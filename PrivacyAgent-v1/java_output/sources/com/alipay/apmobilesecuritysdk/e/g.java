package com.alipay.apmobilesecuritysdk.e;

/* loaded from: classes.dex */
public final class g {
    public static synchronized java.lang.String a(android.content.Context context, java.lang.String str) {
        synchronized (com.alipay.apmobilesecuritysdk.e.g.class) {
            java.lang.String a = com.alipay.sdk.m.b0.e.a(context, "openapi_file_pri", "openApi" + str, "");
            if (com.alipay.sdk.m.z.a.a(a)) {
                return "";
            }
            java.lang.String b = com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), a);
            return com.alipay.sdk.m.z.a.a(b) ? "" : b;
        }
    }

    public static synchronized void a() {
        synchronized (com.alipay.apmobilesecuritysdk.e.g.class) {
        }
    }

    public static synchronized void a(android.content.Context context) {
        synchronized (com.alipay.apmobilesecuritysdk.e.g.class) {
            android.content.SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public static synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        synchronized (com.alipay.apmobilesecuritysdk.e.g.class) {
            try {
                android.content.SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.putString("openApi" + str, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str2));
                    edit.commit();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }
}
