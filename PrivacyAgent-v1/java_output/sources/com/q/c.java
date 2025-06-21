package com.q;

/* loaded from: classes19.dex */
final class c implements java.lang.Runnable {
    public /* synthetic */ android.app.Application n;
    public /* synthetic */ boolean t;
    public /* synthetic */ java.lang.String u;
    public /* synthetic */ java.lang.String v;
    public /* synthetic */ java.lang.String w;
    public /* synthetic */ com.sijla.callback.QtCallBack x;

    public c(android.app.Application application, boolean z, java.lang.String str, java.lang.String str2, java.lang.String str3, com.sijla.callback.QtCallBack qtCallBack) {
        this.n = application;
        this.t = z;
        this.u = str;
        this.v = str2;
        this.w = str3;
        this.x = qtCallBack;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.System.currentTimeMillis();
            android.app.Application application = this.n;
            if (application == null) {
                com.sijla.b.g.b("传入的上下文为null");
                return;
            }
            com.q.Qt.isAllowNetworkConnections(application, this.t);
            if (this.t) {
                com.sijla.h.a.a.k(this.n);
                com.sijla.b.g.a(this.n, this.u, this.v, this.t, this.x);
                com.sijla.c.a.a(this.n);
                com.sijla.b.g.b((android.content.Context) this.n);
                com.sijla.b.d.a(this.n);
                com.sijla.b.g.a(this.n);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
