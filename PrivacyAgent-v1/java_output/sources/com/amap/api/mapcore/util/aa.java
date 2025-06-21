package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class aa {
    static double a = 3.141592653589793d;
    private static boolean d;
    private static final double[] e = {25.575374d, 120.391111d};
    private static final double[] f = {21.405235d, 121.649046d};
    private static final java.util.List<com.amap.api.maps.model.LatLng> g = new java.util.ArrayList(java.util.Arrays.asList(new com.amap.api.maps.model.LatLng(23.379947d, 119.757001d), new com.amap.api.maps.model.LatLng(24.983296d, 120.474496d), new com.amap.api.maps.model.LatLng(25.518722d, 121.359866d), new com.amap.api.maps.model.LatLng(25.41329d, 122.443582d), new com.amap.api.maps.model.LatLng(24.862708d, 122.288354d), new com.amap.api.maps.model.LatLng(24.461292d, 122.188319d), new com.amap.api.maps.model.LatLng(21.584761d, 120.968923d), new com.amap.api.maps.model.LatLng(21.830837d, 120.654445d)));
    public static double b = 6378245.0d;
    public static double c = 0.006693421622965943d;

    private static double a(double d2) {
        return java.lang.Math.sin(d2 * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double d2, double d3) {
        return (java.lang.Math.cos(d3 / 100000.0d) * (d2 / 18000.0d)) + (java.lang.Math.sin(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static com.amap.api.maps.model.LatLng a(android.content.Context context, com.amap.api.maps.model.LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!com.amap.api.mapcore.util.de.a(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        com.autonavi.amap.mapcore.DPoint a2 = a(com.autonavi.amap.mapcore.DPoint.obtain(latLng.longitude, latLng.latitude), d);
        com.amap.api.maps.model.LatLng latLng2 = new com.amap.api.maps.model.LatLng(a2.y, a2.x, false);
        a2.recycle();
        return latLng2;
    }

    public static com.amap.api.maps.model.LatLng a(com.amap.api.maps.model.LatLng latLng) {
        if (latLng != null) {
            try {
                if (com.amap.api.mapcore.util.de.a(latLng.latitude, latLng.longitude)) {
                    com.autonavi.amap.mapcore.DPoint e2 = e(latLng.longitude, latLng.latitude);
                    com.amap.api.maps.model.LatLng latLng2 = new com.amap.api.maps.model.LatLng(e2.y, e2.x, false);
                    e2.recycle();
                    return latLng2;
                }
                if (!f(latLng.latitude, latLng.longitude)) {
                    return latLng;
                }
                com.autonavi.amap.mapcore.DPoint e3 = e(latLng.longitude, latLng.latitude);
                return g(e3.y, e3.x);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static com.autonavi.amap.mapcore.DPoint a(double d2, double d3, double d4, double d5) {
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        com.autonavi.amap.mapcore.DPoint d8 = d(d6, d7);
        obtain.x = c((d2 + d6) - d8.x);
        obtain.y = c((d3 + d7) - d8.y);
        return obtain;
    }

    private static com.autonavi.amap.mapcore.DPoint a(com.autonavi.amap.mapcore.DPoint dPoint, boolean z) {
        try {
            if (!com.amap.api.mapcore.util.de.a(dPoint.y, dPoint.x)) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (!z) {
                dArr = com.autonavi.util.a.a(dPoint.x, dPoint.y);
            }
            dPoint.recycle();
            return com.autonavi.amap.mapcore.DPoint.obtain(dArr[0], dArr[1]);
        } catch (java.lang.Throwable unused) {
            return dPoint;
        }
    }

    private static double b(double d2) {
        return java.lang.Math.cos(d2 * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double d2, double d3) {
        return (java.lang.Math.sin(d3 / 100000.0d) * (d2 / 18000.0d)) + (java.lang.Math.cos(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static com.amap.api.maps.model.LatLng b(android.content.Context context, com.amap.api.maps.model.LatLng latLng) {
        try {
            if (!com.amap.api.mapcore.util.de.a(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            com.autonavi.amap.mapcore.DPoint c2 = c(latLng.longitude, latLng.latitude);
            com.amap.api.maps.model.LatLng a2 = a(context, new com.amap.api.maps.model.LatLng(c2.y, c2.x, false));
            c2.recycle();
            return a2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static double c(double d2) {
        return new java.math.BigDecimal(d2).setScale(8, 4).doubleValue();
    }

    private static com.autonavi.amap.mapcore.DPoint c(double d2, double d3) {
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        double d5 = ((long) (d3 * 100000.0d)) % 36000000;
        return com.autonavi.amap.mapcore.DPoint.obtain(((int) (((-a((int) ((-a(d4, d5)) + d4), (int) ((-b(d4, d5)) + d5))) + d4) + (d4 > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-b(r11, r2)) + d5) + (d5 <= 0.0d ? -1 : 1))) / 100000.0d);
    }

    private static com.autonavi.amap.mapcore.DPoint d(double d2, double d3) {
        com.autonavi.amap.mapcore.DPoint obtain = com.autonavi.amap.mapcore.DPoint.obtain();
        double d4 = (d2 * d2) + (d3 * d3);
        double cos = (java.lang.Math.cos(b(d2) + java.lang.Math.atan2(d3, d2)) * (a(d3) + java.lang.Math.sqrt(d4))) + 0.0065d;
        double sin = (java.lang.Math.sin(b(d2) + java.lang.Math.atan2(d3, d2)) * (a(d3) + java.lang.Math.sqrt(d4))) + 0.006d;
        obtain.x = c(cos);
        obtain.y = c(sin);
        return obtain;
    }

    private static com.autonavi.amap.mapcore.DPoint e(double d2, double d3) {
        com.autonavi.amap.mapcore.DPoint dPoint = null;
        double d4 = 0.006401062d;
        double d5 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint = a(d2, d3, d4, d5);
            d4 = d2 - dPoint.x;
            d5 = d3 - dPoint.y;
        }
        return dPoint;
    }

    private static boolean f(double d2, double d3) {
        return com.amap.api.mapcore.util.dl.a(new com.amap.api.maps.model.LatLng(d2, d3), g);
    }

    private static com.amap.api.maps.model.LatLng g(double d2, double d3) {
        com.amap.api.maps.model.LatLng h = h(d2, d3);
        return new com.amap.api.maps.model.LatLng((d2 * 2.0d) - h.latitude, (d3 * 2.0d) - h.longitude);
    }

    private static com.amap.api.maps.model.LatLng h(double d2, double d3) {
        double d4 = d3 - 105.0d;
        double d5 = d2 - 35.0d;
        double i = i(d4, d5);
        double j = j(d4, d5);
        double d6 = (d2 / 180.0d) * a;
        double sin = java.lang.Math.sin(d6);
        double d7 = 1.0d - ((c * sin) * sin);
        double sqrt = java.lang.Math.sqrt(d7);
        double d8 = b;
        return new com.amap.api.maps.model.LatLng(d2 + ((i * 180.0d) / ((((1.0d - c) * d8) / (d7 * sqrt)) * a)), d3 + ((j * 180.0d) / (((d8 / sqrt) * java.lang.Math.cos(d6)) * a)));
    }

    private static double i(double d2, double d3) {
        double d4 = d2 * 2.0d;
        return (-100.0d) + d4 + (d3 * 3.0d) + (d3 * 0.2d * d3) + (0.1d * d2 * d3) + (java.lang.Math.sqrt(java.lang.Math.abs(d2)) * 0.2d) + ((((java.lang.Math.sin((d2 * 6.0d) * a) * 20.0d) + (java.lang.Math.sin(d4 * a) * 20.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin(a * d3) * 20.0d) + (java.lang.Math.sin((d3 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin((d3 / 12.0d) * a) * 160.0d) + (java.lang.Math.sin((d3 * a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double j(double d2, double d3) {
        double d4 = d2 * 0.1d;
        return d2 + 300.0d + (d3 * 2.0d) + (d4 * d2) + (d4 * d3) + (java.lang.Math.sqrt(java.lang.Math.abs(d2)) * 0.1d) + ((((java.lang.Math.sin((6.0d * d2) * a) * 20.0d) + (java.lang.Math.sin((d2 * 2.0d) * a) * 20.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin(a * d2) * 20.0d) + (java.lang.Math.sin((d2 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin((d2 / 12.0d) * a) * 150.0d) + (java.lang.Math.sin((d2 / 30.0d) * a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
