package com.anythink.basead.a.c;

/* loaded from: classes12.dex */
public final class a {
    android.widget.TextView a;
    android.view.View b;
    android.widget.ImageView c;
    android.view.View d;
    android.view.View e;
    android.content.Context f;
    android.animation.ValueAnimator g;
    boolean h;
    boolean i;
    int j;
    int k;
    private android.view.ViewGroup l;
    private android.widget.TextView m;
    private android.widget.TextView n;
    private android.widget.TextView o;
    private android.widget.TextView p;

    /* renamed from: com.anythink.basead.a.c.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ android.view.ViewGroup.LayoutParams b;

        public AnonymousClass1(java.lang.String str, android.view.ViewGroup.LayoutParams layoutParams) {
            this.a = str;
            this.b = layoutParams;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            com.anythink.basead.a.c.a.this.c.setVisibility(8);
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            if (android.text.TextUtils.equals(str, this.a)) {
                com.anythink.basead.a.c.a.this.c.setImageBitmap(bitmap);
                android.view.ViewGroup.LayoutParams layoutParams = this.b;
                int i = layoutParams.height;
                layoutParams.width = (int) (i * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                layoutParams.height = i;
                com.anythink.basead.a.c.a.this.c.setLayoutParams(layoutParams);
                com.anythink.basead.a.c.a.this.c.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                com.anythink.basead.a.c.a.this.c.setImageBitmap(bitmap);
                com.anythink.basead.a.c.a.this.c.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.basead.a.c.a$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass2(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), this.a.K());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.a.c.a$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        final /* synthetic */ com.anythink.core.common.f.l a;

