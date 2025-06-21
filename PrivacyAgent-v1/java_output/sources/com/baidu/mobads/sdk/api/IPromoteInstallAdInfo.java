package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IPromoteInstallAdInfo {
    java.lang.String getAppPublisher();

    java.lang.String getAppVersion();

    java.lang.String getBrandName();

    java.lang.String getECPMLevel();

    java.lang.String getFunctionUrl();

    java.lang.String getIconUrl();

    java.lang.String getPECPM();

    java.lang.String getPermissionUrl();

    java.lang.String getPrivacyUrl();

    java.lang.String getUnionLogoUrl();

    void handleAdInstall();
}
