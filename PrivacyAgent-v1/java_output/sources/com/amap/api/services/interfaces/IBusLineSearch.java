package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IBusLineSearch {
    com.amap.api.services.busline.BusLineQuery getQuery();

    com.amap.api.services.busline.BusLineResult searchBusLine() throws com.amap.api.services.core.AMapException;

    void searchBusLineAsyn();

    void setOnBusLineSearchListener(com.amap.api.services.busline.BusLineSearch.OnBusLineSearchListener onBusLineSearchListener);

    void setQuery(com.amap.api.services.busline.BusLineQuery busLineQuery);
}
