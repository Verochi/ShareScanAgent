package com.aliyun.common.network;

@com.aliyun.aio.keep.CalledByNative
/* loaded from: classes.dex */
public class AlivcHttpRequest {
    private byte[] body;
    private java.lang.String url;
    private java.lang.String method = "GET";
    private java.util.Map<java.lang.String, java.lang.String> headers = new java.util.HashMap();
    private java.util.Map<java.lang.String, java.lang.String> urlParam = new java.util.HashMap();
    private int readTimeout = 10000;
    private int connectTimeout = 10000;
    private boolean trustAllSSLCert = false;
    private boolean followRedirects = true;

    public void addHeader(java.lang.String str, java.lang.String str2) {
        this.headers.put(str, str2);
    }

    public void addUrlParam(java.lang.String str, java.lang.String str2) {
        this.urlParam.put(str, str2);
    }

    public byte[] getBody() {
        return this.body;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers;
    }

    public java.lang.String getMethod() {
        return this.method;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public java.lang.String getUrl() {
        return this.url;
    }

    public java.util.Map<java.lang.String, java.lang.String> getUrlParam() {
        return this.urlParam;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isTrustAllSSLCert() {
        return this.trustAllSSLCert;
    }

    public void setBody(java.lang.String str) {
        this.body = str.getBytes();
    }

    public void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public void setMethod(java.lang.String str) {
        this.method = str;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setTrustAllSSLCert(boolean z) {
        this.trustAllSSLCert = z;
    }

    public void setUrl(java.lang.String str) {
        this.url = str;
    }
}