        public AnonymousClass3(com.anythink.core.common.f.l lVar) {
            this.a = lVar;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), this.a.L());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.a.c.a$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.a.c.a$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.basead.a.c.a$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ android.view.View a;

        /* renamed from: com.anythink.basead.a.c.a$6$1, reason: invalid class name */
        public class AnonymousClass1 implements android.animation.ValueAnimator.AnimatorUpdateListener {
            public AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                double sin = java.lang.Math.sin(java.lang.Math.toRadians(((java.lang.Float) valueAnimator.getAnimatedValue()).floatValue())) * java.lang.Math.pow(((valueAnimator.getDuration() * 2) - valueAnimator.getCurrentPlayTime()) / (valueAnimator.getDuration() * 2.0f), 2.0d);
                com.anythink.basead.a.c.a.AnonymousClass6.this.a.setTranslationY(-((float) (com.anythink.basead.a.c.a.this.k * sin)));
            }
        }

        public AnonymousClass6(android.view.View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.basead.a.c.a.this.g = android.animation.ValueAnimator.ofFloat(0.0f, 720.0f);
            com.anythink.basead.a.c.a.this.g.setDuration(2000L);
            com.anythink.basead.a.c.a.this.g.addUpdateListener(new com.anythink.basead.a.c.a.AnonymousClass6.AnonymousClass1());
            if (com.anythink.basead.a.c.a.this.g.isStarted()) {
                return;
            }
            com.anythink.basead.a.c.a.this.g.start();
        }
    }

    public a(android.content.Context context) {
        this.f = context;
        this.d = android.view.LayoutInflater.from(context).inflate(com.anythink.core.common.o.i.a(context, "myoffer_letter_top_layout", "layout"), (android.view.ViewGroup) null);
        android.view.View view = new android.view.View(context);
        this.e = view;
        view.setBackgroundResource(com.anythink.core.common.o.i.a(context, "myoffer_letter_bottom", com.anythink.expressad.foundation.h.i.c));
        this.a = (android.widget.TextView) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_btn_banner_cta", "id"));
        this.b = this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_letter_icon", "id"));
        this.l = (android.view.ViewGroup) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_four_element_container", "id"));
        this.m = (android.widget.TextView) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_version_name", "id"));
        this.n = (android.widget.TextView) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_publisher_name", "id"));
        this.o = (android.widget.TextView) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_permission_manage", "id"));
        this.p = (android.widget.TextView) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_privacy_agreement", "id"));
        this.c = (android.widget.ImageView) this.d.findViewById(com.anythink.core.common.o.i.a(context, "myoffer_ad_logo", "id"));
    }

    private void a(com.anythink.core.common.f.l lVar) {
        if (!lVar.N()) {
            android.view.ViewGroup viewGroup = this.l;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            android.widget.TextView textView = this.m;
            if (textView != null) {
                textView.setVisibility(8);
            }
            android.widget.TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            android.widget.TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            android.widget.TextView textView4 = this.o;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            try {
                android.view.View findViewById = this.d.findViewById(com.anythink.core.common.o.i.a(this.f, "myoffer_four_element_container_bg", "id"));
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(null);
                    return;
                }
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        this.m.setText(this.f.getResources().getString(com.anythink.core.common.o.i.a(this.f, "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), lVar.J()));
        this.n.setText(lVar.I());
        this.p.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass2(lVar));
        this.o.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass3(lVar));
        this.m.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass4());
        this.n.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass5());
        android.view.ViewGroup viewGroup2 = this.l;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        android.widget.TextView textView5 = this.m;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        android.widget.TextView textView6 = this.n;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        android.widget.TextView textView7 = this.p;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        android.widget.TextView textView8 = this.o;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
    }

    public final int a() {
        return this.j;
    }

    public final void a(int i) {
        this.j = (i * 111) / 300;
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = this.j;
        this.d.setLayoutParams(layoutParams);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = (android.widget.RelativeLayout.LayoutParams) this.e.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = (layoutParams.height * 200) / 111;
        this.e.setLayoutParams(layoutParams2);
        android.widget.RelativeLayout.LayoutParams layoutParams3 = (android.widget.RelativeLayout.LayoutParams) this.a.getLayoutParams();
        layoutParams3.height = (layoutParams.height * 48) / 126;
        layoutParams3.bottomMargin = (this.j / 129) * 35;
        android.widget.RelativeLayout.LayoutParams layoutParams4 = (android.widget.RelativeLayout.LayoutParams) this.b.getLayoutParams();
        int i2 = this.j;
        layoutParams4.bottomMargin = (i2 / 129) * 35;
        this.k = i2 / 3;
    }

    public final void a(android.view.View view) {
        if (this.h || this.i) {
            return;
        }
        this.h = true;
        view.postDelayed(new com.anythink.basead.a.c.a.AnonymousClass6(view), 2000L);
    }

    public final void a(android.widget.RelativeLayout relativeLayout, int i) {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(8, i);
        this.d.setLayoutParams(layoutParams);
        relativeLayout.addView(this.d, layoutParams);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(8, this.d.getId());
        layoutParams2.addRule(5, this.d.getId());
        layoutParams2.addRule(7, this.d.getId());
        relativeLayout.addView(this.e, 0, layoutParams2);
    }

    public final void a(com.anythink.core.common.f.l lVar, android.view.View.OnClickListener onClickListener) {
        if (android.text.TextUtils.isEmpty(lVar.D())) {
            this.a.setVisibility(8);
            this.b.setVisibility(0);
        } else {
            if (android.text.TextUtils.isEmpty(lVar.z())) {
                this.a.setText(com.anythink.basead.a.d.a(this.f, lVar));
            } else {
                this.a.setText(lVar.z());
            }
            this.a.setOnClickListener(onClickListener);
            this.b.setVisibility(8);
            this.a.setVisibility(0);
        }
        if (this.c != null) {
            java.lang.String y = lVar.y();
            if (android.text.TextUtils.isEmpty(y)) {
                this.c.setVisibility(8);
            } else {
                android.view.ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                com.anythink.core.common.res.b.a(this.f).a(new com.anythink.core.common.res.e(1, y), layoutParams.width, layoutParams.height, new com.anythink.basead.a.c.a.AnonymousClass1(y, layoutParams));
            }
        }
        if (!lVar.N()) {
            android.view.ViewGroup viewGroup = this.l;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            android.widget.TextView textView = this.m;
            if (textView != null) {
                textView.setVisibility(8);
            }
            android.widget.TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            android.widget.TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            android.widget.TextView textView4 = this.o;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            try {
                android.view.View findViewById = this.d.findViewById(com.anythink.core.common.o.i.a(this.f, "myoffer_four_element_container_bg", "id"));
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(null);
                    return;
                }
                return;
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        this.m.setText(this.f.getResources().getString(com.anythink.core.common.o.i.a(this.f, "myoffer_panel_version", com.anythink.expressad.foundation.h.i.g), lVar.J()));
        this.n.setText(lVar.I());
        this.p.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass2(lVar));
        this.o.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass3(lVar));
        this.m.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass4());
        this.n.setOnClickListener(new com.anythink.basead.a.c.a.AnonymousClass5());
        android.view.ViewGroup viewGroup2 = this.l;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        android.widget.TextView textView5 = this.m;
        if (textView5 != null) {
            textView5.setVisibility(0);
        }
        android.widget.TextView textView6 = this.n;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
        android.widget.TextView textView7 = this.p;
        if (textView7 != null) {
            textView7.setVisibility(0);
        }
        android.widget.TextView textView8 = this.o;
        if (textView8 != null) {
            textView8.setVisibility(0);
        }
    }

    public final int b() {
        return this.k;
    }

    public final void c() {
        this.i = true;
        try {
            android.animation.ValueAnimator valueAnimator = this.g;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.g.cancel();
        } catch (java.lang.Throwable unused) {
        }
    }
}
