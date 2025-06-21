package com.qq.e.ads.interstitial2;

/* loaded from: classes19.dex */
public interface UnifiedInterstitialADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADOpened();

    void onADReceive();

    void onNoAD(com.qq.e.comm.util.AdError adError);

    void onRenderFail();

    void onRenderSuccess();

    void onVideoCached();
}
