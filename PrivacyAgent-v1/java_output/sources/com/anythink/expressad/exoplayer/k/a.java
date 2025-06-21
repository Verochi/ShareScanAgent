package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class a {
    private a() {
    }

    public static int a(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return i;
    }

    public static <T> T a(@androidx.annotation.Nullable T t) {
        t.getClass();
        return t;
    }

    private static <T> T a(@androidx.annotation.Nullable T t, java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    private static java.lang.String a(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        return str;
    }

    private static java.lang.String a(@androidx.annotation.Nullable java.lang.String str, java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
        return str;
    }

    private static void a() {
        if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
            throw new java.lang.IllegalStateException("Not in applications main thread");
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new java.lang.IllegalArgumentException();
        }
    }

    public static void a(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static void b(boolean z) {
        if (!z) {
            throw new java.lang.IllegalStateException();
        }
    }

    public static void b(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }
}
