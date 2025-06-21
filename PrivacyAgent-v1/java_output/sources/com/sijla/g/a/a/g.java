package com.sijla.g.a.a;

/* loaded from: classes19.dex */
public final class g {
    com.sijla.g.a.b.c a;
    private android.content.Context b;
    private android.content.ServiceConnection c = new com.sijla.g.a.a.h(this);

    public g(android.content.Context context) {
        this.b = context;
    }

    public final void a(com.sijla.g.a.a.c.a aVar) {
        com.sijla.g.a.b.c cVar;
        try {
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.b.bindService(intent, this.c, 1) || (cVar = this.a) == null) {
                return;
            }
            java.lang.String a = cVar.a();
            if (aVar != null) {
                aVar.a(a);
            }
            this.b.unbindService(this.c);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
