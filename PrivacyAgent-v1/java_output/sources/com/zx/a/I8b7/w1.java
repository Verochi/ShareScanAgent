package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class w1 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String a(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Exception;

    public static java.lang.String b(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.Throwable {
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        java.util.HashMap<java.lang.String, java.lang.String> b2 = com.zx.a.I8b7.i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(b2);
        com.zx.a.I8b7.q1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/uaid/get");
        a2.b = "POST";
        a2.d = com.zx.a.I8b7.s1.a(com.zx.a.I8b7.x0.b("application/json; charset=utf-8"), a(jSONObject, str, str2, str3));
        a2.e = "said get api";
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        com.zx.a.I8b7.q1 q1Var = new com.zx.a.I8b7.q1(aVar);
        o2Var.getClass();
        com.zx.a.I8b7.t1 a3 = new com.zx.a.I8b7.i1(o2Var, q1Var).a();
        if (a3.b == 200) {
            return new org.json.JSONObject(com.zx.a.I8b7.p.a(android.util.Base64.decode(new org.json.JSONObject(a3.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG")).getString("uaid");
        }
        throw new java.lang.RuntimeException("response errCode: " + a3.a("Udid-Error-Code") + ", errMsg: " + a3.a("Udid-Error-Message"));
    }
}
