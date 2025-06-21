package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class f {
    private static volatile com.baidu.mobads.sdk.internal.f a;

    private f() {
    }

    public static com.baidu.mobads.sdk.internal.f a() {
        if (a == null) {
            synchronized (com.baidu.mobads.sdk.internal.f.class) {
                if (a == null) {
                    a = new com.baidu.mobads.sdk.internal.f();
                }
            }
        }
        return a;
    }

    public dalvik.system.DexClassLoader a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.ClassLoader classLoader) {
        try {
            java.io.File file = new java.io.File(str);
            if (!file.exists()) {
                return null;
            }
            file.setReadOnly();
            return new dalvik.system.DexClassLoader(str, str2, str3, classLoader);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public java.lang.String a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return java.net.URLEncoder.encode(str, "UTF-8");
        } catch (java.io.UnsupportedEncodingException | java.lang.NullPointerException unused) {
            return str;
        }
    }

    public void a(double d, com.baidu.mobads.sdk.internal.am.b bVar) {
        com.baidu.mobads.sdk.internal.cq a2 = com.baidu.mobads.sdk.internal.cq.a();
        java.lang.String c = a2.c(com.baidu.mobads.sdk.internal.z.a);
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("v", "" + d);
        hashMap.put("os", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        hashMap.put("tp", a(com.baidu.mobads.sdk.internal.bm.a((android.content.Context) null).d()));
        hashMap.put("bdr", a(com.baidu.mobads.sdk.internal.bm.a((android.content.Context) null).b()));
        com.baidu.mobads.sdk.internal.am amVar = new com.baidu.mobads.sdk.internal.am(a2.a(c, hashMap));
        amVar.a(bVar);
        amVar.b();
    }
}
