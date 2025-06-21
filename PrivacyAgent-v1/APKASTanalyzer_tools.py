import os
import sys

import javalang
from anytree import Node, RenderTree
from anytree.exporter import DotExporter
from anytree.render import AsciiStyle, ContStyle, ContRoundStyle
from graphviz import Source
import matplotlib.pyplot as plt
from PIL import Image

from APKSharingAnalyzer_tools import read_exclude_prefixes

def prefilter_files(directory_path,key_files):
    potential_files = []
    keywords = read_exclude_prefixes(key_files)  # 外部添加更多关键词
    for root, dirs, files in os.walk(directory_path):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                try:
                    with open(file_path, 'r', encoding='utf-8') as f:
                        code_content = f.read()
                        for keyword in keywords:
                            if keyword in code_content:
                                potential_files.append(file_path)
                                break
                except Exception as e:
                    print(f"处理文件 {file_path} 时出错: {e}")
    return potential_files


def java_to_ast(java_code):
    """
    将Java代码转换为抽象语法树
    :param java_code: Java源代码
    :return: AST根节点
    """
    try:
        tree = javalang.parse.parse(java_code)
        print("AST构建成功")
        return tree
    except javalang.parser.JavaSyntaxError as e:
        print(f"Syntax error in Java code: {e}")
        return None


def create_ast_tree(node, parent=None):
    """递归创建可可视化的AST树，优化节点类型处理"""
    if node is None:
        return None

    # 根据节点类型提取有意义的文本表示
    node_type = type(node).__name__

    # 处理基本类型
    if isinstance(node, (str, int, float, bool)):
        node_text = str(node)
        current_node = Node(f"Literal: {node_text[:50]}", parent=parent)
        return current_node

    # 处理不同类型的AST节点
    node_text = node_type
    if hasattr(node, 'name'):
        node_text = f"{node_type}: {getattr(node, 'name', '')}"
    elif hasattr(node, 'member'):
        node_text = f"{node_type}: {getattr(node, 'member', '')}"
    elif hasattr(node, 'operator'):
        node_text = f"{node_type}: {getattr(node, 'operator', '')}"

    current_node = Node(node_text, parent=parent)

    # 递归处理所有属性和子节点（改用 node.children 或手动遍历）
    if hasattr(node, 'children'):
        for child in node.children:
            if isinstance(child, (list, tuple)):
                for item in child:
                    create_ast_tree(item, current_node)
            else:
                create_ast_tree(child, current_node)
    else:
        # 手动遍历所有可能的属性
        for attr in dir(node):
            if attr.startswith('_'):
                continue
            attr_value = getattr(node, attr)
            if isinstance(attr_value, javalang.ast.Node):
                create_ast_tree(attr_value, current_node)
            elif isinstance(attr_value, (list, tuple)):
                for item in attr_value:
                    if isinstance(item, javalang.ast.Node):
                        create_ast_tree(item, current_node)

    return current_node


def save_ast_as_text(root_node, output_path):
    """将AST树结构保存为文本文件，保留树形连接符号并标准化节点类型"""
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write("Standard Java AST (Abstract Syntax Tree)\n")
        f.write("=" * 80 + "\n\n")

        # 标准AST节点类型映射（将javalang内部类型映射为更易读的名称）
        NODE_TYPE_MAPPING = {
            "CompilationUnit": "CompilationUnit",
            "PackageDeclaration": "PackageDeclaration",
            "Import": "ImportDeclaration",
            "ClassDeclaration": "ClassDeclaration",
            "MethodDeclaration": "MethodDeclaration",
            "ConstructorDeclaration": "ConstructorDeclaration",
            "FieldDeclaration": "FieldDeclaration",
            "VariableDeclarator": "VariableDeclarator",
            "ReferenceType": "TypeReference",
            "PrimitiveType": "PrimitiveType",
            "Literal": "Literal",
            "MethodInvocation": "MethodCall",
            "BinaryOperation": "BinaryExpression",
            "IfStatement": "IfCondition",
            "ForStatement": "ForLoop",
            "WhileStatement": "WhileLoop",
            "ReturnStatement": "Return",
            "BlockStatement": "CodeBlock",
            "TryStatement": "TryCatch"
        }

        # 使用ContRoundStyle保持完整的树形连接符
        style = ContRoundStyle()

        # 写入树形结构
        for pre, _, node in RenderTree(root_node, style=style):
            # 解析节点原始名称
            original_name = node.name
            node_type = original_name.split(':', 1)[0].strip() if ':' in original_name else original_name.strip()
            node_value = original_name.split(':', 1)[1].strip() if ':' in original_name else ""

            # 映射为标准节点类型
            standard_type = NODE_TYPE_MAPPING.get(node_type, node_type)

            # 构建节点显示文本（包含标准类型和值）
            node_text = standard_type
            if node_value:
                node_text += f": {node_value}"

            # 提取并添加修饰符（从节点元数据中获取，假设metadata包含attributes）
            modifiers = []
            if hasattr(node, 'metadata') and isinstance(node.metadata, dict) and 'attributes' in node.metadata:
                attrs = node.metadata['attributes']
                # 提取常见修饰符
                for mod in ['public', 'private', 'protected', 'static', 'final', 'abstract', 'synchronized']:
                    if mod in attrs:
                        modifiers.append(mod)
            elif hasattr(node, 'ast_info') and 'modifiers' in node.ast_info:
                # 从ast_info中获取修饰符（适用于create_ast_tree生成的节点）
                modifiers = node.ast_info['modifiers']

            if modifiers:
                node_text += f" [{', '.join(modifiers)}]"

            # 写入节点信息
            f.write(f"{pre}{node_text}\n")

        # 写入统计信息
        f.write("\n" + "=" * 80 + "\n")
        f.write(f"Total Nodes: {len(root_node.descendants) + 1}\n")

        # 计算节点类型分布
        type_counter = {}
        for n in root_node.descendants:
            node_type = n.name.split(':', 1)[0].strip()
            standard_type = NODE_TYPE_MAPPING.get(node_type, node_type)
            type_counter[standard_type] = type_counter.get(standard_type, 0) + 1

        f.write("Node Type Statistics:\n")
        for typ, count in sorted(type_counter.items(), key=lambda x: -x[1]):
            f.write(f"  - {typ}: {count} nodes\n")

