package com.alipay.sdk.m.q;

/* loaded from: classes.dex */
public class d extends com.alipay.sdk.m.p.e {
    public static final java.lang.String t = "log_v";

    @Override // com.alipay.sdk.m.p.e
    public com.alipay.sdk.m.p.b a(com.alipay.sdk.m.s.a aVar, android.content.Context context, java.lang.String str) throws java.lang.Throwable {
        return a(aVar, context, str, com.alipay.sdk.m.l.a.c, true);
    }

    @Override // com.alipay.sdk.m.p.e
    public java.lang.String a(com.alipay.sdk.m.s.a aVar) throws org.json.JSONException {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put(com.alipay.sdk.m.p.e.l, "1.0.0");
        java.util.HashMap<java.lang.String, java.lang.String> hashMap2 = new java.util.HashMap<>();
        hashMap2.put(t, "1.0");
        return a(aVar, hashMap, hashMap2);
    }

    @Override // com.alipay.sdk.m.p.e
    public java.lang.String a(com.alipay.sdk.m.s.a aVar, java.lang.String str, org.json.JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.m.p.e
    public java.util.Map<java.lang.String, java.lang.String> a(boolean z, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.alipay.sdk.m.p.e.c, java.lang.String.valueOf(z));
        hashMap.put(com.alipay.sdk.m.p.e.f, com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        hashMap.put(com.alipay.sdk.m.p.e.i, "CBC");
        return hashMap;
    }

    @Override // com.alipay.sdk.m.p.e
    public org.json.JSONObject a() throws org.json.JSONException {
        return null;
    }

    @Override // com.alipay.sdk.m.p.e
    public boolean c() {
        return false;
    }
}
