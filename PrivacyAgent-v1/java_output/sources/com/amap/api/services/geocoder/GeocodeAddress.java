package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public final class GeocodeAddress implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.geocoder.GeocodeAddress> CREATOR = new com.amap.api.services.geocoder.GeocodeAddress.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private com.amap.api.services.core.LatLonPoint i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;

    /* renamed from: com.amap.api.services.geocoder.GeocodeAddress$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.geocoder.GeocodeAddress> {
        private static com.amap.api.services.geocoder.GeocodeAddress a(android.os.Parcel parcel) {
            return new com.amap.api.services.geocoder.GeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.geocoder.GeocodeAddress createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.geocoder.GeocodeAddress[] newArray(int i) {
            return null;
        }
    }

    public GeocodeAddress() {
    }

    private GeocodeAddress(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
    }

    public /* synthetic */ GeocodeAddress(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String getAdcode() {
        return this.h;
    }

    public final java.lang.String getBuilding() {
        return this.g;
    }

    public final java.lang.String getCity() {
        return this.c;
    }

    public final java.lang.String getCountry() {
        return this.k;
    }

    public final java.lang.String getDistrict() {
        return this.d;
    }

    public final java.lang.String getFormatAddress() {
        return this.a;
    }

    public final com.amap.api.services.core.LatLonPoint getLatLonPoint() {
        return this.i;
    }

    public final java.lang.String getLevel() {
        return this.j;
    }

    public final java.lang.String getNeighborhood() {
        return this.f;
    }

    public final java.lang.String getPostcode() {
        return this.l;
    }

    public final java.lang.String getProvince() {
        return this.b;
    }

    public final java.lang.String getTownship() {
        return this.e;
    }

    public final void setAdcode(java.lang.String str) {
        this.h = str;
    }

    public final void setBuilding(java.lang.String str) {
        this.g = str;
    }

    public final void setCity(java.lang.String str) {
        this.c = str;
    }

    public final void setCountry(java.lang.String str) {
        this.k = str;
    }

    public final void setDistrict(java.lang.String str) {
        this.d = str;
    }

    public final void setFormatAddress(java.lang.String str) {
        this.a = str;
    }

    public final void setLatLonPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.i = latLonPoint;
    }

    public final void setLevel(java.lang.String str) {
        this.j = str;
    }

    public final void setNeighborhood(java.lang.String str) {
        this.f = str;
    }

    public final void setPostcode(java.lang.String str) {
        this.l = str;
    }

    public final void setProvince(java.lang.String str) {
        this.b = str;
    }

    public final void setTownship(java.lang.String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeValue(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
    }
}
