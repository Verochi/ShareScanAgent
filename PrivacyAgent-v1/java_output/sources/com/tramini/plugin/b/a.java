package com.tramini.plugin.b;

/* loaded from: classes19.dex */
public class a {
    private org.json.JSONObject a;
    private java.util.Map<java.lang.String, java.lang.String> b;
    private java.util.Map<java.lang.String, java.lang.String> c;
    private java.util.Map<java.lang.String, java.lang.String> d;

    private org.json.JSONObject b() {
        return this.a;
    }

    private java.util.Map<java.lang.String, java.lang.String> c() {
        return this.b;
    }

    private java.util.Map<java.lang.String, java.lang.String> d() {
        return this.c;
    }

    public final synchronized java.util.Map<java.lang.String, java.lang.String> a() {
        if (this.d == null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            this.d = hashMap;
            java.util.Map<java.lang.String, java.lang.String> map = this.b;
            if (map != null) {
                hashMap.putAll(map);
            }
            java.util.Map<java.lang.String, java.lang.String> map2 = this.c;
            if (map2 != null) {
                this.d.putAll(map2);
            }
        }
        return this.d;
    }

    public final void a(org.json.JSONObject jSONObject) {
        java.lang.String optString = jSONObject.optString(com.tramini.plugin.b.b.a.a);
        java.util.Map<java.lang.String, java.lang.String> a = a();
        if (android.text.TextUtils.isEmpty(optString) || this.a == null) {
            return;
        }
        try {
            org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString);
            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                java.lang.String optString2 = jSONObject2.optString(next);
                java.lang.String str = a.get(next);
                jSONObject.put(next, this.a.opt(next));
                if (!android.text.TextUtils.equals(optString2, str)) {
                    com.tramini.plugin.a.a.a.a(next, optString2, str);
                    jSONObject2.put(next, str);
                }
            }
            jSONObject.put(com.tramini.plugin.b.b.a.a, jSONObject2.toString());
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void b(org.json.JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public final void c(org.json.JSONObject jSONObject) {
        java.lang.String optString = jSONObject.optString(com.tramini.plugin.b.b.a.a);
        java.util.HashMap hashMap = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(optString)) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString);
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    hashMap.put(next, jSONObject2.optString(next));
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        this.b = hashMap;
    }

    public final void d(org.json.JSONObject jSONObject) {
        java.lang.String optString = jSONObject.optString(com.tramini.plugin.b.b.a.b);
        java.util.HashMap hashMap = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(optString)) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString);
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    hashMap.put(next, jSONObject2.optString(next));
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        this.c = hashMap;
    }
}
