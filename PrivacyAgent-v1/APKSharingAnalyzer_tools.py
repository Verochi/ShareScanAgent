import json
import time
from typing import List, Dict, Set
from androguard.core.analysis.analysis import MethodAnalysis
import re
import tiktoken
import transformers

#用于计算token
chat_tokenizer_dir = "deepseek_tokenizer"
tokenizer = transformers.AutoTokenizer.from_pretrained(
        chat_tokenizer_dir, trust_remote_code=True
        )

#计算token用量
def count_tokens(text: str, model: str = "deepseek-chat") -> int:
    return len(tokenizer.encode(text))

# 解析方法描述符
def _manual_parse_descriptor(descriptor: str):
    """手动解析方法描述符（备用方案）"""
    if not descriptor.startswith('(') or ')' not in descriptor:
        return [], descriptor

    params_part = descriptor[1:descriptor.index(')')]
    ret_type = descriptor[descriptor.index(')') + 1:]

    param_types = []
    buffer = ''
    index = 0
    while index < len(params_part):
        c = params_part[index]
        if c == '[':
            buffer = c
            index += 1
            while params_part[index] == '[':
                buffer += c
                index += 1
            c = params_part[index]
        if c == 'L':
            buffer += c
            index += 1
            while params_part[index] != ';':
                buffer += params_part[index]
                index += 1
            buffer += ';'
            param_types.append(buffer)
            buffer = ''
        elif c in ['Z', 'B', 'S', 'C', 'I', 'J', 'F', 'D']:
            if buffer:
                buffer += c
                param_types.append(buffer)
                buffer = ''
            else:
                param_types.append(c)
        index += 1

    return param_types, ret_type

#分割函数的标识符
def _parse_response(response):
    try:
        # 尝试将响应解析为 JSON 格式的 Python 对象
        parsed_data = json.loads(response)

        # 检查解析后的数据是否包含 "functions" 字段
        functions = parsed_data.get("functions", [])
        if not functions:
            return None

        # 检查 "reasons" 字段是否存在且包含所需信息
        reasons = parsed_data.get("reasons", {})
        method_name_reason = reasons.get("method_name", "")
        data_flow_reason = reasons.get("data_flow", "")

        # 检查 "data_flow" 字段
        data_flow = parsed_data.get("data_flow", "")

        # 检查 "info" 字段
        info = parsed_data.get("info", "")

        # 检查 "third_party" 字段
        third_party = parsed_data.get("third_party", "")

        # 如果所有关键信息都存在，则返回处理后的数据
        if all([functions, method_name_reason, data_flow_reason, data_flow, info, third_party]):
            return {
                "functions": functions,
                "reasons": {
                    "method_name": method_name_reason,
                    "data_flow": data_flow_reason
                },
                "data_flow": data_flow,
                "info": info,
                "third_party": third_party
            }
        else:
            return None

    except (json.JSONDecodeError, TypeError):
        # 如果解析 JSON 失败或数据格式不正确，返回 None
        return None

risk_types = ["Intent", "Uri", "ClipData", "ContentResolver", "ShareActionProvider", "SocialMediaAPI",
                          "EmailMessage", "SMSMessage"]
risk_return_types = {
    "Ljava/lang/String;",
    "Lorg/json/JSONObject;",
    "Landroid/content/Intent;",
    "Landroid/net/Uri;",
    "Landroid/content/ClipData;",
    "Ljava/util/List;",
    "Ljava/util/Map;",
    "Lorg/json/JSONArray;",
    "I",
    "F"
}

#跟踪进程
def track_progress(func):
    """分析进度监控装饰器"""

    def wrapper(*args, **kwargs):
        start = time.time()
        result = func(*args, **kwargs)
        print(f"{func.__name__} 耗时: {time.time() - start:.2f}s")
        return result

    return wrapper

#从文件中加载包名
def _load_third_parties_from_file(file_path):
    third_parties = set()
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            for line in file:
                #以#为分隔符分割行内容
                parts = line.split('#', 1)
                #获取分割后的第一部分并去除首尾空白字符
                app_name = parts[0].strip()
                if app_name and not app_name.startswith("#"):
                    third_parties.add(app_name)
    except FileNotFoundError:
        print("第三方包名文件未找到，使用空集合初始化。")
    return list(third_parties)

#手动探知第三方实体
def _detect_third_party(method):
    """解析函数的第三方实体"""
    third_party = None
    pkg =method.class_name.split('/')[:2]
    #检查分割后的包名是否有至少两个元素
    #并且包名的第一部分不在排除列表中（android、java、kotlin）
    if len(pkg) >= 2 and not pkg[0] in {"Landroid", "Ljava", "Lkotlin"}:
        third_party = pkg[1]
    return third_party

#外部加载源和汇规则
def _load_source_sink_rules(file_path):
    """从外部 JSON 文件加载 Source/Sink 规则"""
    sources=[]
    sinks=[]
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            rules = json.load(file)
            sources = set(rules.get('sources', []))
            sinks = set(rules.get('sinks', []))
        return sources,sinks
    except FileNotFoundError:
        print(f"文件 {file_path} 未找到，请检查文件路径。")
    except json.JSONDecodeError:
        print(f"无法解析 {file_path} 中的 JSON 数据，请检查文件格式。")

#读取外部的sink排除文本
def read_exclude_prefixes(file_path):
    try:
        with open(file_path, 'r') as file:
            return [line.strip() for line in file.readlines()]
    except FileNotFoundError:
        print(f"文件 {file_path} 未找到。")
        return []

#分批次处理共享函数
def _find_shared_functions_chunk(dx,chunk: List[MethodAnalysis],sink_nodes):
    """分批次的结合数据流和关键词的共享函数检测"""
    shared_functions_chunk=[]
    _skip_pattern = re.compile(
        r'<init>|<clinit>|/R;|/R\$|Landroid/|Landroidx/|Ljava/|Ljavax/|Lkotlin/|Lkotlinx/'
    )
    for method in chunk:
        if _skip_pattern.search(method.full_name):
            continue
        method_name = method.full_name
        descriptor = method.get_descriptor()

        try:
            param_types, ret_type = _manual_parse_descriptor(descriptor)
        except Exception as e:
            print(f"解析描述符失败: {method_name} -> {descriptor}, 错误: {e}")
            continue

        #判断是否为共享函数
        is_share_keyword = "share" in method_name.lower()
        is_sink = method_name in sink_nodes

        #扩展的风险参数类型
        has_risk_params = any(any(risk_type in p for risk_type in risk_types) for p in param_types)

        #扩展的风险返回类型
        has_risk_return = ret_type in risk_return_types

        if (is_share_keyword or is_sink) and (has_risk_params or has_risk_return):
            shared_functions_chunk.append(method_name)

        shared_functions_chunk= list(set(shared_functions_chunk))
        return shared_functions_chunk

#开始结束时间差
def calculate_time_difference(start_time, end_time):
    elapsed_time = end_time - start_time
    hours, rem = divmod(elapsed_time, 3600)
    minutes, seconds = divmod(rem, 60)
    milliseconds = (elapsed_time - int(elapsed_time)) * 1000

    print(
        f"executed in {int(hours):02}:{int(minutes):02}:{int(seconds):02}.{int(milliseconds):03} (h:m:s.ms)"
    )



