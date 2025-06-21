package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class StreamBitmapDataLoadProvider implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<java.io.InputStream, android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder<android.graphics.Bitmap> cacheDecoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder decoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapEncoder encoder;
    private final com.alimm.tanx.ui.image.glide.load.model.StreamEncoder sourceEncoder = new com.alimm.tanx.ui.image.glide.load.model.StreamEncoder();

    public StreamBitmapDataLoadProvider(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder streamBitmapDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder(bitmapPool, decodeFormat);
        this.decoder = streamBitmapDecoder;
        this.encoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapEncoder();
        this.cacheDecoder = new com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder<>(streamBitmapDecoder);
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
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> getSourceDecoder() {
        return this.decoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<java.io.InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
