package com.huawei.agconnect.exception;

/* loaded from: classes22.dex */
public abstract class AGCException extends java.lang.Exception {
    private int code;
    private java.lang.String errMsg;

    public AGCException(java.lang.String str, int i) {
        this.code = i;
        this.errMsg = str;
    }

    public int getCode() {
        return this.code;
    }

    public java.lang.String getErrMsg() {
        return this.errMsg;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return " code: " + this.code + " message: " + this.errMsg;
    }
}
