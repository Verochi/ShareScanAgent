package com.umeng.commonsdk.debug;

/* loaded from: classes19.dex */
public class UMRTLog {
    private static final java.lang.String RTLOG_ENABLE = "1";
    private static final java.lang.String RTLOG_PROP = "debug.umeng.rtlog";
    public static final java.lang.String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    public static void d(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void sd(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void se(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void si(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void sv(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void sw(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void v(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
        if (com.umeng.commonsdk.UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    private static java.lang.String warpperMsg(java.lang.String str, boolean z) {
        java.lang.StringBuffer stringBuffer;
        if (!z) {
            return str;
        }
        try {
            java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
            if (stackTrace.length >= 3) {
                java.lang.String fileName = stackTrace[2].getFileName();
                java.lang.String methodName = stackTrace[2].getMethodName();
                int lineNumber = stackTrace[2].getLineNumber();
                stringBuffer = new java.lang.StringBuffer();
                stringBuffer.append("<");
                stringBuffer.append(fileName);
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                stringBuffer.append(methodName);
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                stringBuffer.append(lineNumber);
                stringBuffer.append("> ");
                stringBuffer.append(str);
            } else {
                stringBuffer = null;
            }
            return stringBuffer.toString();
        } catch (java.lang.Throwable unused) {
            return str;
        }
    }
}
