package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class bm {
    private static final java.lang.String a = "ro.build.version.emui";
    private static final java.lang.String b = "hw_sc.build.platform.version";

    private static java.lang.String a(java.lang.String str) {
        try {
            return (java.lang.String) java.lang.Class.forName("android.os.SystemProperties").getDeclaredMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class).invoke(null, str);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return !android.text.TextUtils.isEmpty((java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, "ro.build.flyme.version", ""));
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static boolean b() {
        return f() && !g();
    }

    public static boolean c() {
        return f() && g();
    }

    public static boolean d() {
        java.lang.String str = android.os.Build.BRAND;
        if (!str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HW) && !str.equalsIgnoreCase(com.igexin.assist.util.AssistUtils.BRAND_HON) && !str.equalsIgnoreCase("华为")) {
            java.lang.String a2 = a("ro.build.version.emui");
            java.lang.String a3 = a("hw_sc.build.platform.version");
            if (android.text.TextUtils.isEmpty(a2) && android.text.TextUtils.isEmpty(a3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean e() {
        return !android.text.TextUtils.isEmpty(a("ro.coolos.version"));
    }

    private static boolean f() {
        return android.os.Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    private static boolean g() {
        return !android.text.TextUtils.isEmpty(a("ro.build.version.emui"));
    }
}
