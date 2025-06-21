package com.amap.api.maps;

/* loaded from: classes12.dex */
public final class AMap {
    public static final java.lang.String CHINESE = "zh_cn";
    private static final java.lang.String CLASSNAME = "AMap";
    public static final java.lang.String CUSTOM = "custom";
    public static final java.lang.String ENGLISH = "en";
    public static final java.lang.String LOCAL = "local";
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_BUS = 5;
    public static final int MAP_TYPE_NAVI = 4;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MASK_LAYER_NONE = -1;
    public static final int MASK_LAYER_UNDER_LINE = 1;
    public static final int MASK_LAYER_UNDER_MARKER = 0;
    public static final java.lang.String STYLE_CHINESE = "style_zh_cn";
    private final com.autonavi.amap.mapcore.interfaces.IAMap mapDelegate;
    private com.amap.api.maps.model.MyTrafficStyle myTrafficStyle;
    private com.amap.api.maps.Projection projection;
    private com.amap.api.maps.UiSettings uiSettings;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface CommonInfoWindowAdapter {
        com.amap.api.maps.InfoWindowParams getInfoWindowParams(com.amap.api.maps.model.BasePointOverlay basePointOverlay);
    }

    public interface ImageInfoWindowAdapter extends com.amap.api.maps.AMap.InfoWindowAdapter {
        long getInfoWindowUpdateTime();
    }

    public interface InfoWindowAdapter {
        android.view.View getInfoContents(com.amap.api.maps.model.Marker marker);

        android.view.View getInfoWindow(com.amap.api.maps.model.Marker marker);
    }

    public interface MultiPositionInfoWindowAdapter extends com.amap.api.maps.AMap.InfoWindowAdapter {
        android.view.View getInfoWindowClick(com.amap.api.maps.model.Marker marker);

        android.view.View getOverturnInfoWindow(com.amap.api.maps.model.Marker marker);

        android.view.View getOverturnInfoWindowClick(com.amap.api.maps.model.Marker marker);
    }

    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(com.amap.api.maps.model.CameraPosition cameraPosition);

