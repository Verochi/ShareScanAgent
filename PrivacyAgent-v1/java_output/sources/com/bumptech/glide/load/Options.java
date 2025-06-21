package com.bumptech.glide.load;

/* loaded from: classes.dex */
public final class Options implements com.bumptech.glide.load.Key {
    private final androidx.collection.ArrayMap<com.bumptech.glide.load.Option<?>, java.lang.Object> values = new com.bumptech.glide.util.CachedHashCodeArrayMap();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void updateDiskCacheKey(@androidx.annotation.NonNull com.bumptech.glide.load.Option<T> option, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        option.update(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.Options) {
            return this.values.equals(((com.bumptech.glide.load.Options) obj).values);
        }
        return false;
    }

    @androidx.annotation.Nullable
    public <T> T get(@androidx.annotation.NonNull com.bumptech.glide.load.Option<T> option) {
        return this.values.containsKey(option) ? (T) this.values.get(option) : option.getDefaultValue();
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(@androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        this.values.putAll((androidx.collection.SimpleArrayMap<? extends com.bumptech.glide.load.Option<?>, ? extends java.lang.Object>) options.values);
    }

    @androidx.annotation.NonNull
    public <T> com.bumptech.glide.load.Options set(@androidx.annotation.NonNull com.bumptech.glide.load.Option<T> option, @androidx.annotation.NonNull T t) {
        this.values.put(option, t);
        return this;
    }

    public java.lang.String toString() {
        return "Options{values=" + this.values + '}';
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        for (int i = 0; i < this.values.size(); i++) {
            updateDiskCacheKey(this.values.keyAt(i), this.values.valueAt(i), messageDigest);
        }
    }
}
