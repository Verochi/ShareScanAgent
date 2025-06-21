package com.autonavi.amap.mapcore;

/* loaded from: classes12.dex */
public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static double clip(double d, double d2, double d3) {
        return java.lang.Math.min(java.lang.Math.max(d, d2), d3);
    }

    private static double degToRad(double d) {
        return d * 0.017453292519943295d;
    }

    public static android.graphics.Point latLongToPixels(double d, double d2, int i) {
        android.graphics.Point point = new android.graphics.Point();
        latLongToPixels(d, d2, i, point);
        return point;
    }

    public static android.graphics.Point latLongToPixels(int i, int i2, int i3) {
        return latLongToPixels(i2 / 3600000.0d, i / 3600000.0d, i3);
    }

    public static void latLongToPixels(double d, double d2, int i, android.graphics.Point point) {
        double clip = clip(d, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d2, -360.0d, 360.0d)) * 6378137.0d;
        double sin = java.lang.Math.sin(degToRad(clip));
        double log = (java.lang.Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d3 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d4 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        point.x = (int) d3;
        point.y = (int) d4;
    }

    public static com.autonavi.amap.mapcore.DPoint latLongToPixelsDouble(double d, double d2, int i) {
        com.autonavi.amap.mapcore.DPoint dPoint = new com.autonavi.amap.mapcore.DPoint();
        double clip = clip(d, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d2, -360.0d, 360.0d)) * 6378137.0d;
        double sin = java.lang.Math.sin(degToRad(clip));
        double log = (java.lang.Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d3 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d4 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        dPoint.x = d3;
        dPoint.y = d4;
        return dPoint;
    }

    public static com.autonavi.amap.mapcore.DPoint pixelsToLatLong(double d, double d2, int i) {
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        double d3 = (d * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d4 = K_EARTH_CIRCLE_2 - (d2 * 0.14929106831550598d);
        obtain.x = radToDeg(d3 / 6378137.0d);
        double exp = java.lang.Math.exp((d4 / 6378137.0d) * 2.0d);
        obtain.y = radToDeg(java.lang.Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    public static com.autonavi.amap.mapcore.DPoint pixelsToLatLong(long j, long j2, int i) {
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        double d = (j * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d2 = K_EARTH_CIRCLE_2 - (j2 * 0.14929106831550598d);
        obtain.x = radToDeg(d / 6378137.0d);
        double exp = java.lang.Math.exp((d2 / 6378137.0d) * 2.0d);
        obtain.y = radToDeg(java.lang.Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    private static double radToDeg(double d) {
        return d * 57.29577951308232d;
    }
}
