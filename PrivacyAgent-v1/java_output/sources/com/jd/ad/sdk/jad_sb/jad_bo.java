package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_bo implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final java.lang.String jad_an;
    public final com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_fs jad_cp;
    public final boolean jad_dq;
    public final boolean jad_er;

    public jad_bo(java.lang.String str, com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_mzVar, com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar, boolean z, boolean z2) {
        this.jad_an = str;
        this.jad_bo = jad_mzVar;
        this.jad_cp = jad_fsVar;
        this.jad_dq = z;
        this.jad_er = z2;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_fs(jad_mzVar, jad_anVar, this);
    }

    public java.lang.String jad_an() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_ra.jad_mz<android.graphics.PointF, android.graphics.PointF> jad_bo() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_ra.jad_fs jad_cp() {
        return this.jad_cp;
    }
}
