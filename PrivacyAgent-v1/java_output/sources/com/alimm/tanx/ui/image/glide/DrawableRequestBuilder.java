package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class DrawableRequestBuilder<ModelType> extends com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> implements com.alimm.tanx.ui.image.glide.BitmapOptions, com.alimm.tanx.ui.image.glide.DrawableOptions {
    public DrawableRequestBuilder(android.content.Context context, java.lang.Class<ModelType> cls, com.alimm.tanx.ui.image.glide.provider.LoadProvider<ModelType, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> loadProvider, com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker, com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle) {
        super(context, cls, loadProvider, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable.class, glide, requestTracker, lifecycle);
        crossFade();
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> animate(android.view.animation.Animation animation) {
        super.animate(animation);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> animate(com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> glideAnimationFactory) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> animate(com.alimm.tanx.ui.image.glide.request.animation.ViewPropertyAnimation.Animator animator) {
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

    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> bitmapTransform(com.alimm.tanx.ui.image.glide.load.Transformation<android.graphics.Bitmap>... transformationArr) {
        com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation[] gifBitmapWrapperTransformationArr = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation[transformationArr.length];
        for (int i = 0; i < transformationArr.length; i++) {
            gifBitmapWrapperTransformationArr[i] = new com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation(this.glide.getBitmapPool(), transformationArr[i]);
        }
        return transform((com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper>[]) gifBitmapWrapperTransformationArr);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> cacheDecoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resourceDecoder) {
        super.cacheDecoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> centerCrop() {
        return transform(this.glide.getDrawableCenterCrop());
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    /* renamed from: clone */
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> mo9clone() {
        return (com.alimm.tanx.ui.image.glide.DrawableRequestBuilder) super.mo9clone();
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public final com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> crossFade() {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory());
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> crossFade(int i) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(i));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> crossFade(int i, int i2) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(this.context, i, i2));
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.DrawableOptions
    @java.lang.Deprecated
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> crossFade(android.view.animation.Animation animation, int i) {
        super.animate((com.alimm.tanx.ui.image.glide.request.animation.GlideAnimationFactory) new com.alimm.tanx.ui.image.glide.request.animation.DrawableCrossFadeFactory(animation, i));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> decoder(com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resourceDecoder) {
        super.decoder((com.alimm.tanx.ui.image.glide.load.ResourceDecoder) resourceDecoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> diskCacheStrategy(com.alimm.tanx.ui.image.glide.load.engine.DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> encoder(com.alimm.tanx.ui.image.glide.load.ResourceEncoder<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper> resourceEncoder) {
        super.encoder((com.alimm.tanx.ui.image.glide.load.ResourceEncoder) resourceEncoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> error(int i) {
        super.error(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> error(android.graphics.drawable.Drawable drawable) {
        super.error(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> fallback(android.graphics.drawable.Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.BitmapOptions
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> fitCenter() {
        return transform(this.glide.getDrawableFitCenter());
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.request.target.Target<com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> into(android.widget.ImageView imageView) {
        return super.into(imageView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> listener(com.alimm.tanx.ui.image.glide.request.RequestListener<? super ModelType, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> requestListener) {
        super.listener((com.alimm.tanx.ui.image.glide.request.RequestListener) requestListener);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> load(ModelType modeltype) {
        super.load((com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType>) modeltype);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public /* bridge */ /* synthetic */ com.alimm.tanx.ui.image.glide.GenericRequestBuilder load(java.lang.Object obj) {
        return load((com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType>) obj);
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> placeholder(android.graphics.drawable.Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> priority(com.alimm.tanx.ui.image.glide.Priority priority) {
        super.priority(priority);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> signature(com.alimm.tanx.ui.image.glide.load.Key key) {
        super.signature(key);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> sourceEncoder(com.alimm.tanx.ui.image.glide.load.Encoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> encoder) {
        super.sourceEncoder((com.alimm.tanx.ui.image.glide.load.Encoder) encoder);
        return this;
    }

    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> thumbnail(com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<?> drawableRequestBuilder) {
        super.thumbnail((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) drawableRequestBuilder);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> thumbnail(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<?, ?, ?, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> genericRequestBuilder) {
        super.thumbnail((com.alimm.tanx.ui.image.glide.GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> transcoder(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable> resourceTranscoder) {
        super.transcoder((com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder) resourceTranscoder);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alimm.tanx.ui.image.glide.GenericRequestBuilder
    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> transform(com.alimm.tanx.ui.image.glide.load.Transformation<com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper>... transformationArr) {
        super.transform((com.alimm.tanx.ui.image.glide.load.Transformation[]) transformationArr);
        return this;
    }

    public com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> transform(com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapTransformation... bitmapTransformationArr) {
        return bitmapTransform(bitmapTransformationArr);
    }
}
