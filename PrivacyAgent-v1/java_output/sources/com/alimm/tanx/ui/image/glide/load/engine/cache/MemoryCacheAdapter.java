package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public class MemoryCacheAdapter implements com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache {
    private com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener listener;

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void clearMemory() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public int getCurrentSize() {
        return 0;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public int getMaxSize() {
        return 0;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<?> put(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        this.listener.onResourceRemoved(resource);
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<?> remove(com.alimm.tanx.ui.image.glide.load.Key key) {
        return null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void setSizeMultiplier(float f) {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i) {
    }
}
