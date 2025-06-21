package com.anythink.network.baidu;

/* loaded from: classes12.dex */
public class BaiduATDownloadAppInfo extends com.anythink.core.api.ATAdAppInfo {
    public java.lang.String appName;
    public java.lang.String appPackageName;
    public java.lang.String appPrivacyLink;
    public long appSize;
    public java.lang.String appVersion;
    public java.lang.String apppermissionLink;
    public java.lang.String functionLink;
    public java.lang.String publisher;

    public BaiduATDownloadAppInfo(com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
        this.publisher = nativeResponse.getPublisher();
        this.appVersion = nativeResponse.getAppVersion();
        this.appPrivacyLink = nativeResponse.getAppPrivacyLink();
        this.apppermissionLink = nativeResponse.getAppPermissionLink();
        this.appSize = nativeResponse.getAppSize();
        this.appName = nativeResponse.getTitle();
        this.appPackageName = nativeResponse.getAppPackage();
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppDownloadCount() {
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppName() {
        return this.appName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppPackageName() {
        return this.appPackageName;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppPermissonUrl() {
        return this.apppermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return this.appSize;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppVersion() {
        return this.appVersion;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getFunctionUrl() {
        return this.functionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getPublisher() {
        return this.publisher;
    }
}