        void onCameraChangeFinish(com.amap.api.maps.model.CameraPosition cameraPosition);
    }

    public interface OnIndoorBuildingActiveListener {
        void OnIndoorBuilding(com.amap.api.maps.model.IndoorBuildingInfo indoorBuildingInfo);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(com.amap.api.maps.model.Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(com.amap.api.maps.model.LatLng latLng);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(com.amap.api.maps.model.LatLng latLng);
    }

    public interface OnMapScreenShotListener {
        void onMapScreenShot(android.graphics.Bitmap bitmap);

        void onMapScreenShot(android.graphics.Bitmap bitmap, int i);
    }

    public interface OnMapTouchListener {
        void onTouch(android.view.MotionEvent motionEvent);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(com.amap.api.maps.model.Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(com.amap.api.maps.model.Marker marker);

        void onMarkerDragEnd(com.amap.api.maps.model.Marker marker);

        void onMarkerDragStart(com.amap.api.maps.model.Marker marker);
    }

    public interface OnMultiPointClickListener {
        boolean onPointClick(com.amap.api.maps.model.MultiPointItem multiPointItem);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(android.location.Location location);
    }

    public interface OnPOIClickListener {
        void onPOIClick(com.amap.api.maps.model.Poi poi);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(com.amap.api.maps.model.Polyline polyline);
    }

    public interface onMapPrintScreenListener {
        void onMapPrint(android.graphics.drawable.Drawable drawable);
    }

    public AMap(com.autonavi.amap.mapcore.interfaces.IAMap iAMap) {
        this.mapDelegate = iAMap;
    }

    @java.lang.Deprecated
    public static java.lang.String getVersion() {
        return "9.1.0";
    }

    public final void accelerateNetworkInChinese(boolean z) {
        try {
            com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.mapDelegate;
            if (iAMap != null) {
                iAMap.accelerateNetworkInChinese(z);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final com.amap.api.maps.model.Arc addArc(com.amap.api.maps.model.ArcOptions arcOptions) {
        try {
            return this.mapDelegate.addArc(arcOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.BuildingOverlay addBuildingOverlay() {
        try {
            return this.mapDelegate.addBuildingOverlay();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.Circle addCircle(com.amap.api.maps.model.CircleOptions circleOptions) {
        try {
            return this.mapDelegate.addCircle(circleOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.CrossOverlay addCrossOverlay(com.amap.api.maps.model.CrossOverlayOptions crossOverlayOptions) {
        try {
            return this.mapDelegate.addCrossVector(crossOverlayOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.GL3DModel addGL3DModel(com.amap.api.maps.model.GL3DModelOptions gL3DModelOptions) {
        try {
            return this.mapDelegate.addGLModel(gL3DModelOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.GroundOverlay addGroundOverlay(com.amap.api.maps.model.GroundOverlayOptions groundOverlayOptions) {
        try {
            return this.mapDelegate.addGroundOverlay(groundOverlayOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.HeatMapLayer addHeatMapLayer(com.amap.api.maps.model.HeatMapLayerOptions heatMapLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapLayer(heatMapLayerOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.Marker addMarker(com.amap.api.maps.model.MarkerOptions markerOptions) {
        try {
            return this.mapDelegate.addMarker(markerOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final java.util.ArrayList<com.amap.api.maps.model.Marker> addMarkers(java.util.ArrayList<com.amap.api.maps.model.MarkerOptions> arrayList, boolean z) {
        try {
            return this.mapDelegate.addMarkers(arrayList, z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.MultiPointOverlay addMultiPointOverlay(com.amap.api.maps.model.MultiPointOverlayOptions multiPointOverlayOptions) {
        try {
            return this.mapDelegate.addMultiPointOverlay(multiPointOverlayOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.NavigateArrow addNavigateArrow(com.amap.api.maps.model.NavigateArrowOptions navigateArrowOptions) {
        try {
            return this.mapDelegate.addNavigateArrow(navigateArrowOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void addOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.addOnCameraChangeListener(onCameraChangeListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.addOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.addOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.addOnMapClickListener(onMapClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.addOnMapLoadedListener(onMapLoadedListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.addOnMapLongClickListener(onMapLongClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.addOnMapTouchListener(onMapTouchListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.addOnMarkerClickListener(onMarkerClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.addOnMarkerDragListener(onMarkerDragListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.addOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.addOnPOIClickListener(onPOIClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void addOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.addOnPolylineClickListener(onPolylineClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final com.amap.api.maps.model.particle.ParticleOverlay addParticleOverlay(com.amap.api.maps.model.particle.ParticleOverlayOptions particleOverlayOptions) {
        try {
            return this.mapDelegate.addParticleOverlay(particleOverlayOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.Polygon addPolygon(com.amap.api.maps.model.PolygonOptions polygonOptions) {
        try {
            return this.mapDelegate.addPolygon(polygonOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.Polyline addPolyline(com.amap.api.maps.model.PolylineOptions polylineOptions) {
        try {
            return this.mapDelegate.addPolyline(polylineOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.RouteOverlay addRouteOverlay() {
        return this.mapDelegate.addNaviRouteOverlay();
    }

    public final com.amap.api.maps.model.Text addText(com.amap.api.maps.model.TextOptions textOptions) {
        try {
            return this.mapDelegate.addText(textOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.TileOverlay addTileOverlay(com.amap.api.maps.model.TileOverlayOptions tileOverlayOptions) {
        try {
            return this.mapDelegate.addTileOverlay(tileOverlayOptions);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void animateCamera(com.amap.api.maps.CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.animateCamera(cameraUpdate);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void animateCamera(com.amap.api.maps.CameraUpdate cameraUpdate, long j, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        try {
            this.mapDelegate.animateCameraWithDurationAndCallback(cameraUpdate, j, cancelableCallback);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void animateCamera(com.amap.api.maps.CameraUpdate cameraUpdate, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        try {
            this.mapDelegate.animateCameraWithCallback(cameraUpdate, cancelableCallback);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final android.util.Pair<java.lang.Float, com.amap.api.maps.model.LatLng> calculateZoomToSpanLevel(int i, int i2, int i3, int i4, com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2) {
        return this.mapDelegate.calculateZoomToSpanLevel(i, i2, i3, i4, latLng, latLng2);
    }

    public final void clear() {
        try {
            this.mapDelegate.clear();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void clear(boolean z) {
        try {
            this.mapDelegate.clear(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final com.amap.api.maps.model.CameraPosition getCameraPosition() {
        try {
            return this.mapDelegate.getCameraPosition();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final java.lang.String getCurrentStyle() {
        try {
            com.autonavi.amap.mapcore.interfaces.IAMap iAMap = this.mapDelegate;
            return iAMap != null ? iAMap.getCurrentWorldVectorMapStyle() : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public final com.amap.api.maps.InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return this.mapDelegate.getInfoWindowAnimationManager();
    }

    public final java.lang.String getMapContentApprovalNumber() {
        try {
            return this.mapDelegate.getMapContentApprovalNumber();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void getMapPrintScreen(com.amap.api.maps.AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        this.mapDelegate.getMapPrintScreen(onmapprintscreenlistener);
    }

    public final java.util.List<com.amap.api.maps.model.Marker> getMapScreenMarkers() {
        try {
            java.util.List<com.amap.api.maps.model.Marker> mapScreenMarkers = this.mapDelegate.getMapScreenMarkers();
            return mapScreenMarkers == null ? new java.util.ArrayList() : mapScreenMarkers;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void getMapScreenShot(com.amap.api.maps.AMap.OnMapScreenShotListener onMapScreenShotListener) {
        this.mapDelegate.getMapScreenShot(onMapScreenShotListener);
    }

    public final int getMapTextZIndex() {
        try {
            return this.mapDelegate.getMapTextZIndex();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getMapType() {
        try {
            return this.mapDelegate.getMapType();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    public final float getMaxZoomLevel() {
        return this.mapDelegate.getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return this.mapDelegate.getMinZoomLevel();
    }

    public final android.location.Location getMyLocation() {
        try {
            return this.mapDelegate.getMyLocation();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.MyLocationStyle getMyLocationStyle() {
        try {
            return this.mapDelegate.getMyLocationStyle();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.model.MyTrafficStyle getMyTrafficStyle() {
        return this.myTrafficStyle;
    }

    public final long getNativeMapController() {
        try {
            return this.mapDelegate.getNativeMapController();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public final int getNativeMapEngineID() {
        try {
            return this.mapDelegate.getNativeEngineID();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final void getP20MapCenter(com.autonavi.amap.mapcore.IPoint iPoint) {
        if (iPoint == null) {
            try {
                iPoint = new com.autonavi.amap.mapcore.IPoint();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        ((android.graphics.Point) iPoint).x = this.mapDelegate.getSX();
        ((android.graphics.Point) iPoint).y = this.mapDelegate.getSY();
    }

    public final com.amap.api.maps.Projection getProjection() {
        try {
            if (this.projection == null) {
                this.projection = this.mapDelegate.getAMapProjection();
            }
            return this.projection;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float[] getProjectionMatrix() {
        return this.mapDelegate.getProjectionMatrix();
    }

    public final java.lang.String getSatelliteImageApprovalNumber() {
        try {
            return this.mapDelegate.getSatelliteImageApprovalNumber();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getScalePerPixel() {
        try {
            return this.mapDelegate.getScalePerPixel();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final java.lang.String getTerrainApprovalNumber() {
        try {
            return this.mapDelegate.getTerrainApprovalNumber();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final com.amap.api.maps.UiSettings getUiSettings() {
        try {
            if (this.uiSettings == null) {
                this.uiSettings = this.mapDelegate.getAMapUiSettings();
            }
            return this.uiSettings;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float[] getViewMatrix() {
        return this.mapDelegate.getViewMatrix();
    }

    public final float getZoomToSpanLevel(com.amap.api.maps.model.LatLng latLng, com.amap.api.maps.model.LatLng latLng2) {
        return this.mapDelegate.getZoomToSpanLevel(latLng, latLng2);
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.mapDelegate.isMyLocationEnabled();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final boolean isTouchPoiEnable() {
        try {
            return this.mapDelegate.isTouchPoiEnable();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.mapDelegate.isTrafficEnabled();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void moveCamera(com.amap.api.maps.CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.moveCamera(cameraUpdate);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void reloadMap() {
        this.mapDelegate.reloadMap();
    }

    public final void removeOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.removeOnCameraChangeListener(onCameraChangeListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.removeOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.removeOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.removeOnMapClickListener(onMapClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.removeOnMapLoadedListener(onMapLoadedListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.removeOnMapLongClickListener(onMapLongClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.removeOnMapTouchListener(onMapTouchListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.removeOnMarkerClickListener(onMarkerClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.removeOnMarkerDragListener(onMarkerDragListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.removeOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.removeOnPOIClickListener(onPOIClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removeOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.removeOnPolylineClickListener(onPolylineClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removecache() {
        try {
            this.mapDelegate.removecache();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void removecache(com.amap.api.maps.AMap.OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.mapDelegate.removecache(onCacheRemoveListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void resetMinMaxZoomPreference() {
        this.mapDelegate.resetMinMaxZoomPreference();
    }

    public final void runOnDrawFrame() {
        this.mapDelegate.setRunLowFrame(false);
    }

    public final void setAMapGestureListener(com.amap.api.maps.model.AMapGestureListener aMapGestureListener) {
        this.mapDelegate.setAMapGestureListener(aMapGestureListener);
    }

    public final void setCommonInfoWindowAdapter(com.amap.api.maps.AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(commonInfoWindowAdapter);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setConstructingRoadEnable(boolean z) {
        try {
            this.mapDelegate.setConstructingRoadEnable(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomMapStyle(com.amap.api.maps.model.CustomMapStyleOptions customMapStyleOptions) {
        this.mapDelegate.setCustomMapStyle(customMapStyleOptions);
    }

    public final void setCustomMapStyleID(java.lang.String str) {
    }

    public final void setCustomMapStylePath(java.lang.String str) {
    }

    public final void setCustomRenderer(com.amap.api.maps.CustomRenderer customRenderer) {
        try {
            this.mapDelegate.setCustomRenderer(customRenderer);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setCustomTextureResourcePath(java.lang.String str) {
    }

    public final void setIndoorBuildingInfo(com.amap.api.maps.model.IndoorBuildingInfo indoorBuildingInfo) {
        try {
            this.mapDelegate.setIndoorBuildingInfo(indoorBuildingInfo);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowAdapter(com.amap.api.maps.AMap.InfoWindowAdapter infoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(infoWindowAdapter);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLoadOfflineData(boolean z) {
        try {
            this.mapDelegate.setLoadOfflineData(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLocationSource(com.amap.api.maps.LocationSource locationSource) {
        try {
            this.mapDelegate.setLocationSource(locationSource);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapCustomEnable(boolean z) {
    }

    public final void setMapLanguage(java.lang.String str) {
        try {
            this.mapDelegate.setMapLanguage(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapStatusLimits(com.amap.api.maps.model.LatLngBounds latLngBounds) {
        try {
            this.mapDelegate.setMapStatusLimits(latLngBounds);
            moveCamera(com.amap.api.maps.CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapTextZIndex(int i) {
        try {
            this.mapDelegate.setMapTextZIndex(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapType(int i) {
        try {
            this.mapDelegate.setMapType(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMaskLayerParams(int i, int i2, int i3, int i4, int i5, long j) {
        this.mapDelegate.setMaskLayerParams(i, i2, i3, i4, i5, j);
    }

    public final void setMaxZoomLevel(float f) {
        this.mapDelegate.setMaxZoomLevel(f);
    }

    public final void setMinZoomLevel(float f) {
        this.mapDelegate.setMinZoomLevel(f);
    }

    public final void setMyLocationEnabled(boolean z) {
        try {
            this.mapDelegate.setMyLocationEnabled(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationRotateAngle(float f) {
        try {
            this.mapDelegate.setMyLocationRotateAngle(f);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationStyle(com.amap.api.maps.model.MyLocationStyle myLocationStyle) {
        try {
            this.mapDelegate.setMyLocationStyle(myLocationStyle);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationType(int i) {
        try {
            this.mapDelegate.setMyLocationType(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyTrafficStyle(com.amap.api.maps.model.MyTrafficStyle myTrafficStyle) {
        try {
            this.myTrafficStyle = myTrafficStyle;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setNaviLabelEnable(boolean z, int i, int i2) {
        try {
            this.mapDelegate.setNaviLabelEnable(z, i, i2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnCameraChangeListener(com.amap.api.maps.AMap.OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.setOnCameraChangeListener(onCameraChangeListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnIndoorBuildingActiveListener(com.amap.api.maps.AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.setOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnInfoWindowClickListener(com.amap.api.maps.AMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.setOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapClickListener(com.amap.api.maps.AMap.OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.setOnMapClickListener(onMapClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLoadedListener(com.amap.api.maps.AMap.OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.setOnMaploadedListener(onMapLoadedListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLongClickListener(com.amap.api.maps.AMap.OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.setOnMapLongClickListener(onMapLongClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapTouchListener(com.amap.api.maps.AMap.OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.setOnMapTouchListener(onMapTouchListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerClickListener(com.amap.api.maps.AMap.OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.setOnMarkerClickListener(onMarkerClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerDragListener(com.amap.api.maps.AMap.OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.setOnMarkerDragListener(onMarkerDragListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMultiPointClickListener(com.amap.api.maps.AMap.OnMultiPointClickListener onMultiPointClickListener) {
        try {
            this.mapDelegate.setOnMultiPointClickListener(onMultiPointClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMyLocationChangeListener(com.amap.api.maps.AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.setOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPOIClickListener(com.amap.api.maps.AMap.OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.setOnPOIClickListener(onPOIClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPolylineClickListener(com.amap.api.maps.AMap.OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.setOnPolylineClickListener(onPolylineClickListener);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPointToCenter(int i, int i2) {
        try {
            this.mapDelegate.setCenterToPixel(i, i2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRenderFps(int i) {
        this.mapDelegate.setRenderFps(i);
    }

    public final void setRenderMode(int i) {
        this.mapDelegate.setRenderMode(i);
    }

    public final void setRoadArrowEnable(boolean z) {
        try {
            this.mapDelegate.setRoadArrowEnable(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTouchPoiEnable(boolean z) {
        try {
            this.mapDelegate.setTouchPoiEnable(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.mapDelegate.setTrafficEnabled(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTrafficStyleWithTextureData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTextureData(bArr);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setWorldVectorMapStyle(java.lang.String str) {
        try {
            this.mapDelegate.setWorldVectorMapStyle(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showBuildings(boolean z) {
        try {
            this.mapDelegate.set3DBuildingEnabled(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showIndoorMap(boolean z) {
        try {
            this.mapDelegate.setIndoorEnabled(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void showMapText(boolean z) {
        try {
            this.mapDelegate.setMapTextEnable(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void stopAnimation() {
        try {
            this.mapDelegate.stopAnimation();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
