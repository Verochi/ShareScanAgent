package com.hihonor.push.sdk.common.logger;

/* loaded from: classes22.dex */
public class Logger {
    private static final boolean LOG = true;
    private static final boolean LOG_D = false;
    private static final boolean LOG_E = true;
    private static final boolean LOG_I = true;
    private static final boolean LOG_V = true;
    private static final boolean LOG_W = true;

    public static void d(java.lang.String str) {
    }

    public static void d(java.lang.String str, java.lang.String str2) {
    }

    public static void d(java.lang.String str, java.lang.Throwable th) {
    }

    public static void e(java.lang.String str) {
        log(getTag(), str, null);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        log(str, str2, th);
    }

    public static void e(java.lang.String str, java.lang.Throwable th) {
        log(getTag(), str, th);
    }

    private static java.lang.String getTag() {
        java.lang.String str;
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str = "";
                break;
            }
            if (!stackTrace[i].getClass().equals(com.hihonor.push.sdk.common.logger.Logger.class)) {
                java.lang.String className = stackTrace[i].getClassName();
                str = className.substring(className.lastIndexOf(46) + 1);
                break;
            }
            i++;
        }
        return "HonorPush_".concat(java.lang.String.valueOf(str));
    }

    public static void i(java.lang.String str) {
        getTag();
    }

    public static void i(java.lang.String str, java.lang.String str2) {
    }

    public static void i(java.lang.String str, java.lang.Throwable th) {
        getTag();
    }

    public static void log(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (str2.length() > 4000) {
            int i = 0;
            while (i < str2.length()) {
                int i2 = i + 4000;
                if (i2 < str2.length()) {
                    str2.substring(i, i2);
                } else {
                    str2.substring(i);
                }
                i = i2;
            }
        }
    }

    public static void v(java.lang.String str) {
        getTag();
    }

    public static void v(java.lang.String str, java.lang.String str2) {
    }

    public static void v(java.lang.String str, java.lang.Throwable th) {
        getTag();
    }

    public static void w(java.lang.String str) {
        getTag();
    }

    public static void w(java.lang.String str, java.lang.String str2) {
    }

    public static void w(java.lang.String str, java.lang.Throwable th) {
        getTag();
    }
}
