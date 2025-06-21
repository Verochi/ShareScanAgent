package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class FileDescriptorBitmapDataLoadProvider implements com.alimm.tanx.ui.image.glide.provider.DataLoadProvider<android.os.ParcelFileDescriptor, android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.File, android.graphics.Bitmap> cacheDecoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDecoder sourceDecoder;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapEncoder encoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapEncoder();
    private final com.alimm.tanx.ui.image.glide.load.Encoder<android.os.ParcelFileDescriptor> sourceEncoder = com.alimm.tanx.ui.image.glide.load.resource.NullEncoder.get();

    public FileDescriptorBitmapDataLoadProvider(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this.cacheDecoder = new com.alimm.tanx.ui.image.glide.load.resource.file.FileToStreamDecoder(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.StreamBitmapDecoder(bitmapPool, decodeFormat));
        this.sourceDecoder = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.FileDescriptorBitmapDecoder(bitmapPool, decodeFormat);
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
    public com.alimm.tanx.ui.image.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> getSourceDecoder() {
        return this.sourceDecoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.provider.DataLoadProvider
    public com.alimm.tanx.ui.image.glide.load.Encoder<android.os.ParcelFileDescriptor> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
