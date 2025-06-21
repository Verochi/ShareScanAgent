package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class CircleHoleOptions extends com.amap.api.maps.model.BaseHoleOptions implements android.os.Parcelable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final android.os.Parcelable.Creator<com.amap.api.maps.model.CircleHoleOptions> CREATOR = new com.amap.api.maps.model.CircleHoleOptions.AnonymousClass1();
    private com.amap.api.maps.model.LatLng point;
    private double radius;

    /* renamed from: com.amap.api.maps.model.CircleHoleOptions$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.amap.api.maps.model.CircleHoleOptions> {
        private static com.amap.api.maps.model.CircleHoleOptions a(android.os.Parcel parcel) {
            return new com.amap.api.maps.model.CircleHoleOptions(parcel);
        }

        private static com.amap.api.maps.model.CircleHoleOptions[] a(int i) {
            return new com.amap.api.maps.model.CircleHoleOptions[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.model.CircleHoleOptions createFromParcel(android.os.Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ com.amap.api.maps.model.CircleHoleOptions[] newArray(int i) {
            return a(i);
        }
    }

    public CircleHoleOptions() {
        this.point = null;
        this.radius = 0.0d;
        this.isPolygonHoleOptions = false;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public CircleHoleOptions(android.os.Parcel parcel) {
        this.point = null;
        this.radius = 0.0d;
        android.os.Bundle readBundle = parcel.readBundle();
        this.point = new com.amap.api.maps.model.LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }

    public com.amap.api.maps.model.CircleHoleOptions center(com.amap.api.maps.model.LatLng latLng) {
        this.point = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public com.amap.api.maps.model.LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public com.amap.api.maps.model.CircleHoleOptions radius(double d) {
        this.radius = d;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        android.os.Bundle bundle = new android.os.Bundle();
        com.amap.api.maps.model.LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }
}
