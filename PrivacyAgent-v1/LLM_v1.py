#导入所有的库和包
from typing import Optional,Union,List,Literal
from pydantic import BaseModel, Field
import json
from openai import OpenAI
import os
import re
from pathlib import Path
import glob

input_folder = "plaintext_policies"
output_folder_raw = "LLM_results/output_results_raw"
output_folder_with_privacylint = "LLM_results/output_results_with_privacylint"
PrivacyLint_result_folder_path = "PrivacyLint/ext/output_text_form/policy_text_all_form"
#output_folder_nlp = "LLM_results/output_results_nlp"

os.makedirs(output_folder_raw, exist_ok=True)
os.makedirs(output_folder_with_privacylint, exist_ok=True)
#os.makedirs(output_folder_nlp, exist_ok=True)

#PrivacyLint结果的文本
PrivacyLint_files = glob.glob(os.path.join(PrivacyLint_result_folder_path, "*.txt"))
# 判断是否有.txt文件
if PrivacyLint_files:
    first_PrivacyLint_file = PrivacyLint_files[0]
    try:
        with open(first_PrivacyLint_file, 'r', encoding='utf-8') as file:
            PrivacyLint_text = file.read()
    except Exception as e:
        print(f"读取文件 {first_PrivacyLint_file} 时出错: {e}")
else:
    print("该文件夹中没有.txt文件。")

#若分块处理，设置分块的大小
MAX_CHUNK_LENGTH=5000
#调用API
client = OpenAI(api_key="sk-4d765424d2a44527a9d7f6193623343a", base_url="https://api.deepseek.com/v1")

#global_subject = "Inkblot Weather"
'''
# 按段落分块，并且保留前后段落的部分信息作为上下文
chunks = []
paragraphs = privacy_policy_text.split('\n\n')
for i in range(len(paragraphs)):
    if i == 0:
        chunk = paragraphs[i] + ' ' + paragraphs[i + 1][:100]
    elif i == len(paragraphs) - 1:
        chunk = paragraphs[i - 1][-100:] + ' ' + paragraphs[i]
    else:
        chunk = paragraphs[i - 1][-100:] + ' ' + paragraphs[i] + ' ' + paragraphs[i + 1][:100]
    chunks.append(chunk)
'''

#不采用PrivacyLint提示的纯LLM做法
system_prompt_raw = """"You are a professional privacy policy information extraction assistant. Please extract all structured information from the text following these rules:

**Output Requirements**:
1. Must return a JSON array where each element contains:
   - subject: Always use "We".
   - action: Data operation verb (must use English like "collect", "share", "analyze", "use").If the action is not clear, try to summarize the data - related operation.
   - privacy_information: Data type (English, e.g., "name", "email", "location", "Android ID").If not specified, try to infer based on the context.
   - third_party: Third-party name (English, e.g., "Google") or null
2. All fields must use exact these names: subject, action, privacy_information, third_party
3. Missing fields should be null
4. All output must be in English
5. Automatically delete duplicate fields


**Example**:
input：“Wechat collect and use your advertising ID and share it with JingDong.Bur it dose not collect your phone number and system time. ”
output：
```json
[
    {"subject": "We", "action": "collect","privacy_information"："advertising ID","third_party":null},
    {"subject": "We", "action": "use","privacy_information"："advertising ID","third_party":null},
    {"subject": "We", "action": "share","privacy_information"："advertising ID","third_party":"JingDong"},
    {"subject": "We", "action": "not collect","privacy_information"："phone number","third_party":null},
    {"subject": "We", "action": "collect","privacy_information"："system time","third_party":"JingDong"}
]
```"""

