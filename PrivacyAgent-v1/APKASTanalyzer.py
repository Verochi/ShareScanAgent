from anytree import Node, RenderTree, PreOrderIter,PostOrderIter,Node
from anytree.search import findall
import os
from typing import Set,Union
import time
import json
import shutil
import openai
import asyncio
from tqdm import tqdm

from async_llm_call import AsyncDeepSeekAPI, run_api,call_llm,run_with_progress
import async_llm_call

from APKSharingAnalyzer_tools import _load_source_sink_rules
from APKASTanalyzer_tools import get_root_node ,visualize_ast
sources,sinks=_load_source_sink_rules("source_sink_rules.json")

def is_source_or_sink(node, source_set, sink_set):
    name = node.name.split(':')[-1].strip()  # 取最后一部分
    return name in source_set or name in sink_set

def has_key(node):
    """递归检查子树并标记关键路径"""
    if hasattr(node, 'is_key') and node.is_key:
        return True

    # 检查子节点并保存状态
    has_key_child = False
    for child in node.children:
        if has_key(child):  # 递归检查
            has_key_child = True
            break

    return has_key_child  # 返回当前子树是否存在关键节点

def prune_tree(root, sources, sinks):
    """优化后的剪枝函数（减少遍历次数，使用缓存）"""
    is_key_nodes = set()
    is_key_count = 0
    child_key_count = 0

    # 1. 单次后序遍历完成所有标记
    print("开始标记关键节点和路径...")
    for node in PostOrderIter(root):
        # 标记当前节点是否是源/汇
        is_key = is_source_or_sink(node, sources, sinks)
        setattr(node, 'is_key', is_key)
        if is_key:
            is_key_count+=1
            is_key_nodes.add(id(node))
            print(f"已找到{is_key_count}个关键节点")

        '''
        child_key=has_key(node)
        if child_key:
            child_key_count+=1
            has_child_nodes.add(id(node))
            print(f"已找到{child_key_count}个子树含有关键节点的节点")
        setattr(node, 'has_key_child', child_key)
        '''

    # 2. 标记保留节点
    print("标记保留节点...")
    nodes_to_keep = set()
    # 先处理关键节点及其路径
    for node in PostOrderIter(root):
        if node.is_key:
            nodes_to_keep.add(id(node))
            # 保留所有祖先节点（确保路径连通）
            for ancestor in node.path[:-1]:
                nodes_to_keep.add(id(ancestor))
    # 再处理关键节点的子树
    for node in PreOrderIter(root):
        if id(node) in is_key_nodes:  # 如果是关键节点
            for descendant in node.descendants:  # 保留所有后代
                nodes_to_keep.add(id(descendant))

    print(f"保留{len(nodes_to_keep)}个节点")

    # 3. 收集待删除节点（避免在遍历过程中修改树结构）
    print("收集待删除节点...")
    nodes_to_remove = []
    for node in PostOrderIter(root):
        if node.parent:
            if id(node) not in nodes_to_keep:
                nodes_to_remove.append(node)


    # 4. 批量删除节点（使用集合加速查找）
    print(f"共找到 {len(nodes_to_remove)} 个节点需要删除")
    for node in nodes_to_remove:
        parent = getattr(node, 'parent', None)
        if parent and hasattr(parent, 'children'):
            parent.children = [c for c in parent.children
                               if hasattr(c, '__class__') and id(c) in nodes_to_keep]

    return root

def chunk_by_structure(root):
    """按语法结构（方法/循环/条件块）分块"""
    SENSITIVE_NODES = ("MethodInvocation:", "WhileStatement:", "IfStatement:", "FieldAccess:")
    for node in PreOrderIter(root):
        if node.name.startswith(SENSITIVE_NODES):
            yield {
                "node": node.name,
                "path": " → ".join(n.name for n in node.path),
                "code_snippet": "\n".join(f"{'  ' * len(n.path)}{n.name}"
                                          for n in PreOrderIter(node))
            }
def chunk_by_size(root, chunk_size=500):
    """将树按节点数均等分块"""
    nodes = list(PreOrderIter(root))  #将树展平为节点列表
    for i in range(0, len(nodes), chunk_size):  #按指定步长切割
        yield nodes[i:i + chunk_size]  #返回当前分块

def prepare_for_llm_call(root, target_chunk=700, max_variance=0.3):
    """
    生成适合大模型分析的结构化数据块
    返回：包含树结构和元数据的列表
    """

    def get_size(node):
        return len(list(PreOrderIter(node)))

    def process_node(node, final_chunk, processed, target_chunk=1000, max_variance=0.3):
        # 跳过已处理的节点
        if id(node) in processed:
            return

        # 计算子树大小
        subtree_size = get_size(node)
        # 如果子树过大，递归处理子节点
        if subtree_size > target_chunk * (1 + max_variance):
            if hasattr(node, 'children'):  # 确保节点有 children 属性
                for child in node.children:
                    process_node(child, final_chunk, processed, target_chunk, max_variance)
            return
        # 尝试加入最后一个分块
        if final_chunk and sum(get_size(n) for n in final_chunk[-1]) + subtree_size <= target_chunk * (
                1 + max_variance):
            final_chunk[-1].append(node)
        else:
            final_chunk.append([node])  # 创建新分块

        # 标记该节点及其子节点为已处理
        processed.update(id(n) for n in PreOrderIter(node))

    def balanced_chunk(root, target_chunk=500, max_variance=0.3):
        processed = set()
        final_chunk = []
        process_node(root, final_chunk, processed, target_chunk, max_variance)
        print(final_chunk)
        return final_chunk

    result = []
    for chunk in balanced_chunk(root, target_chunk, max_variance):
        result.append({
            "metadata": {
                "chunk_id": id(chunk),
                "subtree_count": len(chunk),
                "total_nodes": sum(len(list(PreOrderIter(n))) for n in chunk)
            },
            "trees": [
                {
                    "root": subtree_root.name,
                    "structure": tree_to_dict(subtree_root),
                    "flat_code": "\n".join(
                        f"{'  '*len(n.path)}{n.name}"
                        for n in PreOrderIter(subtree_root)
                    )
                }
                for subtree_root in chunk
            ]
        })
    return result

