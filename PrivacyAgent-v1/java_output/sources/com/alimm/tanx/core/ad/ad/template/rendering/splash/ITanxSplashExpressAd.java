package com.alimm.tanx.core.ad.ad.template.rendering.splash;

/* loaded from: classes.dex */
public interface ITanxSplashExpressAd extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd {

    public interface OnSplashAdListener {
        void onAdClicked();

        void onAdClosed();

        void onAdFinish();

        void onAdRender(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd iTanxSplashExpressAd);

        void onAdShake();

        void onAdShow();

        void onShowError(com.alimm.tanx.core.request.TanxError tanxError);
    }

    int getFromType();

    com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener getOnSplashAdListener();

    void setOnSplashAdListener(com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd.OnSplashAdListener onSplashAdListener);
}
