package com.anythink.core.common.p;

/* loaded from: classes12.dex */
public class d {
    public static final java.lang.String a = "d";
    java.lang.String b;
    com.anythink.core.common.f.au c;
    com.anythink.core.common.f.h d;
    java.lang.String e;
    int f;
    com.anythink.core.api.ATBaseAdAdapter g;
    com.anythink.core.common.p.b h;
    boolean i;
    boolean j;
    long k;
    long l;
    com.anythink.core.common.m.b m;
    com.anythink.core.common.m.b n;
    com.anythink.core.common.p.c o;
    java.lang.Boolean p;
    int q;
    java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    boolean f182s;

    /* renamed from: com.anythink.core.common.p.d$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATBaseAdAdapter a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.anythink.core.common.f.au c;
        final /* synthetic */ java.util.Map d;

        public AnonymousClass1(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, java.lang.String str, com.anythink.core.common.f.au auVar, java.util.Map map) {
            this.a = aTBaseAdAdapter;
            this.b = str;
            this.c = auVar;
            this.d = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.p.b bVar = com.anythink.core.common.p.d.this.h;
            if (bVar != null) {
                bVar.a(this.a, this.b);
            }
            android.content.Context a = com.anythink.core.common.p.d.a(com.anythink.core.common.p.d.this);
            if (a == null) {
                if (com.anythink.core.common.p.d.this.h != null) {
                    com.anythink.core.common.p.a aVar = new com.anythink.core.common.p.a();
                    aVar.a = 0;
                    aVar.c = android.os.SystemClock.elapsedRealtime() - com.anythink.core.common.p.d.this.k;
                    aVar.b = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adapterInnerError, "", "Request Context is null! Please check the Ad init Context.");
                    com.anythink.core.common.p.d.this.a(this.a, aVar);
                    return;
                }
                return;
            }
            com.anythink.core.common.p.d.a(com.anythink.core.common.p.d.this, a, this.c, this.a);
            try {
                java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.p.d.b(com.anythink.core.common.p.d.this);
                com.anythink.core.common.p.d.this.g = this.a;
                com.anythink.core.common.i.e.a().c();
                com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.a;
                java.util.Map<java.lang.String, java.lang.Object> map = this.d;
                com.anythink.core.common.p.d dVar = com.anythink.core.common.p.d.this;
                aTBaseAdAdapter.internalLoad(a, map, b, new com.anythink.core.common.p.d.a(dVar, dVar, aTBaseAdAdapter, (byte) 0));
                com.anythink.core.common.f.h trackingInfo = this.a.getTrackingInfo();
                trackingInfo.g(this.a.getInternalNetworkPlacementId());
                com.anythink.core.common.p.b bVar2 = com.anythink.core.common.p.d.this.h;
                if (bVar2 != null) {
                    bVar2.a(trackingInfo, this.a);
                }
            } catch (java.lang.Throwable th) {
                com.anythink.core.common.p.a aVar2 = new com.anythink.core.common.p.a();
                aVar2.a = 0;
                aVar2.c = android.os.SystemClock.elapsedRealtime() - com.anythink.core.common.p.d.this.k;
                aVar2.b = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.adapterInnerError, "", th.getMessage());
                com.anythink.core.common.p.d.this.a(this.a, aVar2);
            }
        }
    }

    /* renamed from: com.anythink.core.common.p.d$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.m.b {

        /* renamed from: com.anythink.core.common.p.d$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.p.d.this.l();
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.common.p.d.AnonymousClass2.AnonymousClass1());
        }
    }

    /* renamed from: com.anythink.core.common.p.d$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATBaseAdAdapter a;

        public AnonymousClass3(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            this.a = aTBaseAdAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter = this.a;
                if (aTBaseAdAdapter != null) {
                    aTBaseAdAdapter.internalDestory();
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class a implements com.anythink.core.api.ATCustomLoadListener {
        com.anythink.core.api.ATBaseAdAdapter a;
        com.anythink.core.common.p.d b;

        /* renamed from: com.anythink.core.common.p.d$a$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (com.anythink.core.common.p.d.a.this) {
                    com.anythink.core.common.p.d.a aVar = com.anythink.core.common.p.d.a.this;
                    com.anythink.core.common.p.d dVar = aVar.b;
                    if (dVar != null && aVar.a != null) {
                        dVar.n();
                    }
                }
            }
        }

        /* renamed from: com.anythink.core.common.p.d$a$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.core.api.BaseAd[] a;

            public AnonymousClass2(com.anythink.core.api.BaseAd[] baseAdArr) {
                this.a = baseAdArr;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter;
                synchronized (com.anythink.core.common.p.d.a.this) {
                    com.anythink.core.common.p.d.a aVar = com.anythink.core.common.p.d.a.this;
                    com.anythink.core.common.p.d dVar = aVar.b;
                    if (dVar != null && (aTBaseAdAdapter = aVar.a) != null) {
                        dVar.a(aTBaseAdAdapter, this.a);
                        com.anythink.core.common.p.d.a aVar2 = com.anythink.core.common.p.d.a.this;
                        aVar2.b = null;
                        aVar2.a = null;
                    }
                }
            }
        }

        /* renamed from: com.anythink.core.common.p.d$a$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String a;
            final /* synthetic */ java.lang.String b;

            public AnonymousClass3(java.lang.String str, java.lang.String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                synchronized (com.anythink.core.common.p.d.a.this) {
                    com.anythink.core.common.p.d.a aVar = com.anythink.core.common.p.d.a.this;
                    if (aVar.b != null && aVar.a != null) {
                        com.anythink.core.common.p.a aVar2 = new com.anythink.core.common.p.a();
                        aVar2.a = 0;
                        aVar2.b = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noADError, this.a, this.b);
                        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
                        com.anythink.core.common.p.d.a aVar3 = com.anythink.core.common.p.d.a.this;
                        aVar2.c = elapsedRealtime - com.anythink.core.common.p.d.this.k;
                        aVar3.b.a(aVar3.a, aVar2);
                        com.anythink.core.common.p.d.a aVar4 = com.anythink.core.common.p.d.a.this;
                        aVar4.b = null;
                        aVar4.a = null;
                    }
                }
            }
        }

        private a(com.anythink.core.common.p.d dVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            this.b = dVar;
            this.a = aTBaseAdAdapter;
        }

        public /* synthetic */ a(com.anythink.core.common.p.d dVar, com.anythink.core.common.p.d dVar2, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, byte b) {
            this(dVar2, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(com.anythink.core.api.BaseAd... baseAdArr) {
            com.anythink.core.common.i.e.a().d();
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.common.p.d.a.AnonymousClass2(baseAdArr));
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.common.p.d.a.AnonymousClass1());
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(java.lang.String str, java.lang.String str2) {
            com.anythink.core.common.i.e.a().d();
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.common.p.d.a.AnonymousClass3(str, str2));
        }
    }

    public d(com.anythink.core.common.f.au auVar, int i) {
        this.c = auVar;
        this.q = i;
        this.e = auVar.u();
        this.r = this.e + "_" + hashCode();
    }

    public static /* synthetic */ android.content.Context a(com.anythink.core.common.p.d dVar) {
        android.content.Context context = dVar.o.b.get();
        if (!(context instanceof android.app.Activity)) {
            context = com.anythink.core.common.b.o.a().E();
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            "requestContext = ".concat(java.lang.String.valueOf(context));
        }
        return context;
    }

    private void a(long j) {
        if (j == -1) {
            return;
        }
        this.n = m();
        com.anythink.core.common.m.d.a().a(this.n, j, false);
    }

    private void a(android.content.Context context, com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.d.a.ax()) {
            com.anythink.core.common.b.r a2 = com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f());
            try {
                if (a2.c(auVar.d()) || !aTBaseAdAdapter.internalSetUserDataConsent(context, a2.c(), com.anythink.core.api.ATSDK.isEUTraffic(this.o.a))) {
                    return;
                }
                a2.b(auVar.d());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        this.g = aTBaseAdAdapter;
    }

    private void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar) {
        java.util.Map<java.lang.String, java.lang.Object> h = h();
        java.lang.String valueOf = java.lang.String.valueOf(this.o.e.ag());
        com.anythink.core.common.p.d.AnonymousClass1 anonymousClass1 = new com.anythink.core.common.p.d.AnonymousClass1(aTBaseAdAdapter, valueOf, auVar, h);
        if (android.text.TextUtils.equals(valueOf, "2")) {
            com.anythink.core.common.b.o.a().b(anonymousClass1);
        } else {
            com.anythink.core.common.o.b.b.a().c(anonymousClass1);
        }
    }

    private synchronized void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.f.au auVar, com.anythink.core.common.f.b bVar) {
        if (k()) {
            return;
        }
        f();
        g();
        this.g = null;
        this.p = java.lang.Boolean.TRUE;
        if (this.i) {
            this.d.r = 1;
        }
        com.anythink.core.common.p.b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.a(this.r, aTBaseAdAdapter, auVar, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.api.BaseAd... baseAdArr) {
        if (k()) {
            return;
        }
        com.anythink.core.common.f.au unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
        this.d.d((android.os.SystemClock.elapsedRealtime() - this.k) + (unitGroupInfo.m() == 2 ? unitGroupInfo.l() : 0L));
        f();
        g();
        this.g = null;
        this.p = java.lang.Boolean.TRUE;
        if (this.i) {
            this.d.r = 1;
        }
        com.anythink.core.common.p.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.r, aTBaseAdAdapter, baseAdArr);
        }
    }

    public static /* synthetic */ void a(com.anythink.core.common.p.d dVar, android.content.Context context, com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
        if (com.anythink.core.d.a.ax()) {
            com.anythink.core.common.b.r a2 = com.anythink.core.common.b.r.a(com.anythink.core.common.b.o.a().f());
            try {
                if (a2.c(auVar.d()) || !aTBaseAdAdapter.internalSetUserDataConsent(context, a2.c(), com.anythink.core.api.ATSDK.isEUTraffic(dVar.o.a))) {
                    return;
                }
                a2.b(auVar.d());
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static /* synthetic */ java.util.Map b(com.anythink.core.common.p.d dVar) {
        java.lang.Object obj;
        java.util.Map<java.lang.String, java.lang.Object> map = dVar.o.f;
        if (map == null) {
            return new java.util.HashMap(2);
        }
        if (dVar.c.d() != 2 || (obj = map.get("admob_content_urls")) == null || !(obj instanceof java.util.List)) {
            return map;
        }
        com.anythink.core.common.n.c.a(dVar.b, dVar.d, "admob_content_urls", obj);
        return map;
    }

    private void b(long j) {
        if (j == -1) {
            return;
        }
        this.m = m();
        com.anythink.core.common.m.d.a().a(this.m, j, false);
    }

    private void f() {
        if (this.m != null) {
            com.anythink.core.common.m.d.a().b(this.m);
            this.m = null;
        }
    }

    private void g() {
        if (this.n != null) {
            com.anythink.core.common.m.d.a().b(this.n);
            this.n = null;
        }
    }

    private java.util.Map<java.lang.String, java.lang.Object> h() {
        com.anythink.core.common.p.c cVar = this.o;
        com.anythink.core.d.e eVar = cVar.e;
        java.lang.String str = cVar.c;
        if (eVar == null) {
            return new java.util.HashMap();
        }
        java.util.Map<java.lang.String, java.lang.Object> a2 = eVar.a(this.b, str, this.c);
        int d = this.c.d();
        if (d == 2) {
            com.anythink.core.d.a b = com.anythink.core.d.b.a(this.o.a).b(com.anythink.core.common.b.o.a().o());
            if (b != null) {
                a2.put(com.anythink.core.common.b.h.o.l, java.lang.Boolean.valueOf(b.r() == 1));
            }
            if (eVar.b() == 1) {
                a2.put(com.anythink.core.common.b.h.o.o, java.lang.Integer.valueOf(eVar.b()));
            } else {
                a2.put(com.anythink.core.common.b.h.o.o, java.lang.Integer.valueOf(this.c.an()));
            }
        } else if (d == 6) {
            org.json.JSONObject a3 = com.anythink.core.common.o.h.a(this.o.a, str, this.b, eVar.ag(), this.f);
            if (eVar.aG() == 1) {
                a2.put("tp_info", a3.toString());
            }
        } else if (d == 22) {
            com.anythink.core.common.o.b.a(eVar, a2, this.c, this.o.i);
        }
        if (com.anythink.core.common.o.v.a(this.c) && this.o.e.aB() == 1) {
            com.anythink.core.common.f.an a4 = com.anythink.core.a.a.a(this.o.a).a(this.b, this.o.e.ag());
            a2.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_LOAD_SEQ, java.lang.Integer.valueOf(a4 != null ? a4.c : 0));
            synchronized (com.anythink.core.common.u.a().a(this.b)) {
                java.lang.String a5 = com.anythink.core.common.u.a().a(this.b, this.c.d());
                if (!android.text.TextUtils.isEmpty(a5)) {
                    a2.put(com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.CONTENT, a5);
                }
            }
        }
        return a2;
    }

    private java.util.Map<java.lang.String, java.lang.Object> i() {
        java.lang.Object obj;
        java.util.Map<java.lang.String, java.lang.Object> map = this.o.f;
        if (map == null) {
            return new java.util.HashMap(2);
        }
        if (this.c.d() != 2 || (obj = map.get("admob_content_urls")) == null || !(obj instanceof java.util.List)) {
            return map;
        }
        com.anythink.core.common.n.c.a(this.b, this.d, "admob_content_urls", obj);
        return map;
    }

    private android.content.Context j() {
        android.content.Context context = this.o.b.get();
        if (!(context instanceof android.app.Activity)) {
            context = com.anythink.core.common.b.o.a().E();
        }
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            "requestContext = ".concat(java.lang.String.valueOf(context));
        }
        return context;
    }

    private boolean k() {
        return !this.f182s || this.j || p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l() {
        if (k()) {
            return;
        }
        this.i = true;
        java.lang.String str = this.e;
        com.anythink.core.common.p.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.r, str);
        }
    }

    private com.anythink.core.common.m.b m() {
        return new com.anythink.core.common.p.d.AnonymousClass2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n() {
        f();
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.k;
        this.l = elapsedRealtime;
        com.anythink.core.common.f.h hVar = this.d;
        if (hVar != null) {
            hVar.c(elapsedRealtime);
        }
    }

    private void o() {
        this.g = null;
    }

    private boolean p() {
        return this.p != null;
    }

    private long q() {
        return this.k;
    }

    private boolean r() {
        return this.i;
    }

    private com.anythink.core.common.f.au s() {
        return this.c;
    }

    public final java.lang.String a() {
        return this.r;
    }

    public final void a(double d) {
        com.anythink.core.common.f.b bVar;
        boolean z;
        com.anythink.core.api.BaseAd baseAd;
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter;
        boolean z2;
        java.lang.String str;
        this.f182s = true;
        if (this.c.k() && this.c.M() != null && !android.text.TextUtils.isEmpty(this.o.c)) {
            this.c.M().b(this.o.c);
        }
        com.anythink.core.common.f.av a2 = com.anythink.core.common.a.a().a(this.b, this.c);
        if (a2 != null) {
            com.anythink.core.common.f.f a3 = a2.a(this.c.M());
            int d2 = a3.d();
            if (this.c.j() == 1) {
                bVar = a3.e();
                if (bVar != null) {
                    this.c.toString();
                    z = true;
                }
                z = false;
            } else {
                com.anythink.core.common.f.b a4 = a3.a();
                if (a3.c() && a4 != null) {
                    if (com.anythink.core.common.o.h.a(this.c) <= d) {
                        this.c.toString();
                    } else if (d2 >= this.c.am()) {
                        this.c.toString();
                    }
                    bVar = a4;
                    z = true;
                }
                bVar = a4;
                z = false;
            }
            this.c.toString();
        } else {
            this.c.toString();
            bVar = null;
            z = false;
        }
        if (z) {
            com.anythink.core.common.p.b bVar2 = this.h;
            if (bVar2 != null) {
                bVar2.a(bVar.d().getTrackingInfo(), bVar.d());
            }
            this.c.toString();
            a(bVar.d(), this.c, bVar);
            return;
        }
        this.c.toString();
        com.anythink.core.common.f.q M = this.c.M();
        if (M == null || !M.f175s) {
            baseAd = null;
            aTBaseAdAdapter = null;
            z2 = false;
        } else {
            com.anythink.core.b.c.a aVar = M.r;
            if (aVar != null) {
                aTBaseAdAdapter = aVar.a();
                baseAd = aVar.b();
            } else {
                baseAd = null;
                aTBaseAdAdapter = null;
            }
            M.r = null;
            z2 = true;
        }
        if (aTBaseAdAdapter == null && !z2) {
            aTBaseAdAdapter = com.anythink.core.common.o.j.a(this.c);
        }
        com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter2 = aTBaseAdAdapter;
        if (aTBaseAdAdapter2 == null) {
            if (this.h != null) {
                com.anythink.core.common.p.a aVar2 = new com.anythink.core.common.p.a();
                aVar2.a = 0;
                aVar2.c = z2 ? this.c.l() : 0L;
                java.lang.String str2 = z2 ? com.anythink.core.api.ErrorCode.c2sBiddingCacheError : com.anythink.core.api.ErrorCode.adapterNotExistError;
                if (z2) {
                    str = "";
                } else {
                    str = this.c.i() + " does not exist!";
                }
                aVar2.b = com.anythink.core.api.ErrorCode.getErrorCode(str2, "", str);
                a((com.anythink.core.api.ATBaseAdAdapter) null, aVar2);
                return;
            }
            return;
        }
        try {
            com.anythink.core.common.o.e.a(this.c.d(), aTBaseAdAdapter2.getInternalNetworkSDKVersion());
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.core.common.f.h a5 = com.anythink.core.common.o.u.a(aTBaseAdAdapter2, this.d, this.c);
        this.d = a5;
        com.anythink.core.common.p.b bVar3 = this.h;
        if (bVar3 != null) {
            bVar3.a(a5);
        }
        long C = this.c.C();
        if (C != -1) {
            this.m = m();
            com.anythink.core.common.m.d.a().a(this.m, C, false);
        }
        long r = this.c.r();
        if (r != -1) {
            this.n = m();
            com.anythink.core.common.m.d.a().a(this.n, r, false);
        }
        this.k = android.os.SystemClock.elapsedRealtime();
        android.content.Context context = this.o.b.get();
        if (context != null && (context instanceof android.app.Activity)) {
            aTBaseAdAdapter2.refreshActivityContext((android.app.Activity) context);
        }
        if (z2) {
            com.anythink.core.common.p.b bVar4 = this.h;
            if (bVar4 != null) {
                bVar4.a(this.d, aTBaseAdAdapter2);
            }
            if (baseAd != null) {
                a(aTBaseAdAdapter2, baseAd);
                return;
            } else {
                a(aTBaseAdAdapter2, new com.anythink.core.api.BaseAd[0]);
                return;
            }
        }
        com.anythink.core.common.f.au auVar = this.c;
        java.util.Map<java.lang.String, java.lang.Object> h = h();
        java.lang.String valueOf = java.lang.String.valueOf(this.o.e.ag());
        com.anythink.core.common.p.d.AnonymousClass1 anonymousClass1 = new com.anythink.core.common.p.d.AnonymousClass1(aTBaseAdAdapter2, valueOf, auVar, h);
        if (android.text.TextUtils.equals(valueOf, "2")) {
            com.anythink.core.common.b.o.a().b(anonymousClass1);
        } else {
            com.anythink.core.common.o.b.b.a().c(anonymousClass1);
        }
    }

    public final synchronized void a(com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.p.a aVar) {
        if (k()) {
            return;
        }
        f();
        g();
        if (aTBaseAdAdapter != null) {
            com.anythink.core.common.b.o.a().b(new com.anythink.core.common.p.d.AnonymousClass3(aTBaseAdAdapter));
        }
        this.g = null;
        this.p = java.lang.Boolean.FALSE;
        boolean z = this.j;
        if (z) {
            this.d.r = 2;
        } else if (this.i) {
            this.d.r = 1;
        }
        if (!z) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            com.anythink.core.common.c.a().a(this.e, currentTimeMillis);
            com.anythink.core.common.c.a().a(this.e, currentTimeMillis, aVar.b);
        }
        aVar.d = this.d;
        aVar.e = this.c;
        com.anythink.core.common.p.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.r, aTBaseAdAdapter, aVar);
        }
    }

    public final void a(com.anythink.core.common.p.b bVar) {
        this.h = bVar;
    }

    public final void a(com.anythink.core.common.p.c cVar) {
        this.o = cVar;
        this.b = cVar.d;
        this.d = cVar.h;
        this.f = cVar.g;
    }

    public final synchronized void b() {
        if (k()) {
            return;
        }
        this.p = java.lang.Boolean.FALSE;
        this.j = true;
        com.anythink.core.common.p.a aVar = new com.anythink.core.common.p.a();
        aVar.a = 0;
        aVar.c = android.os.SystemClock.elapsedRealtime() - this.k;
        aVar.b = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.timeOutError, "", "");
        a(this.g, aVar);
    }

    public final java.lang.Boolean c() {
        return this.p;
    }

    public final boolean d() {
        return (p() && this.i) ? false : true;
    }

    public final int e() {
        return this.q;
    }
}
