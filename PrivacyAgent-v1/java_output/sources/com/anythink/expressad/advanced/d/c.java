package com.anythink.expressad.advanced.d;

/* loaded from: classes12.dex */
public class c implements com.anythink.core.common.a.h {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static java.lang.String g = "NativeAdvancedProvider";
    private org.json.JSONObject C;
    private com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup E;
    private boolean F;
    private boolean G;
    private boolean H;
    boolean e;
    com.anythink.expressad.foundation.d.d f;
    private java.lang.String h;
    private java.lang.String i;
    private com.anythink.expressad.advanced.c.a j;
    private com.anythink.expressad.advanced.c.b k;
    private com.anythink.expressad.advanced.d.b l;
    private com.anythink.expressad.out.o m;
    private com.anythink.expressad.advanced.d.d n;
    private com.anythink.expressad.advanced.view.ATNativeAdvancedView o;
    private com.anythink.expressad.advanced.view.ATNativeAdvancedWebview p;
    private com.anythink.expressad.advanced.view.a q;
    private com.anythink.expressad.d.c r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f197s;
    private int t = -1;
    private boolean u = false;
    private int v = 0;
    private boolean w = false;
    private int x = 0;
    private boolean y = false;
    private int z = 0;
    private int A = 0;
    private java.lang.Object B = new java.lang.Object();
    private boolean D = false;
    private boolean I = true;
    public boolean d = false;
    private android.view.ViewTreeObserver.OnScrollChangedListener J = new com.anythink.expressad.advanced.d.c.AnonymousClass1();

    /* renamed from: com.anythink.expressad.advanced.d.c$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: com.anythink.expressad.advanced.d.c$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01781 implements java.lang.Runnable {
            public RunnableC01781() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.advanced.d.c.this.I = true;
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (com.anythink.expressad.advanced.d.c.this.I) {
                com.anythink.expressad.advanced.d.c.this.I = false;
                if (com.anythink.expressad.advanced.d.c.this.E != null) {
                    com.anythink.expressad.advanced.d.c.this.E.postDelayed(new com.anythink.expressad.advanced.d.c.AnonymousClass1.RunnableC01781(), 1000L);
                }
                try {
                    com.anythink.expressad.advanced.d.c.this.k();
                } catch (java.lang.Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.advanced.d.c$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.advanced.c.c.a {
        final /* synthetic */ com.anythink.expressad.foundation.d.c[] a;

        public AnonymousClass2(com.anythink.expressad.foundation.d.c[] cVarArr) {
            this.a = cVarArr;
        }

        @Override // com.anythink.expressad.advanced.c.c.a
        public final void a() {
            java.lang.String unused = com.anythink.expressad.advanced.d.c.g;
            com.anythink.expressad.advanced.d.c.this.a(this.a[0], false);
        }

