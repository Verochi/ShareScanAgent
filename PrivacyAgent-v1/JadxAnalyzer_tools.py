import os
import subprocess
import time
import shutil
import openai
import asyncio
from tqdm import tqdm
from async_llm_call import AsyncDeepSeekAPI, run_api,call_llm,run_with_progress
import async_llm_call
import json
from APKSharingAnalyzer_tools import read_exclude_prefixes

classpath = r"D:\platforms\android-34\android.jar"

def check_file_exists(file_path):
    """检查文件是否存在并返回绝对路径"""
    if not os.path.exists(file_path):
        raise FileNotFoundError(f"文件不存在: {file_path}")
    return os.path.abspath(file_path)

def check_jadx_installation(jadx_path):
    """检查jadx是否可以正常运行"""
    try:
        result = subprocess.run(
            [jadx_path, "--version"],
            capture_output=True,
            text=True,
            check=True
        )
        print(f"jadx版本: {result.stdout.strip()}")
    except subprocess.CalledProcessError as e:
        print(f"异常 jadx检查失败: {e.stderr}")
        raise
    except Exception as e:
        print(f"错误 执行jadx命令时出错: {str(e)}")
        raise

def decompile_apk(apk_path, output_dir):
    # 初始化java_files列表
    java_files = []

    # 清理目标输出目录
    if os.path.exists(output_dir):
        shutil.rmtree(output_dir)
    os.makedirs(output_dir)

    # 验证文件和路径
    apk_path = check_file_exists(apk_path)
    os.makedirs(output_dir, exist_ok=True)
    output_dir = os.path.abspath(output_dir)

    # 检查jadx安装情况
    jadx_path = r"D:\application\jadx\bin\jadx.bat"
    check_jadx_installation(jadx_path)

    # 构建并打印完整命令
    cmd = [
        jadx_path,
        "--verbose",  # 启用详细日志
        "--show-bad-code",  # 允许生成不完美的代码
        "--threads-count", "4",  # 设置线程数
        "--no-res",
        "--no-imports",  # 不生成导入语句，减少处理量
        "--no-debug-info",  # 移除调试信息（类似--skip-debug-info）
        "--no-inline-anonymous",  # 不内联匿名类，提高稳定性
        "-d", output_dir,
        apk_path
    ]
    print(f"执行命令: {' '.join(cmd)}")

    try:
        # 创建日志文件
        log_file = os.path.join(output_dir, "jadx_log.txt")
        with open(log_file, 'w', encoding='utf-8') as f:
            # 执行命令并实时捕获输出到日志文件
            process = subprocess.Popen(
                cmd,
                stdout=subprocess.PIPE,
                stderr=subprocess.STDOUT,  # 合并标准错误和标准输出
                text=True,
                bufsize=1,  # 行缓冲
                universal_newlines=True,
                encoding='utf-8',  # 指定UTF-8编码
                errors='replace'  # 替换无法解码的字符
            )

            # 实时显示并记录输出
            for line in process.stdout:
                print(line.strip())
                f.write(line)

            # 等待命令完成并获取返回码
            returncode = process.wait()

            # 反编译完成后，删除资源目录
            resources_dir = os.path.join(output_dir, "resources")
            if os.path.exists(resources_dir):
                print(f"删除资源目录: {resources_dir}")
                shutil.rmtree(resources_dir)

            # 收集Java源代码文件路径
            for root, dirs, files in os.walk(output_dir):
                for file in files:
                    if file.endswith(".java"):
                        java_files.append(os.path.join(root, file))

            print(f"保留 {len(java_files)} 个Java文件")

            if returncode == 0:
                print(f"SUCCEEDED 反编译成功!")
                print(f"输出目录: {output_dir}")
                print(f"日志文件: {log_file}")
                print(f"输出文件数量: {len(os.listdir(output_dir))}")
            else:
                raise subprocess.CalledProcessError(returncode, cmd)

    except subprocess.CalledProcessError as e:
        # 确保stdout和stderr不为None
        stdout = e.stdout or ""
        stderr = e.stderr or ""

        print(f"WARN 反编译命令失败，但继续处理已生成的文件...")
        print(f"错误详情: {stderr if stderr else stdout}")

        # 收集Java源代码文件路径
        java_files = []
        for root, dirs, files in os.walk(output_dir):
            for file in files:
                if file.endswith(".java"):
                    java_files.append(os.path.join(root, file))

        if java_files:
            print(f"SUCCEEDED 找到 {len(java_files)} 个Java文件，继续分析...")
            return java_files
        else:
            print(f"FAILED 未找到任何Java文件，分析终止")
            return []

    except Exception as e:
        print(f"FAILED 发生未知错误: {str(e)}")
        return []

