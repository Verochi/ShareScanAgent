package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class DeleteObjectRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String objectKey;

    public DeleteObjectRequest(java.lang.String str, java.lang.String str2) {
        setBucketName(str);
        setObjectKey(str2);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }
}
