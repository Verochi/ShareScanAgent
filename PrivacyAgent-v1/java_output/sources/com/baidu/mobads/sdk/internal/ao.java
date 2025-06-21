package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class ao implements com.baidu.mobads.sdk.api.IPromoteInstallAdInfo {
    private final com.baidu.mobads.sdk.internal.ap a;
    private final android.content.Context b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;

    public ao(org.json.JSONObject jSONObject, android.content.Context context, com.baidu.mobads.sdk.internal.ap apVar) {
        this.a = apVar;
        this.b = context;
        try {
            this.c = jSONObject.optString("pk");
            this.d = jSONObject.optString("icon");
            this.e = jSONObject.optString("appname");
            this.f = jSONObject.optString("bidlayer");
            this.g = jSONObject.optString("enc_bid_price");
            this.h = jSONObject.optString(com.aliyun.vod.log.core.AliyunLogCommon.Module.PUBLISHER);
            this.i = jSONObject.optString("app_version");
            this.j = jSONObject.optString("privacy_link");
            this.k = jSONObject.optString("permission_link");
            this.l = jSONObject.optString("function_link");
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getAppPublisher() {
        return this.h;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getAppVersion() {
        return this.i;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getBrandName() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getECPMLevel() {
        return this.f;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getFunctionUrl() {
        return this.l;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getIconUrl() {
        return this.d;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getPECPM() {
        return this.g;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getPermissionUrl() {
        return this.k;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getPrivacyUrl() {
        return this.j;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public java.lang.String getUnionLogoUrl() {
        return "http://union.baidu.com";
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public void handleAdInstall() {
        com.baidu.mobads.sdk.internal.ap apVar = this.a;
        if (apVar != null) {
            apVar.a(this.b, this.c);
        }
    }
}
