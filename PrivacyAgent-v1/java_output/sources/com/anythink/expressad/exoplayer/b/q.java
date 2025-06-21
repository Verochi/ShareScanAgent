package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public final class q implements com.anythink.expressad.exoplayer.b.f {
    private static final long b = 150000;
    private static final long c = 20000;
    private static final short d = 1024;
    private static final byte e = 4;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private java.nio.ByteBuffer m;
    private java.nio.ByteBuffer n;
    private boolean o;
    private byte[] p;
    private byte[] q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f207s;
    private int t;
    private boolean u;
    private long v;

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public q() {
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.m = byteBuffer;
        this.n = byteBuffer;
        this.i = -1;
        this.j = -1;
        this.p = new byte[0];
        this.q = new byte[0];
    }

    private int a(long j) {
        return (int) ((j * this.j) / 1000000);
    }

    private void a(int i) {
        if (this.m.capacity() < i) {
            this.m = java.nio.ByteBuffer.allocateDirect(i).order(java.nio.ByteOrder.nativeOrder());
        } else {
            this.m.clear();
        }
        if (i > 0) {
            this.u = true;
        }
    }

    private void a(java.nio.ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = java.lang.Math.min(byteBuffer.remaining(), this.t);
        int i2 = this.t - min;
        java.lang.System.arraycopy(bArr, i - i2, this.q, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.q, i2, min);
    }

    private void a(byte[] bArr, int i) {
        a(i);
        this.m.put(bArr, 0, i);
        this.m.flip();
        this.n = this.m;
    }

    private void b(java.nio.ByteBuffer byteBuffer) {
        int position;
        int limit = byteBuffer.limit();
        byteBuffer.limit(java.lang.Math.min(limit, byteBuffer.position() + this.p.length));
        int limit2 = byteBuffer.limit() - 1;
        while (true) {
            if (limit2 < byteBuffer.position()) {
                position = byteBuffer.position();
                break;
            } else {
                if (java.lang.Math.abs((int) byteBuffer.get(limit2)) > 4) {
                    int i = this.k;
                    position = ((limit2 / i) * i) + i;
                    break;
                }
                limit2 -= 2;
            }
        }
        if (position == byteBuffer.position()) {
            this.r = 1;
        } else {
            byteBuffer.limit(position);
            a(byteBuffer.remaining());
            this.m.put(byteBuffer);
            this.m.flip();
            this.n = this.m;
        }
        byteBuffer.limit(limit);
    }

    private void c(java.nio.ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int f2 = f(byteBuffer);
        int position = f2 - byteBuffer.position();
        byte[] bArr = this.p;
        int length = bArr.length;
        int i = this.f207s;
        int i2 = length - i;
        if (f2 < limit && position < i2) {
            a(bArr, i);
            this.f207s = 0;
            this.r = 0;
            return;
        }
        int min = java.lang.Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.p, this.f207s, min);
        int i3 = this.f207s + min;
        this.f207s = i3;
        byte[] bArr2 = this.p;
        if (i3 == bArr2.length) {
            if (this.u) {
                a(bArr2, this.t);
                this.v += (this.f207s - (this.t * 2)) / this.k;
            } else {
                this.v += (i3 - this.t) / this.k;
            }
            a(byteBuffer, this.p, this.f207s);
            this.f207s = 0;
            this.r = 2;
        }
        byteBuffer.limit(limit);
    }

    private void d(java.nio.ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int f2 = f(byteBuffer);
        byteBuffer.limit(f2);
        this.v += byteBuffer.remaining() / this.k;
        a(byteBuffer, this.q, this.t);
        if (f2 < limit) {
            a(this.q, this.t);
            this.r = 0;
            byteBuffer.limit(limit);
        }
    }

    private void e(java.nio.ByteBuffer byteBuffer) {
        a(byteBuffer.remaining());
        this.m.put(byteBuffer);
        this.m.flip();
        this.n = this.m;
    }

    private int f(java.nio.ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (java.lang.Math.abs((int) byteBuffer.get(position)) > 4) {
                int i = this.k;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    private int g(java.nio.ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (java.lang.Math.abs((int) byteBuffer.get(limit)) > 4) {
                int i = this.k;
                return ((limit / i) * i) + i;
            }
        }
        return byteBuffer.position();
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(java.nio.ByteBuffer byteBuffer) {
        int position;
        while (byteBuffer.hasRemaining() && !this.n.hasRemaining()) {
            int i = this.r;
            if (i == 0) {
                int limit = byteBuffer.limit();
                byteBuffer.limit(java.lang.Math.min(limit, byteBuffer.position() + this.p.length));
                int limit2 = byteBuffer.limit() - 1;
                while (true) {
                    if (limit2 < byteBuffer.position()) {
                        position = byteBuffer.position();
                        break;
                    } else {
                        if (java.lang.Math.abs((int) byteBuffer.get(limit2)) > 4) {
                            int i2 = this.k;
                            position = ((limit2 / i2) * i2) + i2;
                            break;
                        }
                        limit2 -= 2;
                    }
                }
                if (position == byteBuffer.position()) {
                    this.r = 1;
                } else {
                    byteBuffer.limit(position);
                    a(byteBuffer.remaining());
                    this.m.put(byteBuffer);
                    this.m.flip();
                    this.n = this.m;
                }
                byteBuffer.limit(limit);
            } else if (i == 1) {
                int limit3 = byteBuffer.limit();
                int f2 = f(byteBuffer);
                int position2 = f2 - byteBuffer.position();
                byte[] bArr = this.p;
                int length = bArr.length;
                int i3 = this.f207s;
                int i4 = length - i3;
                if (f2 >= limit3 || position2 >= i4) {
                    int min = java.lang.Math.min(position2, i4);
                    byteBuffer.limit(byteBuffer.position() + min);
                    byteBuffer.get(this.p, this.f207s, min);
                    int i5 = this.f207s + min;
                    this.f207s = i5;
                    byte[] bArr2 = this.p;
                    if (i5 == bArr2.length) {
                        if (this.u) {
                            a(bArr2, this.t);
                            this.v += (this.f207s - (this.t * 2)) / this.k;
                        } else {
                            this.v += (i5 - this.t) / this.k;
                        }
                        a(byteBuffer, this.p, this.f207s);
                        this.f207s = 0;
                        this.r = 2;
                    }
                    byteBuffer.limit(limit3);
                } else {
                    a(bArr, i3);
                    this.f207s = 0;
                    this.r = 0;
                }
            } else {
                if (i != 2) {
                    throw new java.lang.IllegalStateException();
                }
                int limit4 = byteBuffer.limit();
                int f3 = f(byteBuffer);
                byteBuffer.limit(f3);
                this.v += byteBuffer.remaining() / this.k;
                a(byteBuffer, this.q, this.t);
                if (f3 < limit4) {
                    a(this.q, this.t);
                    this.r = 0;
                    byteBuffer.limit(limit4);
                }
            }
        }
    }

    public final void a(boolean z) {
        this.l = z;
        h();
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        return this.j != -1 && this.l;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
        }
        if (this.j == i && this.i == i2) {
            return false;
        }
        this.j = i;
        this.i = i2;
        this.k = i2 * 2;
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int b() {
        return this.i;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int c() {
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final int d() {
        return this.j;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        this.o = true;
        int i = this.f207s;
        if (i > 0) {
            a(this.p, i);
        }
        if (this.u) {
            return;
        }
        this.v += this.t / this.k;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final java.nio.ByteBuffer f() {
        java.nio.ByteBuffer byteBuffer = this.n;
        this.n = com.anythink.expressad.exoplayer.b.f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        return this.o && this.n == com.anythink.expressad.exoplayer.b.f.a;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        if (a()) {
            int a2 = a(150000L) * this.k;
            if (this.p.length != a2) {
                this.p = new byte[a2];
            }
            int a3 = a(20000L) * this.k;
            this.t = a3;
            if (this.q.length != a3) {
                this.q = new byte[a3];
            }
        }
        this.r = 0;
        this.n = com.anythink.expressad.exoplayer.b.f.a;
        this.o = false;
        this.v = 0L;
        this.f207s = 0;
        this.u = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        this.l = false;
        h();
        this.m = com.anythink.expressad.exoplayer.b.f.a;
        this.i = -1;
        this.j = -1;
        this.t = 0;
        this.p = new byte[0];
        this.q = new byte[0];
    }

    public final long j() {
        return this.v;
    }
}
