package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class f1 extends com.huawei.hms.hatool.o {
    public java.lang.String g = "";

    @Override // com.huawei.hms.hatool.s
    public org.json.JSONObject a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.d);
        jSONObject.put("appid", this.a);
        jSONObject.put("hmac", this.g);
        jSONObject.put("chifer", this.f);
        jSONObject.put("timestamp", this.b);
        jSONObject.put("servicetag", this.c);
        jSONObject.put("requestid", this.e);
        return jSONObject;
    }

    public void g(java.lang.String str) {
        this.g = str;
    }
}
