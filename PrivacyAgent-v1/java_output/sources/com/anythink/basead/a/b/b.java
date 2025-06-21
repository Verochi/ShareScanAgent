package com.anythink.basead.a.b;

/* loaded from: classes12.dex */
public class b implements com.anythink.basead.a.b.d.a {
    public static final java.lang.String a = "b";
    com.anythink.core.common.f.l b;
    com.anythink.core.common.f.n c;
    com.anythink.core.common.f.m d;
    com.anythink.core.common.m.b e = new com.anythink.basead.a.b.b.AnonymousClass1();
    private java.lang.String f;
    private boolean g;
    private int h;
    private java.lang.String i;
    private java.util.List<java.lang.String> j;
    private com.anythink.basead.a.b.b.InterfaceC0129b k;
    private com.anythink.basead.a.a.c<java.lang.Void, com.anythink.basead.c.e> l;
    private com.anythink.basead.mraid.MraidWebView m;
    private volatile boolean n;

    /* renamed from: com.anythink.basead.a.b.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.b.b.this.a(com.anythink.basead.c.f.a("20001", com.anythink.basead.c.f.q));
        }
    }

    /* renamed from: com.anythink.basead.a.b.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        /* renamed from: com.anythink.basead.a.b.b$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.basead.mraid.d.a {
            public AnonymousClass1() {
            }

            @Override // com.anythink.basead.mraid.d.a
            public final void a() {
                com.anythink.basead.a.b.b.this.b();
            }

            @Override // com.anythink.basead.mraid.d.a
            public final void a(com.anythink.basead.c.e eVar) {
                com.anythink.basead.a.b.b.this.a(eVar);
            }
        }

        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.basead.a.b.b.this.m = new com.anythink.basead.mraid.MraidWebView(com.anythink.core.common.b.o.a().f());
                java.lang.String str = this.a;
                java.lang.String str2 = this.b;
                com.anythink.basead.mraid.MraidWebView mraidWebView = com.anythink.basead.a.b.b.this.m;
                com.anythink.basead.a.b.b.AnonymousClass2.AnonymousClass1 anonymousClass1 = new com.anythink.basead.a.b.b.AnonymousClass2.AnonymousClass1();
                com.anythink.basead.a.b.b bVar = com.anythink.basead.a.b.b.this;
                com.anythink.basead.mraid.d.a(str, str2, mraidWebView, anonymousClass1, bVar.b, bVar.d, 5);
            } catch (java.lang.Throwable th) {
                com.anythink.basead.a.b.b.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.G, com.anythink.basead.c.f.P + th.getMessage()));
            }
        }
    }

    public class a implements com.anythink.basead.a.a.b<java.lang.Void, com.anythink.basead.c.e> {
        private a() {
        }

        public /* synthetic */ a(com.anythink.basead.a.b.b bVar, byte b) {
            this();
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(com.anythink.basead.c.e eVar) {
            if (com.anythink.basead.a.b.b.this.k != null) {
                java.lang.String unused = com.anythink.basead.a.b.b.this.i;
                com.anythink.basead.a.b.b.this.k.a(eVar);
            }
            com.anythink.basead.a.b.b.e(com.anythink.basead.a.b.b.this);
        }

        private void b() {
            if (com.anythink.basead.a.b.b.this.k != null) {
                java.lang.String unused = com.anythink.basead.a.b.b.this.i;
                com.anythink.basead.a.b.b.this.k.a();
            }
            com.anythink.basead.a.b.b.e(com.anythink.basead.a.b.b.this);
        }

        @Override // com.anythink.basead.a.a.b
        public final /* synthetic */ void a() {
            if (com.anythink.basead.a.b.b.this.k != null) {
                java.lang.String unused = com.anythink.basead.a.b.b.this.i;
                com.anythink.basead.a.b.b.this.k.a();
            }
            com.anythink.basead.a.b.b.e(com.anythink.basead.a.b.b.this);
        }

        @Override // com.anythink.basead.a.a.b
        public final /* synthetic */ void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.c.e eVar2 = eVar;
            if (com.anythink.basead.a.b.b.this.k != null) {
                java.lang.String unused = com.anythink.basead.a.b.b.this.i;
                com.anythink.basead.a.b.b.this.k.a(eVar2);
            }
            com.anythink.basead.a.b.b.e(com.anythink.basead.a.b.b.this);
        }
    }

    /* renamed from: com.anythink.basead.a.b.b$b, reason: collision with other inner class name */
    public interface InterfaceC0129b {
        void a();

        void a(com.anythink.basead.c.e eVar);
    }

    public b(java.lang.String str, boolean z, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        this.f = str;
        this.g = z;
        this.b = lVar;
        this.d = mVar;
        com.anythink.core.common.f.n nVar = mVar.n;
        this.c = nVar;
        this.h = nVar.s();
        com.anythink.basead.a.b.a aVar = new com.anythink.basead.a.b.a();
        this.l = aVar;
        aVar.a((com.anythink.basead.a.a.b) new com.anythink.basead.a.b.b.a(this, (byte) 0));
    }

    private void a() {
        java.util.List<java.lang.String> b = this.b.b((com.anythink.core.common.f.l) this.c);
        if (b == null) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.m, "Incomplete resource allocation! MissResource: ".concat(java.lang.String.valueOf(this.b.p()))));
            return;
        }
        int size = b.size();
        if (size == 0) {
            b();
            return;
        }
        this.j = new java.util.ArrayList(size);
        for (int i = 0; i < size; i++) {
            java.lang.String str = b.get(i);
            if (!android.text.TextUtils.isEmpty(str)) {
                if (this.b.E(str)) {
                    if (!com.anythink.basead.a.b.c.a(this.b, this.c) && !this.j.contains(str)) {
                        this.c.W();
                        this.j.add(str);
                    }
                } else if (!com.anythink.basead.a.b.c.c(str) && !this.j.contains(str)) {
                    this.j.add(str);
                }
            }
        }
        int size2 = this.j.size();
        if (size2 == 0) {
            b();
            return;
        }
        synchronized (this) {
            com.anythink.basead.a.b.d.a().a(this);
            for (int i2 = 0; i2 < size2; i2++) {
                java.lang.String str2 = this.j.get(i2);
                boolean E = this.b.E(str2);
                int W = this.c.W();
                if (E) {
                    if (com.anythink.basead.a.b.c.a(this.b, this.c)) {
                        com.anythink.basead.a.b.d.a().a(str2, W);
                    } else {
                        new com.anythink.basead.a.b.f(this.f, this.b, this.c).a();
                    }
                } else if (!com.anythink.basead.a.b.c.a(str2)) {
                    if (com.anythink.basead.a.b.c.c(str2)) {
                        com.anythink.basead.a.b.c.a(str2, 100);
                        com.anythink.basead.a.b.d.a().a(str2, 100);
                    } else {
                        com.anythink.basead.a.b.c.a(str2, 0);
                        new com.anythink.basead.a.b.e(this.f, this.g, this.b, str2).d();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.basead.c.e eVar) {
        this.n = true;
        com.anythink.basead.a.a.c<java.lang.Void, com.anythink.basead.c.e> cVar = this.l;
        if (cVar != null) {
            cVar.a((com.anythink.basead.a.a.c<java.lang.Void, com.anythink.basead.c.e>) eVar);
        }
    }

    private void a(boolean z) {
        java.lang.String a2 = com.anythink.basead.mraid.d.a(this.d, this.b);
        if (android.text.TextUtils.isEmpty(a2)) {
            a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.G, com.anythink.basead.c.f.M));
        } else if (!z) {
            b();
        } else {
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.b.AnonymousClass2(com.anythink.basead.a.b.c.b(this.d, this.b), a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.anythink.basead.a.a.c<java.lang.Void, com.anythink.basead.c.e> cVar = this.l;
        if (cVar != null) {
            cVar.a();
        }
    }

    private void c() {
        com.anythink.basead.a.b.d.a().b(this);
        com.anythink.core.common.m.d.a().b(this.e);
    }

    private void d() {
        com.anythink.core.common.m.d.a().a(this.e, this.h, false);
    }

    private void e() {
        int i;
        com.anythink.core.common.f.m mVar = this.d;
        if (mVar == null || mVar.n == null) {
            return;
        }
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        try {
            i = java.lang.Math.min(f.getResources().getDisplayMetrics().widthPixels, f.getResources().getDisplayMetrics().heightPixels) / 2;
        } catch (java.lang.Throwable unused) {
            i = 0;
        }
        if (java.lang.String.valueOf(this.d.j).equals("1") && !this.b.H() && this.d.n.aj() != 1) {
            com.anythink.core.d.a b = com.anythink.core.d.b.a(f).b(com.anythink.core.common.b.o.a().o());
            int ak = this.d.n.ak();
            java.util.List<java.lang.String> i2 = ak != 2 ? ak != 3 ? ak != 5 ? null : b.i() : b.j() : b.h();
            if (i2 != null && i2.size() > 0) {
                for (java.lang.String str : i2) {
                    if (!android.text.TextUtils.isEmpty(str) && !com.anythink.basead.a.b.c.b(str, 3)) {
                        com.anythink.core.common.res.b.a(f).a(new com.anythink.core.common.res.e(3, str), i, i, null);
                    }
                }
            }
        }
        if (this.d.n.Q() != 1 || android.text.TextUtils.isEmpty(this.d.n.b())) {
            return;
        }
        com.anythink.core.common.res.b.a(f).a(new com.anythink.core.common.res.e(3, this.d.n.b()), i, i, null);
    }

    public static /* synthetic */ void e(com.anythink.basead.a.b.b bVar) {
        com.anythink.basead.a.b.d.a().b(bVar);
        com.anythink.core.common.m.d.a().b(bVar.e);
    }

    public final void a(com.anythink.basead.a.b.b.InterfaceC0129b interfaceC0129b) {
        int i;
        com.anythink.core.common.f.l lVar = this.b;
        if (lVar == null || this.l == null) {
            a(com.anythink.basead.c.f.a("-9999", com.anythink.basead.c.f.x));
            return;
        }
        this.i = lVar.s();
        this.k = interfaceC0129b;
        com.anythink.core.common.f.m mVar = this.d;
        if (mVar != null && mVar.n != null) {
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            try {
                i = java.lang.Math.min(f.getResources().getDisplayMetrics().widthPixels, f.getResources().getDisplayMetrics().heightPixels) / 2;
            } catch (java.lang.Throwable unused) {
                i = 0;
            }
            if (java.lang.String.valueOf(this.d.j).equals("1") && !this.b.H() && this.d.n.aj() != 1) {
                com.anythink.core.d.a b = com.anythink.core.d.b.a(f).b(com.anythink.core.common.b.o.a().o());
                int ak = this.d.n.ak();
                java.util.List<java.lang.String> i2 = ak != 2 ? ak != 3 ? ak != 5 ? null : b.i() : b.j() : b.h();
                if (i2 != null && i2.size() > 0) {
                    for (java.lang.String str : i2) {
                        if (!android.text.TextUtils.isEmpty(str) && !com.anythink.basead.a.b.c.b(str, 3)) {
                            com.anythink.core.common.res.b.a(f).a(new com.anythink.core.common.res.e(3, str), i, i, null);
                        }
                    }
                }
            }
            if (this.d.n.Q() == 1 && !android.text.TextUtils.isEmpty(this.d.n.b())) {
                com.anythink.core.common.res.b.a(f).a(new com.anythink.core.common.res.e(3, this.d.n.b()), i, i, null);
            }
        }
        com.anythink.core.common.m.d.a().a(this.e, this.h, false);
        if (!this.b.j()) {
            this.l.a(1);
            a();
            return;
        }
        this.n = false;
        com.anythink.core.common.f.n nVar = this.c;
        if (nVar != null) {
            java.lang.String valueOf = java.lang.String.valueOf(nVar.z());
            boolean z = valueOf.equals("1") || valueOf.equals("3");
            this.l.a(1);
            if (z) {
                this.l.a(2);
                a();
            }
            if (this.n) {
                return;
            }
            boolean Z = this.c.Z();
            java.lang.String a2 = com.anythink.basead.mraid.d.a(this.d, this.b);
            if (android.text.TextUtils.isEmpty(a2)) {
                a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.G, com.anythink.basead.c.f.M));
            } else if (Z) {
                com.anythink.core.common.b.o.a().b(new com.anythink.basead.a.b.b.AnonymousClass2(com.anythink.basead.a.b.c.b(this.d, this.b), a2));
            } else {
                b();
            }
        }
    }

    @Override // com.anythink.basead.a.b.d.a
    public final void a(java.lang.String str, int i) {
        synchronized (this) {
            com.anythink.basead.a.b.c.a(str, i);
            if (this.j.contains(str) && (!this.b.E(str) || this.c.W() <= i)) {
                if (this.b.E(str)) {
                    com.anythink.basead.a.b.g.a(this.b, this.c);
                }
                java.util.List<java.lang.String> list = this.j;
                if (list != null) {
                    list.remove(str);
                    this.j.size();
                    if (this.j.size() == 0) {
                        b();
                    }
                }
            }
        }
    }

    @Override // com.anythink.basead.a.b.d.a
    public final void a(java.lang.String str, com.anythink.basead.c.e eVar) {
        synchronized (this) {
            com.anythink.basead.a.b.c.a(str, -1);
            a(eVar);
        }
    }
}
