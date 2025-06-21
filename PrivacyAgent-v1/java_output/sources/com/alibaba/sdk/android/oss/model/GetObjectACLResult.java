package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class GetObjectACLResult extends com.alibaba.sdk.android.oss.model.OSSResult {
    private com.alibaba.sdk.android.oss.model.CannedAccessControlList objectACL;
    private com.alibaba.sdk.android.oss.model.Owner objectOwner = new com.alibaba.sdk.android.oss.model.Owner();

    public java.lang.String getObjectACL() {
        com.alibaba.sdk.android.oss.model.CannedAccessControlList cannedAccessControlList = this.objectACL;
        if (cannedAccessControlList != null) {
            return cannedAccessControlList.toString();
        }
        return null;
    }

    public java.lang.String getObjectOwner() {
        return this.objectOwner.getDisplayName();
    }

    public java.lang.String getObjectOwnerID() {
        return this.objectOwner.getId();
    }

    public com.alibaba.sdk.android.oss.model.Owner getOwner() {
        return this.objectOwner;
    }

    public void setObjectACL(java.lang.String str) {
        this.objectACL = com.alibaba.sdk.android.oss.model.CannedAccessControlList.parseACL(str);
    }

    public void setObjectOwner(java.lang.String str) {
        this.objectOwner.setDisplayName(str);
    }

    public void setObjectOwnerID(java.lang.String str) {
        this.objectOwner.setId(str);
    }
}
