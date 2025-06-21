package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class HalfScreenATView extends com.anythink.basead.ui.BaseScreenATView {
    public static final java.lang.String TAG = "HalfScreenATView";
    protected final int ad;
    protected final int ae;
    protected final int af;
    protected int ag;
    private android.view.View ah;
    private com.anythink.basead.ui.d.a ai;

    /* renamed from: com.anythink.basead.ui.HalfScreenATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.HalfScreenATView.this.a(i, i2);
        }
    }

    public HalfScreenATView(android.content.Context context) {
        super(context);
        this.ad = 1;
        this.ae = 2;
        this.af = 3;
    }

    public HalfScreenATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, int i, int i2) {
        super(context, mVar, lVar, str, i, i2);
        this.ad = 1;
        this.ae = 2;
        this.af = 3;
        setId(com.anythink.core.common.o.i.a(getContext(), "myoffer_half_screen_view_id", "id"));
        if (mVar != null) {
            this.ai = new com.anythink.basead.ui.d.a(lVar, mVar.n);
        }
    }

    private boolean T() {
        return this.c.j() || this.W <= this.aa;
    }

    private boolean U() {
        return !com.anythink.basead.a.d.a(this.c);
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void B() {
        super.C();
        super.D();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void H() {
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void K() {
        com.anythink.basead.ui.BaseEndCardView baseEndCardView;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView;
        if (this.K == null || (baseEndCardView = this.N) == null || baseEndCardView.getParent() != null || (basePlayerView = this.L) == null) {
            return;
        }
        this.K.addView(this.N, 1, basePlayerView.getLayoutParams());
    }

    public int R() {
        int i = this.ag;
        if (i != 1) {
            return i != 2 ? 4 : 3;
        }
        return 7;
    }

    public void S() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int a;
        android.widget.RelativeLayout relativeLayout;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView;
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.K.getLayoutParams();
        int i6 = layoutParams2.leftMargin;
        int i7 = layoutParams2.rightMargin;
        int i8 = layoutParams2.topMargin;
        int i9 = layoutParams2.bottomMargin;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView2 = this.L;
        android.widget.RelativeLayout.LayoutParams layoutParams3 = basePlayerView2 != null ? (android.widget.RelativeLayout.LayoutParams) basePlayerView2.getLayoutParams() : null;
        int b = com.anythink.core.common.o.i.b(getContext());
        if (b <= 0) {
            b = com.anythink.core.common.o.i.a(getContext(), 25.0f);
        }
        int i10 = this.ag;
        if (i10 == 1) {
            if (this.w == 2) {
                i2 = (this.y - i8) - i9;
                i3 = (int) (i2 * 1.75f);
                i4 = com.anythink.core.common.o.i.a(getContext(), 120.0f);
                if (i8 < b) {
                    layoutParams2.topMargin = (int) (b * 1.1f);
                }
                layoutParams2.width = i3;
                this.K.setLayoutParams(layoutParams2);
            } else if (T()) {
                i3 = (this.x - i6) - i7;
                i2 = (int) (i3 / 0.5714286f);
                i4 = com.anythink.core.common.o.i.a(getContext(), 240.0f);
            } else {
                i3 = (this.x - i6) - i7;
                i2 = (int) (i3 / 1.032258f);
                i4 = com.anythink.core.common.o.i.a(getContext(), 120.0f);
            }
            this.z = i3;
            this.A = i2;
        } else {
            if (i10 != 2) {
                android.view.View findViewById = this.M.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_blank", "id"));
                i = findViewById != null ? ((android.widget.RelativeLayout.LayoutParams) findViewById.getLayoutParams()).topMargin : 0;
                if (this.w == 1) {
                    i3 = (this.x - i6) - i7;
                    i2 = (int) (i3 / 1.032258f);
                    this.z = i3;
                    int i11 = (int) (i3 / 2.0f);
                    this.A = i11;
                    i4 = (i2 - i11) + i;
                } else {
                    if (i8 < b) {
                        i8 = (int) (b * 1.1f);
                        layoutParams2.topMargin = i8;
                    }
                    i2 = (this.y - i8) - i9;
                    i3 = (int) (i2 * 1.032258f);
                    this.z = i3;
                    int i12 = (int) (i3 / 2.0f);
                    this.A = i12;
                    i4 = (i2 - i12) + i;
                    layoutParams2.width = i3;
                    this.K.setLayoutParams(layoutParams2);
                }
            } else {
                if (this.w != 1) {
                    if (i8 < b) {
                        i8 = (int) (b * 1.1f);
                        layoutParams2.topMargin = i8;
                    }
                    i2 = (this.y - i8) - i9;
                    i3 = (int) (i2 * 1.6f);
                    if (this.ai != null && (a = this.x - (com.anythink.core.common.o.i.a(getContext(), 116.0f) * 2)) < i3) {
                        i2 = (int) (a / 1.6f);
                        i3 = a;
                    }
                    this.A = i2;
                    int i13 = (int) (i2 * 0.56f);
                    this.z = i13;
                    i5 = i3 - i13;
                    layoutParams2.width = i3;
                    this.K.setLayoutParams(layoutParams2);
                    i4 = i2;
                    layoutParams2.width = i3;
                    layoutParams2.height = i2;
                    this.K.setLayoutParams(layoutParams2);
                    if (layoutParams3 != null && (basePlayerView = this.L) != null) {
                        layoutParams3.width = this.z;
                        layoutParams3.height = this.A;
                        basePlayerView.setLayoutParams(layoutParams3);
                    }
                    layoutParams.width = i5;
                    layoutParams.height = i4;
                    this.M.setLayoutParams(layoutParams);
                    if ((this.ag != 2 && this.w == 2) || (relativeLayout = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_guide2click_container", "id"))) == null || layoutParams3 == null) {
                        return;
                    }
                    relativeLayout.setLayoutParams(layoutParams3);
                }
                android.view.View findViewById2 = this.M.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_view_blank", "id"));
                i = findViewById2 != null ? ((android.widget.RelativeLayout.LayoutParams) findViewById2.getLayoutParams()).topMargin : 0;
                i3 = (this.x - i6) - i7;
                float f = i3;
                int i14 = (int) (f / 0.5714286f);
                if (this.y < (com.anythink.core.common.o.i.a(getContext(), 28.0f) * 2) + i14) {
                    i4 = (int) (f / 1.8181819f);
                    this.z = i3;
                    this.A = (i14 - i4) + i;
                } else {
                    this.z = i3;
                    int i15 = (int) (i3 / 0.8f);
                    this.A = i15;
                    i4 = (i14 - i15) + i;
                }
                i2 = i14;
            }
        }
        i5 = i3;
        layoutParams2.width = i3;
        layoutParams2.height = i2;
        this.K.setLayoutParams(layoutParams2);
        if (layoutParams3 != null) {
            layoutParams3.width = this.z;
            layoutParams3.height = this.A;
            basePlayerView.setLayoutParams(layoutParams3);
        }
        layoutParams.width = i5;
        layoutParams.height = i4;
        this.M.setLayoutParams(layoutParams);
        if (this.ag != 2) {
        }
        relativeLayout.setLayoutParams(layoutParams3);
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void a() {
        int i = this.ag;
        if (i == 1) {
            this.ah = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_half_screen_empty_info", "layout"), this);
        } else if (i != 2) {
            this.ah = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_half_screen_horizontal", "layout"), this);
        } else {
            this.ah = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_half_screen_vertical", "layout"), this);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public void b() {
        super.b();
        try {
            S();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        com.anythink.basead.ui.d.a aVar = this.ai;
        if (aVar != null) {
            aVar.a(this.E).a(new com.anythink.basead.ui.HalfScreenATView.AnonymousClass1()).a(getContext(), this.ah);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public boolean b(int i) {
        return !this.c.j();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public final void d() {
        super.d();
        if ((!com.anythink.basead.a.d.a(this.c)) || this.c.j()) {
            this.ag = 1;
        } else if (T()) {
            this.ag = 2;
        } else {
            this.ag = 3;
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public android.widget.RelativeLayout.LayoutParams m() {
        android.widget.RelativeLayout relativeLayout = this.K;
        if (relativeLayout == null || this.M == null) {
            return super.m();
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
        int i = (layoutParams.height * 2) / 3;
        com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
        if (basePlayerView != null) {
            i = (((android.widget.RelativeLayout.LayoutParams) basePlayerView.getLayoutParams()).height * 2) / 3;
        } else {
            com.anythink.basead.ui.BaseEndCardView baseEndCardView = this.N;
            if (baseEndCardView != null) {
                i = (((android.widget.RelativeLayout.LayoutParams) baseEndCardView.getLayoutParams()).height * 2) / 3;
            }
        }
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(0, i, (this.ag == 2 && this.w == 2) ? layoutParams2.width + 0 : 0, 0);
        return layoutParams3;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final int n() {
        return 2;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final int r() {
        return this.E;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void v() {
        super.v();
        if (this.c.F() != 1 || this.c.Q() <= 0 || this.c.R() <= 0) {
            return;
        }
        this.W = this.c.Q();
        this.aa = this.c.R();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void x() {
        android.view.View cTAButton;
        super.x();
        int R = R();
        this.E = R;
        com.anythink.basead.ui.PanelView panelView = this.M;
        if (panelView != null) {
            panelView.setLayoutType(R);
            if (this.E == 7 && this.b.n.D() == 0 && (cTAButton = this.M.getCTAButton()) != null) {
                cTAButton.setVisibility(8);
            }
        }
        if (b(this.E)) {
            G();
        } else {
            P().setVisibility(8);
        }
    }
}
