package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkVideoEndCoverView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.video.signal.f {
    private final java.lang.String n;
    private android.view.View o;
    private android.widget.ImageView p;
    private android.widget.ImageView q;
    private android.widget.TextView r;

    /* renamed from: s, reason: collision with root package name */
    private android.widget.TextView f276s;
    private android.widget.TextView t;
    private com.anythink.expressad.video.signal.factory.b u;

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoEndCoverView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkVideoEndCoverView.this.e.a(104, "");
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoEndCoverView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkVideoEndCoverView.this.a();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkVideoEndCoverView$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkVideoEndCoverView.this.a();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public AnythinkVideoEndCoverView(android.content.Context context) {
        super(context);
        this.n = "AnythinkVideoEndCoverView";
    }

    public AnythinkVideoEndCoverView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = "AnythinkVideoEndCoverView";
    }

    private boolean a(android.view.View view) {
        if (view == null) {
            return true;
        }
        try {
            this.p = (android.widget.ImageView) view.findViewById(findID("anythink_vec_iv_icon"));
            this.q = (android.widget.ImageView) view.findViewById(findID("anythink_vec_iv_close"));
            this.r = (android.widget.TextView) view.findViewById(findID("anythink_vec_tv_title"));
            this.f276s = (android.widget.TextView) view.findViewById(findID("anythink_vec_tv_desc"));
            this.t = (android.widget.TextView) view.findViewById(findID("anythink_vec_btn"));
            return true;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private void b() {
        android.view.View view = this.o;
        if (view == null) {
            init(this.a);
            preLoadData(this.u);
            return;
        }
        if (view.getParent() != null) {
            ((android.view.ViewGroup) this.o.getParent()).removeView(this.o);
        }
        addView(this.o);
        a(this.o);
        c();
    }

    private void e() {
        android.widget.ImageView imageView;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar != null) {
            if (!android.text.TextUtils.isEmpty(cVar.bd()) && (imageView = this.p) != null) {
                com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(imageView, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 8.0f)));
            }
            android.widget.TextView textView = this.r;
            if (textView != null) {
                textView.setText(this.b.bb());
            }
            android.widget.TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setText(this.b.cU);
            }
            android.widget.TextView textView3 = this.f276s;
            if (textView3 != null) {
                textView3.setText(this.b.bc());
            }
        }
    }

    public final void a() {
        org.json.JSONObject jSONObject;
        org.json.JSONException e;
        org.json.JSONObject jSONObject2;
        org.json.JSONException e2;
        try {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject2 = new org.json.JSONObject();
                try {
                    jSONObject2.put(com.anythink.expressad.foundation.g.a.cc, com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), this.g));
                    jSONObject2.put(com.anythink.expressad.foundation.g.a.cd, com.anythink.expressad.foundation.h.t.a(com.anythink.core.common.b.o.a().f(), this.h));
                    jSONObject2.put(com.anythink.expressad.foundation.g.a.cf, 0);
                    try {
                        this.d = getContext().getResources().getConfiguration().orientation;
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                    jSONObject2.put(com.anythink.expressad.foundation.g.a.cg, this.d);
                    jSONObject2.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(getContext()));
                } catch (org.json.JSONException e4) {
                    e2 = e4;
                    e2.getMessage();
                    jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
                    this.e.a(105, jSONObject);
                }
            } catch (org.json.JSONException e5) {
                jSONObject2 = jSONObject3;
                e2 = e5;
            }
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, jSONObject2);
            } catch (org.json.JSONException e6) {
                e = e6;
                e.printStackTrace();
                this.e.a(105, jSONObject);
            }
        } catch (org.json.JSONException e7) {
            jSONObject = null;
            e = e7;
        }
        this.e.a(105, jSONObject);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        this.q.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoEndCoverView.AnonymousClass1());
        this.p.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoEndCoverView.AnonymousClass2());
        this.t.setOnClickListener(new com.anythink.expressad.video.module.AnythinkVideoEndCoverView.AnonymousClass3());
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        int findLayout = findLayout("anythink_reward_videoend_cover");
        if (findLayout >= 0) {
            android.view.View inflate = this.c.inflate(findLayout, (android.view.ViewGroup) null);
            this.o = inflate;
            if (inflate != null) {
                this.f = a(inflate);
                addView(this.o, -1, -1);
                c();
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        this.g = motionEvent.getRawX();
        this.h = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        this.d = configuration.orientation;
        removeView(this.o);
        android.view.View view = this.o;
        if (view == null) {
            init(this.a);
            preLoadData(this.u);
            return;
        }
        if (view.getParent() != null) {
            ((android.view.ViewGroup) this.o.getParent()).removeView(this.o);
        }
        addView(this.o);
        a(this.o);
        c();
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        android.widget.ImageView imageView;
        this.u = bVar;
        try {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar == null || !this.f || cVar == null) {
                return;
            }
            if (!android.text.TextUtils.isEmpty(cVar.bd()) && (imageView = this.p) != null) {
                com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(imageView, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 8.0f)));
            }
            android.widget.TextView textView = this.r;
            if (textView != null) {
                textView.setText(this.b.bb());
            }
            android.widget.TextView textView2 = this.t;
            if (textView2 != null) {
                textView2.setText(this.b.cU);
            }
            android.widget.TextView textView3 = this.f276s;
            if (textView3 != null) {
                textView3.setText(this.b.bc());
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }
}
