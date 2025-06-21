package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class StringUtil implements com.alimm.tanx.core.utils.NotConfused {
    public static java.lang.String filterNonPrintableCharacters(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (char c : str.toCharArray()) {
            if (isPrintable(c)) {
                sb.append(c);
            }
        }
        com.alimm.tanx.core.utils.LogUtils.d("StringUtil耗时" + (java.lang.System.currentTimeMillis() - currentTimeMillis), new java.lang.String[0]);
        return sb.toString();
    }

    public static boolean isNull(java.lang.String str) {
        return android.text.TextUtils.isEmpty(str);
    }

    public static boolean isPrintable(char c) {
        return (java.lang.Character.isISOControl(c) || java.lang.Character.getType(c) == 0) ? false : true;
    }
}
