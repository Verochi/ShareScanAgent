package com.anythink.expressad.splash.d;

/* loaded from: classes12.dex */
public final class c implements com.anythink.core.common.a.h {
    private static java.lang.String b = "SplashProvider";
    private android.content.Context A;
    private boolean B;
    private com.anythink.expressad.foundation.d.c C;
    private com.anythink.expressad.splash.view.ATSplashPopView D;
    private java.lang.String c;
    private java.lang.String d;
    private long f;
    private int g;
    private int h;
    private com.anythink.expressad.splash.c.c i;
    private com.anythink.expressad.splash.c.d j;
    private com.anythink.expressad.splash.d.b k;
    private com.anythink.expressad.out.e l;
    private com.anythink.expressad.splash.d.d m;
    private com.anythink.expressad.splash.view.ATSplashView n;
    private com.anythink.expressad.splash.view.ATSplashWebview o;
    private android.view.ViewGroup p;
    private android.view.View q;
    private com.anythink.expressad.d.c r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f260s;
    private android.view.ViewGroup t;
    private boolean u;
    private int w;
    private int x;
    private int e = 5;
    private int v = 1;
    private java.lang.Object y = new java.lang.Object();
    private java.lang.Object z = new java.lang.Object();
    public boolean a = false;
    private boolean E = false;
    private boolean F = false;

