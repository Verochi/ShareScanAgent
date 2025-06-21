package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ThirdPartyFullScreenATView extends com.anythink.basead.ui.BaseScreenATView {
    public static final java.lang.String TAG = "ThirdPartyFullScreenATView";
    android.view.View ad;
    java.util.Timer ae;
    private com.anythink.core.api.BaseAd af;
    private final com.anythink.core.common.m.a ag;
    private final com.anythink.core.common.m.b ah;

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.ThirdPartyFullScreenATView.this.J();
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.b.n {
        public AnonymousClass2() {
        }

        @Override // com.anythink.core.common.b.n
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.ThirdPartyFullScreenATView.this.q();
            com.anythink.basead.ui.ThirdPartyFullScreenATView.this.a(com.anythink.basead.c.f.a(str, str2));
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdClicked(android.view.View view) {
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.ThirdPartyFullScreenATView.this.T;
            if (hVar != null) {
                hVar.b(new com.anythink.basead.e.i().a(1, 13));
            }
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdDislikeButtonClick() {
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdImpressed() {
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.ThirdPartyFullScreenATView.this.T;
            if (hVar != null) {
                hVar.a(new com.anythink.basead.e.i());
            }
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoEnd() {
            com.anythink.basead.ui.ThirdPartyFullScreenATView.b(com.anythink.basead.ui.ThirdPartyFullScreenATView.this);
            com.anythink.basead.ui.ThirdPartyFullScreenATView.this.J();
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.ThirdPartyFullScreenATView.this.T;
            if (hVar != null) {
                hVar.b();
            }
            com.anythink.basead.ui.ThirdPartyFullScreenATView.this.q();
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoProgress(int i) {
            com.anythink.basead.ui.ThirdPartyFullScreenATView.b(com.anythink.basead.ui.ThirdPartyFullScreenATView.this);
            com.anythink.basead.ui.ThirdPartyFullScreenATView.a(com.anythink.basead.ui.ThirdPartyFullScreenATView.this, i);
        }

        @Override // com.anythink.core.common.b.m
        public final void onAdVideoStart() {
            com.anythink.basead.ui.ThirdPartyFullScreenATView.a(com.anythink.basead.ui.ThirdPartyFullScreenATView.this);
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.ThirdPartyFullScreenATView.this.T;
            if (hVar != null) {
                hVar.a();
            }
        }

        @Override // com.anythink.core.common.b.m
        public final void onDeeplinkCallback(boolean z) {
        }

        @Override // com.anythink.core.common.b.m
        public final void onDownloadConfirmCallback(android.content.Context context, android.view.View view, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenATView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ int a;

        public AnonymousClass3(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.a * 1000;
            com.anythink.basead.ui.CountDownView countDownView = com.anythink.basead.ui.ThirdPartyFullScreenATView.this.P;
            if (countDownView != null && countDownView.getVisibility() == 0) {
                com.anythink.basead.ui.ThirdPartyFullScreenATView.this.P.refresh(i);
            }
            com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView = com.anythink.basead.ui.ThirdPartyFullScreenATView.this;
            int i2 = thirdPartyFullScreenATView.C;
            if (i2 < 0 || i < i2) {
                return;
            }
            thirdPartyFullScreenATView.J();
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenATView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.basead.ui.PanelView.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.PanelView.a
        public final void a(int i, int i2) {
        }

        @Override // com.anythink.basead.ui.PanelView.a
        public final boolean a() {
            return false;
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenATView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView = com.anythink.basead.ui.ThirdPartyFullScreenATView.this;
            if (thirdPartyFullScreenATView.ad == null || thirdPartyFullScreenATView.S == null || thirdPartyFullScreenATView.af == null) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView2 = com.anythink.basead.ui.ThirdPartyFullScreenATView.this;
            boolean z = !thirdPartyFullScreenATView2.I;
            thirdPartyFullScreenATView2.I = z;
            thirdPartyFullScreenATView2.S.setMute(z);
            com.anythink.basead.ui.ThirdPartyFullScreenATView.this.af.setVideoMute(com.anythink.basead.ui.ThirdPartyFullScreenATView.this.I);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyFullScreenATView$6, reason: invalid class name */
    public class AnonymousClass6 extends java.util.TimerTask {
        public AnonymousClass6() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView = com.anythink.basead.ui.ThirdPartyFullScreenATView.this;
            com.anythink.basead.ui.ThirdPartyFullScreenATView.a(thirdPartyFullScreenATView, (int) thirdPartyFullScreenATView.af.getVideoProgress());
        }
    }

    public ThirdPartyFullScreenATView(android.content.Context context) {
        super(context);
        this.ag = com.anythink.core.common.m.d.a();
        this.ah = new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass1();
    }

    public ThirdPartyFullScreenATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, int i, int i2, com.anythink.core.api.BaseAd baseAd) {
        super(context, mVar, lVar, str, i, i2);
        this.ag = com.anythink.core.common.m.d.a();
        this.ah = new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass1();
        this.af = baseAd;
        this.ad = baseAd.getAdMediaView(new java.lang.Object[0]);
        setId(com.anythink.core.common.o.i.a(getContext(), "myoffer_thirdparty_full_screen_view_id", "id"));
    }

    private void R() {
        int i = this.C;
        if (i < 0) {
            return;
        }
        if (i > 0) {
            this.ag.a(this.ah, i, true);
        } else {
            J();
        }
    }

    private void S() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int D = this.b.n.D();
        if (D == 0) {
            arrayList.addAll(this.M.getClickViews());
            arrayList.add(this.M);
            com.anythink.basead.ui.BaseEndCardView baseEndCardView = this.N;
            if (baseEndCardView != null) {
                arrayList.add(baseEndCardView);
            }
        } else if (D != 1) {
            if (D == 2) {
                arrayList.addAll(this.M.getClickViews());
                arrayList.add(this.M);
            }
        } else if (this.M.getCTAButton() != null) {
            arrayList.add(this.M.getCTAButton());
        }
        this.af.registerListener(this, arrayList, null);
    }

    private void T() {
        android.view.View shakeView;
        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        if (b(this.E)) {
            int i = this.E;
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        int i2 = this.y;
                        int i3 = (int) (i2 * 0.5f);
                        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i2 - i3));
                        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = this.x;
                            layoutParams.height = i3;
                            this.M.setLayoutParams(layoutParams);
                            this.M.removeAllViews();
                            this.M.setLayoutType(this.E);
                        }
                    } else if (i != 6) {
                        if (i == 8 && (shakeView = this.M.getShakeView()) != null) {
                            shakeView.setVisibility(8);
                        }
                    }
                }
                int a = com.anythink.core.common.o.i.a(getContext(), 300.0f);
                this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.x - a, -1));
                android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a;
                    layoutParams2.height = -1;
                    this.M.setLayoutParams(layoutParams2);
                    this.M.removeAllViews();
                    this.M.setLayoutType(this.E);
                }
            } else {
                this.K.setBackgroundColor(-1);
                int i4 = (int) (this.y * 0.5f);
                int a2 = android.text.TextUtils.isEmpty(this.c.w()) ? this.y - i4 : (this.y - i4) + com.anythink.core.common.o.i.a(getContext(), 50.0f);
                this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i4));
                this.N.setNeedArc(true);
                android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.x;
                    layoutParams3.height = a2;
                    this.M.setLayoutParams(layoutParams3);
                    this.M.removeAllViews();
                    this.M.setLayoutType(this.E);
                }
            }
        }
        this.K.addView(this.N, 1);
    }

    private void U() {
        this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        P().setVisibility(0);
        this.K.addView(this.N, 1);
    }

    private void V() {
        if (this.ae == null) {
            java.util.Timer timer = new java.util.Timer();
            this.ae = timer;
            timer.schedule(new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass6(), 0L, 300L);
        }
    }

    private void W() {
        java.util.Timer timer = this.ae;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void X() {
        java.util.Timer timer = this.ae;
        if (timer != null) {
            timer.cancel();
            this.ae = null;
        }
        this.ag.b(this.ah);
    }

    private boolean Y() {
        com.anythink.core.api.BaseAd baseAd = this.af;
        return (baseAd == null || !android.text.TextUtils.equals(baseAd.getAdType(), "1") || this.ad == null) ? false : true;
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        if (thirdPartyFullScreenATView.ae == null) {
            java.util.Timer timer = new java.util.Timer();
            thirdPartyFullScreenATView.ae = timer;
            timer.schedule(thirdPartyFullScreenATView.new AnonymousClass6(), 0L, 300L);
        }
    }

    public static /* synthetic */ void a(com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView, int i) {
        thirdPartyFullScreenATView.post(thirdPartyFullScreenATView.new AnonymousClass3(i));
    }

    public static /* synthetic */ void b(com.anythink.basead.ui.ThirdPartyFullScreenATView thirdPartyFullScreenATView) {
        java.util.Timer timer = thirdPartyFullScreenATView.ae;
        if (timer != null) {
            timer.cancel();
        }
    }

    private void d(int i) {
        post(new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass3(i));
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void B() {
        super.D();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void J() {
        super.J();
        this.ag.b(this.ah);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void K() {
        com.anythink.basead.ui.BaseEndCardView baseEndCardView;
        android.view.View shakeView;
        if (this.K == null || (baseEndCardView = this.N) == null || baseEndCardView.getParent() != null) {
            return;
        }
        if (Y()) {
            this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            if (b(this.E)) {
                int i = this.E;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 5) {
                            int i2 = this.y;
                            int i3 = (int) (i2 * 0.5f);
                            this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i2 - i3));
                            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
                            if (layoutParams != null) {
                                layoutParams.width = this.x;
                                layoutParams.height = i3;
                                this.M.setLayoutParams(layoutParams);
                                this.M.removeAllViews();
                                this.M.setLayoutType(this.E);
                            }
                        } else if (i != 6) {
                            if (i == 8 && (shakeView = this.M.getShakeView()) != null) {
                                shakeView.setVisibility(8);
                            }
                        }
                    }
                    int a = com.anythink.core.common.o.i.a(getContext(), 300.0f);
                    this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(this.x - a, -1));
                    android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.width = a;
                        layoutParams2.height = -1;
                        this.M.setLayoutParams(layoutParams2);
                        this.M.removeAllViews();
                        this.M.setLayoutType(this.E);
                    }
                } else {
                    this.K.setBackgroundColor(-1);
                    int i4 = (int) (this.y * 0.5f);
                    int a2 = android.text.TextUtils.isEmpty(this.c.w()) ? this.y - i4 : (this.y - i4) + com.anythink.core.common.o.i.a(getContext(), 50.0f);
                    this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i4));
                    this.N.setNeedArc(true);
                    android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
                    if (layoutParams3 != null) {
                        layoutParams3.width = this.x;
                        layoutParams3.height = a2;
                        this.M.setLayoutParams(layoutParams3);
                        this.M.removeAllViews();
                        this.M.setLayoutType(this.E);
                    }
                }
            }
            this.K.addView(this.N, 1);
        } else {
            this.N.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            P().setVisibility(0);
            this.K.addView(this.N, 1);
        }
        S();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void L() {
        android.view.View view = this.ad;
        if (view != null && view.getParent() != null) {
            ((android.view.ViewGroup) this.ad.getParent()).removeView(this.ad);
        }
        com.anythink.basead.ui.CountDownView countDownView = this.P;
        if (countDownView != null) {
            countDownView.setVisibility(8);
        }
        com.anythink.basead.ui.MuteImageView muteImageView = this.S;
        if (muteImageView != null) {
            muteImageView.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a() {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_thirdparty_full_screen", "layout"), this);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final boolean b(int i) {
        return (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) ? com.anythink.basead.a.d.a(this.c) : i == 8;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        java.util.Timer timer = this.ae;
        if (timer != null) {
            timer.cancel();
            this.ae = null;
        }
        this.ag.b(this.ah);
        com.anythink.core.api.BaseAd baseAd = this.af;
        if (baseAd != null) {
            baseAd.clear(this);
            this.af.destroy();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void init() {
        b();
        this.D = b(this.E);
        this.af.setNativeEventListener(new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass2());
        if (!this.G) {
            int i = ((com.anythink.basead.ui.BaseScreenATView) this).v;
            if (1 == i || 3 != i) {
                return;
            }
            if (Y()) {
                p();
                int i2 = this.C;
                if (i2 >= 0) {
                    if (i2 > 0) {
                        this.ag.a(this.ah, i2, true);
                        return;
                    } else {
                        J();
                        return;
                    }
                }
                return;
            }
        }
        q();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void p() {
        android.view.View view = this.ad;
        if (view != null) {
            this.K.addView(view, 0, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            c(((int) this.af.getVideoDuration()) * 1000);
            F();
            S();
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final int r() {
        int i = this.E;
        return i == 8 ? i : this.x < this.y ? this.W >= this.aa ? 1 : 5 : this.W < this.aa ? 2 : 6;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void v() {
        java.lang.String x = this.c.x();
        if (android.text.TextUtils.isEmpty(x)) {
            return;
        }
        com.anythink.basead.a.e.a();
        int[] a = com.anythink.core.common.o.c.a(com.anythink.basead.a.e.a(2, x));
        if (a != null) {
            int i = a[0];
            this.ab = i;
            int i2 = a[1];
            this.ac = i2;
            this.W = i;
            this.aa = i2;
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void w() {
        com.anythink.basead.ui.PanelView panelView = this.M;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.M.init(this.c, this.b, this.w, false, new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass4());
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void x() {
        super.x();
        if (this.M != null) {
            if (com.anythink.basead.a.d.a(this.c)) {
                this.E = 0;
            } else {
                this.E = 8;
            }
            this.M.setLayoutType(this.E);
            if (this.E == 8 && this.b.n.D() == 0) {
                this.M.getCTAButton().setVisibility(8);
            }
            this.M.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void z() {
        com.anythink.basead.ui.MuteImageView muteImageView = this.S;
        if (muteImageView == null) {
            return;
        }
        if (this.I) {
            muteImageView.setMute(true);
        } else {
            muteImageView.setMute(false);
        }
        this.S.setVisibility(4);
        this.S.setOnClickListener(new com.anythink.basead.ui.ThirdPartyFullScreenATView.AnonymousClass5());
    }
}