        @Override // com.anythink.expressad.advanced.c.c.a
        public final void b() {
            com.anythink.expressad.advanced.d.c.this.e = false;
        }
    }

    public c(java.lang.String str, java.lang.String str2, android.content.Context context) {
        com.anythink.expressad.advanced.view.a aVar;
        this.i = str;
        this.h = str2;
        if (this.k == null) {
            com.anythink.expressad.advanced.c.b bVar = new com.anythink.expressad.advanced.c.b(com.anythink.core.common.b.o.a().f(), this.i, this.h);
            this.k = bVar;
            bVar.a(this);
        }
        if (this.p == null) {
            try {
                this.p = new com.anythink.expressad.advanced.view.ATNativeAdvancedWebview(com.anythink.core.common.b.o.a().f());
            } catch (java.lang.Throwable unused) {
            }
            if (this.q == null) {
                try {
                    this.q = new com.anythink.expressad.advanced.view.a(this.h, this.k.b(), this);
                } catch (java.lang.Throwable unused2) {
                }
            }
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview != null && (aVar = this.q) != null) {
                aTNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.o == null) {
            com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = new com.anythink.expressad.advanced.view.ATNativeAdvancedView(context);
            this.o = aTNativeAdvancedView;
            aTNativeAdvancedView.setAdvancedNativeWebview(this.p);
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.p;
            if (aTNativeAdvancedWebview2 != null && aTNativeAdvancedWebview2.getParent() == null) {
                this.o.addView(this.p, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.E == null) {
            this.E = new com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup(com.anythink.core.common.b.o.a().f());
            this.E.setLayoutParams((this.z == 0 || this.A == 0) ? new android.view.ViewGroup.LayoutParams(-1, -1) : new android.view.ViewGroup.LayoutParams(this.z, this.A));
            this.E.setProvider(this);
            this.E.addView(this.o);
            this.E.getViewTreeObserver().addOnScrollChangedListener(this.J);
        }
    }

    private void a(android.content.Context context) {
        com.anythink.expressad.advanced.view.a aVar;
        if (this.k == null) {
            com.anythink.expressad.advanced.c.b bVar = new com.anythink.expressad.advanced.c.b(com.anythink.core.common.b.o.a().f(), this.i, this.h);
            this.k = bVar;
            bVar.a(this);
        }
        if (this.p == null) {
            try {
                this.p = new com.anythink.expressad.advanced.view.ATNativeAdvancedWebview(com.anythink.core.common.b.o.a().f());
            } catch (java.lang.Throwable unused) {
            }
            if (this.q == null) {
                try {
                    this.q = new com.anythink.expressad.advanced.view.a(this.h, this.k.b(), this);
                } catch (java.lang.Throwable unused2) {
                }
            }
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview != null && (aVar = this.q) != null) {
                aTNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.o == null) {
            com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = new com.anythink.expressad.advanced.view.ATNativeAdvancedView(context);
            this.o = aTNativeAdvancedView;
            aTNativeAdvancedView.setAdvancedNativeWebview(this.p);
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview2 = this.p;
            if (aTNativeAdvancedWebview2 != null && aTNativeAdvancedWebview2.getParent() == null) {
                this.o.addView(this.p, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.E == null) {
            this.E = new com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup(com.anythink.core.common.b.o.a().f());
            this.E.setLayoutParams((this.z == 0 || this.A == 0) ? new android.view.ViewGroup.LayoutParams(-1, -1) : new android.view.ViewGroup.LayoutParams(this.z, this.A));
            this.E.setProvider(this);
            this.E.addView(this.o);
            this.E.getViewTreeObserver().addOnScrollChangedListener(this.J);
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        this.k.a(this.n);
        this.k.a(cVar, this.o, true);
    }

    private void a(org.json.JSONObject jSONObject) {
        this.D = true;
        b(jSONObject);
    }

    private void b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.A = i;
        this.z = i2;
        this.E.setLayoutParams(new android.view.ViewGroup.LayoutParams(i2, i));
    }

    private void b(org.json.JSONObject jSONObject) {
        if (this.D) {
            this.C = jSONObject;
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendThirdToH5(this.p, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.d, "", jSONObject);
        }
    }

    private void f(int i) {
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
        if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
            return;
        }
        try {
            if (this.p != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.m, i);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.p, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.l, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void g(int i) {
        if (this.u) {
            this.t = i;
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            int i2 = this.t;
            if (i2 == 1) {
                this.k.a(true);
                com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendThirdToH5(this.p, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.f, "", null);
            } else if (i2 == 0) {
                this.k.a(false);
                com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendThirdToH5(this.p, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.g, "", null);
            }
        }
    }

    private void h() {
        com.anythink.expressad.foundation.d.c[] cVarArr = new com.anythink.expressad.foundation.d.c[1];
        com.anythink.expressad.advanced.c.a aVar = this.j;
        if (aVar != null) {
            cVarArr[0] = aVar.c();
        }
        if (cVarArr[0] != null) {
            if (this.r == null) {
                com.anythink.expressad.d.b.a();
                this.r = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.h);
            }
            this.n = new com.anythink.expressad.advanced.d.d(this, this.m, this.r.a(), cVarArr[0]);
            if (this.e) {
                return;
            }
            this.e = true;
            com.anythink.expressad.advanced.c.c.a(this.o, cVarArr[0], this.i, this.h, this.t, new com.anythink.expressad.advanced.d.c.AnonymousClass2(cVarArr));
        }
    }

    private void h(int i) {
        if (this.w) {
            this.v = i;
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendThirdToH5(this.p, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.h, "mute", java.lang.Integer.valueOf(i));
        }
    }

    private java.lang.String i() {
        if (this.d) {
            com.anythink.expressad.advanced.c.b bVar = this.k;
            return bVar != null ? bVar.a() : "";
        }
        com.anythink.expressad.advanced.c.a aVar = this.j;
        return aVar != null ? aVar.a() : "";
    }

    private void i(int i) {
        if (this.y) {
            this.x = i;
            com.anythink.expressad.advanced.view.ATNativeAdvancedWebview aTNativeAdvancedWebview = this.p;
            if (aTNativeAdvancedWebview == null || aTNativeAdvancedWebview.isDestroyed()) {
                return;
            }
            com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendThirdToH5(this.p, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.j, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.k, java.lang.Integer.valueOf(i));
        }
    }

    private void j() {
        g(this.t);
        h(this.v);
        i(this.x);
        b(this.C);
        com.anythink.core.common.b.o.a().f();
        f(com.anythink.expressad.foundation.h.k.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.F && this.G && this.H && !com.anythink.expressad.foundation.h.y.a(this.o.getAdvancedNativeWebview()) && this.E.getAlpha() >= 0.5f && this.E.getVisibility() == 0) {
            com.anythink.expressad.advanced.c.b bVar = this.k;
            if (bVar != null) {
                bVar.d();
            }
            h();
        }
    }

    private void l() {
        com.anythink.expressad.advanced.c.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final java.lang.String a(java.lang.String str) {
        com.anythink.expressad.advanced.c.a aVar = this.j;
        return aVar != null ? aVar.a(str) : "";
    }

    public final void a(int i) {
        this.u = true;
        g(i);
    }

    public final void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.A = i;
        this.z = i2;
        this.E.setLayoutParams(new android.view.ViewGroup.LayoutParams(i2, i));
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        g(this.t);
        h(this.v);
        i(this.x);
        b(this.C);
        com.anythink.core.common.b.o.a().f();
        f(com.anythink.expressad.foundation.h.k.a());
        com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroup = this.E;
        if (aTOutNativeAdvancedViewGroup == null || aTOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (cVar != null && z) {
            if (this.r == null) {
                com.anythink.expressad.d.b.a();
                this.r = com.anythink.expressad.d.b.b(com.anythink.expressad.foundation.b.a.b().e(), this.h);
            }
            this.n = new com.anythink.expressad.advanced.d.d(this, this.m, this.r.a(), cVar);
        }
        if (this.k == null) {
            com.anythink.expressad.advanced.c.b bVar = new com.anythink.expressad.advanced.c.b(com.anythink.core.common.b.o.a().f(), this.i, this.h);
            this.k = bVar;
            bVar.a(this);
        }
        this.k.a(this.n);
        this.k.a(cVar, this.o, true);
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        this.f = dVar;
        this.I = true;
        this.f197s = true;
        this.o.clearResStateAndRemoveClose();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.c d = com.anythink.expressad.d.b.d(com.anythink.expressad.foundation.b.a.b().e(), this.h);
        this.r = d;
        if (d == null) {
            this.r = com.anythink.expressad.d.c.y();
        }
        com.anythink.expressad.advanced.d.b bVar = new com.anythink.expressad.advanced.d.b(this);
        this.l = bVar;
        bVar.a(this.m);
        if (this.j == null) {
            this.j = new com.anythink.expressad.advanced.c.a(this.i, this.h);
        }
        com.anythink.expressad.advanced.d.b bVar2 = this.l;
        if (bVar2 != null) {
            this.j.a(bVar2);
        }
        this.o.resetLoadState();
        this.j.a(this.o);
        this.j.a(this.r);
        this.j.a(this.z, this.A);
        this.j.a(this.t);
        this.j.a(dVar);
    }

    public final void a(com.anythink.expressad.out.o oVar) {
        this.m = oVar;
    }

    public final boolean a() {
        return this.f197s;
    }

    public final void b() {
        this.f197s = false;
    }

    public final void b(int i) {
        this.w = true;
        h(i);
    }

    public final com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup c() {
        return this.E;
    }

    public final void c(int i) {
        this.y = true;
        i(i);
    }

    public final int d() {
        return this.t;
    }

    public final void d(int i) {
        if (i == 1) {
            this.F = true;
        } else if (i == 2) {
            this.G = true;
        } else if (i == 3) {
            this.H = true;
        }
        try {
            k();
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void e() {
        if (this.m != null) {
            this.m = null;
        }
        if (this.l != null) {
            this.l = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        com.anythink.expressad.advanced.c.a aVar = this.j;
        if (aVar != null) {
            aVar.a((com.anythink.expressad.advanced.view.ATNativeAdvancedView) null);
            this.j.b();
        }
        com.anythink.expressad.advanced.c.b bVar = this.k;
        if (bVar != null) {
            bVar.c();
        }
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.o;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.destroy();
        }
        com.anythink.expressad.advanced.a.a.c(this.f.f());
        com.anythink.expressad.advanced.view.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.a();
        }
        com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup aTOutNativeAdvancedViewGroup = this.E;
        if (aTOutNativeAdvancedViewGroup != null) {
            aTOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.J);
            this.E.removeAllViews();
            this.E = null;
        }
    }

    public final void e(int i) {
        if (i == 1) {
            this.F = false;
        } else if (i == 2) {
            this.G = false;
        } else if (i == 3) {
            this.H = false;
        }
        com.anythink.expressad.advanced.c.b bVar = this.k;
        if (bVar != null) {
            bVar.e();
        }
    }

    public final int f() {
        com.anythink.expressad.advanced.c.a aVar = this.j;
        com.anythink.expressad.foundation.d.c c2 = aVar != null ? aVar.c() : null;
        if (c2 != null) {
            return android.text.TextUtils.isEmpty(c2.S()) ? 2 : 1;
        }
        return 0;
    }

    @Override // com.anythink.core.common.a.h
    public boolean isReady() {
        return true;
    }
}
