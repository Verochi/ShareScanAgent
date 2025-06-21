package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public class AnythinkBTNativeEC extends com.anythink.expressad.video.bt.module.BTBaseView {
    private static final java.lang.String p = "anythink_reward_endcard_native_hor";
    private static final java.lang.String q = "anythink_reward_endcard_native_land";
    private android.widget.TextView A;
    private android.widget.TextView B;
    private com.anythink.expressad.videocommon.view.StarLevelView C;
    private boolean D;
    private boolean E;
    private int F;
    private java.lang.Runnable G;
    private android.view.View H;
    private android.view.View I;
    private java.lang.String J;
    private com.anythink.expressad.video.signal.a.j K;
    private android.webkit.WebView L;
    private android.view.ViewGroup r;

    /* renamed from: s, reason: collision with root package name */
    private android.view.ViewGroup f264s;
    private android.widget.RelativeLayout t;
    private android.widget.ImageView u;
    private com.anythink.expressad.videocommon.view.RoundImageView v;
    private android.widget.ImageView w;
    private android.widget.ImageView x;
    private android.widget.ImageView y;
    private android.widget.TextView z;

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this);
            if (com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.H != null) {
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.H.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                int b = com.anythink.expressad.foundation.h.t.b(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.a, 12.0f);
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.x.getLayoutParams().height = b;
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.x.getLayoutParams().width = (int) (b * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.x.setImageBitmap(bitmap);
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.x.setBackgroundColor(1426063360);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass3(java.lang.String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.a, this.a);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.D) {
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, 1);
                com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, view.getX(), view.getY());
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.L != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.d);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("unitId", com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.J);
                    jSONObject.put("data", jSONObject2);
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this.L, "onCloseBtnClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$6, reason: invalid class name */
    public class AnonymousClass6 extends com.anythink.expressad.widget.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, 0);
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, view.getX(), view.getY());
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$7, reason: invalid class name */
    public class AnonymousClass7 extends com.anythink.expressad.widget.a {
        public AnonymousClass7() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, 0);
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, view.getX(), view.getY());
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTNativeEC$8, reason: invalid class name */
    public class AnonymousClass8 extends com.anythink.expressad.widget.a {
        public AnonymousClass8() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, 0);
            com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.this, view.getX(), view.getY());
        }
    }

    public AnythinkBTNativeEC(android.content.Context context) {
        super(context);
        this.D = false;
        this.E = false;
        this.F = 0;
    }

    public AnythinkBTNativeEC(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = false;
        this.E = false;
        this.F = 0;
    }

    private static android.graphics.Bitmap a(android.graphics.drawable.Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    private void a(float f, float f2) {
        if (this.L != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                jSONObject.put("id", this.d);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("x", java.lang.String.valueOf(f));
                jSONObject2.put("y", java.lang.String.valueOf(f2));
                jSONObject.put("data", jSONObject2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (java.lang.Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a(this.L, "onClicked", this.d);
            }
        }
    }

    private void a(android.view.View view) {
        if (view == null) {
            init(this.a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((android.view.ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC anythinkBTNativeEC, float f, float f2) {
        if (anythinkBTNativeEC.L != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("code", com.anythink.expressad.video.bt.module.BTBaseView.n);
                jSONObject.put("id", anythinkBTNativeEC.d);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("x", java.lang.String.valueOf(f));
                jSONObject2.put("y", java.lang.String.valueOf(f2));
                jSONObject.put("data", jSONObject2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a(anythinkBTNativeEC.L, "onClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (java.lang.Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a(anythinkBTNativeEC.L, "onClicked", anythinkBTNativeEC.d);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC anythinkBTNativeEC, int i) {
        org.json.JSONObject jSONObject;
        com.anythink.expressad.video.signal.a.j jVar;
        org.json.JSONObject jSONObject2 = null;
        try {
            try {
                jSONObject = new org.json.JSONObject();
            } catch (java.lang.Throwable th) {
                th.getMessage();
                return;
            }
        } catch (org.json.JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkBTNativeEC.a(i));
        } catch (org.json.JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            jSONObject = jSONObject2;
            jVar = anythinkBTNativeEC.K;
            if (jVar == null) {
            }
        }
        jVar = anythinkBTNativeEC.K;
        if (jVar == null) {
            jVar.click(1, jSONObject != null ? jSONObject.toString() : "");
        }
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.video.bt.module.AnythinkBTNativeEC anythinkBTNativeEC) {
        anythinkBTNativeEC.E = true;
        return true;
    }

    private int b() {
        return findLayout(isLandscape() ? q : p);
    }

    private boolean b(int i) {
        if (isLandscape()) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.f.inflate(i, (android.view.ViewGroup) null);
            this.f264s = viewGroup;
            addView(viewGroup);
            return b(this.f264s);
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.f.inflate(i, (android.view.ViewGroup) null);
        this.r = viewGroup2;
        addView(viewGroup2);
        return b(this.r);
    }

    private boolean b(android.view.View view) {
        try {
            this.t = (android.widget.RelativeLayout) view.findViewById(findID("anythink_native_ec_layout"));
            this.u = (android.widget.ImageView) view.findViewById(findID("anythink_iv_adbanner_bg"));
            this.v = (com.anythink.expressad.videocommon.view.RoundImageView) view.findViewById(findID("anythink_iv_adbanner"));
            this.w = (android.widget.ImageView) view.findViewById(findID("anythink_iv_icon"));
            this.x = (android.widget.ImageView) view.findViewById(findID("anythink_iv_flag"));
            this.y = (android.widget.ImageView) view.findViewById(findID("anythink_iv_link"));
            this.z = (android.widget.TextView) view.findViewById(findID("anythink_tv_apptitle"));
            this.A = (android.widget.TextView) view.findViewById(findID("anythink_tv_appdesc"));
            this.B = (android.widget.TextView) view.findViewById(findID("anythink_tv_nuater"));
            this.C = (com.anythink.expressad.videocommon.view.StarLevelView) view.findViewById(findID("anythink_sv_starlevel"));
            this.H = view.findViewById(findID("anythink_iv_close"));
            android.view.View findViewById = view.findViewById(findID("anythink_tv_cta"));
            this.I = findViewById;
            return isNotNULL(this.u, this.v, this.w, this.z, this.A, this.B, this.C, this.H, findViewById);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(int i) {
        org.json.JSONObject jSONObject;
        com.anythink.expressad.video.signal.a.j jVar;
        org.json.JSONObject jSONObject2 = null;
        try {
            try {
                jSONObject = new org.json.JSONObject();
            } catch (java.lang.Throwable th) {
                th.getMessage();
                return;
            }
        } catch (org.json.JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i));
        } catch (org.json.JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            jSONObject = jSONObject2;
            jVar = this.K;
            if (jVar == null) {
            }
        }
        jVar = this.K;
        if (jVar == null) {
            jVar.click(1, jSONObject != null ? jSONObject.toString() : "");
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public final void a() {
        if (this.h) {
            this.t.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass4());
            this.H.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass5());
            this.I.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass6());
            this.w.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass7());
            this.v.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass8());
        }
    }

    @android.annotation.TargetApi(17)
    public android.graphics.Bitmap blurBitmap(android.graphics.Bitmap bitmap) {
        try {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            android.renderscript.RenderScript create = android.renderscript.RenderScript.create(this.a.getApplicationContext());
            android.renderscript.ScriptIntrinsicBlur create2 = android.renderscript.ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
            android.renderscript.Allocation createFromBitmap = android.renderscript.Allocation.createFromBitmap(create, bitmap);
            android.renderscript.Allocation createFromBitmap2 = android.renderscript.Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(10.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            bitmap.recycle();
            create.destroy();
            return createBitmap;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void init(android.content.Context context) {
        boolean b;
        int findLayout = findLayout(isLandscape() ? q : p);
        if (findLayout > 0) {
            if (isLandscape()) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.f.inflate(findLayout, (android.view.ViewGroup) null);
                this.f264s = viewGroup;
                addView(viewGroup);
                b = b(this.f264s);
            } else {
                android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.f.inflate(findLayout, (android.view.ViewGroup) null);
                this.r = viewGroup2;
                addView(viewGroup2);
                b = b(this.r);
            }
            this.h = b;
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.G == null) {
            this.G = new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass1();
        }
        java.lang.Runnable runnable = this.G;
        if (runnable != null) {
            postDelayed(runnable, this.F * 1000);
        }
        if (!this.h && this.L != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("id", this.d);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("unitId", this.J);
                jSONObject.put("data", jSONObject2);
                jSONObject.toString();
            } catch (org.json.JSONException e) {
                e.getMessage();
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onCloseBtnClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.L != null) {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put("id", this.d);
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                jSONObject4.put("unitId", this.J);
                jSONObject3.put("data", jSONObject4);
                jSONObject3.toString();
            } catch (org.json.JSONException e2) {
                e2.getMessage();
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(this.L, "onNativeECShow", android.util.Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onDestory() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        java.lang.Runnable runnable = this.G;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        int i = configuration.orientation;
        this.g = i;
        if (i == 2) {
            removeView(this.r);
            a(this.f264s);
        } else {
            removeView(this.f264s);
            a(this.r);
        }
    }

    public void preLoadData() {
        android.graphics.Bitmap blurBitmap;
        try {
            if (this.b == null || !this.h) {
                return;
            }
            com.anythink.expressad.videocommon.e.d dVar = this.e;
            if (dVar != null) {
                this.F = dVar.p();
            }
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.be(), new com.anythink.expressad.video.module.a.a.e(this.v, this.b, this.J));
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(this.w, com.anythink.expressad.foundation.h.t.b(com.anythink.expressad.foundation.b.a.b().d(), 8.0f)));
            this.z.setText(this.b.bb());
            this.A.setText(this.b.bc());
            this.B.setText(this.b.aY() + ")");
            this.C.removeAllViews();
            double aX = this.b.aX();
            if (aX <= 0.0d) {
                aX = 5.0d;
            }
            this.C.initScore(aX);
            try {
                android.graphics.Bitmap a = a(this.v.getDrawable());
                if (a != null && (blurBitmap = blurBitmap(a)) != null) {
                    this.u.setImageBitmap(blurBitmap);
                }
            } catch (java.lang.Throwable unused) {
                this.u.setVisibility(8);
            }
            if (!android.text.TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
                this.D = true;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(android.text.TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass2());
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b != null) {
                java.lang.String J = b.J();
                if (android.text.TextUtils.isEmpty(J)) {
                    this.y.setVisibility(8);
                }
                this.y.setOnClickListener(new com.anythink.expressad.video.bt.module.AnythinkBTNativeEC.AnonymousClass3(J));
            } else {
                this.y.setVisibility(8);
            }
            if (this.E) {
                return;
            }
            this.H.setVisibility(8);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void setCreateWebView(android.webkit.WebView webView) {
        this.L = webView;
    }

    public void setJSCommon(com.anythink.expressad.video.signal.a.j jVar) {
        this.K = jVar;
    }

    @Override // com.anythink.expressad.video.bt.module.BTBaseView
    public void setUnitId(java.lang.String str) {
        this.J = str;
    }
}
