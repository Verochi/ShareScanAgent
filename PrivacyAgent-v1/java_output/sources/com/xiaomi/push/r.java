package com.xiaomi.push;

/* loaded from: classes19.dex */
final class r implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.push.p.b a;
    final /* synthetic */ com.xiaomi.push.p b;

    public r(com.xiaomi.push.p pVar, com.xiaomi.push.p.b bVar) {
        this.b = pVar;
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
    }
}
