package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public class ATSplashNativeView extends android.widget.RelativeLayout {
    private static final java.lang.String a = "MBSplashNativeView";
    private int A;
    private int B;
    private float C;
    private float D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private java.lang.String J;
    private java.lang.String K;
    private com.anythink.expressad.splash.view.ATSplashView L;
    private com.anythink.expressad.foundation.d.c M;
    private com.anythink.expressad.shake.MBShakeView N;
    private java.lang.String O;
    private java.lang.String P;
    private java.lang.String Q;
    private com.anythink.expressad.shake.b R;
    private com.anythink.expressad.splash.view.MBNoRecycledCrashImageView b;
    private com.anythink.expressad.splash.view.MBNoRecycledCrashImageView c;
    private android.widget.RelativeLayout d;
    private android.widget.ImageView e;
    private com.anythink.expressad.widget.FeedBackButton f;
    private android.widget.TextView g;
    private android.widget.RelativeLayout h;
    private com.anythink.expressad.splash.view.MBNoRecycledCrashImageView i;
    private android.widget.TextView j;
    private com.anythink.expressad.splash.view.MBNoRecycledCrashImageView k;
    private android.widget.TextView l;
    private android.widget.TextView m;
    private android.widget.RelativeLayout n;
    private android.widget.TextView o;
    private android.widget.TextView p;
    private android.widget.TextView q;
    private com.anythink.expressad.splash.view.MBSplashClickView r;

    /* renamed from: s, reason: collision with root package name */
    private int f261s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$1$1, reason: invalid class name and collision with other inner class name */
        public class C02231 implements com.anythink.core.common.o.c.a {
            public C02231() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a() {
            }

            @Override // com.anythink.core.common.o.c.a
            public final void a(android.graphics.Bitmap bitmap) {
                if (bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                com.anythink.expressad.splash.view.ATSplashNativeView.this.b.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                com.anythink.expressad.splash.view.ATSplashNativeView.this.b.setImageBitmap(bitmap);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() < bitmap.getHeight()) {
                        com.anythink.expressad.splash.view.ATSplashNativeView.a(com.anythink.expressad.splash.view.ATSplashNativeView.this);
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.h.setVisibility(4);
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.c.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.c.setImageBitmap(bitmap);
                    } else if (com.anythink.expressad.splash.view.ATSplashNativeView.this.A == 1) {
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.h.setVisibility(0);
                        try {
                            android.graphics.Bitmap a = com.anythink.expressad.foundation.h.n.a(bitmap, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f));
                            if (a != null && !a.isRecycled()) {
                                com.anythink.expressad.splash.view.ATSplashNativeView.this.k.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                                com.anythink.expressad.splash.view.ATSplashNativeView.this.k.setImageBitmap(a);
                            }
                        } catch (java.lang.Throwable th) {
                            try {
                                th.getMessage();
                                com.anythink.expressad.splash.view.ATSplashNativeView.this.k.setImageBitmap(bitmap);
                            } catch (java.lang.Throwable th2) {
                                th2.getMessage();
                            }
                        }
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.j.setText(com.anythink.expressad.splash.view.ATSplashNativeView.this.M.bb());
                        com.anythink.expressad.splash.view.ATSplashNativeView.h(com.anythink.expressad.splash.view.ATSplashNativeView.this);
                    } else {
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.h.setVisibility(4);
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.c.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.c.setImageBitmap(bitmap);
                    }
                    try {
                        com.anythink.core.common.o.c.a(com.anythink.core.common.b.o.a().f(), bitmap, new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass1.C02231());
                    } catch (java.lang.Throwable unused) {
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.c.setImageBitmap(bitmap);
                    }
                } catch (java.lang.Throwable th3) {
                    th3.getMessage();
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$10, reason: invalid class name */
    public class AnonymousClass10 implements android.view.View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.splash.view.ATSplashNativeView.this.G) {
                if (com.anythink.expressad.splash.view.ATSplashNativeView.this.L.getSplashJSBridgeImpl() != null && com.anythink.expressad.splash.view.ATSplashNativeView.this.L.getSplashJSBridgeImpl().getSplashBridgeListener() != null) {
                    com.anythink.expressad.splash.view.ATSplashNativeView.this.L.getSplashJSBridgeImpl().getSplashBridgeListener().c();
                }
                com.anythink.expressad.splash.view.ATSplashNativeView.this.g.setVisibility(4);
                com.anythink.expressad.splash.view.ATSplashNativeView.this.g.setEnabled(false);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$11, reason: invalid class name */
    public class AnonymousClass11 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass11() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            com.anythink.expressad.splash.view.ATSplashNativeView.this.I = true;
            com.anythink.expressad.splash.view.ATSplashNativeView.b(com.anythink.expressad.splash.view.ATSplashNativeView.this, false);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            com.anythink.expressad.splash.view.ATSplashNativeView.this.I = false;
            com.anythink.expressad.splash.view.ATSplashNativeView.b(com.anythink.expressad.splash.view.ATSplashNativeView.this, true);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            com.anythink.expressad.splash.view.ATSplashNativeView.this.I = false;
            com.anythink.expressad.splash.view.ATSplashNativeView.b(com.anythink.expressad.splash.view.ATSplashNativeView.this, true);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.splash.view.ATSplashNativeView.a(com.anythink.expressad.splash.view.ATSplashNativeView.this, 0);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.expressad.shake.b {
        public AnonymousClass3(int i, int i2) {
            super(i, i2);
        }

        @Override // com.anythink.expressad.shake.b
        public final void a() {
            if (com.anythink.expressad.splash.view.ATSplashNativeView.this.I || com.anythink.expressad.splash.view.ATSplashNativeView.this.H || !com.anythink.expressad.splash.view.ATSplashNativeView.this.isShown()) {
                return;
            }
            com.anythink.expressad.splash.view.ATSplashNativeView.a(com.anythink.expressad.splash.view.ATSplashNativeView.this, 4);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            android.graphics.Bitmap a;
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        if (com.anythink.expressad.splash.view.ATSplashNativeView.this.i == null || (a = com.anythink.expressad.foundation.h.n.a(bitmap, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 40.0f))) == null || a.isRecycled()) {
                            return;
                        }
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.i.setImageBitmap(a);
                    } catch (java.lang.Throwable th) {
                        th.getMessage();
                        com.anythink.expressad.splash.view.ATSplashNativeView.this.i.setImageBitmap(bitmap);
                    }
                } catch (java.lang.Throwable th2) {
                    th2.getMessage();
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.splash.view.ATSplashNativeView.this.i.setVisibility(4);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass5(java.lang.String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.expressad.splash.view.ATSplashNativeView.this.getContext(), this.a);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$6, reason: invalid class name */
    public class AnonymousClass6 implements android.view.View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.splash.view.ATSplashNativeView.a(com.anythink.expressad.splash.view.ATSplashNativeView.this, 1);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.splash.view.ATSplashNativeView.a(com.anythink.expressad.splash.view.ATSplashNativeView.this, 0);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.splash.view.ATSplashNativeView.this.M.aG() != null) {
                java.lang.String c = com.anythink.expressad.splash.view.ATSplashNativeView.this.M.aG().c();
                if (!android.text.TextUtils.isEmpty(c)) {
                    com.anythink.core.common.o.m.a(com.anythink.expressad.splash.view.ATSplashNativeView.this.getContext(), c);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.view.ATSplashNativeView$9, reason: invalid class name */
    public class AnonymousClass9 implements android.view.View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.foundation.d.a aG = com.anythink.expressad.splash.view.ATSplashNativeView.this.M.aG();
            if (aG != null) {
                com.anythink.core.common.o.m.a(com.anythink.core.common.b.o.a().f(), aG.a());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public ATSplashNativeView(android.content.Context context) {
        super(context);
        this.H = false;
        this.I = false;
    }

    public ATSplashNativeView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ATSplashNativeView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.H = false;
        this.I = false;
    }

    public ATSplashNativeView(android.content.Context context, com.anythink.expressad.splash.view.ATSplashView aTSplashView, com.anythink.expressad.splash.a.b bVar) {
        super(context);
        this.H = false;
        this.I = false;
        if (bVar == null) {
            throw new java.lang.IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.J = bVar.b();
        this.K = bVar.a();
        this.M = bVar.c();
        this.L = aTSplashView;
        this.f261s = bVar.e();
        this.v = bVar.f();
        this.u = bVar.g();
        this.w = bVar.h();
        this.x = bVar.i();
        this.y = bVar.j();
        this.z = bVar.k();
        this.A = bVar.l();
        this.G = bVar.d();
        this.B = bVar.m();
        try {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(this.A == 1 ? com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_portrait", "layout") : com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_landscape", "layout"), (android.view.ViewGroup) null);
            addView(inflate);
            this.b = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_image_bg", "id"));
            this.c = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_image", "id"));
            this.d = (android.widget.RelativeLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_topcontroller", "id"));
            this.e = (android.widget.ImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_link", "id"));
            this.f = (com.anythink.expressad.widget.FeedBackButton) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_feedback", "id"));
            this.g = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_skip", "id"));
            this.h = (android.widget.RelativeLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_landscape_foreground", "id"));
            this.i = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_icon", "id"));
            this.j = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_title", "id"));
            this.k = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_foregroundimage", "id"));
            this.l = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_adrect", "id"));
            this.n = (android.widget.RelativeLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_layout_appinfo", "id"));
            this.o = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_appinfo", "id"));
            this.p = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_privacy", "id"));
            this.q = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_permission", "id"));
            this.r = (com.anythink.expressad.splash.view.MBSplashClickView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_click", "id"));
            this.m = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_adcircle", "id"));
            int a2 = com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip", com.anythink.expressad.foundation.h.i.g);
            int a3 = com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_not", com.anythink.expressad.foundation.h.i.g);
            int a4 = com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_s", com.anythink.expressad.foundation.h.i.g);
            this.P = getContext().getResources().getString(a2);
            this.Q = getContext().getResources().getString(a3);
            this.O = getContext().getResources().getString(a4);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
        } else {
            com.anythink.expressad.widget.FeedBackButton feedBackButton = this.f;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
        if (android.text.TextUtils.isEmpty(this.M.be())) {
            this.c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.M.be(), new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass1());
        }
        e();
        if (this.M.aG() == null || this.w != 0) {
            this.n.setVisibility(8);
        } else {
            com.anythink.expressad.foundation.d.a aG = this.M.aG();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_app_name", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.b());
            sb.append("\n");
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_version", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.e());
            sb.append("\n");
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_publish", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.f());
            sb.append("\n");
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_update_time", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.d());
            this.o.setText(sb);
        }
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.M.cU);
        }
        if (this.u == 1) {
            setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass6());
        } else {
            this.r.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass7());
        }
        this.p.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass8());
        this.q.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass9());
        this.g.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass10());
        if (this.x == 1) {
            com.anythink.expressad.shake.MBShakeView mBShakeView = new com.anythink.expressad.shake.MBShakeView(getContext());
            this.N = mBShakeView;
            mBShakeView.initView(this.M.cU);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.r.setVisibility(4);
            this.r.setEnabled(false);
            this.N.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass2());
            this.R = new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass3(this.y, this.z * 1000);
        }
        updateCountDown(this.f261s);
    }

    private void a() {
        try {
            android.view.View inflate = android.view.LayoutInflater.from(getContext()).inflate(this.A == 1 ? com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_portrait", "layout") : com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_landscape", "layout"), (android.view.ViewGroup) null);
            addView(inflate);
            this.b = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_image_bg", "id"));
            this.c = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_image", "id"));
            this.d = (android.widget.RelativeLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_topcontroller", "id"));
            this.e = (android.widget.ImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_link", "id"));
            this.f = (com.anythink.expressad.widget.FeedBackButton) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_feedback", "id"));
            this.g = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_skip", "id"));
            this.h = (android.widget.RelativeLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_landscape_foreground", "id"));
            this.i = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_icon", "id"));
            this.j = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_title", "id"));
            this.k = (com.anythink.expressad.splash.view.MBNoRecycledCrashImageView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_iv_foregroundimage", "id"));
            this.l = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_adrect", "id"));
            this.n = (android.widget.RelativeLayout) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_layout_appinfo", "id"));
            this.o = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_appinfo", "id"));
            this.p = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_privacy", "id"));
            this.q = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_permission", "id"));
            this.r = (com.anythink.expressad.splash.view.MBSplashClickView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_click", "id"));
            this.m = (android.widget.TextView) inflate.findViewById(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_tv_adcircle", "id"));
            int a2 = com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip", com.anythink.expressad.foundation.h.i.g);
            int a3 = com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_not", com.anythink.expressad.foundation.h.i.g);
            int a4 = com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_count_time_can_skip_s", com.anythink.expressad.foundation.h.i.g);
            this.P = getContext().getResources().getString(a2);
            this.Q = getContext().getResources().getString(a3);
            this.O = getContext().getResources().getString(a4);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void a(int i) {
        if (this.L.getSplashJSBridgeImpl() == null || this.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        try {
            this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(com.anythink.expressad.splash.a.a.a.a(com.anythink.expressad.splash.a.a.a.a(i, this.C, this.D), this.M));
        } catch (java.lang.Throwable th) {
            th.getMessage();
            this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(this.M);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.splash.view.ATSplashNativeView aTSplashNativeView, int i) {
        if (aTSplashNativeView.L.getSplashJSBridgeImpl() == null || aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        try {
            aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(com.anythink.expressad.splash.a.a.a.a(com.anythink.expressad.splash.a.a.a.a(i, aTSplashNativeView.C, aTSplashNativeView.D), aTSplashNativeView.M));
        } catch (java.lang.Throwable th) {
            th.getMessage();
            aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(aTSplashNativeView.M);
        }
    }

    private void a(boolean z) {
        if (this.L.getSplashJSBridgeImpl() == null || this.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        this.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(z ? 2 : 1, this.t);
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.splash.view.ATSplashNativeView aTSplashNativeView) {
        aTSplashNativeView.F = true;
        return true;
    }

    private void b() {
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
        } else {
            com.anythink.expressad.widget.FeedBackButton feedBackButton = this.f;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
        if (android.text.TextUtils.isEmpty(this.M.be())) {
            this.c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.M.be(), new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass1());
        }
        e();
        if (this.M.aG() == null || this.w != 0) {
            this.n.setVisibility(8);
        } else {
            com.anythink.expressad.foundation.d.a aG = this.M.aG();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_app_name", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.b());
            sb.append("\n");
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_version", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.e());
            sb.append("\n");
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_publish", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.f());
            sb.append("\n");
            sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_update_time", com.anythink.expressad.foundation.h.i.g)));
            sb.append(aG.d());
            this.o.setText(sb);
        }
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.M.cU);
        }
        if (this.u == 1) {
            setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass6());
        } else {
            this.r.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass7());
        }
        this.p.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass8());
        this.q.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass9());
        this.g.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass10());
        if (this.x == 1) {
            com.anythink.expressad.shake.MBShakeView mBShakeView = new com.anythink.expressad.shake.MBShakeView(getContext());
            this.N = mBShakeView;
            mBShakeView.initView(this.M.cU);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.r.setVisibility(4);
            this.r.setEnabled(false);
            this.N.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass2());
            this.R = new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass3(this.y, this.z * 1000);
        }
        updateCountDown(this.f261s);
    }

    public static /* synthetic */ void b(com.anythink.expressad.splash.view.ATSplashNativeView aTSplashNativeView, boolean z) {
        if (aTSplashNativeView.L.getSplashJSBridgeImpl() == null || aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener() == null) {
            return;
        }
        aTSplashNativeView.L.getSplashJSBridgeImpl().getSplashBridgeListener().a(z ? 2 : 1, aTSplashNativeView.t);
    }

    private void c() {
        if (android.text.TextUtils.isEmpty(this.M.be())) {
            this.c.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.M.be(), new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass1());
        }
    }

    private void d() {
        if (android.text.TextUtils.isEmpty(this.M.bd())) {
            this.i.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(this.M.bd(), new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass4());
        }
    }

    private void e() {
        android.graphics.drawable.Drawable drawable;
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b != null) {
            java.lang.String J = b.J();
            if (android.text.TextUtils.isEmpty(J)) {
                this.e.setVisibility(8);
            }
            this.e.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass5(J));
        } else {
            this.e.setVisibility(8);
        }
        try {
            drawable = getResources().getDrawable(com.anythink.expressad.foundation.h.i.a(getContext().getApplicationContext(), "anythink_splash_m_circle", com.anythink.expressad.foundation.h.i.c));
            try {
                drawable.setBounds(0, 0, com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f), com.anythink.expressad.foundation.h.t.b(getContext(), 10.0f));
            } catch (java.lang.Throwable th) {
                th = th;
                th.getMessage();
                if (this.A == 1) {
                }
                if (this.B != 0) {
                    this.l.setCompoundDrawables(drawable, null, null, null);
                }
                this.l.setText(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_app_label", com.anythink.expressad.foundation.h.i.g)));
                this.m.setVisibility(4);
                return;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            drawable = null;
        }
        if (this.A == 1 || !this.F) {
            if (this.B != 0 && drawable != null) {
                this.l.setCompoundDrawables(drawable, null, null, null);
            }
            this.l.setText(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_app_label", com.anythink.expressad.foundation.h.i.g)));
            this.m.setVisibility(4);
            return;
        }
        if (this.B != 0 && drawable != null) {
            this.m.setCompoundDrawables(drawable, null, null, null);
        }
        this.m.setText(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_app_label", com.anythink.expressad.foundation.h.i.g)));
        this.l.setVisibility(4);
    }

    private void f() {
        if (this.M.aG() == null || this.w != 0) {
            this.n.setVisibility(8);
            return;
        }
        com.anythink.expressad.foundation.d.a aG = this.M.aG();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_app_name", com.anythink.expressad.foundation.h.i.g)));
        sb.append(aG.b());
        sb.append("\n");
        sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_version", com.anythink.expressad.foundation.h.i.g)));
        sb.append(aG.e());
        sb.append("\n");
        sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_publish", com.anythink.expressad.foundation.h.i.g)));
        sb.append(aG.f());
        sb.append("\n");
        sb.append(getContext().getString(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_cm_app_info_update_time", com.anythink.expressad.foundation.h.i.g)));
        sb.append(aG.d());
        this.o.setText(sb);
    }

    private void g() {
        if (this.v == 1) {
            this.r.setVisibility(8);
        } else if (this.x == 1) {
            this.r.setVisibility(8);
        } else {
            this.r.initView(this.M.cU);
        }
    }

    private void h() {
        if (this.u == 1) {
            setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass6());
        } else {
            this.r.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass7());
        }
        this.p.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass8());
        this.q.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass9());
        this.g.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass10());
    }

    public static /* synthetic */ void h(com.anythink.expressad.splash.view.ATSplashNativeView aTSplashNativeView) {
        if (android.text.TextUtils.isEmpty(aTSplashNativeView.M.bd())) {
            aTSplashNativeView.i.setVisibility(4);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(aTSplashNativeView.M.bd(), aTSplashNativeView.new AnonymousClass4());
        }
    }

    private void i() {
        if (com.anythink.expressad.foundation.f.b.a().b()) {
            this.M.l(this.J);
            com.anythink.expressad.foundation.f.b.a().a(this.J, new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass11());
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.f);
            com.anythink.expressad.foundation.f.b.a().a(this.J, this.M);
            return;
        }
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.f;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    private void j() {
        if (this.x == 1) {
            com.anythink.expressad.shake.MBShakeView mBShakeView = new com.anythink.expressad.shake.MBShakeView(getContext());
            this.N = mBShakeView;
            mBShakeView.initView(this.M.cU);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.N.setLayoutParams(layoutParams);
            addView(this.N);
            this.r.setVisibility(4);
            this.r.setEnabled(false);
            this.N.setOnClickListener(new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass2());
            this.R = new com.anythink.expressad.splash.view.ATSplashNativeView.AnonymousClass3(this.y, this.z * 1000);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.x != 1 || this.N == null || this.R == null) {
                return;
            }
            com.anythink.expressad.shake.a.a().a(this.R);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        this.C = motionEvent.getRawX();
        this.D = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        android.widget.TextView textView = this.g;
        if (textView == null || textView.getParent() == null || !(this.g.getParent() instanceof android.view.ViewGroup)) {
            return;
        }
        android.view.ViewGroup.LayoutParams layoutParams = ((android.view.ViewGroup) this.g.getParent()).getLayoutParams();
        if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
            int b = ((android.widget.RelativeLayout.LayoutParams) layoutParams).topMargin + com.anythink.core.common.o.i.b(getContext());
            int[] iArr = new int[2];
            this.g.getLocationOnScreen(iArr);
            int i5 = iArr[1];
            if (i5 < b) {
                int i6 = b - i5;
                android.view.ViewParent parent = this.g.getParent();
                if (parent instanceof android.view.ViewGroup) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) parent;
                    viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop() + i6, viewGroup.getPaddingRight(), viewGroup.getPaddingBottom() + i6);
                }
            }
        }
    }

    public void release() {
        try {
            if (this.R != null) {
                com.anythink.expressad.shake.a.a().b(this.R);
                this.R = null;
            }
            com.anythink.expressad.foundation.f.b.a().c(this.J);
            detachAllViewsFromParent();
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setIsPause(boolean z) {
        this.H = z;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.d.setPadding(i, i3, i2, i4);
    }

    public void updateCountDown(int i) {
        java.lang.String str;
        if (this.g != null) {
            this.t = i;
            if (this.G) {
                str = this.P + " " + i + this.O;
            } else {
                str = i + this.O + " " + this.Q;
            }
            this.g.setText(str);
        }
    }
}
