package com.huawei.hms.utils;

/* loaded from: classes22.dex */
public final class Checker {
    public static void assertHandlerThread(android.os.Handler handler) {
        assertHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void assertHandlerThread(android.os.Handler handler, java.lang.String str) {
        if (android.os.Looper.myLooper() != handler.getLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static void assertNonEmpty(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalStateException("Given String is empty or null");
        }
    }

    public static void assertNonEmpty(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(str2));
        }
    }

    public static <T> T assertNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException("Null reference");
    }

    public static <T> T assertNonNull(T t, java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(str));
    }

    public static void assertNotUiThread(java.lang.String str) {
        if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static void assertUiThread(java.lang.String str) {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static java.lang.String checkNonEmpty(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static java.lang.String checkNonEmpty(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(str2));
        }
        return str;
    }

    public static <T> T checkNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException("Null reference");
    }

    public static <T> T checkNonNull(T t, java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(str));
    }

    public static int checkNonZero(int i) {
        if (i != 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException("Given Integer is zero");
    }

    public static int checkNonZero(int i, java.lang.String str) {
        if (i != 0) {
            return i;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(str));
    }

    public static long checkNotZero(long j) {
        if (j != 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException("Given Long is zero");
    }

    public static long checkNotZero(long j, java.lang.String str) {
        if (j != 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(str));
    }
}
