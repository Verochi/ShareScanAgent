package com.aliyun.vod.common.utils;

/* loaded from: classes12.dex */
public class AliYunMathUtils {
    public static int convertFun(int i) {
        if (fun(i)) {
            return i;
        }
        java.lang.String binaryString = java.lang.Integer.toBinaryString(i);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("the result is : ");
        sb.append(binaryString);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder("1");
        sb2.append(java.lang.String.format("%0" + binaryString.length() + "d", 0));
        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
        sb3.append("the fun is : ");
        sb3.append(sb2.toString());
        return java.lang.Integer.parseInt(sb2.toString(), 2);
    }

    public static boolean fun(int i) {
        return i > 0 && (i & (i + (-1))) == 0;
    }
}
