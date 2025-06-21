package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class GTTransmitMessage extends com.igexin.sdk.message.GTPushMessage {
    private java.lang.String messageId;
    private byte[] payload;
    private java.lang.String payloadId;
    private java.lang.String taskId;

    public GTTransmitMessage() {
    }

    public GTTransmitMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        this.taskId = str;
        this.messageId = str2;
        this.payloadId = str3;
        this.payload = bArr;
    }

    public java.lang.String getMessageId() {
        return this.messageId;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public java.lang.String getPayloadId() {
        return this.payloadId;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public void setMessageId(java.lang.String str) {
        this.messageId = str;
    }

    public void setPayload(byte[] bArr) {
        this.payload = bArr;
    }

    public void setPayloadId(java.lang.String str) {
        this.payloadId = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }
}
