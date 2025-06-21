package com.planit.ephemeris;

/* loaded from: classes19.dex */
public class LatLng {
    public final double latitude;
    public final double longitude;

    public LatLng(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.planit.ephemeris.LatLng m93clone() {
        return new com.planit.ephemeris.LatLng(this.latitude, this.longitude);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.planit.ephemeris.LatLng latLng = (com.planit.ephemeris.LatLng) obj;
        return java.lang.Double.compare(latLng.latitude, this.latitude) == 0 && java.lang.Double.compare(latLng.longitude, this.longitude) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = java.lang.Double.doubleToLongBits(this.latitude);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = java.lang.Double.doubleToLongBits(this.longitude);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }
}
