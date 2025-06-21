package com.anythink.expressad.exoplayer.b;

/* loaded from: classes12.dex */
public abstract class r extends com.anythink.expressad.exoplayer.a implements com.anythink.expressad.exoplayer.k.n {
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e> A;
    private com.anythink.expressad.exoplayer.c.e B;
    private com.anythink.expressad.exoplayer.c.h C;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> D;
    private com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> q;
    private final boolean r;

    /* renamed from: s, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.b.g.a f208s;
    private final com.anythink.expressad.exoplayer.b.h t;
    private final com.anythink.expressad.exoplayer.n u;
    private final com.anythink.expressad.exoplayer.c.e v;
    private com.anythink.expressad.exoplayer.c.d w;
    private com.anythink.expressad.exoplayer.m x;
    private int y;
    private int z;

    public final class a implements com.anythink.expressad.exoplayer.b.h.c {
        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.exoplayer.b.r rVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a() {
            com.anythink.expressad.exoplayer.b.r.b(com.anythink.expressad.exoplayer.b.r.this);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i) {
            com.anythink.expressad.exoplayer.b.r.this.f208s.a(i);
        }

        @Override // com.anythink.expressad.exoplayer.b.h.c
        public final void a(int i, long j, long j2) {
            com.anythink.expressad.exoplayer.b.r.this.f208s.a(i, j, j2);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    public r() {
        this((android.os.Handler) null, (com.anythink.expressad.exoplayer.b.g) null, new com.anythink.expressad.exoplayer.b.f[0]);
    }

    private r(android.os.Handler handler, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.b.c cVar) {
        this(handler, gVar, cVar, null, new com.anythink.expressad.exoplayer.b.f[0]);
    }

    private r(android.os.Handler handler, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.b.c cVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar2, com.anythink.expressad.exoplayer.b.f... fVarArr) {
        this(handler, gVar, gVar2, new com.anythink.expressad.exoplayer.b.l(cVar, fVarArr));
    }

    private r(android.os.Handler handler, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar2, com.anythink.expressad.exoplayer.b.h hVar) {
        super(1);
        this.q = gVar2;
        this.r = false;
        this.f208s = new com.anythink.expressad.exoplayer.b.g.a(handler, gVar);
        this.t = hVar;
        hVar.a(new com.anythink.expressad.exoplayer.b.r.a(this, (byte) 0));
        this.u = new com.anythink.expressad.exoplayer.n();
        this.v = com.anythink.expressad.exoplayer.c.e.e();
        this.F = 0;
        this.H = true;
    }

    private r(android.os.Handler handler, com.anythink.expressad.exoplayer.b.g gVar, com.anythink.expressad.exoplayer.b.f... fVarArr) {
        this(handler, gVar, null, null, fVarArr);
    }

    private static void A() {
    }

    private com.anythink.expressad.exoplayer.m B() {
        com.anythink.expressad.exoplayer.m mVar = this.x;
        return com.anythink.expressad.exoplayer.m.a((java.lang.String) null, "audio/raw", (java.lang.String) null, -1, mVar.u, mVar.v, 2, (java.util.List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (java.lang.String) null);
    }

    private boolean C() {
        if (this.C == null) {
            com.anythink.expressad.exoplayer.c.h c = this.A.c();
            this.C = c;
            if (c == null) {
                return false;
            }
            this.w.f += c.b;
        }
        if (this.C.c()) {
            if (this.F == 2) {
                H();
                G();
                this.H = true;
            } else {
                this.C.e();
                this.C = null;
                E();
            }
            return false;
        }
        if (this.H) {
            com.anythink.expressad.exoplayer.m mVar = this.x;
            com.anythink.expressad.exoplayer.m a2 = com.anythink.expressad.exoplayer.m.a((java.lang.String) null, "audio/raw", (java.lang.String) null, -1, mVar.u, mVar.v, 2, (java.util.List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (java.lang.String) null);
            this.t.a(a2.w, a2.u, a2.v, null, this.y, this.z);
            this.H = false;
        }
        com.anythink.expressad.exoplayer.b.h hVar = this.t;
        com.anythink.expressad.exoplayer.c.h hVar2 = this.C;
        if (!hVar.a(hVar2.c, ((com.anythink.expressad.exoplayer.c.f) hVar2).a)) {
            return false;
        }
        this.w.e++;
        this.C.e();
        this.C = null;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean D() {
        boolean z;
        com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e> gVar = this.A;
        if (gVar == null || this.F == 2 || this.L) {
            return false;
        }
        if (this.B == null) {
            com.anythink.expressad.exoplayer.c.e b2 = gVar.b();
            this.B = b2;
            if (b2 == null) {
                return false;
            }
        }
        if (this.F == 1) {
            this.B.a(4);
            this.A.a((com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e>) this.B);
            this.B = null;
            this.F = 2;
            return false;
        }
        int a2 = this.N ? -4 : a(this.u, this.B, false);
        if (a2 == -3) {
            return false;
        }
        if (a2 == -5) {
            b(this.u.a);
            return true;
        }
        if (this.B.c()) {
            this.L = true;
            this.A.a((com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e>) this.B);
            this.B = null;
            return false;
        }
        boolean g = this.B.g();
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.D;
        if (fVar != null && (g || !this.r)) {
            int e = fVar.e();
            if (e == 1) {
                throw com.anythink.expressad.exoplayer.g.a(this.D.f(), s());
            }
            if (e != 4) {
                z = true;
                this.N = z;
                if (!z) {
                    return false;
                }
                this.B.h();
                com.anythink.expressad.exoplayer.c.e eVar = this.B;
                if (this.J && !eVar.b()) {
                    if (java.lang.Math.abs(eVar.f - this.I) > 500000) {
                        this.I = eVar.f;
                    }
                    this.J = false;
                }
                this.A.a((com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e>) this.B);
                this.G = true;
                this.w.c++;
                this.B = null;
                return true;
            }
        }
        z = false;
        this.N = z;
        if (!z) {
        }
    }

    private void E() {
        this.M = true;
        try {
            this.t.c();
        } catch (com.anythink.expressad.exoplayer.b.h.d e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    private void F() {
        this.N = false;
        if (this.F != 0) {
            H();
            G();
            return;
        }
        this.B = null;
        com.anythink.expressad.exoplayer.c.h hVar = this.C;
        if (hVar != null) {
            hVar.e();
            this.C = null;
        }
        this.A.d();
        this.G = false;
    }

    private void G() {
        if (this.A != null) {
            return;
        }
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.E;
        this.D = fVar;
        if (fVar != null && fVar.g() == null && this.D.f() == null) {
            return;
        }
        try {
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            com.anythink.expressad.exoplayer.k.ad.a("createAudioDecoder");
            this.A = x();
            com.anythink.expressad.exoplayer.k.ad.a();
            long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime();
            this.f208s.a(this.A.a(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
            this.w.a++;
        } catch (com.anythink.expressad.exoplayer.b.e e) {
            throw com.anythink.expressad.exoplayer.g.a(e, s());
        }
    }

    private void H() {
        com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e> gVar = this.A;
        if (gVar == null) {
            return;
        }
        this.B = null;
        this.C = null;
        gVar.e();
        this.A = null;
        this.w.b++;
        this.F = 0;
        this.G = false;
    }

    private void I() {
        long a2 = this.t.a(v());
        if (a2 != Long.MIN_VALUE) {
            if (!this.K) {
                a2 = java.lang.Math.max(this.I, a2);
            }
            this.I = a2;
            this.K = false;
        }
    }

    private void a(com.anythink.expressad.exoplayer.c.e eVar) {
        if (!this.J || eVar.b()) {
            return;
        }
        if (java.lang.Math.abs(eVar.f - this.I) > 500000) {
            this.I = eVar.f;
        }
        this.J = false;
    }

    private void b(com.anythink.expressad.exoplayer.m mVar) {
        com.anythink.expressad.exoplayer.m mVar2 = this.x;
        this.x = mVar;
        if (!com.anythink.expressad.exoplayer.k.af.a(mVar.k, mVar2 == null ? null : mVar2.k)) {
            if (this.x.k != null) {
                com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.i> gVar = this.q;
                if (gVar == null) {
                    throw com.anythink.expressad.exoplayer.g.a(new java.lang.IllegalStateException("Media requires a DrmSessionManager"), s());
                }
                com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> a2 = gVar.a(android.os.Looper.myLooper(), this.x.k);
                this.E = a2;
                if (a2 == this.D) {
                    this.q.a(a2);
                }
            } else {
                this.E = null;
            }
        }
        if (this.G) {
            this.F = 1;
        } else {
            H();
            G();
            this.H = true;
        }
        this.y = mVar.x;
        this.z = mVar.y;
        this.f208s.a(mVar);
    }

    private boolean b(int i) {
        return this.t.a(i);
    }

    public static /* synthetic */ boolean b(com.anythink.expressad.exoplayer.b.r rVar) {
        rVar.K = true;
        return true;
    }

