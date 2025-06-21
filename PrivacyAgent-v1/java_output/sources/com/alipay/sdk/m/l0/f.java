package com.alipay.sdk.m.l0;

/* loaded from: classes.dex */
public class f {
    public static final java.util.regex.Pattern a = java.util.regex.Pattern.compile("([\t\r\n])+");

    public static int a(java.lang.String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m12a(java.lang.String str) {
        return str == null || str.length() <= 0;
    }
}
