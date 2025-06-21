package com.bumptech.glide.provider;

/* loaded from: classes.dex */
public class ModelToResourceClassCache {
    private final java.util.concurrent.atomic.AtomicReference<com.bumptech.glide.util.MultiClassKey> resourceClassKeyRef = new java.util.concurrent.atomic.AtomicReference<>();
    private final androidx.collection.ArrayMap<com.bumptech.glide.util.MultiClassKey, java.util.List<java.lang.Class<?>>> registeredResourceClassCache = new androidx.collection.ArrayMap<>();

    public void clear() {
        synchronized (this.registeredResourceClassCache) {
            this.registeredResourceClassCache.clear();
        }
    }

    @androidx.annotation.Nullable
    public java.util.List<java.lang.Class<?>> get(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2, @androidx.annotation.NonNull java.lang.Class<?> cls3) {
        java.util.List<java.lang.Class<?>> list;
        com.bumptech.glide.util.MultiClassKey andSet = this.resourceClassKeyRef.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.util.MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.set(cls, cls2, cls3);
        }
        synchronized (this.registeredResourceClassCache) {
            list = this.registeredResourceClassCache.get(andSet);
        }
        this.resourceClassKeyRef.set(andSet);
        return list;
    }

    public void put(@androidx.annotation.NonNull java.lang.Class<?> cls, @androidx.annotation.NonNull java.lang.Class<?> cls2, @androidx.annotation.NonNull java.lang.Class<?> cls3, @androidx.annotation.NonNull java.util.List<java.lang.Class<?>> list) {
        synchronized (this.registeredResourceClassCache) {
            this.registeredResourceClassCache.put(new com.bumptech.glide.util.MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
