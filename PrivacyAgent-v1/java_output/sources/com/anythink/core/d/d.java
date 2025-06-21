package com.anythink.core.d;

/* loaded from: classes12.dex */
public final class d {
    private static java.lang.String m = "ofm_logger";
    private static java.lang.String n = "ofm_tk_sw";
    private static java.lang.String o = "ofm_da_sw";
    private static java.lang.String p = "tk_address";
    private static java.lang.String q = "tk_max_amount";
    private static java.lang.String r = "tk_interval";

    /* renamed from: s, reason: collision with root package name */
    private static java.lang.String f189s = "da_rt_keys_ft";
    private static java.lang.String t = "tk_no_t_ft";
    private static java.lang.String u = "da_not_keys_ft";
    private static java.lang.String v = "ofm_system";
    private static java.lang.String w = "ofm_tid";
    private static java.lang.String x = "ofm_firm_info";
    private static java.lang.String y = "ofm_st_vt";
    java.lang.String a = java.lang.String.valueOf(hashCode());
    public java.util.Map<java.lang.String, java.lang.Object> b;
    private boolean c;
    private int d;
    private int e;
    private long f;
    private int g;
    private int h;
    private java.lang.String i;
    private int j;
    private long k;
    private java.util.Map<java.lang.String, java.lang.String> l;

    public static com.anythink.core.d.d a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.anythink.core.d.d dVar = new com.anythink.core.d.d();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            dVar.d = jSONObject.optInt(v);
            dVar.e = jSONObject.optInt(w);
            dVar.f = jSONObject.optLong(y);
            dVar.b = com.anythink.core.common.o.i.c(jSONObject.optString(x));
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject(m);
            if (optJSONObject != null) {
                dVar.g = optJSONObject.optInt(n);
                dVar.h = optJSONObject.optInt(o);
                dVar.i = optJSONObject.optString(p);
                dVar.j = optJSONObject.optInt(q);
                dVar.k = optJSONObject.optLong(r);
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(optJSONObject.optString(t));
                    java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                    java.util.HashMap hashMap = new java.util.HashMap();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                    }
                    dVar.l = hashMap;
                } catch (java.lang.Throwable unused) {
                }
            }
            return dVar;
        } catch (java.lang.Throwable unused2) {
            return null;
        }
    }

    private int b() {
        return this.d;
    }

    private java.util.Map<java.lang.String, java.lang.Object> b(java.lang.String str) {
        try {
            java.util.Map<java.lang.String, java.lang.Object> map = this.b;
            if (map != null) {
                return com.anythink.core.common.o.i.c(map.get(str).toString());
            }
            return null;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private int c() {
        return this.e;
    }

    private static com.anythink.core.d.d c(java.lang.String str) {
        try {
            com.anythink.core.d.d dVar = new com.anythink.core.d.d();
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            dVar.c = true;
            dVar.d = jSONObject.optInt(v);
            dVar.b = com.anythink.core.common.o.i.c(jSONObject.optString(x));
            dVar.g = 1;
            dVar.h = 1;
            return dVar;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private int d() {
        return this.g;
    }

    private int e() {
        return this.h;
    }

    private java.lang.String f() {
        return this.i;
    }

    private int g() {
        return this.j;
    }

    private long h() {
        return this.k;
    }

    private java.util.Map<java.lang.String, java.lang.String> i() {
        return this.l;
    }

    private java.lang.String j() {
        return this.a;
    }

    private boolean k() {
        return this.c;
    }

    public final long a() {
        return this.f;
    }
}
