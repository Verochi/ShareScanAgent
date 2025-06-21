package com.autonavi.amap.api.mapcore;

/* loaded from: classes12.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int i, int i2, float f, int i3, int i4, int i5, int i6, com.amap.api.maps.AMap.CancelableCallback cancelableCallback);

    com.autonavi.amap.api.mapcore.IGLMapState getNewMapState(int i);
}
