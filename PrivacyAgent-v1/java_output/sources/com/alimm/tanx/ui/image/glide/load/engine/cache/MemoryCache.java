package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource);
    }

    void clearMemory();

    int getCurrentSize();

    int getMaxSize();

    com.alimm.tanx.ui.image.glide.load.engine.Resource<?> put(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource);

    com.alimm.tanx.ui.image.glide.load.engine.Resource<?> remove(com.alimm.tanx.ui.image.glide.load.Key key);

    void setResourceRemovedListener(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache.ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f);

    void trimMemory(int i);
}
