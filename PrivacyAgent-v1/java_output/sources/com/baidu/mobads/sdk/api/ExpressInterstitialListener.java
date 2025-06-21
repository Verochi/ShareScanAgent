package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i, java.lang.String str);

    void onLpClosed();

    void onNoAd(int i, java.lang.String str);

    @java.lang.Deprecated
    void onVideoDownloadFailed();

    @java.lang.Deprecated
    void onVideoDownloadSuccess();
}
