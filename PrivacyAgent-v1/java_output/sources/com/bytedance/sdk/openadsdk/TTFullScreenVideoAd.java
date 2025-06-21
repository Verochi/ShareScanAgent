package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTFullScreenVideoAd extends com.bytedance.sdk.openadsdk.TTClientBidding {

    public interface FullScreenVideoAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onSkippedVideo();

        void onVideoComplete();
    }

    long getExpirationTimestamp();

    int getFullVideoAdType();

    int getInteractionType();

    java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo();

    void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener);

    void setFullScreenVideoAdInteractionListener(com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    void showFullScreenVideoAd(android.app.Activity activity);

    void showFullScreenVideoAd(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdConstant.RitScenes ritScenes, java.lang.String str);
}
