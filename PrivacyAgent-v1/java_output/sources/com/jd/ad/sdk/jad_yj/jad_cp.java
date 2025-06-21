package com.jd.ad.sdk.jad_yj;

/* loaded from: classes23.dex */
public final class jad_cp implements com.jd.ad.sdk.jad_yj.jad_er<android.graphics.drawable.Drawable, byte[]> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final com.jd.ad.sdk.jad_yj.jad_er<android.graphics.Bitmap, byte[]> jad_bo;
    public final com.jd.ad.sdk.jad_yj.jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> jad_cp;

    public jad_cp(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_er jad_erVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_yj.jad_er<android.graphics.Bitmap, byte[]> jad_erVar2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_yj.jad_er<com.jd.ad.sdk.jad_xi.jad_cp, byte[]> jad_erVar3) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_erVar2;
        this.jad_cp = jad_erVar3;
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<byte[]> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_xkVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.graphics.drawable.Drawable drawable = jad_xkVar.get();
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return this.jad_bo.jad_an(com.jd.ad.sdk.jad_te.jad_er.jad_an(((android.graphics.drawable.BitmapDrawable) drawable).getBitmap(), this.jad_an), jad_jwVar);
        }
        if (drawable instanceof com.jd.ad.sdk.jad_xi.jad_cp) {
            return this.jad_cp.jad_an(jad_xkVar, jad_jwVar);
        }
        return null;
    }
}
