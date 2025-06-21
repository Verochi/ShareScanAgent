package com.hihonor.push.framework.aidl.entity;

/* loaded from: classes22.dex */
public class RequestHeader implements com.hihonor.push.framework.aidl.IMessageEntity {

    @com.hihonor.push.framework.aidl.annotation.Packed
    private java.lang.String AAID;

    @com.hihonor.push.framework.aidl.annotation.Packed
    private java.lang.String appId;

    @com.hihonor.push.framework.aidl.annotation.Packed
    private java.lang.String certificateFingerprint;

    @com.hihonor.push.framework.aidl.annotation.Packed
    private java.lang.String packageName;

    @com.hihonor.push.framework.aidl.annotation.Packed
    private java.lang.String pushToken;

    @com.hihonor.push.framework.aidl.annotation.Packed
    private int sdkVersion;

    public java.lang.String getAAID() {
        return this.AAID;
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    public java.lang.String getCertificateFingerprint() {
        return this.certificateFingerprint;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getPushToken() {
        return this.pushToken;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public void setAAID(java.lang.String str) {
        this.AAID = str;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public void setCertificateFingerprint(java.lang.String str) {
        this.certificateFingerprint = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setPushToken(java.lang.String str) {
        this.pushToken = str;
    }

    public void setSdkVersion(int i) {
        this.sdkVersion = i;
    }
}
