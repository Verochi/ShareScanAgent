package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_bo implements java.lang.Runnable {
    public final /* synthetic */ com.jd.ad.sdk.splash.JADSplashSkipView jad_s_an;

    public jad_s_bo(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar, com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.splash.JADSplashSkipView jADSplashSkipView = this.jad_s_an;
        if (jADSplashSkipView != null) {
            int i = jADSplashSkipView.jad_s_an;
            if (i < 1 || i > 30) {
                jADSplashSkipView.jad_s_an = 5;
            }
            jADSplashSkipView.post(jADSplashSkipView.jad_s_er);
        }
    }
}
