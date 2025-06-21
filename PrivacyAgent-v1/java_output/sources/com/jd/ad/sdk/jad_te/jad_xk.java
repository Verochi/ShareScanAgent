package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_xk<T> implements com.jd.ad.sdk.jad_ju.jad_ly<T, android.graphics.Bitmap> {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Long> jad_dq = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new com.jd.ad.sdk.jad_te.jad_xk.jad_an());
    public static final com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Integer> jad_er = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new com.jd.ad.sdk.jad_te.jad_xk.jad_bo());
    public static final com.jd.ad.sdk.jad_te.jad_xk.jad_er jad_fs = new com.jd.ad.sdk.jad_te.jad_xk.jad_er();
    public final com.jd.ad.sdk.jad_te.jad_xk.jad_fs<T> jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_bo;
    public final com.jd.ad.sdk.jad_te.jad_xk.jad_er jad_cp;

    public class jad_an implements com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<java.lang.Long> {
        public final java.nio.ByteBuffer jad_an = java.nio.ByteBuffer.allocate(8);

        @Override // com.jd.ad.sdk.jad_ju.jad_iv.jad_bo
        public void jad_an(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.lang.Long l, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
            java.lang.Long l2 = l;
            messageDigest.update(bArr);
            synchronized (this.jad_an) {
                this.jad_an.position(0);
                messageDigest.update(this.jad_an.putLong(l2.longValue()).array());
            }
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_ju.jad_iv.jad_bo<java.lang.Integer> {
        public final java.nio.ByteBuffer jad_an = java.nio.ByteBuffer.allocate(4);

        @Override // com.jd.ad.sdk.jad_ju.jad_iv.jad_bo
        public void jad_an(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull java.lang.Integer num, @androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
            java.lang.Integer num2 = num;
            if (num2 == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.jad_an) {
                this.jad_an.position(0);
                messageDigest.update(this.jad_an.putInt(num2.intValue()).array());
            }
        }
    }

    public static final class jad_cp implements com.jd.ad.sdk.jad_te.jad_xk.jad_fs<android.content.res.AssetFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_te.jad_xk.jad_fs
        public void jad_an(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.content.res.AssetFileDescriptor assetFileDescriptor) {
            android.content.res.AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static final class jad_dq implements com.jd.ad.sdk.jad_te.jad_xk.jad_fs<java.nio.ByteBuffer> {
        @Override // com.jd.ad.sdk.jad_te.jad_xk.jad_fs
        public void jad_an(android.media.MediaMetadataRetriever mediaMetadataRetriever, java.nio.ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new com.jd.ad.sdk.jad_te.jad_yl(this, byteBuffer));
        }
    }

    @androidx.annotation.VisibleForTesting
    public static class jad_er {
    }

    @androidx.annotation.VisibleForTesting
    public interface jad_fs<T> {
        void jad_an(android.media.MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    public static final class jad_hu extends java.lang.RuntimeException {
        public jad_hu() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public static final class jad_jt implements com.jd.ad.sdk.jad_te.jad_xk.jad_fs<android.os.ParcelFileDescriptor> {
        @Override // com.jd.ad.sdk.jad_te.jad_xk.jad_fs
        public void jad_an(android.media.MediaMetadataRetriever mediaMetadataRetriever, android.os.ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    @androidx.annotation.VisibleForTesting
    public jad_xk(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_te.jad_xk.jad_fs<T> jad_fsVar, com.jd.ad.sdk.jad_te.jad_xk.jad_er jad_erVar2) {
        this.jad_bo = jad_erVar;
        this.jad_an = jad_fsVar;
        this.jad_cp = jad_erVar2;
    }

    @androidx.annotation.Nullable
    public static android.graphics.Bitmap jad_an(android.media.MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, com.jd.ad.sdk.jad_te.jad_iv jad_ivVar) {
        android.graphics.Bitmap bitmap = null;
        if (android.os.Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && jad_ivVar != com.jd.ad.sdk.jad_te.jad_iv.jad_bo) {
            try {
                int parseInt = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = java.lang.Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float jad_bo2 = jad_ivVar.jad_bo(parseInt, parseInt2, i2, i3);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j, i, java.lang.Math.round(parseInt * jad_bo2), java.lang.Math.round(jad_bo2 * parseInt2));
            } catch (java.lang.Throwable th) {
                if (android.util.Log.isLoggable("VideoDecoder", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
                }
            }
        }
        if (bitmap == null) {
            bitmap = mediaMetadataRetriever.getFrameAtTime(j, i);
        }
        if (bitmap != null) {
            return bitmap;
        }
        throw new com.jd.ad.sdk.jad_te.jad_xk.jad_hu();
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<android.content.res.AssetFileDescriptor, android.graphics.Bitmap> jad_an(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        return new com.jd.ad.sdk.jad_te.jad_xk(jad_erVar, new com.jd.ad.sdk.jad_te.jad_xk.jad_cp(), jad_fs);
    }

    @androidx.annotation.RequiresApi(api = 23)
    public static com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, android.graphics.Bitmap> jad_bo(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        return new com.jd.ad.sdk.jad_te.jad_xk(jad_erVar, new com.jd.ad.sdk.jad_te.jad_xk.jad_dq(), jad_fs);
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<android.os.ParcelFileDescriptor, android.graphics.Bitmap> jad_cp(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        return new com.jd.ad.sdk.jad_te.jad_xk(jad_erVar, new com.jd.ad.sdk.jad_te.jad_xk.jad_jt(), jad_fs);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull T t, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        long longValue = ((java.lang.Long) jad_jwVar.jad_an(jad_dq)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new java.lang.IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        java.lang.Integer num = (java.lang.Integer) jad_jwVar.jad_an(jad_er);
        if (num == null) {
            num = 2;
        }
        com.jd.ad.sdk.jad_te.jad_iv jad_ivVar = (com.jd.ad.sdk.jad_te.jad_iv) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_iv.jad_dq);
        if (jad_ivVar == null) {
            jad_ivVar = com.jd.ad.sdk.jad_te.jad_iv.jad_cp;
        }
        com.jd.ad.sdk.jad_te.jad_iv jad_ivVar2 = jad_ivVar;
        this.jad_cp.getClass();
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            this.jad_an.jad_an(mediaMetadataRetriever, t);
            return com.jd.ad.sdk.jad_te.jad_er.jad_an(jad_an(mediaMetadataRetriever, longValue, num.intValue(), i, i2, jad_ivVar2), this.jad_bo);
        } finally {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetriever.close();
            } else {
                mediaMetadataRetriever.release();
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull T t, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
