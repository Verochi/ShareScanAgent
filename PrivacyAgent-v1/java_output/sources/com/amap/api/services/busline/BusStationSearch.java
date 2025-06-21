package com.amap.api.services.busline;

/* loaded from: classes12.dex */
public class BusStationSearch {
    private com.amap.api.services.interfaces.IBusStationSearch a;

    public interface OnBusStationSearchListener {
        void onBusStationSearched(com.amap.api.services.busline.BusStationResult busStationResult, int i);
    }

    public BusStationSearch(android.content.Context context, com.amap.api.services.busline.BusStationQuery busStationQuery) throws com.amap.api.services.core.AMapException {
        if (this.a == null) {
            try {
                this.a = new com.amap.api.col.s.av(context, busStationQuery);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                if (e instanceof com.amap.api.services.core.AMapException) {
                    throw ((com.amap.api.services.core.AMapException) e);
                }
            }
        }
    }

    public com.amap.api.services.busline.BusStationQuery getQuery() {
        com.amap.api.services.interfaces.IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.getQuery();
        }
        return null;
    }

    public com.amap.api.services.busline.BusStationResult searchBusStation() throws com.amap.api.services.core.AMapException {
        com.amap.api.services.interfaces.IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            return iBusStationSearch.searchBusStation();
        }
        return null;
    }

    public void searchBusStationAsyn() {
        com.amap.api.services.interfaces.IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.searchBusStationAsyn();
        }
    }

    public void setOnBusStationSearchListener(com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        com.amap.api.services.interfaces.IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setOnBusStationSearchListener(onBusStationSearchListener);
        }
    }

    public void setQuery(com.amap.api.services.busline.BusStationQuery busStationQuery) {
        com.amap.api.services.interfaces.IBusStationSearch iBusStationSearch = this.a;
        if (iBusStationSearch != null) {
            iBusStationSearch.setQuery(busStationQuery);
        }
    }
}
