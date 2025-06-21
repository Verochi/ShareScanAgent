package com.tramini.plugin.a.d;

/* loaded from: classes19.dex */
public final class b {
    public static final int a = 1;
    public static final int b = 2;
    public java.lang.String c;
    public int d;
    public java.lang.String e;

    public final org.json.JSONObject a() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("att_pl", this.d);
            jSONObject.put("att_ver", this.c);
            jSONObject.put("att_inf", this.e);
            return jSONObject;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
