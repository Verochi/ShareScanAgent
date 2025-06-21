package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class q2 extends com.zx.a.I8b7.z0 {
    public final java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.LinkedList<com.zx.sdk.api.ZXIDChangedListener>> a = new java.util.concurrent.ConcurrentHashMap<>();

    @Override // com.zx.a.I8b7.z0
    public void a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int i = jSONObject.getInt("code");
            for (java.lang.String str2 : this.a.keySet()) {
                java.util.Iterator<com.zx.sdk.api.ZXIDChangedListener> it = this.a.get(str2).iterator();
                while (it.hasNext()) {
                    com.zx.sdk.api.ZXIDChangedListener next = it.next();
                    if (i == 0) {
                        next.onChange(a(str2, jSONObject.getString("data")));
                    }
                }
                this.a.remove(str2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
    }
}
