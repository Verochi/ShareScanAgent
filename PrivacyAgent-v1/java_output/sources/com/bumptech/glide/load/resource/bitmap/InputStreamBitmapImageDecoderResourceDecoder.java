package com.bumptech.glide.load.resource.bitmap;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class InputStreamBitmapImageDecoderResourceDecoder implements com.bumptech.glide.load.ResourceDecoder<java.io.InputStream, android.graphics.Bitmap> {
    private final com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder wrapped = new com.bumptech.glide.load.resource.bitmap.BitmapImageDecoderResourceDecoder();

    @Override // com.bumptech.glide.load.ResourceDecoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(@androidx.annotation.NonNull java.io.InputStream inputStream, int i, int i2, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        android.graphics.ImageDecoder.Source createSource;
        createSource = android.graphics.ImageDecoder.createSource(com.bumptech.glide.util.ByteBufferUtil.fromStream(inputStream));
        return this.wrapped.decode(createSource, i, i2, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) throws java.io.IOException {
        return true;
    }
}
