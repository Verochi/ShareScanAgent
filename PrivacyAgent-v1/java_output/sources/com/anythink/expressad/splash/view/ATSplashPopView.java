package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public class ATSplashPopView extends android.widget.RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;
    private static final java.lang.String c = "ATSplashPopView";
    private static final java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(1);
    android.view.View.OnClickListener a;
    android.view.View.OnClickListener b;
    private java.lang.String e;
    private java.lang.String f;
    private int g;
    private com.anythink.expressad.foundation.d.c h;
    private com.anythink.expressad.splash.d.d i;
    private android.widget.ImageView j;
    private android.widget.ImageView k;
    private android.widget.ImageView l;
    private android.widget.ImageView m;
    private android.widget.TextView n;
    private android.widget.TextView o;
    private android.widget.TextView p;
    private int q;
    private android.os.Handler r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f262s;
    private com.anythink.expressad.a.a t;
    private java.lang.Runnable u;

    /* renamed from: com.anythink.expressad.splash.view.ATSplashPopView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ boolean a;

        public AnonymousClass1(boolean z) {
            this.a = z;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                android.graphics.Bitmap a = this.a ? com.anythink.expressad.foundation.h.n.a(bitmap) : com.anythink.expressad.foundation.h.n.a(bitmap, 16);
                android.widget.ImageView imageView = com.anythink.expressad.splash.view.ATSplashPopView.this.j;
                if (a != null) {
                    bitmap = a;
                }
                imageView.setImageBitmap(bitmap);
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashPopView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashPopView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                com.anythink.expressad.splash.view.ATSplashPopView.this.k.setImageBitmap(com.anythink.expressad.foundation.h.n.a(bitmap, 16));
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashPopView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.splash.view.ATSplashPopView.this.p != null) {
                if (com.anythink.expressad.splash.view.ATSplashPopView.this.q != 0) {
                    com.anythink.expressad.splash.view.ATSplashPopView.j(com.anythink.expressad.splash.view.ATSplashPopView.this);
                    com.anythink.expressad.splash.view.ATSplashPopView.this.p.setText(java.lang.String.valueOf(com.anythink.expressad.splash.view.ATSplashPopView.this.q));
                    com.anythink.expressad.splash.view.ATSplashPopView.this.r.postDelayed(com.anythink.expressad.splash.view.ATSplashPopView.this.u, 1000L);
                } else {
                    com.anythink.expressad.splash.view.ATSplashPopView.e(com.anythink.expressad.splash.view.ATSplashPopView.this);
                    com.anythink.expressad.splash.view.ATSplashPopView.this.g();
                    com.anythink.expressad.splash.view.ATSplashPopView.this.r.removeCallbacks(com.anythink.expressad.splash.view.ATSplashPopView.this.u);
                    if (com.anythink.expressad.splash.view.ATSplashPopView.this.i != null) {
                        com.anythink.expressad.splash.view.ATSplashPopView.this.i.b();
                    }
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashPopView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.splash.view.ATSplashPopView.this.i != null) {
                com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView = com.anythink.expressad.splash.view.ATSplashPopView.this;
                com.anythink.expressad.splash.view.ATSplashPopView.a(aTSplashPopView, aTSplashPopView.h);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashPopView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.splash.view.ATSplashPopView.this.q > 0) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (com.anythink.expressad.splash.view.ATSplashPopView.this.i != null) {
                com.anythink.expressad.splash.view.ATSplashPopView.this.i.b();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class a {
        private java.lang.String a;
        private java.lang.String b;
        private int c;
        private com.anythink.expressad.foundation.d.c d;

        public a(java.lang.String str, java.lang.String str2, int i, com.anythink.expressad.foundation.d.c cVar) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = cVar;
        }

        private void a(int i) {
            this.c = i;
        }

        private void a(com.anythink.expressad.foundation.d.c cVar) {
            this.d = cVar;
        }

        private void a(java.lang.String str) {
            this.a = str;
        }

        private void b(java.lang.String str) {
            this.b = str;
        }

        public final java.lang.String a() {
            return this.a;
        }

        public final java.lang.String b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final com.anythink.expressad.foundation.d.c d() {
            return this.d;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface b {
    }

    public ATSplashPopView(android.content.Context context) {
        super(context);
        this.g = 1;
        this.q = -1;
        this.r = new android.os.Handler();
        this.f262s = false;
        this.u = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass4();
        this.a = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass5();
        this.b = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass6();
        this.g = 1;
    }

    public ATSplashPopView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 1;
        this.q = -1;
        this.r = new android.os.Handler();
        this.f262s = false;
        this.u = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass4();
        this.a = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass5();
        this.b = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass6();
        this.g = 1;
    }

    public ATSplashPopView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 1;
        this.q = -1;
        this.r = new android.os.Handler();
        this.f262s = false;
        this.u = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass4();
        this.a = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass5();
        this.b = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass6();
        this.g = 1;
    }

    @androidx.annotation.RequiresApi(api = 21)
    public ATSplashPopView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.g = 1;
        this.q = -1;
        this.r = new android.os.Handler();
        this.f262s = false;
        this.u = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass4();
        this.a = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass5();
        this.b = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass6();
        this.g = 1;
    }

    public ATSplashPopView(android.content.Context context, com.anythink.expressad.splash.view.ATSplashPopView.a aVar, com.anythink.expressad.splash.d.d dVar) {
        super(context);
        this.g = 1;
        this.q = -1;
        this.r = new android.os.Handler();
        this.f262s = false;
        this.u = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass4();
        this.a = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass5();
        this.b = new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass6();
        if (aVar == null) {
            throw new java.lang.IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f = aVar.b();
        this.e = aVar.a();
        this.g = aVar.c();
        this.h = aVar.d();
        this.i = dVar;
        a();
    }

    private void a() {
        if (this.h == null) {
            return;
        }
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -2));
        int i = this.g;
        if (i == 1) {
            b();
            return;
        }
        if (i == 2) {
            c();
        } else if (i == 3) {
            d();
        } else {
            if (i != 4) {
                return;
            }
            e();
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.splash.d.d dVar = this.i;
        if (dVar != null) {
            dVar.a(cVar);
            this.i.b();
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView, com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.splash.d.d dVar = aTSplashPopView.i;
        if (dVar != null) {
            dVar.a(cVar);
            aTSplashPopView.i.b();
        }
    }

    private void a(java.lang.String str) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(str, new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass2());
    }

    private void a(java.lang.String str, boolean z) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(str, new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass1(z));
    }

    private void b() {
        android.view.View imageView = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 80.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("anythink_splash_popview_default", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        this.j = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 60.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 7.0f);
        layoutParams2.leftMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams2);
        this.j.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        com.anythink.expressad.foundation.d.c cVar = this.h;
        if (cVar != null && !android.text.TextUtils.isEmpty(cVar.bd())) {
            a(this.h.bd(), true);
        }
        this.p = new android.widget.TextView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 62.0f);
        layoutParams3.bottomMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 70.0f);
        this.p.setId(generateViewId());
        this.p.setTextSize(10.0f);
        this.p.setTextColor(-1);
        this.p.setGravity(17);
        this.p.setMinWidth(com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f));
        this.p.setMaxHeight(com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f));
        this.p.setLayoutParams(layoutParams3);
        this.p.setBackgroundResource(getResources().getIdentifier("anythink_cm_circle_50black", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(imageView);
        addView(this.p);
        addView(this.j);
        com.anythink.expressad.foundation.d.c cVar2 = this.h;
        if (cVar2 != null && cVar2.u() <= 0) {
            g();
        }
        setOnClickListener(this.a);
        this.p.setOnClickListener(this.b);
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.splash.d.d dVar = this.i;
        if (dVar != null) {
            dVar.a(cVar);
            this.i.b();
        }
    }

    private void b(java.lang.String str) {
        com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(str, new com.anythink.expressad.splash.view.ATSplashPopView.AnonymousClass3());
    }

    private void c() {
        int b2 = com.anythink.expressad.foundation.h.t.b(getContext(), 4.0f);
        this.j = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 28.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams);
        this.j.setPadding(b2, b2, b2, b2);
        this.j.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        a(this.h.bd(), false);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        this.n = textView;
        textView.setId(generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.j.getId());
        layoutParams2.addRule(6, this.j.getId());
        layoutParams2.addRule(8, this.j.getId());
        layoutParams2.leftMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 4.0f);
        layoutParams2.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 40.0f);
        this.n.setLayoutParams(layoutParams2);
        this.n.setGravity(16);
        this.n.setTextSize(10.0f);
        this.n.setSelected(true);
        this.n.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSingleLine(true);
        this.n.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.n.setText(this.h.bb());
        setBackgroundResource(getResources().getIdentifier("anythink_shape_corners_bg", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.j);
        addView(this.n);
        f();
        setOnClickListener(this.a);
    }

    private void d() {
        int b2 = com.anythink.expressad.foundation.h.t.b(getContext(), 4.0f);
        this.j = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams);
        this.j.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        this.j.setPadding(b2, b2, b2, b2);
        a(this.h.bd(), false);
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.j.getId());
        layoutParams2.addRule(6, this.j.getId());
        layoutParams2.addRule(8, this.j.getId());
        layoutParams2.leftMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 8.0f);
        layoutParams2.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        this.n = textView;
        textView.setId(generateViewId());
        this.n.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
        this.n.setGravity(16);
        this.n.setTextSize(12.0f);
        this.n.setSelected(true);
        this.n.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSingleLine(true);
        this.n.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.n.setText(this.h.bb());
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        this.o = textView2;
        textView2.setId(generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.n.getId());
        layoutParams3.addRule(3, this.n.getId());
        layoutParams3.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 4.0f);
        layoutParams3.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 36.0f);
        this.o.setGravity(16);
        this.o.setLayoutParams(layoutParams3);
        this.o.setTextSize(8.0f);
        this.o.setTextColor(-10066330);
        this.o.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        this.o.setMarqueeRepeatLimit(-1);
        this.o.setSelected(true);
        this.o.setSingleLine(true);
        this.o.setText(this.h.bc());
        relativeLayout.addView(this.n);
        relativeLayout.addView(this.o);
        setBackgroundResource(getResources().getIdentifier("anythink_shape_corners_bg", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.j);
        addView(relativeLayout);
        f();
        setOnClickListener(this.a);
    }

    public static /* synthetic */ int e(com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView) {
        aTSplashPopView.q = -1;
        return -1;
    }

    private void e() {
        this.l = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, com.anythink.expressad.foundation.h.t.b(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.l.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        this.l.setId(generateViewId());
        this.l.setLayoutParams(layoutParams);
        a(this.h.be());
        this.k = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, com.anythink.expressad.foundation.h.t.b(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.k.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        this.k.setId(generateViewId());
        this.k.setLayoutParams(layoutParams2);
        b(this.h.be());
        this.j = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.l.getId());
        layoutParams3.topMargin = 20;
        this.j.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        this.j.setId(generateViewId());
        this.j.setLayoutParams(layoutParams3);
        a(this.h.bd(), false);
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.j.getId());
        layoutParams4.addRule(6, this.j.getId());
        layoutParams4.addRule(8, this.j.getId());
        layoutParams4.leftMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 8.0f);
        layoutParams4.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        android.widget.TextView textView = new android.widget.TextView(getContext());
        this.n = textView;
        textView.setId(generateViewId());
        this.n.setGravity(16);
        this.n.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
        this.n.setTextSize(12.0f);
        this.n.setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
        this.n.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        this.n.setMarqueeRepeatLimit(-1);
        this.n.setSelected(true);
        this.n.setSingleLine(true);
        this.n.setText(this.h.bb());
        android.widget.TextView textView2 = new android.widget.TextView(getContext());
        this.o = textView2;
        textView2.setId(generateViewId());
        android.widget.RelativeLayout.LayoutParams layoutParams5 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.n.getId());
        layoutParams5.addRule(3, this.n.getId());
        layoutParams5.topMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 4.0f);
        layoutParams5.rightMargin = com.anythink.expressad.foundation.h.t.b(getContext(), 36.0f);
        this.o.setGravity(16);
        this.o.setLayoutParams(layoutParams5);
        this.o.setTextSize(8.0f);
        this.o.setTextColor(-10066330);
        this.o.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        this.o.setMarqueeRepeatLimit(-1);
        this.o.setSelected(true);
        this.o.setSingleLine(true);
        this.o.setText(this.h.bc());
        relativeLayout.addView(this.n);
        relativeLayout.addView(this.o);
        addView(this.l);
        addView(this.k);
        addView(this.j);
        addView(relativeLayout);
        f();
        setOnClickListener(this.a);
    }

    private void f() {
        java.lang.String str;
        this.m = new android.widget.ImageView(getContext());
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(getContext(), 32.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.j.getId());
        this.m.setLayoutParams(layoutParams);
        try {
            str = getResources().getConfiguration().locale.getLanguage();
        } catch (java.lang.Throwable th) {
            th.getMessage();
            str = "ZH";
        }
        this.m.setBackgroundResource((str.toUpperCase().equals("CN") || str.toUpperCase().equals("ZH")) ? getResources().getIdentifier("anythink_splash_ad", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()) : getResources().getIdentifier("anythink_splash_ad_en", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        addView(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        android.widget.TextView textView = this.p;
        if (textView != null) {
            android.view.ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f);
            layoutParams.height = com.anythink.expressad.foundation.h.t.b(getContext(), 16.0f);
            this.p.setLayoutParams(layoutParams);
            this.p.setText("");
            this.p.setBackgroundResource(getResources().getIdentifier("anythink_splash_popview_close", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    public static int generateViewId() {
        java.util.concurrent.atomic.AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = d;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static /* synthetic */ int j(com.anythink.expressad.splash.view.ATSplashPopView aTSplashPopView) {
        int i = aTSplashPopView.q;
        aTSplashPopView.q = i - 1;
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i != null) {
            getWidth();
            getHeight();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.f262s = true;
        if (this.p != null) {
            this.r.removeCallbacks(this.u);
        }
    }

    public void reStartCountDown() {
        if (this.f262s) {
            this.f262s = false;
            int i = this.q;
            if (i == -1 || i == 0) {
                g();
                return;
            }
            android.widget.TextView textView = this.p;
            if (textView != null) {
                textView.setText(java.lang.String.valueOf(i));
                this.r.postDelayed(this.u, 1000L);
            }
        }
    }

    public void release() {
        try {
            this.r.removeCallbacks(this.u);
            this.u = null;
            detachAllViewsFromParent();
            this.h = null;
            this.i = null;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setPopViewType(com.anythink.expressad.splash.view.ATSplashPopView.a aVar, com.anythink.expressad.splash.d.d dVar) {
        if (aVar == null) {
            throw new java.lang.IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f = aVar.b();
        this.e = aVar.a();
        this.g = aVar.c();
        this.h = aVar.d();
        this.i = dVar;
        a();
    }

    public void startCountDown() {
        this.r.removeCallbacks(this.u);
        com.anythink.expressad.foundation.d.c cVar = this.h;
        if (cVar == null || this.g != 1) {
            return;
        }
        int u = cVar.u();
        if (u <= 0) {
            g();
            return;
        }
        this.q = u;
        android.widget.TextView textView = this.p;
        if (textView != null) {
            textView.setText(java.lang.String.valueOf(u));
            this.r.postDelayed(this.u, 1000L);
        }
    }
}