def visualize_ast(ast, output_path):
    """增强版可视化函数，利用节点元数据提供更详细的展示"""
    if not ast:
        print("No AST to visualize")
        return

    # 创建可视化树
    root_node = create_ast_tree(ast)

    # 导出为DOT文件，自定义节点样式
    dot_file = output_path.replace('.png', '.dot')

    text_output_path = output_path.replace('.png', '.txt')
    save_ast_as_text(root_node, text_output_path)
    print(f"AST文本表示已保存到: {text_output_path}")

    def get_node_style(node):
        """根据节点类型和元数据设置样式"""
        style = 'shape=box'

        if hasattr(node, 'metadata'):
            node_type = node.metadata.get('type', '')

            # 为不同类型的节点设置不同颜色
            if 'ClassDeclaration' in node_type:
                style += ', style="filled", fillcolor="lightblue"'
            elif 'MethodDeclaration' in node_type:
                style += ', style="filled", fillcolor="lightgreen"'
            elif 'FieldDeclaration' in node_type:
                style += ', style="filled", fillcolor="lightyellow"'

            # 添加工具提示显示更多属性
            if node.metadata.get('attributes'):
                tooltip = ", ".join([
                    f"{k}={v}" for k, v in node.metadata['attributes'].items()
                    if len(str(v)) < 50  # 避免过长的工具提示
                ])
                style += f', tooltip="{tooltip}"'

        return style

    with open(dot_file, 'w') as f:
        f.write('digraph AST {\n')
        f.write('    node [fontname="SimHei"];\n')  # 支持中文显示

        # 遍历所有节点，应用自定义样式
        for pre, fill, node in RenderTree(root_node):
            node_id = id(node)
            node_label = node.name.replace('"', '\\"')  # 转义双引号
            f.write(f'    "{node_id}" [label="{node_label}", {get_node_style(node)}];\n')

            # 添加边
            if node.parent:
                f.write(f'    "{id(node.parent)}" -> "{node_id}";\n')

        f.write('}\n')

    # 使用graphviz渲染
    try:
        s = Source.from_file(dot_file)
        s.render(output_path, format='png', cleanup=True, view=False)
        print(f"AST visualization saved to {output_path}")
    except Exception as e:
        print(f"Error generating visualization: {e}")
        # 作为备选，打印树结构
        for pre, fill, node in RenderTree(root_node):
            print(f"{pre}{node.name}")


