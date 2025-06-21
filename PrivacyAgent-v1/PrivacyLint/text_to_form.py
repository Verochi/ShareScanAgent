import pickle
import json
import os
from pathlib import Path

def text_to_form(input_dir, output_dir):
    if not Path(output_dir).exists():
        Path(output_dir).mkdir(parents=True)

    for source_file in Path(input_dir).glob('*.txt'):
        try:

            with open(source_file, 'r', encoding='utf-8') as file:
                data = eval(file.read())

            results = []
            for entry in data:
                if entry[4] == "share" and entry[1]=="collect":
                    subject = "we"
                    action = "share"
                    content = entry[2]
                    recipient = "third_party" if entry[0]=="we" or "us" else entry[0]
                    results.append((subject, action, content, recipient))

            target_file = Path(output_dir) / f"{(source_file.stem)}_share_form.txt"
            with open(target_file, 'w', encoding='utf-8') as file:
                for info_results in results:
                    file.write(f"({','.join(map(str, info_results))})\n")

            print(f"转换成功: {source_file.name} -> {target_file.name}")
        except Exception as e:
            print(f"转换失败 {source_file.name}: {str(e)}")

def text_to_all_form(input_dir, output_dir):
    if not Path(output_dir).exists():
        Path(output_dir).mkdir(parents=True)

    for source_file in Path(input_dir).glob('*.txt'):
        try:

            with open(source_file, 'r', encoding='utf-8') as file:
                data = eval(file.read())

            results = []
            for entry in data:
                if entry[1] == "collect":
                    subject = "we"
                    action = entry[4]
                    content = entry[2]
                    recipient = entry[0]
                    results.append((subject, action, content, recipient))

            target_file = Path(output_dir) / f"{(source_file.stem)}_all_form.txt"
            with open(target_file, 'w', encoding='utf-8') as file:
                for info_results in results:
                    file.write(f"({','.join(map(str, info_results))})\n")

            print(f"转换成功: {source_file.name} -> {target_file.name}")
        except Exception as e:
            print(f"转换失败 {source_file.name}: {str(e)}")

input_dir = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output_text\policy_text_test"
output_dir_form = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output_text_form\policy_text_share_form"
output_dir_all_form = r"C:\Users\21654\PycharmProjects\PrivacyAgent-v1\PrivacyLint\ext\output_text_form\policy_text_all_form"
text_to_form(input_dir, output_dir_form)
text_to_all_form(input_dir, output_dir_all_form)