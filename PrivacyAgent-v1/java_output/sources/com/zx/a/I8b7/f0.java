package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class f0 {
    public static javax.crypto.SecretKey a;
    public static byte[] b;
    public static final java.security.SecureRandom c = new java.security.SecureRandom();

    @com.zx.module.annotation.Java2C.Method2C
    public static native synchronized java.lang.String a();

    public static void b() throws java.lang.Exception {
        java.lang.String str;
        java.lang.String str2;
        com.zx.a.I8b7.q1.a aVar = new com.zx.a.I8b7.q1.a();
        java.util.HashMap<java.lang.String, java.lang.String> b2 = com.zx.a.I8b7.i0.b(a());
        aVar.c.clear();
        aVar.c.putAll(b2);
        com.zx.a.I8b7.q1.a a2 = aVar.a("https://zxid-m.mobileservice.cn/sdk/module/getCoreModule");
        a2.b = "POST";
        com.zx.a.I8b7.x0 b3 = com.zx.a.I8b7.x0.b("application/json; charset=utf-8");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        jSONObject2.put("lid", com.zx.a.I8b7.m3.a(com.zx.a.I8b7.m3.h));
        jSONObject2.put(com.umeng.analytics.pro.bo.al, com.zx.a.I8b7.m3.i);
        jSONObject.put("ctx", jSONObject2);
        jSONObject.put(com.alipay.sdk.m.x.d.D, com.zx.a.I8b7.i0.d());
        jSONObject.put("deviceInfo", com.zx.a.I8b7.i0.b());
        a2.d = com.zx.a.I8b7.s1.a(b3, new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.a(jSONObject.toString(), a, "UDID_ENC_AUTHTAG"), 2), java.nio.charset.StandardCharsets.UTF_8));
        a2.e = "request getCoreModule api";
        com.zx.a.I8b7.o2 o2Var = com.zx.a.I8b7.i0.a;
        com.zx.a.I8b7.q1 q1Var = new com.zx.a.I8b7.q1(aVar);
        o2Var.getClass();
        com.zx.a.I8b7.t1 a3 = new com.zx.a.I8b7.i1(o2Var, q1Var).a();
        if (a3.b != 200) {
            throw new java.lang.RuntimeException("response errCode: " + a3.a("Udid-Error-Code") + ", errMsg: " + a3.a("Udid-Error-Message"));
        }
        org.json.JSONObject jSONObject3 = new org.json.JSONObject(com.zx.a.I8b7.p.a(android.util.Base64.decode(new org.json.JSONObject(a3.e.b()).getString("data"), 2), a, "UDID_ENC_AUTHTAG"));
        if (jSONObject3.getBoolean("enable")) {
            org.json.JSONObject jSONObject4 = jSONObject3.getJSONObject(com.umeng.analytics.pro.bo.e);
            jSONObject4.getString("version");
            java.lang.String string = jSONObject4.getString("checksum");
            byte[] decode = android.util.Base64.decode(jSONObject4.getString("data"), 0);
            if (!android.text.TextUtils.equals(string, com.zx.a.I8b7.p.a("SHA256", decode))) {
                throw new java.io.IOException("zx checksum1 exception");
            }
            com.zx.a.I8b7.r2.a("verify checksum finished");
            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
            jSONObject5.put("mainVersion", com.zx.a.I8b7.m3.b);
            jSONObject5.put("coreVersion", com.zx.a.I8b7.m3.d);
            jSONObject5.put("checksum", string);
            com.zx.a.I8b7.l2.a.a.a.getClass();
            java.lang.String string2 = jSONObject5.getString("coreVersion");
            try {
                str = com.zx.a.I8b7.m3.F.getString("coreVersion");
            } catch (java.lang.Exception unused) {
                str = "";
            }
            if (!android.text.TextUtils.isEmpty(string2) && !android.text.TextUtils.equals(string2, str)) {
                com.zx.a.I8b7.u3 u3Var = com.zx.a.I8b7.l2.a.a.a;
                if (u3Var.b == null) {
                    u3Var.b = u3Var.d();
                }
                try {
                    java.lang.String str3 = new java.lang.String(android.util.Base64.encode(com.zx.a.I8b7.p.b("AES/CBC/PKCS5Padding", com.zx.a.I8b7.m3.v, com.zx.a.I8b7.m3.w, decode), 0), java.nio.charset.StandardCharsets.UTF_8);
                    android.content.ContentValues contentValues = new android.content.ContentValues();
                    contentValues.put("key", (java.lang.Integer) 17);
                    contentValues.put("value", str3);
                    com.zx.a.I8b7.r2.a("replace resultId = ".concat(java.lang.String.valueOf(u3Var.b.replace("zx_table", null, contentValues))));
                } catch (java.lang.Exception e) {
                    com.zx.a.I8b7.r2.b("ZXID updateDBValue valueID:17,value:" + decode + ",error:" + e.toString());
                }
                com.zx.a.I8b7.l2.a.a.a.a(18, jSONObject5.toString(), true);
                com.zx.a.I8b7.m3.F = jSONObject5;
            }
            str2 = "decrypt and checksum finished";
        } else {
            com.zx.a.I8b7.u3 u3Var2 = com.zx.a.I8b7.l2.a.a.a;
            if (u3Var2.b == null) {
                u3Var2.b = u3Var2.d();
            }
            try {
                android.database.sqlite.SQLiteDatabase sQLiteDatabase = u3Var2.b;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("key in(");
                sb.append("17,18");
                sb.append(")");
                sQLiteDatabase.delete("zx_table", sb.toString(), null);
                com.zx.a.I8b7.m3.F = null;
                com.zx.a.I8b7.r2.a("clearCoreModule success");
            } catch (java.lang.Exception e2) {
                java.lang.StringBuilder a4 = com.zx.a.I8b7.f3.a("clearCoreModule error:");
                a4.append(e2.getMessage());
                com.zx.a.I8b7.r2.b(a4.toString());
            }
            str2 = "coreModule enable is false";
        }
        com.zx.a.I8b7.r2.a(str2);
    }
}
