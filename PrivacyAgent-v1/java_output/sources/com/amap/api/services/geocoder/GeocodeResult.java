package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public class GeocodeResult {
    private com.amap.api.services.geocoder.GeocodeQuery a;
    private java.util.List<com.amap.api.services.geocoder.GeocodeAddress> b;

    public GeocodeResult(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery, java.util.List<com.amap.api.services.geocoder.GeocodeAddress> list) {
        new java.util.ArrayList();
        this.a = geocodeQuery;
        this.b = list;
    }

    public java.util.List<com.amap.api.services.geocoder.GeocodeAddress> getGeocodeAddressList() {
        return this.b;
    }

    public com.amap.api.services.geocoder.GeocodeQuery getGeocodeQuery() {
        return this.a;
    }

    public void setGeocodeAddressList(java.util.List<com.amap.api.services.geocoder.GeocodeAddress> list) {
        this.b = list;
    }

    public void setGeocodeQuery(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) {
        this.a = geocodeQuery;
    }
}
