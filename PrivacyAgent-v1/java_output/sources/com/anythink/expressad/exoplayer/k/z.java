package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class z implements com.anythink.expressad.exoplayer.k.n {
    private final com.anythink.expressad.exoplayer.k.c a;
    private boolean b;
    private long c;
    private long d;
    private com.anythink.expressad.exoplayer.v e = com.anythink.expressad.exoplayer.v.a;

    public z(com.anythink.expressad.exoplayer.k.c cVar) {
        this.a = cVar;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        if (this.b) {
            a(d());
        }
        this.e = vVar;
        return vVar;
    }

    public final void a() {
        if (this.b) {
            return;
        }
        this.d = this.a.a();
        this.b = true;
    }

    public final void a(long j) {
        this.c = j;
        if (this.b) {
            this.d = this.a.a();
        }
    }

    public final void b() {
        if (this.b) {
            a(d());
            this.b = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        long a = this.a.a() - this.d;
        com.anythink.expressad.exoplayer.v vVar = this.e;
        return j + (vVar.b == 1.0f ? com.anythink.expressad.exoplayer.b.b(a) : vVar.a(a));
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v e() {
        return this.e;
    }
}
