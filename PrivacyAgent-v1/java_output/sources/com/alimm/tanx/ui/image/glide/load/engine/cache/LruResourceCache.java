package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public class LruResourceCache extends com.alimm.tanx.ui.image.glide.util.LruCache<com.alimm.tanx.ui.image.glide.load.Key, com.alimm.tanx.ui.image.glide.load.engine.Resource<?>> implements com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache {
    private com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener listener;

    public LruResourceCache(int i) {
        super(i);
    }

    @Override // com.alimm.tanx.ui.image.glide.util.LruCache
    public int getSize(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        return resource.getSize();
    }

    @Override // com.alimm.tanx.ui.image.glide.util.LruCache
    public void onItemEvicted(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener resourceRemovedListener = this.listener;
        if (resourceRemovedListener != null) {
            resourceRemovedListener.onResourceRemoved(resource);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ com.alimm.tanx.ui.image.glide.load.engine.Resource put(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.Resource resource) {
        return (com.alimm.tanx.ui.image.glide.load.engine.Resource) super.put((com.alimm.tanx.ui.image.glide.load.engine.cache.LruResourceCache) key, (com.alimm.tanx.ui.image.glide.load.Key) resource);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ com.alimm.tanx.ui.image.glide.load.engine.Resource remove(com.alimm.tanx.ui.image.glide.load.Key key) {
        return (com.alimm.tanx.ui.image.glide.load.engine.Resource) super.remove((com.alimm.tanx.ui.image.glide.load.engine.cache.LruResourceCache) key);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache
    @android.annotation.SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (i >= 60) {
            clearMemory();
        } else if (i >= 40) {
            trimToSize(getCurrentSize() / 2);
        }
    }
}