    /* renamed from: com.anythink.expressad.splash.d.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;

        public AnonymousClass1(com.anythink.expressad.foundation.d.c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.d.c.this.a(this.a, false);
        }
    }

    /* renamed from: com.anythink.expressad.splash.d.c$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;

        public AnonymousClass2(com.anythink.expressad.foundation.d.c cVar, int i, boolean z) {
            this.a = cVar;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.d.c.this.a(this.a, this.b - 1, this.c);
        }
    }

    /* renamed from: com.anythink.expressad.splash.d.c$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnTouchListener {
        final /* synthetic */ boolean a = true;

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return !this.a;
        }
    }

    /* renamed from: com.anythink.expressad.splash.d.c$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnTouchListener {
        final /* synthetic */ boolean a = true;

        public AnonymousClass4() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            return !this.a;
        }
    }

    public c(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.w = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f());
        this.x = com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
        this.w = context.getResources().getDisplayMetrics().widthPixels;
        this.x = context.getResources().getDisplayMetrics().heightPixels;
        this.d = str;
        this.c = str2;
        this.A = context;
        if (this.j == null) {
            this.j = new com.anythink.expressad.splash.c.d(context, str, str2);
        }
        if (this.o == null) {
            try {
                this.o = new com.anythink.expressad.splash.view.ATSplashWebview(context);
            } catch (java.lang.Exception unused) {
            }
            com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.o;
            if (aTSplashWebview != null) {
                aTSplashWebview.setWebViewClient(new com.anythink.expressad.splash.view.b(this.c, this.j.a()));
            }
        }
        if (this.n == null) {
            com.anythink.expressad.splash.view.ATSplashView aTSplashView = new com.anythink.expressad.splash.view.ATSplashView(context);
            this.n = aTSplashView;
            aTSplashView.setSplashWebview(this.o);
        }
    }

    private android.view.ViewGroup a(com.anythink.expressad.out.t tVar) {
        com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView = new com.anythink.expressad.splash.view.ATSplashPopView(com.anythink.core.common.b.o.a().f(), new com.anythink.expressad.splash.view.ATSplashPopView.a(this.d, this.c, tVar.a(), this.C), this.m);
        this.D = aTSplashPopView;
        return aTSplashPopView;
    }

    private void a(int i, int i2) {
        int e = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.o.a().f());
        int f = com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.o.a().f());
        int i3 = this.v;
        if (i3 == 1) {
            if (f >= i2 * 4) {
                this.x = f - i2;
                this.w = e;
                return;
            } else {
                this.x = 0;
                this.w = 0;
                return;
            }
        }
        if (i3 == 2) {
            if (e >= i * 4) {
                this.w = e - i;
                this.x = f;
            } else {
                this.x = 0;
                this.w = 0;
            }
        }
    }

    private void a(long j) {
        this.f = j;
    }

    private void a(android.content.Context context) {
        if (this.j == null) {
            if (context != null) {
                this.j = new com.anythink.expressad.splash.c.d(context, this.d, this.c);
            } else {
                this.j = new com.anythink.expressad.splash.c.d(com.anythink.core.common.b.o.a().f(), this.d, this.c);
            }
        }
        if (this.o == null) {
            try {
                if (context != null) {
                    this.o = new com.anythink.expressad.splash.view.ATSplashWebview(context);
                } else {
                    this.o = new com.anythink.expressad.splash.view.ATSplashWebview(com.anythink.core.common.b.o.a().f());
                }
            } catch (java.lang.Exception unused) {
            }
            com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.o;
            if (aTSplashWebview != null) {
                aTSplashWebview.setWebViewClient(new com.anythink.expressad.splash.view.b(this.c, this.j.a()));
            }
        }
        if (this.n == null) {
            if (context != null) {
                this.n = new com.anythink.expressad.splash.view.ATSplashView(context);
            } else {
                this.n = new com.anythink.expressad.splash.view.ATSplashView(com.anythink.core.common.b.o.a().f());
            }
            this.n.setSplashWebview(this.o);
        }
    }

    private void a(android.view.View view, android.widget.RelativeLayout.LayoutParams layoutParams) {
        this.q = view;
        if (view != null) {
            a(layoutParams.width, layoutParams.height);
            com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.n;
            if (aTSplashView != null) {
                aTSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, int i, boolean z) {
        if (!com.anythink.expressad.splash.c.b.a(this.n, cVar)) {
            if (i > 0) {
                this.j.a.postDelayed(new com.anythink.expressad.splash.d.c.AnonymousClass2(cVar, i, z), 1L);
                return;
            }
            com.anythink.expressad.splash.d.d dVar = this.m;
            if (dVar != null) {
                dVar.a("campaignEx is not ready");
                return;
            }
            return;
        }
        l();
        this.j.a(this.e);
        this.j.a(this.t);
        this.j.a(this.m);
        android.view.ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            com.anythink.core.common.o.w.a(this.n);
            this.p.addView(this.n, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        this.j.a(this.u);
        this.j.a(cVar, this.n);
    }

    private void a(java.lang.String str, android.view.ViewGroup viewGroup) {
        if (!android.text.TextUtils.isEmpty(str)) {
            a(viewGroup);
            return;
        }
        com.anythink.expressad.out.e eVar = this.l;
        if (eVar != null) {
            eVar.a("token is null or empty");
        }
    }

    private void b(android.view.ViewGroup viewGroup) {
        this.t = viewGroup;
    }

    private void c(boolean z) {
        this.B = z;
    }

    private java.lang.String h() {
        if (this.a) {
            com.anythink.expressad.splash.c.d dVar = this.j;
            return dVar != null ? dVar.b() : "";
        }
        com.anythink.expressad.splash.c.c cVar = this.i;
        return cVar != null ? cVar.a() : "";
    }

    private void i() {
        this.E = true;
        com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView != null) {
            aTSplashPopView.startCountDown();
        }
    }

    private void j() {
        this.E = false;
        com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView != null) {
            aTSplashPopView.release();
        }
    }

    private void k() {
        com.anythink.expressad.splash.c.d dVar = this.j;
        if (dVar != null) {
            dVar.d();
        }
        com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView == null || !this.E) {
            return;
        }
        aTSplashPopView.reStartCountDown();
    }

    private void l() {
        com.anythink.expressad.splash.view.ATSplashWebview aTSplashWebview = this.o;
        if (aTSplashWebview != null) {
            aTSplashWebview.setOnTouchListener(new com.anythink.expressad.splash.d.c.AnonymousClass3());
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.n;
        if (aTSplashView != null) {
            aTSplashView.setOnTouchListener(new com.anythink.expressad.splash.d.c.AnonymousClass4());
        }
    }

    private void m() {
        com.anythink.expressad.splash.c.d dVar = this.j;
        if (dVar != null) {
            dVar.e();
        }
        com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView = this.D;
        if (aTSplashPopView == null || !this.E) {
            return;
        }
        aTSplashPopView.pauseCountDown();
    }

    public final void a(int i) {
        this.v = i;
    }

    public final void a(android.view.ViewGroup viewGroup) {
        this.p = viewGroup;
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.n;
        if (aTSplashView != null) {
            aTSplashView.setDevContainer(viewGroup);
        }
        com.anythink.expressad.splash.c.c cVar = this.i;
        com.anythink.expressad.foundation.d.c c = cVar != null ? cVar.c() : null;
        if (c == null) {
            com.anythink.expressad.out.e eVar = this.l;
            if (eVar != null) {
                eVar.a("campaignEx is vali");
                return;
            }
            return;
        }
        if (this.r == null) {
            com.anythink.expressad.d.b.a();
            this.r = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.c);
        }
        com.anythink.expressad.splash.d.d dVar = new com.anythink.expressad.splash.d.d(this, this.l, this.r.a(), c);
        this.m = dVar;
        int i = this.e;
        if (i < 2 || i > 10) {
            this.e = 5;
        }
        dVar.d();
        viewGroup.post(new com.anythink.expressad.splash.d.c.AnonymousClass1(c));
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
        if (cVar != null && z) {
            if (this.r == null) {
                com.anythink.expressad.d.b.a();
                this.r = com.anythink.expressad.d.b.a(com.anythink.expressad.foundation.b.a.b().e(), this.c);
            }
            this.m = new com.anythink.expressad.splash.d.d(this, this.l, this.r.a(), cVar);
        }
        this.C = cVar;
        android.view.ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            if (this.j == null) {
                this.j = new com.anythink.expressad.splash.c.d(viewGroup.getContext(), this.d, this.c);
            }
            a(cVar, 0, z);
        } else {
            com.anythink.expressad.splash.d.d dVar = this.m;
            if (dVar != null) {
                dVar.a("container is null");
            }
        }
    }

    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        synchronized (this.y) {
            if (this.f260s) {
                com.anythink.expressad.splash.d.b bVar = this.k;
                if (bVar != null) {
                    bVar.a("current unit is loading");
                    this.f260s = true;
                }
                return;
            }
            this.f260s = true;
            this.n.clearResState();
            this.r = new com.anythink.expressad.d.c();
            if (this.i == null) {
                this.i = new com.anythink.expressad.splash.c.c(this.d, this.c, this.f * 1000);
            }
            com.anythink.expressad.splash.d.b bVar2 = this.k;
            if (bVar2 != null) {
                bVar2.b("");
                this.i.a(this.k);
            }
            this.n.resetLoadState();
            this.i.b(this.e);
            this.i.a(this.n);
            this.i.a(this.r);
            this.i.a(this.w, this.x);
            this.i.b(this.u);
            this.i.a(this.F);
            this.i.a(this.v);
            this.i.a(dVar);
        }
    }

    public final void a(com.anythink.expressad.out.d dVar) {
        if (this.k == null) {
            this.k = new com.anythink.expressad.splash.d.b(this);
        }
        this.k.a(dVar);
    }

    public final void a(com.anythink.expressad.out.e eVar) {
        this.l = eVar;
    }

    public final void a(boolean z) {
        this.F = z;
    }

    public final boolean a() {
        return this.f260s;
    }

    public final void b() {
        this.f260s = false;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final void b(boolean z) {
        this.u = z;
    }

    public final long c() {
        return this.f;
    }

    public final boolean d() {
        return this.u;
    }

    public final int e() {
        return this.e;
    }

    public final void f() {
        a(100, 100);
    }

    public final void g() {
        this.C = null;
        if (this.l != null) {
            this.l = null;
        }
        if (this.k != null) {
            this.k = null;
        }
        if (this.m != null) {
            this.m = null;
        }
        com.anythink.expressad.splash.c.c cVar = this.i;
        if (cVar != null) {
            cVar.b();
        }
        com.anythink.expressad.splash.c.d dVar = this.j;
        if (dVar != null) {
            dVar.c();
        }
        if (this.A != null) {
            this.A = null;
        }
    }

    @Override // com.anythink.core.common.a.h
    public final boolean isReady() {
        com.anythink.expressad.splash.c.c cVar = this.i;
        return (cVar == null || cVar.c() == null || !com.anythink.expressad.splash.c.b.a(this.n, this.i.c())) ? false : true;
    }
}
