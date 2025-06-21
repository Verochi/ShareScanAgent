package com.alipay.apmobilesecuritysdk.d;

/* loaded from: classes.dex */
public final class a {
    public static synchronized java.util.Map<java.lang.String, java.lang.String> a(android.content.Context context, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.HashMap hashMap;
        synchronized (com.alipay.apmobilesecuritysdk.d.a.class) {
            java.lang.String a = com.alipay.sdk.m.z.a.a(map, "appchannel", "");
            hashMap = new java.util.HashMap();
            hashMap.put("AA1", context.getPackageName());
            com.alipay.sdk.m.a0.a.a();
            hashMap.put("AA2", com.alipay.sdk.m.a0.a.a(context));
            hashMap.put("AA3", "APPSecuritySDK-ALIPAYSDK");
            hashMap.put("AA4", "3.4.0.202206130311");
            hashMap.put("AA6", a);
        }
        return hashMap;
    }
}
