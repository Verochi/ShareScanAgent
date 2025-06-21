package com.xiaomi.a.b;

/* loaded from: classes19.dex */
final class g extends com.xiaomi.push.m.a {
    final /* synthetic */ com.xiaomi.a.b.b a;

    public g(com.xiaomi.a.b.b bVar) {
        this.a = bVar;
    }

    @Override // com.xiaomi.push.m.a
    public final java.lang.String a() {
        return "100889";
    }

    @Override // java.lang.Runnable
    public final void run() {
        int g;
        java.util.concurrent.ExecutorService executorService;
        g = this.a.g();
        if (g > 0) {
            executorService = this.a.a;
            executorService.execute(new com.xiaomi.a.b.h(this));
        }
    }
}
