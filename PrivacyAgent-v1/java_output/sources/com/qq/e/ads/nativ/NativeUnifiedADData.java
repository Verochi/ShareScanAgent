package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public interface NativeUnifiedADData extends com.qq.e.comm.pi.LADI, com.qq.e.comm.pi.NFBI {
    void bindAdToCustomVideo(android.view.ViewGroup viewGroup, android.content.Context context, java.util.List<android.view.View> list, java.util.List<android.view.View> list2);

    void bindAdToView(android.content.Context context, com.qq.e.ads.nativ.widget.NativeAdContainer nativeAdContainer, android.widget.FrameLayout.LayoutParams layoutParams, java.util.List<android.view.View> list);

    void bindAdToView(android.content.Context context, com.qq.e.ads.nativ.widget.NativeAdContainer nativeAdContainer, android.widget.FrameLayout.LayoutParams layoutParams, java.util.List<android.view.View> list, java.util.List<android.view.View> list2);

    void bindCTAViews(java.util.List<android.view.View> list);

    void bindImageViews(java.util.List<android.widget.ImageView> list, int i);

    void bindImageViews(java.util.List<android.widget.ImageView> list, byte[] bArr);

    void bindMediaView(com.qq.e.ads.nativ.MediaView mediaView, com.qq.e.ads.cfg.VideoOption videoOption, com.qq.e.ads.nativ.NativeADMediaListener nativeADMediaListener);

    void destroy();

    boolean equalsAdData(com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData);

    int getAdPatternType();

    com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo getAppMiitInfo();

    double getAppPrice();

    int getAppScore();

    int getAppStatus();

    java.lang.String getButtonText();

    java.lang.String getCTAText();

    com.qq.e.ads.nativ.CustomizeVideo getCustomizeVideo();

    java.lang.String getDesc();

    long getDownloadCount();

    java.lang.String getIconUrl();

    java.util.List<java.lang.String> getImgList();

    java.lang.String getImgUrl();

    int getPictureHeight();

    int getPictureWidth();

    int getProgress();

    java.lang.String getTitle();

    int getVideoCurrentPosition();

    int getVideoDuration();

    boolean isAppAd();

    boolean isWeChatCanvasAd();

    @java.lang.Deprecated
    void negativeFeedback();

    void pauseAppDownload();

    void pauseVideo();

    @java.lang.Deprecated
    void resume();

    void resumeAppDownload();

    void resumeVideo();

    void setNativeAdEventListener(com.qq.e.ads.nativ.NativeADEventListener nativeADEventListener);

    void setVideoMute(boolean z);

    void startVideo();

    void stopVideo();
}
