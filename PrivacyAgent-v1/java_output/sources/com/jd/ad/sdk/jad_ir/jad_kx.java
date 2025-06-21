package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_kx {
    @androidx.annotation.NonNull
    public static <T> T jad_an(@androidx.annotation.Nullable T t) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException("Argument must not be null");
    }

    @androidx.annotation.NonNull
    public static <T> T jad_an(@androidx.annotation.Nullable T t, @androidx.annotation.NonNull java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(str);
    }

    @androidx.annotation.NonNull
    public static java.lang.String jad_an(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @androidx.annotation.NonNull
    public static <T extends java.util.Collection<Y>, Y> T jad_an(@androidx.annotation.NonNull T t) {
        if (t.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    public static void jad_an(boolean z, @androidx.annotation.NonNull java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }
}
