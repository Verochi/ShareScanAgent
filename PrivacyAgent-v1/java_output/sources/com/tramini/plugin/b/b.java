package com.tramini.plugin.b;

/* loaded from: classes19.dex */
public class b extends com.tramini.plugin.b.a {
    public static final java.lang.String a = "b";
    private java.lang.String b;
    private long c;
    private java.util.List d;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tramini.plugin.a.d.c> e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private int n;
    private int o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f438s;

    public static class a {
        public static java.lang.String a = "cached";
        public static java.lang.String b = "n_cache";
        private static java.lang.String c = "si";
        private static java.lang.String d = "scto";
        private static java.lang.String e = "tf";
        private static java.lang.String f = "nl";
        private static java.lang.String g = "t_sw";
        private static java.lang.String h = "att_sw";
        private static java.lang.String i = "plst_addr";
        private static java.lang.String j = "pltk_addr";
        private static java.lang.String k = "cn_plst_addr";
        private static java.lang.String l = "cn_pltk_addr";
    }

    public static com.tramini.plugin.b.b a(java.lang.String str) {
        org.json.JSONArray jSONArray;
        int length;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        com.tramini.plugin.b.b bVar = new com.tramini.plugin.b.b();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            bVar.b(jSONObject);
            bVar.c(jSONObject);
            bVar.d(jSONObject);
            if (jSONObject.isNull(com.tramini.plugin.b.b.a.c)) {
                bVar.b = "";
            } else {
                bVar.b = jSONObject.optString(com.tramini.plugin.b.b.a.c);
            }
            if (jSONObject.isNull(com.tramini.plugin.b.b.a.d)) {
                bVar.c = 3600000L;
            } else {
                bVar.c = jSONObject.optInt(com.tramini.plugin.b.b.a.d);
            }
            if (jSONObject.isNull(com.tramini.plugin.b.b.a.h)) {
                bVar.o = 0;
            } else {
                bVar.o = jSONObject.optInt(com.tramini.plugin.b.b.a.h);
            }
            if (!jSONObject.isNull(com.tramini.plugin.b.b.a.i)) {
                bVar.p = jSONObject.optString(com.tramini.plugin.b.b.a.i);
            }
            if (!jSONObject.isNull(com.tramini.plugin.b.b.a.j)) {
                bVar.q = jSONObject.optString(com.tramini.plugin.b.b.a.j);
            }
            if (!jSONObject.isNull(com.tramini.plugin.b.b.a.k)) {
                bVar.r = jSONObject.optString(com.tramini.plugin.b.b.a.k);
            }
            if (!jSONObject.isNull(com.tramini.plugin.b.b.a.l)) {
                bVar.f438s = jSONObject.optString(com.tramini.plugin.b.b.a.l);
            }
            if (!jSONObject.isNull(com.tramini.plugin.b.b.a.e)) {
                java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tramini.plugin.a.d.c> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<>();
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(jSONObject.optString(com.tramini.plugin.b.b.a.e));
                    java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        try {
                            java.lang.String next = keys.next();
                            com.tramini.plugin.a.d.c cVar = new com.tramini.plugin.a.d.c();
                            org.json.JSONObject optJSONObject = jSONObject2.optJSONObject(next);
                            cVar.d = optJSONObject.optString("pml");
                            cVar.a = optJSONObject.optString(org.apache.tools.ant.taskdefs.email.EmailTask.UU);
                            cVar.b = optJSONObject.optInt("dmin");
                            cVar.c = optJSONObject.optInt("dmax");
                            if (optJSONObject.has("p_s") && !android.text.TextUtils.isEmpty(optJSONObject.optString("p_s"))) {
                                cVar.e = new org.json.JSONArray(optJSONObject.optString("p_s"));
                            }
                            concurrentHashMap.put(next, cVar);
                        } catch (java.lang.Exception unused) {
                        }
                    }
                } catch (java.lang.Exception unused2) {
                }
                bVar.e = concurrentHashMap;
            }
            if (!jSONObject.isNull(com.tramini.plugin.b.b.a.f)) {
                org.json.JSONObject jSONObject3 = new org.json.JSONObject(jSONObject.optString(com.tramini.plugin.b.b.a.f));
                bVar.f = jSONObject3.optString("p1");
                bVar.g = jSONObject3.optString(com.anythink.core.common.h.c.X);
                bVar.h = jSONObject3.optString("p3");
                bVar.i = jSONObject3.optString("p4");
                bVar.j = jSONObject3.optString("p5");
                bVar.k = jSONObject3.optString("p6");
                bVar.l = jSONObject3.optString("p7");
                bVar.m = jSONObject3.optString("p8");
                if (!jSONObject3.isNull("notifications") && (length = (jSONArray = new org.json.JSONArray(jSONObject3.optString("notifications"))).length()) > 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                    bVar.d = arrayList;
                }
            }
            if (jSONObject.isNull(com.tramini.plugin.b.b.a.g)) {
                bVar.n = 0;
            } else {
                bVar.n = jSONObject.optInt(com.tramini.plugin.b.b.a.g);
            }
            return bVar;
        } catch (org.json.JSONException unused3) {
            return null;
        }
    }

    private void a(int i) {
        this.o = i;
    }

    private void a(long j) {
        this.c = j;
    }

    private void a(java.util.List list) {
        this.d = list;
    }

    private void a(java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tramini.plugin.a.d.c> concurrentHashMap) {
        this.e = concurrentHashMap;
    }

    private void b(int i) {
        this.n = i;
    }

    private void b(java.lang.String str) {
        this.b = str;
    }

    private void c(java.lang.String str) {
        this.f = str;
    }

    private void d(java.lang.String str) {
        this.g = str;
    }

    private void e(java.lang.String str) {
        this.h = str;
    }

    private void f(java.lang.String str) {
        this.i = str;
    }

    private void g(java.lang.String str) {
        this.j = str;
    }

    private void h(java.lang.String str) {
        this.k = str;
    }

    private void i(java.lang.String str) {
        this.l = str;
    }

    private void j(java.lang.String str) {
        this.m = str;
    }

    private void k(java.lang.String str) {
        this.p = str;
    }

    private void l(java.lang.String str) {
        this.q = str;
    }

    private void m(java.lang.String str) {
        this.r = str;
    }

    private void n(java.lang.String str) {
        this.f438s = str;
    }

    private java.lang.String q() {
        return this.k;
    }

    private java.lang.String r() {
        return this.r;
    }

    private java.lang.String s() {
        return this.f438s;
    }

    public final int b() {
        return this.o;
    }

    public final java.lang.String c() {
        return this.b;
    }

    public final long d() {
        return this.c;
    }

    public final java.util.List<java.lang.String> e() {
        return this.d;
    }

    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.tramini.plugin.a.d.c> f() {
        return this.e;
    }

    public final java.lang.String g() {
        return this.f;
    }

    public final java.lang.String h() {
        return this.g;
    }

    public final java.lang.String i() {
        return this.h;
    }

    public final java.lang.String j() {
        return this.i;
    }

    public final java.lang.String k() {
        return this.j;
    }

    public final java.lang.String l() {
        return this.l;
    }

    public final java.lang.String m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final java.lang.String o() {
        return this.p;
    }

    public final java.lang.String p() {
        return this.q;
    }
}
