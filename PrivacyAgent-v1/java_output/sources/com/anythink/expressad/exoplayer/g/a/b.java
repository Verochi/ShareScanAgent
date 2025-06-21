package com.anythink.expressad.exoplayer.g.a;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.exoplayer.g.b {
    @Override // com.anythink.expressad.exoplayer.g.b
    public final com.anythink.expressad.exoplayer.g.a a(com.anythink.expressad.exoplayer.g.e eVar) {
        java.nio.ByteBuffer byteBuffer = eVar.e;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s(array, limit);
        java.lang.String p = sVar.p();
        java.lang.String p2 = sVar.p();
        long h = sVar.h();
        return new com.anythink.expressad.exoplayer.g.a(new com.anythink.expressad.exoplayer.g.a.a(p, p2, com.anythink.expressad.exoplayer.k.af.a(sVar.h(), 1000L, h), sVar.h(), java.util.Arrays.copyOfRange(array, sVar.c(), limit), com.anythink.expressad.exoplayer.k.af.a(sVar.h(), 1000000L, h)));
    }
}
