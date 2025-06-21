package com.alimm.tanx.core.ad.listener;

/* loaded from: classes.dex */
public interface ITanxAdLoader extends com.alimm.tanx.core.ad.loader.ITanxRequestLoader {

    public interface BaseAdLoadListener {
        void onError(com.alimm.tanx.core.request.TanxError tanxError);

        void onTimeOut();
    }

    public interface OnAdLoadListener<T extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd> extends com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener {
        void onLoaded(java.util.List<T> list);
    }

    public interface OnRewardAdLoadListener<T extends com.alimm.tanx.core.ad.listener.INewTanxExpressAd> extends com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener {
        void onLoaded(java.util.List<T> list);

        void onRewardVideoCached(T t);
    }

    public interface OnSplashAdLoadListener extends com.alimm.tanx.core.ad.listener.ITanxAdLoader.BaseAdLoadListener {
        void onLoaded(com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd iTanxFeedExpressAd);
    }

    void destroy();

    void loadFeedAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.feed.ITanxFeedExpressAd> onAdLoadListener);

    void loadRewardAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener);

    void loadRewardAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener, long j);

    void loadRewardVideoAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener);

    @java.lang.Deprecated
    void loadRewardVideoAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnRewardAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.reward.ITanxRewardExpressAd> onRewardAdLoadListener, long j);

    void loadSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> onAdLoadListener);

    void loadSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd> onAdLoadListener, long j);

    void loadTableScreenAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> onAdLoadListener);

    void loadTableScreenAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.ad.listener.ITanxAdLoader.OnAdLoadListener<com.alimm.tanx.core.ad.ad.template.rendering.table.screen.ITanxTableScreenExpressAd> onAdLoadListener, long j);

    @java.lang.Deprecated
    void preloadSplashAd(com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot);
}
