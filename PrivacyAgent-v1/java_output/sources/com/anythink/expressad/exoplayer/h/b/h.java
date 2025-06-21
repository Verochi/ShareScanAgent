package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public final class h extends com.anythink.expressad.exoplayer.h.b.a {
    private final int k;
    private final long l;
    private final com.anythink.expressad.exoplayer.h.b.d m;
    private volatile int n;
    private volatile boolean o;
    private volatile boolean p;

    private h(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.m mVar, int i, java.lang.Object obj, long j, long j2, long j3, long j4, int i2, long j5, com.anythink.expressad.exoplayer.h.b.d dVar) {
        super(hVar, kVar, mVar, i, obj, j, j2, j3, j4);
        this.k = i2;
        this.l = j5;
        this.m = dVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
        this.o = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        com.anythink.expressad.exoplayer.j.k a = this.b.a(this.n);
        try {
            com.anythink.expressad.exoplayer.j.h hVar = this.i;
            com.anythink.expressad.exoplayer.e.b bVar = new com.anythink.expressad.exoplayer.e.b(hVar, a.e, hVar.a(a));
            if (this.n == 0) {
                com.anythink.expressad.exoplayer.h.b.b c = c();
                c.a(this.l);
                com.anythink.expressad.exoplayer.h.b.d dVar = this.m;
                long j = this.a;
                dVar.a(c, j == -9223372036854775807L ? 0L : j - this.l);
            }
            try {
                com.anythink.expressad.exoplayer.e.e eVar = this.m.a;
                int i = 0;
                while (i == 0 && !this.o) {
                    i = eVar.a(bVar, (com.anythink.expressad.exoplayer.e.j) null);
                }
                com.anythink.expressad.exoplayer.k.a.b(i != 1);
                com.anythink.expressad.exoplayer.k.af.a(this.i);
                this.p = true;
            } finally {
                this.n = (int) (bVar.c() - this.b.e);
            }
        } catch (java.lang.Throwable th) {
            com.anythink.expressad.exoplayer.k.af.a(this.i);
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.b.c
    public final long d() {
        return this.n;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final long e() {
        return this.j + this.k;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final boolean f() {
        return this.p;
    }
}
