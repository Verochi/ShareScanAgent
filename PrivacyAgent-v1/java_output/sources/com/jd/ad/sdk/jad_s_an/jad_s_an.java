package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_an implements android.view.View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView = this.jad_s_an.jad_s_kx;
        if (jADSplashSkipView != null) {
            jADSplashSkipView.removeCallbacks(null);
        }
        android.view.View view2 = this.jad_s_an.jad_s_iv;
        if (view2 == null || view2.getContext() == null) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_iv.getContext(), this.jad_s_an.jad_s_iv, 1, 0, com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal());
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
