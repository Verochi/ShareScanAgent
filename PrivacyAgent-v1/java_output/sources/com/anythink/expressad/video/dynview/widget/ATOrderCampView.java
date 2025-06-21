package com.anythink.expressad.video.dynview.widget;

/* loaded from: classes12.dex */
public class ATOrderCampView extends com.anythink.expressad.video.module.AnythinkBaseView {
    private com.anythink.expressad.video.dynview.widget.ATOrderCampView n;
    private java.util.List<com.anythink.expressad.foundation.d.c> o;
    private int p;
    private int q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    private int f271s;
    private java.lang.String t;
    private com.anythink.expressad.widget.FeedBackButton u;
    private android.widget.ImageView v;
    private boolean w;
    private com.anythink.expressad.video.dynview.f.c x;
    private com.anythink.expressad.video.dynview.f.b y;
    private boolean z;

    /* renamed from: com.anythink.expressad.video.dynview.widget.ATOrderCampView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.video.dynview.f.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.video.dynview.f.c
        public final void a() {
            com.anythink.expressad.video.dynview.widget.ATOrderCampView.a(com.anythink.expressad.video.dynview.widget.ATOrderCampView.this);
        }

        @Override // com.anythink.expressad.video.dynview.f.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, int i) {
            if (cVar != null) {
                try {
                    com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.setCampaign(cVar);
                    com.anythink.expressad.video.dynview.widget.ATOrderCampView.a(com.anythink.expressad.video.dynview.widget.ATOrderCampView.this, cVar, i);
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.ATOrderCampView$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.video.dynview.f.h {
        final /* synthetic */ android.view.ViewGroup a;

