package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class GlideBuilder {
    private com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final android.content.Context context;
    private com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat;
    private com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory diskCacheFactory;
    private java.util.concurrent.ExecutorService diskCacheService;
    private com.alimm.tanx.ui.image.glide.load.engine.Engine engine;
    private com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache;
    private java.util.concurrent.ExecutorService sourceService;

    /* renamed from: com.alimm.tanx.ui.image.glide.GlideBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory {
        final /* synthetic */ com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache val$diskCache;

        public AnonymousClass1(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache diskCache) {
            this.val$diskCache = diskCache;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
        public com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache build() {
            return this.val$diskCache;
        }
    }

    public GlideBuilder(android.content.Context context) {
        this.context = context.getApplicationContext();
    }

    public com.alimm.tanx.ui.image.glide.Glide createGlide() {
        if (this.sourceService == null) {
            this.sourceService = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor(java.lang.Math.max(1, java.lang.Runtime.getRuntime().availableProcessors()));
        }
        if (this.diskCacheService == null) {
            this.diskCacheService = new com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor(1);
        }
        com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator memorySizeCalculator = new com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator(this.context);
        if (this.bitmapPool == null) {
            this.bitmapPool = new com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool(memorySizeCalculator.getBitmapPoolSize());
        }
        if (this.memoryCache == null) {
            this.memoryCache = new com.alimm.tanx.ui.image.glide.load.engine.cache.LruResourceCache(memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new com.alimm.tanx.ui.image.glide.load.engine.cache.InternalCacheDiskCacheFactory(this.context);
        }
        if (this.engine == null) {
            this.engine = new com.alimm.tanx.ui.image.glide.load.engine.Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheService, this.sourceService);
        }
        if (this.decodeFormat == null) {
            this.decodeFormat = com.alimm.tanx.ui.image.glide.load.DecodeFormat.DEFAULT;
        }
        return new com.alimm.tanx.ui.image.glide.Glide(this.engine, this.memoryCache, this.bitmapPool, this.context, this.decodeFormat);
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setBitmapPool(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setDecodeFormat(com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setDiskCache(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory factory) {
        this.diskCacheFactory = factory;
        return this;
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.GlideBuilder setDiskCache(com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache diskCache) {
        return setDiskCache(new com.alimm.tanx.ui.image.glide.GlideBuilder.AnonymousClass1(diskCache));
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setDiskCacheService(java.util.concurrent.ExecutorService executorService) {
        this.diskCacheService = executorService;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setEngine(com.alimm.tanx.ui.image.glide.load.engine.Engine engine) {
        this.engine = engine;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setMemoryCache(com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GlideBuilder setResizeService(java.util.concurrent.ExecutorService executorService) {
        this.sourceService = executorService;
        return this;
    }
}
