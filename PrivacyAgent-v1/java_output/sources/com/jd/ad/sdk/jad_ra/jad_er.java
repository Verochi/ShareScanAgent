package com.jd.ad.sdk.jad_ra;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> {
    public final java.util.List<com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF>> jad_an;

    public jad_er(java.util.List<com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF>> list) {
        this.jad_an = list;
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.PointF, android.graphics.PointF> jad_an() {
        return this.jad_an.get(0).jad_cp() ? new com.jd.ad.sdk.jad_ox.jad_kx(this.jad_an) : new com.jd.ad.sdk.jad_ox.jad_jw(this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public java.util.List<com.jd.ad.sdk.jad_yh.jad_an<android.graphics.PointF>> jad_bo() {
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_ra.jad_mz
    public boolean jad_cp() {
        return this.jad_an.size() == 1 && this.jad_an.get(0).jad_cp();
    }
}
