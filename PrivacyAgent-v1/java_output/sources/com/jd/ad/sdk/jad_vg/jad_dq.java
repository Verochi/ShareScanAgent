package com.jd.ad.sdk.jad_vg;

/* loaded from: classes23.dex */
public final class jad_dq extends com.jd.ad.sdk.jad_vg.jad_cp<android.graphics.drawable.Drawable> {
    public jad_dq(android.graphics.drawable.Drawable drawable) {
        super(drawable);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public int jad_bo() {
        return java.lang.Math.max(1, this.jad_an.getIntrinsicHeight() * this.jad_an.getIntrinsicWidth() * 4);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    @androidx.annotation.NonNull
    public java.lang.Class<android.graphics.drawable.Drawable> jad_cp() {
        return this.jad_an.getClass();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public void jad_dq() {
    }
}
