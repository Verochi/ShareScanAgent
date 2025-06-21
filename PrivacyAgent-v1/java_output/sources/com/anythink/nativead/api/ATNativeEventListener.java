package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public interface ATNativeEventListener {
    void onAdClicked(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, com.anythink.core.api.ATAdInfo aTAdInfo);

    void onAdImpressed(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, com.anythink.core.api.ATAdInfo aTAdInfo);

    void onAdVideoEnd(com.anythink.nativead.api.ATNativeAdView aTNativeAdView);

    void onAdVideoProgress(com.anythink.nativead.api.ATNativeAdView aTNativeAdView, int i);

    void onAdVideoStart(com.anythink.nativead.api.ATNativeAdView aTNativeAdView);
}
