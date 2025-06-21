package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CompleteMultipartUploadResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String bucketName;
    private java.lang.String eTag;
    private java.lang.String location;
    private java.lang.String objectKey;
    private java.lang.String serverCallbackReturnBody;

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getETag() {
        return this.eTag;
    }

    public java.lang.String getLocation() {
        return this.location;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.lang.String getServerCallbackReturnBody() {
        return this.serverCallbackReturnBody;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setETag(java.lang.String str) {
        this.eTag = str;
    }

    public void setLocation(java.lang.String str) {
        this.location = str;
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setServerCallbackReturnBody(java.lang.String str) {
        this.serverCallbackReturnBody = str;
    }
}
