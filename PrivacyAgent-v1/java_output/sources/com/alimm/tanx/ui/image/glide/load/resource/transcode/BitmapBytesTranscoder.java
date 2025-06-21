package com.alimm.tanx.ui.image.glide.load.resource.transcode;

/* loaded from: classes.dex */
public class BitmapBytesTranscoder implements com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, byte[]> {
    private final android.graphics.Bitmap.CompressFormat compressFormat;
    private final int quality;

    public BitmapBytesTranscoder() {
        this(android.graphics.Bitmap.CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public java.lang.String getId() {
        return "BitmapBytesTranscoder.com.alimm.tanx.ui.image.glide.load.resource.transcode";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public com.alimm.tanx.ui.image.glide.load.engine.Resource<byte[]> transcode(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        resource.get().compress(this.compressFormat, this.quality, byteArrayOutputStream);
        resource.recycle();
        return new com.alimm.tanx.ui.image.glide.load.resource.bytes.BytesResource(byteArrayOutputStream.toByteArray());
    }
}
