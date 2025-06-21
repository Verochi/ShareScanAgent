package com.bumptech.glide.signature;

/* loaded from: classes.dex */
public final class EmptySignature implements com.bumptech.glide.load.Key {
    private static final com.bumptech.glide.signature.EmptySignature EMPTY_KEY = new com.bumptech.glide.signature.EmptySignature();

    private EmptySignature() {
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.signature.EmptySignature obtain() {
        return EMPTY_KEY;
    }

    public java.lang.String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
    }
}
