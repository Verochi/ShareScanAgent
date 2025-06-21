package com.sensorsdata.sf.core.utils;

/* loaded from: classes19.dex */
public class SFLog {
    private static final java.lang.String REGEX = "SensorsFocus.";

    public static void d(java.lang.String str, java.lang.String str2) {
        info(REGEX + str, str2, null);
    }

    public static void d(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        info(REGEX + str, str2, th);
    }

    public static void e(java.lang.String str, java.lang.String str2) {
        e(REGEX + str, str2, null);
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    private static void info(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        try {
            com.sensorsdata.analytics.android.sdk.SALog.i(str, str2, th);
        } catch (java.lang.Exception e) {
            printStackTrace(e);
        }
    }

    public static void printStackTrace(java.lang.Exception exc) {
        com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(exc);
    }
}
