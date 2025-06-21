package com.anythink.core.common;

/* loaded from: classes12.dex */
public class g {
    protected com.anythink.core.common.m.b E;
    com.anythink.core.common.p.f G;
    com.anythink.core.common.a.b.a H;
    com.anythink.core.common.f.au K;
    double L;
    com.anythink.core.common.f.au N;
    protected java.lang.ref.WeakReference<android.content.Context> b;
    protected int c;
    protected com.anythink.core.common.f.az e;
    protected java.lang.String f;
    protected java.lang.String g;
    java.util.Map<java.lang.String, java.lang.Object> h;
    com.anythink.core.common.f.h i;
    protected com.anythink.core.common.f.v j;
    protected com.anythink.core.common.b.c k;
    boolean o;
    boolean p;

    /* renamed from: s, reason: collision with root package name */
    java.lang.String f176s;
    long u;
    int v;
    int w;
    boolean z;
    private final java.lang.String P = getClass().getSimpleName();
    protected java.lang.String d = "";
    boolean l = false;
    boolean m = false;
    protected boolean n = false;
    boolean q = false;
    boolean r = false;
    java.lang.Object x = new java.lang.Object();
    double y = -1.0d;
    double A = -1.0d;
    protected com.anythink.core.common.m.b D = null;
    protected com.anythink.core.common.m.b J = new com.anythink.core.common.g.AnonymousClass1();
    boolean M = false;
    boolean O = false;
    protected android.content.Context a = com.anythink.core.common.b.o.a().f();
    com.anythink.core.api.AdError t = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", "");
    protected java.util.Map<java.lang.String, com.anythink.core.common.p.d> B = new java.util.concurrent.ConcurrentHashMap();
    java.util.List<com.anythink.core.common.f.au> C = java.util.Collections.synchronizedList(new java.util.ArrayList(3));
    com.anythink.core.common.p.i F = new com.anythink.core.common.p.i();
    java.util.List<com.anythink.core.api.ATBaseAdAdapter> I = new java.util.ArrayList();

    /* renamed from: com.anythink.core.common.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {

        /* renamed from: com.anythink.core.common.g$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01651 implements java.lang.Runnable {
            public RunnableC01651() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.g.this.a();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.b.b.a().c(new com.anythink.core.common.g.AnonymousClass1.RunnableC01651());
        }
    }

    /* renamed from: com.anythink.core.common.g$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.m.b {

        /* renamed from: com.anythink.core.common.g$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.g.this.j();
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.g.this.D = null;
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.g.AnonymousClass2.AnonymousClass1(), 2, true);
        }
    }

    /* renamed from: com.anythink.core.common.g$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.m.b {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.g.this.p();
        }
    }

    /* renamed from: com.anythink.core.common.g$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.f.au b;
        final /* synthetic */ int c;
        final /* synthetic */ com.anythink.core.common.p.d d;

