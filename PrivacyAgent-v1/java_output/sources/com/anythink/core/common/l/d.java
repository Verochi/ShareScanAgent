package com.anythink.core.common.l;

/* loaded from: classes12.dex */
public final class d {
    long a = 30000;
    int b = 1;
    long c = 30000;
    java.util.List<com.anythink.core.common.l.e> d = java.util.Collections.synchronizedList(new java.util.ArrayList());
    java.util.Map<java.lang.String, com.anythink.core.common.l.e> e = new java.util.concurrent.ConcurrentHashMap();

    public static com.anythink.core.common.l.d a(org.json.JSONObject jSONObject) {
        com.anythink.core.common.l.d dVar = new com.anythink.core.common.l.d();
        if (jSONObject == null) {
            return dVar;
        }
        dVar.a = jSONObject.optLong("pre_load_time", 30000L);
        dVar.b = jSONObject.optInt("pre_load_num", 1);
        dVar.c = jSONObject.optLong("pre_load_timeout", 30000L);
        org.json.JSONArray optJSONArray = jSONObject.optJSONArray("formats");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    org.json.JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        com.anythink.core.common.l.e eVar = new com.anythink.core.common.l.e();
                        eVar.a = optJSONObject.optInt("format");
                        eVar.b = optJSONObject.optString("pl_id", "");
                        eVar.c = optJSONObject.optInt("req_pacing");
                        eVar.d = optJSONObject.optInt("ad_cache", 1);
                        eVar.e = optJSONObject.optDouble("ad_ecpm", -1.0d);
                        dVar.d.add(eVar);
                        dVar.e.put(eVar.b, eVar);
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        return dVar;
    }

    public final long a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final long c() {
        return this.c;
    }

    public final java.util.Map<java.lang.String, com.anythink.core.common.l.e> d() {
        return this.e;
    }

    public final java.util.List<com.anythink.core.common.l.e> e() {
        return this.d;
    }
}
