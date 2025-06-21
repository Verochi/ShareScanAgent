package com.alipay.sdk.m.b0;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String a;
        synchronized (com.alipay.sdk.m.b0.a.class) {
            java.lang.String str3 = null;
            if (context != null) {
                try {
                    if (!com.alipay.sdk.m.z.a.a(str) && !com.alipay.sdk.m.z.a.a(str2)) {
                        try {
                            a = com.alipay.sdk.m.b0.e.a(context, str, str2, "");
                        } catch (java.lang.Throwable unused) {
                        }
                        if (com.alipay.sdk.m.z.a.a(a)) {
                            return null;
                        }
                        str3 = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), a);
                        return str3;
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            return null;
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.alipay.sdk.m.b0.a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2) || context == null) {
                return;
            }
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
