package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ClickToReLoadView extends android.widget.LinearLayout {
    private android.widget.ImageView a;
    private android.widget.TextView b;
    private com.anythink.basead.ui.ClickToReLoadView.a c;
    private int d;

    /* renamed from: com.anythink.basead.ui.ClickToReLoadView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        long a;

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - this.a > 1000) {
                this.a = currentTimeMillis;
                if (com.anythink.basead.ui.ClickToReLoadView.this.c != null) {
                    com.anythink.basead.ui.ClickToReLoadView.this.c.a();
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public interface a {
        void a();
    }

    public ClickToReLoadView(android.content.Context context) {
        super(context);
        setOrientation(1);
        setGravity(17);
        this.d = com.anythink.core.common.o.i.a(context, 10.0f);
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        this.a = imageView;
        imageView.setImageResource(com.anythink.core.common.o.i.a(context, "myoffer_webview_reload_icon", com.anythink.expressad.foundation.h.i.c));
        int a2 = com.anythink.core.common.o.i.a(context, 30.0f);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = this.d;
        android.widget.TextView textView = new android.widget.TextView(context);
        this.b = textView;
        textView.setText(getResources().getText(com.anythink.core.common.o.i.a(context, "myoffer_webview_reload", com.anythink.expressad.foundation.h.i.g)));
        this.b.setTextColor(getResources().getColor(com.anythink.core.common.o.i.a(context, "color_reload_button", "color")));
        this.b.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_webview_bg_reload_button", com.anythink.expressad.foundation.h.i.c));
        int a3 = com.anythink.core.common.o.i.a(context, 9.0f);
        int a4 = com.anythink.core.common.o.i.a(context, 5.0f);
        this.b.setPadding(a3, a4, a3, a4);
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = this.d;
        addView(this.a, layoutParams);
        addView(this.b, layoutParams2);
        this.b.setOnClickListener(new com.anythink.basead.ui.ClickToReLoadView.AnonymousClass1());
    }

    private void a() {
        this.b.setOnClickListener(new com.anythink.basead.ui.ClickToReLoadView.AnonymousClass1());
    }

    private void a(android.content.Context context) {
        setOrientation(1);
        setGravity(17);
        this.d = com.anythink.core.common.o.i.a(context, 10.0f);
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        this.a = imageView;
        imageView.setImageResource(com.anythink.core.common.o.i.a(context, "myoffer_webview_reload_icon", com.anythink.expressad.foundation.h.i.c));
        int a2 = com.anythink.core.common.o.i.a(context, 30.0f);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = this.d;
        android.widget.TextView textView = new android.widget.TextView(context);
        this.b = textView;
        textView.setText(getResources().getText(com.anythink.core.common.o.i.a(context, "myoffer_webview_reload", com.anythink.expressad.foundation.h.i.g)));
        this.b.setTextColor(getResources().getColor(com.anythink.core.common.o.i.a(context, "color_reload_button", "color")));
        this.b.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_webview_bg_reload_button", com.anythink.expressad.foundation.h.i.c));
        int a3 = com.anythink.core.common.o.i.a(context, 9.0f);
        int a4 = com.anythink.core.common.o.i.a(context, 5.0f);
        this.b.setPadding(a3, a4, a3, a4);
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = this.d;
        addView(this.a, layoutParams);
        addView(this.b, layoutParams2);
    }

    private void b() {
        try {
            this.a.setVisibility(8);
            android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.b.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = 0;
                this.b.setLayoutParams(layoutParams);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getHeight() < com.anythink.core.common.o.i.a(getContext(), 100.0f)) {
            try {
                this.a.setVisibility(8);
                android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.b.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                    this.b.setLayoutParams(layoutParams);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public void setListener(com.anythink.basead.ui.ClickToReLoadView.a aVar) {
        this.c = aVar;
    }
}
