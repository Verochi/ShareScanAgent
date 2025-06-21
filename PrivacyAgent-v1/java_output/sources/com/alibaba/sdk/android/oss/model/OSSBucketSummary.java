package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class OSSBucketSummary {
    private com.alibaba.sdk.android.oss.model.CannedAccessControlList acl;
    public java.util.Date createDate;
    public java.lang.String extranetEndpoint;
    public java.lang.String intranetEndpoint;
    public java.lang.String location;
    public java.lang.String name;
    public com.alibaba.sdk.android.oss.model.Owner owner;
    public java.lang.String storageClass;

    public java.lang.String getAcl() {
        com.alibaba.sdk.android.oss.model.CannedAccessControlList cannedAccessControlList = this.acl;
        if (cannedAccessControlList != null) {
            return cannedAccessControlList.toString();
        }
        return null;
    }

    public void setAcl(java.lang.String str) {
        this.acl = com.alibaba.sdk.android.oss.model.CannedAccessControlList.parseACL(str);
    }

    public java.lang.String toString() {
        if (this.storageClass == null) {
            return "OSSBucket [name=" + this.name + ", creationDate=" + this.createDate + ", owner=" + this.owner.toString() + ", location=" + this.location + "]";
        }
        return "OSSBucket [name=" + this.name + ", creationDate=" + this.createDate + ", owner=" + this.owner.toString() + ", location=" + this.location + ", storageClass=" + this.storageClass + "]";
    }
}
