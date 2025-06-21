package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTNativeExpressAd extends com.bytedance.sdk.openadsdk.TTClientBidding {

    public interface AdInteractionListener extends com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener {
        void onAdDismiss();
    }

    public interface ExpressAdInteractionListener {
        void onAdClicked(android.view.View view, int i);

        void onAdShow(android.view.View view, int i);

        void onRenderFail(android.view.View view, java.lang.String str, int i);

        void onRenderSuccess(android.view.View view, float f, float f2);
    }

    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j, long j2);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i, int i2);

        void onVideoLoad();
    }

    void destroy();

    com.bytedance.sdk.openadsdk.TTAdDislike getDislikeDialog(android.app.Activity activity);

    com.bytedance.sdk.openadsdk.DislikeInfo getDislikeInfo();

    android.view.View getExpressAdView();

    int getImageMode();

    int getInteractionType();

    java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo();

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDislikeCallback(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i);

    void setVideoAdListener(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener);

    void showInteractionExpressAd(android.app.Activity activity);

    void uploadDislikeEvent(java.lang.String str);
}
