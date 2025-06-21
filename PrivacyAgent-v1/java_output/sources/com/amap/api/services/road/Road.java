package com.amap.api.services.road;

/* loaded from: classes12.dex */
public class Road implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.road.Road> CREATOR = new com.amap.api.services.road.Road.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;
    private float d;
    private java.lang.String e;
    private com.amap.api.services.core.LatLonPoint f;

    /* renamed from: com.amap.api.services.road.Road$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.road.Road> {
        private static com.amap.api.services.road.Road a(android.os.Parcel parcel) {
            return new com.amap.api.services.road.Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.road.Road createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.road.Road[] newArray(int i) {
            return null;
        }
    }

    public Road() {
    }

    public Road(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readFloat();
        this.e = parcel.readString();
        this.f = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
    }

    public Road(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.services.core.LatLonPoint getCenterPoint() {
        return this.f;
    }

    public java.lang.String getCityCode() {
        return this.c;
    }

    public java.lang.String getId() {
        return this.a;
    }

    public java.lang.String getName() {
        return this.b;
    }

    public float getRoadWidth() {
        return this.d;
    }

    public java.lang.String getType() {
        return this.e;
    }

    public void setCenterPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.f = latLonPoint;
    }

    public void setCityCode(java.lang.String str) {
        this.c = str;
    }

    public void setId(java.lang.String str) {
        this.a = str;
    }

    public void setName(java.lang.String str) {
        this.b = str;
    }

    public void setRoadWidth(float f) {
        this.d = f;
    }

    public void setType(java.lang.String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeFloat(this.d);
        parcel.writeString(this.e);
        parcel.writeValue(this.f);
    }
}
