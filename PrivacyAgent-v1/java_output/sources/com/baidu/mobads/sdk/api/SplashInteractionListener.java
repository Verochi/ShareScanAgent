package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface SplashInteractionListener extends com.baidu.mobads.sdk.api.SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdExposed();

    void onAdPresent();

    void onAdSkip();

    void onLpClosed();
}
