package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_fs implements com.jd.ad.sdk.jad_ju.jad_na<com.jd.ad.sdk.jad_xi.jad_cp> {
    public final com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_bo;

    public jad_fs(com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_naVar) {
        this.jad_bo = (com.jd.ad.sdk.jad_ju.jad_na) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_naVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.jd.ad.sdk.jad_xi.jad_fs) {
            return this.jad_bo.equals(((com.jd.ad.sdk.jad_xi.jad_fs) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_na
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_mx.jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_an(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<com.jd.ad.sdk.jad_xi.jad_cp> jad_xkVar, int i, int i2) {
        com.jd.ad.sdk.jad_xi.jad_cp jad_cpVar = jad_xkVar.get();
        com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_erVar = new com.jd.ad.sdk.jad_te.jad_er(jad_cpVar.jad_bo(), com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_an);
        com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an = this.jad_bo.jad_an(context, jad_erVar, i, i2);
        if (!jad_erVar.equals(jad_an)) {
            jad_erVar.jad_dq();
        }
        android.graphics.Bitmap bitmap = jad_an.get();
        jad_cpVar.jad_an.jad_an.jad_an(this.jad_bo, bitmap);
        return jad_xkVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
    }
}
