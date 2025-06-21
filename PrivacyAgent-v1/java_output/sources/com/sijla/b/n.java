package com.sijla.b;

/* loaded from: classes19.dex */
final class n implements java.lang.Runnable {
    private /* synthetic */ java.lang.String a;
    private /* synthetic */ com.sijla.b.m b;

    public n(com.sijla.b.m mVar, java.lang.String str) {
        this.b = mVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        android.app.Application application;
        android.app.Application application2;
        android.app.Application application3;
        android.app.Application unused;
        try {
            java.lang.System.currentTimeMillis();
            application = this.b.a;
            com.sijla.b.m.a(com.sijla.h.a.a.d(application));
            unused = this.b.a;
            com.sijla.b.m.b();
            this.b.c();
            application2 = this.b.a;
            com.sijla.b.g.e(application2);
            com.sijla.b.m mVar = this.b;
            application3 = mVar.a;
            mVar.h = com.sijla.b.g.f(application3);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
