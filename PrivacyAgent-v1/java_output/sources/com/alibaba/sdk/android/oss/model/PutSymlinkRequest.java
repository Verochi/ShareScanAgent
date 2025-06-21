package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutSymlinkRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
    private java.lang.String objectKey;
    private java.lang.String targetObjectName;

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.lang.String getTargetObjectName() {
        return this.targetObjectName;
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

    public void setTargetObjectName(java.lang.String str) {
        this.targetObjectName = str;
    }
}
