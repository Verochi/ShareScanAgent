package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class ByteBufferBitmapDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.resource.bitmap.Downsampler downsampler;

    public ByteBufferBitmapDecoder(com.bumptech.glide.load.resource.bitmap.Downsampler downsampler) {
        this.downsampler = downsampler;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return this.downsampler.decode(com.bumptech.glide.util.ByteBufferUtil.toStream(byteBuffer), i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return this.downsampler.handles(byteBuffer);
    }
}
