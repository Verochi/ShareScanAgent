package com.jd.android.sdk.coreinfo.util;

/* loaded from: classes23.dex */
public class Logger {
    public static boolean D;
    public static boolean E;
    public static boolean I;
    public static boolean W;
    public static boolean printStack;

    public static void d(java.lang.String str, java.lang.String str2) {
    }

    public static void debugWithStackTrace(java.lang.String str, java.lang.String str2) {
        if (D && printStack) {
            getStackTrace();
        }
    }

    public static void e(java.lang.String str, java.lang.String str2) {
    }

    public static void e(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
    }

    public static void enableLogger(boolean z) {
        E = z;
        W = z;
        I = z;
        D = z;
    }

    public static void errorWithStackTrace(java.lang.String str, java.lang.String str2) {
        if (E && printStack) {
            getStackTrace();
        }
    }

    public static java.lang.String getStackTrace() {
        try {
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("stacktrace: \n");
            for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
                sb.append(stackTraceElement.toString());
                sb.append("\n");
            }
            return sb.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static void i(java.lang.String str, java.lang.String str2) {
    }

    public static void infoWithStackTrace(java.lang.String str, java.lang.String str2) {
        if (I && printStack) {
            getStackTrace();
        }
    }

    public static void w(java.lang.String str, java.lang.String str2) {
    }

    public static void warnWithStackTrace(java.lang.String str, java.lang.String str2) {
        if (W && printStack) {
            getStackTrace();
        }
    }
}
