package com.jd.ad.sdk.jad_kx;

/* loaded from: classes23.dex */
public class jad_bo implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.jad_kx.jad_an jad_an;

    public jad_bo(com.jd.ad.sdk.jad_kx.jad_an jad_anVar) {
        this.jad_an = jad_anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_kx.jad_an jad_anVar = this.jad_an;
        java.util.List<java.lang.String> list = com.jd.ad.sdk.jad_kx.jad_an.jad_dq;
        synchronized (jad_anVar) {
            jad_anVar.jad_an(list);
        }
        com.jd.ad.sdk.jad_kx.jad_an jad_anVar2 = this.jad_an;
        jad_anVar2.jad_an(jad_anVar2.jad_bo);
    }
}
