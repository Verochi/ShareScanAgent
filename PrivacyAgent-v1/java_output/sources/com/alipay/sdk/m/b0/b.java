package com.alipay.sdk.m.b0;

/* loaded from: classes.dex */
public final class b {
    public static java.lang.String a(java.lang.String str) {
        java.lang.String str2;
        try {
            str2 = com.alipay.sdk.m.b0.f.a(str);
        } catch (java.lang.Throwable unused) {
            str2 = "";
        }
        if (!com.alipay.sdk.m.z.a.a(str2)) {
            return str2;
        }
        return com.alipay.sdk.m.b0.c.a(".SystemConfig" + java.io.File.separator + str);
    }
}
