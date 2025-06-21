package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
abstract class HttpMessage {
    private java.io.InputStream content;
    private long contentLength;
    private java.util.Map<java.lang.String, java.lang.String> headers = new com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap();
    private java.lang.String stringBody;

    public void addHeader(java.lang.String str, java.lang.String str2) {
        this.headers.put(str, str2);
    }

    public void close() throws java.io.IOException {
        java.io.InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
            this.content = null;
        }
    }

    public java.io.InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public java.util.Map<java.lang.String, java.lang.String> getHeaders() {
        return this.headers;
    }

    public java.lang.String getStringBody() {
        return this.stringBody;
    }

    public void setContent(java.io.InputStream inputStream) {
        this.content = inputStream;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
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

    public void setStringBody(java.lang.String str) {
        this.stringBody = str;
    }
}
