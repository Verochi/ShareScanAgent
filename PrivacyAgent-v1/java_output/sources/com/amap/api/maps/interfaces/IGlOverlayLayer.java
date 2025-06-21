package com.amap.api.maps.interfaces;

/* loaded from: classes12.dex */
public interface IGlOverlayLayer {
    boolean IsCircleContainPoint(com.amap.api.maps.model.CircleOptions circleOptions, com.amap.api.maps.model.LatLng latLng);

    boolean IsPolygonContainsPoint(com.amap.api.maps.model.PolygonOptions polygonOptions, com.amap.api.maps.model.LatLng latLng);

    com.amap.api.maps.model.BaseOverlay addOverlayObject(java.lang.String str, com.amap.api.maps.model.BaseOverlay baseOverlay, com.amap.api.maps.model.BaseOptions baseOptions);

    void changeOverlayIndex();

    boolean checkInBounds(java.lang.String str);

    void clear(java.lang.String... strArr);

    void clearTileCache();

    java.lang.String createId(java.lang.String str);

    void destroy();

    boolean draw(int i, int i2, boolean z);

    int getCurrentParticleNum(java.lang.String str);

    com.amap.api.maps.model.BaseOverlay getHitBaseOverlay(android.view.MotionEvent motionEvent, int i);

    com.amap.api.maps.model.BaseOverlay getHitBaseOverlay(com.amap.api.maps.model.LatLng latLng, int i);

    com.amap.api.maps.model.Polyline getHitOverlay(com.amap.api.maps.model.LatLng latLng, int i);

    com.autonavi.base.amap.api.mapcore.IAMapDelegate getMap();

    java.util.List<com.amap.api.maps.model.Marker> getMapScreenMarkers();

    void getMarkerInfoWindowOffset(java.lang.String str, com.autonavi.base.amap.mapcore.FPoint fPoint);

    com.amap.api.maps.model.MultiPointItem getMultiPointItem(com.amap.api.maps.model.LatLng latLng);

    java.lang.Object getNativeProperties(java.lang.String str, java.lang.String str2, java.lang.Object[] objArr);

    com.amap.api.maps.model.LatLng getNearestLatLng(com.amap.api.maps.model.PolylineOptions polylineOptions, com.amap.api.maps.model.LatLng latLng);

    void getOverlayScreenPos(java.lang.String str, com.autonavi.base.amap.mapcore.FPoint fPoint);

    void hideInfoWindow(java.lang.String str);

    void onCreateAMapInstance();

    boolean removeOverlay(java.lang.String str) throws android.os.RemoteException;

    boolean removeOverlay(java.lang.String str, boolean z) throws android.os.RemoteException;

    void set2Top(java.lang.String str);

    void setFlingState(boolean z);

    void setRunLowFrame(boolean z);

    void showInfoWindow(java.lang.String str);

    void updateOption(java.lang.String str, com.amap.api.maps.model.BaseOptions baseOptions);
}
