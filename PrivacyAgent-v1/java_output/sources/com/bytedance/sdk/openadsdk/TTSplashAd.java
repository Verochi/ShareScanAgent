package com.bytedance.sdk.openadsdk;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public interface TTSplashAd extends com.bytedance.sdk.openadsdk.TTClientBidding {

    public interface AdInteractionListener {
        void onAdClicked(android.view.View view, int i);

        void onAdShow(android.view.View view, int i);

        void onAdSkip();

        void onAdTimeOver();
    }

    int getInteractionType();

    java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo();

    int[] getSplashClickEyeSizeToDp();

    android.view.View getSplashView();

    void renderExpressAd(com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener);

    void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener);

    void setNotAllowSdkCountdown();

    void setSplashCardListener(com.bytedance.sdk.openadsdk.ISplashCardListener iSplashCardListener);

    void setSplashClickEyeListener(com.bytedance.sdk.openadsdk.ISplashClickEyeListener iSplashClickEyeListener);

    void setSplashInteractionListener(com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener adInteractionListener);

    void splashClickEyeAnimationFinish();

    void startClickEye();

    void startClickEye(boolean z);
}
