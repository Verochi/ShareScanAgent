package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseMediaATView extends android.widget.FrameLayout {
    protected com.anythink.core.common.f.l a;
    protected com.anythink.core.common.f.n b;
    protected com.anythink.core.common.f.m c;
    protected com.anythink.basead.ui.BaseMediaATView.a d;
    protected boolean e;
    protected android.widget.FrameLayout f;
    private int g;
    private int h;
    private com.anythink.basead.ui.CloseImageView i;

    /* renamed from: com.anythink.basead.ui.BaseMediaATView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.basead.ui.BaseMediaATView.a aVar = com.anythink.basead.ui.BaseMediaATView.this.d;
            if (aVar != null) {
                aVar.onClickCloseView();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface a {
        void onClickCloseView();
    }

    public BaseMediaATView(android.content.Context context) {
        super(context);
        this.g = 0;
        this.h = 0;
    }

    public BaseMediaATView(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, com.anythink.basead.ui.BaseMediaATView.a aVar) {
        super(context);
        this.g = 0;
        this.h = 0;
        this.a = lVar;
        this.b = mVar.n;
        this.e = z;
        this.d = aVar;
        this.c = mVar;
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "base_myoffer_media_ad_view", "layout"), this);
        this.f = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "base_media_view_content", "id"));
        this.i = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "base_media_ad_close", "id"));
    }

    private void a() {
        com.anythink.basead.ui.CloseImageView closeImageView = this.i;
        if (closeImageView == null) {
            return;
        }
        if (this.e) {
            closeImageView.setVisibility(0);
        } else {
            closeImageView.setVisibility(8);
        }
        a(this.i, this.b.n());
        this.i.setOnClickListener(new com.anythink.basead.ui.BaseMediaATView.AnonymousClass1());
    }

    private static void a(com.anythink.basead.ui.a aVar, int i) {
        if (aVar != null) {
            aVar.setClickAreaScaleFactor(i != 2 ? i != 3 ? i != 4 ? 1.0f : 0.5f : 0.75f : 1.5f);
        }
    }

    public void destroy() {
    }

    public java.util.List<android.view.View> getClickViews() {
        return new java.util.ArrayList();
    }

    public int getMediaViewHeight() {
        return this.h;
    }

    public int getMediaViewWidth() {
        return this.g;
    }

    public android.view.View getMonitorClickView() {
        return null;
    }

    public void init(int i, int i2) {
        this.g = i;
        this.h = i2;
        com.anythink.basead.ui.CloseImageView closeImageView = this.i;
        if (closeImageView != null) {
            if (this.e) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
            a(this.i, this.b.n());
            this.i.setOnClickListener(new com.anythink.basead.ui.BaseMediaATView.AnonymousClass1());
        }
    }

    public void notifyClick() {
        com.anythink.core.common.f.n nVar;
        com.anythink.basead.ui.CloseImageView closeImageView = this.i;
        if (closeImageView == null || (nVar = this.b) == null) {
            return;
        }
        a(closeImageView, nVar.m());
    }
}
