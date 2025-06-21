package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class ThirdPartyBannerATView extends com.anythink.basead.ui.BaseBannerATView {
    private android.widget.FrameLayout A;
    private android.widget.FrameLayout B;
    private android.widget.LinearLayout C;
    private android.widget.TextView D;
    private android.widget.TextView E;
    private com.anythink.basead.ui.SpreadAnimLayout F;
    private android.widget.ImageView G;
    private android.widget.TextView H;
    private com.anythink.core.common.ui.component.RoundImageView I;
    private android.view.View J;
    private android.view.View K;
    private java.util.List<java.lang.Integer> L;
    private float M;
    private float N;
    private boolean O;
    private int P;
    private int Q;
    private android.view.View R;
    private android.widget.FrameLayout S;
    private android.widget.TextView T;
    private android.view.ViewGroup y;
    private com.anythink.core.common.f.a.e z;

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.ThirdPartyBannerATView.this.c.w(), str)) {
                com.anythink.basead.ui.ThirdPartyBannerATView.this.I.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass2(android.view.View view) {
            this.a = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int height = this.a.getHeight();
            int width = this.a.getWidth();
            android.view.ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            int b = com.anythink.basead.ui.ThirdPartyBannerATView.b(com.anythink.basead.ui.ThirdPartyBannerATView.this);
            layoutParams.height = b;
            layoutParams.width = (b * width) / height;
            this.a.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass3(java.lang.String str) {
            this.a = str;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(this.a, str)) {
                com.anythink.basead.ui.ThirdPartyBannerATView.this.G.setVisibility(0);
                com.anythink.basead.ui.ThirdPartyBannerATView.this.G.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView b;

        public AnonymousClass4(java.lang.String str, com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = str;
            this.b = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(this.a, str)) {
                this.b.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.ThirdPartyBannerATView.this.c.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.ThirdPartyBannerATView.this.c.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.ThirdPartyBannerATView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public ThirdPartyBannerATView(android.content.Context context) {
        super(context);
        this.O = false;
        this.Q = 5;
    }

    public ThirdPartyBannerATView(android.content.Context context, com.anythink.core.api.BaseAd baseAd, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l<?> lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
        android.view.ViewGroup.LayoutParams layoutParams;
        this.O = false;
        this.Q = 5;
        if (baseAd instanceof com.anythink.core.common.f.a.e) {
            this.z = (com.anythink.core.common.f.a.e) baseAd;
        }
        com.anythink.core.common.f.a.e eVar = this.z;
        if (eVar == null || lVar == null || mVar == null) {
            return;
        }
        this.P = eVar.g();
        this.O = this.z.i() == 0;
        this.L = new java.util.ArrayList();
        for (int i : this.z.h()) {
            this.L.add(java.lang.Integer.valueOf(i));
        }
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_native_ad_layout_320x50", "layout"), (android.view.ViewGroup) this, false);
        this.y = viewGroup;
        addView(viewGroup);
        this.A = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_mediaview_container", "id"));
        this.B = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon_container", "id"));
        this.C = (android.widget.LinearLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "ll_title_desc", "id"));
        this.I = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon", "id"));
        this.D = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.E = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_desc", "id"));
        this.H = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.F = (com.anythink.basead.ui.SpreadAnimLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_spread_layout", "id"));
        this.G = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
        this.S = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ad_choice_container", "id"));
        this.T = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_from", "id"));
        com.anythink.basead.ui.CloseImageView closeImageView = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        this.w = closeImageView;
        a(this.T, this.z.getAdFrom());
        if (closeImageView != null) {
            if (this.O) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
        android.view.View adIconView = this.z.getAdIconView();
        this.J = adIconView;
        if (adIconView != null) {
            if (adIconView.getParent() != null && (this.J.getParent() instanceof android.view.ViewGroup)) {
                ((android.view.ViewGroup) this.J.getParent()).removeView(this.J);
            }
            this.B.removeAllViews();
            this.B.addView(this.J, new android.widget.FrameLayout.LayoutParams(-1, -1));
        } else if (android.text.TextUtils.isEmpty(this.c.w()) || this.I == null) {
            android.widget.FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            android.view.ViewGroup.LayoutParams layoutParams2 = this.B.getLayoutParams();
            this.I.setRadiusInDip(6);
            this.I.setNeedRadiu(true);
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass1());
        }
        a(this.D, this.c.u());
        java.lang.String z = this.c.z();
        a(this.H, z);
        if (android.text.TextUtils.isEmpty(z)) {
            com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout = this.F;
            if (spreadAnimLayout != null) {
                spreadAnimLayout.setVisibility(8);
            }
        } else {
            com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout2 = this.F;
            if (spreadAnimLayout2 != null) {
                spreadAnimLayout2.setRoundRadius(com.anythink.core.common.o.i.a(getContext(), 16.67f));
            }
        }
        a(this.E, this.c.v());
        android.view.View adLogoView = this.z.getAdLogoView();
        if (adLogoView != null) {
            if (this.S != null) {
                if (adLogoView.getParent() != null && (adLogoView.getParent() instanceof android.view.ViewGroup)) {
                    ((android.view.ViewGroup) adLogoView.getParent()).removeView(adLogoView);
                }
                this.S.removeAllViews();
                this.S.addView(adLogoView);
                adLogoView.getViewTreeObserver().addOnGlobalLayoutListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass2(adLogoView));
            }
        } else if (this.G != null) {
            java.lang.String y = this.c.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.G.setVisibility(8);
            } else {
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass3(y));
            }
        }
        if (this.A != null) {
            android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 17;
            this.K = this.z.getAdMediaView(new java.lang.Object[0]);
            java.lang.String mainImageUrl = this.z.getMainImageUrl();
            if (this.K != null) {
                this.A.setVisibility(0);
                if (this.K.getParent() != null) {
                    ((android.view.ViewGroup) this.K.getParent()).removeView(this.K);
                }
                this.A.addView(this.K, layoutParams3);
            } else if (android.text.TextUtils.isEmpty(mainImageUrl)) {
                this.A.setVisibility(8);
                com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout3 = this.F;
                if (spreadAnimLayout3 != null && spreadAnimLayout3.getVisibility() == 0) {
                    this.F.setRoundRadius(a(24.0f));
                }
            } else {
                this.A.setVisibility(0);
                com.anythink.core.common.ui.component.RoundImageView roundImageView = new com.anythink.core.common.ui.component.RoundImageView(getContext());
                this.A.addView(roundImageView, layoutParams3);
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, mainImageUrl), new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass4(mainImageUrl, roundImageView));
            }
        }
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.view.View findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_center_line", "id"));
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView4 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        if (this.c.N()) {
            a(textView, this.c.I());
            a(textView4, this.c.J());
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass5());
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass6());
            }
            if (textView != null && textView.getVisibility() == 0) {
                textView.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass7());
            }
            if (textView4 != null && textView4.getVisibility() == 0) {
                textView4.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass8());
            }
        }
        c();
        com.anythink.core.common.f.a.e eVar2 = this.z;
        if (this.y != null) {
            android.content.Context context2 = getContext();
            int a = com.anythink.core.common.o.i.a(context2, 320.0f);
            int a2 = com.anythink.core.common.o.i.a(context2, 50.0f);
            android.view.ViewGroup customAdContainer = eVar2 != null ? eVar2.getCustomAdContainer() : null;
            if (customAdContainer != null) {
                android.view.ViewGroup.LayoutParams layoutParams4 = customAdContainer.getLayoutParams();
                if (layoutParams4 == null) {
                    layoutParams4 = new android.view.ViewGroup.LayoutParams(a, a2);
                } else {
                    layoutParams4.width = a;
                    layoutParams4.height = a2;
                }
                customAdContainer.setLayoutParams(layoutParams4);
                removeAllViews();
                if (customAdContainer instanceof android.widget.FrameLayout) {
                    android.widget.FrameLayout.LayoutParams layoutParams5 = new android.widget.FrameLayout.LayoutParams(a, a2);
                    layoutParams5.gravity = 17;
                    layoutParams = layoutParams5;
                } else {
                    layoutParams = new android.view.ViewGroup.LayoutParams(a, a2);
                }
                this.y.setLayoutParams(layoutParams);
                com.anythink.core.common.o.w.a(customAdContainer);
                customAdContainer.addView(this.y);
                if (customAdContainer.getParent() != null) {
                    ((android.view.ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                }
                addView(customAdContainer);
            }
            b(this.y);
        }
    }

    private int a(float f) {
        return com.anythink.core.common.o.i.a(getContext(), f);
    }

    private static int a(android.content.Context context) {
        return com.anythink.core.common.o.i.a(context, 320.0f);
    }

    private static void a(android.widget.TextView textView, java.lang.String str) {
        if (textView == null) {
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    private void a(com.anythink.core.api.BaseAd baseAd) {
        android.view.ViewGroup.LayoutParams layoutParams;
        if (this.y == null) {
            return;
        }
        android.content.Context context = getContext();
        int a = com.anythink.core.common.o.i.a(context, 320.0f);
        int a2 = com.anythink.core.common.o.i.a(context, 50.0f);
        android.view.ViewGroup customAdContainer = baseAd != null ? baseAd.getCustomAdContainer() : null;
        if (customAdContainer != null) {
            android.view.ViewGroup.LayoutParams layoutParams2 = customAdContainer.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new android.view.ViewGroup.LayoutParams(a, a2);
            } else {
                layoutParams2.width = a;
                layoutParams2.height = a2;
            }
            customAdContainer.setLayoutParams(layoutParams2);
            removeAllViews();
            if (customAdContainer instanceof android.widget.FrameLayout) {
                android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(a, a2);
                layoutParams3.gravity = 17;
                layoutParams = layoutParams3;
            } else {
                layoutParams = new android.view.ViewGroup.LayoutParams(a, a2);
            }
            this.y.setLayoutParams(layoutParams);
            com.anythink.core.common.o.w.a(customAdContainer);
            customAdContainer.addView(this.y);
            if (customAdContainer.getParent() != null) {
                ((android.view.ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
            }
            addView(customAdContainer);
        }
        b(this.y);
    }

    private static boolean a(float f, float f2, android.view.View view) {
        if (view == null) {
            return false;
        }
        float x = view.getX();
        float y = view.getY();
        return f >= x && f <= ((float) view.getWidth()) + x && f2 >= y && f2 <= ((float) view.getHeight()) + y;
    }

    private boolean a(float f, float f2, android.view.View view, java.util.List<java.lang.Integer> list) {
        this.R = view;
        if (this.z == null || list == null || list.size() == 0) {
            return true;
        }
        if (view == this.A || view == this.B) {
            this.Q = 1;
            return list.contains(1);
        }
        if (view == this.C) {
            if (a(f - view.getX(), f2 - view.getY(), this.D)) {
                this.Q = 2;
                return list.contains(2);
            }
            if (a(f - view.getX(), f2 - view.getY(), this.E)) {
                this.Q = 3;
                return list.contains(3);
            }
        }
        if (view != this.F) {
            return true;
        }
        this.Q = 4;
        return list.contains(4);
    }

    private static int b(android.content.Context context) {
        return com.anythink.core.common.o.i.a(context, 50.0f);
    }

    public static /* synthetic */ int b(com.anythink.basead.ui.ThirdPartyBannerATView thirdPartyBannerATView) {
        return thirdPartyBannerATView.a(8.0f);
    }

    private void b(android.view.View view) {
        android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        int i = this.b.f;
        if (i == 1) {
            layoutParams.gravity = 83;
        } else if (i == 8) {
            layoutParams.gravity = 83;
            layoutParams.width = a(32.0f);
            layoutParams.height = a(8.0f);
        } else {
            layoutParams.gravity = 85;
            layoutParams.rightMargin = a(2.0f);
        }
        layoutParams.bottomMargin = a(1.0f);
        com.anythink.core.basead.b.b bVar = new com.anythink.core.basead.b.b();
        int[] h = this.z.h();
        if (h == null) {
            c((android.view.View) this);
        } else {
            for (int i2 : h) {
                if (i2 == 1) {
                    android.view.View view2 = this.J;
                    if (view2 != null) {
                        c(view2);
                        bVar.b(this.J);
                    } else {
                        com.anythink.core.common.ui.component.RoundImageView roundImageView = this.I;
                        if (roundImageView != null) {
                            c(roundImageView);
                            bVar.b(this.I);
                        }
                    }
                    c(this.K);
                    android.view.View view3 = this.K;
                    if (view3 != null) {
                        bVar.c(view3);
                    }
                } else if (i2 == 2) {
                    c(this.D);
                    bVar.a(this.D);
                } else if (i2 == 3) {
                    c(this.E);
                    bVar.d(this.E);
                } else if (i2 == 4) {
                    c(this.H);
                    bVar.e(this.H);
                } else if (i2 == 5) {
                    c((android.view.View) this);
                }
            }
        }
        com.anythink.basead.ui.CloseImageView closeImageView = this.w;
        if (closeImageView != null) {
            bVar.f(closeImageView);
        }
        this.z.registerListener(view, this.p, layoutParams, bVar);
    }

    private void c(android.view.View view) {
        if (view != null) {
            this.p.add(view);
        }
    }

    private void o() {
        this.P = this.z.g();
        this.O = this.z.i() == 0;
        this.L = new java.util.ArrayList();
        for (int i : this.z.h()) {
            this.L.add(java.lang.Integer.valueOf(i));
        }
    }

    private void p() {
        android.view.ViewGroup.LayoutParams layoutParams;
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_native_ad_layout_320x50", "layout"), (android.view.ViewGroup) this, false);
        this.y = viewGroup;
        addView(viewGroup);
        this.A = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_mediaview_container", "id"));
        this.B = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon_container", "id"));
        this.C = (android.widget.LinearLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "ll_title_desc", "id"));
        this.I = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon", "id"));
        this.D = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.E = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_desc", "id"));
        this.H = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.F = (com.anythink.basead.ui.SpreadAnimLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_spread_layout", "id"));
        this.G = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
        this.S = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ad_choice_container", "id"));
        this.T = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_from", "id"));
        com.anythink.basead.ui.CloseImageView closeImageView = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        this.w = closeImageView;
        a(this.T, this.z.getAdFrom());
        if (closeImageView != null) {
            if (this.O) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
        android.view.View adIconView = this.z.getAdIconView();
        this.J = adIconView;
        if (adIconView != null) {
            if (adIconView.getParent() != null && (this.J.getParent() instanceof android.view.ViewGroup)) {
                ((android.view.ViewGroup) this.J.getParent()).removeView(this.J);
            }
            this.B.removeAllViews();
            this.B.addView(this.J, new android.widget.FrameLayout.LayoutParams(-1, -1));
        } else if (android.text.TextUtils.isEmpty(this.c.w()) || this.I == null) {
            android.widget.FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            android.view.ViewGroup.LayoutParams layoutParams2 = this.B.getLayoutParams();
            this.I.setRadiusInDip(6);
            this.I.setNeedRadiu(true);
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass1());
        }
        a(this.D, this.c.u());
        java.lang.String z = this.c.z();
        a(this.H, z);
        if (android.text.TextUtils.isEmpty(z)) {
            com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout = this.F;
            if (spreadAnimLayout != null) {
                spreadAnimLayout.setVisibility(8);
            }
        } else {
            com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout2 = this.F;
            if (spreadAnimLayout2 != null) {
                spreadAnimLayout2.setRoundRadius(com.anythink.core.common.o.i.a(getContext(), 16.67f));
            }
        }
        a(this.E, this.c.v());
        android.view.View adLogoView = this.z.getAdLogoView();
        if (adLogoView != null) {
            if (this.S != null) {
                if (adLogoView.getParent() != null && (adLogoView.getParent() instanceof android.view.ViewGroup)) {
                    ((android.view.ViewGroup) adLogoView.getParent()).removeView(adLogoView);
                }
                this.S.removeAllViews();
                this.S.addView(adLogoView);
                adLogoView.getViewTreeObserver().addOnGlobalLayoutListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass2(adLogoView));
            }
        } else if (this.G != null) {
            java.lang.String y = this.c.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.G.setVisibility(8);
            } else {
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass3(y));
            }
        }
        if (this.A != null) {
            android.widget.FrameLayout.LayoutParams layoutParams3 = new android.widget.FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 17;
            this.K = this.z.getAdMediaView(new java.lang.Object[0]);
            java.lang.String mainImageUrl = this.z.getMainImageUrl();
            if (this.K != null) {
                this.A.setVisibility(0);
                if (this.K.getParent() != null) {
                    ((android.view.ViewGroup) this.K.getParent()).removeView(this.K);
                }
                this.A.addView(this.K, layoutParams3);
            } else if (android.text.TextUtils.isEmpty(mainImageUrl)) {
                this.A.setVisibility(8);
                com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout3 = this.F;
                if (spreadAnimLayout3 != null && spreadAnimLayout3.getVisibility() == 0) {
                    this.F.setRoundRadius(a(24.0f));
                }
            } else {
                this.A.setVisibility(0);
                com.anythink.core.common.ui.component.RoundImageView roundImageView = new com.anythink.core.common.ui.component.RoundImageView(getContext());
                this.A.addView(roundImageView, layoutParams3);
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, mainImageUrl), new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass4(mainImageUrl, roundImageView));
            }
        }
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.view.View findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_center_line", "id"));
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView4 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        if (this.c.N()) {
            a(textView, this.c.I());
            a(textView4, this.c.J());
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass5());
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass6());
            }
            if (textView != null && textView.getVisibility() == 0) {
                textView.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass7());
            }
            if (textView4 != null && textView4.getVisibility() == 0) {
                textView4.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass8());
            }
        }
        c();
        com.anythink.core.common.f.a.e eVar = this.z;
        if (this.y != null) {
            android.content.Context context = getContext();
            int a = com.anythink.core.common.o.i.a(context, 320.0f);
            int a2 = com.anythink.core.common.o.i.a(context, 50.0f);
            android.view.ViewGroup customAdContainer = eVar != null ? eVar.getCustomAdContainer() : null;
            if (customAdContainer != null) {
                android.view.ViewGroup.LayoutParams layoutParams4 = customAdContainer.getLayoutParams();
                if (layoutParams4 == null) {
                    layoutParams4 = new android.view.ViewGroup.LayoutParams(a, a2);
                } else {
                    layoutParams4.width = a;
                    layoutParams4.height = a2;
                }
                customAdContainer.setLayoutParams(layoutParams4);
                removeAllViews();
                if (customAdContainer instanceof android.widget.FrameLayout) {
                    android.widget.FrameLayout.LayoutParams layoutParams5 = new android.widget.FrameLayout.LayoutParams(a, a2);
                    layoutParams5.gravity = 17;
                    layoutParams = layoutParams5;
                } else {
                    layoutParams = new android.view.ViewGroup.LayoutParams(a, a2);
                }
                this.y.setLayoutParams(layoutParams);
                com.anythink.core.common.o.w.a(customAdContainer);
                customAdContainer.addView(this.y);
                if (customAdContainer.getParent() != null) {
                    ((android.view.ViewGroup) customAdContainer.getParent()).removeView(customAdContainer);
                }
                addView(customAdContainer);
            }
            b(this.y);
        }
    }

    private void q() {
        android.view.ViewGroup viewGroup = (android.view.ViewGroup) android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_native_ad_layout_320x50", "layout"), (android.view.ViewGroup) this, false);
        this.y = viewGroup;
        addView(viewGroup);
    }

    private void r() {
        this.A = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_mediaview_container", "id"));
        this.B = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon_container", "id"));
        this.C = (android.widget.LinearLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "ll_title_desc", "id"));
        this.I = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_icon", "id"));
        this.D = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.E = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_desc", "id"));
        this.H = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_install_btn", "id"));
        this.F = (com.anythink.basead.ui.SpreadAnimLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_spread_layout", "id"));
        this.G = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_self_ad_logo", "id"));
        this.S = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ad_choice_container", "id"));
        this.T = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_from", "id"));
        com.anythink.basead.ui.CloseImageView closeImageView = (com.anythink.basead.ui.CloseImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_close", "id"));
        this.w = closeImageView;
        a(this.T, this.z.getAdFrom());
        if (closeImageView != null) {
            if (this.O) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
        }
        android.view.View adIconView = this.z.getAdIconView();
        this.J = adIconView;
        if (adIconView != null) {
            if (adIconView.getParent() != null && (this.J.getParent() instanceof android.view.ViewGroup)) {
                ((android.view.ViewGroup) this.J.getParent()).removeView(this.J);
            }
            this.B.removeAllViews();
            this.B.addView(this.J, new android.widget.FrameLayout.LayoutParams(-1, -1));
        } else if (android.text.TextUtils.isEmpty(this.c.w()) || this.I == null) {
            android.widget.FrameLayout frameLayout = this.B;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            android.view.ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
            this.I.setRadiusInDip(6);
            this.I.setNeedRadiu(true);
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), layoutParams.width, layoutParams.height, new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass1());
        }
        a(this.D, this.c.u());
        java.lang.String z = this.c.z();
        a(this.H, z);
        if (android.text.TextUtils.isEmpty(z)) {
            com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout = this.F;
            if (spreadAnimLayout != null) {
                spreadAnimLayout.setVisibility(8);
            }
        } else {
            com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout2 = this.F;
            if (spreadAnimLayout2 != null) {
                spreadAnimLayout2.setRoundRadius(com.anythink.core.common.o.i.a(getContext(), 16.67f));
            }
        }
        a(this.E, this.c.v());
        android.view.View adLogoView = this.z.getAdLogoView();
        if (adLogoView != null) {
            if (this.S != null) {
                if (adLogoView.getParent() != null && (adLogoView.getParent() instanceof android.view.ViewGroup)) {
                    ((android.view.ViewGroup) adLogoView.getParent()).removeView(adLogoView);
                }
                this.S.removeAllViews();
                this.S.addView(adLogoView);
                adLogoView.getViewTreeObserver().addOnGlobalLayoutListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass2(adLogoView));
            }
        } else if (this.G != null) {
            java.lang.String y = this.c.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.G.setVisibility(8);
            } else {
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, y), new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass3(y));
            }
        }
        if (this.A != null) {
            android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            this.K = this.z.getAdMediaView(new java.lang.Object[0]);
            java.lang.String mainImageUrl = this.z.getMainImageUrl();
            if (this.K != null) {
                this.A.setVisibility(0);
                if (this.K.getParent() != null) {
                    ((android.view.ViewGroup) this.K.getParent()).removeView(this.K);
                }
                this.A.addView(this.K, layoutParams2);
            } else if (android.text.TextUtils.isEmpty(mainImageUrl)) {
                this.A.setVisibility(8);
                com.anythink.basead.ui.SpreadAnimLayout spreadAnimLayout3 = this.F;
                if (spreadAnimLayout3 != null && spreadAnimLayout3.getVisibility() == 0) {
                    this.F.setRoundRadius(a(24.0f));
                }
            } else {
                this.A.setVisibility(0);
                com.anythink.core.common.ui.component.RoundImageView roundImageView = new com.anythink.core.common.ui.component.RoundImageView(getContext());
                this.A.addView(roundImageView, layoutParams2);
                com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, mainImageUrl), new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass4(mainImageUrl, roundImageView));
            }
        }
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_publisher_name", "id"));
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_privacy_agreement", "id"));
        android.view.View findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_center_line", "id"));
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_permission_manage", "id"));
        android.widget.TextView textView4 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_version_name", "id"));
        if (this.c.N()) {
            a(textView, this.c.I());
            a(textView4, this.c.J());
            if (textView2 != null) {
                textView2.setVisibility(0);
                textView2.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass5());
            }
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            if (textView3 != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass6());
            }
            if (textView != null && textView.getVisibility() == 0) {
                textView.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass7());
            }
            if (textView4 == null || textView4.getVisibility() != 0) {
                return;
            }
            textView4.setOnClickListener(new com.anythink.basead.ui.ThirdPartyBannerATView.AnonymousClass8());
        }
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a() {
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a(int i, java.lang.Runnable runnable) {
    }

    @Override // com.anythink.basead.ui.BaseATView
    public void destroy() {
        com.anythink.core.common.f.a.e eVar = this.z;
        if (eVar != null) {
            eVar.clear(this.y);
            this.z.destroy();
        }
    }

    @Override // com.anythink.basead.ui.BaseATView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        android.view.ViewGroup viewGroup = this.y;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.R = null;
                this.M = motionEvent.getX();
                this.N = motionEvent.getY();
            } else if (action == 1) {
                int i = 0;
                while (true) {
                    if (i >= this.y.getChildCount()) {
                        break;
                    }
                    android.view.View childAt = this.y.getChildAt(i);
                    if (a(this.M, this.N, childAt)) {
                        float f = this.M;
                        float f2 = this.N;
                        java.util.List<java.lang.Integer> list = this.L;
                        this.R = childAt;
                        if (this.z != null && list != null && list.size() != 0) {
                            if (childAt == this.A || childAt == this.B) {
                                this.Q = 1;
                                list.contains(1);
                            } else {
                                if (childAt == this.C) {
                                    if (a(f - childAt.getX(), f2 - childAt.getY(), this.D)) {
                                        this.Q = 2;
                                        list.contains(2);
                                    } else if (a(f - childAt.getX(), f2 - childAt.getY(), this.E)) {
                                        this.Q = 3;
                                        list.contains(3);
                                    }
                                }
                                if (childAt == this.F) {
                                    this.Q = 4;
                                    list.contains(4);
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getClickedArea() {
        if (this.R == null) {
            return 5;
        }
        return this.Q;
    }

    @Override // com.anythink.basead.ui.BaseBannerATView, com.anythink.basead.ui.BaseATView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }
}
