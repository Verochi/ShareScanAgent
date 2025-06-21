package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IRoutePOISearch {
    com.amap.api.services.routepoisearch.RoutePOISearchQuery getQuery();

    com.amap.api.services.routepoisearch.RoutePOISearchResult searchRoutePOI() throws com.amap.api.services.core.AMapException;

    void searchRoutePOIAsyn();

    void setQuery(com.amap.api.services.routepoisearch.RoutePOISearchQuery routePOISearchQuery);

    void setRoutePOISearchListener(com.amap.api.services.routepoisearch.RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener);
}
