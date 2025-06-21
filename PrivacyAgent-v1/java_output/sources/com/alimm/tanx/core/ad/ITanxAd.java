package com.alimm.tanx.core.ad;

/* loaded from: classes.dex */
public interface ITanxAd extends com.alimm.tanx.core.ad.ITanxAdBidding {
    public static final int FEED_ITEM_VIEW_TYPE_NORMAL = 10;
    public static final int FEED_ITEM_VIEW_TYPE_VERTICAL_PIC_AD = 12;
    public static final int FEED_ITEM_VIEW_TYPE_VIDEO = 11;
    public static final int FEED_ITEM_VIEW_TYPE_VIDEO_9_16 = 13;
    public static final int REWARD_ITEM_VIEW_TYPE_AROUSAL = 32;
    public static final int REWARD_ITEM_VIEW_TYPE_BROWSE = 31;
    public static final int REWARD_ITEM_VIEW_TYPE_VIDEO = 30;
    public static final int SPLASH_ITEM_VIEW_TYPE = 1;
    public static final int TABLE_ITEM_VIEW_TYPE = 20;
    public static final int TANX_AD_TYPE_ERROR = -1;

    void bindAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list);

    void bindAdView(com.alimm.tanx.core.ad.view.TanxAdView tanxAdView, java.util.List<android.view.View> list, com.alimm.tanx.core.ad.listener.ITanxInteractionListener iTanxInteractionListener);

    void destroy();

    com.alimm.tanx.core.request.TanxAdSlot getAdSlot();

    int getAdType();

    com.alimm.tanx.core.ad.bean.BidInfo getBidInfo();

    java.lang.String getRequestId();

    java.lang.String getScene();

    void onResourceLoadSuccess();
}
