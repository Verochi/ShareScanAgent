package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GeneratePresignedUrlRequest {
    private java.util.Set<java.lang.String> additionalHeaderNames;
    private java.lang.String bucketName;
    private java.lang.String contentMD5;
    private java.lang.String contentType;
    private long expiration;
    private java.util.Map<java.lang.String, java.lang.String> headers;
    private java.lang.String key;
    private com.alibaba.sdk.android.oss.common.HttpMethod method;
    private java.lang.String process;
    private java.util.Map<java.lang.String, java.lang.String> queryParam;

    public GeneratePresignedUrlRequest(java.lang.String str, java.lang.String str2) {
        this(str, str2, com.anythink.expressad.d.a.b.P);
    }

    public GeneratePresignedUrlRequest(java.lang.String str, java.lang.String str2, long j) {
        this(str, str2, com.anythink.expressad.d.a.b.P, com.alibaba.sdk.android.oss.common.HttpMethod.GET);
    }

    public GeneratePresignedUrlRequest(java.lang.String str, java.lang.String str2, long j, com.alibaba.sdk.android.oss.common.HttpMethod httpMethod) {
        this.headers = new com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap();
        this.queryParam = new java.util.HashMap();
        this.bucketName = str;
        this.key = str2;
        this.expiration = j;
        this.method = httpMethod;
    }

    public void addHeader(java.lang.String str, java.lang.String str2) {
        this.headers.put(str, str2);
    }

    public void addQueryParameter(java.lang.String str, java.lang.String str2) {
        this.queryParam.put(str, str2);
    }

    public java.util.Set<java.lang.String> getAdditionalHeaderNames() {
        return this.additionalHeaderNames;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getContentMD5() {
        return this.contentMD5;
    }

    public java.lang.String getContentType() {
        return this.contentType;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public com.alibaba.sdk.android.oss.common.HttpMethod getMethod() {
        return this.method;
    }

    public java.lang.String getProcess() {
        return this.process;
    }

    public java.util.Map<java.lang.String, java.lang.String> getQueryParameter() {
        return this.queryParam;
    }

    public void setAdditionalHeaderNames(java.util.Set<java.lang.String> set) {
        this.additionalHeaderNames = set;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setContentMD5(java.lang.String str) {
        this.contentMD5 = str;
    }

    public void setContentType(java.lang.String str) {
        this.contentType = str;
    }

    public void setExpiration(long j) {
        this.expiration = j;
    }

    public void setHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
        if (this.headers == null) {
            this.headers = new com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap();
        }
        java.util.Map<java.lang.String, java.lang.String> map2 = this.headers;
        if (map2 != null && map2.size() > 0) {
            this.headers.clear();
        }
        this.headers.putAll(map);
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public void setMethod(com.alibaba.sdk.android.oss.common.HttpMethod httpMethod) {
        if (httpMethod != com.alibaba.sdk.android.oss.common.HttpMethod.GET && httpMethod != com.alibaba.sdk.android.oss.common.HttpMethod.PUT) {
            throw new java.lang.IllegalArgumentException("Only GET or PUT is supported!");
        }
        this.method = httpMethod;
    }

    public void setProcess(java.lang.String str) {
        this.process = str;
    }

    public void setQueryParameter(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            throw new java.lang.NullPointerException("The argument 'queryParameter' is null.");
        }
        java.util.Map<java.lang.String, java.lang.String> map2 = this.queryParam;
        if (map2 != null && map2.size() > 0) {
            this.queryParam.clear();
        }
        this.queryParam.putAll(map);
    }
}
