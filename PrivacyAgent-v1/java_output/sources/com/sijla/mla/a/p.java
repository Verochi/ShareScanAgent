package com.sijla.mla.a;

/* loaded from: classes19.dex */
public final class p extends com.sijla.mla.a.r {
    public static com.sijla.mla.a.r a = null;
    public static int b = 0;
    public static long c = 5000;
    public static final java.lang.String[] d = {com.sijla.mla.L2.s937694391(), com.sijla.mla.L2.s937694391(), com.sijla.mla.L2.s494247835(), com.sijla.mla.L2.s1253627321(), com.sijla.mla.L2.s1068848476()};
    public final com.sijla.mla.a.p.a e;
    public java.lang.Object f;
    public com.sijla.mla.a.r g;
    private com.sijla.mla.a.b h;

    public static class a implements java.lang.Runnable {
        public final com.sijla.mla.a.r a;
        public com.sijla.mla.a.r b;
        public boolean c;
        public boolean d;
        public boolean e;
        public int f;
        public boolean g;
        public int h;
        public int i;
        public int j;
        private final com.sijla.mla.a.b k;
        private java.lang.ref.WeakReference l;
        private com.sijla.mla.a.y m;
        private com.sijla.mla.a.y n;
        private java.lang.String o;

        public a(com.sijla.mla.a.b bVar, com.sijla.mla.a.p pVar, com.sijla.mla.a.r rVar) {
            com.sijla.mla.a.r rVar2 = com.sijla.mla.a.r.n;
            this.m = rVar2;
            this.n = rVar2;
            this.o = null;
            this.j = 0;
            this.k = bVar;
            this.l = new java.lang.ref.WeakReference(pVar);
            this.a = rVar;
        }

        public final synchronized com.sijla.mla.a.y a(com.sijla.mla.a.p pVar, com.sijla.mla.a.y yVar) {
            java.lang.String str;
            com.sijla.mla.a.b bVar = this.k;
            com.sijla.mla.a.p pVar2 = bVar.d;
            try {
                try {
                    bVar.d = pVar;
                    this.m = yVar;
                    if (this.j == 0) {
                        this.j = 2;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(com.sijla.mla.L2.s208858901());
                        int i = com.sijla.mla.a.p.b + 1;
                        com.sijla.mla.a.p.b = i;
                        sb.append(i);
                        new java.lang.Thread(this, sb.toString()).start();
                    } else {
                        notify();
                    }
                    if (pVar2 != null) {
                        pVar2.e.j = 3;
                    }
                    this.j = 2;
                    wait();
                    str = this.o;
                } catch (java.lang.InterruptedException unused) {
                    throw new com.sijla.mla.a.u();
                }
            } finally {
                com.sijla.mla.a.r rVar = com.sijla.mla.a.r.n;
                this.m = rVar;
                this.n = rVar;
                this.o = null;
                this.k.d = pVar2;
                if (pVar2 != null) {
                    pVar2.e.j = 2;
                }
            }
            return str != null ? com.sijla.mla.a.r.a((com.sijla.mla.a.r) com.sijla.mla.a.r.m, (com.sijla.mla.a.y) com.sijla.mla.a.r.h(str)) : com.sijla.mla.a.r.a(com.sijla.mla.a.r.l, this.n);
        }

        public final synchronized com.sijla.mla.a.y a(com.sijla.mla.a.y yVar) {
            try {
                try {
                    this.n = yVar;
                    this.j = 1;
                    notify();
                    do {
                        wait(com.sijla.mla.a.p.c);
                        if (this.l.get() == null) {
                            this.j = 4;
                            throw new com.sijla.mla.a.u();
                        }
                    } while (this.j == 1);
                } catch (java.lang.InterruptedException unused) {
                    this.j = 4;
                    throw new com.sijla.mla.a.u();
                }
            } finally {
                com.sijla.mla.a.r rVar = com.sijla.mla.a.r.n;
                this.m = rVar;
                this.n = rVar;
            }
            return this.m;
        }

        @Override // java.lang.Runnable
        public final synchronized void run() {
            try {
                com.sijla.mla.a.y yVar = this.m;
                this.m = com.sijla.mla.a.r.n;
                this.n = this.a.a(yVar);
            } catch (java.lang.Throwable th) {
                try {
                    this.o = th.getMessage();
                } finally {
                    this.j = 4;
                    notify();
                }
            }
        }
    }

    public p(com.sijla.mla.a.b bVar) {
        com.sijla.mla.a.p.a aVar = new com.sijla.mla.a.p.a(bVar, this, null);
        this.e = aVar;
        aVar.j = 2;
        this.h = bVar;
    }

    public p(com.sijla.mla.a.b bVar, com.sijla.mla.a.r rVar) {
        if (!(rVar != null)) {
            throw new com.sijla.mla.a.i("function cannot be null");
        }
        this.e = new com.sijla.mla.a.p.a(bVar, this, rVar);
        this.h = bVar;
    }

    @Override // com.sijla.mla.a.r
    public final boolean R() {
        return true;
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.p S() {
        return this;
    }

    public final boolean T() {
        return this.e.a == null;
    }

    @Override // com.sijla.mla.a.r
    public final int a_() {
        return 8;
    }

    public final com.sijla.mla.a.y c(com.sijla.mla.a.y yVar) {
        com.sijla.mla.a.p.a aVar = this.e;
        if (aVar.j <= 1) {
            return aVar.a(this, yVar);
        }
        com.sijla.mla.a.f fVar = com.sijla.mla.a.r.m;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("cannot resume ");
        sb.append(aVar.j == 4 ? com.sijla.mla.L2.s1068848476() : com.sijla.mla.L2.s477808311());
        sb.append(" coroutine");
        return com.sijla.mla.a.r.a((com.sijla.mla.a.r) fVar, (com.sijla.mla.a.y) com.sijla.mla.a.n.c(sb.toString()));
    }

    @Override // com.sijla.mla.a.r
    public final java.lang.String c() {
        return com.sijla.mla.L2.s2083039478();
    }

    @Override // com.sijla.mla.a.r
    public final com.sijla.mla.a.r j() {
        return a;
    }
}
