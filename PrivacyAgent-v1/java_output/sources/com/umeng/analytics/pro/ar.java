package com.umeng.analytics.pro;

/* loaded from: classes19.dex */
public class ar implements java.lang.Runnable {
    public static final java.lang.String a = "https://ucc.umeng.com/v2/inn/fetch";
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;

    public ar(java.lang.String str, org.json.JSONObject jSONObject, java.lang.String str2) {
        this.b = str;
        this.c = jSONObject.toString();
        this.d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        org.json.JSONObject jSONObject = null;
        try {
            byte[] a2 = com.umeng.analytics.pro.ap.a(this.b, this.c);
            if (a2 != null) {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(new java.lang.String(a2));
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                try {
                    jSONObject3.put("sourceIucc", this.d);
                    jSONObject3.put("config", jSONObject2);
                } catch (java.lang.Throwable unused) {
                }
                jSONObject = jSONObject3;
            }
        } catch (java.lang.Throwable unused2) {
        }
        com.umeng.ccg.c.a(com.umeng.commonsdk.service.UMGlobalContext.getAppContext(), 102, com.umeng.ccg.d.a(), jSONObject);
    }
}
