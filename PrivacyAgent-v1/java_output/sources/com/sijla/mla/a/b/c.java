package com.sijla.mla.a.b;

/* loaded from: classes19.dex */
public final class c extends com.sijla.mla.a.b.s {
    com.sijla.mla.a.b a;

    public final class a extends com.sijla.mla.a.b.j {
        public a() {
        }

        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return new com.sijla.mla.a.p(com.sijla.mla.a.b.c.this.a, rVar.F());
        }
    }

    public final class b extends com.sijla.mla.a.b.t {
        public b() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            return yVar.ad().c(yVar.b_(2));
        }
    }

    /* renamed from: com.sijla.mla.a.b.c$c, reason: collision with other inner class name */
    public final class C0460c extends com.sijla.mla.a.b.t {
        public C0460c() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.p pVar = com.sijla.mla.a.b.c.this.a.d;
            return com.sijla.mla.a.r.a((com.sijla.mla.a.r) pVar, (com.sijla.mla.a.y) com.sijla.mla.a.r.a(pVar.T()));
        }
    }

    public static final class d extends com.sijla.mla.a.b.j {
        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return com.sijla.mla.a.n.c(com.sijla.mla.a.p.d[rVar.S().e.j]);
        }
    }

    public final class e extends com.sijla.mla.a.b.j {
        public e() {
        }

        @Override // com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar) {
            return com.sijla.mla.a.b.c.this.new f(new com.sijla.mla.a.p(com.sijla.mla.a.b.c.this.a, rVar.F()));
        }
    }

    public final class f extends com.sijla.mla.a.b.t {
        private com.sijla.mla.a.p a;

        public f(com.sijla.mla.a.p pVar) {
            this.a = pVar;
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.y c = this.a.c(yVar);
            return c.h().f() ? c.b_(2) : com.sijla.mla.a.r.d(c.c(2).g());
        }
    }

    public final class g extends com.sijla.mla.a.b.t {
        public g() {
        }

        @Override // com.sijla.mla.a.b.t, com.sijla.mla.a.b.j, com.sijla.mla.a.r
        public final com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            com.sijla.mla.a.b bVar = com.sijla.mla.a.b.c.this.a;
            com.sijla.mla.a.p pVar = bVar.d;
            if (pVar == null || pVar.T()) {
                throw new com.sijla.mla.a.i("cannot yield main thread");
            }
            return bVar.d.e.a(yVar);
        }
    }

    @Override // com.sijla.mla.a.b.s, com.sijla.mla.a.b.j, com.sijla.mla.a.r
    public final com.sijla.mla.a.r b(com.sijla.mla.a.r rVar, com.sijla.mla.a.r rVar2) {
        this.a = rVar2.a();
        com.sijla.mla.a.o oVar = new com.sijla.mla.a.o();
        oVar.a(com.sijla.mla.L2.s154563652(), new com.sijla.mla.a.b.c.a());
        oVar.a(com.sijla.mla.L2.s223556403(), new com.sijla.mla.a.b.c.b());
        oVar.a(com.sijla.mla.L2.s494247835(), new com.sijla.mla.a.b.c.C0460c());
        oVar.a(com.sijla.mla.L2.s1523852302(), new com.sijla.mla.a.b.c.d());
        oVar.a(com.sijla.mla.L2.s620400425(), new com.sijla.mla.a.b.c.g());
        oVar.a(com.sijla.mla.L2.s1086783030(), new com.sijla.mla.a.b.c.e());
        rVar2.a(com.sijla.mla.L2.s2000202260(), oVar);
        rVar2.g(com.sijla.mla.L2.s573041986()).g(com.sijla.mla.L2.s537344421()).a(com.sijla.mla.L2.s2000202260(), oVar);
        return oVar;
    }
}
