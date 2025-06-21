package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class e1 extends com.huawei.hms.hatool.n {
    public java.lang.String b = "";
    public java.lang.String c = "";
    public java.lang.String d = "";
    public java.lang.String e = "";
    public java.lang.String f = "";
    public java.lang.String g;

    @Override // com.huawei.hms.hatool.s
    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("androidid", this.a);
        jSONObject.put("oaid", this.g);
        jSONObject.put("uuid", this.f);
        jSONObject.put("upid", this.e);
        jSONObject.put("imei", this.b);
        jSONObject.put("sn", this.c);
        jSONObject.put("udid", this.d);
        return jSONObject;
    }

    public void b(java.lang.String str) {
        this.b = str;
    }

    public void c(java.lang.String str) {
        this.g = str;
    }

    public void d(java.lang.String str) {
        this.c = str;
    }

    public void e(java.lang.String str) {
        this.d = str;
    }

    public void f(java.lang.String str) {
        this.e = str;
    }

    public void g(java.lang.String str) {
        this.f = str;
    }
}
