package com.anythink.expressad.mbbanner.a.d;

/* loaded from: classes12.dex */
public final class c {
    private static java.lang.String c = "BannerShowManager";
    private float A;
    com.anythink.expressad.a.a a;
    com.anythink.expressad.out.i b;
    private com.anythink.expressad.mbbanner.a.c.c d;
    private boolean e;
    private com.anythink.expressad.foundation.d.c f;
    private com.anythink.expressad.out.TemplateBannerView g;
    private android.widget.ImageView h;
    private com.anythink.expressad.mbbanner.view.ATBannerWebView i;
    private android.widget.ImageView j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private java.lang.String r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f249s;
    private java.util.List<com.anythink.expressad.foundation.d.c> t;
    private int u;
    private com.anythink.expressad.mbbanner.a.a.c w;
    private float z;
    private long v = 15000;
    private android.os.Handler x = new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass1(android.os.Looper.getMainLooper());
    private com.anythink.expressad.foundation.g.g.a y = new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass4();
    private android.view.View.OnClickListener B = new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass5();
    private com.anythink.expressad.mbbanner.a.c.a C = new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass6();
    private com.anythink.expressad.atsignalcommon.a.b D = new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass2();

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            int i = message.what;
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        public AnonymousClass10() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.mbbanner.a.d.c.this.h();
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$11, reason: invalid class name */
    public class AnonymousClass11 implements com.anythink.expressad.out.p.e {
        public AnonymousClass11() {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar) {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, java.lang.String str) {
        }

