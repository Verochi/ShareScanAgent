package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketLoggingResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private boolean mLoggingEnabled = false;
    private java.lang.String mTargetBucketName;
    private java.lang.String mTargetPrefix;

    public java.lang.String getTargetBucketName() {
        return this.mTargetBucketName;
    }

    public java.lang.String getTargetPrefix() {
        return this.mTargetPrefix;
    }

    public boolean loggingEnabled() {
        return this.mLoggingEnabled;
    }

    public void setLoggingEnabled(boolean z) {
        this.mLoggingEnabled = z;
    }

    public void setTargetBucketName(java.lang.String str) {
        this.mTargetBucketName = str;
    }

    public void setTargetPrefix(java.lang.String str) {
        this.mTargetPrefix = str;
    }
}
