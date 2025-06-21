package com.bumptech.glide;

/* loaded from: classes.dex */
public final class GlideBuilder {
    private com.bumptech.glide.load.engine.executor.GlideExecutor animationExecutor;
    private com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory;

    @androidx.annotation.Nullable
    private java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> defaultRequestListeners;
    private com.bumptech.glide.load.engine.executor.GlideExecutor diskCacheExecutor;
    private com.bumptech.glide.load.engine.cache.DiskCache.Factory diskCacheFactory;
    private com.bumptech.glide.load.engine.Engine engine;
    private boolean isActiveResourceRetentionAllowed;
    private boolean isImageDecoderEnabledForBitmaps;
    private boolean isLoggingRequestOriginsEnabled;
    private com.bumptech.glide.load.engine.cache.MemoryCache memoryCache;
    private com.bumptech.glide.load.engine.cache.MemorySizeCalculator memorySizeCalculator;

    @androidx.annotation.Nullable
    private com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    private com.bumptech.glide.load.engine.executor.GlideExecutor sourceExecutor;
    private final java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> defaultTransitionOptions = new androidx.collection.ArrayMap();
    private int logLevel = 4;
    private com.bumptech.glide.Glide.RequestOptionsFactory defaultRequestOptionsFactory = new com.bumptech.glide.GlideBuilder.AnonymousClass1();

    /* renamed from: com.bumptech.glide.GlideBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements com.bumptech.glide.Glide.RequestOptionsFactory {
        public AnonymousClass1() {
        }

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.request.RequestOptions build() {
            return new com.bumptech.glide.request.RequestOptions();
        }
    }

    /* renamed from: com.bumptech.glide.GlideBuilder$2, reason: invalid class name */
    public class AnonymousClass2 implements com.bumptech.glide.Glide.RequestOptionsFactory {
        final /* synthetic */ com.bumptech.glide.request.RequestOptions val$requestOptions;

        public AnonymousClass2(com.bumptech.glide.request.RequestOptions requestOptions) {
            this.val$requestOptions = requestOptions;
        }

