package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public final class Preconditions {
    public Preconditions() {
        throw new java.lang.AssertionError("Cannot use constructor to make a new instance");
    }

    public static boolean a() {
        return android.os.Looper.getMainLooper() == android.os.Looper.myLooper();
    }

    public static void checkArgument(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(android.os.Handler handler) {
        checkHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void checkHandlerThread(android.os.Handler handler, java.lang.String str) {
        if (android.os.Looper.myLooper() != handler.getLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static void checkMainThread(java.lang.String str) {
        if (!a()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static void checkNotMainThread() {
        if (a()) {
            throw new java.lang.IllegalStateException("Must not be called on the main application thread");
        }
    }

    public static <O> O checkNotNull(O o) {
        if (o != null) {
            return o;
        }
        throw new java.lang.NullPointerException("must not refer to a null object");
    }

    public static <O> O checkNotNull(O o, java.lang.Object obj) {
        if (o != null) {
            return o;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static void checkState(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalStateException(java.lang.String.valueOf(obj));
        }
    }
}
