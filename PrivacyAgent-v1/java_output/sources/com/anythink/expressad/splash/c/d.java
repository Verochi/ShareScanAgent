package com.anythink.expressad.splash.c;

/* loaded from: classes12.dex */
public final class d {
    private com.anythink.expressad.foundation.d.c d;
    private com.anythink.expressad.splash.view.ATSplashView e;
    private com.anythink.expressad.splash.d.d f;
    private com.anythink.expressad.a.a g;
    private boolean h;
    private android.widget.TextView i;
    private android.view.View j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String n;
    private java.lang.String o;
    private java.lang.String p;
    private java.lang.String q;
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f259s;
    private android.content.Context u;
    private java.lang.String c = "SplashShowManager";
    private int m = 5;
    private boolean t = false;
    private android.view.View.OnClickListener v = new com.anythink.expressad.splash.c.d.AnonymousClass1();
    private com.anythink.core.common.o.a.f.b w = new com.anythink.core.common.o.a.f.b();
    public android.os.Handler a = new com.anythink.expressad.splash.c.d.AnonymousClass2(android.os.Looper.getMainLooper());
    private com.anythink.expressad.splash.d.a x = new com.anythink.expressad.splash.c.d.AnonymousClass3();
    android.graphics.Rect b = new android.graphics.Rect();

