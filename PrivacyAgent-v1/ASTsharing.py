import json
import requests
from typing import List, Optional, Dict, Any
import re
import async_llm_call
from async_llm_call import AsyncDeepSeekAPI, run_api,call_llm,run_with_progress
from tqdm import tqdm
import asyncio
from APKSharingAnalyzer_tools import remove_duplicates

def split_ast_into_parts(lines: List[str], n: int = 2) -> List[str]:
    """
    将AST文本均匀分割成N个部分，返回分片后的字符串列表

    Args:
        lines: AST的原始行列表
        n: 要分割成的份数 (必须≥1)

    Returns:
        包含N个分片的列表，每个分片是字符串

    Raises:
        ValueError: 如果n不是正整数或大于总行数
    """
    if not isinstance(n, int) or n < 1:
        raise ValueError(f"n必须是正整数，输入为{n}")

    if not lines:
        return [""] * n  # 返回N个空字符串

    total_lines = len(lines)
    if n > total_lines:
        raise ValueError(f"n({n})不能大于总行数({total_lines})")

    part_size = total_lines // n
    result = []

    for i in range(n):
        start = i * part_size
        # 最后一部分包含剩余行
        end = (i + 1) * part_size if i != n - 1 else total_lines
        result.append(''.join(lines[start:end]))

    return result

async def analyze_code_data_flows(
        report_json_path: str = 'report_json',
        ast_path: str = "AST_output/after_ast.txt",
        jadx_results_path: str = 'jadx_results',
        output_path: str = "risk_analysis_result.json",
        ast_slice_n: int = 2,
        api_key: str = "your_api_key_here",
        api_url: str = "https://api.deepseek.com/v1/chat/completions",
        temperature: float = 0.2
) -> Optional[List[Dict[str, Any]]]:

    try:
        # 1. 加载数据
        with open(report_json_path, 'r', encoding='utf-8') as f:
            data = json.load(f)

        llm_flows = data.get("LLM_data_flows", [])
        analyze_flows = data.get("analyze_data_flows", [])
        print("LLM_data_flows:", llm_flows)
        print("analyze_data_flows:", analyze_flows)

        # 2. 处理AST结果
        with open(ast_path, "r", encoding="utf-8") as f:
            lines = f.readlines()

        AST_result = split_ast_into_parts(lines, n=ast_slice_n)
        print(f"AST_result共分成{len(AST_result)}块，结果为{AST_result}")
        lenght = len(AST_result)

        # 3. 加载反编译代码
        with open(jadx_results_path, 'r', encoding='utf-8') as f:
            code = json.load(f)
        print("code:", code)

        final_results = []
        prompts = []

        for i in range(lenght):
            # 4. 构建prompt
            prompt = f"""
            ### 输入数据说明：
            1. **LLM 分析的数据流结果**（可能包含误报或不完整）:
            {json.dumps(llm_flows, indent=2, ensure_ascii=False)}
            
            2. **静态分析的数据流结果**（可能包含误报或不完整）:
            {json.dumps(analyze_flows, indent=2, ensure_ascii=False)}
            
            3. **代码的抽象语法树 (AST)**:
            {AST_result[i]}
            
            4. **原始代码中的风险点**:
            {json.dumps(code, indent=2, ensure_ascii=False)}
            """ + """
            ### 分析要求：
            - 结合 AST 和原始代码，优化数据流分析结果，修正误报或漏报。
            - 返回一个字典列表，每个字典包含以下字段：
              - "source_function"（源函数）: 泄露起始点
              - "sink_function"（汇函数）: 数据泄露的终点（如网络请求、日志输出等）
              - "path"（路径）: 数据从源到汇的代码路径（如函数调用链）
              - "leaked_data_type"（泄露类型）: 如 IMEI、MAC地址、地理位置等
              - "third_party"（第三方）: 数据泄露到的第三方服务（如 URL 或 SDK 名称）
            
            ### 输出示例：
            [
                {
                    "source_function": "com.example.app.getDeviceInfo",
                    "sink_function": "com.example.network.sendData",
                    "path": "getDeviceInfo -> processData -> sendData",
                    "leaked_data_type": "IMEI, MAC地址",
                    "third_party": "google"
                },
                {
                    "source_function": "android.content.ClipboardManager.getText",
                    "sink_function": "com.flurry.analytics.logEvent",
                    "path": "ClipboardManager.getText -> UserBehaviorAnalytics.log -> Flurry.logEvent",
                    "leaked_data_type": "剪切板文本（可能含密码、Token）",
                    "third_party": "Flurry"
                }
            ]
            #请不要在前与后生成无关的文字提示信息，也不要有生成说明。
            """
            prompts.append(prompt)

        llms = [AsyncDeepSeekAPI(api_key=api_key, uid=i) for i, api_key in enumerate(async_llm_call.DEFAULT_API_KEYS)]
        results = await run_api(llms=llms, prompts=prompts, system_prompt="你是一个数据泄露的综合分析专家", times=3, temperature=0.2,max_tokens=5000)
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
                        final_results.extend(data)
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

        final_results = remove_duplicates(final_results)
        # 保存结果
        with open(output_path, 'w', encoding='utf-8') as f:
            json.dump(final_results, f, indent=2, ensure_ascii=False)

        print(f"分析完成，结果已保存到 {output_path}")
        print(f"发现的风险数量: {len(final_results)}")
        return final_results

    except json.JSONDecodeError as e:
        print(f"JSON解析失败: {str(e)}")
    except requests.exceptions.RequestException as e:
        print(f"API调用失败: {str(e)}")
    return None




# 使用示例
if __name__ == "__main__":
    result = asyncio.run(analyze_code_data_flows(
        ast_slice_n=10,
        api_key="sk-531ad7cd29714be1a8d0d8d8b4915320"  # 替换为真实API密钥
    ))
