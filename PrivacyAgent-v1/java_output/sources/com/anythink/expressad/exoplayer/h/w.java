package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
final class w {
    private static final int a = 1000;
    private int j;
    private int k;
    private int l;
    private int m;
    private com.anythink.expressad.exoplayer.m r;

    /* renamed from: s, reason: collision with root package name */
    private int f223s;
    private int b = 1000;
    private int[] c = new int[1000];
    private long[] d = new long[1000];
    private long[] g = new long[1000];
    private int[] f = new int[1000];
    private int[] e = new int[1000];
    private com.anythink.expressad.exoplayer.e.m.a[] h = new com.anythink.expressad.exoplayer.e.m.a[1000];
    private com.anythink.expressad.exoplayer.m[] i = new com.anythink.expressad.exoplayer.m[1000];
    private long n = Long.MIN_VALUE;
    private long o = Long.MIN_VALUE;
    private boolean q = true;
    private boolean p = true;

    public static final class a {
        public int a;
        public long b;
        public com.anythink.expressad.exoplayer.e.m.a c;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2 && this.g[i] <= j; i4++) {
            if (!z || (this.f[i] & 1) != 0) {
                i3 = i4;
            }
            i++;
            if (i == this.b) {
                i = 0;
            }
        }
        return i3;
    }

    private synchronized void b(long j) {
        this.o = java.lang.Math.max(this.o, j);
    }

    private long d(int i) {
        this.n = java.lang.Math.max(this.n, e(i));
        int i2 = this.j - i;
        this.j = i2;
        this.k += i;
        int i3 = this.l + i;
        this.l = i3;
        int i4 = this.b;
        if (i3 >= i4) {
            this.l = i3 - i4;
        }
        int i5 = this.m - i;
        this.m = i5;
        if (i5 < 0) {
            this.m = 0;
        }
        if (i2 != 0) {
            return this.d[this.l];
        }
        int i6 = this.l;
        if (i6 != 0) {
            i4 = i6;
        }
        return this.d[i4 - 1] + this.e[r2];
    }

    private long e(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int f = f(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = java.lang.Math.max(j, this.g[f]);
            if ((this.f[f] & 1) != 0) {
                break;
            }
            f--;
            if (f == -1) {
                f = this.b - 1;
            }
        }
        return j;
    }

    private int f(int i) {
        int i2 = this.l + i;
        int i3 = this.b;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized int a(long j, boolean z) {
        int f = f(this.m);
        if (f() && j >= this.g[f] && (j <= this.o || z)) {
            int a2 = a(f, this.j - this.m, j, true);
            if (a2 == -1) {
                return -1;
            }
            this.m += a2;
            return a2;
        }
        return -1;
    }

    public final synchronized int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z, boolean z2, com.anythink.expressad.exoplayer.m mVar, com.anythink.expressad.exoplayer.h.w.a aVar) {
        if (!f()) {
            if (z2) {
                eVar.a(4);
                return -4;
            }
            com.anythink.expressad.exoplayer.m mVar2 = this.r;
            if (mVar2 == null || (!z && mVar2 == mVar)) {
                return -3;
            }
            nVar.a = mVar2;
            return -5;
        }
        int f = f(this.m);
        if (!z && this.i[f] == mVar) {
            if (eVar.f()) {
                return -3;
            }
            eVar.f = this.g[f];
            eVar.a(this.f[f]);
            aVar.a = this.e[f];
            aVar.b = this.d[f];
            aVar.c = this.h[f];
            this.m++;
            return -4;
        }
        nVar.a = this.i[f];
        return -5;
    }

    public final long a(int i) {
        int b = b() - i;
        com.anythink.expressad.exoplayer.k.a.a(b >= 0 && b <= this.j - this.m);
        int i2 = this.j - b;
        this.j = i2;
        this.o = java.lang.Math.max(this.n, e(i2));
        int i3 = this.j;
        if (i3 == 0) {
            return 0L;
        }
        return this.d[f(i3 - 1)] + this.e[r6];
    }

    public final synchronized long a(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.j;
        if (i2 != 0) {
            long[] jArr = this.g;
            int i3 = this.l;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.m) != i2) {
                    i2 = i + 1;
                }
                int a2 = a(i3, i2, j, z);
                if (a2 == -1) {
                    return -1L;
                }
                return d(a2);
            }
        }
        return -1L;
    }

    public final void a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.p = true;
        this.n = Long.MIN_VALUE;
        this.o = Long.MIN_VALUE;
    }

    public final synchronized void a(long j, int i, long j2, int i2, com.anythink.expressad.exoplayer.e.m.a aVar) {
        if (this.p) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.p = false;
            }
        }
        com.anythink.expressad.exoplayer.k.a.b(!this.q);
        b(j);
        int f = f(this.j);
        this.g[f] = j;
        long[] jArr = this.d;
        jArr[f] = j2;
        this.e[f] = i2;
        this.f[f] = i;
        this.h[f] = aVar;
        this.i[f] = this.r;
        this.c[f] = this.f223s;
        int i3 = this.j + 1;
        this.j = i3;
        int i4 = this.b;
        if (i3 == i4) {
            int i5 = i4 + 1000;
            int[] iArr = new int[i5];
            long[] jArr2 = new long[i5];
            long[] jArr3 = new long[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            com.anythink.expressad.exoplayer.e.m.a[] aVarArr = new com.anythink.expressad.exoplayer.e.m.a[i5];
            com.anythink.expressad.exoplayer.m[] mVarArr = new com.anythink.expressad.exoplayer.m[i5];
            int i6 = this.l;
            int i7 = i4 - i6;
            java.lang.System.arraycopy(jArr, i6, jArr2, 0, i7);
            java.lang.System.arraycopy(this.g, this.l, jArr3, 0, i7);
            java.lang.System.arraycopy(this.f, this.l, iArr2, 0, i7);
            java.lang.System.arraycopy(this.e, this.l, iArr3, 0, i7);
            java.lang.System.arraycopy(this.h, this.l, aVarArr, 0, i7);
            java.lang.System.arraycopy(this.i, this.l, mVarArr, 0, i7);
            java.lang.System.arraycopy(this.c, this.l, iArr, 0, i7);
            int i8 = this.l;
            java.lang.System.arraycopy(this.d, 0, jArr2, i7, i8);
            java.lang.System.arraycopy(this.g, 0, jArr3, i7, i8);
            java.lang.System.arraycopy(this.f, 0, iArr2, i7, i8);
            java.lang.System.arraycopy(this.e, 0, iArr3, i7, i8);
            java.lang.System.arraycopy(this.h, 0, aVarArr, i7, i8);
            java.lang.System.arraycopy(this.i, 0, mVarArr, i7, i8);
            java.lang.System.arraycopy(this.c, 0, iArr, i7, i8);
            this.d = jArr2;
            this.g = jArr3;
            this.f = iArr2;
            this.e = iArr3;
            this.h = aVarArr;
            this.i = mVarArr;
            this.c = iArr;
            this.l = 0;
            this.j = this.b;
            this.b = i5;
        }
    }

    public final synchronized boolean a(long j) {
        if (this.j == 0) {
            return j > this.n;
        }
        if (java.lang.Math.max(this.n, e(this.m)) >= j) {
            return false;
        }
        int i = this.j;
        int f = f(i - 1);
        while (i > this.m && this.g[f] >= j) {
            i--;
            f--;
            if (f == -1) {
                f = this.b - 1;
            }
        }
        a(this.k + i);
        return true;
    }

    public final synchronized boolean a(com.anythink.expressad.exoplayer.m mVar) {
        if (mVar == null) {
            this.q = true;
            return false;
        }
        this.q = false;
        if (com.anythink.expressad.exoplayer.k.af.a(mVar, this.r)) {
            return false;
        }
        this.r = mVar;
        return true;
    }

    public final int b() {
        return this.k + this.j;
    }

    public final void b(int i) {
        this.f223s = i;
    }

    public final int c() {
        return this.k;
    }

    public final synchronized boolean c(int i) {
        int i2 = this.k;
        if (i2 > i || i > this.j + i2) {
            return false;
        }
        this.m = i - i2;
        return true;
    }

    public final int d() {
        return this.k + this.m;
    }

    public final int e() {
        return f() ? this.c[f(this.m)] : this.f223s;
    }

    public final synchronized boolean f() {
        return this.m != this.j;
    }

    public final synchronized com.anythink.expressad.exoplayer.m g() {
        if (this.q) {
            return null;
        }
        return this.r;
    }

    public final synchronized long h() {
        return this.o;
    }

    public final synchronized long i() {
        if (this.j == 0) {
            return Long.MIN_VALUE;
        }
        return this.g[this.l];
    }

    public final synchronized void j() {
        this.m = 0;
    }

    public final synchronized int k() {
        int i;
        int i2 = this.j;
        i = i2 - this.m;
        this.m = i2;
        return i;
    }

    public final synchronized long l() {
        int i = this.m;
        if (i == 0) {
            return -1L;
        }
        return d(i);
    }

    public final synchronized long m() {
        int i = this.j;
        if (i == 0) {
            return -1L;
        }
        return d(i);
    }
}
