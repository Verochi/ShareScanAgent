package com.jd.ad.sdk.jad_sb;

/* loaded from: classes23.dex */
public class jad_iv implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final java.lang.String jad_an;
    public final int jad_bo;
    public final boolean jad_cp;

    public jad_iv(java.lang.String str, int i, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        if (jad_mzVar.jad_na) {
            return new com.jd.ad.sdk.jad_nw.jad_ly(this);
        }
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Animation contains merge paths but they are disabled.");
        return null;
    }

    public java.lang.String jad_an() {
        return this.jad_an;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_lu.jad_zm.jad_an("MergePaths{mode=");
        jad_an.append(com.jd.ad.sdk.jad_sb.jad_hu.jad_an(this.jad_bo));
        jad_an.append('}');
        return jad_an.toString();
    }
}
