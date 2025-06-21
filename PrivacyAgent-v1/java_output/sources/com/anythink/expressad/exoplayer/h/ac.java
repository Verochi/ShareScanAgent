package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
final class ac implements com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.j.t.a<com.anythink.expressad.exoplayer.h.ac.b> {
    private static final int i = 1024;
    final com.anythink.expressad.exoplayer.m b;
    final boolean c;
    boolean d;
    boolean e;
    boolean f;
    byte[] g;
    int h;
    private final com.anythink.expressad.exoplayer.j.k j;
    private final com.anythink.expressad.exoplayer.j.h.a k;
    private final int l;
    private final com.anythink.expressad.exoplayer.h.t.a m;
    private final com.anythink.expressad.exoplayer.h.af n;
    private final long p;
    private int q;
    private final java.util.ArrayList<com.anythink.expressad.exoplayer.h.ac.a> o = new java.util.ArrayList<>();
    final com.anythink.expressad.exoplayer.j.t a = new com.anythink.expressad.exoplayer.j.t("Loader:SingleSampleMediaPeriod");

    public final class a implements com.anythink.expressad.exoplayer.h.y {
        private static final int b = 0;
        private static final int c = 1;
        private static final int d = 2;
        private int e;
        private boolean f;

        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.exoplayer.h.ac acVar, byte b2) {
            this();
        }

