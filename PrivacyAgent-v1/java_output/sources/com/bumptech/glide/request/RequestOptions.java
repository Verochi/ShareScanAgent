package com.bumptech.glide.request;

/* loaded from: classes.dex */
public class RequestOptions extends com.bumptech.glide.request.BaseRequestOptions<com.bumptech.glide.request.RequestOptions> {

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions centerCropOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions centerInsideOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions circleCropOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions fitCenterOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions noAnimationOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions noTransformOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions skipMemoryCacheFalseOptions;

    @androidx.annotation.Nullable
    private static com.bumptech.glide.request.RequestOptions skipMemoryCacheTrueOptions;

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions bitmapTransform(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> transformation) {
        return new com.bumptech.glide.request.RequestOptions().transform(transformation);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions centerCropTransform() {
        if (centerCropOptions == null) {
            centerCropOptions = new com.bumptech.glide.request.RequestOptions().centerCrop().autoClone();
        }
        return centerCropOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions centerInsideTransform() {
        if (centerInsideOptions == null) {
            centerInsideOptions = new com.bumptech.glide.request.RequestOptions().centerInside().autoClone();
        }
        return centerInsideOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions circleCropTransform() {
        if (circleCropOptions == null) {
            circleCropOptions = new com.bumptech.glide.request.RequestOptions().circleCrop().autoClone();
        }
        return circleCropOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions decodeTypeOf(@androidx.annotation.NonNull java.lang.Class<?> cls) {
        return new com.bumptech.glide.request.RequestOptions().decode(cls);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions diskCacheStrategyOf(@androidx.annotation.NonNull com.bumptech.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        return new com.bumptech.glide.request.RequestOptions().diskCacheStrategy(diskCacheStrategy);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions downsampleOf(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy downsampleStrategy) {
        return new com.bumptech.glide.request.RequestOptions().downsample(downsampleStrategy);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions encodeFormatOf(@androidx.annotation.NonNull android.graphics.Bitmap.CompressFormat compressFormat) {
        return new com.bumptech.glide.request.RequestOptions().encodeFormat(compressFormat);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions encodeQualityOf(@androidx.annotation.IntRange(from = 0, to = 100) int i) {
        return new com.bumptech.glide.request.RequestOptions().encodeQuality(i);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions errorOf(@androidx.annotation.DrawableRes int i) {
        return new com.bumptech.glide.request.RequestOptions().error(i);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions errorOf(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return new com.bumptech.glide.request.RequestOptions().error(drawable);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions fitCenterTransform() {
        if (fitCenterOptions == null) {
            fitCenterOptions = new com.bumptech.glide.request.RequestOptions().fitCenter().autoClone();
        }
        return fitCenterOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions formatOf(@androidx.annotation.NonNull com.bumptech.glide.load.DecodeFormat decodeFormat) {
        return new com.bumptech.glide.request.RequestOptions().format(decodeFormat);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions frameOf(@androidx.annotation.IntRange(from = 0) long j) {
        return new com.bumptech.glide.request.RequestOptions().frame(j);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions noAnimation() {
        if (noAnimationOptions == null) {
            noAnimationOptions = new com.bumptech.glide.request.RequestOptions().dontAnimate().autoClone();
        }
        return noAnimationOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions noTransformation() {
        if (noTransformOptions == null) {
            noTransformOptions = new com.bumptech.glide.request.RequestOptions().dontTransform().autoClone();
        }
        return noTransformOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static <T> com.bumptech.glide.request.RequestOptions option(@androidx.annotation.NonNull com.bumptech.glide.load.Option<T> option, @androidx.annotation.NonNull T t) {
        return new com.bumptech.glide.request.RequestOptions().set(option, t);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions overrideOf(int i) {
        return overrideOf(i, i);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions overrideOf(int i, int i2) {
        return new com.bumptech.glide.request.RequestOptions().override(i, i2);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions placeholderOf(@androidx.annotation.DrawableRes int i) {
        return new com.bumptech.glide.request.RequestOptions().placeholder(i);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions placeholderOf(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return new com.bumptech.glide.request.RequestOptions().placeholder(drawable);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions priorityOf(@androidx.annotation.NonNull com.bumptech.glide.Priority priority) {
        return new com.bumptech.glide.request.RequestOptions().priority(priority);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions signatureOf(@androidx.annotation.NonNull com.bumptech.glide.load.Key key) {
        return new com.bumptech.glide.request.RequestOptions().signature(key);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions sizeMultiplierOf(@androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return new com.bumptech.glide.request.RequestOptions().sizeMultiplier(f);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions skipMemoryCacheOf(boolean z) {
        if (z) {
            if (skipMemoryCacheTrueOptions == null) {
                skipMemoryCacheTrueOptions = new com.bumptech.glide.request.RequestOptions().skipMemoryCache(true).autoClone();
            }
            return skipMemoryCacheTrueOptions;
        }
        if (skipMemoryCacheFalseOptions == null) {
            skipMemoryCacheFalseOptions = new com.bumptech.glide.request.RequestOptions().skipMemoryCache(false).autoClone();
        }
        return skipMemoryCacheFalseOptions;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.CheckResult
    public static com.bumptech.glide.request.RequestOptions timeoutOf(@androidx.annotation.IntRange(from = 0) int i) {
        return new com.bumptech.glide.request.RequestOptions().timeout(i);
    }
}
