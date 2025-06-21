package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class AbortMultipartUploadRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String objectKey;
    private java.lang.String uploadId;

    public AbortMultipartUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadId(str3);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }
}
