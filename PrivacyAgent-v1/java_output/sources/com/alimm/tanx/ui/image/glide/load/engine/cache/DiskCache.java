package com.alimm.tanx.ui.image.glide.load.engine.cache;

/* loaded from: classes.dex */
public interface DiskCache {

    public interface Factory {
        public static final java.lang.String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
        public static final int DEFAULT_DISK_CACHE_SIZE = 262144000;

        com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache build();
    }

    public interface Writer {
        boolean write(java.io.File file);
    }

    void clear();

    void delete(com.alimm.tanx.ui.image.glide.load.Key key);

    java.io.File get(com.alimm.tanx.ui.image.glide.load.Key key);

    void put(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Writer writer);
}
