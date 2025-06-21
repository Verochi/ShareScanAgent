package com.anythink.expressad.exoplayer.c;

/* loaded from: classes12.dex */
public final class h extends com.anythink.expressad.exoplayer.c.f {
    public java.nio.ByteBuffer c;
    private final com.anythink.expressad.exoplayer.c.g<?, com.anythink.expressad.exoplayer.c.h, ?> d;

    private h(com.anythink.expressad.exoplayer.c.g<?, com.anythink.expressad.exoplayer.c.h, ?> gVar) {
        this.d = gVar;
    }

    private java.nio.ByteBuffer a(long j, int i) {
        ((com.anythink.expressad.exoplayer.c.f) this).a = j;
        java.nio.ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.c = java.nio.ByteBuffer.allocateDirect(i).order(java.nio.ByteOrder.nativeOrder());
        }
        this.c.position(0);
        this.c.limit(i);
        return this.c;
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        java.nio.ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.f
    public final void e() {
        this.d.a((com.anythink.expressad.exoplayer.c.g<?, com.anythink.expressad.exoplayer.c.h, ?>) this);
    }
}
