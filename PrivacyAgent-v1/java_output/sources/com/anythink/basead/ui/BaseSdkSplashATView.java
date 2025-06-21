package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public abstract class BaseSdkSplashATView extends com.anythink.basead.ui.BaseSplashATView {
    public static final int TYPE_ASSEBLEM = 1;
    public static final int TYPE_SINGLE_PICTURE = 0;
    android.widget.TextView A;
    protected final android.view.View.OnClickListener B;
    protected com.anythink.core.common.ui.component.RoundImageView v;
    android.view.ViewGroup w;
    android.widget.TextView x;
    android.widget.TextView y;
    android.widget.TextView z;

    /* renamed from: com.anythink.basead.ui.BaseSdkSplashATView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.f.n nVar = com.anythink.basead.ui.BaseSdkSplashATView.this.b.n;
            if (nVar != null && nVar.D() == 0) {
                com.anythink.basead.ui.BaseSdkSplashATView.super.a(1, 3);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseSdkSplashATView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.BaseSdkSplashATView.this.c.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseSdkSplashATView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.BaseSdkSplashATView.this.c.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseSdkSplashATView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ android.view.ViewGroup.LayoutParams a;

        public AnonymousClass4(android.view.ViewGroup.LayoutParams layoutParams) {
            this.a = layoutParams;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.BaseSdkSplashATView.this.v.setVisibility(8);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, com.anythink.basead.ui.BaseSdkSplashATView.this.c.y())) {
                android.view.ViewGroup.LayoutParams layoutParams = this.a;
                int i = layoutParams.height;
                layoutParams.width = (int) (i * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i;
                com.anythink.basead.ui.BaseSdkSplashATView.this.v.setLayoutParams(layoutParams);
                com.anythink.basead.ui.BaseSdkSplashATView.this.v.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                com.anythink.basead.ui.BaseSdkSplashATView.this.v.setImageBitmap(bitmap);
                com.anythink.basead.ui.BaseSdkSplashATView.this.v.setVisibility(0);
            }
        }
    }

    public BaseSdkSplashATView(android.content.Context context) {
        super(context);
        this.B = new com.anythink.basead.ui.BaseSdkSplashATView.AnonymousClass1();
    }

    public BaseSdkSplashATView(android.content.Context context, com.anythink.core.common.f.m mVar, com.anythink.core.common.f.l lVar, com.anythink.basead.e.a aVar) {
        super(context, mVar, lVar, aVar);
        this.B = new com.anythink.basead.ui.BaseSdkSplashATView.AnonymousClass1();
        c();
        p();
        a(this.D, this.b.n.n());
    }

    public static boolean isSinglePicture(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.n nVar) {
        return ((lVar instanceof com.anythink.core.common.f.z) && (nVar instanceof com.anythink.core.common.f.ab)) ? 2 == ((com.anythink.core.common.f.ab) nVar).as() : (lVar instanceof com.anythink.core.common.f.ai) && 1 == ((com.anythink.core.common.f.ai) lVar).ae();
    }

    public abstract void b();

    public abstract void c();

    public void o() {
        b();
        this.w = (android.view.ViewGroup) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_four_element_container", "id"));
        this.x = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_publisher_name", "id"));
        this.y = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_privacy_agreement", "id"));
        this.z = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_permission_manage", "id"));
        this.A = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_version_name", "id"));
        if (this.c.N()) {
            android.view.ViewGroup viewGroup = this.w;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            android.widget.TextView textView = this.x;
            if (textView != null) {
                textView.setVisibility(0);
                this.x.setText(this.c.I());
                this.p.add(this.x);
            }
            android.widget.TextView textView2 = this.y;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.y.setOnClickListener(new com.anythink.basead.ui.BaseSdkSplashATView.AnonymousClass2());
            }
            android.widget.TextView textView3 = this.z;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.z.setOnClickListener(new com.anythink.basead.ui.BaseSdkSplashATView.AnonymousClass3());
            }
            android.widget.TextView textView4 = this.A;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.A.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.c.J()));
                this.p.add(this.A);
            }
        } else {
            android.view.ViewGroup viewGroup2 = this.w;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            android.widget.TextView textView5 = this.A;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            android.widget.TextView textView6 = this.x;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            android.widget.TextView textView7 = this.y;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            android.widget.TextView textView8 = this.z;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            try {
                android.view.View findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_four_element_container_bg", "id"));
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(null);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        com.anythink.core.common.ui.component.RoundImageView roundImageView = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ad_logo", "id"));
        this.v = roundImageView;
        android.view.ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
        if (!android.text.TextUtils.isEmpty(this.c.y())) {
            this.v.setVisibility(0);
            int i = layoutParams.width;
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.c.y()), i, i, new com.anythink.basead.ui.BaseSdkSplashATView.AnonymousClass4(layoutParams));
        } else if (this.c.M() != null) {
            android.graphics.Bitmap M = this.c.M();
            int i2 = layoutParams.height;
            layoutParams.width = (int) (i2 * ((M.getWidth() * 1.0f) / M.getHeight()));
            layoutParams.height = i2;
            this.v.setLayoutParams(layoutParams);
            this.v.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            this.v.setImageBitmap(M);
            this.v.setImageBitmap(this.c.M());
            this.v.setVisibility(0);
        } else {
            this.v.setVisibility(8);
        }
        this.p.add(this.v);
    }

    @Override // com.anythink.basead.ui.BaseSplashATView
    public void p() {
        super.p();
        setOnClickListener(this.B);
    }
}
