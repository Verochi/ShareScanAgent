package com.alimm.tanx.ui.image.glide.request;

/* loaded from: classes.dex */
public final class GenericRequest<A, T, Z, R> implements com.alimm.tanx.ui.image.glide.request.Request, com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback, com.alimm.tanx.ui.image.glide.request.ResourceCallback {
    private static final java.util.Queue<com.alimm.tanx.ui.image.glide.request.GenericRequest<?, ?, ?, ?>> REQUEST_POOL = com.alimm.tanx.ui.image.glide.util.Util.createQueue(0);
    private static final java.lang.String TAG = "GenericRequest";
    private static final double TO_MEGABYTE = 9.5367431640625E-7d;
    private com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> animationFactory;
    private android.content.Context context;
    private com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy;
    private com.alimm.tanx.ui.image.glide.load.engine.Engine engine;
    private android.graphics.drawable.Drawable errorDrawable;
    private int errorResourceId;
    private android.graphics.drawable.Drawable fallbackDrawable;
    private int fallbackResourceId;
    private boolean isMemoryCacheable;
    private com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> loadProvider;
    private com.alimm.tanx.ui.image.glide.load.engine.Engine.LoadStatus loadStatus;
    private boolean loadedFromMemoryCache;
    private A model;
    private int overrideHeight;
    private int overrideWidth;
    private android.graphics.drawable.Drawable placeholderDrawable;
    private int placeholderResourceId;
    private com.alimm.tanx.ui.image.glide.Priority priority;
    private com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator;
    private com.alimm.tanx.ui.image.glide.request.RequestListener<? super A, R> requestListener;
    private com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource;
    private com.alimm.tanx.ui.image.glide.load.Key signature;
    private float sizeMultiplier;
    private long startTime;
    private com.alimm.tanx.ui.image.glide.request.GenericRequest.Status status;
    private final java.lang.String tag = java.lang.String.valueOf(hashCode());
    private com.alimm.tanx.ui.image.glide.request.target.Target<R> target;
    private java.lang.Class<R> transcodeClass;
    private com.alimm.tanx.ui.image.glide.load.Transformation<Z> transformation;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private GenericRequest() {
    }

    private boolean canNotifyStatusChanged() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    private boolean canSetResource() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    private static void check(java.lang.String str, java.lang.Object obj, java.lang.String str2) {
        if (obj == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new java.lang.NullPointerException(sb.toString());
        }
    }

    private android.graphics.drawable.Drawable getErrorDrawable() {
        if (this.errorDrawable == null && this.errorResourceId > 0) {
            this.errorDrawable = this.context.getResources().getDrawable(this.errorResourceId);
        }
        return this.errorDrawable;
    }

