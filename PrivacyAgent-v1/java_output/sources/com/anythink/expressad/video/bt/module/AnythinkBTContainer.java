package com.anythink.expressad.video.bt.module;

/* loaded from: classes12.dex */
public class AnythinkBTContainer extends com.anythink.expressad.video.signal.container.AbstractJSContainer implements com.anythink.expressad.video.signal.b {
    private static final java.lang.String d = "AnythinkBTContainer";
    private android.widget.TextView B;
    private boolean C;
    private boolean D;
    private java.lang.String E;
    private boolean F;
    private java.util.List<com.anythink.expressad.foundation.d.c> G;
    private java.util.List<com.anythink.expressad.videocommon.b.c> H;
    private com.anythink.expressad.video.bt.module.a.a I;
    private com.anythink.expressad.video.bt.module.b.h J;
    private com.anythink.expressad.video.bt.module.b.h K;
    private com.anythink.expressad.video.bt.module.a.b L;
    private java.lang.String M;
    private java.lang.String N;
    private boolean O;
    private int P;
    private boolean Q;
    private int R;
    private java.lang.String S;
    private com.anythink.expressad.video.dynview.f.d T;
    com.anythink.expressad.foundation.d.c a;
    private int e;
    private int f;
    private android.widget.FrameLayout g;
    private com.anythink.expressad.video.bt.module.AnythinkBTLayout h;
    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView i;
    private android.view.LayoutInflater j;
    private android.content.Context k;

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTContainer$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.f.a {
        public AnonymousClass1() {
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
                java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
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
                java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
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
                java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                th.getMessage();
                str = "";
            }
            java.lang.String encodeToString = android.util.Base64.encodeToString(str.getBytes(), 2);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, com.anythink.expressad.atsignalcommon.windvane.AbsFeedBackForH5.a, encodeToString);
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTContainer$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.video.dynview.f.h {
        public AnonymousClass2() {
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.a aVar) {
            com.anythink.expressad.foundation.d.c cVar;
            java.lang.String str;
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.g == null || aVar.a() == null) {
                com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.a("nativeview is null");
                return;
            }
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.g.removeAllViews();
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.g.addView(aVar.a());
            com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = com.anythink.expressad.video.bt.module.AnythinkBTContainer.this;
            anythinkBTContainer.B = (android.widget.TextView) anythinkBTContainer.findViewById(anythinkBTContainer.findID("anythink_choice_one_countdown_tv"));
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.I != null) {
                com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.I.a();
            }
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.G == null || com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.G.size() <= 0 || (cVar = (com.anythink.expressad.foundation.d.c) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.G.get(0)) == null) {
                return;
            }
            java.lang.String ai = cVar.ai();
            com.anythink.expressad.videocommon.e.d a = com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n);
            int M = a != null ? a.M() : 1;
            if (cVar.n() == 1) {
                str = ai + "&to=1&cbt=" + cVar.az() + "&tmorl=" + M;
            } else {
                str = ai + "&to=0&cbt=" + cVar.az() + "&tmorl=" + M;
            }
            com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), cVar, ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n, str, false, true, com.anythink.expressad.a.a.a.j);
            com.anythink.expressad.foundation.g.a.f.h.put(cVar.ai(), java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.a(cVar);
        }

        @Override // com.anythink.expressad.video.dynview.f.h
        public final void a(com.anythink.expressad.video.dynview.c.b bVar) {
            java.lang.String str;
            if (bVar != null) {
                str = "errorCode:" + bVar.a() + "Msg:" + bVar.b();
            } else {
                str = "";
            }
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.a("nativeview is null".concat(java.lang.String.valueOf(str)));
        }
    }

    /* renamed from: com.anythink.expressad.video.bt.module.AnythinkBTContainer$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.expressad.video.bt.module.a.b {
        public AnonymousClass3() {
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void a() {
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void a(java.lang.String str) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.anythink.expressad.a.y, ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).o);
                    jSONObject2.put("unitId", ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n);
                    jSONObject.put("data", jSONObject2);
                    java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    java.lang.String unused2 = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewPlayStart", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
            com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer = com.anythink.expressad.video.bt.module.AnythinkBTContainer.this;
            anythinkBTContainer.a = cVar;
            if (anythinkBTContainer.i != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.anythink.expressad.a.y, ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).o);
                    jSONObject2.put("unitId", ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n);
                    jSONObject.put("data", jSONObject2);
                    java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    java.lang.String unused2 = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void a(java.lang.String str, java.lang.String str2) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.anythink.expressad.a.y, ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).o);
                    jSONObject2.put("unitId", ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n);
                    jSONObject2.put("error", str2);
                    jSONObject.put("data", jSONObject2);
                    java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    java.lang.String unused2 = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewPlayFailed", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void a(java.lang.String str, boolean z, com.anythink.expressad.videocommon.c.c cVar) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    if (cVar != null) {
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        jSONObject3.put("name", cVar.a());
                        jSONObject3.put("amount", cVar.b());
                        jSONObject2.put("reward", jSONObject3);
                    }
                    jSONObject2.put("isComplete", z);
                    jSONObject2.put("convert", z ? 1 : 2);
                    jSONObject.put("data", jSONObject2);
                    java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    java.lang.String unused2 = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewCloseBtnClicked", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewDismissed", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void a(boolean z, int i) {
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.Q = z;
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.R = i;
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void b(java.lang.String str) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("convert", true);
                    jSONObject2.put(com.anythink.expressad.a.y, ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).o);
                    jSONObject2.put("unitId", ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n);
                    jSONObject.put("data", jSONObject2);
                    java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    java.lang.String unused2 = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewPlayCompleted", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }

        @Override // com.anythink.expressad.video.bt.module.a.b
        public final void c(java.lang.String str) {
            if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.anythink.expressad.a.y, ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).o);
                    jSONObject2.put("unitId", ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).n);
                    jSONObject.put("data", jSONObject2);
                    java.lang.String unused = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    jSONObject.toString();
                } catch (org.json.JSONException e) {
                    java.lang.String unused2 = com.anythink.expressad.video.bt.module.AnythinkBTContainer.d;
                    e.getMessage();
                }
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.i, "onSubPlayTemplateViewEndcardShowSuccess", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        }
    }

    public class a extends com.anythink.expressad.video.signal.a.c.a {
        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer, byte b) {
            this();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(int i, java.lang.String str) {
            super.a(i, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
            super.a(cVar, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void a(com.anythink.expressad.foundation.d.c cVar, boolean z) {
            super.a(cVar, z);
            com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.K.a(cVar);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void a(com.anythink.expressad.out.j jVar, java.lang.String str) {
            super.a(jVar, str);
            if (jVar == null || !(jVar instanceof com.anythink.expressad.foundation.d.c)) {
                return;
            }
            try {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) jVar;
                java.lang.String optString = new org.json.JSONObject(com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.getJSVideoModule().getCurrentProgress()).optString(androidx.core.app.NotificationCompat.CATEGORY_PROGRESS, "");
                if (cVar.Q() == 3 && cVar.C() == 2 && optString.equals("1.0") && ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).m != null) {
                    if (com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.D) {
                        com.anythink.expressad.video.bt.module.AnythinkBTContainer.this.onAdClose();
                    } else {
                        ((com.anythink.expressad.video.signal.container.AbstractJSContainer) com.anythink.expressad.video.bt.module.AnythinkBTContainer.this).m.finish();
                    }
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.out.p.c
        public final void b(com.anythink.expressad.out.j jVar, java.lang.String str) {
            super.b(jVar, str);
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void c() {
            super.c();
        }

        @Override // com.anythink.expressad.video.signal.a.c.a, com.anythink.expressad.video.signal.c.a
        public final void d() {
            super.d();
        }
    }

    public AnythinkBTContainer(android.content.Context context) {
        super(context);
        this.e = 0;
        this.f = 1;
        this.C = false;
        this.D = true;
        this.F = false;
        this.P = 1;
        init(context);
    }

    public AnythinkBTContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.f = 1;
        this.C = false;
        this.D = true;
        this.F = false;
        this.P = 1;
        init(context);
    }

    private void a(android.content.Context context) {
        if (this.T == null) {
            a("ChoiceOneCallback is null");
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.anythink.expressad.video.dynview.a.a.D, this.T);
        com.anythink.expressad.video.dynview.b.a();
        com.anythink.expressad.video.dynview.b.a(context, this.G, new com.anythink.expressad.video.bt.module.AnythinkBTContainer.AnonymousClass2(), hashMap);
    }

    private boolean a(boolean z) {
        com.anythink.expressad.videocommon.e.d dVar;
        try {
            dVar = this.p;
        } catch (java.lang.Throwable unused) {
        }
        if (dVar == null) {
            return false;
        }
        int K = dVar.K();
        if (K == 1) {
            return z;
        }
        if (K == 2) {
            return z && g();
        }
        if (K != 3) {
            return false;
        }
        return g();
    }

    private com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView b(java.lang.String str) {
        com.anythink.expressad.videocommon.a.C0231a a2 = com.anythink.expressad.videocommon.a.a(str);
        if (a2 == null) {
            return null;
        }
        this.E = a2.b();
        a2.a("");
        return a2.a();
    }

    private com.anythink.expressad.video.bt.module.a.b c() {
        if (this.L == null) {
            this.L = new com.anythink.expressad.video.bt.module.AnythinkBTContainer.AnonymousClass3();
        }
        return this.L;
    }

    private com.anythink.expressad.videocommon.b.c d(com.anythink.expressad.foundation.d.c cVar) {
        java.util.List<com.anythink.expressad.videocommon.b.c> list = this.H;
        if (list == null || cVar == null) {
            return null;
        }
        for (com.anythink.expressad.videocommon.b.c cVar2 : list) {
            if (cVar2.n().aZ().equals(cVar.aZ())) {
                return cVar2;
            }
        }
        return null;
    }

    private static void d() {
    }

    private static boolean e() {
        return true;
    }

    private static int f() {
        return 1;
    }

    private boolean g() {
        try {
            com.anythink.expressad.videocommon.e.d dVar = this.p;
            if (dVar == null) {
                return false;
            }
            double L = dVar.L();
            if (L == 1.0d) {
                return false;
            }
            return new java.util.Random().nextDouble() > L;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                java.util.List<java.lang.String> e = cVar.e();
                if (e == null || e.size() <= 0) {
                    return;
                }
                java.util.Iterator<java.lang.String> it = e.iterator();
                while (it.hasNext()) {
                    com.anythink.expressad.a.a.a(com.anythink.core.common.b.o.a().f(), cVar, this.n, it.next(), true);
                }
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public final void a(java.lang.String str) {
        com.anythink.expressad.video.bt.module.b.h hVar = this.J;
        if (hVar != null) {
            hVar.a(str);
        }
        super.a(str);
    }

    public void appendSubView(com.anythink.expressad.video.bt.module.AnythinkBTContainer anythinkBTContainer, com.anythink.expressad.video.bt.module.ATTempContainer aTTempContainer, org.json.JSONObject jSONObject) {
        try {
            android.widget.FrameLayout.LayoutParams layoutParams = new android.widget.FrameLayout.LayoutParams(-1, -1);
            if (jSONObject != null) {
                android.content.Context f = com.anythink.core.common.b.o.a().f();
                int optInt = jSONObject.optInt(com.sensorsdata.sf.ui.view.UIProperty.left, com.anythink.expressad.video.bt.a.c.a);
                int optInt2 = jSONObject.optInt(com.sensorsdata.sf.ui.view.UIProperty.top, com.anythink.expressad.video.bt.a.c.a);
                int optInt3 = jSONObject.optInt(com.sensorsdata.sf.ui.view.UIProperty.right, com.anythink.expressad.video.bt.a.c.a);
                int optInt4 = jSONObject.optInt(com.sensorsdata.sf.ui.view.UIProperty.bottom, com.anythink.expressad.video.bt.a.c.a);
                if (optInt != -999 && f != null) {
                    layoutParams.leftMargin = com.anythink.expressad.foundation.h.t.b(f, optInt);
                }
                if (optInt2 != -999 && f != null) {
                    layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(f, optInt2);
                }
                if (optInt3 != -999 && f != null) {
                    layoutParams.rightMargin = com.anythink.expressad.foundation.h.t.b(f, optInt3);
                }
                if (optInt4 != -999 && f != null) {
                    layoutParams.bottomMargin = com.anythink.expressad.foundation.h.t.b(f, optInt4);
                }
                int optInt5 = jSONObject.optInt("width");
                int optInt6 = jSONObject.optInt("height");
                if (optInt5 > 0) {
                    layoutParams.width = optInt5;
                }
                if (optInt6 > 0) {
                    layoutParams.height = optInt6;
                }
            }
            anythinkBTContainer.addView(aTTempContainer, layoutParams);
            aTTempContainer.setActivity(this.m);
            aTTempContainer.setMute(this.t);
            aTTempContainer.setBidCampaign(this.C);
            aTTempContainer.setIV(this.u);
            aTTempContainer.setBigOffer(this.D);
            aTTempContainer.setIVRewardEnable(this.w, this.x, this.y);
            aTTempContainer.setShowRewardListener(this.K);
            aTTempContainer.setCampaignDownLoadTask(d(aTTempContainer.getCampaign()));
            aTTempContainer.setAnythinkTempCallback(c());
            aTTempContainer.setH5Cbp(getJSCommon().e());
            aTTempContainer.setWebViewFront(getJSCommon().f());
            aTTempContainer.init(this.k);
            aTTempContainer.onCreate();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void broadcast(java.lang.String str, org.json.JSONObject jSONObject) {
        if (this.i != null) {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put("code", this.e);
                jSONObject2.put("id", this.E);
                jSONObject2.put("eventName", str);
                jSONObject2.put("data", jSONObject);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.i, "broadcast", android.util.Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            } catch (java.lang.Exception unused) {
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a((android.webkit.WebView) this.i, "broadcast", this.E);
            }
        }
    }

    @Override // com.anythink.expressad.video.signal.d
    public void click(int i, java.lang.String str) {
    }

    public int findID(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(getContext(), str, "id");
    }

    public int findLayout(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(getContext(), str, "layout");
    }

    @Override // com.anythink.expressad.video.signal.d
    public void handlerH5Exception(int i, java.lang.String str) {
    }

    public void init(android.content.Context context) {
        this.k = context;
        this.j = android.view.LayoutInflater.from(context);
    }

    public boolean isNativeKilledCallback(com.anythink.expressad.foundation.d.c cVar) {
        if (getJSCommon().e() != 1 && cVar != null) {
            if (cVar.n() == 1) {
                com.anythink.expressad.videocommon.e.d dVar = this.p;
                if (dVar != null) {
                    if (dVar.M() == 1) {
                        cVar.m(1);
                        return true;
                    }
                    cVar.m(0);
                    return false;
                }
            } else {
                if (cVar.A()) {
                    cVar.m(0);
                    return false;
                }
                int a2 = this.p.a();
                cVar.m(a2);
                if (a2 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onAdClose() {
        android.app.Activity activity = this.m;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onBackPressed() {
        try {
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (android.view.View view : b.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).onBackPressed();
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).onBackPressed();
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTLayout) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTLayout) view).onBackPressed();
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        try {
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (android.view.View view : b.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).onConfigurationChanged(configuration);
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTWebView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTWebView) view).onConfigurationChanged(configuration);
                } else if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTLayout) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTLayout) view).onConfigurationChanged(configuration);
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void onCreate() {
        java.lang.String str;
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView;
        com.anythink.expressad.foundation.d.c cVar;
        try {
            int findLayout = findLayout("anythink_bt_container");
            if (findLayout < 0) {
                a("anythink_bt_container layout null");
                return;
            }
            android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.j.inflate(findLayout, this);
            this.g = frameLayout;
            if (frameLayout == null) {
                a("ViewIds null");
                return;
            }
            this.N = "";
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.G;
            if (list == null || list.size() <= 0) {
                str = "";
            } else {
                com.anythink.expressad.foundation.d.c cVar2 = this.G.get(0);
                str = cVar2.ar();
                this.N = cVar2.Z();
            }
            com.anythink.expressad.videocommon.a.C0231a a2 = com.anythink.expressad.videocommon.a.a(this.n + "_" + this.N + "_" + str);
            android.widget.RelativeLayout.LayoutParams layoutParams = null;
            if (a2 != null) {
                this.E = a2.b();
                a2.a("");
                windVaneWebView = a2.a();
            } else {
                windVaneWebView = null;
            }
            this.i = windVaneWebView;
            com.anythink.expressad.videocommon.a.b(this.n + "_" + this.N + "_" + str);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.i;
            if (windVaneWebView2 == null) {
                java.util.List<com.anythink.expressad.foundation.d.c> list2 = this.G;
                if (list2 == null || list2.size() <= 0 || (cVar = this.G.get(0)) == null || !cVar.j()) {
                    a("big template webview is null");
                    return;
                }
                android.content.Context context = this.k;
                if (this.T == null) {
                    a("ChoiceOneCallback is null");
                    return;
                }
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put(com.anythink.expressad.video.dynview.a.a.D, this.T);
                com.anythink.expressad.video.dynview.b.a();
                com.anythink.expressad.video.dynview.b.a(context, this.G, new com.anythink.expressad.video.bt.module.AnythinkBTContainer.AnonymousClass2(), hashMap);
                return;
            }
            com.anythink.expressad.video.signal.factory.b bVar = new com.anythink.expressad.video.signal.factory.b(this.m, this, windVaneWebView2);
            registerJsFactory(bVar);
            this.i.setApiManagerJSFactory(bVar);
            if (this.i.getParent() != null) {
                a("preload template webview is null or load error");
                return;
            }
            if (this.i.getObject() instanceof com.anythink.expressad.video.signal.a.j) {
                bVar.a((com.anythink.expressad.video.signal.a.j) this.i.getObject());
                if (this.i != null) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    jSONObject.put(com.anythink.expressad.foundation.g.a.ch, com.anythink.expressad.foundation.h.t.c(getContext()));
                    try {
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        jSONObject2.put("name", this.r.a());
                        jSONObject2.put("amount", this.r.b());
                        jSONObject2.put("id", this.f281s);
                        jSONObject.put("userId", this.q);
                        jSONObject.put("reward", jSONObject2);
                        jSONObject.put("playVideoMute", this.t);
                        jSONObject.put("extra", this.S);
                    } catch (org.json.JSONException e) {
                        e.getMessage();
                    } catch (java.lang.Exception e2) {
                        e2.getMessage();
                    }
                    this.K = new com.anythink.expressad.video.bt.module.b.d(c(), "");
                    getJSNotifyProxy().a(jSONObject.toString());
                    getJSCommon().h();
                    getJSCommon().a(new com.anythink.expressad.video.bt.module.AnythinkBTContainer.a(this, (byte) 0));
                }
                ((com.anythink.expressad.video.signal.a.c) getJSCommon()).r.c();
            }
            this.i.setBackgroundColor(0);
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || !b.containsKey(this.E)) {
                a("big template webviewLayout is null");
                return;
            }
            android.view.View view = b.get(this.E);
            if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTLayout) {
                com.anythink.expressad.video.bt.module.AnythinkBTLayout anythinkBTLayout = (com.anythink.expressad.video.bt.module.AnythinkBTLayout) view;
                this.h = anythinkBTLayout;
                anythinkBTLayout.addView(this.i, 0, new android.widget.FrameLayout.LayoutParams(-1, -1));
                com.anythink.expressad.foundation.f.b.a().a(this.n + "_1", new com.anythink.expressad.video.bt.module.AnythinkBTContainer.AnonymousClass1());
                com.anythink.expressad.foundation.f.b.a().c(this.n + "_2");
                android.view.View b2 = com.anythink.expressad.foundation.f.b.a().b(this.n + "_1");
                if (com.anythink.expressad.foundation.f.b.a().b() && b2 != null) {
                    try {
                        layoutParams = (android.widget.RelativeLayout.LayoutParams) b2.getLayoutParams();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                    if (layoutParams == null) {
                        layoutParams = new android.widget.RelativeLayout.LayoutParams(com.anythink.expressad.foundation.f.b.a, com.anythink.expressad.foundation.f.b.b);
                    }
                    layoutParams.topMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
                    layoutParams.leftMargin = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
                    b2.setLayoutParams(layoutParams);
                    android.view.ViewGroup viewGroup = (android.view.ViewGroup) b2.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(b2);
                    }
                    this.h.addView(b2);
                }
                this.h.setTag(this.E);
                b.put(this.E, this.h);
                java.util.Iterator<android.view.View> it = b.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    android.view.View next = it.next();
                    if (next instanceof com.anythink.expressad.video.bt.module.AnythinkBTRootLayout) {
                        com.anythink.expressad.video.bt.module.AnythinkBTRootLayout anythinkBTRootLayout = (com.anythink.expressad.video.bt.module.AnythinkBTRootLayout) next;
                        this.M = anythinkBTRootLayout.getInstanceId();
                        this.g.addView(anythinkBTRootLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
                        break;
                    }
                }
                b.remove(this.M);
                b.put(this.M, this);
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.n, this.t);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.E, this.N);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.M, this.N);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(this.n + "_" + this.N, this.m);
            java.util.List<com.anythink.expressad.foundation.d.c> list3 = this.G;
            if (list3 == null || list3.size() <= 0) {
                return;
            }
            a(this.p, this.G.get(0));
        } catch (java.lang.Throwable th) {
            a("onCreate exception ".concat(java.lang.String.valueOf(th)));
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        if (this.F) {
            return;
        }
        this.F = true;
        super.onDestroy();
        com.anythink.expressad.video.bt.a.c.a();
        com.anythink.expressad.video.bt.a.c.d(this.n + "_" + this.N);
        try {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.i;
            if (windVaneWebView != null) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.i.clearWebView();
                this.i.release();
            }
            if (this.L != null) {
                this.L = null;
            }
            if (this.I != null) {
                this.I = null;
            }
            if (this.k != null) {
                this.k = null;
            }
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.G;
            if (list != null && list.size() > 0) {
                for (com.anythink.expressad.foundation.d.c cVar : this.G) {
                    if (cVar != null && cVar.M() != null) {
                        com.anythink.expressad.videocommon.a.b(this.n + "_" + cVar.Z() + "_" + cVar.M().e());
                    }
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.f(this.E);
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.g(this.n);
            com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N).remove(this.E);
            com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N).remove(this.M);
            com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N).clear();
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onPause() {
        com.anythink.expressad.foundation.d.c cVar;
        super.onPause();
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j()) {
            com.anythink.expressad.video.dynview.b.a.a();
        }
        try {
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (android.view.View view : b.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).onPause();
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onResume() {
        com.anythink.expressad.foundation.d.c cVar;
        com.anythink.expressad.video.dynview.e.a aVar;
        super.onResume();
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j() && (aVar = com.anythink.expressad.video.dynview.b.a.a().a) != null) {
            aVar.a();
        }
        if (com.anythink.expressad.foundation.f.b.c) {
            return;
        }
        try {
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (android.view.View view : b.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).onResume();
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.container.AbstractJSContainer
    public void onStop() {
        com.anythink.expressad.foundation.d.c cVar;
        com.anythink.expressad.video.dynview.e.a aVar;
        super.onStop();
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.G;
        if (list != null && list.size() > 0 && (cVar = this.G.get(0)) != null && cVar.j() && (aVar = com.anythink.expressad.video.dynview.b.a.a().a) != null) {
            aVar.c();
        }
        try {
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (android.view.View view : b.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).onStop();
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.anythink.expressad.video.signal.b
    public void reactDeveloper(java.lang.Object obj, java.lang.String str) {
        int i;
        if (this.I == null || android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.video.signal.container.AbstractJSContainer.a(obj, "listener is null");
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("hit");
            java.lang.String optString = jSONObject.optString("unitId", getUnitId());
            jSONObject.optString(com.anythink.expressad.a.y, getPlacementId());
            org.json.JSONObject optJSONObject = jSONObject.optJSONObject("data");
            com.anythink.expressad.foundation.d.c cVar = this.G.get(0);
            boolean z = true;
            if (optInt == 1) {
                boolean optBoolean = optJSONObject.optBoolean("expired");
                if (cVar != null) {
                    if (optBoolean) {
                        cVar.e(1);
                    } else {
                        cVar.e(0);
                    }
                }
                this.O = isNativeKilledCallback(cVar);
            }
            switch (optInt) {
                case 1:
                    this.I.a();
                    break;
                case 2:
                    org.json.JSONObject optJSONObject2 = optJSONObject.optJSONObject("error");
                    java.lang.String optString2 = optJSONObject2 != null ? optJSONObject2.optString("msg") : "";
                    if (android.text.TextUtils.isEmpty(optString2)) {
                        optString2 = optJSONObject.optString("error");
                    }
                    if (!this.O && optInt2 != this.P) {
                        this.I.a(optString2);
                        break;
                    }
                    break;
                case 3:
                    this.I.b();
                    break;
                case 4:
                    this.I.c();
                    break;
                case 5:
                    com.anythink.expressad.video.bt.module.a.a aVar = this.I;
                    com.anythink.expressad.foundation.d.c cVar2 = this.a;
                    if (cVar2 != null) {
                        cVar = cVar2;
                    }
                    aVar.a(cVar);
                    break;
                case 6:
                    if (optJSONObject.optInt("convert") != 1) {
                        z = false;
                    }
                    org.json.JSONObject optJSONObject3 = optJSONObject.optJSONObject("reward");
                    com.anythink.expressad.foundation.d.c b = com.anythink.expressad.foundation.d.c.b(optJSONObject.optJSONObject("campaign"));
                    com.anythink.expressad.videocommon.c.c a2 = com.anythink.expressad.videocommon.c.c.a(optJSONObject3);
                    if (a2 == null) {
                        a2 = this.r;
                    }
                    java.lang.String optString3 = optJSONObject.optString("extra");
                    if (!android.text.TextUtils.isEmpty(optString3)) {
                        this.S = optString3;
                    }
                    if (!this.O && optInt2 != this.P) {
                        if (this.u && ((i = this.w) == com.anythink.expressad.foundation.g.a.cr || i == com.anythink.expressad.foundation.g.a.cs)) {
                            this.I.a(this.Q, this.R);
                        }
                        if (!z) {
                            a2.a(0);
                        }
                        this.I.a(z, a2);
                        if (!this.u && z) {
                            if (b == null) {
                                com.anythink.expressad.video.module.b.a.a(cVar, a2, optString, this.q, this.S);
                                break;
                            } else {
                                com.anythink.expressad.video.module.b.a.a(b, a2, optString, this.q, this.S);
                                break;
                            }
                        }
                    }
                    break;
            }
            a(obj);
        } catch (org.json.JSONException e) {
            com.anythink.expressad.video.signal.container.AbstractJSContainer.a(obj, e.getMessage());
            e.getMessage();
        }
    }

    public void setBTContainerCallback(com.anythink.expressad.video.bt.module.a.a aVar) {
        this.I = aVar;
    }

    public void setCampaignDownLoadTasks(java.util.List<com.anythink.expressad.videocommon.b.c> list) {
        this.H = list;
    }

    public void setCampaigns(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.G = list;
    }

    public void setChoiceOneCallback(com.anythink.expressad.video.dynview.f.d dVar) {
        this.T = dVar;
    }

    public void setDeveloperExtraData(java.lang.String str) {
        this.S = str;
    }

    public void setJSFactory(com.anythink.expressad.video.signal.factory.b bVar) {
        this.A = bVar;
    }

    public void setNotchPadding(int i, int i2, int i3, int i4, int i5) {
        android.widget.TextView textView;
        try {
            java.lang.String a2 = com.anythink.expressad.foundation.h.h.a(i, i2, i3, i4, i5);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.i;
            if (windVaneWebView != null && (windVaneWebView.getObject() instanceof com.anythink.expressad.video.signal.a.j) && !android.text.TextUtils.isEmpty(a2)) {
                ((com.anythink.expressad.video.signal.a.j) this.i.getObject()).b(a2);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.i, "oncutoutfetched", android.util.Base64.encodeToString(a2.getBytes(), 0));
            }
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.G;
            if (list != null && list.size() > 0) {
                try {
                    if (this.G.get(0).j() && (textView = this.B) != null) {
                        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) textView.getLayoutParams();
                        layoutParams.setMargins(i2, i4, i3, i5);
                        this.B.setLayoutParams(layoutParams);
                    }
                } catch (java.lang.Exception e) {
                    e.getMessage();
                }
            }
            com.anythink.expressad.video.bt.a.c.a();
            com.anythink.expressad.video.bt.a.c.a(i, i2, i3, i4, i5);
            java.util.LinkedHashMap<java.lang.String, android.view.View> b = com.anythink.expressad.video.bt.a.c.a().b(this.n, this.N);
            if (b == null || b.size() <= 0) {
                return;
            }
            for (android.view.View view : b.values()) {
                if (view instanceof com.anythink.expressad.video.bt.module.AnythinkBTVideoView) {
                    ((com.anythink.expressad.video.bt.module.AnythinkBTVideoView) view).setNotchPadding(i2, i3, i4, i5);
                }
                if (view instanceof com.anythink.expressad.video.bt.module.ATTempContainer) {
                    ((com.anythink.expressad.video.bt.module.ATTempContainer) view).setNotchPadding(i, i2, i3, i4, i5);
                }
                if ((view instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) && !android.text.TextUtils.isEmpty(a2)) {
                    com.anythink.expressad.atsignalcommon.windvane.j.a().a(view, "oncutoutfetched", android.util.Base64.encodeToString(a2.getBytes(), 0));
                }
            }
        } catch (java.lang.Throwable th) {
            th.getMessage();
        }
    }

    public void setShowRewardVideoListener(com.anythink.expressad.video.bt.module.b.h hVar) {
        this.J = hVar;
    }
}
