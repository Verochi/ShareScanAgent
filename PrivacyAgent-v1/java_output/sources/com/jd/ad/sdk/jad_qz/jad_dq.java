package com.jd.ad.sdk.jad_qz;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes23.dex */
public class jad_dq {
    public final java.util.List<com.jd.ad.sdk.jad_sb.jad_pc> jad_an;
    public final char jad_bo;
    public final double jad_cp;
    public final java.lang.String jad_dq;
    public final java.lang.String jad_er;

    public jad_dq(java.util.List<com.jd.ad.sdk.jad_sb.jad_pc> list, char c, double d, double d2, java.lang.String str, java.lang.String str2) {
        this.jad_an = list;
        this.jad_bo = c;
        this.jad_cp = d2;
        this.jad_dq = str;
        this.jad_er = str2;
    }

    public static int jad_an(char c, java.lang.String str, java.lang.String str2) {
        return str2.hashCode() + ((str.hashCode() + ((c + 0) * 31)) * 31);
    }

    public int hashCode() {
        return jad_an(this.jad_bo, this.jad_er, this.jad_dq);
    }
}
