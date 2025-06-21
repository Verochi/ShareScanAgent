package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class DrawableTypeRequest<ModelType> extends com.alimm.tanx.ui.image.glide.DrawableRequestBuilder<ModelType> implements com.alimm.tanx.ui.image.glide.DownloadOptions {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> fileDescriptorModelLoader;
    private final com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> streamModelLoader;

    public DrawableTypeRequest(java.lang.Class<ModelType> cls, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> modelLoader2, android.content.Context context, com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.manager.RequestTracker requestTracker, com.alimm.tanx.ui.image.glide.manager.Lifecycle lifecycle, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier) {
        super(context, cls, buildProvider(glide, modelLoader, modelLoader2, com.alimm.tanx.ui.image.glide.load.resource.gifbitmap.GifBitmapWrapper.class, com.alimm.tanx.ui.image.glide.load.resource.drawable.GlideDrawable.class, null), glide, requestTracker, lifecycle);
        this.streamModelLoader = modelLoader;
        this.fileDescriptorModelLoader = modelLoader2;
        this.optionsApplier = optionsApplier;
    }

    private static <A, Z, R> com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<A, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, Z, R> buildProvider(com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> modelLoader2, java.lang.Class<Z> cls, java.lang.Class<R> cls2, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<Z, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(cls, cls2);
        }
        return new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<>(new com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.buildDataProvider(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper.class, cls));
    }

    private com.alimm.tanx.ui.image.glide.GenericTranscodeRequest<ModelType, java.io.InputStream, java.io.File> getDownloadOnlyRequest() {
        com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (com.alimm.tanx.ui.image.glide.GenericTranscodeRequest) optionsApplier.apply(new com.alimm.tanx.ui.image.glide.GenericTranscodeRequest(java.io.File.class, this, this.streamModelLoader, java.io.InputStream.class, java.io.File.class, optionsApplier));
    }

    public com.alimm.tanx.ui.image.glide.BitmapTypeRequest<ModelType> asBitmap() {
        com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (com.alimm.tanx.ui.image.glide.BitmapTypeRequest) optionsApplier.apply(new com.alimm.tanx.ui.image.glide.BitmapTypeRequest(this, this.streamModelLoader, this.fileDescriptorModelLoader, optionsApplier));
    }

    public com.alimm.tanx.ui.image.glide.GifTypeRequest<ModelType> asGif() {
        com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (com.alimm.tanx.ui.image.glide.GifTypeRequest) optionsApplier.apply(new com.alimm.tanx.ui.image.glide.GifTypeRequest(this, this.streamModelLoader, optionsApplier));
    }

    @Override // com.alimm.tanx.ui.image.glide.DownloadOptions
    public com.alimm.tanx.ui.image.glide.request.FutureTarget<java.io.File> downloadOnly(int i, int i2) {
        return getDownloadOnlyRequest().downloadOnly(i, i2);
    }

    @Override // com.alimm.tanx.ui.image.glide.DownloadOptions
    public <Y extends com.alimm.tanx.ui.image.glide.request.target.Target<java.io.File>> Y downloadOnly(Y y) {
        return (Y) getDownloadOnlyRequest().downloadOnly(y);
    }
}
