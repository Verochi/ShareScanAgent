package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class n {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String b() throws java.lang.Exception;

    public static void c() throws java.lang.Throwable {
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        java.util.HashMap<java.lang.String, java.lang.String> b2 = com.zx.a.I8b7.i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(b2);
        com.zx.a.I8b7.q1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/config/v2/init");
        a2.b = "POST";
        a2.d = com.zx.a.I8b7.s1.a(com.zx.a.I8b7.x0.b("application/json; charset=utf-8"), b());
        a2.e = "ConfigV2Request get api";
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        com.zx.a.I8b7.q1 q1Var = new com.zx.a.I8b7.q1(aVar);
        o2Var.getClass();
        com.zx.a.I8b7.t1 a3 = new com.zx.a.I8b7.i1(o2Var, q1Var).a();
        if (a3.b == 200) {
            com.zx.a.I8b7.m2.c.a.a(new com.zx.a.I8b7.m(com.zx.a.I8b7.p.a(android.util.Base64.decode(new org.json.JSONObject(a3.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG")));
            return;
        }
        throw new java.lang.RuntimeException("response errCode: " + a3.a("Udid-Error-Code") + ", errMsg: " + a3.a("Udid-Error-Message"));
    }
}
