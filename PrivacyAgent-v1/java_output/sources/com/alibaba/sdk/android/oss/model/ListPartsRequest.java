package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListPartsRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.Integer maxParts;
    private java.lang.String objectKey;
    private java.lang.Integer partNumberMarker;
    private java.lang.String uploadId;

    public ListPartsRequest(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadId(str3);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.Integer getMaxParts() {
        return this.maxParts;
    }

    public java.lang.String getObjectKey() {
        return this.objectKey;
    }

    public java.lang.Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setMaxParts(int i) {
        this.maxParts = java.lang.Integer.valueOf(i);
    }

    public void setObjectKey(java.lang.String str) {
        this.objectKey = str;
    }

    public void setPartNumberMarker(java.lang.Integer num) {
        this.partNumberMarker = num;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }
}
