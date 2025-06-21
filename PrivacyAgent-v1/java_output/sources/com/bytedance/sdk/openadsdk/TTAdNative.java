package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTAdNative {

    public interface CSJSplashAdListener {
        void onSplashLoadFail(com.bytedance.sdk.openadsdk.CSJAdError cSJAdError);

        void onSplashLoadSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd);

        void onSplashRenderFail(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, com.bytedance.sdk.openadsdk.CSJAdError cSJAdError);

        void onSplashRenderSuccess(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd);
    }

    public interface DrawFeedAdListener {
        void onDrawFeedAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTDrawFeedAd> list);

        void onError(int i, java.lang.String str);
    }

    public interface FeedAdListener {
        void onError(int i, java.lang.String str);

        void onFeedAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTFeedAd> list);
    }

    public interface FullScreenVideoAdListener {
        void onError(int i, java.lang.String str);

        void onFullScreenVideoAdLoad(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd tTFullScreenVideoAd);

        @java.lang.Deprecated
        void onFullScreenVideoCached();

        void onFullScreenVideoCached(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd tTFullScreenVideoAd);
    }

    public interface NativeAdListener {
        void onError(int i, java.lang.String str);

        void onNativeAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeAd> list);
    }

    public interface NativeExpressAdListener {
        void onError(int i, java.lang.String str);

        void onNativeExpressAdLoad(java.util.List<com.bytedance.sdk.openadsdk.TTNativeExpressAd> list);
    }

    public interface RewardVideoAdListener {
        void onError(int i, java.lang.String str);

        void onRewardVideoAdLoad(com.bytedance.sdk.openadsdk.TTRewardVideoAd tTRewardVideoAd);

        @java.lang.Deprecated
        void onRewardVideoCached();

        void onRewardVideoCached(com.bytedance.sdk.openadsdk.TTRewardVideoAd tTRewardVideoAd);
    }

    public interface SplashAdListener {
        void onError(int i, java.lang.String str);

        void onSplashAdLoad(com.bytedance.sdk.openadsdk.TTSplashAd tTSplashAd);

        void onTimeout();
    }

    void loadBannerExpressAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener);

    void loadDrawFeedAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener drawFeedAdListener);

    void loadExpressDrawFeedAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener);

    void loadFeedAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener feedAdListener);

    void loadFullScreenVideoAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener);

    @java.lang.Deprecated
    void loadInteractionExpressAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener);

    void loadNativeAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener nativeAdListener);

    void loadNativeExpressAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener nativeExpressAdListener);

    void loadRewardVideoAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener rewardVideoAdListener);

    void loadSplashAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i);

    void loadSplashAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener splashAdListener);

    @java.lang.Deprecated
    void loadSplashAd(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.SplashAdListener splashAdListener, int i);

    void loadStream(com.bytedance.sdk.openadsdk.AdSlot adSlot, com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener feedAdListener);
}
