package com.bun.lib;

/* loaded from: classes.dex */
public class sysParamters {
    private static volatile com.bun.lib.sysParamters d;
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    @androidx.annotation.Keep
    private java.lang.String sdk_version = "10012";

    @androidx.annotation.Keep
    private java.lang.String sdk_vname = "1.0.12";

    private sysParamters() {
    }

    private static android.content.pm.PackageInfo a(android.content.Context context, java.lang.String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        if (context == null) {
            return "0.1.100";
        }
        android.content.pm.PackageInfo a = a(context, context.getPackageName());
        if (a == null) {
            return null;
        }
        return a.versionName;
    }

    public static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
                return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "unknown");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return str2;
            }
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static java.lang.String e() {
        return "";
    }

    public static com.bun.lib.sysParamters f() {
        if (d == null) {
            synchronized (com.bun.lib.sysParamters.class) {
                if (d == null) {
                    d = new com.bun.lib.sysParamters();
                }
            }
        }
        return d;
    }

    public static java.lang.String g() {
        android.content.pm.ApplicationInfo applicationInfo = com.bun.lib.b.b().getApplicationInfo();
        return (applicationInfo == null || android.text.TextUtils.isEmpty(applicationInfo.packageName)) ? h() : applicationInfo.packageName;
    }

    private static java.lang.String h() {
        return com.bun.lib.b.b().getPackageName();
    }

    public java.lang.String a() {
        if (!android.text.TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        java.lang.String a = a(com.bun.lib.b.b());
        this.a = a;
        return a;
    }

    public java.lang.String b() {
        if (!android.text.TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        java.lang.String encode = android.net.Uri.encode(android.os.Build.MANUFACTURER);
        this.c = encode;
        return encode;
    }

    public java.lang.String c() {
        if (!android.text.TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        java.lang.String str = android.os.Build.MODEL;
        this.b = str;
        java.lang.String replace = str.replace(" ", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.b = replace;
        return replace;
    }

    public java.lang.String d() {
        return this.sdk_version;
    }
}
