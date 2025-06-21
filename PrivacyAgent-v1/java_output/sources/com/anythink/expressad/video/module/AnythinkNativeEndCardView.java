package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkNativeEndCardView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.video.signal.f {
    private static final java.lang.String n = "anythink_reward_endcard_native_hor";
    private static final java.lang.String o = "anythink_reward_endcard_native_land";
    private static final java.lang.String p = "anythink_reward_endcard_native_half_portrait";
    private static final java.lang.String q = "anythink_reward_endcard_native_half_landscape";
    private android.widget.ImageView A;
    private android.widget.TextView B;
    private android.widget.TextView C;
    private android.widget.TextView D;
    private android.widget.LinearLayout E;
    private com.anythink.expressad.widget.FeedBackButton F;
    private java.lang.Runnable G;
    private android.widget.RelativeLayout H;
    private com.anythink.expressad.video.signal.factory.b I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private android.view.animation.AlphaAnimation P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private android.view.View V;
    private android.widget.TextView W;
    private boolean aa;
    private java.lang.String ab;
    private com.anythink.expressad.foundation.d.d ac;
    private com.anythink.expressad.shake.MBShakeView ad;
    private com.anythink.expressad.shake.b ae;
    private com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView af;
    private int ag;
    private android.view.ViewGroup r;

    /* renamed from: s, reason: collision with root package name */
    private android.view.ViewGroup f275s;
    private android.widget.RelativeLayout t;
    private android.widget.RelativeLayout u;
    private android.widget.ImageView v;
    private android.widget.ImageView w;
    private android.widget.ImageView x;
    private android.widget.ImageView y;
    private android.widget.ImageView z;

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this);
            if (com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.V != null) {
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.V.setVisibility(0);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$10, reason: invalid class name */
    public class AnonymousClass10 implements com.anythink.expressad.video.dynview.f.h {
        public AnonymousClass10() {
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.addView(aVar.a());
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.U = aVar.c();
            com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = com.anythink.expressad.video.module.AnythinkNativeEndCardView.this;
            anythinkNativeEndCardView.f = anythinkNativeEndCardView.b(aVar.a());
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.e();
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            bVar.b();
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$11, reason: invalid class name */
    public class AnonymousClass11 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass11() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                if (com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.w != null) {
                    com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView = com.anythink.expressad.video.module.AnythinkNativeEndCardView.this;
                    if (anythinkNativeEndCardView.i) {
                        anythinkNativeEndCardView.w.setBackgroundDrawable(null);
                    }
                    com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.w.setImageBitmap(bitmap);
                }
                android.graphics.Bitmap blurBitmap = com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.blurBitmap(bitmap);
                if (blurBitmap == null || blurBitmap.isRecycled() || com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.v == null) {
                    return;
                }
                com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView2 = com.anythink.expressad.video.module.AnythinkNativeEndCardView.this;
                if (anythinkNativeEndCardView2.i) {
                    anythinkNativeEndCardView2.v.setBackgroundDrawable(null);
                }
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.v.setImageBitmap(blurBitmap);
            } catch (java.lang.Throwable unused) {
                if (com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.v != null) {
                    com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.v.setVisibility(4);
                }
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$12, reason: invalid class name */
    public class AnonymousClass12 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass12() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap == null || bitmap.isRecycled() || bitmap.isRecycled()) {
                return;
            }
            try {
                int b = com.anythink.expressad.foundation.h.t.b(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.a, 12.0f);
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.y.getLayoutParams().height = b;
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.y.getLayoutParams().width = (int) (b * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.y.setImageBitmap(bitmap);
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.y.setBackgroundColor(1426063360);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$13, reason: invalid class name */
    public class AnonymousClass13 implements android.view.View.OnClickListener {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass13(java.lang.String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.core.common.o.m.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.a, this.a);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$14, reason: invalid class name */
    public class AnonymousClass14 implements android.view.View.OnClickListener {
        public AnonymousClass14() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.J) {
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 1);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$15, reason: invalid class name */
    public class AnonymousClass15 implements android.view.View.OnClickListener {
        public AnonymousClass15() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.e.a(104, "");
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$16, reason: invalid class name */
    public class AnonymousClass16 extends com.anythink.expressad.widget.a {
        public AnonymousClass16() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$17, reason: invalid class name */
    public class AnonymousClass17 extends com.anythink.expressad.widget.a {
        public AnonymousClass17() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.expressad.widget.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.foundation.d.c cVar = com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.b;
            if (cVar != null && !cVar.j() && com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.b.f() != 2) {
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.H.setPadding(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.Q, com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.S, com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.R, com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.T);
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.H.startAnimation(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.P);
            }
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.H.setVisibility(0);
            if (com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.V.getVisibility() != 0 && com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.K) {
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.V.setVisibility(0);
            }
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.o(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.O = true;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.O = false;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.O = false;
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 0);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$6, reason: invalid class name */
    public class AnonymousClass6 extends com.anythink.expressad.shake.b {
        public AnonymousClass6(int i, int i2) {
            super(i, i2);
        }

        @Override // com.anythink.expressad.shake.b
        public final void a() {
            if (!com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.O && com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.N && com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.isShown()) {
                com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 4);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnAttachStateChangeListener {
        boolean a = false;

        public AnonymousClass7() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(@androidx.annotation.NonNull android.view.View view) {
            if (this.a || com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.ae == null) {
                return;
            }
            this.a = true;
            com.anythink.expressad.shake.a.a().a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.ae);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(@androidx.annotation.NonNull android.view.View view) {
            if (com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.ae != null) {
                com.anythink.expressad.shake.a.a().b(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.ae);
            }
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.this.ae = null;
            this.a = false;
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 0);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkNativeEndCardView$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkNativeEndCardView.a(com.anythink.expressad.video.module.AnythinkNativeEndCardView.this, 2);
        }
    }

    public AnythinkNativeEndCardView(android.content.Context context) {
        super(context);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    public AnythinkNativeEndCardView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    public AnythinkNativeEndCardView(android.content.Context context, android.util.AttributeSet attributeSet, boolean z, int i, boolean z2, int i2, int i3) {
        super(context, attributeSet, z, i, z2, i2, i3);
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = false;
        this.N = false;
        this.O = false;
        this.U = false;
        this.ag = 1;
    }

    private void a() {
        new com.anythink.expressad.video.dynview.j.c();
        com.anythink.expressad.video.dynview.c a = com.anythink.expressad.video.dynview.j.c.a(getContext(), this.b, this.j);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(a, new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass10());
    }

    private void a(android.view.View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.I);
        } else {
            if (view.getParent() != null) {
                ((android.view.ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        h();
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView, int i) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = null;
        try {
            jSONObject = new org.json.JSONObject();
        } catch (org.json.JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, anythinkNativeEndCardView.a(i));
            if (anythinkNativeEndCardView.b.k() == 5) {
                jSONObject.put("camp_position", 0);
            }
        } catch (org.json.JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            jSONObject = jSONObject2;
            anythinkNativeEndCardView.e.a(105, jSONObject);
        }
        anythinkNativeEndCardView.e.a(105, jSONObject);
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView) {
        anythinkNativeEndCardView.K = true;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        r1 = com.anythink.expressad.video.module.AnythinkNativeEndCardView.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002e, code lost:
    
        if (r6.aa != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r6.aa != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        boolean b;
        int i = this.ag;
        java.lang.String str = q;
        java.lang.String str2 = p;
        if (i == 0) {
            if (!this.aa) {
                str2 = n;
            }
            if (isLandscape()) {
            }
        } else {
            if (i != 1) {
                str2 = "";
            } else if (!this.aa) {
                str2 = n;
            }
            if (i == 2) {
            }
        }
        int findLayout = findLayout(str2);
        if (findLayout > 0) {
            if (isLandscape()) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.c.inflate(findLayout, (android.view.ViewGroup) null);
                this.f275s = viewGroup;
                addView(viewGroup);
                b = b(this.f275s);
            } else {
                android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.c.inflate(findLayout, (android.view.ViewGroup) null);
                this.r = viewGroup2;
                addView(viewGroup2);
                b = b(this.r);
            }
            this.f = b;
            e();
        }
    }

    private boolean b(int i) {
        if (isLandscape()) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.c.inflate(i, (android.view.ViewGroup) null);
            this.f275s = viewGroup;
            addView(viewGroup);
            return b(this.f275s);
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.c.inflate(i, (android.view.ViewGroup) null);
        this.r = viewGroup2;
        addView(viewGroup2);
        return b(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(android.view.View view) {
        try {
            this.t = (android.widget.RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_layout"));
            this.u = (android.widget.RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_layer_layout"));
            this.w = (android.widget.ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_adbanner"));
            this.x = (android.widget.ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_icon"));
            this.y = (android.widget.ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_flag"));
            this.z = (android.widget.ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_link"));
            this.B = (android.widget.TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_apptitle"));
            this.E = (android.widget.LinearLayout) view.findViewById(filterFindViewId(this.U, "anythink_sv_starlevel"));
            this.V = view.findViewById(filterFindViewId(this.U, "anythink_iv_close"));
            android.view.View findViewById = view.findViewById(filterFindViewId(this.U, "anythink_tv_cta"));
            if (findViewById != null && (findViewById instanceof android.widget.TextView)) {
                this.W = (android.widget.TextView) findViewById;
            }
            this.F = (com.anythink.expressad.widget.FeedBackButton) view.findViewById(filterFindViewId(this.U, "anythink_native_endcard_feed_btn"));
            this.H = (android.widget.RelativeLayout) view.findViewById(filterFindViewId(this.U, "anythink_native_ec_controller"));
            this.v = (android.widget.ImageView) view.findViewById(filterFindViewId(this.U, "anythink_iv_adbanner_bg"));
            if (!this.i) {
                this.C = (android.widget.TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_appdesc"));
                android.widget.TextView textView = (android.widget.TextView) view.findViewById(filterFindViewId(this.U, "anythink_tv_number"));
                this.D = textView;
                return isNotNULL(this.v, this.w, this.x, this.B, this.C, textView, this.E, this.V, this.W);
            }
            android.widget.ImageView imageView = this.w;
            if (imageView != null && (imageView instanceof com.anythink.expressad.videocommon.view.RoundImageView)) {
                ((com.anythink.expressad.videocommon.view.RoundImageView) imageView).setBorderRadius(10);
            }
            android.widget.ImageView imageView2 = this.x;
            if (imageView2 != null && (imageView2 instanceof com.anythink.expressad.videocommon.view.RoundImageView)) {
                ((com.anythink.expressad.videocommon.view.RoundImageView) imageView2).setBorderRadius(10);
            }
            return isNotNULL(this.v, this.w, this.x, this.B, this.E, this.V);
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return false;
        }
    }

    private void c(int i) {
        org.json.JSONObject jSONObject;
        org.json.JSONObject jSONObject2 = null;
        try {
            jSONObject = new org.json.JSONObject();
        } catch (org.json.JSONException e) {
            e = e;
        }
        try {
            jSONObject.put(com.anythink.expressad.foundation.g.a.ce, a(i));
            if (this.b.k() == 5) {
                jSONObject.put("camp_position", 0);
            }
        } catch (org.json.JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            jSONObject = jSONObject2;
            this.e.a(105, jSONObject);
        }
        this.e.a(105, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        c();
        if (!this.f) {
            this.e.a(104, "");
        }
        android.view.animation.AlphaAnimation alphaAnimation = new android.view.animation.AlphaAnimation(0.0f, 100.0f);
        this.P = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private void f() {
        com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.be(), new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass11());
        com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(this.x, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 8.0f)));
        this.B.setText(this.b.bb());
        android.widget.TextView textView = this.W;
        if (textView != null) {
            textView.setText(this.b.cU);
        }
        android.widget.TextView textView2 = this.C;
        if (textView2 != null) {
            textView2.setText(this.b.bc());
        }
        android.widget.TextView textView3 = this.D;
        if (textView3 != null) {
            textView3.setText(this.b.aY() + ")");
        }
        this.E.removeAllViews();
        double aX = this.b.aX();
        if (aX <= 0.0d) {
            aX = 5.0d;
        }
        android.widget.LinearLayout linearLayout = this.E;
        if (linearLayout instanceof com.anythink.expressad.videocommon.view.StarLevelView) {
            ((com.anythink.expressad.videocommon.view.StarLevelView) linearLayout).initScore(aX);
        }
        android.widget.LinearLayout linearLayout2 = this.E;
        if (linearLayout2 instanceof com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) {
            ((com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) linearLayout2).setRatingAndUser(aX, this.b.aY());
        }
        if (!android.text.TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
            this.J = true;
        }
        com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(android.text.TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass12());
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        if (b != null) {
            java.lang.String J = b.J();
            if (android.text.TextUtils.isEmpty(J)) {
                this.z.setVisibility(8);
            }
            this.z.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass13(J));
        } else {
            this.z.setVisibility(8);
        }
        if (this.K) {
            return;
        }
        this.V.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        r1 = com.anythink.expressad.video.module.AnythinkNativeEndCardView.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002e, code lost:
    
        if (r6.aa != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r6.aa != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int g() {
        int i = this.ag;
        java.lang.String str = q;
        java.lang.String str2 = p;
        if (i == 0) {
            if (!this.aa) {
                str2 = n;
            }
            if (isLandscape()) {
            }
        } else {
            if (i != 1) {
                str2 = "";
            } else if (!this.aa) {
                str2 = n;
            }
            if (i == 2) {
            }
        }
        return findLayout(str2);
    }

    private void h() {
        android.widget.RelativeLayout relativeLayout;
        if (!this.f || (relativeLayout = this.H) == null) {
            return;
        }
        relativeLayout.postDelayed(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass3(), 200L);
    }

    private void i() {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            com.anythink.expressad.widget.FeedBackButton feedBackButton = this.F;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        this.b.l(this.ab);
        com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass4());
        com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", this.b);
        com.anythink.expressad.foundation.f.b.a().c(this.ab + "_1");
        com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", this.F);
        if (this.F != null) {
            com.anythink.expressad.foundation.f.b.a().a(this.ab + "_2", this.F);
        }
    }

    private void j() {
        int parseInt;
        int parseInt2;
        try {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar == null || !cVar.j()) {
                return;
            }
            java.lang.String I = this.b.I();
            if (android.text.TextUtils.isEmpty(I)) {
                I = this.b.P();
            }
            java.lang.String a = com.anythink.expressad.foundation.h.x.a(I, "shake_strength");
            java.lang.String a2 = com.anythink.expressad.foundation.h.x.a(I, "shake_time");
            if (android.text.TextUtils.isEmpty("1") || this.ad != null) {
                return;
            }
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView anythinkBaitClickView = this.af;
            if (anythinkBaitClickView != null) {
                anythinkBaitClickView.setVisibility(8);
            }
            com.anythink.expressad.shake.MBShakeView mBShakeView = new com.anythink.expressad.shake.MBShakeView(getContext());
            this.ad = mBShakeView;
            mBShakeView.initView(this.b.cU, true);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            if (isLandscape()) {
                layoutParams.addRule(13);
            } else {
                layoutParams.addRule(2, findID("anythink_iv_logo"));
                layoutParams.addRule(14);
                this.ad.setPadding(0, 0, 0, com.anythink.expressad.foundation.h.t.b(getContext(), 20.0f));
            }
            this.ad.setLayoutParams(layoutParams);
            android.widget.RelativeLayout relativeLayout = this.t;
            if (relativeLayout != null && relativeLayout.isShown()) {
                if (this.W != null) {
                    this.t.addView(this.ad);
                }
                this.W.setVisibility(4);
                this.ad.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass5());
                int i = 10;
                if (!android.text.TextUtils.isEmpty(a) && (parseInt2 = java.lang.Integer.parseInt(a)) >= 0) {
                    i = parseInt2;
                }
                int i2 = 5000;
                if (!android.text.TextUtils.isEmpty(a2) && (parseInt = java.lang.Integer.parseInt(a2)) > 0) {
                    i2 = parseInt * 1000;
                }
                this.ae = new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass6(i, i2);
                this.ad.addOnAttachStateChangeListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass7());
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void k() {
        int i;
        try {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar == null || !cVar.j()) {
                return;
            }
            java.lang.String I = this.b.I();
            if (android.text.TextUtils.isEmpty(I)) {
                I = this.b.P();
            }
            java.lang.String a = com.anythink.expressad.foundation.h.x.a(I, "bait_click");
            try {
                i = java.lang.Integer.parseInt(a);
            } catch (java.lang.Throwable th) {
                th.getMessage();
                i = 1;
            }
            if (android.text.TextUtils.isEmpty(a) || i == 0 || this.af != null) {
                return;
            }
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView anythinkBaitClickView = new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView(getContext());
            this.af = anythinkBaitClickView;
            anythinkBaitClickView.init(1342177280, i);
            this.af.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            android.widget.RelativeLayout relativeLayout = this.u;
            if (relativeLayout != null) {
                relativeLayout.addView(this.af);
                this.af.startAnimation();
                this.af.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass8());
            }
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    private void l() {
        try {
            com.anythink.expressad.foundation.d.c cVar = this.b;
            if (cVar == null || !cVar.j()) {
                return;
            }
            java.lang.String I = this.b.I();
            if (android.text.TextUtils.isEmpty(I)) {
                I = this.b.P();
            }
            java.lang.String a = com.anythink.expressad.foundation.h.x.a(I, "alac");
            if (android.text.TextUtils.isEmpty(a) || !a.equals("1")) {
                return;
            }
            postDelayed(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass9(), 1000L);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ void o(com.anythink.expressad.video.module.AnythinkNativeEndCardView anythinkNativeEndCardView) {
        if (!com.anythink.expressad.foundation.f.b.a().b()) {
            com.anythink.expressad.widget.FeedBackButton feedBackButton = anythinkNativeEndCardView.F;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        anythinkNativeEndCardView.b.l(anythinkNativeEndCardView.ab);
        com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.new AnonymousClass4());
        com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.b);
        com.anythink.expressad.foundation.f.b.a().c(anythinkNativeEndCardView.ab + "_1");
        com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.F);
        if (anythinkNativeEndCardView.F != null) {
            com.anythink.expressad.foundation.f.b.a().a(anythinkNativeEndCardView.ab + "_2", anythinkNativeEndCardView.F);
        }
    }

    @android.annotation.TargetApi(17)
    public android.graphics.Bitmap blurBitmap(android.graphics.Bitmap bitmap) {
        try {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_4444);
            android.renderscript.RenderScript create = android.renderscript.RenderScript.create(this.a.getApplicationContext());
            android.renderscript.ScriptIntrinsicBlur create2 = android.renderscript.ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
            android.renderscript.Allocation createFromBitmap = android.renderscript.Allocation.createFromBitmap(create, bitmap);
            android.renderscript.Allocation createFromBitmap2 = android.renderscript.Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(25.0f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            create.destroy();
            return createBitmap;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        if (this.f) {
            this.t.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass14());
            this.V.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass15());
            android.widget.TextView textView = this.W;
            if (textView != null) {
                textView.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass16());
            }
            this.x.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass17());
            this.w.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass2());
        }
    }

    public boolean canBackPress() {
        android.view.View view = this.V;
        return view != null && view.getVisibility() == 0;
    }

    public void clearMoreOfferBitmap() {
        com.anythink.expressad.foundation.d.d dVar;
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j() || (dVar = this.ac) == null || (arrayList = dVar.J) == null || arrayList.size() <= 0) {
            return;
        }
        java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.ac.J.iterator();
        while (it.hasNext()) {
            com.anythink.expressad.foundation.d.c next = it.next();
            if (!android.text.TextUtils.isEmpty(next.bd())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).c(next.bd());
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
    }

    public boolean isDyXmlSuccess() {
        return this.U;
    }

    public void notifyShowListener() {
        this.e.a(110, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int parseInt;
        int parseInt2;
        int i;
        super.onAttachedToWindow();
        if (this.G == null) {
            this.G = new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass1();
        }
        java.lang.Runnable runnable = this.G;
        if (runnable != null) {
            postDelayed(runnable, this.L * 1000);
            if (!this.N) {
                this.N = true;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = this.b;
                if (cVar != null && cVar.j()) {
                    java.lang.String I = this.b.I();
                    if (android.text.TextUtils.isEmpty(I)) {
                        I = this.b.P();
                    }
                    java.lang.String a = com.anythink.expressad.foundation.h.x.a(I, "alac");
                    if (!android.text.TextUtils.isEmpty(a) && a.equals("1")) {
                        postDelayed(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass9(), 1000L);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        try {
            com.anythink.expressad.foundation.d.c cVar2 = this.b;
            if (cVar2 != null && cVar2.j()) {
                java.lang.String I2 = this.b.I();
                if (android.text.TextUtils.isEmpty(I2)) {
                    I2 = this.b.P();
                }
                java.lang.String a2 = com.anythink.expressad.foundation.h.x.a(I2, "bait_click");
                try {
                    i = java.lang.Integer.parseInt(a2);
                } catch (java.lang.Throwable th2) {
                    th2.getMessage();
                    i = 1;
                }
                if (!android.text.TextUtils.isEmpty(a2) && i != 0 && this.af == null) {
                    com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView anythinkBaitClickView = new com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView(getContext());
                    this.af = anythinkBaitClickView;
                    anythinkBaitClickView.init(1342177280, i);
                    this.af.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
                    android.widget.RelativeLayout relativeLayout = this.u;
                    if (relativeLayout != null) {
                        relativeLayout.addView(this.af);
                        this.af.startAnimation();
                        this.af.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass8());
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th3.getMessage();
        }
        try {
            com.anythink.expressad.foundation.d.c cVar3 = this.b;
            if (cVar3 == null || !cVar3.j()) {
                return;
            }
            java.lang.String I3 = this.b.I();
            if (android.text.TextUtils.isEmpty(I3)) {
                I3 = this.b.P();
            }
            java.lang.String a3 = com.anythink.expressad.foundation.h.x.a(I3, "shake_strength");
            java.lang.String a4 = com.anythink.expressad.foundation.h.x.a(I3, "shake_time");
            if (android.text.TextUtils.isEmpty("1") || this.ad != null) {
                return;
            }
            com.anythink.expressad.video.dynview.widget.AnythinkBaitClickView anythinkBaitClickView2 = this.af;
            if (anythinkBaitClickView2 != null) {
                anythinkBaitClickView2.setVisibility(8);
            }
            com.anythink.expressad.shake.MBShakeView mBShakeView = new com.anythink.expressad.shake.MBShakeView(getContext());
            this.ad = mBShakeView;
            mBShakeView.initView(this.b.cU, true);
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            if (isLandscape()) {
                layoutParams.addRule(13);
            } else {
                layoutParams.addRule(2, findID("anythink_iv_logo"));
                layoutParams.addRule(14);
                this.ad.setPadding(0, 0, 0, com.anythink.expressad.foundation.h.t.b(getContext(), 20.0f));
            }
            this.ad.setLayoutParams(layoutParams);
            android.widget.RelativeLayout relativeLayout2 = this.t;
            if (relativeLayout2 != null && relativeLayout2.isShown()) {
                if (this.W != null) {
                    this.t.addView(this.ad);
                }
                this.W.setVisibility(4);
                this.ad.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass5());
                int i2 = 10;
                if (!android.text.TextUtils.isEmpty(a3) && (parseInt2 = java.lang.Integer.parseInt(a3)) >= 0) {
                    i2 = parseInt2;
                }
                int i3 = 5000;
                if (!android.text.TextUtils.isEmpty(a4) && (parseInt = java.lang.Integer.parseInt(a4)) > 0) {
                    i3 = parseInt * 1000;
                }
                this.ae = new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass6(i2, i3);
                this.ad.addOnAttachStateChangeListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass7());
            }
        } catch (java.lang.Throwable th4) {
            th4.getMessage();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        java.lang.Runnable runnable = this.G;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        if (this.ae != null) {
            com.anythink.expressad.shake.a.a().b(this.ae);
            this.ae = null;
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j()) {
            android.widget.RelativeLayout relativeLayout = this.H;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            this.d = configuration.orientation;
            if (this.d == 2) {
                removeView(this.r);
                a(this.f275s);
            } else {
                removeView(this.f275s);
                a(this.r);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        this.I = bVar;
        try {
            if (this.b == null || !this.f) {
                return;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.be(), new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass11());
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(this.b.bd(), new com.anythink.expressad.video.module.a.a.j(this.x, com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 8.0f)));
            this.B.setText(this.b.bb());
            android.widget.TextView textView = this.W;
            if (textView != null) {
                textView.setText(this.b.cU);
            }
            android.widget.TextView textView2 = this.C;
            if (textView2 != null) {
                textView2.setText(this.b.bc());
            }
            android.widget.TextView textView3 = this.D;
            if (textView3 != null) {
                textView3.setText(this.b.aY() + ")");
            }
            this.E.removeAllViews();
            double aX = this.b.aX();
            if (aX <= 0.0d) {
                aX = 5.0d;
            }
            android.widget.LinearLayout linearLayout = this.E;
            if (linearLayout instanceof com.anythink.expressad.videocommon.view.StarLevelView) {
                ((com.anythink.expressad.videocommon.view.StarLevelView) linearLayout).initScore(aX);
            }
            android.widget.LinearLayout linearLayout2 = this.E;
            if (linearLayout2 instanceof com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) {
                ((com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) linearLayout2).setRatingAndUser(aX, this.b.aY());
            }
            if (!android.text.TextUtils.isEmpty(this.b.I()) && this.b.I().contains("alecfc=1")) {
                this.J = true;
            }
            com.anythink.expressad.foundation.g.d.b.a(this.a.getApplicationContext()).a(android.text.TextUtils.isEmpty(this.b.aE()) ? com.anythink.expressad.a.ab : this.b.aE(), new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass12());
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
            if (b != null) {
                java.lang.String J = b.J();
                if (android.text.TextUtils.isEmpty(J)) {
                    this.z.setVisibility(8);
                }
                this.z.setOnClickListener(new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass13(J));
            } else {
                this.z.setVisibility(8);
            }
            if (this.K) {
                return;
            }
            this.V.setVisibility(8);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void release() {
        try {
            removeAllViews();
            android.view.animation.AlphaAnimation alphaAnimation = this.P;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.ae = null;
            this.G = null;
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    public void setCloseBtnDelay(int i) {
        this.L = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r6.aa != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0052, code lost:
    
        r1 = com.anythink.expressad.video.module.AnythinkNativeEndCardView.o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
    
        if (r6.aa != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setLayout() {
        int findLayout;
        boolean b;
        if (this.i) {
            new com.anythink.expressad.video.dynview.j.c();
            com.anythink.expressad.video.dynview.c a = com.anythink.expressad.video.dynview.j.c.a(getContext(), this.b, this.j);
            com.anythink.expressad.video.dynview.b.a();
            com.anythink.expressad.video.dynview.b.a(a, new com.anythink.expressad.video.module.AnythinkNativeEndCardView.AnonymousClass10());
            return;
        }
        int i = this.ag;
        java.lang.String str = q;
        java.lang.String str2 = p;
        if (i == 0) {
            if (!this.aa) {
                str2 = n;
            }
            if (isLandscape()) {
            }
            findLayout = findLayout(str2);
            if (findLayout <= 0) {
                if (isLandscape()) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.c.inflate(findLayout, (android.view.ViewGroup) null);
                    this.f275s = viewGroup;
                    addView(viewGroup);
                    b = b(this.f275s);
                } else {
                    android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.c.inflate(findLayout, (android.view.ViewGroup) null);
                    this.r = viewGroup2;
                    addView(viewGroup2);
                    b = b(this.r);
                }
                this.f = b;
                e();
                return;
            }
            return;
        }
        if (i != 1) {
            str2 = "";
        } else if (!this.aa) {
            str2 = n;
        }
        if (i == 2) {
        }
        findLayout = findLayout(str2);
        if (findLayout <= 0) {
        }
    }

    public void setMoreOfferCampaignUnit(com.anythink.expressad.foundation.d.d dVar) {
        java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList;
        com.anythink.expressad.shake.MBShakeView mBShakeView;
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.j()) {
            return;
        }
        this.ac = dVar;
        if (dVar == null || (arrayList = dVar.J) == null || arrayList.size() <= 5 || (mBShakeView = this.ad) == null) {
            return;
        }
        mBShakeView.setPadding(0, 0, 0, com.anythink.expressad.foundation.h.t.b(getContext(), 5.0f));
    }

    public void setNotchPadding(int i, int i2, int i3, int i4) {
        java.lang.String.format("%1s-%2s-%3s-%4s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        this.Q = i;
        this.R = i2;
        this.S = i3;
        this.T = i4;
        h();
    }

    public void setOnPause() {
        this.N = false;
    }

    public void setOnResume() {
        this.N = true;
    }

    public void setUnitId(java.lang.String str) {
        this.ab = str;
    }
}
