package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public final class Assertions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static int checkIndex(int i, int i2, int i3) {
        if (i < i2 || i >= i3) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return i;
    }

    public static void checkMainThread() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Not in applications main thread");
        }
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static java.lang.String checkNotEmpty(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return str;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static java.lang.String checkNotEmpty(@androidx.annotation.Nullable java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return str;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t) {
        t.getClass();
        return t;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t, java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static void checkState(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T> T checkStateNotNull(@androidx.annotation.Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.IllegalStateException();
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"#1"})
    public static <T> T checkStateNotNull(@androidx.annotation.Nullable T t, java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
    }
}
