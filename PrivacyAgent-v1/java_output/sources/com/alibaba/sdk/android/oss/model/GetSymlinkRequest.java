package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetSymlinkRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String objectKey;

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
