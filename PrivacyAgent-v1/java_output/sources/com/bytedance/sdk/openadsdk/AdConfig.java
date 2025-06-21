package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface AdConfig {
    int getAgeGroup();

    java.lang.String getAppId();

    java.lang.String getAppName();

    com.bytedance.sdk.openadsdk.TTCustomController getCustomController();

    java.lang.String getData();

    int[] getDirectDownloadNetworkType();

    @java.lang.Deprecated
    java.lang.Object getExtra(java.lang.String str);

    java.util.Map<java.lang.String, java.lang.Object> getInitExtra();

    java.lang.String getKeywords();

    int getPluginUpdateConfig();

    int getThemeStatus();

    int getTitleBarTheme();

    boolean isAllowShowNotify();

    boolean isDebug();

    boolean isPaid();

    boolean isSupportMultiProcess();
}
