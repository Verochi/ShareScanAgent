package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class ResponseMessage extends com.alibaba.sdk.android.oss.internal.HttpMessage {
    private com.alibaba.sdk.android.oss.internal.RequestMessage request;
    private okhttp3.Response response;
    private int statusCode;

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void addHeader(java.lang.String str, java.lang.String str2) {
        super.addHeader(str, str2);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void close() throws java.io.IOException {
        super.close();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ java.io.InputStream getContent() {
        return super.getContent();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ long getContentLength() {
        return super.getContentLength();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ java.util.Map getHeaders() {
        return super.getHeaders();
    }

    public com.alibaba.sdk.android.oss.internal.RequestMessage getRequest() {
        return this.request;
    }

    public okhttp3.Response getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ java.lang.String getStringBody() {
        return super.getStringBody();
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setContent(java.io.InputStream inputStream) {
        super.setContent(inputStream);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setContentLength(long j) {
        super.setContentLength(j);
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setHeaders(java.util.Map map) {
        super.setHeaders(map);
    }

    public void setRequest(com.alibaba.sdk.android.oss.internal.RequestMessage requestMessage) {
        this.request = requestMessage;
    }

    public void setResponse(okhttp3.Response response) {
        this.response = response;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    @Override // com.alibaba.sdk.android.oss.internal.HttpMessage
    public /* bridge */ /* synthetic */ void setStringBody(java.lang.String str) {
        super.setStringBody(str);
    }
}
