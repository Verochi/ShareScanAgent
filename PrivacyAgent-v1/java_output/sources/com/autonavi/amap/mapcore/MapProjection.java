package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public class MapProjection {
    public static void geo2LonLat(int i, int i2, com.autonavi.amap.mapcore.DPoint dPoint) {
        com.autonavi.amap.mapcore.DPoint pixelsToLatLong = com.autonavi.amap.mapcore.VirtualEarthProjection.pixelsToLatLong(i, i2, 20);
        dPoint.x = pixelsToLatLong.x;
        dPoint.y = pixelsToLatLong.y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d, double d2, com.autonavi.amap.mapcore.IPoint iPoint) {
        android.graphics.Point latLongToPixels = com.autonavi.amap.mapcore.VirtualEarthProjection.latLongToPixels(d2, d, 20);
        ((android.graphics.Point) iPoint).x = latLongToPixels.x;
        ((android.graphics.Point) iPoint).y = latLongToPixels.y;
    }
}
