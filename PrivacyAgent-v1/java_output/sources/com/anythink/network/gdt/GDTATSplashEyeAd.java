package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATSplashEyeAd extends com.anythink.splashad.unitgroup.api.CustomSplashEyeAd {
    com.qq.e.ads.splash.SplashAD a;

    public GDTATSplashEyeAd(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.qq.e.ads.splash.SplashAD splashAD) {
        super(aTBaseAdAdapter);
        this.mAtBaseAdAdapter = aTBaseAdAdapter;
        this.a = splashAD;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void customResourceDestory() {
        this.a = null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public int[] getSuggestedSize(android.content.Context context) {
        return null;
    }

    @Override // com.anythink.splashad.api.IATSplashEyeAd
    public void onFinished() {
        com.qq.e.ads.splash.SplashAD splashAD = this.a;
        if (splashAD != null) {
            splashAD.zoomOutAnimationFinish();
        }
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashEyeAd
    public void show(android.content.Context context, android.graphics.Rect rect) {
        try {
            com.anythink.splashad.api.ATSplashEyeAdListener aTSplashEyeAdListener = this.mATSplashEyeAdListener;
            if (aTSplashEyeAdListener != null) {
                aTSplashEyeAdListener.onAnimationStart(this.mSplashView);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
