package com.jd.ad.sdk.jad_kx;

/* loaded from: classes23.dex */
public class jad_cp {
    public final int jad_an;
    public final java.lang.String jad_bo;
    public final java.lang.String jad_cp;
    public java.lang.String jad_dq;
    public java.lang.String jad_er;

    public jad_cp(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.jad_an = i;
        this.jad_bo = str2;
        this.jad_cp = str;
        this.jad_dq = str3;
        this.jad_er = str4;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("PreloadAdData{id=");
        jad_an.append(this.jad_an);
        jad_an.append(", rId='");
        jad_an.append(this.jad_bo);
        jad_an.append('\'');
        jad_an.append(", appIdSlotId='");
        jad_an.append(this.jad_cp);
        jad_an.append('\'');
        jad_an.append(", preloadAdJson='");
        jad_an.append(this.jad_dq);
        jad_an.append('\'');
        jad_an.append(", preloadAdCacheTimeStamp='");
        jad_an.append(this.jad_er);
        jad_an.append('\'');
        jad_an.append('}');
        return jad_an.toString();
    }
}
