#!/bin/bash

#记录当前工作目录
original_working_dir=$(pwd)
#切换到脚本所在目录
script_dir=$(dirname "$0")
cd "$script_dir"

rm ext/*.log ext/policheck_results.csv ext/policylint_results.csv
rm -rf ext/combined_tables ext/datasets ext/input ext/output ext/output_text ext/output_text_form ext/plaintext_policies

#工作目录还原
cd "$original_working_dir"