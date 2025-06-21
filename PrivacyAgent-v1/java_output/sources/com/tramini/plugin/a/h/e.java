package com.tramini.plugin.a.h;

/* loaded from: classes19.dex */
public final class e {
    private static java.lang.String a = "";
    private static java.lang.String b = "";
    private static java.lang.String c = "";
    private static java.lang.String d = "";
    private static int e;
    private static java.lang.String f;

    private e() {
    }

    public static java.lang.String a() {
        if (com.tramini.plugin.a.b.c.a().a("os_vc")) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(b)) {
            b = java.lang.String.valueOf(android.os.Build.VERSION.SDK_INT);
        }
        return b;
    }

    public static java.lang.String a(android.content.Context context) {
        if (com.tramini.plugin.a.b.c.a().a("app_vc")) {
            return "";
        }
        if (e != 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(e);
            return sb.toString();
        }
        try {
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(e);
            return sb2.toString();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static java.lang.String b() {
        if (com.tramini.plugin.a.b.c.a().a("os_vn")) {
            return "";
        }
        if (android.text.TextUtils.isEmpty(a)) {
            a = android.os.Build.VERSION.RELEASE;
        }
        return a;
    }

    public static java.lang.String b(android.content.Context context) {
        if (com.tramini.plugin.a.b.c.a().a("app_vn")) {
            return "";
        }
        try {
            if (!android.text.TextUtils.isEmpty(d)) {
                return d;
            }
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            d = str;
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static int c() {
        return android.os.Build.VERSION.SDK_INT;
    }

    public static java.lang.String c(android.content.Context context) {
        if (com.tramini.plugin.a.b.c.a().a("package_name")) {
            return "";
        }
        try {
            if (!android.text.TextUtils.isEmpty(c)) {
                return c;
            }
            java.lang.String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            c = str;
            return str;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
