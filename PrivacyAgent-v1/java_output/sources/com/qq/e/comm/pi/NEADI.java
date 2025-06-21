package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface NEADI {
    java.lang.String getAdNetWorkName();

    void loadAd(int i);

    void loadAd(int i, com.qq.e.comm.constants.LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMinVideoDuration(int i);

    void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(com.qq.e.ads.cfg.VideoOption videoOption);
}