# 预筛选可能包含隐私信息的文件
def prefilter_files(directory_path):
    potential_files = []
    keywords = read_exclude_prefixes("high_risked_classes.txt")  # 外部添加更多关键词
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

async def check_directory_for_privacy(
        directory_path,
        batch_size = 20,  # 每批处理的文件数量
        system_prompt: str = "你是一个分析具备泄露隐私信息风险代码块的专家。",
        model_name="deepseek-coder-6.7b-instruct",
        use_prefilter=True,  # 是否启用预筛选
        max_block_length=80000,  # 每个代码块的最大长度（字符数）
        **kwargs
):

    llms = [AsyncDeepSeekAPI(api_key=api_key, uid=i) for i, api_key in enumerate(async_llm_call.DEFAULT_API_KEYS)]

    prompts=[]
    privacy_issues = []
    all_files = []
    codes=[]

    # 收集所有java文件路径
    # 使用预筛选或直接处理所有文件
    if use_prefilter:
        print("使用关键词预筛选可能存在风险的文件...")
        all_files = prefilter_files(directory_path)
        print(f"预筛选完成，发现 {len(all_files)} 个潜在风险文件")
    else:
        # 收集所有java文件路径
        for root, dirs, files in os.walk(directory_path):
            for file in files:
                if file.endswith(".java"):
                    all_files.append(os.path.join(root, file))
        print(f"文件目录{directory_path}解析完成，共 {len(all_files)} 个Java文件")

    # 分批处理文件
    for i in range(0, len(all_files), batch_size):
        batch_files = all_files[i:i + batch_size]
        batch_code = ""
        print(f"处理第{i//batch_size+1}批中")

        # 拼接当前批次的代码，并添加文件元数据
        for file_path in batch_files:
            try:
                with open(file_path, 'r', encoding='utf-8') as f:
                    file_content = f.read()
                    # 删除空行
                    file_content = "\n".join([line for line in file_content.splitlines() if line.strip()])
                    # 添加文件路径作为注释，帮助定位问题
                    batch_code += f"// FILE: {file_path}\n"
                    batch_code += file_content + "\n\n"
            except Exception as e:
                print(f"处理文件 {file_path} 时出错: {e}")
        for j in range(0, len(batch_code), max_block_length):
            part_code = batch_code[j: j + max_block_length]
            codes.append(part_code)

    for code in codes:
        prompt =f"""
                你是一位精通Android隐私合规的安全审计专家。请分析以下Java代码，重点检查：
                ### 检查项：
                1. **敏感数据处理**：
                   - 个人身份信息（姓名、ID、手机号、邮箱）
                   - 设备标识符（IMEI、MAC地址、Android ID）
                   - 位置数据（GPS坐标、Wi-Fi信息）
                   - 生物特征数据（指纹、面部识别）
            
                2. **数据传输安全**：
                   - 是否使用HTTP而非HTTPS
                   - 是否对敏感数据加密传输
                   - 是否存在硬编码的API密钥或Token
            
                3. **数据存储安全**：
                   - 是否明文存储敏感数据
                   - SharedPreferences/文件存储是否加密
                   - 数据库是否加密
            
                4. **日志安全**：
                   - Logcat中是否记录敏感信息
                   - 错误堆栈是否包含隐私数据
                   
                ###如果不存在风险，返回空列表 []
                
                ###分析代码块：
                    ```java
                    {code}
                """
        prompt_ex="""
            ### 输出要求：
            - 如果存在风险，请按以下JSON格式输出，返回一个JSON的字典列表：
            '''json
            [
                {
                    "risk_location": "[类名].[方法名]",
                    "code:":"[代码具体内容]"，
                    "risk_type": "[具体类型，如"明文存储密码"]",
                    "risk_description": "[详细说明，包括数据流向]",
                    "fix_suggestion": "[具体改进措施]"
                },
                {
                    "risk_location": "[类名].[方法名]",
                    "code:":"[代码具体内容]"，
                    "risk_type": "[具体类型，如"明文存储密码"]",
                    "risk_description": "[详细说明，包括数据流向]",
                    "fix_suggestion": "[具体改进措施]"
                }
            ]
            '''
            请不要在列表前后返回无关内容，无风险返回空列表即可
            """
        prompt=prompt+prompt_ex
        prompts.append(prompt)

    print("分析代码中...")
    results = await run_api(llms=llms, prompts=prompts, system_prompt=system_prompt,times=1,**kwargs)
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
        results = await run_api(llms=llms, prompts=new_prompts, system_prompt=system_prompt,times=3,**kwargs)
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

#apk_path = "moji.apk"
#decompile_apk(apk_path, "java_output")
results=asyncio.run(check_directory_for_privacy("java_output",temperature=0.2, max_tokens=4000))
with open("jadx_results", 'w', encoding='utf-8') as f:
    json.dump(results, f, ensure_ascii=False, indent=4)
print("json文件保存成功")
