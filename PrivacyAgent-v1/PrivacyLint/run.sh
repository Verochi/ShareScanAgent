#!/bin/bash

#复制隐私政策文本夹
external_plaintext_dir="C:/Users/21654/PycharmProjects/PrivacyAgent-v1/plaintext_policies"
mounted_plaintext_dir="C:/Users/21654/PycharmProjects/PrivacyAgent-v1/PrivacyLint/ext/plaintext_policies"
mkdir -p "$mounted_plaintext_dir"
cp -r "$external_plaintext_dir/"* "$mounted_plaintext_dir"

#mkdir ext/plaintext_policies
docker run -v "C:/Users/21654/PycharmProjects/PrivacyAgent-v1/PrivacyLint/ext:/ext" benandow/pol-analysis

python PrivacyLint/pickle_to_text.py
python PrivacyLint/text_to_form.py

#read -p "Press Enter to exit..."