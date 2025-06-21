package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class z implements com.sijla.mla.a.s {
    private boolean a;
    private boolean b;
    private com.sijla.mla.a.r c;

    public static class a extends com.sijla.mla.a.z.c {
        private final int c;

        public a(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            super(com.sijla.mla.a.z.a(rVar), com.sijla.mla.a.z.a(rVar2), null);
            this.c = rVar.hashCode();
        }

        private a(com.sijla.mla.a.z.a aVar, com.sijla.mla.a.o.g gVar) {
            super(aVar.a, aVar.b, gVar);
            this.c = aVar.c;
        }

        @Override // com.sijla.mla.a.o.g
        public final int a(int i) {
            return com.sijla.mla.a.o.a(this.c, i);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.o.g c(com.sijla.mla.a.r rVar) {
            this.b = com.sijla.mla.a.z.a(rVar);
            return this;
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.r c() {
            return com.sijla.mla.a.z.a(this.a);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.z.c c(com.sijla.mla.a.o.g gVar) {
            return new com.sijla.mla.a.z.a(this, gVar);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.r d() {
            return com.sijla.mla.a.z.a(this.b);
        }
    }

    public static class b extends com.sijla.mla.a.z.c {
        private final int c;

        public b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            super(com.sijla.mla.a.z.a(rVar), rVar2, null);
            this.c = rVar.hashCode();
        }

        private b(com.sijla.mla.a.z.b bVar, com.sijla.mla.a.o.g gVar) {
            super(bVar.a, bVar.b, gVar);
            this.c = bVar.c;
        }

        @Override // com.sijla.mla.a.o.g
        public final int a(int i) {
            return com.sijla.mla.a.o.a(this.c, i);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.o.g c(com.sijla.mla.a.r rVar) {
            this.b = rVar;
            return this;
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.r c() {
            return com.sijla.mla.a.z.a(this.a);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.z.c c(com.sijla.mla.a.o.g gVar) {
            return new com.sijla.mla.a.z.b(this, gVar);
        }
    }

    public static abstract class c implements com.sijla.mla.a.o.g {
        protected java.lang.Object a;
        protected java.lang.Object b;
        private com.sijla.mla.a.o.g c;

        public c(java.lang.Object obj, java.lang.Object obj2, com.sijla.mla.a.o.g gVar) {
            this.a = obj;
            this.b = obj2;
            this.c = gVar;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.g gVar) {
            com.sijla.mla.a.o.g gVar2 = this.c;
            if (gVar2 != null) {
                gVar = gVar2.a(gVar);
            }
            this.c = gVar;
            return (c() == null || d() == null) ? this.c : this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar) {
            com.sijla.mla.a.r c = c();
            if (c == null) {
                return this.c.a(hVar);
            }
            if (hVar.b(c)) {
                this.b = null;
                return this;
            }
            this.c = this.c.a(hVar);
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g a(com.sijla.mla.a.o.h hVar, com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.r c = c();
            if (c != null && hVar.a(c) != null) {
                return c(rVar);
            }
            if (c == null) {
                return this.c.a(hVar, rVar);
            }
            this.c = this.c.a(hVar, rVar);
            return this;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a() {
            com.sijla.mla.a.r c = c();
            com.sijla.mla.a.r d = d();
            if (c != null && d != null) {
                return new com.sijla.mla.a.o.e(c, d);
            }
            this.a = null;
            this.b = null;
            return null;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.h a(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.o.h a = a();
            if (a != null) {
                return a.a(rVar);
            }
            return null;
        }

        @Override // com.sijla.mla.a.o.g
        public final int b(int i) {
            return 0;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g b(com.sijla.mla.a.o.g gVar) {
            return (c() == null || d() == null) ? gVar : (gVar == null && this.c == null) ? this : c(gVar);
        }

        @Override // com.sijla.mla.a.o.g
        public final boolean b(com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.o.h a = a();
            return a != null && a.b(rVar);
        }

        public abstract com.sijla.mla.a.o.g c(com.sijla.mla.a.r rVar);

        public com.sijla.mla.a.r c() {
            return (com.sijla.mla.a.r) this.a;
        }

        public abstract com.sijla.mla.a.z.c c(com.sijla.mla.a.o.g gVar);

        public com.sijla.mla.a.r d() {
            return (com.sijla.mla.a.r) this.b;
        }

        @Override // com.sijla.mla.a.o.g
        public final com.sijla.mla.a.o.g l_() {
            return this.c;
        }
    }

    public static final class d extends com.sijla.mla.a.z.e {
        private final java.lang.ref.WeakReference b;
        private final com.sijla.mla.a.r c;

        private d(com.sijla.mla.a.r rVar) {
            super(rVar);
            this.b = new java.lang.ref.WeakReference(rVar.U());
            this.c = rVar.j();
        }

        public /* synthetic */ d(com.sijla.mla.a.r rVar, byte b) {
            this(rVar);
        }

        @Override // com.sijla.mla.a.z.e, com.sijla.mla.a.r
        public final com.sijla.mla.a.r X() {
            java.lang.Object obj = this.a.get();
            if (obj != null) {
                return (com.sijla.mla.a.r) obj;
            }
            java.lang.Object obj2 = this.b.get();
            if (obj2 == null) {
                return null;
            }
            com.sijla.mla.a.q qVar = new com.sijla.mla.a.q(obj2, this.c);
            this.a = new java.lang.ref.WeakReference(qVar);
            return qVar;
        }
    }

    public static class e extends com.sijla.mla.a.r {
        java.lang.ref.WeakReference a;

        public e(com.sijla.mla.a.r rVar) {
            this.a = new java.lang.ref.WeakReference(rVar);
        }

        @Override // com.sijla.mla.a.r
        public com.sijla.mla.a.r X() {
            return (com.sijla.mla.a.r) this.a.get();
        }

        @Override // com.sijla.mla.a.r
        public final int a_() {
            com.sijla.mla.a.r.a(com.sijla.mla.L2.s1084235078(), "weak value");
            return 0;
        }

        @Override // com.sijla.mla.a.r
        public final java.lang.String c() {
            com.sijla.mla.a.r.a(com.sijla.mla.L2.s1853832677(), "weak value");
            return null;
        }

        @Override // com.sijla.mla.a.r
        public final boolean d(com.sijla.mla.a.r rVar) {
            java.lang.Object obj = this.a.get();
            return obj != null && rVar.d((com.sijla.mla.a.r) obj);
        }

        @Override // com.sijla.mla.a.r, com.sijla.mla.a.y
        public java.lang.String toString() {
            return "weak<" + this.a.get() + ">";
        }
    }

    public static class f extends com.sijla.mla.a.z.c {
        public f(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
            super(rVar, com.sijla.mla.a.z.a(rVar2), null);
        }

        private f(com.sijla.mla.a.z.f fVar, com.sijla.mla.a.o.g gVar) {
            super(fVar.a, fVar.b, gVar);
        }

        @Override // com.sijla.mla.a.o.g
        public final int a(int i) {
            return com.sijla.mla.a.o.a(c(), i);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.o.g c(com.sijla.mla.a.r rVar) {
            this.b = com.sijla.mla.a.z.a(rVar);
            return this;
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.z.c c(com.sijla.mla.a.o.g gVar) {
            return new com.sijla.mla.a.z.f(this, gVar);
        }

        @Override // com.sijla.mla.a.z.c
        public final com.sijla.mla.a.r d() {
            return com.sijla.mla.a.z.a(this.b);
        }
    }

    public z(boolean z, boolean z2, com.sijla.mla.a.r rVar) {
        this.a = z;
        this.b = z2;
        this.c = rVar;
    }

    public static com.sijla.mla.a.r a(com.sijla.mla.a.r rVar) {
        int a_ = rVar.a_();
        if (a_ != 5 && a_ != 6) {
            if (a_ == 7) {
                return new com.sijla.mla.a.z.d(rVar, (byte) 0);
            }
            if (a_ != 8) {
                return rVar;
            }
        }
        return new com.sijla.mla.a.z.e(rVar);
    }

    public static com.sijla.mla.a.r a(java.lang.Object obj) {
        if (obj instanceof java.lang.ref.WeakReference) {
            obj = ((java.lang.ref.WeakReference) obj).get();
        }
        return obj instanceof com.sijla.mla.a.z.e ? ((com.sijla.mla.a.z.e) obj).X() : (com.sijla.mla.a.r) obj;
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.r a(com.sijla.mla.a.r[] rVarArr, int i) {
        com.sijla.mla.a.r rVar = rVarArr[i];
        if (rVar != null && (rVar = a((java.lang.Object) rVar)) == null) {
            rVarArr[i] = null;
        }
        return rVar;
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.o.g d(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        com.sijla.mla.a.r X = rVar2.X();
        if (X == null) {
            return null;
        }
        return (!this.a || rVar.u() || rVar.v() || rVar.d()) ? (!this.b || X.u() || X.v() || X.d()) ? com.sijla.mla.a.o.e(rVar, X) : new com.sijla.mla.a.z.f(rVar, X) : (!this.b || X.u() || X.v() || X.d()) ? new com.sijla.mla.a.z.b(rVar, X) : new com.sijla.mla.a.z.a(rVar, X);
    }

    @Override // com.sijla.mla.a.s
    public final boolean i_() {
        return this.a;
    }

    @Override // com.sijla.mla.a.s
    public final boolean j_() {
        return this.b;
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.r k_() {
        return this.c;
    }

    @Override // com.sijla.mla.a.s
    public final com.sijla.mla.a.r v(com.sijla.mla.a.r rVar) {
        return this.b ? a(rVar) : rVar;
    }
}
