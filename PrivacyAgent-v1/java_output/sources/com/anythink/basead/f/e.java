package com.anythink.basead.f;

/* loaded from: classes12.dex */
public class e extends com.anythink.basead.f.c {
    com.anythink.basead.e.a a;
    com.anythink.core.common.o.a.c k;
    com.anythink.basead.a.b l;
    android.view.View m;
    volatile boolean n;
    android.view.View o;
    android.view.View.OnClickListener p;
    com.anythink.basead.ui.b.a q;
    private final java.lang.String r;

    /* renamed from: com.anythink.basead.f.e$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.f.e eVar = com.anythink.basead.f.e.this;
            android.view.View view2 = eVar.o;
            if (view2 != null && view == view2) {
                com.anythink.basead.f.e.a(eVar, 1, 1);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            android.view.View view3 = eVar.m;
            if (view3 == null || view != view3) {
                com.anythink.basead.f.e.a(eVar, 1, 2);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                com.anythink.basead.f.e.a(eVar, 1, 3);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.basead.f.e$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.a.b.InterfaceC0128b {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        public AnonymousClass2(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a() {
            com.anythink.basead.e.a aVar = com.anythink.basead.f.e.this.a;
            if (aVar != null) {
                aVar.onAdClick(new com.anythink.basead.e.i().a(this.a, this.b));
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a(boolean z) {
            com.anythink.basead.e.a aVar = com.anythink.basead.f.e.this.a;
            if (aVar != null) {
                aVar.onDeeplinkCallback(z);
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final boolean a(java.lang.String str, com.anythink.core.api.IOfferClickHandler iOfferClickHandler) {
            return false;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void b() {
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void c() {
        }
    }

    /* renamed from: com.anythink.basead.f.e$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.core.common.o.a.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.core.common.o.a.a, com.anythink.core.common.o.a.b
        public final void recordImpression(android.view.View view) {
            com.anythink.basead.f.e.this.n();
        }
    }

    /* renamed from: com.anythink.basead.f.e$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.basead.ui.b.b.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.b.b.a
        public final void a(int i, int i2) {
            com.anythink.basead.f.e.a(com.anythink.basead.f.e.this, i, i2);
        }
    }

    /* renamed from: com.anythink.basead.f.e$5, reason: invalid class name */
    public class AnonymousClass5 extends com.anythink.basead.ui.b.a {
        public AnonymousClass5(android.view.ViewGroup viewGroup, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, com.anythink.basead.ui.b.b.a aVar) {
            super(viewGroup, lVar, mVar, 5, aVar);
        }

        @Override // com.anythink.basead.ui.b.a
        public final android.view.ViewGroup.LayoutParams a() {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            if (com.anythink.basead.f.e.this.m != null) {
                layoutParams.gravity = 81;
                layoutParams.setMargins(0, 0, 0, 0);
            }
            return layoutParams;
        }
    }

    public e(android.content.Context context, com.anythink.core.common.f.m mVar, java.lang.String str, boolean z) {
        super(context, mVar, str, z);
        this.r = getClass().getSimpleName();
        this.p = new com.anythink.basead.f.e.AnonymousClass1();
    }

