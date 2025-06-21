package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
final class u implements com.anythink.expressad.exoplayer.b.f {
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private java.nio.ByteBuffer h;
    private java.nio.ByteBuffer i;
    private byte[] j;
    private int k;
    private boolean l;

    public u() {
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.h = byteBuffer;
        this.i = byteBuffer;
        this.e = -1;
        this.f = -1;
        this.j = new byte[0];
    }

    public final void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(java.nio.ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = java.lang.Math.min(i, this.g);
        this.g -= min;
        byteBuffer.position(position + min);
        if (this.g > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.k + i2) - this.j.length;
        if (this.h.capacity() < length) {
            this.h = java.nio.ByteBuffer.allocateDirect(length).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.h.clear();
        }
        int a = com.anythink.expressad.exoplayer.k.af.a(length, 0, this.k);
        this.h.put(this.j, 0, a);
        int a2 = com.anythink.expressad.exoplayer.k.af.a(length - a, 0, i2);
        byteBuffer.limit(byteBuffer.position() + a2);
        this.h.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - a2;
        int i4 = this.k - a;
        this.k = i4;
        byte[] bArr = this.j;
        java.lang.System.arraycopy(bArr, a, bArr, 0, i4);
        byteBuffer.get(this.j, this.k, i3);
        this.k += i3;
        this.h.flip();
        this.i = this.h;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.b;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
        }
        this.e = i2;
        this.f = i;
        int i4 = this.d;
        this.j = new byte[i4 * i2 * 2];
        this.k = 0;
        int i5 = this.c;
        this.g = i2 * i5 * 2;
        boolean z = this.b;
        boolean z2 = (i5 == 0 && i4 == 0) ? false : true;
        this.b = z2;
        return z != z2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.e;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.l = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final java.nio.ByteBuffer f() {
        java.nio.ByteBuffer byteBuffer = this.i;
        this.i = com.anythink.expressad.exoplayer.b.f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.l && this.i == com.anythink.expressad.exoplayer.b.f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        this.i = com.anythink.expressad.exoplayer.b.f.a;
        this.l = false;
        this.g = 0;
        this.k = 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        h();
        this.h = com.anythink.expressad.exoplayer.b.f.a;
        this.e = -1;
        this.f = -1;
        this.j = new byte[0];
    }
}
