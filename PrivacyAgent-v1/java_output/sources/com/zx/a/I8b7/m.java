package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class m implements com.zx.a.I8b7.m2.b {
    public final /* synthetic */ java.lang.String a;

    public m(java.lang.String str) {
        this.a = str;
    }

    @Override // com.zx.a.I8b7.m2.b
    public void a() {
        b(null);
    }

    @Override // com.zx.a.I8b7.m2.b
    public void a(int i, java.lang.String str) {
    }

    @Override // com.zx.a.I8b7.m2.b
    public void a(android.net.Network network) {
        b(network);
    }

    public final void b(android.net.Network network) {
        try {
            org.json.JSONArray jSONArray = new org.json.JSONObject(this.a).getJSONArray("config");
            for (int i = 0; i < jSONArray.length(); i++) {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.zx.a.I8b7.m3.k.put(network != null ? com.zx.a.I8b7.d0.a(network, jSONObject) : com.zx.a.I8b7.e0.a(jSONObject));
            }
            com.zx.a.I8b7.l2 l2Var = com.zx.a.I8b7.l2.a.a;
            com.zx.a.I8b7.u3 u3Var = l2Var.a;
            org.json.JSONArray jSONArray2 = com.zx.a.I8b7.m3.k;
            u3Var.getClass();
            if (jSONArray2 != null) {
                l2Var.a.a(63, jSONArray2.toString(), true);
                com.zx.a.I8b7.r2.a("reqBZ had changed refresh:".concat(java.lang.String.valueOf(jSONArray2)));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.r2.a(th.getMessage());
        }
    }
}
