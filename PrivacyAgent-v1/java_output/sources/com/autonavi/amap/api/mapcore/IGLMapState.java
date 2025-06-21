package com.autonavi.amap.api.mapcore;

/* loaded from: classes12.dex */
public interface IGLMapState {
    float calculateMapZoomer(int i, int i2, int i3, int i4, int i5);

    float getCameraDegree();

    float getMapAngle();

    com.autonavi.amap.mapcore.DPoint getMapGeoCenter();

    void getMapGeoCenter(com.autonavi.amap.mapcore.IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i, int i2, android.graphics.Point point);

    void setCameraDegree(float f);

    void setMapAngle(float f);

    void setMapGeoCenter(double d, double d2);

    void setMapZoomer(float f);
}
