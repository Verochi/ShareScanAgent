package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class di {
    private static boolean a;
    private static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private static boolean h;
    private static boolean i;
    private static boolean j;
    private static java.util.HashMap<java.lang.String, java.lang.Boolean> k = new java.util.HashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> l = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Integer> m = new java.util.concurrent.ConcurrentHashMap<>();

    private static <T> java.lang.String a(java.util.Map<java.lang.String, T> map) {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("{");
            for (java.util.Map.Entry<java.lang.String, T> entry : map.entrySet()) {
                sb.append("\"" + entry.getKey() + "\":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static java.lang.String a(boolean z) {
        try {
            return "{\"Quest\":" + z + com.alipay.sdk.m.u.i.d;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(android.content.Context context) {
        if (c) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_heatmap", 1);
            a(context, "O009", a(hashMap));
            c = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, int i2) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_draw_fail", java.lang.Integer.valueOf(i2));
            a(context, "O023", a(hashMap));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, int i2, int i3, java.lang.String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (l) {
                if (!l.containsKey(java.lang.Integer.valueOf(i2)) || l.get(java.lang.Integer.valueOf(i2)).intValue() < 2) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("amap_3dmap_map_request_type", java.lang.String.valueOf(i3));
                    hashMap.put("amap_3dmap_map_request_info", str);
                    a(context, "O019", a(hashMap));
                    if (l.containsKey(java.lang.Integer.valueOf(i2))) {
                        l.put(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(l.get(java.lang.Integer.valueOf(i2)).intValue() + 1));
                    } else {
                        l.put(java.lang.Integer.valueOf(i2), 0);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, int i2, long j2, long j3) {
        try {
            synchronized (m) {
                if (!m.containsKey(java.lang.Integer.valueOf(i2)) || m.get(java.lang.Integer.valueOf(i2)).intValue() < 2) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("amap_3dmap_map_request_rendertime", java.lang.Long.valueOf(j2));
                    hashMap.put("amap_3dmap_map_request_size", java.lang.Long.valueOf(j3));
                    a(context, "O020", a(hashMap));
                    if (m.containsKey(java.lang.Integer.valueOf(i2))) {
                        m.put(java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(m.get(java.lang.Integer.valueOf(i2)).intValue() + 1));
                    } else {
                        m.put(java.lang.Integer.valueOf(i2), 0);
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, long j2) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_rendertime", java.lang.Long.valueOf(j2));
            hashMap.put("amap_3dmap_render_background", 0L);
            a(context, "O005", a(hashMap));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized void a(android.content.Context context, java.lang.String str) {
        synchronized (com.amap.api.mapcore.util.di.class) {
            try {
                if (k != null && !android.text.TextUtils.isEmpty(str)) {
                    if (k.containsKey(str) && k.get(str).booleanValue()) {
                        return;
                    }
                    java.util.HashMap hashMap = new java.util.HashMap();
                    hashMap.put("amap_3dmap_coordinate", str);
                    a(context, "O008", a(hashMap));
                    if (!k.containsKey(str)) {
                        k.put(str, java.lang.Boolean.TRUE);
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            return;
        }
        try {
            com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(context, "3dmap", "9.1.0", str);
            hqVar.a(str2);
            com.amap.api.mapcore.util.hr.a(hqVar, context);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void a(android.content.Context context, boolean z) {
        try {
            java.lang.String a2 = a(z);
            com.amap.api.mapcore.util.hq hqVar = new com.amap.api.mapcore.util.hq(context, "3dmap", "9.1.0", "O001");
            hqVar.a(a2);
            com.amap.api.mapcore.util.hr.a(hqVar, context);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(android.content.Context context) {
        if (d) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_offlinemap", 1);
            a(context, "O010", a(hashMap));
            d = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void b(android.content.Context context, java.lang.String str) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_engine_init_fail", str);
            a(context, "O021", a(hashMap));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void b(android.content.Context context, boolean z) {
        if (a) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_stylemap", java.lang.Integer.valueOf(z ? 1 : 0));
            a(context, "O006", a(hashMap));
            a = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c(android.content.Context context) {
        if (e) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_particleoverlay", 1);
            a(context, "O011", a(hashMap));
            e = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c(android.content.Context context, java.lang.String str) {
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_res_load_fail", str);
            a(context, "O022", a(hashMap));
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c(android.content.Context context, boolean z) {
        if (b) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_indoormap", java.lang.Integer.valueOf(z ? 1 : 0));
            a(context, "O007", a(hashMap));
            b = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void d(android.content.Context context) {
        if (g) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_bzmapreview", 1);
            a(context, "O012", a(hashMap));
            g = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void e(android.content.Context context) {
        if (h) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_wxmapreview", 1);
            a(context, "O013", a(hashMap));
            h = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void f(android.content.Context context) {
        if (i) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_dxmapreview", 1);
            a(context, "0016", a(hashMap));
            i = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void g(android.content.Context context) {
        if (f) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_renderfps", 1);
            a(context, "O014", a(hashMap));
            f = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void h(android.content.Context context) {
        if (j) {
            return;
        }
        try {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("amap_3dmap_buildingoverlay", 1);
            a(context, "O015", a(hashMap));
            j = true;
        } catch (java.lang.Throwable unused) {
        }
    }
}
