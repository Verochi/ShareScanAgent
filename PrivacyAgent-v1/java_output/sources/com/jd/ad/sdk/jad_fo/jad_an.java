package com.jd.ad.sdk.jad_fo;

/* loaded from: classes23.dex */
public abstract class jad_an<T> implements com.jd.ad.sdk.jad_fo.jad_er<T> {
    public final int jad_an;
    public final int jad_bo;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_en.jad_dq jad_cp;

    public jad_an() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public jad_an(int i, int i2) {
        if (com.jd.ad.sdk.jad_ir.jad_ly.jad_bo(i, i2)) {
            this.jad_an = i;
            this.jad_bo = i2;
            return;
        }
        throw new java.lang.IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_an() {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        this.jad_cp = jad_dqVar;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final void jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_fo.jad_dq jad_dqVar) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_en.jad_dq jad_bo() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_bo(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final void jad_bo(@androidx.annotation.NonNull com.jd.ad.sdk.jad_fo.jad_dq jad_dqVar) {
        ((com.jd.ad.sdk.jad_en.jad_jw) jad_dqVar).jad_an(this.jad_an, this.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_cp(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_dq() {
    }
}
