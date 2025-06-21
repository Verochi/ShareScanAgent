package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_bo implements com.jd.ad.sdk.jad_ju.jad_mz<android.graphics.drawable.BitmapDrawable> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final com.jd.ad.sdk.jad_ju.jad_mz<android.graphics.Bitmap> jad_bo;

    public jad_bo(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ju.jad_mz<android.graphics.Bitmap> jad_mzVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_mzVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_mz
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_cp jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_bo.jad_an(jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public boolean jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_bo.jad_an(new com.jd.ad.sdk.jad_te.jad_er(((android.graphics.drawable.BitmapDrawable) ((com.jd.ad.sdk.jad_mx.jad_xk) obj).get()).getBitmap(), this.jad_an), file, jad_jwVar);
    }
}
