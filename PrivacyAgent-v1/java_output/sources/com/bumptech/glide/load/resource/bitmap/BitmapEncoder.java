package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class BitmapEncoder implements com.bumptech.glide.load.ResourceEncoder<android.graphics.Bitmap> {
    private static final java.lang.String TAG = "BitmapEncoder";

    @androidx.annotation.Nullable
    private final com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool;
    public static final com.bumptech.glide.load.Option<java.lang.Integer> COMPRESSION_QUALITY = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.bumptech.glide.load.Option<android.graphics.Bitmap.CompressFormat> COMPRESSION_FORMAT = com.bumptech.glide.load.Option.memory("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    @java.lang.Deprecated
    public BitmapEncoder() {
        this.arrayPool = null;
    }

    public BitmapEncoder(@androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
    }

    private android.graphics.Bitmap.CompressFormat getFormat(android.graphics.Bitmap bitmap, com.bumptech.glide.load.Options options) {
        android.graphics.Bitmap.CompressFormat compressFormat = (android.graphics.Bitmap.CompressFormat) options.get(COMPRESSION_FORMAT);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #2 {all -> 0x00b2, blocks: (B:3:0x0021, B:15:0x004b, B:18:0x0063, B:20:0x0069, B:43:0x00ae, B:41:0x00b1, B:34:0x005e), top: B:2:0x0021 }] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean encode(@androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> resource, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        boolean z;
        java.io.FileOutputStream fileOutputStream;
        android.graphics.Bitmap bitmap = resource.get();
        android.graphics.Bitmap.CompressFormat format = getFormat(bitmap, options);
        com.bumptech.glide.util.pool.GlideTrace.beginSectionFormat("encode: [%dx%d] %s", java.lang.Integer.valueOf(bitmap.getWidth()), java.lang.Integer.valueOf(bitmap.getHeight()), format);
        try {
            long logTime = com.bumptech.glide.util.LogTime.getLogTime();
            int intValue = ((java.lang.Integer) options.get(COMPRESSION_QUALITY)).intValue();
            java.io.OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                } catch (java.io.IOException unused) {
                }
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                outputStream = this.arrayPool != null ? new com.bumptech.glide.load.data.BufferedOutputStream(fileOutputStream, this.arrayPool) : fileOutputStream;
                bitmap.compress(format, intValue, outputStream);
                outputStream.close();
                try {
                    outputStream.close();
                } catch (java.io.IOException unused2) {
                }
                z = true;
            } catch (java.io.IOException unused3) {
                outputStream = fileOutputStream;
                android.util.Log.isLoggable(TAG, 3);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                z = false;
                if (android.util.Log.isLoggable(TAG, 2)) {
                }
                return z;
            } catch (java.lang.Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (java.io.IOException unused5) {
                    }
                }
                throw th;
            }
            if (android.util.Log.isLoggable(TAG, 2)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Compressed with type: ");
                sb.append(format);
                sb.append(" of size ");
                sb.append(com.bumptech.glide.util.Util.getBitmapByteSize(bitmap));
                sb.append(" in ");
                sb.append(com.bumptech.glide.util.LogTime.getElapsedMillis(logTime));
                sb.append(", options format: ");
                sb.append(options.get(COMPRESSION_FORMAT));
                sb.append(", hasAlpha: ");
                sb.append(bitmap.hasAlpha());
            }
            return z;
        } finally {
            com.bumptech.glide.util.pool.GlideTrace.endSection();
        }
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.EncodeStrategy getEncodeStrategy(@androidx.annotation.NonNull com.bumptech.glide.load.Options options) {
        return com.bumptech.glide.load.EncodeStrategy.TRANSFORMED;
    }
}
