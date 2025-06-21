package com.igexin.push.config;

/* loaded from: classes23.dex */
public final class g {
    private static final java.lang.String a = "IDCConfigParse";

    public static void a(java.lang.String str, boolean z) {
        org.json.JSONObject jSONObject;
        java.lang.String[] a2;
        java.lang.String[] a3;
        java.lang.String[] a4;
        java.lang.String[] a5;
        java.lang.String[] a6;
        com.igexin.c.a.c.a.b(a, " parse idc config data : ".concat(java.lang.String.valueOf(str)));
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("N")) {
            try {
                com.igexin.push.config.SDKUrlConfig.setLocation(jSONObject.getString("N"));
            } catch (org.json.JSONException e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.has("X1") && (a6 = a(jSONObject, "X1")) != null && a6.length > 0) {
            com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(a6);
            if (z) {
                com.igexin.c.a.c.a.b("Detect_IDCConfigParse", "parse idc success, set new xfr address, reset and redetect +++++++++++++++++");
                com.igexin.push.c.c.a().e();
            }
        }
        if (jSONObject.has("X2") && (a5 = a(jSONObject, "X2")) != null && a5.length > 0) {
            com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = a5;
        }
        if (jSONObject.has("B") && (a4 = a(jSONObject, "B")) != null && a4.length > 0) {
            com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = a4;
        }
        if (jSONObject.has("C") && (a3 = a(jSONObject, "C")) != null && a3.length > 0) {
            com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = a3;
        }
        if (!jSONObject.has("LO") || (a2 = a(jSONObject, "LO")) == null || a2.length <= 0) {
            return;
        }
        com.igexin.push.config.SDKUrlConfig.LOG_ADDRESS_IPS = a2;
    }

    private static java.lang.String[] a(org.json.JSONObject jSONObject, java.lang.String str) {
        try {
            org.json.JSONArray jSONArray = jSONObject.getJSONArray(str);
            int length = jSONArray.length();
            java.lang.String[] strArr = new java.lang.String[length];
            for (int i = 0; i < length; i++) {
                if (!"X1".equals(str) && !"X2".equals(str)) {
                    strArr[i] = "https://" + jSONArray.getString(i);
                }
                strArr[i] = "socket://" + jSONArray.getString(i);
            }
            return strArr;
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }
}
