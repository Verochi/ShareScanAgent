package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class e2 {
    public static java.lang.String a(int i, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("code", i);
            jSONObject.put("message", str);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject.toString();
    }
}
