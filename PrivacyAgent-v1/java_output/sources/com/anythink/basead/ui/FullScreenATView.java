package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class FullScreenATView extends com.anythink.basead.ui.BaseScreenATView {
    public static final java.lang.String TAG = "FullScreenATView";
    private com.anythink.basead.ui.CountDownCloseView ad;
    private com.anythink.basead.ui.CloseHeaderView ae;
    private com.anythink.basead.ui.PanelView af;
    private com.anythink.basead.ui.d.a ag;

    /* renamed from: com.anythink.basead.ui.FullScreenATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.FullScreenATView.this.a(i, i2);
        }
    }

    /* renamed from: com.anythink.basead.ui.FullScreenATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.ui.PanelView.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.PanelView.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.FullScreenATView.this.a(i, i2);
        }

        @Override // com.anythink.basead.ui.PanelView.a
        public final boolean a() {
            if (!com.anythink.basead.ui.FullScreenATView.this.y()) {
                return false;
            }
            com.anythink.basead.ui.FullScreenATView.this.a(4, 5);
            return true;
        }
    }

    /* renamed from: com.anythink.basead.ui.FullScreenATView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.FullScreenATView.this.C();
            com.anythink.basead.ui.FullScreenATView.this.D();
        }
    }

    /* renamed from: com.anythink.basead.ui.FullScreenATView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.animation.Animation.AnimationListener {

        /* renamed from: com.anythink.basead.ui.FullScreenATView$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.FullScreenATView.super.Q();
                if (com.anythink.basead.ui.FullScreenATView.this.af != null) {
                    com.anythink.basead.ui.FullScreenATView.this.af.setVisibility(8);
                }
            }
        }

        public AnonymousClass4() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(android.view.animation.Animation animation) {
            com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = com.anythink.basead.ui.FullScreenATView.this.L;
            if (basePlayerView != null) {
                basePlayerView.post(new com.anythink.basead.ui.FullScreenATView.AnonymousClass4.AnonymousClass1());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(android.view.animation.Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(android.view.animation.Animation animation) {
        }
    }

    public FullScreenATView(android.content.Context context) {
        super(context);
    }

    public FullScreenATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, int i, int i2) {
        super(context, mVar, lVar, str, i, i2);
        setId(com.anythink.core.common.o.i.a(getContext(), "myoffer_full_screen_view_id", "id"));
        if (mVar != null) {
            this.ag = new com.anythink.basead.ui.d.a(lVar, mVar.n);
        }
    }

    private void S() {
        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (com.anythink.basead.a.d.b(this.c)) {
            this.K.addView(this.N, 0);
            return;
        }
        if (b(this.E)) {
            com.anythink.basead.ui.PanelView P = P();
            int i = this.E;
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        int i2 = this.y;
                        int i3 = (int) (i2 * 0.5f);
                        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i2 - i3));
                        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = this.x;
                            layoutParams.height = i3;
                            P.setLayoutParams(layoutParams);
                            P.removeAllViews();
                            P.setLayoutType(this.E);
                        }
                    } else if (i != 6) {
                        if (this.b.n.D() != 0) {
                            android.view.View shakeView = P.getShakeView();
                            if (k()) {
                                if (shakeView != null) {
                                    shakeView.setVisibility(0);
                                }
                            } else if (shakeView != null) {
                                shakeView.setVisibility(8);
                            }
                        }
                    }
                }
                int a = com.anythink.core.common.o.i.a(getContext(), 300.0f);
                this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.x - a, -1));
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a;
                    layoutParams2.height = -1;
                    P.setLayoutParams(layoutParams2);
                    P.removeAllViews();
                    P.setLayoutType(this.E);
                }
            } else {
                this.K.setBackgroundColor(-1);
                int i4 = (int) (this.y * 0.5f);
                int a2 = android.text.TextUtils.isEmpty(this.c.w()) ? this.y - i4 : (this.y - i4) + com.anythink.core.common.o.i.a(getContext(), 50.0f);
                this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i4));
                this.N.setNeedArc(true);
                android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.x;
                    layoutParams3.height = a2;
                    P.setLayoutParams(layoutParams3);
                    P.removeAllViews();
                    P.setLayoutType(this.E);
                }
            }
        }
        this.K.addView(this.N, 0);
    }

    private void T() {
        if (((com.anythink.basead.ui.BaseScreenATView) this).v == 1 && this.H) {
            com.anythink.core.common.ui.component.RoundImageView roundImageView = new com.anythink.core.common.ui.component.RoundImageView(getContext().getApplicationContext());
            roundImageView.setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_reward_icon", com.anythink.expressad.foundation.h.i.c));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 60.0f), com.anythink.core.common.o.i.a(getContext(), 60.0f));
            int i = 2;
            if (b(this.E)) {
                int i2 = this.E;
                if (i2 == 2 || i2 == 6) {
                    layoutParams.leftMargin = this.x - com.anythink.core.common.o.i.a(getContext(), 330.0f);
                    layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 22.0f);
                } else {
                    layoutParams.leftMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                    layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                }
            } else {
                layoutParams.leftMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
            }
            roundImageView.setLayoutParams(layoutParams);
            try {
                i = this.K.indexOfChild(this.M) + 1;
            } catch (java.lang.Throwable unused) {
            }
            this.K.addView(roundImageView, i);
        }
    }

    private boolean U() {
        return ((com.anythink.basead.ui.BaseScreenATView) this).v == 1 && this.F != 100;
    }

    private boolean V() {
        if (((com.anythink.basead.ui.BaseScreenATView) this).v != 1) {
            return false;
        }
        int i = this.F;
        return i == 1 || i == 101;
    }

    private boolean W() {
        return N();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void A() {
        super.A();
        if (U()) {
            if (this.F != 101) {
                com.anythink.basead.ui.CountDownCloseView countDownCloseView = this.ad;
                if (countDownCloseView != null) {
                    countDownCloseView.setVisibility(0);
                    return;
                }
                return;
            }
            com.anythink.basead.ui.CloseHeaderView closeHeaderView = this.ae;
            if (closeHeaderView != null) {
                closeHeaderView.setVisibility(0);
                if (this.ae.getCloseImageView() != null) {
                    this.ae.getCloseImageView().setVisibility(0);
                }
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void B() {
        int i = ((com.anythink.basead.ui.BaseScreenATView) this).v;
        if (i == 1) {
            if (this.r) {
                D();
                return;
            }
        } else if (this.G) {
            D();
            return;
        }
        if (1 != i || this.H) {
            C();
            if (l()) {
                this.r = true;
            }
            q();
            return;
        }
        double ceil = java.lang.Math.ceil(this.b.n.k() / 1000.0d);
        if (this.L != null) {
            double ceil2 = java.lang.Math.ceil(r0.getVideoLength() / 1000.0d);
            if (ceil > ceil2) {
                ceil = ceil2;
            }
        }
        com.anythink.basead.ui.RewardExitConfirmDialogActivity.a(getContext(), java.lang.String.valueOf((int) ceil), new com.anythink.basead.ui.FullScreenATView.AnonymousClass3(), U() ? 2 : 1);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void E() {
        super.E();
        if (U()) {
            I();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void F() {
        super.F();
        if (this.F != 100) {
            this.S.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void G() {
        super.G();
        com.anythink.basead.ui.d.a aVar = this.ag;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void H() {
        super.H();
        com.anythink.basead.ui.d.a aVar = this.ag;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void K() {
        com.anythink.basead.ui.BaseEndCardView baseEndCardView;
        if (this.K == null || (baseEndCardView = this.N) == null || baseEndCardView.getParent() != null) {
            return;
        }
        if (!com.anythink.basead.a.d.a(this.c, this.b)) {
            R();
            return;
        }
        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (!com.anythink.basead.a.d.b(this.c) && b(this.E)) {
            com.anythink.basead.ui.PanelView P = P();
            int i = this.E;
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        int i2 = this.y;
                        int i3 = (int) (i2 * 0.5f);
                        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i2 - i3));
                        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = this.x;
                            layoutParams.height = i3;
                            P.setLayoutParams(layoutParams);
                            P.removeAllViews();
                            P.setLayoutType(this.E);
                        }
                    } else if (i != 6) {
                        if (this.b.n.D() != 0) {
                            android.view.View shakeView = P.getShakeView();
                            if (k()) {
                                if (shakeView != null) {
                                    shakeView.setVisibility(0);
                                }
                            } else if (shakeView != null) {
                                shakeView.setVisibility(8);
                            }
                        }
                    }
                }
                int a = com.anythink.core.common.o.i.a(getContext(), 300.0f);
                this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.x - a, -1));
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a;
                    layoutParams2.height = -1;
                    P.setLayoutParams(layoutParams2);
                    P.removeAllViews();
                    P.setLayoutType(this.E);
                }
            } else {
                this.K.setBackgroundColor(-1);
                int i4 = (int) (this.y * 0.5f);
                int a2 = android.text.TextUtils.isEmpty(this.c.w()) ? this.y - i4 : (this.y - i4) + com.anythink.core.common.o.i.a(getContext(), 50.0f);
                this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i4));
                this.N.setNeedArc(true);
                android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.x;
                    layoutParams3.height = a2;
                    P.setLayoutParams(layoutParams3);
                    P.removeAllViews();
                    P.setLayoutType(this.E);
                }
            }
        }
        this.K.addView(this.N, 0);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void L() {
        super.L();
        if (((com.anythink.basead.ui.BaseScreenATView) this).v == 1 && this.H) {
            com.anythink.core.common.ui.component.RoundImageView roundImageView = new com.anythink.core.common.ui.component.RoundImageView(getContext().getApplicationContext());
            roundImageView.setImageResource(com.anythink.core.common.o.i.a(getContext(), "myoffer_reward_icon", com.anythink.expressad.foundation.h.i.c));
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 60.0f), com.anythink.core.common.o.i.a(getContext(), 60.0f));
            int i = 2;
            if (b(this.E)) {
                int i2 = this.E;
                if (i2 == 2 || i2 == 6) {
                    layoutParams.leftMargin = this.x - com.anythink.core.common.o.i.a(getContext(), 330.0f);
                    layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 22.0f);
                } else {
                    layoutParams.leftMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                    layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                }
            } else {
                layoutParams.leftMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
                layoutParams.topMargin = com.anythink.core.common.o.i.a(getContext(), 12.0f);
            }
            roundImageView.setLayoutParams(layoutParams);
            try {
                i = this.K.indexOfChild(this.M) + 1;
            } catch (java.lang.Throwable unused) {
            }
            this.K.addView(roundImageView, i);
        }
        if (com.anythink.basead.a.d.b(this.c)) {
            com.anythink.basead.ui.PanelView panelView = this.M;
            if (panelView != null) {
                panelView.setVisibility(8);
            }
            com.anythink.basead.ui.PanelView panelView2 = this.af;
            if (panelView2 != null) {
                panelView2.setVisibility(8);
            }
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final com.anythink.basead.ui.CloseImageView M() {
        if (U()) {
            if (this.F == 101) {
                com.anythink.basead.ui.CloseHeaderView closeHeaderView = this.ae;
                if (closeHeaderView != null && closeHeaderView.getCloseImageView() != null) {
                    return this.ae.getCloseImageView();
                }
            } else {
                com.anythink.basead.ui.CountDownCloseView countDownCloseView = this.ad;
                if (countDownCloseView != null) {
                    return countDownCloseView;
                }
            }
        }
        return super.M();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final android.view.ViewGroup O() {
        com.anythink.basead.ui.CloseHeaderView closeHeaderView = this.ae;
        return (closeHeaderView == null || closeHeaderView.getVisibility() != 0 || this.ae.getFeedbackButton() == null) ? super.O() : this.ae.getFeedbackButton();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final com.anythink.basead.ui.PanelView P() {
        com.anythink.basead.ui.PanelView panelView;
        com.anythink.basead.ui.PanelView panelView2;
        return (com.anythink.basead.a.d.a(this.c, this.b) || (panelView2 = this.af) == null) ? (this.G || this.F == 1 || (panelView = this.af) == null) ? super.P() : panelView : panelView2;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void Q() {
        com.anythink.basead.ui.PanelView panelView;
        if (N()) {
            return;
        }
        if (((com.anythink.basead.ui.BaseScreenATView) this).v != 1 || this.F == 100) {
            super.Q();
            if (!l() || (panelView = this.af) == null) {
                return;
            }
            panelView.setVisibility(8);
            return;
        }
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView == null || basePlayerView.getParent() == null) {
            return;
        }
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(0.0f, -getMeasuredWidth(), 0.0f, 0.0f);
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(1.0f, 0.4f);
        android.view.animation.AnimationSet animationSet = new android.view.animation.AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(300L);
        animationSet.setAnimationListener(new com.anythink.basead.ui.FullScreenATView.AnonymousClass4());
        this.L.startAnimation(animationSet);
        com.anythink.basead.ui.PanelView panelView2 = this.af;
        if (panelView2 == null || panelView2.getVisibility() != 0) {
            return;
        }
        this.af.startAnimation(animationSet);
    }

    public final void R() {
        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (com.anythink.basead.a.d.b(this.c)) {
            this.K.addView(this.N, 0);
        } else {
            P().setVisibility(0);
            this.K.addView(this.N, 0);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void a() {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_full_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void a(long j) {
        int i;
        boolean z = true;
        if (((com.anythink.basead.ui.BaseScreenATView) this).v != 1 || ((i = this.F) != 1 && i != 101)) {
            z = false;
        }
        if (z) {
            return;
        }
        super.a(j);
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
        if (!N()) {
            return super.a(str, iOfferClickHandler);
        }
        this.G = true;
        boolean openInternalWebView = ((com.anythink.basead.ui.animplayerview.WebLandpagePlayerView) this.L).openInternalWebView(str, iOfferClickHandler);
        if (openInternalWebView) {
            a(105);
            com.anythink.basead.ui.d.a aVar = this.ag;
            if (aVar != null) {
                aVar.a();
            }
        }
        return openInternalWebView;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void b() {
        super.b();
        com.anythink.basead.ui.d.a aVar = this.ag;
        if (aVar != null) {
            aVar.a(this.E == 8 ? com.anythink.basead.ui.d.a.b : -100).a(new com.anythink.basead.ui.FullScreenATView.AnonymousClass1()).a(getContext(), this);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void b(long j) {
        if (!U()) {
            super.b(j);
            return;
        }
        com.anythink.basead.ui.CloseHeaderView closeHeaderView = this.ae;
        if (closeHeaderView != null && closeHeaderView.getVisibility() == 0) {
            this.ae.refresh(j);
        }
        com.anythink.basead.ui.CountDownCloseView countDownCloseView = this.ad;
        if (countDownCloseView == null || countDownCloseView.getVisibility() != 0) {
            return;
        }
        this.ad.refresh(j);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public boolean b(int i) {
        return (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) ? com.anythink.basead.a.d.a(this.c) : i == 8;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void c() {
        super.c();
        this.ad = (com.anythink.basead.ui.CountDownCloseView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_btn_countdown_close_id", "id"));
        this.ae = (com.anythink.basead.ui.CloseHeaderView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_btn_close_header_view_id", "id"));
        this.af = (com.anythink.basead.ui.PanelView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_view_for_anim_player_id", "id"));
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void c(int i) {
        if (!U()) {
            super.c(i);
        } else {
            this.Q.setVisibility(8);
            this.P.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void c(long j) {
        if (!U()) {
            super.c(j);
            return;
        }
        com.anythink.basead.ui.CloseHeaderView closeHeaderView = this.ae;
        if (closeHeaderView != null && closeHeaderView.getVisibility() == 0) {
            this.ae.setDuration(j);
        }
        com.anythink.basead.ui.CountDownCloseView countDownCloseView = this.ad;
        if (countDownCloseView == null || countDownCloseView.getVisibility() != 0) {
            return;
        }
        this.ad.setDuration(j);
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final int n() {
        return 1;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void o() {
        super.o();
        if (this.L == null || !U()) {
            return;
        }
        android.content.Context context = getContext();
        int i = this.F;
        com.anythink.basead.ui.animplayerview.BasePlayerView emptyAnimPlayer = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 101 ? new com.anythink.basead.ui.animplayerview.EmptyAnimPlayer(context) : new com.anythink.basead.ui.animplayerview.WebLandpagePlayerView(context) : new com.anythink.basead.ui.animplayerview.AlbumScaleAnimPlayerView(context) : new com.anythink.basead.ui.animplayerview.ViewPagerAnimPlayerView(context) : new com.anythink.basead.ui.animplayerview.RedPacketAnimPlayerView(context) : new com.anythink.basead.ui.animplayerview.GuideToClickAnimPlayerView(context) : new com.anythink.basead.ui.animplayerview.EmptyAnimPlayer(context);
        emptyAnimPlayer.setVisibility(8);
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.L.getParent();
        viewGroup.addView(emptyAnimPlayer, viewGroup.indexOfChild(this.L), this.L.getLayoutParams());
        viewGroup.removeView(this.L);
        this.L = emptyAnimPlayer;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void q() {
        if (N()) {
            return;
        }
        super.q();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public int r() {
        int i = this.E;
        return i == 8 ? i : this.x < this.y ? this.ab >= this.ac ? 1 : 5 : this.ab < this.ac ? 2 : 6;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void w() {
        com.anythink.basead.ui.PanelView panelView = this.af;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.af.init(this.c, this.b, this.w, k(), new com.anythink.basead.ui.FullScreenATView.AnonymousClass2());
        }
        super.w();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void x() {
        super.x();
        if (com.anythink.basead.a.d.a(this.c)) {
            this.E = 0;
        } else {
            this.E = 8;
        }
        com.anythink.basead.ui.PanelView panelView = this.M;
        if (panelView != null) {
            panelView.setLayoutType(this.E);
            if (this.E == 8 && this.b.n.D() == 0) {
                this.M.getCTAButton().setVisibility(8);
            }
        }
        com.anythink.basead.ui.PanelView panelView2 = this.af;
        if (panelView2 != null) {
            panelView2.setLayoutType(this.E);
            if (this.E == 8 && this.b.n.D() == 0) {
                this.af.getCTAButton().setVisibility(8);
            }
        }
    }
}
