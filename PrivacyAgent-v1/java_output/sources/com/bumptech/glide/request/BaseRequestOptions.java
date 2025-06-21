package com.bumptech.glide.request;

/* loaded from: classes.dex */
public abstract class BaseRequestOptions<T extends com.bumptech.glide.request.BaseRequestOptions<T>> implements java.lang.Cloneable {
    private static final int DISK_CACHE_STRATEGY = 4;
    private static final int ERROR_ID = 32;
    private static final int ERROR_PLACEHOLDER = 16;
    private static final int FALLBACK = 8192;
    private static final int FALLBACK_ID = 16384;
    private static final int IS_CACHEABLE = 256;
    private static final int ONLY_RETRIEVE_FROM_CACHE = 524288;
    private static final int OVERRIDE = 512;
    private static final int PLACEHOLDER = 64;
    private static final int PLACEHOLDER_ID = 128;
    private static final int PRIORITY = 8;
    private static final int RESOURCE_CLASS = 4096;
    private static final int SIGNATURE = 1024;
    private static final int SIZE_MULTIPLIER = 2;
    private static final int THEME = 32768;
    private static final int TRANSFORMATION = 2048;
    private static final int TRANSFORMATION_ALLOWED = 65536;
    private static final int TRANSFORMATION_REQUIRED = 131072;
    private static final int UNSET = -1;
    private static final int USE_ANIMATION_POOL = 1048576;
    private static final int USE_UNLIMITED_SOURCE_GENERATORS_POOL = 262144;
    private int errorId;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable errorPlaceholder;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable fallbackDrawable;
    private int fallbackId;
    private int fields;
    private boolean isAutoCloneEnabled;
    private boolean isLocked;
    private boolean isTransformationRequired;
    private boolean onlyRetrieveFromCache;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable placeholderDrawable;
    private int placeholderId;

    @androidx.annotation.Nullable
    private android.content.res.Resources.Theme theme;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorsPool;
    private float sizeMultiplier = 1.0f;

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy = com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC;

    @androidx.annotation.NonNull
    private com.bumptech.glide.Priority priority = com.bumptech.glide.Priority.NORMAL;
    private boolean isCacheable = true;
    private int overrideHeight = -1;
    private int overrideWidth = -1;

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.Key signature = com.bumptech.glide.signature.EmptySignature.obtain();
    private boolean isTransformationAllowed = true;

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.Options options = new com.bumptech.glide.load.Options();

    @androidx.annotation.NonNull
    private java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> transformations = new com.bumptech.glide.util.CachedHashCodeArrayMap();

    @androidx.annotation.NonNull
    private java.lang.Class<?> resourceClass = java.lang.Object.class;
    private boolean isScaleOnlyOrNoTransform = true;

    private boolean isSet(int i) {
        return isSet(this.fields, i);
    }

    private static boolean isSet(int i, int i2) {
        return (i & i2) != 0;
    }

