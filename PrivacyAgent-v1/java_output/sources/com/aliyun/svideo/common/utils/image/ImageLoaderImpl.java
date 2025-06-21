package com.aliyun.svideo.common.utils.image;

/* loaded from: classes.dex */
public class ImageLoaderImpl extends com.aliyun.svideo.common.utils.image.AbstractImageLoader {
    private static final java.lang.String TAG = "ImageLoaderImpl";
    private com.bumptech.glide.RequestBuilder mRequestBuilder;

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* renamed from: com.aliyun.svideo.common.utils.image.ImageLoaderImpl$1, reason: invalid class name */
    public class AnonymousClass1<R> implements com.bumptech.glide.request.RequestListener<R> {
        final /* synthetic */ com.aliyun.svideo.common.utils.image.ImageLoaderRequestListener val$listener;

        public AnonymousClass1(com.aliyun.svideo.common.utils.image.ImageLoaderRequestListener imageLoaderRequestListener) {
            this.val$listener = imageLoaderRequestListener;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@androidx.annotation.Nullable com.bumptech.glide.load.engine.GlideException glideException, java.lang.Object obj, com.bumptech.glide.request.target.Target<R> target, boolean z) {
            this.val$listener.onLoadFailed(glideException == null ? "no msg" : glideException.getMessage(), z);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onResourceReady(R r, java.lang.Object obj, com.bumptech.glide.request.target.Target<R> target, com.bumptech.glide.load.DataSource dataSource, boolean z) {
            this.val$listener.onResourceReady(r, z);
            return false;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: com.aliyun.svideo.common.utils.image.ImageLoaderImpl$2, reason: invalid class name */
    public class AnonymousClass2<T> extends com.bumptech.glide.request.target.CustomViewTarget<android.view.View, T> {
        final /* synthetic */ com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget val$loaderTarget;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(android.view.View view, com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget abstractImageLoaderTarget) {
            super(view);
            this.val$loaderTarget = abstractImageLoaderTarget;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.val$loaderTarget.onLoadFailed(drawable);
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.val$loaderTarget.onLoadCleared(drawable);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@androidx.annotation.NonNull T t, @androidx.annotation.Nullable com.bumptech.glide.request.transition.Transition<? super T> transition) {
            this.val$loaderTarget.onResourceReady(t);
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget, com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
            super.onStart();
            this.val$loaderTarget.onLoadStarted();
        }
    }

    @android.annotation.SuppressLint({"CheckResult"})
    private <R> void loadGlideOption(android.content.Context context, com.bumptech.glide.RequestBuilder<R> requestBuilder, com.aliyun.svideo.common.utils.image.ImageLoaderOptions imageLoaderOptions) {
        int i;
        this.mRequestBuilder = requestBuilder;
        com.bumptech.glide.request.RequestOptions skipMemoryCacheOf = com.bumptech.glide.request.RequestOptions.skipMemoryCacheOf(imageLoaderOptions.isSkipMemoryCache());
        if (imageLoaderOptions.getHolderDrawable() != null) {
            skipMemoryCacheOf = skipMemoryCacheOf.placeholder(imageLoaderOptions.getHolderDrawable());
        }
        if (imageLoaderOptions.getHolderDrawableId() != -1) {
            skipMemoryCacheOf = skipMemoryCacheOf.placeholder(imageLoaderOptions.getHolderDrawableId());
        }
        if (imageLoaderOptions.getErrorDrawableId() != -1) {
            skipMemoryCacheOf = skipMemoryCacheOf.error(imageLoaderOptions.getErrorDrawableId());
        }
        if (imageLoaderOptions.isCenterCrop()) {
            skipMemoryCacheOf = skipMemoryCacheOf.centerCrop();
        }
        if (imageLoaderOptions.isCircle()) {
            skipMemoryCacheOf = skipMemoryCacheOf.optionalCircleCrop();
        }
        com.bumptech.glide.request.RequestOptions diskCacheStrategy = imageLoaderOptions.isSkipDiskCacheCache() ? skipMemoryCacheOf.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.NONE) : skipMemoryCacheOf.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC);
        if (imageLoaderOptions.getThumbnail() != 1.0f) {
            this.mRequestBuilder.thumbnail(imageLoaderOptions.getThumbnail());
        }
        android.graphics.Point overridePoint = imageLoaderOptions.getOverridePoint();
        int i2 = overridePoint.x;
        if (i2 != 0 && (i = overridePoint.y) != 0) {
            diskCacheStrategy = diskCacheStrategy.override(i2, i);
        }
        if (imageLoaderOptions.isRoundCorner()) {
            diskCacheStrategy = diskCacheStrategy.transform(new com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform(context, 4.0f, com.aliyun.svideo.common.utils.image.GlideRoundedCornersTransform.CornerType.ALL));
        }
        this.mRequestBuilder.apply((com.bumptech.glide.request.BaseRequestOptions<?>) diskCacheStrategy);
    }

