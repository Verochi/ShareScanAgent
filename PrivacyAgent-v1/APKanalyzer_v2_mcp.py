import openai
# 假设 mcp 相关库可用
from mcp.server import Server
from mcp.server.stdio import stdio_server
import asyncio

from androguard.misc import AnalyzeAPK
from androguard.core.analysis.analysis import MethodAnalysis
# 假设你使用的是 OpenAI 客户端初始化方式，这里保留但注意base_url的问题
client = openai.OpenAI(
    api_key="sk-4d765424d2a44527a9d7f6193623343a",
    base_url="https://api.deepseek.com/v1"
)

# 自定义 TextContent 类
class TextContent:
    def __init__(self, type, text):
        self.type = type
        self.text = text

# 定义APK解析工具
async def parse_apk(file_path):
    try:
        # 加载APK文件
        a = APK(file_path)
        d = DalvikVMFormat(a.get_dex())
        dx = Analysis(d)
        # 这里可以根据需求进一步处理，例如提取类名、方法名等信息
        class_names = [c.name for c in dx.get_classes()]
        return class_names
    except Exception as e:
        return f"Error: {str(e)}"

# 创建MCP Server
server = Server("Data Flow Analysis Server", "0.1.0")
# 自定义工具列表
server.tools = []

# 自定义工具注册装饰器
def tool(func):
    server.tools.append(func)
    return func

# 定义工具
@tool
async def apk_parser(file_path: str):
    parsed_result = await parse_apk(file_path)
    if isinstance(parsed_result, str):  # 如果是错误信息
        return TextContent(type="text", text=parsed_result)

    # 将解析结果转换为字符串表示
    result_str = str(parsed_result)

    # 调用大模型进行分析
    prompt = f"请分析以下APK文件解析得到的类名列表：{result_str}，并给出可能存在的安全风险和优化建议。"
    try:
        response = client.chat.completions.create(
            model="deepseek-chat",
            messages=[
                {"role": "user", "content": prompt}
            ]
        )
        analysis_result = response.choices[0].message.content
    except Exception as e:
        analysis_result = f"调用大模型出错: {str(e)}"

    return TextContent(type="text", text=analysis_result)

async def main():
    # 使用stdio模式运行服务器
    async with stdio_server() as (read_stream, write_stream):
        await server.run(read_stream, write_stream)

if __name__ == "__main__":
    asyncio.run(main())