package com.alipay.sdk.m.p;

/* loaded from: classes.dex */
public abstract class e {
    public static final java.lang.String c = "msp-gzip";
    public static final java.lang.String d = "Msp-Param";
    public static final java.lang.String e = "Operation-Type";
    public static final java.lang.String f = "content-type";
    public static final java.lang.String g = "Version";
    public static final java.lang.String h = "AppId";
    public static final java.lang.String i = "des-mode";
    public static final java.lang.String j = "namespace";
    public static final java.lang.String k = "api_name";
    public static final java.lang.String l = "api_version";
    public static final java.lang.String m = "data";
    public static final java.lang.String n = "params";
    public static final java.lang.String o = "public_key";
    public static final java.lang.String p = "device";
    public static final java.lang.String q = "action";
    public static final java.lang.String r = "type";

    /* renamed from: s, reason: collision with root package name */
    public static final java.lang.String f84s = "method";
    public boolean a = true;
    public boolean b = true;

    public static java.lang.String a(com.alipay.sdk.m.o.a.b bVar, java.lang.String str) {
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map;
        java.util.List<java.lang.String> list;
        if (bVar == null || str == null || (map = bVar.a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return android.text.TextUtils.join(",", list);
    }

    public static org.json.JSONObject a(java.lang.String str, java.lang.String str2) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put("method", str2);
        jSONObject.put("action", jSONObject2);
        return jSONObject;
    }

    public static boolean a(com.alipay.sdk.m.o.a.b bVar) {
        return java.lang.Boolean.valueOf(a(bVar, c)).booleanValue();
    }

    public static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str).getJSONObject("data");
            if (!jSONObject.has("params")) {
                return false;
            }
            java.lang.String optString = jSONObject.getJSONObject("params").optString(o, null);
            if (android.text.TextUtils.isEmpty(optString)) {
                return false;
            }
            com.alipay.sdk.m.m.b.a(optString);
            return true;
        } catch (org.json.JSONException e2) {
            com.alipay.sdk.m.u.e.a(e2);
            return false;
        }
    }

    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, android.content.Context context) throws java.lang.Throwable {
        return a(aVar, context, "");
    }

    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        return a(aVar, context, str, com.alipay.sdk.m.u.m.b(context));
    }

    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        return a(aVar, context, str, str2, true);
    }

    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str, java.lang.String str2, boolean z) throws java.lang.Throwable {
        com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.z, "Packet: " + str2);
        com.alipay.sdk.m.p.c cVar = new com.alipay.sdk.m.p.c(this.b);
        com.alipay.sdk.m.p.b bVar = new com.alipay.sdk.m.p.b(a(aVar), a(aVar, str, a()));
        java.util.Map<java.lang.String, java.lang.String> a = a(false, str);
        com.alipay.sdk.m.p.d a2 = cVar.a(bVar, this.a, a.get("iSr"));
        com.alipay.sdk.m.o.a.b a3 = com.alipay.sdk.m.o.a.a(context, new com.alipay.sdk.m.o.a.C0039a(str2, a(a2.b(), str), a2.a()));
        if (a3 == null) {
            throw new java.lang.RuntimeException("Response is null.");
        }
        com.alipay.sdk.m.p.b a4 = cVar.a(new com.alipay.sdk.m.p.d(a(a3), a3.c), a.get("iSr"));
        return (a4 != null && a(a4.b()) && z) ? a(aVar, context, str, str2, false) : a4;
    }

    public java.lang.String a(com.alipay.sdk.m.s.a aVar) throws org.json.JSONException {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put(p, android.os.Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put(l, b());
        return a(aVar, hashMap, new java.util.HashMap<>());
    }

    public java.lang.String a(com.alipay.sdk.m.s.a aVar, java.lang.String str, org.json.JSONObject jSONObject) {
        com.alipay.sdk.m.s.b d2 = com.alipay.sdk.m.s.b.d();
        com.alipay.sdk.m.t.a a = com.alipay.sdk.m.t.a.a(d2.b());
        org.json.JSONObject a2 = com.alipay.sdk.m.u.d.a(new org.json.JSONObject(), jSONObject);
        try {
            a2.put(com.alipay.sdk.m.l.b.d, str);
            a2.put("tid", a.d());
            a2.put(com.alipay.sdk.m.l.b.b, d2.a().a(aVar, a, c()));
            a2.put(com.alipay.sdk.m.l.b.e, com.alipay.sdk.m.u.n.a(aVar, d2.b(), com.alipay.sdk.m.j.a.d, false));
            a2.put(com.alipay.sdk.m.l.b.f, com.alipay.sdk.m.u.n.h(d2.b()));
            a2.put("app_key", com.alipay.sdk.m.l.a.f);
            a2.put(com.alipay.sdk.m.l.b.g, d2.c());
            a2.put(com.alipay.sdk.m.l.b.j, a.c());
            a2.put(com.alipay.sdk.m.l.b.k, com.alipay.sdk.m.m.b.b(d2.b()));
        } catch (java.lang.Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BodyErr", th);
            com.alipay.sdk.m.u.e.a(th);
        }
        return a2.toString();
    }

    public java.lang.String a(com.alipay.sdk.m.s.a aVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2) throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        if (hashMap != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : hashMap2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put("params", jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public java.util.Map<java.lang.String, java.lang.String> a(boolean z, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(c, java.lang.String.valueOf(z));
        hashMap.put(e, "alipay.msp.cashier.dispatch.bytes");
        hashMap.put(f, com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put("Version", "2.0");
        hashMap.put("AppId", "TAOBAO");
        hashMap.put(d, com.alipay.sdk.m.p.a.a(str));
        hashMap.put(i, "CBC");
        return hashMap;
    }

    public abstract org.json.JSONObject a() throws org.json.JSONException;

    public java.lang.String b() {
        return com.igexin.assist.control.xiaomi.ManufacturePushManager.XIAOMI_VERSION;
    }

    public abstract boolean c();
}
