package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public final class t implements com.anythink.expressad.exoplayer.b.f {
    public static final float b = 8.0f;
    public static final float c = 0.1f;
    public static final float d = 8.0f;
    public static final float e = 0.1f;
    public static final int f = -1;
    private static final float g = 0.01f;
    private static final int h = 1024;
    private int n;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.b.s o;
    private java.nio.ByteBuffer p;
    private java.nio.ShortBuffer q;
    private java.nio.ByteBuffer r;

    /* renamed from: s, reason: collision with root package name */
    private long f210s;
    private long t;
    private boolean u;
    private float k = 1.0f;
    private float l = 1.0f;
    private int i = -1;
    private int j = -1;
    private int m = -1;

    public t() {
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.p = byteBuffer;
        this.q = byteBuffer.asShortBuffer();
        this.r = byteBuffer;
        this.n = -1;
    }

    private void a(int i) {
        this.n = i;
    }

    public final float a(float f2) {
        float a = com.anythink.expressad.exoplayer.k.af.a(f2);
        if (this.k != a) {
            this.k = a;
            this.o = null;
        }
        h();
        return a;
    }

    public final long a(long j) {
        long j2 = this.t;
        if (j2 < 1024) {
            return (long) (this.k * j);
        }
        int i = this.m;
        int i2 = this.j;
        return i == i2 ? com.anythink.expressad.exoplayer.k.af.a(j, this.f210s, j2) : com.anythink.expressad.exoplayer.k.af.a(j, this.f210s * i, j2 * i2);
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void a(java.nio.ByteBuffer byteBuffer) {
        com.anythink.expressad.exoplayer.k.a.b(this.o != null);
        if (byteBuffer.hasRemaining()) {
            java.nio.ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f210s += remaining;
            this.o.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int c2 = this.o.c() * this.i * 2;
        if (c2 > 0) {
            if (this.p.capacity() < c2) {
                java.nio.ByteBuffer order = java.nio.ByteBuffer.allocateDirect(c2).order(java.nio.ByteOrder.nativeOrder());
                this.p = order;
                this.q = order.asShortBuffer();
            } else {
                this.p.clear();
                this.q.clear();
            }
            this.o.b(this.q);
            this.t += c2;
            this.p.limit(c2);
            this.r = this.p;
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a() {
        if (this.j != -1) {
            return java.lang.Math.abs(this.k - 1.0f) >= g || java.lang.Math.abs(this.l - 1.0f) >= g || this.m != this.j;
        }
        return false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean a(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new com.anythink.expressad.exoplayer.b.f.a(i, i2, i3);
        }
        int i4 = this.n;
        if (i4 == -1) {
            i4 = i;
        }
        if (this.j == i && this.i == i2 && this.m == i4) {
            return false;
        }
        this.j = i;
        this.i = i2;
        this.m = i4;
        this.o = null;
        return true;
    }

    public final float b(float f2) {
        float a = com.anythink.expressad.exoplayer.k.af.a(f2);
        if (this.l != a) {
            this.l = a;
            this.o = null;
        }
        h();
        return a;
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
        return this.m;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void e() {
        com.anythink.expressad.exoplayer.k.a.b(this.o != null);
        this.o.a();
        this.u = true;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final java.nio.ByteBuffer f() {
        java.nio.ByteBuffer byteBuffer = this.r;
        this.r = com.anythink.expressad.exoplayer.b.f.a;
        return byteBuffer;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final boolean g() {
        if (!this.u) {
            return false;
        }
        com.anythink.expressad.exoplayer.b.s sVar = this.o;
        return sVar == null || sVar.c() == 0;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void h() {
        if (a()) {
            com.anythink.expressad.exoplayer.b.s sVar = this.o;
            if (sVar == null) {
                this.o = new com.anythink.expressad.exoplayer.b.s(this.j, this.i, this.k, this.l, this.m);
            } else {
                sVar.b();
            }
        }
        this.r = com.anythink.expressad.exoplayer.b.f.a;
        this.f210s = 0L;
        this.t = 0L;
        this.u = false;
    }

    @Override // com.anythink.expressad.exoplayer.b.f
    public final void i() {
        this.k = 1.0f;
        this.l = 1.0f;
        this.i = -1;
        this.j = -1;
        this.m = -1;
        java.nio.ByteBuffer byteBuffer = com.anythink.expressad.exoplayer.b.f.a;
        this.p = byteBuffer;
        this.q = byteBuffer.asShortBuffer();
        this.r = byteBuffer;
        this.n = -1;
        this.o = null;
        this.f210s = 0L;
        this.t = 0L;
        this.u = false;
    }
}
