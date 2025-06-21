package com.alibaba.sdk.android.vod.upload.exception;

/* loaded from: classes.dex */
public class VODClientException extends java.lang.RuntimeException {
    private java.lang.String code;
    private java.lang.String message;

    public VODClientException() {
    }

    public VODClientException(java.lang.String str, java.lang.String str2) {
        super("[ErrorCod]: " + str + ",[ErrorMessage]: " + str2);
        this.code = str;
        this.message = str2;
    }

    public java.lang.String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        java.lang.String message = super.getMessage();
        if (getCause() == null) {
            return message;
        }
        return getCause().getMessage() + "\n" + message;
    }

    public void setCode(java.lang.String str) {
        this.code = str;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }
}
