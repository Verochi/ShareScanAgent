import subprocess #调用外部工具
import json
import os
from openai import OpenAI
from typing import Dict, Any


class APKAnalyzer:
    def __init__(self, openai_api_key="sk-4d765424d2a44527a9d7f6193623343a", base_url="https://api.deepseek.com/v1"):
        self.client = OpenAI(api_key="sk-4d765424d2a44527a9d7f6193623343a", base_url="https://api.deepseek.com/v1")
        self.tools = {
            'decompile': self._decompile_apk,
            'mobsf_scan': self._run_mobsf,
            'androguard': self._run_androguard,
            'string_analysis': self._string_analysis
        }
        #固定分析方案
        self.analysis_plan = {
            "tools_to_run": {
                "decompile": {"engine": "jadx"},
                "mobsf_scan": {"full": True},
                "androguard": {"level": "deep"},
                "string_analysis": {"patterns": ["key", "secret", "password"]}
            },
            "focus_areas": ["hardcoded_secrets", "network_security", "data_storage"],
            "estimated_time": "15 minutes"
        }

    def analyze(self, apk_path: str) -> Dict[str, Any]:
        """主分析流程"""
        #执行工具链
        results = {}
        for tool_name, params in self.analysis_plan['tools_to_run'].items():
            if tool_name in self.tools:
                results[tool_name] = self.tools[tool_name](apk_path, params)

        #聚合分析结果
        final_report = self._generate_report(apk_path, results)
        return final_report

    def _decompile_apk(self, apk_path: str, params: Dict) -> Dict:
        """反编译APK"""
        output_dir = os.path.abspath(f"decompiled_{os.path.splitext(os.path.basename(apk_path))[0]}")
        os.makedirs(output_dir, exist_ok=True)
        jadx_path = r"D:/application/jadx/bin/jadx.bat"
        cmd = ["cmd", "/c", jadx_path, "-d", output_dir, apk_path]
        result = subprocess.run(cmd, capture_output=True, text=True)

        print("1")

        return {
            "status": "success" if result.returncode == 0 else "failed",
            "output_dir": output_dir,
            "summary": self._summarize_decompilation(output_dir)
        }

    def _run_mobsf(self, apk_path: str, params: Dict) -> Dict:
        """运行MobSF扫描"""
        #利用MobSF API的集成
        print("monsf:")
        mobsf_api = "http://localhost:8000/api/v1/scan"
        cmd = [
            "curl", "-F", f"file=@{apk_path}",
            "-H", "Authorization: 7f48e6e7e7c0e58fd2272b63d2b2a827be9c935bfce06cb3b0aa132160a3657e",
            mobsf_api
        ]
        result = subprocess.run(cmd, capture_output=True, text=True)

        print("2")

        try:
            scan_result = json.loads(result.stdout)
            return {
                "score": scan_result.get("score"),
                "findings": scan_result.get("findings"),
                "pdf_report": self._generate_mobsf_pdf(scan_result.get("scan_id"))
            }
        except:
            return {"error": "MobSF analysis failed"}

    def _run_androguard(self, apk_path: str, params: Dict) -> Dict:
        """Androguard分析"""
        from androguard.misc import AnalyzeAPK
        a, d, dx = AnalyzeAPK(apk_path)

        print("3")

        return {
            "permissions": a.get_permissions(),
            "activities": a.get_activities(),
            "services": a.get_services(),
            "receivers": a.get_receivers(),
            "providers": a.get_providers(),
            #"certificate": a.get_certificate()
        }

    def _string_analysis(self, apk_path: str, params: Dict) -> Dict:
        """字符串分析"""
        patterns = params.get("patterns", ["key", "secret", "password"])
        decompiled_dir = f"decompiled_{os.path.splitext(apk_path)[0]}"

        findings = {}
        for pattern in patterns:
            findings[pattern] = []
            for root, dirs, files in os.walk(decompiled_dir):
                for file in files:
                    file_path = os.path.join(root, file)
                    try:
                        with open(file_path, 'r', encoding='utf-8') as f:
                            for line_number, line in enumerate(f, start=1):
                                if pattern in line:
                                    findings[pattern].append(f"{file_path}:{line_number}: {line.strip()}")
                    except Exception as e:
                        # 处理文件打开错误等异常
                        print(f"Error reading {file_path}: {e}")
        print("4")
        return findings

    def _generate_report(self, apk_path: str, results: Dict) -> Dict:
        """生成最终报告"""
        prompt = f"""
        APK安全分析报告生成

        应用文件: {os.path.basename(apk_path)}
        分析结果汇总:
        {json.dumps(results, indent=2)}

        请生成包含以下部分的专业安全报告:
        1. 执行摘要 (风险评级)
        2. 详细发现 (按严重性排序)
        3. 漏洞利用场景分析
        4. 修复建议
        5. 参考标准
        6. 附录 (原始数据摘要)
        """

        report = self._query_llm(prompt, temp=0.2)
        return {
            "report": report,
            "raw_data": results
        }

    def _summarize_decompilation(self, output_dir: str) -> str:
        """总结反编译结果"""
        prompt = f"""
        总结以下APK反编译结果的结构:

        目录结构:
        {os.listdir(output_dir)}

        请用100字左右总结这个APK的主要组件和结构特征。
        """
        return self._query_llm(prompt)

    def _generate_mobsf_pdf(self, scan_id: str) -> str:
        """生成MobSF PDF报告"""
        # 实现PDF报告生成逻辑
        return f"http://localhost:8000/pdf/{scan_id}"

    def _query_llm(self, prompt: str, temp: float = 0.7) -> str:
        """与大模型交互"""
        response = self.client.chat.completions.create(
            model="deepseek-chat",  # 使用DeepSeek模型
            messages=[{"role": "user", "content": prompt}],
            temperature=temp
        )
        return response.choices[0].message.content


# 使用示例
if __name__ == "__main__":
    analyzer = APKAnalyzer()
    report = analyzer.analyze("moji.apk")

    # 保存报告
    with open("security_report.json", "w") as f:
        json.dump(report, f, indent=2)

    print("分析完成! 报告已保存为 security_report.json")
