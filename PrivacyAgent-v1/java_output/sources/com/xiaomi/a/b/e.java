package com.xiaomi.a.b;

/* loaded from: classes19.dex */
final class e extends com.xiaomi.push.m.a {
    final /* synthetic */ com.xiaomi.a.b.b a;

    public e(com.xiaomi.a.b.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "100888";
    }

    @Override // java.lang.Runnable
    public final void run() {
        int f;
        java.util.concurrent.ExecutorService executorService;
        f = this.a.f();
        if (f > 0) {
            executorService = this.a.a;
            executorService.execute(new com.xiaomi.a.b.f(this));
        }
    }
}
