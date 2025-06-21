package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes12.dex */
public interface IAMap {
    void accelerateNetworkInChinese(boolean z);

    com.amap.api.maps.model.Arc addArc(com.amap.api.maps.model.ArcOptions arcOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.BuildingOverlay addBuildingOverlay();

    com.amap.api.maps.model.Circle addCircle(com.amap.api.maps.model.CircleOptions circleOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.CrossOverlay addCrossVector(com.amap.api.maps.model.CrossOverlayOptions crossOverlayOptions);

    com.amap.api.maps.model.GL3DModel addGLModel(com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions);

    com.amap.api.maps.model.GroundOverlay addGroundOverlay(com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.HeatMapLayer addHeatMapLayer(com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.Marker addMarker(com.amap.api.maps.model.MarkerOptions markerOptions) throws android.os.RemoteException;

    java.util.ArrayList<com.amap.api.maps.model.Marker> addMarkers(java.util.ArrayList<com.amap.api.maps.model.MarkerOptions> arrayList, boolean z) throws android.os.RemoteException;

    com.amap.api.maps.model.MultiPointOverlay addMultiPointOverlay(com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.RouteOverlay addNaviRouteOverlay();

    com.amap.api.maps.model.NavigateArrow addNavigateArrow(com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions) throws android.os.RemoteException;

    void addOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) throws android.os.RemoteException;

    void addOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws android.os.RemoteException;

    void addOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws android.os.RemoteException;

    void addOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) throws android.os.RemoteException;

    void addOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) throws android.os.RemoteException;

    void addOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) throws android.os.RemoteException;

    void addOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) throws android.os.RemoteException;