        @Override // com.bumptech.glide.Glide.RequestOptionsFactory
        @androidx.annotation.NonNull
        public com.bumptech.glide.request.RequestOptions build() {
            com.bumptech.glide.request.RequestOptions requestOptions = this.val$requestOptions;
            return requestOptions != null ? requestOptions : new com.bumptech.glide.request.RequestOptions();
        }
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder addGlobalRequestListener(@androidx.annotation.NonNull com.bumptech.glide.request.RequestListener<java.lang.Object> requestListener) {
        if (this.defaultRequestListeners == null) {
            this.defaultRequestListeners = new java.util.ArrayList();
        }
        this.defaultRequestListeners.add(requestListener);
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.Glide build(@androidx.annotation.NonNull android.content.Context context) {
        if (this.sourceExecutor == null) {
            this.sourceExecutor = com.bumptech.glide.load.engine.executor.GlideExecutor.newSourceExecutor();
        }
        if (this.diskCacheExecutor == null) {
            this.diskCacheExecutor = com.bumptech.glide.load.engine.executor.GlideExecutor.newDiskCacheExecutor();
        }
        if (this.animationExecutor == null) {
            this.animationExecutor = com.bumptech.glide.load.engine.executor.GlideExecutor.newAnimationExecutor();
        }
        if (this.memorySizeCalculator == null) {
            this.memorySizeCalculator = new com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder(context).build();
        }
        if (this.connectivityMonitorFactory == null) {
            this.connectivityMonitorFactory = new com.bumptech.glide.manager.DefaultConnectivityMonitorFactory();
        }
        if (this.bitmapPool == null) {
            int bitmapPoolSize = this.memorySizeCalculator.getBitmapPoolSize();
            if (bitmapPoolSize > 0) {
                this.bitmapPool = new com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool(bitmapPoolSize);
            } else {
                this.bitmapPool = new com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter();
            }
        }
        if (this.arrayPool == null) {
            this.arrayPool = new com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool(this.memorySizeCalculator.getArrayPoolSizeInBytes());
        }
        if (this.memoryCache == null) {
            this.memoryCache = new com.bumptech.glide.load.engine.cache.LruResourceCache(this.memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory(context);
        }
        if (this.engine == null) {
            this.engine = new com.bumptech.glide.load.engine.Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, com.bumptech.glide.load.engine.executor.GlideExecutor.newUnlimitedSourceExecutor(), this.animationExecutor, this.isActiveResourceRetentionAllowed);
        }
        java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list = this.defaultRequestListeners;
        if (list == null) {
            this.defaultRequestListeners = java.util.Collections.emptyList();
        } else {
            this.defaultRequestListeners = java.util.Collections.unmodifiableList(list);
        }
        return new com.bumptech.glide.Glide(context, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new com.bumptech.glide.manager.RequestManagerRetriever(this.requestManagerFactory), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptionsFactory, this.defaultTransitionOptions, this.defaultRequestListeners, this.isLoggingRequestOriginsEnabled, this.isImageDecoderEnabledForBitmaps);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setAnimationExecutor(@androidx.annotation.Nullable com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor) {
        this.animationExecutor = glideExecutor;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setArrayPool(@androidx.annotation.Nullable com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setBitmapPool(@androidx.annotation.Nullable com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setConnectivityMonitorFactory(@androidx.annotation.Nullable com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setDefaultRequestOptions(@androidx.annotation.NonNull com.bumptech.glide.Glide.RequestOptionsFactory requestOptionsFactory) {
        this.defaultRequestOptionsFactory = (com.bumptech.glide.Glide.RequestOptionsFactory) com.bumptech.glide.util.Preconditions.checkNotNull(requestOptionsFactory);
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setDefaultRequestOptions(@androidx.annotation.Nullable com.bumptech.glide.request.RequestOptions requestOptions) {
        return setDefaultRequestOptions(new com.bumptech.glide.GlideBuilder.AnonymousClass2(requestOptions));
    }

    @androidx.annotation.NonNull
    public <T> com.bumptech.glide.GlideBuilder setDefaultTransitionOptions(@androidx.annotation.NonNull java.lang.Class<T> cls, @androidx.annotation.Nullable com.bumptech.glide.TransitionOptions<?, T> transitionOptions) {
        this.defaultTransitionOptions.put(cls, transitionOptions);
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setDiskCache(@androidx.annotation.Nullable com.bumptech.glide.load.engine.cache.DiskCache.Factory factory) {
        this.diskCacheFactory = factory;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setDiskCacheExecutor(@androidx.annotation.Nullable com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor) {
        this.diskCacheExecutor = glideExecutor;
        return this;
    }

    public com.bumptech.glide.GlideBuilder setEngine(com.bumptech.glide.load.engine.Engine engine) {
        this.engine = engine;
        return this;
    }

    public com.bumptech.glide.GlideBuilder setImageDecoderEnabledForBitmaps(boolean z) {
        if (!androidx.core.os.BuildCompat.isAtLeastQ()) {
            return this;
        }
        this.isImageDecoderEnabledForBitmaps = z;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setIsActiveResourceRetentionAllowed(boolean z) {
        this.isActiveResourceRetentionAllowed = z;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setLogLevel(int i) {
        if (i < 2 || i > 6) {
            throw new java.lang.IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.logLevel = i;
        return this;
    }

    public com.bumptech.glide.GlideBuilder setLogRequestOrigins(boolean z) {
        this.isLoggingRequestOriginsEnabled = z;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setMemoryCache(@androidx.annotation.Nullable com.bumptech.glide.load.engine.cache.MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setMemorySizeCalculator(@androidx.annotation.NonNull com.bumptech.glide.load.engine.cache.MemorySizeCalculator.Builder builder) {
        return setMemorySizeCalculator(builder.build());
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setMemorySizeCalculator(@androidx.annotation.Nullable com.bumptech.glide.load.engine.cache.MemorySizeCalculator memorySizeCalculator) {
        this.memorySizeCalculator = memorySizeCalculator;
        return this;
    }

    public void setRequestManagerFactory(@androidx.annotation.Nullable com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.requestManagerFactory = requestManagerFactory;
    }

    @java.lang.Deprecated
    public com.bumptech.glide.GlideBuilder setResizeExecutor(@androidx.annotation.Nullable com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor) {
        return setSourceExecutor(glideExecutor);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideBuilder setSourceExecutor(@androidx.annotation.Nullable com.bumptech.glide.load.engine.executor.GlideExecutor glideExecutor) {
        this.sourceExecutor = glideExecutor;
        return this;
    }
}
