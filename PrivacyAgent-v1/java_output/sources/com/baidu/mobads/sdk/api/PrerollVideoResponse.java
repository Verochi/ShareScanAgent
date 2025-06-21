package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface PrerollVideoResponse {
    public static final java.lang.String GIF = "gif";
    public static final java.lang.String NORMAL = "normal";
    public static final java.lang.String VIDEO = "video";

    java.lang.String getAdLogoUrl();

    java.lang.String getBaiduLogoUrl();

    java.lang.String getDesc();

    java.lang.String getIconUrl();

    java.lang.String getImageUrl();

    java.lang.String getMaterialType();

    java.lang.String getTitle();

    java.lang.String getVideoUrl();

    void handleClick(android.view.View view);

    void handleClick(android.view.View view, int i);

    void recordImpression(android.view.View view);
}
