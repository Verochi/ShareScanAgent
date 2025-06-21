package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public class BusStationItem implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.busline.BusStationItem> CREATOR = new com.amap.api.services.busline.BusStationItem.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private com.amap.api.services.core.LatLonPoint c;
    private java.lang.String d;
    private java.lang.String e;
    private java.util.List<com.amap.api.services.busline.BusLineItem> f;

    /* renamed from: com.amap.api.services.busline.BusStationItem$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.busline.BusStationItem> {
        private static com.amap.api.services.busline.BusStationItem a(android.os.Parcel parcel) {
            return new com.amap.api.services.busline.BusStationItem(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.busline.BusStationItem createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.busline.BusStationItem[] newArray(int i) {
            return null;
        }
    }

    public BusStationItem() {
        this.f = new java.util.ArrayList();
    }

    private BusStationItem(android.os.Parcel parcel) {
        this.f = new java.util.ArrayList();
        this.b = parcel.readString();
        this.a = parcel.readString();
        this.c = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readArrayList(com.amap.api.services.busline.BusLineItem.class.getClassLoader());
    }

    public /* synthetic */ BusStationItem(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    private static java.lang.String a(java.util.List<com.amap.api.services.busline.BusLineItem> list) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(list.get(i).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
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
        com.amap.api.services.busline.BusStationItem busStationItem = (com.amap.api.services.busline.BusStationItem) obj;
        java.lang.String str = this.a;
        if (str == null) {
            if (busStationItem.a != null) {
                return false;
            }
        } else if (!str.equals(busStationItem.a)) {
            return false;
        }
        return true;
    }

    public java.lang.String getAdCode() {
        return this.e;
    }

    public java.util.List<com.amap.api.services.busline.BusLineItem> getBusLineItems() {
        return this.f;
    }

    public java.lang.String getBusStationId() {
        return this.a;
    }

    public java.lang.String getBusStationName() {
        return this.b;
    }

    public java.lang.String getCityCode() {
        return this.d;
    }

    public com.amap.api.services.core.LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public int hashCode() {
        java.lang.String str = this.a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(java.lang.String str) {
        this.e = str;
    }

    public void setBusLineItems(java.util.List<com.amap.api.services.busline.BusLineItem> list) {
        this.f = list;
    }

    public void setBusStationId(java.lang.String str) {
        this.a = str;
    }

    public void setBusStationName(java.lang.String str) {
        this.b = str;
    }

    public void setCityCode(java.lang.String str) {
        this.d = str;
    }

    public void setLatLonPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public java.lang.String toString() {
        return "BusStationName: " + this.b + " LatLonPoint: " + this.c.toString() + " BusLines: " + a(this.f) + " CityCode: " + this.d + " AdCode: " + this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.a);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeList(this.f);
    }
}
