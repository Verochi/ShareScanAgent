package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IBasicCPUData extends com.baidu.mobads.sdk.api.AbstractData {

    public interface CpuNativeStatusCB {
        void onAdDownloadWindowShow();

        void onAdStatusChanged(java.lang.String str, int i);

        void onNotifyPerformance(java.lang.String str);

        void onPermissionClose();

        void onPermissionShow();

        void onPrivacyClick();

        void onPrivacyLpClose();
    }

    void cancelAppDownload();

    void clickHotItem(android.view.View view);

    int getActionType();

    int getAdHeight();

    java.lang.String getAdLogoUrl();

    int getAdWidth();

    java.lang.String getAppPackageName();

    java.lang.String getAppPermissionUrl();

    java.lang.String getAppPrivacyUrl();

    java.lang.String getAppPublisher();

    java.lang.String getAppVersion();

    int getAttribute();

    java.lang.String getAuthor();

    java.lang.String getBaiduLogoUrl();

    java.lang.String getBrandName();

    java.lang.String getChannelId();

    java.lang.String getChannelName();

    int getCommentCounts();

    java.util.List<java.lang.Integer> getContentAttributesList();

    java.lang.String getContentClickUrl();

    long getCtime();

    java.lang.String getDesc();

    org.json.JSONArray getDislikeReasons();

    int getDownloadStatus();

    int getDuration();

    org.json.JSONObject getExtra();

    long getHotId();

    java.lang.String getHotWord();

    java.lang.String getIconUrl();

    java.lang.String getImage();

    java.util.List<java.lang.String> getImageUrls();

    java.lang.String getLabel();

    int getPlayCounts();

    int getPresentationType();

    int getReadCounts();

    double getScore();

    java.util.List<java.lang.String> getSmallImageUrls();

    int getStyleTypeCpu();

    int getThumbHeight();

    java.lang.String getThumbUrl();

    int getThumbWidth();

    java.lang.String getTitle();

    java.lang.String getType();

    java.lang.String getUpdateTime();

    java.lang.String getVUrl();

    @java.lang.Deprecated
    void handleClick(android.view.View view, java.lang.Object... objArr);

    void handleCreativeView(android.view.View view);

    void handleDislikeClick(android.view.View view, int i);

    boolean isAutoplay();

    boolean isCanGoLp();

    boolean isNeedDownloadApp();

    boolean isTop();

    void markDislike(java.lang.String[] strArr);

    @java.lang.Deprecated
    void onImpression(android.view.View view);

    void pauseAppDownload();

    void registerViewForInteraction(android.view.View view, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB);

    @java.lang.Deprecated
    void setStatusListener(com.baidu.mobads.sdk.api.IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB);
}
