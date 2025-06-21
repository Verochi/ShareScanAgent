package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListObjectsRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    private java.lang.String bucketName;
    private java.lang.String delimiter;
    private java.lang.String encodingType;
    private java.lang.String marker;
    private java.lang.Integer maxKeys;
    private java.lang.String prefix;

    public ListObjectsRequest() {
        this(null);
    }

    public ListObjectsRequest(java.lang.String str) {
        this(str, null, null, null, null);
    }

    public ListObjectsRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.Integer num) {
        setBucketName(str);
        setPrefix(str2);
        setMarker(str3);
        setDelimiter(str4);
        if (num != null) {
            setMaxKeys(num);
        }
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

    public java.lang.String getMarker() {
        return this.marker;
    }

    public java.lang.Integer getMaxKeys() {
        return this.maxKeys;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setDelimiter(java.lang.String str) {
        this.delimiter = str;
    }

    public void setEncodingType(java.lang.String str) {
        this.encodingType = str;
    }

    public void setMarker(java.lang.String str) {
        this.marker = str;
    }

    public void setMaxKeys(java.lang.Integer num) {
        if (num.intValue() < 0 || num.intValue() > 1000) {
            throw new java.lang.IllegalArgumentException("Maxkeys should less can not exceed 1000.");
        }
        this.maxKeys = num;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
    }
}