    private android.graphics.drawable.Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null && this.fallbackResourceId > 0) {
            this.fallbackDrawable = this.context.getResources().getDrawable(this.fallbackResourceId);
        }
        return this.fallbackDrawable;
    }

    private android.graphics.drawable.Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null && this.placeholderResourceId > 0) {
            this.placeholderDrawable = this.context.getResources().getDrawable(this.placeholderResourceId);
        }
        return this.placeholderDrawable;
    }

    private void init(com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> loadProvider, A a, com.alimm.tanx.ui.image.glide.load.Key key, android.content.Context context, com.alimm.tanx.ui.image.glide.Priority priority, com.alimm.tanx.ui.image.glide.request.target.Target<R> target, float f, android.graphics.drawable.Drawable drawable, int i, android.graphics.drawable.Drawable drawable2, int i2, android.graphics.drawable.Drawable drawable3, int i3, com.alimm.tanx.ui.image.glide.request.RequestListener<? super A, R> requestListener, com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator, com.alimm.tanx.ui.image.glide.load.engine.Engine engine, com.alimm.tanx.ui.image.glide.load.Transformation<Z> transformation, java.lang.Class<R> cls, boolean z, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        this.loadProvider = loadProvider;
        this.model = a;
        this.signature = key;
        this.fallbackDrawable = drawable3;
        this.fallbackResourceId = i3;
        this.context = context.getApplicationContext();
        this.priority = priority;
        this.target = target;
        this.sizeMultiplier = f;
        this.placeholderDrawable = drawable;
        this.placeholderResourceId = i;
        this.errorDrawable = drawable2;
        this.errorResourceId = i2;
        this.requestListener = requestListener;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.transformation = transformation;
        this.transcodeClass = cls;
        this.isMemoryCacheable = z;
        this.animationFactory = glideAnimationFactory;
        this.overrideWidth = i4;
        this.overrideHeight = i5;
        this.diskCacheStrategy = diskCacheStrategy;
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.PENDING;
        if (a != null) {
            check("ModelLoader", loadProvider.getModelLoader(), "try .using(ModelLoader)");
            check("Transcoder", loadProvider.getTranscoder(), "try .as*(Class).transcode(ResourceTranscoder)");
            check("Transformation", transformation, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                check("SourceEncoder", loadProvider.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                check("SourceDecoder", loadProvider.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                check("CacheDecoder", loadProvider.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                check("Encoder", loadProvider.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private boolean isFirstReadyResource() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.isAnyResourceSet();
    }

    private void logV(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.tag);
    }

    private void notifyLoadSuccess() {
        com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <A, T, Z, R> com.alimm.tanx.ui.image.glide.request.GenericRequest<A, T, Z, R> obtain(com.alimm.tanx.ui.image.glide.provider.LoadProvider<A, T, Z, R> loadProvider, A a, com.alimm.tanx.ui.image.glide.load.Key key, android.content.Context context, com.alimm.tanx.ui.image.glide.Priority priority, com.alimm.tanx.ui.image.glide.request.target.Target<R> target, float f, android.graphics.drawable.Drawable drawable, int i, android.graphics.drawable.Drawable drawable2, int i2, android.graphics.drawable.Drawable drawable3, int i3, com.alimm.tanx.ui.image.glide.request.RequestListener<? super A, R> requestListener, com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator, com.alimm.tanx.ui.image.glide.load.engine.Engine engine, com.alimm.tanx.ui.image.glide.load.Transformation<Z> transformation, java.lang.Class<R> cls, boolean z, com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        com.alimm.tanx.ui.image.glide.request.GenericRequest<A, T, Z, R> genericRequest = (com.alimm.tanx.ui.image.glide.request.GenericRequest) REQUEST_POOL.poll();
        if (genericRequest == null) {
            genericRequest = new com.alimm.tanx.ui.image.glide.request.GenericRequest<>();
        }
        genericRequest.init(loadProvider, a, key, context, priority, target, f, drawable, i, drawable2, i2, drawable3, i3, requestListener, requestCoordinator, engine, transformation, cls, z, glideAnimationFactory, i4, i5, diskCacheStrategy);
        return genericRequest;
    }

    private void onResourceReady(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource, R r) {
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.COMPLETE;
        this.resource = resource;
        com.alimm.tanx.ui.image.glide.request.RequestListener<? super A, R> requestListener = this.requestListener;
        if (requestListener == null || !requestListener.onResourceReady(r, this.model, this.target, this.loadedFromMemoryCache, isFirstReadyResource)) {
            this.target.onResourceReady(r, this.animationFactory.build(this.loadedFromMemoryCache, isFirstReadyResource));
        }
        notifyLoadSuccess();
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Resource ready in ");
            tanxu_do2.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(this.startTime));
            tanxu_do2.append(" size: ");
            tanxu_do2.append(resource.getSize() * TO_MEGABYTE);
            tanxu_do2.append(" fromCache: ");
            tanxu_do2.append(this.loadedFromMemoryCache);
            logV(tanxu_do2.toString());
        }
    }

    private void releaseResource(com.alimm.tanx.ui.image.glide.load.engine.Resource resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    private void setErrorPlaceholder(java.lang.Exception exc) {
        if (canNotifyStatusChanged()) {
            android.graphics.drawable.Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(exc, fallbackDrawable);
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void begin() {
        this.startTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        if (this.model == null) {
            onException(null);
            return;
        }
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.WAITING_FOR_SIZE;
        if (com.alimm.tanx.ui.image.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            onSizeReady(this.overrideWidth, this.overrideHeight);
        } else {
            this.target.getSize(this);
        }
        if (!isComplete() && !isFailed() && canNotifyStatusChanged()) {
            this.target.onLoadStarted(getPlaceholderDrawable());
        }
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("finished run method in ");
            tanxu_do2.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(this.startTime));
            logV(tanxu_do2.toString());
        }
    }

    public void cancel() {
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.CANCELLED;
        com.alimm.tanx.ui.image.glide.load.engine.Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void clear() {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        com.alimm.tanx.ui.image.glide.request.GenericRequest.Status status = this.status;
        com.alimm.tanx.ui.image.glide.request.GenericRequest.Status status2 = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.CLEARED;
        if (status == status2) {
            return;
        }
        cancel();
        com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource = this.resource;
        if (resource != null) {
            releaseResource(resource);
        }
        if (canNotifyStatusChanged()) {
            this.target.onLoadCleared(getPlaceholderDrawable());
        }
        this.status = status2;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isCancelled() {
        com.alimm.tanx.ui.image.glide.request.GenericRequest.Status status = this.status;
        return status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.CANCELLED || status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.CLEARED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isComplete() {
        return this.status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.COMPLETE;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isFailed() {
        return this.status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.FAILED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isPaused() {
        return this.status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.PAUSED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isResourceSet() {
        return isComplete();
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public boolean isRunning() {
        com.alimm.tanx.ui.image.glide.request.GenericRequest.Status status = this.status;
        return status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.RUNNING || status == com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.WAITING_FOR_SIZE;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onException(java.lang.Exception exc) {
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.FAILED;
        com.alimm.tanx.ui.image.glide.request.RequestListener<? super A, R> requestListener = this.requestListener;
        if (requestListener == null || !requestListener.onException(exc, this.model, this.target, isFirstReadyResource())) {
            setErrorPlaceholder(exc);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.request.ResourceCallback
    public void onResourceReady(com.alimm.tanx.ui.image.glide.load.engine.Resource<?> resource) {
        if (resource == null) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Expected to receive a Resource<R> with an object of ");
            tanxu_do2.append(this.transcodeClass);
            tanxu_do2.append(" inside, but instead got null.");
            onException(new java.lang.Exception(tanxu_do2.toString()));
            return;
        }
        java.lang.Object obj = resource.get();
        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
            if (canSetResource()) {
                onResourceReady(resource, obj);
                return;
            }
            this.engine.release(resource);
            this.resource = null;
            this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.COMPLETE;
            return;
        }
        this.engine.release(resource);
        this.resource = null;
        java.lang.StringBuilder tanxu_do3 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Expected to receive an object of ");
        tanxu_do3.append(this.transcodeClass);
        tanxu_do3.append(" but instead got ");
        tanxu_do3.append(obj != null ? obj.getClass() : "");
        tanxu_do3.append("{");
        tanxu_do3.append(obj);
        tanxu_do3.append(com.alipay.sdk.m.u.i.d);
        tanxu_do3.append(" inside Resource{");
        tanxu_do3.append(resource);
        tanxu_do3.append("}.");
        tanxu_do3.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        onException(new java.lang.Exception(tanxu_do3.toString()));
    }

    @Override // com.alimm.tanx.ui.image.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Got onSizeReady in ");
            tanxu_do2.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(this.startTime));
            logV(tanxu_do2.toString());
        }
        if (this.status != com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.WAITING_FOR_SIZE) {
            return;
        }
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.RUNNING;
        int round = java.lang.Math.round(this.sizeMultiplier * i);
        int round2 = java.lang.Math.round(this.sizeMultiplier * i2);
        com.alimm.tanx.ui.image.glide.load.data.DataFetcher<T> resourceFetcher = this.loadProvider.getModelLoader().getResourceFetcher(this.model, round, round2);
        if (resourceFetcher == null) {
            java.lang.StringBuilder tanxu_do3 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Failed to load model: '");
            tanxu_do3.append(this.model);
            tanxu_do3.append("'");
            onException(new java.lang.Exception(tanxu_do3.toString()));
            return;
        }
        com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> transcoder = this.loadProvider.getTranscoder();
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do4 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("finished setup for calling load in ");
            tanxu_do4.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(this.startTime));
            logV(tanxu_do4.toString());
        }
        this.loadedFromMemoryCache = true;
        this.loadStatus = this.engine.load(this.signature, round, round2, resourceFetcher, this.loadProvider, this.transformation, transcoder, this.priority, this.isMemoryCacheable, this.diskCacheStrategy, this);
        this.loadedFromMemoryCache = this.resource != null;
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder tanxu_do5 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("finished onSizeReady in ");
            tanxu_do5.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(this.startTime));
            logV(tanxu_do5.toString());
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void pause() {
        clear();
        this.status = com.alimm.tanx.ui.image.glide.request.GenericRequest.Status.PAUSED;
    }

    @Override // com.alimm.tanx.ui.image.glide.request.Request
    public void recycle() {
        this.loadProvider = null;
        this.model = null;
        this.context = null;
        this.target = null;
        this.placeholderDrawable = null;
        this.errorDrawable = null;
        this.fallbackDrawable = null;
        this.requestListener = null;
        this.requestCoordinator = null;
        this.transformation = null;
        this.animationFactory = null;
        this.loadedFromMemoryCache = false;
        this.loadStatus = null;
        REQUEST_POOL.offer(this);
    }
}
