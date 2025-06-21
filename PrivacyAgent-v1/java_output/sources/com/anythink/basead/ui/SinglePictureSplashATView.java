package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class SinglePictureSplashATView extends com.anythink.basead.ui.BaseSdkSplashATView {

    /* renamed from: com.anythink.basead.ui.SinglePictureSplashATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.basead.ui.c.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.c.a
        public final void a(int i, int i2) {
            com.anythink.basead.ui.SinglePictureSplashATView.this.a(i, i2);
        }
    }

    /* renamed from: com.anythink.basead.ui.SinglePictureSplashATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ com.anythink.core.common.ui.component.RoundImageView a;

        /* renamed from: com.anythink.basead.ui.SinglePictureSplashATView$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.basead.ui.WrapRoundImageView a;
            final /* synthetic */ android.graphics.Bitmap b;

            public AnonymousClass1(com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView, android.graphics.Bitmap bitmap) {
                this.a = wrapRoundImageView;
                this.b = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.setBitmapAndResize(this.b, com.anythink.basead.ui.SinglePictureSplashATView.this.getWidth(), com.anythink.basead.ui.SinglePictureSplashATView.this.getHeight());
            }
        }

        /* renamed from: com.anythink.basead.ui.SinglePictureSplashATView$2$2, reason: invalid class name and collision with other inner class name */
        public class C01462 implements com.anythink.core.common.o.c.a {
            public C01462() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.SinglePictureSplashATView.AnonymousClass2.this.a.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass2(com.anythink.core.common.ui.component.RoundImageView roundImageView) {
            this.a = roundImageView;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.SinglePictureSplashATView.this.c.x())) {
                com.anythink.basead.ui.SinglePictureSplashATView singlePictureSplashATView = com.anythink.basead.ui.SinglePictureSplashATView.this;
                com.anythink.basead.ui.WrapRoundImageView wrapRoundImageView = (com.anythink.basead.ui.WrapRoundImageView) singlePictureSplashATView.findViewById(com.anythink.core.common.o.i.a(singlePictureSplashATView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
                if (com.anythink.basead.ui.SinglePictureSplashATView.this.b.n.p() == 2) {
                    wrapRoundImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                    wrapRoundImageView.setImageBitmap(bitmap);
                } else {
                    wrapRoundImageView.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                    wrapRoundImageView.post(new com.anythink.basead.ui.SinglePictureSplashATView.AnonymousClass2.AnonymousClass1(wrapRoundImageView, bitmap));
                }
                if (this.a != null) {
                    com.anythink.core.common.o.c.a(com.anythink.basead.ui.SinglePictureSplashATView.this.getContext(), bitmap, new com.anythink.basead.ui.SinglePictureSplashATView.AnonymousClass2.C01462());
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.SinglePictureSplashATView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.ui.SinglePictureSplashATView singlePictureSplashATView = com.anythink.basead.ui.SinglePictureSplashATView.this;
            if (singlePictureSplashATView.H == null) {
                return;
            }
            int width = singlePictureSplashATView.getWidth();
            int height = com.anythink.basead.ui.SinglePictureSplashATView.this.getHeight();
            int i = (int) (com.anythink.basead.ui.SinglePictureSplashATView.this.getResources().getDisplayMetrics().heightPixels * 0.5d);
            if (width < ((int) (com.anythink.basead.ui.SinglePictureSplashATView.this.getResources().getDisplayMetrics().widthPixels * 0.5d))) {
                com.anythink.basead.ui.SinglePictureSplashATView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, "Splash display width is less than 50% of screen width!"));
            } else if (height < i) {
                com.anythink.basead.ui.SinglePictureSplashATView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, "Splash display height is less than 50% of screen height!"));
            } else {
                com.anythink.basead.ui.SinglePictureSplashATView.super.h();
            }
        }
    }

    public SinglePictureSplashATView(android.content.Context context) {
        super(context);
    }

    public SinglePictureSplashATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseATView
    public final void a() {
        android.view.View inflate = this.b.n.w() == 2 ? android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_layout_single_land", "layout"), this) : android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_layout_single_port", "layout"), this);
        o();
        com.anythink.basead.ui.d.a aVar = this.L;
        if (aVar != null) {
            aVar.a(com.anythink.basead.ui.d.a.c).a(new com.anythink.basead.ui.SinglePictureSplashATView.AnonymousClass1()).a(getContext(), inflate);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    public final void b() {
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_ad_install_btn", "id"));
        this.f149s = textView;
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.x()), getResources().getDisplayMetrics().widthPixels, (getResources().getDisplayMetrics().widthPixels * 627) / com.amap.api.services.core.AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, new com.anythink.basead.ui.SinglePictureSplashATView.AnonymousClass2((com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_splash_bg", "id"))));
        com.anythink.core.common.f.n nVar = this.b.n;
        if (nVar == null || textView == null) {
            return;
        }
        if (nVar.D() == 0 || k()) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        if (android.text.TextUtils.isEmpty(this.c.z())) {
            textView.setText(com.anythink.basead.a.d.a(getContext(), this.c));
        } else {
            textView.setText(this.c.z());
        }
        this.p.add(textView);
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashATView
    public final void c() {
        super.a(this.b.n.V() < 0 ? 100 : this.b.n.V(), new com.anythink.basead.ui.SinglePictureSplashATView.AnonymousClass3());
    }
}
