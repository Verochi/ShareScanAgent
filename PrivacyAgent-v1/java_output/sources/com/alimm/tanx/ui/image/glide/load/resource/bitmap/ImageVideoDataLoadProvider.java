package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class ImageVideoDataLoadProvider implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, android.graphics.Bitmap> cacheDecoder;
    private final com.alimm.tanx.ui.image.glide.load.ResourceEncoder<android.graphics.Bitmap> encoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder sourceDecoder;
    private final com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapperEncoder sourceEncoder;

    public ImageVideoDataLoadProvider(com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<java.io.InputStream, android.graphics.Bitmap> dataLoadProvider, com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<android.os.ParcelFileDescriptor, android.graphics.Bitmap> dataLoadProvider2) {
        this.encoder = dataLoadProvider.getEncoder();
        this.sourceEncoder = new com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapperEncoder(dataLoadProvider.getSourceEncoder(), dataLoadProvider2.getSourceEncoder());
        this.cacheDecoder = dataLoadProvider.getCacheDecoder();
        this.sourceDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageVideoBitmapDecoder(dataLoadProvider.getSourceDecoder(), dataLoadProvider2.getSourceDecoder());
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, android.graphics.Bitmap> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceEncoder<android.graphics.Bitmap> getEncoder() {
        return this.encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> getSourceDecoder() {
        return this.sourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<com.alimm.tanx.ui.image.glide.load.model.ImageVideoWrapper> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
