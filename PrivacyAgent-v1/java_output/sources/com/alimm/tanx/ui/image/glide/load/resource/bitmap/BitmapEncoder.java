package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapEncoder implements com.alimm.tanx.ui.image.glide.load.ResourceEncoder<android.graphics.Bitmap> {
    private static final int DEFAULT_COMPRESSION_QUALITY = 90;
    private static final java.lang.String TAG = "BitmapEncoder";
    private android.graphics.Bitmap.CompressFormat compressFormat;
    private int quality;

    public BitmapEncoder() {
        this(null, 90);
    }

    public BitmapEncoder(android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }

    private android.graphics.Bitmap.CompressFormat getFormat(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap.CompressFormat compressFormat = this.compressFormat;
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(com.alimm.tanx.ui.image.glide.load.engine.Resource<android.graphics.Bitmap> resource, java.io.OutputStream outputStream) {
        android.graphics.Bitmap bitmap = resource.get();
        long logTime = com.alimm.tanx.ui.image.glide.util.LogTime.getLogTime();
        android.graphics.Bitmap.CompressFormat format = getFormat(bitmap);
        bitmap.compress(format, this.quality, outputStream);
        if (!android.util.Log.isLoggable(TAG, 2)) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Compressed with type: ");
        sb.append(format);
        sb.append(" of size ");
        sb.append(com.alimm.tanx.ui.image.glide.util.Util.getBitmapByteSize(bitmap));
        sb.append(" in ");
        sb.append(com.alimm.tanx.ui.image.glide.util.LogTime.getElapsedMillis(logTime));
        return true;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public java.lang.String getId() {
        return "BitmapEncoder.com.alimm.tanx.ui.image.glide.load.resource.bitmap";
    }
}
