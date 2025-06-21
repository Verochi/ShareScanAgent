package com.sijla.g;

/* loaded from: classes19.dex */
final class c implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;
    private /* synthetic */ org.json.JSONObject b;

    public c(android.content.Context context, org.json.JSONObject jSONObject) {
        this.a = context;
        this.b = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        org.json.JSONObject jSONObject = this.b;
        try {
            java.lang.String optString = com.sijla.c.d.a.optString("bsurl", "https://b.qchannel03.cn/n/qtbs/v1");
            if (com.sijla.h.c.a(optString)) {
                return;
            }
            org.json.JSONObject a = com.sijla.h.c.a(jSONObject);
            com.sijla.h.c.a.a();
            com.sijla.h.c.a.a(optString, a);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
