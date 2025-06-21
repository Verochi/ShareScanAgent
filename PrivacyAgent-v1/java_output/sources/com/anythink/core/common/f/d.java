package com.anythink.core.common.f;

/* loaded from: classes12.dex */
public final class d {
    public int a;
    public long b;

    public final void a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.a = jSONObject.optInt("number");
            this.b = jSONObject.optLong("loadTime");
        } catch (java.lang.Exception unused) {
        }
    }

    public final java.lang.String toString() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("number", this.a);
            jSONObject.put("loadTime", this.b);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject.toString();
    }
}
