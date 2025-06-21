package com.igexin.push.g.b;

/* loaded from: classes23.dex */
public final class d extends com.igexin.push.g.b.f {
    public static final int a = 20160629;
    public static final long b = 604800000;
    private static final java.lang.String c = "PollingTimerTask";
    private long e;
    private java.util.concurrent.atomic.AtomicBoolean f;

    public static class a {
        private static final com.igexin.push.g.b.d a = new com.igexin.push.g.b.d();

        private a() {
        }
    }

    public d() {
        super(604800000L, (byte) 0);
        this.e = com.igexin.push.config.d.y;
        this.f = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.p = true;
    }

    private void a(long j) {
        a(j, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    private static com.igexin.push.g.b.d q() {
        return com.igexin.push.g.b.d.a.a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return a;
    }

    public final void g() {
        if (!this.f.getAndSet(true)) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) this, false, true);
        }
        a(this.e);
    }

    @Override // com.igexin.push.g.b.f
    public final void h() {
        com.igexin.push.d.b bVar;
        a(this.e, java.util.concurrent.TimeUnit.MILLISECONDS);
        if (!com.igexin.push.core.e.u && com.igexin.push.core.e.n && com.igexin.push.core.e.p && com.igexin.push.core.e.f388s && com.igexin.push.h.c.a()) {
            com.igexin.c.a.c.a.a("PollingTimerTask|run = true", new java.lang.Object[0]);
            com.igexin.push.d.c cVar = com.igexin.push.d.c.b.a;
            if (cVar.b && (bVar = cVar.e) != null && !(bVar instanceof com.igexin.push.d.d)) {
                cVar.e = new com.igexin.push.d.d();
            }
            com.igexin.push.core.e.b(100L);
            com.igexin.push.g.b.e.g().a(com.igexin.push.core.e.O);
        }
    }

    public final void i() {
        a(604800000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }
}
