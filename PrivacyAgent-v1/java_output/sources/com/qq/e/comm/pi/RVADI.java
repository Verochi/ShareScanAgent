package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface RVADI extends com.qq.e.comm.pi.LADI {
    java.lang.String getAdNetWorkName();

    @java.lang.Deprecated
    long getExpireTimestamp();

    int getRewardAdType();

    int getVideoDuration();

    boolean hasShown();

    void loadAD();

    void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams);

    void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD();

    void showAD(android.app.Activity activity);
}
