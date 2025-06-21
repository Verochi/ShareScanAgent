package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CreateBucketRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    public static final java.lang.String TAB_LOCATIONCONSTRAINT = "LocationConstraint";
    public static final java.lang.String TAB_STORAGECLASS = "StorageClass";
    private com.alibaba.sdk.android.oss.model.CannedAccessControlList bucketACL;
    private java.lang.String bucketName;
    private com.alibaba.sdk.android.oss.model.StorageClass bucketStorageClass = com.alibaba.sdk.android.oss.model.StorageClass.Standard;
    private java.lang.String locationConstraint;

    public CreateBucketRequest(java.lang.String str) {
        setBucketName(str);
    }

    public com.alibaba.sdk.android.oss.model.CannedAccessControlList getBucketACL() {
        return this.bucketACL;
    }

    public java.lang.String getBucketName() {
        return this.bucketName;
    }

    public com.alibaba.sdk.android.oss.model.StorageClass getBucketStorageClass() {
        return this.bucketStorageClass;
    }

    @java.lang.Deprecated
    public java.lang.String getLocationConstraint() {
        return this.locationConstraint;
    }

    public void setBucketACL(com.alibaba.sdk.android.oss.model.CannedAccessControlList cannedAccessControlList) {
        this.bucketACL = cannedAccessControlList;
    }

    public void setBucketName(java.lang.String str) {
        this.bucketName = str;
    }

    public void setBucketStorageClass(com.alibaba.sdk.android.oss.model.StorageClass storageClass) {
        this.bucketStorageClass = storageClass;
    }

    @java.lang.Deprecated
    public void setLocationConstraint(java.lang.String str) {
        this.locationConstraint = str;
    }
}
