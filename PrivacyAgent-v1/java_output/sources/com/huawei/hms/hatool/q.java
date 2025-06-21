package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class q implements com.huawei.hms.hatool.s {
    public java.lang.String a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;

    @Override // com.huawei.hms.hatool.s
    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("type", this.a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put("event", this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (android.text.TextUtils.isEmpty(this.c)) {
            return null;
        }
        jSONObject.put("properties", new org.json.JSONObject(this.c));
        return jSONObject;
    }

    public void a(java.lang.String str) {
        this.c = str;
    }

    public void a(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString("event");
        this.c = jSONObject.optString("properties");
        this.c = com.huawei.hms.hatool.d.a(this.c, com.huawei.hms.hatool.d0.f().a());
        this.a = jSONObject.optString("type");
        this.d = jSONObject.optString("eventtime");
        this.e = jSONObject.optString("event_session_name");
        this.f = jSONObject.optString("first_session_event");
    }

    public java.lang.String b() {
        return this.d;
    }

    public void b(java.lang.String str) {
        this.b = str;
    }

    public java.lang.String c() {
        return this.a;
    }

    public void c(java.lang.String str) {
        this.d = str;
    }

    public org.json.JSONObject d() {
        org.json.JSONObject a = a();
        a.put("properties", com.huawei.hms.hatool.d.b(this.c, com.huawei.hms.hatool.d0.f().a()));
        return a;
    }

    public void d(java.lang.String str) {
        this.a = str;
    }

    public void e(java.lang.String str) {
        this.f = str;
    }

    public void f(java.lang.String str) {
        this.e = str;
    }
}
