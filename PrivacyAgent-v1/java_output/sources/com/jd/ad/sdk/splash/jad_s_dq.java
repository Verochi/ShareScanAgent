package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class jad_s_dq implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_dq(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.view.View view = this.jad_s_an.jad_s_jt;
        if (view == null || view.getParent() == null) {
            return;
        }
        com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_s_an.jad_s_dq);
        com.jd.ad.sdk.splash.jad_s_an.jad_s_cp jad_s_cpVar = this.jad_s_an.jad_s_hu;
        if (jad_s_cpVar != null) {
            com.jd.ad.sdk.splash.JADSplash.jad_s_er jad_s_erVar = (com.jd.ad.sdk.splash.JADSplash.jad_s_er) jad_s_cpVar;
            com.jd.ad.sdk.splash.JADSplash.this.reportCloseEvent(com.jd.ad.sdk.dl.common.CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal());
            com.jd.ad.sdk.splash.JADSplash.this.callbackAdCloseOnUiThread();
            com.jd.ad.sdk.splash.JADSplash.this.destroy();
        }
    }
}
