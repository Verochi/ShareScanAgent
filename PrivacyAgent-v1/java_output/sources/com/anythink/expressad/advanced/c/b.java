package com.anythink.expressad.advanced.c;

/* loaded from: classes12.dex */
public final class b {
    private com.anythink.expressad.foundation.d.c c;
    private com.anythink.expressad.advanced.view.ATNativeAdvancedView d;
    private com.anythink.expressad.advanced.d.d e;
    private com.anythink.expressad.a.a f;
    private com.anythink.expressad.advanced.d.c g;
    private boolean h;
    private android.widget.ImageView j;
    private java.lang.String k;
    private java.lang.String l;
    private boolean m;
    private java.lang.String b = "NativeAdvancedShowManager";
    private int i = -1;
    private android.view.View.OnClickListener n = new com.anythink.expressad.advanced.c.b.AnonymousClass1();
    public android.os.Handler a = new com.anythink.expressad.advanced.c.b.AnonymousClass2(android.os.Looper.getMainLooper());
    private com.anythink.expressad.advanced.d.a o = new com.anythink.expressad.advanced.c.b.AnonymousClass3();

    /* renamed from: com.anythink.expressad.advanced.c.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.advanced.c.b.this.h) {
                com.anythink.expressad.advanced.c.b.b(com.anythink.expressad.advanced.c.b.this);
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.b$2, reason: invalid class name */
    public class AnonymousClass2 extends android.os.Handler {
        public AnonymousClass2(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            super.handleMessage(message);
            if (message.what == 2 && com.anythink.expressad.advanced.c.b.this.c != null && com.anythink.expressad.advanced.c.b.this.c.ay() && com.anythink.expressad.advanced.c.b.this.d != null) {
                com.anythink.expressad.advanced.c.b.this.d.getAdvancedNativeWebview();
            }
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.advanced.d.a {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a() {
            if (com.anythink.expressad.advanced.c.b.this.d != null) {
                com.anythink.expressad.advanced.c.b.this.d.setVisibility(8);
            }
            com.anythink.expressad.advanced.c.b.b(com.anythink.expressad.advanced.c.b.this);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(int i) {
            com.anythink.expressad.advanced.c.b.this.i = i;
            if (com.anythink.expressad.advanced.c.b.this.d != null) {
                com.anythink.expressad.advanced.c.b.this.d.changeCloseBtnState(i);
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.advanced.c.b.this.a(cVar);
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(java.lang.String str) {
            try {
                if (com.anythink.expressad.advanced.c.b.this.e != null) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        com.anythink.expressad.advanced.c.b.this.e.a(com.anythink.expressad.advanced.c.b.this.c);
                        com.anythink.expressad.advanced.d.d unused = com.anythink.expressad.advanced.c.b.this.e;
                    } else {
                        com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(com.anythink.expressad.foundation.d.c.a(com.anythink.expressad.advanced.c.b.this.c));
                        b.p(str);
                        com.anythink.expressad.advanced.c.b.this.a(b);
                    }
                }
            } catch (java.lang.Exception e) {
                java.lang.String unused2 = com.anythink.expressad.advanced.c.b.this.b;
                e.getMessage();
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void a(boolean z) {
            if (com.anythink.expressad.advanced.c.b.this.e != null) {
                com.anythink.expressad.advanced.c.b.this.m = z;
                if (z) {
                    com.anythink.expressad.advanced.d.d unused = com.anythink.expressad.advanced.c.b.this.e;
                } else {
                    com.anythink.expressad.advanced.d.d unused2 = com.anythink.expressad.advanced.c.b.this.e;
                }
            }
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void b() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void c() {
            java.lang.String unused = com.anythink.expressad.advanced.c.b.this.b;
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void d() {
        }

        @Override // com.anythink.expressad.advanced.d.a
        public final void e() {
            com.anythink.expressad.advanced.c.b.b(com.anythink.expressad.advanced.c.b.this);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.b$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.foundation.f.a {
        final /* synthetic */ com.anythink.expressad.advanced.view.ATNativeAdvancedView a;

        public AnonymousClass4(com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView) {
            this.a = aTNativeAdvancedView;
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            java.lang.String str;
            com.anythink.expressad.advanced.c.b.this.e();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.advanced.c.b.this.b;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.a.getAdvancedNativeWebview(), com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            java.lang.String str;
            com.anythink.expressad.advanced.c.b.this.d();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.advanced.c.b.this.b;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.a.getAdvancedNativeWebview(), com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            java.lang.String str;
            com.anythink.expressad.advanced.c.b.this.d();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.advanced.c.b.this.b;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.a.getAdvancedNativeWebview(), com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }
    }

    /* renamed from: com.anythink.expressad.advanced.c.b$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.expressad.foundation.d.c a;
        final /* synthetic */ com.anythink.expressad.advanced.view.ATNativeAdvancedView b;

        public AnonymousClass5(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView) {
            this.a = cVar;
            this.b = aTNativeAdvancedView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.advanced.c.b.this.a(this.a, this.b, false);
        }
    }

    public b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        this.k = str2;
        this.l = str;
        if (this.j == null) {
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            this.j = imageView;
            imageView.setPadding(com.anythink.expressad.foundation.h.t.b(context, 2.0f), com.anythink.expressad.foundation.h.t.b(context, 2.0f), com.anythink.expressad.foundation.h.t.b(context, 2.0f), com.anythink.expressad.foundation.h.t.b(context, 2.0f));
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            this.j.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
            android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.j.getLayoutParams();
            this.j.setLayoutParams(layoutParams == null ? new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(f, 29.0f), com.anythink.expressad.foundation.h.t.b(f, 16.0f)) : layoutParams);
            this.j.setImageResource(f.getResources().getIdentifier("anythink_native_advanced_close_icon", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
        }
    }

    private void a(android.view.View view) {
        if (view != null) {
            view.setOnClickListener(this.n);
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

    public static /* synthetic */ void b(com.anythink.expressad.advanced.c.b bVar) {
        com.anythink.expressad.advanced.d.d dVar = bVar.e;
        if (dVar != null) {
            dVar.c();
            bVar.e = null;
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        boolean z = false;
        if (!cVar.s()) {
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            java.lang.String str = this.k;
            com.anythink.expressad.foundation.b.a.b().b(f);
            if (!android.text.TextUtils.isEmpty(cVar.ag())) {
                com.anythink.expressad.a.a.a(f, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
            }
            if (!android.text.TextUtils.isEmpty(str) && cVar.L() != null && cVar.L().o() != null) {
                com.anythink.expressad.a.a.a(f, cVar, str, cVar.L().o(), false);
            }
            z = true;
            cVar.c(true);
            com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, com.anythink.expressad.foundation.g.a.f.g);
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

    private void f() {
        android.content.Context f = com.anythink.core.common.b.o.a().f();
        this.j.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.j.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.h.t.b(f, 29.0f), com.anythink.expressad.foundation.h.t.b(f, 16.0f));
        }
        this.j.setLayoutParams(layoutParams);
        this.j.setImageResource(f.getResources().getIdentifier("anythink_native_advanced_close_icon", com.anythink.expressad.foundation.h.i.c, com.anythink.expressad.foundation.b.a.b().a()));
    }

    private void g() {
        if (this.c.V()) {
            return;
        }
        boolean z = true;
        this.c.c(true);
        com.anythink.expressad.foundation.d.c cVar = this.c;
        if (cVar.s()) {
            z = false;
        } else {
            android.content.Context f = com.anythink.core.common.b.o.a().f();
            java.lang.String str = this.k;
            com.anythink.expressad.foundation.b.a.b().b(f);
            if (!android.text.TextUtils.isEmpty(cVar.ag())) {
                com.anythink.expressad.a.a.a(f, cVar, str, cVar.ag(), false, true, com.anythink.expressad.a.a.a.i);
            }
            if (!android.text.TextUtils.isEmpty(str) && cVar.L() != null && cVar.L().o() != null) {
                com.anythink.expressad.a.a.a(f, cVar, str, cVar.L().o(), false);
            }
            cVar.c(true);
            com.anythink.expressad.foundation.g.a.f.a(this.k, cVar, com.anythink.expressad.foundation.g.a.f.g);
        }
        if (z) {
            b(cVar, com.anythink.core.common.b.o.a().f(), this.k);
            a(cVar, com.anythink.core.common.b.o.a().f(), this.k);
        }
        com.anythink.expressad.advanced.d.d dVar = this.e;
        if (dVar != null) {
            dVar.a();
        }
    }

    private static void h() {
    }

    private void i() {
        com.anythink.expressad.advanced.d.d dVar = this.e;
        if (dVar != null) {
            dVar.c();
            this.e = null;
        }
    }

    private static /* synthetic */ void j() {
    }

    public final java.lang.String a() {
        com.anythink.expressad.foundation.d.c cVar = this.c;
        return (cVar == null || cVar.Z() == null) ? "" : this.c.Z();
    }

    public final void a(com.anythink.expressad.advanced.d.c cVar) {
        this.g = cVar;
    }

    public final void a(com.anythink.expressad.advanced.d.d dVar) {
        this.e = dVar;
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        cVar.l(this.k);
        com.anythink.expressad.advanced.d.d dVar = this.e;
        if (dVar != null) {
            dVar.a(cVar);
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView, boolean z) {
        android.view.View b;
        android.widget.RelativeLayout.LayoutParams layoutParams;
        if (aTNativeAdvancedView == null) {
            return;
        }
        com.anythink.expressad.foundation.f.b.a().a(this.k, new com.anythink.expressad.advanced.c.b.AnonymousClass4(aTNativeAdvancedView));
        if (cVar.H() && com.anythink.expressad.foundation.f.b.a().b() && (b = com.anythink.expressad.foundation.f.b.a().b(this.k)) != null) {
            try {
                layoutParams = (android.widget.RelativeLayout.LayoutParams) b.getLayoutParams();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
            }
            layoutParams.addRule(12);
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) b.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(b);
            }
            aTNativeAdvancedView.addView(b, layoutParams);
        }
        this.h = this.h;
        this.c = cVar;
        this.d = aTNativeAdvancedView;
        com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl advancedNativeJSBridgeImpl = aTNativeAdvancedView.getAdvancedNativeJSBridgeImpl();
        if (advancedNativeJSBridgeImpl == null) {
            advancedNativeJSBridgeImpl = new com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl(aTNativeAdvancedView.getContext(), this.l, this.k);
            java.util.List<com.anythink.expressad.foundation.d.c> arrayList = new java.util.ArrayList<>();
            arrayList.add(cVar);
            advancedNativeJSBridgeImpl.setCampaignList(arrayList);
        }
        advancedNativeJSBridgeImpl.setAllowSkip(this.h ? 1 : 0);
        advancedNativeJSBridgeImpl.setNativeAdvancedBridgeListener(this.o);
        aTNativeAdvancedView.setAdvancedNativeJSBridgeImpl(advancedNativeJSBridgeImpl);
        if (cVar.s() || !this.h) {
            this.j.setVisibility(8);
        }
        android.widget.ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setOnClickListener(this.n);
        }
        aTNativeAdvancedView.setCloseView(this.j);
        boolean z2 = false;
        if (aTNativeAdvancedView.getVisibility() != 0) {
            aTNativeAdvancedView.setVisibility(0);
        }
        boolean a = com.anythink.expressad.foundation.h.y.a(aTNativeAdvancedView.getAdvancedNativeWebview());
        com.anythink.expressad.advanced.d.c cVar2 = this.g;
        if (cVar2 == null || a || cVar2.c() == null || this.g.c().getAlpha() < 0.5f || this.g.c().getVisibility() != 0 || this.m) {
            if (z) {
                aTNativeAdvancedView.postDelayed(new com.anythink.expressad.advanced.c.b.AnonymousClass5(cVar, aTNativeAdvancedView), 200L);
                return;
            }
            return;
        }
        aTNativeAdvancedView.show();
        com.anythink.expressad.foundation.b.a.b().b(aTNativeAdvancedView.getContext());
        cVar.l(this.k);
        com.anythink.expressad.foundation.f.b.a().a(this.k, cVar);
        com.anythink.expressad.foundation.d.c cVar3 = this.c;
        if (cVar3 != null && cVar3.ay()) {
            aTNativeAdvancedView.getAdvancedNativeWebview();
            try {
                com.anythink.expressad.advanced.a.a.c(cVar.Z());
            } catch (java.lang.Throwable th) {
                th.getMessage();
                com.anythink.expressad.foundation.d.c cVar4 = this.c;
                if (cVar4 != null) {
                    cVar4.Z();
                    this.c.aa();
                    this.c.aZ();
                }
            }
        }
        if (!this.c.V()) {
            this.c.c(true);
            com.anythink.expressad.foundation.d.c cVar5 = this.c;
            if (!cVar5.s()) {
                android.content.Context f = com.anythink.core.common.b.o.a().f();
                java.lang.String str = this.k;
                com.anythink.expressad.foundation.b.a.b().b(f);
                if (!android.text.TextUtils.isEmpty(cVar5.ag())) {
                    com.anythink.expressad.a.a.a(f, cVar5, str, cVar5.ag(), false, true, com.anythink.expressad.a.a.a.i);
                }
                if (!android.text.TextUtils.isEmpty(str) && cVar5.L() != null && cVar5.L().o() != null) {
                    com.anythink.expressad.a.a.a(f, cVar5, str, cVar5.L().o(), false);
                }
                cVar5.c(true);
                com.anythink.expressad.foundation.g.a.f.a(this.k, cVar5, com.anythink.expressad.foundation.g.a.f.g);
                z2 = true;
            }
            if (z2) {
                b(cVar5, com.anythink.core.common.b.o.a().f(), this.k);
                a(cVar5, com.anythink.core.common.b.o.a().f(), this.k);
            }
            com.anythink.expressad.advanced.d.d dVar = this.e;
            if (dVar != null) {
                dVar.a();
            }
        }
        int i = this.i;
        if (i != -1) {
            aTNativeAdvancedView.changeCloseBtnState(i);
        }
        com.anythink.expressad.advanced.a.a.c(cVar.Z());
        this.a.sendEmptyMessageDelayed(2, 1000L);
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final com.anythink.expressad.advanced.d.a b() {
        return this.o;
    }

    public final void c() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.o != null) {
            this.o = null;
        }
        if (this.n != null) {
            this.n = null;
        }
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.d;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.destroy();
        }
        if (this.g != null) {
            this.g = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.k);
    }

    public final void d() {
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview advancedNativeWebview;
        if (this.d == null || com.anythink.expressad.foundation.f.b.c || (advancedNativeWebview = this.d.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestroyed()) {
            return;
        }
        com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.sendEventToH5(advancedNativeWebview, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.b, "");
    }

    public final void e() {
        com.anythink.expressad.advanced.view.ATNativeAdvancedWebview advancedNativeWebview;
        com.anythink.expressad.advanced.view.ATNativeAdvancedView aTNativeAdvancedView = this.d;
        if (aTNativeAdvancedView == null || (advancedNativeWebview = aTNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestroyed()) {
            return;
        }
        com.anythink.expressad.atsignalcommon.windvane.j.a();
        com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) advancedNativeWebview, com.anythink.expressad.advanced.js.NativeAdvancedJsUtils.a, "");
    }
}