        @Override // com.anythink.expressad.out.p.c
        public final boolean a() {
            return false;
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b() {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar) {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, java.lang.String str) {
        }

        @Override // com.anythink.expressad.out.p.e
        public final void c() {
            if (com.anythink.expressad.mbbanner.a.d.c.this.d != null) {
                com.anythink.expressad.mbbanner.a.d.c.this.d.a();
            }
        }

        @Override // com.anythink.expressad.out.p.c
        public final void c(com.anythink.expressad.out.j jVar) {
        }

        @Override // com.anythink.expressad.out.p.c
        public final void d(com.anythink.expressad.out.j jVar) {
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$2, reason: invalid class name */
    public class AnonymousClass2 extends com.anythink.expressad.atsignalcommon.a.b {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            com.anythink.expressad.mbbanner.a.d.c.l(com.anythink.expressad.mbbanner.a.d.c.this);
            com.anythink.expressad.mbbanner.a.a.a.a(webView);
            com.anythink.expressad.mbbanner.a.d.c.n(com.anythink.expressad.mbbanner.a.d.c.this);
            if (com.anythink.expressad.mbbanner.a.d.c.this.f == null || com.anythink.expressad.mbbanner.a.d.c.this.f.s()) {
                return;
            }
            com.anythink.expressad.mbbanner.a.d.c.this.h();
            com.anythink.expressad.mbbanner.a.d.c.b();
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.mbbanner.a.d.c.this.a(str);
            com.anythink.expressad.mbbanner.a.d.c.b();
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            java.lang.String str;
            com.anythink.expressad.mbbanner.a.d.c.this.g.onPause();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.mbbanner.a.d.c.c;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.mbbanner.a.d.c.this.i, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            java.lang.String str;
            com.anythink.expressad.mbbanner.a.d.c.this.g.onResume();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.mbbanner.a.d.c.c;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.mbbanner.a.d.c.this.i, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            java.lang.String str;
            com.anythink.expressad.mbbanner.a.d.c.this.g.onResume();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.mbbanner.a.d.c.c;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.mbbanner.a.d.c.this.i, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.expressad.foundation.g.g.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void a() {
            com.anythink.expressad.mbbanner.a.d.c.this.a(com.anythink.expressad.mbbanner.a.a.n);
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void b() {
        }

        @Override // com.anythink.expressad.foundation.g.g.a
        public final void c() {
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$5, reason: invalid class name */
    public class AnonymousClass5 implements android.view.View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.mbbanner.a.d.c.this.q) {
                com.anythink.expressad.mbbanner.a.d.c.b(com.anythink.expressad.mbbanner.a.d.c.this);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.mbbanner.a.c.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a() {
            com.anythink.expressad.mbbanner.a.d.c.b(com.anythink.expressad.mbbanner.a.d.c.this);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(int i) {
            if (i == 2) {
                com.anythink.expressad.mbbanner.a.d.c.c(com.anythink.expressad.mbbanner.a.d.c.this);
            } else {
                com.anythink.expressad.mbbanner.a.d.c.this.l();
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.mbbanner.a.d.c.this.a(cVar, false, "");
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(boolean z) {
            if (com.anythink.expressad.mbbanner.a.d.c.this.d != null) {
                com.anythink.expressad.mbbanner.a.d.c.this.p = z;
                if (z) {
                    com.anythink.expressad.mbbanner.a.d.c.this.d.b();
                } else {
                    com.anythink.expressad.mbbanner.a.d.c.this.d.c();
                }
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void a(boolean z, java.lang.String str) {
            try {
                if (com.anythink.expressad.mbbanner.a.d.c.this.d != null) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.anythink.expressad.mbbanner.a.d.c.this.d.a(com.anythink.expressad.mbbanner.a.d.c.this.f);
                        com.anythink.expressad.mbbanner.a.d.c.this.d.a();
                    } else {
                        com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(com.anythink.expressad.mbbanner.a.d.c.this.f));
                        b.p(str);
                        com.anythink.expressad.mbbanner.a.d.c.this.a(b, z, str);
                    }
                }
            } catch (java.lang.Exception e) {
                java.lang.String unused = com.anythink.expressad.mbbanner.a.d.c.c;
                e.getMessage();
            }
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void b() {
            com.anythink.expressad.mbbanner.a.d.c.b(com.anythink.expressad.mbbanner.a.d.c.this);
        }

        @Override // com.anythink.expressad.mbbanner.a.c.a
        public final void b(int i) {
            if (i != 1) {
                com.anythink.expressad.mbbanner.a.d.c.this.e();
            } else {
                com.anythink.expressad.mbbanner.a.d.c.this.h();
                com.anythink.expressad.mbbanner.a.d.c.b();
            }
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$7, reason: invalid class name */
    public class AnonymousClass7 implements android.view.View.OnTouchListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            com.anythink.expressad.mbbanner.a.d.c.this.z = motionEvent.getRawX();
            com.anythink.expressad.mbbanner.a.d.c.this.A = motionEvent.getRawY();
            java.lang.String unused = com.anythink.expressad.mbbanner.a.d.c.c;
            float unused2 = com.anythink.expressad.mbbanner.a.d.c.this.z;
            float unused3 = com.anythink.expressad.mbbanner.a.d.c.this.A;
            return false;
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.mbbanner.a.d.c.this.a(com.anythink.expressad.mbbanner.a.e.b.a(com.anythink.expressad.atsignalcommon.bridge.CommonJSBridgeImpUtils.buildClickJsonObject(com.anythink.expressad.mbbanner.a.d.c.this.z, com.anythink.expressad.mbbanner.a.d.c.this.A), com.anythink.expressad.mbbanner.a.d.c.this.f), false, "");
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.mbbanner.a.d.c$9, reason: invalid class name */
    public class AnonymousClass9 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass9() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (com.anythink.expressad.mbbanner.a.d.c.this.h != null) {
                com.anythink.expressad.mbbanner.a.d.c.this.h.setImageBitmap(bitmap);
            }
            com.anythink.expressad.mbbanner.a.d.c.l(com.anythink.expressad.mbbanner.a.d.c.this);
            com.anythink.expressad.mbbanner.a.d.c.m(com.anythink.expressad.mbbanner.a.d.c.this);
            com.anythink.expressad.mbbanner.a.d.c.this.l();
            com.anythink.expressad.mbbanner.a.d.c.this.h();
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.mbbanner.a.d.c.this.a(com.anythink.expressad.mbbanner.a.a.j);
        }
    }

    public c(com.anythink.expressad.out.TemplateBannerView templateBannerView, com.anythink.expressad.mbbanner.a.c.c cVar, java.lang.String str, java.lang.String str2, boolean z, com.anythink.expressad.d.c cVar2) {
        this.e = z;
        this.g = templateBannerView;
        this.r = str2;
        this.f249s = str;
        this.d = new com.anythink.expressad.mbbanner.a.c.e(cVar, cVar2);
    }

    private static java.lang.String a(com.anythink.expressad.foundation.d.c cVar) {
        java.lang.String concat;
        java.io.File file;
        if (cVar == null) {
            return "";
        }
        java.lang.String b = com.anythink.expressad.videocommon.b.j.a().b(cVar.p());
        if (android.text.TextUtils.isEmpty(b)) {
            b = cVar.q();
            if (cVar.ay()) {
                try {
                    file = new java.io.File(b);
                } catch (java.lang.Exception unused) {
                    java.io.File file2 = new java.io.File(b);
                    if (file2.exists() && file2.isFile() && file2.canRead()) {
                        concat = "file:////".concat(java.lang.String.valueOf(b));
                    }
                }
                if (!file.exists()) {
                    return "";
                }
                concat = com.anythink.expressad.foundation.h.m.a(file);
                return concat;
            }
            java.io.File file3 = new java.io.File(b);
            if (file3.exists() && file3.isFile() && file3.canRead()) {
                return "file:////".concat(java.lang.String.valueOf(b));
            }
        }
        return b;
    }

    private static void a(com.anythink.expressad.foundation.d.c cVar, android.content.Context context, java.lang.String str) {
        if (cVar != null) {
            try {
                java.util.List<java.lang.String> e = cVar.e();
                if (e == null || e.size() <= 0) {
                    return;
                }
                java.util.Iterator<java.lang.String> it = e.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.a.a.a(context, cVar, str, it.next(), true);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str) {
        if (this.f == null || i()) {
            return;
        }
        this.x.removeCallbacks(this.y);
        com.anythink.expressad.mbbanner.a.c.c cVar = this.d;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    private com.anythink.expressad.foundation.d.c b(com.anythink.expressad.foundation.d.d dVar) {
        if (dVar != null) {
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVar.J;
            this.t = arrayList;
            if (arrayList != null && arrayList.size() > 0) {
                return this.t.get(0);
            }
        }
        return null;
    }

    public static /* synthetic */ void b() {
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            c(cVar, com.anythink.core.common.b.o.a().f(), this.r);
            b(cVar, com.anythink.core.common.b.o.a().f(), this.r);
            a(cVar, com.anythink.core.common.b.o.a().f(), this.r);
        }
    }

    private static void b(com.anythink.expressad.foundation.d.c cVar, android.content.Context context, java.lang.String str) {
        if (cVar != null) {
            try {
                if (android.text.TextUtils.isEmpty(cVar.ai())) {
                    return;
                }
                com.anythink.expressad.a.a.a(context, cVar, str, cVar.ai(), false, true, com.anythink.expressad.a.a.a.j);
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    public static /* synthetic */ void b(com.anythink.expressad.mbbanner.a.d.c cVar) {
        com.anythink.expressad.mbbanner.a.c.c cVar2 = cVar.d;
        if (cVar2 != null) {
            cVar2.d();
        }
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar, android.content.Context context, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(cVar.ag())) {
            com.anythink.expressad.a.a.a(context, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
        }
        if (android.text.TextUtils.isEmpty(str) || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, str, cVar.L().o(), false);
    }

    public static /* synthetic */ void c(com.anythink.expressad.mbbanner.a.d.c cVar) {
        android.widget.ImageView imageView;
        if (cVar.e && (imageView = cVar.j) != null && imageView.getVisibility() == 0) {
            cVar.j.setVisibility(8);
            cVar.j.setOnClickListener(null);
            if (cVar.g == null || cVar.j.getParent() == null) {
                return;
            }
            cVar.g.removeView(cVar.j);
        }
    }

    private void d(boolean z) {
        if (this.g != null) {
            android.view.View b = com.anythink.expressad.foundation.f.b.a().b(this.r);
            if (com.anythink.expressad.foundation.f.b.a().b() && z && b != null) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) b.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(b);
                }
                b.setVisibility(0);
                android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) b.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
                }
                layoutParams.addRule(12);
                b.setLayoutParams(layoutParams);
                this.g.addView(b);
            }
            com.anythink.expressad.foundation.f.b.a().a(this.r, new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass3());
            this.f.l(this.r);
            com.anythink.expressad.foundation.f.b.a().a(this.r, this.f);
        }
    }

    private boolean d() {
        java.lang.String a = a(this.f);
        if (android.text.TextUtils.isEmpty(a)) {
            return false;
        }
        if (this.g == null) {
            a(com.anythink.expressad.mbbanner.a.a.i);
            return true;
        }
        if (this.i == null) {
            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView = new com.anythink.expressad.mbbanner.view.ATBannerWebView(com.anythink.core.common.b.o.a().f());
            this.i = aTBannerWebView;
            aTBannerWebView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
            this.i.setWebViewClient(new com.anythink.expressad.mbbanner.view.a(this.r, this.t, this.C));
        }
        android.widget.ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (this.i.getVisibility() != 0) {
            this.i.setVisibility(0);
        }
        if (this.i.getParent() == null) {
            this.g.addView(this.i);
            d(this.f.H());
        }
        l();
        com.anythink.expressad.mbbanner.a.a.c cVar = new com.anythink.expressad.mbbanner.a.a.c(this.g.getContext(), this.f249s, this.r);
        this.w = cVar;
        cVar.a(this.t);
        this.w.a(this.C);
        this.w.a(this.u);
        this.i.setWebViewListener(this.D);
        this.i.setObject(this.w);
        if (a.startsWith("file")) {
            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView2 = this.i;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(aTBannerWebView2, a);
            aTBannerWebView2.loadUrl(a);
            return true;
        }
        com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView3 = this.i;
        java.lang.String p = this.f.p();
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(aTBannerWebView3, p, a, "text/html", "utf-8", null);
        aTBannerWebView3.loadDataWithBaseURL(p, a, "text/html", "utf-8", null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    public void e() {
        if (this.g == null) {
            a(com.anythink.expressad.mbbanner.a.a.i);
            return;
        }
        com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView = this.i;
        if (aTBannerWebView != null && aTBannerWebView.getParent() != null) {
            this.g.removeView(this.i);
        }
        if (this.h == null) {
            android.widget.ImageView imageView = new android.widget.ImageView(com.anythink.core.common.b.o.a().f());
            this.h = imageView;
            imageView.setOnTouchListener(new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass7());
            this.h.setOnClickListener(new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass8());
        }
        java.lang.String be = this.f.be();
        if (android.text.TextUtils.isEmpty(be)) {
            a(com.anythink.expressad.mbbanner.a.a.h);
        } else {
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).a(be, new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass9());
        }
    }

    private void f() {
        if (this.e && this.j == null) {
            android.widget.ImageView imageView = new android.widget.ImageView(com.anythink.core.common.b.o.a().f());
            this.j = imageView;
            imageView.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_banner_close", com.anythink.expressad.foundation.h.i.c));
            this.j.setVisibility(8);
            this.j.setContentDescription("closeButton");
        }
    }

    private boolean g() {
        com.anythink.expressad.out.TemplateBannerView templateBannerView = this.g;
        return (templateBannerView == null || com.anythink.expressad.foundation.h.y.a(templateBannerView) || this.p) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.anythink.expressad.out.TemplateBannerView templateBannerView;
        if (this.m && !this.n && this.d != null) {
            this.n = true;
            this.x.removeCallbacks(this.y);
            com.anythink.expressad.foundation.d.c cVar = this.f;
            if (cVar != null && !cVar.am()) {
                this.f.an();
                this.d.a(this.t);
            }
        }
        if (this.m && this.k && this.l && this.n && this.f != null && !i()) {
            com.anythink.expressad.out.TemplateBannerView templateBannerView2 = this.g;
            boolean z = (templateBannerView2 == null || com.anythink.expressad.foundation.h.y.a(templateBannerView2) || this.p) ? false : true;
            if (!z && (templateBannerView = this.g) != null) {
                templateBannerView.postDelayed(new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass10(), 1000L);
            }
            if (this.o && z) {
                int[] iArr = new int[2];
                this.g.getLocationInWindow(iArr);
                com.anythink.expressad.mbbanner.a.a.a.a(this.i, iArr[0], iArr[1]);
                com.anythink.expressad.mbbanner.a.a.a.a(this.i, iArr[0], iArr[1], this.g.getWidth(), this.g.getHeight());
                this.o = false;
                if (!android.text.TextUtils.isEmpty(this.f.be())) {
                    com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).c(this.f.be());
                }
            }
            this.f.aZ();
            if (!z) {
                this.f.c(false);
                return;
            }
            android.widget.ImageView imageView = this.h;
            if (imageView == null || imageView.getVisibility() != 0) {
                java.util.List<com.anythink.expressad.foundation.d.c> list = this.t;
                if (list != null && list.size() > 0) {
                    boolean z2 = false;
                    int i = 0;
                    for (int i2 = 0; i2 < this.t.size(); i2++) {
                        if (!this.t.get(i2).s() && (i2 == 0 || !this.t.get(i2).V())) {
                            c(this.t.get(i2), com.anythink.core.common.b.o.a().f(), this.r);
                            this.t.get(i2).c(true);
                            com.anythink.expressad.foundation.g.a.f.a(this.r, this.t.get(i2), "banner");
                            i = i2;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        b(this.t.get(i), com.anythink.core.common.b.o.a().f(), this.r);
                        a(this.t.get(i), com.anythink.core.common.b.o.a().f(), this.r);
                    }
                }
            } else {
                com.anythink.expressad.foundation.d.c cVar2 = this.f;
                if (cVar2 != null) {
                    if (cVar2 != null) {
                        c(cVar2, com.anythink.core.common.b.o.a().f(), this.r);
                        b(cVar2, com.anythink.core.common.b.o.a().f(), this.r);
                        a(cVar2, com.anythink.core.common.b.o.a().f(), this.r);
                    }
                    this.f.c(true);
                    com.anythink.expressad.foundation.g.a.f.a(this.r, this.f, "banner");
                }
            }
            this.q = true;
            com.anythink.expressad.mbbanner.a.c.c cVar3 = this.d;
            if (cVar3 != null) {
                cVar3.a(this.f, false);
            }
            this.x.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private synchronized boolean i() {
        boolean V;
        V = this.f.V();
        if (!V) {
            this.f.c(true);
        }
        return V;
    }

    private void j() {
        com.anythink.expressad.mbbanner.a.c.c cVar = this.d;
        if (cVar != null) {
            cVar.d();
        }
    }

    private void k() {
        if (this.h != null) {
            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView = this.i;
            if (aTBannerWebView != null) {
                aTBannerWebView.setVisibility(8);
            }
            if (this.h.getVisibility() != 0) {
                this.h.setVisibility(0);
            }
            if (this.g != null) {
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                this.h.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                if (this.h.getParent() == null) {
                    this.g.addView(this.h, layoutParams);
                }
                d(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        android.widget.ImageView imageView;
        if (!this.e || (imageView = this.j) == null) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            this.j.setVisibility(0);
            this.j.setOnClickListener(this.B);
        }
        if (this.j.getParent() != null || this.g == null) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 12.0f), com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 12.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.g.addView(this.j, layoutParams);
    }

    public static /* synthetic */ boolean l(com.anythink.expressad.mbbanner.a.d.c cVar) {
        cVar.m = true;
        return true;
    }

    private void m() {
        android.widget.ImageView imageView;
        if (this.e && (imageView = this.j) != null && imageView.getVisibility() == 0) {
            this.j.setVisibility(8);
            this.j.setOnClickListener(null);
            if (this.g == null || this.j.getParent() == null) {
                return;
            }
            this.g.removeView(this.j);
        }
    }

    public static /* synthetic */ void m(com.anythink.expressad.mbbanner.a.d.c cVar) {
        if (cVar.h != null) {
            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView = cVar.i;
            if (aTBannerWebView != null) {
                aTBannerWebView.setVisibility(8);
            }
            if (cVar.h.getVisibility() != 0) {
                cVar.h.setVisibility(0);
            }
            if (cVar.g != null) {
                android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                cVar.h.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
                if (cVar.h.getParent() == null) {
                    cVar.g.addView(cVar.h, layoutParams);
                }
                cVar.d(true);
            }
        }
    }

    private static void n() {
    }

    public static /* synthetic */ boolean n(com.anythink.expressad.mbbanner.a.d.c cVar) {
        cVar.o = true;
        return true;
    }

    public final void a() {
        if (this.d != null) {
            this.d = null;
        }
        com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView = this.i;
        if (aTBannerWebView != null) {
            aTBannerWebView.setWebViewListener(null);
        }
        if (this.D != null) {
            this.D = null;
        }
        android.widget.ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        android.widget.ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        com.anythink.expressad.out.TemplateBannerView templateBannerView = this.g;
        if (templateBannerView != null) {
            templateBannerView.removeAllViews();
        }
        com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView2 = this.i;
        if (aTBannerWebView2 != null) {
            aTBannerWebView2.release();
        }
        com.anythink.expressad.mbbanner.a.a.c cVar = this.w;
        if (cVar != null) {
            cVar.a();
        }
        if (this.C != null) {
            this.C = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.r);
    }

    public final void a(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        try {
            com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.getInstance().fireSizeChangeEvent(this.i, i, i2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z, java.lang.String str) {
        if (this.q) {
            if (this.a == null) {
                this.a = new com.anythink.expressad.a.a(com.anythink.core.common.b.o.a().f(), this.r);
            }
            this.a.a(new com.anythink.expressad.mbbanner.a.d.c.AnonymousClass11());
            cVar.l(this.r);
            if (!this.f.W()) {
                this.f.X();
            }
            com.anythink.expressad.mbbanner.a.c.c cVar2 = this.d;
            if (cVar2 != null) {
                cVar2.a(cVar);
            }
            if (z) {
                android.text.TextUtils.isEmpty(str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.anythink.expressad.foundation.d.d dVar) {
        com.anythink.expressad.foundation.d.c cVar;
        boolean z = false;
        if (dVar != null) {
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVar.J;
            this.t = arrayList;
            if (arrayList != null && arrayList.size() > 0) {
                cVar = this.t.get(0);
                this.f = cVar;
                if (cVar != null) {
                    a(com.anythink.expressad.mbbanner.a.a.h);
                    return;
                }
                this.x.removeCallbacks(this.y);
                if (this.e && this.j == null) {
                    android.widget.ImageView imageView = new android.widget.ImageView(com.anythink.core.common.b.o.a().f());
                    this.j = imageView;
                    imageView.setBackgroundResource(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), "anythink_banner_close", com.anythink.expressad.foundation.h.i.c));
                    this.j.setVisibility(8);
                    this.j.setContentDescription("closeButton");
                }
                this.m = false;
                this.n = false;
                this.q = false;
                if (android.text.TextUtils.isEmpty(this.f.q())) {
                    android.text.TextUtils.isEmpty(this.f.p());
                }
                this.x.postDelayed(this.y, this.v);
                java.lang.String a = a(this.f);
                if (!android.text.TextUtils.isEmpty(a)) {
                    if (this.g != null) {
                        if (this.i == null) {
                            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView = new com.anythink.expressad.mbbanner.view.ATBannerWebView(com.anythink.core.common.b.o.a().f());
                            this.i = aTBannerWebView;
                            aTBannerWebView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
                            this.i.setWebViewClient(new com.anythink.expressad.mbbanner.view.a(this.r, this.t, this.C));
                        }
                        android.widget.ImageView imageView2 = this.h;
                        if (imageView2 != null) {
                            imageView2.setVisibility(8);
                        }
                        if (this.i.getVisibility() != 0) {
                            this.i.setVisibility(0);
                        }
                        if (this.i.getParent() == null) {
                            this.g.addView(this.i);
                            d(this.f.H());
                        }
                        l();
                        com.anythink.expressad.mbbanner.a.a.c cVar2 = new com.anythink.expressad.mbbanner.a.a.c(this.g.getContext(), this.f249s, this.r);
                        this.w = cVar2;
                        cVar2.a(this.t);
                        this.w.a(this.C);
                        this.w.a(this.u);
                        this.i.setWebViewListener(this.D);
                        this.i.setObject(this.w);
                        if (a.startsWith("file")) {
                            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView2 = this.i;
                            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(aTBannerWebView2, a);
                            aTBannerWebView2.loadUrl(a);
                        } else {
                            com.anythink.expressad.mbbanner.view.ATBannerWebView aTBannerWebView3 = this.i;
                            java.lang.String p = this.f.p();
                            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(aTBannerWebView3, p, a, "text/html", "utf-8", null);
                            aTBannerWebView3.loadDataWithBaseURL(p, a, "text/html", "utf-8", null);
                        }
                    } else {
                        a(com.anythink.expressad.mbbanner.a.a.i);
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                if (android.text.TextUtils.isEmpty(this.f.q())) {
                    android.text.TextUtils.isEmpty(this.f.p());
                }
                e();
                return;
            }
        }
        cVar = null;
        this.f = cVar;
        if (cVar != null) {
        }
    }

    public final void a(com.anythink.expressad.out.i iVar) {
        this.b = iVar;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void a(boolean z, int i) {
        this.u = i;
        if (i == 0) {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.d.c c2 = com.anythink.expressad.d.b.c(com.anythink.expressad.foundation.b.a.b().e(), this.r);
            if (c2 == null) {
                return;
            } else {
                z = c2.d() == 1;
            }
        }
        this.e = z;
    }

    public final void b(boolean z) {
        this.k = z;
        h();
    }

    public final void c(boolean z) {
        this.l = z;
        h();
    }
}
