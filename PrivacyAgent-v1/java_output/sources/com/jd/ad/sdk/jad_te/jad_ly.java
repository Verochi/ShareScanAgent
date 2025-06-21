package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_ly implements com.jd.ad.sdk.jad_ju.jad_na<android.graphics.drawable.Drawable> {
    public final com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_bo;
    public final boolean jad_cp;

    public jad_ly(com.jd.ad.sdk.jad_ju.jad_na<android.graphics.Bitmap> jad_naVar, boolean z) {
        this.jad_bo = jad_naVar;
        this.jad_cp = z;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(java.lang.Object obj) {
        if (obj instanceof com.jd.ad.sdk.jad_te.jad_ly) {
            return this.jad_bo.equals(((com.jd.ad.sdk.jad_te.jad_ly) obj).jad_bo);
        }
        return false;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        return this.jad_bo.hashCode();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_na
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_an(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_xkVar, int i, int i2) {
        com.jd.ad.sdk.jad_ny.jad_er jad_erVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_an;
        android.graphics.drawable.Drawable drawable = jad_xkVar.get();
        com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an = com.jd.ad.sdk.jad_te.jad_kx.jad_an(jad_erVar, drawable, i, i2);
        if (jad_an != null) {
            com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an2 = this.jad_bo.jad_an(context, jad_an, i, i2);
            if (!jad_an2.equals(jad_an)) {
                return com.jd.ad.sdk.jad_te.jad_qd.jad_an(context.getResources(), jad_an2);
            }
            jad_an2.jad_dq();
            return jad_xkVar;
        }
        if (!this.jad_cp) {
            return jad_xkVar;
        }
        throw new java.lang.IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(@androidx.annotation.NonNull java.security.MessageDigest messageDigest) {
        this.jad_bo.jad_an(messageDigest);
    }
}
