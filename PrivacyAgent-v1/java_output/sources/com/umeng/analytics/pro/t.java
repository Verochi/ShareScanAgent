package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class t {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private final long e;

    public static class a {
        public static final com.umeng.analytics.pro.t a = new com.umeng.analytics.pro.t(null);

        private a() {
        }
    }

    private t() {
        this.e = 60000L;
    }

    public /* synthetic */ t(com.umeng.analytics.pro.t.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.umeng.analytics.pro.t a() {
        return com.umeng.analytics.pro.t.a.a;
    }

    private void a(org.json.JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(com.umeng.analytics.pro.f.n)) {
            jSONObject.remove(com.umeng.analytics.pro.f.n);
        }
        if (jSONObject.has(com.umeng.analytics.pro.f.L)) {
            jSONObject.remove(com.umeng.analytics.pro.f.L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(com.umeng.analytics.pro.f.Z)) {
            jSONObject.remove(com.umeng.analytics.pro.f.Z);
        }
        if (jSONObject.has(com.umeng.analytics.pro.f.L)) {
            jSONObject.remove(com.umeng.analytics.pro.f.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    private org.json.JSONArray b() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("id", com.umeng.analytics.pro.aa.a().a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONObject.put("end_time", currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (org.json.JSONException unused) {
        }
        return jSONArray;
    }

    private org.json.JSONArray c() {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("id", com.umeng.analytics.pro.aa.a().d(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(null)));
            jSONObject.put("start_time", currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (org.json.JSONException unused) {
        }
        return jSONArray;
    }

    public int a(android.content.Context context) {
        return java.lang.Integer.valueOf(com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(context, "defcon", java.lang.String.valueOf(0))).intValue();
    }

    public void a(org.json.JSONObject jSONObject, android.content.Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            a(jSONObject, true);
            com.umeng.analytics.pro.k.a(context).b(false, true);
        } else {
            if (a2 == 2) {
                jSONObject.remove(com.umeng.analytics.pro.f.n);
                try {
                    jSONObject.put(com.umeng.analytics.pro.f.n, b());
                } catch (java.lang.Exception unused) {
                }
                a(jSONObject, true);
                com.umeng.analytics.pro.k.a(context).b(false, true);
                return;
            }
            if (a2 == 3) {
                a(jSONObject, false);
                com.umeng.analytics.pro.k.a(context).b(false, true);
            }
        }
    }

    public void b(org.json.JSONObject jSONObject, android.content.Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            if (jSONObject.has(com.umeng.analytics.pro.f.L)) {
                jSONObject.remove(com.umeng.analytics.pro.f.L);
            }
            if (jSONObject.has(com.umeng.analytics.pro.f.n)) {
                try {
                    org.json.JSONArray jSONArray = jSONObject.getJSONArray(com.umeng.analytics.pro.f.n);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(com.umeng.analytics.pro.f.aA)) {
                            jSONObject2.remove(com.umeng.analytics.pro.f.aA);
                        }
                        if (jSONObject2.has(com.umeng.analytics.pro.f.aB)) {
                            jSONObject2.remove(com.umeng.analytics.pro.f.aB);
                        }
                    }
                } catch (org.json.JSONException unused) {
                }
            }
            com.umeng.analytics.pro.k.a(context).a(false, true);
            return;
        }
        if (a2 == 2) {
            if (jSONObject.has(com.umeng.analytics.pro.f.L)) {
                jSONObject.remove(com.umeng.analytics.pro.f.L);
            }
            if (jSONObject.has(com.umeng.analytics.pro.f.n)) {
                jSONObject.remove(com.umeng.analytics.pro.f.n);
            }
            try {
                jSONObject.put(com.umeng.analytics.pro.f.n, c());
            } catch (java.lang.Exception unused2) {
            }
            com.umeng.analytics.pro.k.a(context).a(false, true);
            return;
        }
        if (a2 == 3) {
            if (jSONObject.has(com.umeng.analytics.pro.f.L)) {
                jSONObject.remove(com.umeng.analytics.pro.f.L);
            }
            jSONObject.remove(com.umeng.analytics.pro.f.n);
            com.umeng.analytics.pro.k.a(context).a(false, true);
        }
    }
}
