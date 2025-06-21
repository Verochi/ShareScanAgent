package com.sijla.b;

/* loaded from: classes19.dex */
final class k implements java.lang.Runnable {
    private /* synthetic */ android.app.Application a;
    private /* synthetic */ boolean b = true;

    public k(android.app.Application application) {
        this.a = application;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.sijla.b.g.a(this.a, this.b);
    }
}
