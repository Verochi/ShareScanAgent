package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListPartsResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private java.lang.String bucketName;
    private java.lang.String key;
    private java.lang.String storageClass;
    private java.lang.String uploadId;
    private int maxParts = 0;
    private int partNumberMarker = 0;
    private boolean isTruncated = false;
    private int nextPartNumberMarker = 0;
    private java.util.List<com.alibaba.sdk.android.oss.model.PartSummary> parts = new java.util.ArrayList();

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public int getMaxParts() {
        return this.maxParts;
    }

    public int getNextPartNumberMarker() {
        return this.nextPartNumberMarker;
    }

    public int getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public java.util.List<com.alibaba.sdk.android.oss.model.PartSummary> getParts() {
        return this.parts;
    }

    public java.lang.String getStorageClass() {
        return this.storageClass;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public void setMaxParts(int i) {
        this.maxParts = i;
    }

    public void setNextPartNumberMarker(int i) {
        this.nextPartNumberMarker = i;
    }

    public void setPartNumberMarker(int i) {
        this.partNumberMarker = i;
    }

    public void setParts(java.util.List<com.alibaba.sdk.android.oss.model.PartSummary> list) {
        this.parts.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.parts.addAll(list);
    }

    public void setStorageClass(java.lang.String str) {
        this.storageClass = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }
}
