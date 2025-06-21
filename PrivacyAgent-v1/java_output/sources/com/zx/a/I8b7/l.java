package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class l {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    @com.zx.module.annotation.Java2C.Method2C
    private static native java.lang.String b() throws java.lang.Exception;

    public static void c() throws java.lang.Exception {
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        java.util.HashMap<java.lang.String, java.lang.String> b2 = com.zx.a.I8b7.i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(b2);
        com.zx.a.I8b7.q1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/config/init");
        a2.b = "POST";
        a2.d = com.zx.a.I8b7.s1.a(com.zx.a.I8b7.x0.b("application/json; charset=utf-8"), b());
        a2.e = "request config api";
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        com.zx.a.I8b7.q1 q1Var = new com.zx.a.I8b7.q1(aVar);
        o2Var.getClass();
        com.zx.a.I8b7.t1 a3 = new com.zx.a.I8b7.i1(o2Var, q1Var).a();
        if (a3.b != 200) {
            throw new java.lang.RuntimeException("response errCode: " + a3.a("Udid-Error-Code") + ", errMsg: " + a3.a("Udid-Error-Message"));
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject(com.zx.a.I8b7.p.a(android.util.Base64.decode(new org.json.JSONObject(a3.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG"));
        java.lang.String string = jSONObject.getString("configVersion");
        com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
        l2Var.a.getClass();
        if (!android.text.TextUtils.equals(string, com.zx.a.I8b7.m3.o)) {
            com.zx.a.I8b7.m3.o = string;
            l2Var.a.a(4, string, false);
        }
        org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("fieldConfig");
        com.zx.a.I8b7.u3 u3Var = l2Var.a;
        java.lang.String jSONObject3 = jSONObject2.toString();
        u3Var.getClass();
        if (!android.text.TextUtils.equals(jSONObject3, com.zx.a.I8b7.m3.x)) {
            com.zx.a.I8b7.m3.x = jSONObject3;
            l2Var.a.a(11, jSONObject3, true);
        }
        org.json.JSONObject jSONObject4 = jSONObject.getJSONObject("reportConfig");
        com.zx.a.I8b7.u3 u3Var2 = l2Var.a;
        java.lang.String jSONObject5 = jSONObject4.toString();
        u3Var2.getClass();
        if (!android.text.TextUtils.equals(jSONObject5, com.zx.a.I8b7.m3.y)) {
            com.zx.a.I8b7.m3.y = jSONObject5;
            l2Var.a.a(12, jSONObject5, true);
        }
        org.json.JSONObject jSONObject6 = jSONObject.getJSONObject("cryptoConfig");
        com.zx.a.I8b7.u3 u3Var3 = l2Var.a;
        java.lang.String jSONObject7 = jSONObject6.toString();
        u3Var3.getClass();
        if (!android.text.TextUtils.equals(jSONObject7, com.zx.a.I8b7.m3.z)) {
            com.zx.a.I8b7.m3.z = jSONObject7;
            l2Var.a.a(15, jSONObject7, true);
        }
        org.json.JSONObject optJSONObject = jSONObject.optJSONObject("appConfig");
        if (optJSONObject != null) {
            com.zx.a.I8b7.r2.a("处理 appConfig ");
            try {
                org.json.JSONArray jSONArray = optJSONObject.getJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
                if (jSONArray == null || jSONArray.length() <= 0) {
                    com.zx.a.I8b7.r2.b("appConfig list is empty");
                } else {
                    int length = jSONArray.length();
                    int i = optJSONObject.getInt("type");
                    if (i == 1) {
                        for (int i2 = 0; i2 < length; i2++) {
                            jSONArray.put(i2, com.zx.a.I8b7.p.a(android.util.Base64.decode(jSONArray.getString(i2), 2), a, "UDID_ENC_AUTHTAG"));
                        }
                    } else if (i == 3) {
                        javax.crypto.SecretKey a4 = com.zx.a.I8b7.p.a(b, com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
                        for (int i3 = 0; i3 < length; i3++) {
                            jSONArray.put(i3, new java.lang.String(com.zx.a.I8b7.p.a("AES/CBC/PKCS7Padding", a4, new javax.crypto.spec.IvParameterSpec("UDID_ENC_AUTHTAG".getBytes(java.nio.charset.StandardCharsets.UTF_8)), android.util.Base64.decode(jSONArray.getString(i3), 2)), java.nio.charset.StandardCharsets.UTF_8));
                        }
                    }
                    com.zx.a.I8b7.l2 l2Var2 = com.zx.a.I8b7.l2.a.a;
                    com.zx.a.I8b7.u3 u3Var4 = l2Var2.a;
                    java.lang.String jSONObject8 = optJSONObject.toString();
                    u3Var4.getClass();
                    if (!android.text.TextUtils.equals(jSONObject8, com.zx.a.I8b7.m3.A)) {
                        com.zx.a.I8b7.m3.A = jSONObject8;
                        l2Var2.a.a(21, jSONObject8, true);
                    }
                }
            } catch (java.lang.Exception e) {
                com.zx.a.I8b7.r2.a(e);
            }
        }
        org.json.JSONObject optJSONObject2 = jSONObject.optJSONObject("commonConfig");
        if (optJSONObject2 != null) {
            com.zx.a.I8b7.l2 l2Var3 = com.zx.a.I8b7.l2.a.a;
            com.zx.a.I8b7.u3 u3Var5 = l2Var3.a;
            java.lang.String jSONObject9 = optJSONObject2.toString();
            u3Var5.getClass();
            if (!android.text.TextUtils.equals(jSONObject9, com.zx.a.I8b7.m3.B)) {
                com.zx.a.I8b7.m3.B = jSONObject9;
                l2Var3.a.a(22, jSONObject9, true);
            }
        }
        org.json.JSONObject optJSONObject3 = jSONObject.optJSONObject("invokeConfig");
        if (optJSONObject3 != null) {
            com.zx.a.I8b7.l2 l2Var4 = com.zx.a.I8b7.l2.a.a;
            com.zx.a.I8b7.u3 u3Var6 = l2Var4.a;
            java.lang.String jSONObject10 = optJSONObject3.toString();
            synchronized (u3Var6) {
                if (!android.text.TextUtils.equals(jSONObject10, com.zx.a.I8b7.m3.C)) {
                    com.zx.a.I8b7.m3.C = jSONObject10;
                    com.zx.a.I8b7.m3.c();
                    l2Var4.a.a(19, com.zx.a.I8b7.m3.C, true);
                }
            }
        }
        if (com.zx.a.I8b7.m3.p) {
            return;
        }
        com.zx.a.I8b7.l2 l2Var5 = com.zx.a.I8b7.l2.a.a;
        l2Var5.a.getClass();
        if (true != com.zx.a.I8b7.m3.p) {
            com.zx.a.I8b7.m3.p = true;
            com.zx.a.I8b7.u3 u3Var7 = l2Var5.a;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.zx.a.I8b7.m3.p);
            u3Var7.a(6, sb.toString(), false);
        }
    }
}
