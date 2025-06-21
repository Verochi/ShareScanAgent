package com.sijla.b;

/* loaded from: classes19.dex */
final class i implements java.lang.Runnable {
    private /* synthetic */ android.content.Context a;

    public i(android.content.Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (com.sijla.h.c.a(this.a, "hwbdts", 36000L)) {
                org.json.JSONObject e = com.sijla.h.c.e(this.a);
                e.put("tp", "deviceos");
                e.put("lv", com.alipay.sdk.m.l.c.f);
                e.put("osname", com.sijla.h.c.a());
                com.sijla.h.c.a.a();
                com.sijla.h.c.a.a("https://d.qchannel03.cn/aul", ("data=" + e.toString()).getBytes(), new com.sijla.h.c.a.a.a());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
