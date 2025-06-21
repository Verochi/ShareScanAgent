package com.alibaba.sdk.android.oss.common;

/* loaded from: classes.dex */
public class OSSLog {
    private static final java.lang.String TAG = "OSS-Android-SDK";
    private static boolean enableLog;
    private static com.alibaba.sdk.android.oss.common.LogPrinter logPrinter = new com.alibaba.sdk.android.oss.common.DefaultLogPrinter();
    private static com.alibaba.sdk.android.oss.common.LogPrinter nopLogPrinter = new com.alibaba.sdk.android.oss.common.OSSLog.AnonymousClass1();

    /* renamed from: com.alibaba.sdk.android.oss.common.OSSLog$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.alibaba.sdk.android.oss.common.LogPrinter {
        @Override // com.alibaba.sdk.android.oss.common.LogPrinter
        public void log(com.alibaba.sdk.android.oss.common.LogLevel logLevel, java.lang.String str) {
        }
    }

    public static void disableLog() {
        enableLog = false;
    }

    public static void enableLog() {
        enableLog = true;
    }

    public static com.alibaba.sdk.android.oss.common.LogPrinter getLogPrinter() {
        return logPrinter;
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    private static void log2Local(java.lang.String str, boolean z) {
        if (z) {
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getInstance().write(str);
        }
    }

    public static void logDebug(java.lang.String str) {
        logDebug(TAG, str);
    }

    public static void logDebug(java.lang.String str, java.lang.String str2) {
        logDebug(str, str2, true);
    }

    public static void logDebug(java.lang.String str, java.lang.String str2, boolean z) {
        if (enableLog) {
            logPrinter.log(com.alibaba.sdk.android.oss.common.LogLevel.DEBUG, str2);
            log2Local(str2, z);
        }
    }

    public static void logDebug(java.lang.String str, boolean z) {
        logDebug(TAG, str, z);
    }

    public static void logError(java.lang.String str) {
        logError(TAG, str);
    }

    public static void logError(java.lang.String str, java.lang.String str2) {
        logError(str, str2, true);
    }

    public static void logError(java.lang.String str, java.lang.String str2, boolean z) {
        if (enableLog) {
            logPrinter.log(com.alibaba.sdk.android.oss.common.LogLevel.ERROR, str2);
            log2Local(str2, z);
        }
    }

    public static void logError(java.lang.String str, boolean z) {
        logError(TAG, str, z);
    }

    public static void logInfo(java.lang.String str) {
        logInfo(str, true);
    }

    public static void logInfo(java.lang.String str, boolean z) {
        if (enableLog) {
            logPrinter.log(com.alibaba.sdk.android.oss.common.LogLevel.INFO, str);
            log2Local(str, z);
        }
    }

    public static void logThrowable2Local(java.lang.Throwable th) {
        if (enableLog) {
            com.alibaba.sdk.android.oss.common.OSSLogToFileUtils.getInstance().write(th);
        }
    }

    public static void logVerbose(java.lang.String str) {
        logVerbose(str, true);
    }

    public static void logVerbose(java.lang.String str, boolean z) {
        if (enableLog) {
            logPrinter.log(com.alibaba.sdk.android.oss.common.LogLevel.VERBOSE, str);
            log2Local(str, z);
        }
    }

    public static void logWarn(java.lang.String str) {
        logWarn(str, true);
    }

    public static void logWarn(java.lang.String str, boolean z) {
        if (enableLog) {
            logPrinter.log(com.alibaba.sdk.android.oss.common.LogLevel.WARN, str);
            log2Local(str, z);
        }
    }

    public static void setLogPrinter(com.alibaba.sdk.android.oss.common.LogPrinter logPrinter2) {
        if (logPrinter2 == null) {
            logPrinter = nopLogPrinter;
        } else {
            logPrinter = logPrinter2;
        }
    }
}
