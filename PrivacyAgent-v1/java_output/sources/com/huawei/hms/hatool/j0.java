package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class j0 implements com.huawei.hms.hatool.n0 {
    public android.content.Context a = com.huawei.hms.hatool.b.i();
    public java.lang.String b;
    public org.json.JSONObject c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.Boolean h;

    public j0(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2, java.lang.String str3, long j) {
        this.b = str;
        this.c = jSONObject;
        this.d = str2;
        this.e = str3;
        this.f = java.lang.String.valueOf(j);
        if (com.huawei.hms.hatool.a.i(str2, "oper")) {
            com.huawei.hms.hatool.f0 a = com.huawei.hms.hatool.e0.a().a(str2, j);
            this.g = a.a();
            this.h = java.lang.Boolean.valueOf(a.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        org.json.JSONArray jSONArray;
        com.huawei.hms.hatool.y.c("hmsSdk", "Begin to run EventRecordTask...");
        int h = com.huawei.hms.hatool.b.h();
        int k = com.huawei.hms.hatool.c.k(this.d, this.e);
        if (com.huawei.hms.hatool.q0.a(this.a, "stat_v2_1", h * 1048576)) {
            com.huawei.hms.hatool.y.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            com.huawei.hms.hatool.h0.a().a("", "alltype");
            return;
        }
        com.huawei.hms.hatool.q qVar = new com.huawei.hms.hatool.q();
        qVar.b(this.b);
        qVar.a(this.c.toString());
        qVar.d(this.e);
        qVar.c(this.f);
        qVar.f(this.g);
        java.lang.Boolean bool = this.h;
        qVar.e(bool == null ? null : java.lang.String.valueOf(bool));
        try {
            org.json.JSONObject d = qVar.d();
            java.lang.String a = com.huawei.hms.hatool.u0.a(this.d, this.e);
            java.lang.String a2 = com.huawei.hms.hatool.g0.a(this.a, "stat_v2_1", a, "");
            try {
                jSONArray = !android.text.TextUtils.isEmpty(a2) ? new org.json.JSONArray(a2) : new org.json.JSONArray();
            } catch (org.json.JSONException unused) {
                com.huawei.hms.hatool.y.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new org.json.JSONArray();
            }
            jSONArray.put(d);
            com.huawei.hms.hatool.g0.b(this.a, "stat_v2_1", a, jSONArray.toString());
            if (jSONArray.toString().length() > k * 1024) {
                com.huawei.hms.hatool.h0.a().a(this.d, this.e);
            }
        } catch (org.json.JSONException unused2) {
            com.huawei.hms.hatool.y.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
