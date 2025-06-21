package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class jad_s_bo implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_bo(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.jad_s_an.jad_s_vi) {
            return;
        }
        int onUserCancelJdJump = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getTouchService().onUserCancelJdJump(this.jad_s_an.jad_s_an(), this.jad_s_an.jad_s_dq);
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.this.reportClickEvent(onUserCancelJdJump, jad_s_anVar.jad_s_tg, jad_s_anVar.jad_s_re, jad_s_anVar.jad_s_sf);
        }
    }
}
