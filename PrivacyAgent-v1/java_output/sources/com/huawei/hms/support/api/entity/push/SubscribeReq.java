package com.huawei.hms.support.api.entity.push;

/* loaded from: classes22.dex */
public class SubscribeReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String appId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public boolean isFastApp = false;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String operation;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String packageName;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String projectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String subjectId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String token;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String topic;

    public SubscribeReq() {
    }

    public SubscribeReq(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.packageName = context.getPackageName();
        this.operation = str;
        this.topic = str2;
        this.appId = com.huawei.hms.utils.Util.getAppId(context);
        this.projectId = com.huawei.hms.push.s.c(context);
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    public java.lang.String getOperation() {
        return this.operation;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getProjectId() {
        return this.projectId;
    }

    public java.lang.String getSubjectId() {
        return this.subjectId;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public java.lang.String getTopic() {
        return this.topic;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    public void setFastApp(boolean z) {
        this.isFastApp = z;
    }

    public void setOperation(java.lang.String str) {
        this.operation = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setProjectId(java.lang.String str) {
        this.projectId = str;
    }

    public void setSubjectId(java.lang.String str) {
        this.subjectId = str;
    }

    public void setToken(java.lang.String str) {
        this.token = str;
    }

    public void setTopic(java.lang.String str) {
        this.topic = str;
    }

    public java.lang.String toString() {
        return "SubscribeReq{packageName='" + this.packageName + "', operation='" + this.operation + "'}";
    }
}
