package com.qq.e.ads.banner2;

/* loaded from: classes19.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADReceive();

    void onNoAD(com.qq.e.comm.util.AdError adError);
}
