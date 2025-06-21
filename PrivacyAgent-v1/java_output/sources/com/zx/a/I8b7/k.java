package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class k {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    public static native void a(java.lang.String str);

    public static java.lang.String b(java.lang.String str) throws java.lang.Exception {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
        jSONObject2.put(com.umeng.analytics.pro.bo.al, com.zx.a.I8b7.m3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put("code", str);
        return new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8);
    }
}
