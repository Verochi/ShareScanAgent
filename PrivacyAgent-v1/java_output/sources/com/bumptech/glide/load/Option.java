package com.bumptech.glide.load;

/* loaded from: classes.dex */
public final class Option<T> {
    private static final com.bumptech.glide.load.Option.CacheKeyUpdater<java.lang.Object> EMPTY_UPDATER = new com.bumptech.glide.load.Option.AnonymousClass1();
    private final com.bumptech.glide.load.Option.CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final java.lang.String key;
    private volatile byte[] keyBytes;

    /* renamed from: com.bumptech.glide.load.Option$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.load.Option.CacheKeyUpdater<java.lang.Object> {
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        }
    }

    public interface CacheKeyUpdater<T> {
        void update(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull T t, @androidx.annotation.NonNull java.security.MessageDigest messageDigest);
    }

    private Option(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable T t, @androidx.annotation.NonNull com.bumptech.glide.load.Option.CacheKeyUpdater<T> cacheKeyUpdater) {
        this.key = com.bumptech.glide.util.Preconditions.checkNotEmpty(str);
        this.defaultValue = t;
        this.cacheKeyUpdater = (com.bumptech.glide.load.Option.CacheKeyUpdater) com.bumptech.glide.util.Preconditions.checkNotNull(cacheKeyUpdater);
    }

    @androidx.annotation.NonNull
    public static <T> com.bumptech.glide.load.Option<T> disk(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.bumptech.glide.load.Option.CacheKeyUpdater<T> cacheKeyUpdater) {
        return new com.bumptech.glide.load.Option<>(str, null, cacheKeyUpdater);
    }

    @androidx.annotation.NonNull
    public static <T> com.bumptech.glide.load.Option<T> disk(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable T t, @androidx.annotation.NonNull com.bumptech.glide.load.Option.CacheKeyUpdater<T> cacheKeyUpdater) {
        return new com.bumptech.glide.load.Option<>(str, t, cacheKeyUpdater);
    }

    @androidx.annotation.NonNull
    private static <T> com.bumptech.glide.load.Option.CacheKeyUpdater<T> emptyUpdater() {
        return (com.bumptech.glide.load.Option.CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    @androidx.annotation.NonNull
    private byte[] getKeyBytes() {
        if (this.keyBytes == null) {
            this.keyBytes = this.key.getBytes(com.bumptech.glide.load.Key.CHARSET);
        }
        return this.keyBytes;
    }

    @androidx.annotation.NonNull
    public static <T> com.bumptech.glide.load.Option<T> memory(@androidx.annotation.NonNull java.lang.String str) {
        return new com.bumptech.glide.load.Option<>(str, null, emptyUpdater());
    }

    @androidx.annotation.NonNull
    public static <T> com.bumptech.glide.load.Option<T> memory(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull T t) {
        return new com.bumptech.glide.load.Option<>(str, t, emptyUpdater());
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.bumptech.glide.load.Option) {
            return this.key.equals(((com.bumptech.glide.load.Option) obj).key);
        }
        return false;
    }

    @androidx.annotation.Nullable
    public T getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public java.lang.String toString() {
        return "Option{key='" + this.key + "'}";
    }

    public void update(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.cacheKeyUpdater.update(getKeyBytes(), t, messageDigest);
    }
}
