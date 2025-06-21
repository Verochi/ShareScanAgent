package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IShareSearch {
    java.lang.String searchBusRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws com.amap.api.services.core.AMapException;

    void searchBusRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareBusRouteQuery shareBusRouteQuery);

    java.lang.String searchDrivingRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws com.amap.api.services.core.AMapException;

    void searchDrivingRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery);

    java.lang.String searchLocationShareUrl(com.amap.api.services.core.LatLonSharePoint latLonSharePoint) throws com.amap.api.services.core.AMapException;

    void searchLocationShareUrlAsyn(com.amap.api.services.core.LatLonSharePoint latLonSharePoint);

    java.lang.String searchNaviShareUrl(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery) throws com.amap.api.services.core.AMapException;

    void searchNaviShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareNaviQuery shareNaviQuery);

    java.lang.String searchPoiShareUrl(com.amap.api.services.core.PoiItem poiItem) throws com.amap.api.services.core.AMapException;

    void searchPoiShareUrlAsyn(com.amap.api.services.core.PoiItem poiItem);

    java.lang.String searchWalkRouteShareUrl(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws com.amap.api.services.core.AMapException;

    void searchWalkRouteShareUrlAsyn(com.amap.api.services.share.ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery);

    void setOnShareSearchListener(com.amap.api.services.share.ShareSearch.OnShareSearchListener onShareSearchListener);
}
