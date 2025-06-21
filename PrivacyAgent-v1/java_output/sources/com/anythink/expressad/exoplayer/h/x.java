package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class x implements com.anythink.expressad.exoplayer.e.m {
    public static final int a = -1;
    private static final int b = 32;
    private final com.anythink.expressad.exoplayer.j.b c;
    private final int d;
    private final com.anythink.expressad.exoplayer.h.w e;
    private final com.anythink.expressad.exoplayer.h.w.a f;
    private final com.anythink.expressad.exoplayer.k.s g;
    private com.anythink.expressad.exoplayer.h.x.a h;
    private com.anythink.expressad.exoplayer.h.x.a i;
    private com.anythink.expressad.exoplayer.h.x.a j;
    private com.anythink.expressad.exoplayer.m k;
    private boolean l;
    private com.anythink.expressad.exoplayer.m m;
    private long n;
    private long o;
    private boolean p;
    private com.anythink.expressad.exoplayer.h.x.b q;

    public static final class a {
        public final long a;
        public final long b;
        public boolean c;

        @androidx.annotation.Nullable
        public com.anythink.expressad.exoplayer.j.a d;

        @androidx.annotation.Nullable
        public com.anythink.expressad.exoplayer.h.x.a e;

        public a(long j, int i) {
            this.a = j;
            this.b = j + i;
        }

        public final int a(long j) {
            return ((int) (j - this.a)) + this.d.b;
        }

        public final com.anythink.expressad.exoplayer.h.x.a a() {
            this.d = null;
            com.anythink.expressad.exoplayer.h.x.a aVar = this.e;
            this.e = null;
            return aVar;
        }

        public final void a(com.anythink.expressad.exoplayer.j.a aVar, com.anythink.expressad.exoplayer.h.x.a aVar2) {
            this.d = aVar;
            this.e = aVar2;
            this.c = true;
        }
    }

    public interface b {
        void i();
    }

    public x(com.anythink.expressad.exoplayer.j.b bVar) {
        this.c = bVar;
        int d = bVar.d();
        this.d = d;
        this.e = new com.anythink.expressad.exoplayer.h.w();
        this.f = new com.anythink.expressad.exoplayer.h.w.a();
        this.g = new com.anythink.expressad.exoplayer.k.s(32);
        com.anythink.expressad.exoplayer.h.x.a aVar = new com.anythink.expressad.exoplayer.h.x.a(0L, d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
    }

    private static com.anythink.expressad.exoplayer.m a(com.anythink.expressad.exoplayer.m mVar, long j) {
        if (mVar == null) {
            return null;
        }
        if (j == 0) {
            return mVar;
        }
        long j2 = mVar.l;
        return j2 != Long.MAX_VALUE ? mVar.a(j2 + j) : mVar;
    }

    private void a(long j, java.nio.ByteBuffer byteBuffer, int i) {
        b(j);
        while (i > 0) {
            int min = java.lang.Math.min(i, (int) (this.i.b - j));
            com.anythink.expressad.exoplayer.h.x.a aVar = this.i;
            byteBuffer.put(aVar.d.a, aVar.a(j), min);
            i -= min;
            j += min;
            com.anythink.expressad.exoplayer.h.x.a aVar2 = this.i;
            if (j == aVar2.b) {
                this.i = aVar2.e;
            }
        }
    }

    private void a(long j, byte[] bArr, int i) {
        b(j);
        int i2 = i;
        while (i2 > 0) {
            int min = java.lang.Math.min(i2, (int) (this.i.b - j));
            com.anythink.expressad.exoplayer.h.x.a aVar = this.i;
            java.lang.System.arraycopy(aVar.d.a, aVar.a(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            com.anythink.expressad.exoplayer.h.x.a aVar2 = this.i;
            if (j == aVar2.b) {
                this.i = aVar2.e;
            }
        }
    }

    private void a(com.anythink.expressad.exoplayer.c.e eVar, com.anythink.expressad.exoplayer.h.w.a aVar) {
        int i;
        long j = aVar.b;
        this.g.a(1);
        a(j, this.g.a, 1);
        long j2 = j + 1;
        byte b2 = this.g.a[0];
        boolean z = (b2 & 128) != 0;
        int i2 = b2 & Byte.MAX_VALUE;
        com.anythink.expressad.exoplayer.c.b bVar = eVar.d;
        if (bVar.a == null) {
            bVar.a = new byte[16];
        }
        a(j2, bVar.a, i2);
        long j3 = j2 + i2;
        if (z) {
            this.g.a(2);
            a(j3, this.g.a, 2);
            j3 += 2;
            i = this.g.e();
        } else {
            i = 1;
        }
        com.anythink.expressad.exoplayer.c.b bVar2 = eVar.d;
        int[] iArr = bVar2.d;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar2.e;
        if (iArr3 == null || iArr3.length < i) {
            iArr3 = new int[i];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i3 = i * 6;
            this.g.a(i3);
            a(j3, this.g.a, i3);
            j3 += i3;
            this.g.c(0);
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[i4] = this.g.e();
                iArr4[i4] = this.g.m();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.a - ((int) (j3 - aVar.b));
        }
        com.anythink.expressad.exoplayer.e.m.a aVar2 = aVar.c;
        com.anythink.expressad.exoplayer.c.b bVar3 = eVar.d;
        bVar3.a(i, iArr2, iArr4, aVar2.b, bVar3.a, aVar2.a, aVar2.c, aVar2.d);
        long j4 = aVar.b;
        int i5 = (int) (j3 - j4);
        aVar.b = j4 + i5;
        aVar.a -= i5;
    }

    private void a(com.anythink.expressad.exoplayer.h.x.a aVar) {
        if (aVar.c) {
            com.anythink.expressad.exoplayer.h.x.a aVar2 = this.j;
            boolean z = aVar2.c;
            int i = (z ? 1 : 0) + (((int) (aVar2.a - aVar.a)) / this.d);
            com.anythink.expressad.exoplayer.j.a[] aVarArr = new com.anythink.expressad.exoplayer.j.a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = aVar.d;
                aVar = aVar.a();
            }
            this.c.a(aVarArr);
        }
    }

    private void b(long j) {
        while (true) {
            com.anythink.expressad.exoplayer.h.x.a aVar = this.i;
            if (j < aVar.b) {
                return;
            } else {
                this.i = aVar.e;
            }
        }
    }

    private void c(int i) {
        this.e.b(i);
    }

    private void c(long j) {
        com.anythink.expressad.exoplayer.h.x.a aVar;
        if (j == -1) {
            return;
        }
        while (true) {
            aVar = this.h;
            if (j < aVar.b) {
                break;
            }
            this.c.a(aVar.d);
            this.h = this.h.a();
        }
        if (this.i.a < aVar.a) {
            this.i = aVar;
        }
    }

    private int d(int i) {
        com.anythink.expressad.exoplayer.h.x.a aVar = this.j;
        if (!aVar.c) {
            aVar.a(this.c.a(), new com.anythink.expressad.exoplayer.h.x.a(this.j.b, this.d));
        }
        return java.lang.Math.min(i, (int) (this.j.b - this.o));
    }

    private void e(int i) {
        long j = this.o + i;
        this.o = j;
        com.anythink.expressad.exoplayer.h.x.a aVar = this.j;
        if (j == aVar.b) {
            this.j = aVar.e;
        }
    }

    private void l() {
        this.e.a();
        a(this.h);
        com.anythink.expressad.exoplayer.h.x.a aVar = new com.anythink.expressad.exoplayer.h.x.a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.o = 0L;
        this.c.b();
    }

    private void m() {
        this.p = true;
    }

    private int n() {
        return this.e.e();
    }

    private void o() {
        c(this.e.l());
    }

    public final int a(long j, boolean z) {
        return this.e.a(j, z);
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final int a(com.anythink.expressad.exoplayer.e.f fVar, int i, boolean z) {
        int d = d(i);
        com.anythink.expressad.exoplayer.h.x.a aVar = this.j;
        int a2 = fVar.a(aVar.d.a, aVar.a(this.o), d);
        if (a2 != -1) {
            e(a2);
            return a2;
        }
        if (z) {
            return -1;
        }
        throw new java.io.EOFException();
    }

    public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z, boolean z2, long j) {
        int i;
        int a2 = this.e.a(nVar, eVar, z, z2, this.k, this.f);
        if (a2 == -5) {
            this.k = nVar.a;
            return -5;
        }
        if (a2 != -4) {
            if (a2 == -3) {
                return -3;
            }
            throw new java.lang.IllegalStateException();
        }
        if (!eVar.c()) {
            if (eVar.f < j) {
                eVar.b(Integer.MIN_VALUE);
            }
            if (eVar.g()) {
                com.anythink.expressad.exoplayer.h.w.a aVar = this.f;
                long j2 = aVar.b;
                this.g.a(1);
                a(j2, this.g.a, 1);
                long j3 = j2 + 1;
                byte b2 = this.g.a[0];
                boolean z3 = (b2 & 128) != 0;
                int i2 = b2 & Byte.MAX_VALUE;
                com.anythink.expressad.exoplayer.c.b bVar = eVar.d;
                if (bVar.a == null) {
                    bVar.a = new byte[16];
                }
                a(j3, bVar.a, i2);
                long j4 = j3 + i2;
                if (z3) {
                    this.g.a(2);
                    a(j4, this.g.a, 2);
                    j4 += 2;
                    i = this.g.e();
                } else {
                    i = 1;
                }
                com.anythink.expressad.exoplayer.c.b bVar2 = eVar.d;
                int[] iArr = bVar2.d;
                if (iArr == null || iArr.length < i) {
                    iArr = new int[i];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = bVar2.e;
                if (iArr3 == null || iArr3.length < i) {
                    iArr3 = new int[i];
                }
                int[] iArr4 = iArr3;
                if (z3) {
                    int i3 = i * 6;
                    this.g.a(i3);
                    a(j4, this.g.a, i3);
                    j4 += i3;
                    this.g.c(0);
                    for (int i4 = 0; i4 < i; i4++) {
                        iArr2[i4] = this.g.e();
                        iArr4[i4] = this.g.m();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = aVar.a - ((int) (j4 - aVar.b));
                }
                com.anythink.expressad.exoplayer.e.m.a aVar2 = aVar.c;
                com.anythink.expressad.exoplayer.c.b bVar3 = eVar.d;
                bVar3.a(i, iArr2, iArr4, aVar2.b, bVar3.a, aVar2.a, aVar2.c, aVar2.d);
                long j5 = aVar.b;
                int i5 = (int) (j4 - j5);
                aVar.b = j5 + i5;
                aVar.a -= i5;
            }
            eVar.d(this.f.a);
            com.anythink.expressad.exoplayer.h.w.a aVar3 = this.f;
            long j6 = aVar3.b;
            java.nio.ByteBuffer byteBuffer = eVar.e;
            int i6 = aVar3.a;
            b(j6);
            while (i6 > 0) {
                int min = java.lang.Math.min(i6, (int) (this.i.b - j6));
                com.anythink.expressad.exoplayer.h.x.a aVar4 = this.i;
                byteBuffer.put(aVar4.d.a, aVar4.a(j6), min);
                i6 -= min;
                j6 += min;
                com.anythink.expressad.exoplayer.h.x.a aVar5 = this.i;
                if (j6 == aVar5.b) {
                    this.i = aVar5.e;
                }
            }
        }
        return -4;
    }

    public final void a() {
        this.e.a();
        a(this.h);
        com.anythink.expressad.exoplayer.h.x.a aVar = new com.anythink.expressad.exoplayer.h.x.a(0L, this.d);
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.o = 0L;
        this.c.b();
    }

    public final void a(int i) {
        long a2 = this.e.a(i);
        this.o = a2;
        if (a2 != 0) {
            com.anythink.expressad.exoplayer.h.x.a aVar = this.h;
            if (a2 != aVar.a) {
                while (this.o > aVar.b) {
                    aVar = aVar.e;
                }
                com.anythink.expressad.exoplayer.h.x.a aVar2 = aVar.e;
                a(aVar2);
                com.anythink.expressad.exoplayer.h.x.a aVar3 = new com.anythink.expressad.exoplayer.h.x.a(aVar.b, this.d);
                aVar.e = aVar3;
                if (this.o == aVar.b) {
                    aVar = aVar3;
                }
                this.j = aVar;
                if (this.i == aVar2) {
                    this.i = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.h);
        com.anythink.expressad.exoplayer.h.x.a aVar4 = new com.anythink.expressad.exoplayer.h.x.a(this.o, this.d);
        this.h = aVar4;
        this.i = aVar4;
        this.j = aVar4;
    }

    public final void a(long j) {
        if (this.n != j) {
            this.n = j;
            this.l = true;
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(long j, int i, int i2, int i3, com.anythink.expressad.exoplayer.e.m.a aVar) {
        if (this.l) {
            a(this.m);
        }
        if (this.p) {
            if ((i & 1) == 0 || !this.e.a(j)) {
                return;
            } else {
                this.p = false;
            }
        }
        this.e.a(j + this.n, i, (this.o - i2) - i3, i2, aVar);
    }

    public final void a(long j, boolean z, boolean z2) {
        c(this.e.a(j, z, z2));
    }

    public final void a(com.anythink.expressad.exoplayer.h.x.b bVar) {
        this.q = bVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(com.anythink.expressad.exoplayer.k.s sVar, int i) {
        while (i > 0) {
            int d = d(i);
            com.anythink.expressad.exoplayer.h.x.a aVar = this.j;
            sVar.a(aVar.d.a, aVar.a(this.o), d);
            i -= d;
            e(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.m
    public final void a(com.anythink.expressad.exoplayer.m mVar) {
        com.anythink.expressad.exoplayer.m mVar2;
        long j = this.n;
        if (mVar == null) {
            mVar2 = null;
        } else {
            if (j != 0) {
                long j2 = mVar.l;
                if (j2 != Long.MAX_VALUE) {
                    mVar2 = mVar.a(j2 + j);
                }
            }
            mVar2 = mVar;
        }
        boolean a2 = this.e.a(mVar2);
        this.m = mVar;
        this.l = false;
        com.anythink.expressad.exoplayer.h.x.b bVar = this.q;
        if (bVar == null || !a2) {
            return;
        }
        bVar.i();
    }

    public final int b() {
        return this.e.b();
    }

    public final boolean b(int i) {
        return this.e.c(i);
    }

    public final boolean c() {
        return this.e.f();
    }

    public final int d() {
        return this.e.c();
    }

    public final int e() {
        return this.e.d();
    }

    public final com.anythink.expressad.exoplayer.m f() {
        return this.e.g();
    }

    public final long g() {
        return this.e.h();
    }

    public final long h() {
        return this.e.i();
    }

    public final void i() {
        this.e.j();
        this.i = this.h;
    }

    public final void j() {
        c(this.e.m());
    }

    public final int k() {
        return this.e.k();
    }
}
