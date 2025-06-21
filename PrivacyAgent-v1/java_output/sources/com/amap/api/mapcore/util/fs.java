package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class fs {
    public static int a = 1;
    public static int b = 2;
    private java.lang.String c;
    private int d;
    private long e = java.lang.System.currentTimeMillis();
    private java.lang.String f;

    private fs(int i, java.lang.String str, java.lang.String str2) {
        this.c = str2;
        this.d = i;
        this.f = str;
    }

    public static com.amap.api.mapcore.util.fs a(java.lang.String str, java.lang.String str2) {
        return new com.amap.api.mapcore.util.fs(a, str, str2);
    }

    public static java.lang.String a(int i) {
        return i == b ? "error" : "info";
    }

    public static java.lang.String a(java.util.List<com.amap.api.mapcore.util.fs> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    java.util.Iterator<com.amap.api.mapcore.util.fs> it = list.iterator();
                    while (it.hasNext()) {
                        java.lang.String b2 = b(it.next());
                        if (!android.text.TextUtils.isEmpty(b2)) {
                            jSONArray.put(b2);
                        }
                    }
                    return jSONArray.toString();
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return "";
    }

    public static boolean a(com.amap.api.mapcore.util.fs fsVar) {
        return (fsVar == null || android.text.TextUtils.isEmpty(fsVar.b())) ? false : true;
    }

    public static com.amap.api.mapcore.util.fs b(java.lang.String str, java.lang.String str2) {
        return new com.amap.api.mapcore.util.fs(b, str, str2);
    }

    private static java.lang.String b(com.amap.api.mapcore.util.fs fsVar) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("info", fsVar.b());
            jSONObject.put(com.umeng.analytics.pro.f.aC, fsVar.d());
            jSONObject.put("timestamp", fsVar.e);
            return jSONObject.toString();
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private java.lang.String d() {
        return this.f;
    }

    public final int a() {
        return this.d;
    }

    public final java.lang.String b() {
        new org.json.JSONObject();
        return this.c;
    }

    public final java.lang.String c() {
        return a(this.d);
    }
}
