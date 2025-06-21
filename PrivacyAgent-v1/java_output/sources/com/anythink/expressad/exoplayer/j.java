package com.anythink.expressad.exoplayer;

/* loaded from: classes12.dex */
final class j implements com.anythink.expressad.exoplayer.h {
    private static final java.lang.String w = "ExoPlayerImpl";
    private final android.os.Handler A;
    private final com.anythink.expressad.exoplayer.k B;
    private final android.os.Handler C;
    private final java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.w.c> D;
    private final com.anythink.expressad.exoplayer.ae.b E;
    private final com.anythink.expressad.exoplayer.ae.a F;
    private final java.util.ArrayDeque<com.anythink.expressad.exoplayer.j.a> G;
    private boolean H;
    private int I;
    private boolean J;
    private int K;
    private boolean L;
    private boolean M;
    private com.anythink.expressad.exoplayer.v N;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.g O;
    private com.anythink.expressad.exoplayer.u P;
    private int Q;
    private int R;
    private long S;
    private final com.anythink.expressad.exoplayer.y[] x;
    private final com.anythink.expressad.exoplayer.i.h y;
    private final com.anythink.expressad.exoplayer.i.i z;

    /* renamed from: com.anythink.expressad.exoplayer.j$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            com.anythink.expressad.exoplayer.j.this.a(message);
        }
    }

    public static final class a {
        private final com.anythink.expressad.exoplayer.u a;
        private final java.util.Set<com.anythink.expressad.exoplayer.w.c> b;
        private final com.anythink.expressad.exoplayer.i.h c;
        private final boolean d;
        private final int e;
        private final int f;
        private final boolean g;
        private final boolean h;
        private final boolean i;
        private final boolean j;
        private final boolean k;
        private final boolean l;

        public a(com.anythink.expressad.exoplayer.u uVar, com.anythink.expressad.exoplayer.u uVar2, java.util.Set<com.anythink.expressad.exoplayer.w.c> set, com.anythink.expressad.exoplayer.i.h hVar, boolean z, int i, int i2, boolean z2, boolean z3, boolean z4) {
            this.a = uVar;
            this.b = set;
            this.c = hVar;
            this.d = z;
            this.e = i;
            this.f = i2;
            this.g = z2;
            this.h = z3;
            this.i = z4 || uVar2.f != uVar.f;
            this.j = (uVar2.a == uVar.a && uVar2.b == uVar.b) ? false : true;
            this.k = uVar2.g != uVar.g;
            this.l = uVar2.i != uVar.i;
        }

        public final void a() {
            if (this.j || this.f == 0) {
                for (com.anythink.expressad.exoplayer.w.c cVar : this.b) {
                    com.anythink.expressad.exoplayer.u uVar = this.a;
                    cVar.onTimelineChanged(uVar.a, uVar.b, this.f);
                }
            }
            if (this.d) {
                java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().onPositionDiscontinuity(this.e);
                }
            }
            if (this.l) {
                this.c.a(this.a.i.d);
                for (com.anythink.expressad.exoplayer.w.c cVar2 : this.b) {
                    com.anythink.expressad.exoplayer.u uVar2 = this.a;
                    cVar2.onTracksChanged(uVar2.h, uVar2.i.c);
                }
            }
            if (this.k) {
                java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it2 = this.b.iterator();
                while (it2.hasNext()) {
                    it2.next().onLoadingChanged(this.a.g);
                }
            }
            if (this.i) {
                java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it3 = this.b.iterator();
                while (it3.hasNext()) {
                    it3.next().onPlayerStateChanged(this.h, this.a.f);
                }
            }
            if (this.g) {
                java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it4 = this.b.iterator();
                while (it4.hasNext()) {
                    it4.next().onSeekProcessed();
                }
            }
        }
    }

    @android.annotation.SuppressLint({"HandlerLeak"})
    public j(com.anythink.expressad.exoplayer.y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, com.anythink.expressad.exoplayer.p pVar, com.anythink.expressad.exoplayer.k.c cVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Init ");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" [ExoPlayerLib/2.8.4] [");
        sb.append(com.anythink.expressad.exoplayer.k.af.e);
        sb.append("]");
        com.anythink.expressad.exoplayer.k.a.b(yVarArr.length > 0);
        this.x = (com.anythink.expressad.exoplayer.y[]) com.anythink.expressad.exoplayer.k.a.a(yVarArr);
        this.y = (com.anythink.expressad.exoplayer.i.h) com.anythink.expressad.exoplayer.k.a.a(hVar);
        this.H = false;
        this.I = 0;
        this.J = false;
        this.D = new java.util.concurrent.CopyOnWriteArraySet<>();
        com.anythink.expressad.exoplayer.i.i iVar = new com.anythink.expressad.exoplayer.i.i(new com.anythink.expressad.exoplayer.aa[yVarArr.length], new com.anythink.expressad.exoplayer.i.f[yVarArr.length], null);
        this.z = iVar;
        this.E = new com.anythink.expressad.exoplayer.ae.b();
        this.F = new com.anythink.expressad.exoplayer.ae.a();
        this.N = com.anythink.expressad.exoplayer.v.a;
        com.anythink.expressad.exoplayer.j.AnonymousClass1 anonymousClass1 = new com.anythink.expressad.exoplayer.j.AnonymousClass1(android.os.Looper.myLooper() != null ? android.os.Looper.myLooper() : android.os.Looper.getMainLooper());
        this.A = anonymousClass1;
        this.P = new com.anythink.expressad.exoplayer.u(com.anythink.expressad.exoplayer.ae.a, 0L, com.anythink.expressad.exoplayer.h.af.a, iVar);
        this.G = new java.util.ArrayDeque<>();
        com.anythink.expressad.exoplayer.k kVar = new com.anythink.expressad.exoplayer.k(yVarArr, hVar, iVar, pVar, this.H, this.I, this.J, anonymousClass1, this, cVar);
        this.B = kVar;
        this.C = new android.os.Handler(kVar.b());
    }

    private boolean H() {
        return this.P.a.a() || this.K > 0;
    }

    private com.anythink.expressad.exoplayer.u a(boolean z, boolean z2, int i) {
        if (z) {
            this.Q = 0;
            this.R = 0;
            this.S = 0L;
        } else {
            this.Q = p();
            this.R = o();
            this.S = t();
        }
        com.anythink.expressad.exoplayer.ae aeVar = z2 ? com.anythink.expressad.exoplayer.ae.a : this.P.a;
        java.lang.Object obj = z2 ? null : this.P.b;
        com.anythink.expressad.exoplayer.u uVar = this.P;
        return new com.anythink.expressad.exoplayer.u(aeVar, obj, uVar.c, uVar.d, uVar.e, i, false, z2 ? com.anythink.expressad.exoplayer.h.af.a : uVar.h, z2 ? this.z : uVar.i);
    }

    private void a(com.anythink.expressad.exoplayer.u uVar, int i, boolean z, int i2) {
        int i3 = this.K - i;
        this.K = i3;
        if (i3 == 0) {
            if (uVar.d == -9223372036854775807L) {
                uVar = uVar.a(uVar.c, 0L, uVar.e);
            }
            com.anythink.expressad.exoplayer.u uVar2 = uVar;
            if ((!this.P.a.a() || this.L) && uVar2.a.a()) {
                this.R = 0;
                this.Q = 0;
                this.S = 0L;
            }
            int i4 = this.L ? 0 : 2;
            boolean z2 = this.M;
            this.L = false;
            this.M = false;
            a(uVar2, z, i2, i4, z2, false);
        }
    }

    private void a(com.anythink.expressad.exoplayer.u uVar, boolean z, int i, int i2, boolean z2, boolean z3) {
        boolean z4 = !this.G.isEmpty();
        this.G.addLast(new com.anythink.expressad.exoplayer.j.a(uVar, this.P, this.D, this.y, z, i, i2, z2, this.H, z3));
        this.P = uVar;
        if (z4) {
            return;
        }
        while (!this.G.isEmpty()) {
            this.G.peekFirst().a();
            this.G.removeFirst();
        }
    }

    private long b(long j) {
        long a2 = com.anythink.expressad.exoplayer.b.a(j);
        if (this.P.c.a()) {
            return a2;
        }
        com.anythink.expressad.exoplayer.u uVar = this.P;
        uVar.a.a(uVar.c.a, this.F, false);
        return a2 + this.F.a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int A() {
        if (y()) {
            return this.P.c.c;
        }
        return -1;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long B() {
        if (!y()) {
            return t();
        }
        com.anythink.expressad.exoplayer.u uVar = this.P;
        uVar.a.a(uVar.c.a, this.F, false);
        return this.F.a() + com.anythink.expressad.exoplayer.b.a(this.P.e);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int C() {
        return this.x.length;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.h.af D() {
        return this.P.h;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.i.g E() {
        return this.P.i.c;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.ae F() {
        return this.P.a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final java.lang.Object G() {
        return this.P.b;
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final android.os.Looper a() {
        return this.B.b();
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final com.anythink.expressad.exoplayer.x a(com.anythink.expressad.exoplayer.x.b bVar) {
        return new com.anythink.expressad.exoplayer.x(this.B, bVar, this.P.a, p(), this.C);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i) {
        if (this.I != i) {
            this.I = i;
            this.B.a(i);
            java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i, long j) {
        com.anythink.expressad.exoplayer.ae aeVar = this.P.a;
        if (i < 0 || (!aeVar.a() && i >= aeVar.b())) {
            throw new com.anythink.expressad.exoplayer.o(aeVar, i, j);
        }
        this.M = true;
        this.K++;
        if (y()) {
            this.A.obtainMessage(0, 1, -1, this.P).sendToTarget();
            return;
        }
        this.Q = i;
        if (aeVar.a()) {
            this.S = j == -9223372036854775807L ? 0L : j;
            this.R = 0;
        } else {
            long b = j == -9223372036854775807L ? aeVar.a(i, this.E, false).h : com.anythink.expressad.exoplayer.b.b(j);
            android.util.Pair<java.lang.Integer, java.lang.Long> a2 = aeVar.a(this.E, this.F, i, b);
            this.S = com.anythink.expressad.exoplayer.b.a(b);
            this.R = ((java.lang.Integer) a2.first).intValue();
        }
        this.B.a(aeVar, i, com.anythink.expressad.exoplayer.b.b(j));
        java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(long j) {
        a(p(), j);
    }

    public final void a(android.os.Message message) {
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new java.lang.IllegalStateException();
                }
                com.anythink.expressad.exoplayer.g gVar = (com.anythink.expressad.exoplayer.g) message.obj;
                this.O = gVar;
                java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it = this.D.iterator();
                while (it.hasNext()) {
                    it.next().onPlayerError(gVar);
                }
                return;
            }
            com.anythink.expressad.exoplayer.v vVar = (com.anythink.expressad.exoplayer.v) message.obj;
            if (this.N.equals(vVar)) {
                return;
            }
            this.N = vVar;
            java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it2 = this.D.iterator();
            while (it2.hasNext()) {
                it2.next().onPlaybackParametersChanged(vVar);
            }
            return;
        }
        com.anythink.expressad.exoplayer.u uVar = (com.anythink.expressad.exoplayer.u) message.obj;
        int i2 = message.arg1;
        int i3 = message.arg2;
        boolean z = i3 != -1;
        int i4 = this.K - i2;
        this.K = i4;
        if (i4 == 0) {
            if (uVar.d == -9223372036854775807L) {
                uVar = uVar.a(uVar.c, 0L, uVar.e);
            }
            com.anythink.expressad.exoplayer.u uVar2 = uVar;
            if ((!this.P.a.a() || this.L) && uVar2.a.a()) {
                this.R = 0;
                this.Q = 0;
                this.S = 0L;
            }
            int i5 = this.L ? 0 : 2;
            boolean z2 = this.M;
            this.L = false;
            this.M = false;
            a(uVar2, z, i3, i5, z2, false);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.ac acVar) {
        if (acVar == null) {
            acVar = com.anythink.expressad.exoplayer.ac.e;
        }
        this.B.a(acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(sVar, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.O = null;
        com.anythink.expressad.exoplayer.u a2 = a(z, z2, 2);
        this.L = true;
        this.K++;
        this.B.a(sVar, z, z2);
        a(a2, false, 4, 1, false, false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.v vVar) {
        if (vVar == null) {
            vVar = com.anythink.expressad.exoplayer.v.a;
        }
        this.B.b(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(com.anythink.expressad.exoplayer.w.c cVar) {
        this.D.add(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(boolean z) {
        if (this.H != z) {
            this.H = z;
            this.B.a(z);
            a(this.P, false, 4, 1, false, true);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.c... cVarArr) {
        for (com.anythink.expressad.exoplayer.h.c cVar : cVarArr) {
            a(cVar.a).a(cVar.b).a(cVar.c).i();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.w.g b() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(int i) {
        a(i, -9223372036854775807L);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(com.anythink.expressad.exoplayer.w.c cVar) {
        this.D.remove(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(boolean z) {
        if (this.J != z) {
            this.J = z;
            this.B.b(z);
            java.util.Iterator<com.anythink.expressad.exoplayer.w.c> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void b(com.anythink.expressad.exoplayer.h.c... cVarArr) {
        java.util.ArrayList<com.anythink.expressad.exoplayer.x> arrayList = new java.util.ArrayList();
        for (com.anythink.expressad.exoplayer.h.c cVar : cVarArr) {
            arrayList.add(a(cVar.a).a(cVar.b).a(cVar.c).i());
        }
        boolean z = false;
        for (com.anythink.expressad.exoplayer.x xVar : arrayList) {
            boolean z2 = true;
            while (z2) {
                try {
                    xVar.k();
                    z2 = false;
                } catch (java.lang.InterruptedException unused) {
                    z = true;
                } catch (java.util.concurrent.TimeoutException e) {
                    e.getMessage();
                }
            }
        }
        if (z) {
            java.lang.Thread.currentThread().interrupt();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int c(int i) {
        return this.x[i].a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.w.e c() {
        return null;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void c(boolean z) {
        if (z) {
            this.O = null;
        }
        com.anythink.expressad.exoplayer.u a2 = a(z, z, 1);
        this.K++;
        this.B.c(z);
        a(a2, false, 4, 1, false, false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int d() {
        return this.P.f;
    }

    @Override // com.anythink.expressad.exoplayer.w
    @androidx.annotation.Nullable
    public final com.anythink.expressad.exoplayer.g e() {
        return this.O;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean f() {
        return this.H;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int g() {
        return this.I;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean h() {
        return this.J;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean i() {
        return this.P.g;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void j() {
        b(p());
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.v k() {
        return this.N;
    }

    @Override // com.anythink.expressad.exoplayer.w
    @androidx.annotation.Nullable
    public final java.lang.Object l() {
        int p = p();
        if (p > this.P.a.b()) {
            return null;
        }
        return this.P.a.a(p, this.E, true).a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void m() {
        c(false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void n() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Release ");
        sb.append(java.lang.Integer.toHexString(java.lang.System.identityHashCode(this)));
        sb.append(" [ExoPlayerLib/2.8.4] [");
        sb.append(com.anythink.expressad.exoplayer.k.af.e);
        sb.append("] [");
        sb.append(com.anythink.expressad.exoplayer.l.a());
        sb.append("]");
        this.B.a();
        this.A.removeCallbacksAndMessages(null);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int o() {
        return H() ? this.R : this.P.c.a;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int p() {
        if (H()) {
            return this.Q;
        }
        com.anythink.expressad.exoplayer.u uVar = this.P;
        return uVar.a.a(uVar.c.a, this.F, false).c;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int q() {
        com.anythink.expressad.exoplayer.ae aeVar = this.P.a;
        if (aeVar.a()) {
            return -1;
        }
        return aeVar.a(p(), this.I, this.J);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int r() {
        com.anythink.expressad.exoplayer.ae aeVar = this.P.a;
        if (aeVar.a()) {
            return -1;
        }
        return aeVar.b(p(), this.I, this.J);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long s() {
        com.anythink.expressad.exoplayer.ae aeVar = this.P.a;
        if (aeVar.a()) {
            return -9223372036854775807L;
        }
        if (!y()) {
            return com.anythink.expressad.exoplayer.b.a(aeVar.a(p(), this.E, false).i);
        }
        com.anythink.expressad.exoplayer.h.s.a aVar = this.P.c;
        aeVar.a(aVar.a, this.F, false);
        return com.anythink.expressad.exoplayer.b.a(this.F.c(aVar.b, aVar.c));
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long t() {
        return H() ? this.S : b(this.P.j);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long u() {
        return H() ? this.S : b(this.P.k);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int v() {
        long u = u();
        long s2 = s();
        if (u == -9223372036854775807L || s2 == -9223372036854775807L) {
            return 0;
        }
        if (s2 == 0) {
            return 100;
        }
        return com.anythink.expressad.exoplayer.k.af.a((int) ((u * 100) / s2), 0, 100);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean w() {
        com.anythink.expressad.exoplayer.ae aeVar = this.P.a;
        return !aeVar.a() && aeVar.a(p(), this.E, false).e;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean x() {
        com.anythink.expressad.exoplayer.ae aeVar = this.P.a;
        return !aeVar.a() && aeVar.a(p(), this.E, false).d;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean y() {
        return !H() && this.P.c.a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int z() {
        if (y()) {
            return this.P.c.b;
        }
        return -1;
    }
}
