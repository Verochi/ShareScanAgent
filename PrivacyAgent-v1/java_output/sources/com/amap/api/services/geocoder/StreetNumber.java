package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public final class StreetNumber implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.geocoder.StreetNumber> CREATOR = new com.amap.api.services.geocoder.StreetNumber.AnonymousClass1();
    private java.lang.String a;
    private java.lang.String b;
    private com.amap.api.services.core.LatLonPoint c;
    private java.lang.String d;
    private float e;

    /* renamed from: com.amap.api.services.geocoder.StreetNumber$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.geocoder.StreetNumber> {
        private static com.amap.api.services.geocoder.StreetNumber a(android.os.Parcel parcel) {
            return new com.amap.api.services.geocoder.StreetNumber(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.geocoder.StreetNumber createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ com.amap.api.services.geocoder.StreetNumber[] newArray(int i) {
            return null;
        }
    }

    public StreetNumber() {
    }

    private StreetNumber(android.os.Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (com.amap.api.services.core.LatLonPoint) parcel.readValue(com.amap.api.services.core.LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readFloat();
    }

    public /* synthetic */ StreetNumber(android.os.Parcel parcel, byte b) {
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
        return this.e;
    }

    public final com.amap.api.services.core.LatLonPoint getLatLonPoint() {
        return this.c;
    }

    public final java.lang.String getNumber() {
        return this.b;
    }

    public final java.lang.String getStreet() {
        return this.a;
    }

    public final void setDirection(java.lang.String str) {
        this.d = str;
    }

    public final void setDistance(float f) {
        this.e = f;
    }

    public final void setLatLonPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public final void setNumber(java.lang.String str) {
        this.b = str;
    }

    public final void setStreet(java.lang.String str) {
        this.a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.d);
        parcel.writeFloat(this.e);
    }
}
