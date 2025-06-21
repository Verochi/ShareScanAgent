package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IBusStationSearch {
    com.amap.api.services.busline.BusStationQuery getQuery();

    com.amap.api.services.busline.BusStationResult searchBusStation() throws com.amap.api.services.core.AMapException;

    void searchBusStationAsyn();

    void setOnBusStationSearchListener(com.amap.api.services.busline.BusStationSearch.OnBusStationSearchListener onBusStationSearchListener);

    void setQuery(com.amap.api.services.busline.BusStationQuery busStationQuery);
}
