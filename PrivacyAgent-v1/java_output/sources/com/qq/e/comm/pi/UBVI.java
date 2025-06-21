package com.qq.e.comm.pi;

/* loaded from: classes19.dex */
public interface UBVI extends com.qq.e.comm.pi.LADI {
    void destroy();

    void fetchAd();

    java.lang.String getAdNetWorkName();

    void onWindowFocusChanged(boolean z);

    void setLoadAdParams(com.qq.e.comm.constants.LoadAdParams loadAdParams);

    void setRefresh(int i);

    void setServerSideVerificationOptions(com.qq.e.ads.rewardvideo.ServerSideVerificationOptions serverSideVerificationOptions);
}
