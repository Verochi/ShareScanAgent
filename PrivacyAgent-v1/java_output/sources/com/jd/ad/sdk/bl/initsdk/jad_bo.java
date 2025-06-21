package com.jd.ad.sdk.bl.initsdk;

/* loaded from: classes23.dex */
public class jad_bo implements java.lang.Runnable {
    public final /* synthetic */ int jad_an;
    public final /* synthetic */ java.lang.String jad_bo;

    public jad_bo(com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_cp jad_cpVar, int i, java.lang.String str) {
        this.jad_an = i;
        this.jad_bo = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.bl.initsdk.JADInitCallback jADInitCallback;
        com.jd.ad.sdk.bl.initsdk.JADInitCallback jADInitCallback2;
        jADInitCallback = com.jd.ad.sdk.bl.initsdk.JADYunSdk.mInitCallback;
        if (jADInitCallback != null) {
            jADInitCallback2 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.mInitCallback;
            jADInitCallback2.onInitFailure(this.jad_an, this.jad_bo);
        }
    }
}
