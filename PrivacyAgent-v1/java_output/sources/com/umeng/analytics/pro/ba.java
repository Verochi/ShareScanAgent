package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ba {
    private static com.umeng.analytics.pro.az a;
    private static boolean b;
    private static java.lang.String c;
    private static com.umeng.analytics.pro.az d;
    private static boolean e;
    private static java.lang.String f;

    public static synchronized java.lang.String a(android.content.Context context) {
        synchronized (com.umeng.analytics.pro.ba.class) {
            if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAID(): oaid开关已关闭。");
                return null;
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context == null) {
                return null;
            }
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                return null;
            }
            a();
            com.umeng.analytics.pro.az azVar = a;
            if (azVar != null) {
                try {
                    java.lang.String a2 = azVar.a(context);
                    c = a2;
                    return a2;
                } catch (java.lang.Throwable unused) {
                }
            }
            return null;
        }
    }

    private static void a() {
        if (a != null || b) {
            return;
        }
        synchronized (com.umeng.analytics.pro.ba.class) {
            if (a == null && !b) {
                a = com.umeng.analytics.pro.bc.a();
                b = true;
            }
        }
    }

    public static synchronized java.lang.String b(android.content.Context context) {
        synchronized (com.umeng.analytics.pro.ba.class) {
            if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getOAIDFromCache(): oaid开关已关闭。");
                return null;
            }
            java.lang.String str = c;
            if (str != null && !android.text.TextUtils.isEmpty(str)) {
                return c;
            }
            return a(context);
        }
    }

    private static void b() {
        if (d != null || e) {
            return;
        }
        synchronized (com.umeng.analytics.pro.ba.class) {
            if (d == null && !e) {
                d = com.umeng.analytics.pro.bc.b();
                e = true;
            }
        }
    }

    public static synchronized java.lang.String c(android.content.Context context) {
        synchronized (com.umeng.analytics.pro.ba.class) {
            if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaid(): oaid开关已关闭。");
                return null;
            }
            if (context == null) {
                return null;
            }
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                return null;
            }
            if (com.umeng.analytics.pro.bm.c()) {
                b();
                com.umeng.analytics.pro.az azVar = d;
                if (azVar != null) {
                    try {
                        java.lang.String a2 = azVar.a(context);
                        f = a2;
                        return a2;
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
            return null;
        }
    }

    public static synchronized java.lang.String d(android.content.Context context) {
        synchronized (com.umeng.analytics.pro.ba.class) {
            if (!com.umeng.commonsdk.UMConfigure.shouldCollectOaid()) {
                com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>>*** OpenDeviceId.getHonorCompatibleOaidFromCache(): oaid开关已关闭。");
                return null;
            }
            java.lang.String str = f;
            if (str != null && !android.text.TextUtils.isEmpty(str)) {
                return f;
            }
            return c(context);
        }
    }
}
