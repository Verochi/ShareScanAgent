package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class a {
    public static final java.lang.String a = "ap_req";
    public static final java.lang.String b = "ap_args";
    public static final java.lang.String c = "ap_resp";

    public static com.alipay.sdk.m.g.a a() {
        try {
            try {
                return com.alipay.sdk.m.h.a.a("NP", java.lang.System.currentTimeMillis(), new com.alipay.sdk.m.h.c(com.alipay.sdk.m.s.b.d().c()), (short) com.alipay.sdk.m.k.a.c.a(com.alipay.sdk.m.s.b.d().b()), new com.alipay.sdk.m.h.f());
            } catch (java.lang.Exception unused) {
                return null;
            }
        } catch (java.lang.Exception unused2) {
            return com.alipay.sdk.m.h.a.c();
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a(com.alipay.sdk.m.s.a aVar) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        try {
            com.alipay.sdk.m.g.a a2 = a();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            android.content.Context a3 = aVar != null ? aVar.a() : null;
            if (a3 == null) {
                a3 = com.alipay.sdk.m.s.b.d().b().getApplicationContext();
            }
            java.lang.String a4 = com.alipay.sdk.m.u.n.a(aVar, a3);
            java.lang.String b2 = com.alipay.sdk.m.w.b.b(aVar, a3);
            jSONObject.put("ap_q", a2 != null ? a2.a() : "");
            jSONObject.put(com.alipay.sdk.m.s.a.z, aVar != null ? aVar.d : "");
            jSONObject.put("u_pd", java.lang.String.valueOf(com.alipay.sdk.m.u.n.g()));
            jSONObject.put("u_lk", java.lang.String.valueOf(com.alipay.sdk.m.u.n.e(com.alipay.sdk.m.u.n.b())));
            jSONObject.put("u_pi", java.lang.String.valueOf(aVar != null ? aVar.g : "_"));
            jSONObject.put("u_fu", a4);
            jSONObject.put("u_oi", b2);
            hashMap.put(a, jSONObject.toString());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(a2 != null ? a2.a() : "");
            sb.append("|");
            sb.append(a4);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_q", sb.toString());
        } catch (java.lang.Exception e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx1", e);
        }
        return hashMap;
    }

    public static org.json.JSONObject a(com.alipay.sdk.m.s.a aVar, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        java.lang.String optString = jSONObject.optString(c);
        try {
            if (android.text.TextUtils.isEmpty(optString)) {
                return null;
            }
            return new org.json.JSONObject(optString);
        } catch (org.json.JSONException e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", e);
            return null;
        }
    }

    public static void a(com.alipay.sdk.m.s.a aVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        org.json.JSONObject a2 = com.alipay.sdk.m.m.a.D().a();
        if (hashMap == null || a2 == null) {
            return;
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ap_r", a2.optString("ap_r"));
        hashMap.putAll(com.alipay.sdk.m.u.n.a(a2));
    }

    public static void a(com.alipay.sdk.m.s.a aVar, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.putOpt(b, jSONObject2);
        } catch (org.json.JSONException e) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "APMEx2", e);
        }
    }
}
