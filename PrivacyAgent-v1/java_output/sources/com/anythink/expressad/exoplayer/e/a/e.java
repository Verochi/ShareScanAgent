package com.anythink.expressad.exoplayer.e.a;

/* loaded from: classes12.dex */
public final class e implements com.anythink.expressad.exoplayer.e.e {
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 4;
    public static final int h = 16;
    private static final int i = 8;
    private static final java.lang.String j = "FragmentedMp4Extractor";
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private static final int q = 3;
    private static final int r = 4;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.k.ac A;
    private final com.anythink.expressad.exoplayer.k.s B;
    private final byte[] C;
    private final java.util.ArrayDeque<com.anythink.expressad.exoplayer.e.a.a.C0190a> D;
    private final java.util.ArrayDeque<com.anythink.expressad.exoplayer.e.a.e.b> E;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.e.m F;
    private int G;
    private int H;
    private long I;
    private int J;
    private com.anythink.expressad.exoplayer.k.s K;
    private long L;
    private int M;
    private long N;
    private long O;
    private long P;
    private com.anythink.expressad.exoplayer.e.a.e.c Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private com.anythink.expressad.exoplayer.e.g V;
    private com.anythink.expressad.exoplayer.e.m[] W;
    private com.anythink.expressad.exoplayer.e.m[] X;
    private boolean Y;

    /* renamed from: s, reason: collision with root package name */
    private final int f214s;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.e.a.j t;
    private final java.util.List<com.anythink.expressad.exoplayer.m> u;

    @androidx.annotation.Nullable
    private final com.anythink.expressad.exoplayer.d.e v;
    private final android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> w;
    private final com.anythink.expressad.exoplayer.k.s x;
    private final com.anythink.expressad.exoplayer.k.s y;
    private final com.anythink.expressad.exoplayer.k.s z;
    public static final com.anythink.expressad.exoplayer.e.h d = new com.anythink.expressad.exoplayer.e.a.e.AnonymousClass1();
    private static final int k = com.anythink.expressad.exoplayer.k.af.f("seig");
    private static final byte[] l = {-94, 57, 79, 82, 90, -101, 79, com.google.common.base.Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final com.anythink.expressad.exoplayer.m m = com.anythink.expressad.exoplayer.m.a((java.lang.String) null, "application/x-emsg");

    /* renamed from: com.anythink.expressad.exoplayer.e.a.e$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.exoplayer.e.h {
        @Override // com.anythink.expressad.exoplayer.e.h
        public final com.anythink.expressad.exoplayer.e.e[] a() {
            return new com.anythink.expressad.exoplayer.e.e[]{new com.anythink.expressad.exoplayer.e.a.e()};
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static final class b {
        public final long a;
        public final int b;

        public b(long j, int i) {
            this.a = j;
            this.b = i;
        }
    }

    public static final class c {
        public final com.anythink.expressad.exoplayer.e.m a;
        public com.anythink.expressad.exoplayer.e.a.j c;
        public com.anythink.expressad.exoplayer.e.a.c d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final com.anythink.expressad.exoplayer.e.a.l b = new com.anythink.expressad.exoplayer.e.a.l();
        private final com.anythink.expressad.exoplayer.k.s i = new com.anythink.expressad.exoplayer.k.s(1);
        private final com.anythink.expressad.exoplayer.k.s j = new com.anythink.expressad.exoplayer.k.s();

        public c(com.anythink.expressad.exoplayer.e.m mVar) {
            this.a = mVar;
        }

        public static /* synthetic */ void a(com.anythink.expressad.exoplayer.e.a.e.c cVar) {
            com.anythink.expressad.exoplayer.e.a.l lVar = cVar.b;
            if (lVar.m) {
                com.anythink.expressad.exoplayer.k.s sVar = lVar.q;
                int i = cVar.e().d;
                if (i != 0) {
                    sVar.d(i);
                }
                if (cVar.b.n[cVar.e]) {
                    sVar.d(sVar.e() * 6);
                }
            }
        }

        private void d() {
            com.anythink.expressad.exoplayer.e.a.l lVar = this.b;
            if (lVar.m) {
                com.anythink.expressad.exoplayer.k.s sVar = lVar.q;
                int i = e().d;
                if (i != 0) {
                    sVar.d(i);
                }
                if (this.b.n[this.e]) {
                    sVar.d(sVar.e() * 6);
                }
            }
        }

        private com.anythink.expressad.exoplayer.e.a.k e() {
            com.anythink.expressad.exoplayer.e.a.l lVar = this.b;
            int i = lVar.a.a;
            com.anythink.expressad.exoplayer.e.a.k kVar = lVar.o;
            return kVar != null ? kVar : this.c.a(i);
        }

        public final void a() {
            this.b.a();
            this.e = 0;
            this.g = 0;
            this.f = 0;
            this.h = 0;
        }

        public final void a(long j) {
            long a = com.anythink.expressad.exoplayer.b.a(j);
            int i = this.e;
            while (true) {
                com.anythink.expressad.exoplayer.e.a.l lVar = this.b;
                if (i >= lVar.f || lVar.b(i) >= a) {
                    return;
                }
                if (this.b.l[i]) {
                    this.h = i;
                }
                i++;
            }
        }

        public final void a(com.anythink.expressad.exoplayer.d.e eVar) {
            com.anythink.expressad.exoplayer.e.a.k a = this.c.a(this.b.a.a);
            this.a.a(this.c.h.a(eVar.a(a != null ? a.b : null)));
        }

        public final void a(com.anythink.expressad.exoplayer.e.a.j jVar, com.anythink.expressad.exoplayer.e.a.c cVar) {
            this.c = (com.anythink.expressad.exoplayer.e.a.j) com.anythink.expressad.exoplayer.k.a.a(jVar);
            this.d = (com.anythink.expressad.exoplayer.e.a.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
            this.a.a(jVar.h);
            a();
        }

        public final boolean b() {
            this.e++;
            int i = this.f + 1;
            this.f = i;
            int[] iArr = this.b.h;
            int i2 = this.g;
            if (i != iArr[i2]) {
                return true;
            }
            this.g = i2 + 1;
            this.f = 0;
            return false;
        }

        public final int c() {
            com.anythink.expressad.exoplayer.k.s sVar;
            if (!this.b.m) {
                return 0;
            }
            com.anythink.expressad.exoplayer.e.a.k e = e();
            int i = e.d;
            if (i != 0) {
                sVar = this.b.q;
            } else {
                byte[] bArr = e.e;
                this.j.a(bArr, bArr.length);
                com.anythink.expressad.exoplayer.k.s sVar2 = this.j;
                i = bArr.length;
                sVar = sVar2;
            }
            boolean z = this.b.n[this.e];
            com.anythink.expressad.exoplayer.k.s sVar3 = this.i;
            sVar3.a[0] = (byte) ((z ? 128 : 0) | i);
            sVar3.c(0);
            this.a.a(this.i, 1);
            this.a.a(sVar, i);
            if (!z) {
                return i + 1;
            }
            com.anythink.expressad.exoplayer.k.s sVar4 = this.b.q;
            int e2 = sVar4.e();
            sVar4.d(-2);
            int i2 = (e2 * 6) + 2;
            this.a.a(sVar4, i2);
            return i + 1 + i2;
        }
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, null);
    }

    private e(int i2, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.k.ac acVar) {
        this(i2, acVar, null, null);
    }

    private e(int i2, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.k.ac acVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.e.a.j jVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e eVar) {
        this(i2, acVar, jVar, eVar, java.util.Collections.emptyList());
    }

    private e(int i2, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.k.ac acVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.e.a.j jVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e eVar, java.util.List<com.anythink.expressad.exoplayer.m> list) {
        this(i2, acVar, jVar, eVar, list, null);
    }

    private e(int i2, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.k.ac acVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.e.a.j jVar, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.d.e eVar, java.util.List<com.anythink.expressad.exoplayer.m> list, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.e.m mVar) {
        this.f214s = i2 | (jVar != null ? 8 : 0);
        this.A = acVar;
        this.t = jVar;
        this.v = eVar;
        this.u = java.util.Collections.unmodifiableList(list);
        this.F = mVar;
        this.B = new com.anythink.expressad.exoplayer.k.s(16);
        this.x = new com.anythink.expressad.exoplayer.k.s(com.anythink.expressad.exoplayer.k.p.a);
        this.y = new com.anythink.expressad.exoplayer.k.s(5);
        this.z = new com.anythink.expressad.exoplayer.k.s();
        this.C = new byte[16];
        this.D = new java.util.ArrayDeque<>();
        this.E = new java.util.ArrayDeque<>();
        this.w = new android.util.SparseArray<>();
        this.O = -9223372036854775807L;
        this.N = -9223372036854775807L;
        this.P = -9223372036854775807L;
        a();
    }

