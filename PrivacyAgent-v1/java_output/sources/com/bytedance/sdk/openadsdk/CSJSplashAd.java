package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface CSJSplashAd extends com.bytedance.sdk.openadsdk.TTClientBidding {

    public interface SplashAdListener {
        void onSplashAdClick(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd);

        void onSplashAdClose(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd, int i);

        void onSplashAdShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd);
    }

    public interface SplashCardListener {
        void onSplashCardClick();

        void onSplashCardClose();

        void onSplashCardReadyToShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd);
    }

    public interface SplashClickEyeListener {
        void onSplashClickEyeClick();

        void onSplashClickEyeClose();

        void onSplashClickEyeReadyToShow(com.bytedance.sdk.openadsdk.CSJSplashAd cSJSplashAd);
    }

    int getInteractionType();

    java.util.Map<java.lang.String, java.lang.Object> getMediaExtraInfo();

    android.view.View getSplashCardView();

    int[] getSplashClickEyeSizeToDp();

    android.view.View getSplashClickEyeView();

    android.view.View getSplashView();

    void hideSkipButton();

    void setDownloadListener(com.bytedance.sdk.openadsdk.TTAppDownloadListener tTAppDownloadListener);

    void setSplashAdListener(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener splashAdListener);

    void setSplashCardListener(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashCardListener splashCardListener);

    void setSplashClickEyeListener(com.bytedance.sdk.openadsdk.CSJSplashAd.SplashClickEyeListener splashClickEyeListener);

    void showSplashCardView(android.view.ViewGroup viewGroup, android.app.Activity activity);

    void showSplashClickEyeView(android.view.ViewGroup viewGroup);

    void showSplashView(android.view.ViewGroup viewGroup);

    void startClickEye();
}
