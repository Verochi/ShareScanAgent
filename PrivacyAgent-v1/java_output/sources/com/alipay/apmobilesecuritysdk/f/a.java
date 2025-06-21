package com.alipay.apmobilesecuritysdk.f;

/* loaded from: classes.dex */
public class a {
    public static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null || com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
            return null;
        }
        try {
            java.lang.String a = com.alipay.sdk.m.b0.e.a(context, str, str2, "");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return null;
            }
            return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), a);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        synchronized (com.alipay.apmobilesecuritysdk.f.a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
                return null;
            }
            try {
                java.lang.String a = com.alipay.sdk.m.b0.b.a(str);
                if (com.alipay.sdk.m.z.a.a(a)) {
                    return null;
                }
                java.lang.String string = new org.json.JSONObject(a).getString(str2);
                if (com.alipay.sdk.m.z.a.a(string)) {
                    return null;
                }
                return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), string);
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
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

    public static void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        synchronized (com.alipay.apmobilesecuritysdk.f.a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
                return;
            }
            try {
                java.lang.String a = com.alipay.sdk.m.b0.b.a(str);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.alipay.sdk.m.z.a.b(a)) {
                    try {
                        jSONObject = new org.json.JSONObject(a);
                    } catch (java.lang.Exception unused) {
                        jSONObject = new org.json.JSONObject();
                    }
                }
                jSONObject.put(str2, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3));
                jSONObject.toString();
                try {
                    java.lang.System.clearProperty(str);
                } catch (java.lang.Throwable unused2) {
                }
                if (com.alipay.sdk.m.b0.c.a()) {
                    java.lang.String str4 = ".SystemConfig" + java.io.File.separator + str;
                    if (com.alipay.sdk.m.b0.c.a()) {
                        java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (java.lang.Throwable unused3) {
            }
        }
    }
}
