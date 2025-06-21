package com.bumptech.glide.provider;

/* loaded from: classes.dex */
public class LoadPathCache {
    private static final com.bumptech.glide.load.engine.LoadPath<?, ?, ?> NO_PATHS_SIGNAL = new com.bumptech.glide.load.engine.LoadPath<>(java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.util.Collections.singletonList(new com.bumptech.glide.load.engine.DecodePath(java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.util.Collections.emptyList(), new com.bumptech.glide.load.resource.transcode.UnitTranscoder(), null)), null);
    private final androidx.collection.ArrayMap<com.bumptech.glide.util.MultiClassKey, com.bumptech.glide.load.engine.LoadPath<?, ?, ?>> cache = new androidx.collection.ArrayMap<>();
    private final java.util.concurrent.atomic.AtomicReference<com.bumptech.glide.util.MultiClassKey> keyRef = new java.util.concurrent.atomic.AtomicReference<>();

    private com.bumptech.glide.util.MultiClassKey getKey(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.Class<?> cls3) {
        com.bumptech.glide.util.MultiClassKey andSet = this.keyRef.getAndSet(null);
        if (andSet == null) {
            andSet = new com.bumptech.glide.util.MultiClassKey();
        }
        andSet.set(cls, cls2, cls3);
        return andSet;
    }

    @androidx.annotation.Nullable
    public <Data, TResource, Transcode> com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> get(java.lang.Class<Data> cls, java.lang.Class<TResource> cls2, java.lang.Class<Transcode> cls3) {
        com.bumptech.glide.load.engine.LoadPath<Data, TResource, Transcode> loadPath;
        com.bumptech.glide.util.MultiClassKey key = getKey(cls, cls2, cls3);
        synchronized (this.cache) {
            loadPath = (com.bumptech.glide.load.engine.LoadPath) this.cache.get(key);
        }
        this.keyRef.set(key);
        return loadPath;
    }

    public boolean isEmptyLoadPath(@androidx.annotation.Nullable com.bumptech.glide.load.engine.LoadPath<?, ?, ?> loadPath) {
        return NO_PATHS_SIGNAL.equals(loadPath);
    }

    public void put(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.Class<?> cls3, @androidx.annotation.Nullable com.bumptech.glide.load.engine.LoadPath<?, ?, ?> loadPath) {
        synchronized (this.cache) {
            androidx.collection.ArrayMap<com.bumptech.glide.util.MultiClassKey, com.bumptech.glide.load.engine.LoadPath<?, ?, ?>> arrayMap = this.cache;
            com.bumptech.glide.util.MultiClassKey multiClassKey = new com.bumptech.glide.util.MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = NO_PATHS_SIGNAL;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
