package com.jd.ad.sdk.jad_yj;

/* loaded from: classes23.dex */
public class jad_bo implements com.jd.ad.sdk.jad_yj.jad_er<android.graphics.Bitmap, android.graphics.drawable.BitmapDrawable> {
    public final android.content.res.Resources jad_an;

    public jad_bo(@androidx.annotation.NonNull android.content.res.Resources resources) {
        this.jad_an = (android.content.res.Resources) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(resources);
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.BitmapDrawable> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_xkVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_te.jad_qd.jad_an(this.jad_an, jad_xkVar);
    }
}
