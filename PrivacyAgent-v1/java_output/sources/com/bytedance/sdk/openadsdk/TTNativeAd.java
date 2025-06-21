package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTNativeAd extends com.bytedance.sdk.openadsdk.TTClientBidding {

    public interface AdInteractionListener {
        void onAdClicked(android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd);

        void onAdCreativeClick(android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd);

        void onAdShow(com.bytedance.sdk.openadsdk.TTNativeAd tTNativeAd);
    }

    public interface ExpressRenderListener {
        void onRenderSuccess(android.view.View view, float f, float f2, boolean z);
    }

    void destroy();

    android.graphics.Bitmap getAdLogo();

    android.view.View getAdView();

    int getAppCommentNum();

    int getAppScore();

    int getAppSize();

    java.lang.String getButtonText();

    com.bytedance.sdk.openadsdk.ComplianceInfo getComplianceInfo();

    java.lang.String getDescription();

    com.bytedance.sdk.openadsdk.TTAdDislike getDislikeDialog(android.app.Activity activity);

    com.bytedance.sdk.openadsdk.TTAdDislike getDislikeDialog(com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract tTDislikeDialogAbstract);

    com.bytedance.sdk.openadsdk.DislikeInfo getDislikeInfo();

    com.bytedance.sdk.openadsdk.DownloadStatusController getDownloadStatusController();

    com.bytedance.sdk.openadsdk.TTImage getIcon();

    java.util.List<com.bytedance.sdk.openadsdk.TTImage> getImageList();

    int getImageMode();

    int getInteractionType();

    java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo();

    java.lang.String getSource();

    java.lang.String getTitle();

    com.bytedance.sdk.openadsdk.TTImage getVideoCoverImage();

    void registerViewForInteraction(android.view.ViewGroup viewGroup, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener);

    void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener);

    void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener);

    void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener);

    void registerViewForInteraction(android.view.ViewGroup viewGroup, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, java.util.List<android.view.View> list3, java.util.List<android.view.View> list4, android.view.View view, com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener adInteractionListener);

    void render();

    void setActivityForDownloadApp(android.app.Activity activity);

    void setDislikeCallback(android.app.Activity activity, com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener);

    void setExpressRenderListener(com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener expressRenderListener);

    void showInteractionExpressAd(android.app.Activity activity);

    void uploadDislikeEvent(java.lang.String str);
}
