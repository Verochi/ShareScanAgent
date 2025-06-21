package com.qq.e.ads.rewardvideo;

/* loaded from: classes19.dex */
public interface RewardVideoADListener {
    void onADClick();

    void onADClose();

    void onADExpose();

    void onADLoad();

    void onADShow();

    void onError(com.qq.e.comm.util.AdError adError);

    void onReward(java.util.Map<java.lang.String, java.lang.Object> map);

    void onVideoCached();

    void onVideoComplete();
}
