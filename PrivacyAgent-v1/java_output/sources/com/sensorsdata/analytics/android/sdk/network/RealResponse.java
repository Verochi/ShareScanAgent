package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
public class RealResponse {
    public int code;
    public long contentLength;
    public java.lang.String errorMsg;
    public java.lang.Exception exception;
    public java.lang.String location;
    public java.lang.String result;

    public java.lang.String toString() {
        java.util.Locale locale = java.util.Locale.getDefault();
        java.lang.Object[] objArr = new java.lang.Object[5];
        objArr[0] = java.lang.Integer.valueOf(this.code);
        objArr[1] = this.result;
        objArr[2] = this.location;
        objArr[3] = this.errorMsg;
        java.lang.Exception exc = this.exception;
        objArr[4] = exc == null ? "" : exc.getMessage();
        return java.lang.String.format(locale, "code:%d\nresult:%s\nlocation:%s\nerrorMsg:%s\nexception:%s", objArr);
    }
}
