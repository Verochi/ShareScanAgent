package com.vivo.push;

/* loaded from: classes19.dex */
final class k implements java.lang.Runnable {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ com.vivo.push.e b;

    public k(com.vivo.push.e eVar, java.lang.String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.vivo.push.e.a d;
        d = this.b.d(this.a);
        if (d != null) {
            d.a(1003, new java.lang.Object[0]);
        }
    }
}
