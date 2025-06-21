package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CompleteMultipartUploadRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.util.Map<java.lang.String, java.lang.String> callbackParam;
    private java.util.Map<java.lang.String, java.lang.String> callbackVars;
    private com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
    private java.lang.String objectKey;
    private java.util.List<com.alibaba.sdk.android.oss.model.PartETag> partETags = new java.util.ArrayList();
    private java.lang.String uploadId;

    public CompleteMultipartUploadRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<com.alibaba.sdk.android.oss.model.PartETag> list) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadId(str3);
        setPartETags(list);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCallbackParam() {
        return this.callbackParam;
    }

    public java.util.Map<java.lang.String, java.lang.String> getCallbackVars() {
        return this.callbackVars;
    }

    public com.alibaba.sdk.android.oss.model.ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.util.List<com.alibaba.sdk.android.oss.model.PartETag> getPartETags() {
        return this.partETags;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setCallbackParam(java.util.Map<java.lang.String, java.lang.String> map) {
        this.callbackParam = map;
    }

    public void setCallbackVars(java.util.Map<java.lang.String, java.lang.String> map) {
        this.callbackVars = map;
    }

    public void setMetadata(com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setPartETags(java.util.List<com.alibaba.sdk.android.oss.model.PartETag> list) {
        this.partETags = list;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }
}
