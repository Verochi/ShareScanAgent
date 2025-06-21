package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class MediaATView extends com.anythink.basead.ui.BaseMediaATView {
    public static final java.lang.String TAG = "anythink_" + com.anythink.basead.ui.MediaATView.class.getSimpleName();
    android.widget.RelativeLayout g;
    android.widget.RelativeLayout h;
    android.widget.TextView i;
    android.widget.TextView j;
    android.widget.TextView k;
    android.widget.TextView l;
    final float m;
    private android.widget.TextView n;
    private android.widget.TextView o;
    private android.widget.ImageView p;
    private android.widget.ImageView q;
    private android.widget.ImageView r;

    /* renamed from: s, reason: collision with root package name */
    private com.anythink.core.common.ui.component.RoundImageView f150s;
    private android.widget.TextView t;

    /* renamed from: com.anythink.basead.ui.MediaATView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {

        /* renamed from: com.anythink.basead.ui.MediaATView$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01431 implements java.lang.Runnable {
            final /* synthetic */ android.graphics.Bitmap a;

            public RunnableC01431(android.graphics.Bitmap bitmap) {
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int[] a = com.anythink.core.common.o.w.a(com.anythink.basead.ui.MediaATView.this.getWidth(), com.anythink.basead.ui.MediaATView.this.getHeight(), this.a.getWidth() / this.a.getHeight());
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) com.anythink.basead.ui.MediaATView.this.q.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = a[0];
                    layoutParams.height = a[1];
                    layoutParams.addRule(13);
                    com.anythink.basead.ui.MediaATView.this.q.setLayoutParams(layoutParams);
                }
            }
        }

        /* renamed from: com.anythink.basead.ui.MediaATView$1$2, reason: invalid class name */
        public class AnonymousClass2 implements com.anythink.core.common.o.c.a {
            public AnonymousClass2() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                com.anythink.basead.ui.MediaATView.this.p.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                com.anythink.basead.ui.MediaATView.this.p.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            java.lang.String str3 = com.anythink.basead.ui.MediaATView.TAG;
            "load: image load fail:".concat(java.lang.String.valueOf(str2));
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.MediaATView.this.a.x(), str)) {
                com.anythink.basead.ui.MediaATView.this.q.setImageBitmap(bitmap);
                com.anythink.basead.ui.MediaATView.this.post(new com.anythink.basead.ui.MediaATView.AnonymousClass1.RunnableC01431(bitmap));
                com.anythink.core.common.o.c.a(com.anythink.basead.ui.MediaATView.this.getContext(), bitmap, new com.anythink.basead.ui.MediaATView.AnonymousClass1.AnonymousClass2());
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.common.res.b.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.ui.MediaATView.this.r.setVisibility(8);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.MediaATView.this.a.y(), str)) {
                com.anythink.basead.ui.MediaATView.this.r.setImageBitmap(bitmap);
                android.view.ViewGroup.LayoutParams layoutParams = com.anythink.basead.ui.MediaATView.this.r.getLayoutParams();
                int i = layoutParams.height;
                layoutParams.width = (int) (i * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i;
                com.anythink.basead.ui.MediaATView.this.r.setLayoutParams(layoutParams);
                com.anythink.basead.ui.MediaATView.this.r.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                com.anythink.basead.ui.MediaATView.this.r.setImageBitmap(bitmap);
                com.anythink.basead.ui.MediaATView.this.r.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.res.b.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(com.anythink.basead.ui.MediaATView.this.a.w(), str)) {
                com.anythink.basead.ui.MediaATView.this.f150s.setImageBitmap(bitmap);
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.MediaATView.this.a.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), com.anythink.basead.ui.MediaATView.this.a.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.ui.MediaATView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public MediaATView(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, com.anythink.basead.ui.BaseMediaATView.a aVar) {
        super(context, lVar, mVar, z, aVar);
        this.m = 1.0f;
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public java.util.List<android.view.View> getClickViews() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(this.n);
        arrayList.add(this.q);
        arrayList.add(this.o);
        arrayList.add(this.f150s);
        arrayList.add(this.t);
        com.anythink.core.common.f.n nVar = this.b;
        if (nVar != null && nVar.D() == 0) {
            arrayList.add(this.p);
            arrayList.add(this.g);
        }
        return arrayList;
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public android.view.View getMonitorClickView() {
        return this.o;
    }

    @Override // com.anythink.basead.ui.BaseMediaATView
    public void init(int i, int i2) {
        android.view.View findViewById;
        super.init(i, i2);
        android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_view", "layout"), (android.view.ViewGroup) null, false);
        android.widget.FrameLayout frameLayout = this.f;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f.addView(inflate, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        this.n = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_title", "id"));
        this.o = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_cta", "id"));
        this.p = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_bg_blur", "id"));
        this.q = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_main_image", "id"));
        this.r = (android.widget.ImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_ad_logo", "id"));
        this.f150s = (com.anythink.core.common.ui.component.RoundImageView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_icon", "id"));
        this.t = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_banner_ad_desc", "id"));
        this.g = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_container", "id"));
        this.h = (android.widget.RelativeLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_four_element_container", "id"));
        this.i = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_publisher_name", "id"));
        this.j = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_privacy_agreement", "id"));
        this.k = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_permission_manage", "id"));
        this.l = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_version_name", "id"));
        java.lang.String u = this.a.u();
        if (android.text.TextUtils.isEmpty(u)) {
            this.n.setVisibility(8);
            android.view.ViewGroup.LayoutParams layoutParams = this.t.getLayoutParams();
            if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
                ((android.widget.LinearLayout.LayoutParams) layoutParams).topMargin = 0;
                this.t.setLayoutParams(layoutParams);
            }
        } else {
            this.n.setText(u);
        }
        java.lang.String z = this.a.z();
        if (android.text.TextUtils.isEmpty(z)) {
            this.o.setText(com.anythink.core.common.o.i.a(getContext(), "myoffer_cta_learn_more", com.anythink.expressad.foundation.h.i.g));
        } else {
            this.o.setText(z);
        }
        this.q.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.a.x()), i, i2, new com.anythink.basead.ui.MediaATView.AnonymousClass1());
        if (android.text.TextUtils.isEmpty(this.a.y())) {
            this.r.setVisibility(8);
        } else {
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.a.y()), new com.anythink.basead.ui.MediaATView.AnonymousClass2());
        }
        java.lang.String v = this.a.v();
        if (android.text.TextUtils.isEmpty(v)) {
            this.t.setVisibility(8);
        } else {
            this.t.setText(v);
        }
        if (android.text.TextUtils.isEmpty(this.a.w())) {
            this.f150s.setVisibility(8);
        } else {
            this.f150s.setRadiusInDip(6);
            this.f150s.setNeedRadiu(true);
            android.view.ViewGroup.LayoutParams layoutParams2 = this.f150s.getLayoutParams();
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.a.w()), layoutParams2.width, layoutParams2.height, new com.anythink.basead.ui.MediaATView.AnonymousClass3());
        }
        if (this.a.N()) {
            android.widget.RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                this.h.setOnClickListener(new com.anythink.basead.ui.MediaATView.AnonymousClass4());
            }
            android.widget.TextView textView = this.i;
            if (textView != null) {
                textView.setVisibility(0);
                this.i.setText(this.a.I());
                this.i.setOnClickListener(new com.anythink.basead.ui.MediaATView.AnonymousClass5());
            }
            android.widget.TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.j.setOnClickListener(new com.anythink.basead.ui.MediaATView.AnonymousClass6());
            }
            android.widget.TextView textView3 = this.k;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.k.setOnClickListener(new com.anythink.basead.ui.MediaATView.AnonymousClass7());
            }
            android.widget.TextView textView4 = this.l;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.l.setText(getContext().getResources().getString(com.anythink.core.common.o.i.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), this.a.J()));
                this.l.setOnClickListener(new com.anythink.basead.ui.MediaATView.AnonymousClass8());
            }
        }
        if (com.anythink.basead.a.d.a(this.a) || (findViewById = findViewById(com.anythink.core.common.o.i.a(getContext(), "myoffer_media_ad_main_image_container", "id"))) == null) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams3 = findViewById.getLayoutParams();
        if (layoutParams3 instanceof android.widget.RelativeLayout.LayoutParams) {
            ((android.widget.FrameLayout.LayoutParams) layoutParams3).bottomMargin = com.anythink.core.common.o.i.a(getContext(), 84.0f);
            findViewById.setLayoutParams(layoutParams3);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
