package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MraidContainerView extends android.widget.FrameLayout {
    public static final int ENDCARD_INIT = 1;
    public static final int LOAD_RETRY_CLICK = 3;
    public static final int PRE_LOAD = 5;
    public static final int VISIABLE_CLICK = 4;
    public static final int WINDOW_ATTACH_CHECK = 2;
    private static final java.lang.String j = "MraidContainerView";
    protected com.anythink.core.common.f.l a;
    protected com.anythink.core.common.f.n b;
    protected com.anythink.core.common.f.m c;
    protected com.anythink.basead.ui.b d;
    protected com.anythink.basead.ui.ClickToReLoadView e;
    protected com.anythink.basead.mraid.MraidWebView f;
    protected com.anythink.basead.ui.MraidContainerView.a g;
    boolean h;
    boolean i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;

    /* renamed from: com.anythink.basead.ui.MraidContainerView$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.basead.mraid.b {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.mraid.b
        public final void a() {
            com.anythink.basead.ui.MraidContainerView.a aVar = com.anythink.basead.ui.MraidContainerView.this.g;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void close() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
        public final void open(java.lang.String str) {
            com.anythink.basead.ui.MraidContainerView mraidContainerView = com.anythink.basead.ui.MraidContainerView.this;
            if (mraidContainerView.g == null || mraidContainerView.a(str)) {
                return;
            }
            com.anythink.basead.ui.MraidContainerView.this.g.a(str);
            com.anythink.basead.ui.MraidContainerView.this.h = false;
        }
    }

    /* renamed from: com.anythink.basead.ui.MraidContainerView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.ViewTreeObserver a;

        public AnonymousClass2(android.view.ViewTreeObserver viewTreeObserver) {
            this.a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            try {
                com.anythink.basead.ui.MraidContainerView mraidContainerView = com.anythink.basead.ui.MraidContainerView.this;
                if (!mraidContainerView.i) {
                    mraidContainerView.i = true;
                    android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) mraidContainerView.f.getLayoutParams();
                    layoutParams.width = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.MraidContainerView.this.a.f());
                    layoutParams.height = com.anythink.core.common.o.i.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.MraidContainerView.this.a.g());
                    int width = (com.anythink.basead.ui.MraidContainerView.this.getWidth() - com.anythink.basead.ui.MraidContainerView.this.getPaddingLeft()) - com.anythink.basead.ui.MraidContainerView.this.getPaddingRight();
                    int height = (com.anythink.basead.ui.MraidContainerView.this.getHeight() - com.anythink.basead.ui.MraidContainerView.this.getPaddingBottom()) - com.anythink.basead.ui.MraidContainerView.this.getPaddingTop();
                    float f = com.anythink.basead.ui.MraidContainerView.this.a.f() / (com.anythink.basead.ui.MraidContainerView.this.a.g() * 1.0f);
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

    /* renamed from: com.anythink.basead.ui.MraidContainerView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ int c;

        /* renamed from: com.anythink.basead.ui.MraidContainerView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.basead.mraid.d.a {
            public AnonymousClass1() {
            }

            @Override // com.anythink.basead.mraid.d.a
            public final void a() {
                java.lang.String unused = com.anythink.basead.ui.MraidContainerView.j;
                com.anythink.basead.ui.MraidContainerView.a(com.anythink.basead.ui.MraidContainerView.this);
                com.anythink.basead.ui.MraidContainerView.this.b();
                com.anythink.basead.ui.MraidContainerView.this.g();
            }

            @Override // com.anythink.basead.mraid.d.a
            public final void a(com.anythink.basead.c.e eVar) {
                com.anythink.basead.ui.MraidContainerView.a(com.anythink.basead.ui.MraidContainerView.this);
                java.lang.String unused = com.anythink.basead.ui.MraidContainerView.j;
                eVar.c();
                com.anythink.basead.ui.MraidContainerView.this.d();
                com.anythink.basead.ui.MraidContainerView.this.g();
            }
        }

        public AnonymousClass3(java.lang.String str, java.lang.String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.basead.ui.MraidContainerView.this.f = new com.anythink.basead.mraid.MraidWebView(com.anythink.core.common.b.o.a().f());
                java.lang.String str = this.a;
                java.lang.String str2 = this.b;
                com.anythink.basead.mraid.MraidWebView mraidWebView = com.anythink.basead.ui.MraidContainerView.this.f;
                com.anythink.basead.ui.MraidContainerView.AnonymousClass3.AnonymousClass1 anonymousClass1 = new com.anythink.basead.ui.MraidContainerView.AnonymousClass3.AnonymousClass1();
                com.anythink.basead.ui.MraidContainerView mraidContainerView = com.anythink.basead.ui.MraidContainerView.this;
                com.anythink.basead.mraid.d.a(str, str2, mraidWebView, anonymousClass1, mraidContainerView.a, mraidContainerView.c, this.c);
            } catch (java.lang.Throwable th) {
                com.anythink.basead.ui.MraidContainerView.a(com.anythink.basead.ui.MraidContainerView.this);
                java.lang.String unused = com.anythink.basead.ui.MraidContainerView.j;
                th.getMessage();
                com.anythink.basead.ui.MraidContainerView.this.g();
                com.anythink.basead.ui.MraidContainerView.a aVar = com.anythink.basead.ui.MraidContainerView.this.g;
                if (aVar != null) {
                    th.getMessage();
                    aVar.c();
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.MraidContainerView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.basead.ui.ClickToReLoadView.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.ClickToReLoadView.a
        public final void a() {
            com.anythink.basead.ui.MraidContainerView.this.loadMraidWebView(3);
        }
    }

    public interface a {
        void a();

        void a(java.lang.String str);

        void b();

        void c();
    }

    public MraidContainerView(@androidx.annotation.NonNull android.content.Context context) {
        super(context);
    }

    public MraidContainerView(@androidx.annotation.NonNull android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.basead.ui.MraidContainerView.a aVar) {
        super(context);
        this.a = lVar;
        this.b = mVar.n;
        this.c = mVar;
        this.g = aVar;
        setBackgroundColor(getResources().getColor(com.anythink.core.common.o.i.a(context, "color_99000000", "color")));
    }

    private void a(int i) {
        if (com.anythink.basead.a.b.c.a(this.c, this.a)) {
            return;
        }
        loadMraidWebView(i);
    }

    public static /* synthetic */ boolean a(com.anythink.basead.ui.MraidContainerView mraidContainerView) {
        mraidContainerView.m = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(java.lang.String str) {
        if (this.h) {
            return false;
        }
        com.anythink.core.basead.b.c cVar = new com.anythink.core.basead.b.c();
        cVar.c = this.a;
        cVar.h = this.c;
        cVar.f = str;
        cVar.i = 2;
        com.anythink.core.basead.ui.web.WebLandPageActivity.a(com.anythink.core.common.b.o.a().f(), cVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.anythink.basead.mraid.MraidWebView b = com.anythink.basead.a.b.c.b(com.anythink.basead.a.b.c.b(this.c, this.a));
        this.f = b;
        if (b != null) {
            this.n = true;
            if (this.l) {
                b.setNeedRegisterVolumeChangeReceiver(true);
            }
            this.f.prepare(getContext(), new com.anythink.basead.ui.MraidContainerView.AnonymousClass1());
            this.f.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            addView(this.f);
            c();
            com.anythink.basead.ui.MraidContainerView.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    private void c() {
        if (this.a.f() <= 0 || this.a.g() <= 0) {
            return;
        }
        android.view.ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(new com.anythink.basead.ui.MraidContainerView.AnonymousClass2(viewTreeObserver));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.e == null) {
            com.anythink.basead.ui.ClickToReLoadView clickToReLoadView = new com.anythink.basead.ui.ClickToReLoadView(getContext());
            this.e = clickToReLoadView;
            clickToReLoadView.setListener(new com.anythink.basead.ui.MraidContainerView.AnonymousClass4());
        }
        addView(this.e, new android.widget.FrameLayout.LayoutParams(-1, -1));
    }

    private void e() {
        com.anythink.basead.ui.ClickToReLoadView clickToReLoadView = this.e;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
    }

    private void f() {
        com.anythink.basead.ui.b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.anythink.basead.ui.b bVar = this.d;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.h = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void fireAudioVolumeChange(boolean z) {
        try {
            if (!this.n || this.f == null) {
                return;
            }
            if (z) {
                com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireAudioVolumeChange(this.f, 0.0d);
            } else {
                com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireAudioVolumeChange(this.f, 1.0d);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void fireMraidIsViewable(boolean z) {
        com.anythink.basead.mraid.MraidWebView mraidWebView;
        try {
            if (!this.n || (mraidWebView = this.f) == null) {
                return;
            }
            if (z) {
                com.anythink.expressad.mbbanner.a.a.a.a(mraidWebView, true);
            } else {
                com.anythink.expressad.mbbanner.a.a.a.a(mraidWebView, false);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void init() {
        if (com.anythink.basead.a.b.c.a(this.c, this.a)) {
            b();
            return;
        }
        com.anythink.basead.ui.b bVar = new com.anythink.basead.ui.b(this);
        this.d = bVar;
        bVar.a();
    }

    public void loadMraidWebView(int i) {
        if (this.m || this.n) {
            return;
        }
        this.m = true;
        com.anythink.basead.ui.ClickToReLoadView clickToReLoadView = this.e;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
        com.anythink.basead.ui.b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
        java.lang.String a2 = com.anythink.basead.mraid.d.a(this.c, this.a);
        if (!android.text.TextUtils.isEmpty(a2)) {
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.MraidContainerView.AnonymousClass3(com.anythink.basead.a.b.c.b(this.c, this.a), a2, i));
        } else {
            this.m = false;
            d();
            g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k = true;
        a(2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k = false;
    }

    public void release() {
        com.anythink.basead.mraid.MraidWebView mraidWebView;
        try {
            if (this.n && (mraidWebView = this.f) != null) {
                com.anythink.core.common.o.w.a(mraidWebView);
                this.f.release();
                com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.a().f()).a(this.c, this.a);
            }
            com.anythink.core.common.o.w.a(this);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z) {
        this.l = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.k) {
            a(4);
        }
    }
}
