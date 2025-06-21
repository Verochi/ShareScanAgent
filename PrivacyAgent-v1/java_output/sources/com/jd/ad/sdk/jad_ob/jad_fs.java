package com.jd.ad.sdk.jad_ob;

/* loaded from: classes23.dex */
public class jad_fs implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String jad_an;

    public jad_fs(java.lang.String str) {
        this.jad_an = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.jd.ad.sdk.jad_vi.jad_an.jad_bo) {
            return;
        }
        com.jd.ad.sdk.jad_ob.jad_er.jad_an(this.jad_an);
    }
}
