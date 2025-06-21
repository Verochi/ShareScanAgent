package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public final class j extends com.anythink.expressad.exoplayer.h.b.a {
    private final int k;
    private final com.anythink.expressad.exoplayer.m l;
    private volatile int m;
    private volatile boolean n;

    private j(com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.m mVar, int i, java.lang.Object obj, long j, long j2, long j3, int i2, com.anythink.expressad.exoplayer.m mVar2) {
        super(hVar, kVar, mVar, i, obj, j, j2, -9223372036854775807L, j3);
        this.k = i2;
        this.l = mVar2;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.j.t.c
    public final void b() {
        try {
            long a = this.i.a(this.b.a(this.m));
            if (a != -1) {
                a += this.m;
            }
            com.anythink.expressad.exoplayer.e.b bVar = new com.anythink.expressad.exoplayer.e.b(this.i, this.m, a);
            com.anythink.expressad.exoplayer.h.b.b c = c();
            c.a(0L);
            com.anythink.expressad.exoplayer.e.m a2 = c.a(this.k);
            a2.a(this.l);
            for (int i = 0; i != -1; i = a2.a(bVar, Integer.MAX_VALUE, true)) {
                this.m += i;
            }
            a2.a(this.g, 1, this.m, 0, null);
            com.anythink.expressad.exoplayer.k.af.a(this.i);
            this.n = true;
        } catch (java.lang.Throwable th) {
            com.anythink.expressad.exoplayer.k.af.a(this.i);
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.b.c
    public final long d() {
        return this.m;
    }

    @Override // com.anythink.expressad.exoplayer.h.b.i
    public final boolean f() {
        return this.n;
    }
}
