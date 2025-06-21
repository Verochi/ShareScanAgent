package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_ob implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final boolean jad_an;
    public final android.graphics.Path.FillType jad_bo;
    public final java.lang.String jad_cp;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ra.jad_an jad_dq;

    @androidx.annotation.Nullable
    public final com.jd.ad.sdk.jad_ra.jad_dq jad_er;
    public final boolean jad_fs;

    public jad_ob(java.lang.String str, boolean z, android.graphics.Path.FillType fillType, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ra.jad_an jad_anVar, @androidx.annotation.Nullable com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar, boolean z2) {
        this.jad_cp = str;
        this.jad_an = z;
        this.jad_bo = fillType;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_dqVar;
        this.jad_fs = z2;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_jt(jad_mzVar, jad_anVar, this);
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ra.jad_an jad_an() {
        return this.jad_dq;
    }

    public android.graphics.Path.FillType jad_bo() {
        return this.jad_bo;
    }

    public java.lang.String jad_cp() {
        return this.jad_cp;
    }

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ra.jad_dq jad_dq() {
        return this.jad_er;
    }

    public boolean jad_er() {
        return this.jad_fs;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("ShapeFill{color=, fillEnabled=");
        jad_an.append(this.jad_an);
        jad_an.append('}');
        return jad_an.toString();
    }
}
