package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
final class u {
    public final com.anythink.expressad.exoplayer.ae a;

    @androidx.annotation.Nullable
    public final java.lang.Object b;
    public final com.anythink.expressad.exoplayer.h.s.a c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final com.anythink.expressad.exoplayer.h.af h;
    public final com.anythink.expressad.exoplayer.i.i i;
    public volatile long j;
    public volatile long k;

    public u(com.anythink.expressad.exoplayer.ae aeVar, long j, com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.i iVar) {
        this(aeVar, null, new com.anythink.expressad.exoplayer.h.s.a(0), j, -9223372036854775807L, 1, false, afVar, iVar);
    }

    public u(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj, com.anythink.expressad.exoplayer.h.s.a aVar, long j, long j2, int i, boolean z, com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.i iVar) {
        this.a = aeVar;
        this.b = obj;
        this.c = aVar;
        this.d = j;
        this.e = j2;
        this.j = j;
        this.k = j;
        this.f = i;
        this.g = z;
        this.h = afVar;
        this.i = iVar;
    }

    private static void a(com.anythink.expressad.exoplayer.u uVar, com.anythink.expressad.exoplayer.u uVar2) {
        uVar2.j = uVar.j;
        uVar2.k = uVar.k;
    }

    public final com.anythink.expressad.exoplayer.u a(int i) {
        com.anythink.expressad.exoplayer.u uVar = new com.anythink.expressad.exoplayer.u(this.a, this.b, this.c.a(i), this.d, this.e, this.f, this.g, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final com.anythink.expressad.exoplayer.u a(com.anythink.expressad.exoplayer.ae aeVar, java.lang.Object obj) {
        com.anythink.expressad.exoplayer.u uVar = new com.anythink.expressad.exoplayer.u(aeVar, obj, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final com.anythink.expressad.exoplayer.u a(com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.i iVar) {
        com.anythink.expressad.exoplayer.u uVar = new com.anythink.expressad.exoplayer.u(this.a, this.b, this.c, this.d, this.e, this.f, this.g, afVar, iVar);
        a(this, uVar);
        return uVar;
    }

    public final com.anythink.expressad.exoplayer.u a(com.anythink.expressad.exoplayer.h.s.a aVar, long j, long j2) {
        return new com.anythink.expressad.exoplayer.u(this.a, this.b, aVar, j, aVar.a() ? j2 : -9223372036854775807L, this.f, this.g, this.h, this.i);
    }

    public final com.anythink.expressad.exoplayer.u a(boolean z) {
        com.anythink.expressad.exoplayer.u uVar = new com.anythink.expressad.exoplayer.u(this.a, this.b, this.c, this.d, this.e, this.f, z, this.h, this.i);
        a(this, uVar);
        return uVar;
    }

    public final com.anythink.expressad.exoplayer.u b(int i) {
        com.anythink.expressad.exoplayer.u uVar = new com.anythink.expressad.exoplayer.u(this.a, this.b, this.c, this.d, this.e, i, this.g, this.h, this.i);
        a(this, uVar);
        return uVar;
    }
}
