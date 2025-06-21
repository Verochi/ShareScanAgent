package com.anythink.splashad.api;

/* loaded from: classes12.dex */
public class ATSplashAdExtraInfo {
    private com.anythink.splashad.api.IATSplashEyeAd atSplashEyeAd;
    private int dismissType;

    public ATSplashAdExtraInfo(int i, com.anythink.splashad.api.IATSplashEyeAd iATSplashEyeAd) {
        this.dismissType = i;
        this.atSplashEyeAd = iATSplashEyeAd;
    }

    public com.anythink.splashad.api.IATSplashEyeAd getAtSplashEyeAd() {
        return this.atSplashEyeAd;
    }

    public int getDismissType() {
        return this.dismissType;
    }
}
