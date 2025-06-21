package com.sijla.b;

/* loaded from: classes19.dex */
final class h implements java.lang.Runnable {
    private /* synthetic */ android.app.Application a;

    public h(android.app.Application application) {
        this.a = application;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            java.lang.System.currentTimeMillis();
            com.sijla.b.g.c((android.content.Context) this.a);
            com.sijla.f.f.a().a(this.a);
            com.sijla.b.g.b(this.a);
            com.sijla.g.a.a(this.a);
            com.sijla.e.a.a(this.a);
            com.sijla.a.a.a(new com.sijla.b.i(this.a));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
