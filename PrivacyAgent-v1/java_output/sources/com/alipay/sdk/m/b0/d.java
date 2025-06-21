package com.alipay.sdk.m.b0;

/* loaded from: classes.dex */
public final class d {
    public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.alipay.sdk.m.b0.d.class) {
            if (!com.alipay.sdk.m.z.a.a(str)) {
                if (!com.alipay.sdk.m.z.a.a(str2) && context != null) {
                    try {
                        java.lang.String a = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3);
                        java.util.HashMap hashMap = new java.util.HashMap();
                        hashMap.put(str2, a);
                        com.alipay.sdk.m.b0.e.a(context, str, hashMap);
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }
    }
}
