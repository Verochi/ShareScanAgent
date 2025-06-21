package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap>, com.jd.ad.sdk.jad_mx.jad_tg {
    public final android.graphics.Bitmap jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_bo;

    public jad_er(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        this.jad_an = (android.graphics.Bitmap) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(bitmap, "Bitmap must not be null");
        this.jad_bo = (com.jd.ad.sdk.jad_ny.jad_er) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_erVar, "BitmapPool must not be null");
    }

    @androidx.annotation.Nullable
    public static com.jd.ad.sdk.jad_te.jad_er jad_an(@androidx.annotation.Nullable android.graphics.Bitmap bitmap, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        if (bitmap == null) {
            return null;
        }
        return new com.jd.ad.sdk.jad_te.jad_er(bitmap, jad_erVar);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public android.graphics.Bitmap get() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        this.jad_an.prepareToDraw();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.Bitmap> jad_cp() {
        return android.graphics.Bitmap.class;
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public void jad_dq() {
        this.jad_bo.jad_an(this.jad_an);
    }
}
