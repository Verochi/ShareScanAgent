package com.anythink.expressad.exoplayer.h.b;

/* loaded from: classes12.dex */
public final class f<T extends com.anythink.expressad.exoplayer.h.b.g> implements com.anythink.expressad.exoplayer.h.y, com.anythink.expressad.exoplayer.h.z, com.anythink.expressad.exoplayer.j.t.a<com.anythink.expressad.exoplayer.h.b.c>, com.anythink.expressad.exoplayer.j.t.d {
    private static final java.lang.String d = "ChunkSampleStream";
    public final int a;
    long b;
    boolean c;
    private final int[] e;
    private final com.anythink.expressad.exoplayer.m[] f;
    private final boolean[] g;
    private final T h;
    private final com.anythink.expressad.exoplayer.h.z.a<com.anythink.expressad.exoplayer.h.b.f<T>> i;
    private final com.anythink.expressad.exoplayer.h.t.a j;
    private final int k;
    private final com.anythink.expressad.exoplayer.j.t l = new com.anythink.expressad.exoplayer.j.t("Loader:ChunkSampleStream");
    private final com.anythink.expressad.exoplayer.h.b.e m = new com.anythink.expressad.exoplayer.h.b.e();
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.h.b.a> n;
    private final java.util.List<com.anythink.expressad.exoplayer.h.b.a> o;
    private final com.anythink.expressad.exoplayer.h.x p;
    private final com.anythink.expressad.exoplayer.h.x[] q;
    private final com.anythink.expressad.exoplayer.h.b.b r;

