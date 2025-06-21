package com.ss.android.socialbase.appdownloader.kz;

/* loaded from: classes19.dex */
public class v {
    private static java.lang.String t;
    private static java.lang.String v;
    private static java.lang.String vw;
    private static java.lang.String wg;
    private static java.lang.Boolean yl;

    public static java.lang.String bt() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.system.BuildEx");
            return (java.lang.String) cls.getMethod("getOsBrand", new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]);
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean kz() {
        return yl() && wg(wg(), vw()) && vw(android.os.Process.myUid()) == 0;
    }

    public static int t(android.content.Context context) {
        if (context != null) {
            return wg(wg(), vw()) ? android.provider.Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1 : android.provider.Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
        }
        return 1;
    }

    public static java.lang.String t() {
        if (t == null) {
            t = vw("getReleaseType");
        }
        return t;
    }

    public static int v(android.content.Context context) {
        return (context == null || android.provider.Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    public static java.lang.String v() {
        if (v == null) {
            v = vw("getBuildVersion");
        }
        return v;
    }

    private static int vw(int i) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.os.UserHandleEx");
            return ((java.lang.Integer) cls.getMethod("getUserId", java.lang.Integer.TYPE).invoke(cls, java.lang.Integer.valueOf(i))).intValue();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    public static java.lang.String vw() {
        if (vw == null) {
            vw = vw("getApiVersion");
        }
        return vw;
    }

    private static java.lang.String vw(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new java.lang.Class[0]).invoke(cls, new java.lang.Object[0]).toString();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.String vw(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "unknown");
        } catch (java.lang.Throwable unused) {
            return str2;
        }
    }

    public static boolean vw(android.content.Context context) {
        return context != null && t(context) == 0 && yl();
    }

    public static java.lang.String wg() {
        if (wg == null) {
            wg = vw("getVersion");
        }
        return wg;
    }

    public static boolean wg(android.content.Context context) {
        return context != null && v(context) == 0 && kz();
    }

    private static boolean wg(java.lang.String str, java.lang.String str2) {
        return !android.text.TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    public static boolean yl() {
        if (yl == null) {
            yl = java.lang.Boolean.FALSE;
            try {
                yl = java.lang.Boolean.valueOf("156".equals(vw("ro.config.hw_optb", "0")) && com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE.equals(vw("hw_mc.pure_mode.enable", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE)));
            } catch (java.lang.Exception unused) {
            }
        }
        return yl.booleanValue();
    }
}
