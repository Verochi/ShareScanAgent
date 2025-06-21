package com.loc;

/* loaded from: classes23.dex */
public final class fy {
    static double a = 3.141592653589793d;
    private static final java.util.List<com.amap.api.location.DPoint> b = new java.util.ArrayList(java.util.Arrays.asList(new com.amap.api.location.DPoint(23.379947d, 119.757001d), new com.amap.api.location.DPoint(24.983296d, 120.474496d), new com.amap.api.location.DPoint(25.518722d, 121.359866d), new com.amap.api.location.DPoint(25.41329d, 122.443582d), new com.amap.api.location.DPoint(24.862708d, 122.288354d), new com.amap.api.location.DPoint(24.461292d, 122.188319d), new com.amap.api.location.DPoint(21.584761d, 120.968923d), new com.amap.api.location.DPoint(21.830837d, 120.654445d)));

    private static double a(double d) {
        return java.lang.Math.sin(d * 3000.0d * (a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double d, double d2) {
        return (java.lang.Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (java.lang.Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static com.amap.api.location.DPoint a(double d, double d2, double d3, double d4) {
        com.amap.api.location.DPoint dPoint = new com.amap.api.location.DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        com.amap.api.location.DPoint d7 = d(d5, d6);
        dPoint.setLongitude(c((d + d5) - d7.getLongitude()));
        dPoint.setLatitude(c((d2 + d6) - d7.getLatitude()));
        return dPoint;
    }

    public static com.amap.api.location.DPoint a(android.content.Context context, com.amap.api.location.DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return b(dPoint);
    }

    public static com.amap.api.location.DPoint a(com.amap.api.location.DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (com.loc.fv.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return c(dPoint);
                }
                if (!e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return dPoint;
                }
                com.amap.api.location.DPoint c = c(dPoint);
                return f(c.getLatitude(), c.getLongitude());
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static double b(double d) {
        return java.lang.Math.cos(d * 3000.0d * (a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double d, double d2) {
        return (java.lang.Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (java.lang.Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static com.amap.api.location.DPoint b(android.content.Context context, com.amap.api.location.DPoint dPoint) {
        try {
            return !com.loc.fv.a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : a(context, c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static com.amap.api.location.DPoint b(com.amap.api.location.DPoint dPoint) {
        try {
            if (!com.loc.fv.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] a2 = com.loc.ge.a(dPoint.getLongitude(), dPoint.getLatitude());
            return new com.amap.api.location.DPoint(a2[1], a2[0]);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static double c(double d) {
        return new java.math.BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static com.amap.api.location.DPoint c(double d, double d2) {
        double d3 = ((long) (d * 100000.0d)) % 36000000;
        double d4 = ((long) (d2 * 100000.0d)) % 36000000;
        return new com.amap.api.location.DPoint(((int) (((-b(r11, r2)) + d4) + (d4 <= 0.0d ? -1 : 1))) / 100000.0d, ((int) (((-a((int) ((-a(d3, d4)) + d3), (int) ((-b(d3, d4)) + d4))) + d3) + (d3 > 0.0d ? 1 : -1))) / 100000.0d);
    }

    private static com.amap.api.location.DPoint c(com.amap.api.location.DPoint dPoint) {
        com.amap.api.location.DPoint dPoint2 = null;
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint2 = a(dPoint.getLongitude(), dPoint.getLatitude(), d, d2);
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }

    private static com.amap.api.location.DPoint d(double d, double d2) {
        com.amap.api.location.DPoint dPoint = new com.amap.api.location.DPoint();
        double d3 = (d * d) + (d2 * d2);
        double cos = (java.lang.Math.cos(b(d) + java.lang.Math.atan2(d2, d)) * (a(d2) + java.lang.Math.sqrt(d3))) + 0.0065d;
        double sin = (java.lang.Math.sin(b(d) + java.lang.Math.atan2(d2, d)) * (a(d2) + java.lang.Math.sqrt(d3))) + 0.006d;
        dPoint.setLongitude(c(cos));
        dPoint.setLatitude(c(sin));
        return dPoint;
    }

    private static boolean e(double d, double d2) {
        return com.loc.fv.a(new com.amap.api.location.DPoint(d, d2), b);
    }

    private static com.amap.api.location.DPoint f(double d, double d2) {
        com.amap.api.location.DPoint g = g(d, d2);
        return new com.amap.api.location.DPoint((d * 2.0d) - g.getLatitude(), (d2 * 2.0d) - g.getLongitude());
    }

    private static com.amap.api.location.DPoint g(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double h = h(d3, d4);
        double i = i(d3, d4);
        double d5 = (d / 180.0d) * a;
        double sin = java.lang.Math.sin(d5);
        double d6 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = java.lang.Math.sqrt(d6);
        return new com.amap.api.location.DPoint(d + ((h * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * a)), d2 + ((i * 180.0d) / (((6378245.0d / sqrt) * java.lang.Math.cos(d5)) * a)));
    }

    private static double h(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (java.lang.Math.sqrt(java.lang.Math.abs(d)) * 0.2d) + ((((java.lang.Math.sin((d * 6.0d) * a) * 20.0d) + (java.lang.Math.sin(d3 * a) * 20.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin(a * d2) * 20.0d) + (java.lang.Math.sin((d2 / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin((d2 / 12.0d) * a) * 160.0d) + (java.lang.Math.sin((d2 * a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double i(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (java.lang.Math.sqrt(java.lang.Math.abs(d)) * 0.1d) + ((((java.lang.Math.sin((6.0d * d) * a) * 20.0d) + (java.lang.Math.sin((d * 2.0d) * a) * 20.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin(a * d) * 20.0d) + (java.lang.Math.sin((d / 3.0d) * a) * 40.0d)) * 2.0d) / 3.0d) + ((((java.lang.Math.sin((d / 12.0d) * a) * 150.0d) + (java.lang.Math.sin((d / 30.0d) * a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
