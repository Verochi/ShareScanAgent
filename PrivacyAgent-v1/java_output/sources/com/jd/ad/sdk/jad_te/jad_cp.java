package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ju.jad_mz<android.graphics.Bitmap> {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Integer> jad_bo = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.jd.ad.sdk.jad_ju.jad_iv<android.graphics.Bitmap.CompressFormat> jad_cp = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, com.jd.ad.sdk.jad_ju.jad_iv.jad_er);

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;

    public jad_cp(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_mz
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_cp jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_ju.jad_cp.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {, blocks: (B:9:0x0024, B:20:0x0053, B:22:0x0078, B:24:0x007e, B:49:0x00cc, B:47:0x00cf, B:42:0x0074), top: B:8:0x0024 }] */
    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_xkVar, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        java.io.OutputStream outputStream;
        boolean z;
        android.graphics.Bitmap bitmap = jad_xkVar.get();
        android.graphics.Bitmap.CompressFormat compressFormat = (android.graphics.Bitmap.CompressFormat) jad_jwVar.jad_an(jad_cp);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? android.graphics.Bitmap.CompressFormat.PNG : android.graphics.Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        long jad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        int intValue = ((java.lang.Integer) jad_jwVar.jad_an(jad_bo)).intValue();
        java.io.OutputStream outputStream2 = null;
        try {
            try {
                outputStream = new java.io.FileOutputStream(file);
            } catch (java.io.IOException e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
            outputStream = outputStream2;
        }
        try {
            outputStream2 = this.jad_an != null ? new com.jd.ad.sdk.jad_kv.jad_cp(outputStream, this.jad_an, 65536) : outputStream;
            bitmap.compress(compressFormat, intValue, outputStream2);
            outputStream2.close();
            try {
                outputStream2.close();
            } catch (java.io.IOException unused) {
            }
            z = true;
        } catch (java.io.IOException e2) {
            e = e2;
            outputStream2 = outputStream;
            if (android.util.Log.isLoggable("BitmapEncoder", 3)) {
                com.jd.ad.sdk.logger.Logger.d("BitmapEncoder", "Failed to encode Bitmap", e);
            }
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (java.io.IOException unused2) {
                }
            }
            z = false;
            if (android.util.Log.isLoggable("BitmapEncoder", 2)) {
            }
            return z;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (java.io.IOException unused3) {
                }
            }
            throw th;
        }
        if (android.util.Log.isLoggable("BitmapEncoder", 2)) {
            com.jd.ad.sdk.logger.Logger.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap) + " in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jad_an) + ", options format: " + jad_jwVar.jad_an(jad_cp) + ", hasAlpha: " + bitmap.hasAlpha());
        }
        return z;
    }
}
