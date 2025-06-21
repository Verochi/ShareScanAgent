package com.anythink.expressad.reward.player;

/* loaded from: classes29.dex */
public class ATRewardVideoActivity extends com.anythink.expressad.video.signal.activity.AbstractJSActivity {
    public static java.lang.String a = "unitId";
    public static java.lang.String b = "userId";
    public static java.lang.String c = "reward";
    public static java.lang.String d = "mute";
    public static java.lang.String e = "isIV";
    public static java.lang.String f = "isBid";
    public static java.lang.String g = "isBigOffer";
    public static java.lang.String h = "hasRelease";
    public static java.lang.String i = "ivRewardMode";
    public static java.lang.String j = "ivRewardValueType";
    public static java.lang.String k = "ivRewardValue";
    public static java.lang.String l = "extraData";
    public static java.lang.String m = "baserequestInfo";
    private static final java.lang.String v = "ATRewardVideoActivity";
    private int D;
    private int E;
    private int F;
    private com.anythink.expressad.video.bt.module.b.h I;
    private com.anythink.expressad.videocommon.e.d J;
    private com.anythink.expressad.videocommon.b.c M;
    private com.anythink.expressad.foundation.d.c N;
    private java.util.List<com.anythink.expressad.videocommon.b.c> O;
    private java.util.List<com.anythink.expressad.foundation.d.c> P;
    private com.anythink.expressad.video.bt.module.ATTempContainer Q;
    private com.anythink.expressad.video.bt.module.AnythinkBTContainer R;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView S;
    private com.anythink.expressad.video.bt.module.a.a T;
    private java.lang.String U;
    private java.lang.String V;
    private boolean W;
    com.anythink.core.common.f.m n;
    com.anythink.expressad.foundation.d.c o;
    long p;
    long q;
    long r;
    private java.lang.String w;
    private java.lang.String x;
    private java.lang.String y;
    private com.anythink.expressad.videocommon.c.c z;
    private int A = 2;
    private boolean B = false;
    private boolean C = false;
    private boolean G = false;
    private boolean H = false;
    private boolean K = false;
    private boolean L = false;
    private int X = 1;
    private int Y = 0;
    private int Z = 0;
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private com.anythink.expressad.video.dynview.f.a ae = new com.anythink.expressad.reward.player.ATRewardVideoActivity.AnonymousClass1();
    private com.anythink.expressad.video.dynview.f.d af = new com.anythink.expressad.reward.player.ATRewardVideoActivity.AnonymousClass2();

    /* renamed from: s, reason: collision with root package name */
    com.anythink.expressad.reward.player.b f257s = new com.anythink.expressad.reward.player.ATRewardVideoActivity.AnonymousClass3();

