package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class g1 extends com.huawei.hms.hatool.p {
    public java.lang.String f;
    public java.lang.String g;
    public java.lang.String h;

    @Override // com.huawei.hms.hatool.s
    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("_rom_ver", this.h);
        jSONObject.put("_emui_ver", this.a);
        jSONObject.put("_model", android.os.Build.MODEL);
        jSONObject.put("_mcc", this.f);
        jSONObject.put("_mnc", this.g);
        jSONObject.put("_package_name", this.b);
        jSONObject.put("_app_ver", this.c);
        jSONObject.put("_lib_ver", "2.2.0.313");
        jSONObject.put("_channel", this.d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.e);
        return jSONObject;
    }

    public void f(java.lang.String str) {
        this.f = str;
    }

    public void g(java.lang.String str) {
        this.g = str;
    }

    public void h(java.lang.String str) {
        this.h = str;
    }
}
