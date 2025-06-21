package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class ClientSettings {
    private java.util.List<java.lang.String> apiName;
    private java.lang.String appId;
    private java.lang.String clientClassName;
    private java.lang.String clientPackageName;
    private java.lang.ref.WeakReference<android.app.Activity> cpActivity;
    private boolean hasActivity;
    private java.lang.String innerHmsPkg;
    private boolean isUseInnerHms;
    private java.lang.String mCpID;
    private java.util.List<com.huawei.hms.support.api.entity.auth.Scope> scopes;
    private com.huawei.hms.support.api.client.SubAppInfo subAppId;

    public ClientSettings(java.lang.String str, java.lang.String str2, java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list, java.lang.String str3, java.util.List<java.lang.String> list2) {
        this.clientPackageName = str;
        this.clientClassName = str2;
        this.scopes = list;
        this.appId = str3;
        this.apiName = list2;
    }

    public ClientSettings(java.lang.String str, java.lang.String str2, java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list, java.lang.String str3, java.util.List<java.lang.String> list2, com.huawei.hms.support.api.client.SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        setSubAppId(subAppInfo);
    }

    public java.util.List<java.lang.String> getApiName() {
        return this.apiName;
    }

    public java.lang.String getAppID() {
        return this.appId;
    }

    public java.lang.String getClientClassName() {
        return this.clientClassName;
    }

    public java.lang.String getClientPackageName() {
        return this.clientPackageName;
    }

    public android.app.Activity getCpActivity() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.cpActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public java.lang.String getCpID() {
        return this.mCpID;
    }

    public java.lang.String getInnerHmsPkg() {
        return this.innerHmsPkg;
    }

    public java.util.List<com.huawei.hms.support.api.entity.auth.Scope> getScopes() {
        return this.scopes;
    }

    public com.huawei.hms.support.api.client.SubAppInfo getSubAppID() {
        return this.subAppId;
    }

    public boolean isHasActivity() {
        return this.hasActivity;
    }

    public boolean isUseInnerHms() {
        return this.isUseInnerHms;
    }

    public void setApiName(java.util.List<java.lang.String> list) {
        this.apiName = list;
    }

    public void setAppID(java.lang.String str) {
        this.appId = str;
    }

    public void setClientClassName(java.lang.String str) {
        this.clientClassName = str;
    }

    public void setClientPackageName(java.lang.String str) {
        this.clientPackageName = str;
    }

    public void setCpActivity(android.app.Activity activity) {
        this.cpActivity = new java.lang.ref.WeakReference<>(activity);
        this.hasActivity = true;
    }

    public void setCpID(java.lang.String str) {
        this.mCpID = str;
    }

    public void setInnerHmsPkg(java.lang.String str) {
        this.innerHmsPkg = str;
    }

    public void setScopes(java.util.List<com.huawei.hms.support.api.entity.auth.Scope> list) {
        this.scopes = list;
    }

    public void setSubAppId(com.huawei.hms.support.api.client.SubAppInfo subAppInfo) {
        this.subAppId = subAppInfo;
    }

    public void setUseInnerHms(boolean z) {
        this.isUseInnerHms = z;
    }
}
