package com.anythink.expressad.exoplayer.e;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.exoplayer.e.f {
    private static final int a = 65536;
    private static final int b = 524288;
    private static final int c = 4096;
    private final com.anythink.expressad.exoplayer.j.h e;
    private final long f;
    private long g;
    private int i;
    private int j;
    private byte[] h = new byte[65536];
    private final byte[] d = new byte[4096];

    public b(com.anythink.expressad.exoplayer.j.h hVar, long j, long j2) {
        this.e = hVar;
        this.g = j;
        this.f = j2;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (java.lang.Thread.interrupted()) {
            throw new java.lang.InterruptedException();
        }
        int a2 = this.e.a(bArr, i + i3, i2 - i3);
        if (a2 != -1) {
            return i3 + a2;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    private int e(byte[] bArr, int i, int i2) {
        int i3 = this.j;
        if (i3 == 0) {
            return 0;
        }
        int min = java.lang.Math.min(i3, i2);
        java.lang.System.arraycopy(this.h, 0, bArr, i, min);
        h(min);
        return min;
    }

    private void f(int i) {
        int i2 = this.i + i;
        byte[] bArr = this.h;
        if (i2 > bArr.length) {
            this.h = java.util.Arrays.copyOf(this.h, com.anythink.expressad.exoplayer.k.af.a(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int g(int i) {
        int min = java.lang.Math.min(this.j, i);
        h(min);
        return min;
    }

    private void h(int i) {
        int i2 = this.j - i;
        this.j = i2;
        this.i = 0;
        byte[] bArr = this.h;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[65536 + i2] : bArr;
        java.lang.System.arraycopy(bArr, i, bArr2, 0, i2);
        this.h = bArr2;
    }

    private void i(int i) {
        if (i != -1) {
            this.g += i;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final int a(int i) {
        int g = g(i);
        if (g == 0) {
            byte[] bArr = this.d;
            g = a(bArr, 0, java.lang.Math.min(i, bArr.length), 0, true);
        }
        i(g);
        return g;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final int a(byte[] bArr, int i, int i2) {
        int e = e(bArr, i, i2);
        if (e == 0) {
            e = a(bArr, i, i2, 0, true);
        }
        i(e);
        return e;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void a() {
        this.i = 0;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final <E extends java.lang.Throwable> void a(long j, E e) {
        com.anythink.expressad.exoplayer.k.a.a(j >= 0);
        this.g = j;
        throw e;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        int e = e(bArr, i, i2);
        while (e < i2 && e != -1) {
            e = a(bArr, i, i2, e, z);
        }
        i(e);
        return e != -1;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long b() {
        return this.g + this.i;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void b(byte[] bArr, int i, int i2) {
        a(bArr, i, i2, false);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean b(int i) {
        int g = g(i);
        while (g < i && g != -1) {
            g = a(this.d, -g, java.lang.Math.min(i, this.d.length + g), g, false);
        }
        i(g);
        return g != -1;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long c() {
        return this.g;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void c(int i) {
        int g = g(i);
        while (g < i && g != -1) {
            g = a(this.d, -g, java.lang.Math.min(i, this.d.length + g), g, false);
        }
        i(g);
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean c(byte[] bArr, int i, int i2) {
        if (!d(i2)) {
            return false;
        }
        java.lang.System.arraycopy(this.h, this.i - i2, bArr, i, i2);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final long d() {
        return this.f;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void d(byte[] bArr, int i, int i2) {
        if (d(i2)) {
            java.lang.System.arraycopy(this.h, this.i - i2, bArr, i, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final boolean d(int i) {
        f(i);
        int min = java.lang.Math.min(this.j - this.i, i);
        while (min < i) {
            min = a(this.h, this.i, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i2 = this.i + i;
        this.i = i2;
        this.j = java.lang.Math.max(this.j, i2);
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.f
    public final void e(int i) {
        d(i);
    }
}
