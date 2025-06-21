package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_qd implements com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.BitmapDrawable>, com.jd.ad.sdk.jad_mx.jad_tg {
    public final android.content.res.Resources jad_an;
    public final com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_bo;

    public jad_qd(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_xkVar) {
        this.jad_an = (android.content.res.Resources) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(resources);
        this.jad_bo = (com.jd.ad.sdk.jad_mx.jad_xk) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_xkVar);
    }

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.BitmapDrawable> jad_an(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.Nullable com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_xkVar) {
        if (jad_xkVar == null) {
            return null;
        }
        return new com.jd.ad.sdk.jad_te.jad_qd(resources, jad_xkVar);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public android.graphics.drawable.BitmapDrawable get() {
        return new android.graphics.drawable.BitmapDrawable(this.jad_an, this.jad_bo.get());
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_xkVar = this.jad_bo;
        if (jad_xkVar instanceof com.jd.ad.sdk.jad_mx.jad_tg) {
            ((com.jd.ad.sdk.jad_mx.jad_tg) jad_xkVar).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        return this.jad_bo.jad_bo();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.drawable.BitmapDrawable> jad_cp() {
        return android.graphics.drawable.BitmapDrawable.class;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public void jad_dq() {
        this.jad_bo.jad_dq();
    }
}
