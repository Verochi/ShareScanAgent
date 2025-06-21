package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class dn {
    private static java.util.Map<java.lang.String, com.amap.api.mapcore.util.Cdo> a = new java.util.concurrent.ConcurrentHashMap();
    private static java.lang.String b = "";

    public static void a() {
        try {
            if (com.amap.api.mapcore.util.dm.a) {
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.amap.api.mapcore.util.Cdo>> it = a.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().a();
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void a(int i, java.lang.String str, java.lang.String str2) {
        if (i == 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            return;
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
    }

    private static void a(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.util.Map<java.lang.String, com.amap.api.mapcore.util.Cdo> map;
        com.amap.api.mapcore.util.Cdo cdo;
        try {
            java.lang.String str5 = str3 + str4;
            if (com.amap.api.mapcore.util.dm.b) {
                a(i, str2, str5);
            }
            if (!com.amap.api.mapcore.util.dm.a || (map = a) == null || (cdo = map.get(str)) == null) {
                return;
            }
            cdo.a(i, str2, str5);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        try {
            b();
            com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.dl.a()).a(context.getApplicationContext());
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(java.lang.String str, java.lang.String str2) {
        a(0, "normal", b, str, str2);
    }

    public static void a(java.lang.String str, java.lang.String str2, com.amap.api.maps.model.MarkerOptions markerOptions) {
        if (markerOptions == null) {
            c(str, str2);
            return;
        }
        c(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
    }

    public static void a(java.lang.String str, java.lang.String str2, com.amap.api.maps.model.PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            c(str, str2);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.List<com.amap.api.maps.model.LatLng> points = polygonOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polygonOptions.getStrokeWidth());
        sb.append(";fillColor=");
        sb.append(polygonOptions.getFillColor());
        sb.append(";strokeColor=");
        sb.append(polygonOptions.getStrokeColor());
        sb.append(";visible=");
        sb.append(polygonOptions.isVisible());
        c(str, str2 + " " + sb.toString());
    }

    public static void a(java.lang.String str, java.lang.String str2, com.amap.api.maps.model.PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            c(str, str2);
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.List<com.amap.api.maps.model.LatLng> points = polylineOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polylineOptions.getWidth());
        sb.append(";color=");
        sb.append(polylineOptions.getColor());
        sb.append(";visible=");
        sb.append(polylineOptions.isVisible());
        c(str, str2 + " " + sb.toString());
    }

    public static void a(java.lang.String str, java.lang.String str2, java.util.List<com.amap.api.maps.model.MarkerOptions> list) {
        if (list != null) {
            java.util.Iterator<com.amap.api.maps.model.MarkerOptions> it = list.iterator();
            while (it.hasNext()) {
                a(str, str2, it.next());
            }
        }
    }

    public static void a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean a2 = com.amap.api.mapcore.util.ew.a(jSONObject.optString("able", ""), false);
            boolean a3 = com.amap.api.mapcore.util.ew.a(jSONObject.optString(moji.com.mjwallet.InputSmsCodeFragmentKt.MOBILE, ""), false);
            boolean a4 = com.amap.api.mapcore.util.ew.a(jSONObject.optString("debugupload", ""), false);
            boolean a5 = com.amap.api.mapcore.util.ew.a(jSONObject.optString("debugwrite", ""), false);
            boolean a6 = com.amap.api.mapcore.util.ew.a(jSONObject.optString("forcedUpload", ""), false);
            com.amap.api.mapcore.util.dm.a = a2;
            boolean a7 = com.amap.api.mapcore.util.ew.a(jSONObject.optString(com.meizu.cloud.pushsdk.notification.model.AppIconSetting.DEFAULT_LARGE_ICON, ""), false);
            java.lang.String optString = jSONObject.optString("dis", "");
            if (!a7 || com.amap.api.mapcore.util.fi.f(optString)) {
                com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.dl.a()).a(a2, a3, a5, a4, java.util.Arrays.asList(jSONObject.optString("filter", "").split("&")));
                if (a6) {
                    com.amap.api.mapcore.util.ft.a(com.amap.api.mapcore.util.dl.a()).a(a6);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void b() {
        try {
            a.put("overlay", new com.amap.api.mapcore.util.dq());
            a.put("normal", new com.amap.api.mapcore.util.dp());
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void b(java.lang.String str, java.lang.String str2) {
        a(1, "normal", b, str, str2);
    }

    private static void c(java.lang.String str, java.lang.String str2) {
        a(1, "overlay", b, str, str2);
    }
}
