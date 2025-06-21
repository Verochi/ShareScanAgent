package com.umeng.analytics;

/* loaded from: classes19.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final java.lang.String DEBUG_KEY = "debugkey";
    public static final java.lang.String DEBUG_MODE_PERIOD = "sendaging";
    public static java.lang.String GPU_RENDERER = "";
    public static java.lang.String GPU_VENDER = "";
    public static final java.lang.String RTD_PERIOD = "period";
    public static final java.lang.String RTD_START_TIME = "startTime";
    static double[] a = null;
    private static java.lang.String b = null;
    private static java.lang.String c = null;
    private static java.lang.String d = null;
    private static int e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static java.lang.String mWrapperType;
    public static java.lang.String mWrapperVersion;
    public static final java.lang.String RTD_SP_FILE = com.umeng.analytics.pro.ay.b().b(com.umeng.analytics.pro.ay.A);
    private static java.lang.Object f = new java.lang.Object();
    private static boolean g = false;
    private static java.lang.String h = "";

    public static void a(android.content.Context context, int i) {
        e = i;
        com.umeng.common.b.a(context).a(e);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.umeng.commonsdk.debug.UMLog.aq(com.umeng.analytics.pro.l.A, 0, "\\|");
        } else {
            d = str;
            com.umeng.common.b.a(context).a(d);
        }
    }

    public static void a(java.lang.String str) {
        c = str;
    }

    public static java.lang.String getAppkey(android.content.Context context) {
        return com.umeng.commonsdk.utils.UMUtils.getAppkey(context);
    }

    public static java.lang.String getChannel(android.content.Context context) {
        return com.umeng.commonsdk.utils.UMUtils.getChannel(context);
    }

    public static java.lang.String getGameSdkVersion(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (java.lang.String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return a;
    }

    public static java.lang.String getRealTimeDebugKey() {
        java.lang.String str;
        synchronized (f) {
            str = h;
        }
        return str;
    }

    public static java.lang.String getSecretKey(android.content.Context context) {
        if (android.text.TextUtils.isEmpty(d)) {
            d = com.umeng.common.b.a(context).c();
        }
        return d;
    }

    public static int getVerticalType(android.content.Context context) {
        if (e == 0) {
            e = com.umeng.common.b.a(context).d();
        }
        return e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f) {
            z = g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f) {
            g = false;
            h = "";
        }
    }

    public static void turnOnRealTimeDebug(java.util.Map<java.lang.String, java.lang.String> map) {
        synchronized (f) {
            g = true;
            if (map != null && map.containsKey("debugkey")) {
                h = map.get("debugkey");
            }
        }
    }
}
