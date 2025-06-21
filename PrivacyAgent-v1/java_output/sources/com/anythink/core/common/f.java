package com.anythink.core.common;

/* loaded from: classes12.dex */
public final class f {
    protected android.content.Context a;
    protected java.lang.String b;
    protected boolean d;
    com.anythink.core.common.n g;
    com.anythink.core.common.j.c i;
    com.anythink.core.common.j.e j;
    com.anythink.core.common.j.d k;
    private boolean n;
    private long o;
    private final java.lang.String l = com.anythink.core.common.f.class.getSimpleName();
    protected java.lang.String e = "";
    private java.lang.String m = "";
    private boolean p = false;
    protected int f = 1;
    protected java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.g> c = new java.util.concurrent.ConcurrentHashMap<>(5);
    final java.util.List<com.anythink.core.common.f.aw> h = java.util.Collections.synchronizedList(new java.util.ArrayList(2));

    /* renamed from: com.anythink.core.common.f$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.v a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.anythink.core.common.b.b d;
        final /* synthetic */ android.content.Context e;
        final /* synthetic */ int[] f;
        final /* synthetic */ java.util.Map g;

        /* renamed from: com.anythink.core.common.f$1$1, reason: invalid class name and collision with other inner class name */
        public class C01641 implements com.anythink.core.d.f.c {
            final /* synthetic */ com.anythink.core.common.f.h a;
            final /* synthetic */ android.content.Context b;
            final /* synthetic */ java.lang.String c;

            public C01641(com.anythink.core.common.f.h hVar, android.content.Context context, java.lang.String str) {
                this.a = hVar;
                this.b = context;
                this.c = str;
            }

