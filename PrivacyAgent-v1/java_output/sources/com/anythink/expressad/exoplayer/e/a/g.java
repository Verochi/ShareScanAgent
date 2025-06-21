package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
public final class g implements com.anythink.expressad.exoplayer.e.e, com.anythink.expressad.exoplayer.e.k {
    public static final int e = 1;
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final long j = 262144;
    private static final long k = 10485760;
    private long[][] A;
    private int B;
    private long C;
    private boolean D;
    private final int l;
    private final com.anythink.expressad.exoplayer.k.s m;
    private final com.anythink.expressad.exoplayer.k.s n;
    private final com.anythink.expressad.exoplayer.k.s o;
    private final java.util.ArrayDeque<com.anythink.expressad.exoplayer.e.a.a.C0190a> p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private long f216s;
    private int t;
    private com.anythink.expressad.exoplayer.k.s u;
    private int v;
    private int w;
    private int x;
    private com.anythink.expressad.exoplayer.e.g y;
    private com.anythink.expressad.exoplayer.e.a.g.b[] z;
    public static final com.anythink.expressad.exoplayer.e.h d = new com.anythink.expressad.exoplayer.e.a.g.AnonymousClass1();
    private static final int i = com.anythink.expressad.exoplayer.k.af.f("qt  ");

