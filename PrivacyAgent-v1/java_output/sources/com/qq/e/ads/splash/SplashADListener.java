package com.qq.e.ads.splash;

/* loaded from: classes19.dex */
public interface SplashADListener {
    void onADClicked();

    void onADDismissed();

    void onADExposure();

    void onADLoaded(long j);

    void onADPresent();

    void onADTick(long j);

    void onNoAD(com.qq.e.comm.util.AdError adError);
}
