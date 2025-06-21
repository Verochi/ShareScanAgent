package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetObjectMetaResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }
}
