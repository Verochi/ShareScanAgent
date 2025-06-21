package com.bumptech.glide;

/* loaded from: classes.dex */
public class RequestBuilder<TranscodeType> extends com.bumptech.glide.request.BaseRequestOptions<com.bumptech.glide.RequestBuilder<TranscodeType>> implements com.bumptech.glide.ModelTypes<com.bumptech.glide.RequestBuilder<TranscodeType>> {
    protected static final com.bumptech.glide.request.RequestOptions DOWNLOAD_ONLY_OPTIONS = new com.bumptech.glide.request.RequestOptions().diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.DATA).priority(com.bumptech.glide.Priority.LOW).skipMemoryCache(true);
    private final android.content.Context context;

    @androidx.annotation.Nullable
    private com.bumptech.glide.RequestBuilder<TranscodeType> errorBuilder;
    private final com.bumptech.glide.Glide glide;
    private final com.bumptech.glide.GlideContext glideContext;
    private boolean isDefaultTransitionOptionsSet;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;

    @androidx.annotation.Nullable
    private java.lang.Object model;

    @androidx.annotation.Nullable
    private java.util.List<com.bumptech.glide.request.RequestListener<TranscodeType>> requestListeners;
    private final com.bumptech.glide.RequestManager requestManager;

    @androidx.annotation.Nullable
    private java.lang.Float thumbSizeMultiplier;

    @androidx.annotation.Nullable
    private com.bumptech.glide.RequestBuilder<TranscodeType> thumbnailBuilder;
    private final java.lang.Class<TranscodeType> transcodeClass;

    @androidx.annotation.NonNull
    private com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions;

    /* renamed from: com.bumptech.glide.RequestBuilder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$Priority;

        static {
            int[] iArr = new int[com.bumptech.glide.Priority.values().length];
            $SwitchMap$com$bumptech$glide$Priority = iArr;
            try {
                iArr[com.bumptech.glide.Priority.LOW.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[com.bumptech.glide.Priority.NORMAL.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[com.bumptech.glide.Priority.HIGH.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$Priority[com.bumptech.glide.Priority.IMMEDIATE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr2;
            try {
                iArr2[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused12) {
            }
        }
    }

    @android.annotation.SuppressLint({"CheckResult"})
    public RequestBuilder(@androidx.annotation.NonNull com.bumptech.glide.Glide glide, com.bumptech.glide.RequestManager requestManager, java.lang.Class<TranscodeType> cls, android.content.Context context) {
        this.isDefaultTransitionOptionsSet = true;
        this.glide = glide;
        this.requestManager = requestManager;
        this.transcodeClass = cls;
        this.context = context;
        this.transitionOptions = requestManager.getDefaultTransitionOptions(cls);
        this.glideContext = glide.getGlideContext();
        initRequestListeners(requestManager.getDefaultRequestListeners());
        apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestManager.getDefaultRequestOptions());
    }

    @android.annotation.SuppressLint({"CheckResult"})
    public RequestBuilder(java.lang.Class<TranscodeType> cls, com.bumptech.glide.RequestBuilder<?> requestBuilder) {
        this(requestBuilder.glide, requestBuilder.requestManager, cls, requestBuilder.context);
        this.model = requestBuilder.model;
        this.isModelSet = requestBuilder.isModelSet;
        apply((com.bumptech.glide.request.BaseRequestOptions<?>) requestBuilder);
    }

    private com.bumptech.glide.request.Request buildRequest(com.bumptech.glide.request.target.Target<TranscodeType> target, @androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        return buildRequestRecursive(new java.lang.Object(), target, requestListener, null, this.transitionOptions, baseRequestOptions.getPriority(), baseRequestOptions.getOverrideWidth(), baseRequestOptions.getOverrideHeight(), baseRequestOptions, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.Request buildRequestRecursive(java.lang.Object obj, com.bumptech.glide.request.target.Target<TranscodeType> target, @androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, @androidx.annotation.Nullable com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions, com.bumptech.glide.Priority priority, int i, int i2, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        com.bumptech.glide.request.RequestCoordinator requestCoordinator2;
        com.bumptech.glide.request.RequestCoordinator requestCoordinator3;
        if (this.errorBuilder != null) {
            requestCoordinator3 = new com.bumptech.glide.request.ErrorRequestCoordinator(obj, requestCoordinator);
            requestCoordinator2 = requestCoordinator3;
        } else {
            requestCoordinator2 = null;
            requestCoordinator3 = requestCoordinator;
        }
        com.bumptech.glide.request.Request buildThumbnailRequestRecursive = buildThumbnailRequestRecursive(obj, target, requestListener, requestCoordinator3, transitionOptions, priority, i, i2, baseRequestOptions, executor);
        if (requestCoordinator2 == null) {
            return buildThumbnailRequestRecursive;
        }
        int overrideWidth = this.errorBuilder.getOverrideWidth();
        int overrideHeight = this.errorBuilder.getOverrideHeight();
        if (com.bumptech.glide.util.Util.isValidDimensions(i, i2) && !this.errorBuilder.isValidOverride()) {
            overrideWidth = baseRequestOptions.getOverrideWidth();
            overrideHeight = baseRequestOptions.getOverrideHeight();
        }
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = this.errorBuilder;
        com.bumptech.glide.request.ErrorRequestCoordinator errorRequestCoordinator = requestCoordinator2;
        errorRequestCoordinator.setRequests(buildThumbnailRequestRecursive, requestBuilder.buildRequestRecursive(obj, target, requestListener, errorRequestCoordinator, requestBuilder.transitionOptions, requestBuilder.getPriority(), overrideWidth, overrideHeight, this.errorBuilder, executor));
        return errorRequestCoordinator;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.BaseRequestOptions] */
    private com.bumptech.glide.request.Request buildThumbnailRequestRecursive(java.lang.Object obj, com.bumptech.glide.request.target.Target<TranscodeType> target, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, @androidx.annotation.Nullable com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions, com.bumptech.glide.Priority priority, int i, int i2, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = this.thumbnailBuilder;
        if (requestBuilder == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(obj, target, requestListener, baseRequestOptions, requestCoordinator, transitionOptions, priority, i, i2, executor);
            }
            com.bumptech.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator = new com.bumptech.glide.request.ThumbnailRequestCoordinator(obj, requestCoordinator);
            thumbnailRequestCoordinator.setRequests(obtainRequest(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator, transitionOptions, priority, i, i2, executor), obtainRequest(obj, target, requestListener, baseRequestOptions.mo46clone().sizeMultiplier(this.thumbSizeMultiplier.floatValue()), thumbnailRequestCoordinator, transitionOptions, getThumbnailPriority(priority), i, i2, executor));
            return thumbnailRequestCoordinator;
        }
        if (this.isThumbnailBuilt) {
            throw new java.lang.IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions2 = requestBuilder.isDefaultTransitionOptionsSet ? transitionOptions : requestBuilder.transitionOptions;
        com.bumptech.glide.Priority priority2 = requestBuilder.isPrioritySet() ? this.thumbnailBuilder.getPriority() : getThumbnailPriority(priority);
        int overrideWidth = this.thumbnailBuilder.getOverrideWidth();
        int overrideHeight = this.thumbnailBuilder.getOverrideHeight();
        if (com.bumptech.glide.util.Util.isValidDimensions(i, i2) && !this.thumbnailBuilder.isValidOverride()) {
            overrideWidth = baseRequestOptions.getOverrideWidth();
            overrideHeight = baseRequestOptions.getOverrideHeight();
        }
        com.bumptech.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new com.bumptech.glide.request.ThumbnailRequestCoordinator(obj, requestCoordinator);
        com.bumptech.glide.request.Request obtainRequest = obtainRequest(obj, target, requestListener, baseRequestOptions, thumbnailRequestCoordinator2, transitionOptions, priority, i, i2, executor);
        this.isThumbnailBuilt = true;
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder2 = this.thumbnailBuilder;
        com.bumptech.glide.request.Request buildRequestRecursive = requestBuilder2.buildRequestRecursive(obj, target, requestListener, thumbnailRequestCoordinator2, transitionOptions2, priority2, overrideWidth, overrideHeight, requestBuilder2, executor);
        this.isThumbnailBuilt = false;
        thumbnailRequestCoordinator2.setRequests(obtainRequest, buildRequestRecursive);
        return thumbnailRequestCoordinator2;
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.Priority getThumbnailPriority(@androidx.annotation.NonNull com.bumptech.glide.Priority priority) {
        int i = com.bumptech.glide.RequestBuilder.AnonymousClass1.$SwitchMap$com$bumptech$glide$Priority[priority.ordinal()];
        if (i == 1) {
            return com.bumptech.glide.Priority.NORMAL;
        }
        if (i == 2) {
            return com.bumptech.glide.Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return com.bumptech.glide.Priority.IMMEDIATE;
        }
        throw new java.lang.IllegalArgumentException("unknown priority: " + getPriority());
    }

    @android.annotation.SuppressLint({"CheckResult"})
    private void initRequestListeners(java.util.List<com.bumptech.glide.request.RequestListener<java.lang.Object>> list) {
        java.util.Iterator<com.bumptech.glide.request.RequestListener<java.lang.Object>> it = list.iterator();
        while (it.hasNext()) {
            addListener((com.bumptech.glide.request.RequestListener) it.next());
        }
    }

    private <Y extends com.bumptech.glide.request.target.Target<TranscodeType>> Y into(@androidx.annotation.NonNull Y y, @androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, java.util.concurrent.Executor executor) {
        com.bumptech.glide.util.Preconditions.checkNotNull(y);
        if (!this.isModelSet) {
            throw new java.lang.IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.bumptech.glide.request.Request buildRequest = buildRequest(y, requestListener, baseRequestOptions, executor);
        com.bumptech.glide.request.Request request = y.getRequest();
        if (buildRequest.isEquivalentTo(request) && !isSkipMemoryCacheWithCompletePreviousRequest(baseRequestOptions, request)) {
            if (!((com.bumptech.glide.request.Request) com.bumptech.glide.util.Preconditions.checkNotNull(request)).isRunning()) {
                request.begin();
            }
            return y;
        }
        this.requestManager.clear((com.bumptech.glide.request.target.Target<?>) y);
        y.setRequest(buildRequest);
        this.requestManager.track(y, buildRequest);
        return y;
    }

    private boolean isSkipMemoryCacheWithCompletePreviousRequest(com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, com.bumptech.glide.request.Request request) {
        return !baseRequestOptions.isMemoryCacheable() && request.isComplete();
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.RequestBuilder<TranscodeType> loadGeneric(@androidx.annotation.Nullable java.lang.Object obj) {
        this.model = obj;
        this.isModelSet = true;
        return this;
    }

    private com.bumptech.glide.request.Request obtainRequest(java.lang.Object obj, com.bumptech.glide.request.target.Target<TranscodeType> target, com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions, com.bumptech.glide.request.RequestCoordinator requestCoordinator, com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions, com.bumptech.glide.Priority priority, int i, int i2, java.util.concurrent.Executor executor) {
        android.content.Context context = this.context;
        com.bumptech.glide.GlideContext glideContext = this.glideContext;
        return com.bumptech.glide.request.SingleRequest.obtain(context, glideContext, obj, this.model, this.transcodeClass, baseRequestOptions, i, i2, priority, target, requestListener, this.requestListeners, requestCoordinator, glideContext.getEngine(), transitionOptions.getTransitionFactory(), executor);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> addListener(@androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<TranscodeType> requestListener) {
        if (requestListener != null) {
            if (this.requestListeners == null) {
                this.requestListeners = new java.util.ArrayList();
            }
            this.requestListeners.add(requestListener);
        }
        return this;
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> apply(@androidx.annotation.NonNull com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions) {
        com.bumptech.glide.util.Preconditions.checkNotNull(baseRequestOptions);
        return (com.bumptech.glide.RequestBuilder) super.apply(baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public /* bridge */ /* synthetic */ com.bumptech.glide.request.BaseRequestOptions apply(@androidx.annotation.NonNull com.bumptech.glide.request.BaseRequestOptions baseRequestOptions) {
        return apply((com.bumptech.glide.request.BaseRequestOptions<?>) baseRequestOptions);
    }

    @Override // com.bumptech.glide.request.BaseRequestOptions
    @androidx.annotation.CheckResult
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.RequestBuilder<TranscodeType> mo46clone() {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = (com.bumptech.glide.RequestBuilder) super.mo46clone();
        requestBuilder.transitionOptions = (com.bumptech.glide.TransitionOptions<?, ? super TranscodeType>) requestBuilder.transitionOptions.m47clone();
        return requestBuilder;
    }

    @androidx.annotation.CheckResult
    @java.lang.Deprecated
    public com.bumptech.glide.request.FutureTarget<java.io.File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().submit(i, i2);
    }

    @androidx.annotation.CheckResult
    @java.lang.Deprecated
    public <Y extends com.bumptech.glide.request.target.Target<java.io.File>> Y downloadOnly(@androidx.annotation.NonNull Y y) {
        return (Y) getDownloadOnlyRequest().into((com.bumptech.glide.RequestBuilder<java.io.File>) y);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.RequestBuilder<TranscodeType> error(@androidx.annotation.Nullable com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        this.errorBuilder = requestBuilder;
        return this;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<java.io.File> getDownloadOnlyRequest() {
        return new com.bumptech.glide.RequestBuilder(java.io.File.class, this).apply((com.bumptech.glide.request.BaseRequestOptions<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    @java.lang.Deprecated
    public com.bumptech.glide.request.FutureTarget<TranscodeType> into(int i, int i2) {
        return submit(i, i2);
    }

    @androidx.annotation.NonNull
    public <Y extends com.bumptech.glide.request.target.Target<TranscodeType>> Y into(@androidx.annotation.NonNull Y y) {
        return (Y) into(y, null, com.bumptech.glide.util.Executors.mainThreadExecutor());
    }

    @androidx.annotation.NonNull
    public <Y extends com.bumptech.glide.request.target.Target<TranscodeType>> Y into(@androidx.annotation.NonNull Y y, @androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<TranscodeType> requestListener, java.util.concurrent.Executor executor) {
        return (Y) into(y, requestListener, this, executor);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.request.target.ViewTarget<android.widget.ImageView, TranscodeType> into(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder;
        com.bumptech.glide.util.Util.assertMainThread();
        com.bumptech.glide.util.Preconditions.checkNotNull(imageView);
        if (!isTransformationSet() && isTransformationAllowed() && imageView.getScaleType() != null) {
            switch (com.bumptech.glide.RequestBuilder.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                case 1:
                    requestBuilder = mo46clone().optionalCenterCrop();
                    break;
                case 2:
                    requestBuilder = mo46clone().optionalCenterInside();
                    break;
                case 3:
                case 4:
                case 5:
                    requestBuilder = mo46clone().optionalFitCenter();
                    break;
                case 6:
                    requestBuilder = mo46clone().optionalCenterInside();
                    break;
            }
            return (com.bumptech.glide.request.target.ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestBuilder, com.bumptech.glide.util.Executors.mainThreadExecutor());
        }
        requestBuilder = this;
        return (com.bumptech.glide.request.target.ViewTarget) into(this.glideContext.buildImageViewTarget(imageView, this.transcodeClass), null, requestBuilder, com.bumptech.glide.util.Executors.mainThreadExecutor());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> listener(@androidx.annotation.Nullable com.bumptech.glide.request.RequestListener<TranscodeType> requestListener) {
        this.requestListeners = null;
        return addListener(requestListener);
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        return loadGeneric(bitmap).apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return loadGeneric(drawable).apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE));
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable android.net.Uri uri) {
        return loadGeneric(uri);
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable java.io.File file) {
        return loadGeneric(file);
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable @androidx.annotation.DrawableRes @androidx.annotation.RawRes java.lang.Integer num) {
        return loadGeneric(num).apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.signatureOf(com.bumptech.glide.signature.AndroidResourceSignature.obtain(this.context)));
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable java.lang.Object obj) {
        return loadGeneric(obj);
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable java.lang.String str) {
        return loadGeneric(str);
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.CheckResult
    @java.lang.Deprecated
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable java.net.URL url) {
        return loadGeneric(url);
    }

    @Override // com.bumptech.glide.ModelTypes
    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> load(@androidx.annotation.Nullable byte[] bArr) {
        com.bumptech.glide.RequestBuilder<TranscodeType> loadGeneric = loadGeneric(bArr);
        if (!loadGeneric.isDiskCacheStrategySet()) {
            loadGeneric = loadGeneric.apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.diskCacheStrategyOf(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE));
        }
        return !loadGeneric.isSkipMemoryCacheSet() ? loadGeneric.apply((com.bumptech.glide.request.BaseRequestOptions<?>) com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf(true)) : loadGeneric;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.request.target.Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.request.target.Target<TranscodeType> preload(int i, int i2) {
        return into((com.bumptech.glide.RequestBuilder<TranscodeType>) com.bumptech.glide.request.target.PreloadTarget.obtain(this.requestManager, i, i2));
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.request.FutureTarget<TranscodeType> submit() {
        return submit(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.request.FutureTarget<TranscodeType> submit(int i, int i2) {
        com.bumptech.glide.request.RequestFutureTarget requestFutureTarget = new com.bumptech.glide.request.RequestFutureTarget(i, i2);
        return (com.bumptech.glide.request.FutureTarget) into(requestFutureTarget, requestFutureTarget, com.bumptech.glide.util.Executors.directExecutor());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.thumbSizeMultiplier = java.lang.Float.valueOf(f);
        return this;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(@androidx.annotation.Nullable com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder) {
        this.thumbnailBuilder = requestBuilder;
        return this;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> thumbnail(@androidx.annotation.Nullable com.bumptech.glide.RequestBuilder<TranscodeType>... requestBuilderArr) {
        com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder = null;
        if (requestBuilderArr == null || requestBuilderArr.length == 0) {
            return thumbnail((com.bumptech.glide.RequestBuilder) null);
        }
        for (int length = requestBuilderArr.length - 1; length >= 0; length--) {
            com.bumptech.glide.RequestBuilder<TranscodeType> requestBuilder2 = requestBuilderArr[length];
            if (requestBuilder2 != null) {
                requestBuilder = requestBuilder == null ? requestBuilder2 : requestBuilder2.thumbnail(requestBuilder);
            }
        }
        return thumbnail(requestBuilder);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public com.bumptech.glide.RequestBuilder<TranscodeType> transition(@androidx.annotation.NonNull com.bumptech.glide.TransitionOptions<?, ? super TranscodeType> transitionOptions) {
        this.transitionOptions = (com.bumptech.glide.TransitionOptions) com.bumptech.glide.util.Preconditions.checkNotNull(transitionOptions);
        this.isDefaultTransitionOptionsSet = false;
        return this;
    }
}
