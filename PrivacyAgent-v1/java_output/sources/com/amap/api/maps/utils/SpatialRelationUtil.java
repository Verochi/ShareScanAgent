package com.amap.api.maps.utils;

/* loaded from: classes12.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static android.util.Pair<java.lang.Integer, com.amap.api.maps.model.LatLng> calShortestDistancePoint(java.util.List<com.amap.api.maps.model.LatLng> list, com.amap.api.maps.model.LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int i = 0;
                    for (com.amap.api.maps.model.LatLng latLng2 : list) {
                        arrayList.add(com.autonavi.amap.mapcore.DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new android.util.Pair<>(java.lang.Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, com.autonavi.amap.mapcore.DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        java.lang.Object obj = calShortestDistancePoint.first;
                        java.lang.Object obj2 = calShortestDistancePoint.second;
                        return new android.util.Pair<>(obj, new com.amap.api.maps.model.LatLng(((com.autonavi.amap.mapcore.DPoint) obj2).x, ((com.autonavi.amap.mapcore.DPoint) obj2).y));
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static android.util.Pair<java.lang.Integer, com.amap.api.maps.model.LatLng> calShortestDistancePoint(java.util.List<com.amap.api.maps.model.LatLng> list, com.amap.api.maps.model.LatLng latLng, float f, double d) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    int i = 0;
                    for (com.amap.api.maps.model.LatLng latLng2 : list) {
                        arrayList.add(com.autonavi.amap.mapcore.DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new android.util.Pair<>(java.lang.Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, com.autonavi.amap.mapcore.DPoint.obtain(latLng.latitude, latLng.longitude), f);
                    if (calShortestDistancePoint != null) {
                        com.autonavi.amap.mapcore.DPoint dPoint = (com.autonavi.amap.mapcore.DPoint) calShortestDistancePoint.second;
                        if (com.amap.api.maps.AMapUtils.calculateLineDistance(new com.amap.api.maps.model.LatLng(dPoint.x, dPoint.y), latLng) < d) {
                            java.lang.Object obj = calShortestDistancePoint.first;
                            java.lang.Object obj2 = calShortestDistancePoint.second;
                            return new android.util.Pair<>(obj, new com.amap.api.maps.model.LatLng(((com.autonavi.amap.mapcore.DPoint) obj2).x, ((com.autonavi.amap.mapcore.DPoint) obj2).y));
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> calShortestDistancePoint(java.util.List<com.autonavi.amap.mapcore.DPoint> list, com.autonavi.amap.mapcore.DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> calShortestDistancePoint(java.util.List<com.autonavi.amap.mapcore.DPoint> list, com.autonavi.amap.mapcore.DPoint dPoint, float f) {
        int i;
        double d;
        int i2;
        double doubleValue;
        android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> pair;
        java.util.List<com.autonavi.amap.mapcore.DPoint> list2 = list;
        com.autonavi.amap.mapcore.DPoint dPoint2 = dPoint;
        android.util.Pair<java.lang.Integer, com.autonavi.amap.mapcore.DPoint> pair2 = null;
        if (list2 != null && dPoint2 != null && list.size() != 0) {
            if (list.size() >= 2) {
                com.autonavi.amap.mapcore.DPoint dPoint3 = list2.get(0);
                int size = list.size();
                int i3 = 1;
                double d2 = 0.0d;
                int i4 = 1;
                while (true) {
                    int i5 = size - 1;
                    if (i4 > i5) {
                        break;
                    }
                    com.autonavi.amap.mapcore.DPoint dPoint4 = list2.get(i4);
                    if (i4 == i5 && dPoint4.equals(dPoint2)) {
                        return new android.util.Pair<>(java.lang.Integer.valueOf(i4), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f)) {
                        i = size;
                        d = d2;
                        i2 = i4;
                    } else {
                        if (dPoint3.equals(dPoint2)) {
                            return new android.util.Pair<>(java.lang.Integer.valueOf(i4 - i3), dPoint2);
                        }
                        d = d2;
                        i2 = i4;
                        i = size;
                        android.util.Pair<java.lang.Double, com.autonavi.amap.mapcore.DPoint> pointToSegDist = pointToSegDist(dPoint2.x, dPoint2.y, dPoint3.x, dPoint3.y, dPoint4.x, dPoint4.y);
                        if (pair2 == null) {
                            doubleValue = ((java.lang.Double) pointToSegDist.first).doubleValue();
                            pair = new android.util.Pair<>(java.lang.Integer.valueOf(i2 - 1), pointToSegDist.second);
                        } else if (d > ((java.lang.Double) pointToSegDist.first).doubleValue()) {
                            doubleValue = ((java.lang.Double) pointToSegDist.first).doubleValue();
                            pair = new android.util.Pair<>(java.lang.Integer.valueOf(i2 - 1), pointToSegDist.second);
                        }
                        d2 = doubleValue;
                        pair2 = pair;
                        i4 = i2 + 1;
                        list2 = list;
                        dPoint2 = dPoint;
                        dPoint3 = dPoint4;
                        size = i;
                        i3 = 1;
                    }
                    d2 = d;
                    i4 = i2 + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    size = i;
                    i3 = 1;
                }
            } else {
                return null;
            }
        }
        return pair2;
    }

    private static boolean checkRotateIsMatch(com.autonavi.amap.mapcore.DPoint dPoint, com.autonavi.amap.mapcore.DPoint dPoint2, float f) {
        if (f == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            float abs = java.lang.Math.abs((com.amap.api.mapcore.util.dl.a(dPoint, dPoint2) + 360.0f) - f) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static android.util.Pair<java.lang.Double, com.autonavi.amap.mapcore.DPoint> pointToSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return new android.util.Pair<>(java.lang.Double.valueOf(java.lang.Math.sqrt((d8 * d8) + (d10 * d10))), new com.autonavi.amap.mapcore.DPoint(d3, d4));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return new android.util.Pair<>(java.lang.Double.valueOf(java.lang.Math.sqrt((d13 * d13) + (d14 * d14))), new com.autonavi.amap.mapcore.DPoint(d5, d6));
        }
        double d15 = d11 / d12;
        double d16 = d3 + (d7 * d15);
        double d17 = d4 + (d9 * d15);
        double d18 = d - d16;
        double d19 = d17 - d2;
        return new android.util.Pair<>(java.lang.Double.valueOf(java.lang.Math.sqrt((d18 * d18) + (d19 * d19))), new com.autonavi.amap.mapcore.DPoint(d16, d17));
    }
}
