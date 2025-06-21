package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
class CacheLoader {
    private static final java.lang.String TAG = "CacheLoader";
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache diskCache;

    public CacheLoader(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache diskCache) {
        this.diskCache = diskCache;
    }

    public <Z> com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> load(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, Z> resourceDecoder, int i, int i2) {
        java.io.File file = this.diskCache.get(key);
        com.alimm.tanx.ui.image.glide.load.engine.Resource<Z> resource = null;
        if (file == null) {
            return null;
        }
        try {
            resource = resourceDecoder.decode(file, i, i2);
        } catch (java.io.IOException unused) {
        }
        if (resource == null) {
            this.diskCache.delete(key);
        }
        return resource;
    }
}
