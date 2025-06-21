package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListBucketsResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.util.List<com.alibaba.sdk.android.oss.model.OSSBucketSummary> buckets = new java.util.ArrayList();
    private boolean isTruncated;
    private java.lang.String marker;
    private int maxKeys;
    private java.lang.String nextMarker;
    private java.lang.String ownerDisplayName;
    private java.lang.String ownerId;
    private java.lang.String prefix;

    public void addBucket(com.alibaba.sdk.android.oss.model.OSSBucketSummary oSSBucketSummary) {
        this.buckets.add(oSSBucketSummary);
    }

    public void clearBucketList() {
        this.buckets.clear();
    }

    public java.util.List<com.alibaba.sdk.android.oss.model.OSSBucketSummary> getBuckets() {
        return this.buckets;
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

    public java.lang.String getOwnerDisplayName() {
        return this.ownerDisplayName;
    }

    public java.lang.String getOwnerId() {
        return this.ownerId;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public boolean getTruncated() {
        return this.isTruncated;
    }

    public void setBuckets(java.util.List<com.alibaba.sdk.android.oss.model.OSSBucketSummary> list) {
        this.buckets = list;
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

    public void setOwnerDisplayName(java.lang.String str) {
        this.ownerDisplayName = str;
    }

    public void setOwnerId(java.lang.String str) {
        this.ownerId = str;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }
}
