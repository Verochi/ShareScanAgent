import asyncio
from mcp.client import StdioClientSession
from mcp.client.stdio import stdio_client

async def call_apk_parser(file_path):
    # 配置服务器参数
    server_params = {
        "command": "python",
        "args": ["your_script_name.py"]
    }
    async with stdio_client(server_params) as (read, write):
        session = StdioClientSession(read, write)
        await session.initialize()

        # 列出可用工具
        tools_response = await session.list_tools()
        tools = [tool for _, tool in tools_response if tool.name == "apk_parser"]

        if tools:
            # 调用APK解析工具
            result = await session.call_tool(tools[0].name, {"file_path": file_path})
            print(f"分析结果: {result.text}")
        else:
            print("APK解析工具未找到。")

if __name__ == "__main__":
    apk_file_path = "test.apk"  # 替换为实际的APK文件路径
    asyncio.run(call_apk_parser(apk_file_path))