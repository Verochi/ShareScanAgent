package com.aliyun.common.log.debuglog;

/* loaded from: classes.dex */
public class AlivcSvideoLog {
    private static final int STACK_TRACE = 5;

    public static void d(java.lang.String str, java.lang.String str2) {
        normalLog(3, str, str2);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        normalLog(6, str, str2);
    }

    private static java.lang.String getFileName() {
        java.lang.StackTraceElement stackTrace = getStackTrace();
        return stackTrace != null ? java.lang.String.valueOf(stackTrace.getFileName()) : "";
    }

    private static java.lang.String getLineNumber() {
        java.lang.StackTraceElement stackTrace = getStackTrace();
        return stackTrace != null ? java.lang.String.valueOf(stackTrace.getLineNumber()) : "";
    }

    private static java.lang.StackTraceElement getStackTrace() {
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
        if (stackTrace.length < 5) {
            return null;
        }
        return stackTrace[5];
    }

    private static java.lang.String getSystemMsg() {
        return "[" + getFileName() + " " + getLineNumber() + "]";
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        normalLog(4, str, str2);
    }

    private static java.lang.String normalLog(int i, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = getSystemMsg() + str2;
        android.util.Log.println(i, str, str3);
        return str3;
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        normalLog(2, str, str2);
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        normalLog(5, str, str2);
    }
}
