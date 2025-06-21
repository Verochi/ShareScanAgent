package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public class RegeocodeResult {
    private com.amap.api.services.geocoder.RegeocodeQuery a;
    private com.amap.api.services.geocoder.RegeocodeAddress b;

    public RegeocodeResult(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery, com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) {
        this.a = regeocodeQuery;
        this.b = regeocodeAddress;
    }

    public com.amap.api.services.geocoder.RegeocodeAddress getRegeocodeAddress() {
        return this.b;
    }

    public com.amap.api.services.geocoder.RegeocodeQuery getRegeocodeQuery() {
        return this.a;
    }

    public void setRegeocodeAddress(com.amap.api.services.geocoder.RegeocodeAddress regeocodeAddress) {
        this.b = regeocodeAddress;
    }

    public void setRegeocodeQuery(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) {
        this.a = regeocodeQuery;
    }
}