system_prompt_with_privacylint = """
You are a professional privacy policy information optimization assistant. You will receive a structured text extracted by other methods. Your task is to optimize this structured text according to the semantic content of the privacy policy. Please note that all subjects in the output should be "We".
The structured text will be in the system prompt. And semantic content of the privacy policy will be in the user context.

**Output Requirements**:
1. Must return a JSON array where each element contains:
   - subject: Always use "We".
   - action: Data operation verb (must use English like "collect", "share", "analyze", "use"). If the action is not clear, try to summarize the data - related operation.
   - privacy_information: Data type (English, e.g., "name", "email", "location", "Android ID"). If not specified, try to infer based on the context.
   - third_party: Third - party name (English, e.g., "Google") or null
2. All fields must use exact these names: subject, action, privacy_information, third_party
3. Missing fields should be null
4. All output must be in English
5. Automatically delete duplicate fields

**Example**:
Privacy Policy Input:(provided in user context)
Our service is dedicated to ensuring secure transactions. We handle and process the bank card information you provide to complete payment operations. Also, we verify and record your real identity information and facial information for identity authentication purposes. We check the authenticity of user identity to prevent fraud. We do not share any of this information with third parties without your consent.

Original Structured Text Input(provided in system prompt):
(we,provide,bank card information,we_implicit)
(we,provide,your real identity information,we_implicit)
(we,provide,facial information,we_implicit)
(we,provide,authenticity of user identity,we_implicit)

Optimized Output:
```json
[
    {"subject": "We","action": "handle","privacy_information": "bank card information","third_party": null},
    {"subject": "We","action": "process","privacy_information": "bank card information","third_party": null},
    {"subject": "We","action": "verify","privacy_information": "real identity information","third_party": null},
    {"subject": "We","action": "record","privacy_information": "real identity information","third_party": null},
    {"subject": "We","action": "verify","privacy_information": "facial information","third_party": null},
    {"subject": "We","action": "record","privacy_information": "facial information","third_party": null},
    {"subject": "We","action": "check","privacy_information": "authenticity of user identity","third_party": null}
]```
"""+f"""
**Original Structured Text Input(Please optimize it according to privacy policy input in user context!)**:{PrivacyLint_text}
"""
#system_prompt_with_privacylint = system_prompt_with_privacylint + "\n" + PrivacyLint_text

class Policy(BaseModel):
    """
    Information about a privacy policy.
    This class is used to extract structured information from a privacy policy text.
    """
    subject: Optional[Union[str, List[str]]] = Field(default=None, description="The subject of the privacy policy, such as the entity or service.")
    action: Optional[Union[str, List[str]]] = Field(default=None, description="The action in the privacy policy, e.g., collection, sharing.")
    privacy_information: Optional[Union[str, List[str]]] = Field(default=None, description="The type of privacy information involved, like personal data, location data.")
    third_party: Optional[Union[str, List[str]]] = Field(default=None, description="The third-party involved in the sharing or collection, if any.")

def safe_get(data, key, default=None):
    return data.get(key, default) or default

def process_policy(privacy_policy_text,system_prompt_def=system_prompt_raw,subject=None,is_chunk=None,mode:Literal["raw", "with_privacylint"]="raw"):

    #删除空格、换行和特殊字符
    privacy_policy_text = privacy_policy_text.replace('\n', '').replace('\r', '')  # 去除换行符
    privacy_policy_text = re.sub(r'\s+', ' ', privacy_policy_text).strip()
    privacy_policy_text = re.sub(r'[^a-zA-Z0-9\s.,!?]', '', privacy_policy_text)
    all_results = []

    if mode == "with_privacylint":
        system_prompt_def=system_prompt_with_privacylint

    #使用分块处理
    if is_chunk:
        chunks = [privacy_policy_text[i:i + MAX_CHUNK_LENGTH] for i in range(0, len(privacy_policy_text), MAX_CHUNK_LENGTH)]
        for chunk in chunks:
            #补充主体信息
            if "subject" not in chunk:
                chunk = f"{subject}: {chunk}"

            response = client.chat.completions.create(
                model="deepseek-chat",
                messages=[
                    {"role": "system", "content": system_prompt_def},
                    {"role": "user", "content": chunk}
                ],
                response_format={"type": "json_object"},
                stream=False,
                temperature=0.8,  #降低随机性
                max_tokens=7000
            )

            try:
                content = response.choices[0].message.content
                print("Debug - Raw API response:", content)
                result = json.loads(content)
                if isinstance(result, str):
                    result = json.loads(result)
                if isinstance(result, dict):
                    result = [result]

                for key, value in result[0].items():
                    all_results.extend(value)

            except json.JSONDecodeError:
                print("Failed to parse the response as JSON.")
            except Exception as e:
                print(f"An error occurred: {e}")

    #不分段处理
    else:
        response = client.chat.completions.create(
            model="deepseek-chat",
            messages=[
                {"role": "system", "content": system_prompt_def},
                {"role": "user", "content": privacy_policy_text}
            ],
            response_format={"type": "json_object"},
            stream=False,
            temperature=0.8,  #降低随机性
            max_tokens=7000
        )
        try:
            content = response.choices[0].message.content
            print("Debug - Raw API response:", content)
            result = json.loads(content)
            if isinstance(result, str):
                result = json.loads(result)
            if isinstance(result, dict):
                result = [result]

            for key, value in result[0].items():
                all_results.extend(value)

        except json.JSONDecodeError:
            print("Failed to parse the response as JSON.")
        except Exception as e:
            print(f"An error occurred: {e}")

    policies = []
    for item in all_results:
        try:
            subject = item.get("subject")
            action = item.get("action")
            third_party_str = item.get("third_party", "")
            privacy_info_str = item.get("privacy_information", "")

            # 处理隐私信息
            # 按逗号、and、or 分割并去除空项和空白字符
            privacy_infos = [info.strip() for info in re.split(r',|\s+(and|or)\s+', privacy_info_str) if info.strip()]

            # 处理第三方信息
            third_parties = []
            if third_party_str:
                third_parties = [party.strip() for party in re.split(r',|\s+(and|or)\s+', third_party_str) if
                                 party.strip()]
            if not third_parties:
                third_parties = [None]

            for info in privacy_infos:
                if info:
                    for third_party in third_parties:
                        policy_data = {
                            "subject": subject,
                            "action": action,
                            "privacy_information": info,
                            "third_party": third_party
                        }
                        policy = Policy(**policy_data)
                        policies.append(policy)
        except Exception as e:
            print(f"Error parsing item: {item}\nError: {e}")
            continue

    # 生成元组列表
    tuples_list = [
        (policy.subject, policy.action, policy.privacy_information, policy.third_party)
        for policy in policies
    ]

    return tuples_list

