package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class InitiateMultipartUploadRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    public boolean isSequential;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
    private java.lang.String objectKey;

    public InitiateMultipartUploadRequest(java.lang.String str, java.lang.String str2) {
        this(str, str2, null);
    }

    public InitiateMultipartUploadRequest(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        setBucketName(str);
        setObjectKey(str2);
        setMetadata(objectMetadata);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }
}
