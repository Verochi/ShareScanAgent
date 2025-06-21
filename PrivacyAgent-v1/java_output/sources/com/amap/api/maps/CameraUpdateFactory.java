package com.amap.api.maps;

/* loaded from: classes12.dex */
public final class CameraUpdateFactory {
    private static final java.lang.String CLASSNAME = "CameraUpdateFactory";

    public static com.amap.api.maps.CameraUpdate changeBearing(float f) {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.d(f % 360.0f));
    }

    public static com.amap.api.maps.CameraUpdate changeBearingGeoCenter(float f, com.autonavi.amap.mapcore.IPoint iPoint) {
        return iPoint == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.b(f % 360.0f, new android.graphics.Point(((android.graphics.Point) iPoint).x, ((android.graphics.Point) iPoint).y)));
    }

    public static com.amap.api.maps.CameraUpdate changeLatLng(com.amap.api.maps.model.LatLng latLng) {
        return latLng == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static com.amap.api.maps.CameraUpdate changeTilt(float f) {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c(f));
    }

    public static com.amap.api.maps.CameraUpdate newCameraPosition(com.amap.api.maps.model.CameraPosition cameraPosition) {
        return cameraPosition == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(cameraPosition));
    }

    public static com.amap.api.maps.CameraUpdate newLatLng(com.amap.api.maps.model.LatLng latLng) {
        return latLng == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(latLng));
    }

    public static com.amap.api.maps.CameraUpdate newLatLngBounds(com.amap.api.maps.model.LatLngBounds latLngBounds, int i) {
        return latLngBounds == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(latLngBounds, i));
    }

    public static com.amap.api.maps.CameraUpdate newLatLngBounds(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2, int i3) {
        return latLngBounds == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(latLngBounds, i, i2, i3));
    }

    public static com.amap.api.maps.CameraUpdate newLatLngBoundsRect(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2, int i3, int i4) {
        return latLngBounds == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(latLngBounds, i, i2, i3, i4));
    }

    public static com.amap.api.maps.CameraUpdate newLatLngZoom(com.amap.api.maps.model.LatLng latLng, float f) {
        return latLng == null ? new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.c()) : new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(latLng, f));
    }

    public static com.amap.api.maps.CameraUpdate scrollBy(float f, float f2) {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(f, f2));
    }

    public static com.amap.api.maps.CameraUpdate zoomBy(float f) {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.b(f));
    }

    public static com.amap.api.maps.CameraUpdate zoomBy(float f, android.graphics.Point point) {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(f, point));
    }

    public static com.amap.api.maps.CameraUpdate zoomIn() {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a());
    }

    public static com.amap.api.maps.CameraUpdate zoomOut() {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.b());
    }

    public static com.amap.api.maps.CameraUpdate zoomTo(float f) {
        return new com.amap.api.maps.CameraUpdate(com.amap.api.mapcore.util.z.a(f));
    }
}
