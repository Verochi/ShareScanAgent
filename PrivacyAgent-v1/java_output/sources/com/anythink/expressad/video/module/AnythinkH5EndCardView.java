package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkH5EndCardView extends com.anythink.expressad.video.module.AnythinkBaseView implements com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge, com.anythink.expressad.video.signal.f, com.anythink.expressad.video.signal.h {
    private static final java.lang.String A = "anythink_reward_endcard_h5";
    private static final java.lang.String B = "portrait";
    private static final java.lang.String C = "landscape";
    private static final int D = 1;
    private static final int E = 2;
    private static final int F = 20;
    private static final int G = 15;
    private static final int Q = 100;
    protected static final java.lang.String n = "orientation";
    protected static final java.lang.String o = "webviewshow";
    private com.anythink.expressad.widget.FeedBackButton H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private int O;
    private long P;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean aa;
    private boolean ab;
    private java.lang.String ac;
    private com.anythink.expressad.video.signal.factory.b ad;
    private boolean ae;
    private boolean af;
    protected android.view.View p;
    protected android.widget.RelativeLayout q;
    protected android.widget.ImageView r;

    /* renamed from: s, reason: collision with root package name */
    protected com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView f274s;
    protected android.os.Handler t;
    protected java.lang.String u;
    protected boolean v;
    protected boolean w;
    protected java.lang.String x;
    android.os.Handler y;
    boolean z;

    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            if (com.anythink.expressad.video.module.AnythinkH5EndCardView.this.R) {
                com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(122, "");
            }
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(103, "");
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.onCloseViewClick();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.expressad.atsignalcommon.a.b {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void loadingResourceStatus(android.webkit.WebView webView, int i) {
            super.loadingResourceStatus(webView, i);
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.O = i;
            if (com.anythink.expressad.video.module.AnythinkH5EndCardView.this.N) {
                return;
            }
            com.anythink.expressad.video.module.AnythinkH5EndCardView.d(com.anythink.expressad.video.module.AnythinkH5EndCardView.this);
            if (i == 1) {
                com.anythink.expressad.video.module.AnythinkH5EndCardView.this.reportRenderResult("success", 4);
            } else {
                com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(127, "");
                com.anythink.expressad.video.module.AnythinkH5EndCardView.this.reportRenderResult(com.alipay.sdk.m.u.h.j, 6);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            if (com.anythink.expressad.video.module.AnythinkH5EndCardView.this.w) {
                return;
            }
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = com.anythink.expressad.video.module.AnythinkH5EndCardView.this;
            boolean z = anythinkH5EndCardView.v;
            anythinkH5EndCardView.v = true;
            anythinkH5EndCardView.e.a(100, "");
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(120, "");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = com.anythink.expressad.video.module.AnythinkH5EndCardView.this;
            if (anythinkH5EndCardView.w) {
                return;
            }
            anythinkH5EndCardView.e.a(118, "onReceivedError " + i + str);
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.reportRenderResult(str, 3);
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(127, "");
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(129, "");
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.w = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            super.readyState(webView, i);
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = com.anythink.expressad.video.module.AnythinkH5EndCardView.this;
            boolean z = anythinkH5EndCardView.w;
            anythinkH5EndCardView.O = i;
            if (com.anythink.expressad.video.module.AnythinkH5EndCardView.this.w) {
                return;
            }
            com.anythink.expressad.video.module.AnythinkH5EndCardView.a(com.anythink.expressad.video.module.AnythinkH5EndCardView.this, java.lang.System.currentTimeMillis() - com.anythink.expressad.video.module.AnythinkH5EndCardView.this.P);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String str;
            try {
                try {
                    com.anythink.expressad.video.module.AnythinkH5EndCardView.this.f274s.getLocationOnScreen(new int[2]);
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    android.content.Context f = com.anythink.core.common.b.o.a().f();
                    if (f != null) {
                        jSONObject.put("startX", com.anythink.expressad.foundation.h.t.a(f, r3[0]));
                        jSONObject.put("startY", com.anythink.expressad.foundation.h.t.a(f, r3[1]));
                        jSONObject.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(f));
                    }
                    str = jSONObject.toString();
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                    str = "";
                }
                java.lang.String encodeToString = android.util.Base64.encodeToString(str.toString().getBytes(), 2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.module.AnythinkH5EndCardView.this.f274s, com.anythink.expressad.video.module.AnythinkH5EndCardView.o, encodeToString);
                com.anythink.expressad.video.module.AnythinkH5EndCardView.this.e.a(109, "");
                com.anythink.expressad.video.module.AnythinkH5EndCardView.g(com.anythink.expressad.video.module.AnythinkH5EndCardView.this);
                com.anythink.expressad.video.module.AnythinkH5EndCardView.this.startCounterEndCardShowTimer();
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = com.anythink.expressad.video.module.AnythinkH5EndCardView.this;
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) anythinkH5EndCardView.f274s, "oncutoutfetched", android.util.Base64.encodeToString(anythinkH5EndCardView.ac.getBytes(), 0));
                com.anythink.expressad.video.module.AnythinkH5EndCardView.i(com.anythink.expressad.video.module.AnythinkH5EndCardView.this);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.H.setVisibility(0);
        }
    }

    /* renamed from: com.anythink.expressad.video.module.AnythinkH5EndCardView$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            java.lang.String str;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.module.AnythinkH5EndCardView.this.f274s, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            java.lang.String str;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.module.AnythinkH5EndCardView.this.f274s, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            java.lang.String str;
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.module.AnythinkH5EndCardView.this.f274s, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }
    }

    public class a implements java.lang.Runnable {
        private com.anythink.expressad.video.module.AnythinkH5EndCardView b;

        public a(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.os.Handler handler;
            try {
                java.lang.Thread.sleep(300L);
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
            }
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView == null || (handler = anythinkH5EndCardView.y) == null) {
                return;
            }
            handler.sendEmptyMessage(100);
        }
    }

    public class b implements java.lang.Runnable {
        private com.anythink.expressad.video.module.AnythinkH5EndCardView b;

        public b(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.N) {
                return;
            }
            com.anythink.expressad.video.module.AnythinkH5EndCardView.d(this.b);
            this.b.v = false;
            com.anythink.expressad.video.module.AnythinkH5EndCardView.this.reportRenderResult("timeout", 5);
            this.b.e.a(127, "");
        }
    }

    public static class c implements java.lang.Runnable {
        private com.anythink.expressad.video.module.AnythinkH5EndCardView a;
        private int b;

        public c(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView, int i) {
            this.a = anythinkH5EndCardView;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.a;
            if (anythinkH5EndCardView == null || anythinkH5EndCardView.b == null) {
                return;
            }
            try {
                if (anythinkH5EndCardView.M) {
                    return;
                }
                com.anythink.expressad.video.module.AnythinkH5EndCardView.n(this.a);
                if (com.anythink.expressad.foundation.h.w.b(this.a.b.I())) {
                    this.a.b.I().contains(".zip");
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public class d implements java.lang.Runnable {
        private com.anythink.expressad.video.module.AnythinkH5EndCardView b;

        public d(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                com.anythink.expressad.video.module.AnythinkH5EndCardView.e(anythinkH5EndCardView);
            }
        }
    }

    public class e implements java.lang.Runnable {
        private com.anythink.expressad.video.module.AnythinkH5EndCardView b;

        public e(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                com.anythink.expressad.video.module.AnythinkH5EndCardView.f(anythinkH5EndCardView);
            }
        }
    }

    public class f implements java.lang.Runnable {
        private com.anythink.expressad.video.module.AnythinkH5EndCardView b;

        public f(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
            this.b = anythinkH5EndCardView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView = this.b;
            if (anythinkH5EndCardView != null) {
                if (!anythinkH5EndCardView.aa) {
                    com.anythink.expressad.video.module.AnythinkH5EndCardView.this.setCloseVisible(0);
                }
                com.anythink.expressad.video.module.AnythinkH5EndCardView.l(this.b);
            }
        }
    }

    public AnythinkH5EndCardView(android.content.Context context) {
        super(context);
        this.I = false;
        this.t = new android.os.Handler();
        this.v = false;
        this.w = false;
        this.J = false;
        this.K = 1;
        this.L = 1;
        this.M = false;
        this.N = false;
        this.O = 1;
        this.P = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = "";
        this.y = new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass1(android.os.Looper.getMainLooper());
        this.ae = false;
        this.af = false;
        this.z = false;
    }

    public AnythinkH5EndCardView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = false;
        this.t = new android.os.Handler();
        this.v = false;
        this.w = false;
        this.J = false;
        this.K = 1;
        this.L = 1;
        this.M = false;
        this.N = false;
        this.O = 1;
        this.P = 0L;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = false;
        this.ab = false;
        this.ac = "";
        this.y = new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass1(android.os.Looper.getMainLooper());
        this.ae = false;
        this.af = false;
        this.z = false;
    }

    private void a(long j, boolean z) {
        try {
            if (this.M) {
                return;
            }
            this.M = true;
            if (com.anythink.expressad.foundation.h.w.b(this.b.I())) {
                this.b.I().contains(".zip");
            }
            if (!z) {
                int i = this.O;
            }
            this.b.I();
            this.b.aZ();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView, long j) {
        try {
            if (anythinkH5EndCardView.M) {
                return;
            }
            anythinkH5EndCardView.M = true;
            if (com.anythink.expressad.foundation.h.w.b(anythinkH5EndCardView.b.I())) {
                anythinkH5EndCardView.b.I().contains(".zip");
            }
            int i = anythinkH5EndCardView.O;
            anythinkH5EndCardView.b.I();
            anythinkH5EndCardView.b.aZ();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void a(java.lang.String str) {
        try {
            java.lang.String ad = this.b.ad();
            if (!android.text.TextUtils.isEmpty(str)) {
                this.b.p(str);
            }
            new com.anythink.expressad.a.a(getContext(), this.x);
            this.b.p(ad);
            this.e.a(126, "");
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    private boolean a(android.view.View view) {
        this.r = (android.widget.ImageView) view.findViewById(findID("anythink_windwv_close"));
        this.q = (android.widget.RelativeLayout) view.findViewById(findID("anythink_windwv_content_rl"));
        this.f274s = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(getContext());
        this.f274s.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        this.q.addView(this.f274s);
        return isNotNULL(this.r, this.f274s);
    }

    public static /* synthetic */ boolean d(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.N = true;
        return true;
    }

    public static /* synthetic */ boolean e(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.V = true;
        return true;
    }

    private void f() {
        int o2;
        try {
            this.P = java.lang.System.currentTimeMillis();
            java.lang.String I = this.b.I();
            com.anythink.expressad.videocommon.e.d a2 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.x);
            if (this.J && com.anythink.expressad.foundation.h.w.b(I)) {
                if (I.contains("wfr=1") || (a2 != null && a2.o() > 0)) {
                    if (I.contains("wfr=1")) {
                        java.lang.String[] split = I.split("&");
                        if (split != null && split.length > 0) {
                            for (java.lang.String str : split) {
                                if (com.anythink.expressad.foundation.h.w.b(str) && str.contains(com.huawei.hms.push.constant.RemoteMessageConst.TO) && str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != null && str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).length > 0) {
                                    o2 = com.anythink.expressad.foundation.h.t.a((java.lang.Object) str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)[1]);
                                    break;
                                }
                            }
                        }
                        o2 = 20;
                    } else {
                        if (a2 != null && a2.o() > 0) {
                            o2 = a2.o();
                        }
                        o2 = 20;
                    }
                    if (o2 >= 0) {
                        excuteEndCardShowTask(o2);
                    } else {
                        excuteEndCardShowTask(20);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ boolean f(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.W = true;
        return true;
    }

    private void g() {
        if (this.ae || this.T) {
            return;
        }
        this.ae = true;
        int i = this.K;
        if (i == 0) {
            this.V = true;
            return;
        }
        this.V = false;
        if (i >= 0) {
            this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.d(this), this.K * 1000);
        }
    }

    public static /* synthetic */ void g(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        com.anythink.expressad.foundation.d.c cVar = anythinkH5EndCardView.b;
        if (cVar == null || !cVar.H()) {
            return;
        }
        int i = anythinkH5EndCardView.getResources().getConfiguration().orientation;
        java.lang.String str = "undefined";
        if (i != 0) {
            if (i == 1) {
                str = B;
            } else if (i == 2) {
                str = C;
            }
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, "Interstitial");
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "default");
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
        if (anythinkH5EndCardView.getContext() instanceof android.app.Activity) {
            float e3 = com.anythink.expressad.foundation.h.k.e(anythinkH5EndCardView.getContext());
            float f2 = com.anythink.expressad.foundation.h.k.f(anythinkH5EndCardView.getContext());
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.app.Activity) anythinkH5EndCardView.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f3 = displayMetrics.widthPixels;
            float f4 = displayMetrics.heightPixels;
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(anythinkH5EndCardView.f274s, e3, f2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(anythinkH5EndCardView.f274s, f3, f4);
        }
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(anythinkH5EndCardView.f274s, r7.getLeft(), anythinkH5EndCardView.f274s.getTop(), anythinkH5EndCardView.f274s.getWidth(), anythinkH5EndCardView.f274s.getHeight());
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(anythinkH5EndCardView.f274s, r13.getLeft(), anythinkH5EndCardView.f274s.getTop(), anythinkH5EndCardView.f274s.getWidth(), anythinkH5EndCardView.f274s.getHeight());
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(anythinkH5EndCardView.f274s, hashMap);
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireAudioVolumeChange(anythinkH5EndCardView.f274s, com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.a);
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(anythinkH5EndCardView.f274s);
    }

    private void h() {
        if (this.af || this.T) {
            return;
        }
        this.af = true;
        int i = this.L;
        if (i == 0) {
            this.W = true;
            return;
        }
        this.W = false;
        if (i >= 0) {
            this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.e(this), this.L * 1000);
        }
    }

    private void i() {
        try {
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                com.anythink.expressad.foundation.f.b.a().c(this.x + "_1");
                com.anythink.expressad.widget.FeedBackButton b2 = com.anythink.expressad.foundation.f.b.a().b(this.x + "_2");
                this.H = b2;
                if (b2 != null) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.H);
                    }
                    this.q.addView(this.H);
                    this.q.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass5(), 200L);
                }
                this.b.l(this.x);
                com.anythink.expressad.foundation.f.b.a().a(this.x + "_2", this.b);
                com.anythink.expressad.foundation.f.b.a().a(this.x + "_2", new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass6());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void i(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        try {
            if (com.anythink.expressad.foundation.f.b.a().b()) {
                com.anythink.expressad.foundation.f.b.a().c(anythinkH5EndCardView.x + "_1");
                com.anythink.expressad.widget.FeedBackButton b2 = com.anythink.expressad.foundation.f.b.a().b(anythinkH5EndCardView.x + "_2");
                anythinkH5EndCardView.H = b2;
                if (b2 != null) {
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(anythinkH5EndCardView.H);
                    }
                    anythinkH5EndCardView.q.addView(anythinkH5EndCardView.H);
                    anythinkH5EndCardView.q.postDelayed(anythinkH5EndCardView.new AnonymousClass5(), 200L);
                }
                anythinkH5EndCardView.b.l(anythinkH5EndCardView.x);
                com.anythink.expressad.foundation.f.b.a().a(anythinkH5EndCardView.x + "_2", anythinkH5EndCardView.b);
                com.anythink.expressad.foundation.f.b.a().a(anythinkH5EndCardView.x + "_2", anythinkH5EndCardView.new AnonymousClass6());
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.H()) {
            return;
        }
        int i = getResources().getConfiguration().orientation;
        java.lang.String str = "undefined";
        if (i != 0) {
            if (i == 1) {
                str = B;
            } else if (i == 2) {
                str = C;
            }
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.a, "Interstitial");
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "default");
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.c, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        hashMap.put(com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.d, jSONObject);
        if (getContext() instanceof android.app.Activity) {
            float e3 = com.anythink.expressad.foundation.h.k.e(getContext());
            float f2 = com.anythink.expressad.foundation.h.k.f(getContext());
            android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
            ((android.app.Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f3 = displayMetrics.widthPixels;
            float f4 = displayMetrics.heightPixels;
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetScreenSize(this.f274s, e3, f2);
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetMaxSize(this.f274s, f3, f4);
        }
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetDefaultPosition(this.f274s, r7.getLeft(), this.f274s.getTop(), this.f274s.getWidth(), this.f274s.getHeight());
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetCurrentPosition(this.f274s, r13.getLeft(), this.f274s.getTop(), this.f274s.getWidth(), this.f274s.getHeight());
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireChangeEventForPropertys(this.f274s, hashMap);
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireAudioVolumeChange(this.f274s, com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.a);
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireReadyEvent(this.f274s);
    }

    private static void k() {
    }

    public static /* synthetic */ boolean l(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.S = true;
        return true;
    }

    public static /* synthetic */ boolean n(com.anythink.expressad.video.module.AnythinkH5EndCardView anythinkH5EndCardView) {
        anythinkH5EndCardView.M = true;
        return true;
    }

    public java.lang.String a() {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null) {
            this.R = false;
            return null;
        }
        this.R = true;
        if (cVar.H()) {
            this.J = false;
            java.lang.String G2 = this.b.G();
            if (android.text.TextUtils.isEmpty(G2)) {
                return this.b.P();
            }
            java.io.File file = new java.io.File(G2);
            try {
                G2 = (file.exists() && file.isFile() && file.canRead()) ? "file:////".concat(java.lang.String.valueOf(G2)) : this.b.P();
                return G2;
            } catch (java.lang.Throwable th) {
                if (!com.anythink.expressad.a.a) {
                    return G2;
                }
                th.printStackTrace();
                return G2;
            }
        }
        java.lang.String I = this.b.I();
        if (com.anythink.expressad.foundation.h.w.a(I)) {
            this.J = false;
            return this.b.P();
        }
        this.J = true;
        java.lang.String c2 = com.anythink.expressad.videocommon.b.i.a().c(I);
        if (!android.text.TextUtils.isEmpty(c2)) {
            return c2 + "&native_adtype=" + this.b.w();
        }
        try {
            java.lang.String path = android.net.Uri.parse(I).getPath();
            if (!android.text.TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                java.lang.String P = this.b.P();
                if (android.text.TextUtils.isEmpty(P)) {
                    return null;
                }
                this.J = false;
                excuteTask();
                return P;
            }
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
        return I + "&native_adtype=" + this.b.w();
    }

    public android.widget.RelativeLayout.LayoutParams b() {
        return new android.widget.RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public final void c() {
        super.c();
        if (this.f) {
            this.r.setOnClickListener(new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass2());
        }
    }

    public boolean canBackPress() {
        android.widget.ImageView imageView = this.r;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void close() {
        try {
            onCloseViewClick();
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    public void e() {
        if (this.f) {
            setMatchParent();
        }
    }

    public void excuteEndCardShowTask(int i) {
        this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.c(this, i), i * 1000);
    }

    public void excuteTask() {
        if (this.J || this.K < 0) {
            return;
        }
        this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.f(this), this.K * 1000);
    }

    public void executeEndCardShow(int i) {
        this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.b(this), i * 1000);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void expand(java.lang.String str, boolean z) {
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public com.anythink.expressad.foundation.d.c getMraidCampaign() {
        return this.b;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void handlerPlayableException(java.lang.String str) {
        if (this.w) {
            return;
        }
        this.w = true;
        this.v = false;
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        int findLayout = findLayout(A);
        if (findLayout >= 0) {
            android.view.View inflate = this.c.inflate(findLayout, (android.view.ViewGroup) null);
            this.p = inflate;
            try {
                this.r = (android.widget.ImageView) inflate.findViewById(findID("anythink_windwv_close"));
                this.q = (android.widget.RelativeLayout) inflate.findViewById(findID("anythink_windwv_content_rl"));
                this.f274s = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(getContext());
                this.f274s.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
                this.q.addView(this.f274s);
                this.f = isNotNULL(this.r, this.f274s);
            } catch (java.lang.Exception unused) {
                this.f = false;
            }
            addView(this.p, b());
            c();
            e();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void install(com.anythink.expressad.foundation.d.c cVar) {
    }

    public boolean isLoadSuccess() {
        return this.v;
    }

    public boolean isPlayable() {
        return this.J;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void notifyCloseBtn(int i) {
        if (i == 0) {
            this.T = true;
        } else {
            if (i != 1) {
                return;
            }
            this.U = true;
        }
    }

    public void onBackPress() {
        boolean z;
        if (this.S || (((z = this.T) && this.U) || (!(z || !this.V || this.z) || (!z && this.W && this.z)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.f274s == null) {
                this.e.a(103, "");
                this.e.a(119, "webview is null when closing webview");
            } else {
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.f274s, "onSystemDestory", "");
                new java.lang.Thread(new com.anythink.expressad.video.module.AnythinkH5EndCardView.a(this)).start();
            }
        } catch (java.lang.Exception e2) {
            this.e.a(103, "");
            this.e.a(119, "close webview exception" + e2.getMessage());
            e2.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkBaseView
    public void onSelfConfigurationChanged(android.content.res.Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // android.view.View
    public void onVisibilityChanged(android.view.View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 || this.ab) {
            return;
        }
        this.ab = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || !cVar.H()) {
            return;
        }
        if (z) {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetIsViewable(this.f274s, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
        } else {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSetIsViewable(this.f274s, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void open(java.lang.String str) {
        try {
            java.lang.String ad = this.b.ad();
            if (!android.text.TextUtils.isEmpty(str)) {
                this.b.p(str);
            }
            new com.anythink.expressad.a.a(getContext(), this.x);
            this.b.p(ad);
            this.e.a(126, "");
        } catch (java.lang.Exception e2) {
            try {
                e2.getMessage();
            } catch (java.lang.Exception e3) {
                e3.getMessage();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void orientation(android.content.res.Configuration configuration) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", C);
            } else {
                jSONObject.put("orientation", B);
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.f274s, "orientation", encodeToString);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }

    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        int o2;
        this.ad = bVar;
        java.lang.String a2 = a();
        if (!this.f || this.b == null || android.text.TextUtils.isEmpty(a2)) {
            reportRenderResult("PL URL IS NULL", 3);
            this.e.a(127, "");
            this.e.a(129, "");
        } else {
            this.P = java.lang.System.currentTimeMillis();
            com.anythink.expressad.foundation.webview.BrowserView.DownloadListener downloadListener = new com.anythink.expressad.foundation.webview.BrowserView.DownloadListener(this.b);
            downloadListener.setTitle(this.b.bb());
            this.f274s.setDownloadListener(downloadListener);
            this.f274s.setCampaignId(this.b.aZ());
            setCloseVisible(8);
            this.f274s.setApiManagerJSFactory(bVar);
            if (this.b.H()) {
                this.f274s.setMraidObject(this);
            }
            this.f274s.setWebViewListener(new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass3());
            if (android.text.TextUtils.isEmpty(this.b.G())) {
                try {
                    this.P = java.lang.System.currentTimeMillis();
                    java.lang.String I = this.b.I();
                    com.anythink.expressad.videocommon.e.d a3 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.x);
                    if (this.J && com.anythink.expressad.foundation.h.w.b(I) && (I.contains("wfr=1") || (a3 != null && a3.o() > 0))) {
                        if (I.contains("wfr=1")) {
                            java.lang.String[] split = I.split("&");
                            if (split != null && split.length > 0) {
                                for (java.lang.String str : split) {
                                    if (com.anythink.expressad.foundation.h.w.b(str) && str.contains(com.huawei.hms.push.constant.RemoteMessageConst.TO) && str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != null && str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).length > 0) {
                                        o2 = com.anythink.expressad.foundation.h.t.a((java.lang.Object) str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)[1]);
                                        break;
                                    }
                                }
                            }
                            o2 = 20;
                        } else {
                            if (a3 != null && a3.o() > 0) {
                                o2 = a3.o();
                            }
                            o2 = 20;
                        }
                        if (o2 >= 0) {
                            excuteEndCardShowTask(o2);
                        } else {
                            excuteEndCardShowTask(20);
                        }
                    }
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
            }
            setHtmlSource(com.anythink.expressad.videocommon.b.j.a().b(a2));
            if (android.text.TextUtils.isEmpty(this.u)) {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.f274s;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, a2);
                windVaneWebView.loadUrl(a2);
            } else {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.f274s;
                java.lang.String str2 = this.u;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(windVaneWebView2, a2, str2, "text/html", "UTF-8", null);
                windVaneWebView2.loadDataWithBaseURL(a2, str2, "text/html", "UTF-8", null);
            }
        }
        this.z = false;
    }

    @Override // com.anythink.expressad.video.signal.h
    public void readyStatus(int i) {
    }

    public void release() {
        android.os.Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.t = null;
        }
        android.os.Handler handler2 = this.y;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.y = null;
        }
        this.q.removeAllViews();
        this.f274s.release();
        this.f274s = null;
    }

    public void reportRenderResult(java.lang.String str, int i) {
    }

    public void setCloseDelayShowTime(int i) {
        this.K = i;
    }

    public void setCloseVisible(int i) {
        if (this.f) {
            this.r.setVisibility(i);
        }
    }

    public void setCloseVisibleForMraid(int i) {
        if (this.f) {
            this.aa = true;
            if (i == 4) {
                this.r.setImageDrawable(new android.graphics.drawable.ColorDrawable(16711680));
            } else {
                this.r.setImageResource(findDrawable("anythink_reward_close"));
            }
            this.r.setVisibility(0);
        }
    }

    public void setError(boolean z) {
        this.w = z;
    }

    public void setHtmlSource(java.lang.String str) {
        this.u = str;
    }

    public void setLoadPlayable(boolean z) {
        this.z = z;
    }

    public void setNotchValue(java.lang.String str, int i, int i2, int i3, int i4) {
        com.anythink.expressad.foundation.d.c cVar = this.b;
        if (cVar == null || cVar.f() == 2) {
            return;
        }
        this.ac = str;
        java.lang.String.format("%1s-%2s-%3s-%4s", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.r.getLayoutParams();
        int b2 = com.anythink.expressad.foundation.h.t.b(getContext(), 20.0f);
        layoutParams.setMargins(i + b2, i3 + b2, i2 + b2, i4 + b2);
        this.r.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i) {
        this.L = i;
    }

    public void setUnitId(java.lang.String str) {
        this.x = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            java.lang.String I = this.b.I();
            if (com.anythink.expressad.foundation.h.w.b(I) && I.contains("wfl=1")) {
                java.lang.String[] split = I.split("&");
                int i = 15;
                if (split != null && split.length > 0) {
                    for (java.lang.String str : split) {
                        if (com.anythink.expressad.foundation.h.w.b(str) && str.contains("timeout") && str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != null && str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER).length > 0) {
                            i = com.anythink.expressad.foundation.h.t.a((java.lang.Object) str.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER)[1]);
                        }
                    }
                }
                executeEndCardShow(i);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.h
    public void toggleCloseBtn(int i) {
        int visibility = this.r.getVisibility();
        if (i == 1) {
            this.S = true;
            visibility = 0;
        } else if (i == 2) {
            this.S = false;
            if (this.z) {
                if (!this.af && !this.T) {
                    this.af = true;
                    int i2 = this.L;
                    if (i2 == 0) {
                        this.W = true;
                    } else {
                        this.W = false;
                        if (i2 >= 0) {
                            this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.e(this), this.L * 1000);
                        }
                    }
                }
            } else if (!this.ae && !this.T) {
                this.ae = true;
                int i3 = this.K;
                if (i3 == 0) {
                    this.V = true;
                } else {
                    this.V = false;
                    if (i3 >= 0) {
                        this.t.postDelayed(new com.anythink.expressad.video.module.AnythinkH5EndCardView.d(this), this.K * 1000);
                    }
                }
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void unload() {
        close();
    }

    @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
    public void useCustomClose(boolean z) {
        try {
            setCloseVisibleForMraid(z ? 4 : 0);
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public void volumeChange(double d2) {
        com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireAudioVolumeChange(this.f274s, d2);
    }

    public void webviewshow() {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.f274s;
        if (windVaneWebView != null) {
            windVaneWebView.post(new com.anythink.expressad.video.module.AnythinkH5EndCardView.AnonymousClass4());
        }
    }
}
