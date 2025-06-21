package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_er implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final int jad_an;
    public final android.graphics.Path.FillType jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_cp jad_cp;
    public final com.jd.ad.sdk.jad_ra.jad_dq jad_dq;
    public final com.jd.ad.sdk.jad_ra.jad_fs jad_er;
    public final com.jd.ad.sdk.jad_ra.jad_fs jad_fs;
    public final boolean jad_hu;
    public final java.lang.String jad_jt;

    public jad_er(java.lang.String str, int i, android.graphics.Path.FillType fillType, com.jd.ad.sdk.jad_ra.jad_cp jad_cpVar, com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar, com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar, com.jd.ad.sdk.jad_ra.jad_fs jad_fsVar2, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2, boolean z) {
        this.jad_an = i;
        this.jad_bo = fillType;
        this.jad_cp = jad_cpVar;
        this.jad_dq = jad_dqVar;
        this.jad_er = jad_fsVar;
        this.jad_fs = jad_fsVar2;
        this.jad_jt = str;
        this.jad_hu = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_hu(jad_mzVar, jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_ra.jad_fs jad_an() {
        return this.jad_fs;
    }

    public android.graphics.Path.FillType jad_bo() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_ra.jad_cp jad_cp() {
        return this.jad_cp;
    }

    public int jad_dq() {
        return this.jad_an;
    }

    public java.lang.String jad_er() {
        return this.jad_jt;
    }

    public com.jd.ad.sdk.jad_ra.jad_dq jad_fs() {
        return this.jad_dq;
    }

    public boolean jad_hu() {
        return this.jad_hu;
    }

    public com.jd.ad.sdk.jad_ra.jad_fs jad_jt() {
        return this.jad_er;
    }
}
