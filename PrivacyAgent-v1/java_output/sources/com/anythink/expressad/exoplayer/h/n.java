package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
final class n implements com.anythink.expressad.exoplayer.e.g, com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.x.b, com.anythink.expressad.exoplayer.j.t.a<com.anythink.expressad.exoplayer.h.n.a>, com.anythink.expressad.exoplayer.j.t.d {
    private static final long a = 10000;
    private com.anythink.expressad.exoplayer.h.af A;
    private boolean[] C;
    private boolean[] D;
    private boolean[] E;
    private boolean F;
    private long H;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private final android.net.Uri b;
    private final com.anythink.expressad.exoplayer.j.h c;
    private final int d;
    private final com.anythink.expressad.exoplayer.h.t.a e;
    private final com.anythink.expressad.exoplayer.h.n.c f;
    private final com.anythink.expressad.exoplayer.j.b g;

    @androidx.annotation.Nullable
    private final java.lang.String h;
    private final long i;
    private final com.anythink.expressad.exoplayer.h.n.b k;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.h.r.a p;
    private com.anythink.expressad.exoplayer.e.k q;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z;
    private final com.anythink.expressad.exoplayer.j.t j = new com.anythink.expressad.exoplayer.j.t("Loader:ExtractorMediaPeriod");
    private final com.anythink.expressad.exoplayer.k.f l = new com.anythink.expressad.exoplayer.k.f();
    private final java.lang.Runnable m = new com.anythink.expressad.exoplayer.h.n.AnonymousClass1();
    private final java.lang.Runnable n = new com.anythink.expressad.exoplayer.h.n.AnonymousClass2();
    private final android.os.Handler o = new android.os.Handler();

    /* renamed from: s, reason: collision with root package name */
    private int[] f222s = new int[0];
    private com.anythink.expressad.exoplayer.h.x[] r = new com.anythink.expressad.exoplayer.h.x[0];
    private long I = -9223372036854775807L;
    private long G = -1;
    private long B = -9223372036854775807L;

