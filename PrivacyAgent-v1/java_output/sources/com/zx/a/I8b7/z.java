package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class z implements java.lang.Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ java.lang.String b;
    public final /* synthetic */ com.zx.a.I8b7.y c;

    public z(com.zx.a.I8b7.y yVar, int i, java.lang.String str) {
        this.c = yVar;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.c.b.length() >= 10) {
                com.zx.a.I8b7.r2.a("error list length > MAX_COUNT " + this.c.b.length());
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", this.a);
            jSONObject.put("msg", this.b);
            this.c.b.put(jSONObject);
            com.zx.a.I8b7.r2.a("error add:".concat(java.lang.String.valueOf(jSONObject)));
            if (com.zx.a.I8b7.m3.G) {
                com.zx.a.I8b7.r2.a("error save:" + this.c.b.toString());
                com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
                com.zx.a.I8b7.u3 u3Var = l2Var.a;
                java.lang.String jSONArray = this.c.b.toString();
                u3Var.getClass();
                l2Var.a.a(321, jSONArray, true);
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
