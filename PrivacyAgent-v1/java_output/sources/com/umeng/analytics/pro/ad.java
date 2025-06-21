package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ad extends com.umeng.analytics.pro.ab {
    private java.lang.String a;
    private java.lang.String b;

    public ad(java.lang.String str, java.util.ArrayList<com.umeng.analytics.pro.ac> arrayList) {
        super(str, arrayList);
        this.a = "";
        this.b = "";
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public org.json.JSONObject a(java.lang.String str, org.json.JSONObject jSONObject) {
        org.json.JSONObject a = super.a(str, jSONObject);
        if (a != null) {
            try {
                a.put(com.umeng.ccg.a.v, this.a);
                a.put("action", this.b);
            } catch (java.lang.Throwable unused) {
            }
        }
        return a;
    }

    @Override // com.umeng.analytics.pro.ab, com.umeng.analytics.pro.aj
    public void b(java.lang.String str, org.json.JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has("action")) {
            d(jSONObject.optString("action"));
        }
        if (jSONObject.has(com.umeng.ccg.a.v)) {
            c(jSONObject.optString(com.umeng.ccg.a.v));
        }
    }

    public void c(java.lang.String str) {
        this.a = str;
    }

    public java.lang.String d() {
        return this.a;
    }

    public void d(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String e() {
        return this.b;
    }
}
