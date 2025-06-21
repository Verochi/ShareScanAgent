package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class Owner implements java.io.Serializable {
    private static final long serialVersionUID = -1942759024112448066L;
    private java.lang.String displayName;
    private java.lang.String id;

    public Owner() {
        this(null, null);
    }

    public Owner(java.lang.String str, java.lang.String str2) {
        this.id = str;
        this.displayName = str2;
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.alibaba.sdk.android.oss.model.Owner)) {
            return false;
        }
        com.alibaba.sdk.android.oss.model.Owner owner = (com.alibaba.sdk.android.oss.model.Owner) obj;
        java.lang.String id = owner.getId();
        java.lang.String displayName = owner.getDisplayName();
        java.lang.String id2 = getId();
        java.lang.String displayName2 = getDisplayName();
        if (id == null) {
            id = "";
        }
        if (displayName == null) {
            displayName = "";
        }
        if (id2 == null) {
            id2 = "";
        }
        if (displayName2 == null) {
            displayName2 = "";
        }
        return id.equals(id2) && displayName.equals(displayName2);
    }

    public java.lang.String getDisplayName() {
        return this.displayName;
    }

    public java.lang.String getId() {
        return this.id;
    }

    public int hashCode() {
        java.lang.String str = this.id;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setDisplayName(java.lang.String str) {
        this.displayName = str;
    }

    public void setId(java.lang.String str) {
        this.id = str;
    }

    public java.lang.String toString() {
        return "Owner [name=" + getDisplayName() + ",id=" + getId() + "]";
    }
}
