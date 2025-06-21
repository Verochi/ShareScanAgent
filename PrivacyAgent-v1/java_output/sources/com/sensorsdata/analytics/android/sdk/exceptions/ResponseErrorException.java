package com.sensorsdata.analytics.android.sdk.exceptions;

/* loaded from: classes19.dex */
public class ResponseErrorException extends java.lang.Exception {
    private int httpCode;

    public ResponseErrorException(java.lang.String str, int i) {
        super(str);
        this.httpCode = i;
    }

    public ResponseErrorException(java.lang.Throwable th, int i) {
        super(th);
        this.httpCode = i;
    }

    public int getHttpCode() {
        return this.httpCode;
    }
}
