package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetObjectResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private long contentLength;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();
    private java.io.InputStream objectContent;

    @Override // com.alibaba.sdk.android.oss.model.OSSResult
    public java.lang.Long getClientCRC() {
        java.io.InputStream inputStream = this.objectContent;
        return (inputStream == null || !(inputStream instanceof com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream)) ? super.getClientCRC() : java.lang.Long.valueOf(((com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream) inputStream).getClientCRC64());
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public java.io.InputStream getObjectContent() {
        return this.objectContent;
    }

    public void setContentLength(long j) {
        this.contentLength = j;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectContent(java.io.InputStream inputStream) {
        this.objectContent = inputStream;
    }
}
