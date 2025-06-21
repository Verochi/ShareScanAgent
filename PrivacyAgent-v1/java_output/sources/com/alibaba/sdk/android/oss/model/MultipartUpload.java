package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class MultipartUpload {
    private java.util.Date initiated;
    private java.lang.String key;
    private java.lang.String storageClass;
    private java.lang.String uploadId;

    public java.util.Date getInitiated() {
        return this.initiated;
    }

    public java.lang.String getKey() {
        return this.key;
    }

    public java.lang.String getStorageClass() {
        return this.storageClass;
    }

    public java.lang.String getUploadId() {
        return this.uploadId;
    }

    public void setInitiated(java.util.Date date) {
        this.initiated = date;
    }

    public void setKey(java.lang.String str) {
        this.key = str;
    }

    public void setStorageClass(java.lang.String str) {
        this.storageClass = str;
    }

    public void setUploadId(java.lang.String str) {
        this.uploadId = str;
    }
}
