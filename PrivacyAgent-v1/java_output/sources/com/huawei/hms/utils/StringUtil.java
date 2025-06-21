package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public class StringUtil {
    public static java.lang.String addByteForNum(java.lang.String str, int i, char c) {
        int length = str.length();
        if (length == i) {
            return str;
        }
        if (length > i) {
            return str.substring(length - i);
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (length < i) {
            stringBuffer.append(c);
            length++;
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static boolean checkVersion(java.lang.String str) {
        return java.util.regex.Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(str).find();
    }

    public static int convertVersion2Integer(java.lang.String str) {
        if (!checkVersion(str)) {
            return 0;
        }
        java.lang.String[] split = str.split("\\.");
        if (split.length < 3) {
            return 0;
        }
        int parseInt = (java.lang.Integer.parseInt(split[0]) * com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION) + (java.lang.Integer.parseInt(split[1]) * 100000) + (java.lang.Integer.parseInt(split[2]) * 1000);
        return split.length == 4 ? parseInt + java.lang.Integer.parseInt(split[3]) : parseInt;
    }

    public static java.lang.String objDesc(java.lang.Object obj) {
        if (obj == null) {
            return com.igexin.push.core.b.m;
        }
        return obj.getClass().getName() + '@' + java.lang.Integer.toHexString(obj.hashCode());
    }
}
