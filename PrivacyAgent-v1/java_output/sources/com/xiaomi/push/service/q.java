package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final class q extends com.xiaomi.push.m.a {
    final /* synthetic */ java.lang.String a;
    final /* synthetic */ com.xiaomi.push.service.aa b;
    final /* synthetic */ int c;

    public q(java.lang.String str, com.xiaomi.push.service.aa aaVar, int i) {
        this.a = str;
        this.b = aaVar;
        this.c = i;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.c);
    }
}
