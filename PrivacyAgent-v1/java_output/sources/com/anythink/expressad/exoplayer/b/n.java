package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class n implements com.anythink.expressad.exoplayer.b.f {
    private static final int b = java.lang.Float.floatToIntBits(Float.NaN);
    private static final double c = 4.656612875245797E-10d;
    private int d = -1;
    private int e = -1;
    private int f = 0;
    private java.nio.ByteBuffer g;
    private java.nio.ByteBuffer h;
    private boolean i;

    public n() {
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.g = byteBuffer;
        this.h = byteBuffer;
    }

    private static void a(int i, java.nio.ByteBuffer byteBuffer) {
        int floatToIntBits = java.lang.Float.floatToIntBits((float) (i * c));
        if (floatToIntBits == b) {
            floatToIntBits = java.lang.Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(java.nio.ByteBuffer byteBuffer) {
        boolean z = this.f == 1073741824;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (!z) {
            i = (i / 3) * 4;
        }
        if (this.g.capacity() < i) {
            this.g = java.nio.ByteBuffer.allocateDirect(i).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        if (z) {
            while (position < limit) {
                a((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), this.g);
                position += 4;
            }
        } else {
            while (position < limit) {
                a(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), this.g);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.g.flip();
        this.h = this.g;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return com.anythink.expressad.exoplayer.k.af.c(this.f);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (!com.anythink.expressad.exoplayer.k.af.c(i3)) {
            throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
        }
        if (this.d == i && this.e == i2 && this.f == i3) {
            return false;
        }
        this.d = i;
        this.e = i2;
        this.f = i3;
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 4;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.d;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.i = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final java.nio.ByteBuffer f() {
        java.nio.ByteBuffer byteBuffer = this.h;
        this.h = com.anythink.expressad.exoplayer.b.f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.i && this.h == com.anythink.expressad.exoplayer.b.f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.h = com.anythink.expressad.exoplayer.b.f.a;
        this.i = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.d = -1;
        this.e = -1;
        this.f = 0;
        this.g = com.anythink.expressad.exoplayer.b.f.a;
    }
}
