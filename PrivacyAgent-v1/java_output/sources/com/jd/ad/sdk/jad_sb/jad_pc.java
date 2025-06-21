package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_pc implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final java.lang.String jad_an;
    public final java.util.List<com.jd.ad.sdk.jad_sb.jad_cp> jad_bo;
    public final boolean jad_cp;

    public jad_pc(java.lang.String str, java.util.List<com.jd.ad.sdk.jad_sb.jad_cp> list, boolean z) {
        this.jad_an = str;
        this.jad_bo = list;
        this.jad_cp = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_dq(jad_mzVar, jad_anVar, this);
    }

    public java.util.List<com.jd.ad.sdk.jad_sb.jad_cp> jad_an() {
        return this.jad_bo;
    }

    public java.lang.String jad_bo() {
        return this.jad_an;
    }

    public boolean jad_cp() {
        return this.jad_cp;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("ShapeGroup{name='");
        jad_an.append(this.jad_an);
        jad_an.append("' Shapes: ");
        jad_an.append(java.util.Arrays.toString(this.jad_bo.toArray()));
        jad_an.append('}');
        return jad_an.toString();
    }
}
