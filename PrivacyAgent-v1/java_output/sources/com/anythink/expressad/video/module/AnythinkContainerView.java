package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkContainerView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private java.lang.String P;
    private com.anythink.expressad.video.signal.factory.b Q;
    private com.anythink.expressad.video.dynview.widget.ATOrderCampView R;
    private boolean S;
    private boolean T;
    private java.util.List<com.anythink.expressad.foundation.d.c> U;
    private com.anythink.expressad.video.module.AnythinkPlayableView n;
    private com.anythink.expressad.video.module.AnythinkClickCTAView o;
    private com.anythink.expressad.video.module.AnythinkClickMiniCardView p;
    private com.anythink.expressad.video.module.AnythinkNativeEndCardView q;
    private com.anythink.expressad.video.module.AnythinkH5EndCardView r;

    /* renamed from: s, reason: collision with root package name */
    private com.anythink.expressad.video.module.AnythinkVideoEndCoverView f273s;
    private com.anythink.expressad.video.module.AnythinkVastEndCardView t;
    private com.anythink.expressad.video.module.AnythinkLandingPageView u;
    private com.anythink.expressad.video.module.AnythinkAlertWebview v;
    private java.lang.String w;
    private int x;
    private int y;
    private int z;

    /* renamed from: com.anythink.expressad.video.module.AnythinkContainerView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.video.signal.factory.b a;

        public AnonymousClass1(com.anythink.expressad.video.signal.factory.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = com.anythink.expressad.video.module.AnythinkContainerView.this;
            anythinkContainerView.a(this.a, java.lang.Integer.valueOf(anythinkContainerView.b.F()));
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkContainerView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.video.signal.factory.b a;

        public AnonymousClass2(com.anythink.expressad.video.signal.factory.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = com.anythink.expressad.video.module.AnythinkContainerView.this;
            anythinkContainerView.a(this.a, java.lang.Integer.valueOf(anythinkContainerView.b.F()));
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkContainerView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.video.dynview.f.b {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.video.dynview.f.b
        public final void a() {
            com.anythink.expressad.video.module.a.a aVar = com.anythink.expressad.video.module.AnythinkContainerView.this.e;
            if (aVar != null) {
                aVar.a(117, "");
            }
        }

        @Override // com.anythink.expressad.video.dynview.f.b
        public final void b() {
            if (com.anythink.expressad.video.module.AnythinkContainerView.this.b.f() == 2) {
                com.anythink.expressad.video.module.AnythinkContainerView.this.showVideoEndCover();
            } else {
                com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = com.anythink.expressad.video.module.AnythinkContainerView.this;
                anythinkContainerView.showEndcard(anythinkContainerView.b.F());
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkContainerView$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.expressad.video.module.a.a.i {
        public AnonymousClass4(com.anythink.expressad.video.module.a.a aVar) {
            super(aVar);
        }

        @Override // com.anythink.expressad.video.module.a.a.i, com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i, java.lang.Object obj) {
            super.a(i, obj);
            if (i == 100) {
                com.anythink.expressad.video.module.AnythinkContainerView.this.webviewshow();
                com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = com.anythink.expressad.video.module.AnythinkContainerView.this;
                anythinkContainerView.onConfigurationChanged(anythinkContainerView.getResources().getConfiguration());
            }
        }
    }

    public AnythinkContainerView(android.content.Context context) {
        super(context);
        this.y = 1;
        this.z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.I = false;
        this.J = false;
        this.S = false;
        this.T = false;
        this.U = new java.util.ArrayList();
    }

    public AnythinkContainerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = false;
        this.I = false;
        this.J = false;
        this.S = false;
        this.T = false;
        this.U = new java.util.ArrayList();
    }

    private void a(android.content.res.Configuration configuration, com.anythink.expressad.video.module.AnythinkBaseView... anythinkBaseViewArr) {
        for (int i = 0; i < 8; i++) {
            com.anythink.expressad.video.module.AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i];
            if (anythinkBaseView != null && (anythinkBaseView instanceof com.anythink.expressad.video.module.AnythinkClickMiniCardView)) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            } else if (anythinkBaseView != null && anythinkBaseView.getVisibility() == 0 && anythinkBaseView.getParent() != null && !isLast()) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    private static void a(android.view.View view) {
        if (view != null) {
            try {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    private void a(com.anythink.expressad.video.module.a.a aVar, com.anythink.expressad.video.module.AnythinkBaseView... anythinkBaseViewArr) {
        for (int i = 0; i < 8; i++) {
            com.anythink.expressad.video.module.AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i];
            if (anythinkBaseView != null) {
                if (anythinkBaseView instanceof com.anythink.expressad.video.module.AnythinkClickMiniCardView) {
                    anythinkBaseView.setNotifyListener(new com.anythink.expressad.video.module.a.a.g(this.p, aVar));
                } else {
                    anythinkBaseView.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
                }
            }
        }
    }

    private void a(com.anythink.expressad.video.signal.factory.b bVar) {
        if (this.n == null) {
            this.n = new com.anythink.expressad.video.module.AnythinkPlayableView(this.a);
        }
        this.n.setCloseDelayShowTime(this.z);
        this.n.setPlayCloseBtnTm(this.A);
        this.n.setCampaign(this.b);
        this.n.setNotifyListener(new com.anythink.expressad.video.module.AnythinkContainerView.AnonymousClass4(this.e));
        this.n.preLoadData(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.video.signal.factory.b bVar, java.lang.Integer num) {
        com.anythink.expressad.video.module.a.a aVar;
        this.Q = bVar;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            if (num == null) {
                num = java.lang.Integer.valueOf(cVar.F());
            }
            if (!isLast()) {
                p();
            }
            int intValue = num.intValue();
            if (intValue != 1) {
                if (intValue == 3) {
                    if (this.t == null) {
                        this.t = new com.anythink.expressad.video.module.AnythinkVastEndCardView(this.a);
                    }
                    this.t.setCampaign(this.b);
                    this.t.setNotifyListener(new com.anythink.expressad.video.module.a.a.l(this.e));
                    this.t.preLoadData(bVar);
                    return;
                }
                if (intValue == 4) {
                    if (this.u == null) {
                        this.u = new com.anythink.expressad.video.module.AnythinkLandingPageView(this.a);
                    }
                    this.u.setCampaign(this.b);
                    this.u.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
                    return;
                }
                if (intValue != 5) {
                    if (this.y != 2) {
                        com.anythink.expressad.foundation.d.c cVar2 = this.b;
                        int c = (cVar2 == null || cVar2.M() == null) ? 0 : this.b.M().c();
                        com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
                        if (anythinkNativeEndCardView == null && anythinkNativeEndCardView == null) {
                            if (this.b.j()) {
                                q();
                            } else {
                                com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView2 = new com.anythink.expressad.video.module.AnythinkNativeEndCardView(this.a, null, false, -1, this.b.f() == 2, c, this.b.as());
                                this.q = anythinkNativeEndCardView2;
                                anythinkNativeEndCardView2.setCampaign(this.b);
                            }
                        }
                        this.q.setLayout();
                        this.q.setCampaign(this.b);
                        this.q.setUnitId(this.w);
                        this.q.setCloseBtnDelay(this.z);
                        this.q.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
                        this.q.preLoadData(bVar);
                        this.q.setNotchPadding(this.K, this.L, this.M, this.N);
                        return;
                    }
                    boolean j = this.b.j();
                    boolean f = com.anythink.expressad.foundation.h.t.f(this.b.I());
                    com.anythink.expressad.foundation.d.c cVar3 = this.b;
                    if ((cVar3 == null || !j || f) && cVar3.f() != 2) {
                        if (this.r == null) {
                            this.r = new com.anythink.expressad.video.module.AnythinkH5EndCardView(this.a);
                        }
                        if (this.b.k() == 5 && (aVar = this.e) != null && (aVar instanceof com.anythink.expressad.video.module.a.a.k)) {
                            ((com.anythink.expressad.video.module.a.a.k) aVar).a(this.b);
                        }
                        this.r.setCampaign(this.b);
                        this.r.setCloseDelayShowTime(this.z);
                        this.r.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
                        this.r.setUnitId(this.w);
                        this.r.setNotchValue(this.P, this.K, this.L, this.M, this.N);
                        this.r.preLoadData(bVar);
                        if (this.D) {
                            return;
                        }
                        addView(this.r);
                    }
                }
            }
        }
    }

    private void a(com.anythink.expressad.video.module.AnythinkH5EndCardView... anythinkH5EndCardViewArr) {
        for (int i = 0; i < 4; i++) {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0 && anythinkH5EndCardView.getParent() != null && !isLast()) {
                anythinkH5EndCardView.webviewshow();
            }
        }
    }

    private boolean a() {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        return viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1;
    }

    private void b() {
        setWrapContent();
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            ((android.widget.RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    private void b(int i) {
        if (i != -3) {
            if (i != -2) {
                if (this.o == null) {
                    this.o = new com.anythink.expressad.video.module.AnythinkClickCTAView(this.a);
                }
                this.o.setCampaign(this.b);
                this.o.setUnitId(this.w);
                this.o.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
                this.o.preLoadData(this.Q);
                return;
            }
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar == null || cVar.F() != 2) {
                return;
            }
            if (this.p == null) {
                this.p = new com.anythink.expressad.video.module.AnythinkClickMiniCardView(this.a);
            }
            this.p.setCampaign(this.b);
            com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
            anythinkClickMiniCardView.setNotifyListener(new com.anythink.expressad.video.module.a.a.g(anythinkClickMiniCardView, this.e));
            this.p.preLoadData(this.Q);
            setMatchParent();
            m();
            p();
        }
    }

    private void b(com.anythink.expressad.video.signal.factory.b bVar) {
        this.Q = bVar;
        if (this.f273s == null) {
            com.anythink.expressad.video.module.AnythinkVideoEndCoverView anythinkVideoEndCoverView = new com.anythink.expressad.video.module.AnythinkVideoEndCoverView(this.a);
            this.f273s = anythinkVideoEndCoverView;
            anythinkVideoEndCoverView.setCampaign(this.b);
            this.f273s.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
            this.f273s.preLoadData(bVar);
        }
    }

    private void b(com.anythink.expressad.video.module.AnythinkH5EndCardView... anythinkH5EndCardViewArr) {
        for (int i = 0; i < 4; i++) {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0) {
                anythinkH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    private void e() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            boolean j = cVar.j();
            boolean f = com.anythink.expressad.foundation.h.t.f(this.b.I());
            if (j && !f) {
                i();
                return;
            }
        }
        if (this.y != 2 || this.I) {
            i();
        } else {
            h();
        }
    }

    private void f() {
        if (this.t == null) {
            a(this.Q, (java.lang.Integer) 3);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        addView(this.t, layoutParams);
        this.t.notifyShowListener();
    }

    private void g() {
        if (this.u == null) {
            a(this.Q, (java.lang.Integer) 4);
        }
        this.u.setUnitId(this.w);
        this.u.preLoadData(this.Q);
        addView(this.u);
    }

    private void h() {
        if (this.r == null) {
            a(this.Q, (java.lang.Integer) 2);
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView == null || !anythinkH5EndCardView.isLoadSuccess()) {
            i();
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView2 = this.r;
            if (anythinkH5EndCardView2 != null) {
                anythinkH5EndCardView2.reportRenderResult("timeout", 3);
                this.r.setError(true);
            }
        } else {
            this.I = true;
            addView(this.r);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.r.excuteTask();
            this.r.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView3 = this.r;
        if (anythinkH5EndCardView3 != null) {
            anythinkH5EndCardView3.setUnitId(this.w);
        }
    }

    private void i() {
        this.y = 1;
        if (this.q == null) {
            a(this.Q, (java.lang.Integer) 2);
        }
        addView(this.q);
        onConfigurationChanged(getResources().getConfiguration());
        this.q.notifyShowListener();
        this.T = true;
        bringToFront();
    }

    private void j() {
        com.anythink.expressad.video.module.AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.f273s;
        if (anythinkVideoEndCoverView == null) {
            com.anythink.expressad.video.signal.factory.b bVar = this.Q;
            this.Q = bVar;
            if (anythinkVideoEndCoverView == null) {
                com.anythink.expressad.video.module.AnythinkVideoEndCoverView anythinkVideoEndCoverView2 = new com.anythink.expressad.video.module.AnythinkVideoEndCoverView(this.a);
                this.f273s = anythinkVideoEndCoverView2;
                anythinkVideoEndCoverView2.setCampaign(this.b);
                this.f273s.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
                this.f273s.preLoadData(bVar);
            }
        }
        addView(this.f273s);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    private void k() {
        if (this.n == null) {
            preLoadData(this.Q);
        }
        addView(this.n);
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.setUnitId(this.w);
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && cVar.H() && this.b.J() == 2) {
                this.n.setCloseVisible(0);
            }
            this.n.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
    }

    private void l() {
        if (this.o == null) {
            b(-1);
        }
        if (this.o != null) {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar == null || !cVar.j()) {
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12, -1);
                addView(this.o, 0, layoutParams);
            }
        }
    }

    private void m() {
        if (this.p == null) {
            b(-2);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.D && this.F) {
            this.F = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.p, layoutParams);
    }

    private void n() {
        if (this.v == null) {
            o();
        }
        com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = this.v;
        if (anythinkAlertWebview != null && anythinkAlertWebview.getParent() != null) {
            removeView(this.v);
        }
        addView(this.v);
    }

    private void o() {
        if (this.v == null) {
            com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = new com.anythink.expressad.video.module.AnythinkAlertWebview(this.a);
            this.v = anythinkAlertWebview;
            anythinkAlertWebview.setUnitId(this.w);
            this.v.setCampaign(this.b);
        }
        this.v.preLoadData(this.Q);
    }

    private void p() {
        this.C = false;
        this.T = false;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        if (viewGroup != null) {
            int i = 0;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                android.view.View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof com.anythink.expressad.video.module.AnythinkContainerView) {
                    i++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q() {
        int parseInt;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null) {
            return;
        }
        java.lang.String I = cVar.I();
        if (!android.text.TextUtils.isEmpty(I)) {
            try {
                parseInt = java.lang.Integer.parseInt(com.anythink.expressad.foundation.h.x.a(I, "ecid"));
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
            this.q = new com.anythink.expressad.video.module.AnythinkNativeEndCardView(this.a, null, true, parseInt, this.b.f() != 2, this.l, this.b.as());
            if (this.b.k() == 5) {
                this.q.setCampaign(this.b);
                return;
            }
            com.anythink.expressad.video.module.a.a aVar = this.e;
            if (aVar != null && (aVar instanceof com.anythink.expressad.video.module.a.a.k)) {
                ((com.anythink.expressad.video.module.a.a.k) aVar).a(this.b);
            }
            this.q.setCampaign(this.b);
            return;
        }
        parseInt = 404;
        this.q = new com.anythink.expressad.video.module.AnythinkNativeEndCardView(this.a, null, true, parseInt, this.b.f() != 2, this.l, this.b.as());
        if (this.b.k() == 5) {
        }
    }

    public void addOrderViewData(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null) {
            return;
        }
        this.U = list;
    }

    @Override // android.view.ViewGroup
    public void addView(android.view.View view) {
        if (view != null) {
            a(view);
            super.addView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
        }
    }

    public boolean canBackPress() {
        if (this.q != null) {
            return false;
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            return anythinkH5EndCardView.canBackPress();
        }
        com.anythink.expressad.video.module.AnythinkLandingPageView anythinkLandingPageView = this.u;
        if (anythinkLandingPageView != null) {
            return anythinkLandingPageView.canBackPress();
        }
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            return anythinkPlayableView.canBackPress();
        }
        return false;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void configurationChanged(int i, int i2, int i3) {
        com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView == null || anythinkClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.p.resizeMiniCard(i, i2);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean endCardShowing() {
        return this.B;
    }

    public boolean endcardIsPlayable() {
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        return anythinkH5EndCardView != null && anythinkH5EndCardView.isPlayable();
    }

    public com.anythink.expressad.video.module.AnythinkH5EndCardView getH5EndCardView() {
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        return anythinkH5EndCardView == null ? this.n : anythinkH5EndCardView;
    }

    public com.anythink.expressad.foundation.d.c getReSetCampaign() {
        if (!this.b.j() || !android.text.TextUtils.isEmpty(this.b.I())) {
            return null;
        }
        int size = this.U.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                if (this.U.get(i2) != null && this.U.get(i2).aZ() == this.b.aZ()) {
                    i = i2 - 1;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i < 0 || i >= size || this.U.get(i) == null) {
            return null;
        }
        return this.U.get(i);
    }

    public boolean getShowingTransparent() {
        return this.D;
    }

    public java.lang.String getUnitID() {
        return this.w;
    }

    public int getVideoInteractiveType() {
        return this.x;
    }

    public int getVideoSkipTime() {
        return this.H;
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void handlerPlayableException(java.lang.String str) {
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.handlerPlayableException(str);
            if (!this.I) {
                return;
            }
        }
        e();
    }

    @Override // com.anythink.expressad.video.signal.e
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.S && !this.T) {
            p();
            this.S = false;
        }
        com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = this.v;
        if (anythinkAlertWebview == null || anythinkAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.v);
        com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView = this.o;
        if (anythinkClickCTAView == null || anythinkClickCTAView.getParent() == null) {
            return;
        }
        setWrapContent();
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            ((android.widget.RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        setVisibility(0);
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
        this.e.a(105, cVar);
    }

    public boolean isLast() {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        return viewGroup != null && viewGroup.indexOfChild(this) == 0;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void ivRewardAdsWithoutVideo(java.lang.String str) {
        this.e.a(103, str);
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardLoaded() {
        com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        return anythinkClickMiniCardView != null && anythinkClickMiniCardView.isLoadSuccess();
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean miniCardShowing() {
        return this.C;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i) {
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.notifyCloseBtn(i);
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.notifyCloseBtn(i);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.anythink.expressad.video.module.AnythinkBaseView[] anythinkBaseViewArr = {this.n, this.o, this.p, this.q, this.r, this.t, this.u, this.f273s};
        for (int i = 0; i < 8; i++) {
            com.anythink.expressad.video.module.AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i];
            if (anythinkBaseView != null && (anythinkBaseView instanceof com.anythink.expressad.video.module.AnythinkClickMiniCardView)) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            } else if (anythinkBaseView != null && anythinkBaseView.getVisibility() == 0 && anythinkBaseView.getParent() != null && !isLast()) {
                anythinkBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.q != null || this.t != null) {
            this.e.a(104, "");
            return;
        }
        if (this.u != null) {
            this.e.a(103, "");
            return;
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.C) {
            this.e.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.onBackPress();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(android.content.res.Configuration configuration) {
        com.anythink.expressad.video.module.AnythinkH5EndCardView[] anythinkH5EndCardViewArr = {this.n, this.p, this.r, this.v};
        for (int i = 0; i < 4; i++) {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0) {
                anythinkH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        this.Q = bVar;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            if (cVar.J() == 2) {
                if (this.n == null) {
                    this.n = new com.anythink.expressad.video.module.AnythinkPlayableView(this.a);
                }
                this.n.setCloseDelayShowTime(this.z);
                this.n.setPlayCloseBtnTm(this.A);
                this.n.setCampaign(this.b);
                this.n.setNotifyListener(new com.anythink.expressad.video.module.AnythinkContainerView.AnonymousClass4(this.e));
                this.n.preLoadData(bVar);
            } else {
                b(this.x);
                if (this.b.j()) {
                    try {
                        a(bVar, java.lang.Integer.valueOf(this.b.F()));
                    } catch (java.lang.Throwable th) {
                        th.getMessage();
                        new android.os.Handler(android.os.Looper.getMainLooper()).postAtFrontOfQueue(new com.anythink.expressad.video.module.AnythinkContainerView.AnonymousClass1(bVar));
                    }
                    com.anythink.expressad.foundation.h.t.f(this.b.I());
                } else {
                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.anythink.expressad.video.module.AnythinkContainerView.AnonymousClass2(bVar), getVideoSkipTime());
                }
            }
            o();
        }
    }

    @Override // com.anythink.expressad.video.signal.e, com.anythink.expressad.video.signal.h
    public void readyStatus(int i) {
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.readyStatus(i);
        }
    }

    public void release() {
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.release();
            this.r = null;
        }
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.release();
        }
        com.anythink.expressad.video.module.AnythinkLandingPageView anythinkLandingPageView = this.u;
        if (anythinkLandingPageView != null) {
            anythinkLandingPageView.release();
        }
        com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.clearMoreOfferBitmap();
            this.q.release();
        }
        if (this.e != null) {
            this.e = null;
        }
    }

    @Override // com.anythink.expressad.video.signal.e
    public void resizeMiniCard(int i, int i2, int i3) {
        com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.resizeMiniCard(i, i2);
            this.p.setRadius(i3);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            m();
        }
    }

    public void setAnythinkClickMiniCardViewTransparent() {
        com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.setAnythinkClickMiniCardViewTransparent();
            this.p.setAnythinkClickMiniCardViewClickable(false);
        }
    }

    public void setCloseDelayTime(int i) {
        this.z = i;
    }

    public void setEndscreenType(int i) {
        this.y = i;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.Q = bVar;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        java.lang.String.format("%1s-%2s-%3s-%4s-%5s", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i));
        this.O = i;
        this.K = i2;
        this.L = i3;
        this.M = i4;
        this.N = i5;
        this.P = com.anythink.expressad.foundation.h.h.a(i, i2, i3, i4, i5);
        com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setNotchPadding(i2, i3, i4, i5);
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null && anythinkH5EndCardView.f274s != null) {
            anythinkH5EndCardView.setNotchValue(this.P, i2, i3, i4, i5);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.r.f274s, "oncutoutfetched", android.util.Base64.encodeToString(this.P.getBytes(), 0));
        }
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null && anythinkPlayableView.f274s != null) {
            anythinkPlayableView.setNotchValue(this.P, i2, i3, i4, i5);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.n.f274s, "oncutoutfetched", android.util.Base64.encodeToString(this.P.getBytes(), 0));
        }
        com.anythink.expressad.video.dynview.widget.ATOrderCampView aTOrderCampView = this.R;
        if (aTOrderCampView != null) {
            aTOrderCampView.setNotchPadding(i2, i3, i4, i5);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void setNotifyListener(com.anythink.expressad.video.module.a.a aVar) {
        super.setNotifyListener(aVar);
        com.anythink.expressad.video.module.AnythinkBaseView[] anythinkBaseViewArr = {this.n, this.o, this.p, this.q, this.r, this.t, this.u, this.f273s};
        for (int i = 0; i < 8; i++) {
            com.anythink.expressad.video.module.AnythinkBaseView anythinkBaseView = anythinkBaseViewArr[i];
            if (anythinkBaseView != null) {
                if (anythinkBaseView instanceof com.anythink.expressad.video.module.AnythinkClickMiniCardView) {
                    anythinkBaseView.setNotifyListener(new com.anythink.expressad.video.module.a.a.g(this.p, aVar));
                } else {
                    anythinkBaseView.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = this.q;
        if (anythinkNativeEndCardView != null) {
            anythinkNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i) {
        this.A = i;
    }

    public void setRewardStatus(boolean z) {
        this.J = z;
    }

    public void setShowingTransparent(boolean z) {
        this.D = z;
    }

    public void setUnitID(java.lang.String str) {
        this.w = str;
    }

    public void setVideoInteractiveType(int i) {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j()) {
            this.x = i;
            return;
        }
        int a = com.anythink.expressad.video.dynview.i.c.a(this.b);
        if (a == 100) {
            this.x = i;
        } else {
            this.x = a;
        }
    }

    public void setVideoSkipTime(int i) {
        this.H = i;
    }

    @Override // com.anythink.expressad.video.signal.e
    public boolean showAlertWebView() {
        com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = this.v;
        if (anythinkAlertWebview == null || !anythinkAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) getParent();
        if (!(viewGroup.indexOfChild(this) == viewGroup.getChildCount() - 1) && !this.T) {
            removeAllViews();
            bringToFront();
            this.S = true;
        }
        com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null && anythinkClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.v == null) {
            o();
        }
        com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview2 = this.v;
        if (anythinkAlertWebview2 != null && anythinkAlertWebview2.getParent() != null) {
            removeView(this.v);
        }
        addView(this.v);
        setBackgroundColor(0);
        this.v.webviewshow();
        return true;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showEndcard(int i) {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            if (i == 1) {
                this.e.a(104, "");
            } else if (i == 100) {
                if (cVar.J() == 2) {
                    this.E = true;
                }
                a(this.n);
                setMatchParent();
                i();
            } else if (i == 3) {
                removeAllViews();
                setMatchParent();
                if (this.t == null) {
                    a(this.Q, (java.lang.Integer) 3);
                }
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.t, layoutParams);
                this.t.notifyShowListener();
                this.T = true;
                bringToFront();
            } else if (i == 4) {
                this.e.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.u == null) {
                    a(this.Q, (java.lang.Integer) 4);
                }
                this.u.setUnitId(this.w);
                this.u.preLoadData(this.Q);
                addView(this.u);
                this.T = true;
                bringToFront();
            } else if (i != 5) {
                removeAllViews();
                setMatchParent();
                this.T = true;
                bringToFront();
                e();
                this.e.a(117, "");
            } else {
                this.e.a(106, "");
            }
        }
        this.B = true;
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showMiniCard(int i, int i2, int i3, int i4, int i5) {
        com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
        if (anythinkClickMiniCardView != null) {
            anythinkClickMiniCardView.setMiniCardLocation(i, i2, i3, i4);
            this.p.setRadius(i5);
            this.p.setCloseVisible(8);
            this.p.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.T = true;
            bringToFront();
            m();
            if (this.G) {
                return;
            }
            this.G = true;
            this.e.a(109, "");
            this.e.a(117, "");
        }
    }

    public void showOrderCampView() {
        com.anythink.expressad.video.dynview.widget.ATOrderCampView aTOrderCampView = new com.anythink.expressad.video.dynview.widget.ATOrderCampView(this.a);
        this.R = aTOrderCampView;
        aTOrderCampView.setCampaignExes(this.U);
        com.anythink.expressad.video.module.a.a aVar = this.e;
        if (aVar != null && (aVar instanceof com.anythink.expressad.video.module.a.a.k)) {
            ((com.anythink.expressad.video.module.a.a.k) aVar).a(this.U);
        }
        this.R.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
        this.R.setRewarded(this.J);
        this.R.setNotchPadding(this.K, this.L, this.M, this.N);
        this.R.setCampOrderViewBuildCallback(new com.anythink.expressad.video.module.AnythinkContainerView.AnonymousClass3());
        this.R.createView(this);
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showPlayableView() {
        if (this.b == null || this.E) {
            return;
        }
        removeAllViews();
        setMatchParent();
        if (this.n == null) {
            preLoadData(this.Q);
        }
        addView(this.n);
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.setUnitId(this.w);
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && cVar.H() && this.b.J() == 2) {
                this.n.setCloseVisible(0);
            }
            this.n.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        this.T = true;
        bringToFront();
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoClickView(int i) {
        com.anythink.expressad.foundation.d.c cVar;
        if (this.b != null) {
            if (i == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                p();
                return;
            }
            if (i == 1) {
                if (this.B) {
                    return;
                }
                com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
                if (anythinkH5EndCardView != null && anythinkH5EndCardView.getParent() != null) {
                    removeView(this.r);
                }
                com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView = this.p;
                if (anythinkClickMiniCardView != null && anythinkClickMiniCardView.getParent() != null) {
                    removeView(this.p);
                }
                com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView = this.o;
                if (anythinkClickCTAView == null || anythinkClickCTAView.getParent() == null) {
                    try {
                        com.anythink.expressad.foundation.d.c cVar2 = this.b;
                        if (cVar2 != null && cVar2.J() == 1) {
                            this.T = true;
                            if (this.o == null) {
                                b(-1);
                            }
                            if (this.o != null && ((cVar = this.b) == null || !cVar.j())) {
                                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.o, 0, layoutParams);
                            }
                        }
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                    return;
                }
                return;
            }
            if (i != 2) {
                return;
            }
            com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView2 = this.o;
            if (anythinkClickCTAView2 != null && anythinkClickCTAView2.getParent() != null) {
                removeView(this.o);
            }
            com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = this.v;
            if (anythinkAlertWebview == null || anythinkAlertWebview.getParent() == null) {
                com.anythink.expressad.video.module.AnythinkClickMiniCardView anythinkClickMiniCardView2 = this.p;
                if (anythinkClickMiniCardView2 == null || anythinkClickMiniCardView2.getParent() == null) {
                    try {
                        com.anythink.expressad.foundation.d.c cVar3 = this.b;
                        if (cVar3 != null && cVar3.J() == 1) {
                            setMatchParent();
                            m();
                        }
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (!miniCardLoaded()) {
                    p();
                    return;
                }
                com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView2 = this.r;
                if (anythinkH5EndCardView2 != null && anythinkH5EndCardView2.getParent() != null) {
                    removeView(this.r);
                }
                this.e.a(112, "");
                com.anythink.expressad.foundation.d.c cVar4 = this.b;
                if (cVar4 != null && !cVar4.aw()) {
                    this.b.ax();
                    com.anythink.expressad.video.module.b.a.e(this.a, this.b);
                }
                if (this.D) {
                    this.e.a(115, "");
                } else {
                    this.T = true;
                    bringToFront();
                    webviewshow();
                    onConfigurationChanged(getResources().getConfiguration());
                }
                this.C = true;
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.e
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        com.anythink.expressad.video.module.AnythinkVideoEndCoverView anythinkVideoEndCoverView = this.f273s;
        if (anythinkVideoEndCoverView == null) {
            com.anythink.expressad.video.signal.factory.b bVar = this.Q;
            this.Q = bVar;
            if (anythinkVideoEndCoverView == null) {
                com.anythink.expressad.video.module.AnythinkVideoEndCoverView anythinkVideoEndCoverView2 = new com.anythink.expressad.video.module.AnythinkVideoEndCoverView(this.a);
                this.f273s = anythinkVideoEndCoverView2;
                anythinkVideoEndCoverView2.setCampaign(this.b);
                this.f273s.setNotifyListener(new com.anythink.expressad.video.module.a.a.i(this.e));
                this.f273s.preLoadData(bVar);
            }
        }
        addView(this.f273s);
        onConfigurationChanged(getResources().getConfiguration());
        this.T = true;
        bringToFront();
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i) {
        com.anythink.expressad.video.module.AnythinkPlayableView anythinkPlayableView = this.n;
        if (anythinkPlayableView != null) {
            anythinkPlayableView.toggleCloseBtn(i);
        }
        com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.r;
        if (anythinkH5EndCardView != null) {
            anythinkH5EndCardView.toggleCloseBtn(i);
        }
    }

    public void triggerCloseBtn(java.lang.String str) {
        if (this.b != null) {
            this.e.a(122, "");
            this.e.a(104, "");
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void webviewshow() {
        com.anythink.expressad.video.module.AnythinkH5EndCardView[] anythinkH5EndCardViewArr = {this.n, this.p, this.r, this.v};
        for (int i = 0; i < 4; i++) {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = anythinkH5EndCardViewArr[i];
            if (anythinkH5EndCardView != null && anythinkH5EndCardView.getVisibility() == 0 && anythinkH5EndCardView.getParent() != null && !isLast()) {
                anythinkH5EndCardView.webviewshow();
            }
        }
    }
}