    /* renamed from: com.anythink.expressad.exoplayer.h.n$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.exoplayer.h.n.a(com.anythink.expressad.exoplayer.h.n.this);
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.h.n$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.exoplayer.h.n.this.M) {
                return;
            }
            com.anythink.expressad.exoplayer.h.n.this.p.a((com.anythink.expressad.exoplayer.h.r.a) com.anythink.expressad.exoplayer.h.n.this);
        }
    }

    public final class a implements com.anythink.expressad.exoplayer.j.t.c {
        private final android.net.Uri b;
        private final com.anythink.expressad.exoplayer.j.h c;
        private final com.anythink.expressad.exoplayer.h.n.b d;
        private final com.anythink.expressad.exoplayer.k.f e;
        private volatile boolean g;
        private long i;
        private com.anythink.expressad.exoplayer.j.k j;
        private long l;
        private final com.anythink.expressad.exoplayer.e.j f = new com.anythink.expressad.exoplayer.e.j();
        private boolean h = true;
        private long k = -1;

        public a(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.h.n.b bVar, com.anythink.expressad.exoplayer.k.f fVar) {
            this.b = (android.net.Uri) com.anythink.expressad.exoplayer.k.a.a(uri);
            this.c = (com.anythink.expressad.exoplayer.j.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
            this.d = (com.anythink.expressad.exoplayer.h.n.b) com.anythink.expressad.exoplayer.k.a.a(bVar);
            this.e = fVar;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void a() {
            this.g = true;
        }

        public final void a(long j, long j2) {
            this.f.a = j;
            this.i = j2;
            this.h = true;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void b() {
            int i = 0;
            while (i == 0 && !this.g) {
                com.anythink.expressad.exoplayer.e.b bVar = null;
                try {
                    long j = this.f.a;
                    com.anythink.expressad.exoplayer.j.k kVar = new com.anythink.expressad.exoplayer.j.k(this.b, j, com.anythink.expressad.exoplayer.h.n.this.h);
                    this.j = kVar;
                    long a = this.c.a(kVar);
                    this.k = a;
                    if (a != -1) {
                        this.k = a + j;
                    }
                    com.anythink.expressad.exoplayer.e.b bVar2 = new com.anythink.expressad.exoplayer.e.b(this.c, j, this.k);
                    try {
                        com.anythink.expressad.exoplayer.e.e a2 = this.d.a(bVar2, this.c.a());
                        if (this.h) {
                            a2.a(j, this.i);
                            this.h = false;
                        }
                        while (i == 0 && !this.g) {
                            this.e.c();
                            i = a2.a(bVar2, this.f);
                            if (bVar2.c() > com.anythink.expressad.exoplayer.h.n.this.i + j) {
                                j = bVar2.c();
                                this.e.b();
                                com.anythink.expressad.exoplayer.h.n.this.o.post(com.anythink.expressad.exoplayer.h.n.this.n);
                            }
                        }
                        if (i == 1) {
                            i = 0;
                        } else {
                            this.f.a = bVar2.c();
                            this.l = this.f.a - this.j.e;
                        }
                        com.anythink.expressad.exoplayer.k.af.a(this.c);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (i != 1 && bVar != null) {
                            this.f.a = bVar.c();
                            this.l = this.f.a - this.j.e;
                        }
                        com.anythink.expressad.exoplayer.k.af.a(this.c);
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            }
        }
    }

    public static final class b {
        private final com.anythink.expressad.exoplayer.e.e[] a;
        private final com.anythink.expressad.exoplayer.e.g b;
        private com.anythink.expressad.exoplayer.e.e c;

        public b(com.anythink.expressad.exoplayer.e.e[] eVarArr, com.anythink.expressad.exoplayer.e.g gVar) {
            this.a = eVarArr;
            this.b = gVar;
        }

        public final com.anythink.expressad.exoplayer.e.e a(com.anythink.expressad.exoplayer.e.f fVar, android.net.Uri uri) {
            com.anythink.expressad.exoplayer.e.e eVar = this.c;
            if (eVar != null) {
                return eVar;
            }
            com.anythink.expressad.exoplayer.e.e[] eVarArr = this.a;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.anythink.expressad.exoplayer.e.e eVar2 = eVarArr[i];
                try {
                } catch (java.io.EOFException unused) {
                } catch (java.lang.Throwable th) {
                    fVar.a();
                    throw th;
                }
                if (eVar2.a(fVar)) {
                    this.c = eVar2;
                    fVar.a();
                    break;
                }
                continue;
                fVar.a();
                i++;
            }
            com.anythink.expressad.exoplayer.e.e eVar3 = this.c;
            if (eVar3 != null) {
                eVar3.a(this.b);
                return this.c;
            }
            throw new com.anythink.expressad.exoplayer.h.ag("None of the available extractors (" + com.anythink.expressad.exoplayer.k.af.a(this.a) + ") could read the stream.", uri);
        }

        public final void a() {
            if (this.c != null) {
                this.c = null;
            }
        }
    }

    public interface c {
        void a(long j, boolean z);
    }

    public final class d implements com.anythink.expressad.exoplayer.h.y {
        private final int b;

        public d(int i) {
            this.b = i;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            return com.anythink.expressad.exoplayer.h.n.this.a(this.b, j);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            return com.anythink.expressad.exoplayer.h.n.this.a(this.b, nVar, eVar, z);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return com.anythink.expressad.exoplayer.h.n.this.a(this.b);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            com.anythink.expressad.exoplayer.h.n.this.h();
        }
    }

    public n(android.net.Uri uri, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.e.e[] eVarArr, int i, com.anythink.expressad.exoplayer.h.t.a aVar, com.anythink.expressad.exoplayer.h.n.c cVar, com.anythink.expressad.exoplayer.j.b bVar, @androidx.annotation.Nullable java.lang.String str, int i2) {
        this.b = uri;
        this.c = hVar;
        this.d = i;
        this.e = aVar;
        this.f = cVar;
        this.g = bVar;
        this.h = str;
        this.i = i2;
        this.k = new com.anythink.expressad.exoplayer.h.n.b(eVarArr, this);
        this.v = i == -1 ? 3 : i;
        aVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[RETURN] */
    /* renamed from: a, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a2(com.anythink.expressad.exoplayer.h.n.a aVar, long j, long j2, java.io.IOException iOException) {
        boolean z;
        com.anythink.expressad.exoplayer.e.k kVar;
        boolean z2 = iOException instanceof com.anythink.expressad.exoplayer.h.ag;
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l, iOException, z2);
        a(aVar);
        if (z2) {
            return 3;
        }
        int m = m();
        boolean z3 = m > this.K;
        if (this.G == -1 && ((kVar = this.q) == null || kVar.b() == -9223372036854775807L)) {
            if (this.u && !j()) {
                this.J = true;
                z = false;
                if (z) {
                    return 2;
                }
                return z3 ? 1 : 0;
            }
            this.x = this.u;
            this.H = 0L;
            this.K = 0;
            for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
                xVar.a();
            }
            aVar.a(0L, 0L);
        } else {
            this.K = m;
        }
        z = true;
        if (z) {
        }
    }

    private void a(com.anythink.expressad.exoplayer.h.n.a aVar) {
        if (this.G == -1) {
            this.G = aVar.k;
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.anythink.expressad.exoplayer.h.n.a aVar, long j, long j2) {
        if (this.B == -9223372036854775807L) {
            long n = n();
            long j3 = n == Long.MIN_VALUE ? 0L : n + 10000;
            this.B = j3;
            this.f.a(j3, this.q.a());
        }
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        a(aVar);
        this.L = true;
        this.p.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.anythink.expressad.exoplayer.h.n.a aVar, long j, long j2, boolean z) {
        this.e.b(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, j, j2, aVar.l);
        if (z) {
            return;
        }
        a(aVar);
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            xVar.a();
        }
        if (this.z > 0) {
            this.p.a((com.anythink.expressad.exoplayer.h.r.a) this);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.exoplayer.h.n nVar) {
        if (nVar.M || nVar.u || nVar.q == null || !nVar.t) {
            return;
        }
        for (com.anythink.expressad.exoplayer.h.x xVar : nVar.r) {
            if (xVar.f() == null) {
                return;
            }
        }
        nVar.l.b();
        int length = nVar.r.length;
        com.anythink.expressad.exoplayer.h.ae[] aeVarArr = new com.anythink.expressad.exoplayer.h.ae[length];
        nVar.D = new boolean[length];
        nVar.C = new boolean[length];
        nVar.E = new boolean[length];
        nVar.B = nVar.q.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            com.anythink.expressad.exoplayer.m f = nVar.r[i].f();
            aeVarArr[i] = new com.anythink.expressad.exoplayer.h.ae(f);
            java.lang.String str = f.h;
            if (!com.anythink.expressad.exoplayer.k.o.b(str) && !com.anythink.expressad.exoplayer.k.o.a(str)) {
                z = false;
            }
            nVar.D[i] = z;
            nVar.F = z | nVar.F;
            i++;
        }
        nVar.A = new com.anythink.expressad.exoplayer.h.af(aeVarArr);
        if (nVar.d == -1 && nVar.G == -1 && nVar.q.b() == -9223372036854775807L) {
            nVar.v = 6;
        }
        nVar.u = true;
        nVar.f.a(nVar.B, nVar.q.a());
        nVar.p.a((com.anythink.expressad.exoplayer.h.r) nVar);
    }

    private boolean a(com.anythink.expressad.exoplayer.h.n.a aVar, int i) {
        com.anythink.expressad.exoplayer.e.k kVar;
        if (this.G != -1 || ((kVar = this.q) != null && kVar.b() != -9223372036854775807L)) {
            this.K = i;
            return true;
        }
        if (this.u && !j()) {
            this.J = true;
            return false;
        }
        this.x = this.u;
        this.H = 0L;
        this.K = 0;
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            xVar.a();
        }
        aVar.a(0L, 0L);
        return true;
    }

    private static boolean a(java.io.IOException iOException) {
        return iOException instanceof com.anythink.expressad.exoplayer.h.ag;
    }

    private void b(int i) {
        if (this.E[i]) {
            return;
        }
        com.anythink.expressad.exoplayer.m a2 = this.A.a(i).a(0);
        this.e.a(com.anythink.expressad.exoplayer.k.o.d(a2.h), a2, 0, (java.lang.Object) null, this.H);
        this.E[i] = true;
    }

    private void c(int i) {
        if (this.J && this.D[i] && !this.r[i].c()) {
            this.I = 0L;
            this.J = false;
            this.x = true;
            this.H = 0L;
            this.K = 0;
            for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
                xVar.a();
            }
            this.p.a((com.anythink.expressad.exoplayer.h.r.a) this);
        }
    }

    private boolean d(long j) {
        int i;
        int length = this.r.length;
        while (true) {
            if (i >= length) {
                return true;
            }
            com.anythink.expressad.exoplayer.h.x xVar = this.r[i];
            xVar.i();
            i = ((xVar.a(j, false) != -1) || (!this.D[i] && this.F)) ? i + 1 : 0;
        }
        return false;
    }

    private boolean j() {
        return this.x || o();
    }

    private void k() {
        if (this.M || this.u || this.q == null || !this.t) {
            return;
        }
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            if (xVar.f() == null) {
                return;
            }
        }
        this.l.b();
        int length = this.r.length;
        com.anythink.expressad.exoplayer.h.ae[] aeVarArr = new com.anythink.expressad.exoplayer.h.ae[length];
        this.D = new boolean[length];
        this.C = new boolean[length];
        this.E = new boolean[length];
        this.B = this.q.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            com.anythink.expressad.exoplayer.m f = this.r[i].f();
            aeVarArr[i] = new com.anythink.expressad.exoplayer.h.ae(f);
            java.lang.String str = f.h;
            if (!com.anythink.expressad.exoplayer.k.o.b(str) && !com.anythink.expressad.exoplayer.k.o.a(str)) {
                z = false;
            }
            this.D[i] = z;
            this.F = z | this.F;
            i++;
        }
        this.A = new com.anythink.expressad.exoplayer.h.af(aeVarArr);
        if (this.d == -1 && this.G == -1 && this.q.b() == -9223372036854775807L) {
            this.v = 6;
        }
        this.u = true;
        this.f.a(this.B, this.q.a());
        this.p.a((com.anythink.expressad.exoplayer.h.r) this);
    }

    private void l() {
        com.anythink.expressad.exoplayer.h.n.a aVar = new com.anythink.expressad.exoplayer.h.n.a(this.b, this.c, this.k, this.l);
        if (this.u) {
            com.anythink.expressad.exoplayer.k.a.b(o());
            long j = this.B;
            if (j != -9223372036854775807L && this.I >= j) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            } else {
                aVar.a(this.q.a(this.I).a.c, this.I);
                this.I = -9223372036854775807L;
            }
        }
        this.K = m();
        this.e.a(aVar.j, 1, -1, null, 0, null, aVar.i, this.B, this.j.a(aVar, this, this.v));
    }

    private int m() {
        int i = 0;
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            i += xVar.b();
        }
        return i;
    }

    private long n() {
        long j = Long.MIN_VALUE;
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            j = java.lang.Math.max(j, xVar.g());
        }
        return j;
    }

    private boolean o() {
        return this.I != -9223372036854775807L;
    }

    public final int a(int i, long j) {
        int i2 = 0;
        if (j()) {
            return 0;
        }
        com.anythink.expressad.exoplayer.h.x xVar = this.r[i];
        if (!this.L || j <= xVar.g()) {
            int a2 = xVar.a(j, true);
            if (a2 != -1) {
                i2 = a2;
            }
        } else {
            i2 = xVar.k();
        }
        if (i2 > 0) {
            b(i);
        } else {
            c(i);
        }
        return i2;
    }

    public final int a(int i, com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
        if (j()) {
            return -3;
        }
        int a2 = this.r[i].a(nVar, eVar, z, this.L, this.H);
        if (a2 == -4) {
            b(i);
        } else if (a2 == -3) {
            c(i);
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
    @Override // com.anythink.expressad.exoplayer.j.t.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ int a(com.anythink.expressad.exoplayer.h.n.a aVar, long j, long j2, java.io.IOException iOException) {
        boolean z;
        com.anythink.expressad.exoplayer.e.k kVar;
        com.anythink.expressad.exoplayer.h.n.a aVar2 = aVar;
        boolean z2 = iOException instanceof com.anythink.expressad.exoplayer.h.ag;
        this.e.a(aVar2.j, 1, -1, null, 0, null, aVar2.i, this.B, j, j2, aVar2.l, iOException, z2);
        a(aVar2);
        if (z2) {
            return 3;
        }
        int m = m();
        boolean z3 = m > this.K;
        if (this.G == -1 && ((kVar = this.q) == null || kVar.b() == -9223372036854775807L)) {
            if (this.u && !j()) {
                this.J = true;
                z = false;
                if (z) {
                    return 2;
                }
                return z3 ? 1 : 0;
            }
            this.x = this.u;
            this.H = 0L;
            this.K = 0;
            for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
                xVar.a();
            }
            aVar2.a(0L, 0L);
        } else {
            this.K = m;
        }
        z = true;
        if (z) {
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        if (!this.q.a()) {
            return 0L;
        }
        com.anythink.expressad.exoplayer.e.k.a a2 = this.q.a(j);
        return com.anythink.expressad.exoplayer.k.af.a(j, acVar, a2.a.b, a2.b.b);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, com.anythink.expressad.exoplayer.h.y[] yVarArr, boolean[] zArr2, long j) {
        com.anythink.expressad.exoplayer.i.f fVar;
        com.anythink.expressad.exoplayer.k.a.b(this.u);
        int i = this.z;
        int i2 = 0;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            com.anythink.expressad.exoplayer.h.y yVar = yVarArr[i3];
            if (yVar != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((com.anythink.expressad.exoplayer.h.n.d) yVar).b;
                com.anythink.expressad.exoplayer.k.a.b(this.C[i4]);
                this.z--;
                this.C[i4] = false;
                yVarArr[i3] = null;
            }
        }
        boolean z = !this.w ? j == 0 : i != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (yVarArr[i5] == null && (fVar = fVarArr[i5]) != null) {
                com.anythink.expressad.exoplayer.k.a.b(fVar.g() == 1);
                com.anythink.expressad.exoplayer.k.a.b(fVar.b(0) == 0);
                int a2 = this.A.a(fVar.f());
                com.anythink.expressad.exoplayer.k.a.b(!this.C[a2]);
                this.z++;
                this.C[a2] = true;
                yVarArr[i5] = new com.anythink.expressad.exoplayer.h.n.d(a2);
                zArr2[i5] = true;
                if (!z) {
                    com.anythink.expressad.exoplayer.h.x xVar = this.r[a2];
                    xVar.i();
                    z = xVar.a(j, true) == -1 && xVar.e() != 0;
                }
            }
        }
        if (this.z == 0) {
            this.J = false;
            this.x = false;
            if (this.j.a()) {
                com.anythink.expressad.exoplayer.h.x[] xVarArr = this.r;
                int length = xVarArr.length;
                while (i2 < length) {
                    xVarArr[i2].j();
                    i2++;
                }
                this.j.b();
            } else {
                com.anythink.expressad.exoplayer.h.x[] xVarArr2 = this.r;
                int length2 = xVarArr2.length;
                while (i2 < length2) {
                    xVarArr2[i2].a();
                    i2++;
                }
            }
        } else if (z) {
            j = b(j);
            while (i2 < yVarArr.length) {
                if (yVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.w = true;
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final com.anythink.expressad.exoplayer.e.m a(int i, int i2) {
        int length = this.r.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f222s[i3] == i) {
                return this.r[i3];
            }
        }
        com.anythink.expressad.exoplayer.h.x xVar = new com.anythink.expressad.exoplayer.h.x(this.g);
        xVar.a(this);
        int i4 = length + 1;
        int[] copyOf = java.util.Arrays.copyOf(this.f222s, i4);
        this.f222s = copyOf;
        copyOf[length] = i;
        com.anythink.expressad.exoplayer.h.x[] xVarArr = (com.anythink.expressad.exoplayer.h.x[]) java.util.Arrays.copyOf(this.r, i4);
        this.r = xVarArr;
        xVarArr[length] = xVar;
        return xVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        h();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        int length = this.r.length;
        for (int i = 0; i < length; i++) {
            this.r[i].a(j, z, this.C[i]);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void a(com.anythink.expressad.exoplayer.e.k kVar) {
        this.q = kVar;
        this.o.post(this.m);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(com.anythink.expressad.exoplayer.h.r.a aVar, long j) {
        this.p = aVar;
        this.l.a();
        l();
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.n.a aVar, long j, long j2) {
        com.anythink.expressad.exoplayer.h.n.a aVar2 = aVar;
        if (this.B == -9223372036854775807L) {
            long n = n();
            long j3 = n == Long.MIN_VALUE ? 0L : n + 10000;
            this.B = j3;
            this.f.a(j3, this.q.a());
        }
        this.e.a(aVar2.j, 1, -1, null, 0, null, aVar2.i, this.B, j, j2, aVar2.l);
        a(aVar2);
        this.L = true;
        this.p.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.n.a aVar, long j, long j2, boolean z) {
        com.anythink.expressad.exoplayer.h.n.a aVar2 = aVar;
        this.e.b(aVar2.j, 1, -1, null, 0, null, aVar2.i, this.B, j, j2, aVar2.l);
        if (z) {
            return;
        }
        a(aVar2);
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            xVar.a();
        }
        if (this.z > 0) {
            this.p.a((com.anythink.expressad.exoplayer.h.r.a) this);
        }
    }

    public final boolean a(int i) {
        if (j()) {
            return false;
        }
        return this.L || this.r[i].c();
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        if (!this.q.a()) {
            j = 0;
        }
        this.H = j;
        this.x = false;
        if (!o() && d(j)) {
            return j;
        }
        this.J = false;
        this.I = j;
        this.L = false;
        if (this.j.a()) {
            this.j.b();
        } else {
            for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
                xVar.a();
            }
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final com.anythink.expressad.exoplayer.h.af b() {
        return this.A;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (!this.y) {
            this.e.c();
            this.y = true;
        }
        if (!this.x) {
            return -9223372036854775807L;
        }
        if (!this.L && m() <= this.K) {
            return -9223372036854775807L;
        }
        this.x = false;
        return this.H;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.L || this.J) {
            return false;
        }
        if (this.u && this.z == 0) {
            return false;
        }
        boolean a2 = this.l.a();
        if (this.j.a()) {
            return a2;
        }
        l();
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void c_() {
        this.t = true;
        this.o.post(this.m);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long n;
        if (this.L) {
            return Long.MIN_VALUE;
        }
        if (o()) {
            return this.I;
        }
        if (this.F) {
            int length = this.r.length;
            n = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.D[i]) {
                    n = java.lang.Math.min(n, this.r[i].g());
                }
            }
        } else {
            n = n();
        }
        return n == Long.MIN_VALUE ? this.H : n;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        if (this.z == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public final void f() {
        if (this.u) {
            for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
                xVar.j();
            }
        }
        this.j.a(this);
        this.o.removeCallbacksAndMessages(null);
        this.p = null;
        this.M = true;
        this.e.b();
    }

    @Override // com.anythink.expressad.exoplayer.j.t.d
    public final void g() {
        for (com.anythink.expressad.exoplayer.h.x xVar : this.r) {
            xVar.a();
        }
        this.k.a();
    }

    public final void h() {
        this.j.a(this.v);
    }

    @Override // com.anythink.expressad.exoplayer.h.x.b
    public final void i() {
        this.o.post(this.m);
    }
}
