package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface ExpressResponse {
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VERTICAL_VIDEO = 41;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;
    public static final int THEME_DARK = 1;
    public static final int THEME_DEFAULT = 0;

    public interface ExpressAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADFunctionClick();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    public interface ExpressCloseListener {
        void onAdClose(com.baidu.mobads.sdk.api.ExpressResponse expressResponse);
    }

    public interface ExpressDislikeListener {
        void onDislikeItemClick(java.lang.String str);

        void onDislikeWindowClose();

        void onDislikeWindowShow();
    }

    public interface ExpressInteractionListener {
        void onAdClick();

        void onAdExposed();

        void onAdRenderFail(android.view.View view, java.lang.String str, int i);

        void onAdRenderSuccess(android.view.View view, float f, float f2);

        void onAdUnionClick();
    }

    void biddingFail(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener);

    void biddingSuccess(java.util.LinkedHashMap<java.lang.String, java.lang.Object> linkedHashMap, com.baidu.mobads.sdk.api.BiddingListener biddingListener);

    void bindInteractionActivity(android.app.Activity activity);

    int getAdActionType();

    com.baidu.mobads.sdk.api.ExpressAdData getAdData();

    java.lang.Object getAdDataForKey(java.lang.String str);

    java.lang.String getECPMLevel();

    android.view.View getExpressAdView();

    java.lang.String getPECPM();

    int getStyleType();

    boolean isAdAvailable();

    void render();

    void setAdCloseListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressCloseListener expressCloseListener);

    void setAdDislikeListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener expressDislikeListener);

    void setAdPrivacyListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener);

    void setExpectedSizePixel(int i, int i2);

    void setInteractionListener(com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener expressInteractionListener);

    boolean switchTheme(int i);
}
