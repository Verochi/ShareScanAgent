package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public class RegeocodeQuery {
    private com.amap.api.services.core.LatLonPoint a;
    private float b;
    private java.lang.String c = com.amap.api.services.geocoder.GeocodeSearch.AMAP;
    private java.lang.String d = "";
    private java.lang.String e = "distance";
    private java.lang.String f = "base";

    public RegeocodeQuery(com.amap.api.services.core.LatLonPoint latLonPoint, float f, java.lang.String str) {
        this.a = latLonPoint;
        this.b = f;
        setLatLonType(str);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery = (com.amap.api.services.geocoder.RegeocodeQuery) obj;
        java.lang.String str = this.c;
        if (str == null) {
            if (regeocodeQuery.c != null) {
                return false;
            }
        } else if (!str.equals(regeocodeQuery.c)) {
            return false;
        }
        com.amap.api.services.core.LatLonPoint latLonPoint = this.a;
        if (latLonPoint == null) {
            if (regeocodeQuery.a != null) {
                return false;
            }
        } else if (!latLonPoint.equals(regeocodeQuery.a)) {
            return false;
        }
        if (java.lang.Float.floatToIntBits(this.b) != java.lang.Float.floatToIntBits(regeocodeQuery.b) || !this.e.equals(regeocodeQuery.e)) {
            return false;
        }
        java.lang.String str2 = this.f;
        if (str2 == null) {
            if (regeocodeQuery.f != null) {
                return false;
            }
        } else if (!str2.equals(regeocodeQuery.f)) {
            return false;
        }
        return true;
    }

    public java.lang.String getExtensions() {
        return this.f;
    }

    public java.lang.String getLatLonType() {
        return this.c;
    }

    public java.lang.String getMode() {
        return this.e;
    }

    public java.lang.String getPoiType() {
        return this.d;
    }

    public com.amap.api.services.core.LatLonPoint getPoint() {
        return this.a;
    }

    public float getRadius() {
        return this.b;
    }

    public int hashCode() {
        java.lang.String str = this.c;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        com.amap.api.services.core.LatLonPoint latLonPoint = this.a;
        return ((hashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + java.lang.Float.floatToIntBits(this.b);
    }

    public void setExtensions(java.lang.String str) {
        this.f = str;
    }

    public void setLatLonType(java.lang.String str) {
        if (str != null) {
            if (str.equals(com.amap.api.services.geocoder.GeocodeSearch.AMAP) || str.equals(com.amap.api.services.geocoder.GeocodeSearch.GPS)) {
                this.c = str;
            }
        }
    }

    public void setMode(java.lang.String str) {
        this.e = str;
    }

    public void setPoiType(java.lang.String str) {
        this.d = str;
    }

    public void setPoint(com.amap.api.services.core.LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public void setRadius(float f) {
        this.b = f;
    }
}