        public AnonymousClass2(android.view.ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            try {
                com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.n.addView(aVar.a());
                com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.w = aVar.c();
                this.a.removeAllViews();
                this.a.addView(com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.n);
                com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.setViewStatus();
                if (com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.y != null) {
                    com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.y.a();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            try {
                if (com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.y != null) {
                    com.anythink.expressad.video.dynview.widget.ATOrderCampView.this.y.b();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.ATOrderCampView$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.widget.ATOrderCampView$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass4(java.lang.String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(this.a);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public ATOrderCampView(android.content.Context context) {
        super(context);
        this.w = false;
        this.x = new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass1();
        this.z = false;
    }

    public ATOrderCampView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.w = false;
        this.x = new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass1();
        this.z = false;
    }

    private void a() {
        com.anythink.expressad.video.module.a.a aVar = this.e;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(com.anythink.expressad.foundation.d.c cVar, int i, int i2) {
        org.json.JSONObject jSONObject;
        org.json.JSONException e;
        com.anythink.expressad.video.module.a.a aVar;
        if (cVar != null && cVar.j()) {
            try {
                com.anythink.expressad.foundation.d.c.C0208c M = cVar.M();
                if (M != null) {
                    M.b();
                }
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
        try {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i));
                jSONObject.put("camp_position", i2);
            } catch (org.json.JSONException e3) {
                e = e3;
                e.printStackTrace();
                aVar = this.e;
                if (aVar == null) {
                }
            }
        } catch (org.json.JSONException e4) {
            jSONObject = null;
            e = e4;
        }
        aVar = this.e;
        if (aVar == null) {
            aVar.a(105, jSONObject);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.dynview.widget.ATOrderCampView aTOrderCampView) {
        com.anythink.expressad.video.module.a.a aVar = aTOrderCampView.e;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.anythink.expressad.video.dynview.widget.ATOrderCampView aTOrderCampView, com.anythink.expressad.foundation.d.c cVar, int i) {
        org.json.JSONObject jSONObject;
        org.json.JSONException e;
        com.anythink.expressad.video.module.a.a aVar;
        if (cVar != null && cVar.j()) {
            try {
                com.anythink.expressad.foundation.d.c.C0208c M = cVar.M();
                if (M != null) {
                    M.b();
                }
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
        }
        try {
            jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put(com.anythink.expressad.foundation.g.a.ce, aTOrderCampView.a(0));
                jSONObject.put("camp_position", i);
            } catch (org.json.JSONException e3) {
                e = e3;
                e.printStackTrace();
                aVar = aTOrderCampView.e;
                if (aVar == null) {
                }
            }
        } catch (org.json.JSONException e4) {
            jSONObject = null;
            e = e4;
        }
        aVar = aTOrderCampView.e;
        if (aVar == null) {
            aVar.a(105, jSONObject);
        }
    }

    private void b() {
        android.view.animation.ScaleAnimation scaleAnimation = new android.view.animation.ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 2, 0.5f, 2, 0.5f);
        scaleAnimation.setDuration(500L);
        this.n.startAnimation(scaleAnimation);
    }

    private void e() {
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.u;
        if (feedBackButton == null) {
            return;
        }
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.o;
        if (list == null) {
            feedBackButton.setVisibility(8);
            return;
        }
        if (list.get(0) == null) {
            this.u.setVisibility(8);
            return;
        }
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            this.u.setVisibility(8);
            return;
        }
        this.t = this.o.get(0).K();
        this.b = this.o.get(0);
        com.anythink.expressad.foundation.f.b.a().a(this.t + "_2", new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass3());
        com.anythink.expressad.foundation.f.b.a().a(this.t + "_2", this.b);
        com.anythink.expressad.foundation.f.b.a().a(this.t + "_2", this.u);
    }

    private void f() {
        if (this.v == null) {
            return;
        }
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b == null) {
            this.v.setVisibility(8);
            return;
        }
        java.lang.String J = b.J();
        if (android.text.TextUtils.isEmpty(J)) {
            this.v.setVisibility(8);
        }
        this.v.setOnClickListener(new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass4(J));
    }

    public void createView(android.view.ViewGroup viewGroup) {
        if (this.o == null) {
            com.anythink.expressad.video.dynview.f.b bVar = this.y;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.anythink.expressad.video.dynview.a.a.E, this.x);
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c b = com.anythink.expressad.video.dynview.j.c.b(com.anythink.core.common.b.o.a().f(), this.o);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(b, new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass2(viewGroup), hashMap);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        this.n = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onAttachedToWindow() {
        org.json.JSONObject jSONObject;
        org.json.JSONException e;
        com.anythink.expressad.video.module.a.a aVar;
        super.onAttachedToWindow();
        if (this.o == null) {
            return;
        }
        for (int i = 0; i < this.o.size(); i++) {
            try {
                jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("camp_position", i);
                } catch (org.json.JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    aVar = this.e;
                    if (aVar == null) {
                    }
                }
            } catch (org.json.JSONException e3) {
                jSONObject = null;
                e = e3;
            }
            aVar = this.e;
            if (aVar == null) {
                aVar.a(110, jSONObject);
            }
        }
    }

    public void setCampOrderViewBuildCallback(com.anythink.expressad.video.dynview.f.b bVar) {
        this.y = bVar;
    }

    public void setCampaignExes(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.o = list;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        this.p = i;
        this.q = i2;
        this.r = i3;
        this.f271s = i4;
        setViewStatus();
    }

    public void setRewarded(boolean z) {
        this.z = z;
    }

    public void setViewStatus() {
        com.anythink.expressad.video.dynview.widget.ATOrderCampView aTOrderCampView = this.n;
        if (aTOrderCampView == null || !this.z) {
            return;
        }
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) aTOrderCampView.findViewById(filterFindViewId(this.w, "anythink_native_order_camp_controller"));
        this.u = (com.anythink.expressad.widget.FeedBackButton) this.n.findViewById(filterFindViewId(this.w, "anythink_native_order_camp_feed_btn"));
        this.v = (android.widget.ImageView) this.n.findViewById(filterFindViewId(this.w, "anythink_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.p, this.r, this.q, this.f271s);
        }
        com.anythink.expressad.widget.FeedBackButton feedBackButton = this.u;
        if (feedBackButton != null && feedBackButton != null) {
            try {
                java.util.List<com.anythink.expressad.foundation.d.c> list = this.o;
                if (list == null) {
                    feedBackButton.setVisibility(8);
                } else if (list.get(0) == null) {
                    this.u.setVisibility(8);
                } else if (com.anythink.expressad.foundation.f.b.a().b()) {
                    this.t = this.o.get(0).K();
                    this.b = this.o.get(0);
                    com.anythink.expressad.foundation.f.b.a().a(this.t + "_2", new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass3());
                    com.anythink.expressad.foundation.f.b.a().a(this.t + "_2", this.b);
                    com.anythink.expressad.foundation.f.b.a().a(this.t + "_2", this.u);
                } else {
                    this.u.setVisibility(8);
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
        android.widget.ImageView imageView = this.v;
        if (imageView == null || imageView == null) {
            return;
        }
        try {
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b == null) {
                this.v.setVisibility(8);
                return;
            }
            java.lang.String J = b.J();
            if (android.text.TextUtils.isEmpty(J)) {
                this.v.setVisibility(8);
            }
            this.v.setOnClickListener(new com.anythink.expressad.video.dynview.widget.ATOrderCampView.AnonymousClass4(J));
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public void startAlphaAnimation() {
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.n.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        android.view.animation.TranslateAnimation translateAnimation = new android.view.animation.TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.n.startAnimation(translateAnimation);
    }
}
