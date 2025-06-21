package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class AsseblemSplashATView extends com.anythink.basead.ui.BaseSdkSplashATView {

    /* renamed from: com.anythink.basead.ui.AsseblemSplashATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.AsseblemSplashATView.this.a(i, i2);
        }
    }

    /* renamed from: com.anythink.basead.ui.AsseblemSplashATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView a;

        public AnonymousClass2(com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.AsseblemSplashATView.this.c.w())) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.AsseblemSplashATView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ android.widget.FrameLayout a;
        final /* synthetic */ com.anythink.basead.ui.WrapRoundImageView b;
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView c;

        /* renamed from: com.anythink.basead.ui.AsseblemSplashATView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            public AnonymousClass1(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3 anonymousClass3 = com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3.this;
                anonymousClass3.b.setBitmapAndResize(this.a, anonymousClass3.a.getWidth(), com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3.this.a.getHeight());
                com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3.this.b.setVisibility(0);
            }
        }

        /* renamed from: com.anythink.basead.ui.AsseblemSplashATView$3$2, reason: invalid class name */
        public class AnonymousClass2 implements com.anythink.core.common.o.c.a {
            public AnonymousClass2() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3.this.c.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass3(android.widget.FrameLayout frameLayout, com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView, com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = frameLayout;
            this.b = wrapRoundImageView;
            this.c = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.AsseblemSplashATView.this.c.x())) {
                this.a.post(new com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3.AnonymousClass1(bitmap));
                com.anythink.core.common.o.c.a(com.anythink.basead.ui.AsseblemSplashATView.this.getContext(), bitmap, new com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3.AnonymousClass2());
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.AsseblemSplashATView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.AsseblemSplashATView asseblemSplashATView = com.anythink.basead.ui.AsseblemSplashATView.this;
            if (asseblemSplashATView.H == null) {
                return;
            }
            com.anythink.basead.ui.AsseblemSplashATView.super.h();
        }
    }

    public AsseblemSplashATView(android.content.Context context) {
        super(context);
    }

    public AsseblemSplashATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a() {
        android.view.View inflate = this.b.n.w() == 2 ? android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_land", "layout"), this) : android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_port", "layout"), this);
        o();
        com.anythink.basead.ui.d.a aVar = this.L;
        if (aVar != null) {
            aVar.a(com.anythink.basead.ui.d.a.c).a(new com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass1()).a(getContext(), inflate);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    public final void b() {
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_title", "id"));
        android.widget.TextView textView2 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_install_btn", "id"));
        android.widget.TextView textView3 = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_desc", "id"));
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        com.anythink.core.common.ui.component.RoundImageView roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_bg", "id"));
        com.anythink.core.common.ui.component.RoundImageView roundImageView2 = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_icon", "id"));
        this.f149s = textView2;
        if (android.text.TextUtils.isEmpty(this.c.w())) {
            com.anythink.basead.ui.d.c.a(roundImageView2);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) roundImageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.rightMargin = 0;
                roundImageView2.setLayoutParams(layoutParams);
            }
            if (textView != null) {
                textView.setGravity(17);
            }
            if (textView3 != null) {
                textView3.setGravity(17);
            }
        } else {
            roundImageView2.setVisibility(0);
            roundImageView2.setNeedRadiu(true);
            roundImageView2.setRadiusInDip(12);
            int i = roundImageView2.getLayoutParams().width;
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.w()), i, i, new com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass2(roundImageView2));
        }
        this.p.add(roundImageView2);
        frameLayout.removeAllViews();
        com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = new com.anythink.basead.ui.WrapRoundImageView(getContext());
        android.widget.FrameLayout.LayoutParams layoutParams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        wrapRoundImageView.setLayoutParams(layoutParams2);
        wrapRoundImageView.setNeedRadiu(false);
        wrapRoundImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView.setVisibility(4);
        frameLayout.addView(wrapRoundImageView, layoutParams2);
        frameLayout.setVisibility(0);
        roundImageView.setNeedRadiu(false);
        if (android.text.TextUtils.isEmpty(this.c.x())) {
            roundImageView.setBackgroundColor(android.graphics.Color.parseColor("#EFEFEF"));
        } else {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.x()), getResources().getDisplayMetrics().widthPixels, (getResources().getDisplayMetrics().widthPixels * 627) / com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, new com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass3(frameLayout, wrapRoundImageView, roundImageView));
            this.p.add(wrapRoundImageView);
        }
        if (android.text.TextUtils.isEmpty(this.c.u())) {
            textView.setVisibility(4);
        } else {
            textView.setText(this.c.u());
            textView.setVisibility(0);
        }
        this.p.add(textView);
        if (android.text.TextUtils.isEmpty(this.c.z())) {
            textView2.setText(com.anythink.basead.a.d.a(getContext(), this.c));
        } else {
            textView2.setText(this.c.z());
        }
        this.p.add(textView2);
        if (textView3 != null) {
            if (android.text.TextUtils.isEmpty(this.c.v())) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(this.c.v());
            }
            this.p.add(textView3);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    public void c() {
        super.a(this.b.n.V() < 0 ? 100 : this.b.n.V(), new com.anythink.basead.ui.AsseblemSplashATView.AnonymousClass4());
    }
}
