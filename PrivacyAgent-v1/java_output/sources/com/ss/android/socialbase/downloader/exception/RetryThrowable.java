package com.ss.android.socialbase.downloader.exception;

/* loaded from: classes19.dex */
public class RetryThrowable extends java.lang.Throwable {
    private java.lang.String errorMsg;

    public RetryThrowable(java.lang.String str) {
        super(str);
        this.errorMsg = str;
    }

    public java.lang.String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(java.lang.String str) {
        this.errorMsg = str;
    }
}
