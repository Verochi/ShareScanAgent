package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public class ATTempContainer extends com.anythink.expressad.video.signal.container.AbstractJSContainer {
    private static final java.lang.String B = "ATTempContainer";
    private static final long ab = 5000;
    private static final long ac = 2000;
    private static final long ad = 100;
    private static final int ae = -1;
    private static final int af = -2;
    private static final int ag = -3;
    private static final int ah = -3;
    private static final int ai = -4;
    private static final int am = 250;
    protected static final int b = 0;
    private android.view.View C;
    private com.anythink.expressad.foundation.d.c D;
    private com.anythink.expressad.videocommon.b.c E;
    private com.anythink.expressad.video.bt.module.b.h F;
    private com.anythink.expressad.video.bt.module.a.b G;
    private com.anythink.expressad.video.dynview.f.a H;
    private int I;
    private java.lang.String J;
    private com.anythink.expressad.video.signal.factory.b K;
    private int L;
    private int M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private java.lang.String T;
    private java.lang.String U;
    private java.util.List<com.anythink.expressad.foundation.d.c> V;
    private int W;
    protected boolean a;
    private android.view.LayoutInflater aa;
    private int aj;
    private int ak;
    private int al;
    private android.view.View an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver ay;
    private java.lang.Runnable az;
    protected boolean c;
    protected com.anythink.expressad.video.bt.module.ATTempContainer.a d;
    protected com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView e;
    protected com.anythink.expressad.video.module.AnythinkVideoView f;
    protected com.anythink.expressad.video.module.AnythinkContainerView g;
    protected android.os.Handler h;
    protected java.lang.Runnable i;
    protected java.lang.Runnable j;
    com.anythink.expressad.reward.player.c k;

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.video.bt.module.ATTempContainer.this.getActivityProxy().h() != 0) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.aj = -3;
            } else {
                java.lang.String unused = com.anythink.expressad.video.bt.module.ATTempContainer.B;
                com.anythink.expressad.video.bt.module.ATTempContainer.this.defaultLoad(-1, "WebView load timeout");
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.video.bt.module.ATTempContainer.this.getActivityProxy().h() == 0) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.defaultLoad(-3, "JS bridge connect timeout");
            } else {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.aj = -4;
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.expressad.video.bt.module.ATTempContainer.this.an != null) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.an.setVisibility(8);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).m != null) {
                ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).m.finish();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$5, reason: invalid class name */
    public class AnonymousClass5 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass5() {
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void a() {
            java.lang.String str;
            com.anythink.expressad.video.bt.module.ATTempContainer.this.onPause();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.video.bt.module.ATTempContainer.B;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.ATTempContainer.this.e, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void b() {
            java.lang.String str;
            com.anythink.expressad.video.bt.module.ATTempContainer.this.onResume();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.video.bt.module.ATTempContainer.B;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.ATTempContainer.this.e, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }

        @Override // com.anythink.expressad.foundation.f.a
        public final void c() {
            java.lang.String str;
            com.anythink.expressad.video.bt.module.ATTempContainer.this.onResume();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                if (com.anythink.core.common.b.o.a().f() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (java.lang.Throwable th) {
                java.lang.String unused = com.anythink.expressad.video.bt.module.ATTempContainer.B;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.ATTempContainer.this.e, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener {
        public AnonymousClass6() {
        }

        @Override // com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver.VolumeChangeListener
        public final void onVolumeChanged(double d) {
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView;
            java.lang.String unused = com.anythink.expressad.video.bt.module.ATTempContainer.B;
            try {
                if (!com.anythink.expressad.video.bt.module.ATTempContainer.this.D.H() || (anythinkContainerView = com.anythink.expressad.video.bt.module.ATTempContainer.this.g) == null || anythinkContainerView.getH5EndCardView() == null) {
                    return;
                }
                com.anythink.expressad.video.bt.module.ATTempContainer.this.g.getH5EndCardView().volumeChange(d);
            } catch (java.lang.Exception e) {
                java.lang.String unused2 = com.anythink.expressad.video.bt.module.ATTempContainer.B;
                e.getMessage();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.bt.module.ATTempContainer.this.an.setBackgroundColor(0);
            com.anythink.expressad.video.bt.module.ATTempContainer.this.an.setVisibility(0);
            com.anythink.expressad.video.bt.module.ATTempContainer.this.an.bringToFront();
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.video.bt.module.ATTempContainer.this.an.setVisibility(8);
        }
    }

    public interface a {

        /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$a$a, reason: collision with other inner class name */
        public static class C0226a implements com.anythink.expressad.video.bt.module.ATTempContainer.a {
            private static final java.lang.String b = "ActivityErrorListener";
            private boolean a = false;

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public void a(java.lang.String str) {
                this.a = true;
            }

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public final boolean a() {
                return this.a;
            }

            @Override // com.anythink.expressad.video.bt.module.ATTempContainer.a
            public final void b() {
                this.a = true;
            }
        }

        void a(java.lang.String str);

        boolean a();

        void b();
    }

    public final class b extends com.anythink.expressad.video.module.a.a.f {
        private android.app.Activity V;
        private com.anythink.expressad.foundation.d.c W;

        /* renamed from: com.anythink.expressad.video.bt.module.ATTempContainer$b$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
            }
        }

        public b(android.app.Activity activity, com.anythink.expressad.foundation.d.c cVar) {
            this.V = activity;
            this.W = cVar;
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i, java.lang.Object obj) {
            android.content.Context context = com.anythink.expressad.video.bt.module.ATTempContainer.this.getContext();
            if (context != null && context != context.getApplicationContext()) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().a(context);
            }
            if (this.V != null) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().a(this.V);
            }
            com.anythink.expressad.video.bt.module.ATTempContainer.m(com.anythink.expressad.video.bt.module.ATTempContainer.this);
            if (i == 108) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().a(new com.anythink.expressad.video.signal.a.c.b(com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon(), new com.anythink.expressad.video.bt.module.ATTempContainer.d(com.anythink.expressad.video.bt.module.ATTempContainer.this, (byte) 0)));
                com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
            } else if (i == 113) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a(this.W);
                com.anythink.expressad.reward.player.c cVar = com.anythink.expressad.video.bt.module.ATTempContainer.this.k;
            } else if (i == 117) {
                com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = com.anythink.expressad.video.bt.module.ATTempContainer.this.f;
                if (anythinkVideoView != null) {
                    anythinkVideoView.setVisible(4);
                }
                com.anythink.expressad.video.bt.module.ATTempContainer.m(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.c();
                com.anythink.expressad.reward.player.c cVar2 = com.anythink.expressad.video.bt.module.ATTempContainer.this.k;
            } else if (i != 126 && i != 128) {
                switch (i) {
                    case 103:
                    case 104:
                        com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                        break;
                    case 105:
                        com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                        break;
                    case 106:
                        if (com.anythink.expressad.video.bt.module.ATTempContainer.this.G != null) {
                            com.anythink.expressad.video.bt.module.ATTempContainer.this.G.a(com.anythink.expressad.video.bt.module.ATTempContainer.this.J, this.W);
                        } else {
                            com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a(this.W);
                        }
                        if (this.V != null && this.W != null) {
                            com.anythink.core.common.b.o.a().a(new com.anythink.expressad.video.bt.module.ATTempContainer.b.AnonymousClass1(), 50L);
                            break;
                        }
                        break;
                }
            } else {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a(this.W);
            }
            super.a(i, obj);
        }
    }

    public final class c extends com.anythink.expressad.video.module.a.a.f {
        private c() {
        }

        public /* synthetic */ c(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        public final void a(int i, java.lang.Object obj) {
            super.a(i, obj);
            try {
                java.lang.String obj2 = obj instanceof org.json.JSONObject ? obj.toString() : (java.lang.String) obj;
                if (((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).u && !android.text.TextUtils.isEmpty(obj2)) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(obj2);
                    int optInt = jSONObject.optInt("type");
                    int optInt2 = jSONObject.optInt(com.anythink.expressad.foundation.d.c.bX);
                    if (optInt == 2) {
                        com.anythink.expressad.video.bt.module.ATTempContainer.this.L = com.anythink.expressad.foundation.g.a.cx;
                    } else if (optInt != 3) {
                        com.anythink.expressad.video.bt.module.ATTempContainer.this.L = com.anythink.expressad.foundation.g.a.cv;
                    } else {
                        com.anythink.expressad.video.bt.module.ATTempContainer.this.L = com.anythink.expressad.foundation.g.a.cw;
                    }
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.M = optInt2;
                }
            } catch (java.lang.Exception unused) {
            }
            if (i == 120) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.c();
                com.anythink.expressad.reward.player.c cVar = com.anythink.expressad.video.bt.module.ATTempContainer.this.k;
                return;
            }
            if (i == 126) {
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a(com.anythink.expressad.video.bt.module.ATTempContainer.this.D);
                com.anythink.expressad.reward.player.c cVar2 = com.anythink.expressad.video.bt.module.ATTempContainer.this.k;
                return;
            }
            if (i == 127) {
                com.anythink.expressad.video.bt.module.ATTempContainer.h(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.c();
                com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSContainerModule().showEndcard(100);
                return;
            }
            switch (i) {
                case 100:
                    com.anythink.expressad.video.bt.module.ATTempContainer.q(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = com.anythink.expressad.video.bt.module.ATTempContainer.this;
                    aTTempContainer.h.postDelayed(aTTempContainer.az, 250L);
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                    break;
                case 101:
                case 102:
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().j();
                    break;
                case 103:
                    com.anythink.expressad.video.bt.module.ATTempContainer.h(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    if (!com.anythink.expressad.video.bt.module.ATTempContainer.this.D.H()) {
                        com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().j();
                        break;
                    } else {
                        com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                        break;
                    }
                case 104:
                    com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    break;
                case 105:
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                    break;
            }
        }
    }

    public class d extends com.anythink.expressad.video.signal.a.c.a {
        private d() {
        }

        public /* synthetic */ d(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(int i, java.lang.String str) {
            super.a(i, str);
            com.anythink.expressad.video.bt.module.ATTempContainer.this.defaultLoad(i, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            super.a(cVar, str);
            com.anythink.expressad.video.bt.module.ATTempContainer.s(com.anythink.expressad.video.bt.module.ATTempContainer.this);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            super.a(cVar, z);
            com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a(cVar);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, java.lang.String str) {
            super.a(jVar, str);
            com.anythink.expressad.video.bt.module.ATTempContainer.t(com.anythink.expressad.video.bt.module.ATTempContainer.this);
            com.anythink.expressad.video.bt.module.ATTempContainer.u(com.anythink.expressad.video.bt.module.ATTempContainer.this);
            if (jVar == null || !(jVar instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
                java.lang.String optString = new org.json.JSONObject(com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSVideoModule().getCurrentProgress()).optString(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, "");
                if (cVar.Q() == 3 && cVar.C() == 2 && optString.equals("1.0") && ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).m != null) {
                    if (((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).z) {
                        com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    } else {
                        ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).m.finish();
                    }
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, java.lang.String str) {
            super.b(jVar, str);
            com.anythink.expressad.video.bt.module.ATTempContainer.u(com.anythink.expressad.video.bt.module.ATTempContainer.this);
            com.anythink.expressad.video.bt.module.ATTempContainer.t(com.anythink.expressad.video.bt.module.ATTempContainer.this);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void c() {
            super.c();
            com.anythink.expressad.video.bt.module.ATTempContainer.this.receiveSuccess();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void d() {
            super.d();
            com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer = com.anythink.expressad.video.bt.module.ATTempContainer.this;
            android.os.Handler handler = aTTempContainer.h;
            if (handler != null) {
                handler.removeCallbacks(aTTempContainer.i);
            }
        }
    }

    public final class e extends com.anythink.expressad.video.module.a.a.f {
        private e() {
        }

        public /* synthetic */ e(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer, byte b) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x0114, code lost:
        
            if (r2.a.D.l() != false) goto L62;
         */
        @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(int i, java.lang.Object obj) {
            super.a(i, obj);
            if (((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).u) {
                try {
                    if (obj instanceof java.lang.String) {
                        java.lang.String str = (java.lang.String) obj;
                        if (!android.text.TextUtils.isEmpty(str)) {
                            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                            com.anythink.expressad.video.bt.module.ATTempContainer.this.L = jSONObject.getInt("Alert_window_status");
                            com.anythink.expressad.video.bt.module.ATTempContainer.this.M = jSONObject.getInt("complete_info");
                        }
                    }
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            if (i != 2) {
                if (i == 121) {
                    com.anythink.expressad.video.bt.module.ATTempContainer.h(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.F.b();
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.au = false;
                    return;
                }
                if (i == 16) {
                    com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    return;
                }
                if (i == 17) {
                    com.anythink.expressad.video.bt.module.ATTempContainer.h(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = com.anythink.expressad.video.bt.module.ATTempContainer.this.g;
                    if (anythinkContainerView != null) {
                        anythinkContainerView.setRewardStatus(true);
                        return;
                    }
                    return;
                }
                switch (i) {
                    case 10:
                        com.anythink.expressad.video.bt.module.ATTempContainer.this.au = true;
                        if (com.anythink.expressad.video.bt.module.ATTempContainer.this.D != null) {
                            if (!com.anythink.expressad.video.bt.module.ATTempContainer.this.D.j()) {
                                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                                break;
                            } else if (!((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).z) {
                                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                                break;
                            } else if (com.anythink.expressad.video.bt.module.ATTempContainer.this.D.l()) {
                                com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                                break;
                            }
                        }
                        break;
                }
                return;
            }
            if (i == 12 && !com.anythink.expressad.video.bt.module.ATTempContainer.this.au) {
                if (((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).p.U() == 0) {
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a("play error");
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.au = false;
                    com.anythink.expressad.video.bt.module.ATTempContainer.k(com.anythink.expressad.video.bt.module.ATTempContainer.this);
                    return;
                } else {
                    if (com.anythink.expressad.video.bt.module.ATTempContainer.this.D != null && com.anythink.expressad.video.bt.module.ATTempContainer.this.D.j()) {
                        if (!((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.ATTempContainer.this).z) {
                            com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                        }
                    }
                    com.anythink.expressad.video.bt.module.ATTempContainer.this.F.a();
                }
            }
            com.anythink.expressad.video.bt.module.ATTempContainer.this.getJSVideoModule().videoOperate(3);
            com.anythink.expressad.video.bt.module.ATTempContainer.this.au = false;
        }
    }

    public ATTempContainer(android.content.Context context) {
        super(context);
        this.I = 1;
        this.J = "";
        this.L = com.anythink.expressad.foundation.g.a.cv;
        this.N = false;
        this.T = "";
        this.V = new java.util.ArrayList();
        this.W = 0;
        this.a = false;
        this.c = false;
        this.d = new com.anythink.expressad.video.bt.module.ATTempContainer.a.C0226a();
        this.h = new android.os.Handler();
        this.aj = 0;
        this.ak = 0;
        this.al = 0;
        this.i = new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass1();
        this.j = new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass2();
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.az = new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass3();
        init(context);
    }

    public ATTempContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = 1;
        this.J = "";
        this.L = com.anythink.expressad.foundation.g.a.cv;
        this.N = false;
        this.T = "";
        this.V = new java.util.ArrayList();
        this.W = 0;
        this.a = false;
        this.c = false;
        this.d = new com.anythink.expressad.video.bt.module.ATTempContainer.a.C0226a();
        this.h = new android.os.Handler();
        this.aj = 0;
        this.ak = 0;
        this.al = 0;
        this.i = new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass1();
        this.j = new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass2();
        this.ao = false;
        this.ap = false;
        this.aq = false;
        this.as = false;
        this.at = false;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = false;
        this.az = new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass3();
        init(context);
    }

    private int a(int i, int i2) {
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        if (i < 0 || (list = this.V) == null || list.size() == 0 || i2 <= 1) {
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i2 - 1; i4++) {
            if (this.V.get(i4) != null) {
                i3 += this.V.get(i4).bi();
            }
        }
        if (i > i3) {
            return i - i3;
        }
        return 0;
    }

    private void a(int i, java.lang.String str) {
        try {
            com.anythink.expressad.foundation.d.r rVar = new com.anythink.expressad.foundation.d.r();
            rVar.h(com.anythink.expressad.foundation.d.r.i);
            rVar.c("code=" + i + ",desc=" + str);
            com.anythink.expressad.foundation.d.c cVar = this.D;
            rVar.b((cVar == null || cVar.M() == null) ? "" : this.D.M().e());
            rVar.f(this.n);
            com.anythink.expressad.foundation.d.c cVar2 = this.D;
            rVar.g(cVar2 != null ? cVar2.aZ() : "");
            com.anythink.expressad.foundation.d.c cVar3 = this.D;
            if (cVar3 != null && !android.text.TextUtils.isEmpty(cVar3.Z())) {
                rVar.d(this.D.Z());
            }
            com.anythink.expressad.foundation.d.c cVar4 = this.D;
            if (cVar4 != null && !android.text.TextUtils.isEmpty(cVar4.aa())) {
                rVar.e(this.D.aa());
            }
            getContext();
            int a2 = com.anythink.expressad.foundation.h.k.a();
            rVar.c(a2);
            rVar.j(com.anythink.expressad.foundation.h.k.a(getContext(), a2));
            com.anythink.expressad.foundation.d.r.a(rVar);
            com.anythink.expressad.video.module.b.a.a();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    private static android.widget.RelativeLayout.LayoutParams c() {
        return new android.widget.RelativeLayout.LayoutParams(-1, -1);
    }

    private void d() {
        if (this.a) {
            setMatchParent();
        }
    }

    private int e() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.D);
        if (b2 != null) {
            return b2.c();
        }
        return 0;
    }

    private int f() {
        if (getJSCommon() != null) {
            return getJSCommon().n();
        }
        return 1;
    }

    private int g() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.D);
        if (b2 != null) {
            return b2.b();
        }
        return 0;
    }

    private boolean h() {
        com.anythink.expressad.video.signal.a.j b2 = b(this.D);
        if (b2 != null) {
            return b2.a();
        }
        return false;
    }

    public static /* synthetic */ boolean h(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        aTTempContainer.ap = true;
        return true;
    }

    private boolean i() {
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.f;
        if (anythinkVideoView != null) {
            return anythinkVideoView.isShowingAlertView() || this.f.isInstallDialogShowing();
        }
        return false;
    }

    private void j() {
        int f;
        int e2;
        try {
            if (this.e != null) {
                int i = getResources().getConfiguration().orientation;
                if (h()) {
                    f = com.anythink.expressad.foundation.h.t.g(getContext());
                    e2 = com.anythink.expressad.foundation.h.t.h(getContext());
                    if (com.anythink.expressad.foundation.h.g.a(getContext())) {
                        int i2 = com.anythink.expressad.foundation.h.t.i(getContext());
                        if (i == 2) {
                            f += i2;
                        } else {
                            e2 += i2;
                        }
                    }
                } else {
                    f = com.anythink.expressad.foundation.h.t.f(getContext());
                    e2 = com.anythink.expressad.foundation.h.t.e(getContext());
                }
                int c2 = this.D.M().c();
                if (c(this.D) == 1) {
                    c2 = i;
                }
                getJSNotifyProxy().a(i, c2, f, e2);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(getContext()));
                try {
                    if (this.r != null) {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        jSONObject2.put("name", this.r.a());
                        jSONObject2.put("amount", this.r.b());
                        jSONObject2.put("id", this.f281s);
                        jSONObject.put("userId", this.q);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.t);
                        jSONObject.put("extra", this.U);
                    }
                } catch (org.json.JSONException e3) {
                    e3.getMessage();
                } catch (java.lang.Exception e4) {
                    e4.getMessage();
                }
                getJSNotifyProxy().a(jSONObject.toString());
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.e, "oncutoutfetched", android.util.Base64.encodeToString(this.T.getBytes(), 0));
                getJSCommon().h();
                loadModuleDatas();
                this.h.postDelayed(this.i, 2000L);
            }
        } catch (java.lang.Exception e5) {
            if (com.anythink.expressad.a.a) {
                e5.printStackTrace();
            }
        }
    }

    private void k() {
        int i = this.aj;
        java.lang.Runnable runnable = i == -3 ? this.i : i == -4 ? this.j : null;
        if (runnable != null) {
            runnable.run();
            this.aj = 0;
        }
    }

    public static /* synthetic */ void k(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        int i;
        try {
            com.anythink.expressad.video.bt.module.a.b bVar = aTTempContainer.G;
            if (bVar == null) {
                android.app.Activity activity = aTTempContainer.m;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (aTTempContainer.u && ((i = aTTempContainer.w) == com.anythink.expressad.foundation.g.a.cr || i == com.anythink.expressad.foundation.g.a.cs)) {
                boolean z = true;
                if (aTTempContainer.M != 1) {
                    z = false;
                }
                bVar.a(z, aTTempContainer.L);
            }
            aTTempContainer.G.a(aTTempContainer.J, aTTempContainer.ap, aTTempContainer.r);
        } catch (java.lang.Exception unused) {
            android.app.Activity activity2 = aTTempContainer.m;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private boolean l() {
        this.e = findWindVaneWebView();
        com.anythink.expressad.video.module.AnythinkVideoView findAnythinkVideoView = findAnythinkVideoView();
        this.f = findAnythinkVideoView;
        findAnythinkVideoView.setVideoLayout(this.D);
        this.f.setIsIV(this.u);
        this.f.setUnitId(this.n);
        this.f.setCamPlayOrderCallback(this.H, this.V, this.I, this.W);
        this.f.setTempEventListener(this.k);
        if (this.z) {
            this.f.setNotchPadding(this.P, this.Q, this.R, this.S);
        }
        com.anythink.expressad.video.module.AnythinkContainerView findAnythinkContainerView = findAnythinkContainerView();
        this.g = findAnythinkContainerView;
        if (this.z) {
            findAnythinkContainerView.setNotchPadding(this.O, this.P, this.Q, this.R, this.S);
        }
        return (this.f == null || this.g == null || !initViews()) ? false : true;
    }

    private void m() {
        if (this.p == null) {
            this.p = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.n, this.u);
        }
    }

    public static /* synthetic */ boolean m(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        aTTempContainer.av = true;
        return true;
    }

    private static void n() {
    }

    private void o() {
        int i;
        try {
            com.anythink.expressad.video.bt.module.a.b bVar = this.G;
            if (bVar == null) {
                android.app.Activity activity = this.m;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (this.u && ((i = this.w) == com.anythink.expressad.foundation.g.a.cr || i == com.anythink.expressad.foundation.g.a.cs)) {
                boolean z = true;
                if (this.M != 1) {
                    z = false;
                }
                bVar.a(z, this.L);
            }
            this.G.a(this.J, this.ap, this.r);
        } catch (java.lang.Exception unused) {
            android.app.Activity activity2 = this.m;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    private static void p() {
    }

    private void q() {
        android.view.ViewGroup viewGroup;
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.e;
        this.K = new com.anythink.expressad.video.signal.factory.b(this.m, windVaneWebView, this.f, this.g, this.D, new com.anythink.expressad.video.bt.module.ATTempContainer.d(this, (byte) 0));
        com.anythink.expressad.foundation.d.c cVar = this.D;
        if (cVar != null && cVar.k() == 5 && (list = this.V) != null) {
            this.K.a(list);
        }
        registerJsFactory(this.K);
        com.anythink.expressad.foundation.f.b.a().a(this.n + "_1", new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass5());
        if (windVaneWebView == null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.C.findViewById(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_templete_webview_parent", "id"));
        windVaneWebView.setApiManagerJSFactory(this.K);
        if (windVaneWebView.getParent() != null) {
            defaultLoad(0, "preload template webview is null or load error");
            return;
        }
        if (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
            this.K.a((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject());
            getJSCommon().a(this.t);
            getJSCommon().a(this.n);
            getJSCommon().a(this.p);
            getJSCommon().a(new com.anythink.expressad.video.bt.module.ATTempContainer.d(this, (byte) 0));
            com.anythink.expressad.foundation.d.c cVar2 = this.D;
            if (cVar2 != null && (cVar2.H() || this.D.ay())) {
                com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver(getContext());
                this.ay = mraidVolumeChangeReceiver;
                mraidVolumeChangeReceiver.registerReceiver();
                this.ay.getCurrentVolume();
                this.ay.setVolumeChangeListener(new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass6());
            }
            getJSContainerModule().readyStatus(((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r());
            j();
            ((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r.c();
            if (this.z) {
                getJSCommon().f(this.ak);
                getJSCommon().e(this.al);
            }
        }
        if (getJSCommon().f() == 1 && (viewGroup = (android.view.ViewGroup) this.C.findViewById(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_templete_webview_parent", "id"))) != null) {
            ((android.view.ViewGroup) this.C).removeView(viewGroup);
            ((android.view.ViewGroup) this.C).addView(viewGroup, 1);
        }
        viewGroup2.addView(windVaneWebView, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public static /* synthetic */ boolean q(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        aTTempContainer.aw = true;
        return true;
    }

    private void r() {
        getJSCommon().a(this.t);
        getJSCommon().a(this.n);
        getJSCommon().a(this.p);
        getJSCommon().a(new com.anythink.expressad.video.bt.module.ATTempContainer.d(this, (byte) 0));
        com.anythink.expressad.foundation.d.c cVar = this.D;
        if (cVar != null) {
            if (cVar.H() || this.D.ay()) {
                com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver(getContext());
                this.ay = mraidVolumeChangeReceiver;
                mraidVolumeChangeReceiver.registerReceiver();
                this.ay.getCurrentVolume();
                this.ay.setVolumeChangeListener(new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass6());
            }
        }
    }

    private void s() {
        if (this.ap) {
            com.anythink.expressad.video.module.b.a.a(this.D, this.r, this.n, this.q, this.U);
        }
    }

    public static /* synthetic */ void s(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        if (aTTempContainer.isLoadSuccess()) {
            aTTempContainer.m.runOnUiThread(aTTempContainer.new AnonymousClass7());
        }
    }

    private void t() {
        com.anythink.expressad.foundation.d.c cVar;
        int i;
        boolean z = true;
        try {
            this.ao = true;
            com.anythink.expressad.foundation.d.c cVar2 = this.D;
            if (cVar2 != null && cVar2.J() == 2) {
                this.ap = true;
            }
            com.anythink.expressad.video.bt.module.b.h hVar = this.F;
            if (hVar != null) {
                if (this.u && ((i = this.w) == com.anythink.expressad.foundation.g.a.cr || i == com.anythink.expressad.foundation.g.a.cs)) {
                    if (this.M != 1) {
                        z = false;
                    }
                    hVar.a(z, this.L);
                }
                if (!this.ap) {
                    this.r.a(0);
                }
                this.F.a(this.ap, this.r);
            }
            this.h.removeCallbacks(this.az);
            if (((!this.u && !this.z) || ((cVar = this.D) != null && cVar.j())) && this.ap) {
                com.anythink.expressad.video.module.b.a.a(this.D, this.r, this.n, this.q, this.U);
            }
            if (!this.z) {
                if (this.u) {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.D);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.D);
                }
            }
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
            if (anythinkContainerView != null) {
                anythinkContainerView.release();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public static /* synthetic */ boolean t(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        aTTempContainer.at = true;
        return true;
    }

    private static int u() {
        try {
            com.anythink.expressad.videocommon.e.a b2 = com.anythink.expressad.videocommon.e.c.a().b();
            if (b2 == null) {
                com.anythink.expressad.videocommon.e.c.a();
                com.anythink.expressad.videocommon.e.c.c();
            }
            if (b2 != null) {
                return (int) b2.g();
            }
            return 5;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    public static /* synthetic */ void u(com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer) {
        if (aTTempContainer.isLoadSuccess()) {
            aTTempContainer.m.runOnUiThread(aTTempContainer.new AnonymousClass8());
        }
    }

    private void v() {
        if (isLoadSuccess()) {
            this.m.runOnUiThread(new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass7());
        }
    }

    private void w() {
        if (isLoadSuccess()) {
            this.m.runOnUiThread(new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass8());
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public final void a(java.lang.String str) {
        com.anythink.expressad.video.bt.module.b.h hVar = this.F;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    public boolean canBackPress() {
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
        return anythinkContainerView == null || anythinkContainerView.canBackPress();
    }

    public void defaultLoad(int i, java.lang.String str) {
        int i2;
        superDefaultLoad(i, str);
        if (!isLoadSuccess()) {
            a(i, str);
            android.app.Activity activity = this.m;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (this.D.J() == 2) {
            this.g.setCampaign(this.D);
            this.g.addOrderViewData(this.V);
            this.g.setUnitID(this.n);
            this.g.setCloseDelayTime(this.D.g() > -2 ? this.D.g() : this.p.p());
            this.g.setPlayCloseBtnTm(this.p.j());
            this.g.setNotifyListener(new com.anythink.expressad.video.module.a.a.h(this.D, this.E, this.r, b(), this.n, new com.anythink.expressad.video.bt.module.ATTempContainer.c(this, (byte) 0), this.p.M(), this.z));
            this.g.preLoadData(this.K);
            this.g.showPlayableView();
            return;
        }
        a(i, str);
        this.an.setVisibility(8);
        loadModuleDatas();
        int f = this.p.f();
        int e2 = e();
        int i3 = e2 != 0 ? e2 : f;
        com.anythink.expressad.foundation.d.c cVar = this.D;
        if (cVar != null && cVar.j()) {
            this.f.setContainerViewOnNotifyListener(new com.anythink.expressad.video.bt.module.ATTempContainer.b(this.m, this.D));
        }
        com.anythink.expressad.foundation.d.c cVar2 = this.D;
        int e3 = (cVar2 == null || cVar2.h() <= -2) ? this.p.e() : this.D.h();
        if (this.D.k() == 5 && (i2 = this.I) > 1) {
            e3 = a(e3, i2);
            this.D.a(e3);
        }
        int i4 = e3;
        this.f.setVideoSkipTime(i4);
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.f;
        anythinkVideoView.setNotifyListener(new com.anythink.expressad.video.module.a.a.m(anythinkVideoView, this.g, this.D, this.r, this.E, b(), this.n, i3, i4, new com.anythink.expressad.video.bt.module.ATTempContainer.e(this, (byte) 0), this.p.M(), this.z, this.p.U()));
        this.f.defaultShow();
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
        anythinkContainerView.setNotifyListener(new com.anythink.expressad.video.module.a.a.b(this.f, anythinkContainerView, this.D, this.r, this.E, b(), this.n, new com.anythink.expressad.video.bt.module.ATTempContainer.b(this.m, this.D), this.p.M(), this.z));
        this.g.defaultShow();
    }

    public com.anythink.expressad.video.module.AnythinkContainerView findAnythinkContainerView() {
        return (com.anythink.expressad.video.module.AnythinkContainerView) findViewById(findID("anythink_video_templete_container"));
    }

    public com.anythink.expressad.video.module.AnythinkVideoView findAnythinkVideoView() {
        return (com.anythink.expressad.video.module.AnythinkVideoView) findViewById(findID("anythink_video_templete_videoview"));
    }

    public int findID(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(getContext(), str, "id");
    }

    public int findLayout(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(getContext(), str, "layout");
    }

    public com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView findWindVaneWebView() {
        try {
            if (!this.z) {
                com.anythink.expressad.videocommon.a.C0231a a2 = this.u ? com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.D) : com.anythink.expressad.videocommon.a.a(94, this.D);
                if (a2 == null || !a2.c()) {
                    return null;
                }
                if (this.u) {
                    com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.D);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.D);
                }
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a3 = a2.a();
                if (this.as) {
                    a3.setWebViewTransparent();
                }
                return a3;
            }
            com.anythink.expressad.foundation.d.c cVar = this.D;
            if (cVar == null || cVar.M() == null) {
                return null;
            }
            com.anythink.expressad.videocommon.a.C0231a a4 = com.anythink.expressad.videocommon.a.a(this.n + "_" + this.D.aZ() + "_" + this.D.Z() + "_" + this.D.M().e());
            if (a4 != null) {
                return a4.a();
            }
            return null;
        } catch (java.lang.Exception e2) {
            if (!com.anythink.expressad.a.a) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public com.anythink.expressad.foundation.d.c getCampaign() {
        return this.D;
    }

    public java.lang.String getInstanceId() {
        return this.J;
    }

    public int getLayoutID() {
        return findLayout(this.as ? "anythink_reward_activity_video_templete_transparent" : "anythink_reward_activity_video_templete");
    }

    public void init(android.content.Context context) {
        this.aa = android.view.LayoutInflater.from(context);
    }

    public boolean initViews() {
        android.view.View findViewById = findViewById(findID("anythink_video_templete_progressbar"));
        this.an = findViewById;
        return findViewById != null;
    }

    public boolean isLoadSuccess() {
        return this.c;
    }

    public void loadModuleDatas() {
        int i;
        int i2;
        com.anythink.expressad.video.signal.a.j b2 = b(this.D);
        int b3 = b2 != null ? b2.b() : 0;
        if (b3 != 0) {
            this.t = b3;
        }
        int f = this.p.f();
        int e2 = e();
        int i3 = e2 != 0 ? e2 : f;
        this.f.setSoundState(this.t);
        this.f.setCampaign(this.D);
        this.f.setPlayURL(this.E.r());
        com.anythink.expressad.foundation.d.c cVar = this.D;
        int e3 = (cVar == null || cVar.h() <= -2) ? this.p.e() : this.D.h();
        if (this.D.k() == 5 && (i2 = this.I) > 1) {
            e3 = a(e3, i2);
            this.D.a(e3);
        }
        this.f.setVideoSkipTime(e3);
        this.f.setCloseAlert(this.p.k());
        this.f.setBufferTimeout(u());
        this.f.setNotifyListener(new com.anythink.expressad.video.module.a.a.n(this.K, this.D, this.r, this.E, b(), this.n, i3, e3, new com.anythink.expressad.video.bt.module.ATTempContainer.e(this, (byte) 0), this.p.M(), this.z, this.p.U()));
        this.f.setShowingTransparent(this.as);
        if (this.u && ((i = this.w) == com.anythink.expressad.foundation.g.a.cr || i == com.anythink.expressad.foundation.g.a.cs)) {
            this.f.setIVRewardEnable(i, this.x, this.y);
            this.f.setDialogRole(getJSCommon() != null ? getJSCommon().n() : 1);
        }
        this.g.setCampaign(this.D);
        this.g.addOrderViewData(this.V);
        this.g.setUnitID(this.n);
        this.g.setCloseDelayTime(this.D.g() > -2 ? this.D.g() : this.p.p());
        this.g.setPlayCloseBtnTm(this.p.j());
        this.g.setVideoInteractiveType(this.p.h());
        this.g.setEndscreenType(this.p.r());
        this.g.setVideoSkipTime(e3);
        this.g.setShowingTransparent(this.as);
        this.g.setJSFactory(this.K);
        if (this.D.J() == 2) {
            this.g.setNotifyListener(new com.anythink.expressad.video.module.a.a.h(this.D, this.E, this.r, b(), this.n, new com.anythink.expressad.video.bt.module.ATTempContainer.c(this, (byte) 0), this.p.M(), this.z));
            this.g.preLoadData(this.K);
            this.g.showPlayableView();
        } else {
            this.g.setNotifyListener(new com.anythink.expressad.video.module.a.a.c(this.K, this.D, this.r, this.E, b(), this.n, new com.anythink.expressad.video.bt.module.ATTempContainer.b(this.m, this.D), this.p.M(), this.z));
            this.g.preLoadData(this.K);
            this.f.preLoadData(this.K);
        }
        if (this.as) {
            this.g.setAnythinkClickMiniCardViewTransparent();
        }
    }

    public void notifyEvent(java.lang.String str) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.e;
        if (windVaneWebView != null) {
            java.lang.String str2 = this.J;
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, str, android.util.Base64.encodeToString(str2.getBytes(), 2));
        }
    }

    public void onBackPressed() {
        android.app.Activity activity;
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView;
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView2;
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView;
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView2;
        if (this.as && (anythinkVideoView2 = this.f) != null) {
            anythinkVideoView2.notifyVideoClose();
            return;
        }
        if (this.au && (anythinkVideoView = this.f) != null) {
            if (!anythinkVideoView.isMiniCardShowing()) {
                this.f.onBackPress();
                return;
            }
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView3 = this.g;
            if (anythinkContainerView3 != null) {
                anythinkContainerView3.onMiniEndcardBackPress();
                return;
            }
            return;
        }
        if (this.aw && (anythinkContainerView2 = this.g) != null) {
            anythinkContainerView2.onPlayableBackPress();
            return;
        }
        if (this.av && (anythinkContainerView = this.g) != null) {
            anythinkContainerView.onEndcardBackPress();
        }
        if (getJSCommon().g()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
                return;
            }
            return;
        }
        if (!canBackPress() || (activity = this.m) == null || this.z || this.ax) {
            return;
        }
        this.ax = true;
        activity.onBackPressed();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        android.view.ViewGroup viewGroup;
        java.util.List<com.anythink.expressad.foundation.d.c> list;
        if (this.p == null) {
            this.p = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.n, this.u);
        }
        this.ax = false;
        try {
            if (this.z) {
                com.anythink.expressad.foundation.d.c cVar = this.D;
                if (cVar == null || !cVar.j()) {
                    this.F = new com.anythink.expressad.video.bt.module.b.d(this.G, this.J);
                } else {
                    this.F = new com.anythink.expressad.video.bt.module.b.e(getContext(), this.u, this.p, this.D, this.F, b(), this.n);
                }
            } else {
                this.F = new com.anythink.expressad.video.bt.module.b.e(getContext(), this.u, this.p, this.D, this.F, b(), this.n);
            }
            registerErrorListener(new com.anythink.expressad.video.bt.module.b.f(this.F));
            a(this.p, this.D);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            android.view.View inflate = this.aa.inflate(layoutID, (android.view.ViewGroup) null);
            this.C = inflate;
            addView(inflate, new android.widget.RelativeLayout.LayoutParams(-1, -1));
            if (this.a) {
                setMatchParent();
            }
            this.e = findWindVaneWebView();
            com.anythink.expressad.video.module.AnythinkVideoView findAnythinkVideoView = findAnythinkVideoView();
            this.f = findAnythinkVideoView;
            findAnythinkVideoView.setVideoLayout(this.D);
            this.f.setIsIV(this.u);
            this.f.setUnitId(this.n);
            this.f.setCamPlayOrderCallback(this.H, this.V, this.I, this.W);
            this.f.setTempEventListener(this.k);
            if (this.z) {
                this.f.setNotchPadding(this.P, this.Q, this.R, this.S);
            }
            com.anythink.expressad.video.module.AnythinkContainerView findAnythinkContainerView = findAnythinkContainerView();
            this.g = findAnythinkContainerView;
            if (this.z) {
                findAnythinkContainerView.setNotchPadding(this.O, this.P, this.Q, this.R, this.S);
            }
            if (!((this.f == null || this.g == null || !initViews()) ? false : true)) {
                this.d.a(com.anythink.expressad.foundation.e.a.b);
                android.app.Activity activity = this.m;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            this.c = true;
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.e;
            this.K = new com.anythink.expressad.video.signal.factory.b(this.m, windVaneWebView, this.f, this.g, this.D, new com.anythink.expressad.video.bt.module.ATTempContainer.d(this, (byte) 0));
            com.anythink.expressad.foundation.d.c cVar2 = this.D;
            if (cVar2 != null && cVar2.k() == 5 && (list = this.V) != null) {
                this.K.a(list);
            }
            registerJsFactory(this.K);
            com.anythink.expressad.foundation.f.b.a().a(this.n + "_1", new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass5());
            if (windVaneWebView == null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) this.C.findViewById(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_templete_webview_parent", "id"));
            windVaneWebView.setApiManagerJSFactory(this.K);
            if (windVaneWebView.getParent() != null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            if (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                this.K.a((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject());
                getJSCommon().a(this.t);
                getJSCommon().a(this.n);
                getJSCommon().a(this.p);
                getJSCommon().a(new com.anythink.expressad.video.bt.module.ATTempContainer.d(this, (byte) 0));
                com.anythink.expressad.foundation.d.c cVar3 = this.D;
                if (cVar3 != null && (cVar3.H() || this.D.ay())) {
                    com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = new com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver(getContext());
                    this.ay = mraidVolumeChangeReceiver;
                    mraidVolumeChangeReceiver.registerReceiver();
                    this.ay.getCurrentVolume();
                    this.ay.setVolumeChangeListener(new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass6());
                }
                getJSContainerModule().readyStatus(((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r());
                j();
                ((com.anythink.expressad.video.signal.a.j) windVaneWebView.getObject()).r.c();
                if (this.z) {
                    getJSCommon().f(this.ak);
                    getJSCommon().e(this.al);
                }
            }
            if (getJSCommon().f() == 1 && (viewGroup = (android.view.ViewGroup) this.C.findViewById(com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_video_templete_webview_parent", "id"))) != null) {
                ((android.view.ViewGroup) this.C).removeView(viewGroup);
                ((android.view.ViewGroup) this.C).addView(viewGroup, 1);
            }
            viewGroup2.addView(windVaneWebView, new android.view.ViewGroup.LayoutParams(-1, -1));
        } catch (java.lang.Throwable th) {
            a("onCreate error".concat(java.lang.String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        com.anythink.expressad.foundation.d.c cVar;
        int i;
        if (this.N) {
            return;
        }
        boolean z = true;
        this.N = true;
        super.onDestroy();
        try {
            com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.f;
            if (anythinkVideoView != null) {
                anythinkVideoView.releasePlayer();
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.e;
            if (windVaneWebView != null) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.e.clearWebView();
                this.e.release();
            }
            if (this.G != null) {
                this.G = null;
            }
            this.h.removeCallbacks(this.i);
            this.h.removeCallbacks(this.j);
            getJSCommon().k();
            if (this.u) {
                com.anythink.expressad.d.b.a();
                com.anythink.expressad.d.b.c(this.n);
            }
            if (!this.ao) {
                try {
                    this.ao = true;
                    com.anythink.expressad.foundation.d.c cVar2 = this.D;
                    if (cVar2 != null && cVar2.J() == 2) {
                        this.ap = true;
                    }
                    com.anythink.expressad.video.bt.module.b.h hVar = this.F;
                    if (hVar != null) {
                        if (this.u && ((i = this.w) == com.anythink.expressad.foundation.g.a.cr || i == com.anythink.expressad.foundation.g.a.cs)) {
                            if (this.M != 1) {
                                z = false;
                            }
                            hVar.a(z, this.L);
                        }
                        if (!this.ap) {
                            this.r.a(0);
                        }
                        this.F.a(this.ap, this.r);
                    }
                    this.h.removeCallbacks(this.az);
                    if (((!this.u && !this.z) || ((cVar = this.D) != null && cVar.j())) && this.ap) {
                        com.anythink.expressad.video.module.b.a.a(this.D, this.r, this.n, this.q, this.U);
                    }
                    if (!this.z) {
                        if (this.u) {
                            com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.D);
                        } else {
                            com.anythink.expressad.videocommon.a.b(94, this.D);
                        }
                    }
                    com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
                    if (anythinkContainerView != null) {
                        anythinkContainerView.release();
                    }
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
            }
            com.anythink.expressad.atsignalcommon.mraid.MraidVolumeChangeReceiver mraidVolumeChangeReceiver = this.ay;
            if (mraidVolumeChangeReceiver != null) {
                mraidVolumeChangeReceiver.unregisterReceiver();
            }
            if (!this.z) {
                if (isLoadSuccess()) {
                    this.h.postDelayed(new com.anythink.expressad.video.bt.module.ATTempContainer.AnonymousClass4(), ad);
                } else {
                    android.app.Activity activity = this.m;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(this.J);
        } catch (java.lang.Throwable th2) {
            th2.getMessage();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.aq = true;
        try {
            getJSVideoModule().videoOperate(2);
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
            if (anythinkContainerView != null) {
                anythinkContainerView.setOnPause();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onResume() {
        android.app.Activity activity;
        super.onResume();
        int i = this.aj;
        java.lang.Runnable runnable = i == -3 ? this.i : i == -4 ? this.j : null;
        if (runnable != null) {
            runnable.run();
            this.aj = 0;
        }
        try {
            if (this.f != null && !i() && !this.f.isMiniCardShowing() && !com.anythink.expressad.foundation.f.b.c) {
                this.f.setCover(false);
            }
            com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
            if (anythinkContainerView != null) {
                anythinkContainerView.setOnResume();
            }
            if (this.aq && !i() && !com.anythink.expressad.foundation.f.b.c) {
                getJSVideoModule().videoOperate(1);
            }
            android.app.Activity activity2 = this.m;
            if (activity2 != null) {
                com.anythink.expressad.foundation.h.t.a(activity2.getWindow().getDecorView());
            }
            if (this.as && this.at && (activity = this.m) != null) {
                activity.finish();
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.f;
        if (anythinkVideoView != null) {
            anythinkVideoView.setCover(true);
        }
    }

    public void preload() {
    }

    public void receiveSuccess() {
        this.h.removeCallbacks(this.j);
        this.h.postDelayed(this.az, 250L);
    }

    public void registerErrorListener(com.anythink.expressad.video.bt.module.ATTempContainer.a aVar) {
        this.d = aVar;
    }

    public void setAnythinkTempCallback(com.anythink.expressad.video.bt.module.a.b bVar) {
        this.G = bVar;
    }

    public void setCamPlayOrderCallback(com.anythink.expressad.video.dynview.f.a aVar, int i) {
        this.H = aVar;
        this.I = i;
    }

    public void setCampOrderViewData(java.util.List<com.anythink.expressad.foundation.d.c> list, int i) {
        if (list != null) {
            this.V = list;
        }
        this.W = i;
    }

    public void setCampaign(com.anythink.expressad.foundation.d.c cVar) {
        this.D = cVar;
        if (cVar != null) {
            if (android.text.TextUtils.isEmpty(cVar.K()) && !android.text.TextUtils.isEmpty(this.n)) {
                cVar.l(this.n);
            }
            com.anythink.expressad.foundation.f.b.a().a(cVar.K() + "_1", cVar);
        }
    }

    public void setCampaignDownLoadTask(com.anythink.expressad.videocommon.b.c cVar) {
        this.E = cVar;
    }

    public void setCampaignExpired(boolean z) {
        try {
            com.anythink.expressad.foundation.d.c cVar = this.D;
            if (cVar != null) {
                if (!z) {
                    cVar.e(0);
                    if (this.D.A()) {
                        this.D.m(0);
                        return;
                    }
                    com.anythink.expressad.videocommon.e.d dVar = this.p;
                    if (dVar != null) {
                        this.D.m(dVar.a());
                        return;
                    }
                    return;
                }
                cVar.e(1);
                if (this.v) {
                    this.D.m(0);
                    return;
                }
                com.anythink.expressad.videocommon.e.d dVar2 = this.p;
                if (dVar2 != null) {
                    if (dVar2.M() == 1) {
                        this.D.m(1);
                    } else {
                        this.D.m(0);
                    }
                }
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
        }
    }

    public void setDeveloperExtraData(java.lang.String str) {
        this.U = str;
    }

    public void setH5Cbp(int i) {
        this.al = i;
    }

    public void setInstanceId(java.lang.String str) {
        this.J = str;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.K = bVar;
    }

    public void setMatchParent() {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setMediaPlayerUrl(java.lang.String str) {
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        this.O = i;
        this.P = i2;
        this.Q = i3;
        this.R = i4;
        this.S = i5;
        this.T = com.anythink.expressad.foundation.h.h.a(i, i2, i3, i4, i5);
        if (getJSCommon() != null && !android.text.TextUtils.isEmpty(this.T)) {
            getJSCommon().b(this.T);
            if (this.e != null && !android.text.TextUtils.isEmpty(this.T)) {
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.e, "oncutoutfetched", android.util.Base64.encodeToString(this.T.getBytes(), 0));
            }
        }
        com.anythink.expressad.video.module.AnythinkVideoView anythinkVideoView = this.f;
        if (anythinkVideoView != null) {
            anythinkVideoView.setNotchPadding(i2, i3, i4, i5);
        }
        com.anythink.expressad.video.module.AnythinkContainerView anythinkContainerView = this.g;
        if (anythinkContainerView != null) {
            anythinkContainerView.setNotchPadding(i, i2, i3, i4, i5);
        }
    }

    public void setShowRewardListener(com.anythink.expressad.video.bt.module.b.h hVar) {
        this.F = hVar;
    }

    public void setShowingTransparent() {
        int a2;
        android.app.Activity activity;
        boolean h = h();
        this.as = h;
        if (h || (a2 = com.anythink.expressad.foundation.h.i.a(getContext(), "anythink_reward_theme", com.anythink.expressad.foundation.h.i.e)) <= 1 || (activity = this.m) == null) {
            return;
        }
        activity.setTheme(a2);
    }

    public void setTempEventListener(com.anythink.expressad.reward.player.c cVar) {
        this.k = cVar;
    }

    public void setWebViewFront(int i) {
        this.ak = i;
    }

    public void superDefaultLoad(int i, java.lang.String str) {
        this.h.removeCallbacks(this.i);
        this.h.removeCallbacks(this.j);
        this.d.b();
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.e;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }
}
