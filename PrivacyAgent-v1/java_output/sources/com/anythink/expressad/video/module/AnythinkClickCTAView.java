package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkClickCTAView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.video.signal.f {
    private static final java.lang.String n = "anythink_reward_clickable_cta";
    private android.view.ViewGroup o;
    private android.widget.ImageView p;
    private android.widget.TextView q;
    private android.widget.TextView r;

    /* renamed from: s, reason: collision with root package name */
    private android.widget.TextView f272s;
    private java.lang.String t;
    private float u;
    private float v;
    private int w;
    private android.animation.ObjectAnimator x;

    /* renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.video.dynview.f.h {
        final /* synthetic */ android.view.ViewGroup a;

        public AnonymousClass1(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            this.a.addView(aVar.a());
            com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView = com.anythink.expressad.video.module.AnythinkClickCTAView.this;
            anythinkClickCTAView.f = anythinkClickCTAView.f();
            com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView2 = com.anythink.expressad.video.module.AnythinkClickCTAView.this;
            anythinkClickCTAView2.r = (android.widget.TextView) anythinkClickCTAView2.findViewById(anythinkClickCTAView2.findID("anythink_tv_desc"));
            com.anythink.expressad.video.module.AnythinkClickCTAView.this.c();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            bVar.b();
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.expressad.widget.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkClickCTAView.b(com.anythink.expressad.video.module.AnythinkClickCTAView.this);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.expressad.widget.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkClickCTAView.b(com.anythink.expressad.video.module.AnythinkClickCTAView.this);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkClickCTAView$5, reason: invalid class name */
    public class AnonymousClass5 extends com.anythink.expressad.video.module.a.a.e {
        public AnonymousClass5(android.widget.ImageView imageView, com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            super(imageView, cVar, str);
        }

        @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            super.a(str, str2);
            com.anythink.expressad.video.module.AnythinkClickCTAView.this.b();
        }
    }

    public AnythinkClickCTAView(android.content.Context context) {
        super(context);
    }

    public AnythinkClickCTAView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a() {
        int findLayout = findLayout(n);
        if (findLayout >= 0) {
            this.c.inflate(findLayout, this);
            this.f = f();
            c();
            setWrapContent();
        }
    }

    private void a(android.view.ViewGroup viewGroup, com.anythink.expressad.foundation.d.c cVar) {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c b = com.anythink.expressad.video.dynview.j.c.b(viewGroup, cVar);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(b, new com.anythink.expressad.video.module.AnythinkClickCTAView.AnonymousClass1(viewGroup));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        android.widget.ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public static /* synthetic */ void b(com.anythink.expressad.video.module.AnythinkClickCTAView anythinkClickCTAView) {
        org.json.JSONObject jSONObject;
        org.json.JSONException e;
        com.anythink.expressad.foundation.d.c cVar = anythinkClickCTAView.b;
        if (cVar != null) {
            cVar.j();
        }
        try {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkClickCTAView.a(0));
            } catch (org.json.JSONException e2) {
                e = e2;
                e.printStackTrace();
                anythinkClickCTAView.e.a(105, jSONObject);
            }
        } catch (org.json.JSONException e3) {
            jSONObject = null;
            e = e3;
        }
        anythinkClickCTAView.e.a(105, jSONObject);
    }

    private void e() {
        setWrapContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        this.o = (android.view.ViewGroup) findViewById(findID("anythink_viewgroup_ctaroot"));
        this.p = (android.widget.ImageView) findViewById(findID("anythink_iv_appicon"));
        this.q = (android.widget.TextView) findViewById(findID("anythink_tv_title"));
        android.widget.TextView textView = (android.widget.TextView) findViewById(findID("anythink_tv_install"));
        this.f272s = textView;
        return isNotNULL(this.o, this.p, this.q, textView);
    }

    private void g() {
        org.json.JSONObject jSONObject;
        org.json.JSONException e;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            cVar.j();
        }
        try {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(0));
            } catch (org.json.JSONException e2) {
                e = e2;
                e.printStackTrace();
                this.e.a(105, jSONObject);
            }
        } catch (org.json.JSONException e3) {
            jSONObject = null;
            e = e3;
        }
        this.e.a(105, jSONObject);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        if (this.f) {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar != null && cVar.j()) {
                setOnClickListener(new com.anythink.expressad.video.module.AnythinkClickCTAView.AnonymousClass2());
            }
            this.f272s.setOnClickListener(new com.anythink.expressad.video.module.AnythinkClickCTAView.AnonymousClass3());
            android.widget.ImageView imageView = this.p;
            if (imageView != null) {
                imageView.setOnClickListener(new com.anythink.expressad.video.module.AnythinkClickCTAView.AnonymousClass4());
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.animation.ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null) {
            try {
                objectAnimator.start();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        android.animation.ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null) {
            try {
                objectAnimator.cancel();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        this.u = motionEvent.getRawX();
        this.v = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.w = configuration.orientation;
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            if (cVar.j()) {
                com.anythink.expressad.foundation.d.c cVar2 = this.b;
                new com.anythink.expressad.video.dynview.j.c();
                com.anythink.expressad.video.dynview.c b = com.anythink.expressad.video.dynview.j.c.b(this, cVar2);
                com.anythink.expressad.video.dynview.b.a();
                com.anythink.expressad.video.dynview.b.a(b, new com.anythink.expressad.video.module.AnythinkClickCTAView.AnonymousClass1(this));
            } else {
                int findLayout = findLayout(n);
                if (findLayout >= 0) {
                    this.c.inflate(findLayout, this);
                    this.f = f();
                    c();
                    setWrapContent();
                }
            }
            if (this.f) {
                this.f272s.setText(this.b.cU);
                if (android.text.TextUtils.isEmpty(this.b.bd())) {
                    b();
                } else {
                    com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.AnythinkClickCTAView.AnonymousClass5(this.p, this.b, this.t));
                }
                if (this.q != null && !android.text.TextUtils.isEmpty(this.b.bb())) {
                    this.q.setText(this.b.bb());
                }
                if (this.r == null || android.text.TextUtils.isEmpty(this.b.bc())) {
                    return;
                }
                this.r.setText(this.b.bc());
            }
        }
    }

    public void setObjectAnimator(android.animation.ObjectAnimator objectAnimator) {
        this.x = objectAnimator;
    }

    public void setUnitId(java.lang.String str) {
        this.t = str;
    }
}