    /* renamed from: com.anythink.expressad.splash.c.d$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.splash.c.d.this.h) {
                com.anythink.expressad.splash.c.d.b(com.anythink.expressad.splash.c.d.this);
                com.anythink.expressad.splash.c.d.a(com.anythink.expressad.splash.c.d.this, -1);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.d$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1) {
                if (i == 2 && com.anythink.expressad.splash.c.d.this.d != null && com.anythink.expressad.splash.c.d.this.d.ay() && com.anythink.expressad.splash.c.d.this.e != null) {
                    com.anythink.expressad.splash.c.d.this.e.getSplashWebview();
                    return;
                }
                return;
            }
            if (com.anythink.expressad.splash.c.d.this.t) {
                return;
            }
            if (com.anythink.expressad.splash.c.d.this.e == null || !com.anythink.core.common.o.w.a(com.anythink.expressad.splash.c.d.this.e, com.anythink.expressad.splash.c.d.this.w)) {
                com.anythink.expressad.splash.c.d.this.a.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
            } else {
                if (com.anythink.expressad.splash.c.d.this.m <= 0) {
                    com.anythink.expressad.splash.c.d.b(com.anythink.expressad.splash.c.d.this);
                    return;
                }
                com.anythink.expressad.splash.c.d.g(com.anythink.expressad.splash.c.d.this);
                com.anythink.expressad.splash.c.d dVar = com.anythink.expressad.splash.c.d.this;
                com.anythink.expressad.splash.c.d.a(dVar, dVar.m);
                com.anythink.expressad.splash.c.d.this.a.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.d$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.splash.d.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a() {
            com.anythink.expressad.splash.c.d.b(com.anythink.expressad.splash.c.d.this);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(int i) {
            if (com.anythink.expressad.splash.c.d.this.e != null) {
                com.anythink.expressad.splash.c.d.this.e.changeCloseBtnState(i);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(int i, int i2) {
            if (i == 1) {
                com.anythink.expressad.splash.c.d.this.a.removeMessages(1);
            }
            if (i == 2) {
                com.anythink.expressad.splash.c.d.this.m = i2;
                com.anythink.expressad.splash.c.d.this.a.removeMessages(1);
                com.anythink.expressad.splash.c.d.this.a.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.splash.c.d.this.a(cVar);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(java.lang.String str) {
            com.anythink.expressad.splash.c.d.a(com.anythink.expressad.splash.c.d.this, str);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void a(boolean z) {
            if (z) {
                com.anythink.expressad.splash.c.d.this.a.removeMessages(1);
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b(int i) {
            java.lang.String unused = com.anythink.expressad.splash.c.d.this.c;
            com.anythink.expressad.splash.c.d.this.m = i;
            com.anythink.expressad.splash.c.d.this.a.removeMessages(1);
            com.anythink.expressad.splash.c.d.this.a.sendEmptyMessageDelayed(1, 1000L);
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void b(java.lang.String str) {
            try {
                if (com.anythink.expressad.splash.c.d.this.f != null) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.anythink.expressad.splash.c.d.this.f.a(com.anythink.expressad.splash.c.d.this.d);
                        return;
                    }
                    com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(com.anythink.expressad.splash.c.d.this.d));
                    b.p(str);
                    com.anythink.expressad.splash.c.d.this.a(b);
                }
            } catch (java.lang.Exception e) {
                java.lang.String unused = com.anythink.expressad.splash.c.d.this.c;
                e.getMessage();
            }
        }

        @Override // com.anythink.expressad.splash.d.a
        public final void c() {
            com.anythink.expressad.splash.c.d.b(com.anythink.expressad.splash.c.d.this);
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.d$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnAttachStateChangeListener {

        /* renamed from: com.anythink.expressad.splash.c.d$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.splash.c.d dVar = com.anythink.expressad.splash.c.d.this;
                if (com.anythink.expressad.splash.c.d.a(dVar, dVar.e)) {
                    com.anythink.expressad.splash.c.d.this.g();
                }
            }
        }

        public AnonymousClass4() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(android.view.View view) {
            com.anythink.core.common.b.o.a().a(new com.anythink.expressad.splash.c.d.AnonymousClass4.AnonymousClass1(), 30L);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(android.view.View view) {
            com.anythink.expressad.splash.c.d.this.c();
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.d$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.splash.c.d dVar = com.anythink.expressad.splash.c.d.this;
            if (com.anythink.expressad.splash.c.d.a(dVar, dVar.e)) {
                com.anythink.expressad.splash.c.d.this.g();
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.d$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass6() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            java.lang.String str;
            com.anythink.expressad.splash.c.d.this.e();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.splash.c.d.this.c;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.splash.c.d.this.e.getSplashWebview(), com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            java.lang.String str;
            com.anythink.expressad.splash.c.d.this.d();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.splash.c.d.this.c;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.splash.c.d.this.e.getSplashWebview(), com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            java.lang.String str;
            com.anythink.expressad.splash.c.d.this.d();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.splash.c.d.this.c;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.splash.c.d.this.e.getSplashWebview(), com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }
    }

    public d(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.k = str2;
        this.l = str;
        this.u = context;
        int a = com.anythink.expressad.foundation.h.i.a(context.getApplicationContext(), "anythink_splash_count_time_can_skip", com.anythink.expressad.foundation.h.i.g);
        int a2 = com.anythink.expressad.foundation.h.i.a(this.u.getApplicationContext(), "anythink_splash_count_time_can_skip_not", com.anythink.expressad.foundation.h.i.g);
        int a3 = com.anythink.expressad.foundation.h.i.a(this.u.getApplicationContext(), "anythink_splash_count_time_can_skip_s", com.anythink.expressad.foundation.h.i.g);
        this.o = this.u.getResources().getString(a);
        this.q = this.u.getResources().getString(a2);
        this.p = this.u.getResources().getString(a3);
        if (this.i == null) {
            android.widget.TextView textView = new android.widget.TextView(context);
            this.i = textView;
            textView.setGravity(1);
            this.i.setTextIsSelectable(false);
            this.i.setPadding(com.anythink.expressad.foundation.h.t.b(context, 5.0f), com.anythink.expressad.foundation.h.t.b(context, 5.0f), com.anythink.expressad.foundation.h.t.b(context, 5.0f), com.anythink.expressad.foundation.h.t.b(context, 5.0f));
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.i.getLayoutParams();
            this.i.setLayoutParams(layoutParams == null ? new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(context, 100.0f), com.anythink.expressad.foundation.h.t.b(context, 50.0f)) : layoutParams);
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            if (f != null) {
                java.lang.String a4 = com.anythink.expressad.foundation.b.a.b().a();
                int identifier = f.getResources().getIdentifier("anythink_splash_count_time_can_skip", com.anythink.expressad.foundation.h.i.g, a4);
                int identifier2 = f.getResources().getIdentifier("anythink_splash_count_time_can_skip_not", com.anythink.expressad.foundation.h.i.g, a4);
                int identifier3 = f.getResources().getIdentifier("anythink_splash_count_time_can_skip_s", com.anythink.expressad.foundation.h.i.g, a4);
                this.o = f.getResources().getString(identifier);
                java.lang.String string = f.getResources().getString(identifier2);
                this.q = string;
                this.n = string;
                this.p = f.getResources().getString(identifier3);
                this.i.setBackgroundResource(f.getResources().getIdentifier("anythink_splash_close_bg", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
                this.i.setTextColor(f.getResources().getColor(f.getResources().getIdentifier("anythink_splash_count_time_skip_text_color", "color", a4)));
            }
        }
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

    public static /* synthetic */ void a(com.anythink.expressad.splash.c.d dVar, int i) {
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = dVar.e;
        if (aTSplashView != null) {
            aTSplashView.updateCountdown(i);
            if (dVar.e.getSplashJSBridgeImpl() != null) {
                dVar.e.getSplashJSBridgeImpl().updateCountDown(i);
            }
        }
        if (i < 0) {
            dVar.m = i;
        } else if (dVar.j == null) {
            dVar.i();
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.splash.c.d dVar, java.lang.String str) {
        com.anythink.expressad.splash.d.d dVar2 = dVar.f;
        if (dVar2 != null) {
            dVar2.a("web show failed:".concat(java.lang.String.valueOf(str)));
        }
    }

    private void a(java.lang.String str) {
        com.anythink.expressad.splash.d.d dVar = this.f;
        if (dVar != null) {
            dVar.a("web show failed:".concat(java.lang.String.valueOf(str)));
        }
    }

    private boolean a(android.view.View view) {
        return view != null && view.getVisibility() == 0 && view.getParent() != null && view.getWindowVisibility() == 0 && view.getGlobalVisibleRect(this.b) && ((long) this.b.height()) * ((long) this.b.width()) > 0;
    }

    public static /* synthetic */ boolean a(com.anythink.expressad.splash.c.d dVar, android.view.View view) {
        return view != null && view.getVisibility() == 0 && view.getParent() != null && view.getWindowVisibility() == 0 && view.getGlobalVisibleRect(dVar.b) && ((long) dVar.b.height()) * ((long) dVar.b.width()) > 0;
    }

    private void b(int i) {
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.updateCountdown(i);
            if (this.e.getSplashJSBridgeImpl() != null) {
                this.e.getSplashJSBridgeImpl().updateCountDown(i);
            }
        }
        if (i < 0) {
            this.m = i;
        } else if (this.j == null) {
            i();
        }
    }

