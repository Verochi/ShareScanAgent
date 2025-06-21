package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class g implements java.lang.Runnable {

    public class a implements com.zx.module.base.Callback {
        public a(com.zx.a.I8b7.g gVar) {
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                if (new org.json.JSONObject(str).getInt("code") == 10010) {
                    com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
                    l2Var.a.getClass();
                    l2Var.a.a(322, str, true);
                    com.zx.a.I8b7.r2.a("isp net Err had changed refresh: value");
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.n3.b.a.b(new org.json.JSONObject(), new com.zx.a.I8b7.g.a(this), 2);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th);
        }
    }
}
