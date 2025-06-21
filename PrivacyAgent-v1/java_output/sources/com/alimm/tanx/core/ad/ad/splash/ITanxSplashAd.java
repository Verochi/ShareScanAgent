package com.alimm.tanx.core.ad.ad.splash;

/* loaded from: classes.dex */
public interface ITanxSplashAd extends com.alimm.tanx.core.ad.ITanxAd {
    void bindSplashAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, android.view.View view, android.view.View view2, com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener iTanxSplashInteractionListener);

    void click(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.lang.String str, java.lang.String str2);

    void clickUpload();
}
