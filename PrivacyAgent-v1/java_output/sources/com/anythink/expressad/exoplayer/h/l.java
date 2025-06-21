package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class l implements com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.r.a {
    public final com.anythink.expressad.exoplayer.h.s a;
    public final com.anythink.expressad.exoplayer.h.s.a b;
    private final com.anythink.expressad.exoplayer.j.b c;
    private com.anythink.expressad.exoplayer.h.r d;
    private com.anythink.expressad.exoplayer.h.r.a e;
    private long f;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.h.l.a g;
    private boolean h;
    private long i = -9223372036854775807L;

    public interface a {
        void a(com.anythink.expressad.exoplayer.h.s.a aVar, java.io.IOException iOException);
    }

    public l(com.anythink.expressad.exoplayer.h.s sVar, com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        this.b = aVar;
        this.c = bVar;
        this.a = sVar;
    }

    private void h() {
        this.e.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        return this.d.a(j, acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, com.anythink.expressad.exoplayer.h.y[] yVarArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.i;
        if (j3 == -9223372036854775807L || j != 0) {
            j2 = j;
        } else {
            this.i = -9223372036854775807L;
            j2 = j3;
        }
        return this.d.a(fVarArr, zArr, yVarArr, zArr2, j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        try {
            com.anythink.expressad.exoplayer.h.r rVar = this.d;
            if (rVar != null) {
                rVar.a();
            } else {
                this.a.b();
            }
        } catch (java.io.IOException e) {
            com.anythink.expressad.exoplayer.h.l.a aVar = this.g;
            if (aVar == null) {
                throw e;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            aVar.a(this.b, e);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        this.d.a(j, z);
    }

    public final void a(com.anythink.expressad.exoplayer.h.l.a aVar) {
        this.g = aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(com.anythink.expressad.exoplayer.h.r.a aVar, long j) {
        this.e = aVar;
        this.f = j;
        com.anythink.expressad.exoplayer.h.r rVar = this.d;
        if (rVar != null) {
            rVar.a(this, j);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.e.a((com.anythink.expressad.exoplayer.h.r) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.e.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        this.d.a_(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        return this.d.b(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final com.anythink.expressad.exoplayer.h.af b() {
        return this.d.b();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        return this.d.c();
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        com.anythink.expressad.exoplayer.h.r rVar = this.d;
        return rVar != null && rVar.c(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.d.d();
    }

    public final void d(long j) {
        if (this.f != 0 || j == 0) {
            return;
        }
        this.i = j;
        this.f = j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return this.d.e();
    }

    public final void f() {
        com.anythink.expressad.exoplayer.h.r a2 = this.a.a(this.b, this.c);
        this.d = a2;
        if (this.e != null) {
            a2.a(this, this.f);
        }
    }

    public final void g() {
        com.anythink.expressad.exoplayer.h.r rVar = this.d;
        if (rVar != null) {
            this.a.a(rVar);
        }
    }
}
