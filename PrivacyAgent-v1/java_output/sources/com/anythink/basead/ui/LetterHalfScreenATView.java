package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class LetterHalfScreenATView extends com.anythink.basead.ui.HalfScreenATView {
    com.anythink.basead.a.c.a ah;
    int ai;
    int aj;

    /* renamed from: com.anythink.basead.ui.LetterHalfScreenATView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.LetterHalfScreenATView.this.a(1, 7);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.LetterHalfScreenATView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.LetterHalfScreenATView.this.a(1, 1);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public LetterHalfScreenATView(android.content.Context context) {
        super(context);
    }

    public LetterHalfScreenATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, int i, int i2) {
        super(context, mVar, lVar, str, i, i2);
        if (this.t != null) {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.anythink.basead.ui.b.e.a.a, 1);
            this.t.a(hashMap);
        }
    }

    private void T() {
        this.ah.a(this.c, new com.anythink.basead.ui.LetterHalfScreenATView.AnonymousClass2());
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void G() {
        if (b(this.E)) {
            super.G();
        } else {
            P().setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void K() {
        this.N.setPadding(this.L.getPaddingLeft(), this.L.getPaddingTop(), this.L.getPaddingRight(), this.L.getPaddingBottom());
        super.K();
    }

    @Override // com.anythink.basead.ui.HalfScreenATView
    public final int R() {
        return 9;
    }

    @Override // com.anythink.basead.ui.HalfScreenATView
    public final void S() {
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.M.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.K.getLayoutParams();
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.L.getLayoutParams();
        int i = this.x;
        int i2 = (i - layoutParams2.leftMargin) - layoutParams2.rightMargin;
        int i3 = this.ai;
        int i4 = i2 - (i3 * 2);
        this.z = i4;
        this.A = i4;
        this.ah.a(i - (i3 * 2));
        int a = this.ah.a();
        layoutParams2.width = -1;
        layoutParams2.height = -2;
        this.K.setLayoutParams(layoutParams2);
        layoutParams3.width = this.z;
        layoutParams3.height = this.A;
        this.L.setLayoutParams(layoutParams3);
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.topMargin = this.A;
        layoutParams.bottomMargin = this.ah.b();
        this.M.setLayoutParams(layoutParams);
        com.anythink.basead.ui.PanelView panelView = this.M;
        panelView.setPadding(panelView.getPaddingLeft(), this.M.getPaddingTop(), this.M.getPaddingRight(), (a - this.ah.b()) + com.anythink.core.common.o.i.a(getContext(), 9.0f));
        if (!b(this.E)) {
            layoutParams3.bottomMargin = this.ah.b();
            layoutParams3.height = (this.A + this.ah.a()) - (this.ah.b() * 2);
            this.L.setLayoutParams(layoutParams3);
            com.anythink.basead.ui.animplayerview.BasePlayerView basePlayerView = this.L;
            basePlayerView.setPadding(basePlayerView.getPaddingLeft(), this.L.getPaddingTop(), this.L.getPaddingRight(), this.ah.a() - (this.ah.b() * 2));
        }
        this.aj = layoutParams3.height;
        this.ah.a(this.K);
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseATView
    public final void a() {
        this.ai = com.anythink.core.common.o.i.a(getContext(), 38.0f);
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_half_screen_letter_vertical", "layout"), this);
        int i = this.ai;
        setPadding(i, 0, i, 0);
        setBackgroundResource(com.anythink.core.common.o.i.a(getContext(), "dailog_background_color", "color"));
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void b() {
        com.anythink.core.common.f.n nVar;
        super.b();
        com.anythink.core.common.f.m mVar = this.b;
        if (mVar == null || (nVar = mVar.n) == null || nVar.D() != 0) {
            return;
        }
        this.K.setOnClickListener(new com.anythink.basead.ui.LetterHalfScreenATView.AnonymousClass1());
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final boolean b(int i) {
        if (this.c.j()) {
            return false;
        }
        return (android.text.TextUtils.isEmpty(this.c.w()) && android.text.TextUtils.isEmpty(this.c.u()) && android.text.TextUtils.isEmpty(this.c.v())) ? false : true;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void c() {
        super.c();
        com.anythink.basead.a.c.a aVar = new com.anythink.basead.a.c.a(getContext());
        this.ah = aVar;
        aVar.a((android.widget.RelativeLayout) this.K.getParent(), this.K.getId());
        this.ah.a(this.c, new com.anythink.basead.ui.LetterHalfScreenATView.AnonymousClass2());
    }

    @Override // com.anythink.basead.ui.HalfScreenATView, com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public final android.widget.RelativeLayout.LayoutParams m() {
        int i = (this.aj * 2) / 3;
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, i, 0, 0);
        return layoutParams;
    }

    @Override // com.anythink.basead.ui.BaseScreenATView
    public final void u() {
        super.u();
        com.anythink.basead.a.c.a aVar = this.ah;
        if (aVar != null) {
            aVar.c();
        }
    }
}
