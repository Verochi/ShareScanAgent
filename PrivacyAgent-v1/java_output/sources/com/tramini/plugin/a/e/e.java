package com.tramini.plugin.a.e;

/* loaded from: classes19.dex */
public final class e extends com.tramini.plugin.a.e.a {
    public static final int p = 10001;
    private android.content.Context q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private org.json.JSONObject f436s;
    private org.json.JSONObject t;

    public e(android.content.Context context, java.lang.String str, org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        this.q = context;
        this.r = str;
        this.f436s = jSONObject;
        this.t = jSONObject2;
    }

    @Override // com.tramini.plugin.a.e.a
    public final int a() {
        return 1;
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.lang.Object a(java.lang.String str) {
        return str.trim();
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.lang.String b() {
        com.tramini.plugin.a.d.c cVar = com.tramini.plugin.b.c.a(this.q).b().f().get(this.r);
        com.tramini.plugin.a.a.a();
        return cVar != null ? cVar.a : com.tramini.plugin.a.a.c();
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.util.Map<java.lang.String, java.lang.String> c() {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("Content-Encoding", "gzip");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    @Override // com.tramini.plugin.a.e.a
    public final byte[] d() {
        return com.tramini.plugin.a.e.a.b(f());
    }

    @Override // com.tramini.plugin.a.e.a
    public final org.json.JSONObject e() {
        org.json.JSONObject jSONObject = this.f436s;
        return jSONObject == null ? super.e() : jSONObject;
    }

    @Override // com.tramini.plugin.a.e.a
    public final java.lang.String f() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String b = com.tramini.plugin.a.h.c.b(e().toString());
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        jSONArray.put(this.t);
        java.lang.String b2 = com.tramini.plugin.a.h.c.b(jSONArray.toString());
        java.lang.String a = com.tramini.plugin.a.h.f.a("d_version=1.0&dt=" + b2 + "&cm=" + b);
        try {
            jSONObject.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_CROP_MODE, b);
            jSONObject.put(com.amap.api.mapcore.util.dt.a, b2);
            jSONObject.put("d_version", "1.0");
            jSONObject.put("d_sign", a);
            jSONObject.put("pl_c", "5");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    @Override // com.tramini.plugin.a.e.a
    public final boolean g() {
        return false;
    }
}
