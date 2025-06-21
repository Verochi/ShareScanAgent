package com.alimm.tanx.ui.image.glide;

/* loaded from: classes.dex */
public class BitmapTypeRequest<ModelType> extends com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> fileDescriptorModelLoader;
    private final com.alimm.tanx.ui.image.glide.Glide glide;
    private final com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier;
    private final com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> streamModelLoader;

    public BitmapTypeRequest(com.alimm.tanx.ui.image.glide.GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> modelLoader2, com.alimm.tanx.ui.image.glide.RequestManager.OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, modelLoader, modelLoader2, android.graphics.Bitmap.class, null), android.graphics.Bitmap.class, genericRequestBuilder);
        this.streamModelLoader = modelLoader;
        this.fileDescriptorModelLoader = modelLoader2;
        this.glide = genericRequestBuilder.glide;
        this.optionsApplier = optionsApplier;
    }

    private static <A, R> com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<A, com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap, R> buildProvider(com.alimm.tanx.ui.image.glide.Glide glide, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, java.io.InputStream> modelLoader, com.alimm.tanx.ui.image.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> modelLoader2, java.lang.Class<R> cls, com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(android.graphics.Bitmap.class, cls);
        }
        return new com.alimm.tanx.ui.image.glide.provider.FixedLoadProvider<>(new com.alimm.tanx.ui.image.glide.load.model.ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.buildDataProvider(com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper.class, android.graphics.Bitmap.class));
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, byte[]> toBytes() {
        return (com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, byte[]>) transcode(new com.alimm.tanx.ui.image.glide.load.resource.transcode.BitmapBytesTranscoder(), byte[].class);
    }

    public com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, byte[]> toBytes(android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        return (com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, byte[]>) transcode(new com.alimm.tanx.ui.image.glide.load.resource.transcode.BitmapBytesTranscoder(compressFormat, i), byte[].class);
    }

    public <R> com.alimm.tanx.ui.image.glide.BitmapRequestBuilder<ModelType, R> transcode(com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, R> resourceTranscoder, java.lang.Class<R> cls) {
        return (com.alimm.tanx.ui.image.glide.BitmapRequestBuilder) this.optionsApplier.apply(new com.alimm.tanx.ui.image.glide.BitmapRequestBuilder(buildProvider(this.glide, this.streamModelLoader, this.fileDescriptorModelLoader, cls, resourceTranscoder), cls, this));
    }
}
