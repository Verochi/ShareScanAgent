package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetObjectRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String objectKey;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback progressListener;
    private com.alibaba.sdk.android.oss.model.Range range;
    private java.util.Map<java.lang.String, java.lang.String> requestHeaders;
    private java.lang.String xOssProcess;

    public GetObjectRequest(java.lang.String str, java.lang.String str2) {
        setBucketName(str);
        setObjectKey(str2);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback getProgressListener() {
        return this.progressListener;
    }

    public com.alibaba.sdk.android.oss.model.Range getRange() {
        return this.range;
    }

    public java.util.Map<java.lang.String, java.lang.String> getRequestHeaders() {
        return this.requestHeaders;
    }

    public java.lang.String getxOssProcess() {
        return this.xOssProcess;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setProgressListener(com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.GetObjectRequest> oSSProgressCallback) {
        this.progressListener = oSSProgressCallback;
    }

    public void setRange(com.alibaba.sdk.android.oss.model.Range range) {
        this.range = range;
    }

    public void setRequestHeaders(java.util.Map<java.lang.String, java.lang.String> map) {
        this.requestHeaders = map;
    }

    public void setxOssProcess(java.lang.String str) {
        this.xOssProcess = str;
    }
}
