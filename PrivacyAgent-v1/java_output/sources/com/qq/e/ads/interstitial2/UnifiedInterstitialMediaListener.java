package com.qq.e.ads.interstitial2;

/* loaded from: classes19.dex */
public interface UnifiedInterstitialMediaListener {
    void onVideoComplete();

    void onVideoError(com.qq.e.comm.util.AdError adError);

    void onVideoInit();

    void onVideoLoading();

    void onVideoPageClose();

    void onVideoPageOpen();

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
