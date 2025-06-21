package com.amap.api.services.core;

/* loaded from: classes12.dex */
public class LatLonPoint implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.amap.api.services.core.LatLonPoint> CREATOR = new com.amap.api.services.core.LatLonPoint.AnonymousClass1();
    private double a;
    private double b;

    /* renamed from: com.amap.api.services.core.LatLonPoint$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.services.core.LatLonPoint> {
        private static com.amap.api.services.core.LatLonPoint a(android.os.Parcel parcel) {
            return new com.amap.api.services.core.LatLonPoint(parcel);
        }

        private static com.amap.api.services.core.LatLonPoint[] a(int i) {
            return new com.amap.api.services.core.LatLonPoint[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.core.LatLonPoint createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.services.core.LatLonPoint[] newArray(int i) {
            return a(i);
        }
    }

    public LatLonPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public LatLonPoint(android.os.Parcel parcel) {
        this.a = parcel.readDouble();
        this.b = parcel.readDouble();
    }

    public com.amap.api.services.core.LatLonPoint copy() {
        return new com.amap.api.services.core.LatLonPoint(this.a, this.b);
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
        com.amap.api.services.core.LatLonPoint latLonPoint = (com.amap.api.services.core.LatLonPoint) obj;
        return java.lang.Double.doubleToLongBits(this.a) == java.lang.Double.doubleToLongBits(latLonPoint.a) && java.lang.Double.doubleToLongBits(this.b) == java.lang.Double.doubleToLongBits(latLonPoint.b);
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLongitude() {
        return this.b;
    }

    public int hashCode() {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(this.a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = java.lang.Double.doubleToLongBits(this.b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public void setLatitude(double d) {
        this.a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public java.lang.String toString() {
        return this.a + "," + this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeDouble(this.a);
        parcel.writeDouble(this.b);
    }
}
