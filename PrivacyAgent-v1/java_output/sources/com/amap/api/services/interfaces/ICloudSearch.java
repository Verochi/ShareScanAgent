package com.amap.api.services.interfaces;

/* loaded from: classes12.dex */
public interface ICloudSearch {
    void searchCloudAsyn(com.amap.api.services.cloud.CloudSearch.Query query);

    void searchCloudDetailAsyn(java.lang.String str, java.lang.String str2);

    void setOnCloudSearchListener(com.amap.api.services.cloud.CloudSearch.OnCloudSearchListener onCloudSearchListener);
}
