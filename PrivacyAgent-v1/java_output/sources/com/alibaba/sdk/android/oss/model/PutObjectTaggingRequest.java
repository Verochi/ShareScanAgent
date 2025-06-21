package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutObjectTaggingRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String objectKey;
    private java.util.Map<java.lang.String, java.lang.String> tags;

    public PutObjectTaggingRequest(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        this.bucketName = str;
        this.objectKey = str2;
        this.tags = map;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.util.Map<java.lang.String, java.lang.String> getTags() {
        return this.tags;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setTags(java.util.Map<java.lang.String, java.lang.String> map) {
        this.tags = map;
    }
}
