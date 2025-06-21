package com.alipay.apmobilesecuritysdk.d;

/* loaded from: classes.dex */
public final class b {
    public static synchronized java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap;
        synchronized (com.alipay.apmobilesecuritysdk.d.b.class) {
            hashMap = new java.util.HashMap();
            java.lang.String a = com.alipay.sdk.m.z.a.a(map, "tid", "");
            java.lang.String a2 = com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, "");
            java.lang.String a3 = com.alipay.sdk.m.z.a.a(map, "userId", "");
            java.lang.String a4 = com.alipay.sdk.m.z.a.a(map, "appName", "");
            java.lang.String a5 = com.alipay.sdk.m.z.a.a(map, "appKeyClient", "");
            java.lang.String a6 = com.alipay.sdk.m.z.a.a(map, "tmxSessionId", "");
            java.lang.String f = com.alipay.apmobilesecuritysdk.e.h.f(context);
            java.lang.String a7 = com.alipay.sdk.m.z.a.a(map, "sessionId", "");
            hashMap.put("AC1", a);
            hashMap.put("AC2", a2);
            hashMap.put("AC3", "");
            hashMap.put("AC4", f);
            hashMap.put("AC5", a3);
            hashMap.put("AC6", a6);
            hashMap.put("AC7", "");
            hashMap.put("AC8", a4);
            hashMap.put("AC9", a5);
            if (com.alipay.sdk.m.z.a.b(a7)) {
                hashMap.put("AC10", a7);
            }
        }
        return hashMap;
    }
}
