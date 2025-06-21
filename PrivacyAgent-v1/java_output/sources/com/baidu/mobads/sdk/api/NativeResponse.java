package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface NativeResponse extends com.baidu.mobads.sdk.api.AbstractData {
    public static final int ACTION_TYPE_APP_DOWNLOAD = 2;
    public static final int ACTION_TYPE_DEEP_LINK = 3;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_PORTRAIT_IMAGE = 42;
    public static final int INFO_FLOW_PORTRAIT_VIDEO = 41;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;

    public interface AdCloseListener {
        void onAdClose(com.baidu.mobads.sdk.api.NativeResponse nativeResponse);
    }

    public interface AdDislikeListener {
        void onDislikeItemClick(java.lang.String str);

        void onDislikeWindowClose();

        void onDislikeWindowShow();
    }

    public interface AdDownloadWindowListener extends com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();
    }

    public interface AdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i);

        void onADStatusChanged();

        void onAdClick();

        void onAdUnionClick();
    }

    public interface AdPrivacyListener {
        void onADFunctionClick();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    public interface AdShakeViewListener {
        void onDismiss();
    }

    public interface CustomizeMediaPlayer {
        java.lang.String getVideoUrl();

        void reportPlayError(int i);

        void reportPlayFrozen(int i);

        void reportPlayerReady();

        void reportVideoMuteChange(int i, boolean z);

        void reportVideoPause(int i, com.baidu.mobads.sdk.api.NativeResponse.VideoReason videoReason);

        void reportVideoReplay();

        void reportVideoResume(int i);

        void reportVideoShow();

        void reportVideoStart(boolean z);

        void reportVideoStop(int i, com.baidu.mobads.sdk.api.NativeResponse.VideoReason videoReason);
    }

    public enum MaterialType {
        NORMAL("normal"),
        VIDEO("video"),
        HTML(com.baidu.mobads.sdk.internal.a.f);

        private final java.lang.String value;

        MaterialType(java.lang.String str) {
            this.value = str;
        }

        public static com.baidu.mobads.sdk.api.NativeResponse.MaterialType parse(java.lang.String str) {
            for (com.baidu.mobads.sdk.api.NativeResponse.MaterialType materialType : values()) {
                if (materialType.value.equalsIgnoreCase(str)) {
                    return materialType;
                }
            }
            return null;
        }

        public java.lang.String getValue() {
            return this.value;
        }
    }

    public enum VideoReason {
        JUMP_LANDING_PAGE(1),
        BACKGROUND(2),
        USER_CLICK(3),
        JUMP_OTHER_APP(4),
        PLAY_COMPLETE(5),
        AD_CLOSE(6),
        OTHER_REASON(7);

        int code;

        VideoReason(int i) {
            this.code = i;
        }

        public int getCode() {
            return this.code;
        }
    }

    void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener);

    void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener);

    void cancelAppDownload();

    void clearImpressionTaskWhenBack();

    void dislikeClick(com.baidu.mobads.sdk.api.DislikeEvent dislikeEvent);

    void functionClick();

    java.lang.String getActButtonString();

    int getAdActionType();

    java.lang.Object getAdDataForKey(java.lang.String str);

    java.lang.String getAdLogoUrl();

    java.lang.String getAdMaterialType();

    java.lang.String getAppFunctionLink();

    java.lang.String getAppPackage();

    java.lang.String getAppPermissionLink();

    java.lang.String getAppPrivacyLink();

    long getAppSize();

    java.lang.String getAppVersion();

    java.lang.String getBaiduLogoUrl();

    java.lang.String getBrandName();

    int getContainerHeight();

    int getContainerSizeType();

    int getContainerWidth();

    com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer getCustomizeMediaPlayer();

    java.lang.String getDesc();

    java.util.List<com.baidu.mobads.sdk.api.DislikeEvent> getDislikeList();

    int getDownloadStatus();

    int getDuration();

    java.lang.String getECPMLevel();

    java.util.Map<java.lang.String, java.lang.String> getExtras();

    java.lang.String getHtmlSnippet();

    java.lang.String getIconUrl();

    java.lang.String getImageUrl();

    int getMainPicHeight();

    int getMainPicWidth();

    java.lang.String getMarketingPendant();

    com.baidu.mobads.sdk.api.NativeResponse.MaterialType getMaterialType();

    java.util.List<java.lang.String> getMultiPicUrls();

    java.lang.String getPECPM();

    java.lang.String getPublisher();

    int getStyleType();

    java.lang.String getTitle();

    java.lang.String getVideoUrl();

    android.webkit.WebView getWebView();

    boolean isAdAvailable(android.content.Context context);

    boolean isAutoPlay();

    @java.lang.Deprecated
    boolean isNeedDownloadApp();

    boolean isNonWifiAutoPlay();

    void pauseAppDownload();

    void permissionClick();

    void privacyClick();

    void recordImpression(android.view.View view);

    void registerViewForInteraction(android.view.View view, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener adInteractionListener);

    android.view.View renderBulletView(int i, int i2);

    android.view.View renderCouponFloatView(com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener);

    android.view.View renderFlipPageView();

    android.view.View renderShakeView(int i, int i2, com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener);

    android.view.View renderSlideView(int i, int i2, int i3, com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener adShakeViewListener);

    void resumeAppDownload();

    void setAdPrivacyListener(com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener adPrivacyListener);

    void stopNativeView(android.view.View view);

    void unionLogoClick();
}
