package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class GifRequestBuilder<ModelType> extends com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> implements com.alimm.tanx.ui.image.glide.BitmapOptions, com.alimm.tanx.ui.image.glide.DrawableOptions {
    public GifRequestBuilder(com.alimm.tanx.ui.image.glide.provider.LoadProvider<ModelType, java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> loadProvider, java.lang.Class<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> cls, com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
    }

    private com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation[] toGifTransformations(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap>[] transformationArr) {
        com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation[] gifDrawableTransformationArr = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation[transformationArr.length];
        for (int i = 0; i < transformationArr.length; i++) {
            gifDrawableTransformationArr[i] = new com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawableTransformation(transformationArr[i], this.glide.getBitmapPool());
        }
        return gifDrawableTransformationArr;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> animate(android.view.animation.Animation animation) {
        super.animate(animation);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> animate(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> glideAnimationFactory) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> animate(com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> cacheDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceDecoder) {
        super.cacheDecoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> centerCrop() {
        return transformFrame(this.glide.getBitmapCenterCrop());
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    /* renamed from: clone */
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> mo9clone() {
        return (com.alimm.tanx.ui.image.glide.GifRequestBuilder) super.mo9clone();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> crossFade() {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> crossFade(int i) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(i));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> crossFade(int i, int i2) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(this.context, i, i2));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> crossFade(android.view.animation.Animation animation, int i) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(animation, i));
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> decoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceDecoder) {
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> encoder(com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceEncoder) {
        super.encoder((com.alimm.tanx.ui.image.glide.load.ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> error(int i) {
        super.error(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> error(android.graphics.drawable.Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> fallback(android.graphics.drawable.Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> fitCenter() {
        return transformFrame(this.glide.getBitmapFitCenter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> listener(com.alimm.tanx.ui.image.glide.request.RequestListener<? super ModelType, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> requestListener) {
        super.listener((com.alimm.tanx.ui.image.glide.request.RequestListener) requestListener);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ com.alimm.tanx.ui.image.glide.GenericRequestBuilder load(java.lang.Object obj) {
        return load((com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType>) obj);
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load((com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType>) modeltype);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> placeholder(android.graphics.drawable.Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> priority(com.alimm.tanx.ui.image.glide.Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> signature(com.alimm.tanx.ui.image.glide.load.Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> sourceEncoder(com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> encoder) {
        super.sourceEncoder((com.alimm.tanx.ui.image.glide.load.Encoder) encoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> thumbnail(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> genericRequestBuilder) {
        super.thumbnail((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> thumbnail(com.alimm.tanx.ui.image.glide.GifRequestBuilder<?> gifRequestBuilder) {
        super.thumbnail((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) gifRequestBuilder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> transcoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable> resourceTranscoder) {
        super.transcoder((com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder) resourceTranscoder);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> transform(com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable>... transformationArr) {
        super.transform((com.alimm.tanx.ui.image.glide.load.Transformation[]) transformationArr);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> transformFrame(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        return transform((com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable>[]) toGifTransformations(transformationArr));
    }

    public com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> transformFrame(com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation... bitmapTransformationArr) {
        return transform((com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable>[]) toGifTransformations(bitmapTransformationArr));
    }
}
