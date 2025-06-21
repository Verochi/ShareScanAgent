package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public class MemoryCacheAdapter implements com.bumptech.glide.load.engine.cache.MemoryCache {
    private com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener listener;

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getCurrentSize() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public long getMaxSize() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<?> put(@androidx.annotation.NonNull com.bumptech.glide.load.Key key, @androidx.annotation.Nullable com.bumptech.glide.load.engine.Resource<?> resource) {
        if (resource == null) {
            return null;
        }
        this.listener.onResourceRemoved(resource);
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<?> remove(@androidx.annotation.NonNull com.bumptech.glide.load.Key key) {
        return null;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(@androidx.annotation.NonNull com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float f) {
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i) {
    }
}
