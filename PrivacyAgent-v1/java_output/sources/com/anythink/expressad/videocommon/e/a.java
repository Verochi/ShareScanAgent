package com.anythink.expressad.videocommon.e;

/* loaded from: classes12.dex */
public final class a {
    public static final int a = 1000;
    public static final int b = 1000;
    private java.util.Map<java.lang.String, java.lang.Integer> c;
    private java.util.Map<java.lang.String, com.anythink.expressad.videocommon.c.c> d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;

    private static com.anythink.expressad.videocommon.e.a a(java.lang.String str) {
        com.anythink.expressad.videocommon.e.a aVar;
        com.anythink.expressad.videocommon.e.a aVar2 = null;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                aVar = new com.anythink.expressad.videocommon.e.a();
            } catch (java.lang.Exception e) {
                e = e;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                org.json.JSONObject optJSONObject = jSONObject.optJSONObject(com.anythink.expressad.videocommon.e.b.a);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    java.util.Iterator<java.lang.String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        java.lang.String next = keys.next();
                        int optInt = optJSONObject.optInt(next, 1000);
                        if (!android.text.TextUtils.isEmpty(next)) {
                            if (android.text.TextUtils.isEmpty(next) || optInt != 0) {
                                hashMap.put(next, java.lang.Integer.valueOf(optInt));
                            } else {
                                hashMap.put(next, 1000);
                            }
                        }
                    }
                    aVar.c = hashMap;
                }
                aVar.d = com.anythink.expressad.videocommon.c.c.a(jSONObject.optJSONArray("reward"));
                aVar.e = jSONObject.optLong("getpf", 43200L);
                aVar.f = jSONObject.optLong(com.anythink.expressad.videocommon.e.b.x, 5400L);
                aVar.g = jSONObject.optLong("plct", com.anythink.expressad.d.a.b.P);
                aVar.h = jSONObject.optLong("dlct", com.anythink.expressad.d.a.b.P);
                aVar.i = jSONObject.optLong(com.anythink.expressad.videocommon.e.b.A, 5L);
                aVar.j = jSONObject.optLong("current_time");
                return aVar;
            } catch (java.lang.Exception e2) {
                e = e2;
                aVar2 = aVar;
                e.printStackTrace();
                return aVar2;
            }
        }
        return aVar2;
    }

    private void a(long j) {
        this.j = j;
    }

    private long l() {
        return this.e * 1000;
    }

    private long m() {
        return this.f * 1000;
    }

    private long n() {
        return this.j;
    }

    private static com.anythink.expressad.videocommon.e.a o() {
        com.anythink.expressad.videocommon.e.a aVar = new com.anythink.expressad.videocommon.e.a();
        java.util.HashMap hashMap = new java.util.HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put("9", 1000);
        hashMap.put("8", 1000);
        java.util.HashMap hashMap2 = new java.util.HashMap(3);
        hashMap2.put("1", new com.anythink.expressad.videocommon.c.c("Virtual Item", 1));
        aVar.c = hashMap;
        aVar.d = hashMap2;
        aVar.e = 43200L;
        aVar.f = 5400L;
        aVar.g = com.anythink.expressad.d.a.b.P;
        aVar.h = com.anythink.expressad.d.a.b.P;
        aVar.i = 5L;
        return aVar;
    }

    public final void a() {
        this.e = 43200L;
    }

    public final void a(java.util.Map<java.lang.String, java.lang.Integer> map) {
        this.c = map;
    }

    public final void b() {
        this.f = 5400L;
    }

    public final void b(java.util.Map<java.lang.String, com.anythink.expressad.videocommon.c.c> map) {
        this.d = map;
    }

    public final long c() {
        return this.g * 1000;
    }

    public final void d() {
        this.g = com.anythink.expressad.d.a.b.P;
    }

    public final long e() {
        return this.h;
    }

    public final void f() {
        this.h = com.anythink.expressad.d.a.b.P;
    }

    public final long g() {
        return this.i;
    }

    public final void h() {
        this.i = 5L;
    }

    public final java.util.Map<java.lang.String, java.lang.Integer> i() {
        if (this.c == null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            this.c = hashMap;
            hashMap.put("1", 1000);
            this.c.put("9", 1000);
            this.c.put("8", 1000);
        }
        return this.c;
    }

    public final java.util.Map<java.lang.String, com.anythink.expressad.videocommon.c.c> j() {
        return this.d;
    }

    public final org.json.JSONObject k() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            java.util.Map<java.lang.String, java.lang.Integer> map = this.c;
            if (map != null && map.size() > 0) {
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    for (java.util.Map.Entry<java.lang.String, java.lang.Integer> entry : this.c.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put(com.anythink.expressad.videocommon.e.b.a, jSONObject2);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            java.util.Map<java.lang.String, com.anythink.expressad.videocommon.c.c> map2 = this.d;
            if (map2 != null && map2.size() > 0) {
                try {
                    org.json.JSONArray jSONArray = new org.json.JSONArray();
                    for (java.util.Map.Entry<java.lang.String, com.anythink.expressad.videocommon.c.c> entry2 : this.d.entrySet()) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        java.lang.String key = entry2.getKey();
                        com.anythink.expressad.videocommon.c.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put("name", value.a());
                            jSONObject3.put("amount", value.b());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.e);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.x, this.f);
            jSONObject.put("plct", this.g);
            jSONObject.put("dlct", this.h);
            jSONObject.put(com.anythink.expressad.videocommon.e.b.A, this.i);
            jSONObject.put("current_time", this.j);
            return jSONObject;
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }
}
