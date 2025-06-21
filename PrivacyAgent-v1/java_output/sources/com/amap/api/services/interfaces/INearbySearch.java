package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface INearbySearch {
    void addNearbyListener(com.amap.api.services.nearby.NearbySearch.NearbyListener nearbyListener);

    void clearUserInfoAsyn();

    void destroy();

    void removeNearbyListener(com.amap.api.services.nearby.NearbySearch.NearbyListener nearbyListener);

    com.amap.api.services.nearby.NearbySearchResult searchNearbyInfo(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery) throws com.amap.api.services.core.AMapException;

    void searchNearbyInfoAsyn(com.amap.api.services.nearby.NearbySearch.NearbyQuery nearbyQuery);

    void setUserID(java.lang.String str);

    void startUploadNearbyInfoAuto(com.amap.api.services.nearby.UploadInfoCallback uploadInfoCallback, int i);

    void stopUploadNearbyInfoAuto();

    void uploadNearbyInfoAsyn(com.amap.api.services.nearby.UploadInfo uploadInfo);
}
