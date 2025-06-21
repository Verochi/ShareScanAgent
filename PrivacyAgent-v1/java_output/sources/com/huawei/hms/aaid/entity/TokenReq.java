package com.huawei.hms.aaid.entity;

/* loaded from: classes22.dex */
public class TokenReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String aaid;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String appId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean firstTime;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String packageName;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String projectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String scope;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String subjectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean isMultiSender = false;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean isFastApp = false;

    public java.lang.String getAaid() {
        return this.aaid;
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getProjectId() {
        return this.projectId;
    }

    public java.lang.String getScope() {
        return this.scope;
    }

    public java.lang.String getSubjectId() {
        return this.subjectId;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isFirstTime() {
        return this.firstTime;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAaid(java.lang.String str) {
        this.aaid = str;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public void setFastApp(boolean z) {
        this.isFastApp = z;
    }

    public void setFirstTime(boolean z) {
        this.firstTime = z;
    }

    public void setMultiSender(boolean z) {
        this.isMultiSender = z;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setProjectId(java.lang.String str) {
        this.projectId = str;
    }

    public void setScope(java.lang.String str) {
        this.scope = str;
    }

    public void setSubjectId(java.lang.String str) {
        this.subjectId = str;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(com.huawei.hms.aaid.entity.TokenReq.class.getName());
        stringBuffer.append("{");
        stringBuffer.append("pkgName: ");
        stringBuffer.append(this.packageName);
        stringBuffer.append(",isFirstTime: ");
        stringBuffer.append(this.firstTime);
        stringBuffer.append(",scope:");
        stringBuffer.append(this.scope);
        stringBuffer.append(",appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(",projectId:");
        stringBuffer.append(this.projectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append(com.alipay.sdk.m.u.i.d);
        return stringBuffer.toString();
    }
}
