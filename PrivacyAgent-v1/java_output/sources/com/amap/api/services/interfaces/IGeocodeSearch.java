package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IGeocodeSearch {
    com.amap.api.services.geocoder.RegeocodeAddress getFromLocation(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) throws com.amap.api.services.core.AMapException;

    void getFromLocationAsyn(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery);

    java.util.List<com.amap.api.services.geocoder.GeocodeAddress> getFromLocationName(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) throws com.amap.api.services.core.AMapException;

    void getFromLocationNameAsyn(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery);

    void setOnGeocodeSearchListener(com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener);
}
