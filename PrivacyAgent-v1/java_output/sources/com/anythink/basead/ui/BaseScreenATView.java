package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseScreenATView extends com.anythink.basead.ui.BaseATView {
    public static final int FORMAT_INTERSTITIAL = 3;
    public static final int FORMAT_REWARD_VIDEO = 1;
    public static final java.lang.String TAG = "BaseScreenATView";
    protected int A;
    long B;
    protected int C;
    protected boolean D;
    protected int E;
    protected int F;
    protected boolean G;
    protected boolean H;
    protected boolean I;
    protected float J;
    protected android.widget.RelativeLayout K;
    protected com.anythink.basead.ui.animplayerview.BasePlayerView L;
    protected com.anythink.basead.ui.PanelView M;
    protected com.anythink.basead.ui.BaseEndCardView N;
    protected com.anythink.basead.ui.b O;
    protected com.anythink.basead.ui.CountDownView P;
    protected com.anythink.basead.ui.CloseImageView Q;
    protected android.view.ViewGroup R;
    protected com.anythink.basead.ui.MuteImageView S;
    protected com.anythink.basead.e.h T;
    java.lang.Runnable U;
    java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.Boolean> V;
    protected int W;
    protected int aa;
    protected int ab;
    protected int ac;
    private long ad;
    private long ae;
    private long af;
    private long ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private com.anythink.basead.c ak;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected int z;

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseScreenATView.super.h();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$10, reason: invalid class name */
    public class AnonymousClass10 implements com.anythink.basead.ui.EndCardView.a {
        public AnonymousClass10() {
        }

        @Override // com.anythink.basead.ui.EndCardView.a
        public final void a() {
            java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            baseScreenATView.a(1, baseScreenATView.r ? 7 : 3);
        }

        @Override // com.anythink.basead.ui.EndCardView.a
        public final void b() {
            com.anythink.basead.ui.BaseScreenATView.this.L();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$11, reason: invalid class name */
    public class AnonymousClass11 implements com.anythink.basead.c.a {
        public AnonymousClass11() {
        }

        @Override // com.anythink.basead.c.a
        public final void a() {
            com.anythink.basead.ui.BaseScreenATView.e(com.anythink.basead.ui.BaseScreenATView.this);
        }

        @Override // com.anythink.basead.c.a
        public final void b() {
            com.anythink.basead.ui.BaseScreenATView.this.s();
            com.anythink.basead.ui.BaseScreenATView.this.ak.b();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        public AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseScreenATView.g(com.anythink.basead.ui.BaseScreenATView.this);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$13, reason: invalid class name */
    public class AnonymousClass13 implements com.anythink.basead.ui.PanelView.a {
        public AnonymousClass13() {
        }

        @Override // com.anythink.basead.ui.PanelView.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.BaseScreenATView.this.a(i, i2);
        }

        @Override // com.anythink.basead.ui.PanelView.a
        public final boolean a() {
            if (!com.anythink.basead.ui.BaseScreenATView.this.y()) {
                return false;
            }
            com.anythink.basead.ui.BaseScreenATView.this.a(4, 5);
            return true;
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            if (baseScreenATView.L == null || baseScreenATView.S == null) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (!r1.isMute()) {
                com.anythink.basead.ui.BaseScreenATView baseScreenATView2 = com.anythink.basead.ui.BaseScreenATView.this;
                baseScreenATView2.I = true;
                baseScreenATView2.S.setMute(true);
                com.anythink.basead.ui.BaseScreenATView.this.L.setMute(true);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            com.anythink.basead.ui.BaseScreenATView baseScreenATView3 = com.anythink.basead.ui.BaseScreenATView.this;
            baseScreenATView3.I = false;
            baseScreenATView3.S.setMute(false);
            com.anythink.basead.ui.BaseScreenATView.this.L.setMute(false);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.BaseScreenATView.this.B();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.BaseScreenATView.h(com.anythink.basead.ui.BaseScreenATView.this);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.basead.ui.BaseScreenATView.a a;

        /* renamed from: com.anythink.basead.ui.BaseScreenATView$5$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ java.util.List a;

            public AnonymousClass1(java.util.List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.BaseScreenATView.a aVar = com.anythink.basead.ui.BaseScreenATView.AnonymousClass5.this.a;
                if (aVar != null) {
                    aVar.a(this.a);
                }
            }
        }

        /* renamed from: com.anythink.basead.ui.BaseScreenATView$5$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ java.util.List a;

            public AnonymousClass2(java.util.List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.BaseScreenATView.a aVar = com.anythink.basead.ui.BaseScreenATView.AnonymousClass5.this.a;
                if (aVar != null) {
                    aVar.a(this.a);
                }
            }
        }

        public AnonymousClass5(com.anythink.basead.ui.BaseScreenATView.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.a b = com.anythink.core.d.b.a(com.anythink.basead.ui.BaseScreenATView.this.getContext()).b(com.anythink.core.common.b.o.a().o());
            java.util.List<java.lang.String> arrayList = new java.util.ArrayList<>();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int i = com.anythink.basead.ui.BaseScreenATView.this.F;
            int i2 = 0;
            if (i == 2) {
                arrayList = b.h();
            } else if (i == 3) {
                arrayList = b.j();
            } else if (i == 5) {
                arrayList = b.i();
                boolean z = arrayList.size() >= 4;
                if (z) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        java.lang.String str = arrayList.get(i3);
                        if (android.text.TextUtils.isEmpty(str) || !com.anythink.basead.a.b.c.b(str, 3)) {
                            z = false;
                            break;
                        }
                    }
                }
                if (!z) {
                    arrayList.clear();
                }
            }
            if (arrayList.size() == 0) {
                com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass5.AnonymousClass1(arrayList2));
                return;
            }
            if (arrayList.size() > 0) {
                try {
                    i2 = java.lang.Math.min(com.anythink.basead.ui.BaseScreenATView.this.getResources().getDisplayMetrics().widthPixels, com.anythink.basead.ui.BaseScreenATView.this.getResources().getDisplayMetrics().heightPixels) / 2;
                } catch (java.lang.Throwable unused) {
                }
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(com.anythink.core.common.res.b.a(com.anythink.basead.ui.BaseScreenATView.this.getContext()).b(new com.anythink.core.common.res.e(3, it.next()), i2, i2));
                }
            }
            com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass5.AnonymousClass2(arrayList2));
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.basead.ui.animplayerview.BasePlayerView.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a() {
            java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            com.anythink.basead.ui.b.a aVar = baseScreenATView.t;
            if (aVar != null) {
                aVar.a(baseScreenATView.L.getVideoLength());
            }
            com.anythink.basead.ui.BaseScreenATView.this.a(101);
            com.anythink.basead.ui.BaseScreenATView.this.F();
            com.anythink.basead.ui.BaseScreenATView.this.ad = java.lang.System.currentTimeMillis();
            com.anythink.basead.ui.BaseScreenATView.this.h();
            com.anythink.basead.ui.BaseScreenATView.b(com.anythink.basead.ui.BaseScreenATView.this);
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a(int i) {
            com.anythink.basead.c.i i2 = com.anythink.basead.ui.BaseScreenATView.this.i();
            if (i == 25) {
                java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
                com.anythink.basead.a.a.a(2, com.anythink.basead.ui.BaseScreenATView.this.c, i2);
            } else if (i == 50) {
                java.lang.String str2 = com.anythink.basead.ui.BaseScreenATView.TAG;
                com.anythink.basead.a.a.a(3, com.anythink.basead.ui.BaseScreenATView.this.c, i2);
            } else {
                if (i != 75) {
                    return;
                }
                java.lang.String str3 = com.anythink.basead.ui.BaseScreenATView.TAG;
                com.anythink.basead.a.a.a(4, com.anythink.basead.ui.BaseScreenATView.this.c, i2);
            }
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a(long j) {
            com.anythink.basead.ui.BaseScreenATView.b(com.anythink.basead.ui.BaseScreenATView.this, j);
            com.anythink.basead.ui.BaseScreenATView.this.a(j);
            com.anythink.basead.ui.BaseScreenATView.this.b(j);
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            int i = baseScreenATView.C;
            if (i >= 0 && j >= i) {
                baseScreenATView.J();
            }
            if (j >= com.anythink.basead.ui.BaseScreenATView.this.b.n.k()) {
                com.anythink.basead.ui.BaseScreenATView baseScreenATView2 = com.anythink.basead.ui.BaseScreenATView.this;
                if (baseScreenATView2.H) {
                    return;
                }
                baseScreenATView2.J();
                com.anythink.basead.ui.BaseScreenATView baseScreenATView3 = com.anythink.basead.ui.BaseScreenATView.this;
                baseScreenATView3.H = true;
                com.anythink.basead.e.h hVar = baseScreenATView3.T;
                if (hVar != null) {
                    hVar.c();
                }
            }
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void a(com.anythink.basead.c.e eVar) {
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            baseScreenATView.r = true;
            baseScreenATView.a(108);
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.BaseScreenATView.this.T;
            if (hVar != null) {
                hVar.g();
            }
            com.anythink.basead.c.i i = com.anythink.basead.ui.BaseScreenATView.this.i();
            i.h = com.anythink.basead.ui.BaseScreenATView.this.fillVideoEndRecord(false);
            com.anythink.basead.a.a.a(17, com.anythink.basead.ui.BaseScreenATView.this.c, i);
            com.anythink.basead.ui.BaseScreenATView.this.a(eVar);
            com.anythink.basead.ui.BaseScreenATView baseScreenATView2 = com.anythink.basead.ui.BaseScreenATView.this;
            if (!baseScreenATView2.H && baseScreenATView2.b.n.l() == 1) {
                com.anythink.basead.ui.BaseScreenATView baseScreenATView3 = com.anythink.basead.ui.BaseScreenATView.this;
                baseScreenATView3.H = true;
                com.anythink.basead.e.h hVar2 = baseScreenATView3.T;
                if (hVar2 != null) {
                    hVar2.c();
                }
            }
            com.anythink.basead.ui.BaseScreenATView baseScreenATView4 = com.anythink.basead.ui.BaseScreenATView.this;
            com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = baseScreenATView4.L;
            if (basePlayerView != null) {
                baseScreenATView4.b(basePlayerView.getVideoLength());
            }
            com.anythink.basead.ui.BaseScreenATView baseScreenATView5 = com.anythink.basead.ui.BaseScreenATView.this;
            if (baseScreenATView5.G) {
                baseScreenATView5.Q();
            } else {
                baseScreenATView5.q();
            }
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void b() {
            java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void b(long j) {
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.BaseScreenATView.this.T;
            if (hVar != null) {
                hVar.f();
            }
            com.anythink.basead.ui.BaseScreenATView.this.c(j);
            com.anythink.basead.a.a.a(35, com.anythink.basead.ui.BaseScreenATView.this.c, com.anythink.basead.ui.BaseScreenATView.this.i());
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void c() {
            java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
            com.anythink.basead.c.i i = com.anythink.basead.ui.BaseScreenATView.this.i();
            com.anythink.basead.a.a.a(5, com.anythink.basead.ui.BaseScreenATView.this.c, i);
            com.anythink.basead.a.a.a(31, com.anythink.basead.ui.BaseScreenATView.this.c, i);
            com.anythink.basead.ui.BaseScreenATView.this.a(107);
            com.anythink.basead.e.h hVar = com.anythink.basead.ui.BaseScreenATView.this.T;
            if (hVar != null) {
                hVar.b();
            }
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            if (!baseScreenATView.H) {
                baseScreenATView.H = true;
                com.anythink.basead.e.h hVar2 = baseScreenATView.T;
                if (hVar2 != null) {
                    hVar2.c();
                }
            }
            if (com.anythink.basead.ui.BaseScreenATView.this.b.n.N() != 1) {
                if (com.anythink.basead.ui.BaseScreenATView.this.M() != null) {
                    com.anythink.basead.ui.BaseScreenATView baseScreenATView2 = com.anythink.basead.ui.BaseScreenATView.this;
                    baseScreenATView2.a(baseScreenATView2.M());
                }
                com.anythink.basead.ui.BaseScreenATView.this.D();
                return;
            }
            com.anythink.basead.ui.BaseScreenATView baseScreenATView3 = com.anythink.basead.ui.BaseScreenATView.this;
            baseScreenATView3.r = true;
            if (baseScreenATView3.G) {
                baseScreenATView3.Q();
            } else {
                baseScreenATView3.q();
            }
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void d() {
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = baseScreenATView.L;
            if (basePlayerView != null) {
                com.anythink.basead.ui.BaseScreenATView.c(baseScreenATView, basePlayerView.getCurrentPosition());
            }
            com.anythink.basead.c.i i = com.anythink.basead.ui.BaseScreenATView.this.i();
            i.g = com.anythink.basead.ui.BaseScreenATView.this.j();
            com.anythink.basead.a.a.a(14, com.anythink.basead.ui.BaseScreenATView.this.c, i);
            com.anythink.core.common.f.n nVar = com.anythink.basead.ui.BaseScreenATView.this.b.n;
            if ((nVar == null || nVar.A() != 1) && !com.anythink.basead.ui.BaseScreenATView.this.N()) {
                return;
            }
            com.anythink.basead.ui.BaseScreenATView.this.a(1, 3);
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void e() {
            java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
            com.anythink.basead.c.i i = com.anythink.basead.ui.BaseScreenATView.this.i();
            i.g = com.anythink.basead.ui.BaseScreenATView.this.j();
            com.anythink.basead.a.a.a(12, com.anythink.basead.ui.BaseScreenATView.this.c, i);
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void f() {
            java.lang.String str = com.anythink.basead.ui.BaseScreenATView.TAG;
            com.anythink.basead.c.i i = com.anythink.basead.ui.BaseScreenATView.this.i();
            i.g = com.anythink.basead.ui.BaseScreenATView.this.j();
            com.anythink.basead.a.a.a(13, com.anythink.basead.ui.BaseScreenATView.this.c, i);
        }

        @Override // com.anythink.basead.ui.animplayerview.BasePlayerView.a
        public final void g() {
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            com.anythink.core.common.f.m mVar = baseScreenATView.b;
            new com.anythink.basead.a.b.f(mVar.b, baseScreenATView.c, mVar.n).b();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$7, reason: invalid class name */
    public class AnonymousClass7 implements com.anythink.basead.ui.BaseScreenATView.a {
        public AnonymousClass7() {
        }

        @Override // com.anythink.basead.ui.BaseScreenATView.a
        public final void a(java.util.List<android.graphics.Bitmap> list) {
            com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView;
            if (com.anythink.basead.ui.BaseScreenATView.this.F == 5 && (list == null || list.size() == 0)) {
                com.anythink.basead.ui.BaseScreenATView.this.F = 1;
            }
            com.anythink.basead.ui.BaseScreenATView.this.a(list);
            if (!com.anythink.basead.ui.BaseScreenATView.this.ah || (basePlayerView = com.anythink.basead.ui.BaseScreenATView.this.L) == null || basePlayerView.isPlaying()) {
                return;
            }
            com.anythink.basead.ui.BaseScreenATView.this.ac();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseScreenATView.this.J();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseScreenATView$9, reason: invalid class name */
    public class AnonymousClass9 implements com.anythink.basead.ui.MraidEndCardView.a {
        public AnonymousClass9() {
        }

        @Override // com.anythink.basead.ui.MraidEndCardView.a
        public final void a() {
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            if (3 == baseScreenATView.v) {
                if (baseScreenATView.c.F() == 1 && com.anythink.basead.ui.BaseScreenATView.this.c.H()) {
                    return;
                }
                com.anythink.basead.ui.BaseScreenATView.this.h();
            }
        }

        @Override // com.anythink.basead.ui.MraidEndCardView.a
        public final void a(java.lang.String str) {
            java.lang.String str2 = com.anythink.basead.ui.BaseScreenATView.TAG;
            com.anythink.basead.ui.BaseScreenATView.this.c.w(str);
            com.anythink.basead.ui.BaseScreenATView.this.a(1, 13);
        }

        @Override // com.anythink.basead.ui.MraidEndCardView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidEndCardView.a
        public final void c() {
            com.anythink.basead.ui.BaseScreenATView baseScreenATView = com.anythink.basead.ui.BaseScreenATView.this;
            if (3 == baseScreenATView.v) {
                if (baseScreenATView.c.F() == 1 && com.anythink.basead.ui.BaseScreenATView.this.c.H()) {
                    return;
                }
                com.anythink.basead.ui.BaseScreenATView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, com.anythink.basead.c.f.Q));
                com.anythink.basead.ui.BaseScreenATView.this.D();
            }
        }
    }

    public interface a {
        void a(java.util.List<android.graphics.Bitmap> list);
    }

    public BaseScreenATView(android.content.Context context) {
        super(context);
        this.F = 100;
        this.ah = false;
        this.U = new com.anythink.basead.ui.BaseScreenATView.AnonymousClass1();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BaseScreenATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, int i, int i2) {
        super(context, mVar, lVar, str);
        this.F = 100;
        this.ah = false;
        this.U = new com.anythink.basead.ui.BaseScreenATView.AnonymousClass1();
        this.v = i;
        this.w = i2;
        this.ae = this.b.n.B() > 0 ? this.b.n.B() * 1000 : this.b.n.B();
        long C = this.b.n.C() > 0 ? this.b.n.C() * 1000 : this.b.n.C();
        this.af = C;
        if (C > 0) {
            long j = this.ae;
            if (j >= 0) {
                this.ag = j + C;
                this.C = this.b.n.F() * 1000;
                this.I = this.b.n.E() == 0;
                if (1 != this.v) {
                    if (this.c.H()) {
                        this.F = 100;
                        return;
                    } else if (this.b.n.aj() == 1) {
                        this.F = 101;
                        return;
                    } else {
                        if (this.b.n.ak() > 0) {
                            this.F = this.b.n.ak();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        this.ag = C;
        this.C = this.b.n.F() * 1000;
        this.I = this.b.n.E() == 0;
        if (1 != this.v) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void R() {
        this.ae = this.b.n.B() > 0 ? this.b.n.B() * 1000 : this.b.n.B();
        long C = this.b.n.C() > 0 ? this.b.n.C() * 1000 : this.b.n.C();
        this.af = C;
        if (C > 0) {
            long j = this.ae;
            if (j >= 0) {
                this.ag = j + C;
                this.C = this.b.n.F() * 1000;
                this.I = this.b.n.E() != 0;
                if (1 != this.v) {
                    if (this.c.H()) {
                        this.F = 100;
                        return;
                    } else if (this.b.n.aj() == 1) {
                        this.F = 101;
                        return;
                    } else {
                        if (this.b.n.ak() > 0) {
                            this.F = this.b.n.ak();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        this.ag = C;
        this.C = this.b.n.F() * 1000;
        this.I = this.b.n.E() != 0;
        if (1 != this.v) {
        }
    }

    private void S() {
        if (com.anythink.basead.a.d.b(this.c) && !com.anythink.basead.a.b.c.a(this.b, this.c) && this.N == null) {
            this.N = b(true);
        }
    }

    private void T() {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.x = i;
        int i2 = displayMetrics.heightPixels;
        this.y = i2;
        this.W = i;
        this.aa = i2;
    }

    private void U() {
        if (this.F == 100) {
            a((java.util.List<android.graphics.Bitmap>) null);
        } else {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.ui.BaseScreenATView.AnonymousClass5(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass7()), 2, true);
        }
    }

    private void V() {
        if (this.N == null) {
            this.N = b(false);
        }
        K();
        L();
    }

    private void W() {
        this.E = r();
        com.anythink.basead.ui.EndCardView endCardView = new com.anythink.basead.ui.EndCardView(getContext(), this.c, this.b);
        endCardView.setSize(this.x, this.y);
        endCardView.init(false, false, new com.anythink.basead.ui.BaseScreenATView.AnonymousClass10());
        this.N = endCardView;
        K();
        endCardView.load();
        if (b(this.E)) {
            G();
            com.anythink.basead.ui.PanelView P = P();
            if (P == null || P.getVisibility() != 0) {
                return;
            }
            if (P.getCTAButton() == null || P.getCTAButton().getVisibility() != 0) {
                this.q = P;
            } else {
                this.q = P.getCTAButton();
            }
        }
    }

    private void X() {
        t();
        if (this.ak == null) {
            this.ak = new com.anythink.basead.c();
        }
        this.ak.a(getContext(), this.c, this.b, new com.anythink.basead.ui.BaseScreenATView.AnonymousClass11());
    }

    private void Y() {
        this.ai = true;
        if (O() != null) {
            O().setVisibility(8);
        }
    }

    private void Z() {
        if (this.O == null) {
            this.O = new com.anythink.basead.ui.b(this.K);
        }
        this.O.b();
    }

    private static int a(com.anythink.core.common.f.n nVar) {
        int H;
        if (nVar == null || (H = (int) (nVar.H() / 100.0f)) == 0) {
            return 0;
        }
        java.util.Random random = new java.util.Random();
        if (random.nextInt(100) > H) {
            return 0;
        }
        int I = nVar.I();
        int J = nVar.J();
        if (J <= 0) {
            return 0;
        }
        if (I == J) {
            return I;
        }
        try {
            return random.nextInt(J - I) + I;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private void a(com.anythink.basead.ui.BaseScreenATView.a aVar) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.ui.BaseScreenATView.AnonymousClass5(aVar), 2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.List<android.graphics.Bitmap> list) {
        o();
        this.L.setListener(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass6());
        this.T.e();
        this.L.init(this.c, this.b, this.I, list);
        if (this.F == 1) {
            q();
        } else {
            this.L.setVisibility(0);
        }
    }

    private void aa() {
        com.anythink.basead.ui.b bVar = this.O;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void ab() {
        com.anythink.basead.a.a.a(1, this.c, i());
        com.anythink.basead.e.h hVar = this.T;
        if (hVar != null) {
            hVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac() {
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView == null || !basePlayerView.hasVideo()) {
            return;
        }
        if (!this.L.isPlaying()) {
            this.ad = java.lang.System.currentTimeMillis();
            long currentPosition = this.L.getCurrentPosition();
            this.B = currentPosition;
            if (currentPosition != 0) {
                com.anythink.basead.a.a.a(15, this.c, i());
            }
        }
        this.L.start();
    }

    private void ad() {
        c(4);
    }

    private void ae() {
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView == null || basePlayerView.getParent() == null || !(this.L.getParent() instanceof android.view.ViewGroup)) {
            return;
        }
        if (!l() || this.r) {
            Q();
        }
    }

    private com.anythink.basead.ui.BaseEndCardView b(boolean z) {
        com.anythink.basead.ui.MraidEndCardView mraidEndCardView = new com.anythink.basead.ui.MraidEndCardView(getContext(), this.c, this.b);
        mraidEndCardView.setEndCardListener(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass9());
        mraidEndCardView.init(z);
        return mraidEndCardView;
    }

    public static /* synthetic */ void b(com.anythink.basead.ui.BaseScreenATView baseScreenATView) {
        com.anythink.basead.a.a.a(1, baseScreenATView.c, baseScreenATView.i());
        com.anythink.basead.e.h hVar = baseScreenATView.T;
        if (hVar != null) {
            hVar.a();
        }
    }

    public static /* synthetic */ void b(com.anythink.basead.ui.BaseScreenATView baseScreenATView, long j) {
        com.anythink.core.common.f.ak ad;
        java.util.Map<java.lang.Integer, java.lang.String[]> y;
        com.anythink.core.common.f.l lVar = baseScreenATView.c;
        if (!(lVar instanceof com.anythink.core.common.f.ai) || (ad = ((com.anythink.core.common.f.ai) lVar).ad()) == null || (y = ad.y()) == null || y.size() <= 0) {
            return;
        }
        if (baseScreenATView.V == null) {
            baseScreenATView.V = new java.util.concurrent.ConcurrentHashMap<>();
        }
        long j2 = j / 1000;
        for (java.lang.Integer num : y.keySet()) {
            if (baseScreenATView.V.get(num) == null || !baseScreenATView.V.get(num).booleanValue()) {
                if (j2 >= num.intValue()) {
                    baseScreenATView.V.put(num, java.lang.Boolean.TRUE);
                    com.anythink.basead.c.i i = baseScreenATView.i();
                    i.h.i = num.intValue();
                    com.anythink.basead.a.a.a(32, baseScreenATView.c, i);
                }
            }
        }
    }

    public static /* synthetic */ void c(com.anythink.basead.ui.BaseScreenATView baseScreenATView, long j) {
        if (baseScreenATView.D && baseScreenATView.ae == -1) {
            long j2 = baseScreenATView.af;
            if (j2 != 0) {
                baseScreenATView.ae = j;
                if (j2 > 0) {
                    baseScreenATView.ag = j + j2;
                }
                baseScreenATView.G();
            }
        }
    }

    private void d(long j) {
        com.anythink.core.common.f.ak ad;
        java.util.Map<java.lang.Integer, java.lang.String[]> y;
        com.anythink.core.common.f.l lVar = this.c;
        if (!(lVar instanceof com.anythink.core.common.f.ai) || (ad = ((com.anythink.core.common.f.ai) lVar).ad()) == null || (y = ad.y()) == null || y.size() <= 0) {
            return;
        }
        if (this.V == null) {
            this.V = new java.util.concurrent.ConcurrentHashMap<>();
        }
        long j2 = j / 1000;
        for (java.lang.Integer num : y.keySet()) {
            if (this.V.get(num) == null || !this.V.get(num).booleanValue()) {
                if (j2 >= num.intValue()) {
                    this.V.put(num, java.lang.Boolean.TRUE);
                    com.anythink.basead.c.i i = i();
                    i.h.i = num.intValue();
                    com.anythink.basead.a.a.a(32, this.c, i);
                }
            }
        }
    }

    private void e(long j) {
        if (this.D && this.ae == -1) {
            long j2 = this.af;
            if (j2 != 0) {
                this.ae = j;
                if (j2 > 0) {
                    this.ag = j + j2;
                }
                G();
            }
        }
    }

    public static /* synthetic */ void e(com.anythink.basead.ui.BaseScreenATView baseScreenATView) {
        baseScreenATView.ai = true;
        if (baseScreenATView.O() != null) {
            baseScreenATView.O().setVisibility(8);
        }
    }

    public static /* synthetic */ void g(com.anythink.basead.ui.BaseScreenATView baseScreenATView) {
        com.anythink.basead.ui.b bVar = baseScreenATView.O;
        if (bVar != null) {
            bVar.c();
        }
    }

    public static /* synthetic */ void h(com.anythink.basead.ui.BaseScreenATView baseScreenATView) {
        baseScreenATView.t();
        if (baseScreenATView.ak == null) {
            baseScreenATView.ak = new com.anythink.basead.c();
        }
        baseScreenATView.ak.a(baseScreenATView.getContext(), baseScreenATView.c, baseScreenATView.b, baseScreenATView.new AnonymousClass11());
    }

    public void A() {
        if (M() != null) {
            this.J = a(M(), this.b.n.n());
            M().setVisibility(8);
            M().setOnClickListener(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass3());
        }
    }

    public abstract void B();

    public final void C() {
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView == null || !basePlayerView.isPlaying()) {
            return;
        }
        this.L.stop();
        this.L.removeAllViews();
        com.anythink.basead.c.i i = i();
        i.g = j();
        com.anythink.basead.a.a.a(16, this.c, i);
    }

    public final void D() {
        com.anythink.basead.c.i i = i();
        i.g = j();
        com.anythink.basead.a.a.a(7, this.c, i);
        com.anythink.basead.e.h hVar = this.T;
        if (hVar != null) {
            hVar.d();
        }
    }

    public void E() {
        if (O() != null) {
            O().setVisibility(8);
            O().setOnClickListener(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass4());
        }
    }

    public void F() {
        c(0);
        com.anythink.basead.ui.MuteImageView muteImageView = this.S;
        if (muteImageView == null || muteImageView.getVisibility() == 0) {
            return;
        }
        this.S.setVisibility(0);
    }

    public void G() {
        com.anythink.basead.ui.PanelView P = P();
        if (P.getVisibility() != 0) {
            a(104);
            P.setVisibility(0);
        }
    }

    public void H() {
        if (P().getVisibility() != 8) {
            P().setVisibility(8);
        }
    }

    public final void I() {
        if (this.ai || O() == null || O().getVisibility() == 0) {
            return;
        }
        O().setVisibility(0);
    }

    public void J() {
        if (M() != null && M().getVisibility() != 0) {
            M().setVisibility(0);
            M().setClickAreaScaleFactor(this.J);
        }
        I();
    }

    public abstract void K();

    public void L() {
        a(103);
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView != null && basePlayerView.getParent() != null && (this.L.getParent() instanceof android.view.ViewGroup) && (!l() || this.r)) {
            Q();
        }
        c(8);
        if (M() != null) {
            M().setClickAreaScaleFactor(this.J);
        }
        com.anythink.basead.ui.MuteImageView muteImageView = this.S;
        if (muteImageView != null) {
            muteImageView.setVisibility(8);
        }
    }

    public com.anythink.basead.ui.CloseImageView M() {
        return this.Q;
    }

    public final boolean N() {
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView;
        return this.v == 1 && this.F == 101 && (basePlayerView = this.L) != null && (basePlayerView instanceof com.anythink.basead.ui.animplayerview.WebLandpagePlayerView);
    }

    public android.view.ViewGroup O() {
        return this.R;
    }

    public com.anythink.basead.ui.PanelView P() {
        return this.M;
    }

    public void Q() {
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView == null || basePlayerView.getParent() == null) {
            return;
        }
        ((android.view.ViewGroup) this.L.getParent()).removeView(this.L);
        this.L = null;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, int i2) {
        this.J = a(M(), this.b.n.m());
        if (this.aj || this.c == null) {
            return;
        }
        super.a(i, i2);
    }

    public void a(long j) {
        long j2 = this.ag;
        if (j2 >= 0 && j > j2) {
            H();
            return;
        }
        if (this.D) {
            long j3 = this.ae;
            if (j3 < 0 || j < j3) {
                return;
            }
            G();
        }
    }

    public final void a(com.anythink.basead.c.e eVar) {
        com.anythink.basead.e.h hVar = this.T;
        if (hVar != null) {
            hVar.a(eVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(com.anythink.basead.e.i iVar) {
        com.anythink.basead.e.h hVar = this.T;
        if (hVar != null) {
            hVar.b(iVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(boolean z) {
        com.anythink.basead.e.h hVar = this.T;
        if (hVar != null) {
            hVar.a(z);
        }
    }

    public void b() {
        this.K = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_rl_root", "id"));
        this.L = (com.anythink.basead.ui.animplayerview.BasePlayerView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_player_view_id", "id"));
        this.M = (com.anythink.basead.ui.PanelView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_view_id", "id"));
        this.P = (com.anythink.basead.ui.CountDownView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_count_down_view_id", "id"));
        this.S = (com.anythink.basead.ui.MuteImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_btn_mute_id", "id"));
        this.Q = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_btn_close_id", "id"));
        this.R = (android.view.ViewGroup) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_feedback_ll_id", "id"));
        c();
        c(4);
        z();
        A();
        E();
        w();
        this.D = b(this.E);
    }

    public void b(long j) {
        com.anythink.basead.ui.CountDownView countDownView = this.P;
        if (countDownView == null || countDownView.getVisibility() != 0) {
            return;
        }
        this.P.refresh(j);
    }

    public abstract boolean b(int i);

    public void c() {
    }

    public void c(int i) {
        com.anythink.basead.ui.CountDownView countDownView = this.P;
        if (countDownView != null) {
            if (i == 0 && countDownView.getVisibility() == 0) {
                return;
            }
            this.P.setVisibility(i);
        }
    }

    public void c(long j) {
        com.anythink.basead.ui.CountDownView countDownView = this.P;
        if (countDownView != null) {
            countDownView.setDuration(j);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void d() {
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        this.x = i;
        int i2 = displayMetrics.heightPixels;
        this.y = i2;
        this.W = i;
        this.aa = i2;
        v();
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        super.destroy();
        this.T = null;
        com.anythink.basead.ui.BaseEndCardView baseEndCardView = this.N;
        if (baseEndCardView != null) {
            baseEndCardView.a();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void e() {
        int i;
        if (this.T != null) {
            int i2 = this.F;
            if (i2 != 1) {
                i = 3;
                if (i2 != 2) {
                    if (i2 != 3) {
                        i = 5;
                        if (i2 != 4) {
                            i = i2 != 5 ? i2 != 101 ? 1 : 7 : 6;
                        }
                    } else {
                        i = 4;
                    }
                }
            } else {
                i = this.b.n.ak() == 1 ? 2 : 8;
            }
            com.anythink.basead.e.i iVar = new com.anythink.basead.e.i();
            iVar.c = i;
            if ((this instanceof com.anythink.basead.ui.LetterFullScreenATView) || (this instanceof com.anythink.basead.ui.LetterHalfScreenATView)) {
                iVar.d = 1;
            } else {
                iVar.d = 2;
            }
            this.T.a(iVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void f() {
        this.aj = true;
        if (this.O == null) {
            this.O = new com.anythink.basead.ui.b(this.K);
        }
        this.O.b();
    }

    public com.anythink.basead.c.j fillVideoEndRecord(boolean z) {
        com.anythink.basead.c.j jVar = new com.anythink.basead.c.j();
        jVar.l = this.w == 2 ? 4 : 1;
        jVar.r = 1;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        jVar.a = basePlayerView != null ? basePlayerView.getVideoLength() / 1000 : 0L;
        jVar.b = this.B / 1000;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView2 = this.L;
        jVar.c = basePlayerView2 != null ? basePlayerView2.getCurrentPosition() / 1000 : 0L;
        long j = this.B;
        jVar.d = j == 0 ? 1 : 0;
        jVar.o = j == 0 ? 1 : 2;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView3 = this.L;
        jVar.e = (basePlayerView3 == null || basePlayerView3.getCurrentPosition() != this.L.getVideoLength()) ? 0 : 1;
        jVar.u = z ? 0 : 2;
        jVar.f = this.ad;
        jVar.g = java.lang.System.currentTimeMillis();
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView4 = this.L;
        jVar.h = basePlayerView4 != null ? basePlayerView4.getCurrentPosition() : 0L;
        jVar.toString();
        return jVar;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void g() {
        this.aj = false;
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass12());
    }

    public float getCloseButtonScaleFactor() {
        return this.J;
    }

    public long getHideBannerTime() {
        return this.ag;
    }

    public int getPlayerViewType() {
        return this.F;
    }

    public long getShowBannerTime() {
        return this.ae;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final synchronized void h() {
        if (this.b.n.V() > 0) {
            com.anythink.core.common.b.o.a().a(this.U, this.b.n.V());
        } else {
            super.h();
        }
    }

    public boolean hasReward() {
        return this.H;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final com.anythink.basead.c.i i() {
        com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.b.d, this.o);
        iVar.e = getWidth();
        iVar.f = getHeight();
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView != null && basePlayerView.hasVideo()) {
            iVar.h = fillVideoEndRecord(true);
        }
        return iVar;
    }

    public void init() {
        b();
        if (this.G) {
            q();
            return;
        }
        int i = this.v;
        if (1 == i) {
            if (this.F == 100) {
                a((java.util.List<android.graphics.Bitmap>) null);
            } else {
                com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.basead.ui.BaseScreenATView.AnonymousClass5(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass7()), 2, true);
            }
            S();
            return;
        }
        if (3 == i) {
            if (com.anythink.basead.a.d.a(this.c, this.b)) {
                p();
                S();
            } else {
                q();
                if (com.anythink.basead.a.d.b(this.c)) {
                    return;
                }
                h();
            }
        }
    }

    public boolean isShowEndCard() {
        return this.G;
    }

    public boolean isVideoMute() {
        return this.I;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final boolean l() {
        return com.anythink.basead.a.d.a(this.c, this.b);
    }

    @Override // com.anythink.basead.ui.BaseATView
    public android.widget.RelativeLayout.LayoutParams m() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        if (this.w == 2) {
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

    public boolean needHideFeedbackButton() {
        return this.ai;
    }

    public void o() {
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (N()) {
            ((com.anythink.basead.ui.animplayerview.WebLandpagePlayerView) this.L).onActivityResult(i, i2, intent);
        }
    }

    public void p() {
        a(new java.util.ArrayList());
    }

    public void q() {
        a(102);
        this.G = true;
        if (com.anythink.basead.a.d.b(this.c)) {
            if (this.N == null) {
                this.N = b(false);
            }
            K();
            L();
        } else {
            this.E = r();
            com.anythink.basead.ui.EndCardView endCardView = new com.anythink.basead.ui.EndCardView(getContext(), this.c, this.b);
            endCardView.setSize(this.x, this.y);
            endCardView.init(false, false, new com.anythink.basead.ui.BaseScreenATView.AnonymousClass10());
            this.N = endCardView;
            K();
            endCardView.load();
            if (b(this.E)) {
                G();
                com.anythink.basead.ui.PanelView P = P();
                if (P != null && P.getVisibility() == 0) {
                    if (P.getCTAButton() == null || P.getCTAButton().getVisibility() != 0) {
                        this.q = P;
                    } else {
                        this.q = P.getCTAButton();
                    }
                }
            }
        }
        com.anythink.basead.ui.BaseEndCardView baseEndCardView = this.N;
        if (baseEndCardView != null) {
            baseEndCardView.postDelayed(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass8(), a(this.b.n));
        }
        com.anythink.basead.a.a.a(6, this.c, i());
    }

    public abstract int r();

    public final void s() {
        a(110);
        this.ah = true;
        try {
            com.anythink.basead.c cVar = this.ak;
            if (cVar == null || !cVar.a()) {
                ac();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void setCloseButtonScaleFactor(float f) {
        this.J = f;
        if (M() != null) {
            M().setClickAreaScaleFactor(this.J);
        }
    }

    public void setHasReward(boolean z) {
        this.H = z;
    }

    public void setHideBannerTime(long j) {
        this.ag = j;
    }

    public void setHideFeedbackButton(boolean z) {
        this.ai = z;
    }

    public void setIsShowEndCard(boolean z) {
        this.G = z;
    }

    public void setListener(com.anythink.basead.e.h hVar) {
        this.T = hVar;
    }

    public void setShowBannerTime(long j) {
        this.ae = j;
    }

    public void setVideoMute(boolean z) {
        this.I = z;
    }

    public final void t() {
        a(111);
        this.ah = false;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView != null) {
            if (basePlayerView.isPlaying()) {
                com.anythink.basead.a.a.a(11, this.c, i());
            }
            this.L.pause();
        }
    }

    public void u() {
        destroy();
        com.anythink.core.common.b.o.a().d(this.U);
    }

    public void v() {
        java.lang.String x = this.c.x();
        if (android.text.TextUtils.isEmpty(x)) {
            return;
        }
        com.anythink.basead.a.e.a();
        int[] a2 = com.anythink.core.common.o.c.a(com.anythink.basead.a.e.a(1, x));
        if (a2 != null) {
            int i = a2[0];
            this.ab = i;
            int i2 = a2[1];
            this.ac = i2;
            this.W = i;
            this.aa = i2;
        }
    }

    public void w() {
        com.anythink.basead.ui.PanelView panelView = this.M;
        if (panelView != null) {
            panelView.setVisibility(4);
            this.M.init(this.c, this.b, this.w, k(), new com.anythink.basead.ui.BaseScreenATView.AnonymousClass13());
        }
        x();
    }

    public void x() {
    }

    public final boolean y() {
        com.anythink.basead.c cVar = this.ak;
        return (cVar == null || !cVar.a()) && this.ah;
    }

    public void z() {
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
        this.S.setOnClickListener(new com.anythink.basead.ui.BaseScreenATView.AnonymousClass2());
    }
}
