package com.hihonor.push.sdk.utils;

/* loaded from: classes22.dex */
public class Preconditions {
    private Preconditions() {
    }

    public static void assertHandlerThread(android.os.Handler handler) {
        assertHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void assertHandlerThread(android.os.Handler handler, java.lang.String str) {
        if (android.os.Looper.myLooper() != handler.getLooper()) {
            throw new java.lang.IllegalStateException(str);
        }
    }

    public static <O> void checkNotNull(O o) {
        if (o == null) {
            throw new java.lang.NullPointerException("must not refer to a null object");
        }
    }

    public static <O> void checkNotNull(O o, java.lang.String str) {
        if (o == null) {
            throw new java.lang.NullPointerException(str);
        }
    }
}
