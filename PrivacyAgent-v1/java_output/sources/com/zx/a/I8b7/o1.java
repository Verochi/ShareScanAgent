package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class o1 implements java.lang.Runnable {

    public class a implements com.zx.module.base.Callback {
        public a(com.zx.a.I8b7.o1 o1Var) {
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                if (jSONObject.getInt("code") == 0) {
                    com.zx.a.I8b7.v1.b(jSONObject.getJSONObject("data").getString("type"), jSONObject.getJSONObject("data").getString("code"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.n3.b.a.b(new org.json.JSONObject(), new com.zx.a.I8b7.o1.a(this), 2);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
