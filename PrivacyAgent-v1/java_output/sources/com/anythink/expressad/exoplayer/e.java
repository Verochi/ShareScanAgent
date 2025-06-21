package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
final class e implements com.anythink.expressad.exoplayer.k.n {
    private final com.anythink.expressad.exoplayer.k.z a;
    private final com.anythink.expressad.exoplayer.e.a b;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.y c;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.k.n d;

    public interface a {
        void a(com.anythink.expressad.exoplayer.v vVar);
    }

    public e(com.anythink.expressad.exoplayer.e.a aVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.b = aVar;
        this.a = new com.anythink.expressad.exoplayer.k.z(cVar);
    }

    private void f() {
        this.a.a(this.d.d());
        com.anythink.expressad.exoplayer.v e = this.d.e();
        if (e.equals(this.a.e())) {
            return;
        }
        this.a.a(e);
        this.b.a(e);
    }

    private boolean g() {
        com.anythink.expressad.exoplayer.y yVar = this.c;
        if (yVar == null || yVar.v()) {
            return false;
        }
        return this.c.u() || !this.c.g();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        com.anythink.expressad.exoplayer.k.n nVar = this.d;
        if (nVar != null) {
            vVar = nVar.a(vVar);
        }
        this.a.a(vVar);
        this.b.a(vVar);
        return vVar;
    }

    public final void a() {
        this.a.a();
    }

    public final void a(long j) {
        this.a.a(j);
    }

    public final void a(com.anythink.expressad.exoplayer.y yVar) {
        com.anythink.expressad.exoplayer.k.n nVar;
        com.anythink.expressad.exoplayer.k.n c = yVar.c();
        if (c == null || c == (nVar = this.d)) {
            return;
        }
        if (nVar != null) {
            throw com.anythink.expressad.exoplayer.g.a(new java.lang.IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.d = c;
        this.c = yVar;
        c.a(this.a.e());
        f();
    }

    public final void b() {
        this.a.b();
    }

    public final void b(com.anythink.expressad.exoplayer.y yVar) {
        if (yVar == this.c) {
            this.d = null;
            this.c = null;
        }
    }

    public final long c() {
        if (!g()) {
            return this.a.d();
        }
        f();
        return this.d.d();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        return g() ? this.d.d() : this.a.d();
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v e() {
        com.anythink.expressad.exoplayer.k.n nVar = this.d;
        return nVar != null ? nVar.e() : this.a.e();
    }
}
