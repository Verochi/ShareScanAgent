import pickle
import json
import os
from pathlib import Path

def pickle_to_text(input_dir, output_dir):
    if not Path(output_dir).exists():
        Path(output_dir).mkdir(parents=True)

    for pkl_file in Path(input_dir).glob('*.pickle'):
        try:
            with open(pkl_file, 'rb') as f:
                data = pickle.load(f, encoding='latin1')
            if isinstance(data, (dict, list)):
                text_data = json.dumps(data, indent=4, ensure_ascii=False)
            else:
                text_data = str(data)
            output_file = Path(output_dir) / f"{pkl_file.stem}.txt"
            with open(output_file, 'w', encoding='utf-8') as f:
                f.write(text_data)
            print(f"转换成功: {pkl_file.name} -> {output_file.name}")
        except Exception as e:
            print(f"转换失败 {pkl_file.name}: {str(e)}")


input_dir = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output\policy"
output_dir = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output_text\policy_text_test"
pickle_to_text(input_dir, output_dir)
input_dir = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output\analytics"
output_dir = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output_text\analytics_text_test"
pickle_to_text(input_dir, output_dir)
