package com.huawei.hms.core.aidl;

/* loaded from: classes22.dex */
public class RequestHeader implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    private int apiLevel;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.util.List<java.lang.String> apiNameList;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String appId;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String packageName;

    @com.huawei.hms.core.aidl.annotation.Packed
    private int sdkVersion;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String sessionId;

    public RequestHeader() {
    }

    public RequestHeader(java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        this.appId = str;
        this.packageName = str2;
        this.sdkVersion = i;
        this.sessionId = str3;
    }

    public java.util.List<java.lang.String> getApiNameList() {
        return this.apiNameList;
    }

    public java.lang.String getAppID() {
        return this.appId;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public java.lang.String getSessionId() {
        return this.sessionId;
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setApiNameList(java.util.List<java.lang.String> list) {
        this.apiNameList = list;
    }

    public void setAppID(java.lang.String str) {
        this.appId = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setSdkVersion(int i) {
        this.sdkVersion = i;
    }

    public void setSessionId(java.lang.String str) {
        this.sessionId = str;
    }
}
