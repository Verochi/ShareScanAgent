package com.meizu.cloud.pushsdk.a.a;

/* loaded from: classes23.dex */
public class c {
    private final int a;
    private final java.lang.String b;

    public c(int i, java.lang.String str) {
        this.a = i;
        this.b = str;
    }

    public java.lang.String toString() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("code", this.a);
            jSONObject.put("body", this.b);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        return "[NetResponse] " + jSONObject.toString();
    }
}
