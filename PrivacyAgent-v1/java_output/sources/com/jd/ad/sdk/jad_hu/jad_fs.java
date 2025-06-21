package com.jd.ad.sdk.jad_hu;

/* loaded from: classes23.dex */
public class jad_fs extends com.jd.ad.sdk.jad_fo.jad_an<android.graphics.Bitmap> {
    public final /* synthetic */ com.jd.ad.sdk.jad_lu.jad_na jad_dq;
    public final /* synthetic */ android.graphics.Bitmap[] jad_er;

    public jad_fs(com.jd.ad.sdk.jad_hu.jad_jt jad_jtVar, com.jd.ad.sdk.jad_lu.jad_na jad_naVar, android.graphics.Bitmap[] bitmapArr) {
        this.jad_dq = jad_naVar;
        this.jad_er = bitmapArr;
    }

    public void jad_an(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gp.jad_bo<? super android.graphics.Bitmap> jad_boVar) {
        com.jd.ad.sdk.jad_lu.jad_na jad_naVar = this.jad_dq;
        this.jad_er[0] = com.jd.ad.sdk.jad_hu.jad_hu.jad_an(bitmap, jad_naVar.jad_an, jad_naVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_an(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public /* bridge */ /* synthetic */ void jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.Nullable com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
        jad_an((android.graphics.Bitmap) obj, (com.jd.ad.sdk.jad_gp.jad_bo<? super android.graphics.Bitmap>) jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_an, com.jd.ad.sdk.jad_fo.jad_er
    public void jad_cp(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }
}
