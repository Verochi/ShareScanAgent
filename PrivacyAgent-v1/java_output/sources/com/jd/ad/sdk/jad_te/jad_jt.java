package com.jd.ad.sdk.jad_te;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes23.dex */
public final class jad_jt implements com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, android.graphics.Bitmap> {
    public final com.jd.ad.sdk.jad_te.jad_dq jad_an = new com.jd.ad.sdk.jad_te.jad_dq();

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.graphics.ImageDecoder.Source createSource;
        createSource = android.graphics.ImageDecoder.createSource(byteBuffer);
        return this.jad_an.jad_an(createSource, i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
