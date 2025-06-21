package com.huawei.hms.support.api.entity.auth;

/* loaded from: classes22.dex */
public class Scope implements com.huawei.hms.core.aidl.IMessageEntity, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.huawei.hms.support.api.entity.auth.Scope> CREATOR = new com.huawei.hms.support.api.entity.auth.Scope.a();
    private java.lang.String mScopeUri;

    public static class a implements android.os.Parcelable.Creator<com.huawei.hms.support.api.entity.auth.Scope> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.support.api.entity.auth.Scope createFromParcel(android.os.Parcel parcel) {
            return new com.huawei.hms.support.api.entity.auth.Scope(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.huawei.hms.support.api.entity.auth.Scope[] newArray(int i) {
            return new com.huawei.hms.support.api.entity.auth.Scope[i];
        }
    }

    public Scope() {
        this.mScopeUri = null;
    }

    public Scope(android.os.Parcel parcel) {
        this.mScopeUri = parcel.readString();
    }

    public Scope(java.lang.String str) {
        this.mScopeUri = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof com.huawei.hms.support.api.entity.auth.Scope) {
            return com.huawei.hms.common.internal.Objects.equal(this.mScopeUri, ((com.huawei.hms.support.api.entity.auth.Scope) obj).mScopeUri);
        }
        return false;
    }

    @java.lang.Deprecated
    public boolean equeals(java.lang.Object obj) {
        return equals(obj);
    }

    public java.lang.String getScopeUri() {
        return this.mScopeUri;
    }

    public final int hashCode() {
        java.lang.String str = this.mScopeUri;
        return str == null ? super.hashCode() : str.hashCode();
    }

    public final java.lang.String toString() {
        return this.mScopeUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mScopeUri);
    }
}
