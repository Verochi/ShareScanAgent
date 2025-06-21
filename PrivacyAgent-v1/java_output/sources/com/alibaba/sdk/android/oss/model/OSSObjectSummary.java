package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class OSSObjectSummary {
    private java.lang.String bucketName;
    private java.lang.String eTag;
    private java.lang.String key;
    private java.util.Date lastModified;
    private com.alibaba.sdk.android.oss.model.Owner owner;
    private long size;
    private java.lang.String storageClass;
    private java.lang.String type;

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.lang.String getETag() {
        return this.eTag;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public com.alibaba.sdk.android.oss.model.Owner getOwner() {
        return this.owner;
    }

    public long getSize() {
        return this.size;
    }

    public java.lang.String getStorageClass() {
        return this.storageClass;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setETag(java.lang.String str) {
        this.eTag = str;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public void setLastModified(java.util.Date date) {
        this.lastModified = date;
    }

    public void setOwner(com.alibaba.sdk.android.oss.model.Owner owner) {
        this.owner = owner;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setStorageClass(java.lang.String str) {
        this.storageClass = str;
    }

    public void setType(java.lang.String str) {
        this.type = str;
    }
}
