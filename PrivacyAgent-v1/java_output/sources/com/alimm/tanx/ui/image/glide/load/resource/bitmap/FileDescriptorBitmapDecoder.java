package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class FileDescriptorBitmapDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<android.os.ParcelFileDescriptor, android.graphics.Bitmap> {
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder bitmapDecoder;
    private final com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat;

    public FileDescriptorBitmapDecoder(android.content.Context context) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool(), com.alimm.tanx.ui.image.glide.load.DecodeFormat.DEFAULT);
    }

    public FileDescriptorBitmapDecoder(android.content.Context context, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool(), decodeFormat);
    }

    public FileDescriptorBitmapDecoder(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder(), bitmapPool, decodeFormat);
    }

    public FileDescriptorBitmapDecoder(com.alimm.tanx.ui.image.glide.load.resource.bitmap.VideoBitmapDecoder videoBitmapDecoder, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this.bitmapDecoder = videoBitmapDecoder;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.os.ParcelFileDescriptor parcelFileDescriptor, int i, int i2) throws java.io.IOException {
        return com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(this.bitmapDecoder.decode(parcelFileDescriptor, this.bitmapPool, i, i2, this.decodeFormat), this.bitmapPool);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        return "FileDescriptorBitmapDecoder.com.alimm.tanx.ui.image.glide.load.data.bitmap";
    }
}
