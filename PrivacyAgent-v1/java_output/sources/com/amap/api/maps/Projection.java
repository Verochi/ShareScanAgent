package com.amap.api.maps;

/* loaded from: classes12.dex */
public class Projection {
    private final com.autonavi.amap.mapcore.interfaces.IProjection projectionDelegate;

    public Projection(com.autonavi.amap.mapcore.interfaces.IProjection iProjection) {
        this.projectionDelegate = iProjection;
    }

    public float calZoomByTargetPos(com.amap.api.maps.model.LatLng latLng, int i) {
        try {
            return this.projectionDelegate.calculateMapZoomer(latLng, i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 3.0f;
        }
    }

    public com.amap.api.maps.model.TileProjection fromBoundsToTile(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2) {
        try {
            return this.projectionDelegate.fromBoundsToTile(latLngBounds, i, i2);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public com.amap.api.maps.model.LatLng fromScreenLocation(android.graphics.Point point) {
        try {
            return this.projectionDelegate.fromScreenLocation(point);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public com.amap.api.maps.model.AMapCameraInfo getCameraInfo() {
        try {
            return this.projectionDelegate.getCameraInfo();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public com.amap.api.maps.model.LatLngBounds getMapBounds(com.amap.api.maps.model.LatLng latLng, float f) {
        try {
            return this.projectionDelegate.getMapBounds(latLng, f);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public com.amap.api.maps.model.VisibleRegion getVisibleRegion() {
        try {
            return this.projectionDelegate.getVisibleRegion();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @java.lang.Deprecated
    public android.graphics.PointF toMapLocation(com.amap.api.maps.model.LatLng latLng) {
        try {
            return this.projectionDelegate.toMapLocation(latLng);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public android.graphics.PointF toOpenGLLocation(com.amap.api.maps.model.LatLng latLng) {
        try {
            return this.projectionDelegate.toMapLocation(latLng);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float toOpenGLWidth(int i) {
        try {
            return this.projectionDelegate.toMapLenWithWin(i);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public android.graphics.Point toScreenLocation(com.amap.api.maps.model.LatLng latLng) {
        try {
            return this.projectionDelegate.toScreenLocation(latLng);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
