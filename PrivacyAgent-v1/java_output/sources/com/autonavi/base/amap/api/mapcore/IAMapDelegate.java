package com.autonavi.base.amap.api.mapcore;

/* loaded from: classes12.dex */
public interface IAMapDelegate extends com.autonavi.amap.mapcore.interfaces.IAMap {
    void addGestureMapMessage(int i, com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage abstractGestureMapMessage);

    void addOverlayTexture(int i, com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty gLTextureProperty);

    void animateCamera(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws android.os.RemoteException;

    void animateCameraWithDurationAndCallback(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j, com.amap.api.maps.AMap.CancelableCallback cancelableCallback);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(java.lang.String str, boolean z, int i);

    void changeMapLogo(int i, boolean z);

    void changeSize(int i, int i2);

    void changeSurface(int i, javax.microedition.khronos.opengles.GL10 gl10, int i2, int i3);

    float checkZoomLevel(float f) throws android.os.RemoteException;

    void clearTileCache();

    java.lang.String createId(java.lang.String str);

    void createSurface(int i, javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig);

    void geo2Latlng(int i, int i2, com.autonavi.amap.mapcore.DPoint dPoint);

    void geo2Map(int i, int i2, com.autonavi.base.amap.mapcore.FPoint fPoint);

    com.autonavi.extra.b getAMapExtraInterfaceManager();

    float getCameraDegree(int i);

    com.amap.api.maps.model.CameraPosition getCameraPositionPrj(boolean z);

    android.content.Context getContext();

    com.amap.api.mapcore.util.a getCustomStyleManager();

    int getEngineIDWithGestureInfo(com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    float[] getFinalMatrix();

    com.autonavi.base.ae.gmap.GLMapEngine getGLMapEngine();

    android.view.View getGLMapView();

    void getGeoCenter(int i, com.autonavi.amap.mapcore.IPoint iPoint);

    com.amap.api.maps.interfaces.IGlOverlayLayer getGlOverlayLayer();

    com.amap.api.mapcore.util.aj getInfoWindowDelegate();

    void getLatLng2Map(double d, double d2, com.autonavi.base.amap.mapcore.FPoint fPoint);

    void getLatLng2Pixel(double d, double d2, com.autonavi.amap.mapcore.IPoint iPoint);

    float getLogoMarginRate(int i);

    int getLogoPosition();

    float getMapAngle(int i);

    com.amap.api.maps.model.LatLngBounds getMapBounds(com.amap.api.maps.model.LatLng latLng, float f, float f2, float f3);

    com.autonavi.base.amap.mapcore.MapConfig getMapConfig();

    com.autonavi.base.ae.gmap.GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    com.amap.api.maps.AMap.OnCameraChangeListener getOnCameraChangeListener() throws android.os.RemoteException;

    void getPixel2Geo(int i, int i2, com.autonavi.amap.mapcore.IPoint iPoint);

    void getPixel2LatLng(int i, int i2, com.autonavi.amap.mapcore.DPoint dPoint);

    float getPreciseLevel(int i);

    com.autonavi.base.amap.api.mapcore.IProjectionDelegate getProjection() throws android.os.RemoteException;

    android.graphics.Rect getRect();

    com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int i);

    android.graphics.Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int i);

    boolean isLockMapCameraDegree(int i);

    boolean isUseAnchor();

    void latlon2Geo(double d, double d2, com.autonavi.amap.mapcore.IPoint iPoint);

    void map2Geo(float f, float f2, com.autonavi.amap.mapcore.IPoint iPoint);

    void moveCamera(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws android.os.RemoteException;

    boolean onDoubleTap(int i, android.view.MotionEvent motionEvent);

    void onLongPress(int i, android.view.MotionEvent motionEvent);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int i, android.view.MotionEvent motionEvent);

    void pixel2Map(int i, int i2, android.graphics.PointF pointF);

    void post(java.lang.Runnable runnable);

    void redrawInfoWindow();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay baseMapOverlay);

    boolean removeGLModel(java.lang.String str);

    boolean removeGLOverlay(java.lang.String str) throws android.os.RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean z, byte[] bArr);

    void setGestureStatus(int i, int i2);

    void setHideLogoEnble(boolean z);

    void setLogoBottomMargin(int i);

    void setLogoLeftMargin(int i);

    void setLogoMarginRate(int i, float f);

    void setLogoPosition(int i);

    void setMapCustomEnable(boolean z, boolean z2);

    void setMapEnable(boolean z);

    void setMapWidgetListener(com.autonavi.base.ae.gmap.listener.AMapWidgetListener aMapWidgetListener);

    void setZoomPosition(int i);

    void showCompassEnabled(boolean z);

    void showIndoorSwitchControlsEnabled(boolean z);

    void showInfoWindow(com.amap.api.maps.model.BaseOverlay baseOverlay) throws android.os.RemoteException;

    void showInfoWindow(com.autonavi.base.amap.api.mapcore.BaseOverlayImp baseOverlayImp) throws android.os.RemoteException;

    void showLogoEnabled(boolean z);

    void showMyLocationButtonEnabled(boolean z);

    void showMyLocationOverlay(android.location.Location location) throws android.os.RemoteException;

    void showScaleEnabled(boolean z);

    void showZoomControlsEnabled(boolean z);

    float toMapLenWithWin(int i);

    void zoomOut(int i);
}
