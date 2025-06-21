package com.huawei.hms.aaid.entity;

/* loaded from: classes22.dex */
public class DeleteTokenReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String appId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String pkgName;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String projectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String scope;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String subjectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String token;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean isMultiSender = false;

    @com.huawei.hms.core.aidl.annotation.Packed
    public int deleteType = 0;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean isFastApp = false;

    public java.lang.String getAppId() {
        return this.appId;
    }

    public int getDeleteType() {
        return this.deleteType;
    }

    public java.lang.String getPkgName() {
        return this.pkgName;
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

    public java.lang.String getToken() {
        return this.token;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public void setDeleteType(int i) {
        this.deleteType = i;
    }

    public void setFastApp(boolean z) {
        this.isFastApp = z;
    }

    public void setMultiSender(boolean z) {
        this.isMultiSender = z;
    }

    public void setPkgName(java.lang.String str) {
        this.pkgName = str;
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

    public void setToken(java.lang.String str) {
        this.token = str;
    }

    public java.lang.String toString() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(com.huawei.hms.aaid.entity.DeleteTokenReq.class.getName());
        stringBuffer.append("{");
        stringBuffer.append("pkgName: ");
        stringBuffer.append(this.pkgName);
        stringBuffer.append(",scope:");
        stringBuffer.append(this.scope);
        stringBuffer.append(",appId:");
        stringBuffer.append(this.appId);
        stringBuffer.append(",projectId:");
        stringBuffer.append(this.projectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append(",subjectId:");
        stringBuffer.append(this.subjectId);
        stringBuffer.append(com.alipay.sdk.m.u.i.d);
        return stringBuffer.toString();
    }
}
