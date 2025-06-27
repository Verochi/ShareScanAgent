import json
from typing import List, Dict, Tuple
from openai import OpenAI

client = OpenAI(api_key="sk-9d5d5e1547cf40ada7debd3d531f77ba", base_url="https://api.deepseek.com")

def load_static_analysis(file_path: str) -> List[Dict]:
    """加载静态分析JSON文件"""
    with open(file_path, 'r', encoding='utf-8') as f:
        return json.load(f)

def load_privacy_policy(file_path: str) -> List[Tuple]:
    """加载隐私政策TXT文件"""
    with open(file_path, 'r', encoding='utf-8') as f:
        return [tuple(line.strip().strip('()').split(',')) for line in f if line.strip()]

def generate_prompt(static_data: List[Dict], policy_data: List[Tuple]) -> str:
    """生成发送给大模型的提示词"""
    static_str = "\n".join([f"{item['leaked_data_type']} (第三方: {item['third_party']})"
                            for item in static_data])

    policy_str = "\n".join([f"{action} {data_type} (第三方: {third_party})"
                            for _, action, data_type, third_party in policy_data])

    return f"""
请分析以下应用的实际代码行为与隐私政策声明之间是否存在不一致：

=== 静态分析结果（实际代码行为） ===
{static_str}

=== 隐私政策声明 ===
{policy_str}

请按以下规则匹配并分类不一致情况：
1. 相反披露：政策声明不收集但代码实际收集，或声明收集但代码未发现相关收集行为
2. 省略披露：代码实际收集但政策中完全未提及
3. 模糊披露：政策声明模糊(如"可能收集")而代码明确收集
4. 若无不一致的隐私政策条款或代码分析无需输出

输出格式要求：
- 对于每个不一致项，按以下格式输出：
  [不一致类型] 
  静态分析: [静态分析的隐私信息]传递给[第三方]
  隐私政策: [声明内容的元组]
  证据路径：[源函数][汇函数][路径]
  
示例输出
  [模糊披露]
  静态分析： Device MAC address 传递给 umeng  
  隐私政策： (We,share,Android description,umeng)
  证据路径：
    "source_function": "Lcom/umeng/commonsdk/statistics/common/DeviceConfig; getDeviceIdUmengMD5 (Landroid/content/Context;)Ljava/lang/String;",
    "sink_function": "Lcom/umeng/commonsdk/statistics/common/DeviceConfig; getMacByJavaAPI ()Ljava/lang/String;",
    "path": "Lcom/umeng/commonsdk/statistics/common/DeviceConfig; getDeviceIdUmengMD5 (Landroid/content/Context;)Ljava/lang/String; -> Lcom/umeng/commonsdk/statistics/common/DeviceConfig; getDeviceId (Landroid/content/Context;)Ljava/lang/String; -> Lcom/umeng/commonsdk/statistics/common/DeviceConfig; getDeviceIdForBox (Landroid/content/Context;)Ljava/lang/String; -> Lcom/umeng/commonsdk/statistics/common/DeviceConfig; getMacByJavaAPI ()Ljava/lang/String;",
"""

def consistence_analyze(static_data: List[Dict], policy_data: List[Tuple]) -> str:
    """调用大模型API分析差异"""
    prompt = generate_prompt(static_data, policy_data)
    response = client.chat.completions.create(
        model="deepseek-chat",
        messages=[
            {"role": "system", "content": "你是一个静态代码分析和隐私政策分析的专家"},
            {"role": "user", "content": prompt},
        ],
        stream=False,
        temperature = 0.2
    )
    return response.choices[0].message.content



if __name__ == "__main__":

    # 加载数据
    static_data = load_static_analysis("risk_analysis_result.json")
    policy_data = load_privacy_policy(r"LLM_results/output_results_with_privacylint/baidu_with_pravacylint.txt")

    # 分析差异
    results = consistence_analyze(static_data, policy_data)

    # 输出结果
    print("=== 不一致分析结果 ===")
    print(results)