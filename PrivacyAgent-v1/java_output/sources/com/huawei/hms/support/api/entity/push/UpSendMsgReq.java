package com.huawei.hms.support.api.entity.push;

/* loaded from: classes22.dex */
public class UpSendMsgReq implements com.huawei.hms.core.aidl.IMessageEntity {

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String collapseKey;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String data;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String msgId;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String msgType;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String packageName;

    @com.huawei.hms.core.aidl.annotation.Packed
    public int receiptMode;

    @com.huawei.hms.core.aidl.annotation.Packed
    public int sendMode;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String to;

    @com.huawei.hms.core.aidl.annotation.Packed
    public java.lang.String token;

    @com.huawei.hms.core.aidl.annotation.Packed
    public int ttl;

    public java.lang.String getCollapseKey() {
        return this.collapseKey;
    }

    public java.lang.String getData() {
        return this.data;
    }

    public java.lang.String getMessageId() {
        return this.msgId;
    }

    public java.lang.String getMessageType() {
        return this.msgType;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public java.lang.String getTo() {
        return this.to;
    }

    public java.lang.String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setCollapseKey(java.lang.String str) {
        this.collapseKey = str;
    }

    public void setData(java.lang.String str) {
        this.data = str;
    }

    public void setMessageId(java.lang.String str) {
        this.msgId = str;
    }

    public void setMessageType(java.lang.String str) {
        this.msgType = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setReceiptMode(int i) {
        this.receiptMode = i;
    }

    public void setSendMode(int i) {
        this.sendMode = i;
    }

    public void setTo(java.lang.String str) {
        this.to = str;
    }

    public void setToken(java.lang.String str) {
        this.token = str;
    }

    public void setTtl(int i) {
        this.ttl = i;
    }
}
