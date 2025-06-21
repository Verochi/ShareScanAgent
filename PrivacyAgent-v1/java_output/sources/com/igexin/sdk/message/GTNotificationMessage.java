package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class GTNotificationMessage extends com.igexin.sdk.message.GTPushMessage {
    private java.lang.String content;
    private java.lang.String intentUri;
    private java.lang.String messageId;
    private java.lang.String payload;
    private java.lang.String taskId;
    private java.lang.String title;
    private java.lang.String url;

    public GTNotificationMessage() {
    }

    public GTNotificationMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        this.taskId = str;
        this.messageId = str2;
        this.title = str3;
        this.content = str4;
        this.url = str5;
        this.intentUri = str6;
        this.payload = str7;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public java.lang.String getIntentUri() {
        return this.intentUri;
    }

    public java.lang.String getMessageId() {
        return this.messageId;
    }

    public java.lang.String getPayload() {
        return this.payload;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setIntentUri(java.lang.String str) {
        this.intentUri = str;
    }

    public void setMessageId(java.lang.String str) {
        this.messageId = str;
    }

    public void setPayload(java.lang.String str) {
        this.payload = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }
}
