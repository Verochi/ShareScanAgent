package com.jd.ad.sdk.jad_te;

@androidx.annotation.RequiresApi(27)
/* loaded from: classes23.dex */
public final class jad_mz implements com.jd.ad.sdk.jad_ju.jad_fs {
    /* JADX WARN: Removed duplicated region for block: B:5:0x0019 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        int jad_bo;
        com.jd.ad.sdk.jad_bo.jad_an jad_anVar = new com.jd.ad.sdk.jad_bo.jad_an(inputStream, false);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_bo2 = jad_anVar.jad_bo(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
        if (jad_bo2 != null) {
            try {
                jad_bo = jad_bo2.jad_bo(jad_anVar.jad_jt);
            } catch (java.lang.NumberFormatException unused) {
            }
            if (jad_bo != 0) {
                return -1;
            }
            return jad_bo;
        }
        jad_bo = 1;
        if (jad_bo != 0) {
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        java.util.concurrent.atomic.AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_ir.jad_an.jad_an;
        return jad_an(new com.jd.ad.sdk.jad_ir.jad_an.C0381jad_an(byteBuffer), jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream) {
        return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
    }
}
