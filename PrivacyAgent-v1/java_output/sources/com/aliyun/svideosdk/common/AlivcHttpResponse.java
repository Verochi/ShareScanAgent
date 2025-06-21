package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AlivcHttpResponse {
    private java.lang.String body;
    private int statusCode;
    private java.lang.String statusMessage;

    public AlivcHttpResponse(int i, java.lang.String str) {
        this.statusCode = i;
        this.statusMessage = str;
    }

    public java.lang.String getBody() {
        return this.body;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public java.lang.String getStatusMessage() {
        return this.statusMessage;
    }

    public void setBody(java.lang.String str) {
        this.body = str;
    }
}
