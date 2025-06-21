package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public class jad_tg implements com.jd.ad.sdk.jad_ju.jad_ly<android.net.Uri, android.graphics.Bitmap> {
    public final com.jd.ad.sdk.jad_vg.jad_er jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_er jad_bo;

    public jad_tg(com.jd.ad.sdk.jad_vg.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_er jad_erVar2) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_erVar2;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull android.net.Uri uri, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_mx.jad_xk jad_an = this.jad_an.jad_an(uri);
        if (jad_an == null) {
            return null;
        }
        return com.jd.ad.sdk.jad_te.jad_kx.jad_an(this.jad_bo, (android.graphics.drawable.Drawable) ((com.jd.ad.sdk.jad_vg.jad_cp) jad_an).get(), i, i2);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