    /* renamed from: com.anythink.expressad.reward.player.ATRewardVideoActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.video.dynview.f.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.video.dynview.f.a
        public final void a(java.util.Map<java.lang.String, java.lang.Object> map) {
            if (map.containsKey("mute")) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.A = ((java.lang.Integer) map.get("mute")).intValue();
            }
            if (map.containsKey(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION)) {
                int intValue = ((java.lang.Integer) map.get(com.alibaba.sdk.android.oss.common.RequestParameters.POSITION)).intValue();
                if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.P == null || com.anythink.expressad.reward.player.ATRewardVideoActivity.this.P.size() <= 0 || intValue <= 0) {
                    return;
                }
                com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
                aTRewardVideoActivity.N = (com.anythink.expressad.foundation.d.c) aTRewardVideoActivity.P.get(intValue);
                com.anythink.expressad.reward.player.ATRewardVideoActivity.b(com.anythink.expressad.reward.player.ATRewardVideoActivity.this);
                int i = intValue - 1;
                if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.P.get(i) != null) {
                    com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity2 = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
                    com.anythink.expressad.reward.player.ATRewardVideoActivity.b(aTRewardVideoActivity2, ((com.anythink.expressad.foundation.d.c) aTRewardVideoActivity2.P.get(i)).bi());
                }
                com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity3 = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.N.b(aTRewardVideoActivity3.a(aTRewardVideoActivity3.N.i(), com.anythink.expressad.reward.player.ATRewardVideoActivity.this.X));
                com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity4 = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
                aTRewardVideoActivity4.b(aTRewardVideoActivity4.N);
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.player.ATRewardVideoActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.video.dynview.f.d {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.video.dynview.f.d
        public final void a() {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.R != null) {
                new com.anythink.expressad.video.dynview.h.b().d(com.anythink.expressad.reward.player.ATRewardVideoActivity.this.R);
            }
            com.anythink.expressad.reward.player.ATRewardVideoActivity.f(com.anythink.expressad.reward.player.ATRewardVideoActivity.this);
            com.anythink.expressad.reward.player.ATRewardVideoActivity.this.b();
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.Q != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.Q.setNotchPadding(com.anythink.expressad.reward.player.ATRewardVideoActivity.this.ad, com.anythink.expressad.reward.player.ATRewardVideoActivity.this.Z, com.anythink.expressad.reward.player.ATRewardVideoActivity.this.ab, com.anythink.expressad.reward.player.ATRewardVideoActivity.this.aa, com.anythink.expressad.reward.player.ATRewardVideoActivity.this.ac);
            }
        }

        @Override // com.anythink.expressad.video.dynview.f.d
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (cVar == null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.b("campaign is null");
                return;
            }
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.R != null) {
                new com.anythink.expressad.video.dynview.h.b().d(com.anythink.expressad.reward.player.ATRewardVideoActivity.this.R);
            }
            com.anythink.expressad.reward.player.ATRewardVideoActivity.this.N = cVar;
            com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
            aTRewardVideoActivity.b(aTRewardVideoActivity.N);
        }
    }

    /* renamed from: com.anythink.expressad.reward.player.ATRewardVideoActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.reward.player.b {
        public java.lang.String a = "1";

        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.reward.player.b
        public final java.lang.String a() {
            return this.a;
        }

        @Override // com.anythink.expressad.reward.player.c
        public final void b() {
        }

        @Override // com.anythink.expressad.reward.player.c
        public final void c() {
            this.a = "1";
            com.anythink.expressad.reward.player.ATRewardVideoActivity.this.a("4", 0L);
        }

        @Override // com.anythink.expressad.reward.player.c
        public final void d() {
            if (android.text.TextUtils.equals(this.a, "1")) {
                this.a = "2";
            }
            com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("5-");
            com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity2 = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
            sb.append(aTRewardVideoActivity2.q <= aTRewardVideoActivity2.r ? "2" : "1");
            aTRewardVideoActivity.a(sb.toString(), 0L);
        }

        @Override // com.anythink.expressad.reward.player.c
        public final void e() {
            if (android.text.TextUtils.equals(this.a, "1")) {
                this.a = "3";
                com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("6-");
                com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity2 = com.anythink.expressad.reward.player.ATRewardVideoActivity.this;
                sb.append(aTRewardVideoActivity2.q <= aTRewardVideoActivity2.r ? "2" : "1");
                aTRewardVideoActivity.a(sb.toString(), 0L);
            }
        }

        @Override // com.anythink.expressad.reward.player.c
        public final void f() {
        }
    }

    /* renamed from: com.anythink.expressad.reward.player.ATRewardVideoActivity$4, reason: invalid class name */
    public class AnonymousClass4 implements com.anythink.expressad.video.bt.module.a.a {
        public AnonymousClass4() {
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void a() {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.a();
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void a(com.anythink.expressad.foundation.d.c cVar) {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.a(cVar);
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void a(java.lang.String str) {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.a(str);
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void a(boolean z, int i) {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.a(z, i);
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void a(boolean z, com.anythink.expressad.videocommon.c.c cVar) {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.a(z, cVar);
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void b() {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.b();
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.a
        public final void c() {
            if (com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I != null) {
                com.anythink.expressad.reward.player.ATRewardVideoActivity.this.I.c();
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.player.ATRewardVideoActivity$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass5() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            com.anythink.expressad.reward.player.ATRewardVideoActivity.this.onPause();
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            com.anythink.expressad.reward.player.ATRewardVideoActivity.this.onResume();
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            com.anythink.expressad.reward.player.ATRewardVideoActivity.this.onResume();
        }
    }

    public static final class a implements java.lang.Runnable {
        private final java.util.List<com.anythink.expressad.videocommon.b.c> a;
        private final java.lang.String b;
        private final java.lang.String c;

        public a(java.util.List<com.anythink.expressad.videocommon.b.c> list, java.lang.String str, java.lang.String str2) {
            this.a = list;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.util.List<com.anythink.expressad.videocommon.b.c> list = this.a;
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (com.anythink.expressad.videocommon.b.c cVar : this.a) {
                    if (cVar != null && cVar.n() != null) {
                        com.anythink.expressad.foundation.d.c n = cVar.n();
                        java.lang.String str = n.Z() + n.aZ() + n.S();
                        com.anythink.expressad.videocommon.b.n c = com.anythink.expressad.videocommon.b.e.a().c(this.b);
                        if (c != null) {
                            try {
                                c.b(str);
                            } catch (java.lang.Exception unused) {
                            }
                        }
                        if (n.M() != null) {
                            if (!android.text.TextUtils.isEmpty(n.M().e())) {
                                com.anythink.expressad.videocommon.a.b(this.b + "_" + n.aZ() + "_" + this.c + "_" + n.M().e());
                                com.anythink.expressad.videocommon.a.b(n.w(), n);
                            }
                            if (!android.text.TextUtils.isEmpty(n.ar())) {
                                com.anythink.expressad.videocommon.a.b(this.b + "_" + this.c + "_" + n.ar());
                            }
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i2, int i3) {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.P;
        if (list == null || list.size() == 0) {
            return i2;
        }
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.P.size(); i6++) {
            if (this.P.get(0) != null) {
                if (i6 == 0) {
                    i5 = this.P.get(0).i();
                }
                i4 += this.P.get(i6).bi();
            }
        }
        if (i3 == 1) {
            if (i2 == 0) {
                if (i4 >= 45) {
                    return 45;
                }
            } else if (i4 > i2) {
                if (i2 > 45) {
                    return 45;
                }
                return i2;
            }
            return i4;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < i3 - 1; i8++) {
            if (this.P.get(i8) != null) {
                i7 += this.P.get(i8).bi();
            }
        }
        if (i5 > i7) {
            return i5 - i7;
        }
        return 0;
    }

    private static com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a(java.lang.String str) {
        com.anythink.expressad.videocommon.a.C0231a a2 = com.anythink.expressad.videocommon.a.a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    private void a(int i2) {
        try {
            com.anythink.expressad.foundation.d.c cVar = this.N;
            if (cVar == null || cVar.f() != 2) {
                return;
            }
            getWindow().getDecorView().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) this.Q.getLayoutParams();
            int b2 = com.anythink.expressad.foundation.h.t.b(this, 58.0f);
            int b3 = com.anythink.expressad.foundation.h.t.b(this, 104.0f);
            if (this.N.M().c() == 0) {
                if (i2 == 2) {
                    layoutParams.setMargins(b3, b2, b3, b2);
                } else {
                    layoutParams.setMargins(b2, b3, b2, b3);
                }
            } else if (this.N.M().c() == 2) {
                layoutParams.setMargins(b3, b2, b3, b2);
            } else {
                layoutParams.setMargins(b2, b3, b2, b3);
            }
            this.Q.setLayoutParams(layoutParams);
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar == null) {
            b("campaign is less");
            return;
        }
        int a2 = a(cVar.i(), this.X);
        this.N = cVar;
        cVar.m();
        this.X = 1;
        this.N.b(a2);
        b(this.N);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, long j2) {
        java.lang.String str2;
        java.lang.String str3;
        try {
            com.anythink.core.common.f.m mVar = this.n;
            java.lang.String str4 = mVar != null ? mVar.d : "";
            java.lang.String str5 = mVar != null ? mVar.b : "";
            java.lang.String str6 = mVar != null ? mVar.c : "";
            if (mVar != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.n.j);
                str2 = sb.toString();
            } else {
                str2 = "";
            }
            if (this.n != null) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(this.n.f);
                str3 = sb2.toString();
            } else {
                str3 = "";
            }
            com.anythink.expressad.foundation.d.c cVar = this.o;
            java.lang.String aZ = cVar != null ? cVar.aZ() : "";
            com.anythink.expressad.foundation.d.c cVar2 = this.o;
            com.anythink.core.common.n.c.a(str, str4, str5, str6, str2, str3, 2, 1, aZ, "20", !android.text.TextUtils.isEmpty(cVar2 != null ? cVar2.S() : ""), j2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private void a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (list == null) {
            b("no available campaign");
            return;
        }
        if (list.size() == 0) {
            b("no available campaign");
            return;
        }
        if ((list.get(0) != null ? list.get(0).k() : 0) != 5) {
            c();
            return;
        }
        for (com.anythink.expressad.foundation.d.c cVar : list) {
            if (cVar != null) {
                this.Y += cVar.bi();
            }
        }
        com.anythink.expressad.foundation.d.c cVar2 = list.get(0);
        if (cVar2 == null) {
            b("campaign is less");
            return;
        }
        int a2 = a(cVar2.i(), this.X);
        this.N = cVar2;
        cVar2.m();
        this.X = 1;
        this.N.b(a2);
        b(this.N);
    }

    public static /* synthetic */ int b(com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity) {
        int i2 = aTRewardVideoActivity.X;
        aTRewardVideoActivity.X = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int b(com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity, int i2) {
        int i3 = aTRewardVideoActivity.Y - i2;
        aTRewardVideoActivity.Y = i3;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        com.anythink.expressad.foundation.d.p pVar;
        java.util.List<com.anythink.expressad.foundation.d.c> list2;
        int c2 = c("anythink_temp_container");
        if (c2 < 0) {
            b("no id anythink_bt_container in anythink_more_offer_activity layout");
        }
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = (com.anythink.expressad.video.bt.module.ATTempContainer) findViewById(c2);
        this.Q = aTTempContainer;
        if (aTTempContainer == null) {
            b("env error");
        }
        java.util.List<com.anythink.expressad.foundation.d.c> list3 = this.P;
        if (list3 == null || list3.size() <= 0 || !this.P.get(0).j()) {
            this.Q.setVisibility(0);
        } else {
            new com.anythink.expressad.video.dynview.h.b();
            com.anythink.expressad.video.dynview.h.b.e(this.Q);
        }
        a(-1);
        this.Q.setVisibility(0);
        this.Q.setActivity(this);
        this.Q.setBidCampaign(this.C);
        this.Q.setBigOffer(this.G);
        this.Q.setUnitId(this.w);
        this.Q.setCampaign(this.N);
        if (this.N.k() == 5 && (list2 = this.P) != null && list2.size() > 1) {
            android.view.View findViewById = findViewById(c("anythink_reward_root_container"));
            if (findViewById != null) {
                findViewById.setBackgroundColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            }
            this.Q.removeAllViews();
            this.Q.setCampOrderViewData(this.P, this.Y);
            this.Q.setCamPlayOrderCallback(this.ae, this.X);
        }
        this.Q.setCampaignDownLoadTask(this.M);
        this.Q.setIV(this.B);
        com.anythink.expressad.foundation.d.c cVar = this.N;
        if (cVar == null || cVar.f() != 2) {
            this.Q.setIVRewardEnable(this.D, this.E, this.F);
        } else {
            this.Q.setIVRewardEnable(0, 0, 0);
        }
        this.Q.setMute(this.A);
        this.Q.setDeveloperExtraData(this.V);
        com.anythink.expressad.foundation.d.c cVar2 = this.N;
        if (((cVar2 != null && (pVar = cVar2.aH) != null) || ((list = this.P) != null && list.size() > 0 && this.P.get(0) != null && (pVar = this.P.get(0).aH) != null)) && !android.text.TextUtils.isEmpty(pVar.b()) && pVar.a() > 0) {
            com.anythink.expressad.videocommon.c.c cVar3 = new com.anythink.expressad.videocommon.c.c(pVar.b(), pVar.a());
            if (cVar3.b() < 0) {
                cVar3.a(1);
            }
            this.z = cVar3;
        }
        this.Q.setReward(this.z);
        this.Q.setRewardUnitSetting(this.J);
        this.Q.setPlacementId(this.x);
        this.Q.setUserId(this.y);
        this.Q.setShowRewardListener(this.I);
        this.Q.setTempEventListener(this.f257s);
        this.Q.init(this);
        this.Q.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.d.c n;
        try {
            java.util.List<com.anythink.expressad.videocommon.b.c> list = this.O;
            if (list != null && list.size() > 0) {
                for (com.anythink.expressad.videocommon.b.c cVar2 : this.O) {
                    if (cVar2 != null && (n = cVar2.n()) != null && android.text.TextUtils.equals(n.aZ(), cVar.aZ()) && android.text.TextUtils.equals(n.Z(), cVar.Z())) {
                        this.M = cVar2;
                    }
                }
            }
            this.G = true;
            b();
            com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
            if (aTTempContainer != null) {
                aTTempContainer.setNotchPadding(this.ad, this.Z, this.ab, this.aa, this.ac);
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            b("more offer to one offer exception");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(java.lang.String str) {
        com.anythink.expressad.video.bt.module.b.h hVar = this.I;
        if (hVar != null) {
            hVar.a(str);
        }
        finish();
    }

    private int c(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(getApplicationContext(), str, "id");
    }

    private void c() {
        com.anythink.expressad.foundation.d.p pVar;
        int c2 = c("anythink_bt_container");
        if (c2 < 0) {
            b("no anythink_webview_framelayout in anythink_more_offer_activity layout");
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = (com.anythink.expressad.video.bt.module.AnythinkBTContainer) findViewById(c2);
        this.R = anythinkBTContainer;
        if (anythinkBTContainer == null) {
            b("env error");
        }
        this.R.setVisibility(0);
        com.anythink.expressad.video.bt.module.a.a d2 = d();
        this.T = d2;
        this.R.setBTContainerCallback(d2);
        this.R.setShowRewardVideoListener(this.I);
        this.R.setChoiceOneCallback(this.af);
        this.R.setCampaigns(this.P);
        this.R.setCampaignDownLoadTasks(this.O);
        this.R.setRewardUnitSetting(this.J);
        this.R.setUnitId(this.w);
        this.R.setPlacementId(this.x);
        this.R.setUserId(this.y);
        this.R.setActivity(this);
        this.R.setDeveloperExtraData(this.V);
        com.anythink.expressad.foundation.d.c cVar = this.N;
        if (((cVar != null && (pVar = cVar.aH) != null) || (this.P.get(0) != null && (pVar = this.P.get(0).aH) != null)) && !android.text.TextUtils.isEmpty(pVar.b()) && pVar.a() > 0) {
            com.anythink.expressad.videocommon.c.c cVar2 = new com.anythink.expressad.videocommon.c.c(pVar.b(), pVar.a());
            if (cVar2.b() < 0) {
                cVar2.a(1);
            }
            this.z = cVar2;
        }
        this.R.setReward(this.z);
        this.R.setIVRewardEnable(this.D, this.E, this.F);
        this.R.setIV(this.B);
        this.R.setMute(this.A);
        this.R.setJSFactory((com.anythink.expressad.video.signal.factory.b) this.u);
        this.R.init(this);
        this.R.onCreate();
    }

    private static void c(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            if (!android.text.TextUtils.isEmpty(cVar.be())) {
                com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).c(cVar.be());
            }
            if (android.text.TextUtils.isEmpty(cVar.bd())) {
                return;
            }
            com.anythink.expressad.foundation.g.d.b.a(com.anythink.core.common.b.o.a().f()).c(cVar.bd());
        }
    }

    private int d(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(getApplicationContext(), str, "layout");
    }

    private com.anythink.expressad.video.bt.module.a.a d() {
        if (this.T == null) {
            this.T = new com.anythink.expressad.reward.player.ATRewardVideoActivity.AnonymousClass4();
        }
        return this.T;
    }

    private void e() {
        try {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.P;
            if (list != null && list.size() > 0) {
                java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.P.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
            com.anythink.expressad.foundation.d.c cVar = this.N;
            if (cVar != null) {
                c(cVar);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ boolean f(com.anythink.expressad.reward.player.ATRewardVideoActivity aTRewardVideoActivity) {
        aTRewardVideoActivity.G = true;
        return true;
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity
    public final void a(int i2, int i3, int i4, int i5, int i6) {
        this.Z = i3;
        this.ab = i4;
        this.aa = i5;
        this.ac = i6;
        this.ad = i2;
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.setNotchPadding(i2, i3, i4, i5, i6);
        }
        com.anythink.expressad.video.dynview.a.b.e = i2;
        com.anythink.expressad.video.dynview.a.b.a = i3;
        com.anythink.expressad.video.dynview.a.b.b = i4;
        com.anythink.expressad.video.dynview.a.b.c = i5;
        com.anythink.expressad.video.dynview.a.b.d = i6;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        int a2 = com.anythink.expressad.foundation.h.i.a(this, "anythink_reward_activity_close", com.anythink.expressad.foundation.h.i.f);
        int a3 = com.anythink.expressad.foundation.h.i.a(this, "anythink_reward_activity_stay", com.anythink.expressad.foundation.h.i.f);
        if (a2 > 1 && a3 > 1) {
            overridePendingTransition(a3, a2);
        }
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onDestroy();
            this.Q = null;
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onDestroy();
            this.R = null;
        }
        com.anythink.expressad.foundation.f.b.a().c(this.w + "_1");
        com.anythink.expressad.foundation.f.b.a().c(this.w + "_2");
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onBackPressed();
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onBackPressed();
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.Q != null) {
            a(configuration.orientation);
            this.Q.onConfigurationChanged(configuration);
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onConfigurationChanged(configuration);
        }
    }

    @Override // com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        java.util.List<com.anythink.expressad.foundation.d.c> a2;
        java.util.List<com.anythink.expressad.videocommon.b.c> list;
        java.lang.String str = "";
        super.onCreate(bundle);
        com.anythink.expressad.a.x = true;
        com.anythink.expressad.foundation.b.a.b().b(this);
        try {
            android.content.Intent intent = getIntent();
            java.lang.String stringExtra = intent.getStringExtra(a);
            this.w = stringExtra;
            if (stringExtra != null) {
                try {
                    a2 = com.anythink.expressad.videocommon.b.e.a().a(this.w);
                } catch (java.lang.Throwable unused) {
                }
            } else {
                a2 = null;
            }
            this.o = a2 != null ? a2.get(0) : null;
            java.io.Serializable serializableExtra = intent.getSerializableExtra(m);
            this.n = serializableExtra instanceof com.anythink.core.common.f.m ? (com.anythink.core.common.f.m) serializableExtra : null;
            a("1", 0L);
            int a3 = com.anythink.expressad.foundation.h.i.a(getApplicationContext(), "anythink_more_offer_activity", "layout");
            if (a3 < 0) {
                b("no anythink_more_offer_activity layout");
                return;
            }
            setContentView(a3);
            if (android.text.TextUtils.isEmpty(this.w)) {
                b("data empty error");
                return;
            }
            this.I = com.anythink.expressad.reward.b.a.c.get(this.w);
            this.x = intent.getStringExtra(com.anythink.expressad.a.y);
            this.z = com.anythink.expressad.videocommon.c.c.b(intent.getStringExtra(c));
            this.y = intent.getStringExtra(b);
            this.A = intent.getIntExtra(d, 2);
            this.B = intent.getBooleanExtra(e, false);
            this.C = intent.getBooleanExtra(f, false);
            this.V = intent.getStringExtra(l);
            if (this.B) {
                this.D = intent.getIntExtra(i, 0);
                this.E = intent.getIntExtra(j, 0);
                this.F = intent.getIntExtra(k, 0);
            }
            com.anythink.expressad.video.signal.factory.b bVar = new com.anythink.expressad.video.signal.factory.b(this);
            this.u = bVar;
            a(bVar);
            if (this.I == null) {
                b("showRewardListener is null");
                return;
            }
            com.anythink.expressad.videocommon.e.d a4 = com.anythink.expressad.reward.a.e.a().a(this.x, this.w);
            this.J = a4;
            if (a4 == null) {
                com.anythink.expressad.videocommon.e.d a5 = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.w);
                this.J = a5;
                if (a5 == null) {
                    this.J = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.w, this.B);
                }
            }
            com.anythink.expressad.videocommon.e.d dVar = this.J;
            if (dVar != null) {
                this.z.a(dVar.m());
                this.z.a(this.J.n());
            }
            com.anythink.expressad.videocommon.c.c cVar = this.z;
            if (cVar != null && cVar.b() <= 0) {
                this.z.a(1);
            }
            int a6 = com.anythink.expressad.foundation.h.i.a(this, "anythink_reward_activity_open", com.anythink.expressad.foundation.h.i.f);
            int a7 = com.anythink.expressad.foundation.h.i.a(this, "anythink_reward_activity_stay", com.anythink.expressad.foundation.h.i.f);
            if (a6 > 1 && a7 > 1) {
                overridePendingTransition(a6, a7);
            }
            if (bundle != null) {
                try {
                    this.L = bundle.getBoolean(h);
                } catch (java.lang.Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.O = com.anythink.expressad.videocommon.b.e.a().b(this.w);
            boolean booleanExtra = intent.getBooleanExtra(g, false);
            this.G = booleanExtra;
            if (!booleanExtra) {
                java.util.List<com.anythink.expressad.videocommon.b.c> list2 = this.O;
                if (list2 != null && list2.size() > 0) {
                    this.M = this.O.get(0);
                }
                com.anythink.expressad.videocommon.b.c cVar2 = this.M;
                if (cVar2 != null) {
                    this.N = cVar2.n();
                    this.M.a(true);
                    this.M.b(false);
                }
                if (this.M == null || this.N == null || this.z == null) {
                    b("data empty error");
                }
                b();
                return;
            }
            java.util.List<com.anythink.expressad.foundation.d.c> a8 = com.anythink.expressad.videocommon.b.e.a().a(this.w);
            this.P = a8;
            this.U = "";
            if (a8 != null && a8.size() > 0) {
                com.anythink.expressad.foundation.d.c cVar3 = this.P.get(0);
                str = cVar3.ar();
                this.U = cVar3.Z();
            }
            com.anythink.expressad.videocommon.a.C0231a a9 = com.anythink.expressad.videocommon.a.a(this.w + "_" + this.U + "_" + str);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a10 = a9 != null ? a9.a() : null;
            this.S = a10;
            if (a10 != null) {
                c();
                return;
            }
            if (this.M == null && (list = this.O) != null && list.size() > 0) {
                this.M = this.O.get(0);
            }
            if (this.M == null) {
                com.anythink.expressad.videocommon.b.e a11 = com.anythink.expressad.videocommon.b.e.a();
                int i2 = this.B ? com.anythink.expressad.foundation.g.a.aU : 94;
                java.lang.String str2 = this.w;
                boolean z = this.C;
                com.anythink.expressad.videocommon.b.n c2 = a11.c(str2);
                this.M = c2 != null ? c2.b(i2, z) : null;
            }
            com.anythink.expressad.videocommon.b.c cVar4 = this.M;
            if (cVar4 != null) {
                this.N = cVar4.n();
                this.M.a(true);
                this.M.b(false);
            }
            if (this.M == null || this.N == null || this.z == null) {
                b("data empty error");
            }
            this.G = false;
            com.anythink.expressad.videocommon.a.a.a();
            java.util.List<com.anythink.expressad.foundation.d.c> a12 = com.anythink.expressad.videocommon.a.a.a(this.P);
            if (a12 == null) {
                b("no available campaign");
                return;
            }
            int size = a12.size();
            if (size == 0) {
                b("no available campaign");
                return;
            }
            if (a12.get(0) == null || !a12.get(0).j()) {
                b();
                return;
            }
            if (size != 1) {
                a(a12);
                return;
            }
            com.anythink.expressad.foundation.d.c cVar5 = a12.get(0);
            this.N = cVar5;
            if (cVar5 != null) {
                cVar5.m();
            }
            b(this.N);
        } catch (java.lang.Throwable th) {
            b("onCreate error".concat(java.lang.String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.P;
            if (list != null && list.size() > 0) {
                java.util.Iterator<com.anythink.expressad.foundation.d.c> it = this.P.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
            com.anythink.expressad.foundation.d.c cVar = this.N;
            if (cVar != null) {
                c(cVar);
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
        com.anythink.expressad.video.module.b.a.a(this.w);
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onDestroy();
            this.Q = null;
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onDestroy();
            this.R = null;
        }
        this.ae = null;
        this.af = null;
        com.anythink.expressad.foundation.g.h.a.a().execute(new com.anythink.expressad.reward.player.ATRewardVideoActivity.a(this.O, this.w, this.U));
        java.util.List<com.anythink.expressad.foundation.d.c> list2 = this.P;
        com.anythink.expressad.foundation.d.c cVar2 = (list2 == null || list2.size() <= 0) ? null : this.P.get(0);
        if (cVar2 == null) {
            cVar2 = this.N;
        }
        if (cVar2 != null && !android.text.TextUtils.isEmpty(cVar2.S())) {
            com.anythink.core.common.a.k.a().b();
        }
        this.f257s = null;
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long j2 = this.r + 1;
        this.r = j2;
        if (j2 <= 5) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("3-");
            com.anythink.expressad.reward.player.b bVar = this.f257s;
            sb.append(bVar != null ? bVar.a() : "0");
            a(sb.toString(), android.os.SystemClock.elapsedRealtime() - this.p);
        }
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onPause();
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onRestart();
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onRestart();
        }
    }

    @Override // com.anythink.expressad.video.signal.activity.AbstractJSActivity, com.anythink.expressad.activity.ATBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.p = android.os.SystemClock.elapsedRealtime();
        long j2 = this.q + 1;
        this.q = j2;
        if (j2 <= 5) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("2-");
            com.anythink.expressad.reward.player.b bVar = this.f257s;
            sb.append(bVar != null ? bVar.a() : "0");
            a(sb.toString(), 0L);
        }
        if (com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        com.anythink.expressad.foundation.b.a.b().b(this);
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onResume();
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(android.os.Bundle bundle) {
        bundle.putBoolean(h, this.L);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        new com.anythink.expressad.reward.player.ATRewardVideoActivity.AnonymousClass5();
        if (com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onStart();
            this.N.l(this.w);
            com.anythink.expressad.foundation.f.b.a().a(this.w + "_1", this.N);
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onStart();
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.P;
            if (list != null && list.size() > 0) {
                com.anythink.expressad.foundation.d.c cVar = this.P.get(0);
                cVar.l(this.w);
                com.anythink.expressad.foundation.f.b.a().a(this.w + "_1", cVar);
            }
        }
        if (this.W) {
            return;
        }
        com.anythink.expressad.foundation.f.b.a().b(this.w + "_1", 1);
        com.anythink.expressad.foundation.f.b.a().c(this.w + "_2");
        this.W = true;
    }

    @Override // android.app.Activity
    public void onStop() {
        com.anythink.expressad.a.x = false;
        try {
            super.onStop();
        } catch (java.lang.Throwable unused) {
        }
        com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = this.Q;
        if (aTTempContainer != null) {
            aTTempContainer.onStop();
        }
        com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = this.R;
        if (anythinkBTContainer != null) {
            anythinkBTContainer.onStop();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        super.setTheme(com.anythink.expressad.foundation.h.i.a(this, "anythink_transparent_theme", com.anythink.expressad.foundation.h.i.e));
    }
}
