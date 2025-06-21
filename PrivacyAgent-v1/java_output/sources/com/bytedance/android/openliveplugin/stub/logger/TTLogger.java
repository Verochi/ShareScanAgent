package com.bytedance.android.openliveplugin.stub.logger;

/* loaded from: classes.dex */
public class TTLogger {
    private static boolean DEBUG = false;
    private static final java.lang.String TAG = "TTLiveLogger";
    private static int sLevel = 4;

    public static void d(java.lang.String str) {
        if (DEBUG) {
            d(TAG, str);
        }
    }

    public static void d(java.lang.String str, java.lang.String str2) {
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void d(java.lang.String str, java.lang.Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 3) {
            formatMsgs(objArr);
        }
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    public static void e(java.lang.String str) {
        if (DEBUG) {
            e(TAG, str);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void e(java.lang.String str, java.lang.Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 6) {
            formatMsgs(objArr);
        }
    }

    private static java.lang.String formatMsgs(java.lang.Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            java.lang.Object obj = objArr[i];
            sb.append(obj != null ? obj.toString() : " null ");
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int getLogLevel() {
        return sLevel;
    }

    private static java.lang.String getSimpleClassName(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? str : str.substring(lastIndexOf + 1);
    }

    public static void i(java.lang.String str) {
        if (DEBUG) {
            i(TAG, str);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
    }

    public static void i(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void i(java.lang.String str, java.lang.Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 4) {
            formatMsgs(objArr);
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logDirect(java.lang.String str, java.lang.String str2) {
    }

    public static void openDebugMode() {
        DEBUG = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    public static void st(java.lang.String str, int i) {
        try {
            throw new java.lang.Exception();
        } catch (java.lang.Exception e) {
            java.lang.StackTraceElement[] stackTrace = e.getStackTrace();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i2 = 1; i2 < java.lang.Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append("\n");
                }
                sb.append(getSimpleClassName(stackTrace[i2].getClassName()));
                sb.append(".");
                sb.append(stackTrace[i2].getMethodName());
            }
            v(str, sb.toString());
        }
    }

    public static void v(java.lang.String str) {
        v(TAG, str);
    }

    public static void v(java.lang.String str, java.lang.String str2) {
    }

    public static void v(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void v(java.lang.String str, java.lang.Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 2) {
            formatMsgs(objArr);
        }
    }

    public static void w(java.lang.String str) {
        if (DEBUG) {
            w(TAG, str);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
    }

    public static void w(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void w(java.lang.String str, java.lang.Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 5) {
            formatMsgs(objArr);
        }
    }
}
