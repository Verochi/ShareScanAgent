package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class OSSResult {
    private java.lang.Long clientCRC;
    private java.lang.String requestId;
    private java.util.Map<java.lang.String, java.lang.String> responseHeader;
    private java.lang.Long serverCRC;
    private int statusCode;

    public java.lang.Long getClientCRC() {
        return this.clientCRC;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public java.util.Map<java.lang.String, java.lang.String> getResponseHeader() {
        return this.responseHeader;
    }

    public java.lang.Long getServerCRC() {
        return this.serverCRC;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setClientCRC(java.lang.Long l) {
        if (l == null || l.longValue() == 0) {
            return;
        }
        this.clientCRC = l;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setResponseHeader(java.util.Map<java.lang.String, java.lang.String> map) {
        this.responseHeader = map;
    }

    public void setServerCRC(java.lang.Long l) {
        if (l == null || l.longValue() == 0) {
            return;
        }
        this.serverCRC = l;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public java.lang.String toString() {
        return java.lang.String.format("OSSResult<%s>: \nstatusCode:%d,\nresponseHeader:%s,\nrequestId:%s", super.toString(), java.lang.Integer.valueOf(this.statusCode), this.responseHeader.toString(), this.requestId);
    }
}
