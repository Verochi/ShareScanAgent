package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class p2 extends com.zx.a.I8b7.z0 {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedList<com.zx.sdk.api.ZXIDListener>> a = new java.util.concurrent.ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.z0
    public void a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int i = jSONObject.getInt("code");
            java.lang.String optString = jSONObject.optString("message");
            for (java.lang.String str2 : this.a.keySet()) {
                java.util.Iterator<com.zx.sdk.api.ZXIDListener> it = this.a.get(str2).iterator();
                while (it.hasNext()) {
                    com.zx.sdk.api.ZXIDListener next = it.next();
                    if (i == 0) {
                        next.onSuccess(a(str2, jSONObject.getString("data")));
                    } else {
                        com.zx.a.I8b7.y yVar = com.zx.a.I8b7.y.b.a;
                        yVar.getClass();
                        try {
                            yVar.a(new com.zx.a.I8b7.z(yVar, i, optString));
                        } catch (java.lang.Throwable th) {
                            com.zx.a.I8b7.r2.a(th);
                        }
                        next.onFailed(i, optString);
                    }
                }
                this.a.remove(str2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