txt_files =[f for f in Path(input_folder).glob("*.txt")]

for txt_file in txt_files:
    print(f"\nProcessing file: {txt_file.name}")

    file_subject = txt_file.stem.replace("_", " ")
    with open(txt_file, 'r', encoding='utf-8') as file:
        policy_text = file.read()

    #纯LLM
    tuples_list = process_policy(policy_text,subject=file_subject,is_chunk=True)
    output_file_raw = Path(output_folder_raw) / f"{txt_file.stem}_raw.txt"
    with open(output_file_raw, 'w', encoding='utf-8') as file:
        for t in tuples_list:
            formatted_tuple = '(' + ','.join(str(item) if item is not None else 'None' for item in t) + ')'
            file.write(formatted_tuple + '\n')
    print(f"Results saved to: {output_folder_raw}")

    #采用PrivacyLint后的优化结果
    tuples_list = process_policy(policy_text,subject=file_subject,is_chunk=True,mode="with_privacylint")
    output_file_with_privacylint = Path(output_folder_with_privacylint) / f"{txt_file.stem}_with_pravacylint.txt"
    with open(output_file_with_privacylint, 'w', encoding='utf-8') as file:
        for t in tuples_list:
            formatted_tuple = '(' + ','.join(str(item) if item is not None else 'None' for item in t) + ')'
            file.write(formatted_tuple + '\n')

    '''
    output_file_nlp = Path(output_folder_nlp) / f"{txt_file.stem}_result_nlp.txt"
    with open(output_file_nlp, 'w', encoding='utf-8') as file:
        for t in tuples_list:
            subject, action, privacy_info, third_party = t

            # 处理默认值
            subject = subject if subject is not None else "We"
            action = action if action is not None else "collect"
            privacy_info = privacy_info if privacy_info is not None else "some personal information"

            # 构建基础句子
            sentence = f"{subject} {action} {privacy_info}"

            # 处理第三方信息
            if third_party is not None:
                if isinstance(third_party, list):
                    if len(third_party) > 1:
                        third_parties = ", ".join(third_party[:-1]) + " and " + third_party[-1]
                    else:
                        third_parties = third_party[0]
                else:
                    third_parties = third_party
                sentence += f" with {third_parties}"
            # 添加句号并写入
            file.write(sentence.capitalize() + ".\n")  # 确保首字母大写
    '''


print(f"Results saved to: {output_folder_with_privacylint}")

