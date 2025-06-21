package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PutBucketLifecycleRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> lifecycleRules;
    private java.lang.String mBucketName;

    public java.lang.String getBucketName() {
        return this.mBucketName;
    }

    public java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> getLifecycleRules() {
        return this.lifecycleRules;
    }

    public void setBucketName(java.lang.String str) {
        this.mBucketName = str;
    }

    public void setLifecycleRules(java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> arrayList) {
        this.lifecycleRules = arrayList;
    }
}