    @androidx.annotation.NonNull
    private T optionalScaleOnlyTransform(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, false);
    }

    @androidx.annotation.NonNull
    private T scaleOnlyTransform(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return scaleOnlyTransform(downsampleStrategy, transformation, true);
    }

    @androidx.annotation.NonNull
    private T scaleOnlyTransform(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, boolean z) {
        T transform = z ? transform(downsampleStrategy, transformation) : optionalTransform(downsampleStrategy, transformation);
        transform.isScaleOnlyOrNoTransform = true;
        return transform;
    }

    private T self() {
        return this;
    }

    @androidx.annotation.NonNull
    private T selfOrThrowIfLocked() {
        if (this.isLocked) {
            throw new java.lang.IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return self();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T apply(@androidx.annotation.NonNull com.bumptech.glide.request.BaseRequestOptions<?> baseRequestOptions) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().apply(baseRequestOptions);
        }
        if (isSet(baseRequestOptions.fields, 2)) {
            this.sizeMultiplier = baseRequestOptions.sizeMultiplier;
        }
        if (isSet(baseRequestOptions.fields, 262144)) {
            this.useUnlimitedSourceGeneratorsPool = baseRequestOptions.useUnlimitedSourceGeneratorsPool;
        }
        if (isSet(baseRequestOptions.fields, 1048576)) {
            this.useAnimationPool = baseRequestOptions.useAnimationPool;
        }
        if (isSet(baseRequestOptions.fields, 4)) {
            this.diskCacheStrategy = baseRequestOptions.diskCacheStrategy;
        }
        if (isSet(baseRequestOptions.fields, 8)) {
            this.priority = baseRequestOptions.priority;
        }
        if (isSet(baseRequestOptions.fields, 16)) {
            this.errorPlaceholder = baseRequestOptions.errorPlaceholder;
            this.errorId = 0;
            this.fields &= -33;
        }
        if (isSet(baseRequestOptions.fields, 32)) {
            this.errorId = baseRequestOptions.errorId;
            this.errorPlaceholder = null;
            this.fields &= -17;
        }
        if (isSet(baseRequestOptions.fields, 64)) {
            this.placeholderDrawable = baseRequestOptions.placeholderDrawable;
            this.placeholderId = 0;
            this.fields &= -129;
        }
        if (isSet(baseRequestOptions.fields, 128)) {
            this.placeholderId = baseRequestOptions.placeholderId;
            this.placeholderDrawable = null;
            this.fields &= -65;
        }
        if (isSet(baseRequestOptions.fields, 256)) {
            this.isCacheable = baseRequestOptions.isCacheable;
        }
        if (isSet(baseRequestOptions.fields, 512)) {
            this.overrideWidth = baseRequestOptions.overrideWidth;
            this.overrideHeight = baseRequestOptions.overrideHeight;
        }
        if (isSet(baseRequestOptions.fields, 1024)) {
            this.signature = baseRequestOptions.signature;
        }
        if (isSet(baseRequestOptions.fields, 4096)) {
            this.resourceClass = baseRequestOptions.resourceClass;
        }
        if (isSet(baseRequestOptions.fields, 8192)) {
            this.fallbackDrawable = baseRequestOptions.fallbackDrawable;
            this.fallbackId = 0;
            this.fields &= -16385;
        }
        if (isSet(baseRequestOptions.fields, 16384)) {
            this.fallbackId = baseRequestOptions.fallbackId;
            this.fallbackDrawable = null;
            this.fields &= -8193;
        }
        if (isSet(baseRequestOptions.fields, 32768)) {
            this.theme = baseRequestOptions.theme;
        }
        if (isSet(baseRequestOptions.fields, 65536)) {
            this.isTransformationAllowed = baseRequestOptions.isTransformationAllowed;
        }
        if (isSet(baseRequestOptions.fields, 131072)) {
            this.isTransformationRequired = baseRequestOptions.isTransformationRequired;
        }
        if (isSet(baseRequestOptions.fields, 2048)) {
            this.transformations.putAll(baseRequestOptions.transformations);
            this.isScaleOnlyOrNoTransform = baseRequestOptions.isScaleOnlyOrNoTransform;
        }
        if (isSet(baseRequestOptions.fields, 524288)) {
            this.onlyRetrieveFromCache = baseRequestOptions.onlyRetrieveFromCache;
        }
        if (!this.isTransformationAllowed) {
            this.transformations.clear();
            int i = this.fields & (-2049);
            this.isTransformationRequired = false;
            this.fields = i & (-131073);
            this.isScaleOnlyOrNoTransform = true;
        }
        this.fields |= baseRequestOptions.fields;
        this.options.putAll(baseRequestOptions.options);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    public T autoClone() {
        if (this.isLocked && !this.isAutoCloneEnabled) {
            throw new java.lang.IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.isAutoCloneEnabled = true;
        return lock();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T centerCrop() {
        return transform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.CENTER_OUTSIDE, new com.bumptech.glide.load.resource.bitmap.CenterCrop());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T centerInside() {
        return scaleOnlyTransform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.CENTER_INSIDE, new com.bumptech.glide.load.resource.bitmap.CenterInside());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T circleCrop() {
        return transform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.CENTER_INSIDE, new com.bumptech.glide.load.resource.bitmap.CircleCrop());
    }

    @Override // 
    @androidx.annotation.CheckResult
    /* renamed from: clone */
    public T mo46clone() {
        try {
            T t = (T) super.clone();
            com.bumptech.glide.load.Options options = new com.bumptech.glide.load.Options();
            t.options = options;
            options.putAll(this.options);
            com.bumptech.glide.util.CachedHashCodeArrayMap cachedHashCodeArrayMap = new com.bumptech.glide.util.CachedHashCodeArrayMap();
            t.transformations = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.transformations);
            t.isLocked = false;
            t.isAutoCloneEnabled = false;
            return t;
        } catch (java.lang.CloneNotSupportedException e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T decode(@androidx.annotation.NonNull java.lang.Class<?> cls) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().decode(cls);
        }
        this.resourceClass = (java.lang.Class) com.bumptech.glide.util.Preconditions.checkNotNull(cls);
        this.fields |= 4096;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T disallowHardwareConfig() {
        return set(com.bumptech.glide.load.resource.bitmap.Downsampler.ALLOW_HARDWARE_CONFIG, java.lang.Boolean.FALSE);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T diskCacheStrategy(@androidx.annotation.NonNull com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().diskCacheStrategy(diskCacheStrategy);
        }
        this.diskCacheStrategy = (com.bumptech.glide.load.engine.DiskCacheStrategy) com.bumptech.glide.util.Preconditions.checkNotNull(diskCacheStrategy);
        this.fields |= 4;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T dontAnimate() {
        return set(com.bumptech.glide.load.resource.gif.GifOptions.DISABLE_ANIMATION, java.lang.Boolean.TRUE);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T dontTransform() {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().dontTransform();
        }
        this.transformations.clear();
        int i = this.fields & (-2049);
        this.isTransformationRequired = false;
        this.isTransformationAllowed = false;
        this.fields = (i & (-131073)) | 65536;
        this.isScaleOnlyOrNoTransform = true;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T downsample(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        return set(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.OPTION, com.bumptech.glide.util.Preconditions.checkNotNull(downsampleStrategy));
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T encodeFormat(@androidx.annotation.NonNull android.graphics.Bitmap.CompressFormat compressFormat) {
        return set(com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_FORMAT, com.bumptech.glide.util.Preconditions.checkNotNull(compressFormat));
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T encodeQuality(@androidx.annotation.IntRange(from = 0, to = 100) int i) {
        return set(com.bumptech.glide.load.resource.bitmap.BitmapEncoder.COMPRESSION_QUALITY, java.lang.Integer.valueOf(i));
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.bumptech.glide.request.BaseRequestOptions)) {
            return false;
        }
        com.bumptech.glide.request.BaseRequestOptions baseRequestOptions = (com.bumptech.glide.request.BaseRequestOptions) obj;
        return java.lang.Float.compare(baseRequestOptions.sizeMultiplier, this.sizeMultiplier) == 0 && this.errorId == baseRequestOptions.errorId && com.bumptech.glide.util.Util.bothNullOrEqual(this.errorPlaceholder, baseRequestOptions.errorPlaceholder) && this.placeholderId == baseRequestOptions.placeholderId && com.bumptech.glide.util.Util.bothNullOrEqual(this.placeholderDrawable, baseRequestOptions.placeholderDrawable) && this.fallbackId == baseRequestOptions.fallbackId && com.bumptech.glide.util.Util.bothNullOrEqual(this.fallbackDrawable, baseRequestOptions.fallbackDrawable) && this.isCacheable == baseRequestOptions.isCacheable && this.overrideHeight == baseRequestOptions.overrideHeight && this.overrideWidth == baseRequestOptions.overrideWidth && this.isTransformationRequired == baseRequestOptions.isTransformationRequired && this.isTransformationAllowed == baseRequestOptions.isTransformationAllowed && this.useUnlimitedSourceGeneratorsPool == baseRequestOptions.useUnlimitedSourceGeneratorsPool && this.onlyRetrieveFromCache == baseRequestOptions.onlyRetrieveFromCache && this.diskCacheStrategy.equals(baseRequestOptions.diskCacheStrategy) && this.priority == baseRequestOptions.priority && this.options.equals(baseRequestOptions.options) && this.transformations.equals(baseRequestOptions.transformations) && this.resourceClass.equals(baseRequestOptions.resourceClass) && com.bumptech.glide.util.Util.bothNullOrEqual(this.signature, baseRequestOptions.signature) && com.bumptech.glide.util.Util.bothNullOrEqual(this.theme, baseRequestOptions.theme);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T error(@androidx.annotation.DrawableRes int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().error(i);
        }
        this.errorId = i;
        int i2 = this.fields | 32;
        this.errorPlaceholder = null;
        this.fields = i2 & (-17);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T error(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().error(drawable);
        }
        this.errorPlaceholder = drawable;
        int i = this.fields | 16;
        this.errorId = 0;
        this.fields = i & (-33);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T fallback(@androidx.annotation.DrawableRes int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().fallback(i);
        }
        this.fallbackId = i;
        int i2 = this.fields | 16384;
        this.fallbackDrawable = null;
        this.fields = i2 & (-8193);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T fallback(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().fallback(drawable);
        }
        this.fallbackDrawable = drawable;
        int i = this.fields | 8192;
        this.fallbackId = 0;
        this.fields = i & (-16385);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T fitCenter() {
        return scaleOnlyTransform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.FIT_CENTER, new com.bumptech.glide.load.resource.bitmap.FitCenter());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T format(@androidx.annotation.NonNull com.bumptech.glide.load.DecodeFormat decodeFormat) {
        com.bumptech.glide.util.Preconditions.checkNotNull(decodeFormat);
        return (T) set(com.bumptech.glide.load.resource.bitmap.Downsampler.DECODE_FORMAT, decodeFormat).set(com.bumptech.glide.load.resource.gif.GifOptions.DECODE_FORMAT, decodeFormat);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T frame(@androidx.annotation.IntRange(from = 0) long j) {
        return set(com.bumptech.glide.load.resource.bitmap.VideoDecoder.TARGET_FRAME, java.lang.Long.valueOf(j));
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.load.engine.DiskCacheStrategy getDiskCacheStrategy() {
        return this.diskCacheStrategy;
    }

    public final int getErrorId() {
        return this.errorId;
    }

    @androidx.annotation.Nullable
    public final android.graphics.drawable.Drawable getErrorPlaceholder() {
        return this.errorPlaceholder;
    }

    @androidx.annotation.Nullable
    public final android.graphics.drawable.Drawable getFallbackDrawable() {
        return this.fallbackDrawable;
    }

    public final int getFallbackId() {
        return this.fallbackId;
    }

    public final boolean getOnlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.load.Options getOptions() {
        return this.options;
    }

    public final int getOverrideHeight() {
        return this.overrideHeight;
    }

    public final int getOverrideWidth() {
        return this.overrideWidth;
    }

    @androidx.annotation.Nullable
    public final android.graphics.drawable.Drawable getPlaceholderDrawable() {
        return this.placeholderDrawable;
    }

    public final int getPlaceholderId() {
        return this.placeholderId;
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.Priority getPriority() {
        return this.priority;
    }

    @androidx.annotation.NonNull
    public final java.lang.Class<?> getResourceClass() {
        return this.resourceClass;
    }

    @androidx.annotation.NonNull
    public final com.bumptech.glide.load.Key getSignature() {
        return this.signature;
    }

    public final float getSizeMultiplier() {
        return this.sizeMultiplier;
    }

    @androidx.annotation.Nullable
    public final android.content.res.Resources.Theme getTheme() {
        return this.theme;
    }

    @androidx.annotation.NonNull
    public final java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> getTransformations() {
        return this.transformations;
    }

    public final boolean getUseAnimationPool() {
        return this.useAnimationPool;
    }

    public final boolean getUseUnlimitedSourceGeneratorsPool() {
        return this.useUnlimitedSourceGeneratorsPool;
    }

    public int hashCode() {
        return com.bumptech.glide.util.Util.hashCode(this.theme, com.bumptech.glide.util.Util.hashCode(this.signature, com.bumptech.glide.util.Util.hashCode(this.resourceClass, com.bumptech.glide.util.Util.hashCode(this.transformations, com.bumptech.glide.util.Util.hashCode(this.options, com.bumptech.glide.util.Util.hashCode(this.priority, com.bumptech.glide.util.Util.hashCode(this.diskCacheStrategy, com.bumptech.glide.util.Util.hashCode(this.onlyRetrieveFromCache, com.bumptech.glide.util.Util.hashCode(this.useUnlimitedSourceGeneratorsPool, com.bumptech.glide.util.Util.hashCode(this.isTransformationAllowed, com.bumptech.glide.util.Util.hashCode(this.isTransformationRequired, com.bumptech.glide.util.Util.hashCode(this.overrideWidth, com.bumptech.glide.util.Util.hashCode(this.overrideHeight, com.bumptech.glide.util.Util.hashCode(this.isCacheable, com.bumptech.glide.util.Util.hashCode(this.fallbackDrawable, com.bumptech.glide.util.Util.hashCode(this.fallbackId, com.bumptech.glide.util.Util.hashCode(this.placeholderDrawable, com.bumptech.glide.util.Util.hashCode(this.placeholderId, com.bumptech.glide.util.Util.hashCode(this.errorPlaceholder, com.bumptech.glide.util.Util.hashCode(this.errorId, com.bumptech.glide.util.Util.hashCode(this.sizeMultiplier)))))))))))))))))))));
    }

    public boolean isAutoCloneEnabled() {
        return this.isAutoCloneEnabled;
    }

    public final boolean isDiskCacheStrategySet() {
        return isSet(4);
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    public final boolean isMemoryCacheable() {
        return this.isCacheable;
    }

    public final boolean isPrioritySet() {
        return isSet(8);
    }

    public boolean isScaleOnlyOrNoTransform() {
        return this.isScaleOnlyOrNoTransform;
    }

    public final boolean isSkipMemoryCacheSet() {
        return isSet(256);
    }

    public final boolean isTransformationAllowed() {
        return this.isTransformationAllowed;
    }

    public final boolean isTransformationRequired() {
        return this.isTransformationRequired;
    }

    public final boolean isTransformationSet() {
        return isSet(2048);
    }

    public final boolean isValidOverride() {
        return com.bumptech.glide.util.Util.isValidDimensions(this.overrideWidth, this.overrideHeight);
    }

    @androidx.annotation.NonNull
    public T lock() {
        this.isLocked = true;
        return self();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T onlyRetrieveFromCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().onlyRetrieveFromCache(z);
        }
        this.onlyRetrieveFromCache = z;
        this.fields |= 524288;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T optionalCenterCrop() {
        return optionalTransform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.CENTER_OUTSIDE, new com.bumptech.glide.load.resource.bitmap.CenterCrop());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T optionalCenterInside() {
        return optionalScaleOnlyTransform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.CENTER_INSIDE, new com.bumptech.glide.load.resource.bitmap.CenterInside());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T optionalCircleCrop() {
        return optionalTransform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.CENTER_OUTSIDE, new com.bumptech.glide.load.resource.bitmap.CircleCrop());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T optionalFitCenter() {
        return optionalScaleOnlyTransform(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.FIT_CENTER, new com.bumptech.glide.load.resource.bitmap.FitCenter());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T optionalTransform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return transform(transformation, false);
    }

    @androidx.annotation.NonNull
    public final T optionalTransform(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().optionalTransform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation, false);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public <Y> T optionalTransform(@androidx.annotation.NonNull java.lang.Class<Y> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> transformation) {
        return transform(cls, transformation, false);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T override(int i) {
        return override(i, i);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T override(int i, int i2) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().override(i, i2);
        }
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.fields |= 512;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T placeholder(@androidx.annotation.DrawableRes int i) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().placeholder(i);
        }
        this.placeholderId = i;
        int i2 = this.fields | 128;
        this.placeholderDrawable = null;
        this.fields = i2 & (-65);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T placeholder(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().placeholder(drawable);
        }
        this.placeholderDrawable = drawable;
        int i = this.fields | 64;
        this.placeholderId = 0;
        this.fields = i & (-129);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T priority(@androidx.annotation.NonNull com.bumptech.glide.Priority priority) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().priority(priority);
        }
        this.priority = (com.bumptech.glide.Priority) com.bumptech.glide.util.Preconditions.checkNotNull(priority);
        this.fields |= 8;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public <Y> T set(@androidx.annotation.NonNull com.bumptech.glide.load.Option<Y> option, @androidx.annotation.NonNull Y y) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().set(option, y);
        }
        com.bumptech.glide.util.Preconditions.checkNotNull(option);
        com.bumptech.glide.util.Preconditions.checkNotNull(y);
        this.options.set(option, y);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T signature(@androidx.annotation.NonNull com.bumptech.glide.load.Key key) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().signature(key);
        }
        this.signature = (com.bumptech.glide.load.Key) com.bumptech.glide.util.Preconditions.checkNotNull(key);
        this.fields |= 1024;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T sizeMultiplier(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().sizeMultiplier(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new java.lang.IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.sizeMultiplier = f;
        this.fields |= 2;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T skipMemoryCache(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().skipMemoryCache(true);
        }
        this.isCacheable = !z;
        this.fields |= 256;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T theme(@androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().theme(theme);
        }
        this.theme = theme;
        this.fields |= 32768;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T timeout(@androidx.annotation.IntRange(from = 0) int i) {
        return set(com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.TIMEOUT, java.lang.Integer.valueOf(i));
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T transform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return transform(transformation, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    public T transform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().transform(transformation, z);
        }
        com.bumptech.glide.load.resource.bitmap.DrawableTransformation drawableTransformation = new com.bumptech.glide.load.resource.bitmap.DrawableTransformation(transformation, z);
        transform(android.graphics.Bitmap.class, transformation, z);
        transform(android.graphics.drawable.Drawable.class, drawableTransformation, z);
        transform(android.graphics.drawable.BitmapDrawable.class, drawableTransformation.asBitmapDrawable(), z);
        transform(com.bumptech.glide.load.resource.gif.GifDrawable.class, new com.bumptech.glide.load.resource.gif.GifDrawableTransformation(transformation), z);
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public final T transform(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().transform(downsampleStrategy, transformation);
        }
        downsample(downsampleStrategy);
        return transform(transformation);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public <Y> T transform(@androidx.annotation.NonNull java.lang.Class<Y> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> transformation) {
        return transform(cls, transformation, true);
    }

    @androidx.annotation.NonNull
    public <Y> T transform(@androidx.annotation.NonNull java.lang.Class<Y> cls, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> transformation, boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().transform(cls, transformation, z);
        }
        com.bumptech.glide.util.Preconditions.checkNotNull(cls);
        com.bumptech.glide.util.Preconditions.checkNotNull(transformation);
        this.transformations.put(cls, transformation);
        int i = this.fields | 2048;
        this.isTransformationAllowed = true;
        int i2 = i | 65536;
        this.fields = i2;
        this.isScaleOnlyOrNoTransform = false;
        if (z) {
            this.fields = i2 | 131072;
            this.isTransformationRequired = true;
        }
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T transform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return transformationArr.length > 1 ? transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) new com.bumptech.glide.load.MultiTransformation(transformationArr), true) : transformationArr.length == 1 ? transform(transformationArr[0]) : selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    @java.lang.Deprecated
    public T transforms(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) new com.bumptech.glide.load.MultiTransformation(transformationArr), true);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T useAnimationPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().useAnimationPool(z);
        }
        this.useAnimationPool = z;
        this.fields |= 1048576;
        return selfOrThrowIfLocked();
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public T useUnlimitedSourceGeneratorsPool(boolean z) {
        if (this.isAutoCloneEnabled) {
            return (T) mo46clone().useUnlimitedSourceGeneratorsPool(z);
        }
        this.useUnlimitedSourceGeneratorsPool = z;
        this.fields |= 262144;
        return selfOrThrowIfLocked();
    }
}
