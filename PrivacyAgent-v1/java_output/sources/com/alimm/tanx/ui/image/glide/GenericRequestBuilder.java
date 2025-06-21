package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> implements java.lang.Cloneable {
    private com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<TranscodeType> animationFactory;
    protected final android.content.Context context;
    private com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private android.graphics.drawable.Drawable errorPlaceholder;
    private android.graphics.drawable.Drawable fallbackDrawable;
    private int fallbackResource;
    protected final com.alimm.tanx.ui.image.glide.Glide glide;
    private boolean isCacheable;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private boolean isTransformationSet;
    protected final com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle;
    private com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider;
    private ModelType model;
    protected final java.lang.Class<ModelType> modelClass;
    private int overrideHeight;
    private int overrideWidth;
    private android.graphics.drawable.Drawable placeholderDrawable;
    private int placeholderId;
    private com.alimm.tanx.ui.image.glide.Priority priority;
    private com.alimm.tanx.ui.image.glide.request.RequestListener<? super ModelType, TranscodeType> requestListener;
    protected final com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker;
    private com.alimm.tanx.ui.image.glide.load.Key signature;
    private java.lang.Float sizeMultiplier;
    private java.lang.Float thumbSizeMultiplier;
    private com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, TranscodeType> thumbnailRequestBuilder;
    protected final java.lang.Class<TranscodeType> transcodeClass;
    private com.alimm.tanx.ui.image.glide.load.Transformation<ResourceType> transformation;

    /* renamed from: com.alimm.tanx.ui.image.glide.GenericRequestBuilder$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alimm.tanx.ui.image.glide.request.RequestFutureTarget val$target;

        public AnonymousClass1(com.alimm.tanx.ui.image.glide.request.RequestFutureTarget requestFutureTarget) {
            this.val$target = requestFutureTarget;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$target.isCancelled()) {
                return;
            }
            com.alimm.tanx.ui.image.glide.GenericRequestBuilder.this.into((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) this.val$target);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.GenericRequestBuilder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[android.widget.ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[android.widget.ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[android.widget.ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    public GenericRequestBuilder(android.content.Context context, java.lang.Class<ModelType> cls, com.alimm.tanx.ui.image.glide.provider.LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, java.lang.Class<TranscodeType> cls2, com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker, com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle) {
        this.signature = com.alimm.tanx.ui.image.glide.signature.EmptySignature.obtain();
        this.sizeMultiplier = java.lang.Float.valueOf(1.0f);
        this.priority = null;
        this.isCacheable = true;
        this.animationFactory = com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.getFactory();
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.diskCacheStrategy = com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy.RESULT;
        this.transformation = com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation.get();
        this.context = context;
        this.modelClass = cls;
        this.transcodeClass = cls2;
        this.glide = glide;
        this.requestTracker = requestTracker;
        this.lifecycle = lifecycle;
        this.loadProvider = loadProvider != null ? new com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<>(loadProvider) : null;
        if (context == null) {
            throw new java.lang.NullPointerException("Context can't be null");
        }
        if (cls != null && loadProvider == null) {
            throw new java.lang.NullPointerException("LoadProvider must not be null");
        }
    }

    public GenericRequestBuilder(com.alimm.tanx.ui.image.glide.provider.LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, java.lang.Class<TranscodeType> cls, com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        this(genericRequestBuilder.context, genericRequestBuilder.modelClass, loadProvider, cls, genericRequestBuilder.glide, genericRequestBuilder.requestTracker, genericRequestBuilder.lifecycle);
        this.model = genericRequestBuilder.model;
        this.isModelSet = genericRequestBuilder.isModelSet;
        this.signature = genericRequestBuilder.signature;
        this.diskCacheStrategy = genericRequestBuilder.diskCacheStrategy;
        this.isCacheable = genericRequestBuilder.isCacheable;
    }

    private com.alimm.tanx.ui.image.glide.request.Request buildRequest(com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> target) {
        if (this.priority == null) {
            this.priority = com.alimm.tanx.ui.image.glide.Priority.NORMAL;
        }
        return buildRequestRecursive(target, null);
    }

    private com.alimm.tanx.ui.image.glide.request.Request buildRequestRecursive(com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> target, com.alimm.tanx.ui.image.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder = this.thumbnailRequestBuilder;
        if (genericRequestBuilder == null) {
            if (this.thumbSizeMultiplier == null) {
                return obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator);
            }
            com.alimm.tanx.ui.image.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator2 = new com.alimm.tanx.ui.image.glide.request.ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
            thumbnailRequestCoordinator2.setRequests(obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator2), obtainRequest(target, this.thumbSizeMultiplier.floatValue(), getThumbnailPriority(), thumbnailRequestCoordinator2));
            return thumbnailRequestCoordinator2;
        }
        if (this.isThumbnailBuilt) {
            throw new java.lang.IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (genericRequestBuilder.animationFactory.equals(com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.getFactory())) {
            this.thumbnailRequestBuilder.animationFactory = this.animationFactory;
        }
        com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder2 = this.thumbnailRequestBuilder;
        if (genericRequestBuilder2.priority == null) {
            genericRequestBuilder2.priority = getThumbnailPriority();
        }
        if (com.alimm.tanx.ui.image.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder3 = this.thumbnailRequestBuilder;
            if (!com.alimm.tanx.ui.image.glide.util.Util.isValidDimensions(genericRequestBuilder3.overrideWidth, genericRequestBuilder3.overrideHeight)) {
                this.thumbnailRequestBuilder.override(this.overrideWidth, this.overrideHeight);
            }
        }
        com.alimm.tanx.ui.image.glide.request.ThumbnailRequestCoordinator thumbnailRequestCoordinator3 = new com.alimm.tanx.ui.image.glide.request.ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
        com.alimm.tanx.ui.image.glide.request.Request obtainRequest = obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator3);
        this.isThumbnailBuilt = true;
        com.alimm.tanx.ui.image.glide.request.Request buildRequestRecursive = this.thumbnailRequestBuilder.buildRequestRecursive(target, thumbnailRequestCoordinator3);
        this.isThumbnailBuilt = false;
        thumbnailRequestCoordinator3.setRequests(obtainRequest, buildRequestRecursive);
        return thumbnailRequestCoordinator3;
    }

    private com.alimm.tanx.ui.image.glide.Priority getThumbnailPriority() {
        com.alimm.tanx.ui.image.glide.Priority priority = this.priority;
        return priority == com.alimm.tanx.ui.image.glide.Priority.LOW ? com.alimm.tanx.ui.image.glide.Priority.NORMAL : priority == com.alimm.tanx.ui.image.glide.Priority.NORMAL ? com.alimm.tanx.ui.image.glide.Priority.HIGH : com.alimm.tanx.ui.image.glide.Priority.IMMEDIATE;
    }

    private com.alimm.tanx.ui.image.glide.request.Request obtainRequest(com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> target, float f, com.alimm.tanx.ui.image.glide.Priority priority, com.alimm.tanx.ui.image.glide.request.RequestCoordinator requestCoordinator) {
        return com.alimm.tanx.ui.image.glide.request.GenericRequest.obtain(this.loadProvider, this.model, this.signature, this.context, priority, target, f, this.placeholderDrawable, this.placeholderId, this.errorPlaceholder, this.errorId, this.fallbackDrawable, this.fallbackResource, this.requestListener, requestCoordinator, this.glide.getEngine(), this.transformation, this.transcodeClass, this.isCacheable, this.animationFactory, this.overrideWidth, this.overrideHeight, this.diskCacheStrategy);
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(int i) {
        return animate(new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory(this.context, i));
    }

    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(android.view.animation.Animation animation) {
        return animate(new com.alimm.tanx.ui.image.glide.request.animation.ViewAnimationFactory(animation));
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        if (glideAnimationFactory == null) {
            throw new java.lang.NullPointerException("Animation factory must not be null!");
        }
        this.animationFactory = glideAnimationFactory;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator) {
        return animate(new com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimationFactory(animator));
    }

    public void applyCenterCrop() {
    }

    public void applyFitCenter() {
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> cacheDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, ResourceType> resourceDecoder) {
        com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setCacheDecoder(resourceDecoder);
        }
        return this;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> mo9clone() {
        try {
            com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> genericRequestBuilder = (com.alimm.tanx.ui.image.glide.GenericRequestBuilder) super.clone();
            com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
            genericRequestBuilder.loadProvider = childLoadProvider != null ? childLoadProvider.m10clone() : null;
            return genericRequestBuilder;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> decoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<DataType, ResourceType> resourceDecoder) {
        com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setSourceDecoder(resourceDecoder);
        }
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        this.diskCacheStrategy = diskCacheStrategy;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> dontAnimate() {
        return animate(com.alimm.tanx.ui.image.glide.request.animation.NoAnimation.getFactory());
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> dontTransform() {
        return transform(com.alimm.tanx.ui.image.glide.load.resource.UnitTransformation.get());
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> encoder(com.alimm.tanx.ui.image.glide.load.ResourceEncoder<ResourceType> resourceEncoder) {
        com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setEncoder(resourceEncoder);
        }
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> error(int i) {
        this.errorId = i;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> error(android.graphics.drawable.Drawable drawable) {
        this.errorPlaceholder = drawable;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> fallback(int i) {
        this.fallbackResource = i;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> fallback(android.graphics.drawable.Drawable drawable) {
        this.fallbackDrawable = drawable;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.request.FutureTarget<TranscodeType> into(int i, int i2) {
        com.alimm.tanx.ui.image.glide.request.RequestFutureTarget requestFutureTarget = new com.alimm.tanx.ui.image.glide.request.RequestFutureTarget(this.glide.getMainHandler(), i, i2);
        this.glide.getMainHandler().post(new com.alimm.tanx.ui.image.glide.GenericRequestBuilder.AnonymousClass1(requestFutureTarget));
        return requestFutureTarget;
    }

    public com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> into(android.widget.ImageView imageView) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (imageView == null) {
            throw new java.lang.IllegalArgumentException("You must pass in a non null View");
        }
        if (!this.isTransformationSet && imageView.getScaleType() != null) {
            int i = com.alimm.tanx.ui.image.glide.GenericRequestBuilder.AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()];
            if (i == 1) {
                applyCenterCrop();
            } else if (i == 2 || i == 3 || i == 4) {
                applyFitCenter();
            }
        }
        return into((com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType>) this.glide.buildImageViewTarget(imageView, this.transcodeClass));
    }

    public <Y extends com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType>> Y into(Y y) {
        com.alimm.tanx.ui.image.glide.util.Util.assertMainThread();
        if (y == null) {
            throw new java.lang.IllegalArgumentException("You must pass in a non null Target");
        }
        if (!this.isModelSet) {
            throw new java.lang.IllegalArgumentException("You must first set a model (try #load())");
        }
        com.alimm.tanx.ui.image.glide.request.Request request = y.getRequest();
        if (request != null) {
            request.clear();
            this.requestTracker.removeRequest(request);
            request.recycle();
        }
        com.alimm.tanx.ui.image.glide.request.Request buildRequest = buildRequest(y);
        y.setRequest(buildRequest);
        this.lifecycle.addListener(y);
        this.requestTracker.runRequest(buildRequest);
        return y;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> listener(com.alimm.tanx.ui.image.glide.request.RequestListener<? super ModelType, TranscodeType> requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> load(ModelType modeltype) {
        this.model = modeltype;
        this.isModelSet = true;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> override(int i, int i2) {
        if (!com.alimm.tanx.ui.image.glide.util.Util.isValidDimensions(i, i2)) {
            throw new java.lang.IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
        }
        this.overrideWidth = i;
        this.overrideHeight = i2;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> placeholder(int i) {
        this.placeholderId = i;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> placeholder(android.graphics.drawable.Drawable drawable) {
        this.placeholderDrawable = drawable;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> preload(int i, int i2) {
        return into((com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType>) com.alimm.tanx.ui.image.glide.request.target.PreloadTarget.obtain(i, i2));
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> priority(com.alimm.tanx.ui.image.glide.Priority priority) {
        this.priority = priority;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> signature(com.alimm.tanx.ui.image.glide.load.Key key) {
        if (key == null) {
            throw new java.lang.NullPointerException("Signature must not be null");
        }
        this.signature = key;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> sizeMultiplier(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = java.lang.Float.valueOf(f);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> skipMemoryCache(boolean z) {
        this.isCacheable = !z;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> sourceEncoder(com.alimm.tanx.ui.image.glide.load.Encoder<DataType> encoder) {
        com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setSourceEncoder(encoder);
        }
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> thumbnail(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.thumbSizeMultiplier = java.lang.Float.valueOf(f);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> thumbnail(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        if (equals(genericRequestBuilder)) {
            throw new java.lang.IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
        }
        this.thumbnailRequestBuilder = genericRequestBuilder;
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<ResourceType, TranscodeType> resourceTranscoder) {
        com.alimm.tanx.ui.image.glide.provider.ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> childLoadProvider = this.loadProvider;
        if (childLoadProvider != null) {
            childLoadProvider.setTranscoder(resourceTranscoder);
        }
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transform(com.alimm.tanx.ui.image.glide.load.Transformation<ResourceType>... transformationArr) {
        this.isTransformationSet = true;
        if (transformationArr.length == 1) {
            this.transformation = transformationArr[0];
        } else {
            this.transformation = new com.alimm.tanx.ui.image.glide.load.MultiTransformation(transformationArr);
        }
        return this;
    }
}
