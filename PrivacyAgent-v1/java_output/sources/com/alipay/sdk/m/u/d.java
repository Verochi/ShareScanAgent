package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public class d {
    public static org.json.JSONObject a(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2) {
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            org.json.JSONObject[] jSONObjectArr = {jSONObject, jSONObject2};
            for (int i = 0; i < 2; i++) {
                org.json.JSONObject jSONObject4 = jSONObjectArr[i];
                if (jSONObject4 != null) {
                    java.util.Iterator<java.lang.String> keys = jSONObject4.keys();
                    while (keys.hasNext()) {
                        java.lang.String next = keys.next();
                        jSONObject3.put(next, jSONObject4.get(next));
                    }
                }
            }
        } catch (org.json.JSONException e) {
            com.alipay.sdk.m.u.e.a(e);
        }
        return jSONObject3;
    }
}
