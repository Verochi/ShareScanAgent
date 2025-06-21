package com.vivo.push;

/* loaded from: classes19.dex */
final class j implements java.lang.Runnable {
    final /* synthetic */ com.vivo.push.b.b a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ com.vivo.push.e c;

    public j(com.vivo.push.e eVar, com.vivo.push.b.b bVar, java.lang.String str) {
        this.c = eVar;
        this.a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.a);
        this.c.e(this.b);
    }
}
