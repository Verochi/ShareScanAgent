package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes12.dex */
public interface IProjection {
    float calculateMapZoomer(com.amap.api.maps.model.LatLng latLng, int i);

    com.amap.api.maps.model.TileProjection fromBoundsToTile(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2) throws android.os.RemoteException;

    com.amap.api.maps.model.LatLng fromScreenLocation(android.graphics.Point point) throws android.os.RemoteException;

    com.amap.api.maps.model.AMapCameraInfo getCameraInfo();

    com.amap.api.maps.model.LatLngBounds getMapBounds(com.amap.api.maps.model.LatLng latLng, float f) throws android.os.RemoteException;

    com.amap.api.maps.model.VisibleRegion getVisibleRegion() throws android.os.RemoteException;

    float toMapLenWithWin(int i) throws android.os.RemoteException;

    android.graphics.PointF toMapLocation(com.amap.api.maps.model.LatLng latLng) throws android.os.RemoteException;

    android.graphics.Point toScreenLocation(com.amap.api.maps.model.LatLng latLng) throws android.os.RemoteException;
}
