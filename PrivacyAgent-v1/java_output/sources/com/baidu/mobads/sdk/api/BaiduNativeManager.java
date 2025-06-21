package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final java.lang.String TAG = "BaiduNativeManager";
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final java.lang.String mAdPlacementId;
    private java.lang.String mAppSid;
    private int mBidFloor;
    private final android.content.Context mContext;
    private com.baidu.mobads.sdk.api.RequestParameters mRequestParameters;
    private int mTimeoutMillis;

    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i, java.lang.String str);

        void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.EntryResponse> list);

        void onNoAd(int i, java.lang.String str);
    }

    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i, java.lang.String str, com.baidu.mobads.sdk.api.ExpressResponse expressResponse);

        void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.ExpressResponse> list);

        void onNoAd(int i, java.lang.String str, com.baidu.mobads.sdk.api.ExpressResponse expressResponse);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse);

        void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list);

        void onNoAd(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    @java.lang.Deprecated
    public interface PortraitVideoAdListener extends com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(android.content.Context context, java.lang.String str) {
        this(context, str, 8000);
    }

    public BaiduNativeManager(android.content.Context context, java.lang.String str, int i) {
        this(context, str, true, i);
    }

    public BaiduNativeManager(android.content.Context context, java.lang.String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(android.content.Context context, java.lang.String str, boolean z, int i) {
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i;
    }

    private java.lang.String getAdPlacemenId(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        if (requestParameters != null) {
            java.lang.String adPlacementId = requestParameters.getAdPlacementId();
            if (!android.text.TextUtils.isEmpty(adPlacementId)) {
                return adPlacementId;
            }
        }
        return this.mAdPlacementId;
    }

    private int getBidFloor(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        int bidFloor;
        return (requestParameters == null || (bidFloor = requestParameters.getBidFloor()) <= 0) ? this.mBidFloor : bidFloor;
    }

    private void loadBiddingAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, java.lang.String str, java.lang.String str2, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener, com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener) {
        com.baidu.mobads.sdk.internal.de deVar = new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.r = getBidFloor(requestParameters);
        deVar.c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            deVar.a(new com.baidu.mobads.sdk.internal.ad(feedAdListener));
        } else if (expressAdListener != null) {
            deVar.a(expressAdListener);
            deVar.a(1);
        }
        deVar.a(new com.baidu.mobads.sdk.internal.ak());
        if (requestParameters == null) {
            requestParameters = new com.baidu.mobads.sdk.api.RequestParameters.Builder().build();
        }
        deVar.a(requestParameters);
        deVar.l();
        deVar.c(str2);
    }

    public java.lang.String getExpressFeedBiddingToken(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        com.baidu.mobads.sdk.internal.de deVar = new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        deVar.a(1);
        com.baidu.mobads.sdk.api.RequestParameters build = requestParameters == null ? new com.baidu.mobads.sdk.api.RequestParameters.Builder().build() : requestParameters;
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.r = getBidFloor(requestParameters);
        deVar.a(build);
        this.mRequestParameters = build;
        return deVar.l();
    }

    public java.lang.String getFeedBiddingToken(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        com.baidu.mobads.sdk.internal.de deVar = new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        com.baidu.mobads.sdk.api.RequestParameters build = requestParameters == null ? new com.baidu.mobads.sdk.api.RequestParameters.Builder().build() : requestParameters;
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.r = getBidFloor(requestParameters);
        deVar.a(build);
        this.mRequestParameters = build;
        return deVar.l();
    }

    public java.lang.String getPortraitVideoBiddingToken(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        com.baidu.mobads.sdk.internal.de deVar = new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        com.baidu.mobads.sdk.api.RequestParameters build = requestParameters == null ? new com.baidu.mobads.sdk.api.RequestParameters.Builder().build() : requestParameters;
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            deVar.h(this.mAppSid);
        }
        deVar.r = getBidFloor(requestParameters);
        deVar.a(build);
        this.mRequestParameters = build;
        return deVar.l();
    }

    public void loadBidAdForExpress(java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
    }

    public void loadBidAdForFeed(java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    @java.lang.Deprecated
    public void loadBidAdForPortraitVideo(java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadContentAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, new com.baidu.mobads.sdk.internal.ad(feedAdListener), new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.b(requestParameters);
    }

    public void loadExpressAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.b(requestParameters);
    }

    public void loadFeedAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, getAdPlacemenId(requestParameters), new com.baidu.mobads.sdk.internal.ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.b(requestParameters);
    }

    public void loadFeedEntryAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.EntryAdListener entryAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.b(requestParameters);
    }

    public void loadInsiteAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, new com.baidu.mobads.sdk.internal.ad(feedAdListener), new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, new com.baidu.mobads.sdk.internal.ad(feedAdListener), new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(com.baidu.mobads.sdk.api.RequestParameters requestParameters, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, getAdPlacemenId(requestParameters), new com.baidu.mobads.sdk.internal.ad(feedAdListener), this.isCacheVideo, 8000, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.b(requestParameters);
    }

    public void setAppSid(java.lang.String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.isCacheVideoOnlyWifi = z;
    }

    @java.lang.Deprecated
    public void setExpressFeedBiddingData(com.baidu.mobads.sdk.api.RequestParameters requestParameters, java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener expressAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.a(requestParameters);
        gVar.a(str);
    }

    @java.lang.Deprecated
    public void setFeedBiddingData(com.baidu.mobads.sdk.api.RequestParameters requestParameters, java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener feedAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, getAdPlacemenId(requestParameters), new com.baidu.mobads.sdk.internal.ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.a(requestParameters);
        gVar.a(str);
    }

    @java.lang.Deprecated
    public void setPortraitVideoBiddingData(com.baidu.mobads.sdk.api.RequestParameters requestParameters, java.lang.String str, com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener portraitVideoAdListener) {
        com.baidu.mobads.sdk.internal.g gVar = new com.baidu.mobads.sdk.internal.g(this.mContext, new com.baidu.mobads.sdk.internal.ad(portraitVideoAdListener), new com.baidu.mobads.sdk.internal.de(this.mContext, getAdPlacemenId(requestParameters), com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!android.text.TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.isCacheVideoOnlyWifi);
        gVar.a(new com.baidu.mobads.sdk.internal.ak());
        gVar.a(requestParameters);
        gVar.a(str);
    }
}
