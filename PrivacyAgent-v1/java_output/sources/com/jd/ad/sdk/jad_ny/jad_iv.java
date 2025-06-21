package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public final class jad_iv implements com.jd.ad.sdk.jad_ny.jad_an<int[]> {
    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_an(int[] iArr) {
        return iArr.length;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public java.lang.String jad_an() {
        return "IntegerArrayPool";
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int jad_bo() {
        return 4;
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_an
    public int[] newArray(int i) {
        return new int[i];
    }
}
