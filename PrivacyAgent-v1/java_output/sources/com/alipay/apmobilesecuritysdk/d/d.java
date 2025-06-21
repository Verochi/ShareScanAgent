package com.alipay.apmobilesecuritysdk.d;

/* loaded from: classes.dex */
public final class d {
    public static synchronized java.util.Map<java.lang.String, java.lang.String> a() {
        java.util.HashMap hashMap;
        synchronized (com.alipay.apmobilesecuritysdk.d.d.class) {
            hashMap = new java.util.HashMap();
            try {
                new com.alipay.apmobilesecuritysdk.c.b();
                hashMap.put("AE16", "");
            } catch (java.lang.Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context) {
        java.util.HashMap hashMap;
        synchronized (com.alipay.apmobilesecuritysdk.d.d.class) {
            com.alipay.sdk.m.a0.d.a();
            com.alipay.sdk.m.a0.b.b();
            hashMap = new java.util.HashMap();
            hashMap.put("AE1", com.alipay.sdk.m.a0.d.b());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.alipay.sdk.m.a0.d.c() ? "1" : "0");
            hashMap.put("AE2", sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(com.alipay.sdk.m.a0.d.a(context) ? "1" : "0");
            hashMap.put("AE3", sb2.toString());
            hashMap.put("AE4", com.alipay.sdk.m.a0.d.d());
            hashMap.put("AE5", com.alipay.sdk.m.a0.d.e());
            hashMap.put("AE6", com.alipay.sdk.m.a0.d.f());
            hashMap.put("AE7", com.alipay.sdk.m.a0.d.g());
            hashMap.put("AE8", com.alipay.sdk.m.a0.d.h());
            hashMap.put("AE9", com.alipay.sdk.m.a0.d.i());
            hashMap.put("AE10", com.alipay.sdk.m.a0.d.j());
            hashMap.put("AE11", com.alipay.sdk.m.a0.d.k());
            hashMap.put("AE12", com.alipay.sdk.m.a0.d.l());
            hashMap.put("AE13", com.alipay.sdk.m.a0.d.m());
            hashMap.put("AE14", com.alipay.sdk.m.a0.d.n());
            hashMap.put("AE15", com.alipay.sdk.m.a0.d.o());
            hashMap.put("AE21", com.alipay.sdk.m.a0.b.g());
        }
        return hashMap;
    }
}
