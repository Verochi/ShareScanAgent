package com.airbnb.lottie;

/* loaded from: classes.dex */
public final class LottieResult<V> {

    @androidx.annotation.Nullable
    public final V a;

    @androidx.annotation.Nullable
    public final java.lang.Throwable b;

    public LottieResult(V v) {
        this.a = v;
        this.b = null;
    }

    public LottieResult(java.lang.Throwable th) {
        this.b = th;
        this.a = null;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.airbnb.lottie.LottieResult)) {
            return false;
        }
        com.airbnb.lottie.LottieResult lottieResult = (com.airbnb.lottie.LottieResult) obj;
        if (getValue() != null && getValue().equals(lottieResult.getValue())) {
            return true;
        }
        if (getException() == null || lottieResult.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    @androidx.annotation.Nullable
    public java.lang.Throwable getException() {
        return this.b;
    }

    @androidx.annotation.Nullable
    public V getValue() {
        return this.a;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{getValue(), getException()});
    }
}
