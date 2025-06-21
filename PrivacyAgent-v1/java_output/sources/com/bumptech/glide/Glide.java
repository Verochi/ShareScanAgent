package com.bumptech.glide;

/* loaded from: classes.dex */
public class Glide implements android.content.ComponentCallbacks2 {
    private static final java.lang.String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    private static final java.lang.String TAG = "Glide";
    private static volatile com.bumptech.glide.Glide glide;
    private static volatile boolean isInitializing;
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("this")
    private com.bumptech.glide.load.engine.prefill.BitmapPreFiller bitmapPreFiller;
    private final com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory;
    private final com.bumptech.glide.Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final com.bumptech.glide.load.engine.Engine engine;
    private final com.bumptech.glide.GlideContext glideContext;
    private final com.bumptech.glide.load.engine.cache.MemoryCache memoryCache;
    private final com.bumptech.glide.Registry registry;
    private final com.bumptech.glide.manager.RequestManagerRetriever requestManagerRetriever;
    private final java.util.List<com.bumptech.glide.RequestManager> managers = new java.util.ArrayList();
    private com.bumptech.glide.MemoryCategory memoryCategory = com.bumptech.glide.MemoryCategory.NORMAL;

    public interface RequestOptionsFactory {
        @androidx.annotation.NonNull
        com.bumptech.glide.request.RequestOptions build();
    }

