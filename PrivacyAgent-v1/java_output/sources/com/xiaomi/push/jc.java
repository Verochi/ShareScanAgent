package com.xiaomi.push;

/* loaded from: classes19.dex */
public final class jc {
    private static android.content.Context a;
    private static java.lang.String b;

    public static android.content.Context a() {
        return a;
    }

    public static java.lang.Class<?> a(android.content.Context context, java.lang.String str) {
        if (str == null || str.trim().length() == 0) {
            throw new java.lang.ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && android.os.Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (java.lang.Throwable unused) {
            }
        }
        try {
            return java.lang.Class.forName(str);
        } catch (java.lang.Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(java.lang.String.format("loadClass fail hasContext= %s, errMsg = %s", java.lang.Boolean.valueOf(z), th.getLocalizedMessage()));
            throw new java.lang.ClassNotFoundException("loadClass fail ", th);
        }
    }

    public static void a(android.content.Context context) {
        a = context.getApplicationContext();
    }

    public static int b() {
        try {
            java.lang.Class<?> a2 = a(null, "miui.os.Build");
            if (a2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return a2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    public static boolean b(android.content.Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static boolean c() {
        return android.text.TextUtils.equals((java.lang.String) com.xiaomi.push.aj.a("android.os.SystemProperties", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "sys.boot_completed"), "1");
    }

    public static boolean d() {
        try {
            return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(java.lang.Boolean.FALSE);
        } catch (java.lang.ClassNotFoundException unused) {
            com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
            return false;
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    public static synchronized java.lang.String e() {
        synchronized (com.xiaomi.push.jc.class) {
            java.lang.String str = b;
            if (str != null) {
                return str;
            }
            java.lang.String str2 = android.os.Build.VERSION.INCREMENTAL;
            if (b() <= 0) {
                java.lang.String a2 = com.xiaomi.push.jb.a(com.alipay.sdk.m.c.a.a, "");
                b = a2;
                if (android.text.TextUtils.isEmpty(a2)) {
                    java.lang.String a3 = com.xiaomi.push.jb.a("ro.build.version.opporom", "");
                    if (!android.text.TextUtils.isEmpty(a3) && !a3.startsWith("ColorOS_")) {
                        b = "ColorOS_".concat(a3);
                    }
                    a2 = b;
                    if (android.text.TextUtils.isEmpty(a2)) {
                        java.lang.String a4 = com.xiaomi.push.jb.a("ro.vivo.os.version", "");
                        if (!android.text.TextUtils.isEmpty(a4) && !a4.startsWith("FuntouchOS_")) {
                            b = "FuntouchOS_".concat(a4);
                        }
                        a2 = b;
                        if (android.text.TextUtils.isEmpty(a2)) {
                            str2 = java.lang.String.valueOf(com.xiaomi.push.jb.a("ro.product.brand", "Android") + "_" + str2);
                        }
                    }
                }
                str2 = a2;
            }
            b = str2;
            return str2;
        }
    }
}
