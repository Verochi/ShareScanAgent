package com.alimm.tanx.core.ad.ad.reward;

/* loaded from: classes.dex */
public interface ITanxRewardVideoInteractionListener extends com.alimm.tanx.core.ad.listener.ITanxInteractionListener<com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd> {
    void onAdClose();

    void onError(com.alimm.tanx.core.request.TanxError tanxError);

    void onRewardArrived(boolean z, int i, java.util.Map<java.lang.String, java.lang.Object> map);

    void onSkippedVideo();

    void onVideoComplete();

    void onVideoError(com.alimm.tanx.core.request.TanxPlayerError tanxPlayerError);
}
