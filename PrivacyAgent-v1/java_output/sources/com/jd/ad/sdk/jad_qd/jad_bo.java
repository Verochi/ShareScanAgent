package com.jd.ad.sdk.jad_qd;

/* loaded from: classes23.dex */
public class jad_bo implements java.lang.Runnable {
    public final /* synthetic */ boolean[] jad_an;

    public jad_bo(boolean[] zArr) {
        this.jad_an = zArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.jad_an[0] = com.jd.ad.sdk.jad_qd.jad_cp.jad_er();
    }
}
