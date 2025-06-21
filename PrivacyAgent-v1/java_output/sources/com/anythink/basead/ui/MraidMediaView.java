package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MraidMediaView extends com.anythink.basead.ui.BaseMediaATView {
    boolean g;
    boolean h;
    boolean i;
    private com.anythink.basead.ui.MraidContainerView j;
    private com.anythink.basead.ui.MraidMediaView.a k;

    /* renamed from: com.anythink.basead.ui.MraidMediaView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.MraidContainerView.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            com.anythink.basead.ui.MraidMediaView mraidMediaView = com.anythink.basead.ui.MraidMediaView.this;
            mraidMediaView.g = true;
            mraidMediaView.a();
            if (com.anythink.basead.ui.MraidMediaView.this.k != null) {
                com.anythink.basead.ui.MraidMediaView.this.k.a();
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(java.lang.String str) {
            if (com.anythink.basead.ui.MraidMediaView.this.k != null) {
                com.anythink.basead.ui.MraidMediaView.this.k.a(str);
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void c() {
        }
    }

    public interface a {
        void a();

        void a(java.lang.String str);
    }

    public MraidMediaView(android.content.Context context) {
        this(context, null, null, false, null);
    }

    public MraidMediaView(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, com.anythink.basead.ui.BaseMediaATView.a aVar) {
        super(context, lVar, mVar, z, aVar);
    }

    private static void a(java.lang.String str) {
    }

    private void b() {
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.a, this.c, new com.anythink.basead.ui.MraidMediaView.AnonymousClass1());
        this.j = mraidContainerView;
        mraidContainerView.init();
        android.widget.FrameLayout frameLayout = this.f;
        if (frameLayout == null || this.j == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.f.addView(this.j, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public final synchronized void a() {
        if (this.g && this.h && !this.i) {
            this.i = true;
            com.anythink.core.common.n.c.a(this.c, this.a);
        }
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public void destroy() {
        super.destroy();
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.j;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    public void fireAudioVolumeChange(boolean z) {
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.j;
        if (mraidContainerView != null) {
            mraidContainerView.fireAudioVolumeChange(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public void init(int i, int i2) {
        super.init(i, i2);
        com.anythink.basead.ui.MraidContainerView mraidContainerView = new com.anythink.basead.ui.MraidContainerView(getContext(), this.a, this.c, new com.anythink.basead.ui.MraidMediaView.AnonymousClass1());
        this.j = mraidContainerView;
        mraidContainerView.init();
        android.widget.FrameLayout frameLayout = this.f;
        if (frameLayout == null || this.j == null) {
            return;
        }
        frameLayout.removeAllViews();
        this.f.addView(this.j, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.h = true;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.h = false;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.anythink.basead.ui.MraidContainerView mraidContainerView = this.j;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    public void setMraidWebViewListener(com.anythink.basead.ui.MraidMediaView.a aVar) {
        this.k = aVar;
    }
}