def APKASTanalyze(input_dir, output_dir="AST_output", keyword_file="high_risked_classes.txt"):
    """
    为Java目录中的所有文件创建统一AST
    :param input_dir: 包含Java文件的目录
    :param output_dir: 输出目录
    :param keyword_file: 关键词文件（可选）
    """
    if not os.path.exists(input_dir):
        print(f"错误: 目录不存在 - {input_dir}")
        return

    # 创建输出目录
    os.makedirs(output_dir, exist_ok=True)
    print(f"输出目录: {output_dir}")

    # 获取Java文件列表
    java_files = prefilter_files(input_dir, keyword_file) if keyword_file else []
    if not java_files:
        java_files = [os.path.join(root, f) for root, _, files in os.walk(input_dir)
                     for f in files if f.endswith(".java")]
    print(f"实际处理 {len(java_files)} 个Java文件")


    # 创建统一AST根节点
    root_node = Node("Java_Directory_AST")

    # 处理每个Java文件

    success_count = 0
    failed_files = []

    for i, java_file in enumerate(java_files, 1):
        relative_path = os.path.relpath(java_file, input_dir)
        print(f"\n文件 {i}/{len(java_files)}: {relative_path}")

        try:
            with open(java_file, 'r', encoding='utf-8') as f:
                java_code = f.read()

            ast = java_to_ast(java_code)
            if ast:
                # 从文件路径获取类名（原逻辑）
                class_name = os.path.splitext(relative_path)[0].replace(os.sep, '.')

                # 新增：提取目录层级并转换为包结构
                dir_parts = os.path.dirname(relative_path).split(os.sep)
                # 过滤空字符串（处理根目录情况）
                dir_parts = [part for part in dir_parts if part]
                package_parts = dir_parts  # 目录结构即包结构

                # 新增：递归创建目录层级节点
                current_parent = root_node
                for part in package_parts:
                    # 查找是否已存在该节点
                    existing_node = next((child for child in current_parent.children
                                          if child.name == part), None)
                    if existing_node:
                        current_parent = existing_node
                    else:
                        # 创建新的目录节点
                        new_node = Node(part, parent=current_parent)
                        current_parent = new_node

                # 创建文件节点并挂载到最后一级目录节点下
                file_node = Node(f"File: {class_name}", parent=current_parent)  # 移除前导空格
                ast_root_node = create_ast_tree(ast, parent=file_node)  # 显式接收返回值
                print(f"  AST根节点类型: {type(ast_root_node).__name__}")
                print(f"  文件节点子节点数量: {len(file_node.children)}")
                if ast_root_node is None:
                    print(f"警告: 文件 {relative_path} 的AST为空")
                    failed_files.append(java_file)
                else:
                    success_count += 1
            else:
                failed_files.append(java_file)

        except Exception as e:
            print(f"✗ 处理失败: {e}")
            failed_files.append(java_file)

    # 输出处理结果
    print(f"\n处理完成:")
    print(f"  ✓ 成功: {success_count} 个文件")
    print(f"  ✗ 失败: {len(failed_files)} 个文件")

    if failed_files:
        print(f"  失败文件列表:")
        for file in failed_files:
            print(f"    - {os.path.relpath(file, input_dir)}")

    if not root_node.children:
        print("警告: AST根节点没有子节点，可能所有文件处理失败")
        return

    # 可视化统一AST
    if success_count > 0:
        output_path = os.path.join(output_dir, "unified_ast.png")
        visualize_ast(root_node, output_path)
    else:
        print("无法生成AST: 没有成功处理任何文件")

def get_root_node(input_dir, keyword_file="high_risked_classes.txt"):

    if not os.path.exists(input_dir):
        print(f"错误: 目录不存在 - {input_dir}")
        return

    # 获取Java文件列表
    java_files = prefilter_files(input_dir, keyword_file) if keyword_file else []
    if not java_files:
        java_files = [os.path.join(root, f) for root, _, files in os.walk(input_dir)
                     for f in files if f.endswith(".java")]
    print(f"实际处理 {len(java_files)} 个Java文件")
    # 创建统一AST根节点
    root_node = Node("Java_Directory_AST")

    # 处理每个Java文件
    success_count = 0
    failed_files = []

    for i, java_file in enumerate(java_files, 1):
        relative_path = os.path.relpath(java_file, input_dir)
        print(f"\n文件 {i}/{len(java_files)}: {relative_path}")

        try:
            with open(java_file, 'r', encoding='utf-8') as f:
                java_code = f.read()

            ast = java_to_ast(java_code)
            if ast:
                # 从文件路径获取类名（原逻辑）
                class_name = os.path.splitext(relative_path)[0].replace(os.sep, '.')

                # 新增：提取目录层级并转换为包结构
                dir_parts = os.path.dirname(relative_path).split(os.sep)
                # 过滤空字符串（处理根目录情况）
                dir_parts = [part for part in dir_parts if part]
                package_parts = dir_parts  # 目录结构即包结构

                # 新增：递归创建目录层级节点
                current_parent = root_node
                for part in package_parts:
                    # 查找是否已存在该节点
                    existing_node = next((child for child in current_parent.children
                                          if child.name == part), None)
                    if existing_node:
                        current_parent = existing_node
                    else:
                        # 创建新的目录节点
                        new_node = Node(part, parent=current_parent)
                        current_parent = new_node

                # 创建文件节点并挂载到最后一级目录节点下
                file_node = Node(f"File: {class_name}", parent=current_parent)  # 移除前导空格
                ast_root_node = create_ast_tree(ast, parent=file_node)  # 显式接收返回值
                print(f"  AST根节点类型: {type(ast_root_node).__name__}")
                if ast_root_node is None:
                    print(f"警告: 文件 {relative_path} 的AST为空")
                    failed_files.append(java_file)
                else:
                    success_count += 1
            else:
                failed_files.append(java_file)

        except Exception as e:
            print(f"✗ 处理失败: {e}")
            failed_files.append(java_file)

    return root_node


if __name__ == '__main__':
    results = APKASTanalyze("java_output",keyword_file="high_risked_classes.txt")