package com.anythink.basead.d.a;

/* loaded from: classes12.dex */
public class b {
    private static volatile com.anythink.basead.d.a.b c;
    private final java.lang.String b = getClass().getSimpleName();
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.a.h> a = new java.util.concurrent.ConcurrentHashMap<>(2);

    /* renamed from: com.anythink.basead.d.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.j a;
        final /* synthetic */ com.anythink.core.common.f.m b;
        final /* synthetic */ com.anythink.expressad.foundation.d.d c;
        final /* synthetic */ com.anythink.basead.d.a.b.a d;

        /* renamed from: com.anythink.basead.d.a.b$1$1, reason: invalid class name and collision with other inner class name */
        public class C01341 implements com.anythink.expressad.out.d {
            public C01341() {
            }

            @Override // com.anythink.expressad.out.d
            public final void a() {
                com.anythink.expressad.splash.d.c cVar = (com.anythink.expressad.splash.d.c) com.anythink.basead.d.a.b.this.a.remove(com.anythink.basead.d.a.b.AnonymousClass1.this.b.b + com.anythink.basead.d.a.b.AnonymousClass1.this.b.a);
                if (cVar != null) {
                    com.anythink.basead.d.a.b.a aVar = com.anythink.basead.d.a.b.AnonymousClass1.this.d;
                    if (aVar != null) {
                        aVar.b(cVar);
                        return;
                    }
                    return;
                }
                if (com.anythink.basead.d.a.b.AnonymousClass1.this.d != null) {
                    com.anythink.basead.d.a.b.AnonymousClass1.this.d.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.m, "Resource download fail."));
                }
            }

            @Override // com.anythink.expressad.out.d
            public final void a(java.lang.String str) {
                com.anythink.basead.d.a.b.AnonymousClass1 anonymousClass1 = com.anythink.basead.d.a.b.AnonymousClass1.this;
                com.anythink.basead.d.a.b.a(com.anythink.basead.d.a.b.this, str, anonymousClass1.b, anonymousClass1.d);
            }

            @Override // com.anythink.expressad.out.d
            public final void b() {
            }
        }

        public AnonymousClass1(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.b.a aVar) {
            this.a = jVar;
            this.b = mVar;
            this.c = dVar;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.d.c cVar = new com.anythink.expressad.splash.d.c(com.anythink.core.common.b.o.a().f(), "", android.text.TextUtils.isEmpty(this.a.Y()) ? this.b.c : this.a.Y());
            cVar.b(this.b.n.v() == 0);
            int t = ((int) this.b.n.t()) / 1000;
            if (t <= 2) {
                cVar.b(2);
            } else if (t >= 10) {
                cVar.b(10);
            } else {
                cVar.b(t);
            }
            cVar.a(this.b.n.D() == 0);
            cVar.a(this.b.n.w());
            cVar.f();
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList = this.c.J;
            if (arrayList != null && arrayList.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar2 : arrayList) {
                    if (cVar2 != null) {
                        java.lang.String c = cVar2.c();
                        if (!android.text.TextUtils.isEmpty(c)) {
                            boolean z = this.b.n.D() == 0;
                            boolean z2 = com.anythink.expressad.shake.a.a().b() && this.b.n.Q() == 1;
                            c = com.anythink.basead.d.a.b.b(com.anythink.basead.d.a.b.c(c, z), z2, this.b.n.R(), this.b.n.S());
                            if (!z2 && !z) {
                                c = com.anythink.basead.d.a.b.b(c, true);
                            } else if (z2) {
                                c = com.anythink.basead.d.a.b.b(c, false);
                            }
                        }
                        cVar2.a(c);
                    }
                }
            }
            cVar.a(new com.anythink.basead.d.a.b.AnonymousClass1.C01341());
            com.anythink.basead.d.a.b.a aVar = this.d;
            if (aVar != null) {
                aVar.a(cVar);
            }
            com.anythink.basead.d.a.b.this.a.put(this.b.b + this.b.a, cVar);
            cVar.a(this.c);
        }
    }

    /* renamed from: com.anythink.basead.d.a.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.out.h {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.a.b.a b;

        public AnonymousClass2(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.b.a aVar) {
            this.a = mVar;
            this.b = aVar;
        }

        @Override // com.anythink.expressad.out.h
        public final void a() {
            com.anythink.expressad.out.TemplateBannerView templateBannerView = (com.anythink.expressad.out.TemplateBannerView) com.anythink.basead.d.a.b.this.a.remove(this.a.b + this.a.a);
            if (templateBannerView != null) {
                com.anythink.basead.d.a.b.a aVar = this.b;
                if (aVar != null) {
                    aVar.b(templateBannerView);
                    return;
                }
                return;
            }
            if (this.b != null) {
                this.b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.m, "Resource download fail."));
            }
        }

        @Override // com.anythink.expressad.out.h
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
        }

        @Override // com.anythink.expressad.out.h
        public final void a(java.lang.String str) {
            com.anythink.basead.d.a.b.a(com.anythink.basead.d.a.b.this, str, this.a, this.b);
        }

        @Override // com.anythink.expressad.out.h
        public final void b() {
        }

        @Override // com.anythink.expressad.out.h
        public final void c() {
        }

        @Override // com.anythink.expressad.out.h
        public final void d() {
        }

        @Override // com.anythink.expressad.out.h
        public final void e() {
        }

        @Override // com.anythink.expressad.out.h
        public final void f() {
        }
    }

    /* renamed from: com.anythink.basead.d.a.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.videocommon.d.a {
        final /* synthetic */ com.anythink.core.common.f.m a;
        final /* synthetic */ com.anythink.basead.d.a.b.a b;

        public AnonymousClass3(com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.b.a aVar) {
            this.a = mVar;
            this.b = aVar;
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a(java.lang.String str) {
            com.anythink.basead.d.a.b.a(com.anythink.basead.d.a.b.this, str, this.a, this.b);
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void a(boolean z, java.lang.String str, float f) {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void b() {
            com.anythink.expressad.reward.b.a aVar = (com.anythink.expressad.reward.b.a) com.anythink.basead.d.a.b.this.a.remove(this.a.b + this.a.a);
            if (aVar == null || !aVar.isReady()) {
                if (this.b != null) {
                    this.b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.m, "Resource download fail."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.a.b.a aVar2 = this.b;
            if (aVar2 != null) {
                aVar2.b(aVar);
            }
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void b(java.lang.String str) {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void c() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void d() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void e() {
        }

        @Override // com.anythink.expressad.videocommon.d.a
        public final void f() {
        }
    }

    /* renamed from: com.anythink.basead.d.a.b$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.common.f.j a;
        final /* synthetic */ com.anythink.core.common.f.m b;
        final /* synthetic */ com.anythink.basead.d.a.b.a c;
        final /* synthetic */ com.anythink.expressad.foundation.d.d d;

        /* renamed from: com.anythink.basead.d.a.b$4$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.expressad.out.o {
            public AnonymousClass1() {
            }

            @Override // com.anythink.expressad.out.o
            public final void a() {
                com.anythink.expressad.advanced.d.c cVar = (com.anythink.expressad.advanced.d.c) com.anythink.basead.d.a.b.this.a.remove(com.anythink.basead.d.a.b.AnonymousClass4.this.b.b + com.anythink.basead.d.a.b.AnonymousClass4.this.b.a);
                if (cVar != null) {
                    com.anythink.basead.d.a.b.a aVar = com.anythink.basead.d.a.b.AnonymousClass4.this.c;
                    if (aVar != null) {
                        aVar.b(cVar);
                        return;
                    }
                    return;
                }
                if (com.anythink.basead.d.a.b.AnonymousClass4.this.c != null) {
                    com.anythink.basead.d.a.b.AnonymousClass4.this.c.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.n, com.anythink.basead.c.f.I));
                }
            }

            @Override // com.anythink.expressad.out.o
            public final void a(com.anythink.expressad.foundation.d.c cVar) {
            }

            @Override // com.anythink.expressad.out.o
            public final void a(java.lang.String str) {
                com.anythink.basead.d.a.b.AnonymousClass4 anonymousClass4 = com.anythink.basead.d.a.b.AnonymousClass4.this;
                com.anythink.basead.d.a.b.a(com.anythink.basead.d.a.b.this, str, anonymousClass4.b, anonymousClass4.c);
            }

            @Override // com.anythink.expressad.out.o
            public final void b() {
            }

            @Override // com.anythink.expressad.out.o
            public final void c() {
            }

            @Override // com.anythink.expressad.out.o
            public final void d() {
            }

            @Override // com.anythink.expressad.out.o
            public final void e() {
            }

            @Override // com.anythink.expressad.out.o
            public final void f() {
            }
        }

        public AnonymousClass4(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.b.a aVar, com.anythink.expressad.foundation.d.d dVar) {
            this.a = jVar;
            this.b = mVar;
            this.c = aVar;
            this.d = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.advanced.d.c cVar = new com.anythink.expressad.advanced.d.c("", android.text.TextUtils.isEmpty(this.a.Y()) ? this.b.c : this.a.Y(), com.anythink.core.common.b.o.a().f());
            cVar.a(new com.anythink.basead.d.a.b.AnonymousClass4.AnonymousClass1());
            com.anythink.basead.d.a.b.a aVar = this.c;
            if (aVar != null) {
                aVar.a(cVar);
            }
            com.anythink.basead.d.a.b.this.a.put(this.b.b + this.b.a, cVar);
            cVar.a(this.d);
        }
    }

    public interface a {
        void a(com.anythink.basead.c.e eVar);

        void a(com.anythink.core.common.a.h hVar);

        void b(com.anythink.core.common.a.h hVar);
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.anythink.basead.a.b a(com.anythink.basead.a.b bVar, com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.d.a aG;
        com.anythink.core.common.f.n n = bVar.b().n();
        if (bVar.b().s().equals(cVar.aZ())) {
            a(bVar.b(), cVar);
            return bVar;
        }
        com.anythink.core.common.f.j jVar = new com.anythink.core.common.f.j();
        a(jVar, cVar);
        jVar.k(cVar.aZ());
        int Q = cVar.Q();
        if (Q != 0) {
            if (Q == 1 || Q == 2) {
                jVar.g(1);
            } else if (Q != 3) {
                if (Q != 4) {
                    if (Q != 5) {
                        if (Q != 8) {
                            if (Q != 9) {
                                if (Q == 12) {
                                    jVar.g(6);
                                }
                            }
                        }
                    }
                }
                jVar.g(3);
            } else {
                jVar.g(4);
            }
            aG = cVar.aG();
            if (aG != null) {
                jVar.O(aG.b());
                jVar.z(aG.f());
                jVar.A(aG.e());
                jVar.B(aG.c());
                jVar.C(aG.a());
            }
            com.anythink.basead.a.b bVar2 = new com.anythink.basead.a.b(com.anythink.core.common.b.o.a().f(), bVar.c(), jVar);
            jVar.a(n);
            return bVar2;
        }
        jVar.g(2);
        aG = cVar.aG();
        if (aG != null) {
        }
        com.anythink.basead.a.b bVar22 = new com.anythink.basead.a.b(com.anythink.core.common.b.o.a().f(), bVar.c(), jVar);
        jVar.a(n);
        return bVar22;
    }

    public static com.anythink.basead.d.a.b a() {
        if (c == null) {
            synchronized (com.anythink.basead.d.a.b.class) {
                if (c == null) {
                    c = new com.anythink.basead.d.a.b();
                }
            }
        }
        return c;
    }

    public static /* synthetic */ void a(com.anythink.basead.d.a.b bVar, java.lang.String str, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.b.a aVar) {
        bVar.a.remove(mVar.b + mVar.a);
        if (aVar != null) {
            aVar.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.m, str));
        }
    }

    public static void a(com.anythink.core.common.f.j jVar) {
        if (!android.text.TextUtils.isEmpty(jVar.o())) {
            com.anythink.expressad.out.b.a = jVar.o();
        }
        if (com.anythink.expressad.foundation.b.a.b().d() == null) {
            com.anythink.expressad.foundation.b.a.b().a(com.anythink.core.common.b.o.a().f());
            com.anythink.expressad.e.a a2 = com.anythink.expressad.out.g.a();
            java.util.HashMap hashMap = new java.util.HashMap(3);
            hashMap.put(com.anythink.expressad.a.d, jVar.W());
            hashMap.put(com.anythink.expressad.a.e, jVar.X());
            a2.a(hashMap, com.anythink.core.common.b.o.a().f());
        }
    }

    public static void a(com.anythink.core.common.f.j jVar, com.anythink.expressad.foundation.d.c cVar) {
        jVar.x(cVar.ba());
        jVar.o(cVar.bd());
        jVar.m(cVar.bb());
        jVar.n(cVar.bc());
        jVar.w(cVar.ad());
        jVar.v(cVar.af());
        com.anythink.core.common.f.ak ad = jVar.ad();
        if (ad == null) {
            ad = new com.anythink.core.common.f.ak();
            jVar.a(ad);
        }
        com.anythink.expressad.foundation.d.n L = cVar.L();
        if (L != null) {
            ad.b(L.a());
            ad.c(L.b());
            ad.d(L.c());
        }
        a((com.anythink.core.common.f.l) jVar, cVar);
    }

    public static void a(com.anythink.core.common.f.j jVar, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        java.util.Iterator<com.anythink.expressad.foundation.d.c> it = list.iterator();
        while (it.hasNext()) {
            it.next().t(jVar.y());
        }
    }

    public static void a(com.anythink.core.common.f.l lVar, com.anythink.expressad.foundation.d.c cVar) {
        java.lang.String[] l;
        com.anythink.core.common.f.j jVar = lVar instanceof com.anythink.core.common.f.j ? (com.anythink.core.common.f.j) lVar : null;
        if (lVar == null || cVar == null) {
            return;
        }
        lVar.w(cVar.ad());
        lVar.e(cVar.aO());
        lVar.d(cVar.aN());
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(cVar.ah() + "&opdptype={opdptype}&apk_ptype={apk_ptype}");
        com.anythink.expressad.foundation.d.n L = cVar.L();
        if (L != null && (l = L.l()) != null) {
            for (java.lang.String str : l) {
                arrayList.add(str);
            }
        }
        com.anythink.core.common.f.ak ad = jVar.ad();
        if (ad == null) {
            ad = new com.anythink.core.common.f.ak();
            jVar.a(ad);
        }
        ad.a((java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]));
    }

    public static void a(com.anythink.core.common.f.m mVar, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        int i = mVar.j;
        if (i == 1 || i == 3) {
            list.get(0).a(mVar.n.F());
        }
    }

    private void a(java.lang.String str, com.anythink.core.common.f.m mVar, com.anythink.basead.d.a.b.a aVar) {
        this.a.remove(mVar.b + mVar.a);
        if (aVar != null) {
            aVar.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.m, str));
        }
    }

    public static /* synthetic */ java.lang.String b(java.lang.String str, boolean z) {
        if (z) {
            if (str.contains("hdbtn")) {
                return str.replace("hdbtn=1", "hdbtn=0");
            }
            return str + "&hdbtn=0";
        }
        if (str.contains("hdbtn")) {
            return str.replace("hdbtn=0", "hdbtn=1");
        }
        return str + "&hdbtn=1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String b(java.lang.String str, boolean z, int i, long j) {
        java.lang.String str2;
        java.lang.String str3;
        if (z) {
            if (str.contains("shake_show")) {
                str2 = str.replace("shake_show=0", "shake_show=1");
            } else {
                str2 = str + "&shake_show=1";
            }
        } else if (str.contains("shake_show")) {
            str2 = str.replace("shake_show=1", "shake_show=0");
        } else {
            str2 = str + "&shake_show=0";
        }
        if (str2.contains("shake_time")) {
            str3 = str2.replaceAll("(shake_time=[^&]*)", "shake_time=" + (j / 1000));
        } else {
            str3 = str2 + "&shake_time=" + (j / 1000);
        }
        if (str3.contains("shake_strength")) {
            return str3.replaceAll("(shake_strength=[^&]*)", "shake_strength=".concat(java.lang.String.valueOf(i)));
        }
        return str3 + "&shake_strength=" + i;
    }

    private void b(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.b.a aVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.d.a.b.AnonymousClass1(jVar, mVar, dVar, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String c(java.lang.String str, boolean z) {
        if (z) {
            if (str.contains(com.anythink.expressad.video.dynview.a.a.L)) {
                return str.replace("alecfc=0", "alecfc=1");
            }
            return str + "&alecfc=1";
        }
        if (str.contains(com.anythink.expressad.video.dynview.a.a.L)) {
            return str.replace("alecfc=1", "alecfc=0");
        }
        return str + "&alecfc=0";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void c(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.b.a aVar) {
        char c2;
        int i;
        com.anythink.core.common.f.n nVar = mVar.n;
        int a2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), 50.0f);
        if (nVar.h() <= 0) {
            java.lang.String x = nVar.x();
            x.hashCode();
            switch (x.hashCode()) {
                case -559799608:
                    if (x.equals(com.anythink.core.common.f.n.c)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507809854:
                    if (x.equals(com.anythink.core.common.f.n.b)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1622564786:
                    if (x.equals(com.anythink.core.common.f.n.d)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    a2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), 250.0f);
                    i = 2;
                    break;
                case 1:
                case 2:
                    a2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), 90.0f);
                    i = 1;
                    break;
                default:
                    i = 4;
                    break;
            }
        } else {
            a2 = nVar.h();
            i = 5;
        }
        com.anythink.expressad.out.TemplateBannerView templateBannerView = new com.anythink.expressad.out.TemplateBannerView(com.anythink.core.common.b.o.a().f());
        templateBannerView.init(new com.anythink.expressad.out.i(i, nVar.h()), "", android.text.TextUtils.isEmpty(jVar.Y()) ? mVar.c : jVar.Y());
        templateBannerView.setAllowShowCloseBtn(nVar.y() == 0);
        if (a2 > 0) {
            templateBannerView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, a2));
        }
        templateBannerView.setBannerAdListener(new com.anythink.basead.d.a.b.AnonymousClass2(mVar, aVar));
        if (aVar != null) {
            aVar.a(templateBannerView);
        }
        this.a.put(mVar.b + mVar.a, templateBannerView);
        templateBannerView.load(dVar);
    }

    private static java.lang.String d(java.lang.String str, boolean z) {
        if (z) {
            if (str.contains("hdbtn")) {
                return str.replace("hdbtn=1", "hdbtn=0");
            }
            return str + "&hdbtn=0";
        }
        if (str.contains("hdbtn")) {
            return str.replace("hdbtn=0", "hdbtn=1");
        }
        return str + "&hdbtn=1";
    }

    private void d(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.b.a aVar) {
        com.anythink.expressad.reward.b.a aVar2 = new com.anythink.expressad.reward.b.a();
        java.lang.String Y = android.text.TextUtils.isEmpty(jVar.Y()) ? mVar.c : jVar.Y();
        int i = mVar.j;
        if (i == 1) {
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), Y, false);
            aVar2.a(false);
        } else if (i == 3) {
            com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), Y, true);
            aVar2.a(true);
        }
        aVar2.a(mVar.n.E() == 0 ? 1 : 2);
        aVar2.a("", Y);
        com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), Y, false);
        if (mVar.n.F() >= 0) {
            a2.a(mVar.n.F());
        }
        if (mVar.j == 1) {
            a2.l();
        }
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVar.J;
        if (arrayList != null && arrayList.size() > 0) {
            for (com.anythink.expressad.foundation.d.c cVar : arrayList) {
                if (cVar != null) {
                    boolean z = com.anythink.expressad.shake.a.a().b() && mVar.n.Q() == 1;
                    boolean z2 = mVar.n.D() == 0;
                    java.lang.String I = cVar.I();
                    if (!android.text.TextUtils.isEmpty(I)) {
                        cVar.k(b(c(I, z2), z, mVar.n.R(), mVar.n.S()));
                    }
                    java.lang.String P = cVar.P();
                    if (!android.text.TextUtils.isEmpty(P)) {
                        cVar.n(b(c(P, z2), z, mVar.n.R(), mVar.n.S()));
                    }
                    com.anythink.expressad.foundation.d.c.C0208c M = cVar.M();
                    boolean z3 = mVar.n.A() == 1;
                    if (M != null) {
                        java.lang.String e = M.e();
                        if (!android.text.TextUtils.isEmpty(e)) {
                            M.a(c(e, z3));
                        }
                    }
                }
            }
        }
        aVar2.a(new com.anythink.basead.d.a.b.AnonymousClass3(mVar, aVar));
        if (aVar != null) {
            aVar.a(aVar2);
        }
        this.a.put(mVar.b + mVar.a, aVar2);
        aVar2.a(dVar);
    }

    private void e(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.b.a aVar) {
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.d.a.b.AnonymousClass4(jVar, mVar, aVar, dVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(com.anythink.core.common.f.j jVar, com.anythink.core.common.f.m mVar, com.anythink.expressad.foundation.d.d dVar, com.anythink.basead.d.a.b.a aVar) {
        char c2;
        int i;
        a(jVar);
        if (java.lang.String.valueOf(mVar.j).equals("0")) {
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.d.a.b.AnonymousClass4(jVar, mVar, aVar, dVar));
            return;
        }
        if (!java.lang.String.valueOf(mVar.j).equals("2")) {
            if (java.lang.String.valueOf(mVar.j).equals("4")) {
                com.anythink.core.common.b.o.a().b(new com.anythink.basead.d.a.b.AnonymousClass1(jVar, mVar, dVar, aVar));
                return;
            } else {
                d(jVar, mVar, dVar, aVar);
                return;
            }
        }
        com.anythink.core.common.f.n nVar = mVar.n;
        int a2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), 50.0f);
        if (nVar.h() <= 0) {
            java.lang.String x = nVar.x();
            x.hashCode();
            switch (x.hashCode()) {
                case -559799608:
                    if (x.equals(com.anythink.core.common.f.n.c)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507809854:
                    if (x.equals(com.anythink.core.common.f.n.b)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1622564786:
                    if (x.equals(com.anythink.core.common.f.n.d)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    a2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), 250.0f);
                    i = 2;
                    break;
                case 1:
                case 2:
                    a2 = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), 90.0f);
                    i = 1;
                    break;
                default:
                    i = 4;
                    break;
            }
        } else {
            a2 = nVar.h();
            i = 5;
        }
        com.anythink.expressad.out.TemplateBannerView templateBannerView = new com.anythink.expressad.out.TemplateBannerView(com.anythink.core.common.b.o.a().f());
        templateBannerView.init(new com.anythink.expressad.out.i(i, nVar.h()), "", android.text.TextUtils.isEmpty(jVar.Y()) ? mVar.c : jVar.Y());
        templateBannerView.setAllowShowCloseBtn(nVar.y() == 0);
        if (a2 > 0) {
            templateBannerView.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, a2));
        }
        templateBannerView.setBannerAdListener(new com.anythink.basead.d.a.b.AnonymousClass2(mVar, aVar));
        aVar.a(templateBannerView);
        this.a.put(mVar.b + mVar.a, templateBannerView);
        templateBannerView.load(dVar);
    }
}
