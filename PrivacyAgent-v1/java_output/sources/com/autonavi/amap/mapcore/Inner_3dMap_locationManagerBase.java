package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public interface Inner_3dMap_locationManagerBase {
    void destroy();

    com.autonavi.amap.mapcore.Inner_3dMap_location getLastKnownLocation();

    void setLocationListener(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener);

    void setLocationOption(com.autonavi.amap.mapcore.Inner_3dMap_locationOption inner_3dMap_locationOption);

    void startLocation();

    void stopLocation();

    void unRegisterLocationListener(com.autonavi.amap.mapcore.Inner_3dMap_locationListener inner_3dMap_locationListener);
}
