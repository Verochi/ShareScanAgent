package com.huawei.hms.support.api.entity.auth;

/* loaded from: classes22.dex */
public class PermissionInfo implements com.huawei.hms.core.aidl.IMessageEntity, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.huawei.hms.support.api.entity.auth.PermissionInfo> CREATOR = new com.huawei.hms.support.api.entity.auth.PermissionInfo.a();

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String appID;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String packageName;

    @com.huawei.hms.core.aidl.annotation.Packed
    private java.lang.String permission;

    public static class a implements android.os.Parcelable.Creator<com.huawei.hms.support.api.entity.auth.PermissionInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.support.api.entity.auth.PermissionInfo createFromParcel(android.os.Parcel parcel) {
            return new com.huawei.hms.support.api.entity.auth.PermissionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.support.api.entity.auth.PermissionInfo[] newArray(int i) {
            return new com.huawei.hms.support.api.entity.auth.PermissionInfo[i];
        }
    }

    public PermissionInfo() {
    }

    public PermissionInfo(android.os.Parcel parcel) {
        this.appID = parcel.readString();
        this.packageName = parcel.readString();
        this.permission = parcel.readString();
    }

    public PermissionInfo(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.appID = str;
        this.packageName = str2;
        this.permission = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAppID() {
        return this.appID;
    }

    public java.lang.String getPackageName() {
        return this.packageName;
    }

    public java.lang.String getPermission() {
        return this.permission;
    }

    public void setAppID(java.lang.String str) {
        this.appID = str;
    }

    public void setPackageName(java.lang.String str) {
        this.packageName = str;
    }

    public void setPermission(java.lang.String str) {
        this.permission = str;
    }

    public com.huawei.hms.support.api.entity.auth.PermissionInfo setPermissionUri(java.lang.String str) {
        this.permission = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.appID);
        parcel.writeString(this.packageName);
        parcel.writeString(this.permission);
    }
}
