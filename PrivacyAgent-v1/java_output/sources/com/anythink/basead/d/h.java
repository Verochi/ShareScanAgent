package com.anythink.basead.d;

/* loaded from: classes12.dex */
public class h {
    android.content.Context a;
    com.anythink.basead.e.a b;
    com.anythink.core.common.o.a.c c;
    com.anythink.basead.a.b d;
    android.view.View e;
    volatile boolean f;
    com.anythink.core.common.f.ai g;
    com.anythink.core.common.f.m h;
    boolean i;
    boolean j;
    java.lang.String k;
    com.anythink.expressad.advanced.d.c l;
    com.anythink.basead.ui.BaseMediaATView m;
    android.view.View n;
    int p;
    int q;
    com.anythink.basead.ui.b.a r;

    /* renamed from: s, reason: collision with root package name */
    com.anythink.basead.ui.OwnNativeATView f147s;
    private final java.lang.String t = getClass().getSimpleName();
    android.view.View.OnClickListener o = new com.anythink.basead.d.h.AnonymousClass1();

    /* renamed from: com.anythink.basead.d.h$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.d.h hVar = com.anythink.basead.d.h.this;
            android.view.View view2 = hVar.n;
            if (view2 != null && view == view2) {
                hVar.a(view, 1, 1);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            android.view.View view3 = hVar.e;
            if (view3 == null || view != view3) {
                hVar.a(view, 1, 2);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } else {
                hVar.a(view, 1, 3);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.basead.d.h$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.a.b.InterfaceC0128b {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        public AnonymousClass2(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.h.this.b;
            if (aVar != null) {
                aVar.onAdClick(new com.anythink.basead.e.i().a(this.a, this.b));
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void a(boolean z) {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.h.this.b;
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
            com.anythink.basead.ui.BaseMediaATView baseMediaATView = com.anythink.basead.d.h.this.m;
            if (baseMediaATView != null) {
                baseMediaATView.notifyClick();
            }
        }

        @Override // com.anythink.basead.a.b.InterfaceC0128b
        public final void c() {
        }
    }

    /* renamed from: com.anythink.basead.d.h$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.out.o {

        /* renamed from: com.anythink.basead.d.h$3$1, reason: invalid class name */
        public class AnonymousClass1 implements com.anythink.basead.a.b.InterfaceC0128b {
            public AnonymousClass1() {
            }

            @Override // com.anythink.basead.a.b.InterfaceC0128b
            public final void a() {
                com.anythink.basead.e.a aVar = com.anythink.basead.d.h.this.b;
                if (aVar != null) {
                    aVar.onAdClick(new com.anythink.basead.e.i().a(1, 13));
                }
            }

            @Override // com.anythink.basead.a.b.InterfaceC0128b
            public final void a(boolean z) {
                com.anythink.basead.e.a aVar = com.anythink.basead.d.h.this.b;
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

        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.out.o
        public final void a() {
        }

        @Override // com.anythink.expressad.out.o
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            com.anythink.basead.d.h hVar = com.anythink.basead.d.h.this;
            if (hVar.d == null) {
                hVar.d = new com.anythink.basead.a.b(f, hVar.h, hVar.g);
                com.anythink.basead.d.h.this.d.a(new com.anythink.basead.d.h.AnonymousClass3.AnonymousClass1());
            }
            com.anythink.basead.d.a.b.a(com.anythink.basead.d.h.this.d.b(), cVar);
            com.anythink.expressad.advanced.d.c cVar2 = com.anythink.basead.d.h.this.l;
            com.anythink.expressad.advanced.view.ATOutNativeAdvancedViewGroup c = cVar2 != null ? cVar2.c() : null;
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(com.anythink.basead.d.h.this.h.d, "");
            if (c != null) {
                iVar.f = c.getHeight();
                iVar.e = c.getWidth();
            }
            iVar.g = new com.anythink.basead.c.a();
            com.anythink.basead.d.h.this.d.a(iVar);
        }

        @Override // com.anythink.expressad.out.o
        public final void a(java.lang.String str) {
        }