    /* renamed from: com.anythink.expressad.exoplayer.e.a.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.e.h {
        @Override // com.anythink.expressad.exoplayer.e.h
        public final com.anythink.expressad.exoplayer.e.e[] a() {
            return new com.anythink.expressad.exoplayer.e.e[]{new com.anythink.expressad.exoplayer.e.a.g()};
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {
        public final com.anythink.expressad.exoplayer.e.a.j a;
        public final com.anythink.expressad.exoplayer.e.a.m b;
        public final com.anythink.expressad.exoplayer.e.m c;
        public int d;

        public b(com.anythink.expressad.exoplayer.e.a.j jVar, com.anythink.expressad.exoplayer.e.a.m mVar, com.anythink.expressad.exoplayer.e.m mVar2) {
            this.a = jVar;
            this.b = mVar;
            this.c = mVar2;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface c {
    }

    public g() {
        this(0);
    }

    public g(int i2) {
        this.l = i2;
        this.o = new com.anythink.expressad.exoplayer.k.s(16);
        this.p = new java.util.ArrayDeque<>();
        this.m = new com.anythink.expressad.exoplayer.k.s(com.anythink.expressad.exoplayer.k.p.a);
        this.n = new com.anythink.expressad.exoplayer.k.s(4);
        this.v = -1;
    }

    private static int a(com.anythink.expressad.exoplayer.e.a.m mVar, long j2) {
        int a2 = mVar.a(j2);
        return a2 == -1 ? mVar.b(j2) : a2;
    }

    private static long a(com.anythink.expressad.exoplayer.e.a.m mVar, long j2, long j3) {
        int a2 = a(mVar, j2);
        return a2 == -1 ? j3 : java.lang.Math.min(mVar.c[a2], j3);
    }

    private java.util.ArrayList<com.anythink.expressad.exoplayer.e.a.m> a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a, com.anythink.expressad.exoplayer.e.i iVar, boolean z) {
        com.anythink.expressad.exoplayer.e.a.j a2;
        java.util.ArrayList<com.anythink.expressad.exoplayer.e.a.m> arrayList = new java.util.ArrayList<>();
        for (int i2 = 0; i2 < c0190a.aX.size(); i2++) {
            com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a2 = c0190a.aX.get(i2);
            if (c0190a2.aU == com.anythink.expressad.exoplayer.e.a.a.I && (a2 = com.anythink.expressad.exoplayer.e.a.b.a(c0190a2, c0190a.d(com.anythink.expressad.exoplayer.e.a.a.H), -9223372036854775807L, (com.anythink.expressad.exoplayer.d.e) null, z, this.D)) != null) {
                com.anythink.expressad.exoplayer.e.a.m a3 = com.anythink.expressad.exoplayer.e.a.b.a(a2, c0190a2.e(com.anythink.expressad.exoplayer.e.a.a.J).e(com.anythink.expressad.exoplayer.e.a.a.K).e(com.anythink.expressad.exoplayer.e.a.a.L), iVar);
                if (a3.b != 0) {
                    arrayList.add(a3);
                }
            }
        }
        return arrayList;
    }

    private void a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a) {
        com.anythink.expressad.exoplayer.g.a aVar;
        java.util.ArrayList<com.anythink.expressad.exoplayer.e.a.m> a2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.anythink.expressad.exoplayer.e.i iVar = new com.anythink.expressad.exoplayer.e.i();
        com.anythink.expressad.exoplayer.e.a.a.b d2 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.aF);
        if (d2 != null) {
            aVar = com.anythink.expressad.exoplayer.e.a.b.a(d2, this.D);
            if (aVar != null) {
                iVar.a(aVar);
            }
        } else {
            aVar = null;
        }
        int i2 = 1;
        int i3 = 0;
        try {
            a2 = a(c0190a, iVar, (this.l & 1) != 0);
        } catch (com.anythink.expressad.exoplayer.e.a.b.g unused) {
            iVar = new com.anythink.expressad.exoplayer.e.i();
            a2 = a(c0190a, iVar, true);
        }
        int size = a2.size();
        int i4 = -1;
        long j2 = -9223372036854775807L;
        while (i3 < size) {
            com.anythink.expressad.exoplayer.e.a.m mVar = a2.get(i3);
            com.anythink.expressad.exoplayer.e.a.j jVar = mVar.a;
            com.anythink.expressad.exoplayer.e.a.g.b bVar = new com.anythink.expressad.exoplayer.e.a.g.b(jVar, mVar, this.y.a(i3, jVar.d));
            com.anythink.expressad.exoplayer.m a3 = jVar.h.a(mVar.e + 30);
            if (jVar.d == i2) {
                if (iVar.a()) {
                    a3 = a3.a(iVar.b, iVar.c);
                }
                if (aVar != null) {
                    a3 = a3.a(aVar);
                }
            }
            bVar.c.a(a3);
            long j3 = jVar.g;
            if (j3 == -9223372036854775807L) {
                j3 = mVar.h;
            }
            j2 = java.lang.Math.max(j2, j3);
            if (jVar.d == 2 && i4 == -1) {
                i4 = arrayList.size();
            }
            arrayList.add(bVar);
            i3++;
            i2 = 1;
        }
        this.B = i4;
        this.C = j2;
        com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr = (com.anythink.expressad.exoplayer.e.a.g.b[]) arrayList.toArray(new com.anythink.expressad.exoplayer.e.a.g.b[arrayList.size()]);
        this.z = bVarArr;
        this.A = a(bVarArr);
        this.y.c_();
        this.y.a(this);
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.W || i2 == com.anythink.expressad.exoplayer.e.a.a.H || i2 == com.anythink.expressad.exoplayer.e.a.a.X || i2 == com.anythink.expressad.exoplayer.e.a.a.Y || i2 == com.anythink.expressad.exoplayer.e.a.a.ar || i2 == com.anythink.expressad.exoplayer.e.a.a.as || i2 == com.anythink.expressad.exoplayer.e.a.a.at || i2 == com.anythink.expressad.exoplayer.e.a.a.V || i2 == com.anythink.expressad.exoplayer.e.a.a.au || i2 == com.anythink.expressad.exoplayer.e.a.a.av || i2 == com.anythink.expressad.exoplayer.e.a.a.aw || i2 == com.anythink.expressad.exoplayer.e.a.a.ax || i2 == com.anythink.expressad.exoplayer.e.a.a.ay || i2 == com.anythink.expressad.exoplayer.e.a.a.T || i2 == com.anythink.expressad.exoplayer.e.a.a.f || i2 == com.anythink.expressad.exoplayer.e.a.a.aF;
    }

    private static boolean a(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(8);
        if (sVar.i() == i) {
            return true;
        }
        sVar.d(4);
        while (sVar.a() > 0) {
            if (sVar.i() == i) {
                return true;
            }
        }
        return false;
    }

    private static long[][] a(com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            jArr[i2] = new long[bVarArr[i2].b.b];
            jArr2[i2] = bVarArr[i2].b.f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < bVarArr.length) {
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < bVarArr.length; i5++) {
                if (!zArr[i5]) {
                    long j4 = jArr2[i5];
                    if (j4 <= j3) {
                        i4 = i5;
                        j3 = j4;
                    }
                }
            }
            int i6 = iArr[i4];
            long[] jArr3 = jArr[i4];
            jArr3[i6] = j2;
            com.anythink.expressad.exoplayer.e.a.m mVar = bVarArr[i4].b;
            j2 += mVar.d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr3.length) {
                jArr2[i4] = mVar.f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private void b(long j2) {
        while (!this.p.isEmpty() && this.p.peek().aV == j2) {
            com.anythink.expressad.exoplayer.e.a.a.C0190a pop = this.p.pop();
            if (pop.aU == com.anythink.expressad.exoplayer.e.a.a.G) {
                a(pop);
                this.p.clear();
                this.q = 2;
            } else if (!this.p.isEmpty()) {
                this.p.peek().a(pop);
            }
        }
        if (this.q != 2) {
            d();
        }
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.U;
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar) {
        if (this.t == 0) {
            if (!fVar.a(this.o.a, 0, 8, true)) {
                return false;
            }
            this.t = 8;
            this.o.c(0);
            this.f216s = this.o.h();
            this.r = this.o.i();
        }
        long j2 = this.f216s;
        if (j2 == 1) {
            fVar.b(this.o.a, 8, 8);
            this.t += 8;
            this.f216s = this.o.n();
        } else if (j2 == 0) {
            long d2 = fVar.d();
            if (d2 == -1 && !this.p.isEmpty()) {
                d2 = this.p.peek().aV;
            }
            if (d2 != -1) {
                this.f216s = (d2 - fVar.c()) + this.t;
            }
        }
        long j3 = this.f216s;
        int i2 = this.t;
        if (j3 < i2) {
            throw new com.anythink.expressad.exoplayer.t("Atom size less than header length (unsupported).");
        }
        int i3 = this.r;
        if (i3 == com.anythink.expressad.exoplayer.e.a.a.G || i3 == com.anythink.expressad.exoplayer.e.a.a.I || i3 == com.anythink.expressad.exoplayer.e.a.a.J || i3 == com.anythink.expressad.exoplayer.e.a.a.K || i3 == com.anythink.expressad.exoplayer.e.a.a.L || i3 == com.anythink.expressad.exoplayer.e.a.a.U) {
            long c2 = (fVar.c() + this.f216s) - this.t;
            this.p.push(new com.anythink.expressad.exoplayer.e.a.a.C0190a(this.r, c2));
            if (this.f216s == this.t) {
                b(c2);
            } else {
                d();
            }
        } else {
            if (i3 == com.anythink.expressad.exoplayer.e.a.a.W || i3 == com.anythink.expressad.exoplayer.e.a.a.H || i3 == com.anythink.expressad.exoplayer.e.a.a.X || i3 == com.anythink.expressad.exoplayer.e.a.a.Y || i3 == com.anythink.expressad.exoplayer.e.a.a.ar || i3 == com.anythink.expressad.exoplayer.e.a.a.as || i3 == com.anythink.expressad.exoplayer.e.a.a.at || i3 == com.anythink.expressad.exoplayer.e.a.a.V || i3 == com.anythink.expressad.exoplayer.e.a.a.au || i3 == com.anythink.expressad.exoplayer.e.a.a.av || i3 == com.anythink.expressad.exoplayer.e.a.a.aw || i3 == com.anythink.expressad.exoplayer.e.a.a.ax || i3 == com.anythink.expressad.exoplayer.e.a.a.ay || i3 == com.anythink.expressad.exoplayer.e.a.a.T || i3 == com.anythink.expressad.exoplayer.e.a.a.f || i3 == com.anythink.expressad.exoplayer.e.a.a.aF) {
                com.anythink.expressad.exoplayer.k.a.b(i2 == 8);
                com.anythink.expressad.exoplayer.k.a.b(this.f216s <= 2147483647L);
                com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s((int) this.f216s);
                this.u = sVar;
                java.lang.System.arraycopy(this.o.a, 0, sVar.a, 0, 8);
                this.q = 1;
            } else {
                this.u = null;
                this.q = 1;
            }
        }
        return true;
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        boolean z;
        boolean z2;
        long j2 = this.f216s - this.t;
        long c2 = fVar.c() + j2;
        com.anythink.expressad.exoplayer.k.s sVar = this.u;
        if (sVar != null) {
            fVar.b(sVar.a, this.t, (int) j2);
            if (this.r == com.anythink.expressad.exoplayer.e.a.a.f) {
                com.anythink.expressad.exoplayer.k.s sVar2 = this.u;
                sVar2.c(8);
                if (sVar2.i() != i) {
                    sVar2.d(4);
                    while (sVar2.a() > 0) {
                        if (sVar2.i() == i) {
                        }
                    }
                    z2 = false;
                    this.D = z2;
                }
                z2 = true;
                this.D = z2;
            } else if (!this.p.isEmpty()) {
                this.p.peek().a(new com.anythink.expressad.exoplayer.e.a.a.b(this.r, this.u));
            }
        } else {
            if (j2 >= 262144) {
                jVar.a = fVar.c() + j2;
                z = true;
                b(c2);
                return (z || this.q == 2) ? false : true;
            }
            fVar.c((int) j2);
        }
        z = false;
        b(c2);
        if (z) {
        }
    }

    private int c(long j2) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z = true;
        long j4 = Long.MAX_VALUE;
        boolean z2 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr = this.z;
            if (i4 >= bVarArr.length) {
                break;
            }
            com.anythink.expressad.exoplayer.e.a.g.b bVar = bVarArr[i4];
            int i5 = bVar.d;
            com.anythink.expressad.exoplayer.e.a.m mVar = bVar.b;
            if (i5 != mVar.b) {
                long j6 = mVar.c[i5];
                long j7 = this.A[i4][i5];
                long j8 = j6 - j2;
                boolean z3 = j8 < 0 || j8 >= 262144;
                if ((!z3 && z2) || (z3 == z2 && j8 < j5)) {
                    z2 = z3;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z = z3;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        return (j3 == Long.MAX_VALUE || !z || j4 < j3 + k) ? i3 : i2;
    }

    private int c(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        int i2;
        com.anythink.expressad.exoplayer.e.j jVar2;
        long c2 = fVar.c();
        if (this.v == -1) {
            int i3 = 0;
            boolean z = true;
            long j2 = Long.MAX_VALUE;
            boolean z2 = true;
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            int i5 = -1;
            long j4 = Long.MAX_VALUE;
            while (true) {
                com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr = this.z;
                if (i3 >= bVarArr.length) {
                    break;
                }
                com.anythink.expressad.exoplayer.e.a.g.b bVar = bVarArr[i3];
                int i6 = bVar.d;
                com.anythink.expressad.exoplayer.e.a.m mVar = bVar.b;
                if (i6 != mVar.b) {
                    long j5 = mVar.c[i6];
                    long j6 = this.A[i3][i6];
                    long j7 = j5 - c2;
                    boolean z3 = j7 < 0 || j7 >= 262144;
                    if ((!z3 && z) || (z3 == z && j7 < j4)) {
                        i5 = i3;
                        z = z3;
                        j4 = j7;
                        j3 = j6;
                    }
                    if (j6 < j2) {
                        i4 = i3;
                        z2 = z3;
                        j2 = j6;
                    }
                }
                i3++;
            }
            int i7 = (j2 == Long.MAX_VALUE || !z2 || j3 < j2 + k) ? i5 : i4;
            this.v = i7;
            if (i7 == -1) {
                return -1;
            }
        }
        com.anythink.expressad.exoplayer.e.a.g.b bVar2 = this.z[this.v];
        com.anythink.expressad.exoplayer.e.m mVar2 = bVar2.c;
        int i8 = bVar2.d;
        com.anythink.expressad.exoplayer.e.a.m mVar3 = bVar2.b;
        long j8 = mVar3.c[i8];
        int i9 = mVar3.d[i8];
        long j9 = (j8 - c2) + this.w;
        if (j9 < 0) {
            i2 = 1;
            jVar2 = jVar;
        } else {
            if (j9 < 262144) {
                if (bVar2.a.i == 1) {
                    j9 += 8;
                    i9 -= 8;
                }
                fVar.c((int) j9);
                int i10 = bVar2.a.l;
                if (i10 == 0) {
                    while (true) {
                        int i11 = this.w;
                        if (i11 >= i9) {
                            break;
                        }
                        int a2 = mVar2.a(fVar, i9 - i11, false);
                        this.w += a2;
                        this.x -= a2;
                    }
                } else {
                    byte[] bArr = this.n.a;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i12 = 4 - i10;
                    while (this.w < i9) {
                        int i13 = this.x;
                        if (i13 == 0) {
                            fVar.b(this.n.a, i12, i10);
                            this.n.c(0);
                            this.x = this.n.m();
                            this.m.c(0);
                            mVar2.a(this.m, 4);
                            this.w += 4;
                            i9 += i12;
                        } else {
                            int a3 = mVar2.a(fVar, i13, false);
                            this.w += a3;
                            this.x -= a3;
                        }
                    }
                }
                com.anythink.expressad.exoplayer.e.a.m mVar4 = bVar2.b;
                mVar2.a(mVar4.f[i8], mVar4.g[i8], i9, 0, null);
                bVar2.d++;
                this.v = -1;
                this.w = 0;
                this.x = 0;
                return 0;
            }
            jVar2 = jVar;
            i2 = 1;
        }
        jVar2.a = j8;
        return i2;
    }

    private void d() {
        this.q = 0;
        this.t = 0;
    }

    private void d(long j2) {
        for (com.anythink.expressad.exoplayer.e.a.g.b bVar : this.z) {
            com.anythink.expressad.exoplayer.e.a.m mVar = bVar.b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            bVar.d = a2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0337 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0006 A[SYNTHETIC] */
    @Override // com.anythink.expressad.exoplayer.e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        com.anythink.expressad.exoplayer.e.m mVar;
        boolean z;
        boolean z2;
        boolean z3;
        while (true) {
            int i2 = this.q;
            if (i2 == 0) {
                if (this.t == 0) {
                    z3 = false;
                    if (fVar.a(this.o.a, 0, 8, true)) {
                        this.t = 8;
                        this.o.c(0);
                        this.f216s = this.o.h();
                        this.r = this.o.i();
                    }
                    if (z3) {
                        return -1;
                    }
                }
                long j2 = this.f216s;
                if (j2 == 1) {
                    fVar.b(this.o.a, 8, 8);
                    this.t += 8;
                    this.f216s = this.o.n();
                } else if (j2 == 0) {
                    long d2 = fVar.d();
                    if (d2 == -1 && !this.p.isEmpty()) {
                        d2 = this.p.peek().aV;
                    }
                    if (d2 != -1) {
                        this.f216s = (d2 - fVar.c()) + this.t;
                    }
                }
                long j3 = this.f216s;
                int i3 = this.t;
                if (j3 < i3) {
                    throw new com.anythink.expressad.exoplayer.t("Atom size less than header length (unsupported).");
                }
                int i4 = this.r;
                if (i4 == com.anythink.expressad.exoplayer.e.a.a.G || i4 == com.anythink.expressad.exoplayer.e.a.a.I || i4 == com.anythink.expressad.exoplayer.e.a.a.J || i4 == com.anythink.expressad.exoplayer.e.a.a.K || i4 == com.anythink.expressad.exoplayer.e.a.a.L || i4 == com.anythink.expressad.exoplayer.e.a.a.U) {
                    long c2 = (fVar.c() + this.f216s) - this.t;
                    this.p.push(new com.anythink.expressad.exoplayer.e.a.a.C0190a(this.r, c2));
                    if (this.f216s == this.t) {
                        b(c2);
                    } else {
                        d();
                    }
                } else {
                    if (i4 == com.anythink.expressad.exoplayer.e.a.a.W || i4 == com.anythink.expressad.exoplayer.e.a.a.H || i4 == com.anythink.expressad.exoplayer.e.a.a.X || i4 == com.anythink.expressad.exoplayer.e.a.a.Y || i4 == com.anythink.expressad.exoplayer.e.a.a.ar || i4 == com.anythink.expressad.exoplayer.e.a.a.as || i4 == com.anythink.expressad.exoplayer.e.a.a.at || i4 == com.anythink.expressad.exoplayer.e.a.a.V || i4 == com.anythink.expressad.exoplayer.e.a.a.au || i4 == com.anythink.expressad.exoplayer.e.a.a.av || i4 == com.anythink.expressad.exoplayer.e.a.a.aw || i4 == com.anythink.expressad.exoplayer.e.a.a.ax || i4 == com.anythink.expressad.exoplayer.e.a.a.ay || i4 == com.anythink.expressad.exoplayer.e.a.a.T || i4 == com.anythink.expressad.exoplayer.e.a.a.f || i4 == com.anythink.expressad.exoplayer.e.a.a.aF) {
                        com.anythink.expressad.exoplayer.k.a.b(i3 == 8);
                        com.anythink.expressad.exoplayer.k.a.b(this.f216s <= 2147483647L);
                        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s((int) this.f216s);
                        this.u = sVar;
                        java.lang.System.arraycopy(this.o.a, 0, sVar.a, 0, 8);
                        this.q = 1;
                    } else {
                        this.u = null;
                        this.q = 1;
                    }
                }
                z3 = true;
                if (z3) {
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new java.lang.IllegalStateException();
                    }
                    long c3 = fVar.c();
                    if (this.v == -1) {
                        long j4 = Long.MAX_VALUE;
                        long j5 = Long.MAX_VALUE;
                        long j6 = Long.MAX_VALUE;
                        int i5 = 0;
                        boolean z4 = true;
                        boolean z5 = true;
                        int i6 = -1;
                        int i7 = -1;
                        while (true) {
                            com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr = this.z;
                            if (i5 >= bVarArr.length) {
                                break;
                            }
                            com.anythink.expressad.exoplayer.e.a.g.b bVar = bVarArr[i5];
                            int i8 = bVar.d;
                            com.anythink.expressad.exoplayer.e.a.m mVar2 = bVar.b;
                            if (i8 != mVar2.b) {
                                long j7 = mVar2.c[i8];
                                long j8 = this.A[i5][i8];
                                long j9 = j7 - c3;
                                boolean z6 = j9 < 0 || j9 >= 262144;
                                if ((!z6 && z5) || (z6 == z5 && j9 < j6)) {
                                    i7 = i5;
                                    z5 = z6;
                                    j6 = j9;
                                    j5 = j8;
                                }
                                if (j8 < j4) {
                                    i6 = i5;
                                    z4 = z6;
                                    j4 = j8;
                                }
                            }
                            i5++;
                        }
                        int i9 = (j4 == Long.MAX_VALUE || !z4 || j5 < j4 + k) ? i7 : i6;
                        this.v = i9;
                        if (i9 == -1) {
                            return -1;
                        }
                    }
                    com.anythink.expressad.exoplayer.e.a.g.b bVar2 = this.z[this.v];
                    com.anythink.expressad.exoplayer.e.m mVar3 = bVar2.c;
                    int i10 = bVar2.d;
                    com.anythink.expressad.exoplayer.e.a.m mVar4 = bVar2.b;
                    long j10 = mVar4.c[i10];
                    int i11 = mVar4.d[i10];
                    long j11 = (j10 - c3) + this.w;
                    if (j11 < 0 || j11 >= 262144) {
                        jVar.a = j10;
                        return 1;
                    }
                    if (bVar2.a.i == 1) {
                        j11 += 8;
                        i11 -= 8;
                    }
                    fVar.c((int) j11);
                    int i12 = bVar2.a.l;
                    if (i12 == 0) {
                        mVar = mVar3;
                        while (true) {
                            int i13 = this.w;
                            if (i13 >= i11) {
                                break;
                            }
                            int a2 = mVar.a(fVar, i11 - i13, false);
                            this.w += a2;
                            this.x -= a2;
                        }
                    } else {
                        byte[] bArr = this.n.a;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        int i14 = 4 - i12;
                        while (this.w < i11) {
                            int i15 = this.x;
                            if (i15 == 0) {
                                fVar.b(this.n.a, i14, i12);
                                this.n.c(0);
                                this.x = this.n.m();
                                this.m.c(0);
                                mVar3.a(this.m, 4);
                                this.w += 4;
                                i11 += i14;
                            } else {
                                int a3 = mVar3.a(fVar, i15, false);
                                this.w += a3;
                                this.x -= a3;
                            }
                        }
                        mVar = mVar3;
                    }
                    com.anythink.expressad.exoplayer.e.a.m mVar5 = bVar2.b;
                    mVar.a(mVar5.f[i10], mVar5.g[i10], i11, 0, null);
                    bVar2.d++;
                    this.v = -1;
                    this.w = 0;
                    this.x = 0;
                    return 0;
                }
                long j12 = this.f216s - this.t;
                long c4 = fVar.c() + j12;
                com.anythink.expressad.exoplayer.k.s sVar2 = this.u;
                if (sVar2 != null) {
                    fVar.b(sVar2.a, this.t, (int) j12);
                    if (this.r == com.anythink.expressad.exoplayer.e.a.a.f) {
                        com.anythink.expressad.exoplayer.k.s sVar3 = this.u;
                        sVar3.c(8);
                        if (sVar3.i() != i) {
                            sVar3.d(4);
                            while (sVar3.a() > 0) {
                                if (sVar3.i() == i) {
                                }
                            }
                            z2 = false;
                            this.D = z2;
                        }
                        z2 = true;
                        this.D = z2;
                    } else if (!this.p.isEmpty()) {
                        this.p.peek().a(new com.anythink.expressad.exoplayer.e.a.a.b(this.r, this.u));
                    }
                } else if (j12 < 262144) {
                    fVar.c((int) j12);
                } else {
                    jVar.a = fVar.c() + j12;
                    z = true;
                    b(c4);
                    if (!((z || this.q == 2) ? false : true)) {
                        return 1;
                    }
                }
                z = false;
                b(c4);
                if (!((z || this.q == 2) ? false : true)) {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final com.anythink.expressad.exoplayer.e.k.a a(long j2) {
        long j3;
        long j4;
        int b2;
        com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr = this.z;
        if (bVarArr.length == 0) {
            return new com.anythink.expressad.exoplayer.e.k.a(com.anythink.expressad.exoplayer.e.l.a);
        }
        int i2 = this.B;
        long j5 = -1;
        if (i2 != -1) {
            com.anythink.expressad.exoplayer.e.a.m mVar = bVarArr[i2].b;
            int a2 = a(mVar, j2);
            if (a2 == -1) {
                return new com.anythink.expressad.exoplayer.e.k.a(com.anythink.expressad.exoplayer.e.l.a);
            }
            long j6 = mVar.f[a2];
            j3 = mVar.c[a2];
            if (j6 >= j2 || a2 >= mVar.b - 1 || (b2 = mVar.b(j2)) == -1 || b2 == a2) {
                j4 = -9223372036854775807L;
            } else {
                j4 = mVar.f[b2];
                j5 = mVar.c[b2];
            }
            j2 = j6;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr2 = this.z;
            if (i3 >= bVarArr2.length) {
                break;
            }
            if (i3 != this.B) {
                com.anythink.expressad.exoplayer.e.a.m mVar2 = bVarArr2[i3].b;
                long a3 = a(mVar2, j2, j3);
                if (j4 != -9223372036854775807L) {
                    j5 = a(mVar2, j4, j5);
                }
                j3 = a3;
            }
            i3++;
        }
        com.anythink.expressad.exoplayer.e.l lVar = new com.anythink.expressad.exoplayer.e.l(j2, j3);
        return j4 == -9223372036854775807L ? new com.anythink.expressad.exoplayer.e.k.a(lVar) : new com.anythink.expressad.exoplayer.e.k.a(lVar, new com.anythink.expressad.exoplayer.e.l(j4, j5));
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(long j2, long j3) {
        this.p.clear();
        this.t = 0;
        this.v = -1;
        this.w = 0;
        this.x = 0;
        if (j2 == 0) {
            d();
            return;
        }
        com.anythink.expressad.exoplayer.e.a.g.b[] bVarArr = this.z;
        if (bVarArr != null) {
            for (com.anythink.expressad.exoplayer.e.a.g.b bVar : bVarArr) {
                com.anythink.expressad.exoplayer.e.a.m mVar = bVar.b;
                int a2 = mVar.a(j3);
                if (a2 == -1) {
                    a2 = mVar.b(j3);
                }
                bVar.d = a2;
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(com.anythink.expressad.exoplayer.e.g gVar) {
        this.y = gVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return com.anythink.expressad.exoplayer.e.a.i.b(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final long b() {
        return this.C;
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void c() {
    }
}
