package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class d1 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0069, code lost:
    
        if (android.text.TextUtils.equals(com.zx.a.I8b7.l2.a.a.a.a(26), r1.toString()) != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b() throws java.lang.Exception {
        org.json.JSONArray jSONArray;
        java.lang.String a2 = com.zx.a.I8b7.l2.a.a.a.a(25);
        if (!android.text.TextUtils.isEmpty(a2)) {
            try {
                org.json.JSONArray jSONArray2 = new org.json.JSONArray(a2);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                for (int i = 0; i < jSONArray2.length(); i++) {
                    try {
                        arrayList.add(jSONArray2.getString(i));
                    } catch (org.json.JSONException unused) {
                    }
                }
                java.util.Collections.sort(arrayList, new com.zx.a.I8b7.d2());
                jSONArray = new org.json.JSONArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    try {
                        java.lang.String str = (java.lang.String) arrayList.get(i2);
                        if (com.zx.a.I8b7.w3.b(str) != null) {
                            jSONArray.put(str);
                        }
                    } catch (java.lang.Exception unused2) {
                        com.zx.a.I8b7.r2.b("iaps data error");
                    }
                }
            } catch (org.json.JSONException unused3) {
            }
        }
        jSONArray = null;
        if (jSONArray == null) {
            com.zx.a.I8b7.r2.a("laps 和上次一样本次不上报");
            return;
        }
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        java.util.HashMap<java.lang.String, java.lang.String> b2 = com.zx.a.I8b7.i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(b2);
        com.zx.a.I8b7.q1.a a3 = aVar.a("https://zxid-m.mobileservice.cn/sdk/app/depAnalysis");
        a3.b = "POST";
        com.zx.a.I8b7.x0 b3 = com.zx.a.I8b7.x0.b("application/json; charset=utf-8");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
        jSONObject2.put(com.umeng.analytics.pro.bo.al, com.zx.a.I8b7.m3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put(com.alipay.sdk.m.x.d.D, com.zx.a.I8b7.i0.d());
        jSONObject.put("deviceInfo", com.zx.a.I8b7.i0.b());
        jSONObject.put("apps", new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.a(jSONArray.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        a3.d = com.zx.a.I8b7.s1.a(b3, new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        a3.e = "request postIAPS api";
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        com.zx.a.I8b7.q1 q1Var = new com.zx.a.I8b7.q1(aVar);
        o2Var.getClass();
        com.zx.a.I8b7.t1 a4 = new com.zx.a.I8b7.i1(o2Var, q1Var).a();
        if (a4.b != 200) {
            throw new java.lang.RuntimeException("response errCode: " + a4.a("Udid-Error-Code") + ", errMsg: " + a4.a("Udid-Error-Message"));
        }
        com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
        com.zx.a.I8b7.u3 u3Var = l2Var.a;
        java.lang.String jSONArray3 = jSONArray.toString();
        u3Var.getClass();
        if (android.text.TextUtils.isEmpty(jSONArray3)) {
            return;
        }
        l2Var.a.a(26, jSONArray3, true);
    }
}
