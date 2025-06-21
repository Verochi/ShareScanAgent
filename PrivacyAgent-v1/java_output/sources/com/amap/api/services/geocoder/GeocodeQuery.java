package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public class GeocodeQuery {
    private java.lang.String a;
    private java.lang.String b;
    private java.lang.String c;

    public GeocodeQuery(java.lang.String str, java.lang.String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.amap.api.services.geocoder.GeocodeQuery geocodeQuery = (com.amap.api.services.geocoder.GeocodeQuery) obj;
        java.lang.String str = this.b;
        if (str == null) {
            if (geocodeQuery.b != null) {
                return false;
            }
        } else if (!str.equals(geocodeQuery.b)) {
            return false;
        }
        java.lang.String str2 = this.a;
        if (str2 == null) {
            if (geocodeQuery.a != null) {
                return false;
            }
        } else if (!str2.equals(geocodeQuery.a)) {
            return false;
        }
        return true;
    }

    public java.lang.String getCity() {
        return this.b;
    }

    public java.lang.String getCountry() {
        return this.c;
    }

    public java.lang.String getLocationName() {
        return this.a;
    }

    public int hashCode() {
        java.lang.String str = this.b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        java.lang.String str2 = this.a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(java.lang.String str) {
        this.b = str;
    }

    public void setCountry(java.lang.String str) {
        this.c = str;
    }

    public void setLocationName(java.lang.String str) {
        this.a = str;
    }
}
