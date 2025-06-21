package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class HeadObjectResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    @Override // com.alibaba.sdk.android.oss.model.OSSResult
    public java.lang.String toString() {
        return java.lang.String.format("HeadObjectResult<%s>:\n metadata:%s", super.toString(), this.metadata.toString());
    }
}
