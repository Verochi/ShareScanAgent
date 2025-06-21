package com.bumptech.glide.load.resource.bitmap;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes.dex */
public final class BitmapImageDecoderResourceDecoder extends com.bumptech.glide.load.resource.ImageDecoderResourceDecoder<android.graphics.Bitmap> {
    private static final java.lang.String TAG = "BitmapImageDecoder";
    private final com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool bitmapPool = new com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter();

    @Override // com.bumptech.glide.load.resource.ImageDecoderResourceDecoder
    public com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> decode(android.graphics.ImageDecoder.Source source, int i, int i2, android.graphics.ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws java.io.IOException {
        android.graphics.Bitmap decodeBitmap;
        decodeBitmap = android.graphics.ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (android.util.Log.isLoggable(TAG, 2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Decoded [");
            sb.append(decodeBitmap.getWidth());
            sb.append("x");
            sb.append(decodeBitmap.getHeight());
            sb.append("] for [");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("]");
        }
        return new com.bumptech.glide.load.resource.bitmap.BitmapResource(decodeBitmap, this.bitmapPool);
    }
}
