package com.anythink.splashad.api;

/* loaded from: classes12.dex */
public interface ATSplashAdListener {
    void onAdClick(com.anythink.core.api.ATAdInfo aTAdInfo);

    void onAdDismiss(com.anythink.core.api.ATAdInfo aTAdInfo, com.anythink.splashad.api.ATSplashAdExtraInfo aTSplashAdExtraInfo);

    void onAdLoadTimeout();

    void onAdLoaded(boolean z);

    void onAdShow(com.anythink.core.api.ATAdInfo aTAdInfo);

    void onNoAdError(com.anythink.core.api.AdError adError);
}
