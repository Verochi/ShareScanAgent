package com.anythink.core.api;

/* loaded from: classes12.dex */
public abstract class ATAdAppInfo {
    @java.lang.Deprecated
    public boolean canHandleFunctionClick() {
        return false;
    }

    @java.lang.Deprecated
    public void functionUrlClick() {
    }

    public abstract java.lang.String getAppDownloadCount();

    public abstract java.lang.String getAppName();

    public abstract java.lang.String getAppPackageName();

    public abstract java.lang.String getAppPermissonUrl();

    public abstract java.lang.String getAppPrivacyUrl();

    public abstract long getAppSize();

    public abstract java.lang.String getAppVersion();

    public java.lang.String getFunctionUrl() {
        return "";
    }

    public abstract java.lang.String getPublisher();

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Publisher: ");
        sb.append(android.text.TextUtils.isEmpty(getPublisher()) ? "" : getPublisher());
        sb.append(" | AppVersion: ");
        sb.append(android.text.TextUtils.isEmpty(getAppVersion()) ? "" : getAppVersion());
        sb.append(" | AppPrivacyUrl: ");
        sb.append(android.text.TextUtils.isEmpty(getAppPrivacyUrl()) ? "" : getAppPrivacyUrl());
        sb.append(" | AppPermissonUrl: ");
        sb.append(android.text.TextUtils.isEmpty(getAppPermissonUrl()) ? "" : getAppPermissonUrl());
        sb.append(" | AppName: ");
        sb.append(android.text.TextUtils.isEmpty(getAppName()) ? "" : getAppName());
        sb.append(" | AppPackageName: ");
        sb.append(android.text.TextUtils.isEmpty(getAppPackageName()) ? "" : getAppPackageName());
        sb.append(" | AppSize: ");
        sb.append(getAppSize());
        sb.append(" | AppDownloadCount: ");
        sb.append(getAppDownloadCount());
        sb.append(" | DescriptionUrl: ");
        sb.append(getFunctionUrl());
        return sb.toString();
    }
}
