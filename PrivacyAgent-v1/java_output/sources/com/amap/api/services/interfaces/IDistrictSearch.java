package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface IDistrictSearch {
    com.amap.api.services.district.DistrictSearchQuery getQuery();

    com.amap.api.services.district.DistrictResult searchDistrict() throws com.amap.api.services.core.AMapException;

    void searchDistrictAnsy();

    void searchDistrictAsyn();

    void setOnDistrictSearchListener(com.amap.api.services.district.DistrictSearch.OnDistrictSearchListener onDistrictSearchListener);

    void setQuery(com.amap.api.services.district.DistrictSearchQuery districtSearchQuery);
}
