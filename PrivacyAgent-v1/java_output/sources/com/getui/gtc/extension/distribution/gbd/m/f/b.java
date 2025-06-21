package com.getui.gtc.extension.distribution.gbd.m.f;

/* loaded from: classes22.dex */
public final class b implements java.lang.Runnable {
    private static final java.lang.String a = "Up_Search";
    private final com.getui.gtc.extension.distribution.gbd.m.b.b b;

    public b(com.getui.gtc.extension.distribution.gbd.m.b.b bVar) {
        this.b = bVar;
    }

    private static int a() {
        return 1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "execute search for target: ssdp");
            com.getui.gtc.extension.distribution.gbd.m.f.a aVar = new com.getui.gtc.extension.distribution.gbd.m.f.a();
            for (int i = 0; i <= 0; i++) {
                try {
                    this.b.c().a(aVar);
                    java.lang.Thread.sleep(500L);
                } catch (java.lang.Throwable unused) {
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    public final java.lang.String toString() {
        return "(" + com.getui.gtc.extension.distribution.gbd.m.f.b.class.getSimpleName() + ")";
    }
}