    private static int a(com.anythink.expressad.exoplayer.e.a.e.c cVar, int i2, long j2, int i3, com.anythink.expressad.exoplayer.k.s sVar, int i4) {
        boolean z;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        boolean z5;
        sVar.c(8);
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        com.anythink.expressad.exoplayer.e.a.j jVar = cVar.c;
        com.anythink.expressad.exoplayer.e.a.l lVar = cVar.b;
        com.anythink.expressad.exoplayer.e.a.c cVar2 = lVar.a;
        lVar.h[i2] = sVar.m();
        long[] jArr = lVar.g;
        long j3 = lVar.c;
        jArr[i2] = j3;
        if ((b2 & 1) != 0) {
            jArr[i2] = j3 + sVar.i();
        }
        boolean z6 = (b2 & 4) != 0;
        int i7 = cVar2.d;
        if (z6) {
            i7 = sVar.m();
        }
        boolean z7 = (b2 & 256) != 0;
        boolean z8 = (b2 & 512) != 0;
        boolean z9 = (b2 & 1024) != 0;
        boolean z10 = (b2 & 2048) != 0;
        long[] jArr2 = jVar.j;
        long j4 = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            j4 = com.anythink.expressad.exoplayer.k.af.a(jVar.k[0], 1000L, jVar.e);
        }
        int[] iArr = lVar.i;
        int[] iArr2 = lVar.j;
        long[] jArr3 = lVar.k;
        boolean[] zArr = lVar.l;
        int i8 = i7;
        boolean z11 = jVar.d == 2 && (i3 & 1) != 0;
        int i9 = i4 + lVar.h[i2];
        long j5 = jVar.e;
        long j6 = j4;
        long j7 = i2 > 0 ? lVar.f217s : j2;
        int i10 = i4;
        while (i10 < i9) {
            int m2 = z7 ? sVar.m() : cVar2.b;
            if (z8) {
                z = z7;
                i5 = sVar.m();
            } else {
                z = z7;
                i5 = cVar2.c;
            }
            if (i10 == 0 && z6) {
                z2 = z6;
                i6 = i8;
            } else if (z9) {
                z2 = z6;
                i6 = sVar.i();
            } else {
                z2 = z6;
                i6 = cVar2.d;
            }
            if (z10) {
                z3 = z10;
                z4 = z8;
                z5 = z9;
                iArr2[i10] = (int) ((sVar.i() * 1000) / j5);
            } else {
                z3 = z10;
                z4 = z8;
                z5 = z9;
                iArr2[i10] = 0;
            }
            jArr3[i10] = com.anythink.expressad.exoplayer.k.af.a(j7, 1000L, j5) - j6;
            iArr[i10] = i5;
            zArr[i10] = ((i6 >> 16) & 1) == 0 && (!z11 || i10 == 0);
            i10++;
            j7 += m2;
            j5 = j5;
            z7 = z;
            z6 = z2;
            z10 = z3;
            z8 = z4;
            z9 = z5;
        }
        lVar.f217s = j7;
        return i9;
    }

    private static android.util.Pair<java.lang.Long, com.anythink.expressad.exoplayer.e.a> a(com.anythink.expressad.exoplayer.k.s sVar, long j2) {
        long n2;
        long n3;
        sVar.c(8);
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar.i());
        sVar.d(4);
        long h2 = sVar.h();
        if (a2 == 0) {
            n2 = sVar.h();
            n3 = sVar.h();
        } else {
            n2 = sVar.n();
            n3 = sVar.n();
        }
        long j3 = n2;
        long j4 = j2 + n3;
        long a3 = com.anythink.expressad.exoplayer.k.af.a(j3, 1000000L, h2);
        sVar.d(2);
        int e2 = sVar.e();
        int[] iArr = new int[e2];
        long[] jArr = new long[e2];
        long[] jArr2 = new long[e2];
        long[] jArr3 = new long[e2];
        long j5 = j3;
        long j6 = a3;
        int i2 = 0;
        while (i2 < e2) {
            int i3 = sVar.i();
            if ((i3 & Integer.MIN_VALUE) != 0) {
                throw new com.anythink.expressad.exoplayer.t("Unhandled indirect reference");
            }
            long h3 = sVar.h();
            iArr[i2] = i3 & Integer.MAX_VALUE;
            jArr[i2] = j4;
            jArr3[i2] = j6;
            long j7 = j5 + h3;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i4 = e2;
            long a4 = com.anythink.expressad.exoplayer.k.af.a(j7, 1000000L, h2);
            jArr4[i2] = a4 - jArr5[i2];
            sVar.d(4);
            j4 += r1[i2];
            i2++;
            iArr = iArr;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            e2 = i4;
            j5 = j7;
            j6 = a4;
        }
        return android.util.Pair.create(java.lang.Long.valueOf(a3), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
    }

    private static com.anythink.expressad.exoplayer.d.e a(java.util.List<com.anythink.expressad.exoplayer.e.a.a.b> list) {
        int size = list.size();
        java.util.ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.e.a.a.b bVar = list.get(i2);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.Z) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList();
                }
                byte[] bArr = bVar.aV.a;
                java.util.UUID a2 = com.anythink.expressad.exoplayer.e.a.h.a(bArr);
                if (a2 != null) {
                    arrayList.add(new com.anythink.expressad.exoplayer.d.e.a(a2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.anythink.expressad.exoplayer.d.e(arrayList);
    }

    private static com.anythink.expressad.exoplayer.e.a.c a(android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.c> sparseArray, int i2) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (com.anythink.expressad.exoplayer.e.a.c) com.anythink.expressad.exoplayer.k.a.a(sparseArray.get(i2));
    }

    private static com.anythink.expressad.exoplayer.e.a.e.c a(android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray) {
        int size = sparseArray.size();
        com.anythink.expressad.exoplayer.e.a.e.c cVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.e.a.e.c valueAt = sparseArray.valueAt(i2);
            int i3 = valueAt.g;
            com.anythink.expressad.exoplayer.e.a.l lVar = valueAt.b;
            if (i3 != lVar.e) {
                long j3 = lVar.g[i3];
                if (j3 < j2) {
                    cVar = valueAt;
                    j2 = j3;
                }
            }
        }
        return cVar;
    }

    private static com.anythink.expressad.exoplayer.e.a.e.c a(com.anythink.expressad.exoplayer.k.s sVar, android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray) {
        sVar.c(8);
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        com.anythink.expressad.exoplayer.e.a.e.c b3 = b(sparseArray, sVar.i());
        if (b3 == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long n2 = sVar.n();
            com.anythink.expressad.exoplayer.e.a.l lVar = b3.b;
            lVar.c = n2;
            lVar.d = n2;
        }
        com.anythink.expressad.exoplayer.e.a.c cVar = b3.d;
        b3.b.a = new com.anythink.expressad.exoplayer.e.a.c((b2 & 2) != 0 ? sVar.m() - 1 : cVar.a, (b2 & 8) != 0 ? sVar.m() : cVar.b, (b2 & 16) != 0 ? sVar.m() : cVar.c, (b2 & 32) != 0 ? sVar.m() : cVar.d);
        return b3;
    }

    private void a() {
        this.G = 0;
        this.J = 0;
    }

    private void a(long j2) {
        while (!this.D.isEmpty() && this.D.peek().aV == j2) {
            a(this.D.pop());
        }
        a();
    }

    private void a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a) {
        int i2 = c0190a.aU;
        if (i2 == com.anythink.expressad.exoplayer.e.a.a.G) {
            b(c0190a);
        } else if (i2 == com.anythink.expressad.exoplayer.e.a.a.P) {
            c(c0190a);
        } else {
            if (this.D.isEmpty()) {
                return;
            }
            this.D.peek().a(c0190a);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a, android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray, int i2, byte[] bArr) {
        int size = c0190a.aX.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a2 = c0190a.aX.get(i3);
            if (c0190a2.aU == com.anythink.expressad.exoplayer.e.a.a.Q) {
                b(c0190a2, sparseArray, i2, bArr);
            }
        }
    }

    private static void a(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a, com.anythink.expressad.exoplayer.e.a.e.c cVar, long j2, int i2) {
        java.util.List<com.anythink.expressad.exoplayer.e.a.a.b> list = c0190a.aW;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            com.anythink.expressad.exoplayer.e.a.a.b bVar = list.get(i5);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.E) {
                com.anythink.expressad.exoplayer.k.s sVar = bVar.aV;
                sVar.c(12);
                int m2 = sVar.m();
                if (m2 > 0) {
                    i4 += m2;
                    i3++;
                }
            }
        }
        cVar.g = 0;
        cVar.f = 0;
        cVar.e = 0;
        cVar.b.a(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            com.anythink.expressad.exoplayer.e.a.a.b bVar2 = list.get(i8);
            if (bVar2.aU == com.anythink.expressad.exoplayer.e.a.a.E) {
                i7 = a(cVar, i6, j2, i2, bVar2.aV, i7);
                i6++;
            }
        }
    }

    private void a(com.anythink.expressad.exoplayer.e.a.a.b bVar, long j2) {
        long n2;
        long n3;
        if (!this.D.isEmpty()) {
            this.D.peek().a(bVar);
            return;
        }
        int i2 = bVar.aU;
        int i3 = 0;
        if (i2 != com.anythink.expressad.exoplayer.e.a.a.F) {
            if (i2 == com.anythink.expressad.exoplayer.e.a.a.aL) {
                com.anythink.expressad.exoplayer.k.s sVar = bVar.aV;
                com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
                if (mVarArr == null || mVarArr.length == 0) {
                    return;
                }
                sVar.c(12);
                int a2 = sVar.a();
                sVar.p();
                sVar.p();
                long a3 = com.anythink.expressad.exoplayer.k.af.a(sVar.h(), 1000000L, sVar.h());
                for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
                    sVar.c(12);
                    mVar.a(sVar, a2);
                }
                long j3 = this.P;
                if (j3 == -9223372036854775807L) {
                    this.E.addLast(new com.anythink.expressad.exoplayer.e.a.e.b(a3, a2));
                    this.M += a2;
                    return;
                }
                long j4 = j3 + a3;
                com.anythink.expressad.exoplayer.k.ac acVar = this.A;
                if (acVar != null) {
                    j4 = acVar.b(j4);
                }
                com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
                int length = mVarArr2.length;
                while (i3 < length) {
                    mVarArr2[i3].a(j4, 1, a2, 0, null);
                    i3++;
                }
                return;
            }
            return;
        }
        com.anythink.expressad.exoplayer.k.s sVar2 = bVar.aV;
        sVar2.c(8);
        int a4 = com.anythink.expressad.exoplayer.e.a.a.a(sVar2.i());
        sVar2.d(4);
        long h2 = sVar2.h();
        if (a4 == 0) {
            n2 = sVar2.h();
            n3 = sVar2.h();
        } else {
            n2 = sVar2.n();
            n3 = sVar2.n();
        }
        long j5 = n2;
        long j6 = j2 + n3;
        long a5 = com.anythink.expressad.exoplayer.k.af.a(j5, 1000000L, h2);
        sVar2.d(2);
        int e2 = sVar2.e();
        int[] iArr = new int[e2];
        long[] jArr = new long[e2];
        long[] jArr2 = new long[e2];
        long[] jArr3 = new long[e2];
        long j7 = a5;
        while (i3 < e2) {
            int i4 = sVar2.i();
            if ((i4 & Integer.MIN_VALUE) != 0) {
                throw new com.anythink.expressad.exoplayer.t("Unhandled indirect reference");
            }
            long h3 = sVar2.h();
            iArr[i3] = i4 & Integer.MAX_VALUE;
            jArr[i3] = j6;
            jArr3[i3] = j7;
            long j8 = j5 + h3;
            int i5 = e2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            j7 = com.anythink.expressad.exoplayer.k.af.a(j8, 1000000L, h2);
            jArr4[i3] = j7 - jArr5[i3];
            sVar2.d(4);
            j6 += r13[i3];
            i3++;
            jArr3 = jArr5;
            jArr2 = jArr4;
            iArr = iArr;
            jArr = jArr;
            j5 = j8;
            e2 = i5;
        }
        android.util.Pair create = android.util.Pair.create(java.lang.Long.valueOf(a5), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
        this.P = ((java.lang.Long) create.first).longValue();
        this.V.a((com.anythink.expressad.exoplayer.e.k) create.second);
        this.Y = true;
    }

    private static void a(com.anythink.expressad.exoplayer.e.a.k kVar, com.anythink.expressad.exoplayer.k.s sVar, com.anythink.expressad.exoplayer.e.a.l lVar) {
        int i2;
        int i3 = kVar.d;
        sVar.c(8);
        if ((com.anythink.expressad.exoplayer.e.a.a.b(sVar.i()) & 1) == 1) {
            sVar.d(8);
        }
        int d2 = sVar.d();
        int m2 = sVar.m();
        if (m2 != lVar.f) {
            throw new com.anythink.expressad.exoplayer.t("Length mismatch: " + m2 + ", " + lVar.f);
        }
        if (d2 == 0) {
            boolean[] zArr = lVar.n;
            i2 = 0;
            for (int i4 = 0; i4 < m2; i4++) {
                int d3 = sVar.d();
                i2 += d3;
                zArr[i4] = d3 > i3;
            }
        } else {
            i2 = (d2 * m2) + 0;
            java.util.Arrays.fill(lVar.n, 0, m2, d2 > i3);
        }
        lVar.a(i2);
    }

    private void a(com.anythink.expressad.exoplayer.k.s sVar) {
        com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
        if (mVarArr == null || mVarArr.length == 0) {
            return;
        }
        sVar.c(12);
        int a2 = sVar.a();
        sVar.p();
        sVar.p();
        long a3 = com.anythink.expressad.exoplayer.k.af.a(sVar.h(), 1000000L, sVar.h());
        for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
            sVar.c(12);
            mVar.a(sVar, a2);
        }
        long j2 = this.P;
        if (j2 == -9223372036854775807L) {
            this.E.addLast(new com.anythink.expressad.exoplayer.e.a.e.b(a3, a2));
            this.M += a2;
            return;
        }
        long j3 = j2 + a3;
        com.anythink.expressad.exoplayer.k.ac acVar = this.A;
        if (acVar != null) {
            j3 = acVar.b(j3);
        }
        long j4 = j3;
        for (com.anythink.expressad.exoplayer.e.m mVar2 : this.W) {
            mVar2.a(j4, 1, a2, 0, null);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, int i2, com.anythink.expressad.exoplayer.e.a.l lVar) {
        sVar.c(i2 + 8);
        int b2 = com.anythink.expressad.exoplayer.e.a.a.b(sVar.i());
        if ((b2 & 1) != 0) {
            throw new com.anythink.expressad.exoplayer.t("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (b2 & 2) != 0;
        int m2 = sVar.m();
        if (m2 == lVar.f) {
            java.util.Arrays.fill(lVar.n, 0, m2, z);
            lVar.a(sVar.a());
            lVar.a(sVar);
        } else {
            throw new com.anythink.expressad.exoplayer.t("Length mismatch: " + m2 + ", " + lVar.f);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, com.anythink.expressad.exoplayer.e.a.l lVar) {
        sVar.c(8);
        int i2 = sVar.i();
        if ((com.anythink.expressad.exoplayer.e.a.a.b(i2) & 1) == 1) {
            sVar.d(8);
        }
        int m2 = sVar.m();
        if (m2 != 1) {
            throw new com.anythink.expressad.exoplayer.t("Unexpected saio entry count: ".concat(java.lang.String.valueOf(m2)));
        }
        lVar.d += com.anythink.expressad.exoplayer.e.a.a.a(i2) == 0 ? sVar.h() : sVar.n();
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, com.anythink.expressad.exoplayer.e.a.l lVar, byte[] bArr) {
        sVar.c(8);
        sVar.a(bArr, 0, 16);
        if (java.util.Arrays.equals(bArr, l)) {
            a(sVar, 16, lVar);
        }
    }

    private static void a(com.anythink.expressad.exoplayer.k.s sVar, com.anythink.expressad.exoplayer.k.s sVar2, java.lang.String str, com.anythink.expressad.exoplayer.e.a.l lVar) {
        byte[] bArr;
        sVar.c(8);
        int i2 = sVar.i();
        int i3 = sVar.i();
        int i4 = k;
        if (i3 != i4) {
            return;
        }
        if (com.anythink.expressad.exoplayer.e.a.a.a(i2) == 1) {
            sVar.d(4);
        }
        if (sVar.i() != 1) {
            throw new com.anythink.expressad.exoplayer.t("Entry count in sbgp != 1 (unsupported).");
        }
        sVar2.c(8);
        int i5 = sVar2.i();
        if (sVar2.i() != i4) {
            return;
        }
        int a2 = com.anythink.expressad.exoplayer.e.a.a.a(i5);
        if (a2 == 1) {
            if (sVar2.h() == 0) {
                throw new com.anythink.expressad.exoplayer.t("Variable length description in sgpd found (unsupported)");
            }
        } else if (a2 >= 2) {
            sVar2.d(4);
        }
        if (sVar2.h() != 1) {
            throw new com.anythink.expressad.exoplayer.t("Entry count in sgpd != 1 (unsupported).");
        }
        sVar2.d(1);
        int d2 = sVar2.d();
        int i6 = (d2 & 240) >> 4;
        int i7 = d2 & 15;
        if (sVar2.d() == 1) {
            int d3 = sVar2.d();
            byte[] bArr2 = new byte[16];
            sVar2.a(bArr2, 0, 16);
            if (d3 == 0) {
                int d4 = sVar2.d();
                byte[] bArr3 = new byte[d4];
                sVar2.a(bArr3, 0, d4);
                bArr = bArr3;
            } else {
                bArr = null;
            }
            lVar.m = true;
            lVar.o = new com.anythink.expressad.exoplayer.e.a.k(true, str, d3, bArr2, i6, i7, bArr);
        }
    }

    private static boolean a(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.X || i2 == com.anythink.expressad.exoplayer.e.a.a.W || i2 == com.anythink.expressad.exoplayer.e.a.a.H || i2 == com.anythink.expressad.exoplayer.e.a.a.F || i2 == com.anythink.expressad.exoplayer.e.a.a.Y || i2 == com.anythink.expressad.exoplayer.e.a.a.B || i2 == com.anythink.expressad.exoplayer.e.a.a.C || i2 == com.anythink.expressad.exoplayer.e.a.a.T || i2 == com.anythink.expressad.exoplayer.e.a.a.D || i2 == com.anythink.expressad.exoplayer.e.a.a.E || i2 == com.anythink.expressad.exoplayer.e.a.a.Z || i2 == com.anythink.expressad.exoplayer.e.a.a.ah || i2 == com.anythink.expressad.exoplayer.e.a.a.ai || i2 == com.anythink.expressad.exoplayer.e.a.a.am || i2 == com.anythink.expressad.exoplayer.e.a.a.al || i2 == com.anythink.expressad.exoplayer.e.a.a.aj || i2 == com.anythink.expressad.exoplayer.e.a.a.ak || i2 == com.anythink.expressad.exoplayer.e.a.a.V || i2 == com.anythink.expressad.exoplayer.e.a.a.S || i2 == com.anythink.expressad.exoplayer.e.a.a.aL;
    }

    private static android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.c> b(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(12);
        return android.util.Pair.create(java.lang.Integer.valueOf(sVar.i()), new com.anythink.expressad.exoplayer.e.a.c(sVar.m() - 1, sVar.m(), sVar.m(), sVar.i()));
    }

    @androidx.annotation.Nullable
    private static com.anythink.expressad.exoplayer.e.a.e.c b(android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray, int i2) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : sparseArray.get(i2);
    }

    private void b() {
        int i2;
        if (this.W == null) {
            com.anythink.expressad.exoplayer.e.m[] mVarArr = new com.anythink.expressad.exoplayer.e.m[2];
            this.W = mVarArr;
            com.anythink.expressad.exoplayer.e.m mVar = this.F;
            if (mVar != null) {
                mVarArr[0] = mVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((this.f214s & 4) != 0) {
                mVarArr[i2] = this.V.a(this.w.size(), 4);
                i2++;
            }
            com.anythink.expressad.exoplayer.e.m[] mVarArr2 = (com.anythink.expressad.exoplayer.e.m[]) java.util.Arrays.copyOf(this.W, i2);
            this.W = mVarArr2;
            for (com.anythink.expressad.exoplayer.e.m mVar2 : mVarArr2) {
                mVar2.a(m);
            }
        }
        if (this.X == null) {
            this.X = new com.anythink.expressad.exoplayer.e.m[this.u.size()];
            for (int i3 = 0; i3 < this.X.length; i3++) {
                com.anythink.expressad.exoplayer.e.m a2 = this.V.a(this.w.size() + 1 + i3, 3);
                a2.a(this.u.get(i3));
                this.X[i3] = a2;
            }
        }
    }

    private void b(long j2) {
        while (!this.E.isEmpty()) {
            com.anythink.expressad.exoplayer.e.a.e.b removeFirst = this.E.removeFirst();
            this.M -= removeFirst.b;
            long j3 = removeFirst.a + j2;
            com.anythink.expressad.exoplayer.k.ac acVar = this.A;
            if (acVar != null) {
                j3 = acVar.b(j3);
            }
            for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
                mVar.a(j3, 1, removeFirst.b, this.M, null);
            }
        }
    }

    private void b(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a) {
        int i2;
        int i3;
        int i4 = 0;
        com.anythink.expressad.exoplayer.k.a.b(this.t == null, "Unexpected moov box.");
        com.anythink.expressad.exoplayer.d.e eVar = this.v;
        if (eVar == null) {
            eVar = a(c0190a.aW);
        }
        com.anythink.expressad.exoplayer.e.a.a.C0190a e2 = c0190a.e(com.anythink.expressad.exoplayer.e.a.a.R);
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        int size = e2.aW.size();
        long j2 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            com.anythink.expressad.exoplayer.e.a.a.b bVar = e2.aW.get(i5);
            int i6 = bVar.aU;
            if (i6 == com.anythink.expressad.exoplayer.e.a.a.D) {
                android.util.Pair<java.lang.Integer, com.anythink.expressad.exoplayer.e.a.c> b2 = b(bVar.aV);
                sparseArray.put(((java.lang.Integer) b2.first).intValue(), (com.anythink.expressad.exoplayer.e.a.c) b2.second);
            } else if (i6 == com.anythink.expressad.exoplayer.e.a.a.S) {
                j2 = c(bVar.aV);
            }
        }
        android.util.SparseArray sparseArray2 = new android.util.SparseArray();
        int size2 = c0190a.aX.size();
        int i7 = 0;
        while (i7 < size2) {
            com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a2 = c0190a.aX.get(i7);
            if (c0190a2.aU == com.anythink.expressad.exoplayer.e.a.a.I) {
                i2 = i7;
                i3 = size2;
                com.anythink.expressad.exoplayer.e.a.j a2 = com.anythink.expressad.exoplayer.e.a.b.a(c0190a2, c0190a.d(com.anythink.expressad.exoplayer.e.a.a.H), j2, eVar, (this.f214s & 16) != 0, false);
                if (a2 != null) {
                    sparseArray2.put(a2.c, a2);
                }
            } else {
                i2 = i7;
                i3 = size2;
            }
            i7 = i2 + 1;
            size2 = i3;
        }
        int size3 = sparseArray2.size();
        if (this.w.size() != 0) {
            com.anythink.expressad.exoplayer.k.a.b(this.w.size() == size3);
            while (i4 < size3) {
                com.anythink.expressad.exoplayer.e.a.j jVar = (com.anythink.expressad.exoplayer.e.a.j) sparseArray2.valueAt(i4);
                this.w.get(jVar.c).a(jVar, a((android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.c>) sparseArray, jVar.c));
                i4++;
            }
            return;
        }
        while (i4 < size3) {
            com.anythink.expressad.exoplayer.e.a.j jVar2 = (com.anythink.expressad.exoplayer.e.a.j) sparseArray2.valueAt(i4);
            com.anythink.expressad.exoplayer.e.a.e.c cVar = new com.anythink.expressad.exoplayer.e.a.e.c(this.V.a(i4, jVar2.d));
            cVar.a(jVar2, a((android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.c>) sparseArray, jVar2.c));
            this.w.put(jVar2.c, cVar);
            this.O = java.lang.Math.max(this.O, jVar2.g);
            i4++;
        }
        b();
        this.V.c_();
    }

    private static void b(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a, android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray, int i2, byte[] bArr) {
        com.anythink.expressad.exoplayer.e.a.e.c a2 = a(c0190a.d(com.anythink.expressad.exoplayer.e.a.a.C).aV, sparseArray);
        if (a2 == null) {
            return;
        }
        com.anythink.expressad.exoplayer.e.a.l lVar = a2.b;
        long j2 = lVar.f217s;
        a2.a();
        int i3 = com.anythink.expressad.exoplayer.e.a.a.B;
        if (c0190a.d(i3) != null && (i2 & 2) == 0) {
            j2 = d(c0190a.d(i3).aV);
        }
        a(c0190a, a2, j2, i2);
        com.anythink.expressad.exoplayer.e.a.k a3 = a2.c.a(lVar.a.a);
        com.anythink.expressad.exoplayer.e.a.a.b d2 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.ah);
        if (d2 != null) {
            a(a3, d2.aV, lVar);
        }
        com.anythink.expressad.exoplayer.e.a.a.b d3 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.ai);
        if (d3 != null) {
            a(d3.aV, lVar);
        }
        com.anythink.expressad.exoplayer.e.a.a.b d4 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.am);
        if (d4 != null) {
            a(d4.aV, 0, lVar);
        }
        com.anythink.expressad.exoplayer.e.a.a.b d5 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.aj);
        com.anythink.expressad.exoplayer.e.a.a.b d6 = c0190a.d(com.anythink.expressad.exoplayer.e.a.a.ak);
        if (d5 != null && d6 != null) {
            a(d5.aV, d6.aV, a3 != null ? a3.b : null, lVar);
        }
        int size = c0190a.aW.size();
        for (int i4 = 0; i4 < size; i4++) {
            com.anythink.expressad.exoplayer.e.a.a.b bVar = c0190a.aW.get(i4);
            if (bVar.aU == com.anythink.expressad.exoplayer.e.a.a.al) {
                a(bVar.aV, lVar, bArr);
            }
        }
    }

    private static void b(com.anythink.expressad.exoplayer.k.s sVar, com.anythink.expressad.exoplayer.e.a.l lVar) {
        a(sVar, 0, lVar);
    }

    private static boolean b(int i2) {
        return i2 == com.anythink.expressad.exoplayer.e.a.a.G || i2 == com.anythink.expressad.exoplayer.e.a.a.I || i2 == com.anythink.expressad.exoplayer.e.a.a.J || i2 == com.anythink.expressad.exoplayer.e.a.a.K || i2 == com.anythink.expressad.exoplayer.e.a.a.L || i2 == com.anythink.expressad.exoplayer.e.a.a.P || i2 == com.anythink.expressad.exoplayer.e.a.a.Q || i2 == com.anythink.expressad.exoplayer.e.a.a.R || i2 == com.anythink.expressad.exoplayer.e.a.a.U;
    }

    private boolean b(com.anythink.expressad.exoplayer.e.f fVar) {
        if (this.J == 0) {
            if (!fVar.a(this.B.a, 0, 8, true)) {
                return false;
            }
            this.J = 8;
            this.B.c(0);
            this.I = this.B.h();
            this.H = this.B.i();
        }
        long j2 = this.I;
        if (j2 == 1) {
            fVar.b(this.B.a, 8, 8);
            this.J += 8;
            this.I = this.B.n();
        } else if (j2 == 0) {
            long d2 = fVar.d();
            if (d2 == -1 && !this.D.isEmpty()) {
                d2 = this.D.peek().aV;
            }
            if (d2 != -1) {
                this.I = (d2 - fVar.c()) + this.J;
            }
        }
        if (this.I < this.J) {
            throw new com.anythink.expressad.exoplayer.t("Atom size less than header length (unsupported).");
        }
        long c2 = fVar.c() - this.J;
        if (this.H == com.anythink.expressad.exoplayer.e.a.a.P) {
            int size = this.w.size();
            for (int i2 = 0; i2 < size; i2++) {
                com.anythink.expressad.exoplayer.e.a.l lVar = this.w.valueAt(i2).b;
                lVar.b = c2;
                lVar.d = c2;
                lVar.c = c2;
            }
        }
        int i3 = this.H;
        if (i3 == com.anythink.expressad.exoplayer.e.a.a.m) {
            this.Q = null;
            this.L = this.I + c2;
            if (!this.Y) {
                this.V.a(new com.anythink.expressad.exoplayer.e.k.b(this.O, c2));
                this.Y = true;
            }
            this.G = 2;
            return true;
        }
        if (i3 == com.anythink.expressad.exoplayer.e.a.a.G || i3 == com.anythink.expressad.exoplayer.e.a.a.I || i3 == com.anythink.expressad.exoplayer.e.a.a.J || i3 == com.anythink.expressad.exoplayer.e.a.a.K || i3 == com.anythink.expressad.exoplayer.e.a.a.L || i3 == com.anythink.expressad.exoplayer.e.a.a.P || i3 == com.anythink.expressad.exoplayer.e.a.a.Q || i3 == com.anythink.expressad.exoplayer.e.a.a.R || i3 == com.anythink.expressad.exoplayer.e.a.a.U) {
            long c3 = (fVar.c() + this.I) - 8;
            this.D.push(new com.anythink.expressad.exoplayer.e.a.a.C0190a(this.H, c3));
            if (this.I == this.J) {
                a(c3);
            } else {
                a();
            }
        } else if (i3 == com.anythink.expressad.exoplayer.e.a.a.X || i3 == com.anythink.expressad.exoplayer.e.a.a.W || i3 == com.anythink.expressad.exoplayer.e.a.a.H || i3 == com.anythink.expressad.exoplayer.e.a.a.F || i3 == com.anythink.expressad.exoplayer.e.a.a.Y || i3 == com.anythink.expressad.exoplayer.e.a.a.B || i3 == com.anythink.expressad.exoplayer.e.a.a.C || i3 == com.anythink.expressad.exoplayer.e.a.a.T || i3 == com.anythink.expressad.exoplayer.e.a.a.D || i3 == com.anythink.expressad.exoplayer.e.a.a.E || i3 == com.anythink.expressad.exoplayer.e.a.a.Z || i3 == com.anythink.expressad.exoplayer.e.a.a.ah || i3 == com.anythink.expressad.exoplayer.e.a.a.ai || i3 == com.anythink.expressad.exoplayer.e.a.a.am || i3 == com.anythink.expressad.exoplayer.e.a.a.al || i3 == com.anythink.expressad.exoplayer.e.a.a.aj || i3 == com.anythink.expressad.exoplayer.e.a.a.ak || i3 == com.anythink.expressad.exoplayer.e.a.a.V || i3 == com.anythink.expressad.exoplayer.e.a.a.S || i3 == com.anythink.expressad.exoplayer.e.a.a.aL) {
            if (this.J != 8) {
                throw new com.anythink.expressad.exoplayer.t("Leaf atom defines extended atom size (unsupported).");
            }
            long j3 = this.I;
            if (j3 > 2147483647L) {
                throw new com.anythink.expressad.exoplayer.t("Leaf atom with length > 2147483647 (unsupported).");
            }
            com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s((int) j3);
            this.K = sVar;
            java.lang.System.arraycopy(this.B.a, 0, sVar.a, 0, 8);
            this.G = 1;
        } else {
            if (this.I > 2147483647L) {
                throw new com.anythink.expressad.exoplayer.t("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.K = null;
            this.G = 1;
        }
        return true;
    }

    private static long c(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(8);
        return com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) == 0 ? sVar.h() : sVar.n();
    }

    private void c(com.anythink.expressad.exoplayer.e.a.a.C0190a c0190a) {
        a(c0190a, this.w, this.f214s, this.C);
        com.anythink.expressad.exoplayer.d.e a2 = this.v != null ? null : a(c0190a.aW);
        if (a2 != null) {
            int size = this.w.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.w.valueAt(i2).a(a2);
            }
        }
        if (this.N != -9223372036854775807L) {
            int size2 = this.w.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.w.valueAt(i3).a(this.N);
            }
            this.N = -9223372036854775807L;
        }
    }

    private void c(com.anythink.expressad.exoplayer.e.f fVar) {
        long n2;
        long n3;
        int i2 = ((int) this.I) - this.J;
        com.anythink.expressad.exoplayer.k.s sVar = this.K;
        if (sVar != null) {
            fVar.b(sVar.a, 8, i2);
            com.anythink.expressad.exoplayer.e.a.a.b bVar = new com.anythink.expressad.exoplayer.e.a.a.b(this.H, this.K);
            long c2 = fVar.c();
            if (this.D.isEmpty()) {
                int i3 = bVar.aU;
                int i4 = 0;
                if (i3 == com.anythink.expressad.exoplayer.e.a.a.F) {
                    com.anythink.expressad.exoplayer.k.s sVar2 = bVar.aV;
                    sVar2.c(8);
                    int a2 = com.anythink.expressad.exoplayer.e.a.a.a(sVar2.i());
                    sVar2.d(4);
                    long h2 = sVar2.h();
                    if (a2 == 0) {
                        n2 = sVar2.h();
                        n3 = sVar2.h();
                    } else {
                        n2 = sVar2.n();
                        n3 = sVar2.n();
                    }
                    long j2 = c2 + n3;
                    long j3 = n2;
                    long a3 = com.anythink.expressad.exoplayer.k.af.a(j3, 1000000L, h2);
                    sVar2.d(2);
                    int e2 = sVar2.e();
                    int[] iArr = new int[e2];
                    long[] jArr = new long[e2];
                    long[] jArr2 = new long[e2];
                    long[] jArr3 = new long[e2];
                    long j4 = a3;
                    while (i4 < e2) {
                        int i5 = sVar2.i();
                        if ((i5 & Integer.MIN_VALUE) != 0) {
                            throw new com.anythink.expressad.exoplayer.t("Unhandled indirect reference");
                        }
                        long h3 = sVar2.h();
                        iArr[i4] = i5 & Integer.MAX_VALUE;
                        jArr[i4] = j2;
                        jArr3[i4] = j4;
                        j3 += h3;
                        long[] jArr4 = jArr3;
                        long[] jArr5 = jArr2;
                        j4 = com.anythink.expressad.exoplayer.k.af.a(j3, 1000000L, h2);
                        jArr5[i4] = j4 - jArr4[i4];
                        sVar2.d(4);
                        j2 += iArr[i4];
                        i4++;
                        jArr2 = jArr5;
                        jArr = jArr;
                        jArr3 = jArr4;
                        e2 = e2;
                    }
                    android.util.Pair create = android.util.Pair.create(java.lang.Long.valueOf(a3), new com.anythink.expressad.exoplayer.e.a(iArr, jArr, jArr2, jArr3));
                    this.P = ((java.lang.Long) create.first).longValue();
                    this.V.a((com.anythink.expressad.exoplayer.e.k) create.second);
                    this.Y = true;
                } else if (i3 == com.anythink.expressad.exoplayer.e.a.a.aL) {
                    com.anythink.expressad.exoplayer.k.s sVar3 = bVar.aV;
                    com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
                    if (mVarArr != null && mVarArr.length != 0) {
                        sVar3.c(12);
                        int a4 = sVar3.a();
                        sVar3.p();
                        sVar3.p();
                        long a5 = com.anythink.expressad.exoplayer.k.af.a(sVar3.h(), 1000000L, sVar3.h());
                        for (com.anythink.expressad.exoplayer.e.m mVar : this.W) {
                            sVar3.c(12);
                            mVar.a(sVar3, a4);
                        }
                        long j5 = this.P;
                        if (j5 != -9223372036854775807L) {
                            long j6 = j5 + a5;
                            com.anythink.expressad.exoplayer.k.ac acVar = this.A;
                            if (acVar != null) {
                                j6 = acVar.b(j6);
                            }
                            com.anythink.expressad.exoplayer.e.m[] mVarArr2 = this.W;
                            int length = mVarArr2.length;
                            while (i4 < length) {
                                mVarArr2[i4].a(j6, 1, a4, 0, null);
                                i4++;
                            }
                        } else {
                            this.E.addLast(new com.anythink.expressad.exoplayer.e.a.e.b(a5, a4));
                            this.M += a4;
                        }
                    }
                }
            } else {
                this.D.peek().a(bVar);
            }
        } else {
            fVar.c(i2);
        }
        a(fVar.c());
    }

    private static long d(com.anythink.expressad.exoplayer.k.s sVar) {
        sVar.c(8);
        return com.anythink.expressad.exoplayer.e.a.a.a(sVar.i()) == 1 ? sVar.n() : sVar.h();
    }

    private void d(com.anythink.expressad.exoplayer.e.f fVar) {
        int size = this.w.size();
        com.anythink.expressad.exoplayer.e.a.e.c cVar = null;
        long j2 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            com.anythink.expressad.exoplayer.e.a.l lVar = this.w.valueAt(i2).b;
            if (lVar.r) {
                long j3 = lVar.d;
                if (j3 < j2) {
                    cVar = this.w.valueAt(i2);
                    j2 = j3;
                }
            }
        }
        if (cVar == null) {
            this.G = 3;
            return;
        }
        int c2 = (int) (j2 - fVar.c());
        if (c2 < 0) {
            throw new com.anythink.expressad.exoplayer.t("Offset to encryption data was negative.");
        }
        fVar.c(c2);
        com.anythink.expressad.exoplayer.e.a.l lVar2 = cVar.b;
        fVar.b(lVar2.q.a, 0, lVar2.p);
        lVar2.q.c(0);
        lVar2.r = false;
    }

    private boolean e(com.anythink.expressad.exoplayer.e.f fVar) {
        int i2;
        com.anythink.expressad.exoplayer.e.m.a aVar;
        int a2;
        int i3 = 1;
        if (this.G == 3) {
            if (this.Q == null) {
                android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray = this.w;
                int size = sparseArray.size();
                long j2 = Long.MAX_VALUE;
                com.anythink.expressad.exoplayer.e.a.e.c cVar = null;
                for (int i4 = 0; i4 < size; i4++) {
                    com.anythink.expressad.exoplayer.e.a.e.c valueAt = sparseArray.valueAt(i4);
                    int i5 = valueAt.g;
                    com.anythink.expressad.exoplayer.e.a.l lVar = valueAt.b;
                    if (i5 != lVar.e) {
                        long j3 = lVar.g[i5];
                        if (j3 < j2) {
                            cVar = valueAt;
                            j2 = j3;
                        }
                    }
                }
                if (cVar == null) {
                    int c2 = (int) (this.L - fVar.c());
                    if (c2 < 0) {
                        throw new com.anythink.expressad.exoplayer.t("Offset to end of mdat was negative.");
                    }
                    fVar.c(c2);
                    a();
                    return false;
                }
                int c3 = (int) (cVar.b.g[cVar.g] - fVar.c());
                if (c3 < 0) {
                    c3 = 0;
                }
                fVar.c(c3);
                this.Q = cVar;
            }
            com.anythink.expressad.exoplayer.e.a.e.c cVar2 = this.Q;
            int[] iArr = cVar2.b.i;
            int i6 = cVar2.e;
            int i7 = iArr[i6];
            this.R = i7;
            if (i6 < cVar2.h) {
                fVar.c(i7);
                com.anythink.expressad.exoplayer.e.a.e.c.a(this.Q);
                if (!this.Q.b()) {
                    this.Q = null;
                }
                this.G = 3;
                return true;
            }
            if (cVar2.c.i == 1) {
                this.R = i7 - 8;
                fVar.c(8);
            }
            int c4 = this.Q.c();
            this.S = c4;
            this.R += c4;
            this.G = 4;
            this.T = 0;
        }
        com.anythink.expressad.exoplayer.e.a.e.c cVar3 = this.Q;
        com.anythink.expressad.exoplayer.e.a.l lVar2 = cVar3.b;
        com.anythink.expressad.exoplayer.e.a.j jVar = cVar3.c;
        com.anythink.expressad.exoplayer.e.m mVar = cVar3.a;
        int i8 = cVar3.e;
        long b2 = lVar2.b(i8) * 1000;
        com.anythink.expressad.exoplayer.k.ac acVar = this.A;
        if (acVar != null) {
            b2 = acVar.b(b2);
        }
        long j4 = b2;
        int i9 = jVar.l;
        if (i9 == 0) {
            while (true) {
                int i10 = this.S;
                int i11 = this.R;
                if (i10 >= i11) {
                    break;
                }
                this.S += mVar.a(fVar, i11 - i10, false);
            }
        } else {
            byte[] bArr = this.y.a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i12 = i9 + 1;
            int i13 = 4 - i9;
            while (this.S < this.R) {
                int i14 = this.T;
                if (i14 == 0) {
                    fVar.b(bArr, i13, i12);
                    this.y.c(0);
                    this.T = this.y.m() - i3;
                    this.x.c(0);
                    mVar.a(this.x, 4);
                    mVar.a(this.y, i3);
                    this.U = this.X.length > 0 && com.anythink.expressad.exoplayer.k.p.a(jVar.h.h, bArr[4]);
                    this.S += 5;
                    this.R += i13;
                } else {
                    if (this.U) {
                        this.z.a(i14);
                        fVar.b(this.z.a, 0, this.T);
                        mVar.a(this.z, this.T);
                        a2 = this.T;
                        com.anythink.expressad.exoplayer.k.s sVar = this.z;
                        int a3 = com.anythink.expressad.exoplayer.k.p.a(sVar.a, sVar.b());
                        this.z.c("video/hevc".equals(jVar.h.h) ? 1 : 0);
                        this.z.b(a3);
                    } else {
                        a2 = mVar.a(fVar, i14, false);
                    }
                    this.S += a2;
                    this.T -= a2;
                    i3 = 1;
                }
            }
        }
        boolean z = lVar2.l[i8];
        if (lVar2.m) {
            int i15 = (z ? 1 : 0) | 1073741824;
            com.anythink.expressad.exoplayer.e.a.k kVar = lVar2.o;
            if (kVar == null) {
                kVar = jVar.a(lVar2.a.a);
            }
            i2 = i15;
            aVar = kVar.c;
        } else {
            i2 = z ? 1 : 0;
            aVar = null;
        }
        mVar.a(j4, i2, this.R, 0, aVar);
        while (!this.E.isEmpty()) {
            com.anythink.expressad.exoplayer.e.a.e.b removeFirst = this.E.removeFirst();
            this.M -= removeFirst.b;
            long j5 = j4 + removeFirst.a;
            com.anythink.expressad.exoplayer.k.ac acVar2 = this.A;
            if (acVar2 != null) {
                j5 = acVar2.b(j5);
            }
            for (com.anythink.expressad.exoplayer.e.m mVar2 : this.W) {
                mVar2.a(j5, 1, removeFirst.b, this.M, null);
            }
        }
        if (!this.Q.b()) {
            this.Q = null;
        }
        this.G = 3;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x05af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x021c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0004 A[SYNTHETIC] */
    @Override // com.anythink.expressad.exoplayer.e.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(com.anythink.expressad.exoplayer.e.f fVar, com.anythink.expressad.exoplayer.e.j jVar) {
        int i2;
        com.anythink.expressad.exoplayer.e.m.a aVar;
        int a2;
        long n2;
        long n3;
        boolean z;
        com.anythink.expressad.exoplayer.e.f fVar2 = fVar;
        while (true) {
            int i3 = this.G;
            int i4 = 1;
            if (i3 == 0) {
                if (this.J == 0) {
                    if (fVar2.a(this.B.a, 0, 8, true)) {
                        this.J = 8;
                        this.B.c(0);
                        this.I = this.B.h();
                        this.H = this.B.i();
                    } else {
                        z = false;
                        if (!z) {
                            return -1;
                        }
                    }
                }
                long j2 = this.I;
                if (j2 == 1) {
                    fVar2.b(this.B.a, 8, 8);
                    this.J += 8;
                    this.I = this.B.n();
                } else if (j2 == 0) {
                    long d2 = fVar.d();
                    if (d2 == -1 && !this.D.isEmpty()) {
                        d2 = this.D.peek().aV;
                    }
                    if (d2 != -1) {
                        this.I = (d2 - fVar.c()) + this.J;
                    }
                }
                if (this.I < this.J) {
                    throw new com.anythink.expressad.exoplayer.t("Atom size less than header length (unsupported).");
                }
                long c2 = fVar.c() - this.J;
                if (this.H == com.anythink.expressad.exoplayer.e.a.a.P) {
                    int size = this.w.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        com.anythink.expressad.exoplayer.e.a.l lVar = this.w.valueAt(i5).b;
                        lVar.b = c2;
                        lVar.d = c2;
                        lVar.c = c2;
                    }
                }
                int i6 = this.H;
                if (i6 == com.anythink.expressad.exoplayer.e.a.a.m) {
                    this.Q = null;
                    this.L = this.I + c2;
                    if (!this.Y) {
                        this.V.a(new com.anythink.expressad.exoplayer.e.k.b(this.O, c2));
                        this.Y = true;
                    }
                    this.G = 2;
                } else if (i6 == com.anythink.expressad.exoplayer.e.a.a.G || i6 == com.anythink.expressad.exoplayer.e.a.a.I || i6 == com.anythink.expressad.exoplayer.e.a.a.J || i6 == com.anythink.expressad.exoplayer.e.a.a.K || i6 == com.anythink.expressad.exoplayer.e.a.a.L || i6 == com.anythink.expressad.exoplayer.e.a.a.P || i6 == com.anythink.expressad.exoplayer.e.a.a.Q || i6 == com.anythink.expressad.exoplayer.e.a.a.R || i6 == com.anythink.expressad.exoplayer.e.a.a.U) {
                    long c3 = (fVar.c() + this.I) - 8;
                    this.D.push(new com.anythink.expressad.exoplayer.e.a.a.C0190a(this.H, c3));
                    if (this.I == this.J) {
                        a(c3);
                    } else {
                        a();
                    }
                } else {
                    if (i6 == com.anythink.expressad.exoplayer.e.a.a.X || i6 == com.anythink.expressad.exoplayer.e.a.a.W || i6 == com.anythink.expressad.exoplayer.e.a.a.H || i6 == com.anythink.expressad.exoplayer.e.a.a.F || i6 == com.anythink.expressad.exoplayer.e.a.a.Y || i6 == com.anythink.expressad.exoplayer.e.a.a.B || i6 == com.anythink.expressad.exoplayer.e.a.a.C || i6 == com.anythink.expressad.exoplayer.e.a.a.T || i6 == com.anythink.expressad.exoplayer.e.a.a.D || i6 == com.anythink.expressad.exoplayer.e.a.a.E || i6 == com.anythink.expressad.exoplayer.e.a.a.Z || i6 == com.anythink.expressad.exoplayer.e.a.a.ah || i6 == com.anythink.expressad.exoplayer.e.a.a.ai || i6 == com.anythink.expressad.exoplayer.e.a.a.am || i6 == com.anythink.expressad.exoplayer.e.a.a.al || i6 == com.anythink.expressad.exoplayer.e.a.a.aj || i6 == com.anythink.expressad.exoplayer.e.a.a.ak || i6 == com.anythink.expressad.exoplayer.e.a.a.V || i6 == com.anythink.expressad.exoplayer.e.a.a.S || i6 == com.anythink.expressad.exoplayer.e.a.a.aL) {
                        if (this.J != 8) {
                            throw new com.anythink.expressad.exoplayer.t("Leaf atom defines extended atom size (unsupported).");
                        }
                        long j3 = this.I;
                        if (j3 > 2147483647L) {
                            throw new com.anythink.expressad.exoplayer.t("Leaf atom with length > 2147483647 (unsupported).");
                        }
                        com.anythink.expressad.exoplayer.k.s sVar = new com.anythink.expressad.exoplayer.k.s((int) j3);
                        this.K = sVar;
                        java.lang.System.arraycopy(this.B.a, 0, sVar.a, 0, 8);
                        this.G = 1;
                    } else {
                        if (this.I > 2147483647L) {
                            throw new com.anythink.expressad.exoplayer.t("Skipping atom with length > 2147483647 (unsupported).");
                        }
                        this.K = null;
                        this.G = 1;
                    }
                    z = true;
                    if (!z) {
                    }
                }
                z = true;
                if (!z) {
                }
            } else if (i3 != 1) {
                long j4 = Long.MAX_VALUE;
                if (i3 != 2) {
                    if (i3 == 3) {
                        if (this.Q == null) {
                            android.util.SparseArray<com.anythink.expressad.exoplayer.e.a.e.c> sparseArray = this.w;
                            int size2 = sparseArray.size();
                            com.anythink.expressad.exoplayer.e.a.e.c cVar = null;
                            for (int i7 = 0; i7 < size2; i7++) {
                                com.anythink.expressad.exoplayer.e.a.e.c valueAt = sparseArray.valueAt(i7);
                                int i8 = valueAt.g;
                                com.anythink.expressad.exoplayer.e.a.l lVar2 = valueAt.b;
                                if (i8 != lVar2.e) {
                                    long j5 = lVar2.g[i8];
                                    if (j5 < j4) {
                                        cVar = valueAt;
                                        j4 = j5;
                                    }
                                }
                            }
                            if (cVar == null) {
                                int c4 = (int) (this.L - fVar.c());
                                if (c4 < 0) {
                                    throw new com.anythink.expressad.exoplayer.t("Offset to end of mdat was negative.");
                                }
                                fVar2.c(c4);
                                a();
                                i4 = 0;
                                if (i4 != 0) {
                                    return 0;
                                }
                            } else {
                                int c5 = (int) (cVar.b.g[cVar.g] - fVar.c());
                                if (c5 < 0) {
                                    c5 = 0;
                                }
                                fVar2.c(c5);
                                this.Q = cVar;
                            }
                        }
                        com.anythink.expressad.exoplayer.e.a.e.c cVar2 = this.Q;
                        int[] iArr = cVar2.b.i;
                        int i9 = cVar2.e;
                        int i10 = iArr[i9];
                        this.R = i10;
                        if (i9 < cVar2.h) {
                            fVar2.c(i10);
                            com.anythink.expressad.exoplayer.e.a.e.c.a(this.Q);
                            if (!this.Q.b()) {
                                this.Q = null;
                            }
                            this.G = 3;
                            if (i4 != 0) {
                            }
                        } else {
                            if (cVar2.c.i == 1) {
                                this.R = i10 - 8;
                                fVar2.c(8);
                            }
                            int c6 = this.Q.c();
                            this.S = c6;
                            this.R += c6;
                            this.G = 4;
                            this.T = 0;
                        }
                    }
                    com.anythink.expressad.exoplayer.e.a.e.c cVar3 = this.Q;
                    com.anythink.expressad.exoplayer.e.a.l lVar3 = cVar3.b;
                    com.anythink.expressad.exoplayer.e.a.j jVar2 = cVar3.c;
                    com.anythink.expressad.exoplayer.e.m mVar = cVar3.a;
                    int i11 = cVar3.e;
                    long b2 = lVar3.b(i11) * 1000;
                    com.anythink.expressad.exoplayer.k.ac acVar = this.A;
                    if (acVar != null) {
                        b2 = acVar.b(b2);
                    }
                    int i12 = jVar2.l;
                    if (i12 == 0) {
                        while (true) {
                            int i13 = this.S;
                            int i14 = this.R;
                            if (i13 >= i14) {
                                break;
                            }
                            this.S += mVar.a(fVar2, i14 - i13, false);
                        }
                    } else {
                        byte[] bArr = this.y.a;
                        bArr[0] = 0;
                        bArr[1] = 0;
                        bArr[2] = 0;
                        int i15 = i12 + 1;
                        int i16 = 4 - i12;
                        while (this.S < this.R) {
                            int i17 = this.T;
                            if (i17 == 0) {
                                fVar2.b(bArr, i16, i15);
                                this.y.c(0);
                                this.T = this.y.m() - i4;
                                this.x.c(0);
                                mVar.a(this.x, 4);
                                mVar.a(this.y, i4);
                                this.U = this.X.length > 0 && com.anythink.expressad.exoplayer.k.p.a(jVar2.h.h, bArr[4]);
                                this.S += 5;
                                this.R += i16;
                                i4 = 1;
                            } else {
                                if (this.U) {
                                    this.z.a(i17);
                                    fVar2.b(this.z.a, 0, this.T);
                                    mVar.a(this.z, this.T);
                                    a2 = this.T;
                                    com.anythink.expressad.exoplayer.k.s sVar2 = this.z;
                                    int a3 = com.anythink.expressad.exoplayer.k.p.a(sVar2.a, sVar2.b());
                                    this.z.c("video/hevc".equals(jVar2.h.h) ? 1 : 0);
                                    this.z.b(a3);
                                } else {
                                    a2 = mVar.a(fVar2, i17, false);
                                }
                                this.S += a2;
                                this.T -= a2;
                                i4 = 1;
                            }
                        }
                    }
                    boolean z2 = lVar3.l[i11];
                    if (lVar3.m) {
                        int i18 = (z2 ? 1 : 0) | 1073741824;
                        com.anythink.expressad.exoplayer.e.a.k kVar = lVar3.o;
                        if (kVar == null) {
                            kVar = jVar2.a(lVar3.a.a);
                        }
                        i2 = i18;
                        aVar = kVar.c;
                    } else {
                        i2 = z2 ? 1 : 0;
                        aVar = null;
                    }
                    mVar.a(b2, i2, this.R, 0, aVar);
                    while (!this.E.isEmpty()) {
                        com.anythink.expressad.exoplayer.e.a.e.b removeFirst = this.E.removeFirst();
                        this.M -= removeFirst.b;
                        long j6 = removeFirst.a + b2;
                        com.anythink.expressad.exoplayer.k.ac acVar2 = this.A;
                        if (acVar2 != null) {
                            j6 = acVar2.b(j6);
                        }
                        for (com.anythink.expressad.exoplayer.e.m mVar2 : this.W) {
                            mVar2.a(j6, 1, removeFirst.b, this.M, null);
                        }
                    }
                    if (!this.Q.b()) {
                        this.Q = null;
                    }
                    this.G = 3;
                    i4 = 1;
                    if (i4 != 0) {
                    }
                } else {
                    int size3 = this.w.size();
                    com.anythink.expressad.exoplayer.e.a.e.c cVar4 = null;
                    for (int i19 = 0; i19 < size3; i19++) {
                        com.anythink.expressad.exoplayer.e.a.l lVar4 = this.w.valueAt(i19).b;
                        if (lVar4.r) {
                            long j7 = lVar4.d;
                            if (j7 < j4) {
                                cVar4 = this.w.valueAt(i19);
                                j4 = j7;
                            }
                        }
                    }
                    if (cVar4 == null) {
                        this.G = 3;
                    } else {
                        int c7 = (int) (j4 - fVar.c());
                        if (c7 < 0) {
                            throw new com.anythink.expressad.exoplayer.t("Offset to encryption data was negative.");
                        }
                        fVar2.c(c7);
                        com.anythink.expressad.exoplayer.e.a.l lVar5 = cVar4.b;
                        fVar2.b(lVar5.q.a, 0, lVar5.p);
                        lVar5.q.c(0);
                        lVar5.r = false;
                    }
                }
            } else {
                int i20 = ((int) this.I) - this.J;
                com.anythink.expressad.exoplayer.k.s sVar3 = this.K;
                if (sVar3 != null) {
                    fVar2.b(sVar3.a, 8, i20);
                    com.anythink.expressad.exoplayer.e.a.a.b bVar = new com.anythink.expressad.exoplayer.e.a.a.b(this.H, this.K);
                    long c8 = fVar.c();
                    if (this.D.isEmpty()) {
                        int i21 = bVar.aU;
                        if (i21 == com.anythink.expressad.exoplayer.e.a.a.F) {
                            com.anythink.expressad.exoplayer.k.s sVar4 = bVar.aV;
                            sVar4.c(8);
                            int a4 = com.anythink.expressad.exoplayer.e.a.a.a(sVar4.i());
                            sVar4.d(4);
                            long h2 = sVar4.h();
                            if (a4 == 0) {
                                n2 = sVar4.h();
                                n3 = sVar4.h();
                            } else {
                                n2 = sVar4.n();
                                n3 = sVar4.n();
                            }
                            long j8 = c8 + n3;
                            long a5 = com.anythink.expressad.exoplayer.k.af.a(n2, 1000000L, h2);
                            sVar4.d(2);
                            int e2 = sVar4.e();
                            int[] iArr2 = new int[e2];
                            long[] jArr = new long[e2];
                            long[] jArr2 = new long[e2];
                            long[] jArr3 = new long[e2];
                            long j9 = a5;
                            int i22 = 0;
                            while (i22 < e2) {
                                int i23 = sVar4.i();
                                if ((i23 & Integer.MIN_VALUE) != 0) {
                                    throw new com.anythink.expressad.exoplayer.t("Unhandled indirect reference");
                                }
                                long h3 = sVar4.h();
                                iArr2[i22] = i23 & Integer.MAX_VALUE;
                                jArr[i22] = j8;
                                jArr3[i22] = j9;
                                long j10 = n2 + h3;
                                int i24 = i22;
                                long[] jArr4 = jArr2;
                                long[] jArr5 = jArr3;
                                j9 = com.anythink.expressad.exoplayer.k.af.a(j10, 1000000L, h2);
                                jArr4[i24] = j9 - jArr5[i24];
                                sVar4.d(4);
                                j8 += r15[i24];
                                jArr = jArr;
                                jArr2 = jArr4;
                                jArr3 = jArr5;
                                i22 = i24 + 1;
                                iArr2 = iArr2;
                                n2 = j10;
                                e2 = e2;
                            }
                            android.util.Pair create = android.util.Pair.create(java.lang.Long.valueOf(a5), new com.anythink.expressad.exoplayer.e.a(iArr2, jArr, jArr2, jArr3));
                            this.P = ((java.lang.Long) create.first).longValue();
                            this.V.a((com.anythink.expressad.exoplayer.e.k) create.second);
                            this.Y = true;
                        } else if (i21 == com.anythink.expressad.exoplayer.e.a.a.aL) {
                            com.anythink.expressad.exoplayer.k.s sVar5 = bVar.aV;
                            com.anythink.expressad.exoplayer.e.m[] mVarArr = this.W;
                            if (mVarArr != null && mVarArr.length != 0) {
                                sVar5.c(12);
                                int a6 = sVar5.a();
                                sVar5.p();
                                sVar5.p();
                                long a7 = com.anythink.expressad.exoplayer.k.af.a(sVar5.h(), 1000000L, sVar5.h());
                                for (com.anythink.expressad.exoplayer.e.m mVar3 : this.W) {
                                    sVar5.c(12);
                                    mVar3.a(sVar5, a6);
                                }
                                long j11 = this.P;
                                if (j11 != -9223372036854775807L) {
                                    long j12 = j11 + a7;
                                    com.anythink.expressad.exoplayer.k.ac acVar3 = this.A;
                                    if (acVar3 != null) {
                                        j12 = acVar3.b(j12);
                                    }
                                    for (com.anythink.expressad.exoplayer.e.m mVar4 : this.W) {
                                        mVar4.a(j12, 1, a6, 0, null);
                                    }
                                } else {
                                    this.E.addLast(new com.anythink.expressad.exoplayer.e.a.e.b(a7, a6));
                                    this.M += a6;
                                }
                            }
                        }
                        fVar2 = fVar;
                    } else {
                        this.D.peek().a(bVar);
                    }
                } else {
                    fVar2.c(i20);
                }
                a(fVar.c());
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(long j2, long j3) {
        int size = this.w.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.w.valueAt(i2).a();
        }
        this.E.clear();
        this.M = 0;
        this.N = j3;
        this.D.clear();
        a();
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void a(com.anythink.expressad.exoplayer.e.g gVar) {
        this.V = gVar;
        com.anythink.expressad.exoplayer.e.a.j jVar = this.t;
        if (jVar != null) {
            com.anythink.expressad.exoplayer.e.a.e.c cVar = new com.anythink.expressad.exoplayer.e.a.e.c(gVar.a(0, jVar.d));
            cVar.a(this.t, new com.anythink.expressad.exoplayer.e.a.c(0, 0, 0, 0));
            this.w.put(0, cVar);
            b();
            this.V.c_();
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final boolean a(com.anythink.expressad.exoplayer.e.f fVar) {
        return com.anythink.expressad.exoplayer.e.a.i.a(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.e.e
    public final void c() {
    }
}
