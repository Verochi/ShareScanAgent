package com.anythink.basead.ui;

/* loaded from: classes12.dex */
public class BaseATActivity extends android.app.Activity {
    public static final java.lang.String a = "BaseATActivity";
    private com.anythink.core.api.BaseAd A;
    boolean b;
    com.anythink.core.common.f.af c;
    long d = 0;
    long e = 0;
    float f = 0.0f;
    boolean g = false;
    boolean h = false;
    com.anythink.core.common.b.a i = new com.anythink.basead.ui.BaseATActivity.AnonymousClass1();
    com.anythink.basead.e.h j;
    long k;
    long l;
    long m;
    private com.anythink.basead.ui.BaseScreenATView n;
    private com.anythink.core.common.f.m o;
    private com.anythink.core.common.f.l p;
    private java.lang.String q;
    private com.anythink.basead.e.b.InterfaceC0141b r;

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f148s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* renamed from: com.anythink.basead.ui.BaseATActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.b.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.core.common.b.a
        public final void a(java.lang.Object obj) {
            if (!(obj instanceof com.anythink.core.common.f.af) || com.anythink.basead.ui.BaseATActivity.this.p == null) {
                return;
            }
            com.anythink.core.common.f.af afVar = (com.anythink.core.common.f.af) obj;
            if (afVar.a().E().equals(com.anythink.basead.ui.BaseATActivity.this.p.E())) {
                com.anythink.basead.ui.BaseATActivity baseATActivity = com.anythink.basead.ui.BaseATActivity.this;
                if (baseATActivity.b) {
                    afVar.a(baseATActivity);
                } else {
                    baseATActivity.c = afVar;
                }
            }
        }
    }

    /* renamed from: com.anythink.basead.ui.BaseATActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.basead.e.h {
        java.lang.String a = "1";

        public AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a() {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.a();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.c.e eVar) {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.a(eVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(com.anythink.basead.e.i iVar) {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.a(iVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void a(boolean z) {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.a(z);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b() {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.b();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void b(com.anythink.basead.e.i iVar) {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.b(iVar);
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void c() {
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.c();
            }
        }

        @Override // com.anythink.basead.e.b.InterfaceC0141b
        public final void d() {
            com.anythink.basead.ui.BaseATActivity.this.finish();
            if (com.anythink.basead.ui.BaseATActivity.this.z) {
                com.anythink.basead.ui.BaseATActivity.this.overridePendingTransition(0, 0);
            }
            if (com.anythink.basead.ui.BaseATActivity.this.r != null) {
                com.anythink.basead.ui.BaseATActivity.this.r.d();
            }
        }

        @Override // com.anythink.basead.e.h
        public final void e() {
            this.a = "1";
            com.anythink.basead.ui.BaseATActivity.this.a("4", 0L);
        }

        @Override // com.anythink.basead.e.h
        public final void f() {
            if (android.text.TextUtils.equals(this.a, "1")) {
                this.a = "2";
            }
            com.anythink.basead.ui.BaseATActivity baseATActivity = com.anythink.basead.ui.BaseATActivity.this;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("5-");
            com.anythink.basead.ui.BaseATActivity baseATActivity2 = com.anythink.basead.ui.BaseATActivity.this;
            sb.append(baseATActivity2.l - baseATActivity2.m <= 0 ? "2" : "1");
            baseATActivity.a(sb.toString(), 0L);
        }

        @Override // com.anythink.basead.e.h
        public final void g() {
            if (android.text.TextUtils.equals(this.a, "1")) {
                this.a = "3";
                com.anythink.basead.ui.BaseATActivity baseATActivity = com.anythink.basead.ui.BaseATActivity.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("6-");
                com.anythink.basead.ui.BaseATActivity baseATActivity2 = com.anythink.basead.ui.BaseATActivity.this;
                sb.append(baseATActivity2.l - baseATActivity2.m <= 0 ? "2" : "1");
                baseATActivity.a(sb.toString(), 0L);
            }
        }

        @Override // com.anythink.basead.e.h
        public final java.lang.String h() {
            return this.a;
        }
    }

    private void a() {
        android.content.Intent intent = getIntent();
        try {
            if (intent == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(a);
                sb.append(" Intent is null.");
            } else {
                this.f148s = intent.getStringExtra("extra_scenario");
                this.t = intent.getIntExtra(com.anythink.core.basead.a.C0161a.b, 1);
                this.p = (com.anythink.core.common.f.l) intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.c);
                this.o = (com.anythink.core.common.f.m) intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.e);
                this.q = intent.getStringExtra(com.anythink.core.basead.a.C0161a.d);
                this.z = a(this.t, this.o);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.content.Context] */
    public static void a(android.app.Activity activity, com.anythink.core.basead.b.c cVar) {
        android.content.Intent intent = new android.content.Intent();
        ?? f = com.anythink.core.common.b.o.a().f();
        if (activity == null || activity.isFinishing()) {
            activity = f;
        }
        boolean a2 = a(cVar.a, cVar.h);
        if (cVar.e == 2) {
            if (a2) {
                intent.setClass(activity, com.anythink.basead.ui.ATLandscapeTranslucentActivity.class);
            } else {
                intent.setClass(activity, com.anythink.basead.ui.ATLandscapeActivity.class);
            }
        } else if (a2) {
            intent.setClass(activity, com.anythink.basead.ui.ATPortraitTranslucentActivity.class);
        } else {
            intent.setClass(activity, com.anythink.basead.ui.ATPortraitActivity.class);
        }
        intent.putExtra("extra_scenario", cVar.b);
        intent.putExtra(com.anythink.core.basead.a.C0161a.b, cVar.a);
        intent.putExtra(com.anythink.core.basead.a.C0161a.c, cVar.c);
        intent.putExtra(com.anythink.core.basead.a.C0161a.d, cVar.d);
        intent.putExtra(com.anythink.core.basead.a.C0161a.e, cVar.h);
        if (!(activity instanceof android.app.Activity)) {
            intent.addFlags(268435456);
        }
        try {
            activity.startActivity(intent);
        } catch (java.lang.Throwable th) {
            com.anythink.basead.e.b.InterfaceC0141b a3 = com.anythink.basead.e.b.a().a(cVar.d);
            if (a3 != null) {
                a3.a(com.anythink.basead.c.f.a("10000", th.getMessage()));
            }
        }
    }

    private void a(android.os.Bundle bundle) {
        if (bundle != null) {
            this.v = bundle.getBoolean(com.anythink.core.basead.a.C0161a.f);
            this.w = bundle.getBoolean(com.anythink.core.basead.a.C0161a.g);
            this.x = bundle.getBoolean(com.anythink.core.basead.a.C0161a.h);
            this.y = bundle.getBoolean(com.anythink.core.basead.a.C0161a.k);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0161a.m);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0161a.n);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0161a.o);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0161a.i, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0161a.p, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, long j) {
        java.lang.String str2;
        java.lang.String str3;
        com.anythink.core.common.f.l lVar = this.p;
        if (lVar == null || lVar.d() == 10) {
            return;
        }
        try {
            com.anythink.core.common.f.m mVar = this.o;
            java.lang.String str4 = mVar != null ? mVar.d : "";
            java.lang.String str5 = mVar != null ? mVar.b : "";
            java.lang.String str6 = mVar != null ? mVar.c : "";
            if (mVar != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.o.j);
                str2 = sb.toString();
            } else {
                str2 = "";
            }
            if (this.o != null) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(this.o.f);
                str3 = sb2.toString();
            } else {
                str3 = "";
            }
            com.anythink.core.common.f.l lVar2 = this.p;
            int d = lVar2 != null ? lVar2.d() : -1;
            com.anythink.core.common.f.l lVar3 = this.p;
            java.lang.String s2 = lVar3 != null ? lVar3.s() : "";
            com.anythink.core.common.f.l lVar4 = this.p;
            com.anythink.core.common.n.c.a(str, str4, str5, str6, str2, str3, d, 0, s2, lVar4 instanceof com.anythink.core.common.f.j ? ((com.anythink.core.common.f.j) lVar4).Z() : "", com.anythink.basead.d.c.b.a(this.o, this.p), j);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static boolean a(int i, com.anythink.core.common.f.m mVar) {
        com.anythink.core.common.f.n nVar;
        if (mVar == null || (nVar = mVar.n) == null || i != 3) {
            return false;
        }
        return android.text.TextUtils.equals("2", nVar.K());
    }

    private com.anythink.basead.ui.BaseScreenATView b() {
        return this.t != 3 ? new com.anythink.basead.ui.FullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : this.A != null ? new com.anythink.basead.ui.ThirdPartyFullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u, this.A) : this.z ? (this.o.n.an() == 1 && this.u == 1) ? new com.anythink.basead.ui.LetterHalfScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : new com.anythink.basead.ui.HalfScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : (this.o.n.an() == 1 && this.u == 1) ? new com.anythink.basead.ui.LetterFullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : new com.anythink.basead.ui.FullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u);
    }

    private void b(android.os.Bundle bundle) {
        com.anythink.basead.ui.BaseATActivity.AnonymousClass2 anonymousClass2 = new com.anythink.basead.ui.BaseATActivity.AnonymousClass2();
        this.j = anonymousClass2;
        this.n.setListener(anonymousClass2);
        if (bundle != null) {
            this.v = bundle.getBoolean(com.anythink.core.basead.a.C0161a.f);
            this.w = bundle.getBoolean(com.anythink.core.basead.a.C0161a.g);
            this.x = bundle.getBoolean(com.anythink.core.basead.a.C0161a.h);
            this.y = bundle.getBoolean(com.anythink.core.basead.a.C0161a.k);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0161a.m);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0161a.n);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0161a.o);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0161a.i, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0161a.p, false);
        }
        this.n.setIsShowEndCard(this.v);
        this.n.setHideFeedbackButton(this.w);
        this.n.setHasReward(this.y);
        if (bundle != null) {
            this.n.setVideoMute(this.x);
            this.n.setShowBannerTime(this.d);
            this.n.setHideBannerTime(this.e);
            this.n.setCloseButtonScaleFactor(this.f);
            this.n.setHasPerformClick(this.g);
            this.n.setShowingEndCardAfterVideoPlay(this.h);
        }
        try {
            this.n.init();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            try {
                com.anythink.basead.e.b.InterfaceC0141b interfaceC0141b = this.r;
                if (interfaceC0141b != null) {
                    interfaceC0141b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, com.anythink.core.common.o.i.a(th.getStackTrace())));
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            finish();
        }
    }

    private void c() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mCalled");
            declaredField.setAccessible(true);
            declaredField.setBoolean(this, true);
        } catch (java.lang.Throwable unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.anythink.basead.ui.BaseScreenATView baseScreenATView = this.n;
        if (baseScreenATView != null) {
            baseScreenATView.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (com.anythink.core.common.b.o.a().f() == null) {
            com.anythink.core.common.b.o.a().a(getApplicationContext());
        }
        if (this instanceof com.anythink.basead.ui.ATLandscapeActivity) {
            this.u = 2;
        } else {
            this.u = 1;
        }
        android.content.Intent intent = getIntent();
        try {
            if (intent != null) {
                this.f148s = intent.getStringExtra("extra_scenario");
                this.t = intent.getIntExtra(com.anythink.core.basead.a.C0161a.b, 1);
                this.p = (com.anythink.core.common.f.l) intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.c);
                this.o = (com.anythink.core.common.f.m) intent.getSerializableExtra(com.anythink.core.basead.a.C0161a.e);
                this.q = intent.getStringExtra(com.anythink.core.basead.a.C0161a.d);
                this.z = a(this.t, this.o);
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(a);
                sb.append(" Intent is null.");
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        this.r = com.anythink.basead.e.b.a().a(this.q);
        this.A = com.anythink.basead.d.i.a().a(this.q);
        a("1", 0L);
        com.anythink.core.common.f.m mVar = this.o;
        if (mVar == null || mVar.n == null) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            java.lang.String str = a;
            sb2.append(str);
            sb2.append("Start Screen Ad Error.");
            try {
                com.anythink.basead.e.b.InterfaceC0141b interfaceC0141b = this.r;
                if (interfaceC0141b != null) {
                    interfaceC0141b.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str + "Start FullScreen Ad Error."));
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            finish();
            return;
        }
        if (this.p == null) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            java.lang.String str2 = a;
            sb3.append(str2);
            sb3.append(" onCreate: OfferAd = null");
            try {
                com.anythink.basead.e.b.InterfaceC0141b interfaceC0141b2 = this.r;
                if (interfaceC0141b2 != null) {
                    interfaceC0141b2.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str2 + " onCreate: OfferAd = null"));
                }
            } catch (java.lang.Throwable th2) {
                th2.printStackTrace();
            }
            finish();
            return;
        }
        com.anythink.core.common.b.a().a("1", this.i);
        this.n = this.t != 3 ? new com.anythink.basead.ui.FullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : this.A != null ? new com.anythink.basead.ui.ThirdPartyFullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u, this.A) : this.z ? (this.o.n.an() == 1 && this.u == 1) ? new com.anythink.basead.ui.LetterHalfScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : new com.anythink.basead.ui.HalfScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : (this.o.n.an() == 1 && this.u == 1) ? new com.anythink.basead.ui.LetterFullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u) : new com.anythink.basead.ui.FullScreenATView(this, this.o, this.p, this.f148s, this.t, this.u);
        com.anythink.core.api.BaseAd baseAd = this.A;
        android.view.ViewGroup customAdContainer = baseAd != null ? baseAd.getCustomAdContainer() : null;
        if (customAdContainer != null) {
            customAdContainer.addView(this.n);
            com.anythink.core.common.o.w.a(customAdContainer);
            setContentView(customAdContainer);
        } else {
            setContentView(this.n);
        }
        com.anythink.basead.ui.BaseATActivity.AnonymousClass2 anonymousClass2 = new com.anythink.basead.ui.BaseATActivity.AnonymousClass2();
        this.j = anonymousClass2;
        this.n.setListener(anonymousClass2);
        if (bundle != null) {
            this.v = bundle.getBoolean(com.anythink.core.basead.a.C0161a.f);
            this.w = bundle.getBoolean(com.anythink.core.basead.a.C0161a.g);
            this.x = bundle.getBoolean(com.anythink.core.basead.a.C0161a.h);
            this.y = bundle.getBoolean(com.anythink.core.basead.a.C0161a.k);
            this.d = bundle.getLong(com.anythink.core.basead.a.C0161a.m);
            this.e = bundle.getLong(com.anythink.core.basead.a.C0161a.n);
            this.f = bundle.getFloat(com.anythink.core.basead.a.C0161a.o);
            this.g = bundle.getBoolean(com.anythink.core.basead.a.C0161a.i, false);
            this.h = bundle.getBoolean(com.anythink.core.basead.a.C0161a.p, false);
        }
        this.n.setIsShowEndCard(this.v);
        this.n.setHideFeedbackButton(this.w);
        this.n.setHasReward(this.y);
        if (bundle != null) {
            this.n.setVideoMute(this.x);
            this.n.setShowBannerTime(this.d);
            this.n.setHideBannerTime(this.e);
            this.n.setCloseButtonScaleFactor(this.f);
            this.n.setHasPerformClick(this.g);
            this.n.setShowingEndCardAfterVideoPlay(this.h);
        }
        try {
            this.n.init();
        } catch (java.lang.Throwable th3) {
            th3.printStackTrace();
            try {
                com.anythink.basead.e.b.InterfaceC0141b interfaceC0141b3 = this.r;
                if (interfaceC0141b3 != null) {
                    interfaceC0141b3.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, com.anythink.core.common.o.i.a(th3.getStackTrace())));
                }
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        this.c = null;
        this.j = null;
        com.anythink.core.common.b.a().b("1", this.i);
        com.anythink.basead.ui.BaseScreenATView baseScreenATView = this.n;
        if (baseScreenATView != null) {
            baseScreenATView.u();
        }
        com.anythink.core.common.f.l lVar = this.p;
        if (lVar != null && lVar.H() && !this.p.O()) {
            com.anythink.core.common.a.k.a().b();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (4 == i) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        long j = this.m + 1;
        this.m = j;
        if (j <= 5) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("3-");
            com.anythink.basead.e.h hVar = this.j;
            sb.append(hVar != null ? hVar.h() : "0");
            a(sb.toString(), android.os.SystemClock.elapsedRealtime() - this.k);
        }
        this.b = false;
        com.anythink.basead.ui.BaseScreenATView baseScreenATView = this.n;
        if (baseScreenATView != null) {
            baseScreenATView.t();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        if (android.os.Build.VERSION.SDK_INT < 29) {
            try {
                try {
                    super.onResume();
                } catch (java.lang.Throwable unused) {
                    finish();
                }
            } catch (java.lang.Throwable unused2) {
                java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.setBoolean(this, true);
            }
        } else {
            super.onResume();
        }
        this.k = android.os.SystemClock.elapsedRealtime();
        long j = this.l + 1;
        this.l = j;
        if (j <= 5) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("2-");
            com.anythink.basead.e.h hVar = this.j;
            sb.append(hVar != null ? hVar.h() : "0");
            a(sb.toString(), 0L);
        }
        this.b = true;
        com.anythink.basead.ui.BaseScreenATView baseScreenATView = this.n;
        if (baseScreenATView != null) {
            baseScreenATView.s();
        }
        com.anythink.core.common.f.af afVar = this.c;
        if (afVar != null) {
            afVar.a(this);
            this.c = null;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        super.onSaveInstanceState(bundle);
        com.anythink.basead.ui.BaseScreenATView baseScreenATView = this.n;
        if (baseScreenATView != null) {
            if (baseScreenATView.isShowEndCard()) {
                bundle.putBoolean(com.anythink.core.basead.a.C0161a.f, true);
            }
            bundle.putBoolean(com.anythink.core.basead.a.C0161a.g, this.n.needHideFeedbackButton());
            bundle.putBoolean(com.anythink.core.basead.a.C0161a.h, this.n.isVideoMute());
            bundle.putBoolean(com.anythink.core.basead.a.C0161a.k, this.n.hasReward());
            bundle.putLong(com.anythink.core.basead.a.C0161a.m, this.n.getShowBannerTime());
            bundle.putLong(com.anythink.core.basead.a.C0161a.n, this.n.getHideBannerTime());
            bundle.putFloat(com.anythink.core.basead.a.C0161a.o, this.n.getCloseButtonScaleFactor());
            bundle.putBoolean(com.anythink.core.basead.a.C0161a.i, this.n.getHasPerformClick());
            bundle.putBoolean(com.anythink.core.basead.a.C0161a.p, this.n.isShowingEndCardAfterVideoPlay());
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (android.os.Build.VERSION.SDK_INT == 26) {
            super.setTheme(com.anythink.core.common.o.i.a(this, "myoffer_half_screen_fit_by_o", com.anythink.expressad.foundation.h.i.e));
        } else {
            super.setTheme(i);
        }
    }
}
