package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class DeleteMultipleObjectRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    private java.lang.String bucketName;
    private boolean isQuiet;
    private java.util.List<java.lang.String> objectKeys;

    public DeleteMultipleObjectRequest(java.lang.String str, java.util.List<java.lang.String> list, java.lang.Boolean bool) {
        setBucketName(str);
        setObjectKeys(list);
        setQuiet(bool);
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public java.util.List<java.lang.String> getObjectKeys() {
        return this.objectKeys;
    }

    public java.lang.Boolean getQuiet() {
        return java.lang.Boolean.valueOf(this.isQuiet);
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setObjectKeys(java.util.List<java.lang.String> list) {
        this.objectKeys = list;
    }

    public void setQuiet(java.lang.Boolean bool) {
        this.isQuiet = bool.booleanValue();
    }
}
