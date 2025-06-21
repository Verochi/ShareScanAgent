package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IDistanceSearch {
    com.amap.api.services.route.DistanceResult calculateRouteDistance(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery) throws com.amap.api.services.core.AMapException;

    void calculateRouteDistanceAsyn(com.amap.api.services.route.DistanceSearch.DistanceQuery distanceQuery);

    void setDistanceSearchListener(com.amap.api.services.route.DistanceSearch.OnDistanceSearchListener onDistanceSearchListener);
}
