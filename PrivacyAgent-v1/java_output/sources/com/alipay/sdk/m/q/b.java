package com.alipay.sdk.m.q;

/* loaded from: classes.dex */
public class b extends com.alipay.sdk.m.p.e {
    @Override // com.alipay.sdk.m.p.e
    public java.lang.String a(com.alipay.sdk.m.s.a aVar, java.util.HashMap<java.lang.String, java.lang.String> hashMap, java.util.HashMap<java.lang.String, java.lang.String> hashMap2) throws org.json.JSONException {
        if (hashMap2 == null) {
            hashMap2 = new java.util.HashMap<>();
        }
        hashMap2.putAll(com.alipay.sdk.m.u.a.a(aVar));
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "cf " + hashMap2);
        return super.a(aVar, hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.m.p.e
    public org.json.JSONObject a() throws org.json.JSONException {
        return com.alipay.sdk.m.p.e.a("sdkConfig", "obtain");
    }

    @Override // com.alipay.sdk.m.p.e
    public java.lang.String b() {
        return "5.0.0";
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return true;
    }
}