    void addOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) throws android.os.RemoteException;

    void addOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) throws android.os.RemoteException;

    void addOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws android.os.RemoteException;

    void addOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) throws android.os.RemoteException;

    void addOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) throws android.os.RemoteException;

    com.amap.api.maps.model.particle.ParticleOverlay addParticleOverlay(com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions);

    com.amap.api.maps.model.Polygon addPolygon(com.amap.api.maps.model.PolygonOptions polygonOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.Polyline addPolyline(com.amap.api.maps.model.PolylineOptions polylineOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.Text addText(com.amap.api.maps.model.TextOptions textOptions) throws android.os.RemoteException;

    com.amap.api.maps.model.TileOverlay addTileOverlay(com.amap.api.maps.model.TileOverlayOptions tileOverlayOptions) throws android.os.RemoteException;

    void animateCamera(com.amap.api.maps.CameraUpdate cameraUpdate) throws android.os.RemoteException;

    void animateCameraWithCallback(com.amap.api.maps.CameraUpdate cameraUpdate, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) throws android.os.RemoteException;

    void animateCameraWithDurationAndCallback(com.amap.api.maps.CameraUpdate cameraUpdate, long j, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) throws android.os.RemoteException;

    android.util.Pair<java.lang.Float, com.amap.api.maps.model.LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2);

    boolean canStopMapRender();

    void changeSurface(javax.microedition.khronos.opengles.GL10 gl10, int i, int i2);

    void checkMapState(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState);

    void clear() throws android.os.RemoteException;

    void clear(boolean z) throws android.os.RemoteException;

    long createGLOverlay(int i);

    void createSurface(javax.microedition.khronos.opengles.GL10 gl10, javax.microedition.khronos.egl.EGLConfig eGLConfig);

    void destroy();

    void destroySurface(int i);

    void drawFrame(javax.microedition.khronos.opengles.GL10 gl10);

    com.amap.api.maps.Projection getAMapProjection() throws android.os.RemoteException;

    com.amap.api.maps.UiSettings getAMapUiSettings() throws android.os.RemoteException;

    com.amap.api.maps.model.AMapCameraInfo getCamerInfo();

    float getCameraAngle();

    com.amap.api.maps.model.CameraPosition getCameraPosition() throws android.os.RemoteException;

    java.lang.String getCurrentWorldVectorMapStyle();

    long getGlOverlayMgrPtr();

    com.amap.api.maps.InfoWindowAnimationManager getInfoWindowAnimationManager();

    void getLatLngRect(com.autonavi.amap.mapcore.DPoint[] dPointArr);

    android.os.Handler getMainHandler();

    java.lang.String getMapContentApprovalNumber();

    int getMapHeight();

    void getMapPrintScreen(com.amap.api.maps.AMap.onMapPrintScreenListener onmapprintscreenlistener);

    java.util.List<com.amap.api.maps.model.Marker> getMapScreenMarkers() throws android.os.RemoteException;

    void getMapScreenShot(com.amap.api.maps.AMap.OnMapScreenShotListener onMapScreenShotListener);

    int getMapTextZIndex() throws android.os.RemoteException;

    int getMapType() throws android.os.RemoteException;

    int getMapWidth();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    android.location.Location getMyLocation() throws android.os.RemoteException;

    com.amap.api.maps.model.MyLocationStyle getMyLocationStyle() throws android.os.RemoteException;

    int getNativeEngineID();

    long getNativeMapController();

    float[] getProjectionMatrix();

    int getRenderMode();

    int getSX();

    int getSY();

    java.lang.String getSatelliteImageApprovalNumber();

    float getScalePerPixel() throws android.os.RemoteException;

    float getSkyHeight();

    java.lang.String getTerrainApprovalNumber();

    android.view.View getView() throws android.os.RemoteException;

    float[] getViewMatrix();

    java.lang.String getWorldVectorMapLanguage();

    java.lang.String getWorldVectorMapStyle();

    float getZoomToSpanLevel(com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2);

    boolean isIndoorEnabled() throws android.os.RemoteException;

    boolean isMaploaded();

    boolean isMyLocationEnabled() throws android.os.RemoteException;

    boolean isTouchPoiEnable();

    boolean isTrafficEnabled() throws android.os.RemoteException;

    void loadWorldVectorMap(boolean z);

    void moveCamera(com.amap.api.maps.CameraUpdate cameraUpdate) throws android.os.RemoteException;

    void onActivityPause();

    void onActivityResume();

    void onChangeFinish();

    void onFling();

    void onIndoorBuildingActivity(int i, byte[] bArr);

    boolean onTouchEvent(android.view.MotionEvent motionEvent);

    void queueEvent(java.lang.Runnable runnable);

    void reloadMap();

    void removeOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) throws android.os.RemoteException;

    void removeOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws android.os.RemoteException;

    void removeOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws android.os.RemoteException;

    void removeOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) throws android.os.RemoteException;

    void removeOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) throws android.os.RemoteException;

    void removeOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) throws android.os.RemoteException;

    void removeOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) throws android.os.RemoteException;

    void removeOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) throws android.os.RemoteException;

    void removeOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) throws android.os.RemoteException;

    void removeOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws android.os.RemoteException;

    void removeOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) throws android.os.RemoteException;

    void removeOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) throws android.os.RemoteException;

    void removecache() throws android.os.RemoteException;

    void removecache(com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener) throws android.os.RemoteException;

    void renderSurface(javax.microedition.khronos.opengles.GL10 gl10);

    void requestRender();

    void resetMinMaxZoomPreference();

    void resetRenderTime();

    void set3DBuildingEnabled(boolean z) throws android.os.RemoteException;

    void setAMapGestureListener(com.amap.api.maps.model.AMapGestureListener aMapGestureListener);

    void setCenterToPixel(int i, int i2) throws android.os.RemoteException;

    void setConstructingRoadEnable(boolean z) throws android.os.RemoteException;

    void setCustomMapStyle(com.amap.api.maps.model.CustomMapStyleOptions customMapStyleOptions);

    void setCustomMapStyleID(java.lang.String str);

    void setCustomMapStylePath(java.lang.String str);

    void setCustomRenderer(com.amap.api.maps.CustomRenderer customRenderer) throws android.os.RemoteException;

    void setCustomTextureResourcePath(java.lang.String str);

    void setIndoorBuildingInfo(com.amap.api.maps.model.IndoorBuildingInfo indoorBuildingInfo) throws android.os.RemoteException;

    void setIndoorEnabled(boolean z) throws android.os.RemoteException;

    void setInfoWindowAdapter(com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws android.os.RemoteException;

    void setInfoWindowAdapter(com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter) throws android.os.RemoteException;

    void setLoadOfflineData(boolean z) throws android.os.RemoteException;

    void setLocationSource(com.amap.api.maps.LocationSource locationSource) throws android.os.RemoteException;

    void setMapCustomEnable(boolean z);

    void setMapLanguage(java.lang.String str);

    void setMapStatusLimits(com.amap.api.maps.model.LatLngBounds latLngBounds);

    void setMapTextEnable(boolean z) throws android.os.RemoteException;

    void setMapTextZIndex(int i) throws android.os.RemoteException;

    void setMapType(int i) throws android.os.RemoteException;

    void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j);

    void setMaxZoomLevel(float f);

    void setMinZoomLevel(float f);

    void setMyLocationEnabled(boolean z) throws android.os.RemoteException;

    void setMyLocationRotateAngle(float f) throws android.os.RemoteException;

    void setMyLocationStyle(com.amap.api.maps.model.MyLocationStyle myLocationStyle) throws android.os.RemoteException;

    void setMyLocationType(int i) throws android.os.RemoteException;

    void setNaviLabelEnable(boolean z, int i, int i2) throws android.os.RemoteException;

    void setOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) throws android.os.RemoteException;

    void setOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws android.os.RemoteException;

    void setOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws android.os.RemoteException;

    void setOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) throws android.os.RemoteException;

    void setOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) throws android.os.RemoteException;

    void setOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) throws android.os.RemoteException;

    void setOnMaploadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) throws android.os.RemoteException;

    void setOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) throws android.os.RemoteException;

    void setOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) throws android.os.RemoteException;

    void setOnMultiPointClickListener(com.amap.api.maps.AMap.OnMultiPointClickListener onMultiPointClickListener);

    void setOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws android.os.RemoteException;

    void setOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) throws android.os.RemoteException;

    void setOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) throws android.os.RemoteException;

    void setRenderFps(int i);

    void setRenderMode(int i);

    void setRoadArrowEnable(boolean z) throws android.os.RemoteException;

    void setRunLowFrame(boolean z);

    void setTouchPoiEnable(boolean z);

    void setTrafficEnabled(boolean z) throws android.os.RemoteException;

    void setTrafficStyleWithTextureData(byte[] bArr);

    void setVisibilityEx(int i);

    void setWorldVectorMapStyle(java.lang.String str);

    void setZOrderOnTop(boolean z) throws android.os.RemoteException;

    void setZoomScaleParam(float f);

    void stopAnimation() throws android.os.RemoteException;
}
