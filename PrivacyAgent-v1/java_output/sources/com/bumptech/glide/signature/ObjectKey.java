package com.bumptech.glide.signature;

/* loaded from: classes.dex */
public final class ObjectKey implements com.bumptech.glide.load.Key {
    private final java.lang.Object object;

    public ObjectKey(@androidx.annotation.NonNull java.lang.Object obj) {
        this.object = com.bumptech.glide.util.Preconditions.checkNotNull(obj);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.signature.ObjectKey) {
            return this.object.equals(((com.bumptech.glide.signature.ObjectKey) obj).object);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.object.hashCode();
    }

    public java.lang.String toString() {
        return "ObjectKey{object=" + this.object + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        messageDigest.update(this.object.toString().getBytes(com.bumptech.glide.load.Key.CHARSET));
    }
}
