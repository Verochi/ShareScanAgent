package com.umeng.commonsdk.vchannel;

/* loaded from: classes19.dex */
public class b {
    private java.lang.String b;
    private java.lang.String a = "_$unknown";
    private long c = 0;
    private long d = 0;
    private java.lang.String e = com.umeng.commonsdk.vchannel.a.j;
    private java.util.Map<java.lang.String, java.lang.Object> f = null;

    public b(android.content.Context context) {
        this.b = com.umeng.commonsdk.service.UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public java.lang.String a() {
        return this.a;
    }

    public void a(long j) {
        this.c = j;
    }

    public void a(java.lang.String str) {
        this.a = str;
    }

    public void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.f = map;
    }

    public long b() {
        return this.c;
    }

    public java.util.Map<java.lang.String, java.lang.Object> c() {
        return this.f;
    }

    public org.json.JSONObject d() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("id", this.a);
            jSONObject.put("pn", this.b);
            jSONObject.put("ds", this.d);
            jSONObject.put("ts", this.c);
            java.util.Map<java.lang.String, java.lang.Object> map = this.f;
            if (map != null && map.size() > 0) {
                for (java.lang.String str : this.f.keySet()) {
                    jSONObject.put(str, this.f.get(str));
                }
            }
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put(jSONObject);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put(this.e, jSONArray);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            jSONArray2.put(jSONObject2);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[");
        sb.append("id:" + this.a + ",");
        sb.append("pn:" + this.b + ",");
        sb.append("ts:" + this.c + ",");
        java.util.Map<java.lang.String, java.lang.Object> map = this.f;
        if (map != null && map.size() > 0) {
            for (java.lang.String str : this.f.keySet()) {
                java.lang.Object obj = this.f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.d + "]");
        return sb.toString();
    }
}
