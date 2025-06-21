package com.amap.api.services.help;

/* loaded from: classes12.dex */
public class Tip implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.help.Tip> CREATOR = new com.amap.api.services.help.Tip.AnonymousClass1();
    private java.lang.String a;
    private com.amap.api.services.core.LatLonPoint b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;

    /* renamed from: com.amap.api.services.help.Tip$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.help.Tip> {
        private static com.amap.api.services.help.Tip a(android.os.Parcel parcel) {
            return new com.amap.api.services.help.Tip(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.help.Tip createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.help.Tip[] newArray(int i) {
            return null;
        }
    }

    public Tip() {
        this.h = "";
    }

    private Tip(android.os.Parcel parcel) {
        this.h = "";
        this.c = parcel.readString();
        this.e = parcel.readString();
        this.d = parcel.readString();
        this.a = parcel.readString();
        this.b = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public /* synthetic */ Tip(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public java.lang.String getAdcode() {
        return this.e;
    }

    public java.lang.String getAddress() {
        return this.f;
    }

    public java.lang.String getDistrict() {
        return this.d;
    }

    public java.lang.String getName() {
        return this.c;
    }

    public java.lang.String getPoiID() {
        return this.a;
    }

    public com.amap.api.services.core.LatLonPoint getPoint() {
        return this.b;
    }

    public java.lang.String getTypeCode() {
        return this.g;
    }

    public void setAdcode(java.lang.String str) {
        this.e = str;
    }

    public void setAddress(java.lang.String str) {
        this.f = str;
    }

    public void setDistrict(java.lang.String str) {
        this.d = str;
    }

    public void setID(java.lang.String str) {
        this.a = str;
    }

    public void setName(java.lang.String str) {
        this.c = str;
    }

    public void setPostion(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.b = latLonPoint;
    }

    public void setTypeCode(java.lang.String str) {
        this.g = str;
    }

    public java.lang.String toString() {
        return "name:" + this.c + " district:" + this.d + " adcode:" + this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.e);
        parcel.writeString(this.d);
        parcel.writeString(this.a);
        parcel.writeValue(this.b);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
