package com.getui.gtc.extension.distribution.gbd.c;

/* loaded from: classes22.dex */
public final class f {
    private static final java.lang.String a = "GBDConfigBean";
    private static final java.lang.String b = "result";
    private static final java.lang.String c = "tag";
    private static final java.lang.String d = "config";
    private static final java.lang.String e = "timestamp";
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private long i;
    private java.lang.String j;
    private java.util.HashMap<java.lang.String, java.lang.String> k;

    private java.util.HashMap<java.lang.String, java.lang.String> a() {
        return this.k;
    }

    private void a(long j) {
        this.i = j;
    }

    private void a(java.lang.String str) {
        this.f = str;
    }

    private void a(java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        this.k = hashMap;
    }

    private void b(java.lang.String str) {
        this.g = str;
    }

    private boolean b() {
        return "ok".equals(this.f);
    }

    private java.lang.String c() {
        return this.f;
    }

    private void c(java.lang.String str) {
        this.h = str;
    }

    private java.lang.String d() {
        return this.g;
    }

    private void d(java.lang.String str) {
        this.j = str;
    }

    private static com.getui.gtc.extension.distribution.gbd.c.f e(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.c.f fVar = new com.getui.gtc.extension.distribution.gbd.c.f();
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("result");
            fVar.f = optString;
            if ("ok".equals(optString)) {
                fVar.g = jSONObject.optString("tag");
                fVar.h = jSONObject.optString("config");
                fVar.i = jSONObject.optLong("timestamp", java.lang.System.currentTimeMillis());
                fVar.g(fVar.h);
            }
        } catch (org.json.JSONException e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, e2.toString());
        }
        fVar.g(fVar.h);
        return fVar;
    }

    private java.lang.String e() {
        return this.h;
    }

    private long f() {
        return this.i;
    }

    private void f(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("result");
            this.f = optString;
            if ("ok".equals(optString)) {
                this.g = jSONObject.optString("tag");
                this.h = jSONObject.optString("config");
                this.i = jSONObject.optLong("timestamp", java.lang.System.currentTimeMillis());
                g(this.h);
            }
        } catch (org.json.JSONException e2) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, e2.toString());
        }
    }

    private java.lang.String g() {
        return this.j;
    }

    private void g(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    hashMap.put(next, java.lang.String.valueOf(jSONObject.get(next)));
                }
            } catch (org.json.JSONException e2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, e2.toString());
            }
        }
        this.k = hashMap;
    }

    public final java.lang.String toString() {
        return "tag:" + this.g + "\nresult:" + this.f + "\nconfig:" + this.h + "\n";
    }
}
