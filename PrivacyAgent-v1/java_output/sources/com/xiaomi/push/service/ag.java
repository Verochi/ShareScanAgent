package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class ag {
    private static long a = 0;
    private static java.lang.String b = "";

    public static java.lang.String a() {
        if (android.text.TextUtils.isEmpty(b)) {
            b = com.xiaomi.push.ao.a(4);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(b);
        long j = a;
        a = 1 + j;
        sb.append(j);
        return sb.toString();
    }
}
