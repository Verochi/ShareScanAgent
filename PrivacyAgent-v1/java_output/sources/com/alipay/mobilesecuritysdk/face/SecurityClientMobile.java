package com.alipay.mobilesecuritysdk.face;

/* loaded from: classes.dex */
public class SecurityClientMobile {
    public static synchronized java.lang.String GetApdid(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String a;
        synchronized (com.alipay.mobilesecuritysdk.face.SecurityClientMobile.class) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.alipay.sdk.m.l.b.g, com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, ""));
            hashMap.put("tid", com.alipay.sdk.m.z.a.a(map, "tid", ""));
            hashMap.put("userId", com.alipay.sdk.m.z.a.a(map, "userId", ""));
            com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getInstance(context).initToken(0, hashMap, null);
            a = com.alipay.apmobilesecuritysdk.a.a.a(context);
        }
        return a;
    }
}
