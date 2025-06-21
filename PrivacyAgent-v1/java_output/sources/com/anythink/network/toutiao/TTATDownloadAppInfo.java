package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATDownloadAppInfo extends com.anythink.core.api.ATAdAppInfo {
    public java.lang.String appName;
    public java.lang.String appPermissionLink;
    public java.lang.String appPrivacyLink;
    public long appSize;
    public java.lang.String appVersion;
    public java.lang.String functionLink;
    public java.lang.String publisher;

    public TTATDownloadAppInfo(com.bytedance.sdk.openadsdk.ComplianceInfo complianceInfo, long j) {
        this.appPrivacyLink = complianceInfo.getPrivacyUrl();
        this.appPermissionLink = complianceInfo.getPermissionUrl();
        this.appName = complianceInfo.getAppName();
        this.publisher = complianceInfo.getDeveloperName();
        this.appVersion = complianceInfo.getAppVersion();
        this.functionLink = complianceInfo.getFunctionDescUrl();
        this.appSize = j;
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
        return "";
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppPermissonUrl() {
        return this.appPermissionLink;
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
