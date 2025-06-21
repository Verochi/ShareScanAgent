package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    public static int a = 0;
    public static boolean b = true;

    public static java.lang.String a(java.lang.String str, @androidx.annotation.Nullable java.lang.Throwable th) {
        java.lang.String throwableString = getThrowableString(th);
        if (android.text.TextUtils.isEmpty(throwableString)) {
            return str;
        }
        java.lang.String valueOf = java.lang.String.valueOf(str);
        java.lang.String replace = throwableString.replace("\n", "\n  ");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(valueOf.length() + 4 + java.lang.String.valueOf(replace).length());
        sb.append(valueOf);
        sb.append("\n  ");
        sb.append(replace);
        sb.append('\n');
        return sb.toString();
    }

    public static boolean b(@androidx.annotation.Nullable java.lang.Throwable th) {
        while (th != null) {
            if (th instanceof java.net.UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void d(java.lang.String str, java.lang.String str2) {
    }

    public static void d(java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        d(str, a(str2, th));
    }

    public static void e(java.lang.String str, java.lang.String str2) {
    }

    public static void e(java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        e(str, a(str2, th));
    }

    public static int getLogLevel() {
        return a;
    }

    @androidx.annotation.Nullable
    public static java.lang.String getThrowableString(@androidx.annotation.Nullable java.lang.Throwable th) {
        if (th == null) {
            return null;
        }
        return b(th) ? "UnknownHostException (no network)" : !b ? th.getMessage() : android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    public static void i(java.lang.String str, java.lang.String str2) {
    }

    public static void i(java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        i(str, a(str2, th));
    }

    public static void setLogLevel(int i) {
        a = i;
    }

    public static void setLogStackTraces(boolean z) {
        b = z;
    }

    public static void w(java.lang.String str, java.lang.String str2) {
    }

    public static void w(java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.Throwable th) {
        w(str, a(str2, th));
    }

    public boolean getLogStackTraces() {
        return b;
    }
}
