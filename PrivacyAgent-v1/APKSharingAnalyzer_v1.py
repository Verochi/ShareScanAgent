import os
import json
from typing import List, Dict, Set
from openai import OpenAI
from androguard.misc import AnalyzeAPK
from androguard.core.analysis.analysis import MethodAnalysis
import networkx as nx
import re
import datetime
from concurrent.futures import ThreadPoolExecutor, as_completed #并行处理
import time

import async_llm_call
from APKSharingAnalyzer_tools import _manual_parse_descriptor,_parse_response,risk_types,risk_return_types,track_progress,_load_third_parties_from_file,_detect_third_party
from APKSharingAnalyzer_tools import _load_source_sink_rules,read_exclude_prefixes,_find_shared_functions_chunk,count_tokens,calculate_time_difference
import pickle
from typing import Literal
import transformers
import random
import asyncio
from async_llm_call import AsyncDeepSeekAPI, run_api,call_llm,run_with_progress
from tqdm import tqdm

class APKSharingAnalyzer:
    def __init__(self, api_key="sk-4d765424d2a44527a9d7f6193623343a", base_url="https://api.deepseek.com/v1"):
        self.client = OpenAI(api_key=api_key, base_url=base_url)
        self.shared_functions_LLM = []      #共享方法（LLM）
        self.call_graph = None              #调用图
        self.sources = set()                #源方法（集合）
        self.sinks = set()                  #汇方法（集合）
        self.third_parties = _load_third_parties_from_file("third_parties.txt")
        self._skip_pattern = re.compile(
            r'<init>|<clinit>|/R;|/R\$|Landroid/|Landroidx/|Ljava/|Ljavax/|Lkotlin/|Lkotlinx/'
        )                                   #跳过的系统方法
        self.soure_nodes=[]
        self.sink_nodes=[]
        self.shared_functions_mine = []     #手动分析的共享方法
        self.third_party_flows = []         #数据流：源、汇、路径、第三方
        self.sources,self.sinks=_load_source_sink_rules("source_sink_rules.json")
        self.sink_nodes_all=[]
        self.LLM_third_party_flows=[]
        self.LLM_data_flow=[]

    async def analyze_apk(self, apk_path: str, max_dataflow_paths: int = 10) -> Dict:
        """分析APK文件，返回结构化结果"""
        a, d, dx = AnalyzeAPK(apk_path)
        self._build_call_graph(dx)
        self.sink_nodes=await self.sinks_after_LLM( temperature=0.2, max_tokens=6000)
        self._analyze_data_flow(dx, max_paths=max_dataflow_paths)  #限制路径数量
        self._find_shared_functions(dx)
        self.shared_functions_LLM,self.LLM_third_party_flows = self._consult_large_model(apk_path, dx)
        self.analyze_data_flow()
        self.save_results("report_pickle","pickle")
        self.save_results("report_json", "json")

    #构建调用图
    @track_progress
    def _build_call_graph(self, dx):
        """批量处理节点和边，减少网络图操作"""
        print("构建调用图：")
        self.call_graph = nx.DiGraph()  #初始化图

        #批量添加节点
        nodes = [
            (m.full_name, {
                "is_source": any(src in m.full_name for src in self.sources),
                "is_sink": any(sink in m.full_name for sink in self.sinks)
            })
            for m in dx.get_methods()
        ]
        self.call_graph.add_nodes_from(nodes)

        #批量添加边
        edges = []
        for method in dx.get_methods():
            #随代码动态补充第三方（暂不动态补充）
            #result = _detect_third_party(method)
            #if result:
            #    self.third_parties.append(result)
            for _, call, _ in method.get_xref_to():
                edges.append((method.full_name, call.full_name))
        self.call_graph.add_edges_from(edges)

        #去重第三方实体
        self.third_parties = list(set(self.third_parties))
        #查找源节点和汇节点
        self.source_nodes = [n for n, attr in self.call_graph.nodes.items() if attr.get("is_source", False)]
        self.sink_nodes = [n for n, attr in self.call_graph.nodes.items() if attr.get("is_sink", False)and not any(n.startswith(prefix) for prefix in read_exclude_prefixes("sink_exclude.txt"))]
        self.sink_nodes_all = [n for n, attr in self.call_graph.nodes.items() if attr.get("is_sink", False)]
        #去重汇节点与源节点
        self.sink_nodes=list(set(self.sink_nodes))
        self.source_nodes = list(set(self.source_nodes))
        #汇节点排序随机化
        random.shuffle(self.sink_nodes)
        print(f"第三方实体{self.third_parties}")
        print(f"筛选后的汇方法{self.sink_nodes}")

    #通过大模型筛查更有可能的sinks
    async def sinks_after_LLM(
            self,
            chunk_size: int = 600,
            max_chunks: int = 200,
            system_prompt: str = "你是一个识别隐私信息外泄函数的专家。",
            **kwargs
    ):

        llms = [AsyncDeepSeekAPI(api_key=api_key, uid=i) for i, api_key in enumerate(async_llm_call.DEFAULT_API_KEYS)]
        #random.shuffle(llms)

        confirmed_sinks = []
        prompts = []

        for i in range(0, min(len(self.sink_nodes), max_chunks * chunk_size), chunk_size):
            chunk = self.sink_nodes[i:i + chunk_size]
            prompt = f"""
                **请从以下函数列表中筛选出较高概率造成隐私数据泄露的函数名。
                **筛选出来的函数一定要较可能有泄露敏感数据的风险。
                **只需返回确认的函数全名列表，无需解释原因。
                **待筛选列表：
                {chunk}
                **请返回合法的JSON列表,若不存在这样的函数，返回json格式的空列表即可。
                **返回格式示例：'''json
                ["Lcom/facebook/stetho/inspector/network/CountingOutputStream; write (I)V", "Lcom/facebook/share/internal/ShareContentValidation$Validator; validate (Lcom/facebook/share/model/ShareMessengerOpenGraphMusicTemplateContent;)V"]
                '''
                **请保持输出完整，若输出可能超出限制，请删减
            """
            prompts.append(prompt)
        print("分析sinks函数中...")
        results = await run_api(llms=llms, prompts=prompts, system_prompt=system_prompt, **kwargs)
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

                    #解析JSON（使用json.loads而不是eval）
                    data = json.loads(cleaned_response)
                    if isinstance(data, list):
                        confirmed_sinks.extend(data)
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
                f"请严格返回合法的JSON数组格式，不要包含任何额外文本。例如：\n```json\n[\"函数1\", \"函数2\"]\n```\n之前的错误响应：{resp}"
                for resp in retries
            ]
            results = await run_api(llms=llms, prompts=new_prompts, system_prompt=system_prompt, **kwargs)
            retrytimes += 1

        # 去重并返回结果
        confirmed_sinks = list(set(confirmed_sinks))
        print(f"最终确认的Sinks函数（{len(confirmed_sinks)}个）:")
        for sink in confirmed_sinks:
            print(sink)
        return confirmed_sinks

    #多线程进行数据流分析
    @track_progress
    def _analyze_data_flow(self, dx, max_paths=8, max_depth=6, workers=4):
        """多线程分析数据流"""
        sink_methods = [m for m in dx.get_methods() if m.full_name in self.sink_nodes]

        with ThreadPoolExecutor(max_workers=workers) as executor:
            futures = {
                executor.submit(
                    self._analyze_sink,
                    method,
                    max_paths,
                    max_depth
                ): method for method in sink_methods
            }
            for future in as_completed(futures):
                try:
                    future.result()
                except Exception as e:
                    print(f"Sink分析失败: {str(e)[:50]}")

        print(f"数据流：{self.third_party_flows}")

    #单个数据流分析
    def _analyze_sink(self, method, max_paths, max_depth):
        """单个Sink的独立分析方法"""
        method_name = method.full_name
        print(f"Analyzing sink: {method_name}")
        is_third_party = any(pkg in method.class_name for pkg in self.third_parties)
        #查找符合条件的第三方包名
        third_party_pkg = next((pkg for pkg in self.third_parties if pkg in method.class_name), None)

        paths_found = 0
        for source in self.source_nodes:
            for path in nx.all_simple_paths(
                    self.call_graph,
                    source=source,
                    target=method_name,
                    cutoff=max_depth
            ):
                if paths_found >= max_paths:
                    break

                if is_third_party:
                    self.third_party_flows.append({
                        "source": source,
                        "sink": method_name,
                        "path": path,
                        "third_party":third_party_pkg
                    })
                paths_found += 1

    #手动匹配共享函数
    @track_progress
    def _find_shared_functions(self, dx):
        """结合数据流和关键词的共享函数检测"""
        for method in dx.get_methods():
            if self._should_skip_method(method.full_name):
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
            is_sink = method_name in self.sink_nodes

            #扩展的风险参数类型
            has_risk_params = any(any(risk_type in p for risk_type in risk_types) for p in param_types)

            #扩展的风险返回类型
            has_risk_return = ret_type in risk_return_types

            if (is_share_keyword or is_sink) and (has_risk_params or has_risk_return):
                self.shared_functions_mine.append(method_name)

            self.shared_functions_mine=list(set(self.shared_functions_mine))

        print(f"手工寻找的共享函数:{self.shared_functions_mine}")
    def _should_skip_method(self, method_name: str) -> bool:
        return bool(self._skip_pattern.search(method_name))

    #大模型咨询
    def _consult_large_model(self, apk_path: str, dx, chunk_size: int = 7, max_chunks: int = 200):
        """更保守的默认分块参数"""
        all_results = []
        all_functions = []
        methods = [m for m in dx.get_methods() if self._is_high_risk(m)]

        for i in range(0, min(len(methods), max_chunks * chunk_size), chunk_size):
            chunk = methods[i:i + chunk_size]
            prompt = self._build_chunk_prompt(chunk, apk_path, dx)

            try:
                response = self._safe_llm_call(prompt)
                print(
                    f"分析数据共享风险中...处理总量：{len(methods)}个，已处理：{min(i + chunk_size, len(methods))}个，分析进度：{(min(i + chunk_size, len(methods)) / len(methods)) * 100:.2f}%")
                print("大模型返回的结果:", response)

                # 更健壮的结果处理逻辑
                if isinstance(response, list):
                    for item in response:
                        if isinstance(item, dict):
                            all_results.append(item)
                            all_functions.append(item["functions"])
                        else:
                            print(f"警告: 列表中包含非字典项: {type(item)}")
                elif isinstance(response, dict):
                    all_results.append(response)
                    all_functions.append(response["functions"])
                else:
                    print(f"警告: 返回了非预期类型结果: {type(response)}")

            except Exception as e:
                print(f"分块 {i}-{i + chunk_size} 处理失败: {str(e)[:100]}...")

        return all_functions,all_results

    def _is_high_risk(self, method: MethodAnalysis) -> bool:
        """判断方法是否高风险"""
        if self._should_skip_method(method.full_name):
            return False
        name = method.full_name
        return (
                name in self.sink_nodes and any(pkg in method.class_name for pkg in self.third_parties)
                #可以后续补充其他的判断方法
        )

    def _build_chunk_prompt(self, chunk: List[MethodAnalysis], apk_path: str,dx) -> str:
        """使用JSON模板构建结构化提示词"""
        # 准备方法数据
        methods_info = [
            {
                "name": m.full_name,
                "class": m.class_name,
                "is_sink": m in self.sink_nodes,
                "third_party": next(
                    (pkg for pkg in self.third_parties if pkg in m.class_name),
                    None
                ),
                "descriptor": m.get_descriptor(),
                "data_flows":[flow for flow in self.third_party_flows if flow["sink"] == m.full_name]
            }
            for m in chunk
        ]

        shared_fuctions_chunk=_find_shared_functions_chunk(dx,chunk,self.sink_nodes)

        #构建模板
        template = {
            "task": "从以下方法中一个一个识别数据共享风险,并请尤其关注给出的数据流",
            "analysis_rules": [
                "被标记为Sink（数据汇聚点）",
                f"调用第三方SDK（{list(self.third_parties)}）",
                f"在以下共享函数列表之中{','.join(shared_fuctions_chunk)}"
                f"请重点关注优先关注给出的有关该函数的数据流{ json.dumps([flow for method_info in methods_info for flow in method_info['data_flows']])}"
            ],
            "methods": methods_info,
            "response":
                {
                "format": {
                    "functions": ["高风险方法全名列表"],
                    "reasons":  "匹配规则说明",
                    "data_flow":"完整的源函数与汇函数路径（若无输出None,请结合给出的数据流分析）,给出一个即可",
                    "info":"传递的隐私信息类型(请推测传递的隐私数据类型)",
                    "third_party":"传递的第三方(如果是None，请结合函数名推测可能的第三方)"
                },
            }
        }

        prompt_example="""
        "example": 
         '''json
            [{
            "functions": "com.example.ShareUtil.sendData",
            "reasons":  "方法名包含'share'且参数含Intent，在共享函数列表中",
            "data_flow":
                    {
                        "source": "Lcom/mopub/common/LocationService; getLastKnownLocation (Landroid/content/Context; I Lcom/mopub/common/MoPub$LocationAwareness;)Landroid/location/Location;",
                        "sink": "Lcom/mopub/common/privacy/MoPubIdentifier; getAdvertisingInfo ()Lcom/mopub/common/privacy/AdvertisingId;",
                        "path": [
                                "Lcom/mopub/common/LocationService; getLastKnownLocation (Landroid/content/Context; I Lcom/mopub/common/MoPub$LocationAwareness;)Landroid/location/Location;",
                                "Lcom/mopub/common/LocationService; getLocationFromProvider (Landroid/content/Context; Lcom/mopub/common/LocationService$ValidLocationProvider;)Landroid/location/Location;",
                                "Lcom/mopub/common/MoPub; canCollectPersonalInformation ()Z",
                                "Lcom/mopub/common/privacy/PersonalInfoManager; canCollectPersonalInformation ()Z",
                                "Lcom/mopub/common/privacy/MoPubIdentifier; getAdvertisingInfo ()Lcom/mopub/common/privacy/AdvertisingId;"
                        ],
                        "third_party": "mopub"
                    },
            "info": "AndroidID",
            "third_party": "Tencent"
        }]
        '''
        """


        data_flows_str = ""
        for method in methods_info:
            data_flows_str += json.dumps(method["data_flows"]) + "\n"

        prompt = json.dumps(template,
                            ensure_ascii=False) + prompt_example +"\n请务必以 JSON 格式返回结果，一个方法一个方法分析，返回一个字典列表，确保 JSON 格式的正确性和完整性"
        return prompt


    def _safe_llm_call(self, prompt: str):
        """安全的LLM API调用（带重试机制）"""
        max_retries = 3
        #prompt_tokens = count_tokens(prompt)
        #safe_max_tokens = 64000 - prompt_tokens - 100  #预留缓冲
        for attempt in range(max_retries):
            try:
                response = self.client.chat.completions.create(
                    model="deepseek-chat",
                    messages=[{"role": "user", "content": prompt}],
                    temperature=0.2,
                    max_tokens=6000
                )
                content = response.choices[0].message.content

                #去除代码块标记和注释
                content = content.replace("```json", "").replace("```", "").split("#")[0].strip()

                try:
                    #尝试将内容解析为 JSON 格式
                    json_data = json.loads(content)
                    return json_data
                except json.JSONDecodeError:
                    print(f"大模型返回的内容不是有效的 JSON 格式: {content}")
                    #再次提示大模型返回有效的 JSON 格式
                    new_prompt = f"你之前返回的内容不是有效的 JSON 格式，请返回合法的 JSON 格式，并且不要输出任何无关的内容,也不要输出'''josn和''',不要在开头随便增添语句。原内容：{content}"
                    new_response = self.client.chat.completions.create(
                        model="deepseek-chat",
                        messages=[{"role": "user", "content": new_prompt}],
                        temperature=0.2,
                        max_tokens=6000
                    )
                    new_content = new_response.choices[0].message.content
                    try:
                        json_data = json.loads(new_content)
                        return json_data
                    except json.JSONDecodeError:
                        print(f"再次请求后，大模型返回的内容仍不是有效的 JSON 格式:{new_content}")
                        return new_content
            except Exception as e:
                if attempt == max_retries - 1:
                    raise
                print(f"API调用失败，重试 {attempt + 1}/{max_retries}: {e}")

    def plot_risk_flow(self, output_path="flow.png"):
        """绘制源->第三方汇的调用链"""
        import matplotlib.pyplot as plt

        # 高亮风险路径
        edge_colors = []
        for u, v in self.call_graph.edges():
            if any(
                    u in flow["path"] and v in flow["path"]
                    for flow in self.third_party_flows
            ):
                edge_colors.append("red")
            else:
                edge_colors.append("gray")
        print("开始绘画数据流")
        plt.figure(figsize=(12, 8))
        nx.draw(
            self.call_graph,
            with_labels=False,
            edge_color=edge_colors,
            node_size=10,
            alpha=0.6
        )
        plt.savefig(output_path)
        print("数据流绘画完成")

    def save_results(self, file_path="report",mode:Literal["json", "pickle"]="pickle"):
        results = {
            "sources":self.source_nodes,
            "all_sinks":self.sink_nodes_all,
            "sinks":self.sink_nodes,
            "all_third_parties": self.third_parties,
            "my_data_flows":self.third_party_flows,
            "my_shared_functions":self.shared_functions_mine,
            "llm_shared_functions":self.shared_functions_LLM,
            "LLM_data_flows":self.LLM_third_party_flows,
            "analyze_data_flows":self.LLM_data_flow
        }
        if mode == "pickle":
            print("开始保存为pickle文件")
            with open(file_path, 'wb') as f:
                pickle.dump(results, f)
            print("pickle文件保存成功")
        else:
            print("开始保存为json文件")
            with open(file_path, 'w', encoding='utf-8') as f:
                json.dump(results, f, ensure_ascii=False, indent=4)
            print("json文件保存成功")


    def analyze_data_flow(self,chunk_size=7):
        results = []
        #llm_third_party_flows_str = json.dumps(self.LLM_third_party_flows, indent=4, ensure_ascii=False)
        # 分块处理原始数据流
        for i in range(0, len(self.third_party_flows), chunk_size):
            chunk = self.third_party_flows[i:i + chunk_size]
            # 使用 json.dumps 将数据转换为格式化的 JSON 字符串
            third_party_flows_str = json.dumps(chunk, indent=4, ensure_ascii=False)

            # 构建提示信息
            prompt = f"""
               你需要根据以下数据流动信息进行总结，返回一个 JSON 格式的字典列表。每个字典代表一条数据流动记录，并且必须包含以下字段：
    
               - "source_function": 明确数据流动的起始函数，对应原数据中的源函数信息。
               - "path": 数据流动的完整路径，将路径中的各个函数用 " -> " 连接起来，若原数据提供了路径列表，需进行转换。
               - "sink_function": 数据流动的终点函数，对应原数据中的汇函数信息。
               - "privacy_info": 推测出的数据流动中涉及的隐私信息，如果无法从给定数据中推测出来，填写 "None"。
               - "third_party": 推测出的数据共享涉及的第三方实体，如果无法从给定数据中推测出来，填写 "None"。
                数据流动信息：
                {third_party_flows_str}
    
                """
            prompt_ex="""
               请严格按照如下 JSON 格式返回结果：
               ```json
               [
                   {
            "source_function": "源函数全限定名",
                       "path": "源函数 -> 中间函数1 -> 中间函数2 -> ... -> 汇函数",
                       "sink_function": "汇函数全限定名",
                       "privacy_info": "隐私信息描述",
                       "third_party": "第三方实体名称"
                   },
                   {
            "source_function": "另一个源函数全限定名",
                       "path": "另一个源函数 -> 另一个中间函数1 -> ... -> 另一个汇函数",
                       "sink_function": "另一个汇函数全限定名",
                       "privacy_info": "另一个隐私信息描述",
                       "third_party": "另一个第三方实体名称"
                   }
               ]
            """
            prompt=prompt_ex+prompt
            response = self._safe_llm_call(prompt)
            print(
                f"分析数据流中... 处理总量：{len(self.third_party_flows)} 个，已处理：{min(i + chunk_size, len(self.third_party_flows))} 个，分析进度：{(min(i + chunk_size, len(self.third_party_flows)) / len(self.third_party_flows)) * 100:.2f}%")
            print("数据流分析大模型返回的结果:", response)
            if isinstance(response, list):
                for item in response:
                    if isinstance(item, dict):
                        results.append(item)
        '''
        unique_results = []
        seen = set()
        for result in results:
            result_tuple = tuple(sorted(result.items()))
        if result_tuple not in seen:
            seen.add(result_tuple)
        unique_results.append(result)
        '''
        self.LLM_data_flow=results


analyzer = APKSharingAnalyzer()
asyncio.run(analyzer.analyze_apk("moji.apk"))



