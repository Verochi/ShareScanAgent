package com.jd.ad.sdk.jad_ra;

/* loaded from: classes23.dex */
public class jad_iv implements com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> {
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_an;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_bo;

    public jad_iv(com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2) {
        this.jad_an = jad_boVar;
        this.jad_bo = jad_boVar2;
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an() {
        return new com.jd.ad.sdk.jad_ox.jad_na(this.jad_an.jad_an(), this.jad_bo.jad_an());
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public java.util.List<com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF>> jad_bo() {
        throw new java.lang.UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public boolean jad_cp() {
        return this.jad_an.jad_cp() && this.jad_bo.jad_cp();
    }
}
