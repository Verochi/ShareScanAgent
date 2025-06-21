package com.huawei.hms.framework.network.grs.g.k;

/* loaded from: classes22.dex */
public class c {
    private final com.huawei.hms.framework.network.grs.GrsBaseInfo a;
    private final android.content.Context b;
    private final java.util.Set<java.lang.String> c = new java.util.HashSet();

    public c(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo, android.content.Context context) {
        this.a = grsBaseInfo;
        this.b = context;
    }

    private java.lang.String e() {
        java.util.Set<java.lang.String> b = com.huawei.hms.framework.network.grs.f.b.a(this.b.getPackageName(), this.a).b();
        if (b.isEmpty()) {
            return "";
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<java.lang.String> it = b.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            com.huawei.hms.framework.common.Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (org.json.JSONException unused) {
            return "";
        }
    }

    private java.lang.String f() {
        com.huawei.hms.framework.common.Logger.v("GrsRequestInfo", "getGeoipService enter");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<java.lang.String> it = this.c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            com.huawei.hms.framework.common.Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (org.json.JSONException unused) {
            return "";
        }
    }

    public android.content.Context a() {
        return this.b;
    }

    public void a(java.lang.String str) {
        this.c.add(str);
    }

    public com.huawei.hms.framework.network.grs.GrsBaseInfo b() {
        return this.a;
    }

    public java.lang.String c() {
        return this.c.size() == 0 ? e() : f();
    }

    public java.util.Set<java.lang.String> d() {
        return this.c;
    }
}
