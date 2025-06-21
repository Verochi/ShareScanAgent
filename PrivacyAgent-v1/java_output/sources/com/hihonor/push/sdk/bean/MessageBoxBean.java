package com.hihonor.push.sdk.bean;

/* loaded from: classes22.dex */
public class MessageBoxBean {
    private java.lang.String content;
    private java.lang.String image;
    private java.lang.String msgExtra;
    private long receiveTimeMillis;
    private com.hihonor.push.sdk.bean.SkipType skipType;
    private java.lang.String skipUrl;
    private java.lang.String title;

    public java.lang.String getContent() {
        return this.content;
    }

    public java.lang.String getImage() {
        return this.image;
    }

    public java.lang.String getMsgExtra() {
        return this.msgExtra;
    }

    public long getReceiveTimeMillis() {
        return this.receiveTimeMillis;
    }

    public com.hihonor.push.sdk.bean.SkipType getSkipType() {
        return this.skipType;
    }

    public java.lang.String getSkipUrl() {
        return this.skipUrl;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setContent(java.lang.String str) {
        this.content = str;
    }

    public void setImage(java.lang.String str) {
        this.image = str;
    }

    public void setMsgExtra(java.lang.String str) {
        this.msgExtra = str;
    }

    public void setReceiveTimeMillis(long j) {
        this.receiveTimeMillis = j;
    }

    public void setSkipType(com.hihonor.push.sdk.bean.SkipType skipType) {
        this.skipType = skipType;
    }

    public void setSkipUrl(java.lang.String str) {
        this.skipUrl = str;
    }

    public void setTitle(java.lang.String str) {
        this.title = str;
    }
}
