package com.sina.weibo.sdk.c;

/* loaded from: classes19.dex */
public final class c {
    private static boolean an;

    public static void a(java.lang.String str, java.lang.String str2) {
        if (an) {
            java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            java.lang.String str3 = stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str3);
            sb.append(": ");
            sb.append(str2);
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        if (an) {
            java.lang.StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            java.lang.String str3 = stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str3);
            sb.append(": ");
            sb.append(str2);
        }
    }

    public static void setLoggerEnable(boolean z) {
        an = z;
    }
}
