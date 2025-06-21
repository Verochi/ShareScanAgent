package com.anythink.expressad.exoplayer.a;

/* loaded from: classes12.dex */
public final class a implements com.anythink.expressad.exoplayer.b.g, com.anythink.expressad.exoplayer.d.c, com.anythink.expressad.exoplayer.g.f, com.anythink.expressad.exoplayer.h.t, com.anythink.expressad.exoplayer.j.d.a, com.anythink.expressad.exoplayer.l.h, com.anythink.expressad.exoplayer.w.c {
    private final com.anythink.expressad.exoplayer.k.c b;

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.w e;
    private final java.util.concurrent.CopyOnWriteArraySet<com.anythink.expressad.exoplayer.a.b> a = new java.util.concurrent.CopyOnWriteArraySet<>();
    private final com.anythink.expressad.exoplayer.a.a.b d = new com.anythink.expressad.exoplayer.a.a.b();
    private final com.anythink.expressad.exoplayer.ae.b c = new com.anythink.expressad.exoplayer.ae.b();

    /* renamed from: com.anythink.expressad.exoplayer.a.a$a, reason: collision with other inner class name */
    public static class C0183a {
        public static com.anythink.expressad.exoplayer.a.a a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.w wVar, com.anythink.expressad.exoplayer.k.c cVar) {
            return new com.anythink.expressad.exoplayer.a.a(wVar, cVar);
        }
    }

    public static final class b {
        private com.anythink.expressad.exoplayer.a.a.c c;
        private com.anythink.expressad.exoplayer.a.a.c d;
        private boolean f;
        private final java.util.ArrayList<com.anythink.expressad.exoplayer.a.a.c> a = new java.util.ArrayList<>();
        private final com.anythink.expressad.exoplayer.ae.a b = new com.anythink.expressad.exoplayer.ae.a();
        private com.anythink.expressad.exoplayer.ae e = com.anythink.expressad.exoplayer.ae.a;

        private com.anythink.expressad.exoplayer.a.a.c a(com.anythink.expressad.exoplayer.a.a.c cVar, com.anythink.expressad.exoplayer.ae aeVar) {
            int a;
            return (aeVar.a() || this.e.a() || (a = aeVar.a(this.e.a(cVar.b.a, this.b, true).b)) == -1) ? cVar : new com.anythink.expressad.exoplayer.a.a.c(aeVar.a(a, this.b, false).c, cVar.b.a(a));
        }

        private void i() {
            if (this.a.isEmpty()) {
                return;
            }
            this.c = this.a.get(0);
        }

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.a.a.c a() {
            if (this.a.isEmpty() || this.e.a() || this.f) {
                return null;
            }
            return this.a.get(0);
        }

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.h.s.a a(int i) {
            com.anythink.expressad.exoplayer.ae aeVar = this.e;
            if (aeVar == null) {
                return null;
            }
            int c = aeVar.c();
            com.anythink.expressad.exoplayer.h.s.a aVar = null;
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                com.anythink.expressad.exoplayer.a.a.c cVar = this.a.get(i2);
                int i3 = cVar.b.a;
                if (i3 < c && this.e.a(i3, this.b, false).c == i) {
                    if (aVar != null) {
                        return null;
                    }
                    aVar = cVar.b;
                }
            }
            return aVar;
        }

        public final void a(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            this.a.add(new com.anythink.expressad.exoplayer.a.a.c(i, aVar));
            if (this.a.size() != 1 || this.e.a()) {
                return;
            }
            i();
        }

        public final void a(com.anythink.expressad.exoplayer.ae aeVar) {
            for (int i = 0; i < this.a.size(); i++) {
                java.util.ArrayList<com.anythink.expressad.exoplayer.a.a.c> arrayList = this.a;
                arrayList.set(i, a(arrayList.get(i), aeVar));
            }
            com.anythink.expressad.exoplayer.a.a.c cVar = this.d;
            if (cVar != null) {
                this.d = a(cVar, aeVar);
            }
            this.e = aeVar;
            i();
        }

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.a.a.c b() {
            return this.c;
        }

        public final void b(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            com.anythink.expressad.exoplayer.a.a.c cVar = new com.anythink.expressad.exoplayer.a.a.c(i, aVar);
            this.a.remove(cVar);
            if (cVar.equals(this.d)) {
                this.d = this.a.isEmpty() ? null : this.a.get(0);
            }
        }

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.a.a.c c() {
            return this.d;
        }

        public final void c(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            this.d = new com.anythink.expressad.exoplayer.a.a.c(i, aVar);
        }

        @androidx.annotation.Nullable
        public final com.anythink.expressad.exoplayer.a.a.c d() {
            if (this.a.isEmpty()) {
                return null;
            }
            return this.a.get(r0.size() - 1);
        }

        public final boolean e() {
            return this.f;
        }

        public final void f() {
            i();
        }

        public final void g() {
            this.f = true;
        }

        public final void h() {
            this.f = false;
            i();
        }
    }

    public static final class c {
        public final int a;
        public final com.anythink.expressad.exoplayer.h.s.a b;

        public c(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
            this.a = i;
            this.b = aVar;
        }

        public final boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && com.anythink.expressad.exoplayer.a.a.c.class == obj.getClass()) {
                com.anythink.expressad.exoplayer.a.a.c cVar = (com.anythink.expressad.exoplayer.a.a.c) obj;
                if (this.a == cVar.a && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a * 31) + this.b.hashCode();
        }
    }

    public a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.w wVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.e = wVar;
        this.b = (com.anythink.expressad.exoplayer.k.c) com.anythink.expressad.exoplayer.k.a.a(cVar);
    }

    private com.anythink.expressad.exoplayer.a.b.a a(@androidx.annotation.Nullable com.anythink.expressad.exoplayer.a.a.c cVar) {
        if (cVar != null) {
            return d(cVar.a, cVar.b);
        }
        int p = ((com.anythink.expressad.exoplayer.w) com.anythink.expressad.exoplayer.k.a.a(this.e)).p();
        return d(p, this.d.a(p));
    }

    private void a(int i, int i2) {
        com.anythink.expressad.exoplayer.a.b.a i3 = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i3, i, i2);
        }
    }

    private void a(@androidx.annotation.Nullable android.net.NetworkInfo networkInfo) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i, networkInfo);
        }
    }

    private void a(com.anythink.expressad.exoplayer.w wVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.e == null);
        this.e = (com.anythink.expressad.exoplayer.w) com.anythink.expressad.exoplayer.k.a.a(wVar);
    }

    private com.anythink.expressad.exoplayer.a.b.a d(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar) {
        long a;
        long j;
        com.anythink.expressad.exoplayer.k.a.a(this.e);
        long a2 = this.b.a();
        com.anythink.expressad.exoplayer.ae F = this.e.F();
        long j2 = 0;
        if (i != this.e.p()) {
            if (i < F.b() && (aVar == null || !aVar.a())) {
                a = com.anythink.expressad.exoplayer.b.a(F.a(i, this.c, false).h);
                j = a;
            }
            j = j2;
        } else if (aVar == null || !aVar.a()) {
            a = this.e.B();
            j = a;
        } else {
            if (this.e.z() == aVar.b && this.e.A() == aVar.c) {
                j2 = this.e.t();
            }
            j = j2;
        }
        return new com.anythink.expressad.exoplayer.a.b.a(a2, F, i, aVar, j, this.e.t(), this.e.u() - this.e.B());
    }

    private java.util.Set<com.anythink.expressad.exoplayer.a.b> g() {
        return java.util.Collections.unmodifiableSet(this.a);
    }

    private com.anythink.expressad.exoplayer.a.b.a h() {
        return a(this.d.b());
    }

    private com.anythink.expressad.exoplayer.a.b.a i() {
        return a(this.d.a());
    }

    private com.anythink.expressad.exoplayer.a.b.a j() {
        return a(this.d.c());
    }

    private com.anythink.expressad.exoplayer.a.b.a k() {
        return a(this.d.d());
    }

    public final void a() {
        if (this.d.e()) {
            return;
        }
        com.anythink.expressad.exoplayer.a.b.a i = i();
        this.d.g();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void a(int i) {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(j, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(int i, int i2, int i3, float f) {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(j, i, i2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(int i, long j) {
        com.anythink.expressad.exoplayer.a.b.a h = h();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(h, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void a(int i, long j, long j2) {
        com.anythink.expressad.exoplayer.a.b.a j3 = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j3, i, j, j2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
        this.d.a(i, aVar);
        com.anythink.expressad.exoplayer.a.b.a d = d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar, java.io.IOException iOException, boolean z) {
        com.anythink.expressad.exoplayer.a.b.a d = d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(d, iOException);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void a(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        com.anythink.expressad.exoplayer.a.b.a d = d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(d, cVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(android.view.Surface surface) {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j, surface);
        }
    }

    public final void a(com.anythink.expressad.exoplayer.a.b bVar) {
        this.a.add(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(i, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.g.f
    public final void a(com.anythink.expressad.exoplayer.g.a aVar) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i, aVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(com.anythink.expressad.exoplayer.m mVar) {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j, 2, mVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void a(java.lang.Exception exc) {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j, exc);
        }
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void a(java.lang.String str, long j, long j2) {
        com.anythink.expressad.exoplayer.a.b.a j3 = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j3, 2, str);
        }
    }

    public final void b() {
        for (com.anythink.expressad.exoplayer.a.a.c cVar : new java.util.ArrayList(this.d.a)) {
            b(cVar.a, cVar.b);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
        this.d.b(i, aVar);
        com.anythink.expressad.exoplayer.a.b.a d = d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void b(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        com.anythink.expressad.exoplayer.a.b.a d = d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(d, cVar);
        }
    }

    public final void b(com.anythink.expressad.exoplayer.a.b bVar) {
        this.a.remove(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.l.h
    public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
        com.anythink.expressad.exoplayer.a.b.a h = h();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(h, 2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void b(com.anythink.expressad.exoplayer.m mVar) {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j, 1, mVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void b(java.lang.String str, long j, long j2) {
        com.anythink.expressad.exoplayer.a.b.a j3 = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(j3, 1, str);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.d.a
    public final void c() {
        a(this.d.d());
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void c(int i, com.anythink.expressad.exoplayer.h.s.a aVar) {
        this.d.c(i, aVar);
        com.anythink.expressad.exoplayer.a.b.a d = d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(d);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.t
    public final void c(int i, @androidx.annotation.Nullable com.anythink.expressad.exoplayer.h.s.a aVar, com.anythink.expressad.exoplayer.h.t.b bVar, com.anythink.expressad.exoplayer.h.t.c cVar) {
        d(i, aVar);
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void c(com.anythink.expressad.exoplayer.c.d dVar) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(i, 1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void d() {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.b.g
    public final void d(com.anythink.expressad.exoplayer.c.d dVar) {
        com.anythink.expressad.exoplayer.a.b.a h = h();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(h, 1);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void e() {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().g(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.d.c
    public final void f() {
        com.anythink.expressad.exoplayer.a.b.a j = j();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().h(j);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onLoadingChanged(boolean z) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(i, z);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlaybackParametersChanged(com.anythink.expressad.exoplayer.v vVar) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i, vVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i, gVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPlayerStateChanged(boolean z, int i) {
        com.anythink.expressad.exoplayer.a.b.a i2 = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i2, z, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onPositionDiscontinuity(int i) {
        this.d.f();
        com.anythink.expressad.exoplayer.a.b.a i2 = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(i2, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onRepeatModeChanged(int i) {
        com.anythink.expressad.exoplayer.a.b.a i2 = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(i2, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onSeekProcessed() {
        if (this.d.e()) {
            this.d.h();
            com.anythink.expressad.exoplayer.a.b.a i = i();
            java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onShuffleModeEnabledChanged(boolean z) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i, z);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onTimelineChanged(com.anythink.expressad.exoplayer.ae aeVar, @androidx.annotation.Nullable java.lang.Object obj, int i) {
        this.d.a(aeVar);
        com.anythink.expressad.exoplayer.a.b.a i2 = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i2, i);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.c
    public final void onTracksChanged(com.anythink.expressad.exoplayer.h.af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
        com.anythink.expressad.exoplayer.a.b.a i = i();
        java.util.Iterator<com.anythink.expressad.exoplayer.a.b> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(i, gVar);
        }
    }
}
