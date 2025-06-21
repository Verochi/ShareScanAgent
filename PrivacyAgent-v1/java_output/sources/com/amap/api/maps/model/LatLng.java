package com.amap.api.maps.model;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public final class LatLng implements android.os.Parcelable, java.lang.Cloneable {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public static final com.amap.api.maps.model.LatLngCreator CREATOR = new com.amap.api.maps.model.LatLngCreator();
    public final double latitude;
    public final double longitude;

    public LatLng(double d, double d2) {
        this(d, d2, true);
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingExclude
    public LatLng(double d, double d2, boolean z) {
        if (!z) {
            this.latitude = d;
            this.longitude = d2;
            return;
        }
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.longitude = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.longitude = d2;
        }
        if (d < -90.0d || d > 90.0d) {
            try {
                throw new com.amap.api.maps.AMapException(com.amap.api.maps.AMapException.ERROR_ILLEGAL_VALUE);
            } catch (com.amap.api.maps.AMapException e) {
                e.printStackTrace();
            }
        }
        this.latitude = java.lang.Math.max(-90.0d, java.lang.Math.min(90.0d, d));
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.LatLng m20clone() {
        return new com.amap.api.maps.model.LatLng(this.latitude, this.longitude);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.amap.api.maps.model.LatLng)) {
            return false;
        }
        com.amap.api.maps.model.LatLng latLng = (com.amap.api.maps.model.LatLng) obj;
        return java.lang.Double.doubleToLongBits(this.latitude) == java.lang.Double.doubleToLongBits(latLng.latitude) && java.lang.Double.doubleToLongBits(this.longitude) == java.lang.Double.doubleToLongBits(latLng.longitude);
    }

    public final int hashCode() {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(this.latitude);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = java.lang.Double.doubleToLongBits(this.longitude);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public final java.lang.String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
    }
}
