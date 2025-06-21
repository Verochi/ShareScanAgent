package com.anythink.expressad.exoplayer.g.c;

/* loaded from: classes12.dex */
public final class c implements com.anythink.expressad.exoplayer.g.b {
    private static final int a = 0;
    private static final int b = 4;
    private static final int c = 5;
    private static final int d = 6;
    private static final int e = 255;
    private final com.anythink.expressad.exoplayer.k.s f = new com.anythink.expressad.exoplayer.k.s();
    private final com.anythink.expressad.exoplayer.k.r g = new com.anythink.expressad.exoplayer.k.r();
    private com.anythink.expressad.exoplayer.k.ac h;

    @Override // com.anythink.expressad.exoplayer.g.b
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e eVar) {
        com.anythink.expressad.exoplayer.k.ac acVar = this.h;
        if (acVar == null || eVar.g != acVar.a()) {
            com.anythink.expressad.exoplayer.k.ac acVar2 = new com.anythink.expressad.exoplayer.k.ac(eVar.f);
            this.h = acVar2;
            acVar2.b(eVar.f - eVar.g);
        }
        java.nio.ByteBuffer byteBuffer = eVar.e;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f.a(array, limit);
        this.g.a(array, limit);
        this.g.b(39);
        long c2 = (this.g.c(1) << 32) | this.g.c(32);
        this.g.b(20);
        int c3 = this.g.c(12);
        int c4 = this.g.c(8);
        this.f.d(14);
        com.anythink.expressad.exoplayer.g.a.InterfaceC0194a a2 = c4 != 0 ? c4 != 255 ? c4 != 4 ? c4 != 5 ? c4 != 6 ? null : com.anythink.expressad.exoplayer.g.c.g.a(this.f, c2, this.h) : com.anythink.expressad.exoplayer.g.c.d.a(this.f, c2, this.h) : com.anythink.expressad.exoplayer.g.c.f.a(this.f) : com.anythink.expressad.exoplayer.g.c.a.a(this.f, c3, c2) : new com.anythink.expressad.exoplayer.g.c.e();
        return a2 == null ? new com.anythink.expressad.exoplayer.g.a(new com.anythink.expressad.exoplayer.g.a.InterfaceC0194a[0]) : new com.anythink.expressad.exoplayer.g.a(a2);
    }
}
