package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface UIADI extends com.qq.e.comm.pi.LADI {
    void close();

    void destroy();

    java.lang.String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    void loadAd();

    void loadFullScreenAD();

    void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(com.qq.e.ads.cfg.VideoOption videoOption);

    void show();

    void show(android.app.Activity activity);

    void showFullScreenAD(android.app.Activity activity);
}
