package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketLifecycleResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> mLifecycleRules;

    public void addLifecycleRule(com.alibaba.sdk.android.oss.model.BucketLifecycleRule bucketLifecycleRule) {
        if (this.mLifecycleRules == null) {
            this.mLifecycleRules = new java.util.ArrayList<>();
        }
        this.mLifecycleRules.add(bucketLifecycleRule);
    }

    public java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> getlifecycleRules() {
        return this.mLifecycleRules;
    }

    public void setLifecycleRules(java.util.ArrayList<com.alibaba.sdk.android.oss.model.BucketLifecycleRule> arrayList) {
        this.mLifecycleRules = arrayList;
    }
}