    public Glide(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Engine engine, @androidx.annotation.NonNull com.bumptech.glide.load.engine.cache.MemoryCache memoryCache, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool, @androidx.annotation.NonNull com.bumptech.glide.manager.RequestManagerRetriever requestManagerRetriever, @androidx.annotation.NonNull com.bumptech.glide.manager.ConnectivityMonitorFactory connectivityMonitorFactory, int i, @androidx.annotation.NonNull com.bumptech.glide.Glide.RequestOptionsFactory requestOptionsFactory, @androidx.annotation.NonNull java.util.Map<java.lang.Class<?>, com.bumptech.glide.TransitionOptions<?, ?>> map, @androidx.annotation.NonNull java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list, boolean z, boolean z2) {
        com.bumptech.glide.load.ResourceDecoder byteBufferBitmapDecoder;
        com.bumptech.glide.load.ResourceDecoder streamBitmapDecoder;
        com.bumptech.glide.Registry registry;
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.arrayPool = arrayPool;
        this.memoryCache = memoryCache;
        this.requestManagerRetriever = requestManagerRetriever;
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        android.content.res.Resources resources = context.getResources();
        com.bumptech.glide.Registry registry2 = new com.bumptech.glide.Registry();
        this.registry = registry2;
        registry2.register(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser());
        int i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            registry2.register(new com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser());
        }
        java.util.List<com.bumptech.glide.load.ImageHeaderParser> imageHeaderParsers = registry2.getImageHeaderParsers();
        com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder byteBufferGifDecoder = new com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder(context, imageHeaderParsers, bitmapPool, arrayPool);
        com.bumptech.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> parcel = com.bumptech.glide.load.resource.bitmap.VideoDecoder.parcel(bitmapPool);
        com.bumptech.glide.load.resource.bitmap.Downsampler downsampler = new com.bumptech.glide.load.resource.bitmap.Downsampler(registry2.getImageHeaderParsers(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (!z2 || i2 < 28) {
            byteBufferBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder(downsampler, arrayPool);
        } else {
            streamBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder();
        }
        com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder resourceDrawableDecoder = new com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder(context);
        com.bumptech.glide.load.model.ResourceLoader.StreamFactory streamFactory = new com.bumptech.glide.load.model.ResourceLoader.StreamFactory(resources);
        com.bumptech.glide.load.model.ResourceLoader.UriFactory uriFactory = new com.bumptech.glide.load.model.ResourceLoader.UriFactory(resources);
        com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new com.bumptech.glide.load.model.ResourceLoader.FileDescriptorFactory(resources);
        com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new com.bumptech.glide.load.model.ResourceLoader.AssetFileDescriptorFactory(resources);
        com.bumptech.glide.load.resource.bitmap.BitmapEncoder bitmapEncoder = new com.bumptech.glide.load.resource.bitmap.BitmapEncoder(arrayPool);
        com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder bitmapBytesTranscoder = new com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder();
        com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder();
        android.content.ContentResolver contentResolver = context.getContentResolver();
        registry2.append(java.nio.ByteBuffer.class, new com.bumptech.glide.load.model.ByteBufferEncoder()).append(java.io.InputStream.class, new com.bumptech.glide.load.model.StreamEncoder(arrayPool)).append(com.bumptech.glide.Registry.BUCKET_BITMAP, java.nio.ByteBuffer.class, android.graphics.Bitmap.class, byteBufferBitmapDecoder).append(com.bumptech.glide.Registry.BUCKET_BITMAP, java.io.InputStream.class, android.graphics.Bitmap.class, streamBitmapDecoder);
        if (com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()) {
            registry2.append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry2.append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.os.ParcelFileDescriptor.class, android.graphics.Bitmap.class, parcel).append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.content.res.AssetFileDescriptor.class, android.graphics.Bitmap.class, com.bumptech.glide.load.resource.bitmap.VideoDecoder.asset(bitmapPool)).append(android.graphics.Bitmap.class, android.graphics.Bitmap.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(com.bumptech.glide.Registry.BUCKET_BITMAP, android.graphics.Bitmap.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder()).append(android.graphics.Bitmap.class, (com.bumptech.glide.load.ResourceEncoder) bitmapEncoder).append(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, java.nio.ByteBuffer.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).append(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, java.io.InputStream.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, streamBitmapDecoder)).append(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, android.os.ParcelFileDescriptor.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, parcel)).append(android.graphics.drawable.BitmapDrawable.class, (com.bumptech.glide.load.ResourceEncoder) new com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).append(com.bumptech.glide.Registry.BUCKET_GIF, java.io.InputStream.class, com.bumptech.glide.load.resource.gif.GifDrawable.class, new com.bumptech.glide.load.resource.gif.StreamGifDecoder(imageHeaderParsers, byteBufferGifDecoder, arrayPool)).append(com.bumptech.glide.Registry.BUCKET_GIF, java.nio.ByteBuffer.class, com.bumptech.glide.load.resource.gif.GifDrawable.class, byteBufferGifDecoder).append(com.bumptech.glide.load.resource.gif.GifDrawable.class, (com.bumptech.glide.load.ResourceEncoder) new com.bumptech.glide.load.resource.gif.GifDrawableEncoder()).append(com.bumptech.glide.gifdecoder.GifDecoder.class, com.bumptech.glide.gifdecoder.GifDecoder.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.gifdecoder.GifDecoder.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder(bitmapPool)).append(android.net.Uri.class, android.graphics.drawable.Drawable.class, resourceDrawableDecoder).append(android.net.Uri.class, android.graphics.Bitmap.class, new com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).register(new com.bumptech.glide.load.resource.bytes.ByteBufferRewinder.Factory()).append(java.io.File.class, java.nio.ByteBuffer.class, new com.bumptech.glide.load.model.ByteBufferFileLoader.Factory()).append(java.io.File.class, java.io.InputStream.class, new com.bumptech.glide.load.model.FileLoader.StreamFactory()).append(java.io.File.class, java.io.File.class, new com.bumptech.glide.load.resource.file.FileDecoder()).append(java.io.File.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.FileLoader.FileDescriptorFactory()).append(java.io.File.class, java.io.File.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).register(new com.bumptech.glide.load.data.InputStreamRewinder.Factory(arrayPool));
        if (com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.isSupported()) {
            registry = registry2;
            registry.register(new com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.Factory());
        } else {
            registry = registry2;
        }
        java.lang.Class cls = java.lang.Integer.TYPE;
        registry.append(cls, java.io.InputStream.class, streamFactory).append(cls, android.os.ParcelFileDescriptor.class, fileDescriptorFactory).append(java.lang.Integer.class, java.io.InputStream.class, streamFactory).append(java.lang.Integer.class, android.os.ParcelFileDescriptor.class, fileDescriptorFactory).append(java.lang.Integer.class, android.net.Uri.class, uriFactory).append(cls, android.content.res.AssetFileDescriptor.class, assetFileDescriptorFactory).append(java.lang.Integer.class, android.content.res.AssetFileDescriptor.class, assetFileDescriptorFactory).append(cls, android.net.Uri.class, uriFactory).append(java.lang.String.class, java.io.InputStream.class, new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory()).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.DataUrlLoader.StreamFactory()).append(java.lang.String.class, java.io.InputStream.class, new com.bumptech.glide.load.model.StringLoader.StreamFactory()).append(java.lang.String.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.StringLoader.FileDescriptorFactory()).append(java.lang.String.class, android.content.res.AssetFileDescriptor.class, new com.bumptech.glide.load.model.StringLoader.AssetFileDescriptorFactory()).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.HttpUriLoader.Factory()).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.AssetUriLoader.StreamFactory(context.getAssets())).append(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.AssetUriLoader.FileDescriptorFactory(context.getAssets())).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader.Factory(context)).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader.Factory(context));
        if (i2 >= 29) {
            registry.append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.InputStreamFactory(context));
            registry.append(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.stream.QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        registry.append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.UriLoader.StreamFactory(contentResolver)).append(android.net.Uri.class, android.os.ParcelFileDescriptor.class, new com.bumptech.glide.load.model.UriLoader.FileDescriptorFactory(contentResolver)).append(android.net.Uri.class, android.content.res.AssetFileDescriptor.class, new com.bumptech.glide.load.model.UriLoader.AssetFileDescriptorFactory(contentResolver)).append(android.net.Uri.class, java.io.InputStream.class, new com.bumptech.glide.load.model.UrlUriLoader.StreamFactory()).append(java.net.URL.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.UrlLoader.StreamFactory()).append(android.net.Uri.class, java.io.File.class, new com.bumptech.glide.load.model.MediaStoreFileLoader.Factory(context)).append(com.bumptech.glide.load.model.GlideUrl.class, java.io.InputStream.class, new com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Factory()).append(byte[].class, java.nio.ByteBuffer.class, new com.bumptech.glide.load.model.ByteArrayLoader.ByteBufferFactory()).append(byte[].class, java.io.InputStream.class, new com.bumptech.glide.load.model.ByteArrayLoader.StreamFactory()).append(android.net.Uri.class, android.net.Uri.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(android.graphics.drawable.Drawable.class, android.graphics.drawable.Drawable.class, com.bumptech.glide.load.model.UnitModelLoader.Factory.getInstance()).append(android.graphics.drawable.Drawable.class, android.graphics.drawable.Drawable.class, new com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder()).register(android.graphics.Bitmap.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder(resources)).register(android.graphics.Bitmap.class, byte[].class, bitmapBytesTranscoder).register(android.graphics.drawable.Drawable.class, byte[].class, new com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).register(com.bumptech.glide.load.resource.gif.GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        if (i2 >= 23) {
            com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> byteBuffer = com.bumptech.glide.load.resource.bitmap.VideoDecoder.byteBuffer(bitmapPool);
            registry.append(java.nio.ByteBuffer.class, android.graphics.Bitmap.class, byteBuffer);
            registry.append(java.nio.ByteBuffer.class, android.graphics.drawable.BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder(resources, byteBuffer));
        }
        this.glideContext = new com.bumptech.glide.GlideContext(context, arrayPool, registry, new com.bumptech.glide.request.target.ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, z, i);
    }

    @androidx.annotation.GuardedBy("Glide.class")
    private static void checkAndInitializeGlide(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule) {
        if (isInitializing) {
            throw new java.lang.IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        isInitializing = true;
        initializeGlide(context, generatedAppGlideModule);
        isInitializing = false;
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.Glide get(@androidx.annotation.NonNull android.content.Context context) {
        if (glide == null) {
            com.bumptech.glide.GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context.getApplicationContext());
            synchronized (com.bumptech.glide.Glide.class) {
                if (glide == null) {
                    checkAndInitializeGlide(context, annotationGeneratedGlideModules);
                }
            }
        }
        return glide;
    }

    @androidx.annotation.Nullable
    private static com.bumptech.glide.GeneratedAppGlideModule getAnnotationGeneratedGlideModules(android.content.Context context) {
        try {
            return (com.bumptech.glide.GeneratedAppGlideModule) com.bumptech.glide.GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(android.content.Context.class).newInstance(context.getApplicationContext());
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        } catch (java.lang.IllegalAccessException e) {
            throwIncorrectGlideModule(e);
            return null;
        } catch (java.lang.InstantiationException e2) {
            throwIncorrectGlideModule(e2);
            return null;
        } catch (java.lang.NoSuchMethodException e3) {
            throwIncorrectGlideModule(e3);
            return null;
        } catch (java.lang.reflect.InvocationTargetException e4) {
            throwIncorrectGlideModule(e4);
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static java.io.File getPhotoCacheDir(@androidx.annotation.NonNull android.content.Context context) {
        return getPhotoCacheDir(context, "image_manager_disk_cache");
    }

    @androidx.annotation.Nullable
    public static java.io.File getPhotoCacheDir(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
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

    @androidx.annotation.NonNull
    private static com.bumptech.glide.manager.RequestManagerRetriever getRetriever(@androidx.annotation.Nullable android.content.Context context) {
        com.bumptech.glide.util.Preconditions.checkNotNull(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return get(context).getRequestManagerRetriever();
    }

    @androidx.annotation.VisibleForTesting
    public static void init(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.GlideBuilder glideBuilder) {
        com.bumptech.glide.GeneratedAppGlideModule annotationGeneratedGlideModules = getAnnotationGeneratedGlideModules(context);
        synchronized (com.bumptech.glide.Glide.class) {
            if (glide != null) {
                tearDown();
            }
            initializeGlide(context, glideBuilder, annotationGeneratedGlideModules);
        }
    }

    @androidx.annotation.VisibleForTesting
    @java.lang.Deprecated
    public static synchronized void init(com.bumptech.glide.Glide glide2) {
        synchronized (com.bumptech.glide.Glide.class) {
            if (glide != null) {
                tearDown();
            }
            glide = glide2;
        }
    }

    @androidx.annotation.GuardedBy("Glide.class")
    private static void initializeGlide(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule) {
        initializeGlide(context, new com.bumptech.glide.GlideBuilder(), generatedAppGlideModule);
    }

    @androidx.annotation.GuardedBy("Glide.class")
    private static void initializeGlide(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.bumptech.glide.GlideBuilder glideBuilder, @androidx.annotation.Nullable com.bumptech.glide.GeneratedAppGlideModule generatedAppGlideModule) {
        android.content.Context applicationContext = context.getApplicationContext();
        java.util.List<com.bumptech.glide.module.GlideModule> emptyList = java.util.Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.isManifestParsingEnabled()) {
            emptyList = new com.bumptech.glide.module.ManifestParser(applicationContext).parse();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.getExcludedModuleClasses().isEmpty()) {
            java.util.Set<java.lang.Class<?>> excludedModuleClasses = generatedAppGlideModule.getExcludedModuleClasses();
            java.util.Iterator<com.bumptech.glide.module.GlideModule> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.module.GlideModule next = it.next();
                if (excludedModuleClasses.contains(next.getClass())) {
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("AppGlideModule excludes manifest GlideModule: ");
                        sb.append(next);
                    }
                    it.remove();
                }
            }
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            for (com.bumptech.glide.module.GlideModule glideModule : emptyList) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(glideModule.getClass());
            }
        }
        glideBuilder.setRequestManagerFactory(generatedAppGlideModule != null ? generatedAppGlideModule.getRequestManagerFactory() : null);
        java.util.Iterator<com.bumptech.glide.module.GlideModule> it2 = emptyList.iterator();
        while (it2.hasNext()) {
            it2.next().applyOptions(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.applyOptions(applicationContext, glideBuilder);
        }
        com.bumptech.glide.Glide build = glideBuilder.build(applicationContext);
        for (com.bumptech.glide.module.GlideModule glideModule2 : emptyList) {
            try {
                glideModule2.registerComponents(applicationContext, build, build.registry);
            } catch (java.lang.AbstractMethodError e) {
                throw new java.lang.IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule2.getClass().getName(), e);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.registerComponents(applicationContext, build, build.registry);
        }
        applicationContext.registerComponentCallbacks(build);
        glide = build;
    }

    @androidx.annotation.VisibleForTesting
    public static synchronized void tearDown() {
        synchronized (com.bumptech.glide.Glide.class) {
            if (glide != null) {
                glide.getContext().getApplicationContext().unregisterComponentCallbacks(glide);
                glide.engine.shutdown();
            }
            glide = null;
        }
    }

    private static void throwIncorrectGlideModule(java.lang.Exception exc) {
        throw new java.lang.IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.RequestManager with(@androidx.annotation.NonNull android.app.Activity activity) {
        return getRetriever(activity).get(activity);
    }

    @androidx.annotation.NonNull
    @java.lang.Deprecated
    public static com.bumptech.glide.RequestManager with(@androidx.annotation.NonNull android.app.Fragment fragment) {
        return getRetriever(fragment.getActivity()).get(fragment);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.RequestManager with(@androidx.annotation.NonNull android.content.Context context) {
        return getRetriever(context).get(context);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.RequestManager with(@androidx.annotation.NonNull android.view.View view) {
        return getRetriever(view.getContext()).get(view);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.RequestManager with(@androidx.annotation.NonNull androidx.fragment.app.Fragment fragment) {
        return getRetriever(fragment.getContext()).get(fragment);
    }

    @androidx.annotation.NonNull
    public static com.bumptech.glide.RequestManager with(@androidx.annotation.NonNull androidx.fragment.app.FragmentActivity fragmentActivity) {
        return getRetriever(fragmentActivity).get(fragmentActivity);
    }

    public void clearDiskCache() {
        com.bumptech.glide.util.Util.assertBackgroundThread();
        this.engine.clearDiskCache();
    }

    public void clearMemory() {
        com.bumptech.glide.util.Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
        this.arrayPool.clearMemory();
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool getArrayPool() {
        return this.arrayPool;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    public com.bumptech.glide.manager.ConnectivityMonitorFactory getConnectivityMonitorFactory() {
        return this.connectivityMonitorFactory;
    }

    @androidx.annotation.NonNull
    public android.content.Context getContext() {
        return this.glideContext.getBaseContext();
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.GlideContext getGlideContext() {
        return this.glideContext;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.Registry getRegistry() {
        return this.registry;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.manager.RequestManagerRetriever getRequestManagerRetriever() {
        return this.requestManagerRetriever;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        clearMemory();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        trimMemory(i);
    }

    public synchronized void preFillBitmapPool(@androidx.annotation.NonNull com.bumptech.glide.load.engine.prefill.PreFillType.Builder... builderArr) {
        if (this.bitmapPreFiller == null) {
            this.bitmapPreFiller = new com.bumptech.glide.load.engine.prefill.BitmapPreFiller(this.memoryCache, this.bitmapPool, (com.bumptech.glide.load.DecodeFormat) this.defaultRequestOptionsFactory.build().getOptions().get(com.bumptech.glide.load.resource.bitmap.Downsampler.DECODE_FORMAT));
        }
        this.bitmapPreFiller.preFill(builderArr);
    }

    public void registerRequestManager(com.bumptech.glide.RequestManager requestManager) {
        synchronized (this.managers) {
            if (this.managers.contains(requestManager)) {
                throw new java.lang.IllegalStateException("Cannot register already registered manager");
            }
            this.managers.add(requestManager);
        }
    }

    public boolean removeFromManagers(@androidx.annotation.NonNull com.bumptech.glide.request.target.Target<?> target) {
        synchronized (this.managers) {
            java.util.Iterator<com.bumptech.glide.RequestManager> it = this.managers.iterator();
            while (it.hasNext()) {
                if (it.next().untrack(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.MemoryCategory setMemoryCategory(@androidx.annotation.NonNull com.bumptech.glide.MemoryCategory memoryCategory) {
        com.bumptech.glide.util.Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
        com.bumptech.glide.MemoryCategory memoryCategory2 = this.memoryCategory;
        this.memoryCategory = memoryCategory;
        return memoryCategory2;
    }

    public void trimMemory(int i) {
        com.bumptech.glide.util.Util.assertMainThread();
        java.util.Iterator<com.bumptech.glide.RequestManager> it = this.managers.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i);
        }
        this.memoryCache.trimMemory(i);
        this.bitmapPool.trimMemory(i);
        this.arrayPool.trimMemory(i);
    }

    public void unregisterRequestManager(com.bumptech.glide.RequestManager requestManager) {
        synchronized (this.managers) {
            if (!this.managers.contains(requestManager)) {
                throw new java.lang.IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.managers.remove(requestManager);
        }
    }
}