    private void loadGlideResource(@androidx.annotation.NonNull android.content.Context context, java.lang.Object obj, @androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.ImageLoaderOptions imageLoaderOptions) {
        com.bumptech.glide.RequestManager with;
        if (context instanceof android.app.Activity) {
            android.app.Activity activity = (android.app.Activity) context;
            if (activity.isDestroyed()) {
                return;
            } else {
                with = com.bumptech.glide.Glide.with(activity);
            }
        } else {
            with = com.bumptech.glide.Glide.with(context);
        }
        if (imageLoaderOptions.isAsBitmap()) {
            com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> load = with.asBitmap().load(obj instanceof java.lang.String ? (java.lang.String) obj : (java.lang.Integer) obj);
            if (imageLoaderOptions.isCrossFade()) {
                load = load.transition(new com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions().crossFade());
            }
            loadGlideOption(context, load, imageLoaderOptions);
            return;
        }
        com.bumptech.glide.RequestBuilder<android.graphics.drawable.Drawable> load2 = with.load(obj instanceof java.lang.String ? (java.lang.String) obj : (java.lang.Integer) obj);
        if (imageLoaderOptions.isCrossFade()) {
            load2 = load2.transition(new com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions().crossFade());
        }
        loadGlideOption(context, load2, imageLoaderOptions);
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public void clear(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.widget.ImageView imageView) {
        com.bumptech.glide.Glide.with(context).clear(imageView);
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public <T> void into(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.AbstractImageLoaderTarget<T> abstractImageLoaderTarget) {
        this.mRequestBuilder.into((com.bumptech.glide.RequestBuilder) new com.aliyun.svideo.common.utils.image.ImageLoaderImpl.AnonymousClass2(view, abstractImageLoaderTarget));
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public void into(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.mRequestBuilder.into(imageView);
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    @android.annotation.SuppressLint({"CheckResult"})
    public <R> com.aliyun.svideo.common.utils.image.AbstractImageLoader listener(@androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.ImageLoaderRequestListener<R> imageLoaderRequestListener) {
        this.mRequestBuilder.listener(new com.aliyun.svideo.common.utils.image.ImageLoaderImpl.AnonymousClass1(imageLoaderRequestListener));
        return this;
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull int i) {
        return loadImage(context, i, new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder().build());
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, int i, @androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.ImageLoaderOptions imageLoaderOptions) {
        loadGlideResource(context, java.lang.Integer.valueOf(i), imageLoaderOptions);
        return this;
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        return loadImage(context, str, new com.aliyun.svideo.common.utils.image.ImageLoaderOptions.Builder().build());
    }

    @Override // com.aliyun.svideo.common.utils.image.AbstractImageLoader
    public com.aliyun.svideo.common.utils.image.AbstractImageLoader loadImage(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.aliyun.svideo.common.utils.image.ImageLoaderOptions imageLoaderOptions) {
        loadGlideResource(context, str, imageLoaderOptions);
        return this;
    }
}
