package com.anythink.core.d;

/* loaded from: classes12.dex */
public class c {
    private org.json.JSONObject a;
    private java.util.Map<java.lang.String, java.lang.String> b;
    private java.util.Map<java.lang.String, java.lang.String> c;
    final java.lang.String d = com.anythink.core.d.c.class.getSimpleName();
    private java.util.Map<java.lang.String, java.lang.String> e;

    private org.json.JSONObject a() {
        return this.a;
    }

    private java.util.Map<java.lang.String, java.lang.String> b() {
        return this.b;
    }

    private java.util.Map<java.lang.String, java.lang.String> c() {
        return this.c;
    }

    public final void a(org.json.JSONObject jSONObject, java.lang.String str) {
        java.lang.String optString = jSONObject.optString("cached");
        java.util.Map<java.lang.String, java.lang.String> az = az();
        if (!android.text.TextUtils.isEmpty(optString) && this.a != null) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(optString);
                java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    java.lang.String optString2 = jSONObject2.optString(next);
                    java.lang.String str2 = az.get(next);
                    jSONObject.put(next, this.a.opt(next));
                    if (!android.text.TextUtils.equals(optString2, str2)) {
                        com.anythink.core.common.n.c.a(str, android.text.TextUtils.isEmpty(str) ? "1" : "2", next, optString2, str2);
                        jSONObject2.put(next, str2);
                    }
                }
                jSONObject.put("cached", jSONObject2.toString());
            } catch (java.lang.Throwable unused) {
            }
        }
        if (this instanceof com.anythink.core.d.a) {
            try {
                if (!android.text.TextUtils.isEmpty(((com.anythink.core.d.a) this).e()) && ((com.anythink.core.d.a) this).h() != null && ((com.anythink.core.d.a) this).h().size() > 0 && !android.text.TextUtils.equals(((com.anythink.core.d.a) this).e(), jSONObject.optString(com.anythink.core.d.a.C0174a.h, ""))) {
                    java.util.Iterator<java.lang.String> it = ((com.anythink.core.d.a) this).h().iterator();
                    while (it.hasNext()) {
                        com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(com.anythink.core.common.o.g.a(it.next()));
                    }
                }
                if (!android.text.TextUtils.isEmpty(((com.anythink.core.d.a) this).f()) && ((com.anythink.core.d.a) this).j() != null && ((com.anythink.core.d.a) this).j().size() > 0 && !android.text.TextUtils.equals(((com.anythink.core.d.a) this).f(), jSONObject.optString(com.anythink.core.d.a.C0174a.i, ""))) {
                    java.util.Iterator<java.lang.String> it2 = ((com.anythink.core.d.a) this).j().iterator();
                    while (it2.hasNext()) {
                        com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(com.anythink.core.common.o.g.a(it2.next()));
                    }
                }
                if (android.text.TextUtils.isEmpty(((com.anythink.core.d.a) this).g()) || ((com.anythink.core.d.a) this).i() == null || ((com.anythink.core.d.a) this).i().size() <= 0 || android.text.TextUtils.equals(((com.anythink.core.d.a) this).g(), jSONObject.optString(com.anythink.core.d.a.C0174a.j, ""))) {
                    return;
                }
                java.util.Iterator<java.lang.String> it3 = ((com.anythink.core.d.a) this).i().iterator();
                while (it3.hasNext()) {
                    com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(com.anythink.core.common.o.g.a(it3.next()));
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    public final boolean ay() {
        java.util.Map<java.lang.String, java.lang.String> map = this.c;
        return map == null || map.size() == 0;
    }

    public final synchronized java.util.Map<java.lang.String, java.lang.String> az() {
        if (this.e == null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            this.e = hashMap;
            java.util.Map<java.lang.String, java.lang.String> map = this.b;
            if (map != null) {
                hashMap.putAll(map);
            }
            java.util.Map<java.lang.String, java.lang.String> map2 = this.c;
            if (map2 != null) {
                this.e.putAll(map2);
            }
        }
        return this.e;
    }

    public final void b(org.json.JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public final void c(org.json.JSONObject jSONObject) {
        java.lang.String optString = jSONObject.optString("cached");
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
        java.lang.String optString = jSONObject.optString(com.anythink.core.common.h.c.at);
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
