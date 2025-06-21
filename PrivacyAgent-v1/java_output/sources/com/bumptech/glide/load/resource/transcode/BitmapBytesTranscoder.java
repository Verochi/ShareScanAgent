package com.bumptech.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class BitmapBytesTranscoder implements com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, byte[]> {
    private final android.graphics.Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(android.graphics.Bitmap.CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(@androidx.annotation.NonNull android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @androidx.annotation.Nullable
    public com.bumptech.glide.load.engine.Resource<byte[]> transcode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        resource.get().compress(this.compressFormat, this.quality, byteArrayOutputStream);
        resource.recycle();
        return new com.bumptech.glide.load.resource.bytes.BytesResource(byteArrayOutputStream.toByteArray());
    }
}
