package com.alipay.apmobilesecuritysdk.e;

/* loaded from: classes.dex */
public class h {
    public static java.lang.String a = "";

    public static long a(android.content.Context context) {
        java.lang.String a2 = com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "update_time_interval");
        if (!com.alipay.sdk.m.z.a.b(a2)) {
            return 86400000L;
        }
        try {
            return java.lang.Long.parseLong(a2);
        } catch (java.lang.Exception unused) {
            return 86400000L;
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        a(context, "update_time_interval", str);
    }

    public static void a(android.content.Context context, java.lang.String str, long j) {
        com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "vkey_valid" + str, java.lang.String.valueOf(j));
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", str, str2);
    }

    public static void a(android.content.Context context, boolean z) {
        a(context, "log_switch", z ? "1" : "0");
    }

    public static java.lang.String b(android.content.Context context) {
        return com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "last_apdid_env");
    }

    public static void b(android.content.Context context, java.lang.String str) {
        a(context, "last_machine_boot_time", str);
    }

    public static void c(android.content.Context context, java.lang.String str) {
        a(context, "last_apdid_env", str);
    }

    public static boolean c(android.content.Context context) {
        java.lang.String a2 = com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "log_switch");
        return a2 != null && "1".equals(a2);
    }

    public static java.lang.String d(android.content.Context context) {
        return com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "dynamic_key");
    }

    public static void d(android.content.Context context, java.lang.String str) {
        a(context, "agent_switch", str);
    }

    public static java.lang.String e(android.content.Context context) {
        return com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "apse_degrade");
    }

    public static void e(android.content.Context context, java.lang.String str) {
        a(context, "dynamic_key", str);
    }

    public static java.lang.String f(android.content.Context context) {
        java.lang.String str;
        android.content.SharedPreferences.Editor edit;
        synchronized (com.alipay.apmobilesecuritysdk.e.h.class) {
            if (com.alipay.sdk.m.z.a.a(a)) {
                java.lang.String a2 = com.alipay.sdk.m.b0.e.a(context, "alipay_vkey_random", "random", "");
                a = a2;
                if (com.alipay.sdk.m.z.a.a(a2)) {
                    java.lang.String a3 = com.alipay.sdk.m.y.b.a(java.util.UUID.randomUUID().toString());
                    a = a3;
                    if (a3 != null && (edit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                        edit.putString("random", a3);
                        edit.commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    public static void f(android.content.Context context, java.lang.String str) {
        a(context, "webrtc_url", str);
    }

    public static void g(android.content.Context context, java.lang.String str) {
        a(context, "apse_degrade", str);
    }

    public static long h(android.content.Context context, java.lang.String str) {
        try {
            java.lang.String a2 = com.alipay.sdk.m.b0.a.a(context, "vkeyid_settings", "vkey_valid" + str);
            if (com.alipay.sdk.m.z.a.a(a2)) {
                return 0L;
            }
            return java.lang.Long.parseLong(a2);
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
    }
}
