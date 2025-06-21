package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseATView extends android.widget.RelativeLayout implements com.anythink.basead.ui.guidetoclickv2.d {
    java.lang.String a;
    com.anythink.core.common.f.m b;
    com.anythink.core.common.f.l c;
    com.anythink.core.common.o.a.c d;
    com.anythink.basead.a.b e;
    volatile boolean f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    java.lang.String o;
    java.util.List<android.view.View> p;
    android.view.View q;
    protected boolean r;

    /* renamed from: s, reason: collision with root package name */
    protected android.view.View f149s;
    protected com.anythink.basead.ui.b.a t;
    com.anythink.basead.ui.guidetoclickv2.c u;
    private boolean v;

    /* renamed from: com.anythink.basead.ui.BaseATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.b.b.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.b.b.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.BaseATView.this.a(i, i2);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseATView$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.basead.ui.b.a {
        public AnonymousClass2(android.view.ViewGroup viewGroup, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i, com.anythink.basead.ui.b.b.a aVar) {
            super(viewGroup, lVar, mVar, i, aVar);
        }

        @Override // com.anythink.basead.ui.b.a
        public final android.view.ViewGroup.LayoutParams a() {
            return com.anythink.basead.ui.BaseATView.this.m();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseATView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.basead.a.b.InterfaceC0128b {
        final /* synthetic */ com.anythink.basead.e.i a;

        public AnonymousClass3(com.anythink.basead.e.i iVar) {
            this.a = iVar;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a() {
            com.anythink.basead.ui.BaseATView.this.a(this.a);
            com.anythink.basead.ui.BaseATView baseATView = com.anythink.basead.ui.BaseATView.this;
            com.anythink.core.common.f.l lVar = baseATView.c;
            if ((lVar instanceof com.anythink.core.common.f.ai) && baseATView.b.f == 67) {
                if (((com.anythink.core.common.f.ai) lVar).a(true, false)) {
                    com.anythink.core.common.d.c.a(baseATView.getContext()).a(baseATView.c.s(), 1, 0);
                }
                if (((com.anythink.core.common.f.ai) baseATView.c).a(false, false)) {
                    com.anythink.core.common.d.b.a(baseATView.getContext()).a(baseATView.c.t(), 1, 0);
                }
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a(boolean z) {
            com.anythink.basead.ui.BaseATView.this.a(z);
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
            return com.anythink.basead.ui.BaseATView.this.a(str, iOfferClickHandler);
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void b() {
            com.anythink.basead.ui.BaseATView.this.f();
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void c() {
            com.anythink.basead.ui.BaseATView.this.g();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseATView$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.core.common.o.a.a {
        final /* synthetic */ java.lang.Runnable a;
        final /* synthetic */ int b;

        public AnonymousClass4(java.lang.Runnable runnable, int i) {
            this.a = runnable;
            this.b = i;
        }

        @Override // com.anythink.core.common.o.a.a, com.anythink.core.common.o.a.b
        public final int getImpressionMinTimeViewed() {
            int i = this.b;
            if (i > 0) {
                return i;
            }
            return 50;
        }

        @Override // com.anythink.core.common.o.a.a, com.anythink.core.common.o.a.b
        public final void recordImpression(android.view.View view) {
            java.lang.Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public static class a {
        public static final int a = 101;
        public static final int b = 102;
        public static final int c = 103;
        public static final int d = 104;
        public static final int e = 105;
        public static final int f = 106;
        public static final int g = 107;
        public static final int h = 108;
        public static final int i = 110;
        public static final int j = 111;
        public static final int k = 112;
        public static final int l = 113;
        public static final int m = 114;
        public static final int n = 115;
        public static final int o = 116;
        public static final int p = 117;
    }

    public static class b {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
    }

    public BaseATView(android.content.Context context) {
        super(context);
        this.a = "BaseATView";
        this.v = false;
        this.r = false;
    }

    public BaseATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        this(context, mVar, lVar, "");
    }

    public BaseATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str) {
        super(context);
        this.a = "BaseATView";
        this.v = false;
        this.r = false;
        this.b = mVar;
        this.c = lVar;
        this.o = str;
        this.p = new java.util.ArrayList();
        d();
        a();
        this.t = new com.anythink.basead.ui.BaseATView.AnonymousClass2(this, this.c, this.b, n(), new com.anythink.basead.ui.BaseATView.AnonymousClass1());
        setFocusable(true);
        setClickable(true);
    }

    private boolean a(android.view.MotionEvent motionEvent) {
        synchronized (this) {
            try {
                com.anythink.basead.ui.guidetoclickv2.c cVar = this.u;
                if (cVar != null) {
                    if (cVar.a(motionEvent)) {
                        return true;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
            return false;
        }
    }

    private static int b(int i) {
        java.util.Random random = new java.util.Random();
        if (i <= 0) {
            return 0;
        }
        double d = i;
        int i2 = (int) (0.1d * d);
        return random.nextInt((((int) (d * 0.9d)) - i2) + 1) + i2;
    }

    private void b() {
        this.t = new com.anythink.basead.ui.BaseATView.AnonymousClass2(this, this.c, this.b, n(), new com.anythink.basead.ui.BaseATView.AnonymousClass1());
    }

    private void b(android.view.View view) {
        this.q = view;
    }

    private void c() {
        com.anythink.core.common.f.l lVar = this.c;
        if (lVar instanceof com.anythink.core.common.f.z) {
            com.anythink.basead.f.a.b.a(getContext()).a((com.anythink.core.common.f.z) this.c);
        } else if (lVar instanceof com.anythink.core.common.f.ai) {
            com.anythink.basead.d.c.d a2 = com.anythink.basead.d.c.d.a();
            android.content.Context context = getContext();
            com.anythink.core.common.f.m mVar = this.b;
            a2.a(context, com.anythink.basead.d.c.d.a(mVar.b, mVar.c), this.c, this.b.n);
        }
        com.anythink.core.common.f.l lVar2 = this.c;
        if ((lVar2 instanceof com.anythink.core.common.f.ai) && this.b.f == 67) {
            if (((com.anythink.core.common.f.ai) lVar2).a(true, true)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.c.s(), 0, 1);
            }
            if (((com.anythink.core.common.f.ai) this.c).a(false, true)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.c.t(), 0, 1);
            }
        }
    }

    private void o() {
        com.anythink.core.common.f.l lVar = this.c;
        if ((lVar instanceof com.anythink.core.common.f.ai) && this.b.f == 67) {
            if (((com.anythink.core.common.f.ai) lVar).a(true, false)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.c.s(), 1, 0);
            }
            if (((com.anythink.core.common.f.ai) this.c).a(false, false)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.c.t(), 1, 0);
            }
        }
    }

    private boolean p() {
        return com.anythink.basead.a.d.b(this.c);
    }

    public float a(com.anythink.basead.ui.a aVar, int i) {
        float f = 1.0f;
        if (aVar != null) {
            if (i == 2) {
                f = 1.5f;
            } else if (i == 3) {
                f = 0.75f;
            } else if (i == 4) {
                f = 0.5f;
            }
            aVar.setClickAreaScaleFactor(f);
        }
        return f;
    }

    public abstract void a();

    public final void a(int i) {
        com.anythink.basead.ui.b.a aVar = this.t;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(int i, int i2) {
        this.v = true;
        h();
        if (this.e == null) {
            this.e = new com.anythink.basead.a.b(getContext(), this.b, this.c);
        }
        if (this.e.a()) {
            return;
        }
        if (this.r) {
            if (i2 == 1) {
                i2 = 6;
            } else if (i2 == 2 || i2 == 3) {
                i2 = 7;
            } else if (i2 == 4) {
                i2 = 8;
            } else if (i2 == 5) {
                i2 = 9;
            }
        }
        this.e.a(new com.anythink.basead.ui.BaseATView.AnonymousClass3(new com.anythink.basead.e.i().a(i, i2)));
        com.anythink.basead.c.i i3 = i();
        if (i != 1) {
            android.view.View view = this.q;
            if (view != null) {
                a(view);
            } else {
                a(this);
            }
        }
        i3.g = j();
        this.e.a(i3);
        a(113);
    }

    public void a(int i, java.lang.Runnable runnable) {
        if (i > 0) {
            getContext();
            this.d = new com.anythink.core.common.o.a.c(i);
        } else {
            getContext();
            this.d = new com.anythink.core.common.o.a.c();
        }
        this.d.a(this, new com.anythink.basead.ui.BaseATView.AnonymousClass4(runnable, i));
    }

    public final void a(android.view.View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int b2 = b(width);
        int b3 = b(height);
        int i3 = i + b2;
        this.g = i3;
        this.h = i2 + b3;
        this.k = b2;
        this.l = b3;
        this.i = i3 + ((int) (java.lang.Math.random() * 15.0d));
        int random = b2 + i2 + ((int) (java.lang.Math.random() * 15.0d));
        this.j = random;
        this.m = this.i - i;
        this.n = random - i2;
    }

    public abstract void a(com.anythink.basead.e.i iVar);

    public abstract void a(boolean z);

    public boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
        return false;
    }

    public void d() {
    }

    public void destroy() {
        a(112);
        com.anythink.basead.a.b bVar = this.e;
        if (bVar != null) {
            bVar.d();
        }
        com.anythink.core.common.o.a.c cVar = this.d;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = (int) motionEvent.getRawX();
            this.h = (int) motionEvent.getRawY();
            this.k = (int) motionEvent.getX();
            this.l = (int) motionEvent.getY();
        } else if (action == 1 || action == 3) {
            this.i = (int) motionEvent.getRawX();
            this.j = (int) motionEvent.getRawY();
            this.m = (int) motionEvent.getX();
            this.n = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public abstract void e();

    public void f() {
    }

    public void g() {
    }

    public boolean getHasPerformClick() {
        return this.v;
    }

    public synchronized void h() {
        if (this.f) {
            return;
        }
        this.f = true;
        com.anythink.core.common.f.l lVar = this.c;
        if (lVar instanceof com.anythink.core.common.f.z) {
            com.anythink.basead.f.a.b.a(getContext()).a((com.anythink.core.common.f.z) this.c);
        } else if (lVar instanceof com.anythink.core.common.f.ai) {
            com.anythink.basead.d.c.d a2 = com.anythink.basead.d.c.d.a();
            android.content.Context context = getContext();
            com.anythink.core.common.f.m mVar = this.b;
            a2.a(context, com.anythink.basead.d.c.d.a(mVar.b, mVar.c), this.c, this.b.n);
        }
        com.anythink.core.common.f.l lVar2 = this.c;
        if ((lVar2 instanceof com.anythink.core.common.f.ai) && this.b.f == 67) {
            if (((com.anythink.core.common.f.ai) lVar2).a(true, true)) {
                com.anythink.core.common.d.c.a(getContext()).a(this.c.s(), 0, 1);
            }
            if (((com.anythink.core.common.f.ai) this.c).a(false, true)) {
                com.anythink.core.common.d.b.a(getContext()).a(this.c.t(), 0, 1);
            }
        }
        a(114);
        com.anythink.basead.a.a.a(8, this.c, i());
        e();
    }

    public com.anythink.basead.c.i i() {
        com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.b.d, "");
        iVar.e = getWidth();
        iVar.f = getHeight();
        return iVar;
    }

    public boolean isShowingEndCardAfterVideoPlay() {
        return this.r;
    }

    public final com.anythink.basead.c.a j() {
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        aVar.a = this.g;
        aVar.b = this.h;
        aVar.c = this.i;
        aVar.d = this.j;
        aVar.e = this.k;
        aVar.f = this.l;
        aVar.g = this.m;
        aVar.h = this.n;
        return aVar;
    }

    public boolean k() {
        com.anythink.core.common.f.m mVar;
        com.anythink.core.common.f.n nVar;
        return com.anythink.expressad.shake.a.a().b() && (mVar = this.b) != null && (nVar = mVar.n) != null && nVar.Q() == 1;
    }

    public boolean l() {
        return false;
    }

    public android.widget.RelativeLayout.LayoutParams m() {
        return null;
    }

    public int n() {
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(116);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(117);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.d
    public void setCallback(com.anythink.basead.ui.guidetoclickv2.c cVar) {
        synchronized (this) {
            this.u = cVar;
        }
    }

    public void setHasPerformClick(boolean z) {
        this.v = z;
    }

    public void setShowingEndCardAfterVideoPlay(boolean z) {
        this.r = z;
    }
}
