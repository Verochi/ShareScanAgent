package com.aliyun.player.bean;

/* loaded from: classes.dex */
public class InfoBean {
    private com.aliyun.player.bean.InfoCode mCode;
    private long mExtraValue = -1;
    private java.lang.String mExtraMsg = null;

    public com.aliyun.player.bean.InfoCode getCode() {
        return this.mCode;
    }

    public java.lang.String getExtraMsg() {
        return this.mExtraMsg;
    }

    public long getExtraValue() {
        return this.mExtraValue;
    }

    public void setCode(com.aliyun.player.bean.InfoCode infoCode) {
        this.mCode = infoCode;
    }

    public void setExtraMsg(java.lang.String str) {
        this.mExtraMsg = str;
    }

    public void setExtraValue(long j) {
        this.mExtraValue = j;
    }
}
