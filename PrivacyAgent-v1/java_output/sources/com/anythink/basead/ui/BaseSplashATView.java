package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseSplashATView extends com.anythink.basead.ui.BaseATView {
    protected android.widget.TextView C;
    protected com.anythink.basead.ui.CloseFrameLayout D;
    protected java.lang.String E;
    protected java.util.Timer F;
    protected boolean G;
    protected com.anythink.basead.e.a H;
    protected com.anythink.basead.ui.b I;
    final long J;
    protected final android.view.View.OnClickListener K;
    protected com.anythink.basead.ui.d.a L;
    boolean M;
    boolean N;
    boolean O;
    boolean P;
    private com.anythink.core.common.o.a.f.b v;
    private long w;

    /* renamed from: com.anythink.basead.ui.BaseSplashATView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.BaseSplashATView baseSplashATView = com.anythink.basead.ui.BaseSplashATView.this;
            android.view.View view2 = baseSplashATView.f149s;
            if (view2 == null || view2 != view) {
                com.anythink.basead.ui.BaseSplashATView.super.a(1, 2);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                com.anythink.basead.ui.BaseSplashATView.super.a(1, 1);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseSplashATView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.basead.ui.BaseSplashATView.this.b.n.v() == 0 || com.anythink.basead.ui.BaseSplashATView.this.O) {
                com.anythink.basead.ui.BaseSplashATView.this.b(true);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseSplashATView$3, reason: invalid class name */
    public class AnonymousClass3 extends java.util.TimerTask {

        /* renamed from: com.anythink.basead.ui.BaseSplashATView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (com.anythink.basead.ui.BaseSplashATView.this.w <= 0) {
                    com.anythink.basead.ui.BaseSplashATView.e(com.anythink.basead.ui.BaseSplashATView.this);
                } else {
                    com.anythink.basead.ui.BaseSplashATView baseSplashATView = com.anythink.basead.ui.BaseSplashATView.this;
                    baseSplashATView.a(baseSplashATView.w);
                }
                com.anythink.basead.ui.BaseSplashATView.this.w -= 1000;
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseSplashATView baseSplashATView = com.anythink.basead.ui.BaseSplashATView.this;
            if (com.anythink.core.common.o.w.a(baseSplashATView, baseSplashATView.v)) {
                com.anythink.basead.ui.BaseSplashATView.this.post(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass3.AnonymousClass1());
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseSplashATView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseSplashATView.this.I.c();
        }
    }

    public BaseSplashATView(android.content.Context context) {
        super(context);
        this.E = "Skip";
        this.J = 1000L;
        this.w = 5000L;
        this.K = new com.anythink.basead.ui.BaseSplashATView.AnonymousClass1();
        this.M = false;
        this.N = false;
        this.O = false;
    }

    public BaseSplashATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar);
        this.E = "Skip";
        this.J = 1000L;
        this.w = 5000L;
        this.K = new com.anythink.basead.ui.BaseSplashATView.AnonymousClass1();
        this.M = false;
        this.N = false;
        this.O = false;
        this.v = new com.anythink.core.common.o.a.f.b();
        this.H = aVar;
        this.E = getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_skip_text", com.anythink.expressad.foundation.h.i.g));
        this.C = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_skip", "id"));
        this.D = (com.anythink.basead.ui.CloseFrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_skip_area", "id"));
        this.w = this.b.n.t();
        this.G = false;
        a(this.D, this.b.n.n());
        if (lVar.d() == 4) {
            try {
                android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_install_btn", "id"));
                android.graphics.drawable.Drawable directlySplashAdCTAButtongBgDrawable = com.anythink.core.api.ATSDKGlobalSetting.getDirectlySplashAdCTAButtongBgDrawable();
                if (textView != null) {
                    if (directlySplashAdCTAButtongBgDrawable != null) {
                        textView.setBackgroundDrawable(directlySplashAdCTAButtongBgDrawable);
                    } else {
                        textView.setBackgroundResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_bg_rectangle_btn_cta_directly_asseblem", com.anythink.expressad.foundation.h.i.c));
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.b.n.v() != 0) {
            this.C.setText((j / 1000) + " s");
            return;
        }
        this.C.setText((j / 1000) + "s | " + this.E);
    }

    private void b() {
        if (this.N) {
            return;
        }
        this.N = true;
        if (this.P) {
            return;
        }
        this.D.setVisibility(0);
        this.D.setOnClickListener(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass2());
        this.O = false;
        java.util.Timer timer = new java.util.Timer();
        this.F = timer;
        timer.schedule(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass3(), 1000L, 1000L);
        a(this.w);
        this.w -= 1000;
    }

    private void c() {
        this.D.setVisibility(0);
        this.D.setOnClickListener(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass2());
        this.O = false;
        java.util.Timer timer = new java.util.Timer();
        this.F = timer;
        timer.schedule(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass3(), 1000L, 1000L);
        a(this.w);
        this.w -= 1000;
    }

    public static /* synthetic */ void e(com.anythink.basead.ui.BaseSplashATView baseSplashATView) {
        baseSplashATView.b(true);
        baseSplashATView.C.setText(baseSplashATView.E);
        baseSplashATView.O = true;
    }

    private void o() {
        b(true);
        this.C.setText(this.E);
        this.O = true;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, int i2) {
        super.a(i, i2);
        a(this.D, this.b.n.m());
    }

    public final void a(com.anythink.basead.c.e eVar) {
        if (this.M) {
            return;
        }
        this.M = true;
        com.anythink.basead.e.a aVar = this.H;
        if (aVar != null) {
            aVar.onShowFailed(eVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(com.anythink.basead.e.i iVar) {
        com.anythink.basead.e.a aVar = this.H;
        if (aVar != null) {
            aVar.onAdClick(iVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(boolean z) {
        com.anythink.basead.e.a aVar = this.H;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    public final void b(boolean z) {
        java.util.Timer timer = this.F;
        if (timer != null) {
            timer.cancel();
        }
        this.F = null;
        if (this.G) {
            return;
        }
        this.G = true;
        a(115);
        if (z) {
            if (!this.M) {
                a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, "SplashView not showing on screen."));
            }
            com.anythink.basead.e.a aVar = this.H;
            if (aVar != null) {
                aVar.onAdClosed();
            }
        }
    }

    public void checkSkipViewLocation() {
        try {
            android.view.ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
            if (layoutParams instanceof android.widget.FrameLayout.LayoutParams) {
                int b = ((android.widget.FrameLayout.LayoutParams) layoutParams).topMargin + com.anythink.core.common.o.i.b(getContext());
                int[] iArr = new int[2];
                this.C.getLocationOnScreen(iArr);
                int i = iArr[1];
                if (i < b) {
                    int i2 = b - i;
                    android.view.ViewParent parent = this.C.getParent();
                    if (parent instanceof android.view.ViewGroup) {
                        ((android.view.ViewGroup) parent).setPadding(((android.view.ViewGroup) parent).getPaddingLeft(), ((android.view.ViewGroup) parent).getPaddingTop() + i2, ((android.view.ViewGroup) parent).getPaddingRight(), ((android.view.ViewGroup) parent).getPaddingBottom());
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void d() {
        super.d();
        com.anythink.core.common.f.m mVar = this.b;
        if (mVar != null) {
            this.L = new com.anythink.basead.ui.d.a(this.c, mVar.n);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        this.H = null;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void e() {
        this.M = true;
        com.anythink.basead.e.a aVar = this.H;
        if (aVar != null) {
            aVar.onAdShow(new com.anythink.basead.e.i());
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void f() {
        if (this.c instanceof com.anythink.core.common.f.ai) {
            if (this.I == null) {
                this.I = new com.anythink.basead.ui.b(this);
            }
            this.I.b();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void g() {
        if (!(this.c instanceof com.anythink.core.common.f.ai) || this.I == null) {
            return;
        }
        post(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass4());
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final android.widget.RelativeLayout.LayoutParams m() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        if (this.b.n.w() == 2) {
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, com.anythink.core.common.o.i.a(getContext(), 154.0f));
        } else {
            int measuredHeight = (getMeasuredHeight() * 2) / 3;
            layoutParams.addRule(11);
            layoutParams.setMargins(0, measuredHeight, 0, 0);
        }
        return layoutParams;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final int n() {
        return 3;
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b(false);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        checkSkipViewLocation();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            if (z) {
                a(110);
            } else {
                a(111);
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@androidx.annotation.NonNull android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (android.os.Build.VERSION.SDK_INT < 24) {
            if (i == 0) {
                a(110);
            } else {
                a(111);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.N) {
            return;
        }
        this.N = true;
        if (this.P) {
            return;
        }
        this.D.setVisibility(0);
        this.D.setOnClickListener(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass2());
        this.O = false;
        java.util.Timer timer = new java.util.Timer();
        this.F = timer;
        timer.schedule(new com.anythink.basead.ui.BaseSplashATView.AnonymousClass3(), 1000L, 1000L);
        a(this.w);
        this.w -= 1000;
    }

    public void p() {
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            android.view.View view = this.p.get(i);
            if (view != null) {
                view.setOnClickListener(this.K);
            }
        }
    }

    public void setDontCountDown(boolean z) {
        com.anythink.basead.ui.CloseFrameLayout closeFrameLayout;
        this.P = z;
        if (!z || (closeFrameLayout = this.D) == null) {
            return;
        }
        closeFrameLayout.setVisibility(8);
    }
}
