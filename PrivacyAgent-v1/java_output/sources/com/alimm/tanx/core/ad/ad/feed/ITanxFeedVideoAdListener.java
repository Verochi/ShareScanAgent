package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public interface ITanxFeedVideoAdListener<T extends com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd> {
    android.view.View onCustomLoadingIcon();

    android.view.View onCustomPlayIcon();

    void onError(com.alimm.tanx.core.request.TanxError tanxError);

    void onProgressUpdate(long j, long j2);

    void onVideoAdPaused(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd);

    void onVideoAdStartPlay(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd);

    void onVideoComplete();

    void onVideoError(com.alimm.tanx.core.request.TanxPlayerError tanxPlayerError);

    void onVideoLoad(com.alimm.tanx.core.ad.ad.feed.ITanxFeedAd iTanxFeedAd);
}
