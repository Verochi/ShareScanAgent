package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class Glide {
    private static final java.lang.String TAG = "Glide";
    private static volatile com.alimm.tanx.ui.image.glide.Glide glide = null;
    private static boolean modulesEnabled = true;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.CenterCrop bitmapCenterCrop;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.FitCenter bitmapFitCenter;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private final com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFiller bitmapPreFiller;
    private final com.alimm.tanx.ui.image.glide.provider.DataLoadProviderRegistry dataLoadProviderRegistry;
    private final com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat;
    private final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation drawableCenterCrop;
    private final com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation drawableFitCenter;
    private final com.alimm.tanx.ui.image.glide.load.engine.Engine engine;
    private final com.alimm.tanx.ui.image.glide.request.target.ImageViewTargetFactory imageViewTargetFactory = new com.alimm.tanx.ui.image.glide.request.target.ImageViewTargetFactory();
    private final com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory loaderFactory;
    private final android.os.Handler mainHandler;
    private final com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache;
    private final com.alimm.tanx.ui.image.glide.load.resource.transcode.TranscoderRegistry transcoderRegistry;

    public static class ClearTarget extends com.alimm.tanx.ui.image.glide.request.target.ViewTarget<android.view.View, java.lang.Object> {
        public ClearTarget(android.view.View view) {
            super(view);
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadCleared(android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadFailed(java.lang.Exception exc, android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.BaseTarget, com.alimm.tanx.ui.image.glide.request.target.Target
        public void onLoadStarted(android.graphics.drawable.Drawable drawable) {
        }

        @Override // com.alimm.tanx.ui.image.glide.request.target.Target
        public void onResourceReady(java.lang.Object obj, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimation<? super java.lang.Object> glideAnimation) {
        }
    }

    public Glide(com.alimm.tanx.ui.image.glide.load.engine.Engine engine, com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache memoryCache, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, android.content.Context context, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        com.alimm.tanx.ui.image.glide.load.resource.transcode.TranscoderRegistry transcoderRegistry = new com.alimm.tanx.ui.image.glide.load.resource.transcode.TranscoderRegistry();
        this.transcoderRegistry = transcoderRegistry;
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.decodeFormat = decodeFormat;
        this.loaderFactory = new com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory(context);
        this.mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
        this.bitmapPreFiller = new com.alimm.tanx.ui.image.glide.load.engine.prefill.BitmapPreFiller(memoryCache, bitmapPool, decodeFormat);
        com.alimm.tanx.ui.image.glide.provider.DataLoadProviderRegistry dataLoadProviderRegistry = new com.alimm.tanx.ui.image.glide.provider.DataLoadProviderRegistry();
        this.dataLoadProviderRegistry = dataLoadProviderRegistry;
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDataLoadProvider streamBitmapDataLoadProvider = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDataLoadProvider(bitmapPool, decodeFormat);
        dataLoadProviderRegistry.register(java.io.InputStream.class, android.graphics.Bitmap.class, streamBitmapDataLoadProvider);
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider fileDescriptorBitmapDataLoadProvider = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider(bitmapPool, decodeFormat);
        dataLoadProviderRegistry.register(android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, fileDescriptorBitmapDataLoadProvider);
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoDataLoadProvider imageVideoDataLoadProvider = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoDataLoadProvider(streamBitmapDataLoadProvider, fileDescriptorBitmapDataLoadProvider);
        dataLoadProviderRegistry.register(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper.class, android.graphics.Bitmap.class, imageVideoDataLoadProvider);
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableLoadProvider gifDrawableLoadProvider = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableLoadProvider(context, bitmapPool);
        dataLoadProviderRegistry.register(java.io.InputStream.class, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.class, gifDrawableLoadProvider);
        dataLoadProviderRegistry.register(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper.class, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper.class, new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider(imageVideoDataLoadProvider, gifDrawableLoadProvider, bitmapPool));
        dataLoadProviderRegistry.register(java.io.InputStream.class, java.io.File.class, new com.alimm.tanx.ui.image.glide.load.resource.file.StreamFileDataLoadProvider());
        register(java.io.File.class, android.os.ParcelFileDescriptor.class, new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorFileLoader.Factory());
        register(java.io.File.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamFileLoader.Factory());
        java.lang.Class cls = java.lang.Integer.TYPE;
        register(cls, android.os.ParcelFileDescriptor.class, new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorResourceLoader.Factory());
        register(cls, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamResourceLoader.Factory());
        register(java.lang.Integer.class, android.os.ParcelFileDescriptor.class, new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorResourceLoader.Factory());
        register(java.lang.Integer.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamResourceLoader.Factory());
        register(java.lang.String.class, android.os.ParcelFileDescriptor.class, new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorStringLoader.Factory());
        register(java.lang.String.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamStringLoader.Factory());
        register(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.alimm.tanx.ui.image.glide.load.model.file_descriptor.FileDescriptorUriLoader.Factory());
        register(android.net.Uri.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamUriLoader.Factory());
        register(java.net.URL.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamUrlLoader.Factory());
        register(com.alimm.tanx.ui.image.glide.load.model.GlideUrl.class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.HttpUrlGlideUrlLoader.Factory());
        register(byte[].class, java.io.InputStream.class, new com.alimm.tanx.ui.image.glide.load.model.stream.StreamByteArrayLoader.Factory());
        transcoderRegistry.register(android.graphics.Bitmap.class, com.alimm.tanx.ui.image.glide.load.resource.bitmap.GlideBitmapDrawable.class, new com.alimm.tanx.ui.image.glide.load.resource.transcode.GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool));
        transcoderRegistry.register(com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper.class, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable.class, new com.alimm.tanx.ui.image.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder(new com.alimm.tanx.ui.image.glide.load.resource.transcode.GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool)));
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.CenterCrop centerCrop = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.CenterCrop(bitmapPool);
        this.bitmapCenterCrop = centerCrop;
        this.drawableCenterCrop = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation(bitmapPool, centerCrop);
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.FitCenter fitCenter = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.FitCenter(bitmapPool);
        this.bitmapFitCenter = fitCenter;
        this.drawableFitCenter = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation(bitmapPool, fitCenter);
    }

    public static <T> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, android.os.ParcelFileDescriptor> buildFileDescriptorModelLoader(java.lang.Class<T> cls, android.content.Context context) {
        return buildModelLoader((java.lang.Class) cls, android.os.ParcelFileDescriptor.class, context);
    }

    public static <T> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, android.os.ParcelFileDescriptor> buildFileDescriptorModelLoader(T t, android.content.Context context) {
        return buildModelLoader(t, android.os.ParcelFileDescriptor.class, context);
    }

    public static <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> buildModelLoader(java.lang.Class<T> cls, java.lang.Class<Y> cls2, android.content.Context context) {
        if (cls == null) {
            return null;
        }
        return get(context).loaderFactory.buildModelLoader(cls, cls2);
    }

    public static <T, Y> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, Y> buildModelLoader(T t, java.lang.Class<Y> cls, android.content.Context context) {
        return buildModelLoader((java.lang.Class) (t != null ? t.getClass() : null), (java.lang.Class) cls, context);
    }

    public static <T> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, java.io.InputStream> buildStreamModelLoader(java.lang.Class<T> cls, android.content.Context context) {
        return buildModelLoader((java.lang.Class) cls, java.io.InputStream.class, context);
    }

    public static <T> com.alimm.tanx.ui.image.glide.load.model.ModelLoader<T, java.io.InputStream> buildStreamModelLoader(T t, android.content.Context context) {
        return buildModelLoader(t, java.io.InputStream.class, context);
    }

    public static void clear(android.view.View view) {
        clear(new com.alimm.tanx.ui.image.glide.Glide.ClearTarget(view));
    }

    public static void clear(com.alimm.tanx.ui.image.glide.request.FutureTarget<?> futureTarget) {
        futureTarget.clear();
    }

    public static void clear(com.alimm.tanx.ui.image.glide.request.target.Target<?> target) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        com.alimm.tanx.ui.image.glide.request.Request request = target.getRequest();
        if (request != null) {
            request.clear();
            target.setRequest(null);
        }
    }

    public static com.alimm.tanx.ui.image.glide.Glide get(android.content.Context context) {
        if (glide == null) {
            synchronized (com.alimm.tanx.ui.image.glide.Glide.class) {
                if (glide == null) {
                    android.content.Context applicationContext = context.getApplicationContext();
                    com.alimm.tanx.ui.image.glide.GlideBuilder glideBuilder = new com.alimm.tanx.ui.image.glide.GlideBuilder(applicationContext);
                    java.util.List<com.alimm.tanx.ui.image.glide.module.GlideModule> parseGlideModules = parseGlideModules(applicationContext);
                    java.util.Iterator<com.alimm.tanx.ui.image.glide.module.GlideModule> it = parseGlideModules.iterator();
                    while (it.hasNext()) {
                        it.next().applyOptions(applicationContext, glideBuilder);
                    }
                    glide = glideBuilder.createGlide();
                    java.util.Iterator<com.alimm.tanx.ui.image.glide.module.GlideModule> it2 = parseGlideModules.iterator();
                    while (it2.hasNext()) {
                        it2.next().registerComponents(applicationContext, glide);
                    }
                }
            }
        }
        return glide;
    }

    private com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory getLoaderFactory() {
        return this.loaderFactory;
    }

    public static java.io.File getPhotoCacheDir(android.content.Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    public static java.io.File getPhotoCacheDir(android.content.Context context, java.lang.String str) {
        java.io.File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        java.io.File file = new java.io.File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    @java.lang.Deprecated
    public static boolean isSetup() {
        return glide != null;
    }

    private static java.util.List<com.alimm.tanx.ui.image.glide.module.GlideModule> parseGlideModules(android.content.Context context) {
        return modulesEnabled ? new com.alimm.tanx.ui.image.glide.module.ManifestParser(context).parse() : java.util.Collections.emptyList();
    }

    public static void setModulesEnabled(boolean z) {
        synchronized (com.alimm.tanx.ui.image.glide.Glide.class) {
            if (glide != null) {
                throw new java.lang.IllegalArgumentException("Glide singleton already exists.");
            }
            modulesEnabled = z;
        }
    }

    @java.lang.Deprecated
    public static void setup(com.alimm.tanx.ui.image.glide.GlideBuilder glideBuilder) {
        if (isSetup()) {
            throw new java.lang.IllegalArgumentException("Glide is already setup, check with isSetup() first");
        }
        glide = glideBuilder.createGlide();
    }

    public static void tearDown() {
        glide = null;
        modulesEnabled = true;
    }

    public static com.alimm.tanx.ui.image.glide.RequestManager with(android.app.Activity activity) {
        return com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().get(activity);
    }

    @android.annotation.TargetApi(11)
    public static com.alimm.tanx.ui.image.glide.RequestManager with(android.app.Fragment fragment) {
        return com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().get(fragment);
    }

    public static com.alimm.tanx.ui.image.glide.RequestManager with(android.content.Context context) {
        return com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().get(context);
    }

    public static com.alimm.tanx.ui.image.glide.RequestManager with(androidx.fragment.app.Fragment fragment) {
        return com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().get(fragment);
    }

    public static com.alimm.tanx.ui.image.glide.RequestManager with(androidx.fragment.app.FragmentActivity fragmentActivity) {
        return com.alimm.tanx.ui.image.glide.manager.RequestManagerRetriever.get().get(fragmentActivity);
    }

    public <T, Z> com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<T, Z> buildDataProvider(java.lang.Class<T> cls, java.lang.Class<Z> cls2) {
        return this.dataLoadProviderRegistry.get(cls, cls2);
    }

    public <R> com.alimm.tanx.ui.image.glide.request.target.Target<R> buildImageViewTarget(android.widget.ImageView imageView, java.lang.Class<R> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    public <Z, R> com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> buildTranscoder(java.lang.Class<Z> cls, java.lang.Class<R> cls2) {
        return this.transcoderRegistry.get(cls, cls2);
    }

    public void clearDiskCache() {
        com.alimm.tanx.ui.image.glide.util.Util.assertBackgroundThread();
        getEngine().clearDiskCache();
    }

    public void clearMemory() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
    }

    public com.alimm.tanx.ui.image.glide.load.resource.bitmap.CenterCrop getBitmapCenterCrop() {
        return this.bitmapCenterCrop;
    }

    public com.alimm.tanx.ui.image.glide.load.resource.bitmap.FitCenter getBitmapFitCenter() {
        return this.bitmapFitCenter;
    }

    public com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public com.alimm.tanx.ui.image.glide.load.DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    public com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation getDrawableCenterCrop() {
        return this.drawableCenterCrop;
    }

    public com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation getDrawableFitCenter() {
        return this.drawableFitCenter;
    }

    public com.alimm.tanx.ui.image.glide.load.engine.Engine getEngine() {
        return this.engine;
    }

    public android.os.Handler getMainHandler() {
        return this.mainHandler;
    }

    public void preFillBitmapPool(com.alimm.tanx.ui.image.glide.load.engine.prefill.PreFillType.Builder... builderArr) {
        this.bitmapPreFiller.preFill(builderArr);
    }

    public <T, Y> void register(java.lang.Class<T> cls, java.lang.Class<Y> cls2, com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> modelLoaderFactory) {
        com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> register = this.loaderFactory.register(cls, cls2, modelLoaderFactory);
        if (register != null) {
            register.teardown();
        }
    }

    public void setMemoryCategory(com.alimm.tanx.ui.image.glide.MemoryCategory memoryCategory) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
    }

    public void trimMemory(int i) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        this.memoryCache.trimMemory(i);
        this.bitmapPool.trimMemory(i);
    }

    @java.lang.Deprecated
    public <T, Y> void unregister(java.lang.Class<T> cls, java.lang.Class<Y> cls2) {
        com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory<T, Y> unregister = this.loaderFactory.unregister(cls, cls2);
        if (unregister != null) {
            unregister.teardown();
        }
    }
}
