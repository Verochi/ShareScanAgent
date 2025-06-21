package com.getui.gtc.entity;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class Ie implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.getui.gtc.entity.Ie> CREATOR = new com.getui.gtc.entity.Ie.AnonymousClass1();
    private java.lang.String aid;

    /* renamed from: cn, reason: collision with root package name */
    private java.lang.String f313cn;
    private java.lang.String cs;
    private java.lang.String k;

    /* renamed from: com.getui.gtc.entity.Ie$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.getui.gtc.entity.Ie> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.getui.gtc.entity.Ie createFromParcel(android.os.Parcel parcel) {
            return new com.getui.gtc.entity.Ie(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.getui.gtc.entity.Ie[] newArray(int i) {
            return new com.getui.gtc.entity.Ie[i];
        }
    }

    public Ie() {
    }

    public Ie(android.os.Parcel parcel) {
        this.f313cn = parcel.readString();
        this.aid = parcel.readString();
        this.cs = parcel.readString();
        this.k = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            java.lang.String str = this.f313cn;
            java.lang.String str2 = ((com.getui.gtc.entity.Ie) obj).f313cn;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public java.lang.String getAid() {
        return this.aid;
    }

    public java.lang.String getCn() {
        return this.f313cn;
    }

    public java.lang.String getCs() {
        return this.cs;
    }

    public java.lang.String getK() {
        return this.k;
    }

    public int hashCode() {
        java.lang.String str = this.f313cn;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setAid(java.lang.String str) {
        this.aid = str;
    }

    public void setCn(java.lang.String str) {
        this.f313cn = str;
    }

    public void setCs(java.lang.String str) {
        this.cs = str;
    }

    public void setK(java.lang.String str) {
        this.k = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.f313cn);
        parcel.writeString(this.aid);
        parcel.writeString(this.cs);
        parcel.writeString(this.k);
    }
}