    private void a(int i) {
        com.anythink.basead.ui.b.a aVar = this.q;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private void a(int i, int i2) {
        n();
        if (this.l == null) {
            this.l = new com.anythink.basead.a.b(this.c, this.d, this.g);
        }
        if (this.l.a()) {
            return;
        }
        this.l.a(new com.anythink.basead.f.e.AnonymousClass2(i, i2));
        this.l.a(new com.anythink.basead.c.i(this.d.d, ""));
        a(113);
    }

    private void a(android.view.View view, android.view.View.OnClickListener onClickListener) {
        if (!(view instanceof android.view.ViewGroup)) {
            view.setOnClickListener(onClickListener);
            return;
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            a(viewGroup.getChildAt(i), onClickListener);
        }
    }

    private void a(android.view.View view, android.view.View[] viewArr) {
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), viewArr);
            }
            return;
        }
        if ((view instanceof android.widget.Button) || (view instanceof android.widget.TextView)) {
            java.lang.String charSequence = ((android.widget.TextView) view).getText().toString();
            if (android.text.TextUtils.isEmpty(charSequence) || !android.text.TextUtils.equals(charSequence, g())) {
                return;
            }
            viewArr[0] = view;
        }
    }

    public static /* synthetic */ void a(com.anythink.basead.f.e eVar, int i, int i2) {
        eVar.n();
        if (eVar.l == null) {
            eVar.l = new com.anythink.basead.a.b(eVar.c, eVar.d, eVar.g);
        }
        if (eVar.l.a()) {
            return;
        }
        eVar.l.a(eVar.new AnonymousClass2(i, i2));
        eVar.l.a(new com.anythink.basead.c.i(eVar.d.d, ""));
        eVar.a(113);
    }

    private void b(android.view.View view) {
        this.m = view;
        o();
        com.anythink.basead.f.e.AnonymousClass3 anonymousClass3 = new com.anythink.basead.f.e.AnonymousClass3();
        if (this.k == null) {
            view.getContext();
            this.k = new com.anythink.core.common.o.a.c();
        }
        this.k.a(view, anonymousClass3);
    }

    public static android.view.View k() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.n) {
            return;
        }
        a(114);
        this.n = true;
        com.anythink.basead.f.a.b.a(this.c).a(this.g);
        com.anythink.basead.a.a.a(8, this.g, new com.anythink.basead.c.i(this.d.d, ""));
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdShow(new com.anythink.basead.e.i());
        }
    }

    private void o() {
        com.anythink.core.common.f.z zVar;
        com.anythink.core.common.f.m mVar;
        android.view.View view = this.m;
        if (view == null || !(view instanceof android.view.ViewGroup) || (zVar = this.g) == null || (mVar = this.d) == null) {
            return;
        }
        this.q = new com.anythink.basead.f.e.AnonymousClass5((android.view.ViewGroup) view, zVar, mVar, new com.anythink.basead.f.e.AnonymousClass4());
    }

    @Override // com.anythink.basead.f.a
    public final void a(android.app.Activity activity, java.util.Map<java.lang.String, java.lang.Object> map) {
    }

    public final void a(android.view.View view) {
        b(view);
        a(view, this.p);
    }

    public final void a(android.view.View view, java.util.List<android.view.View> list) {
        b(view);
        if (list == null) {
            view.setOnClickListener(this.p);
            return;
        }
        android.view.View[] viewArr = new android.view.View[1];
        a(view, viewArr);
        android.view.View view2 = viewArr[0];
        if (view2 != null) {
            this.o = view2;
        }
        for (android.view.View view3 : list) {
            if (view3 != null) {
                view3.setOnClickListener(this.p);
            }
        }
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    public final java.lang.String b() {
        com.anythink.core.common.f.z zVar = this.g;
        return zVar != null ? zVar.u() : "";
    }

    public final java.lang.String f() {
        com.anythink.core.common.f.z zVar = this.g;
        return zVar != null ? zVar.v() : "";
    }

    public final java.lang.String g() {
        com.anythink.core.common.f.z zVar = this.g;
        return zVar != null ? zVar.z() : "";
    }

    public final java.lang.String h() {
        com.anythink.core.common.f.z zVar = this.g;
        return zVar != null ? zVar.w() : "";
    }

    public final java.lang.String i() {
        com.anythink.core.common.f.z zVar = this.g;
        return zVar != null ? zVar.x() : "";
    }

    public final java.lang.String j() {
        com.anythink.core.common.f.z zVar = this.g;
        return zVar != null ? zVar.y() : "";
    }

    public final void l() {
        com.anythink.core.common.o.a.c cVar = this.k;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void m() {
        l();
        a(112);
        this.a = null;
        com.anythink.basead.a.b bVar = this.l;
        if (bVar != null) {
            bVar.d();
            this.l = null;
        }
        com.anythink.core.common.o.a.c cVar = this.k;
        if (cVar != null) {
            cVar.b();
            this.k = null;
        }
    }
}
