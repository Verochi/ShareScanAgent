package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class GifTypeRequest<ModelType> extends com.alimm.tanx.ui.image.glide.GifRequestBuilder<ModelType> {
    private final com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> streamModelLoader;

    public GifTypeRequest(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, modelLoader, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.class, null), com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.class, genericRequestBuilder);
        this.streamModelLoader = modelLoader;
        this.optionsApplier = optionsApplier;
        crossFade();
    }

    private static <A, R> com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<A, java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, R> buildProvider(com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> modelLoader, java.lang.Class<R> cls, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, R> resourceTranscoder) {
        if (modelLoader == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.class, cls);
        }
        return new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<>(modelLoader, resourceTranscoder, glide.buildDataProvider(java.io.InputStream.class, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable.class));
    }

    public com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, byte[]> toBytes() {
        return (com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, byte[]>) transcode(new com.alimm.tanx.ui.image.glide.load.resource.transcode.GifDrawableBytesTranscoder(), byte[].class);
    }

    public <R> com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, java.io.InputStream, com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, R> transcode(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<com.alimm.tanx.ui.image.glide.load.resource.gif.GifDrawable, R> resourceTranscoder, java.lang.Class<R> cls) {
        return this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.GenericRequestBuilder(buildProvider(this.glide, this.streamModelLoader, cls, resourceTranscoder), cls, this));
    }
}