    /* renamed from: s, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.m f220s;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.h.b.f.b<T> t;
    private long u;
    private long v;

    public final class a implements com.anythink.expressad.exoplayer.h.y {
        public final com.anythink.expressad.exoplayer.h.b.f<T> a;
        private final com.anythink.expressad.exoplayer.h.x c;
        private final int d;
        private boolean e;

        public a(com.anythink.expressad.exoplayer.h.b.f<T> fVar, com.anythink.expressad.exoplayer.h.x xVar, int i) {
            this.a = fVar;
            this.c = xVar;
            this.d = i;
        }

        private void a() {
            com.anythink.expressad.exoplayer.k.a.b(com.anythink.expressad.exoplayer.h.b.f.this.g[this.d]);
            com.anythink.expressad.exoplayer.h.b.f.this.g[this.d] = false;
        }

        private void d() {
            if (this.e) {
                return;
            }
            com.anythink.expressad.exoplayer.h.b.f.this.j.a(com.anythink.expressad.exoplayer.h.b.f.this.e[this.d], com.anythink.expressad.exoplayer.h.b.f.this.f[this.d], 0, (java.lang.Object) null, com.anythink.expressad.exoplayer.h.b.f.this.v);
            this.e = true;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            int a;
            if (!com.anythink.expressad.exoplayer.h.b.f.this.c || j <= this.c.g()) {
                a = this.c.a(j, true);
                if (a == -1) {
                    a = 0;
                }
            } else {
                a = this.c.k();
            }
            if (a > 0) {
                d();
            }
            return a;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            if (com.anythink.expressad.exoplayer.h.b.f.this.a()) {
                return -3;
            }
            com.anythink.expressad.exoplayer.h.x xVar = this.c;
            com.anythink.expressad.exoplayer.h.b.f fVar = com.anythink.expressad.exoplayer.h.b.f.this;
            int a = xVar.a(nVar, eVar, z, fVar.c, fVar.b);
            if (a == -4) {
                d();
            }
            return a;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            com.anythink.expressad.exoplayer.h.b.f fVar = com.anythink.expressad.exoplayer.h.b.f.this;
            if (fVar.c) {
                return true;
            }
            return !fVar.a() && this.c.c();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
        }
    }

    public interface b<T extends com.anythink.expressad.exoplayer.h.b.g> {
        void a();
    }

    private f(int i, int[] iArr, com.anythink.expressad.exoplayer.m[] mVarArr, T t, com.anythink.expressad.exoplayer.h.z.a<com.anythink.expressad.exoplayer.h.b.f<T>> aVar, com.anythink.expressad.exoplayer.j.b bVar, long j, int i2, com.anythink.expressad.exoplayer.h.t.a aVar2) {
        this.a = i;
        this.e = iArr;
        this.f = mVarArr;
        this.h = t;
        this.i = aVar;
        this.j = aVar2;
        this.k = i2;
        java.util.ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = new java.util.ArrayList<>();
        this.n = arrayList;
        this.o = java.util.Collections.unmodifiableList(arrayList);
        int i3 = 0;
        int length = iArr == null ? 0 : iArr.length;
        this.q = new com.anythink.expressad.exoplayer.h.x[length];
        this.g = new boolean[length];
        int i4 = length + 1;
        int[] iArr2 = new int[i4];
        com.anythink.expressad.exoplayer.h.x[] xVarArr = new com.anythink.expressad.exoplayer.h.x[i4];
        com.anythink.expressad.exoplayer.h.x xVar = new com.anythink.expressad.exoplayer.h.x(bVar);
        this.p = xVar;
        iArr2[0] = i;
        xVarArr[0] = xVar;
        while (i3 < length) {
            com.anythink.expressad.exoplayer.h.x xVar2 = new com.anythink.expressad.exoplayer.h.x(bVar);
            this.q[i3] = xVar2;
            int i5 = i3 + 1;
            xVarArr[i5] = xVar2;
            iArr2[i5] = iArr[i3];
            i3 = i5;
        }
        this.r = new com.anythink.expressad.exoplayer.h.b.b(iArr2, xVarArr);
        this.u = j;
        this.v = j;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private int a2(com.anythink.expressad.exoplayer.h.b.c cVar, long j, long j2, java.io.IOException iOException) {
        boolean z;
        long d2 = cVar.d();
        boolean z2 = cVar instanceof com.anythink.expressad.exoplayer.h.b.a;
        int size = this.n.size() - 1;
        boolean z3 = (d2 != 0 && z2 && a(size)) ? false : true;
        if (this.h.f() && z3) {
            if (z2) {
                com.anythink.expressad.exoplayer.k.a.b(d(size) == cVar);
                if (this.n.isEmpty()) {
                    this.u = this.v;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.j.a(cVar.b, cVar.c, this.a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, j, j2, d2, iOException, z);
        if (!z) {
            return 0;
        }
        this.i.a(this);
        return 2;
    }

    private com.anythink.expressad.exoplayer.h.b.f<T>.a a(long j, int i) {
        for (int i2 = 0; i2 < this.q.length; i2++) {
            if (this.e[i2] == i) {
                com.anythink.expressad.exoplayer.k.a.b(!this.g[i2]);
                this.g[i2] = true;
                this.q[i2].i();
                this.q[i2].a(j, true);
                return new com.anythink.expressad.exoplayer.h.b.f.a(this, this.q[i2], i2);
            }
        }
        throw new java.lang.IllegalStateException();
    }

    private void a(int i, int i2) {
        int b2 = b(i - i2, 0);
        int b3 = i2 == 1 ? b2 : b(i - 1, b2);
        while (b2 <= b3) {
            c(b2);
            b2++;
        }
    }

    private void a(long j, boolean z) {
        int d2 = this.p.d();
        this.p.a(j, z, true);
        int d3 = this.p.d();
        if (d3 > d2) {
            long h = this.p.h();
            int i = 0;
            while (true) {
                com.anythink.expressad.exoplayer.h.x[] xVarArr = this.q;
                if (i >= xVarArr.length) {
                    break;
                }
                xVarArr[i].a(h, z, this.g[i]);
                i++;
            }
            int b2 = b(d3, 0);
            if (b2 > 0) {
                com.anythink.expressad.exoplayer.k.af.a((java.util.List) this.n, 0, b2);
            }
        }
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.anythink.expressad.exoplayer.h.b.c cVar, long j, long j2) {
        this.j.a(cVar.b, cVar.c, this.a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, j, j2, cVar.d());
        this.i.a(this);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.anythink.expressad.exoplayer.h.b.c cVar, long j, long j2, boolean z) {
        this.j.b(cVar.b, cVar.c, this.a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, j, j2, cVar.d());
        if (z) {
            return;
        }
        this.p.a();
        for (com.anythink.expressad.exoplayer.h.x xVar : this.q) {
            xVar.a();
        }
        this.i.a(this);
    }

    private void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.b.f.b<T> bVar) {
        this.t = bVar;
        this.p.j();
        for (com.anythink.expressad.exoplayer.h.x xVar : this.q) {
            xVar.j();
        }
        this.l.a(this);
    }

    private boolean a(int i) {
        int e;
        com.anythink.expressad.exoplayer.h.b.a aVar = this.n.get(i);
        if (this.p.e() > aVar.a(0)) {
            return true;
        }
        int i2 = 0;
        do {
            com.anythink.expressad.exoplayer.h.x[] xVarArr = this.q;
            if (i2 >= xVarArr.length) {
                return false;
            }
            e = xVarArr[i2].e();
            i2++;
        } while (e <= aVar.a(i2));
        return true;
    }

    private static boolean a(com.anythink.expressad.exoplayer.h.b.c cVar) {
        return cVar instanceof com.anythink.expressad.exoplayer.h.b.a;
    }

    private int b(int i, int i2) {
        do {
            i2++;
            if (i2 >= this.n.size()) {
                return this.n.size() - 1;
            }
        } while (this.n.get(i2).a(0) <= i);
        return i2 - 1;
    }

    private void b(int i) {
        int b2 = b(i, 0);
        if (b2 > 0) {
            com.anythink.expressad.exoplayer.k.af.a((java.util.List) this.n, 0, b2);
        }
    }

    private void b(long j) {
        com.anythink.expressad.exoplayer.h.b.a aVar;
        boolean z;
        this.v = j;
        this.p.i();
        if (a()) {
            z = false;
        } else {
            for (int i = 0; i < this.n.size(); i++) {
                aVar = this.n.get(i);
                long j2 = aVar.g;
                if (j2 == j && aVar.a == -9223372036854775807L) {
                    break;
                } else {
                    if (j2 > j) {
                        break;
                    }
                }
            }
            aVar = null;
            if (aVar != null) {
                z = this.p.b(aVar.a(0));
                this.b = Long.MIN_VALUE;
            } else {
                z = this.p.a(j, (j > e() ? 1 : (j == e() ? 0 : -1)) < 0) != -1;
                this.b = this.v;
            }
        }
        if (z) {
            for (com.anythink.expressad.exoplayer.h.x xVar : this.q) {
                xVar.i();
                xVar.a(j, false);
            }
            return;
        }
        this.u = j;
        this.c = false;
        this.n.clear();
        if (this.l.a()) {
            this.l.b();
            return;
        }
        this.p.a();
        for (com.anythink.expressad.exoplayer.h.x xVar2 : this.q) {
            xVar2.a();
        }
    }

    private void c(int i) {
        com.anythink.expressad.exoplayer.h.b.a aVar = this.n.get(i);
        com.anythink.expressad.exoplayer.m mVar = aVar.d;
        if (!mVar.equals(this.f220s)) {
            this.j.a(this.a, mVar, aVar.e, aVar.f, aVar.g);
        }
        this.f220s = mVar;
    }

    private com.anythink.expressad.exoplayer.h.b.a d(int i) {
        com.anythink.expressad.exoplayer.h.b.a aVar = this.n.get(i);
        java.util.ArrayList<com.anythink.expressad.exoplayer.h.b.a> arrayList = this.n;
        com.anythink.expressad.exoplayer.k.af.a((java.util.List) arrayList, i, arrayList.size());
        int i2 = 0;
        this.p.a(aVar.a(0));
        while (true) {
            com.anythink.expressad.exoplayer.h.x[] xVarArr = this.q;
            if (i2 >= xVarArr.length) {
                return aVar;
            }
            com.anythink.expressad.exoplayer.h.x xVar = xVarArr[i2];
            i2++;
            xVar.a(aVar.a(i2));
        }
    }

    private T f() {
        return this.h;
    }

    private long h() {
        return this.h.a();
    }

    private void i() {
        this.t = null;
        this.p.j();
        for (com.anythink.expressad.exoplayer.h.x xVar : this.q) {
            xVar.j();
        }
        this.l.a(this);
    }

    private com.anythink.expressad.exoplayer.h.b.a j() {
        return this.n.get(r0.size() - 1);
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final int a(long j) {
        int i = 0;
        if (a()) {
            return 0;
        }
        if (!this.c || j <= this.p.g()) {
            int a2 = this.p.a(j, true);
            if (a2 != -1) {
                i = a2;
            }
        } else {
            i = this.p.k();
        }
        if (i > 0) {
            a(this.p.e(), i);
        }
        return i;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ int a(com.anythink.expressad.exoplayer.h.b.c cVar, long j, long j2, java.io.IOException iOException) {
        boolean z;
        com.anythink.expressad.exoplayer.h.b.c cVar2 = cVar;
        long d2 = cVar2.d();
        boolean z2 = cVar2 instanceof com.anythink.expressad.exoplayer.h.b.a;
        int size = this.n.size() - 1;
        boolean z3 = (d2 != 0 && z2 && a(size)) ? false : true;
        if (this.h.f() && z3) {
            if (z2) {
                com.anythink.expressad.exoplayer.k.a.b(d(size) == cVar2);
                if (this.n.isEmpty()) {
                    this.u = this.v;
                }
            }
            z = true;
        } else {
            z = false;
        }
        this.j.a(cVar2.b, cVar2.c, this.a, cVar2.d, cVar2.e, cVar2.f, cVar2.g, cVar2.h, j, j2, d2, iOException, z);
        if (!z) {
            return 0;
        }
        this.i.a(this);
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
        if (a()) {
            return -3;
        }
        int a2 = this.p.a(nVar, eVar, z, this.c, this.b);
        if (a2 == -4) {
            a(this.p.e(), 1);
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.b.c cVar, long j, long j2) {
        com.anythink.expressad.exoplayer.h.b.c cVar2 = cVar;
        this.j.a(cVar2.b, cVar2.c, this.a, cVar2.d, cVar2.e, cVar2.f, cVar2.g, cVar2.h, j, j2, cVar2.d());
        this.i.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.b.c cVar, long j, long j2, boolean z) {
        com.anythink.expressad.exoplayer.h.b.c cVar2 = cVar;
        this.j.b(cVar2.b, cVar2.c, this.a, cVar2.d, cVar2.e, cVar2.f, cVar2.g, cVar2.h, j, j2, cVar2.d());
        if (z) {
            return;
        }
        this.p.a();
        for (com.anythink.expressad.exoplayer.h.x xVar : this.q) {
            xVar.a();
        }
        this.i.a(this);
    }

    public final boolean a() {
        return this.u != -9223372036854775807L;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        int size;
        int c;
        if (this.l.a() || a() || (size = this.n.size()) <= (c = this.h.c())) {
            return;
        }
        while (true) {
            if (c >= size) {
                c = size;
                break;
            } else if (!a(c)) {
                break;
            } else {
                c++;
            }
        }
        if (c == size) {
            return;
        }
        long j2 = j().h;
        com.anythink.expressad.exoplayer.h.b.a d2 = d(c);
        if (this.n.isEmpty()) {
            this.u = this.v;
        }
        this.c = false;
        this.j.a(this.a, d2.g, j2);
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final boolean b() {
        if (this.c) {
            return true;
        }
        return !a() && this.p.c();
    }

    @Override // com.anythink.expressad.exoplayer.h.y
    public final void c() {
        this.l.c();
        this.l.a();
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.c || this.l.a()) {
            return false;
        }
        boolean a2 = a();
        if (!a2) {
            j();
        }
        com.anythink.expressad.exoplayer.h.b.e eVar = this.m;
        boolean z = eVar.b;
        com.anythink.expressad.exoplayer.h.b.c cVar = eVar.a;
        eVar.a = null;
        eVar.b = false;
        if (z) {
            this.u = -9223372036854775807L;
            this.c = true;
            return true;
        }
        if (cVar == null) {
            return false;
        }
        if (cVar instanceof com.anythink.expressad.exoplayer.h.b.a) {
            com.anythink.expressad.exoplayer.h.b.a aVar = (com.anythink.expressad.exoplayer.h.b.a) cVar;
            if (a2) {
                long j2 = aVar.g;
                long j3 = this.u;
                if (j2 == j3) {
                    j3 = Long.MIN_VALUE;
                }
                this.b = j3;
                this.u = -9223372036854775807L;
            }
            aVar.a(this.r);
            this.n.add(aVar);
        }
        this.j.a(cVar.b, cVar.c, this.a, cVar.d, cVar.e, cVar.f, cVar.g, cVar.h, this.l.a(cVar, this, this.k));
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long d() {
        if (this.c) {
            return Long.MIN_VALUE;
        }
        if (a()) {
            return this.u;
        }
        long j = this.v;
        com.anythink.expressad.exoplayer.h.b.a j2 = j();
        if (!j2.f()) {
            if (this.n.size() > 1) {
                j2 = this.n.get(r2.size() - 2);
            } else {
                j2 = null;
            }
        }
        if (j2 != null) {
            j = java.lang.Math.max(j, j2.h);
        }
        return java.lang.Math.max(j, this.p.g());
    }

    @Override // com.anythink.expressad.exoplayer.h.z
    public final long e() {
        if (a()) {
            return this.u;
        }
        if (this.c) {
            return Long.MIN_VALUE;
        }
        return j().h;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.d
    public final void g() {
        this.p.a();
        for (com.anythink.expressad.exoplayer.h.x xVar : this.q) {
            xVar.a();
        }
    }
}
