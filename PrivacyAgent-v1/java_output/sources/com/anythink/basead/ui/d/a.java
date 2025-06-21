package com.anythink.basead.ui.d;

/* loaded from: classes12.dex */
public final class a {
    public static final int a = -100;
    public static final int b = -101;
    public static final int c = -102;
    private final com.anythink.core.common.f.l<?> d;
    private final com.anythink.core.common.f.n e;
    private int f;
    private android.view.View g;
    private android.view.View h;
    private android.view.View i;
    private android.view.View j;
    private android.view.View k;
    private android.view.View l;
    private android.view.View m;
    private android.view.View n;
    private com.anythink.basead.ui.c.a o;

    /* renamed from: com.anythink.basead.ui.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.basead.ui.d.a.this.o != null) {
                com.anythink.basead.ui.d.a.this.o.a(10, 14);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.d.a$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.basead.ui.d.a.this.o != null) {
                com.anythink.basead.ui.d.a.this.o.a(10, 14);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.d.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.ui.d.a.this.l != null) {
                com.anythink.basead.ui.d.a.this.l.setVisibility(8);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.d.a$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.basead.ui.d.a.this.l != null) {
                com.anythink.basead.ui.d.a.this.l.setVisibility(0);
            }
        }
    }

    public a(com.anythink.core.common.f.l<?> lVar, com.anythink.core.common.f.n nVar) {
        this.d = lVar;
        this.e = nVar;
    }

    private static int a(android.content.Context context, float f) {
        return com.anythink.core.common.o.i.a(context, f);
    }

    private void a(android.content.Context context) {
        if (this.i == null) {
            this.i = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_splash_ad_install_btn", "id"));
        }
        if (this.j == null) {
            this.j = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_shake_view", "id"));
        }
        if (com.anythink.basead.ui.BaseSdkSplashATView.isSinglePicture(this.d, this.e)) {
            this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
            a(context, this.i, 100.0f);
            a(context, this.j, 100.0f);
        } else if (this.e.w() == 2) {
            this.l.setPadding(0, 0, 0, 0);
            android.view.View view = this.m;
            if (view != null && view.getLayoutParams() != null) {
                android.view.ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                layoutParams.height = com.anythink.core.common.o.i.a(context, 46.0f);
                this.m.setLayoutParams(layoutParams);
                this.m.setPadding(com.anythink.core.common.o.i.a(context, 31.0f), com.anythink.core.common.o.i.a(context, 13.0f), com.anythink.core.common.o.i.a(context, 33.0f), com.anythink.core.common.o.i.a(context, 13.0f));
                this.m.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_invalid_button_shape_radius_24", com.anythink.expressad.foundation.h.i.c));
            }
            android.view.View view2 = this.n;
            if (view2 != null && view2.getLayoutParams() != null) {
                android.view.ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
                if (layoutParams2 instanceof android.widget.RelativeLayout.LayoutParams) {
                    android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.addRule(0, com.anythink.core.common.o.i.a(context, "myoffer_fl_invalid_btn", "id"));
                    layoutParams3.rightMargin = com.anythink.core.common.o.i.a(context, 10.0f);
                    this.n.setLayoutParams(layoutParams3);
                }
                this.n.setPadding(0, 0, 0, 0);
            }
        } else {
            this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
            android.view.View view3 = this.h;
            if (view3 != null) {
                view3.setPadding(0, com.anythink.core.common.o.i.a(context, 25.0f), 0, 0);
            }
        }
        this.l.setVisibility(0);
        a(false);
    }

    private static void a(android.content.Context context, android.view.View view, float f) {
        if (view == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            ((android.widget.RelativeLayout.LayoutParams) layoutParams).bottomMargin = com.anythink.core.common.o.i.a(context, f);
        } else if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            ((android.widget.LinearLayout.LayoutParams) layoutParams).bottomMargin = com.anythink.core.common.o.i.a(context, f);
        }
    }

    private void a(boolean z) {
        android.view.View view;
        if (z && (view = this.m) != null) {
            view.setOnClickListener(new com.anythink.basead.ui.d.a.AnonymousClass1());
            return;
        }
        android.view.View view2 = this.l;
        if (view2 == null) {
            return;
        }
        view2.setOnClickListener(new com.anythink.basead.ui.d.a.AnonymousClass2());
    }

    private void b(android.content.Context context) {
        android.view.View findViewById = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_include_invalid_button_full_screen", "id"));
        this.l = findViewById;
        if (findViewById == null) {
            this.l = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_fl_invalid_btn", "id"));
        }
        this.h = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_splash_ad_bottom_container", "id"));
        this.k = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_ll_top_content", "id"));
        this.i = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_btn_banner_cta", "id"));
        this.j = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_shake_hint_text", "id"));
        this.n = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_ll_title_desc_container", "id"));
        android.view.View view = this.l;
        if (view != null) {
            this.m = view.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_invalid_btn", "id"));
        }
    }

    private static void b(android.content.Context context, android.view.View view, float f) {
        if (view == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            ((android.widget.RelativeLayout.LayoutParams) layoutParams).topMargin = com.anythink.core.common.o.i.a(context, f);
        } else if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin = com.anythink.core.common.o.i.a(context, f);
        }
    }

    public final com.anythink.basead.ui.d.a a(int i) {
        this.f = i;
        return this;
    }

    public final com.anythink.basead.ui.d.a a(com.anythink.basead.ui.c.a aVar) {
        this.o = aVar;
        return this;
    }

    public final void a() {
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.d.a.AnonymousClass3());
    }

    public final void a(android.content.Context context, android.view.View view) {
        com.anythink.core.common.f.n nVar;
        boolean z;
        this.g = view;
        if (view == null || this.d == null || (nVar = this.e) == null || !nVar.al()) {
            return;
        }
        android.view.View findViewById = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_include_invalid_button_full_screen", "id"));
        this.l = findViewById;
        if (findViewById == null) {
            this.l = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_fl_invalid_btn", "id"));
        }
        this.h = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_splash_ad_bottom_container", "id"));
        this.k = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_ll_top_content", "id"));
        this.i = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_btn_banner_cta", "id"));
        this.j = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_shake_hint_text", "id"));
        this.n = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_ll_title_desc_container", "id"));
        android.view.View view2 = this.l;
        if (view2 != null) {
            this.m = view2.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_invalid_btn", "id"));
        }
        if (this.l == null) {
            return;
        }
        if (android.text.TextUtils.equals(java.lang.String.valueOf(this.e.z()), "4")) {
            if (this.i == null) {
                this.i = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_splash_ad_install_btn", "id"));
            }
            if (this.j == null) {
                this.j = this.g.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_shake_view", "id"));
            }
            if (com.anythink.basead.ui.BaseSdkSplashATView.isSinglePicture(this.d, this.e)) {
                this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
                a(context, this.i, 100.0f);
                a(context, this.j, 100.0f);
            } else if (this.e.w() == 2) {
                this.l.setPadding(0, 0, 0, 0);
                android.view.View view3 = this.m;
                if (view3 != null && view3.getLayoutParams() != null) {
                    android.view.ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                    layoutParams.height = com.anythink.core.common.o.i.a(context, 46.0f);
                    this.m.setLayoutParams(layoutParams);
                    this.m.setPadding(com.anythink.core.common.o.i.a(context, 31.0f), com.anythink.core.common.o.i.a(context, 13.0f), com.anythink.core.common.o.i.a(context, 33.0f), com.anythink.core.common.o.i.a(context, 13.0f));
                    this.m.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_invalid_button_shape_radius_24", com.anythink.expressad.foundation.h.i.c));
                }
                android.view.View view4 = this.n;
                if (view4 != null && view4.getLayoutParams() != null) {
                    android.view.ViewGroup.LayoutParams layoutParams2 = this.n.getLayoutParams();
                    if (layoutParams2 instanceof android.widget.RelativeLayout.LayoutParams) {
                        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) layoutParams2;
                        layoutParams3.addRule(0, com.anythink.core.common.o.i.a(context, "myoffer_fl_invalid_btn", "id"));
                        layoutParams3.rightMargin = com.anythink.core.common.o.i.a(context, 10.0f);
                        this.n.setLayoutParams(layoutParams3);
                    }
                    this.n.setPadding(0, 0, 0, 0);
                }
            } else {
                this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
                android.view.View view5 = this.h;
                if (view5 != null) {
                    view5.setPadding(0, com.anythink.core.common.o.i.a(context, 25.0f), 0, 0);
                }
            }
            this.l.setVisibility(0);
            a(false);
            return;
        }
        int i = this.f;
        if (i != -101) {
            switch (i) {
                case 1:
                case 5:
                    this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
                    if (!android.text.TextUtils.isEmpty(this.d.w())) {
                        a(context, this.i, 100.0f);
                        a(context, this.j, 154.0f);
                    }
                    z = false;
                    break;
                case 2:
                case 6:
                    this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 10.0f), 0, 0);
                    if (!android.text.TextUtils.isEmpty(this.d.w())) {
                        a(context, this.k, 160.0f);
                        a(context, this.i, 70.0f);
                        a(context, this.j, 124.0f);
                    }
                    z = false;
                    break;
                case 3:
                case 4:
                case 7:
                    if (!com.anythink.core.common.o.e.h(context)) {
                        this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 10.0f), 0, 0);
                        z = false;
                        break;
                    } else {
                        android.view.View view6 = this.m;
                        if (view6 != null && view6.getLayoutParams() != null) {
                            android.view.ViewGroup.LayoutParams layoutParams4 = this.m.getLayoutParams();
                            layoutParams4.width = com.anythink.core.common.o.i.a(context, 80.0f);
                            layoutParams4.height = com.anythink.core.common.o.i.a(context, 48.0f);
                            this.m.setLayoutParams(layoutParams4);
                            this.m.setPadding(com.anythink.core.common.o.i.a(context, 34.0f), com.anythink.core.common.o.i.a(context, 14.0f), com.anythink.core.common.o.i.a(context, 34.0f), com.anythink.core.common.o.i.a(context, 14.0f));
                            this.m.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_invalid_button_shape_radius_24", com.anythink.expressad.foundation.h.i.c));
                        }
                        z = true;
                        break;
                    }
                    break;
                case 8:
                    break;
                default:
                    if (com.anythink.core.common.o.e.h(context)) {
                        this.l.setPadding(0, 0, 0, 0);
                        android.view.View view7 = this.m;
                        if (view7 != null) {
                            android.view.ViewGroup.LayoutParams layoutParams5 = view7.getLayoutParams();
                            layoutParams5.height = com.anythink.core.common.o.i.a(context, 48.0f);
                            this.m.setLayoutParams(layoutParams5);
                            this.m.setPadding(com.anythink.core.common.o.i.a(context, 34.0f), com.anythink.core.common.o.i.a(context, 14.0f), com.anythink.core.common.o.i.a(context, 34.0f), com.anythink.core.common.o.i.a(context, 14.0f));
                            this.m.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_invalid_button_shape_radius_24", com.anythink.expressad.foundation.h.i.c));
                        }
                        android.view.View view8 = this.n;
                        if (view8 != null && view8.getLayoutParams() != null) {
                            android.view.ViewGroup.LayoutParams layoutParams6 = this.n.getLayoutParams();
                            if (layoutParams6 instanceof android.widget.RelativeLayout.LayoutParams) {
                                android.widget.RelativeLayout.LayoutParams layoutParams7 = (android.widget.RelativeLayout.LayoutParams) layoutParams6;
                                layoutParams7.addRule(0, com.anythink.core.common.o.i.a(context, "myoffer_fl_invalid_btn", "id"));
                                this.n.setLayoutParams(layoutParams7);
                            }
                        }
                        if (this.f == -100) {
                            android.view.ViewGroup.LayoutParams layoutParams8 = this.l.getLayoutParams();
                            layoutParams8.width = -2;
                            if (layoutParams8 instanceof android.widget.RelativeLayout.LayoutParams) {
                                android.widget.RelativeLayout.LayoutParams layoutParams9 = (android.widget.RelativeLayout.LayoutParams) layoutParams8;
                                layoutParams9.addRule(11);
                                layoutParams9.rightMargin = com.anythink.core.common.o.i.a(context, 20.0f);
                                layoutParams9.bottomMargin = com.anythink.core.common.o.i.a(context, 30.0f);
                            }
                            this.l.setLayoutParams(layoutParams8);
                        }
                    } else {
                        this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
                        android.view.View view9 = this.h;
                        if (view9 != null) {
                            view9.setPadding(0, 0, 0, 0);
                        }
                        b(context, this.k, 14.0f);
                        b(context, this.i, 92.0f);
                        if (this.f == -100) {
                            a(context, this.l, 44.0f);
                        }
                    }
                    z = false;
                    break;
            }
            this.l.setVisibility(0);
            a(z);
        }
        if (com.anythink.core.common.o.e.h(context)) {
            this.l.setPadding(0, 0, 0, 0);
            android.view.View view10 = this.m;
            if (view10 != null) {
                android.view.ViewGroup.LayoutParams layoutParams10 = view10.getLayoutParams();
                layoutParams10.height = com.anythink.core.common.o.i.a(context, 48.0f);
                this.m.setLayoutParams(layoutParams10);
                this.m.setPadding(com.anythink.core.common.o.i.a(context, 34.0f), com.anythink.core.common.o.i.a(context, 14.0f), com.anythink.core.common.o.i.a(context, 34.0f), com.anythink.core.common.o.i.a(context, 14.0f));
                this.m.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_invalid_button_shape_radius_24", com.anythink.expressad.foundation.h.i.c));
            }
            if (this.f == -101) {
                android.view.ViewGroup.LayoutParams layoutParams11 = this.l.getLayoutParams();
                layoutParams11.width = -2;
                if (layoutParams11 instanceof android.widget.RelativeLayout.LayoutParams) {
                    android.widget.RelativeLayout.LayoutParams layoutParams12 = (android.widget.RelativeLayout.LayoutParams) layoutParams11;
                    layoutParams12.addRule(11);
                    layoutParams12.rightMargin = com.anythink.core.common.o.i.a(context, 20.0f);
                    layoutParams12.bottomMargin = com.anythink.core.common.o.i.a(context, 30.0f);
                }
                this.l.setLayoutParams(layoutParams11);
            }
        } else {
            this.l.setPadding(0, com.anythink.core.common.o.i.a(context, 26.0f), 0, 0);
            a(context, this.i, 100.0f);
            a(context, this.j, 152.0f);
            if (this.f == -101) {
                a(context, this.l, 35.0f);
            }
        }
        z = false;
        this.l.setVisibility(0);
        a(z);
    }

    public final void b() {
        com.anythink.core.common.b.o.a().b(new com.anythink.basead.ui.d.a.AnonymousClass4());
    }
}
