package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATDownloadAppInfo extends com.anythink.core.api.ATAdAppInfo {
    public java.lang.String appDownloadCount;
    public java.lang.String appName;
    public java.lang.String appPrivacyLink;
    public long appSize;
    public java.lang.String appVersion;
    public java.lang.String apppermissionLink;
    public java.lang.String functionLink;
    public java.lang.String publisher;

    public GDTATDownloadAppInfo(com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo nativeUnifiedADAppMiitInfo, java.lang.String str) {
        this.publisher = nativeUnifiedADAppMiitInfo.getAuthorName();
        this.appVersion = nativeUnifiedADAppMiitInfo.getVersionName();
        this.appPrivacyLink = nativeUnifiedADAppMiitInfo.getPrivacyAgreement();
        this.apppermissionLink = nativeUnifiedADAppMiitInfo.getPermissionsUrl();
        this.appName = nativeUnifiedADAppMiitInfo.getAppName();
        this.appSize = nativeUnifiedADAppMiitInfo.getPackageSizeBytes();
        this.functionLink = nativeUnifiedADAppMiitInfo.getDescriptionUrl();
        this.appDownloadCount = str;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppDownloadCount() {
        return this.appDownloadCount;
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
