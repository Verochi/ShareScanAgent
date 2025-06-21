package com.jd.ad.sdk.bl.initsdk;

/* loaded from: classes23.dex */
public class jad_an implements java.lang.Runnable {
    public jad_an(com.jd.ad.sdk.bl.initsdk.JADYunSdk.jad_cp jad_cpVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.bl.initsdk.JADInitCallback jADInitCallback;
        com.jd.ad.sdk.bl.initsdk.JADInitCallback jADInitCallback2;
        jADInitCallback = com.jd.ad.sdk.bl.initsdk.JADYunSdk.mInitCallback;
        if (jADInitCallback != null) {
            jADInitCallback2 = com.jd.ad.sdk.bl.initsdk.JADYunSdk.mInitCallback;
            jADInitCallback2.onInitSuccess();
        }
    }
}
