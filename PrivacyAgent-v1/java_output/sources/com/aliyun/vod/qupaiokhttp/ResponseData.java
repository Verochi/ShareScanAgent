package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
class ResponseData {
    private int code;
    private okhttp3.Headers headers;
    private okhttp3.Response httpResponse;
    private java.lang.String message;
    private java.lang.String response;
    private boolean responseNull;
    private boolean success;
    private boolean timeout;

    public int getCode() {
        return this.code;
    }

    public okhttp3.Headers getHeaders() {
        return this.headers;
    }

    public okhttp3.Response getHttpResponse() {
        return this.httpResponse;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public java.lang.String getResponse() {
        return this.response;
    }

    public boolean isResponseNull() {
        return this.responseNull;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean isTimeout() {
        return this.timeout;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setHeaders(okhttp3.Headers headers) {
        this.headers = headers;
    }

    public void setHttpResponse(okhttp3.Response response) {
        this.httpResponse = response;
    }

    public void setMessage(java.lang.String str) {
        this.message = str;
    }

    public void setResponse(java.lang.String str) {
        this.response = str;
    }

    public void setResponseNull(boolean z) {
        this.responseNull = z;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTimeout(boolean z) {
        this.timeout = z;
    }
}
