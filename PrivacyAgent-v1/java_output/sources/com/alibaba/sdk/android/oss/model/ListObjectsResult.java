package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListObjectsResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String bucketName;
    private java.lang.String delimiter;
    private java.lang.String encodingType;
    private boolean isTruncated;
    private java.lang.String marker;
    private int maxKeys;
    private java.lang.String nextMarker;
    private java.lang.String prefix;
    private java.util.List<com.alibaba.sdk.android.oss.model.OSSObjectSummary> objectSummaries = new java.util.ArrayList();
    private java.util.List<java.lang.String> commonPrefixes = new java.util.ArrayList();

    public void addCommonPrefix(java.lang.String str) {
        this.commonPrefixes.add(str);
    }

    public void addObjectSummary(com.alibaba.sdk.android.oss.model.OSSObjectSummary oSSObjectSummary) {
        this.objectSummaries.add(oSSObjectSummary);
    }

    public void clearCommonPrefixes() {
        this.commonPrefixes.clear();
    }

    public void clearObjectSummaries() {
        this.objectSummaries.clear();
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.util.List<java.lang.String> getCommonPrefixes() {
        return this.commonPrefixes;
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

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public java.lang.String getNextMarker() {
        return this.nextMarker;
    }

    public java.util.List<com.alibaba.sdk.android.oss.model.OSSObjectSummary> getObjectSummaries() {
        return this.objectSummaries;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public boolean isTruncated() {
        return this.isTruncated;
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

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public void setNextMarker(java.lang.String str) {
        this.nextMarker = str;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }
}
