package com.bumptech.glide.load.resource.bitmap;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class ByteBufferBitmapImageDecoderResourceDecoder implements com.bumptech.glide.load.ResourceDecoder<java.nio.ByteBuffer, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder wrapped = new com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder();

    @Override // com.bumptech.glide.load.ResourceDecoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        android.graphics.ImageDecoder.Source createSource;
        createSource = android.graphics.ImageDecoder.createSource(byteBuffer);
        return this.wrapped.decode(createSource, i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return true;
    }
}
