package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class ji {
    private static final java.lang.String[] b = {"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};
    private static final java.lang.String[] c = {"com.amap.api.mapcore2d", "com.amap.api.maps2d"};
    private static final java.lang.String[] d = {"com.amap.trace"};
    static com.amap.api.mapcore.util.fh a = null;

    public static com.amap.api.mapcore.util.fh a() throws com.amap.api.mapcore.util.eu {
        java.lang.Class<?> cls;
        java.lang.Class<?> cls2;
        com.amap.api.mapcore.util.fh a2;
        com.amap.api.mapcore.util.fh fhVar = a;
        if (fhVar != null) {
            return fhVar;
        }
        try {
            cls = com.amap.api.maps.MapsInitializer.class;
            java.lang.String str = com.amap.api.maps.MapsInitializer.sdcardDir;
        } catch (java.lang.Throwable unused) {
            cls = null;
        }
        try {
            if (cls != null) {
                java.lang.String str2 = (java.lang.String) com.amap.api.mapcore.util.iv.a(cls, "getVersion", (java.lang.Object[]) null, (java.lang.Class<?>[]) null);
                a2 = new com.amap.api.mapcore.util.fh.a("3dmap", str2, "AMAP_SDK_Android_Map_".concat(java.lang.String.valueOf(str2))).a(b).a();
            } else {
                cls = java.lang.Class.forName("com.amap.api.maps2d.MapsInitializer");
                java.lang.String str3 = (java.lang.String) com.amap.api.mapcore.util.iv.a(cls, "getVersion", (java.lang.Object[]) null, (java.lang.Class<?>[]) null);
                a2 = new com.amap.api.mapcore.util.fh.a("2dmap", str3, "AMAP_SDK_Android_2DMap_".concat(java.lang.String.valueOf(str3))).a(c).a();
            }
            a = a2;
        } catch (java.lang.Throwable unused2) {
        }
        if (cls == null) {
            try {
                cls2 = java.lang.Class.forName("com.amap.trace.AMapTraceClient");
            } catch (java.lang.Throwable unused3) {
                cls2 = null;
            }
            if (cls2 != null) {
                try {
                    java.lang.String str4 = (java.lang.String) com.amap.api.mapcore.util.iv.a(cls2, "getVersion", (java.lang.Object[]) null, (java.lang.Class<?>[]) null);
                    a = new com.amap.api.mapcore.util.fh.a("trace", str4, "AMAP_TRACE_Android_".concat(java.lang.String.valueOf(str4))).a(d).a();
                } catch (java.lang.Throwable unused4) {
                }
            }
        }
        return a;
    }

    public static boolean a(com.amap.api.mapcore.util.je jeVar) {
        if (jeVar == null || jeVar.d().equals("8") || jeVar.d().equals("5") || jeVar.d().equals("6")) {
            return false;
        }
        return a((com.autonavi.amap.mapcore.Inner_3dMap_location) jeVar);
    }

    public static boolean a(com.autonavi.amap.mapcore.Inner_3dMap_location inner_3dMap_location) {
        double longitude = inner_3dMap_location.getLongitude();
        double latitude = inner_3dMap_location.getLatitude();
        return !(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d && latitude <= 90.0d && longitude >= -180.0d && latitude >= -90.0d;
    }
}
