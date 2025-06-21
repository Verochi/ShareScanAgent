package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_fs implements com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, android.graphics.Bitmap> {
    public final com.jd.ad.sdk.jad_te.jad_jw jad_an;

    public jad_fs(com.jd.ad.sdk.jad_te.jad_jw jad_jwVar) {
        this.jad_an = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_te.jad_jw jad_jwVar2 = this.jad_an;
        return jad_jwVar2.jad_an(new com.jd.ad.sdk.jad_te.jad_ob.jad_an(byteBuffer, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i, i2, jad_jwVar, com.jd.ad.sdk.jad_te.jad_jw.jad_kx);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_an.getClass();
        return true;
    }
}
