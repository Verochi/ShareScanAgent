package com.meizu.cloud.pushsdk.d.f;

/* loaded from: classes23.dex */
public final class d {
    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static <T> T a(T t, java.lang.Object obj) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(java.lang.String.valueOf(obj));
    }

    public static void a(boolean z, java.lang.Object obj) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(obj));
        }
    }
}
