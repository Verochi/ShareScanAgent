package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public class jad_s_er implements android.view.View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.JADSplashSkipView jad_s_an;

    public jad_s_er(com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.splash.JADSplashSkipView.jad_s_bo jad_s_boVar = this.jad_s_an.jad_s_bo;
        if (jad_s_boVar != null) {
            com.jd.ad.sdk.splash.jad_s_cp jad_s_cpVar = (com.jd.ad.sdk.splash.jad_s_cp) jad_s_boVar;
            com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_cpVar.jad_s_an, view);
            com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView = jad_s_cpVar.jad_s_an.jad_s_kx;
            if (jADSplashSkipView != null) {
                jADSplashSkipView.removeCallbacks(null);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
