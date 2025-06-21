package com.aliyun.player.bean;

/* loaded from: classes.dex */
public class ErrorInfo {
    private com.aliyun.player.bean.ErrorCode mCode;
    private java.lang.String mExtra;
    private java.lang.String mMsg;

    public com.aliyun.player.bean.ErrorCode getCode() {
        return this.mCode;
    }

    public java.lang.String getExtra() {
        return this.mExtra;
    }

    public java.lang.String getMsg() {
        return this.mMsg;
    }

    public void setCode(com.aliyun.player.bean.ErrorCode errorCode) {
        this.mCode = errorCode;
    }

    public void setExtra(java.lang.String str) {
        this.mExtra = str;
    }

    public void setMsg(java.lang.String str) {
        this.mMsg = str;
    }
}
