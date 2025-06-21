package com.anythink.expressad.exoplayer.h.a;

/* loaded from: classes12.dex */
final class d extends com.anythink.expressad.exoplayer.h.p {
    private final com.anythink.expressad.exoplayer.h.a.a c;

    public d(com.anythink.expressad.exoplayer.ae aeVar, com.anythink.expressad.exoplayer.h.a.a aVar) {
        super(aeVar);
        com.anythink.expressad.exoplayer.k.a.b(aeVar.c() == 1);
        com.anythink.expressad.exoplayer.k.a.b(aeVar.b() == 1);
        this.c = aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
    public final com.anythink.expressad.exoplayer.ae.a a(int i, com.anythink.expressad.exoplayer.ae.a aVar, boolean z) {
        this.b.a(i, aVar, z);
        aVar.a(aVar.a, aVar.b, aVar.c, aVar.d, aVar.b(), this.c);
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
    public final com.anythink.expressad.exoplayer.ae.b a(int i, com.anythink.expressad.exoplayer.ae.b bVar, boolean z, long j) {
        com.anythink.expressad.exoplayer.ae.b a = super.a(i, bVar, z, j);
        if (a.i == -9223372036854775807L) {
            a.i = this.c.k;
        }
        return a;
    }
}
