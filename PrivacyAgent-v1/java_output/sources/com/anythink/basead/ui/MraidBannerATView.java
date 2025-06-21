package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MraidBannerATView extends com.anythink.basead.ui.BaseBannerATView {
    boolean A;
    boolean B;
    com.anythink.basead.ui.MraidContainerView y;
    boolean z;

    /* renamed from: com.anythink.basead.ui.MraidBannerATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.MraidContainerView.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            com.anythink.basead.ui.MraidBannerATView mraidBannerATView = com.anythink.basead.ui.MraidBannerATView.this;
            mraidBannerATView.z = true;
            mraidBannerATView.o();
            try {
                com.anythink.basead.ui.MraidBannerATView.this.b();
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(java.lang.String str) {
            com.anythink.basead.ui.MraidBannerATView.this.c.w(str);
            com.anythink.basead.ui.MraidBannerATView.this.a(1, 13);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
        }
    }

    public MraidBannerATView(android.content.Context context) {
        super(context);
    }

    public MraidBannerATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
        c();
    }

    private void p() {
        int a;
        int a2;
        java.lang.String x = this.b.n.x();
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_web_banner_ad_layout", "layout"), this);
        a = com.anythink.core.common.o.i.a(getContext(), 50.0f);
        a2 = com.anythink.core.common.o.i.a(getContext(), 320.0f);
        x.hashCode();
        switch (x) {
            case "300x250":
                a2 = com.anythink.core.common.o.i.a(getContext(), 300.0f);
                a = com.anythink.core.common.o.i.a(getContext(), 250.0f);
                break;
            case "320x90":
                a2 = com.anythink.core.common.o.i.a(getContext(), 320.0f);
                a = com.anythink.core.common.o.i.a(getContext(), 90.0f);
                break;
            case "728x90":
                a2 = com.anythink.core.common.o.i.a(getContext(), 720.0f);
                a = com.anythink.core.common.o.i.a(getContext(), 90.0f);
                break;
        }
        int min = java.lang.Math.min(a2, getResources().getDisplayMetrics().widthPixels);
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.c, this.b, new com.anythink.basead.ui.MraidBannerATView.AnonymousClass1());
        this.y = mraidContainerView;
        mraidContainerView.init();
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_web", "id"));
        this.y.setMinimumHeight(com.anythink.core.common.o.i.a(getContext(), 50.0f));
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(min, a);
        layoutParams.gravity = 17;
        frameLayout.addView(this.y, 0, layoutParams);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(min, a));
        this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        if (this.b.n.y() != 0) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            a(this.w, this.b.n.n());
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a() {
        int a;
        int a2;
        java.lang.String x = this.b.n.x();
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_web_banner_ad_layout", "layout"), this);
        a = com.anythink.core.common.o.i.a(getContext(), 50.0f);
        a2 = com.anythink.core.common.o.i.a(getContext(), 320.0f);
        x.hashCode();
        switch (x) {
            case "300x250":
                a2 = com.anythink.core.common.o.i.a(getContext(), 300.0f);
                a = com.anythink.core.common.o.i.a(getContext(), 250.0f);
                break;
            case "320x90":
                a2 = com.anythink.core.common.o.i.a(getContext(), 320.0f);
                a = com.anythink.core.common.o.i.a(getContext(), 90.0f);
                break;
            case "728x90":
                a2 = com.anythink.core.common.o.i.a(getContext(), 720.0f);
                a = com.anythink.core.common.o.i.a(getContext(), 90.0f);
                break;
        }
        int min = java.lang.Math.min(a2, getResources().getDisplayMetrics().widthPixels);
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.c, this.b, new com.anythink.basead.ui.MraidBannerATView.AnonymousClass1());
        this.y = mraidContainerView;
        mraidContainerView.init();
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_web", "id"));
        this.y.setMinimumHeight(com.anythink.core.common.o.i.a(getContext(), 50.0f));
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(min, a);
        layoutParams.gravity = 17;
        frameLayout.addView(this.y, 0, layoutParams);
        setLayoutParams(new android.view.ViewGroup.LayoutParams(min, a));
        this.w = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        if (this.b.n.y() != 0) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            a(this.w, this.b.n.n());
        }
    }

    @Override // com.anythink.basead.ui.BaseBannerATView
    public final void b() {
        if (this.y == null) {
            return;
        }
        super.b();
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.y;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    public final synchronized void o() {
        if (this.z && this.A && !this.B) {
            this.B = true;
            com.anythink.core.common.n.c.a(this.b, this.c);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A = true;
        o();
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A = false;
    }
}
