import asyncio
from dataclasses import dataclass, field
from typing import List, Tuple
from tqdm import tqdm
from aiolimiter import AsyncLimiter
from openai import AsyncOpenAI
from typing import Any  # 用于类型注解

# ===== 默认配置 =====
DEFAULT_API_KEYS = [
    #"sk-4d765424d2a44527a9d7f6193623343a",
    #"sk-bd353a2b964544ecb6792c973ba28cc4",
    #"sk-ceb3817aacbe4faa8e7eb78878be4d50",
    #"sk-e4482bed956d4cfe9c33903cedffdfe8",
    #"sk-31af5fe021474385a54fb87be3f787ec",
    #"sk-1fd251fb97a64ca39c9eee6d98cf1832",
    "sk-639e85dff993487c99cef0b169615716",
    "sk-440f1b2be3564f69afb03305ef64b852",
    "sk-9d5d5e1547cf40ada7debd3d531f77ba",
    "sk-531ad7cd29714be1a8d0d8d8b4915320",
    "sk-71897e61344c46b09ca52703ca4f53d1",
    "sk-411c6f5d850b47f092a65f3fe69118fd"
]
DEFAULT_BASE_URL = "https://api.deepseek.com/v1"
DEFAULT_MODEL_NAME = "deepseek-chat"
DEFAULT_MAX_TOKENS = 6000
DEFAULT_TEMPERATURE = 0.2

# ===== DeepSeek API 封装 =====
@dataclass
class AsyncDeepSeekAPI:
    """异步调用 DeepSeek API 的封装类"""
    base_url: str = DEFAULT_BASE_URL
    api_key: str = ""
    uid: int = 0  # 用于识别每个 API 实例
    cnt: int = 0  # 调用计数
    max_tokens: int = DEFAULT_MAX_TOKENS
    temperature: float = DEFAULT_TEMPERATURE
    llm: AsyncOpenAI = field(init=False) # 异步客户端

    def __post_init__(self):
        """初始化 OpenAI 客户端"""
        self.llm = AsyncOpenAI(api_key=self.api_key, base_url=self.base_url)

    async def agenerate(
            self,
            text: str,
            system_prompt: str = None,  # 新增：可选的 system 提示
            model_name=DEFAULT_MODEL_NAME,
            **kwargs
    ):
        """异步调用 DeepSeek API，支持 system 消息"""
        self.cnt += 1

        # 构造 messages 列表
        messages = []
        if system_prompt:
            messages.append({"role": "system", "content": system_prompt})
        messages.append({"role": "user", "content": text})

        response = await self.llm.chat.completions.create(
            model=model_name,
            messages=messages,
            max_tokens=kwargs.get("max_tokens", self.max_tokens),
            temperature=kwargs.get("temperature", self.temperature),
        )
        return response.choices[0].message.content

# ===== 异步任务管理 =====
async def call_llm(
    llm: AsyncDeepSeekAPI,
    text: str,
    system_prompt: str = None,
    model_name=DEFAULT_MODEL_NAME,
    times=12,
    **kwargs
):
    """带限速的 API 调用，支持 system 消息"""
    async with AsyncLimiter(times, 1):  # 默认限流：每秒 12 次
        res = await llm.agenerate(
            text=text,
            system_prompt=system_prompt,
            model_name=model_name,
            **kwargs
        )
    return res


async def run_api(
    llms: List[AsyncDeepSeekAPI],
    prompts: List[str],
    system_prompt: str = None,
    model_name=DEFAULT_MODEL_NAME,
    times=12,
    **kwargs
) :

    tasks = [
        call_llm(
            llm=llms[i % len(llms)],
            text=prompt,
            system_prompt=system_prompt,
            model_name=model_name,
            times = times,
            **kwargs
        )
        for i, prompt in enumerate(prompts)
    ]

    with tqdm(total=len(tasks)) as pbar:
        results = await asyncio.gather(*[
            run_with_progress(task, pbar) for task in tasks
        ])

    return results


async def run_with_progress(task, pbar):
    """包装任务以更新进度条"""
    result = await task
    pbar.update(1)
    return result