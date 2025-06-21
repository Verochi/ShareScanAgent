package com.tencent.tauth;

/* loaded from: classes19.dex */
public class UiError {
    public int errorCode;
    public java.lang.String errorDetail;
    public java.lang.String errorMessage;

    public UiError(int i, java.lang.String str, java.lang.String str2) {
        this.errorMessage = str;
        this.errorCode = i;
        this.errorDetail = str2;
    }

    public java.lang.String toString() {
        return "errorCode: " + this.errorCode + ", errorMsg: " + this.errorMessage + ", errorDetail: " + this.errorDetail;
    }
}
