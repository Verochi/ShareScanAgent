package com.bumptech.glide.load.engine.cache;

/* loaded from: classes.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<?> resource);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    @androidx.annotation.Nullable
    com.bumptech.glide.load.engine.Resource<?> put(@androidx.annotation.NonNull com.bumptech.glide.load.Key key, @androidx.annotation.Nullable com.bumptech.glide.load.engine.Resource<?> resource);

    @androidx.annotation.Nullable
    com.bumptech.glide.load.engine.Resource<?> remove(@androidx.annotation.NonNull com.bumptech.glide.load.Key key);

    void setResourceRemovedListener(@androidx.annotation.NonNull com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f);

    void trimMemory(int i);
}
