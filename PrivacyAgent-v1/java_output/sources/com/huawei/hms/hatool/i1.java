package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public final class i1 {
    public static com.huawei.hms.hatool.i1 c;
    public android.content.Context a;
    public final java.lang.Object b = new java.lang.Object();

    public static com.huawei.hms.hatool.i1 a() {
        if (c == null) {
            b();
        }
        return c;
    }

    public static synchronized void b() {
        synchronized (com.huawei.hms.hatool.i1.class) {
            if (c == null) {
                c = new com.huawei.hms.hatool.i1();
            }
        }
    }

    public final org.json.JSONObject a(java.util.Map<java.lang.String, java.lang.String> map) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        if (map != null) {
            try {
                for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (org.json.JSONException unused) {
                com.huawei.hms.hatool.y.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    public void a(android.content.Context context) {
        synchronized (this.b) {
            if (this.a != null) {
                return;
            }
            this.a = context;
            com.huawei.hms.hatool.h0.a().a(context);
        }
    }

    public void a(java.lang.String str, int i) {
        com.huawei.hms.hatool.h0.a().a(str, i);
    }

    public void a(java.lang.String str, int i, java.lang.String str2, java.util.LinkedHashMap<java.lang.String, java.lang.String> linkedHashMap) {
        com.huawei.hms.hatool.h0.a().a(str, i, str2, a(linkedHashMap));
    }

    public void a(java.lang.String str, android.content.Context context, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("_constants", str3);
            com.huawei.hms.hatool.h0.a().a(str, 0, str2, jSONObject);
        } catch (org.json.JSONException unused) {
            com.huawei.hms.hatool.y.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }
}
