package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_an<DataType> implements com.jd.ad.sdk.jad_ju.jad_ly<DataType, android.graphics.drawable.BitmapDrawable> {
    public final com.jd.ad.sdk.jad_ju.jad_ly<DataType, android.graphics.Bitmap> jad_an;
    public final android.content.res.Resources jad_bo;

    public jad_an(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_ly<DataType, android.graphics.Bitmap> jad_lyVar) {
        this.jad_bo = (android.content.res.Resources) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(resources);
        this.jad_an = (com.jd.ad.sdk.jad_ju.jad_ly) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_lyVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.BitmapDrawable> jad_an(@androidx.annotation.NonNull DataType datatype, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_te.jad_qd.jad_an(this.jad_bo, this.jad_an.jad_an(datatype, i, i2, jad_jwVar));
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull DataType datatype, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(datatype, jad_jwVar);
    }
}
