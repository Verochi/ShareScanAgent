package com.alibaba.sdk.android.oss;

/* loaded from: classes.dex */
public class ServiceException extends java.lang.Exception {
    public static final java.lang.String PARSE_RESPONSE_FAIL = "SDKParseResponseFail";
    private static final long serialVersionUID = 430933593095358673L;
    private java.lang.String date;
    private java.lang.String ec;
    private java.lang.String errorCode;
    private java.lang.String hostId;
    private java.lang.String partEtag;
    private java.lang.String partNumber;
    private java.lang.String rawMessage;
    private java.lang.String recommendDoc;
    private java.lang.String requestId;
    private int statusCode;

    public ServiceException(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this(i, str, str2, str3, str4, str5, null);
    }

    public ServiceException(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6) {
        super(str);
        this.statusCode = i;
        this.errorCode = str2;
        this.requestId = str3;
        this.hostId = str4;
        this.rawMessage = str5;
        this.ec = str6;
        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(this);
    }

    public java.lang.String getDate() {
        return this.date;
    }

    public java.lang.String getEc() {
        return this.ec;
    }

    public java.lang.String getErrorCode() {
        return this.errorCode;
    }

    public java.lang.String getHostId() {
        return this.hostId;
    }

    public java.lang.String getPartEtag() {
        return this.partEtag;
    }

    public java.lang.String getPartNumber() {
        return this.partNumber;
    }

    public java.lang.String getRawMessage() {
        return this.rawMessage;
    }

    public java.lang.String getRecommendDoc() {
        return this.recommendDoc;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setDate(java.lang.String str) {
        this.date = str;
    }

    public void setPartEtag(java.lang.String str) {
        this.partEtag = str;
    }

    public void setPartNumber(java.lang.String str) {
        this.partNumber = str;
    }

    public void setRecommendDoc(java.lang.String str) {
        this.recommendDoc = str;
    }

    @Override // java.lang.Throwable
    public java.lang.String toString() {
        return "[StatusCode]: " + this.statusCode + ", [Code]: " + getErrorCode() + ", [Message]: " + getMessage() + ", [Requestid]: " + getRequestId() + ", [HostId]: " + getHostId() + ", [RawMessage]: " + getRawMessage();
    }
}
