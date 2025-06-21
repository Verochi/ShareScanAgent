package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class StreamBitmapDecoder implements com.alimm.tanx.ui.image.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> {
    private static final java.lang.String ID = "StreamBitmapDecoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    private com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool;
    private com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat;
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler downsampler;
    private java.lang.String id;

    public StreamBitmapDecoder(android.content.Context context) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool());
    }

    public StreamBitmapDecoder(android.content.Context context, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this(com.alimm.tanx.ui.image.glide.Glide.get(context).getBitmapPool(), decodeFormat);
    }

    public StreamBitmapDecoder(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool) {
        this(bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat.DEFAULT);
    }

    public StreamBitmapDecoder(com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this(com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler.AT_LEAST, bitmapPool, decodeFormat);
    }

    public StreamBitmapDecoder(com.alimm.tanx.ui.image.glide.load.resource.bitmap.Downsampler downsampler, com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool, com.alimm.tanx.ui.image.glide.load.DecodeFormat decodeFormat) {
        this.downsampler = downsampler;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> decode(java.io.InputStream inputStream, int i, int i2) {
        return com.alimm.tanx.ui.image.glide.load.resource.bitmap.BitmapResource.obtain(this.downsampler.decode(inputStream, this.bitmapPool, i, i2, this.decodeFormat), this.bitmapPool);
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public java.lang.String getId() {
        if (this.id == null) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do(ID);
            tanxu_do2.append(this.downsampler.getId());
            tanxu_do2.append(this.decodeFormat.name());
            this.id = tanxu_do2.toString();
        }
        return this.id;
    }
}
