package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class q extends com.anythink.expressad.exoplayer.j.s.a {
    private final java.lang.String a;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> b;
    private final int c;
    private final int d;
    private final boolean e;

    public q(java.lang.String str) {
        this(str, null);
    }

    public q(java.lang.String str, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar) {
        this(str, aaVar, (byte) 0);
    }

    private q(java.lang.String str, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.h> aaVar, byte b) {
        this.a = str;
        this.b = aaVar;
        this.c = 8000;
        this.d = 8000;
        this.e = false;
    }

    private com.anythink.expressad.exoplayer.j.p b(com.anythink.expressad.exoplayer.j.s.f fVar) {
        return new com.anythink.expressad.exoplayer.j.p(this.a, null, this.b, this.c, this.d, this.e, fVar);
    }

    @Override // com.anythink.expressad.exoplayer.j.s.a
    public final /* synthetic */ com.anythink.expressad.exoplayer.j.s a(com.anythink.expressad.exoplayer.j.s.f fVar) {
        return new com.anythink.expressad.exoplayer.j.p(this.a, null, this.b, this.c, this.d, this.e, fVar);
    }
}