    private void b(android.view.View view) {
        if (view != null) {
            view.setOnClickListener(this.v);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z;
        if (cVar.s()) {
            z = false;
        } else {
            c(cVar, com.anythink.core.common.b.o.a().f(), this.k);
            z = true;
            cVar.c(true);
            com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, "splash");
        }
        if (z) {
            b(cVar, com.anythink.core.common.b.o.a().f(), this.k);
            a(cVar, com.anythink.core.common.b.o.a().f(), this.k);
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

    public static /* synthetic */ void b(com.anythink.expressad.splash.c.d dVar) {
        if (dVar.t) {
            return;
        }
        try {
            dVar.t = true;
            com.anythink.expressad.splash.d.d dVar2 = dVar.f;
            if (dVar2 != null) {
                dVar2.b();
                dVar.f = null;
            }
            dVar.f259s = false;
            com.anythink.expressad.splash.view.ATSplashView aTSplashView = dVar.e;
            if (aTSplashView != null) {
                aTSplashView.getSplashWebview();
            }
            android.os.Handler handler = dVar.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        b(cVar, com.anythink.core.common.b.o.a().f(), this.k);
        c(cVar, com.anythink.core.common.b.o.a().f(), this.k);
        a(cVar, com.anythink.core.common.b.o.a().f(), this.k);
        cVar.c(true);
        com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, "splash");
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar, android.content.Context context, java.lang.String str) {
        com.anythink.expressad.foundation.b.a.b().b(context);
        if (!android.text.TextUtils.isEmpty(cVar.ag())) {
            com.anythink.expressad.a.a.a(context, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
        }
        if (android.text.TextUtils.isEmpty(str) || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, str, cVar.L().o(), false);
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.splash.d.d dVar = this.f;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    private void f() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        if (f != null) {
            java.lang.String a = com.anythink.expressad.foundation.b.a.b().a();
            int identifier = f.getResources().getIdentifier("anythink_splash_count_time_can_skip", com.anythink.expressad.foundation.h.i.g, a);
            int identifier2 = f.getResources().getIdentifier("anythink_splash_count_time_can_skip_not", com.anythink.expressad.foundation.h.i.g, a);
            int identifier3 = f.getResources().getIdentifier("anythink_splash_count_time_can_skip_s", com.anythink.expressad.foundation.h.i.g, a);
            this.o = f.getResources().getString(identifier);
            java.lang.String string = f.getResources().getString(identifier2);
            this.q = string;
            this.n = string;
            this.p = f.getResources().getString(identifier3);
            this.i.setBackgroundResource(f.getResources().getIdentifier("anythink_splash_close_bg", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
            this.i.setTextColor(f.getResources().getColor(f.getResources().getIdentifier("anythink_splash_count_time_skip_text_color", "color", a)));
        }
    }

    public static /* synthetic */ int g(com.anythink.expressad.splash.c.d dVar) {
        int i = dVar.m;
        dVar.m = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.d != null && !this.f259s) {
            boolean z = true;
            this.f259s = true;
            if (this.f != null && this.e != null) {
                android.content.Context context = this.u;
                if (context != null && (context instanceof android.app.Activity) && ((android.app.Activity) context).isFinishing()) {
                    this.f.a("Activity is finishing");
                    return;
                }
                this.f.a();
            }
            if (!this.d.V()) {
                if (!this.e.isDynamicView()) {
                    com.anythink.expressad.foundation.d.c cVar = this.d;
                    if (cVar.s()) {
                        z = false;
                    } else {
                        c(cVar, com.anythink.core.common.b.o.a().f(), this.k);
                        cVar.c(true);
                        com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, "splash");
                    }
                    if (z) {
                        b(cVar, com.anythink.core.common.b.o.a().f(), this.k);
                        a(cVar, com.anythink.core.common.b.o.a().f(), this.k);
                    }
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar2 = this.d;
                b(cVar2, com.anythink.core.common.b.o.a().f(), this.k);
                c(cVar2, com.anythink.core.common.b.o.a().f(), this.k);
                a(cVar2, com.anythink.core.common.b.o.a().f(), this.k);
                cVar2.c(true);
                com.anythink.expressad.foundation.g.a.f.a(this.k, cVar2, "splash");
            }
        }
    }

    private void h() {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        if (com.anythink.expressad.foundation.f.b.a().b() && !this.e.isDynamicView()) {
            com.anythink.expressad.foundation.f.b.a().a(this.k, new com.anythink.expressad.splash.c.d.AnonymousClass6());
            com.anythink.expressad.widget.FeedBackButton b = com.anythink.expressad.foundation.f.b.a().b(this.k);
            if (b != null) {
                try {
                    layoutParams = (android.widget.RelativeLayout.LayoutParams) b.getLayoutParams();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    layoutParams = null;
                }
                if (layoutParams == null) {
                    layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
                }
                layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
                layoutParams.leftMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) b.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(b);
                }
                this.e.addView(b, layoutParams);
            }
            this.d.l(this.k);
            com.anythink.expressad.foundation.f.b.a().a(this.k, this.d);
        }
    }

    private void i() {
        java.lang.String str;
        if (this.h) {
            str = this.o + this.m + this.p;
        } else {
            str = this.m + this.q;
        }
        this.i.setText(str);
    }

    private void j() {
        if (this.t) {
            return;
        }
        try {
            this.t = true;
            com.anythink.expressad.splash.d.d dVar = this.f;
            if (dVar != null) {
                dVar.b();
                this.f = null;
            }
            this.f259s = false;
            com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
            if (aTSplashView != null) {
                aTSplashView.getSplashWebview();
            }
            android.os.Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private void k() {
        com.anythink.expressad.splash.view.ATSplashWebview splashWebview;
        android.os.Handler handler;
        this.r = false;
        if (this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
            this.a.sendEmptyMessageDelayed(1, 1000L);
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
        if (aTSplashView == null || (splashWebview = aTSplashView.getSplashWebview()) == null || splashWebview.isDestroyed()) {
            return;
        }
        com.anythink.expressad.splash.js.SplashJsUtils.sendEventToH5(splashWebview, "onInstallAlertHide", "");
    }

    private void l() {
        com.anythink.expressad.splash.view.ATSplashWebview splashWebview;
        android.os.Handler handler;
        this.r = true;
        if (this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
        if (aTSplashView == null || (splashWebview = aTSplashView.getSplashWebview()) == null || splashWebview.isDestroyed()) {
            return;
        }
        com.anythink.expressad.splash.js.SplashJsUtils.sendEventToH5(splashWebview, "onInstallAlertShow", "");
    }

    public final com.anythink.expressad.splash.d.a a() {
        return this.x;
    }

    public final void a(int i) {
        this.m = i;
    }

    public final void a(android.view.ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.v);
        }
        this.j = viewGroup;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                cVar.aA();
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
        com.anythink.expressad.splash.d.d dVar = this.f;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.splash.view.ATSplashView aTSplashView) {
        android.widget.RelativeLayout.LayoutParams layoutParams;
        a(this.h);
        this.d = cVar;
        this.e = aTSplashView;
        com.anythink.expressad.splash.js.SplashJSBridgeImpl splashJSBridgeImpl = aTSplashView.getSplashJSBridgeImpl();
        if (splashJSBridgeImpl == null) {
            splashJSBridgeImpl = new com.anythink.expressad.splash.js.SplashJSBridgeImpl(aTSplashView.getContext(), this.l, this.k);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.add(cVar);
            splashJSBridgeImpl.setCampaignList(arrayList);
        }
        splashJSBridgeImpl.setCountdownS(this.m);
        splashJSBridgeImpl.setAllowSkip(this.h ? 1 : 0);
        splashJSBridgeImpl.setSplashBridgeListener(this.x);
        aTSplashView.setSplashJSBridgeImpl(splashJSBridgeImpl);
        boolean s2 = cVar.s();
        android.view.View view = this.j;
        if (view == null) {
            if (s2) {
                this.i.setVisibility(8);
            }
            i();
            b(this.i);
            aTSplashView.setCloseView(this.i);
        } else {
            if (s2) {
                view.setVisibility(8);
            }
            b(this.j);
            aTSplashView.setCloseView(this.j);
        }
        aTSplashView.show();
        com.anythink.expressad.foundation.d.c cVar2 = this.d;
        if (cVar2 != null && cVar2.ay()) {
            aTSplashView.getSplashWebview();
        }
        aTSplashView.addOnAttachStateChangeListener(new com.anythink.expressad.splash.c.d.AnonymousClass4());
        com.anythink.core.common.b.o.a().a(new com.anythink.expressad.splash.c.d.AnonymousClass5(), 30L);
        com.anythink.expressad.splash.c.b.a(this.d.be());
        this.a.removeMessages(1);
        this.a.sendEmptyMessageDelayed(1, 1000L);
        this.a.sendEmptyMessageDelayed(2, 1000L);
        if (!com.anythink.expressad.foundation.f.b.a().b() || this.e.isDynamicView()) {
            return;
        }
        com.anythink.expressad.foundation.f.b.a().a(this.k, new com.anythink.expressad.splash.c.d.AnonymousClass6());
        com.anythink.expressad.widget.FeedBackButton b = com.anythink.expressad.foundation.f.b.a().b(this.k);
        if (b != null) {
            try {
                layoutParams = (android.widget.RelativeLayout.LayoutParams) b.getLayoutParams();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
            }
            layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
            layoutParams.leftMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) b.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(b);
            }
            this.e.addView(b, layoutParams);
        }
        this.d.l(this.k);
        com.anythink.expressad.foundation.f.b.a().a(this.k, this.d);
    }

    public final void a(com.anythink.expressad.splash.d.d dVar) {
        this.f = dVar;
    }

    public final void a(boolean z) {
        this.h = z;
        if (z) {
            this.n = this.o;
        } else {
            this.n = this.q;
        }
    }

    public final java.lang.String b() {
        com.anythink.expressad.foundation.d.c cVar = this.d;
        return (cVar == null || cVar.Z() == null) ? "" : this.d.Z();
    }

    public final void c() {
        android.os.Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(1);
            this.a.removeMessages(2);
        }
        if (this.f != null) {
            this.f = null;
        }
        if (this.x != null) {
            this.x = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.destroy();
        }
        com.anythink.expressad.foundation.f.b.a().c(this.k);
    }

    public final void d() {
        android.os.Handler handler;
        if (this.r || com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        if (this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
            this.a.sendEmptyMessageDelayed(1, 1000L);
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.onResume();
            com.anythink.expressad.splash.view.ATSplashWebview splashWebview = this.e.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestroyed()) {
                return;
            }
            com.anythink.expressad.splash.js.SplashJsUtils.sendEventToH5(splashWebview, com.anythink.expressad.splash.js.SplashJsUtils.b, "");
        }
    }

    public final void e() {
        android.os.Handler handler;
        if (this.m > 0 && (handler = this.a) != null) {
            handler.removeMessages(1);
        }
        com.anythink.expressad.splash.view.ATSplashView aTSplashView = this.e;
        if (aTSplashView != null) {
            aTSplashView.onPause();
            com.anythink.expressad.splash.view.ATSplashWebview splashWebview = this.e.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestroyed()) {
                return;
            }
            com.anythink.expressad.splash.js.SplashJsUtils.sendEventToH5(splashWebview, com.anythink.expressad.splash.js.SplashJsUtils.a, "");
        }
    }
}
