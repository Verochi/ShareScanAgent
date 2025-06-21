package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketACLRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;

    public GetBucketACLRequest(java.lang.String str) {
        setBucketName(str);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }
}
