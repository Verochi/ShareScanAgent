package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutBucketLoggingRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String mBucketName;
    private java.lang.String mTargetBucketName;
    private java.lang.String mTargetPrefix;

    public java.lang.String getBucketName() {
        return this.mBucketName;
    }

    public java.lang.String getTargetBucketName() {
        return this.mTargetBucketName;
    }

    public java.lang.String getTargetPrefix() {
        return this.mTargetPrefix;
    }

    public void setBucketName(java.lang.String str) {
        this.mBucketName = str;
    }

    public void setTargetBucketName(java.lang.String str) {
        this.mTargetBucketName = str;
    }

    public void setTargetPrefix(java.lang.String str) {
        this.mTargetPrefix = str;
    }
}
