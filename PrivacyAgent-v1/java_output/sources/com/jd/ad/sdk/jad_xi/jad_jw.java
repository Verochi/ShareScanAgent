package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_jw implements com.jd.ad.sdk.jad_ju.jad_ly<java.io.InputStream, com.jd.ad.sdk.jad_xi.jad_cp> {
    public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_an;
    public final com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, com.jd.ad.sdk.jad_xi.jad_cp> jad_bo;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_cp;

    public jad_jw(java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, com.jd.ad.sdk.jad_xi.jad_cp> jad_lyVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = list;
        this.jad_bo = jad_lyVar;
        this.jad_cp = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        byte[] bArr;
        java.io.InputStream inputStream2 = inputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(16384);
        try {
            byte[] bArr2 = new byte[16384];
            while (true) {
                int read = inputStream2.read(bArr2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byteArrayOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable("StreamGifDecoder", 5)) {
                com.jd.ad.sdk.logger.Logger.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return this.jad_bo.jad_an(java.nio.ByteBuffer.wrap(bArr), i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return !((java.lang.Boolean) jad_jwVar.jad_an(com.jd.ad.sdk.jad_xi.jad_iv.jad_bo)).booleanValue() && com.jd.ad.sdk.jad_ju.jad_jt.jad_bo(this.jad_an, inputStream, this.jad_cp) == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.GIF;
    }
}