        @Override // com.anythink.expressad.out.o
        public final void b() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.h.this.b;
            if (aVar != null) {
                aVar.onAdShow(new com.anythink.basead.e.i());
            }
        }

        @Override // com.anythink.expressad.out.o
        public final void c() {
        }

        @Override // com.anythink.expressad.out.o
        public final void d() {
        }

        @Override // com.anythink.expressad.out.o
        public final void e() {
        }

        @Override // com.anythink.expressad.out.o
        public final void f() {
            com.anythink.basead.e.a aVar = com.anythink.basead.d.h.this.b;
            if (aVar != null) {
                aVar.onAdClosed();
            }
        }
    }

    /* renamed from: com.anythink.basead.d.h$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.basead.ui.MraidMediaView.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.basead.ui.MraidMediaView.a
        public final void a() {
            com.anythink.basead.d.h hVar = com.anythink.basead.d.h.this;
            com.anythink.basead.ui.OwnNativeATView ownNativeATView = hVar.f147s;
            if (ownNativeATView != null) {
                hVar.b(ownNativeATView);
            }
        }

        @Override // com.anythink.basead.ui.MraidMediaView.a
        public final void a(java.lang.String str) {
            com.anythink.core.common.f.ai aiVar = com.anythink.basead.d.h.this.g;
            if (aiVar != null) {
                aiVar.w(str);
            }
            com.anythink.basead.d.h hVar = com.anythink.basead.d.h.this;
            hVar.a(hVar.m, 1, 13);
        }
    }

    /* renamed from: com.anythink.basead.d.h$5, reason: invalid class name */
    public class AnonymousClass5 extends com.anythink.core.common.o.a.a {
        public AnonymousClass5() {
        }

        @Override // com.anythink.core.common.o.a.a, com.anythink.core.common.o.a.b
        public final void recordImpression(android.view.View view) {
            com.anythink.basead.d.h.this.u();
        }
    }

    /* renamed from: com.anythink.basead.d.h$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.basead.ui.b.b.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.basead.ui.b.b.a
        public final void a(int i, int i2) {
            com.anythink.basead.d.h hVar = com.anythink.basead.d.h.this;
            hVar.a(com.anythink.basead.d.h.b(hVar), i, i2);
        }
    }

    /* renamed from: com.anythink.basead.d.h$7, reason: invalid class name */
    public class AnonymousClass7 extends com.anythink.basead.ui.b.a {
        public AnonymousClass7(android.view.ViewGroup viewGroup, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, int i, com.anythink.basead.ui.b.b.a aVar) {
            super(viewGroup, lVar, mVar, i, aVar);
        }

        @Override // com.anythink.basead.ui.b.a
        public final android.view.ViewGroup.LayoutParams a() {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
            if (com.anythink.basead.d.h.this.f147s != null) {
                layoutParams.gravity = 81;
                layoutParams.setMargins(0, 0, 0, 0);
            }
            return layoutParams;
        }
    }

    /* renamed from: com.anythink.basead.d.h$8, reason: invalid class name */
    public class AnonymousClass8 implements com.anythink.basead.ui.OwnNativeATView.a {
        public AnonymousClass8() {
        }

        @Override // com.anythink.basead.ui.OwnNativeATView.a
        public final void a() {
            com.anythink.basead.d.h.this.b(110);
        }

        @Override // com.anythink.basead.ui.OwnNativeATView.a
        public final void b() {
            com.anythink.basead.d.h.this.b(111);
        }
    }

    public static class a implements com.anythink.basead.ui.BaseMediaATView.a {
        private final com.anythink.basead.ui.BaseMediaATView.a a;

        public a(com.anythink.basead.ui.BaseMediaATView.a aVar) {
            this.a = aVar;
        }

        @Override // com.anythink.basead.ui.BaseMediaATView.a
        public final void onClickCloseView() {
            com.anythink.basead.ui.BaseMediaATView.a aVar = this.a;
            if (aVar != null) {
                aVar.onClickCloseView();
            }
        }
    }

    public h(android.content.Context context, com.anythink.core.common.f.ai aiVar, com.anythink.core.common.f.m mVar, com.anythink.core.common.a.h hVar, boolean z) {
        this.a = context.getApplicationContext();
        this.g = aiVar;
        this.h = mVar;
        this.i = z;
        if (hVar instanceof com.anythink.expressad.advanced.d.c) {
            com.anythink.expressad.advanced.d.c cVar = (com.anythink.expressad.advanced.d.c) hVar;
            this.l = cVar;
            cVar.a(new com.anythink.basead.d.h.AnonymousClass3());
        }
    }

    private static int a(int i) {
        java.util.Random random = new java.util.Random();
        if (i <= 0) {
            return 0;
        }
        double d = i;
        int i2 = (int) (0.1d * d);
        return random.nextInt((((int) (d * 0.9d)) - i2) + 1) + i2;
    }

    private android.view.View a(android.content.Context context, com.anythink.core.common.f.l lVar) {
        com.anythink.basead.ui.SimpleMediaATView simpleMediaATView = new com.anythink.basead.ui.SimpleMediaATView(context);
        simpleMediaATView.initView(lVar);
        simpleMediaATView.setOnClickListener(this.o);
        return simpleMediaATView;
    }

    private android.view.View a(android.content.Context context, boolean z, boolean z2, com.anythink.basead.ui.BaseMediaATView.a aVar) {
        com.anythink.basead.d.h.a aVar2 = new com.anythink.basead.d.h.a(aVar);
        com.anythink.basead.ui.OwnNativeATView ownNativeATView = new com.anythink.basead.ui.OwnNativeATView(this.a);
        this.f147s = ownNativeATView;
        if (z) {
            com.anythink.basead.ui.MraidMediaView mraidMediaView = new com.anythink.basead.ui.MraidMediaView(context, this.g, this.h, z2, aVar2);
            this.m = mraidMediaView;
            mraidMediaView.setMraidWebViewListener(new com.anythink.basead.d.h.AnonymousClass4());
        } else {
            this.m = new com.anythink.basead.ui.MediaATView(context, this.g, this.h, z2, aVar2);
        }
        this.m.init(this.p, this.q);
        ownNativeATView.addView(this.m, new android.widget.FrameLayout.LayoutParams(this.m.getMediaViewWidth(), this.m.getMediaViewHeight()));
        a(ownNativeATView, this.m.getClickViews());
        return ownNativeATView;
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
        if (((view instanceof android.widget.Button) || (view instanceof android.widget.TextView)) && android.text.TextUtils.equals(((android.widget.TextView) view).getText().toString(), this.g.z())) {
            viewArr[0] = view;
        }
    }

    private void a(com.anythink.basead.ui.OwnNativeATView[] ownNativeATViewArr, android.view.View view) {
        if (view instanceof android.view.ViewGroup) {
            if (view instanceof com.anythink.basead.ui.OwnNativeATView) {
                ownNativeATViewArr[0] = (com.anythink.basead.ui.OwnNativeATView) view;
            }
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(ownNativeATViewArr, viewGroup.getChildAt(i));
            }
        }
    }

    public static /* synthetic */ android.view.View b(com.anythink.basead.d.h hVar) {
        android.view.View monitorClickView;
        com.anythink.basead.ui.BaseMediaATView baseMediaATView = hVar.m;
        if (baseMediaATView != null && (monitorClickView = baseMediaATView.getMonitorClickView()) != null) {
            hVar.n = monitorClickView;
            return monitorClickView;
        }
        android.view.View[] viewArr = new android.view.View[1];
        hVar.a(hVar.f147s, viewArr);
        android.view.View view = viewArr[0];
        if (view == null) {
            return hVar.f147s;
        }
        hVar.n = view;
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.anythink.basead.ui.b.a aVar = this.r;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private static com.anythink.basead.c.a c(android.view.View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        int a2 = a(width);
        int a3 = a(height);
        com.anythink.basead.c.a aVar = new com.anythink.basead.c.a();
        int i3 = i + a2;
        aVar.a = i3;
        aVar.b = i2 + a3;
        aVar.e = a2;
        aVar.f = a3;
        aVar.c = i3 + ((int) (java.lang.Math.random() * 15.0d));
        int random = aVar.b + ((int) (java.lang.Math.random() * 15.0d));
        aVar.d = random;
        aVar.g = aVar.c - i;
        aVar.h = random - i2;
        return aVar;
    }

    private boolean d(android.view.View view) {
        if (this.f147s == null) {
            com.anythink.basead.ui.OwnNativeATView[] ownNativeATViewArr = new com.anythink.basead.ui.OwnNativeATView[1];
            a(ownNativeATViewArr, view);
            com.anythink.basead.ui.OwnNativeATView ownNativeATView = ownNativeATViewArr[0];
            if (ownNativeATView == null || ownNativeATView.getChildCount() == 0) {
                return false;
            }
            this.f147s = ownNativeATViewArr[0];
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.j && this.g.j()) {
            com.anythink.basead.ui.BaseMediaATView baseMediaATView = this.m;
            if (baseMediaATView instanceof com.anythink.basead.ui.MraidMediaView) {
                ((com.anythink.basead.ui.MraidMediaView) baseMediaATView).fireAudioVolumeChange(this.j);
            }
        }
        if (this.g instanceof com.anythink.core.common.f.ah) {
            com.anythink.basead.d.c.d a2 = com.anythink.basead.d.c.d.a();
            android.content.Context context = this.a;
            com.anythink.core.common.f.m mVar = this.h;
            a2.a(context, com.anythink.basead.d.c.d.a(mVar.b, mVar.c), this.g, this.h.n);
        }
        com.anythink.expressad.advanced.d.c cVar = this.l;
        android.view.View c = cVar != null ? cVar.c() : this.f147s;
        if (this.g.j()) {
            c = this.m;
        }
        if (c != null) {
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.h.d, "");
            iVar.f = c.getHeight();
            iVar.e = c.getWidth();
            com.anythink.basead.a.a.a(8, this.g, iVar);
            com.anythink.basead.e.a aVar = this.b;
            if (aVar != null) {
                aVar.onAdShow(new com.anythink.basead.e.i());
            }
        }
        b(114);
    }

    private android.view.View v() {
        android.view.View monitorClickView;
        com.anythink.basead.ui.BaseMediaATView baseMediaATView = this.m;
        if (baseMediaATView != null && (monitorClickView = baseMediaATView.getMonitorClickView()) != null) {
            this.n = monitorClickView;
            return monitorClickView;
        }
        android.view.View[] viewArr = new android.view.View[1];
        a(this.f147s, viewArr);
        android.view.View view = viewArr[0];
        if (view == null) {
            return this.f147s;
        }
        this.n = view;
        return view;
    }

    private void w() {
        com.anythink.basead.ui.OwnNativeATView ownNativeATView;
        com.anythink.core.common.f.ai aiVar;
        com.anythink.core.common.f.m mVar;
        if (this.l != null || (ownNativeATView = this.f147s) == null || (aiVar = this.g) == null || (mVar = this.h) == null) {
            return;
        }
        this.r = new com.anythink.basead.d.h.AnonymousClass7(ownNativeATView, aiVar, mVar, this.i ? 5 : 6, new com.anythink.basead.d.h.AnonymousClass6());
        this.f147s.setLifeCallback(new com.anythink.basead.d.h.AnonymousClass8());
    }

    public final android.view.View a(android.content.Context context, boolean z, com.anythink.basead.ui.BaseMediaATView.a aVar) {
        com.anythink.expressad.advanced.d.c cVar = this.l;
        if (cVar != null) {
            cVar.a(z ? 1 : 0);
            return this.l.c();
        }
        com.anythink.core.common.f.ai aiVar = this.g;
        if (aiVar != null && aiVar.j() && this.i) {
            return a(context, true, z, aVar);
        }
        com.anythink.core.common.f.ai aiVar2 = this.g;
        if (aiVar2 == null || android.text.TextUtils.isEmpty(aiVar2.x())) {
            return null;
        }
        boolean z2 = this.i;
        if (z2 && (this.g instanceof com.anythink.core.common.f.j)) {
            return a(context, false, z, aVar);
        }
        if (!z2) {
            com.anythink.core.common.f.ai aiVar3 = this.g;
            if (aiVar3 instanceof com.anythink.core.common.f.j) {
                com.anythink.basead.ui.SimpleMediaATView simpleMediaATView = new com.anythink.basead.ui.SimpleMediaATView(context);
                simpleMediaATView.initView(aiVar3);
                simpleMediaATView.setOnClickListener(this.o);
                return simpleMediaATView;
            }
        }
        return null;
    }

    public final com.anythink.core.common.f.l a() {
        return this.g;
    }

    public final void a(int i, int i2) {
        this.p = i;
        this.q = i2;
        com.anythink.expressad.advanced.d.c cVar = this.l;
        if (cVar != null) {
            cVar.a(i2, i);
        }
    }

    public final void a(android.view.View view) {
        a(view, (java.util.List<android.view.View>) null);
    }

    public final void a(android.view.View view, int i, int i2) {
        com.anythink.basead.c.a aVar;
        if (this.f147s != null) {
            u();
            if (this.d == null) {
                this.d = new com.anythink.basead.a.b(com.anythink.core.common.b.o.a().f(), this.h, this.g);
            }
            if (this.d.a()) {
                return;
            }
            this.d.a(new com.anythink.basead.d.h.AnonymousClass2(i, i2));
            com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.h.d, "");
            iVar.f = this.f147s.getHeight();
            iVar.e = this.f147s.getWidth();
            if (i == 1) {
                aVar = this.f147s.getAdClickRecord();
            } else if (view == null) {
                aVar = null;
            } else {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int i3 = iArr[0];
                int i4 = iArr[1];
                int width = view.getWidth();
                int height = view.getHeight();
                int a2 = a(width);
                int a3 = a(height);
                com.anythink.basead.c.a aVar2 = new com.anythink.basead.c.a();
                int i5 = i3 + a2;
                aVar2.a = i5;
                aVar2.b = i4 + a3;
                aVar2.e = a2;
                aVar2.f = a3;
                aVar2.c = i5 + ((int) (java.lang.Math.random() * 15.0d));
                int random = aVar2.b + ((int) (java.lang.Math.random() * 15.0d));
                aVar2.d = random;
                aVar2.g = aVar2.c - i3;
                aVar2.h = random - i4;
                aVar = aVar2;
            }
            iVar.g = aVar;
            this.d.a(iVar);
            b(113);
        }
    }

    public final void a(android.view.View view, java.util.List<android.view.View> list) {
        com.anythink.basead.ui.OwnNativeATView ownNativeATView;
        com.anythink.core.common.f.ai aiVar;
        com.anythink.core.common.f.m mVar;
        boolean z = true;
        if (this.f147s == null) {
            com.anythink.basead.ui.OwnNativeATView[] ownNativeATViewArr = new com.anythink.basead.ui.OwnNativeATView[1];
            a(ownNativeATViewArr, view);
            com.anythink.basead.ui.OwnNativeATView ownNativeATView2 = ownNativeATViewArr[0];
            if (ownNativeATView2 == null || ownNativeATView2.getChildCount() == 0) {
                z = false;
            } else {
                this.f147s = ownNativeATViewArr[0];
            }
        }
        if (z) {
            com.anythink.core.common.f.ai aiVar2 = this.g;
            if (aiVar2 != null && !aiVar2.j()) {
                b(view);
                if (list == null || list.size() <= 0) {
                    a(view, this.o);
                } else {
                    for (android.view.View view2 : list) {
                        if (view2 != null) {
                            view2.setOnClickListener(this.o);
                        }
                    }
                }
            }
            if (this.l != null || (ownNativeATView = this.f147s) == null || (aiVar = this.g) == null || (mVar = this.h) == null) {
                return;
            }
            this.r = new com.anythink.basead.d.h.AnonymousClass7(ownNativeATView, aiVar, mVar, this.i ? 5 : 6, new com.anythink.basead.d.h.AnonymousClass6());
            this.f147s.setLifeCallback(new com.anythink.basead.d.h.AnonymousClass8());
        }
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.b = aVar;
    }

    public final void a(java.lang.String str) {
        this.k = str;
        if (this.l != null) {
            if (android.text.TextUtils.isEmpty(str)) {
                this.l.c(3);
                return;
            }
            java.lang.String str2 = this.k;
            str2.hashCode();
            switch (str2) {
                case "1":
                    this.l.c(3);
                    break;
                case "2":
                    this.l.c(1);
                    break;
                case "3":
                    this.l.c(2);
                    break;
            }
        }
    }

    public final void a(boolean z) {
        this.j = z;
        com.anythink.expressad.advanced.d.c cVar = this.l;
        if (cVar != null) {
            cVar.b(z ? 1 : 2);
        }
    }

    public final boolean a(boolean z, boolean z2) {
        if (this.g.q() != 67) {
            return false;
        }
        return this.g.a(z, z2);
    }

    public final java.lang.String b() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.u() : "";
    }

    public final void b(android.view.View view) {
        this.e = view;
        com.anythink.basead.d.h.AnonymousClass5 anonymousClass5 = new com.anythink.basead.d.h.AnonymousClass5();
        if (this.c == null) {
            view.getContext();
            this.c = new com.anythink.core.common.o.a.c(this.h.n.V() <= 0 ? 100 : this.h.n.V());
        }
        this.c.a(view, anonymousClass5);
    }

    public final java.lang.String c() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.v() : "";
    }

    public final java.lang.String d() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.z() : "";
    }

    public final java.lang.String e() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.w() : "";
    }

    public final java.lang.String f() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.x() : "";
    }

    public final java.lang.String g() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.y() : "";
    }

    public final java.lang.String h() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.ag() : "";
    }

    public final java.lang.String i() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.I() : "";
    }

    public final java.lang.String j() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.L() : "";
    }

    public final java.lang.String k() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.K() : "";
    }

    public final java.lang.String l() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.J() : "";
    }

    public final java.lang.String m() {
        com.anythink.core.common.f.ai aiVar = this.g;
        return aiVar != null ? aiVar.e() : "";
    }

    public final boolean n() {
        com.anythink.core.common.f.ai aiVar = this.g;
        if (aiVar != null) {
            return (android.text.TextUtils.isEmpty(aiVar.I()) && android.text.TextUtils.isEmpty(this.g.ag()) && android.text.TextUtils.isEmpty(this.g.L()) && android.text.TextUtils.isEmpty(this.g.K()) && android.text.TextUtils.isEmpty(this.g.e()) && android.text.TextUtils.isEmpty(this.g.J())) ? false : true;
        }
        return false;
    }

    public final boolean o() {
        return this.i || this.l != null;
    }

    public final void p() {
        com.anythink.core.common.o.a.c cVar = this.c;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void q() {
        p();
        b(112);
        this.e = null;
        this.f147s = null;
        this.b = null;
        try {
            com.anythink.expressad.advanced.d.c cVar = this.l;
            if (cVar != null) {
                cVar.e();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        com.anythink.basead.a.b bVar = this.d;
        if (bVar != null) {
            bVar.d();
            this.d = null;
        }
        com.anythink.core.common.o.a.c cVar2 = this.c;
        if (cVar2 != null) {
            cVar2.b();
            this.c = null;
        }
        com.anythink.basead.ui.BaseMediaATView baseMediaATView = this.m;
        if (baseMediaATView != null) {
            baseMediaATView.destroy();
        }
    }

    public final void r() {
        com.anythink.expressad.advanced.d.c cVar = this.l;
        if (cVar != null) {
            cVar.d(3);
        }
    }

    public final void s() {
        com.anythink.expressad.advanced.d.c cVar = this.l;
        if (cVar != null) {
            cVar.e(3);
        }
    }

    public final int t() {
        com.anythink.expressad.advanced.d.c cVar = this.l;
        if (cVar == null) {
            return 2;
        }
        return cVar.f();
    }
}
