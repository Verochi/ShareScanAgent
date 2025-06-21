package com.huawei.hms.support.api.entity.core;

/* loaded from: classes22.dex */
public class JosBaseReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String channelId;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String cpId;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String hmsSdkVersionName;

    private static <T> T get(T t) {
        return t;
    }

    public java.lang.String getChannelId() {
        return (java.lang.String) get(this.channelId);
    }

    public java.lang.String getCpID() {
        return (java.lang.String) get(this.cpId);
    }

    public java.lang.String getHmsSdkVersionName() {
        return (java.lang.String) get(this.hmsSdkVersionName);
    }

    public void setChannelId(java.lang.String str) {
        this.channelId = str;
    }

    public void setCpID(java.lang.String str) {
        this.cpId = str;
    }

    public void setHmsSdkVersionName(java.lang.String str) {
        this.hmsSdkVersionName = str;
    }
}
