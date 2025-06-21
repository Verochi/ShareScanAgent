package com.amap.api.services.geocoder;

/* loaded from: classes12.dex */
public final class GeocodeSearch {
    public static final java.lang.String AMAP = "autonavi";
    public static final java.lang.String EXTENSIONS_ALL = "all";
    public static final java.lang.String EXTENSIONS_BASE = "base";
    public static final java.lang.String GPS = "gps";
    private com.amap.api.services.interfaces.IGeocodeSearch a;

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(com.amap.api.services.geocoder.GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(com.amap.api.services.geocoder.RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(android.content.Context context) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.az(context);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public final com.amap.api.services.geocoder.RegeocodeAddress getFromLocation(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            return iGeocodeSearch.getFromLocation(regeocodeQuery);
        }
        return null;
    }

    public final void getFromLocationAsyn(com.amap.api.services.geocoder.RegeocodeQuery regeocodeQuery) {
        com.amap.api.services.interfaces.IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.getFromLocationAsyn(regeocodeQuery);
        }
    }

    public final java.util.List<com.amap.api.services.geocoder.GeocodeAddress> getFromLocationName(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            return iGeocodeSearch.getFromLocationName(geocodeQuery);
        }
        return null;
    }

    public final void getFromLocationNameAsyn(com.amap.api.services.geocoder.GeocodeQuery geocodeQuery) {
        com.amap.api.services.interfaces.IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.getFromLocationNameAsyn(geocodeQuery);
        }
    }

    public final void setOnGeocodeSearchListener(com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        com.amap.api.services.interfaces.IGeocodeSearch iGeocodeSearch = this.a;
        if (iGeocodeSearch != null) {
            iGeocodeSearch.setOnGeocodeSearchListener(onGeocodeSearchListener);
        }
    }
}
