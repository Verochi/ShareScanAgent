package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class LetterFullScreenATView extends com.anythink.basead.ui.FullScreenATView {
    com.anythink.basead.a.c.a ad;
    int ae;
    int af;
    int ag;
    int ah;
    int ai;
    int aj;

    /* renamed from: com.anythink.basead.ui.LetterFullScreenATView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.LetterFullScreenATView.this.a(1, 7);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.LetterFullScreenATView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.LetterFullScreenATView.this.a(1, 1);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public LetterFullScreenATView(android.content.Context context) {
        super(context);
        this.ae = com.anythink.core.common.o.i.a(getContext(), 13.0f);
        this.af = com.anythink.core.common.o.i.a(getContext(), 60.0f);
        this.ag = com.anythink.core.common.o.i.a(getContext(), 53.0f);
        this.ah = com.anythink.core.common.o.i.a(getContext(), 17.0f);
    }

    public LetterFullScreenATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, java.lang.String str, int i, int i2) {
        super(context, mVar, lVar, str, i, i2);
        this.ae = com.anythink.core.common.o.i.a(getContext(), 13.0f);
        this.af = com.anythink.core.common.o.i.a(getContext(), 60.0f);
        this.ag = com.anythink.core.common.o.i.a(getContext(), 53.0f);
        this.ah = com.anythink.core.common.o.i.a(getContext(), 17.0f);
    }

    private void S() {
        this.ae = (this.x - ((int) (((this.y - this.ag) - this.af) * 0.49714285714285716d))) / 2;
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void G() {
        if (b(this.E)) {
            super.G();
        } else {
            P().setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void K() {
        R();
        if (b(this.E)) {
            com.anythink.basead.ui.PanelView P = P();
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) P.getLayoutParams();
            layoutParams.addRule(3, this.N.getId());
            layoutParams.height = -2;
            layoutParams.bottomMargin = this.ad.b();
            layoutParams.addRule(12, 0);
            P.setPadding(0, com.anythink.core.common.o.i.a(getContext(), 30.0f), 0, (((this.ad.b() / 129) * 69) + this.ad.a()) - layoutParams.bottomMargin);
            P.setBackgroundColor(-1);
            this.N.getLayoutParams().height = this.ai;
        } else {
            ((android.widget.RelativeLayout.LayoutParams) this.N.getLayoutParams()).bottomMargin = this.aj;
            this.N.getLayoutParams().height = this.ai;
            this.N.setPadding(0, 0, 0, (this.ad.a() - this.aj) - this.ad.b());
            H();
        }
        this.ad.a(this.K);
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void L() {
        super.L();
        android.graphics.drawable.Drawable b = this.N.b();
        if (b != null) {
            setBackgroundDrawable(b);
        }
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseATView
    public final void a() {
        com.anythink.core.common.f.n nVar;
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_letter_full_screen", "layout"), this);
        setGravity(13);
        com.anythink.core.common.f.m mVar = this.b;
        if (mVar == null || (nVar = mVar.n) == null || nVar.D() != 0) {
            return;
        }
        setOnClickListener(new com.anythink.basead.ui.LetterFullScreenATView.AnonymousClass1());
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void b() {
        this.ae = (this.x - ((int) (((this.y - this.ag) - this.af) * 0.49714285714285716d))) / 2;
        super.b();
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.K.getLayoutParams();
        int i = this.ah;
        layoutParams.setMargins(i, this.af, i, this.ag);
        int i2 = this.ae;
        setPadding(i2, 0, i2, 0);
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final boolean b(int i) {
        if (this.c.j()) {
            return false;
        }
        return (android.text.TextUtils.isEmpty(this.c.w()) && android.text.TextUtils.isEmpty(this.c.u()) && android.text.TextUtils.isEmpty(this.c.v())) ? false : true;
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void c() {
        super.c();
        com.anythink.basead.a.c.a aVar = new com.anythink.basead.a.c.a(getContext());
        this.ad = aVar;
        aVar.a(this.c, new com.anythink.basead.ui.LetterFullScreenATView.AnonymousClass2());
        this.ad.a(this, this.K.getId());
        this.ad.a(this.x - (this.ae * 2));
        this.ai = (this.x - (this.ae * 2)) - (this.ah * 2);
        if (b(this.E)) {
            return;
        }
        this.aj = this.ad.b();
        this.ai = ((this.ai + this.ad.a()) - this.aj) - this.ad.b();
    }

    @Override // com.anythink.basead.ui.BaseScreenATView, com.anythink.basead.ui.BaseATView
    public final android.widget.RelativeLayout.LayoutParams m() {
        int i = (this.ai * 2) / 3;
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, i, 0, 0);
        return layoutParams;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(1140850688);
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final int r() {
        return this.E;
    }

    @Override // com.anythink.basead.ui.FullScreenATView, com.anythink.basead.ui.BaseScreenATView
    public final void x() {
        this.E = 9;
        com.anythink.basead.ui.PanelView P = P();
        if (P != null) {
            P.setLayoutType(this.E);
            ((android.widget.LinearLayout.LayoutParams) P.findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_iv_banner_icon", "id")).getLayoutParams()).bottomMargin = com.anythink.core.common.o.i.a(getContext(), 30.0f);
        }
    }
}