        public AnonymousClass4(java.lang.String str, com.anythink.core.common.f.au auVar, int i, com.anythink.core.common.p.d dVar) {
            this.a = str;
            this.b = auVar;
            this.c = i;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            synchronized (com.anythink.core.common.g.this) {
                if (com.anythink.core.common.g.this.F.b()) {
                    com.anythink.core.common.g.this.B.remove(this.a);
                    return;
                }
                if (com.anythink.core.common.o.v.a(this.b) && android.text.TextUtils.isEmpty(com.anythink.core.common.u.a().a(com.anythink.core.common.g.this.g, this.b.d()))) {
                    com.anythink.core.common.u.a().a(com.anythink.core.common.g.this.g, this.b.d(), this.b.h());
                }
                boolean b = com.anythink.core.common.g.b(this.c);
                com.anythink.core.common.f.h S = com.anythink.core.common.g.this.i.S();
                if (b) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(this.b.d());
                    str = sb.toString();
                } else {
                    str = com.anythink.core.common.g.this.f176s;
                }
                S.m(str);
                com.anythink.core.common.o.u.a(S, this.b, com.anythink.core.common.g.this.v, true);
                S.a(android.os.SystemClock.elapsedRealtime() - com.anythink.core.common.g.this.u);
                if (com.anythink.core.common.g.this.a(S, this.b, this.c, this.a)) {
                    return;
                }
                java.lang.String unused = com.anythink.core.common.g.this.P;
                this.b.toString();
                boolean a = com.anythink.core.common.p.f.a(com.anythink.core.common.g.this.g, this.b, S);
                com.anythink.core.common.g.this.v++;
                if (a) {
                    com.anythink.core.common.p.a aVar = new com.anythink.core.common.p.a();
                    aVar.a = 6;
                    aVar.b = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", "Bid result has expired.");
                    aVar.c = 0L;
                    aVar.d = S;
                    aVar.e = this.b;
                    com.anythink.core.common.g.this.a(this.a, aVar);
                    return;
                }
                if (this.b.k()) {
                    com.anythink.core.common.g.this.d(this.b);
                }
                int aa = this.b.aa();
                if (aa > 0) {
                    S.q = aa;
                } else {
                    com.anythink.core.common.g gVar = com.anythink.core.common.g.this;
                    if (gVar.m && gVar.w < gVar.e.h()) {
                        S.q = 5;
                    }
                }
                com.anythink.core.common.g.a(com.anythink.core.common.g.this, this.d, S, this.b);
            }
        }
    }

    /* renamed from: com.anythink.core.common.g$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.core.common.p.b {
        final /* synthetic */ com.anythink.core.common.f.au a;

        public AnonymousClass5(com.anythink.core.common.f.au auVar) {
            this.a = auVar;
        }

        @Override // com.anythink.core.common.p.b
        public final void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.lang.String str) {
            com.anythink.core.common.g.this.a(aTBaseAdAdapter, str);
        }

        @Override // com.anythink.core.common.p.b
        public final void a(com.anythink.core.common.f.h hVar) {
            com.anythink.core.common.n.a.a(com.anythink.core.common.g.this.a).a(1, hVar);
            com.anythink.core.common.o.o.a(hVar, com.anythink.core.common.b.h.m.a, com.anythink.core.common.b.h.m.n, "");
        }

        @Override // com.anythink.core.common.p.b
        public final void a(com.anythink.core.common.f.h hVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            com.anythink.core.common.g.a(com.anythink.core.common.g.this, hVar);
            if (this.a.aC() == 1) {
                com.anythink.core.common.g.a(com.anythink.core.common.g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.p.b
        public final void a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.b bVar) {
            com.anythink.core.common.g.this.a(str, aTBaseAdAdapter, bVar.e(), auVar);
        }

        @Override // com.anythink.core.common.p.b
        public final void a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.p.a aVar) {
            com.anythink.core.common.g.this.a(str, aVar);
            if (aTBaseAdAdapter == null || aTBaseAdAdapter.getUnitGroupInfo() == null) {
                return;
            }
            aTBaseAdAdapter.getUnitGroupInfo();
            if (this.a.aC() == 1) {
                com.anythink.core.common.g.b(com.anythink.core.common.g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.p.b
        public final void a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd... baseAdArr) {
            com.anythink.core.api.IATAdFilter p = com.anythink.core.common.b.o.a().p(com.anythink.core.common.g.this.g);
            com.anythink.core.api.BaseAd baseAd = (baseAdArr == null || baseAdArr.length <= 0) ? null : baseAdArr[0];
            if (p == null || !p.isAdFilter(com.anythink.core.common.b.k.a(aTBaseAdAdapter), baseAd)) {
                com.anythink.core.common.g.this.a(str, aTBaseAdAdapter, baseAdArr != null ? java.util.Arrays.asList(baseAdArr) : null);
            } else {
                com.anythink.core.common.p.a aVar = new com.anythink.core.common.p.a();
                aVar.a = 8;
                aVar.c = aTBaseAdAdapter.getTrackingInfo().P();
                aVar.b = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adSourceNotFilledError, "", "");
                aVar.d = aTBaseAdAdapter.getTrackingInfo();
                aVar.e = aTBaseAdAdapter.getUnitGroupInfo();
                com.anythink.core.common.g.this.a(str, aVar);
            }
            if (this.a.aC() == 1) {
                com.anythink.core.common.g.b(com.anythink.core.common.g.this, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.common.p.b
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.core.common.g.this.a(str);
            if (this.a.aC() == 1) {
                com.anythink.core.common.g.this.G();
            }
        }
    }

    /* renamed from: com.anythink.core.common.g$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.core.common.i.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.core.common.i.a
        public final void a(java.lang.String str) {
        }

        @Override // com.anythink.core.common.i.a
        public final void a(java.lang.String str, java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2, boolean z) {
            for (com.anythink.core.common.f.au auVar : list) {
                com.anythink.core.common.g.this.c(auVar);
                auVar.x(8);
                com.anythink.core.common.g.this.G.a(auVar);
                com.anythink.core.common.g.this.b(auVar, 3);
            }
            if (list2 != null) {
                java.util.Iterator<com.anythink.core.common.f.au> it = list2.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.g.this.b(it.next());
                }
            }
            com.anythink.core.common.g gVar = com.anythink.core.common.g.this;
            gVar.O = false;
            gVar.s();
        }
    }

    /* renamed from: com.anythink.core.common.g$7, reason: invalid class name */
    public class AnonymousClass7 implements com.anythink.core.common.i.a {
        public AnonymousClass7() {
        }

        @Override // com.anythink.core.common.i.a
        public final void a(java.lang.String str) {
        }

        @Override // com.anythink.core.common.i.a
        public final void a(java.lang.String str, java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2, boolean z) {
            if (com.anythink.core.common.g.this.F.c()) {
                java.lang.String unused = com.anythink.core.common.g.this.P;
                for (com.anythink.core.common.f.au auVar : list) {
                    com.anythink.core.common.g.this.G.d(auVar);
                    com.anythink.core.common.p.f.a(auVar, com.anythink.core.common.g.this.i);
                }
                return;
            }
            com.anythink.core.common.g gVar = com.anythink.core.common.g.this;
            if (gVar.w < gVar.e.h()) {
                java.lang.String unused2 = com.anythink.core.common.g.this.P;
                com.anythink.core.common.g.this.a(list, (java.util.List<com.anythink.core.common.f.au>) null, (java.util.List<com.anythink.core.common.f.au>) null);
                com.anythink.core.common.g.this.l();
                return;
            }
            java.lang.String unused3 = com.anythink.core.common.g.this.P;
            double a = com.anythink.core.common.g.this.G.a(false);
            int size = list.size();
            java.util.ArrayList arrayList = new java.util.ArrayList(size);
            java.util.ArrayList arrayList2 = new java.util.ArrayList(size);
            for (int i = 0; i < size; i++) {
                com.anythink.core.common.f.au auVar2 = list.get(i);
                com.anythink.core.common.g.this.G.d(auVar2);
                if (com.anythink.core.common.o.h.a(auVar2) > a) {
                    arrayList.add(auVar2);
                } else {
                    arrayList2.add(auVar2);
                }
            }
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.anythink.core.common.f.au auVar3 = (com.anythink.core.common.f.au) it.next();
                com.anythink.core.common.g.this.c(auVar3);
                auVar3.x(7);
                com.anythink.core.common.g.this.G.a(auVar3);
                com.anythink.core.common.g.this.b(auVar3, 5);
            }
            java.util.Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                com.anythink.core.common.p.f.a((com.anythink.core.common.f.au) it2.next(), com.anythink.core.common.g.this.i);
            }
        }
    }

    /* renamed from: com.anythink.core.common.g$8, reason: invalid class name */
    public class AnonymousClass8 implements com.anythink.core.common.i.a {
        final /* synthetic */ com.anythink.core.common.i.a a;

        public AnonymousClass8(com.anythink.core.common.i.a aVar) {
            this.a = aVar;
        }

        @Override // com.anythink.core.common.i.a
        public final void a(java.lang.String str) {
            com.anythink.core.common.i.a aVar = this.a;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        @Override // com.anythink.core.common.i.a
        public final void a(java.lang.String str, java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2, boolean z) {
            com.anythink.core.common.i.a aVar = this.a;
            if (aVar != null) {
                aVar.a(str, list, list2, z);
            }
        }
    }

    public static class a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
    }

    public g(android.content.Context context) {
        this.b = new java.lang.ref.WeakReference<>(context);
    }

    private void A() {
        com.anythink.core.common.f.b F = F();
        if (F != null) {
            com.anythink.core.common.f.au unitGroupInfo = F.d() != null ? F.d().getUnitGroupInfo() : null;
            a(unitGroupInfo, com.anythink.core.common.o.h.a(unitGroupInfo), true);
            a(9);
        } else {
            if (w()) {
                return;
            }
            z();
        }
    }

    private synchronized boolean B() {
        this.G.c();
        this.G.e();
        this.G.f();
        this.G.k();
        return this.G.v();
    }

    private synchronized boolean C() {
        if (this.G.c() == 0) {
            if (this.G.e() == 0) {
                return true;
            }
        }
        return false;
    }

    private void D() {
        if (this.J != null) {
            com.anythink.core.common.m.d.a().b(this.J);
        }
    }

    private void E() {
        com.anythink.core.d.e a2;
        com.anythink.core.common.o.o.a("Mediation", "placementId:" + this.g + ";result_callback:success;loadType:" + this.j.d + com.alipay.sdk.m.u.i.b);
        com.anythink.core.common.v.a(this.a).a(this.g, this.f, true);
        com.anythink.core.common.f.v vVar = this.j;
        if (vVar != null && vVar.f != null) {
            boolean z = false;
            try {
                com.anythink.core.common.f.az azVar = this.e;
                if (azVar != null && (a2 = azVar.a()) != null) {
                    try {
                        com.anythink.core.common.u a3 = com.anythink.core.common.u.a();
                        java.lang.String str = this.g;
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(this.e.a().ag());
                        if (a3.a(str, sb.toString()) != null) {
                            com.anythink.core.common.f.a(a2, this.i);
                            com.anythink.core.common.f.b(a2, this.i);
                        }
                    } catch (com.anythink.core.common.f.g e) {
                        com.anythink.core.common.f.v vVar2 = this.j;
                        vVar2.f.a(1, vVar2, this.e, e.a);
                        z = true;
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            if (!z) {
                com.anythink.core.common.f.v vVar3 = this.j;
                vVar3.f.a(this.z ? 1 : 2, vVar3, this.e);
            }
            this.j.f = null;
        }
        com.anythink.core.c.b.a().a(this.g, this.f, this.G.b().a());
    }

    private com.anythink.core.common.f.b F() {
        com.anythink.core.common.a.b.a aVar;
        com.anythink.core.common.f.b a2 = com.anythink.core.common.a.a().a(this.a, this.g);
        return (a2 == null && (aVar = this.H) != null) ? aVar.a() : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.I.size() == 0) {
            return;
        }
        synchronized (this.I) {
            java.util.Iterator<com.anythink.core.api.ATBaseAdAdapter> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().destory();
            }
            this.I.clear();
        }
    }

    private void a(int i, java.util.List<com.anythink.core.common.f.au> list, com.anythink.core.common.i.a aVar) {
        boolean z = this.K != null || com.anythink.core.common.o.v.a(this.C);
        com.anythink.core.common.f.a aVar2 = new com.anythink.core.common.f.a();
        aVar2.b = this.a;
        aVar2.c = this.j;
        aVar2.d = this.f;
        aVar2.e = this.g;
        aVar2.f = this.e.a().ag();
        aVar2.g = this.e.l();
        aVar2.h = this.e.m();
        com.anythink.core.common.h.a();
        aVar2.l = com.anythink.core.common.h.a(this.e.a(), z);
        com.anythink.core.common.h.a();
        aVar2.o = com.anythink.core.common.h.a(this.e.a());
        com.anythink.core.common.h.a();
        aVar2.p = com.anythink.core.common.h.b(this.e.a());
        aVar2.j = list;
        aVar2.n = this.e;
        aVar2.f167s = this.i;
        aVar2.q = this.h;
        aVar2.v = this.G.r();
        aVar2.w = this.G.s();
        aVar2.x = this.G.t();
        aVar2.m = z;
        aVar2.t = i;
        aVar2.u = com.anythink.core.common.o.h.a(this.N);
        aVar2.y = this.G.a();
        com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar2);
        bVar.a(com.anythink.core.api.ATSDK.isNetworkLogDebug());
        bVar.a(new com.anythink.core.common.g.AnonymousClass8(aVar));
    }

    private void a(long j) {
        if (this.E != null) {
            com.anythink.core.common.m.d.a().a(this.E, j, false);
        }
    }

    private void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter == null) {
            return;
        }
        synchronized (this.I) {
            this.I.add(aTBaseAdAdapter);
        }
    }

    private void a(com.anythink.core.api.AdError adError) {
        com.anythink.core.common.n nVar;
        com.anythink.core.common.o.o.a("Mediation", "placementId:" + this.g + ";result_callback:fail;loadType:" + this.j.d + com.alipay.sdk.m.u.i.b);
        com.anythink.core.common.v.a(this.a).a(this.g, this.f, false);
        com.anythink.core.common.f.v vVar = this.j;
        if (vVar != null && (nVar = vVar.f) != null) {
            nVar.a(2, vVar, this.e, adError);
            this.j.f = null;
        }
        com.anythink.core.c.b.a().a(this.g, this.f, null);
    }

    private synchronized void a(com.anythink.core.common.f.au auVar) {
        this.G.b(auVar);
    }

    private void a(com.anythink.core.common.f.au auVar, double d, boolean z) {
        if (auVar == null) {
            return;
        }
        d(auVar);
        if (d > this.y) {
            this.y = d;
            if (d != d || !z || !this.z) {
                this.z = !z;
            }
        }
        double a2 = com.anythink.core.common.o.h.a(auVar);
        double d2 = this.A;
        if (d2 == -1.0d || a2 < d2) {
            this.A = a2;
        }
        this.G.e(auVar);
    }

    private synchronized void a(com.anythink.core.common.f.au auVar, int i) {
        this.G.b(auVar, i);
    }

    private void a(com.anythink.core.common.f.h hVar) {
        this.i = hVar;
    }

    private void a(com.anythink.core.common.f.h hVar, com.anythink.core.api.AdError adError) {
        com.anythink.core.common.b.c cVar = this.k;
        if (cVar != null) {
            cVar.b(hVar, adError);
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.g gVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            synchronized (gVar.I) {
                gVar.I.add(aTBaseAdAdapter);
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.g gVar, com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.c cVar = gVar.k;
        if (cVar != null) {
            cVar.c(hVar);
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.g gVar, com.anythink.core.common.p.d dVar, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.p.c cVar = new com.anythink.core.common.p.c();
        cVar.a = gVar.a;
        cVar.b = gVar.b;
        cVar.c = gVar.f;
        cVar.d = gVar.g;
        cVar.e = gVar.e.a();
        cVar.f = gVar.h;
        cVar.g = gVar.v;
        cVar.h = hVar;
        cVar.i = gVar.G.t();
        dVar.a(cVar);
        dVar.a(gVar.new AnonymousClass5(auVar));
        dVar.a(gVar.A);
    }

    private void a(com.anythink.core.common.p.d dVar) {
        boolean d = dVar.d();
        if (d) {
            this.G.a(-1, dVar.e());
        }
        b(dVar);
        s();
        if (this.H != null && this.G.b().a() != this.H.e() && this.y >= this.H.d()) {
            this.H.d();
            this.H.c();
        }
        if (d) {
            if (this.G.o() == 0 && this.G.c() == 0 && (this.q || this.l)) {
                w();
            }
            dVar.e();
            this.G.a(dVar.e());
            a(this.G.b(dVar.e()), dVar.e());
            l();
        }
    }

    private void a(com.anythink.core.common.p.d dVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.h hVar, boolean z, com.anythink.core.api.BaseAd... baseAdArr) {
        hVar.g(aTBaseAdAdapter.getInternalNetworkPlacementId());
        double a2 = dVar.e() != 2 ? com.anythink.core.common.o.h.a(auVar) : 0.0d;
        a(auVar, a2, z);
        com.anythink.core.b.d.b.a(aTBaseAdAdapter, auVar, hVar, baseAdArr);
        this.G.f(auVar);
        double d = this.L;
        if (d <= 0.0d) {
            hVar.f170s = 0;
        } else if (d < a2) {
            hVar.f170s = 2;
        } else {
            hVar.f170s = 1;
        }
        com.anythink.core.common.p.f.a(this.a, this.g, this.f, auVar, null);
    }

    private void a(com.anythink.core.common.p.d dVar, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.p.c cVar = new com.anythink.core.common.p.c();
        cVar.a = this.a;
        cVar.b = this.b;
        cVar.c = this.f;
        cVar.d = this.g;
        cVar.e = this.e.a();
        cVar.f = this.h;
        cVar.g = this.v;
        cVar.h = hVar;
        cVar.i = this.G.t();
        dVar.a(cVar);
        dVar.a(new com.anythink.core.common.g.AnonymousClass5(auVar));
        dVar.a(this.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str) {
        if (this.F.b()) {
            return;
        }
        a(this.B.get(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd baseAd, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.p.d remove = this.B.remove(str);
        if (remove == null) {
            return;
        }
        a(remove, aTBaseAdAdapter, auVar, aTBaseAdAdapter.getTrackingInfo(), true, baseAd);
        auVar.toString();
        a(auVar);
        u();
        c(aTBaseAdAdapter.getTrackingInfo());
        auVar.u();
        a(remove);
    }

    private synchronized void a(java.util.List<com.anythink.core.common.f.au> list, int i) {
        if (!this.F.b() && !this.F.c() && list != null && list.size() != 0) {
            this.G.a(list);
            this.G.e();
            java.util.Iterator<com.anythink.core.common.f.au> it = list.iterator();
            while (it.hasNext()) {
                b(it.next(), i);
            }
        }
    }

    private void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.h = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(com.anythink.core.common.f.h hVar, com.anythink.core.common.f.au auVar, int i, java.lang.String str) {
        com.anythink.core.common.f.e c = com.anythink.core.common.u.a().c(this.g);
        if (c == null || !c.a(auVar)) {
            return false;
        }
        com.anythink.core.common.o.o.a(this.g, hVar, "Can't Load On Showing", auVar, -1, -1);
        com.anythink.core.common.n.c.a(hVar, 7, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.loadInShowingFilter, "", "Can't Load On Showing"));
        com.anythink.core.common.u.a().a(this.g, c.a(), this.f);
        this.G.a(auVar, i);
        a(auVar);
        this.G.a(i);
        this.B.remove(str);
        this.G.a(-1, i);
        a(this.G.b(i), i);
        return true;
    }

    private void b(long j) {
        com.anythink.core.common.m.d.a().a(this.J, j, false);
    }

    private void b(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter == null) {
            return;
        }
        synchronized (this.I) {
            this.I.remove(aTBaseAdAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.core.common.f.au auVar) {
        this.t.putNetworkErrorMsg(auVar.u(), auVar.d(), auVar.e(), com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, "", auVar.A()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.core.common.f.au auVar, int i) {
        com.anythink.core.common.p.d dVar = new com.anythink.core.common.p.d(auVar, i);
        java.lang.String a2 = dVar.a();
        this.B.put(a2, dVar);
        this.G.a(1, i);
        com.anythink.core.common.o.b.b.a().c(new com.anythink.core.common.g.AnonymousClass4(a2, auVar, i, dVar));
    }

    private void b(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.c cVar = this.k;
        if (cVar != null) {
            cVar.c(hVar);
        }
    }

    public static /* synthetic */ void b(com.anythink.core.common.g gVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (aTBaseAdAdapter != null) {
            synchronized (gVar.I) {
                gVar.I.remove(aTBaseAdAdapter);
            }
        }
    }

    private void b(com.anythink.core.common.p.d dVar) {
        if (dVar.c() == null || !dVar.c().booleanValue() || dVar.e() == 2 || !dVar.c().booleanValue()) {
            return;
        }
        this.w++;
    }

    public static /* synthetic */ boolean b(int i) {
        return i == 3 || i == 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.anythink.core.common.f.au auVar) {
        this.G.c(auVar);
        com.anythink.core.common.p.f.a(this.a, this.g, this.f, null, auVar);
        this.G.d(auVar);
    }

    private void c(com.anythink.core.common.f.h hVar) {
        com.anythink.core.common.b.c cVar = this.k;
        if (cVar != null) {
            cVar.d(hVar);
        }
    }

    private static boolean c(int i) {
        return i == 3 || i == 5;
    }

    private synchronized void d(int i) {
        if ((i != 2 ? this.G.p() : this.G.q()) == 0) {
            a(this.G.b(i), i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.anythink.core.common.f.au auVar) {
        if (auVar != null && com.anythink.core.common.p.f.h(auVar) > com.anythink.core.common.o.h.a(this.N)) {
            this.N = auVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void j() {
        com.anythink.core.common.f.b F = F();
        this.r = true;
        if (this.n || F == null) {
            return;
        }
        com.anythink.core.common.f.au unitGroupInfo = F.d() != null ? F.d().getUnitGroupInfo() : null;
        a(unitGroupInfo, com.anythink.core.common.o.h.a(unitGroupInfo), true);
        a(9);
    }

    private synchronized void k() {
        if (this.o) {
            this.G.b(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        double a2 = this.G.a(false);
        double t = t();
        this.G.o();
        int i = this.w;
        this.e.h();
        this.F.c();
        this.F.b();
        if ((this.l && this.w >= this.e.h() && a2 >= t) || this.F.c() || this.F.b()) {
            this.o = true;
            k();
            if (this.G.o() == 0) {
                com.anythink.core.common.p.f.a(this.a, this.g);
                com.anythink.core.common.p.f.a(this.g);
                r();
            }
        }
        q();
        if (this.o || B()) {
            r();
        }
    }

    private void m() {
        if (this.H != null) {
            com.anythink.core.common.f.h S = this.i.S();
            com.anythink.core.common.o.u.a(S, this.H.e(), 0, true);
            this.H.a(this.f, S);
        }
    }

    private void n() {
        if (this.e.j() >= 0) {
            this.D = new com.anythink.core.common.g.AnonymousClass2();
            this.e.j();
            com.anythink.core.common.m.d.a().a(this.D, this.e.j(), false);
        }
    }

    private com.anythink.core.common.m.b o() {
        return new com.anythink.core.common.g.AnonymousClass3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        if (!this.n && this.G.f() > 0) {
            this.E = null;
            com.anythink.core.common.f.au g = this.G.g();
            g.toString();
            this.G.a(g);
            this.G.f();
            this.G.q();
            b(g, 2);
        }
    }

    private synchronized void q() {
        com.anythink.core.common.f.q M;
        if (!this.F.g() && this.F.e()) {
            if (this.F.b()) {
                return;
            }
            com.anythink.core.common.f.au b = this.G.b(this.l);
            if (b != null && (M = b.M()) != null) {
                this.F.h();
                b.toString();
                com.anythink.core.b.d.b.a(M, b);
            }
            return;
        }
        this.F.g();
        this.F.e();
    }

    private synchronized void r() {
        if (!this.F.e()) {
            this.F.e();
        } else {
            if (this.F.b()) {
                return;
            }
            this.G.a(this.i.S());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s() {
        boolean z;
        double t = t();
        double d = this.y;
        if (d >= 0.0d) {
            if (((this.l || this.q) && d >= t) || this.r) {
                if (!this.n) {
                    a(-1);
                }
                x();
            }
        } else if (this.l) {
            if (this.E == null || !C()) {
                z = false;
            } else {
                com.anythink.core.common.m.d.a().b(this.E);
                this.E.run();
                this.E = null;
                z = true;
            }
            if (z) {
                return;
            }
            if (B() && !this.n) {
                A();
            }
        }
    }

    private double t() {
        com.anythink.core.common.f.au auVar;
        if (this.e.k() == 2) {
            synchronized (this.B) {
                auVar = com.anythink.core.common.p.f.a(this.B);
            }
        } else {
            auVar = null;
        }
        return java.lang.Math.max(java.lang.Math.max(com.anythink.core.common.o.h.a(this.G.d()), com.anythink.core.common.o.h.a(this.G.j())), com.anythink.core.common.o.h.a(auVar));
    }

    private synchronized void u() {
        this.G.i();
        if (this.E != null) {
            com.anythink.core.common.m.d.a().b(this.E);
            this.E = null;
        }
    }

    private void v() {
        w();
        if (this.M) {
            return;
        }
        E();
    }

    private synchronized boolean w() {
        if (this.G.m()) {
            return false;
        }
        if (this.F.c()) {
            return false;
        }
        this.F.f();
        this.O = true;
        a(8, this.G.n(), new com.anythink.core.common.g.AnonymousClass6());
        return true;
    }

    private synchronized void x() {
        if (this.l) {
            if (this.F.c()) {
                return;
            }
            java.util.List<com.anythink.core.common.f.au> list = this.C;
            if (list != null && list.size() != 0) {
                if (this.p) {
                    return;
                }
                this.p = true;
                a(7, this.C, new com.anythink.core.common.g.AnonymousClass7());
            }
        }
    }

    private boolean y() {
        if (this.E == null || !C()) {
            return false;
        }
        com.anythink.core.common.m.d.a().b(this.E);
        this.E.run();
        this.E = null;
        return true;
    }

    private void z() {
        com.anythink.core.common.n nVar;
        this.n = true;
        this.m = false;
        if (this.J != null) {
            com.anythink.core.common.m.d.a().b(this.J);
        }
        com.anythink.core.common.n.c.a(this.i.S(), this.t);
        if (!this.M) {
            com.anythink.core.api.AdError adError = this.t;
            com.anythink.core.common.o.o.a("Mediation", "placementId:" + this.g + ";result_callback:fail;loadType:" + this.j.d + com.alipay.sdk.m.u.i.b);
            com.anythink.core.common.v.a(this.a).a(this.g, this.f, false);
            com.anythink.core.common.f.v vVar = this.j;
            if (vVar != null && (nVar = vVar.f) != null) {
                nVar.a(2, vVar, this.e, adError);
                this.j.f = null;
            }
            com.anythink.core.c.b.a().a(this.g, this.f, null);
        }
        f();
    }

    public final synchronized void a() {
        java.util.concurrent.ConcurrentHashMap concurrentHashMap;
        this.F.a();
        synchronized (this.B) {
            concurrentHashMap = new java.util.concurrent.ConcurrentHashMap(this.B);
        }
        java.util.Iterator it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.core.common.p.d dVar = (com.anythink.core.common.p.d) ((java.util.Map.Entry) it.next()).getValue();
            if (dVar != null) {
                dVar.b();
            }
        }
        if (!this.n) {
            this.n = true;
            A();
        }
        l();
    }

    public final synchronized void a(double d, com.anythink.core.common.f.au auVar) {
        G();
        if (!this.F.g() && auVar != null && auVar.k()) {
            this.F.h();
        }
        if (d > this.L) {
            this.L = d;
        }
        int ag = this.e.a().ag();
        if (ag == 0 || ag == 2) {
            return;
        }
        this.F.d();
        com.anythink.core.common.u a2 = com.anythink.core.common.u.a();
        java.lang.String str = this.g;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.e.a().ag());
        com.anythink.core.common.f a3 = a2.a(str, sb.toString());
        if (a3 != null) {
            a3.a(this.f);
        } else {
            com.anythink.core.common.n.c.a("AdManage is null--notifyimpression", "Id:" + this.g + "--format:" + this.e.a().ag(), com.anythink.core.common.b.o.a().q());
        }
        if (!this.n) {
            a(10);
        }
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i) {
        boolean z;
        u();
        if (this.D != null) {
            com.anythink.core.common.m.d.a().b(this.D);
            this.D = null;
        }
        com.anythink.core.common.a.b.a aVar = this.H;
        if (aVar != null && (aVar.e() == this.G.b().a() || this.H.d() > this.y)) {
            this.H.b();
            a(this.H.e(), this.H.d(), true);
            i = 11;
        }
        if (i != 5) {
            switch (i) {
                case 9:
                case 10:
                case 11:
                    break;
                default:
                    z = false;
                    break;
            }
            this.n = true;
            this.m = true;
            if (this.J != null) {
                com.anythink.core.common.m.d.a().b(this.J);
            }
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.u;
            com.anythink.core.common.f.h S = this.i.S();
            S.b(true);
            S.d(elapsedRealtime);
            if (z) {
                S.E(i);
            }
            com.anythink.core.common.n.a.a(this.a).a(12, S);
            com.anythink.core.common.p.f.a(this.a, this.g);
            com.anythink.core.common.p.f.a(this.g);
            v();
        }
        z = true;
        this.n = true;
        this.m = true;
        if (this.J != null) {
        }
        long elapsedRealtime2 = android.os.SystemClock.elapsedRealtime() - this.u;
        com.anythink.core.common.f.h S2 = this.i.S();
        S2.b(true);
        S2.d(elapsedRealtime2);
        if (z) {
        }
        com.anythink.core.common.n.a.a(this.a).a(12, S2);
        com.anythink.core.common.p.f.a(this.a, this.g);
        com.anythink.core.common.p.f.a(this.g);
        v();
    }

    public final void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.lang.String str) {
        if (aTBaseAdAdapter != null) {
            str.hashCode();
            if (str.equals("0")) {
                aTBaseAdAdapter.setRequestNum(aTBaseAdAdapter.getUnitGroupInfo().s());
            } else if (str.equals("4")) {
                aTBaseAdAdapter.setFetchAdTimeout(this.j.h);
            }
        }
    }

    public final void a(com.anythink.core.common.b.c cVar) {
        this.k = cVar;
    }

    public final void a(com.anythink.core.common.f.v vVar) {
        this.j = vVar;
    }

    public final void a(com.anythink.core.common.p.g gVar) {
        this.G = new com.anythink.core.common.p.f(gVar);
        this.l = gVar.f;
        this.f = gVar.b;
        this.g = gVar.a;
        this.e = gVar.c;
        this.c = gVar.g;
        this.f176s = com.anythink.core.common.p.f.b(gVar.d);
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.util.List<? extends com.anythink.core.api.BaseAd> list) {
        if (aTBaseAdAdapter != null) {
            aTBaseAdAdapter.getTrackingInfo().C();
        }
        com.anythink.core.common.p.d remove = this.B.remove(str);
        if (remove == null) {
            return;
        }
        com.anythink.core.common.f.h trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        com.anythink.core.common.f.au unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        unitGroupInfo.toString();
        a(unitGroupInfo);
        u();
        a(remove, aTBaseAdAdapter, unitGroupInfo, trackingInfo, false, new com.anythink.core.api.BaseAd[0]);
        if (unitGroupInfo.C() != -1 && trackingInfo.O() > 0) {
            com.anythink.core.common.n.c.a(trackingInfo);
        }
        c(aTBaseAdAdapter.getTrackingInfo());
        com.anythink.core.common.n.a.a(this.a).a(2, trackingInfo);
        com.anythink.core.common.a.a().a(this.g, aTBaseAdAdapter, list, unitGroupInfo.q());
        com.anythink.core.common.o.o.a(trackingInfo, com.anythink.core.common.b.h.m.b, com.anythink.core.common.b.h.m.l, "");
        a(remove);
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.common.p.a aVar) {
        com.anythink.core.common.f.h hVar = aVar.d;
        com.anythink.core.common.f.au auVar = aVar.e;
        com.anythink.core.api.AdError adError = aVar.b;
        long j = aVar.c;
        java.lang.String C = hVar.C();
        com.anythink.core.common.p.d remove = this.B.remove(str);
        if (remove == null) {
            return;
        }
        auVar.toString();
        a(auVar);
        this.t.putNetworkErrorMsg(C, hVar.M(), hVar.Z(), adError);
        com.anythink.core.common.n.c.a(hVar, aVar.a, adError, j);
        if (j > 0) {
            com.anythink.core.common.b.c cVar = this.k;
            if (cVar != null) {
                cVar.b(hVar, adError);
            }
            com.anythink.core.common.o.o.a(hVar, com.anythink.core.common.b.h.m.b, com.anythink.core.common.b.h.m.m, adError.printStackTrace());
        }
        a(remove);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0080 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:43:0x0005, B:44:0x0009, B:46:0x000f, B:5:0x001e, B:7:0x0025, B:10:0x002d, B:13:0x0091, B:14:0x0095, B:16:0x009b, B:18:0x00a9, B:21:0x0049, B:29:0x0069, B:31:0x0080, B:32:0x0082, B:36:0x0051, B:40:0x00ab), top: B:42:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2, java.util.List<com.anythink.core.common.f.au> list3) {
        java.lang.String str;
        java.lang.String str2;
        synchronized (this.x) {
            if (list2 != null) {
                try {
                    java.util.Iterator<com.anythink.core.common.f.au> it = list2.iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            if (list3 != null) {
                this.C.addAll(list3);
            }
            if (list != null && list.size() != 0) {
                this.F.f();
                com.anythink.core.common.f.au auVar = list.get(0);
                boolean a2 = com.anythink.core.common.p.f.a(auVar, this.F);
                boolean g = this.G.g(auVar);
                if (a2 || g) {
                    java.lang.String str3 = !this.n ? "1" : this.m ? "2" : "3";
                    if (a2) {
                        str2 = "1";
                    } else if (g) {
                        str2 = "2";
                    } else {
                        str = "1";
                        com.anythink.core.common.n.c.a(this.i, auVar.d(), auVar.u(), com.anythink.core.common.o.h.a(auVar), str3, str);
                        if (auVar.Z()) {
                            this.K = auVar;
                        }
                        c(auVar);
                        list.remove(0);
                        this.G.a(auVar);
                        b(auVar, 3);
                    }
                    str = str2;
                    com.anythink.core.common.n.c.a(this.i, auVar.d(), auVar.u(), com.anythink.core.common.o.h.a(auVar), str3, str);
                    if (auVar.Z()) {
                    }
                    c(auVar);
                    list.remove(0);
                    this.G.a(auVar);
                    b(auVar, 3);
                }
                for (com.anythink.core.common.f.au auVar2 : list) {
                    c(auVar2);
                    a(auVar2, 1);
                }
            }
        }
    }

    public final void b() {
        long a2 = this.G.a(this.l, this.e.a().A());
        if (a2 > -1) {
            this.E = new com.anythink.core.common.g.AnonymousClass3();
        }
        this.u = android.os.SystemClock.elapsedRealtime();
        com.anythink.core.common.m.d.a().a(this.J, this.e.i(), false);
        if (this.G.h() && this.l) {
            w();
        }
        a(this.G.u(), 1);
        if (this.E != null) {
            com.anythink.core.common.m.d.a().a(this.E, a2, false);
        }
        if (this.H != null) {
            com.anythink.core.common.f.h S = this.i.S();
            com.anythink.core.common.o.u.a(S, this.H.e(), 0, true);
            this.H.a(this.f, S);
        }
        if (this.e.j() >= 0) {
            this.D = new com.anythink.core.common.g.AnonymousClass2();
            this.e.j();
            com.anythink.core.common.m.d.a().a(this.D, this.e.j(), false);
        }
    }

    public final boolean c() {
        if (this.n) {
            return true;
        }
        return this.l && this.G.c() == 0 && this.G.o() == 0;
    }

    public final void d() {
        this.q = true;
        s();
    }

    public final void e() {
        synchronized (this.x) {
            this.l = true;
            this.q = true;
            s();
            l();
        }
    }

    public final void f() {
        this.M = true;
        com.anythink.core.common.u a2 = com.anythink.core.common.u.a();
        java.lang.String str = this.g;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.e.a().ag());
        com.anythink.core.common.f a3 = a2.a(str, sb.toString());
        if (a3 != null) {
            a3.a(this.f);
            return;
        }
        com.anythink.core.common.n.c.a("AdManage is null--notifycancel", "Id:" + this.g + "--format:" + this.e.a().ag(), com.anythink.core.common.b.o.a().q());
    }

    public final void g() {
        java.util.List<com.anythink.core.common.p.e> l = this.G.l();
        synchronized (l) {
            if (l.size() > 0) {
                com.anythink.core.common.f.au a2 = l.remove(0).a();
                if (!this.n || this.w < this.e.h() || com.anythink.core.common.o.h.a(a2) > this.y) {
                    this.G.a(a2);
                    b(a2, 4);
                }
            }
            if (l.size() > 0) {
                for (com.anythink.core.common.p.e eVar : l) {
                    com.anythink.core.common.f.au a3 = eVar.a();
                    if (!this.n || this.w < this.e.h() || com.anythink.core.common.o.h.a(a3) > this.y) {
                        int b = eVar.b();
                        if (b == 1) {
                            a(a3, 1);
                            d(b);
                        } else if (b == 2) {
                            a(a3, 2);
                            d(b);
                        } else if (b == 3) {
                            this.G.a(a3);
                            b(a3, 3);
                        }
                    }
                }
            }
            l.clear();
        }
        l();
    }

    public final com.anythink.core.common.a.b.a h() {
        return this.H;
    }

    public final com.anythink.core.d.e i() {
        return this.e.a();
    }
}
