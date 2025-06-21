package com.bumptech.glide.request;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements com.bumptech.glide.request.Request, com.bumptech.glide.request.target.SizeReadyCallback, com.bumptech.glide.request.ResourceCallback {
    private static final java.lang.String GLIDE_TAG = "Glide";
    private final com.bumptech.glide.request.transition.TransitionFactory<? super R> animationFactory;
    private final java.util.concurrent.Executor callbackExecutor;
    private final android.content.Context context;
    private volatile com.bumptech.glide.load.engine.Engine engine;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable errorDrawable;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable fallbackDrawable;
    private final com.bumptech.glide.GlideContext glideContext;

    @androidx.annotation.GuardedBy("requestLock")
    private int height;

    @androidx.annotation.GuardedBy("requestLock")
    private boolean isCallingCallbacks;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.load.engine.Engine.LoadStatus loadStatus;

    @androidx.annotation.Nullable
    private final java.lang.Object model;
    private final int overrideHeight;
    private final int overrideWidth;

    @androidx.annotation.Nullable
    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable placeholderDrawable;
    private final com.bumptech.glide.Priority priority;
    private final com.bumptech.glide.request.RequestCoordinator requestCoordinator;

    @androidx.annotation.Nullable
    private final java.util.List<com.bumptech.glide.request.RequestListener<R>> requestListeners;
    private final java.lang.Object requestLock;
    private final com.bumptech.glide.request.BaseRequestOptions<?> requestOptions;

    @androidx.annotation.Nullable
    private java.lang.RuntimeException requestOrigin;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.load.engine.Resource<R> resource;

    @androidx.annotation.GuardedBy("requestLock")
    private long startTime;
    private final com.bumptech.glide.util.pool.StateVerifier stateVerifier;

    @androidx.annotation.GuardedBy("requestLock")
    private com.bumptech.glide.request.SingleRequest.Status status;

    @androidx.annotation.Nullable
    private final java.lang.String tag;
    private final com.bumptech.glide.request.target.Target<R> target;

    @androidx.annotation.Nullable
    private final com.bumptech.glide.request.RequestListener<R> targetListener;
    private final java.lang.Class<R> transcodeClass;

    @androidx.annotation.GuardedBy("requestLock")
    private int width;
    private static final java.lang.String TAG = "Request";
    private static final boolean IS_VERBOSE_LOGGABLE = android.util.Log.isLoggable(TAG, 2);

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(android.content.Context context, com.bumptech.glide.GlideContext glideContext, @androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2, java.lang.Class<R> cls, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, int i, int i2, com.bumptech.glide.Priority priority, com.bumptech.glide.request.target.Target<R> target, @androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<R> requestListener, @androidx.annotation.Nullable java.util.List<com.bumptech.glide.request.RequestListener<R>> list, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.Engine engine, com.bumptech.glide.request.transition.TransitionFactory<? super R> transitionFactory, java.util.concurrent.Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? java.lang.String.valueOf(super.hashCode()) : null;
        this.stateVerifier = com.bumptech.glide.util.pool.StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context;
        this.glideContext = glideContext;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority;
        this.target = target;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = com.bumptech.glide.request.SingleRequest.Status.PENDING;
        if (this.requestOrigin == null && glideContext.isLoggingRequestOriginsEnabled()) {
            this.requestOrigin = new java.lang.RuntimeException("Glide request origin trace");
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new java.lang.IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean canNotifyCleared() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyCleared(this);
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean canNotifyStatusChanged() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canNotifyStatusChanged(this);
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean canSetResource() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || requestCoordinator.canSetImage(this);
    }

    @androidx.annotation.GuardedBy("requestLock")
    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        com.bumptech.glide.load.engine.Engine.LoadStatus loadStatus = this.loadStatus;
        if (loadStatus != null) {
            loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            android.graphics.drawable.Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            android.graphics.drawable.Drawable fallbackDrawable = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable;
            if (fallbackDrawable == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            android.graphics.drawable.Drawable placeholderDrawable = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable;
            if (placeholderDrawable == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    @androidx.annotation.GuardedBy("requestLock")
    private boolean isFirstReadyResource() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        return requestCoordinator == null || !requestCoordinator.getRoot().isAnyResourceSet();
    }

    @androidx.annotation.GuardedBy("requestLock")
    private android.graphics.drawable.Drawable loadDrawable(@androidx.annotation.DrawableRes int i) {
        return com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.getDrawable(this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void logV(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.tag);
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : java.lang.Math.round(f * i);
    }

    @androidx.annotation.GuardedBy("requestLock")
    private void notifyLoadFailed() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestFailed(this);
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    private void notifyLoadSuccess() {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator = this.requestCoordinator;
        if (requestCoordinator != null) {
            requestCoordinator.onRequestSuccess(this);
        }
    }

    public static <R> com.bumptech.glide.request.SingleRequest<R> obtain(android.content.Context context, com.bumptech.glide.GlideContext glideContext, java.lang.Object obj, java.lang.Object obj2, java.lang.Class<R> cls, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, int i, int i2, com.bumptech.glide.Priority priority, com.bumptech.glide.request.target.Target<R> target, com.bumptech.glide.request.RequestListener<R> requestListener, @androidx.annotation.Nullable java.util.List<com.bumptech.glide.request.RequestListener<R>> list, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.Engine engine, com.bumptech.glide.request.transition.TransitionFactory<? super R> transitionFactory, java.util.concurrent.Executor executor) {
        return new com.bumptech.glide.request.SingleRequest<>(context, glideContext, obj, obj2, cls, baseRequestOptions, i, i2, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Load failed for ");
                sb.append(this.model);
                sb.append(" with size [");
                sb.append(this.width);
                sb.append("x");
                sb.append(this.height);
                sb.append("]");
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = com.bumptech.glide.request.SingleRequest.Status.FAILED;
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    java.util.Iterator<com.bumptech.glide.request.RequestListener<R>> it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        z |= it.next().onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z = false;
                }
                com.bumptech.glide.request.RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z2 = false;
                }
                if (!(z | z2)) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                notifyLoadFailed();
            } catch (java.lang.Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> resource, R r, com.bumptech.glide.load.DataSource dataSource) {
        boolean z;
        boolean isFirstReadyResource = isFirstReadyResource();
        this.status = com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
        this.resource = resource;
        if (this.glideContext.getLogLevel() <= 3) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Finished loading ");
            sb.append(r.getClass().getSimpleName());
            sb.append(" from ");
            sb.append(dataSource);
            sb.append(" for ");
            sb.append(this.model);
            sb.append(" with size [");
            sb.append(this.width);
            sb.append("x");
            sb.append(this.height);
            sb.append("] in ");
            sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime));
            sb.append(" ms");
        }
        boolean z2 = true;
        this.isCallingCallbacks = true;
        try {
            java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                java.util.Iterator<com.bumptech.glide.request.RequestListener<R>> it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    z |= it.next().onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource);
                }
            } else {
                z = false;
            }
            com.bumptech.glide.request.RequestListener<R> requestListener = this.targetListener;
            if (requestListener == null || !requestListener.onResourceReady(r, this.model, this.target, dataSource, isFirstReadyResource)) {
                z2 = false;
            }
            if (!(z2 | z)) {
                this.target.onResourceReady(r, this.animationFactory.build(dataSource, isFirstReadyResource));
            }
            this.isCallingCallbacks = false;
            notifyLoadSuccess();
        } catch (java.lang.Throwable th) {
            this.isCallingCallbacks = false;
            throw th;
        }
    }

    @androidx.annotation.GuardedBy("requestLock")
    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            android.graphics.drawable.Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable);
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void begin() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            this.startTime = com.bumptech.glide.util.LogTime.getLogTime();
            if (this.model == null) {
                if (com.bumptech.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                    this.width = this.overrideWidth;
                    this.height = this.overrideHeight;
                }
                onLoadFailed(new com.bumptech.glide.load.engine.GlideException("Received null model"), getFallbackDrawable() == null ? 5 : 3);
                return;
            }
            com.bumptech.glide.request.SingleRequest.Status status = this.status;
            com.bumptech.glide.request.SingleRequest.Status status2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING;
            if (status == status2) {
                throw new java.lang.IllegalArgumentException("Cannot restart a running request");
            }
            if (status == com.bumptech.glide.request.SingleRequest.Status.COMPLETE) {
                onResourceReady(this.resource, com.bumptech.glide.load.DataSource.MEMORY_CACHE);
                return;
            }
            com.bumptech.glide.request.SingleRequest.Status status3 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE;
            this.status = status3;
            if (com.bumptech.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
                onSizeReady(this.overrideWidth, this.overrideHeight);
            } else {
                this.target.getSize(this);
            }
            com.bumptech.glide.request.SingleRequest.Status status4 = this.status;
            if ((status4 == status2 || status4 == status3) && canNotifyStatusChanged()) {
                this.target.onLoadStarted(getPlaceholderDrawable());
            }
            if (IS_VERBOSE_LOGGABLE) {
                logV("finished run method in " + com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime));
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.requestLock) {
            assertNotCallingCallbacks();
            this.stateVerifier.throwIfRecycled();
            com.bumptech.glide.request.SingleRequest.Status status = this.status;
            com.bumptech.glide.request.SingleRequest.Status status2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED;
            if (status == status2) {
                return;
            }
            cancel();
            com.bumptech.glide.load.engine.Resource<R> resource = this.resource;
            if (resource != null) {
                this.resource = null;
            } else {
                resource = null;
            }
            if (canNotifyCleared()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = status2;
            if (resource != null) {
                this.engine.release(resource);
            }
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public java.lang.Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isEquivalentTo(com.bumptech.glide.request.Request request) {
        int i;
        int i2;
        java.lang.Object obj;
        java.lang.Class<R> cls;
        com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions;
        com.bumptech.glide.Priority priority;
        int size;
        int i3;
        int i4;
        java.lang.Object obj2;
        java.lang.Class<R> cls2;
        com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions2;
        com.bumptech.glide.Priority priority2;
        int size2;
        if (!(request instanceof com.bumptech.glide.request.SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority = this.priority;
            java.util.List<com.bumptech.glide.request.RequestListener<R>> list = this.requestListeners;
            size = list != null ? list.size() : 0;
        }
        com.bumptech.glide.request.SingleRequest singleRequest = (com.bumptech.glide.request.SingleRequest) request;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority2 = singleRequest.priority;
            java.util.List<com.bumptech.glide.request.RequestListener<R>> list2 = singleRequest.requestListeners;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && com.bumptech.glide.util.Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority == priority2 && size == size2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            com.bumptech.glide.request.SingleRequest.Status status = this.status;
            z = status == com.bumptech.glide.request.SingleRequest.Status.RUNNING || status == com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void onLoadFailed(com.bumptech.glide.load.engine.GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.ResourceCallback
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> resource, com.bumptech.glide.load.DataSource dataSource) {
        this.stateVerifier.throwIfRecycled();
        com.bumptech.glide.load.engine.Resource<?> resource2 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource == null) {
                        onLoadFailed(new com.bumptech.glide.load.engine.GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    java.lang.Object obj = resource.get();
                    try {
                        if (obj != null && this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (canSetResource()) {
                                onResourceReady(resource, obj, dataSource);
                                return;
                            }
                            this.resource = null;
                            this.status = com.bumptech.glide.request.SingleRequest.Status.COMPLETE;
                            this.engine.release(resource);
                            return;
                        }
                        this.resource = null;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.transcodeClass);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(resource);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        onLoadFailed(new com.bumptech.glide.load.engine.GlideException(sb.toString()));
                        this.engine.release(resource);
                    } catch (java.lang.Throwable th) {
                        resource2 = resource;
                        th = th;
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        } catch (java.lang.Throwable th3) {
            if (resource2 != null) {
                this.engine.release(resource2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i, int i2) {
        java.lang.Object obj;
        this.stateVerifier.throwIfRecycled();
        java.lang.Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                try {
                    boolean z = IS_VERBOSE_LOGGABLE;
                    if (z) {
                        logV("Got onSizeReady in " + com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime));
                    }
                    if (this.status == com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE) {
                        com.bumptech.glide.request.SingleRequest.Status status = com.bumptech.glide.request.SingleRequest.Status.RUNNING;
                        this.status = status;
                        float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                        this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                        this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                        if (z) {
                            logV("finished setup for calling load in " + com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime));
                        }
                        obj = obj2;
                        try {
                            this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                            if (this.status != status) {
                                this.loadStatus = null;
                            }
                            if (z) {
                                logV("finished onSizeReady in " + com.bumptech.glide.util.LogTime.getElapsedMillis(this.startTime));
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                obj = obj2;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
