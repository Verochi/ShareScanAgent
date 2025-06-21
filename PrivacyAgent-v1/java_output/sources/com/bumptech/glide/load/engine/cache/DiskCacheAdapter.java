package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public class DiskCacheAdapter implements com.bumptech.glide.load.engine.cache.DiskCache {

    public static final class Factory implements com.bumptech.glide.load.engine.cache.DiskCache.Factory {
        @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
        public com.bumptech.glide.load.engine.cache.DiskCache build() {
            return new com.bumptech.glide.load.engine.cache.DiskCacheAdapter();
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void clear() {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(com.bumptech.glide.load.Key key) {
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public java.io.File get(com.bumptech.glide.load.Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(com.bumptech.glide.load.Key key, com.bumptech.glide.load.engine.cache.DiskCache.Writer writer) {
    }
}
