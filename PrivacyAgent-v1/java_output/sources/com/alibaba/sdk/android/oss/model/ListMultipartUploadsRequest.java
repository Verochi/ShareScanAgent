package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListMultipartUploadsRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private java.lang.String delimiter;
    private java.lang.String encodingType;
    private java.lang.String keyMarker;
    private java.lang.Integer maxUploads;
    private java.lang.String prefix;
    private java.lang.String uploadIdMarker;

    public ListMultipartUploadsRequest(java.lang.String str) {
        this.bucketName = str;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getDelimiter() {
        return this.delimiter;
    }

    public java.lang.String getEncodingType() {
        return this.encodingType;
    }

    public java.lang.String getKeyMarker() {
        return this.keyMarker;
    }

    public java.lang.Integer getMaxUploads() {
        return this.maxUploads;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public java.lang.String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public void setDelimiter(java.lang.String str) {
        this.delimiter = str;
    }

    public void setEncodingType(java.lang.String str) {
        this.encodingType = str;
    }

    public void setKeyMarker(java.lang.String str) {
        this.keyMarker = str;
    }

    public void setMaxUploads(java.lang.Integer num) {
        this.maxUploads = num;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
    }

    public void setUploadIdMarker(java.lang.String str) {
        this.uploadIdMarker = str;
    }
}