            @Override // com.anythink.core.d.f.c
            public final void a(com.anythink.core.api.AdError adError) {
                java.lang.String unused = com.anythink.core.common.f.this.l;
                java.lang.String str = com.anythink.core.common.b.h.m.m;
                com.anythink.core.common.f.AnonymousClass1 anonymousClass1 = com.anythink.core.common.f.AnonymousClass1.this;
                java.lang.String str2 = anonymousClass1.b;
                java.lang.String d = com.anythink.core.common.o.h.d(anonymousClass1.c);
                java.lang.String printStackTrace = adError.printStackTrace();
                if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                        jSONObject.put("action", com.anythink.core.common.b.h.m.C);
                        jSONObject.put("result", str);
                        jSONObject.put(com.anythink.expressad.videocommon.e.b.v, str2);
                        jSONObject.put("adtype", d);
                        jSONObject.put(com.bytedance.sdk.openadsdk.mediation.MediationConstant.KEY_ERROR_MSG, printStackTrace);
                        com.anythink.core.common.o.o.a("anythink_network", jSONObject.toString(), android.text.TextUtils.equals(com.anythink.core.common.b.h.m.m, str));
                    } catch (java.lang.Throwable unused2) {
                    }
                }
                com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.placeStrategyError, adError.getPlatformCode(), adError.getPlatformMSG());
                this.a.E(5);
                com.anythink.core.common.f.AnonymousClass1 anonymousClass12 = com.anythink.core.common.f.AnonymousClass1.this;
                com.anythink.core.common.f.this.a(true, this.a, errorCode, anonymousClass12.a);
            }

            @Override // com.anythink.core.d.f.c
            public final void a(com.anythink.core.d.e eVar) {
                synchronized (com.anythink.core.common.f.this) {
                    com.anythink.core.common.o.u.a(this.a, eVar);
                    if (android.text.TextUtils.equals(java.lang.String.valueOf(eVar.ag()), com.anythink.core.common.f.AnonymousClass1.this.c)) {
                        com.anythink.core.common.f.AnonymousClass1 anonymousClass1 = com.anythink.core.common.f.AnonymousClass1.this;
                        com.anythink.core.common.f.a(com.anythink.core.common.f.this, this.b, anonymousClass1.b, this.c, eVar, this.a, anonymousClass1.a);
                        return;
                    }
                    com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.formatError, "", "Format corresponding to API: " + com.anythink.core.common.o.h.d(com.anythink.core.common.f.AnonymousClass1.this.c) + ", Format corresponding to placement strategy: " + com.anythink.core.common.o.h.d(java.lang.String.valueOf(eVar.ag())));
                    com.anythink.core.common.f.AnonymousClass1 anonymousClass12 = com.anythink.core.common.f.AnonymousClass1.this;
                    com.anythink.core.common.f.this.a(anonymousClass12.a, errorCode);
                    this.a.b(false);
                    com.anythink.core.common.n.c.a(this.a, errorCode);
                    com.anythink.core.common.f.this.d = false;
                }
            }

            @Override // com.anythink.core.d.f.c
            public final void b(com.anythink.core.d.e eVar) {
                if (eVar.ay()) {
                    return;
                }
                com.anythink.core.common.f.this.b();
            }
        }

        public AnonymousClass1(com.anythink.core.common.f.v vVar, java.lang.String str, java.lang.String str2, com.anythink.core.common.b.b bVar, android.content.Context context, int[] iArr, java.util.Map map) {
            this.a = vVar;
            this.b = str;
            this.c = str2;
            this.d = bVar;
            this.e = context;
            this.f = iArr;
            this.g = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            synchronized (com.anythink.core.common.f.this) {
                if (!com.anythink.core.common.f.this.f() || this.a.d == 0) {
                    if (com.anythink.core.common.f.a(com.anythink.core.common.f.this) || this.a.d != 5) {
                        if (com.anythink.core.common.f.this.k() && this.a.d == 0) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("PlacementId(");
                            sb.append(this.b);
                            sb.append(") the load api calls are not allowed in Auto-load mode");
                            return;
                        }
                        com.anythink.core.common.f fVar = com.anythink.core.common.f.this;
                        if (fVar.g == null) {
                            fVar.g = new com.anythink.core.common.n();
                        }
                        com.anythink.core.common.n nVar = com.anythink.core.common.f.this.g;
                        java.lang.String str2 = this.b;
                        java.lang.String str3 = this.c;
                        nVar.a = str2;
                        nVar.b = str3;
                        nVar.a(this.d);
                        com.anythink.core.common.f.v vVar = this.a;
                        com.anythink.core.common.f fVar2 = com.anythink.core.common.f.this;
                        vVar.f = fVar2.g;
                        if (vVar.d != 4) {
                            fVar2.f = 1;
                        } else {
                            fVar2.f++;
                        }
                        com.anythink.core.common.f.c(fVar2);
                        int i = this.a.d;
                        com.anythink.core.common.b.o.a().a(this.e, com.anythink.core.common.b.o.a().o(), com.anythink.core.common.b.o.a().p());
                        if (android.text.TextUtils.isEmpty(this.a.a)) {
                            str = com.anythink.core.common.o.h.a(this.e);
                            this.a.a = str;
                        } else {
                            str = this.a.a;
                        }
                        java.lang.String str4 = str;
                        com.anythink.core.common.f fVar3 = com.anythink.core.common.f.this;
                        java.lang.String str5 = this.a.a;
                        com.anythink.core.common.b.b bVar = this.d;
                        com.anythink.core.common.j.c cVar = fVar3.i;
                        if (cVar != null) {
                            cVar.a(str5, bVar);
                        }
                        if (com.anythink.core.common.b.o.a().f() != null && !android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().o()) && !android.text.TextUtils.isEmpty(com.anythink.core.common.b.o.a().p()) && !com.anythink.core.common.o.i.a(this.b)) {
                            if (com.anythink.core.common.f.d(com.anythink.core.common.f.this)) {
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Placement(");
                                sb2.append(this.b);
                                sb2.append(") is loading.");
                                com.anythink.core.common.e.a(this.a.g, com.anythink.core.common.e.c, this.b, com.anythink.core.common.f.this.m, com.anythink.core.common.f.this.e);
                                return;
                            }
                            android.content.Context applicationContext = this.e.getApplicationContext();
                            java.lang.String o = com.anythink.core.common.b.o.a().o();
                            java.lang.String p = com.anythink.core.common.b.o.a().p();
                            boolean v = com.anythink.core.common.b.o.a().v();
                            com.anythink.core.d.f a = com.anythink.core.d.f.a(this.e);
                            com.anythink.core.d.e c = v ? null : a.c(this.b);
                            java.lang.String str6 = this.b;
                            com.anythink.core.common.f.v vVar2 = this.a;
                            com.anythink.core.common.f.h a2 = com.anythink.core.common.o.u.a(str4, str6, c, vVar2.d, this.f[0], vVar2.g, vVar2.i);
                            a2.y(this.c);
                            java.util.Map<java.lang.String, java.lang.Object> map = this.g;
                            if (map != null) {
                                a2.b(map);
                            }
                            if (c == null && !v && (!android.text.TextUtils.isEmpty(this.a.c) || this.a.b != null)) {
                                com.anythink.core.common.f fVar4 = com.anythink.core.common.f.this;
                                if (com.anythink.core.common.f.a(fVar4, this.b, str4, this.a, fVar4.g)) {
                                    com.anythink.core.common.f fVar5 = com.anythink.core.common.f.this;
                                    fVar5.e = str4;
                                    fVar5.m = a2.V();
                                    com.anythink.core.d.f.a(this.e).a(null, o, p, this.b, this.a.g, null);
                                    return;
                                }
                            }
                            com.anythink.core.d.e f = a.f(this.b);
                            if (c != null || v || f == null) {
                                f = c;
                            }
                            if (f != null) {
                                try {
                                    com.anythink.core.common.f.a(f, a2);
                                    com.anythink.core.common.f.b(f, a2);
                                } catch (com.anythink.core.common.f.g e) {
                                    com.anythink.core.common.f.this.a(true, a2, (java.lang.Throwable) e, this.a);
                                    return;
                                } catch (java.lang.Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            int c2 = com.anythink.core.common.f.this.c();
                            if (c2 > 0 && f != null) {
                                if (com.anythink.core.common.a.a().a(this.e, this.b) != null) {
                                    java.lang.String unused = com.anythink.core.common.f.this.l;
                                    f.g();
                                    if (c2 >= f.g()) {
                                        a2.b(false);
                                        a2.E(4);
                                        com.anythink.core.common.n.a.a(applicationContext).a(10, a2);
                                        com.anythink.core.common.n.a.a(applicationContext).a(12, a2);
                                        com.anythink.core.common.f.this.d = false;
                                        com.anythink.core.common.b.b bVar2 = this.d;
                                        if (bVar2 != null) {
                                            bVar2.onAdLoaded();
                                            com.anythink.core.common.f.this.g.b(this.d);
                                        }
                                        return;
                                    }
                                    com.anythink.core.common.b.b bVar3 = this.d;
                                    if (bVar3 != null) {
                                        bVar3.onAdLoaded();
                                        com.anythink.core.common.f.this.g.b(this.d);
                                    }
                                    java.lang.String unused2 = com.anythink.core.common.f.this.l;
                                    f.g();
                                    this.a.d = 9;
                                    a2.x(9);
                                } else {
                                    com.anythink.core.common.f.this.b();
                                }
                            }
                            if (f != null && com.anythink.core.common.f.this.n) {
                                long currentTimeMillis = java.lang.System.currentTimeMillis() - com.anythink.core.common.f.this.o;
                                if (currentTimeMillis > 0 && currentTimeMillis < f.as()) {
                                    com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.loadFailInPacingError, "", "");
                                    a2.E(7);
                                    com.anythink.core.common.f.this.a(com.anythink.core.common.f.this.p ? false : true, a2, new com.anythink.core.common.f.g(errorCode, errorCode.printStackTrace()), this.a);
                                    com.anythink.core.common.f.this.p = true;
                                    return;
                                }
                            }
                            com.anythink.core.common.f.j(com.anythink.core.common.f.this);
                            com.anythink.core.common.f.k(com.anythink.core.common.f.this);
                            com.anythink.core.common.f.this.p = false;
                            if (f != null && com.anythink.core.a.b.a().a(applicationContext, this.b, f)) {
                                com.anythink.core.api.AdError errorCode2 = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.loadCappingError, "", "");
                                a2.E(8);
                                com.anythink.core.common.f.this.a(true, a2, (java.lang.Throwable) new com.anythink.core.common.f.g(errorCode2, errorCode2.printStackTrace()), this.a);
                                return;
                            } else {
                                if (com.anythink.core.common.f.this.f()) {
                                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder("Placement(");
                                    sb3.append(this.b);
                                    sb3.append(") is loading.");
                                    com.anythink.core.common.e.a(this.a.g, com.anythink.core.common.e.c, this.b, com.anythink.core.common.f.this.m, com.anythink.core.common.f.this.e);
                                    return;
                                }
                                a.g(this.b);
                                com.anythink.core.common.f fVar6 = com.anythink.core.common.f.this;
                                fVar6.d = true;
                                java.util.Iterator<com.anythink.core.common.g> it = fVar6.c.values().iterator();
                                while (it.hasNext()) {
                                    it.next().f();
                                }
                                com.anythink.core.d.f.a(this.e).a(f, o, p, this.b, this.a.g, new com.anythink.core.common.f.AnonymousClass1.C01641(a2, applicationContext, str4));
                                return;
                            }
                        }
                        com.anythink.core.common.f.this.a(this.a, com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.appIdOrPlaceIdEmpty, "", ""));
                        if (com.anythink.core.common.b.o.a().A()) {
                            java.lang.StringBuilder sb4 = new java.lang.StringBuilder("Please check these params in your code (AppId: ");
                            sb4.append(com.anythink.core.common.b.o.a().o());
                            sb4.append(", AppKey: ");
                            sb4.append(com.anythink.core.common.b.o.a().p());
                            sb4.append(", PlacementId: ");
                            sb4.append(this.b);
                            sb4.append(")");
                        }
                        com.anythink.core.common.f.this.d = false;
                    }
                }
            }
        }
    }

    /* renamed from: com.anythink.core.common.f$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.anythink.core.common.f.v b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.anythink.core.d.e e;
        final /* synthetic */ boolean f;
        final /* synthetic */ java.util.List g;
        final /* synthetic */ com.anythink.core.common.f.az h;
        final /* synthetic */ com.anythink.core.common.f.h i;
        final /* synthetic */ com.anythink.core.common.f.ay j;
        final /* synthetic */ com.anythink.core.common.f.ap k;
        final /* synthetic */ com.anythink.core.common.f.p l;
        final /* synthetic */ com.anythink.core.common.p.h m;

        /* renamed from: com.anythink.core.common.f$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.core.common.i.a {
            public AnonymousClass1() {
            }

            @Override // com.anythink.core.common.i.a
            public final void a(java.lang.String str) {
                com.anythink.core.common.g gVar = com.anythink.core.common.f.this.c.get(str);
                if (gVar != null) {
                    gVar.d();
                }
            }

            @Override // com.anythink.core.common.i.a
            public final void a(java.lang.String str, java.util.List<com.anythink.core.common.f.au> list, java.util.List<com.anythink.core.common.f.au> list2, boolean z) {
                boolean d = com.anythink.core.common.f.AnonymousClass2.this.h.d();
                java.util.ArrayList arrayList = null;
                for (com.anythink.core.common.f.au auVar : list2) {
                    if (d && (auVar.m() == 1 || auVar.m() == 3)) {
                        if (auVar.O() != 1) {
                            if (arrayList == null) {
                                arrayList = new java.util.ArrayList(4);
                            }
                            auVar.x(7);
                            arrayList.add(auVar);
                        }
                    }
                    if (!d && auVar.l() != 0) {
                        com.anythink.core.common.c a = com.anythink.core.common.c.a();
                        a.c.put(auVar.u(), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
                    }
                }
                com.anythink.core.common.g gVar = com.anythink.core.common.f.this.c.get(str);
                if (gVar != null) {
                    gVar.a(list, list2, arrayList);
                    if (z) {
                        gVar.e();
                    }
                }
            }
        }

        public AnonymousClass2(android.content.Context context, com.anythink.core.common.f.v vVar, java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, boolean z, java.util.List list, com.anythink.core.common.f.az azVar, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.ay ayVar, com.anythink.core.common.f.ap apVar, com.anythink.core.common.f.p pVar, com.anythink.core.common.p.h hVar2) {
            this.a = context;
            this.b = vVar;
            this.c = str;
            this.d = str2;
            this.e = eVar;
            this.f = z;
            this.g = list;
            this.h = azVar;
            this.i = hVar;
            this.j = ayVar;
            this.k = apVar;
            this.l = pVar;
            this.m = hVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.f.a aVar = new com.anythink.core.common.f.a();
                aVar.b = this.a;
                aVar.c = this.b;
                aVar.d = this.c;
                aVar.e = this.d;
                aVar.f = this.e.ag();
                aVar.g = this.e.R();
                aVar.h = this.e.L();
                aVar.i = this.e.u();
                com.anythink.core.common.h.a();
                aVar.l = com.anythink.core.common.h.a(this.e, this.f);
                com.anythink.core.common.h.a();
                aVar.o = com.anythink.core.common.h.a(this.e);
                com.anythink.core.common.h.a();
                aVar.p = com.anythink.core.common.h.b(this.e);
                aVar.j = this.g;
                aVar.n = this.h;
                aVar.f167s = this.i;
                aVar.v = this.j;
                aVar.w = this.k;
                aVar.x = this.l;
                aVar.q = com.anythink.core.common.u.a().b(com.anythink.core.common.f.this.b);
                aVar.m = this.f;
                if (this.b.d == 8) {
                    aVar.t = 7;
                }
                aVar.y = this.m;
                com.anythink.core.b.b bVar = new com.anythink.core.b.b(aVar);
                bVar.a(com.anythink.core.api.ATSDK.isNetworkLogDebug());
                bVar.a(new com.anythink.core.common.f.AnonymousClass2.AnonymousClass1());
            } catch (java.lang.Throwable unused) {
                com.anythink.core.common.g gVar = com.anythink.core.common.f.this.c.get(this.c);
                if (gVar != null) {
                    gVar.e();
                }
            }
        }
    }

    /* renamed from: com.anythink.core.common.f$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass3(java.lang.String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.g gVar = com.anythink.core.common.f.this.c.get(this.a);
            if (gVar != null) {
                gVar.g();
            }
        }
    }

    /* renamed from: com.anythink.core.common.f$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.common.b.b {
        final /* synthetic */ com.anythink.core.common.b.b[] a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;
        final /* synthetic */ com.anythink.core.common.f.v e;
        final /* synthetic */ com.anythink.core.d.e f;

        public AnonymousClass4(com.anythink.core.common.b.b[] bVarArr, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.core.common.f.v vVar, com.anythink.core.d.e eVar) {
            this.a = bVarArr;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = vVar;
            this.f = eVar;
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoadFail(com.anythink.core.api.AdError adError) {
            if (this.a[0] != null) {
                com.anythink.core.common.n.c.a(this.b, this.c, this.d, this.e.a, this.f, false, "0", "0", "");
                this.a[0].onAdLoadFail(adError);
            }
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoaded() {
            if (this.a[0] != null) {
                com.anythink.core.common.n.c.a(this.b, this.c, this.d, this.e.a, this.f, true, "0", "1", "");
                this.a[0].onAdLoaded();
            }
        }
    }

    /* renamed from: com.anythink.core.common.f$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.core.common.b.b {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.anythink.core.common.f.v d;
        final /* synthetic */ com.anythink.core.d.e e;
        final /* synthetic */ com.anythink.core.common.b.b[] f;
        final /* synthetic */ android.content.Context g;

        public AnonymousClass5(java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.core.common.f.v vVar, com.anythink.core.d.e eVar, com.anythink.core.common.b.b[] bVarArr, android.content.Context context) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = vVar;
            this.e = eVar;
            this.f = bVarArr;
            this.g = context;
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoadFail(com.anythink.core.api.AdError adError) {
            com.anythink.core.common.f.b b = com.anythink.core.common.f.b(this.g, this.b, this.c, this.d);
            if (b == null) {
                com.anythink.core.common.w.a().b(this.b);
                com.anythink.core.common.n.c.a(this.a, this.b, this.c, this.d.a, this.e, false, "0", "0", "");
                com.anythink.core.common.b.b bVar = this.f[0];
                if (bVar != null) {
                    bVar.onAdLoadFail(adError);
                    return;
                }
                return;
            }
            com.anythink.core.common.o.o.a("Shared", "placementId:" + this.a + ";result_callback:success;");
            com.anythink.core.common.f.h h = b.h();
            com.anythink.core.common.n.c.a(this.a, this.b, this.c, this.d.a, this.e, true, "1", "0", h != null ? h.ad() : "");
            com.anythink.core.common.b.b bVar2 = this.f[0];
            if (bVar2 != null) {
                bVar2.onAdLoaded();
            }
        }

        @Override // com.anythink.core.common.b.b
        public final void onAdLoaded() {
            com.anythink.core.common.n.c.a(this.a, this.b, this.c, this.d.a, this.e, true, "2", "1", "");
            com.anythink.core.common.b.b bVar = this.f[0];
            if (bVar != null) {
                bVar.onAdLoaded();
            }
        }
    }

    private f(android.content.Context context, java.lang.String str) {
        this.a = context.getApplicationContext();
        this.b = str;
        if (com.anythink.core.common.b.o.a().f() == null) {
            com.anythink.core.common.b.o.a().a(this.a);
        }
    }

    private com.anythink.core.common.f.b a(android.content.Context context, boolean z, boolean z2, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f fVar, com.anythink.core.d.e eVar) {
        com.anythink.core.common.f.b bVar;
        java.lang.String str;
        double d;
        boolean z3;
        java.lang.String str2;
        java.lang.String str3;
        boolean z4;
        java.lang.String str4;
        java.lang.String j = eVar.j();
        int ag = eVar.ag();
        com.anythink.core.common.w.a();
        com.anythink.core.common.f a = com.anythink.core.common.w.a(j, java.lang.String.valueOf(ag));
        if (a != null) {
            com.anythink.core.common.f.c cVar = new com.anythink.core.common.f.c();
            a(cVar, this.b, eVar);
            bVar = a.a(context, z, z2, map, cVar);
            if (bVar != null) {
                com.anythink.core.common.o.u.a(this.b, eVar, bVar.h());
            }
        } else {
            bVar = null;
        }
        boolean z5 = true;
        java.lang.String str5 = "";
        double d2 = 0.0d;
        if (bVar != null) {
            com.anythink.core.common.f.h h = bVar.h();
            java.lang.String ad = h != null ? h.ad() : "";
            d = bVar.m();
            str = ad;
            z3 = true;
        } else {
            com.anythink.core.common.w.a().b(j);
            str = "";
            d = 0.0d;
            z3 = false;
        }
        com.anythink.core.common.f.b a2 = fVar.a(context, z, z2, map, (com.anythink.core.common.f.c) null);
        if (a2 != null) {
            com.anythink.core.common.f.h h2 = a2.h();
            if (h2 != null) {
                str5 = h2.ad();
                str4 = java.lang.String.valueOf(h2.K());
            } else {
                str4 = "";
            }
            str2 = str5;
            str3 = str4;
            d2 = a2.m();
            z4 = true;
        } else {
            str2 = "";
            str3 = str2;
            z4 = false;
        }
        if (bVar != null && (a2 == null || d > d2)) {
            a2 = bVar;
        }
        java.lang.String str6 = this.b;
        if (!z4 && !z3) {
            z5 = false;
        }
        com.anythink.core.common.n.c.a(str6, j, eVar, z5, z4, z3, str2, str, str3);
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.core.common.f a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        char c;
        com.anythink.core.common.f a = com.anythink.core.common.u.a().a(str, str2);
        if (a == null) {
            synchronized (com.anythink.core.common.f.class) {
                if (a == null) {
                    a = new com.anythink.core.common.f(context, str);
                    int hashCode = str2.hashCode();
                    if (hashCode != 49) {
                        if (hashCode == 51 && str2.equals("3")) {
                            c = 1;
                            if (c != 0 || c == 1) {
                                a.k = new com.anythink.core.common.j.a(str, str2);
                            }
                            com.anythink.core.common.u.a().a(str, str2, a);
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        a.k = new com.anythink.core.common.j.a(str, str2);
                        com.anythink.core.common.u.a().a(str, str2, a);
                    } else {
                        if (str2.equals("1")) {
                            c = 0;
                            if (c != 0) {
                            }
                            a.k = new com.anythink.core.common.j.a(str, str2);
                            com.anythink.core.common.u.a().a(str, str2, a);
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        a.k = new com.anythink.core.common.j.a(str, str2);
                        com.anythink.core.common.u.a().a(str, str2, a);
                    }
                }
            }
        }
        return a;
    }

    public static java.lang.String a(com.anythink.core.common.f.m mVar) {
        return mVar.b + mVar.c + mVar.f + java.lang.System.currentTimeMillis();
    }

    private static java.util.List<com.anythink.core.api.ATAdInfo> a(android.content.Context context, com.anythink.core.common.f fVar, com.anythink.core.d.e eVar) {
        com.anythink.core.common.f.b a;
        java.lang.String j = eVar.j();
        com.anythink.core.common.w.a();
        com.anythink.core.common.f a2 = com.anythink.core.common.w.a(j, java.lang.String.valueOf(eVar.ag()));
        com.anythink.core.api.ATAdInfo n = (a2 == null || (a = a2.a(context, false, false, (java.util.Map<java.lang.String, java.lang.Object>) null, (com.anythink.core.common.f.c) null)) == null) ? null : a.n();
        java.util.List<com.anythink.core.api.ATAdInfo> a3 = fVar.a(context);
        if (n == null) {
            return a3;
        }
        if (a3 == null || a3.size() == 0) {
            java.util.ArrayList arrayList = new java.util.ArrayList(2);
            arrayList.add(n);
            return arrayList;
        }
        com.anythink.core.api.ATAdInfo aTAdInfo = a3.get(0);
        if (aTAdInfo != null && n.getEcpm() > aTAdInfo.getEcpm()) {
            n.getEcpm();
            aTAdInfo.getEcpm();
            a3.add(0, n);
        }
        return a3;
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.b.b bVar, com.anythink.core.common.f fVar, com.anythink.core.d.e eVar) {
        java.lang.String j = eVar.j();
        com.anythink.core.common.f.c cVar = new com.anythink.core.common.f.c();
        a(cVar, str2, eVar);
        vVar.i = cVar;
        com.anythink.core.common.b.b[] bVarArr = {bVar};
        if (eVar.m() != 1) {
            fVar.a(context, str, str2, vVar, new com.anythink.core.common.f.AnonymousClass5(str2, j, str, vVar, eVar, bVarArr, context));
            return;
        }
        com.anythink.core.common.f.b b = b(context, j, str, vVar);
        if (b != null) {
            java.lang.String a = com.anythink.core.common.o.h.a(context);
            vVar.a = a;
            com.anythink.core.common.o.o.a("Shared", "placementId:" + str2 + ";result_callback:success;");
            com.anythink.core.common.f.h h = b.h();
            com.anythink.core.common.n.c.a(str2, j, str, a, eVar, true, "1", "2", h != null ? h.ad() : "");
            com.anythink.core.common.b.b bVar2 = bVarArr[0];
            if (bVar2 != null) {
                bVar2.onAdLoaded();
            }
            bVarArr[0] = null;
        } else {
            com.anythink.core.common.w.a().b(j);
        }
        fVar.a(context, str, str2, vVar, new com.anythink.core.common.f.AnonymousClass4(bVarArr, str2, j, str, vVar, eVar));
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.v vVar) {
        com.anythink.core.common.f.h hVar2;
        com.anythink.core.common.f.v vVar2;
        com.anythink.core.common.f fVar;
        boolean z;
        boolean z2;
        com.anythink.core.common.f.v vVar3;
        com.anythink.core.common.f fVar2;
        com.anythink.core.common.f.p pVar;
        com.anythink.core.common.f.au auVar;
        com.anythink.core.common.g gVar;
        boolean z3;
        com.anythink.core.common.f.p pVar2;
        com.anythink.core.common.f.ay ayVar;
        com.anythink.core.common.f.ao aoVar;
        com.anythink.core.common.f.p pVar3;
        com.anythink.core.common.f.ap apVar;
        java.util.Map<java.lang.String, java.lang.Object> map;
        com.anythink.core.common.n.c.a("1", str2, str, "", 0, eVar.ag(), 0L);
        com.anythink.core.common.f.az azVar = new com.anythink.core.common.f.az(vVar, eVar);
        if (hVar != null) {
            hVar.c(azVar.e());
            hVar.d(azVar.f());
        }
        try {
            try {
                if (eVar.aT()) {
                    try {
                        a(eVar, hVar);
                        b(eVar, hVar);
                        com.anythink.core.common.f.ao a = com.anythink.core.common.o.q.a(eVar, hVar);
                        com.anythink.core.common.f.h c = a.c();
                        if (a.b() == 0) {
                            try {
                                c.E(5);
                                if (a.a().t() != 1) {
                                    throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                                }
                                throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                            } catch (java.lang.Throwable th) {
                                th = th;
                                hVar2 = hVar;
                                vVar3 = vVar;
                                fVar2 = this;
                                z2 = true;
                                fVar2.a(z2, hVar2, th, vVar3);
                                return;
                            }
                        }
                        if (!a.g()) {
                            c.E(6);
                            com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAvailableAdsource, "", "");
                            throw new com.anythink.core.common.f.g(errorCode, errorCode.printStackTrace());
                        }
                        java.util.ArrayList arrayList = new java.util.ArrayList(1);
                        com.anythink.core.common.o.q.b(a, arrayList);
                        java.util.List<com.anythink.core.common.f.au> a2 = com.anythink.core.common.o.q.a(a, a.d());
                        com.anythink.core.common.a.a().b(str);
                        boolean z4 = arrayList.size() > 0;
                        boolean z5 = !z4 && (a.e() == null || a.e().size() == 0);
                        if (z5 && ((a2 == null || a2.size() == 0) && (a.f() == null || a.f().size() == 0))) {
                            com.anythink.core.api.AdError errorCode2 = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAvailableAdsource, "", "");
                            hVar.E(6);
                            a(true, hVar, errorCode2, vVar);
                            this.d = false;
                            return;
                        }
                        com.anythink.core.a.b.a().b(this.a, str, eVar);
                        com.anythink.core.common.n.a.a(this.a).a(10, hVar);
                        java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.u.a().b(this.b);
                        java.util.Map<java.lang.String, com.anythink.core.common.f.ay> map2 = com.anythink.core.common.x.a(this.a).a;
                        com.anythink.core.common.f.ay remove = map2 != null ? map2.remove(str) : null;
                        com.anythink.core.common.f.ap a3 = com.anythink.core.common.v.a(this.a).a(str, str2);
                        com.anythink.core.common.f.p a4 = com.anythink.core.common.d.a().a(str);
                        com.anythink.core.common.f.p pVar4 = new com.anythink.core.common.f.p(str2);
                        com.anythink.core.common.f.ap apVar2 = a3;
                        com.anythink.core.common.d.a().a(this.b, pVar4);
                        hVar.b(true);
                        hVar.w(azVar.f());
                        com.anythink.core.common.g gVar2 = new com.anythink.core.common.g(vVar.a());
                        gVar2.h = b;
                        gVar2.i = hVar;
                        gVar2.a(vVar);
                        gVar2.a(vVar.e);
                        this.e = str2;
                        this.m = hVar.V();
                        java.util.List<com.anythink.core.common.f.au> a5 = com.anythink.core.d.k.a(eVar, eVar.O());
                        if (a5.size() > 0) {
                            pVar = pVar4;
                            auVar = a5.get(0);
                        } else {
                            pVar = pVar4;
                            auVar = null;
                        }
                        if (auVar != null) {
                            for (com.anythink.core.common.f.au auVar2 : a.e()) {
                                if (auVar2.u().equals(auVar.u())) {
                                    gVar = gVar2;
                                    com.anythink.core.common.f.ap apVar3 = apVar2;
                                    z3 = z5;
                                    pVar2 = a4;
                                    ayVar = remove;
                                    map = b;
                                    aoVar = a;
                                    pVar3 = pVar;
                                    apVar = apVar3;
                                    gVar.H = com.anythink.core.common.a.b.a().a(context, str, str2, auVar2, eVar, map);
                                } else {
                                    gVar = gVar2;
                                    z3 = z5;
                                    pVar2 = a4;
                                    ayVar = remove;
                                    aoVar = a;
                                    pVar3 = pVar;
                                    apVar = apVar2;
                                    map = b;
                                }
                                gVar2 = gVar;
                                a4 = pVar2;
                                z5 = z3;
                                remove = ayVar;
                                b = map;
                                pVar = pVar3;
                                apVar2 = apVar;
                                a = aoVar;
                            }
                        }
                        com.anythink.core.common.g gVar3 = gVar2;
                        boolean z6 = z5;
                        com.anythink.core.common.f.p pVar5 = a4;
                        com.anythink.core.common.f.ay ayVar2 = remove;
                        com.anythink.core.common.f.ao aoVar2 = a;
                        com.anythink.core.common.f.ap apVar4 = apVar2;
                        com.anythink.core.common.p.h hVar3 = new com.anythink.core.common.p.h(a2);
                        com.anythink.core.common.p.g gVar4 = new com.anythink.core.common.p.g();
                        gVar4.a = str;
                        gVar4.b = str2;
                        gVar4.c = azVar;
                        gVar4.d = a2;
                        gVar4.f = z6;
                        gVar4.g = hVar.Y();
                        gVar4.h = ayVar2;
                        gVar4.j = apVar4;
                        gVar4.i = hVar3;
                        gVar4.l = pVar5;
                        gVar4.k = pVar;
                        gVar4.e = aoVar2.f();
                        gVar3.a(gVar4);
                        this.c.put(str2, gVar3);
                        gVar3.b();
                        this.d = false;
                        if (z6) {
                            return;
                        }
                        com.anythink.core.common.o.b.b.a().c(new com.anythink.core.common.f.AnonymousClass2(context, vVar, str2, str, eVar, z4, aoVar2.e(), azVar, hVar, ayVar2, apVar4, pVar5, hVar3));
                        return;
                    } catch (com.anythink.core.common.f.g e) {
                        e = e;
                        z = true;
                        fVar = this;
                        hVar2 = hVar;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        z2 = true;
                        fVar2 = this;
                        hVar2 = hVar;
                        vVar3 = vVar;
                        fVar2.a(z2, hVar2, th, vVar3);
                        return;
                    }
                } else {
                    hVar2 = hVar;
                    try {
                        hVar2.E(5);
                        throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.placementAdClose, "", ""), "Strategy is close.");
                    } catch (com.anythink.core.common.f.g e2) {
                        e = e2;
                        z = true;
                        fVar = this;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        z2 = true;
                        fVar2 = this;
                        vVar3 = vVar;
                        fVar2.a(z2, hVar2, th, vVar3);
                        return;
                    }
                }
                vVar2 = vVar;
            } catch (com.anythink.core.common.f.g e3) {
                e = e3;
                hVar2 = hVar;
                vVar2 = vVar;
                fVar = this;
                z = true;
            }
            fVar.a(z, hVar2, e, vVar2);
        } catch (java.lang.Throwable th4) {
            th = th4;
            hVar2 = hVar;
        }
    }

    private static void a(com.anythink.core.common.f.ao aoVar) {
        com.anythink.core.common.f.h c = aoVar.c();
        if (aoVar.b() == 0) {
            c.E(5);
            if (aoVar.a().t() != 1) {
                throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
            }
            throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
        }
        if (aoVar.g()) {
            return;
        }
        c.E(6);
        com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAvailableAdsource, "", "");
        throw new com.anythink.core.common.f.g(errorCode, errorCode.printStackTrace());
    }

    private static void a(com.anythink.core.common.f.c cVar, java.lang.String str, com.anythink.core.d.e eVar) {
        cVar.a(str, eVar.an(), eVar.Y());
    }

    public static /* synthetic */ void a(com.anythink.core.common.f fVar, android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar, com.anythink.core.common.f.v vVar) {
        com.anythink.core.common.f.h hVar2;
        com.anythink.core.common.f.v vVar2;
        com.anythink.core.common.f.v vVar3;
        com.anythink.core.common.f.p pVar;
        com.anythink.core.common.f.au auVar;
        boolean z;
        com.anythink.core.common.f.p pVar2;
        com.anythink.core.common.f.ay ayVar;
        com.anythink.core.common.f.p pVar3;
        com.anythink.core.common.f.ap apVar;
        java.util.Map<java.lang.String, java.lang.Object> map;
        com.anythink.core.common.f.ao aoVar;
        java.util.List<com.anythink.core.common.f.au> list;
        com.anythink.core.common.n.c.a("1", str2, str, "", 0, eVar.ag(), 0L);
        com.anythink.core.common.f.az azVar = new com.anythink.core.common.f.az(vVar, eVar);
        if (hVar != null) {
            hVar.c(azVar.e());
            hVar.d(azVar.f());
        }
        try {
            try {
                if (!eVar.aT()) {
                    hVar2 = hVar;
                    try {
                        hVar2.E(5);
                        throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.placementAdClose, "", ""), "Strategy is close.");
                    } catch (com.anythink.core.common.f.g e) {
                        e = e;
                        vVar2 = vVar;
                        fVar.a(true, hVar2, (java.lang.Throwable) e, vVar2);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        vVar3 = vVar;
                        fVar.a(true, hVar2, th, vVar3);
                    }
                }
                try {
                    a(eVar, hVar);
                    b(eVar, hVar);
                    com.anythink.core.common.f.ao a = com.anythink.core.common.o.q.a(eVar, hVar);
                    com.anythink.core.common.f.h c = a.c();
                    if (a.b() == 0) {
                        try {
                            c.E(5);
                            if (a.a().t() != 1) {
                                throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAdsourceConfig, "", ""), "No Adsource.");
                            }
                            throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAdsourceConfigInDebugerMode, "", ""), "No Adsource.");
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            hVar2 = hVar;
                            vVar3 = vVar;
                            fVar.a(true, hVar2, th, vVar3);
                        }
                    }
                    if (!a.g()) {
                        c.E(6);
                        com.anythink.core.api.AdError errorCode = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAvailableAdsource, "", "");
                        throw new com.anythink.core.common.f.g(errorCode, errorCode.printStackTrace());
                    }
                    java.util.ArrayList arrayList = new java.util.ArrayList(1);
                    com.anythink.core.common.o.q.b(a, arrayList);
                    java.util.List<com.anythink.core.common.f.au> a2 = com.anythink.core.common.o.q.a(a, a.d());
                    com.anythink.core.common.a.a().b(str);
                    boolean z2 = arrayList.size() > 0;
                    boolean z3 = !z2 && (a.e() == null || a.e().size() == 0);
                    if (z3 && ((a2 == null || a2.size() == 0) && (a.f() == null || a.f().size() == 0))) {
                        com.anythink.core.api.AdError errorCode2 = com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.noAvailableAdsource, "", "");
                        hVar.E(6);
                        fVar.a(true, hVar, errorCode2, vVar);
                        fVar.d = false;
                        return;
                    }
                    com.anythink.core.a.b.a().b(fVar.a, str, eVar);
                    com.anythink.core.common.n.a.a(fVar.a).a(10, hVar);
                    java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.u.a().b(fVar.b);
                    java.util.Map<java.lang.String, com.anythink.core.common.f.ay> map2 = com.anythink.core.common.x.a(fVar.a).a;
                    com.anythink.core.common.f.ay remove = map2 != null ? map2.remove(str) : null;
                    com.anythink.core.common.f.ap a3 = com.anythink.core.common.v.a(fVar.a).a(str, str2);
                    com.anythink.core.common.f.p a4 = com.anythink.core.common.d.a().a(str);
                    com.anythink.core.common.f.p pVar4 = new com.anythink.core.common.f.p(str2);
                    com.anythink.core.common.f.ap apVar2 = a3;
                    com.anythink.core.common.d.a().a(fVar.b, pVar4);
                    hVar.b(true);
                    hVar.w(azVar.f());
                    com.anythink.core.common.g gVar = new com.anythink.core.common.g(vVar.a());
                    gVar.h = b;
                    gVar.i = hVar;
                    gVar.a(vVar);
                    gVar.a(vVar.e);
                    fVar.e = str2;
                    fVar.m = hVar.V();
                    java.util.List<com.anythink.core.common.f.au> a5 = com.anythink.core.d.k.a(eVar, eVar.O());
                    if (a5.size() > 0) {
                        pVar = pVar4;
                        auVar = a5.get(0);
                    } else {
                        pVar = pVar4;
                        auVar = null;
                    }
                    if (auVar != null) {
                        for (com.anythink.core.common.f.au auVar2 : a.e()) {
                            if (auVar2.u().equals(auVar.u())) {
                                com.anythink.core.common.f.ap apVar3 = apVar2;
                                z = z3;
                                pVar2 = a4;
                                ayVar = remove;
                                map = b;
                                apVar = apVar3;
                                com.anythink.core.common.f.p pVar5 = pVar;
                                aoVar = a;
                                pVar3 = pVar5;
                                list = a2;
                                gVar.H = com.anythink.core.common.a.b.a().a(context, str, str2, auVar2, eVar, map);
                            } else {
                                z = z3;
                                pVar2 = a4;
                                ayVar = remove;
                                pVar3 = pVar;
                                apVar = apVar2;
                                map = b;
                                aoVar = a;
                                list = a2;
                            }
                            z3 = z;
                            remove = ayVar;
                            a4 = pVar2;
                            a2 = list;
                            a = aoVar;
                            b = map;
                            pVar = pVar3;
                            apVar2 = apVar;
                        }
                    }
                    boolean z4 = z3;
                    com.anythink.core.common.f.p pVar6 = a4;
                    com.anythink.core.common.f.ay ayVar2 = remove;
                    com.anythink.core.common.f.p pVar7 = pVar;
                    com.anythink.core.common.f.ap apVar4 = apVar2;
                    com.anythink.core.common.f.ao aoVar2 = a;
                    java.util.List<com.anythink.core.common.f.au> list2 = a2;
                    com.anythink.core.common.p.h hVar3 = new com.anythink.core.common.p.h(list2);
                    com.anythink.core.common.p.g gVar2 = new com.anythink.core.common.p.g();
                    gVar2.a = str;
                    gVar2.b = str2;
                    gVar2.c = azVar;
                    gVar2.d = list2;
                    gVar2.f = z4;
                    gVar2.g = hVar.Y();
                    gVar2.h = ayVar2;
                    gVar2.j = apVar4;
                    gVar2.i = hVar3;
                    gVar2.l = pVar6;
                    gVar2.k = pVar7;
                    gVar2.e = aoVar2.f();
                    gVar.a(gVar2);
                    fVar.c.put(str2, gVar);
                    gVar.b();
                    fVar.d = false;
                    if (z4) {
                        return;
                    }
                    com.anythink.core.common.o.b.b.a().c(fVar.new AnonymousClass2(context, vVar, str2, str, eVar, z2, aoVar2.e(), azVar, hVar, ayVar2, apVar4, pVar6, hVar3));
                } catch (com.anythink.core.common.f.g e2) {
                    e = e2;
                    hVar2 = hVar;
                    vVar2 = vVar;
                    fVar.a(true, hVar2, (java.lang.Throwable) e, vVar2);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    hVar2 = hVar;
                    vVar3 = vVar;
                    fVar.a(true, hVar2, th, vVar3);
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                hVar2 = hVar;
            }
        } catch (com.anythink.core.common.f.g e3) {
            e = e3;
            hVar2 = hVar;
            vVar2 = vVar;
        }
    }

    private void a(com.anythink.core.common.j.d dVar) {
        this.k = dVar;
    }

    public static void a(com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar) {
        if (com.anythink.core.a.a.a(com.anythink.core.common.b.o.a().f()).a(eVar, hVar.ac())) {
            hVar.E(1);
            throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.outOfCapError, "", ""), "Capping.");
        }
    }

    private void a(java.lang.String str, com.anythink.core.common.b.b bVar) {
        com.anythink.core.common.j.c cVar = this.i;
        if (cVar != null) {
            cVar.a(str, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.f.h hVar, com.anythink.core.api.AdError adError, com.anythink.core.common.f.v vVar) {
        this.d = false;
        hVar.b(false);
        if (z) {
            com.anythink.core.common.n.a.a(this.a).a(10, hVar);
            com.anythink.core.common.n.c.a(hVar, adError);
        }
        a(vVar, adError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.anythink.core.common.f.h hVar, java.lang.Throwable th, com.anythink.core.common.f.v vVar) {
        a(z, hVar, th instanceof com.anythink.core.common.f.g ? ((com.anythink.core.common.f.g) th).a : com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.exception, "", th.getMessage()), vVar);
    }

    public static /* synthetic */ boolean a(com.anythink.core.common.f fVar) {
        com.anythink.core.common.j.e eVar = fVar.j;
        return eVar != null ? eVar.b() : !android.text.TextUtils.isEmpty(fVar.e);
    }

    public static /* synthetic */ boolean a(com.anythink.core.common.f fVar, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.n nVar) {
        com.anythink.core.common.j.e eVar = fVar.j;
        if (eVar != null) {
            return eVar.a(fVar.a, str, str2, vVar, nVar);
        }
        return false;
    }

    private boolean a(java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.n nVar) {
        com.anythink.core.common.j.e eVar = this.j;
        if (eVar != null) {
            return eVar.a(this.a, str, str2, vVar, nVar);
        }
        return false;
    }

    private boolean a(boolean z, boolean z2, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.b);
        java.lang.String str = android.text.TextUtils.isEmpty(this.e) ? "" : this.e;
        if (a == null) {
            a = com.anythink.core.d.f.a(this.a).a(this.b);
        }
        com.anythink.core.d.e eVar = a;
        if (eVar == null) {
            if (z) {
                com.anythink.core.common.n.c.a(str, this.b, eVar, 4, "", map);
            } else if (z2) {
                com.anythink.core.common.n.c.a(str, this.b, false, 4, eVar, (com.anythink.core.common.f.b) null, "", "", map, cVar);
            }
            return true;
        }
        com.anythink.core.a.c.a();
        if (com.anythink.core.a.c.a(this.b, eVar)) {
            if (z) {
                com.anythink.core.common.n.c.a(str, this.b, eVar, 3, "", map);
            } else if (z2) {
                com.anythink.core.common.n.c.a(str, this.b, false, 3, eVar, (com.anythink.core.common.f.b) null, "", "", map, cVar);
            }
            return true;
        }
        if (!com.anythink.core.a.a.a(this.a).a(eVar, this.b)) {
            return false;
        }
        if (z) {
            com.anythink.core.common.n.c.a(str, this.b, eVar, 2, "", map);
        } else if (z2) {
            com.anythink.core.common.n.c.a(str, this.b, false, 2, eVar, (com.anythink.core.common.f.b) null, "", "", map, cVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.anythink.core.common.f.b b(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar) {
        com.anythink.core.common.w.a();
        com.anythink.core.common.f a = com.anythink.core.common.w.a(str, str2);
        if (a != null) {
            return a.a(context, true, false, vVar.g, vVar.i);
        }
        return null;
    }

    public static void b(com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar) {
        com.anythink.core.a.c.a();
        if (com.anythink.core.a.c.a(hVar.ac(), eVar)) {
            hVar.E(2);
            throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.inPacingError, "", ""), "Pacing.");
        }
    }

    public static /* synthetic */ void c(com.anythink.core.common.f fVar) {
        com.anythink.core.common.j.d dVar = fVar.k;
        if (dVar != null) {
            dVar.c();
        }
    }

    private static void c(com.anythink.core.d.e eVar, com.anythink.core.common.f.h hVar) {
        if (eVar.aT()) {
            return;
        }
        hVar.E(5);
        throw new com.anythink.core.common.f.g(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.placementAdClose, "", ""), "Strategy is close.");
    }

    public static /* synthetic */ boolean d(com.anythink.core.common.f fVar) {
        com.anythink.core.common.j.e eVar = fVar.j;
        return eVar != null && eVar.a();
    }

    private boolean h() {
        return java.lang.System.currentTimeMillis() - this.o <= 2000;
    }

    private boolean i() {
        com.anythink.core.common.j.e eVar = this.j;
        return eVar != null && eVar.a();
    }

    private boolean j() {
        com.anythink.core.common.j.e eVar = this.j;
        return eVar != null ? eVar.b() : !android.text.TextUtils.isEmpty(this.e);
    }

    public static /* synthetic */ boolean j(com.anythink.core.common.f fVar) {
        fVar.n = false;
        return false;
    }

    public static /* synthetic */ long k(com.anythink.core.common.f fVar) {
        fVar.o = 0L;
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        com.anythink.core.common.j.d dVar = this.k;
        return dVar != null && dVar.a();
    }

    private void l() {
        com.anythink.core.common.j.d dVar = this.k;
        if (dVar != null) {
            dVar.c();
        }
    }

    private void m() {
        com.anythink.core.common.j.d dVar = this.k;
        if (dVar != null) {
            dVar.b();
        }
    }

    public final com.anythink.core.api.ATAdStatusInfo a(android.content.Context context, java.util.Map<java.lang.String, java.lang.Object> map) {
        boolean f = f();
        com.anythink.core.common.f.b a = a(context, true, false, map);
        com.anythink.core.api.ATAdStatusInfo aTAdStatusInfo = new com.anythink.core.api.ATAdStatusInfo(f, a != null, a != null ? a.n() : null);
        if (this.k != null) {
            if (!(java.lang.System.currentTimeMillis() - this.o <= 2000) && a(aTAdStatusInfo) && (c() <= 0 || !aTAdStatusInfo.isReady())) {
                this.k.a(context, 5);
            }
        }
        return aTAdStatusInfo;
    }

    public final com.anythink.core.common.f.b a(android.content.Context context, boolean z, boolean z2, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (com.anythink.core.common.w.a().b()) {
            com.anythink.core.d.e a = com.anythink.core.d.f.a(context).a(this.b);
            if (a != null && com.anythink.core.common.w.a().c(this.b)) {
                return null;
            }
            if (com.anythink.core.common.w.a().a(a)) {
                return a(context, z, z2, map, this, a);
            }
        }
        return a(context, z, z2, map, (com.anythink.core.common.f.c) null);
    }

    public final com.anythink.core.common.f.b a(android.content.Context context, boolean z, boolean z2, java.util.Map<java.lang.String, java.lang.Object> map, com.anythink.core.common.f.c cVar) {
        com.anythink.core.common.j.e eVar;
        if (a(z2, z, map, cVar)) {
            return null;
        }
        com.anythink.core.common.f.b a = com.anythink.core.common.a.a().a(context, this.b, z, z2, map, cVar);
        return (a != null || (eVar = this.j) == null) ? a : eVar.a(this.b, z, map, cVar);
    }

    public final com.anythink.core.common.j.d a() {
        return this.k;
    }

    public final java.util.List<com.anythink.core.api.ATAdInfo> a(android.content.Context context) {
        java.util.List<com.anythink.core.common.f.b> a;
        if (a(false, false, (java.util.Map<java.lang.String, java.lang.Object>) null, (com.anythink.core.common.f.c) null) || (a = com.anythink.core.common.a.a().a(context, this.b, false, false, true, (java.util.Map<java.lang.String, java.lang.Object>) null, (com.anythink.core.common.f.c) null)) == null || a.size() <= 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(3);
        java.util.Iterator<com.anythink.core.common.f.b> it = a.iterator();
        while (it.hasNext()) {
            com.anythink.core.common.f.b next = it.next();
            com.anythink.core.api.BaseAd e = next != null ? next.e() : null;
            com.anythink.core.api.ATBaseAdAdapter d = next != null ? next.d() : null;
            if (e != null) {
                arrayList.add(com.anythink.core.common.b.k.a(e));
            } else if (d != null) {
                arrayList.add(com.anythink.core.common.b.k.a(d));
            }
        }
        return arrayList;
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.b.b bVar) {
        java.util.Map<java.lang.String, java.lang.Object> b = com.anythink.core.common.u.a().b(str2);
        int[] iArr = {0};
        if (b.containsKey(com.anythink.core.common.f.at.N)) {
            try {
                iArr[0] = ((java.lang.Integer) b.get(com.anythink.core.common.f.at.N)).intValue();
            } catch (java.lang.Throwable unused) {
            }
        }
        int i = vVar.d;
        if (i == 0 || i == 3) {
            com.anythink.core.common.u.a().a(str2, new java.lang.Throwable().getStackTrace());
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.f.AnonymousClass1(vVar, str2, str, bVar, context, iArr, b), 2, true);
    }

    public final void a(com.anythink.core.api.AdError adError) {
        com.anythink.core.common.j.d dVar = this.k;
        if (dVar != null) {
            dVar.a(adError, this.f);
        }
    }

    public final void a(com.anythink.core.common.f.aw awVar, com.anythink.core.d.e eVar) {
        com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.b);
        if (a != null) {
            boolean z = true;
            if (eVar != null && (android.text.TextUtils.equals(a.ad(), eVar.ad()) || a.ay())) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        synchronized (this.h) {
            this.h.add(awVar);
        }
    }

    public final void a(com.anythink.core.common.f.b bVar) {
        java.util.List<com.anythink.core.common.f.aw> list;
        if (bVar == null || (list = this.h) == null) {
            return;
        }
        synchronized (list) {
            if (this.h.size() > 0) {
                this.h.remove(0);
            }
        }
    }

    public final void a(com.anythink.core.common.f.v vVar, com.anythink.core.api.AdError adError) {
        com.anythink.core.common.n nVar = this.g;
        if (nVar != null) {
            nVar.a(1, vVar, null, adError);
        }
    }

    public final void a(com.anythink.core.common.j.c cVar) {
        this.i = cVar;
    }

    public final void a(com.anythink.core.common.j.e eVar) {
        this.j = eVar;
    }

    public final void a(java.lang.String str) {
        this.c.remove(str);
    }

    public final void a(java.lang.String str, double d, com.anythink.core.common.f.au auVar) {
        com.anythink.core.common.g gVar = this.c.get(str);
        if (gVar != null) {
            gVar.a(d, auVar);
        }
    }

    public final boolean a(com.anythink.core.api.ATAdStatusInfo aTAdStatusInfo) {
        com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.a().f()).a(this.b);
        if (a == null || c() < a.g() || aTAdStatusInfo == null || !aTAdStatusInfo.isReady()) {
            return k() || (a != null && a.ae() == 1);
        }
        return false;
    }

    public final com.anythink.core.common.g b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public final java.util.List<com.anythink.core.api.ATAdInfo> b(android.content.Context context) {
        com.anythink.core.common.f.b a;
        if (com.anythink.core.common.w.a().b()) {
            com.anythink.core.d.e a2 = com.anythink.core.d.f.a(context).a(this.b);
            com.anythink.core.api.ATAdInfo aTAdInfo = null;
            if (a2 != null && com.anythink.core.common.w.a().c(this.b)) {
                return null;
            }
            if (com.anythink.core.common.w.a().a(a2)) {
                java.lang.String j = a2.j();
                com.anythink.core.common.w.a();
                com.anythink.core.common.f a3 = com.anythink.core.common.w.a(j, java.lang.String.valueOf(a2.ag()));
                if (a3 != null && (a = a3.a(context, false, false, (java.util.Map<java.lang.String, java.lang.Object>) null, (com.anythink.core.common.f.c) null)) != null) {
                    aTAdInfo = a.n();
                }
                java.util.List<com.anythink.core.api.ATAdInfo> a4 = a(context);
                if (aTAdInfo == null) {
                    return a4;
                }
                if (a4 == null || a4.size() == 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList(2);
                    arrayList.add(aTAdInfo);
                    return arrayList;
                }
                com.anythink.core.api.ATAdInfo aTAdInfo2 = a4.get(0);
                if (aTAdInfo2 == null || aTAdInfo.getEcpm() <= aTAdInfo2.getEcpm()) {
                    return a4;
                }
                aTAdInfo.getEcpm();
                aTAdInfo2.getEcpm();
                a4.add(0, aTAdInfo);
                return a4;
            }
        }
        return a(context);
    }

    public final void b() {
        synchronized (this.h) {
            this.h.clear();
        }
    }

    public final void b(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.common.f.v vVar, com.anythink.core.common.b.b bVar) {
        if (com.anythink.core.common.w.a().b()) {
            com.anythink.core.d.e a = com.anythink.core.d.f.a(context).a(this.b);
            if (a != null && com.anythink.core.common.w.a().c(this.b)) {
                if (bVar != null) {
                    bVar.onAdLoadFail(com.anythink.core.api.ErrorCode.getErrorCode(com.anythink.core.api.ErrorCode.sharedPlacementIdError, "", ""));
                    return;
                }
                return;
            }
            if (com.anythink.core.common.w.a().a(a)) {
                java.lang.String j = a.j();
                com.anythink.core.common.f.c cVar = new com.anythink.core.common.f.c();
                a(cVar, str2, a);
                vVar.i = cVar;
                com.anythink.core.common.b.b[] bVarArr = {bVar};
                if (a.m() != 1) {
                    a(context, str, str2, vVar, new com.anythink.core.common.f.AnonymousClass5(str2, j, str, vVar, a, bVarArr, context));
                    return;
                }
                com.anythink.core.common.f.b b = b(context, j, str, vVar);
                if (b != null) {
                    java.lang.String a2 = com.anythink.core.common.o.h.a(context);
                    vVar.a = a2;
                    com.anythink.core.common.o.o.a("Shared", "placementId:" + str2 + ";result_callback:success;");
                    com.anythink.core.common.f.h h = b.h();
                    com.anythink.core.common.n.c.a(str2, j, str, a2, a, true, "1", "2", h != null ? h.ad() : "");
                    com.anythink.core.common.b.b bVar2 = bVarArr[0];
                    if (bVar2 != null) {
                        bVar2.onAdLoaded();
                    }
                    bVarArr[0] = null;
                } else {
                    com.anythink.core.common.w.a().b(j);
                }
                a(context, str, str2, vVar, new com.anythink.core.common.f.AnonymousClass4(bVarArr, str2, j, str, vVar, a));
                return;
            }
        }
        a(context, str, str2, vVar, bVar);
    }

    public final int c() {
        java.util.List<com.anythink.core.common.f.aw> list = this.h;
        int i = 0;
        if (list != null) {
            synchronized (list) {
                java.util.Iterator<com.anythink.core.common.f.aw> it = this.h.iterator();
                while (it.hasNext()) {
                    com.anythink.core.common.f.aw next = it.next();
                    if (next == null || !next.a()) {
                        it.remove();
                    } else {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    public final void c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.f.AnonymousClass3(str), 2, true);
    }

    public final void d() {
        this.n = false;
        this.o = 0L;
        this.p = false;
    }

    public final void e() {
        com.anythink.core.d.e b = com.anythink.core.d.f.a(this.a).b(this.b);
        if (this.n || b == null) {
            return;
        }
        this.n = true;
        this.o = java.lang.System.currentTimeMillis();
    }

    public final boolean f() {
        com.anythink.core.common.g gVar;
        if (this.d) {
            return true;
        }
        return (android.text.TextUtils.isEmpty(this.e) || (gVar = this.c.get(this.e)) == null || gVar.c()) ? false : true;
    }

    public final java.lang.String g() {
        return this.e;
    }
}
