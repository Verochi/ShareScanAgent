package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class BitmapRequestBuilder<ModelType, TranscodeType> extends com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap, TranscodeType> implements com.alimm.tanx.ui.image.glide.BitmapOptions, com.alimm.tanx.ui.image.glide.DrawableOptions {
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat;
    private com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler downsampler;
    private com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> imageDecoder;
    private com.alimm.tanx.ui.image.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> videoDecoder;

    public BitmapRequestBuilder(com.alimm.tanx.ui.image.glide.provider.LoadProvider<ModelType, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap, TranscodeType> loadProvider, java.lang.Class<TranscodeType> cls, com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
        this.downsampler = com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AT_LEAST;
        com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = genericRequestBuilder.glide.getBitmapPool();
        this.bitmapPool = bitmapPool;
        com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat = genericRequestBuilder.glide.getDecodeFormat();
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder(bitmapPool, decodeFormat);
        this.videoDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDecoder(bitmapPool, this.decodeFormat);
    }

    private java.lang.RuntimeException crossFadeNotSupported() {
        java.lang.String canonicalName = this.transcodeClass.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = this.transcodeClass.toString();
        }
        return new java.lang.UnsupportedOperationException(".crossFade() is not supported for " + canonicalName + ", use .animate() to provide a compatible animation.");
    }

    private com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> downsample(com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler downsampler) {
        this.downsampler = downsampler;
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder streamBitmapDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder(downsampler, this.bitmapPool, this.decodeFormat);
        this.imageDecoder = streamBitmapDecoder;
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder(streamBitmapDecoder, this.videoDecoder));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> animate(android.view.animation.Animation animation) {
        super.animate(animation);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> animate(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> animate(com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator) {
        super.animate(animator);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyCenterCrop() {
        centerCrop();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public void applyFitCenter() {
        fitCenter();
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> approximate() {
        return downsample(com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AT_LEAST);
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> asIs() {
        return downsample(com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.NONE);
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> atMost() {
        return downsample(com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AT_MOST);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> cacheDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, android.graphics.Bitmap> resourceDecoder) {
        super.cacheDecoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> centerCrop() {
        return transform(this.glide.getBitmapCenterCrop());
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    /* renamed from: clone */
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> mo9clone() {
        return (com.alimm.tanx.ui.image.glide.BitmapRequestBuilder) super.mo9clone();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public final com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> crossFade() {
        if (android.graphics.Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.BitmapCrossFadeFactory());
        }
        if (android.graphics.drawable.Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory());
        }
        throw crossFadeNotSupported();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> crossFade(int i) {
        if (android.graphics.Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.BitmapCrossFadeFactory(i));
        }
        if (android.graphics.drawable.Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(i));
        }
        throw crossFadeNotSupported();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> crossFade(int i, int i2) {
        if (android.graphics.Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.BitmapCrossFadeFactory(this.context, i, i2));
        }
        if (android.graphics.drawable.Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(this.context, i, i2));
        }
        throw crossFadeNotSupported();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> crossFade(android.view.animation.Animation animation, int i) {
        if (android.graphics.Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.BitmapCrossFadeFactory(animation, i));
        }
        if (android.graphics.drawable.Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(animation, i));
        }
        throw crossFadeNotSupported();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> decoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> resourceDecoder) {
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> encoder(com.alimm.tanx.ui.image.glide.load.ResourceEncoder<android.graphics.Bitmap> resourceEncoder) {
        super.encoder((com.alimm.tanx.ui.image.glide.load.ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> error(int i) {
        super.error(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> error(android.graphics.drawable.Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> fallback(android.graphics.drawable.Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> fitCenter() {
        return transform(this.glide.getBitmapFitCenter());
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> format(com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat);
        this.videoDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDecoder(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder(), this.bitmapPool, decodeFormat);
        super.cacheDecoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) new com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat)));
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> imageDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> resourceDecoder) {
        this.imageDecoder = resourceDecoder;
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder(resourceDecoder, this.videoDecoder));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.request.target.Target<TranscodeType> into(android.widget.ImageView imageView) {
        return super.into(imageView);
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> listener(com.alimm.tanx.ui.image.glide.request.RequestListener<? super ModelType, TranscodeType> requestListener) {
        super.listener((com.alimm.tanx.ui.image.glide.request.RequestListener) requestListener);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> load(ModelType modeltype) {
        super.load((com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType>) modeltype);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ com.alimm.tanx.ui.image.glide.GenericRequestBuilder load(java.lang.Object obj) {
        return load((com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType>) obj);
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> placeholder(android.graphics.drawable.Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> priority(com.alimm.tanx.ui.image.glide.Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> signature(com.alimm.tanx.ui.image.glide.load.Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> sourceEncoder(com.alimm.tanx.ui.image.glide.load.Encoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> encoder) {
        super.sourceEncoder((com.alimm.tanx.ui.image.glide.load.Encoder) encoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<?, TranscodeType> bitmapRequestBuilder) {
        super.thumbnail((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) bitmapRequestBuilder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        super.thumbnail((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> transcoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, TranscodeType> resourceTranscoder) {
        super.transcoder((com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder) resourceTranscoder);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> transform(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        super.transform((com.alimm.tanx.ui.image.glide.load.Transformation[]) transformationArr);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> transform(com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation... bitmapTransformationArr) {
        super.transform((com.alimm.tanx.ui.image.glide.load.Transformation[]) bitmapTransformationArr);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, TranscodeType> videoDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> resourceDecoder) {
        this.videoDecoder = resourceDecoder;
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder(this.imageDecoder, resourceDecoder));
        return this;
    }
}
