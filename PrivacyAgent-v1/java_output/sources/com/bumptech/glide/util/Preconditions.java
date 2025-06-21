package com.bumptech.glide.util;

/* loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z, @androidx.annotation.NonNull java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(str);
        }
    }

    @androidx.annotation.NonNull
    public static java.lang.String checkNotEmpty(@androidx.annotation.Nullable java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @androidx.annotation.NonNull
    public static <T extends java.util.Collection<Y>, Y> T checkNotEmpty(@androidx.annotation.NonNull T t) {
        if (t.isEmpty()) {
            throw new java.lang.IllegalArgumentException("Must not be empty.");
        }
        return t;
    }

    @androidx.annotation.NonNull
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t) {
        return (T) checkNotNull(t, "Argument must not be null");
    }

    @androidx.annotation.NonNull
    public static <T> T checkNotNull(@androidx.annotation.Nullable T t, @androidx.annotation.NonNull java.lang.String str) {
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException(str);
    }
}