    private boolean b(boolean z) {
        com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.D;
        if (fVar == null || (!z && this.r)) {
            return false;
        }
        int e = fVar.e();
        if (e != 1) {
            return e != 4;
        }
        throw com.anythink.expressad.exoplayer.g.a(this.D.f(), s());
    }

    private static void y() {
    }

    private static void z() {
    }

    @Override // com.anythink.expressad.exoplayer.z
    public final int a(com.anythink.expressad.exoplayer.m mVar) {
        int w = w();
        if (w <= 2) {
            return w;
        }
        return w | (com.anythink.expressad.exoplayer.k.af.a >= 21 ? 32 : 0) | 8;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v a(com.anythink.expressad.exoplayer.v vVar) {
        return this.t.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.x.b
    public final void a(int i, java.lang.Object obj) {
        if (i == 2) {
            this.t.a(((java.lang.Float) obj).floatValue());
        } else if (i != 3) {
            super.a(i, obj);
        } else {
            this.t.a((com.anythink.expressad.exoplayer.b.b) obj);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016f A[Catch: d -> 0x01b1, b -> 0x01b3, e | a | b | d -> 0x01b5, e -> 0x01b7, TryCatch #3 {e | a | b | d -> 0x01b5, blocks: (B:17:0x004c, B:18:0x0051, B:20:0x0058, B:22:0x0064, B:27:0x00d9, B:29:0x00dd, B:31:0x00e1, B:34:0x00e7, B:36:0x00eb, B:39:0x00f5, B:41:0x00fa, B:42:0x010c, B:49:0x0121, B:54:0x01ad, B:57:0x012b, B:59:0x0133, B:60:0x013f, B:63:0x014b, B:66:0x0150, B:70:0x016a, B:73:0x016f, B:75:0x017a, B:77:0x0180, B:79:0x0190, B:80:0x0194, B:81:0x0196, B:83:0x015a, B:84:0x0168, B:86:0x0112, B:90:0x006d, B:92:0x0075, B:94:0x0079, B:95:0x0082, B:96:0x008d, B:98:0x0091, B:99:0x00b8, B:101:0x00c6), top: B:16:0x004c }] */
    @Override // com.anythink.expressad.exoplayer.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(long j, long j2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.M) {
            try {
                this.t.c();
                return;
            } catch (com.anythink.expressad.exoplayer.b.h.d e) {
                throw com.anythink.expressad.exoplayer.g.a(e, s());
            }
        }
        if (this.x == null) {
            this.v.a();
            int a2 = a(this.u, this.v, true);
            if (a2 != -5) {
                if (a2 == -4) {
                    com.anythink.expressad.exoplayer.k.a.b(this.v.c());
                    this.L = true;
                    E();
                    return;
                }
                return;
            }
            b(this.u.a);
        }
        G();
        if (this.A != null) {
            try {
                com.anythink.expressad.exoplayer.k.ad.a("drainAndFeed");
                do {
                    if (this.C == null) {
                        com.anythink.expressad.exoplayer.c.h c = this.A.c();
                        this.C = c;
                        if (c != null) {
                            this.w.f += c.b;
                        }
                        z = false;
                    }
                    if (!this.C.c()) {
                        if (this.H) {
                            com.anythink.expressad.exoplayer.m mVar = this.x;
                            com.anythink.expressad.exoplayer.m a3 = com.anythink.expressad.exoplayer.m.a((java.lang.String) null, "audio/raw", (java.lang.String) null, -1, mVar.u, mVar.v, 2, (java.util.List<byte[]>) null, (com.anythink.expressad.exoplayer.d.e) null, (java.lang.String) null);
                            this.t.a(a3.w, a3.u, a3.v, null, this.y, this.z);
                            this.H = false;
                        }
                        com.anythink.expressad.exoplayer.b.h hVar = this.t;
                        com.anythink.expressad.exoplayer.c.h hVar2 = this.C;
                        if (hVar.a(hVar2.c, ((com.anythink.expressad.exoplayer.c.f) hVar2).a)) {
                            this.w.e++;
                            this.C.e();
                            this.C = null;
                            z = true;
                        }
                    } else if (this.F == 2) {
                        H();
                        G();
                        this.H = true;
                    } else {
                        this.C.e();
                        this.C = null;
                        E();
                    }
                    z = false;
                } while (z);
                do {
                    com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e> gVar = this.A;
                    if (gVar != null && this.F != 2 && !this.L) {
                        if (this.B == null) {
                            com.anythink.expressad.exoplayer.c.e b2 = gVar.b();
                            this.B = b2;
                            if (b2 == null) {
                            }
                        }
                        if (this.F == 1) {
                            this.B.a(4);
                            this.A.a((com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e>) this.B);
                            this.B = null;
                            this.F = 2;
                        } else {
                            int a4 = this.N ? -4 : a(this.u, this.B, false);
                            if (a4 != -3) {
                                if (a4 == -5) {
                                    b(this.u.a);
                                } else if (this.B.c()) {
                                    this.L = true;
                                    this.A.a((com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e>) this.B);
                                    this.B = null;
                                } else {
                                    boolean g = this.B.g();
                                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.D;
                                    if (fVar != null && (g || !this.r)) {
                                        int e2 = fVar.e();
                                        if (e2 == 1) {
                                            throw com.anythink.expressad.exoplayer.g.a(this.D.f(), s());
                                        }
                                        if (e2 != 4) {
                                            z3 = true;
                                            this.N = z3;
                                            if (z3) {
                                                this.B.h();
                                                com.anythink.expressad.exoplayer.c.e eVar = this.B;
                                                if (this.J && !eVar.b()) {
                                                    if (java.lang.Math.abs(eVar.f - this.I) > 500000) {
                                                        this.I = eVar.f;
                                                    }
                                                    this.J = false;
                                                }
                                                this.A.a((com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e>) this.B);
                                                this.G = true;
                                                this.w.c++;
                                                this.B = null;
                                            }
                                        }
                                    }
                                    z3 = false;
                                    this.N = z3;
                                    if (z3) {
                                    }
                                }
                                z2 = true;
                            }
                        }
                    }
                    z2 = false;
                } while (z2);
                com.anythink.expressad.exoplayer.k.ad.a();
            } catch (com.anythink.expressad.exoplayer.b.e | com.anythink.expressad.exoplayer.b.h.a | com.anythink.expressad.exoplayer.b.h.b | com.anythink.expressad.exoplayer.b.h.d e3) {
                throw com.anythink.expressad.exoplayer.g.a(e3, s());
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(long j, boolean z) {
        this.t.i();
        this.I = j;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        if (this.A != null) {
            this.N = false;
            if (this.F != 0) {
                H();
                G();
                return;
            }
            this.B = null;
            com.anythink.expressad.exoplayer.c.h hVar = this.C;
            if (hVar != null) {
                hVar.e();
                this.C = null;
            }
            this.A.d();
            this.G = false;
        }
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void a(boolean z) {
        com.anythink.expressad.exoplayer.c.d dVar = new com.anythink.expressad.exoplayer.c.d();
        this.w = dVar;
        this.f208s.a(dVar);
        int i = r().b;
        if (i != 0) {
            this.t.c(i);
        } else {
            this.t.g();
        }
    }

    @Override // com.anythink.expressad.exoplayer.a, com.anythink.expressad.exoplayer.y
    public final com.anythink.expressad.exoplayer.k.n c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            I();
        }
        return this.I;
    }

    @Override // com.anythink.expressad.exoplayer.k.n
    public final com.anythink.expressad.exoplayer.v e() {
        return this.t.f();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void n() {
        this.t.a();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void o() {
        I();
        this.t.h();
    }

    @Override // com.anythink.expressad.exoplayer.a
    public final void p() {
        this.x = null;
        this.H = true;
        this.N = false;
        try {
            H();
            this.t.j();
            try {
                com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar = this.D;
                if (fVar != null) {
                    this.q.a(fVar);
                }
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar2 = this.E;
                    if (fVar2 != null && fVar2 != this.D) {
                        this.q.a(fVar2);
                    }
                } finally {
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar3 = this.E;
                    if (fVar3 != null && fVar3 != this.D) {
                        this.q.a(fVar3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (java.lang.Throwable th2) {
            try {
                com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar4 = this.D;
                if (fVar4 != null) {
                    this.q.a(fVar4);
                }
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar5 = this.E;
                    if (fVar5 != null && fVar5 != this.D) {
                        this.q.a(fVar5);
                    }
                    throw th2;
                } finally {
                }
            } catch (java.lang.Throwable th3) {
                try {
                    com.anythink.expressad.exoplayer.d.f<com.anythink.expressad.exoplayer.d.i> fVar6 = this.E;
                    if (fVar6 != null && fVar6 != this.D) {
                        this.q.a(fVar6);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean u() {
        if (this.t.e()) {
            return true;
        }
        if (this.x == null || this.N) {
            return false;
        }
        return t() || this.C != null;
    }

    @Override // com.anythink.expressad.exoplayer.y
    public final boolean v() {
        return this.M && this.t.d();
    }

    public abstract int w();

    public abstract com.anythink.expressad.exoplayer.c.g<com.anythink.expressad.exoplayer.c.e, ? extends com.anythink.expressad.exoplayer.c.h, ? extends com.anythink.expressad.exoplayer.b.e> x();
}
