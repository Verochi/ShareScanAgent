package com.sijla.h;

/* loaded from: classes19.dex */
final class d implements com.sijla.h.e {
    private /* synthetic */ java.lang.String a;

    public d(java.lang.String str) {
        this.a = str;
    }

    @Override // com.sijla.h.e
    public final org.json.JSONObject a(android.content.Context context) {
        java.lang.String g;
        try {
            org.json.JSONObject e = com.sijla.h.c.e(context);
            e.put("tp", this.a);
            g = com.sijla.h.c.g(context);
            e.put("v", com.sijla.h.c.b(g));
            e.put("dft", "1");
            return e;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
