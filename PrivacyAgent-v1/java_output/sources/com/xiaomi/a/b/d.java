package com.xiaomi.a.b;

/* loaded from: classes19.dex */
final class d implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.a.a.c a;
    final /* synthetic */ com.xiaomi.a.b.b b;

    public d(com.xiaomi.a.b.b bVar, com.xiaomi.a.a.c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.xiaomi.a.b.b.a(this.b, this.a);
    }
}
