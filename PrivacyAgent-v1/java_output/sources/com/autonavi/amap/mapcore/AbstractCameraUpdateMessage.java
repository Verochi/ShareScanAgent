package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public com.amap.api.maps.model.LatLngBounds bounds;
    public com.amap.api.maps.model.CameraPosition cameraPosition;
    public com.autonavi.amap.mapcore.DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public com.amap.api.maps.AMap.CancelableCallback mCallback;
    public com.autonavi.amap.mapcore.interfaces.IMapConfig mapConfig;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int width;
    public float xPixel;
    public float yPixel;
    public com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.none;
    public android.graphics.Point focus = null;
    public float zoom = Float.NaN;
    public float tilt = Float.NaN;
    public float bearing = Float.NaN;
    public boolean isUseAnchor = false;
    public long mDuration = 250;
    public float maxZoomLevel = 0.0f;
    public float minZoomLevel = 0.0f;
    public float curZoolScale = 0.0f;

    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    public void changeCenterByAnchor(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, com.autonavi.amap.mapcore.DPoint dPoint) {
        changeCenterByAnchor(iGLMapState, dPoint, this.anchorX, this.anchorY);
    }

    public void changeCenterByAnchor(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, com.autonavi.amap.mapcore.DPoint dPoint, int i, int i2) {
        iGLMapState.recalculate();
        android.graphics.Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i, i2);
        com.autonavi.amap.mapcore.DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        iGLMapState.setMapGeoCenter((mapGeoCenter.x + dPoint.x) - anchorGeoPoint.x, (mapGeoCenter.y + dPoint.y) - anchorGeoPoint.y);
    }

    public void generateMapAnimation(com.autonavi.amap.api.mapcore.IGLMapEngine iGLMapEngine) {
        com.autonavi.amap.api.mapcore.IGLMapState newMapState = iGLMapEngine.getNewMapState(1);
        runCameraUpdate(newMapState);
        com.autonavi.amap.mapcore.DPoint mapGeoCenter = newMapState.getMapGeoCenter();
        iGLMapEngine.addGroupAnimation(1, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.x, (int) mapGeoCenter.y, this.mCallback);
        newMapState.recycle();
    }

    public android.graphics.Point getAnchorGeoPoint(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState, int i, int i2) {
        android.graphics.Point point = new android.graphics.Point();
        iGLMapState.screenToP20Point(i, i2, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(com.autonavi.amap.mapcore.AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    public void normalChange(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState) {
        this.zoom = java.lang.Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = java.lang.Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = java.lang.Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float a = com.amap.api.mapcore.util.dl.a(this.mapConfig, this.zoom);
        this.zoom = a;
        this.tilt = com.amap.api.mapcore.util.dl.a(this.mapConfig, this.tilt, a);
        this.bearing = (float) (((this.bearing % 360.0d) + 360.0d) % 360.0d);
        android.graphics.Point point = this.focus;
        if (point != null && this.geoPoint == null) {
            android.graphics.Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, point.x, point.y);
            this.geoPoint = new com.autonavi.amap.mapcore.DPoint(anchorGeoPoint.x, anchorGeoPoint.y);
        }
        if (!java.lang.Float.isNaN(this.zoom)) {
            iGLMapState.setMapZoomer(this.zoom);
        }
        if (!java.lang.Float.isNaN(this.bearing)) {
            iGLMapState.setMapAngle(this.bearing);
        }
        if (!java.lang.Float.isNaN(this.tilt)) {
            iGLMapState.setCameraDegree(this.tilt);
        }
        android.graphics.Point point2 = this.focus;
        if (point2 != null) {
            changeCenterByAnchor(iGLMapState, this.geoPoint, point2.x, point2.y);
            return;
        }
        com.autonavi.amap.mapcore.DPoint dPoint = this.geoPoint;
        if ((dPoint == null || (dPoint.x == 0.0d && dPoint.y == 0.0d)) ? false : true) {
            iGLMapState.setMapGeoCenter(dPoint.x, dPoint.y);
        }
    }

    public abstract void runCameraUpdate(com.autonavi.amap.api.mapcore.IGLMapState iGLMapState);
}
