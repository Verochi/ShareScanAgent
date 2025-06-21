package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_uh implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final java.lang.String jad_an;
    public final int jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_cp;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_dq;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_er;
    public final boolean jad_fs;

    public jad_uh(java.lang.String str, int i, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar3, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = jad_boVar;
        this.jad_dq = jad_boVar2;
        this.jad_er = jad_boVar3;
        this.jad_fs = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_sf(jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_an() {
        return this.jad_dq;
    }

    public java.lang.String jad_bo() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_cp() {
        return this.jad_er;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_dq() {
        return this.jad_cp;
    }

    public int jad_er() {
        return this.jad_bo;
    }

    public boolean jad_fs() {
        return this.jad_fs;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Trim Path: {start: ");
        jad_an.append(this.jad_cp);
        jad_an.append(", end: ");
        jad_an.append(this.jad_dq);
        jad_an.append(", offset: ");
        jad_an.append(this.jad_er);
        jad_an.append(com.alipay.sdk.m.u.i.d);
        return jad_an.toString();
    }
}
