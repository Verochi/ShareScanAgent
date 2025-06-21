package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IPoiSearch {
    com.amap.api.services.poisearch.PoiSearch.SearchBound getBound();

    java.lang.String getLanguage();

    com.amap.api.services.poisearch.PoiSearch.Query getQuery();

    com.amap.api.services.poisearch.PoiResult searchPOI() throws com.amap.api.services.core.AMapException;

    void searchPOIAsyn();

    com.amap.api.services.core.PoiItem searchPOIId(java.lang.String str) throws com.amap.api.services.core.AMapException;

    void searchPOIIdAsyn(java.lang.String str);

    void setBound(com.amap.api.services.poisearch.PoiSearch.SearchBound searchBound);

    void setLanguage(java.lang.String str);

    void setOnPoiSearchListener(com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener onPoiSearchListener);

    void setQuery(com.amap.api.services.poisearch.PoiSearch.Query query);
}
