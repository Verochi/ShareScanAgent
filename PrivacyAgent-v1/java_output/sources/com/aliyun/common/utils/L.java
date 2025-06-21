package com.aliyun.common.utils;

/* loaded from: classes.dex */
public final class L {
    private static volatile boolean DISABLED = false;
    private static final java.lang.String LOG_FORMAT = "%1$s\n%2$s";

    private L() {
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        log(3, null, str, objArr);
    }

    public static void disableLogging() {
        DISABLED = true;
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        log(6, null, str, objArr);
    }

    public static void e(java.lang.Throwable th) {
        log(6, th, null, new java.lang.Object[0]);
    }

    public static void e(java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        log(6, th, str, objArr);
    }

    public static void enableLogging() {
        DISABLED = false;
    }

    public static void i(java.lang.String str, java.lang.Object... objArr) {
        log(4, null, str, objArr);
    }

    private static void log(int i, java.lang.Throwable th, java.lang.String str, java.lang.Object... objArr) {
        if (DISABLED) {
            return;
        }
        if (objArr.length > 0) {
            str = java.lang.String.format(str, objArr);
        }
        if (th != null) {
            if (str == null) {
                str = th.getMessage();
            }
            str = java.lang.String.format(LOG_FORMAT, str, android.util.Log.getStackTraceString(th));
        }
        android.util.Log.println(i, "VideoLoader", str);
    }

    public static void w(java.lang.String str, java.lang.Object... objArr) {
        log(5, null, str, objArr);
    }
}
