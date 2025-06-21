package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketInfoResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private com.alibaba.sdk.android.oss.model.OSSBucketSummary bucket;

    public com.alibaba.sdk.android.oss.model.OSSBucketSummary getBucket() {
        return this.bucket;
    }

    public void setBucket(com.alibaba.sdk.android.oss.model.OSSBucketSummary oSSBucketSummary) {
        this.bucket = oSSBucketSummary;
    }

    @Override // com.alibaba.sdk.android.oss.model.OSSResult
    public java.lang.String toString() {
        return java.lang.String.format("GetBucketInfoResult<%s>:\n bucket:%s", super.toString(), this.bucket.toString());
    }
}
