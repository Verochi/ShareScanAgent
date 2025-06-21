package com.autonavi.base.amap.api.mapcore;

/* loaded from: classes12.dex */
public interface InfoWindowCalculate {
    boolean checkInBounds();

    com.autonavi.amap.mapcore.IPoint getAnchor();

    com.amap.api.maps.model.BitmapDescriptor getBitmapDescriptor();

    com.autonavi.base.amap.mapcore.FPoint getGeoPosition();

    int getHeight();

    int getInfoWindowOffsetX();

    int getInfoWindowOffsetY();

    int getRealInfoWindowOffsetX();

    int getRealInfoWindowOffsetY();

    com.amap.api.maps.model.LatLng getRealPosition();

    android.graphics.Rect getRect();

    com.autonavi.amap.mapcore.IPoint getScreenPosition();

    int getWidth();

    boolean isContains();

    boolean isDestory();

    boolean isInfoWindowEnable();

    boolean isViewMode();

    void setInfoWindowOffset(int i, int i2) throws android.os.RemoteException;

    void setInfoWindowShown(boolean z);
}
