package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetBucketACLResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private com.alibaba.sdk.android.oss.model.CannedAccessControlList bucketACL;
    private com.alibaba.sdk.android.oss.model.Owner bucketOwner = new com.alibaba.sdk.android.oss.model.Owner();

    public java.lang.String getBucketACL() {
        com.alibaba.sdk.android.oss.model.CannedAccessControlList cannedAccessControlList = this.bucketACL;
        if (cannedAccessControlList != null) {
            return cannedAccessControlList.toString();
        }
        return null;
    }

    public java.lang.String getBucketOwner() {
        return this.bucketOwner.getDisplayName();
    }

    public java.lang.String getBucketOwnerID() {
        return this.bucketOwner.getId();
    }

    public com.alibaba.sdk.android.oss.model.Owner getOwner() {
        return this.bucketOwner;
    }

    public void setBucketACL(java.lang.String str) {
        this.bucketACL = com.alibaba.sdk.android.oss.model.CannedAccessControlList.parseACL(str);
    }

    public void setBucketOwner(java.lang.String str) {
        this.bucketOwner.setDisplayName(str);
    }

    public void setBucketOwnerID(java.lang.String str) {
        this.bucketOwner.setId(str);
    }
}
