package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class z {
    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a() {
        com.amap.api.mapcore.util.y yVar = new com.amap.api.mapcore.util.y();
        yVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.zoomBy;
        yVar.amount = 1.0f;
        return yVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(float f) {
        com.amap.api.mapcore.util.w wVar = new com.amap.api.mapcore.util.w();
        wVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.zoom = f;
        return wVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(float f, float f2) {
        com.amap.api.mapcore.util.x xVar = new com.amap.api.mapcore.util.x();
        xVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.scrollBy;
        xVar.xPixel = f;
        xVar.yPixel = f2;
        return xVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(float f, android.graphics.Point point) {
        com.amap.api.mapcore.util.y yVar = new com.amap.api.mapcore.util.y();
        yVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.zoomBy;
        yVar.amount = f;
        yVar.focus = point;
        return yVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(android.graphics.Point point) {
        com.amap.api.mapcore.util.w wVar = new com.amap.api.mapcore.util.w();
        wVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.geoPoint = new com.autonavi.amap.mapcore.DPoint(point.x, point.y);
        return wVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(com.amap.api.maps.model.CameraPosition cameraPosition) {
        com.amap.api.maps.model.LatLng latLng;
        com.amap.api.mapcore.util.w wVar = new com.amap.api.mapcore.util.w();
        wVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            com.autonavi.amap.mapcore.DPoint latLongToPixelsDouble = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            wVar.geoPoint = new com.autonavi.amap.mapcore.DPoint(latLongToPixelsDouble.x, latLongToPixelsDouble.y);
            wVar.zoom = cameraPosition.zoom;
            wVar.bearing = cameraPosition.bearing;
            wVar.tilt = cameraPosition.tilt;
            wVar.cameraPosition = cameraPosition;
        }
        return wVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(com.amap.api.maps.model.LatLng latLng) {
        return a(com.amap.api.maps.model.CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(com.amap.api.maps.model.LatLng latLng, float f) {
        return a(com.amap.api.maps.model.CameraPosition.builder().target(latLng).zoom(f).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(com.amap.api.maps.model.LatLngBounds latLngBounds, int i) {
        com.amap.api.mapcore.util.v vVar = new com.amap.api.mapcore.util.v();
        vVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newLatLngBounds;
        vVar.bounds = latLngBounds;
        vVar.paddingLeft = i;
        vVar.paddingRight = i;
        vVar.paddingTop = i;
        vVar.paddingBottom = i;
        return vVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2, int i3) {
        com.amap.api.mapcore.util.v vVar = new com.amap.api.mapcore.util.v();
        vVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        vVar.bounds = latLngBounds;
        vVar.paddingLeft = i3;
        vVar.paddingRight = i3;
        vVar.paddingTop = i3;
        vVar.paddingBottom = i3;
        vVar.width = i;
        vVar.height = i2;
        return vVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage a(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        com.amap.api.mapcore.util.v vVar = new com.amap.api.mapcore.util.v();
        vVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newLatLngBounds;
        vVar.bounds = latLngBounds;
        vVar.paddingLeft = i;
        vVar.paddingRight = i2;
        vVar.paddingTop = i3;
        vVar.paddingBottom = i4;
        return vVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage b() {
        com.amap.api.mapcore.util.y yVar = new com.amap.api.mapcore.util.y();
        yVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.zoomBy;
        yVar.amount = -1.0f;
        return yVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage b(float f) {
        return a(f, (android.graphics.Point) null);
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage b(float f, android.graphics.Point point) {
        com.amap.api.mapcore.util.w wVar = new com.amap.api.mapcore.util.w();
        wVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.geoPoint = new com.autonavi.amap.mapcore.DPoint(point.x, point.y);
        wVar.bearing = f;
        return wVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage c() {
        return new com.amap.api.mapcore.util.w();
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage c(float f) {
        com.amap.api.mapcore.util.w wVar = new com.amap.api.mapcore.util.w();
        wVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.tilt = f;
        return wVar;
    }

    public static com.autonavi.amap.mapcore.AbstractCameraUpdateMessage d(float f) {
        com.amap.api.mapcore.util.w wVar = new com.amap.api.mapcore.util.w();
        wVar.nowType = com.autonavi.amap.mapcore.AbstractCameraUpdateMessage.Type.newCameraPosition;
        wVar.bearing = f;
        return wVar;
    }
}
