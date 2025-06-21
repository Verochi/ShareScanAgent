package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MraidSplashATView extends com.anythink.basead.ui.BaseSplashATView {
    com.anythink.basead.ui.MraidContainerView v;
    boolean w;

    /* renamed from: com.anythink.basead.ui.MraidSplashATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.MraidSplashATView.this.a(i, i2);
        }
    }

    /* renamed from: com.anythink.basead.ui.MraidSplashATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.ui.MraidContainerView.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            try {
                com.anythink.basead.ui.MraidSplashATView.a(com.anythink.basead.ui.MraidSplashATView.this);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(java.lang.String str) {
            com.anythink.basead.ui.MraidSplashATView.this.c.w(str);
            com.anythink.basead.ui.MraidSplashATView.this.a(1, 13);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
            com.anythink.basead.ui.MraidSplashATView.this.a(106);
            com.anythink.basead.ui.MraidSplashATView.this.p();
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
            com.anythink.basead.ui.MraidSplashATView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, com.anythink.basead.c.f.Q));
            com.anythink.basead.ui.MraidSplashATView.this.b(true);
        }
    }

    /* renamed from: com.anythink.basead.ui.MraidSplashATView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.ViewTreeObserver a;

        public AnonymousClass3(android.view.ViewTreeObserver viewTreeObserver) {
            this.a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            try {
                com.anythink.basead.ui.MraidSplashATView mraidSplashATView = com.anythink.basead.ui.MraidSplashATView.this;
                if (!mraidSplashATView.w) {
                    mraidSplashATView.w = true;
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) mraidSplashATView.v.getLayoutParams();
                    layoutParams.width = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.MraidSplashATView.this.c.f());
                    layoutParams.height = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.MraidSplashATView.this.c.g());
                    int width = com.anythink.basead.ui.MraidSplashATView.this.getWidth();
                    int height = com.anythink.basead.ui.MraidSplashATView.this.getHeight();
                    float f = com.anythink.basead.ui.MraidSplashATView.this.c.f() / (com.anythink.basead.ui.MraidSplashATView.this.c.g() * 1.0f);
                    layoutParams.width = java.lang.Math.min(width, layoutParams.width);
                    int min = java.lang.Math.min(height, layoutParams.height);
                    layoutParams.height = min;
                    int i = layoutParams.width;
                    float f2 = i / (min * 1.0f);
                    if (f2 > f) {
                        layoutParams.width = (int) (min * f);
                    } else if (f2 < f) {
                        layoutParams.height = (int) (i / f);
                    }
                    layoutParams.gravity = 17;
                }
                this.a.removeGlobalOnLayoutListener(this);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.MraidSplashATView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.MraidSplashATView mraidSplashATView = com.anythink.basead.ui.MraidSplashATView.this;
            if (mraidSplashATView.H == null) {
                return;
            }
            com.anythink.basead.ui.MraidSplashATView.super.h();
        }
    }

    public MraidSplashATView(android.content.Context context) {
        super(context);
    }

    public MraidSplashATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.MraidSplashATView mraidSplashATView) {
        if (mraidSplashATView.c.j() && mraidSplashATView.v == null) {
            return;
        }
        super.a(mraidSplashATView.b.n.V() < 0 ? 100 : mraidSplashATView.b.n.V(), mraidSplashATView.new AnonymousClass4());
    }

    private void b() {
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.c, this.b, new com.anythink.basead.ui.MraidSplashATView.AnonymousClass2());
        this.v = mraidContainerView;
        mraidContainerView.setNeedRegisterVolumeChangeReceiver(true);
        this.v.init();
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_web", "id"));
        if (this.c.f() > 0 && this.c.g() > 0) {
            android.view.ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new com.anythink.basead.ui.MraidSplashATView.AnonymousClass3(viewTreeObserver));
            frameLayout.setBackgroundDrawable(new com.anythink.basead.ui.a.a());
        }
        if (frameLayout != null) {
            this.v.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.v);
        }
    }

    private void c() {
        if (this.c.j() && this.v == null) {
            return;
        }
        super.a(this.b.n.V() < 0 ? 100 : this.b.n.V(), new com.anythink.basead.ui.MraidSplashATView.AnonymousClass4());
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a() {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_web_splash_ad_layout", "layout"), this);
        com.anythink.basead.ui.d.a aVar = this.L;
        if (aVar != null) {
            aVar.a(com.anythink.basead.ui.d.a.c).a(new com.anythink.basead.ui.MraidSplashATView.AnonymousClass1()).a(getContext(), this);
        }
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.c, this.b, new com.anythink.basead.ui.MraidSplashATView.AnonymousClass2());
        this.v = mraidContainerView;
        mraidContainerView.setNeedRegisterVolumeChangeReceiver(true);
        this.v.init();
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_web", "id"));
        if (this.c.f() > 0 && this.c.g() > 0) {
            android.view.ViewTreeObserver viewTreeObserver = frameLayout.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new com.anythink.basead.ui.MraidSplashATView.AnonymousClass3(viewTreeObserver));
            frameLayout.setBackgroundDrawable(new com.anythink.basead.ui.a.a());
        }
        if (frameLayout != null) {
            this.v.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(this.v);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView, com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.v;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.v;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    public final void p() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            android.view.View view = this.p.get(i);
            if (view != null) {
                view.setOnClickListener(this.K);
            }
        }
    }
}
