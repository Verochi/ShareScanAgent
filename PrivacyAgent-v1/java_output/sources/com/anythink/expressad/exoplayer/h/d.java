package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public final class d implements com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.r.a {
    public final com.anythink.expressad.exoplayer.h.r a;
    long b;
    long c;
    private com.anythink.expressad.exoplayer.h.r.a d;
    private com.anythink.expressad.exoplayer.h.d.a[] e = new com.anythink.expressad.exoplayer.h.d.a[0];
    private long f;

    public final class a implements com.anythink.expressad.exoplayer.h.y {
        public final com.anythink.expressad.exoplayer.h.y a;
        private boolean c;

        public a(com.anythink.expressad.exoplayer.h.y yVar) {
            this.a = yVar;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            if (com.anythink.expressad.exoplayer.h.d.this.f()) {
                return -3;
            }
            return this.a.a(j);
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            if (com.anythink.expressad.exoplayer.h.d.this.f()) {
                return -3;
            }
            if (this.c) {
                eVar.a(4);
                return -4;
            }
            int a = this.a.a(nVar, eVar, z);
            if (a == -5) {
                com.anythink.expressad.exoplayer.m mVar = nVar.a;
                int i = mVar.x;
                if (i != 0 || mVar.y != 0) {
                    com.anythink.expressad.exoplayer.h.d dVar = com.anythink.expressad.exoplayer.h.d.this;
                    if (dVar.b != 0) {
                        i = 0;
                    }
                    nVar.a = mVar.a(i, dVar.c == Long.MIN_VALUE ? mVar.y : 0);
                }
                return -5;
            }
            com.anythink.expressad.exoplayer.h.d dVar2 = com.anythink.expressad.exoplayer.h.d.this;
            long j = dVar2.c;
            if (j == Long.MIN_VALUE || ((a != -4 || eVar.f < j) && !(a == -3 && dVar2.d() == Long.MIN_VALUE))) {
                return a;
            }
            eVar.a();
            eVar.a(4);
            this.c = true;
            return -4;
        }

        public final void a() {
            this.c = false;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return !com.anythink.expressad.exoplayer.h.d.this.f() && this.a.b();
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            this.a.c();
        }
    }

    public d(com.anythink.expressad.exoplayer.h.r rVar, boolean z, long j, long j2) {
        this.a = rVar;
        this.f = z ? j : -9223372036854775807L;
        this.b = j;
        this.c = j2;
    }

    private static boolean a(long j, com.anythink.expressad.exoplayer.i.f[] fVarArr) {
        if (j != 0) {
            for (com.anythink.expressad.exoplayer.i.f fVar : fVarArr) {
                if (fVar != null && !com.anythink.expressad.exoplayer.k.o.a(fVar.h().h)) {
                    return true;
                }
            }
        }
        return false;
    }

    private com.anythink.expressad.exoplayer.ac b(long j, com.anythink.expressad.exoplayer.ac acVar) {
        long a2 = com.anythink.expressad.exoplayer.k.af.a(acVar.f, j - this.b);
        long j2 = acVar.g;
        long j3 = this.c;
        long a3 = com.anythink.expressad.exoplayer.k.af.a(j2, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (a2 == acVar.f && a3 == acVar.g) ? acVar : new com.anythink.expressad.exoplayer.ac(a2, a3);
    }

    private void g() {
        this.d.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        long j2 = this.b;
        if (j == j2) {
            return j2;
        }
        long a2 = com.anythink.expressad.exoplayer.k.af.a(acVar.f, j - j2);
        long j3 = acVar.g;
        long j4 = this.c;
        long a3 = com.anythink.expressad.exoplayer.k.af.a(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j);
        if (a2 != acVar.f || a3 != acVar.g) {
            acVar = new com.anythink.expressad.exoplayer.ac(a2, a3);
        }
        return this.a.a(j, acVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
    
        if (r1 > r5) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    @Override // com.anythink.expressad.exoplayer.h.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, com.anythink.expressad.exoplayer.h.y[] yVarArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        this.e = new com.anythink.expressad.exoplayer.h.d.a[yVarArr.length];
        com.anythink.expressad.exoplayer.h.y[] yVarArr2 = new com.anythink.expressad.exoplayer.h.y[yVarArr.length];
        int i = 0;
        while (true) {
            com.anythink.expressad.exoplayer.h.y yVar = null;
            if (i >= yVarArr.length) {
                break;
            }
            com.anythink.expressad.exoplayer.h.d.a[] aVarArr = this.e;
            com.anythink.expressad.exoplayer.h.d.a aVar = (com.anythink.expressad.exoplayer.h.d.a) yVarArr[i];
            aVarArr[i] = aVar;
            if (aVar != null) {
                yVar = aVar.a;
            }
            yVarArr2[i] = yVar;
            i++;
        }
        long a2 = this.a.a(fVarArr, zArr, yVarArr2, zArr2, j);
        boolean z2 = true;
        if (f()) {
            long j3 = this.b;
            if (j == j3) {
                if (j3 != 0) {
                    for (com.anythink.expressad.exoplayer.i.f fVar : fVarArr) {
                        if (fVar != null && !com.anythink.expressad.exoplayer.k.o.a(fVar.h().h)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    j2 = a2;
                    this.f = j2;
                    if (a2 != j) {
                        if (a2 >= this.b) {
                            long j4 = this.c;
                            if (j4 != Long.MIN_VALUE) {
                            }
                        }
                        z2 = false;
                    }
                    com.anythink.expressad.exoplayer.k.a.b(z2);
                    for (int i2 = 0; i2 < yVarArr.length; i2++) {
                        com.anythink.expressad.exoplayer.h.y yVar2 = yVarArr2[i2];
                        if (yVar2 == null) {
                            this.e[i2] = null;
                        } else if (yVarArr[i2] == null || this.e[i2].a != yVar2) {
                            this.e[i2] = new com.anythink.expressad.exoplayer.h.d.a(yVar2);
                        }
                        yVarArr[i2] = this.e[i2];
                    }
                    return a2;
                }
            }
        }
        j2 = -9223372036854775807L;
        this.f = j2;
        if (a2 != j) {
        }
        com.anythink.expressad.exoplayer.k.a.b(z2);
        while (i2 < yVarArr.length) {
        }
        return a2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
        this.a.a();
    }

    public final void a(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
        this.a.a(j, z);
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(com.anythink.expressad.exoplayer.h.r.a aVar, long j) {
        this.d = aVar;
        this.a.a(this, j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.anythink.expressad.exoplayer.h.r.a
    public final void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.d.a((com.anythink.expressad.exoplayer.h.r) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.z.a
    public final /* bridge */ /* synthetic */ void a(com.anythink.expressad.exoplayer.h.r rVar) {
        this.d.a((com.anythink.expressad.exoplayer.h.r.a) this);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
        this.a.a_(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 > r7) goto L17;
     */
    @Override // com.anythink.expressad.exoplayer.h.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long b(long j) {
        this.f = -9223372036854775807L;
        boolean z = false;
        for (com.anythink.expressad.exoplayer.h.d.a aVar : this.e) {
            if (aVar != null) {
                aVar.a();
            }
        }
        long b = this.a.b(j);
        if (b != j) {
            if (b >= this.b) {
                long j2 = this.c;
                if (j2 != Long.MIN_VALUE) {
                }
            }
            com.anythink.expressad.exoplayer.k.a.b(z);
            return b;
        }
        z = true;
        com.anythink.expressad.exoplayer.k.a.b(z);
        return b;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final com.anythink.expressad.exoplayer.h.af b() {
        return this.a.b();
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (f()) {
            long j = this.f;
            this.f = -9223372036854775807L;
            long c = c();
            return c != -9223372036854775807L ? c : j;
        }
        long c2 = this.a.c();
        if (c2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.anythink.expressad.exoplayer.k.a.b(c2 >= this.b);
        long j2 = this.c;
        if (j2 != Long.MIN_VALUE && c2 > j2) {
            z = false;
        }
        com.anythink.expressad.exoplayer.k.a.b(z);
        return c2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        return this.a.c(j);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        long d = this.a.d();
        if (d != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || d < j) {
                return d;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        long e = this.a.e();
        if (e != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || e < j) {
                return e;
            }
        }
        return Long.MIN_VALUE;
    }

    public final boolean f() {
        return this.f != -9223372036854775807L;
    }
}
