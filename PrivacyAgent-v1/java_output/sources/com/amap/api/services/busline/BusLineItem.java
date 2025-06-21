package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public class BusLineItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.busline.BusLineItem> CREATOR = new com.amap.api.services.busline.BusLineItem.AnonymousClass1();
    private float a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.util.List<com.amap.api.services.core.LatLonPoint> e;
    private java.util.List<com.amap.api.services.core.LatLonPoint> f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.util.Date j;
    private java.util.Date k;
    private java.lang.String l;
    private float m;
    private float n;
    private java.util.List<com.amap.api.services.busline.BusStationItem> o;

    /* renamed from: com.amap.api.services.busline.BusLineItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.busline.BusLineItem> {
        private static com.amap.api.services.busline.BusLineItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.busline.BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.busline.BusLineItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.busline.BusLineItem[] newArray(int i) {
            return null;
        }
    }

    public BusLineItem() {
        this.e = new java.util.ArrayList();
        this.f = new java.util.ArrayList();
        this.o = new java.util.ArrayList();
    }

    public BusLineItem(android.os.Parcel parcel) {
        this.e = new java.util.ArrayList();
        this.f = new java.util.ArrayList();
        this.o = new java.util.ArrayList();
        this.a = parcel.readFloat();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readArrayList(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.f = parcel.readArrayList(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.j = com.amap.api.col.s.i.e(parcel.readString());
        this.k = com.amap.api.col.s.i.e(parcel.readString());
        this.l = parcel.readString();
        this.m = parcel.readFloat();
        this.n = parcel.readFloat();
        this.o = parcel.readArrayList(com.amap.api.services.busline.BusStationItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.amap.api.services.busline.BusLineItem busLineItem = (com.amap.api.services.busline.BusLineItem) obj;
        java.lang.String str = this.g;
        if (str == null) {
            if (busLineItem.g != null) {
                return false;
            }
        } else if (!str.equals(busLineItem.g)) {
            return false;
        }
        return true;
    }

    public float getBasicPrice() {
        return this.m;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getBounds() {
        return this.f;
    }

    public java.lang.String getBusCompany() {
        return this.l;
    }

    public java.lang.String getBusLineId() {
        return this.g;
    }

    public java.lang.String getBusLineName() {
        return this.b;
    }

    public java.lang.String getBusLineType() {
        return this.c;
    }

    public java.util.List<com.amap.api.services.busline.BusStationItem> getBusStations() {
        return this.o;
    }

    public java.lang.String getCityCode() {
        return this.d;
    }

    public java.util.List<com.amap.api.services.core.LatLonPoint> getDirectionsCoordinates() {
        return this.e;
    }

    public float getDistance() {
        return this.a;
    }

    public java.util.Date getFirstBusTime() {
        java.util.Date date = this.j;
        if (date == null) {
            return null;
        }
        return (java.util.Date) date.clone();
    }

    public java.util.Date getLastBusTime() {
        java.util.Date date = this.k;
        if (date == null) {
            return null;
        }
        return (java.util.Date) date.clone();
    }

    public java.lang.String getOriginatingStation() {
        return this.h;
    }

    public java.lang.String getTerminalStation() {
        return this.i;
    }

    public float getTotalPrice() {
        return this.n;
    }

    public int hashCode() {
        java.lang.String str = this.g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f) {
        this.m = f;
    }

    public void setBounds(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
        this.f = list;
    }

    public void setBusCompany(java.lang.String str) {
        this.l = str;
    }

    public void setBusLineId(java.lang.String str) {
        this.g = str;
    }

    public void setBusLineName(java.lang.String str) {
        this.b = str;
    }

    public void setBusLineType(java.lang.String str) {
        this.c = str;
    }

    public void setBusStations(java.util.List<com.amap.api.services.busline.BusStationItem> list) {
        this.o = list;
    }

    public void setCityCode(java.lang.String str) {
        this.d = str;
    }

    public void setDirectionsCoordinates(java.util.List<com.amap.api.services.core.LatLonPoint> list) {
        this.e = list;
    }

    public void setDistance(float f) {
        this.a = f;
    }

    public void setFirstBusTime(java.util.Date date) {
        if (date == null) {
            this.j = null;
        } else {
            this.j = (java.util.Date) date.clone();
        }
    }

    public void setLastBusTime(java.util.Date date) {
        if (date == null) {
            this.k = null;
        } else {
            this.k = (java.util.Date) date.clone();
        }
    }

    public void setOriginatingStation(java.lang.String str) {
        this.h = str;
    }

    public void setTerminalStation(java.lang.String str) {
        this.i = str;
    }

    public void setTotalPrice(float f) {
        this.n = f;
    }

    public java.lang.String toString() {
        return this.b + " " + com.amap.api.col.s.i.a(this.j) + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + com.amap.api.col.s.i.a(this.k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeFloat(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeList(this.e);
        parcel.writeList(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(com.amap.api.col.s.i.a(this.j));
        parcel.writeString(com.amap.api.col.s.i.a(this.k));
        parcel.writeString(this.l);
        parcel.writeFloat(this.m);
        parcel.writeFloat(this.n);
        parcel.writeList(this.o);
    }
}
