package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class UploadPartRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String md5Digest;
    private java.lang.String objectKey;
    private byte[] partContent;
    private int partNumber;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest> progressCallback;
    private java.lang.String uploadId;

    public UploadPartRequest() {
    }

    public UploadPartRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        this.bucketName = str;
        this.objectKey = str2;
        this.uploadId = str3;
        this.partNumber = i;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getMd5Digest() {
        return this.md5Digest;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public byte[] getPartContent() {
        return this.partContent;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest> getProgressCallback() {
        return this.progressCallback;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setMd5Digest(java.lang.String str) {
        this.md5Digest = str;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setPartContent(byte[] bArr) {
        this.partContent = bArr;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public void setProgressCallback(com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest> oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }
}
