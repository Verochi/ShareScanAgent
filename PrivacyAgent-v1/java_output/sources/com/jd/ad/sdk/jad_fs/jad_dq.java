package com.jd.ad.sdk.jad_fs;

/* loaded from: classes23.dex */
public class jad_dq implements java.lang.Cloneable {
    public final long jad_an;
    public final int jad_bo;
    public final int jad_cp;

    public jad_dq(int i, int i2, long j) {
        this.jad_bo = i;
        this.jad_cp = i2;
        this.jad_an = j;
    }

    @androidx.annotation.NonNull
    public java.lang.Object clone() {
        return new com.jd.ad.sdk.jad_fs.jad_dq(this.jad_bo, this.jad_cp, this.jad_an);
    }
}
