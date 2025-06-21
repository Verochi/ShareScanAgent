package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public final class RegeocodeRoad implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.geocoder.RegeocodeRoad> CREATOR = new com.amap.api.services.geocoder.RegeocodeRoad.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private float c;
    private java.lang.String d;
    private com.amap.api.services.core.LatLonPoint e;

    /* renamed from: com.amap.api.services.geocoder.RegeocodeRoad$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.geocoder.RegeocodeRoad> {
        private static com.amap.api.services.geocoder.RegeocodeRoad a(android.os.Parcel parcel) {
            return new com.amap.api.services.geocoder.RegeocodeRoad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.geocoder.RegeocodeRoad createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.geocoder.RegeocodeRoad[] newArray(int i) {
            return null;
        }
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readString();
        this.e = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
    }

    public /* synthetic */ RegeocodeRoad(android.os.Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final java.lang.String getDirection() {
        return this.d;
    }

    public final float getDistance() {
        return this.c;
    }

    public final java.lang.String getId() {
        return this.a;
    }

    public final com.amap.api.services.core.LatLonPoint getLatLngPoint() {
        return this.e;
    }

    public final java.lang.String getName() {
        return this.b;
    }

    public final void setDirection(java.lang.String str) {
        this.d = str;
    }

    public final void setDistance(float f) {
        this.c = f;
    }

    public final void setId(java.lang.String str) {
        this.a = str;
    }

    public final void setLatLngPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public final void setName(java.lang.String str) {
        this.b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeString(this.d);
        parcel.writeValue(this.e);
    }
}
