package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public final class RegeocodeAddress implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.geocoder.RegeocodeAddress> CREATOR = new com.amap.api.services.geocoder.RegeocodeAddress.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private com.amap.api.services.geocoder.StreetNumber h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.util.List<com.amap.api.services.geocoder.RegeocodeRoad> l;
    private java.util.List<com.amap.api.services.road.Crossroad> m;
    private java.util.List<com.amap.api.services.core.PoiItem> n;
    private java.util.List<com.amap.api.services.geocoder.BusinessArea> o;
    private java.util.List<com.amap.api.services.geocoder.AoiItem> p;
    private java.lang.String q;
    private java.lang.String r;

    /* renamed from: com.amap.api.services.geocoder.RegeocodeAddress$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.geocoder.RegeocodeAddress> {
        private static com.amap.api.services.geocoder.RegeocodeAddress a(android.os.Parcel parcel) {
            return new com.amap.api.services.geocoder.RegeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.geocoder.RegeocodeAddress createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.geocoder.RegeocodeAddress[] newArray(int i) {
            return null;
        }
    }

    public RegeocodeAddress() {
        this.l = new java.util.ArrayList();
        this.m = new java.util.ArrayList();
        this.n = new java.util.ArrayList();
        this.o = new java.util.ArrayList();
        this.p = new java.util.ArrayList();
    }

    private RegeocodeAddress(android.os.Parcel parcel) {
        this.l = new java.util.ArrayList();
        this.m = new java.util.ArrayList();
        this.n = new java.util.ArrayList();
        this.o = new java.util.ArrayList();
        this.p = new java.util.ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = (com.amap.api.services.geocoder.StreetNumber) parcel.readValue(com.amap.api.services.geocoder.StreetNumber.class.getClassLoader());
        this.l = parcel.readArrayList(com.amap.api.services.road.Road.class.getClassLoader());
        this.m = parcel.readArrayList(com.amap.api.services.road.Crossroad.class.getClassLoader());
        this.n = parcel.readArrayList(com.amap.api.services.core.PoiItem.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.o = parcel.readArrayList(com.amap.api.services.geocoder.BusinessArea.class.getClassLoader());
        this.p = parcel.readArrayList(com.amap.api.services.geocoder.AoiItem.class.getClassLoader());
        this.k = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
    }

    public /* synthetic */ RegeocodeAddress(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String getAdCode() {
        return this.j;
    }

    public final java.util.List<com.amap.api.services.geocoder.AoiItem> getAois() {
        return this.p;
    }

    public final java.lang.String getBuilding() {
        return this.g;
    }

    public final java.util.List<com.amap.api.services.geocoder.BusinessArea> getBusinessAreas() {
        return this.o;
    }

    public final java.lang.String getCity() {
        return this.c;
    }

    public final java.lang.String getCityCode() {
        return this.i;
    }

    public final java.lang.String getCountry() {
        return this.q;
    }

    public final java.lang.String getCountryCode() {
        return this.r;
    }

    public final java.util.List<com.amap.api.services.road.Crossroad> getCrossroads() {
        return this.m;
    }

    public final java.lang.String getDistrict() {
        return this.d;
    }

    public final java.lang.String getFormatAddress() {
        return this.a;
    }

    public final java.lang.String getNeighborhood() {
        return this.f;
    }

    public final java.util.List<com.amap.api.services.core.PoiItem> getPois() {
        return this.n;
    }

    public final java.lang.String getProvince() {
        return this.b;
    }

    public final java.util.List<com.amap.api.services.geocoder.RegeocodeRoad> getRoads() {
        return this.l;
    }

    public final com.amap.api.services.geocoder.StreetNumber getStreetNumber() {
        return this.h;
    }

    public final java.lang.String getTowncode() {
        return this.k;
    }

    public final java.lang.String getTownship() {
        return this.e;
    }

    public final void setAdCode(java.lang.String str) {
        this.j = str;
    }

    public final void setAois(java.util.List<com.amap.api.services.geocoder.AoiItem> list) {
        this.p = list;
    }

    public final void setBuilding(java.lang.String str) {
        this.g = str;
    }

    public final void setBusinessAreas(java.util.List<com.amap.api.services.geocoder.BusinessArea> list) {
        this.o = list;
    }

    public final void setCity(java.lang.String str) {
        this.c = str;
    }

    public final void setCityCode(java.lang.String str) {
        this.i = str;
    }

    public final void setCountry(java.lang.String str) {
        this.q = str;
    }

    public final void setCountryCode(java.lang.String str) {
        this.r = str;
    }

    public final void setCrossroads(java.util.List<com.amap.api.services.road.Crossroad> list) {
        this.m = list;
    }

    public final void setDistrict(java.lang.String str) {
        this.d = str;
    }

    public final void setFormatAddress(java.lang.String str) {
        this.a = str;
    }

    public final void setNeighborhood(java.lang.String str) {
        this.f = str;
    }

    public final void setPois(java.util.List<com.amap.api.services.core.PoiItem> list) {
        this.n = list;
    }

    public final void setProvince(java.lang.String str) {
        this.b = str;
    }

    public final void setRoads(java.util.List<com.amap.api.services.geocoder.RegeocodeRoad> list) {
        this.l = list;
    }

    public final void setStreetNumber(com.amap.api.services.geocoder.StreetNumber streetNumber) {
        this.h = streetNumber;
    }

    public final void setTowncode(java.lang.String str) {
        this.k = str;
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
        parcel.writeValue(this.h);
        parcel.writeList(this.l);
        parcel.writeList(this.m);
        parcel.writeList(this.n);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeList(this.o);
        parcel.writeList(this.p);
        parcel.writeString(this.k);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
    }
}
