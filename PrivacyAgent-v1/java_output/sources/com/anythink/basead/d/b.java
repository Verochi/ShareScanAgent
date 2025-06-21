package com.anythink.basead.d;

/* loaded from: classes12.dex */
public abstract class b {
    private com.anythink.basead.d.b.EnumC0136b a;
    protected android.content.Context b;
    protected com.anythink.core.common.f.m c;
    protected com.anythink.basead.d.c d;
    protected com.anythink.core.common.f.ai e;
    protected com.anythink.core.common.a.h f;
    protected com.anythink.basead.a.b g;
    protected com.anythink.basead.e.a h;
    protected java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.basead.a.b> i;
    protected java.lang.String j;
    private boolean k = false;

    /* renamed from: com.anythink.basead.d.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.d.a.a.InterfaceC0133a {
        final /* synthetic */ com.anythink.basead.d.b.a a;

        public AnonymousClass1(com.anythink.basead.d.b.a aVar) {
            this.a = aVar;
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.a.h hVar) {
            com.anythink.basead.d.b.a(com.anythink.basead.d.b.this, hVar);
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.f.j jVar) {
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.f.j jVar, com.anythink.basead.c.e eVar) {
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.f.j jVar, com.anythink.core.common.a.h hVar) {
            com.anythink.basead.d.b.a aVar = this.a;
            if (aVar != null) {
                aVar.onAdCacheLoaded();
            }
        }
    }

    /* renamed from: com.anythink.basead.d.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.d.a.a.InterfaceC0133a {
        final /* synthetic */ com.anythink.basead.e.c a;

        public AnonymousClass2(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.a.h hVar) {
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.f.j jVar) {
            com.anythink.basead.d.b.this.a(jVar);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.f.j jVar, com.anythink.basead.c.e eVar) {
            com.anythink.basead.d.b.a(com.anythink.basead.d.b.this, jVar, eVar, this.a, true);
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0133a
        public final void a(com.anythink.core.common.f.j jVar, com.anythink.core.common.a.h hVar) {
            com.anythink.basead.d.b bVar = com.anythink.basead.d.b.this;
            bVar.e = jVar;
            com.anythink.basead.d.b.a(bVar, hVar);
            com.anythink.basead.a.a.a(33, jVar, new com.anythink.basead.c.i(com.anythink.basead.d.b.this.c.d, ""));
            com.anythink.basead.d.b.a(com.anythink.basead.d.b.this);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }
    }

    /* renamed from: com.anythink.basead.d.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.basead.a.b.InterfaceC0128b {
        public AnonymousClass3() {
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.b.this.h;
            if (aVar != null) {
                aVar.onAdClick(new com.anythink.basead.e.i().a(1, 13));
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a(boolean z) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.b.this.h;
            if (aVar != null) {
                aVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
            return false;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void b() {
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void c() {
        }
    }

    /* renamed from: com.anythink.basead.d.b$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.basead.d.b.a.InterfaceC0135a {
        final /* synthetic */ com.anythink.basead.e.c a;

        public AnonymousClass4(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0135a
        public final void a() {
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0135a
        public final void a(com.anythink.core.common.f.ah ahVar) {
            com.anythink.basead.d.b bVar = com.anythink.basead.d.b.this;
            bVar.e = ahVar;
            com.anythink.basead.a.a.a(33, com.anythink.basead.d.b.this.e, new com.anythink.basead.c.i(bVar.c.d, ""));
            com.anythink.basead.d.b.a(com.anythink.basead.d.b.this);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0135a
        public final void a(com.anythink.core.common.f.ah ahVar, com.anythink.basead.c.e eVar) {
            com.anythink.basead.d.b.a(com.anythink.basead.d.b.this, ahVar, eVar, this.a, false);
        }
    }

    /* renamed from: com.anythink.basead.d.b$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.basead.a.b.InterfaceC0128b {
        public AnonymousClass5() {
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.b.this.h;
            if (aVar != null) {
                aVar.onAdClick(new com.anythink.basead.e.i().a(1, 13));
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a(boolean z) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.b.this.h;
            if (aVar != null) {
                aVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
            return false;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void b() {
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void c() {
        }
    }

    /* renamed from: com.anythink.basead.d.b$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.anythink.basead.d.b.EnumC0136b.values().length];
            a = iArr;
            try {
                iArr[com.anythink.basead.d.b.EnumC0136b.ADX_OFFER_REQUEST_TYPE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.anythink.basead.d.b.EnumC0136b.ONLINE_API_OFFER_REQUEST_TYPE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
        }
    }

    public interface a {
        void onAdCacheLoaded();
    }

    /* renamed from: com.anythink.basead.d.b$b, reason: collision with other inner class name */
    public enum EnumC0136b {
        ADX_OFFER_REQUEST_TYPE,
        ONLINE_API_OFFER_REQUEST_TYPE
    }

    public b(android.content.Context context, com.anythink.basead.d.b.EnumC0136b enumC0136b, com.anythink.core.common.f.m mVar) {
        this.b = context.getApplicationContext();
        this.a = enumC0136b;
        this.c = mVar;
    }

    public static /* synthetic */ void a(com.anythink.basead.d.b bVar, com.anythink.core.common.a.h hVar) {
        bVar.f = hVar;
        com.anythink.basead.a.b bVar2 = new com.anythink.basead.a.b(bVar.b, bVar.c, bVar.e);
        bVar.g = bVar2;
        bVar2.a(bVar.new AnonymousClass3());
    }

    public static /* synthetic */ void a(com.anythink.basead.d.b bVar, com.anythink.core.common.f.l lVar, com.anythink.basead.c.e eVar, com.anythink.basead.e.c cVar, boolean z) {
        if (lVar != null) {
            com.anythink.basead.a.a.a(34, lVar, new com.anythink.basead.c.i(bVar.c.d, ""));
        }
        if (lVar instanceof com.anythink.core.common.f.ah) {
            com.anythink.core.basead.b.a();
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(f, com.anythink.core.basead.b.a(bVar.c));
        }
        if (z) {
            try {
                com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.o.a().f(), bVar.c.a);
            } catch (java.lang.Throwable unused) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(eVar);
        }
    }

    private void a(com.anythink.core.common.a.h hVar) {
        this.f = hVar;
        com.anythink.basead.a.b bVar = new com.anythink.basead.a.b(this.b, this.c, this.e);
        this.g = bVar;
        bVar.a(new com.anythink.basead.d.b.AnonymousClass3());
    }

    private void a(com.anythink.core.common.f.l lVar, com.anythink.basead.c.e eVar, com.anythink.basead.e.c cVar, boolean z) {
        if (lVar != null) {
            com.anythink.basead.a.a.a(34, lVar, new com.anythink.basead.c.i(this.c.d, ""));
        }
        if (lVar instanceof com.anythink.core.common.f.ah) {
            com.anythink.core.basead.b.a();
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(f, com.anythink.core.basead.b.a(this.c));
        }
        if (z) {
            try {
                com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.o.a().f(), this.c.a);
            } catch (java.lang.Throwable unused) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(eVar);
        }
    }

    public static /* synthetic */ boolean a(com.anythink.basead.d.b bVar) {
        bVar.k = true;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r4.onAdLoadFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.w));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(com.anythink.basead.e.c cVar) {
        try {
            com.anythink.core.common.f.m mVar = this.c;
            if (mVar != null && !android.text.TextUtils.isEmpty(mVar.b) && !android.text.TextUtils.isEmpty(this.c.a)) {
                com.anythink.basead.d.a.a.a(this.b).a(this.c, new com.anythink.basead.d.b.AnonymousClass2(cVar));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
            }
        }
    }

    private void c(com.anythink.basead.e.c cVar) {
        try {
            com.anythink.basead.d.b.a.a(this.b).a(this.c, this.j, new com.anythink.basead.d.b.AnonymousClass4(cVar));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
            }
        }
    }

    public final java.lang.String a(com.anythink.core.common.f.ai aiVar) {
        return this.c.b + this.c.c + this.c.f + aiVar.s() + java.lang.System.currentTimeMillis();
    }

    public final void a(com.anythink.basead.d.b.a aVar) {
        if (com.anythink.basead.d.b.AnonymousClass6.a[this.a.ordinal()] != 1) {
            return;
        }
        if (c()) {
            if (aVar != null) {
                aVar.onAdCacheLoaded();
            }
        } else if (this.c != null) {
            com.anythink.basead.d.a.a.a(this.b).a(this.e, this.c, new com.anythink.basead.d.b.AnonymousClass1(aVar));
        }
    }

    public final void a(com.anythink.basead.d.c cVar) {
        com.anythink.core.common.f.aj ajVar;
        this.d = cVar;
        com.anythink.core.common.f.n nVar = this.c.n;
        if (!(nVar instanceof com.anythink.core.common.f.aj) || (ajVar = (com.anythink.core.common.f.aj) nVar) == null || cVar == null) {
            return;
        }
        ajVar.x(cVar.a());
        ajVar.y(cVar.b());
        ajVar.e(cVar.d());
        ajVar.r(cVar.c());
        ajVar.q(cVar.e());
        ajVar.b(cVar.f());
        ajVar.p(cVar.g());
        ajVar.c(cVar.h());
        ajVar.d(cVar.i());
        ajVar.f(cVar.j());
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.h = aVar;
    }

    public final void a(com.anythink.basead.e.c cVar) {
        int i = com.anythink.basead.d.b.AnonymousClass6.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            try {
                com.anythink.basead.d.b.a.a(this.b).a(this.c, this.j, new com.anythink.basead.d.b.AnonymousClass4(cVar));
                return;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
                return;
            }
        }
        try {
            com.anythink.core.common.f.m mVar = this.c;
            if (mVar != null && !android.text.TextUtils.isEmpty(mVar.b) && !android.text.TextUtils.isEmpty(this.c.a)) {
                com.anythink.basead.d.a.a.a(this.b).a(this.c, new com.anythink.basead.d.b.AnonymousClass2(cVar));
                return;
            }
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.w));
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th2.getMessage()));
        }
    }

    public final void a(com.anythink.core.common.f.j jVar) {
        if (jVar.c() == 1) {
            com.anythink.core.common.a.c.a().b();
            if (com.anythink.core.common.o.i.a(this.b, jVar.E())) {
                jVar.aa();
                jVar.E();
                com.anythink.core.common.a.c.a().c(jVar);
            } else {
                jVar.aa();
                jVar.E();
                com.anythink.core.common.a.c.a().a(jVar);
            }
        }
    }

    public final synchronized void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        try {
            if (this.g == null) {
                return;
            }
            if (this.i == null) {
                this.i = new java.util.concurrent.ConcurrentHashMap<>(2);
            }
            com.anythink.basead.a.b bVar = this.i.get(cVar.aZ());
            if (bVar == null) {
                bVar = com.anythink.basead.d.a.b.a(this.g, cVar);
                this.i.put(cVar.aZ(), bVar);
            }
            if (bVar != null) {
                com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.c.d, str);
                iVar.g = new com.anythink.basead.c.a();
                bVar.a(new com.anythink.basead.d.b.AnonymousClass5());
                bVar.a(iVar);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(java.lang.String str) {
        this.j = str;
    }

    public void b() {
        this.e = null;
    }

    public final boolean c() {
        com.anythink.core.common.f.ai aiVar;
        int i = com.anythink.basead.d.b.AnonymousClass6.a[this.a.ordinal()];
        if (i != 1) {
            if (i != 2 || (aiVar = this.e) == null || !(aiVar instanceof com.anythink.core.common.f.ah) || aiVar.U()) {
                return false;
            }
            if (this.k) {
                return true;
            }
            if (com.anythink.basead.a.b.c.a(this.e, this.c)) {
                this.k = true;
                return true;
            }
            return false;
        }
        if (this.e == null) {
            this.e = com.anythink.basead.d.a.a.a(this.b).a(this.c);
        }
        com.anythink.core.common.f.ai aiVar2 = this.e;
        if (aiVar2 == null || aiVar2.U()) {
            return false;
        }
        com.anythink.core.common.f.ai aiVar3 = this.e;
        if ((aiVar3 instanceof com.anythink.core.common.f.j) && !android.text.TextUtils.isEmpty(((com.anythink.core.common.f.j) aiVar3).a())) {
            com.anythink.core.common.a.h hVar = this.f;
            if (hVar != null) {
                return hVar.isReady();
            }
            return false;
        }
        if (this.k) {
            return true;
        }
        if (!com.anythink.basead.a.b.c.a(this.e, this.c)) {
            return false;
        }
        this.k = true;
        return true;
    }

    public final void d() {
        a((com.anythink.basead.d.b.a) null);
    }

    public final synchronized void e() {
        com.anythink.basead.a.b bVar = this.g;
        if (bVar != null) {
            bVar.d();
            this.g = null;
        }
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.basead.a.b> concurrentHashMap = this.i;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.basead.a.b>> it = this.i.entrySet().iterator();
            while (it.hasNext()) {
                com.anythink.basead.a.b value = it.next().getValue();
                if (value != null) {
                    value.d();
                    it.remove();
                }
            }
        }
    }

    public final com.anythink.core.common.f.l f() {
        return this.e;
    }
}
