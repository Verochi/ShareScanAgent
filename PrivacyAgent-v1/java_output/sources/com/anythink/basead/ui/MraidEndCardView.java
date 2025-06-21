package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MraidEndCardView extends com.anythink.basead.ui.BaseEndCardView {
    private static java.lang.String g = "MraidEndCardView";
    com.anythink.basead.ui.MraidContainerView e;
    com.anythink.basead.ui.MraidEndCardView.a f;

    /* renamed from: com.anythink.basead.ui.MraidEndCardView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.MraidEndCardView mraidEndCardView = com.anythink.basead.ui.MraidEndCardView.this;
            com.anythink.basead.ui.MraidEndCardView.a aVar = mraidEndCardView.f;
            if (aVar != null) {
                aVar.a(mraidEndCardView.b.D());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.MraidEndCardView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.ui.MraidContainerView.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            com.anythink.basead.ui.MraidEndCardView.a aVar = com.anythink.basead.ui.MraidEndCardView.this.f;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(java.lang.String str) {
            com.anythink.basead.ui.MraidEndCardView.a aVar = com.anythink.basead.ui.MraidEndCardView.this.f;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
            com.anythink.basead.ui.MraidEndCardView.a aVar = com.anythink.basead.ui.MraidEndCardView.this.f;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    public interface a {
        void a();

        void a(java.lang.String str);

        void b();

        void c();
    }

    public MraidEndCardView(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar) {
        super(context, lVar, mVar);
        setId(com.anythink.core.common.o.i.a(getContext(), "myoffer_end_card_id", "id"));
        setBackgroundDrawable(new com.anythink.basead.ui.a.a());
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    public final void a() {
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.e;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    @Override // com.anythink.basead.ui.BaseEndCardView
    public final android.graphics.drawable.Drawable b() {
        return new com.anythink.basead.ui.a.a();
    }

    public void init(boolean z) {
        if (this.c.n.D() == 0) {
            setOnClickListener(new com.anythink.basead.ui.MraidEndCardView.AnonymousClass1());
        }
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.b, this.c, new com.anythink.basead.ui.MraidEndCardView.AnonymousClass2());
        this.e = mraidContainerView;
        mraidContainerView.setBackgroundColor(0);
        this.e.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(this.e);
        this.e.setNeedRegisterVolumeChangeReceiver(true);
        this.e.init();
        if (z) {
            this.e.loadMraidWebView(1);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.e;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    public void setEndCardListener(com.anythink.basead.ui.MraidEndCardView.a aVar) {
        this.f = aVar;
    }
}
