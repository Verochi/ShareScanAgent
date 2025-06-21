package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
final class r implements com.autonavi.base.amap.api.mapcore.IProjectionDelegate {
    private com.autonavi.base.amap.api.mapcore.IAMapDelegate a;

    public r(com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate) {
        this.a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float calculateMapZoomer(com.amap.api.maps.model.LatLng latLng, int i) {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        com.autonavi.base.ae.gmap.GLMapState mapProjection = iAMapDelegate.getMapProjection();
        com.autonavi.base.amap.mapcore.MapConfig mapConfig = this.a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        return com.amap.api.mapcore.util.dl.a(mapProjection, (int) mapConfig.getSX(), (int) mapConfig.getSY(), latLng.latitude, latLng.longitude, i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final com.amap.api.maps.model.TileProjection fromBoundsToTile(com.amap.api.maps.model.LatLngBounds latLngBounds, int i, int i2) throws android.os.RemoteException {
        if (latLngBounds == null || i < 0 || i > 20 || i2 <= 0) {
            return null;
        }
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        com.autonavi.amap.mapcore.IPoint obtain2 = com.autonavi.amap.mapcore.IPoint.obtain();
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        com.amap.api.maps.model.LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate2 = this.a;
        com.amap.api.maps.model.LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        int i3 = ((android.graphics.Point) obtain).x;
        int i4 = 20 - i;
        int i5 = (i3 >> i4) / i2;
        int i6 = (((android.graphics.Point) obtain).y >> i4) / i2;
        int i7 = (((android.graphics.Point) obtain2).x >> i4) / i2;
        int i8 = ((android.graphics.Point) obtain2).y;
        int i9 = (i8 >> i4) / i2;
        obtain.recycle();
        obtain2.recycle();
        return new com.amap.api.maps.model.TileProjection((i3 - ((i5 << i4) * i2)) >> i4, (i8 - ((i9 << i4) * i2)) >> i4, i5, i7, i9, i6);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final com.amap.api.maps.model.LatLng fromScreenLocation(android.graphics.Point point) throws android.os.RemoteException {
        if (point == null) {
            return null;
        }
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        this.a.getPixel2LatLng(point.x, point.y, obtain);
        com.amap.api.maps.model.LatLng latLng = new com.amap.api.maps.model.LatLng(obtain.y, obtain.x);
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final com.amap.api.maps.model.AMapCameraInfo getCameraInfo() {
        return this.a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final com.amap.api.maps.model.LatLngBounds getMapBounds(com.amap.api.maps.model.LatLng latLng, float f) throws android.os.RemoteException {
        com.autonavi.base.amap.api.mapcore.IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final com.amap.api.maps.model.VisibleRegion getVisibleRegion() throws android.os.RemoteException {
        int mapWidth = this.a.getMapWidth();
        int mapHeight = this.a.getMapHeight();
        com.amap.api.maps.model.LatLng fromScreenLocation = fromScreenLocation(new android.graphics.Point(0, 0));
        com.amap.api.maps.model.LatLng fromScreenLocation2 = fromScreenLocation(new android.graphics.Point(mapWidth, 0));
        com.amap.api.maps.model.LatLng fromScreenLocation3 = fromScreenLocation(new android.graphics.Point(0, mapHeight));
        com.amap.api.maps.model.LatLng fromScreenLocation4 = fromScreenLocation(new android.graphics.Point(mapWidth, mapHeight));
        return new com.amap.api.maps.model.VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, com.amap.api.maps.model.LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final float toMapLenWithWin(int i) {
        if (i <= 0) {
            return 0.0f;
        }
        return this.a.toMapLenWithWin(i);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final android.graphics.PointF toMapLocation(com.amap.api.maps.model.LatLng latLng) throws android.os.RemoteException {
        if (latLng == null) {
            return null;
        }
        com.autonavi.base.amap.mapcore.FPoint obtain = com.autonavi.base.amap.mapcore.FPoint.obtain();
        this.a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        android.graphics.PointF pointF = new android.graphics.PointF(((android.graphics.PointF) obtain).x, ((android.graphics.PointF) obtain).y);
        obtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public final android.graphics.Point toScreenLocation(com.amap.api.maps.model.LatLng latLng) throws android.os.RemoteException {
        if (latLng == null) {
            return null;
        }
        com.autonavi.amap.mapcore.IPoint obtain = com.autonavi.amap.mapcore.IPoint.obtain();
        this.a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        android.graphics.Point point = new android.graphics.Point(((android.graphics.Point) obtain).x, ((android.graphics.Point) obtain).y);
        obtain.recycle();
        return point;
    }
}