def tree_to_dict(node):
    """将子树转换为嵌套字典结构"""
    return {
        "name": node.name,
        "children": [tree_to_dict(c) for c in node.children]
    }

def build_analysis_prompt(batch):
    """构造分析提示词"""
    return """
    给出一个代码块的树结构，需检查：
    1. 敏感数据流动（如put/get/save操作）
    2. 推断泄露隐私信息的类型
    2. 第三方SDK调用（如google.、facebook.）
    3. 加密/授权缺失节点

    返回JSON的字典列表格式，例如：
    '''json
    [
        {
            "data_leak": "[敏感数据流动情况]",
            "privacy_info":"[隐私数据类型]",
            "third_party": "[第三方]",
            "security_issue": "[安全问题]",
            "detail": "[节点信息、风险细节、建议等]"
         },
         {
            "data_leak": "[敏感数据流动情况]",
            "privacy_info":"[隐私数据类型]",
            "third_party": "[第三方]",
            "security_issue": "[安全问题]",
            "detail": "[节点信息、风险细节、建议等]"
         }
    ]
    """+f"""以下为代码结构块{batch}，请返回JSON的字典列表格式， 请不要在列表前后返回无关内容，无风险返回空列表即可"""

async def AST_analyze(
        root,
        batch_size=20,
        system_prompt: str = "你是一个分析具备泄露隐私信息风险代码结构的专家。",
        model_name="deepseek-coder-6.7b-instruct",
        max_block_length=28000,  # 每个代码块的最大长度（字符数）
        **kwargs
):
    llms = [AsyncDeepSeekAPI(api_key=api_key, uid=i) for i, api_key in enumerate(async_llm_call.DEFAULT_API_KEYS)]

    prompts = []
    all_chunks = prepare_for_llm_call(root)
    privacy_issues=[]
    for c in all_chunks:
        prompts.append(build_analysis_prompt(c))

    print("分析代码树中...")
    results = await run_api(llms=llms, prompts=prompts, system_prompt=system_prompt, times=3, **kwargs)
    retrytimes = 0
    Maxretries = 2

    while retrytimes < Maxretries:
        retries = []
        for response in results:
            try:
                #  清理响应文本（去除Markdown标记、无关字符）
                cleaned_response = response.strip()
                if cleaned_response.startswith("```json"):
                    cleaned_response = cleaned_response[7:].strip()
                if cleaned_response.endswith("```"):
                    cleaned_response = cleaned_response[:-3].strip()

                # 解析JSON（使用json.loads而不是eval）
                data = json.loads(cleaned_response)
                if isinstance(data, list):
                    print(f"大模型返回结果：{data}")
                    privacy_issues.extend(data)
            except json.JSONDecodeError as e:  # 明确捕获JSON解析错误
                print(f"[错误] JSON解析失败: {e}")
                print(f"[原始响应]: {response}")
                retries.append(response)
            except Exception as e:  # 捕获其他意外错误
                print(f"[意外错误] {e}")
                retries.append(response)

        # 如果没有需要重试的，提前退出
        if not retries:
            break

        print(f"第 {retrytimes + 1} 次重试...")
        new_prompts = [
            f"请严格返回合法的JSON字典列表格式，不要包含任何额外文本。请不要在列表前后返回无关内容，无风险返回空列表即可，之前的错误响应：{resp}"
            for resp in retries
        ]
        results = await run_api(llms=llms, prompts=new_prompts, system_prompt=system_prompt, times=3, **kwargs)
        retrytimes += 1

    # 在去重前，将字典转换为元组（基于字典的 items()）
    unique_issues = []
    seen = set()  # 用于记录已出现的元组
    for issue in privacy_issues:
        issue_tuple = tuple(issue.items())  # 将字典转换为键值对元组
        if issue_tuple not in seen:
            seen.add(issue_tuple)
            unique_issues.append(issue)  # 保留原始字典
    privacy_issues = unique_issues

    print(f"最终确认风险代码块（{len(privacy_issues)}个）:")
    for issue in privacy_issues:
        print(issue)
    return privacy_issues
if __name__ == '__main__':
    root_node=get_root_node("java_output","high_risked_classes.txt")
    root_node=prune_tree(root_node,sources,sinks)
    print("成功剪枝")
    #output_path = os.path.join("AST_output", "after_ast.png")
    #visualize_ast(root_node, output_path)
    after = len(list(PreOrderIter(root_node)))
    print(f"剪枝后: {after} 节点")

    results=asyncio.run(AST_analyze(root_node,temperature=0.2, max_tokens=6000))
    with open("ASTanalyzer_results", 'w', encoding='utf-8') as f:
        json.dump(results, f, ensure_ascii=False, indent=4)
    print("json文件保存成功")