        private void d() {
            if (this.f) {
                return;
            }
            com.anythink.expressad.exoplayer.h.ac.this.m.a(com.anythink.expressad.exoplayer.k.o.d(com.anythink.expressad.exoplayer.h.ac.this.b.h), com.anythink.expressad.exoplayer.h.ac.this.b, 0, (java.lang.Object) null, 0L);
            this.f = true;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(long j) {
            if (j <= 0 || this.e == 2) {
                return 0;
            }
            this.e = 2;
            d();
            return 1;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final int a(com.anythink.expressad.exoplayer.n nVar, com.anythink.expressad.exoplayer.c.e eVar, boolean z) {
            int i = this.e;
            if (i == 2) {
                eVar.b(4);
                return -4;
            }
            if (z || i == 0) {
                nVar.a = com.anythink.expressad.exoplayer.h.ac.this.b;
                this.e = 1;
                return -5;
            }
            com.anythink.expressad.exoplayer.h.ac acVar = com.anythink.expressad.exoplayer.h.ac.this;
            if (!acVar.e) {
                return -3;
            }
            if (acVar.f) {
                eVar.f = 0L;
                eVar.b(1);
                eVar.d(com.anythink.expressad.exoplayer.h.ac.this.h);
                java.nio.ByteBuffer byteBuffer = eVar.e;
                com.anythink.expressad.exoplayer.h.ac acVar2 = com.anythink.expressad.exoplayer.h.ac.this;
                byteBuffer.put(acVar2.g, 0, acVar2.h);
                d();
            } else {
                eVar.b(4);
            }
            this.e = 2;
            return -4;
        }

        public final void a() {
            if (this.e == 2) {
                this.e = 1;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final boolean b() {
            return com.anythink.expressad.exoplayer.h.ac.this.e;
        }

        @Override // com.anythink.expressad.exoplayer.h.y
        public final void c() {
            com.anythink.expressad.exoplayer.h.ac acVar = com.anythink.expressad.exoplayer.h.ac.this;
            if (acVar.c) {
                return;
            }
            acVar.a.c();
        }
    }

    public static final class b implements com.anythink.expressad.exoplayer.j.t.c {
        public final com.anythink.expressad.exoplayer.j.k a;
        private final com.anythink.expressad.exoplayer.j.h b;
        private int c;
        private byte[] d;

        public b(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.h hVar) {
            this.a = kVar;
            this.b = hVar;
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void a() {
        }

        @Override // com.anythink.expressad.exoplayer.j.t.c
        public final void b() {
            int i = 0;
            this.c = 0;
            try {
                this.b.a(this.a);
                while (i != -1) {
                    int i2 = this.c + i;
                    this.c = i2;
                    byte[] bArr = this.d;
                    if (bArr == null) {
                        this.d = new byte[1024];
                    } else if (i2 == bArr.length) {
                        this.d = java.util.Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    com.anythink.expressad.exoplayer.j.h hVar = this.b;
                    byte[] bArr2 = this.d;
                    int i3 = this.c;
                    i = hVar.a(bArr2, i3, bArr2.length - i3);
                }
            } finally {
                com.anythink.expressad.exoplayer.k.af.a(this.b);
            }
        }
    }

    public ac(com.anythink.expressad.exoplayer.j.k kVar, com.anythink.expressad.exoplayer.j.h.a aVar, com.anythink.expressad.exoplayer.m mVar, long j, int i2, com.anythink.expressad.exoplayer.h.t.a aVar2, boolean z) {
        this.j = kVar;
        this.k = aVar;
        this.b = mVar;
        this.p = j;
        this.l = i2;
        this.m = aVar2;
        this.c = z;
        this.n = new com.anythink.expressad.exoplayer.h.af(new com.anythink.expressad.exoplayer.h.ae(mVar));
        aVar2.a();
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private int a2(com.anythink.expressad.exoplayer.h.ac.b bVar, long j, long j2, java.io.IOException iOException) {
        int i2 = this.q + 1;
        this.q = i2;
        boolean z = this.c && i2 >= this.l;
        this.m.a(bVar.a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar.c, iOException, z);
        if (!z) {
            return 0;
        }
        this.e = true;
        return 2;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.anythink.expressad.exoplayer.h.ac.b bVar, long j, long j2) {
        this.m.a(bVar.a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar.c);
        this.h = bVar.c;
        this.g = bVar.d;
        this.e = true;
        this.f = true;
    }

    private void b(com.anythink.expressad.exoplayer.h.ac.b bVar, long j, long j2) {
        this.m.b(bVar.a, 1, -1, null, 0, null, 0L, this.p, j, j2, bVar.c);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* bridge */ /* synthetic */ int a(com.anythink.expressad.exoplayer.h.ac.b bVar, long j, long j2, java.io.IOException iOException) {
        com.anythink.expressad.exoplayer.h.ac.b bVar2 = bVar;
        int i2 = this.q + 1;
        this.q = i2;
        boolean z = this.c && i2 >= this.l;
        this.m.a(bVar2.a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar2.c, iOException, z);
        if (!z) {
            return 0;
        }
        this.e = true;
        return 2;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(long j, com.anythink.expressad.exoplayer.ac acVar) {
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long a(com.anythink.expressad.exoplayer.i.f[] fVarArr, boolean[] zArr, com.anythink.expressad.exoplayer.h.y[] yVarArr, boolean[] zArr2, long j) {
        for (int i2 = 0; i2 < fVarArr.length; i2++) {
            com.anythink.expressad.exoplayer.h.y yVar = yVarArr[i2];
            if (yVar != null && (fVarArr[i2] == null || !zArr[i2])) {
                this.o.remove(yVar);
                yVarArr[i2] = null;
            }
            if (yVarArr[i2] == null && fVarArr[i2] != null) {
                com.anythink.expressad.exoplayer.h.ac.a aVar = new com.anythink.expressad.exoplayer.h.ac.a(this, (byte) 0);
                this.o.add(aVar);
                yVarArr[i2] = aVar;
                zArr2[i2] = true;
            }
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a() {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(long j, boolean z) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final void a(com.anythink.expressad.exoplayer.h.r.a aVar, long j) {
        aVar.a((com.anythink.expressad.exoplayer.h.r) this);
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.ac.b bVar, long j, long j2) {
        com.anythink.expressad.exoplayer.h.ac.b bVar2 = bVar;
        this.m.a(bVar2.a, 1, -1, this.b, 0, null, 0L, this.p, j, j2, bVar2.c);
        this.h = bVar2.c;
        this.g = bVar2.d;
        this.e = true;
        this.f = true;
    }

    @Override // com.anythink.expressad.exoplayer.j.t.a
    public final /* synthetic */ void a(com.anythink.expressad.exoplayer.h.ac.b bVar, long j, long j2, boolean z) {
        this.m.b(bVar.a, 1, -1, null, 0, null, 0L, this.p, j, j2, r10.c);
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final void a_(long j) {
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long b(long j) {
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            this.o.get(i2).a();
        }
        return j;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final com.anythink.expressad.exoplayer.h.af b() {
        return this.n;
    }

    @Override // com.anythink.expressad.exoplayer.h.r
    public final long c() {
        if (this.d) {
            return -9223372036854775807L;
        }
        this.m.c();
        this.d = true;
        return -9223372036854775807L;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final boolean c(long j) {
        if (this.e || this.a.a()) {
            return false;
        }
        this.m.a(this.j, 1, -1, this.b, 0, null, 0L, this.p, this.a.a(new com.anythink.expressad.exoplayer.h.ac.b(this.j, this.k.a()), this, this.l));
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long d() {
        return this.e ? Long.MIN_VALUE : 0L;
    }

    @Override // com.anythink.expressad.exoplayer.h.r, com.anythink.expressad.exoplayer.h.z
    public final long e() {
        return (this.e || this.a.a()) ? Long.MIN_VALUE : 0L;
    }

    public final void f() {
        this.a.a((com.anythink.expressad.exoplayer.j.t.d) null);
        this.m.b();
    }
}
