package com.anythink.network.adx;

/* loaded from: classes12.dex */
public class AdxAppDownloadInfo extends com.anythink.core.api.ATAdAppInfo {
    public java.lang.String appName;
    public java.lang.String appPrivacyLink;
    public java.lang.String appVersion;
    public java.lang.String apppermissionLink;
    public java.lang.String functionLink;
    public java.lang.String publisher;

    public AdxAppDownloadInfo(com.anythink.basead.d.h hVar) {
        this.publisher = hVar.i();
        this.appVersion = hVar.l();
        this.appPrivacyLink = hVar.k();
        this.apppermissionLink = hVar.j();
        this.appName = hVar.h();
        this.functionLink = hVar.m();
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
        return this.apppermissionLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public java.lang.String getAppPrivacyUrl() {
        return this.appPrivacyLink;
    }

    @Override // com.anythink.core.api.ATAdAppInfo
    public long getAppSize() {
        return 0L;
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
