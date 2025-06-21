package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class r0 {
    public static void a(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.hatool.b0 b0Var;
        java.lang.String str3;
        java.lang.String replace = "{url}/getPublicKey?keytype=2".replace("{url}", com.huawei.hms.hatool.c.f(str, str2));
        java.lang.String f = com.huawei.hms.hatool.b.f();
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("App-Id", f);
        try {
            b0Var = com.huawei.hms.hatool.a0.a(replace, new byte[0], hashMap);
        } catch (java.lang.Exception e) {
            com.huawei.hms.hatool.y.e("GetPublicKey", "get pubKey response Exception :" + e.getMessage());
            b0Var = null;
        }
        if (b0Var == null) {
            str3 = "get pubKey response is null";
        } else if (b0Var.b() == 200) {
            if (android.text.TextUtils.isEmpty(b0Var.a())) {
                return;
            }
            c(b0Var.a(), str2);
            return;
        } else {
            str3 = "get pubKey fail HttpCode :" + b0Var.b();
        }
        com.huawei.hms.hatool.y.e("GetPublicKey", str3);
    }

    public static boolean a() {
        java.lang.String a = com.huawei.hms.hatool.b.a();
        if (android.text.TextUtils.isEmpty(a)) {
            a = com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_time_interval", "");
            com.huawei.hms.hatool.b.f(a);
        }
        java.lang.String m = com.huawei.hms.hatool.b.m();
        if (android.text.TextUtils.isEmpty(m)) {
            m = com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_time_last", "");
            com.huawei.hms.hatool.b.c(m);
        }
        if (android.text.TextUtils.isEmpty(a) || android.text.TextUtils.isEmpty(m)) {
            return true;
        }
        try {
            return java.lang.System.currentTimeMillis() - java.lang.Long.parseLong(m) > ((long) java.lang.Integer.parseInt(a));
        } catch (java.lang.NumberFormatException e) {
            com.huawei.hms.hatool.y.e("GetPublicKey", "checkCachePubKey NumberFormatException :" + e.getMessage());
            return true;
        }
    }

    public static java.lang.String b(java.lang.String str, java.lang.String str2) {
        java.lang.String o;
        java.lang.String c = com.huawei.hms.hatool.b.c();
        if (android.text.TextUtils.isEmpty(c)) {
            c = com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_version", "");
            com.huawei.hms.hatool.b.g(c);
        }
        if ("maint".equals(str2)) {
            o = com.huawei.hms.hatool.b.n();
            if (android.text.TextUtils.isEmpty(o)) {
                o = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_maint", ""));
                com.huawei.hms.hatool.b.d(o);
            }
        } else {
            o = com.huawei.hms.hatool.b.o();
            if (android.text.TextUtils.isEmpty(o)) {
                o = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt("HiAnalytics_Sdk_Public_Sp_Key", com.huawei.hms.hatool.g0.a(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_oper", ""));
                com.huawei.hms.hatool.b.e(o);
            }
        }
        if (!android.text.TextUtils.isEmpty(o) && !android.text.TextUtils.isEmpty(c) && !a()) {
            return o;
        }
        com.huawei.hms.hatool.o0.a().a(new com.huawei.hms.hatool.m0(str, str2));
        return null;
    }

    public static void c(java.lang.String str, java.lang.String str2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.lang.String optString = jSONObject.optString("publicKey");
            java.lang.String optString2 = jSONObject.optString("publicKeyOM");
            java.lang.String optString3 = jSONObject.optString("pubkey_version");
            java.lang.String str3 = java.lang.System.currentTimeMillis() + "";
            java.lang.String optString4 = jSONObject.optString("timeInterval");
            com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_oper", com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString));
            com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_maint", com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.encrypt("HiAnalytics_Sdk_Public_Sp_Key", optString2));
            com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_time_interval", optString4);
            com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_version", optString3);
            com.huawei.hms.hatool.g0.b(com.huawei.hms.hatool.b.i(), "Privacy_MY", "public_key_time_last", str3);
            com.huawei.hms.hatool.b.e(optString);
            com.huawei.hms.hatool.b.d(optString2);
            com.huawei.hms.hatool.b.g(optString3);
            com.huawei.hms.hatool.b.c(str3);
            com.huawei.hms.hatool.b.f(optString4);
        } catch (org.json.JSONException e) {
            com.huawei.hms.hatool.y.e("GetPublicKey", "get pubKey parse json JSONException :" + e.getMessage());
        }
    }
}
