package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseBannerATView extends com.anythink.basead.ui.BaseATView {
    public final java.lang.String TAG;
    protected com.anythink.basead.e.a v;
    protected com.anythink.basead.ui.CloseImageView w;
    android.view.View x;
    private com.anythink.basead.ui.d.b y;

    /* renamed from: com.anythink.basead.ui.BaseBannerATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.BaseBannerATView.this.a(i, i2);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseBannerATView$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.BaseBannerATView.super.h();
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseBannerATView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.e.a aVar = com.anythink.basead.ui.BaseBannerATView.this.v;
            if (aVar != null) {
                aVar.onAdClosed();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public BaseBannerATView(android.content.Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
    }

    public BaseBannerATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar);
        this.TAG = getClass().getSimpleName();
        this.v = aVar;
        if (mVar != null) {
            if (lVar == null || !lVar.O()) {
                com.anythink.core.common.f.n nVar = mVar.n;
                if (nVar != null && nVar.am()) {
                    com.anythink.basead.ui.d.b bVar = new com.anythink.basead.ui.d.b();
                    this.y = bVar;
                    bVar.a(true).a(new com.anythink.basead.ui.BaseBannerATView.AnonymousClass1());
                } else {
                    com.anythink.basead.ui.d.b bVar2 = this.y;
                    if (bVar2 != null) {
                        bVar2.a(false);
                    }
                }
            }
        }
    }

    private void a(com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar) {
        if (mVar != null) {
            if (lVar == null || !lVar.O()) {
                com.anythink.core.common.f.n nVar = mVar.n;
                if (nVar != null && nVar.am()) {
                    com.anythink.basead.ui.d.b bVar = new com.anythink.basead.ui.d.b();
                    this.y = bVar;
                    bVar.a(true).a(new com.anythink.basead.ui.BaseBannerATView.AnonymousClass1());
                } else {
                    com.anythink.basead.ui.d.b bVar2 = this.y;
                    if (bVar2 != null) {
                        bVar2.a(false);
                    }
                }
            }
        }
    }

    private boolean o() {
        if (this.x == null) {
            this.x = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_guide2click_container", "id"));
        }
        android.view.View view = this.x;
        return view != null && view.getVisibility() == 0;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, int i2) {
        super.a(i, i2);
        a(this.w, this.b.n.m());
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(com.anythink.basead.e.i iVar) {
        com.anythink.basead.e.a aVar = this.v;
        if (aVar != null) {
            aVar.onAdClick(iVar);
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(boolean z) {
        com.anythink.basead.e.a aVar = this.v;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    public void b() {
        a(this.b.n.V() < 0 ? 100 : this.b.n.V(), new com.anythink.basead.ui.BaseBannerATView.AnonymousClass2());
    }

    public void c() {
        this.w.setOnClickListener(new com.anythink.basead.ui.BaseBannerATView.AnonymousClass3());
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void e() {
        com.anythink.basead.e.a aVar = this.v;
        if (aVar != null) {
            aVar.onAdShow(new com.anythink.basead.e.i());
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final android.widget.RelativeLayout.LayoutParams m() {
        int measuredHeight = getMeasuredHeight() - com.anythink.core.common.o.i.a(getContext(), 12.0f);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, measuredHeight, 0, 0);
        return layoutParams;
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final int n() {
        return 4;
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        com.anythink.basead.ui.d.b bVar;
        return (o() || (bVar = this.y) == null) ? super.onInterceptTouchEvent(motionEvent) : bVar.a(motionEvent);
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.anythink.basead.ui.d.b bVar;
        return (o() || (bVar = this.y) == null) ? super.onTouchEvent(motionEvent) : bVar.a(this, motionEvent);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (android.os.Build.VERSION.SDK_INT >= 24) {
            if (z) {
                a(110);
            } else {
                a(111);
            }
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (android.os.Build.VERSION.SDK_INT < 24) {
            if (i == 0) {
                a(110);
            } else {
                a(111);
            }
        }
    }
}
