package com.sijla.b;

/* loaded from: classes19.dex */
final class f implements java.lang.Runnable {
    private /* synthetic */ com.sijla.b.e a;

    public f(com.sijla.b.e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.sijla.b.d.a aVar;
        com.sijla.b.d.a aVar2;
        try {
            if (com.sijla.b.g.f == 0) {
                aVar = com.sijla.b.d.d;
                long j = aVar.a;
                aVar2 = com.sijla.b.d.d;
                long j2 = 0;
                aVar2.a = 0L;
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (j <= 0) {
                    j = currentTimeMillis;
                }
                long j3 = (currentTimeMillis - j) / 1000;
                android.app.Application application = this.a.a;
                if (j3 >= 0) {
                    j2 = j3;
                }
                com.sijla.b.g.a(application, j2);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }
}
