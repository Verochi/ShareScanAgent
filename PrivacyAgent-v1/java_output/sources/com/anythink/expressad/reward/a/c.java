package com.anythink.expressad.reward.a;

/* loaded from: classes12.dex */
public final class c {
    private static final java.lang.String a = "RewardCampaignsResourceManager";
    private static java.util.Map<java.lang.String, com.anythink.expressad.reward.a.c.a> d = null;
    private static final int f = 100;
    private static final int g = 200;
    private static final int h = 101;
    private static final int i = 201;
    private static final int j = 102;
    private static final int k = 202;
    private static final int l = 103;
    private static final int m = 203;
    private static final int n = 104;
    private static final int o = 204;
    private static final int p = 105;
    private static final int q = 205;
    private static final int r = 0;

    /* renamed from: s, reason: collision with root package name */
    private static final int f252s = 1;
    private final com.anythink.expressad.reward.a.c.h b;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.anythink.expressad.foundation.d.c>> c;
    private boolean e;
    private volatile java.util.List<com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView> t;

    /* renamed from: com.anythink.expressad.reward.a.c$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.CopyOnWriteArrayList a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ int d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ java.lang.String f;
        final /* synthetic */ com.anythink.expressad.reward.a.c.i g;

        public AnonymousClass1(java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList, android.content.Context context, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, com.anythink.expressad.reward.a.c.i iVar) {
            this.a = copyOnWriteArrayList;
            this.b = context;
            this.c = str;
            this.d = i;
            this.e = str2;
            this.f = str3;
            this.g = iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:116:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x019f  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            java.util.Iterator it;
            boolean j;
            java.lang.String bd;
            java.lang.String be;
            java.util.List<java.lang.String> list;
            java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = this.a;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                return;
            }
            try {
                com.anythink.expressad.videocommon.b.l.a().a(this.a);
                com.anythink.expressad.videocommon.b.e.a().a(this.c, this.a, this.d, new com.anythink.expressad.reward.a.c.f(com.anythink.expressad.reward.a.c.this.b, this.e, this.c, this.f));
                com.anythink.expressad.videocommon.b.e.a().d(this.c);
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.getLocalizedMessage();
                }
            }
            java.util.Iterator it2 = this.a.iterator();
            while (it2.hasNext()) {
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) it2.next();
                if (cVar != null) {
                    com.anythink.expressad.foundation.d.c.C0208c M = cVar.M();
                    if (M != null && !cVar.j()) {
                        java.lang.String e2 = M.e();
                        if (!android.text.TextUtils.isEmpty(e2) && !e2.contains(com.anythink.expressad.foundation.d.c.d)) {
                            if (e2.contains(".zip")) {
                                try {
                                    it = it2;
                                } catch (java.lang.Exception e3) {
                                    e = e3;
                                    it = it2;
                                }
                                try {
                                    com.anythink.expressad.videocommon.b.i.a().b(e2, (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.c.g(this.b, this.e, this.c, this.f, cVar, 859, com.anythink.expressad.reward.a.c.this.b, this.g, this.a));
                                } catch (java.lang.Exception e4) {
                                    e = e4;
                                    if (com.anythink.expressad.a.a) {
                                        e.getLocalizedMessage();
                                    }
                                    java.lang.String I = cVar.I();
                                    j = cVar.j();
                                    boolean f = com.anythink.expressad.foundation.h.t.f(I);
                                    if (!j) {
                                    }
                                    if (!android.text.TextUtils.isEmpty(cVar.P())) {
                                    }
                                    bd = cVar.bd();
                                    if (!android.text.TextUtils.isEmpty(bd)) {
                                    }
                                    be = cVar.be();
                                    if (!android.text.TextUtils.isEmpty(be)) {
                                    }
                                    if (M != null) {
                                    }
                                    it2 = it;
                                }
                            } else {
                                it = it2;
                                try {
                                    com.anythink.expressad.videocommon.b.i.a().b(e2, new com.anythink.expressad.reward.a.c.d(859, this.e, this.c, this.f, cVar, this.g, com.anythink.expressad.reward.a.c.this.b, this.a));
                                } catch (java.lang.Exception e5) {
                                    if (com.anythink.expressad.a.a) {
                                        e5.getLocalizedMessage();
                                    }
                                }
                            }
                            java.lang.String I2 = cVar.I();
                            j = cVar.j();
                            boolean f2 = com.anythink.expressad.foundation.h.t.f(I2);
                            if (!j) {
                                com.anythink.expressad.reward.a.c.a(com.anythink.expressad.reward.a.c.this, this.b, this.e, this.c, this.f, cVar, I2, this.g, this.a);
                            } else if (f2) {
                                com.anythink.expressad.reward.a.c.a(com.anythink.expressad.reward.a.c.this, this.b, this.e, this.c, this.f, cVar, I2, this.g, this.a);
                            }
                            if (!android.text.TextUtils.isEmpty(cVar.P()) && !cVar.j()) {
                                com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
                            }
                            bd = cVar.bd();
                            if (!android.text.TextUtils.isEmpty(bd)) {
                                try {
                                    com.anythink.expressad.foundation.g.d.b.a(this.b).a(bd, new com.anythink.expressad.reward.a.c.e(com.anythink.expressad.reward.a.c.this.b, 0, this.e, this.c, this.f, cVar));
                                } catch (java.lang.Exception e6) {
                                    if (com.anythink.expressad.a.a) {
                                        e6.getLocalizedMessage();
                                    }
                                }
                            }
                            be = cVar.be();
                            if (!android.text.TextUtils.isEmpty(be)) {
                                try {
                                    com.anythink.expressad.foundation.g.d.b.a(this.b).a(be, new com.anythink.expressad.reward.a.c.e(com.anythink.expressad.reward.a.c.this.b, 0, this.e, this.c, this.f, cVar));
                                } catch (java.lang.Exception e7) {
                                    if (com.anythink.expressad.a.a) {
                                        e7.getLocalizedMessage();
                                    }
                                }
                            }
                            if (M != null) {
                                java.lang.String d = M.d();
                                if (!android.text.TextUtils.isEmpty(d) && !cVar.j()) {
                                    if (d.contains(".zip")) {
                                        try {
                                            com.anythink.expressad.videocommon.b.i.a().b(d, (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.c.g(this.b, this.e, this.c, this.f, cVar, 313, com.anythink.expressad.reward.a.c.this.b, this.g, this.a));
                                        } catch (java.lang.Exception e8) {
                                            if (com.anythink.expressad.a.a) {
                                                e8.getLocalizedMessage();
                                            }
                                        }
                                    } else {
                                        try {
                                            com.anythink.expressad.videocommon.b.i.a().b(d, new com.anythink.expressad.reward.a.c.d(313, this.e, this.c, this.f, cVar, this.g, com.anythink.expressad.reward.a.c.this.b, this.a));
                                        } catch (java.lang.Exception e9) {
                                            if (com.anythink.expressad.a.a) {
                                                e9.getLocalizedMessage();
                                            }
                                        }
                                    }
                                }
                                java.util.List<com.anythink.expressad.foundation.d.c.C0208c.a> f3 = M.f();
                                if (f3 != null && f3.size() > 0) {
                                    for (com.anythink.expressad.foundation.d.c.C0208c.a aVar : f3) {
                                        if (aVar != null && (list = aVar.b) != null && list.size() > 0) {
                                            for (java.lang.String str : aVar.b) {
                                                if (!android.text.TextUtils.isEmpty(str)) {
                                                    try {
                                                        com.anythink.expressad.foundation.g.d.b.a(this.b).a(str, new com.anythink.expressad.reward.a.c.e(com.anythink.expressad.reward.a.c.this.b, 1, this.e, this.c, this.f, cVar));
                                                    } catch (java.lang.Exception e10) {
                                                        if (com.anythink.expressad.a.a) {
                                                            e10.getLocalizedMessage();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            it2 = it;
                        }
                    }
                    it = it2;
                    java.lang.String I22 = cVar.I();
                    j = cVar.j();
                    boolean f22 = com.anythink.expressad.foundation.h.t.f(I22);
                    if (!j) {
                    }
                    if (!android.text.TextUtils.isEmpty(cVar.P())) {
                        com.anythink.expressad.videocommon.b.i.a().b(cVar.P());
                    }
                    bd = cVar.bd();
                    if (!android.text.TextUtils.isEmpty(bd)) {
                    }
                    be = cVar.be();
                    if (!android.text.TextUtils.isEmpty(be)) {
                    }
                    if (M != null) {
                    }
                    it2 = it;
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.c$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.videocommon.b.i.d {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.anythink.expressad.reward.a.c.i d;

        public AnonymousClass2(java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.reward.a.c.i iVar) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = iVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            try {
                com.anythink.expressad.videocommon.b.l.a().b(str, true);
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 105;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", this.a);
                bundle.putString(com.anythink.expressad.a.y, this.b);
                bundle.putString("request_id", this.c);
                bundle.putString("url", str);
                obtain.setData(bundle);
                com.anythink.expressad.reward.a.c.this.b.sendMessage(obtain);
                com.anythink.expressad.reward.a.c.i iVar = this.d;
                if (iVar != null) {
                    iVar.a(this.b, this.a, this.c);
                }
            } catch (java.lang.Exception e) {
                com.anythink.expressad.videocommon.b.l.a().b(str, false);
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 205;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("unit_id", this.a);
                bundle2.putString(com.anythink.expressad.a.y, this.b);
                bundle2.putString("request_id", this.c);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                com.anythink.expressad.reward.a.c.this.b.sendMessage(obtain2);
                com.anythink.expressad.reward.a.c.i iVar2 = this.d;
                if (iVar2 != null) {
                    java.lang.String str2 = this.a;
                    e.getLocalizedMessage();
                    iVar2.a(str2);
                }
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            try {
                com.anythink.expressad.videocommon.b.l.a().b(str2, false);
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 205;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", this.a);
                bundle.putString(com.anythink.expressad.a.y, this.b);
                bundle.putString("request_id", this.c);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                obtain.setData(bundle);
                com.anythink.expressad.reward.a.c.this.b.sendMessage(obtain);
                com.anythink.expressad.reward.a.c.i iVar = this.d;
                if (iVar != null) {
                    iVar.a(this.a);
                }
            } catch (java.lang.Exception e) {
                com.anythink.expressad.videocommon.b.l.a().b(str2, false);
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 105;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("unit_id", this.a);
                bundle2.putString(com.anythink.expressad.a.y, this.b);
                bundle2.putString("request_id", this.c);
                bundle2.putString("url", str2);
                bundle2.putString("message", e.getMessage());
                obtain2.setData(bundle2);
                com.anythink.expressad.reward.a.c.this.b.sendMessage(obtain2);
                com.anythink.expressad.reward.a.c.i iVar2 = this.d;
                if (iVar2 != null) {
                    iVar2.a(this.a);
                }
                if (com.anythink.expressad.a.a) {
                    e.getLocalizedMessage();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.c$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView b;
        final /* synthetic */ com.anythink.expressad.foundation.d.c c;
        final /* synthetic */ java.util.List d;
        final /* synthetic */ java.lang.String e;
        final /* synthetic */ com.anythink.expressad.videocommon.e.d f;
        final /* synthetic */ java.lang.String g;

        public AnonymousClass3(boolean z, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar, java.util.List list, java.lang.String str, com.anythink.expressad.videocommon.e.d dVar, java.lang.String str2) {
            this.a = z;
            this.b = windVaneWebView;
            this.c = cVar;
            this.d = list;
            this.e = str;
            this.f = dVar;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.reward.a.c.a(this.a, this.b, this.c.M().e(), this.c, this.d, com.anythink.expressad.videocommon.b.i.a().c(this.c.M().e()), this.e, this.f, this.g, com.anythink.expressad.reward.a.c.this.e);
        }
    }

    public static class a {
        boolean a;
        boolean b;
        int c;
        int d;
        java.lang.String e;
        java.lang.String f;
        int g;
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> h;
        java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> i;

        public a(boolean z, boolean z2, int i, int i2, java.lang.String str, java.lang.String str2, int i3, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            this.a = z;
            this.b = z2;
            this.c = i;
            this.d = i2;
            this.e = str;
            this.f = str2;
            this.g = i3;
            this.h = copyOnWriteArrayList;
            this.i = new java.util.concurrent.CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    public static class b extends com.anythink.expressad.atsignalcommon.a.a {
        private final android.os.Handler b;
        private final java.lang.Runnable c;
        private final boolean d;
        private final boolean e;
        private int f;
        private java.lang.String g;
        private java.lang.String h;
        private java.lang.String i;
        private java.lang.String j;
        private com.anythink.expressad.videocommon.a.C0231a k;
        private com.anythink.expressad.foundation.d.c l;
        private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> m;
        private com.anythink.expressad.videocommon.e.d n;
        private final com.anythink.expressad.reward.a.c.j o;
        private boolean q;
        private boolean r;
        private boolean t;
        private long u;

        /* renamed from: s, reason: collision with root package name */
        private int f253s = 0;
        private boolean p = false;

        public b(boolean z, android.os.Handler handler, java.lang.Runnable runnable, boolean z2, boolean z3, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.expressad.videocommon.a.C0231a c0231a, com.anythink.expressad.foundation.d.c cVar, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, com.anythink.expressad.videocommon.e.d dVar, com.anythink.expressad.reward.a.c.j jVar, long j) {
            this.b = handler;
            this.c = runnable;
            this.d = z2;
            this.e = z3;
            this.f = i;
            this.g = str;
            this.i = str2;
            this.h = str3;
            this.j = str4;
            this.k = c0231a;
            this.l = cVar;
            this.m = copyOnWriteArrayList;
            this.n = dVar;
            this.o = jVar;
            this.t = z;
            this.u = j;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final java.lang.String a(java.lang.String str) {
            return com.anythink.expressad.videocommon.b.i.a().c(str);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(6:12|(3:15|16|(3:21|(3:23|24|25)(2:33|(1:37))|27))|43|44|45|27) */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0112, code lost:
        
            if (com.anythink.expressad.a.a != false) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0114, code lost:
        
            r0.getLocalizedMessage();
         */
        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void a(java.lang.Object obj, java.lang.String str) {
            if (obj == null) {
                return;
            }
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                java.lang.String optString = new org.json.JSONObject(str).optString("id");
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.video.bt.a.c.a(obj, optString);
                com.anythink.expressad.video.bt.a.c.a();
                java.lang.String c = com.anythink.expressad.video.bt.a.c.c(optString);
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.foundation.d.c a = com.anythink.expressad.video.bt.a.c.a(optString);
                com.anythink.expressad.video.bt.a.c.a();
                com.anythink.expressad.videocommon.e.d b = com.anythink.expressad.video.bt.a.c.b(optString);
                java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = new java.util.concurrent.CopyOnWriteArrayList();
                copyOnWriteArrayList.add(a);
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = ((com.anythink.expressad.atsignalcommon.windvane.a) obj).a;
                if (windVaneWebView instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) {
                    com.anythink.expressad.reward.a.c cVar = com.anythink.expressad.reward.a.c.m.a;
                    boolean z = this.t;
                    int i = this.f253s == 0 ? 3 : 6;
                    if (windVaneWebView != null) {
                        if (a != null && b != null) {
                            try {
                                if (a.M() != null && !android.text.TextUtils.isEmpty(c)) {
                                    if (android.text.TextUtils.isEmpty(a.M().e())) {
                                        org.json.JSONObject jSONObject = new org.json.JSONObject();
                                        try {
                                            jSONObject.put("id", optString);
                                            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                                            jSONObject2.put("result", 1);
                                            jSONObject2.put("error", "data is null");
                                            jSONObject.put("data", jSONObject2);
                                            com.anythink.expressad.atsignalcommon.windvane.j.a();
                                            com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                                        } catch (java.lang.Exception e) {
                                            if (com.anythink.expressad.a.a) {
                                                e.getLocalizedMessage();
                                            }
                                        }
                                    } else if (android.text.TextUtils.isEmpty(a.M().e()) || !a.M().e().contains(com.anythink.expressad.foundation.d.c.d)) {
                                        new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(cVar.new AnonymousClass3(z, windVaneWebView, a, copyOnWriteArrayList, c, b, optString), i * 1000);
                                    }
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                th.getMessage();
                                return;
                            }
                        }
                        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                        jSONObject3.put("id", optString);
                        org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                        jSONObject4.put("result", 2);
                        jSONObject4.put("error", "data is null");
                        jSONObject3.put("data", jSONObject4);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
                    }
                    this.f253s++;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.c
        public final void a(java.lang.String str, int i, int i2) {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            java.lang.Runnable runnable;
            super.onPageFinished(webView, str);
            if (this.q) {
                return;
            }
            if (!str.contains("wfr=1")) {
                com.anythink.expressad.videocommon.b.l.a().c(this.h + "_" + this.j + "_" + this.g, true);
                android.os.Handler handler = this.b;
                if (handler != null && (runnable = this.c) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.k;
                if (c0231a != null) {
                    c0231a.a(true);
                }
                com.anythink.expressad.reward.a.c.j jVar = this.o;
                if (jVar != null) {
                    jVar.a();
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.q = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.anythink.expressad.videocommon.b.l.a().c(this.h + "_" + this.j + "_" + this.g, false);
            if (this.o != null) {
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.k;
                if (c0231a != null) {
                    c0231a.a(false);
                }
                this.o.a(str);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.a, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            java.lang.Runnable runnable;
            if (this.r) {
                return;
            }
            boolean z = this.p;
            if (i == 1) {
                if (z) {
                    com.anythink.expressad.videocommon.a.e(this.h + "_" + this.j);
                } else {
                    com.anythink.expressad.videocommon.a.d(this.h + "_" + this.j);
                }
                com.anythink.expressad.videocommon.a.a(this.h + "_" + this.j + "_" + this.g, this.k, true, this.p);
                android.os.Handler handler = this.b;
                if (handler != null && (runnable = this.c) != null) {
                    handler.removeCallbacks(runnable);
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.h + "_" + this.j + "_" + this.g, true);
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.k;
                if (c0231a != null) {
                    c0231a.a(true);
                }
                com.anythink.expressad.reward.a.c.j jVar = this.o;
                if (jVar != null) {
                    jVar.a();
                }
            } else {
                com.anythink.expressad.videocommon.b.l.a().c(this.h + "_" + this.j + "_" + this.g, false);
                com.anythink.expressad.videocommon.a.C0231a c0231a2 = this.k;
                if (c0231a2 != null) {
                    c0231a2.a(false);
                }
                com.anythink.expressad.reward.a.c.j jVar2 = this.o;
                if (jVar2 != null) {
                    jVar2.a("state 2");
                }
            }
            this.r = true;
        }
    }

    /* renamed from: com.anythink.expressad.reward.a.c$c, reason: collision with other inner class name */
    public interface InterfaceC0216c {
        void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList);

        void a(java.lang.String str, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList);
    }

    public static final class d implements com.anythink.expressad.videocommon.b.i.b {
        public static final int a = 497;
        public static final int b = 313;
        public static final int c = 859;
        private int e;
        private final java.lang.String f;
        private final java.lang.String g;
        private final java.lang.String h;
        private com.anythink.expressad.foundation.d.c i;
        private com.anythink.expressad.reward.a.c.i j;
        private android.os.Handler k;
        private java.util.List<com.anythink.expressad.foundation.d.c> l;
        private boolean d = false;
        private final long m = java.lang.System.currentTimeMillis();

        public d(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.reward.a.c.i iVar, android.os.Handler handler, java.util.List<com.anythink.expressad.foundation.d.c> list) {
            this.e = i;
            this.f = str;
            this.g = str2;
            this.h = str3;
            this.i = cVar;
            this.j = iVar;
            this.k = handler;
            this.l = list;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            com.anythink.expressad.videocommon.b.l.a().b(str, true);
            int i = this.e;
            if (i == 313) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 101;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.f);
                bundle.putString("request_id", this.h);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.k.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 101;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.f);
                bundle2.putString("request_id", this.h);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.k.sendMessage(obtain2);
                if (this.d) {
                    java.lang.System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            android.os.Message obtain3 = android.os.Message.obtain();
            obtain3.what = 105;
            android.os.Bundle bundle3 = new android.os.Bundle();
            bundle3.putString("unit_id", this.g);
            bundle3.putString(com.anythink.expressad.a.y, this.f);
            bundle3.putString("request_id", this.h);
            obtain3.setData(bundle3);
            this.k.sendMessage(obtain3);
            com.anythink.expressad.reward.a.c.i iVar = this.j;
            if (iVar != null) {
                iVar.a(this.f, this.g, this.h);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.videocommon.b.l.a().b(str, false);
            int i = this.e;
            if (i == 313) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 201;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.f);
                bundle.putString("request_id", this.h);
                bundle.putString("url", str);
                bundle.putString("message", str2);
                obtain.setData(bundle);
                this.k.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 201;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.f);
                bundle2.putString("request_id", this.h);
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                obtain2.setData(bundle2);
                this.k.sendMessage(obtain2);
                if (this.d) {
                    java.lang.System.currentTimeMillis();
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            android.os.Message obtain3 = android.os.Message.obtain();
            obtain3.what = 205;
            android.os.Bundle bundle3 = new android.os.Bundle();
            bundle3.putString("unit_id", this.g);
            bundle3.putString(com.anythink.expressad.a.y, this.f);
            bundle3.putString("request_id", this.h);
            bundle3.putString("message", str2);
            obtain3.setData(bundle3);
            this.k.sendMessage(obtain3);
            com.anythink.expressad.reward.a.c.i iVar = this.j;
            if (iVar != null) {
                iVar.a(this.g);
            }
        }

        public final void a(boolean z) {
            this.d = z;
        }
    }

    public static final class e implements com.anythink.expressad.foundation.g.d.c {
        public static final int a = 0;
        public static final int b = 1;
        private android.os.Handler c;
        private int d;
        private java.lang.String e;
        private java.lang.String f;
        private java.lang.String g;
        private com.anythink.expressad.foundation.d.c h;

        public e(android.os.Handler handler, int i, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.d.c cVar) {
            this.c = handler;
            this.d = i;
            this.f = str;
            this.e = str2;
            this.g = str3;
            this.h = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            com.anythink.expressad.videocommon.b.l.a();
            com.anythink.expressad.videocommon.b.l.c(str);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = this.d == 0 ? 102 : 104;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("unit_id", this.e);
            bundle.putString(com.anythink.expressad.a.y, this.f);
            bundle.putString("request_id", this.g);
            obtain.setData(bundle);
            this.c.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = this.d == 0 ? 202 : 204;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("unit_id", this.e);
            bundle.putString(com.anythink.expressad.a.y, this.f);
            bundle.putString("request_id", this.g);
            obtain.setData(bundle);
            this.c.sendMessage(obtain);
        }
    }

    public static final class f implements com.anythink.expressad.videocommon.d.b {
        private android.os.Handler a;
        private final java.lang.String b;
        private final java.lang.String c;
        private final java.lang.String d;

        public f(android.os.Handler handler, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = handler;
            this.c = str;
            this.b = str2;
            this.d = str3;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str) {
            com.anythink.expressad.videocommon.b.l.a().a(str, true);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 100;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("unit_id", this.b);
            bundle.putString(com.anythink.expressad.a.y, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.videocommon.b.l.a().a(str2, false);
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = 200;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("unit_id", this.b);
            bundle.putString(com.anythink.expressad.a.y, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str2);
            bundle.putString("message", str);
            obtain.setData(bundle);
            this.a.sendMessage(obtain);
        }
    }

    public static final class g implements com.anythink.expressad.videocommon.b.i.d {
        public static final int a = 497;
        public static final int b = 859;
        public static final int c = 313;
        public static final int d = 502;
        private android.content.Context f;
        private java.lang.String g;
        private java.lang.String h;
        private java.lang.String i;
        private com.anythink.expressad.foundation.d.c j;
        private int k;
        private android.os.Handler l;
        private com.anythink.expressad.reward.a.c.i m;
        private java.util.List<com.anythink.expressad.foundation.d.c> n;
        private boolean e = false;
        private long o = java.lang.System.currentTimeMillis();

        public g(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.d.c cVar, int i, android.os.Handler handler, com.anythink.expressad.reward.a.c.i iVar, java.util.List<com.anythink.expressad.foundation.d.c> list) {
            this.f = context;
            this.h = str;
            this.g = str2;
            this.i = str3;
            this.j = cVar;
            this.k = i;
            this.l = handler;
            this.m = iVar;
            this.n = list;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str) {
            com.anythink.expressad.videocommon.b.l.a().b(str, true);
            java.lang.System.currentTimeMillis();
            int i = this.k;
            if (i == 313) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 101;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.h);
                bundle.putString("request_id", this.i);
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.l.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 101;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.h);
                bundle2.putString("request_id", this.i);
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.l.sendMessage(obtain2);
                return;
            }
            if (i != 859) {
                return;
            }
            android.os.Message obtain3 = android.os.Message.obtain();
            obtain3.what = 103;
            android.os.Bundle bundle3 = new android.os.Bundle();
            bundle3.putString("unit_id", this.g);
            bundle3.putString(com.anythink.expressad.a.y, this.h);
            bundle3.putString("request_id", this.i);
            obtain3.setData(bundle3);
            this.l.sendMessage(obtain3);
            com.anythink.expressad.reward.a.c.i iVar = this.m;
            if (iVar != null) {
                iVar.a(this.h, this.g, this.i);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.videocommon.b.l.a().b(str2, false);
            java.lang.System.currentTimeMillis();
            int i = this.k;
            if (i == 313) {
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 101;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", this.g);
                bundle.putString(com.anythink.expressad.a.y, this.h);
                bundle.putString("request_id", this.i);
                bundle.putString("url", str2);
                bundle.putString("message", str);
                obtain.setData(bundle);
                this.l.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                android.os.Message obtain2 = android.os.Message.obtain();
                obtain2.what = 201;
                android.os.Bundle bundle2 = new android.os.Bundle();
                bundle2.putString("unit_id", this.g);
                bundle2.putString(com.anythink.expressad.a.y, this.h);
                bundle2.putString("request_id", this.i);
                bundle2.putString("url", str2);
                bundle2.putString("message", str);
                obtain2.setData(bundle2);
                this.l.sendMessage(obtain2);
                return;
            }
            if (i != 859) {
                return;
            }
            android.os.Message obtain3 = android.os.Message.obtain();
            obtain3.what = 203;
            android.os.Bundle bundle3 = new android.os.Bundle();
            bundle3.putString("unit_id", this.g);
            bundle3.putString(com.anythink.expressad.a.y, this.h);
            bundle3.putString("request_id", this.i);
            bundle3.putString("url", str2);
            bundle3.putString("message", str);
            obtain3.setData(bundle3);
            this.l.sendMessage(obtain3);
            com.anythink.expressad.reward.a.c.i iVar = this.m;
            if (iVar != null) {
                iVar.a(this.g);
            }
        }

        public final void a(boolean z) {
            this.e = z;
        }
    }

    public static final class h extends android.os.Handler {
        private android.content.Context a;
        private com.anythink.expressad.reward.a.c.InterfaceC0216c b;
        private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.reward.a.c.InterfaceC0216c> c;
        private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c>> d;

        public h(android.os.Looper looper) {
            super(looper);
            this.c = new java.util.concurrent.ConcurrentHashMap<>();
            this.d = new java.util.concurrent.ConcurrentHashMap<>();
        }

        public final void a(android.content.Context context) {
            this.a = context;
        }

        public final void a(java.lang.String str, java.lang.String str2, com.anythink.expressad.reward.a.c.InterfaceC0216c interfaceC0216c) {
            this.c.put(str + "_" + str2, interfaceC0216c);
        }

        public final void a(java.lang.String str, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList) {
            this.d.put(str, copyOnWriteArrayList);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            boolean z;
            android.os.Bundle data = message.getData();
            java.lang.String string = data.getString(com.anythink.expressad.a.y);
            java.lang.String string2 = data.getString("unit_id");
            java.lang.String string3 = data.getString("request_id");
            java.lang.String str = string2 + "_" + string3;
            com.anythink.expressad.reward.a.c.a aVar = (com.anythink.expressad.reward.a.c.a) com.anythink.expressad.reward.a.c.d.get(str);
            com.anythink.expressad.reward.a.c.InterfaceC0216c interfaceC0216c = this.c.get(str);
            java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList = this.d.get(str);
            int i = message.what;
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    break;
                default:
                    switch (i) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (aVar != null && interfaceC0216c != null) {
                                data.getString("message");
                                com.anythink.expressad.reward.a.c.b(message.what);
                                java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList2 = aVar.h;
                                com.anythink.expressad.foundation.d.c cVar = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : aVar.h.get(0);
                                try {
                                    if (!aVar.a || aVar.i == null) {
                                        if (com.anythink.expressad.videocommon.b.e.a().a(aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList)) {
                                            interfaceC0216c.a(string, string2, string3, aVar.h);
                                        } else {
                                            if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0) {
                                                int i2 = message.what;
                                                if (i2 != 200) {
                                                    if (i2 != 201) {
                                                        if (i2 != 203) {
                                                            if (i2 == 205 && cVar.aB().contains(3)) {
                                                            }
                                                        } else if (cVar.aB().contains(1)) {
                                                        }
                                                    } else if (cVar.aB().contains(2)) {
                                                    }
                                                } else if (cVar.aB().contains(0)) {
                                                }
                                            }
                                            interfaceC0216c.a(string2, aVar.h);
                                        }
                                        this.c.remove(str);
                                        com.anythink.expressad.reward.a.c.d.remove(str);
                                        this.d.remove(str);
                                        break;
                                    } else if (aVar.c == 1) {
                                        if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0) {
                                            int i3 = message.what;
                                            if (i3 != 200) {
                                                if (i3 != 201) {
                                                    if (i3 != 203) {
                                                        if (i3 == 205) {
                                                            if (!cVar.aB().contains(3)) {
                                                                java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList3 = aVar.h;
                                                                if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                                                    com.anythink.expressad.foundation.d.c cVar2 = aVar.h.get(0);
                                                                    if (cVar2.ar().equals(cVar2.I()) && cVar.aB().contains(2)) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else if (cVar.aB().contains(1)) {
                                                    }
                                                } else if (cVar.aB().contains(2)) {
                                                }
                                            } else if (cVar.aB().contains(0)) {
                                            }
                                        }
                                        interfaceC0216c.a(string2, aVar.h);
                                        this.c.remove(str);
                                        com.anythink.expressad.reward.a.c.d.remove(str);
                                        this.d.remove(str);
                                        break;
                                    } else {
                                        java.lang.String string4 = data.getString("url");
                                        int i4 = message.what;
                                        if (i4 == 200) {
                                            if (cVar != null && cVar.aB() != null && cVar.aB().size() > 0) {
                                                if (cVar.aB().contains(0)) {
                                                }
                                            }
                                            for (int i5 = 0; i5 < aVar.i.size(); i5++) {
                                                if (aVar.i.get(i5).S().equals(string4)) {
                                                    aVar.i.remove(i5);
                                                }
                                            }
                                            com.anythink.expressad.reward.a.c.d.remove(str);
                                            com.anythink.expressad.reward.a.c.d.put(str, aVar);
                                        } else if (i4 != 201) {
                                            if (i4 != 203) {
                                                if (i4 == 205) {
                                                    if (cVar == null || cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(3)) {
                                                        aVar.i.clear();
                                                        com.anythink.expressad.reward.a.c.d.remove(str);
                                                        com.anythink.expressad.reward.a.c.d.put(str, aVar);
                                                    }
                                                }
                                            } else if (cVar == null || cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(1)) {
                                                for (int i6 = 0; i6 < aVar.i.size(); i6++) {
                                                    com.anythink.expressad.foundation.d.c cVar3 = aVar.i.get(i6);
                                                    if (cVar3.M() != null && cVar3.M().e().equals(string4)) {
                                                        aVar.i.remove(i6);
                                                    }
                                                }
                                                com.anythink.expressad.reward.a.c.d.remove(str);
                                                com.anythink.expressad.reward.a.c.d.put(str, aVar);
                                            }
                                        } else if (cVar == null || cVar.aB() == null || cVar.aB().size() <= 0 || !cVar.aB().contains(2)) {
                                            for (int i7 = 0; i7 < aVar.i.size(); i7++) {
                                                com.anythink.expressad.foundation.d.c cVar4 = aVar.i.get(i7);
                                                if (cVar4.M() != null && cVar4.M().d().equals(string4)) {
                                                    aVar.i.remove(i7);
                                                }
                                                if (!android.text.TextUtils.isEmpty(cVar4.I()) && cVar4.I().equals(string4)) {
                                                    aVar.i.remove(i7);
                                                }
                                            }
                                            com.anythink.expressad.reward.a.c.d.remove(str);
                                            com.anythink.expressad.reward.a.c.d.put(str, aVar);
                                        }
                                        if (com.anythink.expressad.videocommon.b.e.a().a(aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList)) {
                                            interfaceC0216c.a(string, string2, string3, aVar.h);
                                            this.c.remove(str);
                                            com.anythink.expressad.reward.a.c.d.remove(str);
                                            this.d.remove(str);
                                            break;
                                        } else if (aVar.i.size() == 0) {
                                            interfaceC0216c.a(string2, aVar.h);
                                            this.c.remove(str);
                                            com.anythink.expressad.reward.a.c.d.remove(str);
                                            this.d.remove(str);
                                            break;
                                        }
                                    }
                                } catch (java.lang.Exception e) {
                                    java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList4 = aVar.h;
                                    e.getMessage();
                                    interfaceC0216c.a(string2, copyOnWriteArrayList4);
                                    return;
                                }
                            }
                            break;
                    }
                    return;
            }
            if (aVar == null || interfaceC0216c == null) {
                return;
            }
            try {
                z = com.anythink.expressad.videocommon.b.e.a().a(aVar.e, aVar.b, aVar.d, aVar.a, aVar.c, copyOnWriteArrayList);
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.getLocalizedMessage();
                }
                z = false;
            }
            if (z) {
                interfaceC0216c.a(string, string2, string3, aVar.h);
                this.c.remove(str);
                com.anythink.expressad.reward.a.c.d.remove(str);
                this.d.remove(str);
            }
        }
    }

    public interface i {
        void a(java.lang.String str);

        void a(java.lang.String str, java.lang.String str2, java.lang.String str3);
    }

    public interface j {
        void a();

        void a(java.lang.String str);
    }

    public static class k extends com.anythink.expressad.atsignalcommon.a.b {
        private android.os.Handler a;
        private java.lang.Runnable b;
        private final boolean c;
        private final boolean e;
        private java.lang.String f;
        private final com.anythink.expressad.reward.a.c.j g;
        private final com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView h;
        private final java.lang.String i;
        private final java.lang.String j;
        private final java.lang.String k;
        private final com.anythink.expressad.videocommon.a.C0231a l;
        private final com.anythink.expressad.foundation.d.c m;
        private java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> n;
        private long o;
        private boolean p;
        private boolean q;
        private final java.lang.Runnable r;

        /* renamed from: s, reason: collision with root package name */
        private final java.lang.Runnable f254s;

        /* renamed from: com.anythink.expressad.reward.a.c$k$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.reward.a.c.j a;
            final /* synthetic */ com.anythink.expressad.videocommon.a.C0231a b;
            final /* synthetic */ java.lang.String c;
            final /* synthetic */ java.lang.String d;
            final /* synthetic */ java.lang.String e;
            final /* synthetic */ java.lang.String f;

            public AnonymousClass1(com.anythink.expressad.reward.a.c.j jVar, com.anythink.expressad.videocommon.a.C0231a c0231a, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.a = jVar;
                this.b = c0231a;
                this.c = str;
                this.d = str2;
                this.e = str3;
                this.f = str4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a;
                com.anythink.expressad.videocommon.a.C0231a c0231a;
                if (this.a != null && (c0231a = this.b) != null) {
                    c0231a.a(true);
                    com.anythink.expressad.videocommon.b.l.a().c(this.c + "_" + this.d + "_" + this.e, true);
                    this.a.a();
                }
                com.anythink.expressad.videocommon.a.C0231a c0231a2 = this.b;
                if (c0231a2 == null || (a = c0231a2.a()) == null) {
                    return;
                }
                try {
                    a.release();
                } catch (java.lang.Exception unused) {
                }
            }
        }

        /* renamed from: com.anythink.expressad.reward.a.c$k$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ com.anythink.expressad.reward.a.c.j a;
            final /* synthetic */ com.anythink.expressad.videocommon.a.C0231a b;
            final /* synthetic */ java.lang.String c;
            final /* synthetic */ java.lang.String d;
            final /* synthetic */ java.lang.String e;
            final /* synthetic */ java.lang.String f;

            public AnonymousClass2(com.anythink.expressad.reward.a.c.j jVar, com.anythink.expressad.videocommon.a.C0231a c0231a, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
                this.a = jVar;
                this.b = c0231a;
                this.c = str;
                this.d = str2;
                this.e = str3;
                this.f = str4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView a;
                com.anythink.expressad.videocommon.a.C0231a c0231a;
                if (this.a != null && (c0231a = this.b) != null) {
                    c0231a.a(true);
                    com.anythink.expressad.videocommon.b.l.a().c(this.c + "_" + this.d + "_" + this.e, true);
                    this.a.a();
                }
                com.anythink.expressad.videocommon.a.C0231a c0231a2 = this.b;
                if (c0231a2 == null || (a = c0231a2.a()) == null) {
                    return;
                }
                try {
                    a.release();
                } catch (java.lang.Exception unused) {
                }
            }
        }

        public k(android.os.Handler handler, java.lang.Runnable runnable, boolean z, boolean z2, java.lang.String str, com.anythink.expressad.reward.a.c.j jVar, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.anythink.expressad.videocommon.a.C0231a c0231a, com.anythink.expressad.foundation.d.c cVar, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, long j) {
            this.a = handler;
            this.b = runnable;
            this.c = z;
            this.e = z2;
            this.f = str;
            this.g = jVar;
            this.h = windVaneWebView;
            this.i = str2;
            this.j = str4;
            this.k = str3;
            this.l = c0231a;
            this.m = cVar;
            this.n = copyOnWriteArrayList;
            this.o = j;
            com.anythink.expressad.reward.a.c.k.AnonymousClass1 anonymousClass1 = new com.anythink.expressad.reward.a.c.k.AnonymousClass1(jVar, c0231a, str4, str, str2, str3);
            this.f254s = anonymousClass1;
            this.r = new com.anythink.expressad.reward.a.c.k.AnonymousClass2(jVar, c0231a, str4, str, str2, str3);
            if (handler != null) {
                handler.postDelayed(anonymousClass1, 5000L);
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            java.lang.Runnable runnable;
            android.os.Handler handler;
            java.lang.Runnable runnable2;
            super.onPageFinished(webView, str);
            android.os.Handler handler2 = this.a;
            if (handler2 != null && (runnable2 = this.f254s) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.p) {
                return;
            }
            if (str.contains("wfr=1")) {
                android.os.Handler handler3 = this.a;
                if (handler3 != null && (runnable = this.r) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            } else {
                com.anythink.expressad.videocommon.b.l.a().c(this.j + "_" + this.f + "_" + this.i, true);
                java.lang.Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.l;
                if (c0231a != null) {
                    c0231a.a(true);
                }
                if (this.c) {
                    if (this.m.A()) {
                        com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.m.aa(), this.l);
                    } else {
                        com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.m.aa(), this.l);
                    }
                } else if (this.m.A()) {
                    com.anythink.expressad.videocommon.a.a(94, this.m.aa(), this.l);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.m.aa(), this.l);
                }
                com.anythink.expressad.reward.a.c.j jVar = this.g;
                if (jVar != null) {
                    jVar.a();
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.p = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.anythink.expressad.videocommon.b.l.a().c(this.j + "_" + this.f + "_" + this.i, false);
            android.os.Handler handler = this.a;
            if (handler != null) {
                if (this.r != null) {
                    handler.removeCallbacks(this.f254s);
                }
                java.lang.Runnable runnable = this.r;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.l;
                if (c0231a != null) {
                    c0231a.a(false);
                }
                com.anythink.expressad.reward.a.c.j jVar = this.g;
                if (jVar != null) {
                    jVar.a(str);
                }
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.getLocalizedMessage();
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            java.lang.String str = "";
            java.util.Objects.toString(sslError == null ? "" : java.lang.Integer.valueOf(sslError.getPrimaryError()));
            com.anythink.expressad.videocommon.b.l.a().c(this.j + "_" + this.f + "_" + this.i, false);
            android.os.Handler handler = this.a;
            if (handler != null) {
                if (this.r != null) {
                    handler.removeCallbacks(this.f254s);
                }
                java.lang.Runnable runnable = this.r;
                if (runnable != null) {
                    this.a.removeCallbacks(runnable);
                }
            }
            try {
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.l;
                if (c0231a != null) {
                    c0231a.a(false);
                }
                com.anythink.expressad.reward.a.c.j jVar = this.g;
                if (jVar != null) {
                    if (sslError != null) {
                        str = java.lang.Integer.toString(sslError.getPrimaryError());
                    }
                    jVar.a(str);
                }
            } catch (java.lang.Exception e) {
                if (com.anythink.expressad.a.a) {
                    e.getLocalizedMessage();
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            android.os.Handler handler;
            java.lang.Runnable runnable;
            java.lang.Runnable runnable2;
            super.readyState(webView, i);
            android.os.Handler handler2 = this.a;
            if (handler2 != null && (runnable2 = this.r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            android.os.Handler handler3 = this.a;
            if (handler3 != null && (runnable = this.f254s) != null) {
                handler3.removeCallbacks(runnable);
            }
            if (this.q) {
                return;
            }
            if (i == 1) {
                java.lang.Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.j + "_" + this.f + "_" + this.i, true);
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.l;
                if (c0231a != null) {
                    c0231a.a(true);
                }
                if (this.c) {
                    if (this.e) {
                        com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.m.aa(), this.l);
                    } else {
                        com.anythink.expressad.videocommon.a.b(com.anythink.expressad.foundation.g.a.aU, this.m.aa(), this.l);
                    }
                } else if (this.e) {
                    com.anythink.expressad.videocommon.a.a(94, this.m.aa(), this.l);
                } else {
                    com.anythink.expressad.videocommon.a.b(94, this.m.aa(), this.l);
                }
                com.anythink.expressad.reward.a.c.j jVar = this.g;
                if (jVar != null) {
                    jVar.a();
                }
            } else {
                com.anythink.expressad.reward.a.c.j jVar2 = this.g;
                if (jVar2 != null) {
                    jVar2.a("state ".concat(java.lang.String.valueOf(i)));
                }
            }
            this.q = true;
        }
    }

    public static class l extends com.anythink.expressad.atsignalcommon.a.b {
        private java.lang.String a;
        private final boolean b = false;
        private final com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView c;
        private final java.lang.String e;
        private final java.lang.String f;
        private final com.anythink.expressad.videocommon.a.C0231a g;
        private final com.anythink.expressad.foundation.d.c h;
        private boolean i;
        private java.lang.String j;
        private boolean k;
        private boolean l;

        public l(java.lang.String str, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.a.C0231a c0231a, com.anythink.expressad.foundation.d.c cVar, boolean z, java.lang.String str4) {
            this.c = windVaneWebView;
            this.e = str2;
            this.f = str3;
            this.g = c0231a;
            this.h = cVar;
            this.a = str;
            this.i = z;
            this.j = str4;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            if (this.k) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.c != null) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    try {
                        jSONObject.put("id", this.a);
                        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.anythink.expressad.atsignalcommon.windvane.j.a();
                        com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.c, "componentReact", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (java.lang.Exception e) {
                        if (com.anythink.expressad.a.a) {
                            e.getLocalizedMessage();
                        }
                    }
                }
                com.anythink.expressad.videocommon.b.l.a().c(this.f + "_" + this.j + "_" + this.e, true);
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.g;
                if (c0231a != null) {
                    c0231a.a(true);
                }
                java.lang.String str2 = this.f + "_" + this.h.aZ() + "_" + this.h.Z() + "_" + this.e;
                if (this.b) {
                    if (this.h.A()) {
                        com.anythink.expressad.videocommon.a.a(com.anythink.expressad.foundation.g.a.aU, this.h.aa(), this.g);
                    } else {
                        com.anythink.expressad.videocommon.a.a(str2, this.g, false, this.i);
                    }
                } else if (this.h.A()) {
                    com.anythink.expressad.videocommon.a.a(94, this.h.aa(), this.g);
                } else {
                    com.anythink.expressad.videocommon.a.a(str2, this.g, false, this.i);
                }
            }
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.b(webView);
            this.k = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            com.anythink.expressad.videocommon.b.l.a().c(this.f + "_" + this.j + "_" + this.e, false);
            com.anythink.expressad.videocommon.a.C0231a c0231a = this.g;
            if (c0231a != null) {
                c0231a.a(false);
            }
            if (this.c != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.c, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.getLocalizedMessage();
                    }
                }
            }
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            if (this.l) {
                return;
            }
            if (this.c != null) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", this.a);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) this.c, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (java.lang.Exception e) {
                    if (com.anythink.expressad.a.a) {
                        e.getLocalizedMessage();
                    }
                }
            }
            java.lang.String str = this.f + "_" + this.h.aZ() + "_" + this.h.Z() + "_" + this.e;
            if (i == 1) {
                com.anythink.expressad.videocommon.b.l.a().c(this.f + "_" + this.j + "_" + this.e, true);
                com.anythink.expressad.videocommon.a.C0231a c0231a = this.g;
                if (c0231a != null) {
                    c0231a.a(true);
                }
                if (this.b) {
                    if (this.h.A()) {
                        com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                    } else {
                        com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                    }
                } else if (this.h.A()) {
                    com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                } else {
                    com.anythink.expressad.videocommon.a.a(str, this.g, false, this.i);
                }
            } else {
                com.anythink.expressad.videocommon.b.l.a().c(this.f + "_" + this.j + "_" + this.e, false);
                com.anythink.expressad.videocommon.a.C0231a c0231a2 = this.g;
                if (c0231a2 != null) {
                    c0231a2.a(false);
                }
            }
            this.l = true;
        }
    }

    public static final class m {
        private static final com.anythink.expressad.reward.a.c a = new com.anythink.expressad.reward.a.c((byte) 0);

        private m() {
        }
    }

    private c() {
        this.t = new java.util.ArrayList(6);
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("mb-reward-load-thread");
        d = new java.util.HashMap();
        handlerThread.start();
        this.b = new com.anythink.expressad.reward.a.c.h(handlerThread.getLooper());
        this.c = new java.util.concurrent.ConcurrentHashMap<>();
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static com.anythink.expressad.reward.a.c a() {
        return com.anythink.expressad.reward.a.c.m.a;
    }

    private void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.d.c cVar, java.lang.String str4, com.anythink.expressad.reward.a.c.i iVar, java.util.List<com.anythink.expressad.foundation.d.c> list) {
        if (android.text.TextUtils.isEmpty(str4) || cVar.H()) {
            return;
        }
        if (str4.contains(".zip") && str4.contains(com.anythink.expressad.videocommon.b.m.b)) {
            boolean isEmpty = android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str4));
            try {
                com.anythink.expressad.reward.a.c.g gVar = new com.anythink.expressad.reward.a.c.g(context, str, str2, str3, cVar, 497, this.b, iVar, list);
                gVar.a(isEmpty);
                com.anythink.expressad.videocommon.b.i.a().b(str4, (com.anythink.expressad.videocommon.b.i.a) gVar);
                return;
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.getLocalizedMessage();
                    return;
                }
                return;
            }
        }
        boolean isEmpty2 = android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(str4));
        try {
            com.anythink.expressad.reward.a.c.d dVar = new com.anythink.expressad.reward.a.c.d(497, str, str2, str3, cVar, iVar, this.b, list);
            dVar.a(isEmpty2);
            com.anythink.expressad.videocommon.b.i.a().b(str4, dVar);
        } catch (java.lang.Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.getLocalizedMessage();
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.reward.a.c cVar, android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.foundation.d.c cVar2, java.lang.String str4, com.anythink.expressad.reward.a.c.i iVar, java.util.List list) {
        if (android.text.TextUtils.isEmpty(str4) || cVar2.H()) {
            return;
        }
        if (str4.contains(".zip") && str4.contains(com.anythink.expressad.videocommon.b.m.b)) {
            boolean isEmpty = android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.i.a().c(str4));
            try {
                com.anythink.expressad.reward.a.c.g gVar = new com.anythink.expressad.reward.a.c.g(context, str, str2, str3, cVar2, 497, cVar.b, iVar, list);
                gVar.a(isEmpty);
                com.anythink.expressad.videocommon.b.i.a().b(str4, (com.anythink.expressad.videocommon.b.i.a) gVar);
                return;
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.getLocalizedMessage();
                    return;
                }
                return;
            }
        }
        boolean isEmpty2 = android.text.TextUtils.isEmpty(com.anythink.expressad.videocommon.b.j.a().b(str4));
        try {
            com.anythink.expressad.reward.a.c.d dVar = new com.anythink.expressad.reward.a.c.d(497, str, str2, str3, cVar2, iVar, cVar.b, list);
            dVar.a(isEmpty2);
            com.anythink.expressad.videocommon.b.i.a().b(str4, dVar);
        } catch (java.lang.Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.getLocalizedMessage();
            }
        }
    }

    private static /* synthetic */ void a(com.anythink.expressad.reward.a.c cVar, boolean z, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar2, java.util.List list, com.anythink.expressad.videocommon.e.d dVar, java.lang.String str, java.lang.String str2, int i2) {
        if (windVaneWebView != null) {
            if (cVar2 == null || dVar == null || cVar2.M() == null || android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str2);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", "data is null");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                } catch (java.lang.Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.getLocalizedMessage();
                        return;
                    }
                    return;
                }
            }
            if (!android.text.TextUtils.isEmpty(cVar2.M().e())) {
                if (android.text.TextUtils.isEmpty(cVar2.M().e()) || !cVar2.M().e().contains(com.anythink.expressad.foundation.d.c.d)) {
                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(cVar.new AnonymousClass3(z, windVaneWebView, cVar2, list, str, dVar, str2), i2 * 1000);
                    return;
                }
                return;
            }
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put("id", str2);
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                jSONObject4.put("result", 1);
                jSONObject4.put("error", "data is null");
                jSONObject3.put("data", jSONObject4);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (java.lang.Exception e3) {
                if (com.anythink.expressad.a.a) {
                    e3.getLocalizedMessage();
                }
            }
        }
    }

    private void a(boolean z, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, com.anythink.expressad.foundation.d.c cVar, java.util.List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.videocommon.e.d dVar, java.lang.String str, java.lang.String str2, int i2) {
        if (windVaneWebView != null) {
            if (cVar == null || dVar == null || cVar.M() == null || android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("id", str2);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", "data is null");
                    jSONObject.put("data", jSONObject2);
                    com.anythink.expressad.atsignalcommon.windvane.j.a();
                    com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                } catch (java.lang.Exception e2) {
                    if (com.anythink.expressad.a.a) {
                        e2.getLocalizedMessage();
                        return;
                    }
                    return;
                }
            }
            if (!android.text.TextUtils.isEmpty(cVar.M().e())) {
                if (android.text.TextUtils.isEmpty(cVar.M().e()) || !cVar.M().e().contains(com.anythink.expressad.foundation.d.c.d)) {
                    new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(new com.anythink.expressad.reward.a.c.AnonymousClass3(z, windVaneWebView, cVar, list, str, dVar, str2), i2 * 1000);
                    return;
                }
                return;
            }
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            try {
                jSONObject3.put("id", str2);
                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                jSONObject4.put("result", 1);
                jSONObject4.put("error", "data is null");
                jSONObject3.put("data", jSONObject4);
                com.anythink.expressad.atsignalcommon.windvane.j.a();
                com.anythink.expressad.atsignalcommon.windvane.j.a((android.webkit.WebView) windVaneWebView, "onSubPlayTemplateViewLoad", android.util.Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (java.lang.Exception e3) {
                if (com.anythink.expressad.a.a) {
                    e3.getLocalizedMessage();
                }
            }
        }
    }

    private static void a(boolean z, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, int i2, com.anythink.expressad.foundation.d.c cVar, java.util.List<com.anythink.expressad.foundation.d.c> list, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar, java.lang.String str4, boolean z2) {
        com.anythink.expressad.video.signal.a.j jVar;
        java.lang.String Z;
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView d2 = com.anythink.expressad.reward.a.c.m.a.d();
            if (d2 == null) {
                d2 = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = d2;
            c0231a.a(windVaneWebView2);
            if (list == null || list.size() <= 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
                Z = cVar.Z();
            } else {
                java.util.List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (a2 != null && a2.size() > 0) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        com.anythink.expressad.foundation.d.c cVar2 = list.get(i3);
                        for (com.anythink.expressad.foundation.d.c cVar3 : a2) {
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                list.set(i3, cVar2);
                            }
                        }
                    }
                }
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
                Z = list.get(0).Z();
            }
            java.lang.String str5 = Z;
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(i2);
            jVar2.a(str3);
            jVar2.c(str4);
            jVar2.a(dVar);
            jVar2.b(z);
            windVaneWebView2.setWebViewListener(new com.anythink.expressad.reward.a.c.l(str4, windVaneWebView, str, str3, c0231a, cVar, z2, str5));
            windVaneWebView2.setObject(jVar2);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str5);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.getLocalizedMessage();
            }
        }
    }

    public static /* synthetic */ void a(boolean z, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, java.util.List list, java.lang.String str2, java.lang.String str3, com.anythink.expressad.videocommon.e.d dVar, java.lang.String str4, boolean z2) {
        com.anythink.expressad.video.signal.a.j jVar;
        java.lang.String Z;
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView d2 = com.anythink.expressad.reward.a.c.m.a.d();
            if (d2 == null) {
                d2 = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = d2;
            c0231a.a(windVaneWebView2);
            if (list == null || list.size() <= 0) {
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar);
                Z = cVar.Z();
            } else {
                java.util.List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (a2 != null && a2.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) list.get(i2);
                        for (com.anythink.expressad.foundation.d.c cVar3 : a2) {
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                list.set(i2, cVar2);
                            }
                        }
                    }
                }
                jVar = new com.anythink.expressad.video.signal.a.j(null, cVar, list);
                Z = ((com.anythink.expressad.foundation.d.c) list.get(0)).Z();
            }
            java.lang.String str5 = Z;
            com.anythink.expressad.video.signal.a.j jVar2 = jVar;
            jVar2.a(0);
            jVar2.a(str3);
            jVar2.c(str4);
            jVar2.a(dVar);
            jVar2.b(z);
            windVaneWebView2.setWebViewListener(new com.anythink.expressad.reward.a.c.l(str4, windVaneWebView, str, str3, c0231a, cVar, z2, str5));
            windVaneWebView2.setObject(jVar2);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, str2);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str5);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.getLocalizedMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized java.lang.String b(int i2) {
        synchronized (com.anythink.expressad.reward.a.c.class) {
            return i2 != 200 ? i2 != 201 ? i2 != 203 ? i2 != 205 ? "unknown" : "tpl" : "temp" : "zip/html" : "video";
        }
    }

    private static java.lang.String c(int i2) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("code", i2);
            java.lang.String jSONObject2 = jSONObject.toString();
            return !android.text.TextUtils.isEmpty(jSONObject2) ? android.util.Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private synchronized void c() {
    }

    private synchronized com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView d() {
        return null;
    }

    public final synchronized void a(android.content.Context context, com.anythink.expressad.foundation.d.c cVar, java.lang.String str, java.lang.String str2, java.lang.String str3, com.anythink.expressad.reward.a.c.i iVar) {
        this.b.a(context);
        if (cVar != null) {
            java.lang.String ar = cVar.ar();
            if (cVar.j()) {
                com.anythink.expressad.videocommon.b.l.a().b(ar, true);
                android.os.Message obtain = android.os.Message.obtain();
                obtain.what = 105;
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("unit_id", str2);
                bundle.putString(com.anythink.expressad.a.y, str);
                bundle.putString("request_id", str3);
                bundle.putString("url", ar);
                obtain.setData(bundle);
                this.b.sendMessage(obtain);
                iVar.a(str, str2, str3);
                return;
            }
        }
        if (cVar != null && !android.text.TextUtils.isEmpty(cVar.ar())) {
            try {
                com.anythink.expressad.videocommon.b.i.a().b(cVar.ar(), (com.anythink.expressad.videocommon.b.i.a) new com.anythink.expressad.reward.a.c.AnonymousClass2(str2, str, str3, iVar));
            } catch (java.lang.Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.getLocalizedMessage();
                }
            }
        }
    }

    public final synchronized void a(android.content.Context context, boolean z, int i2, boolean z2, int i3, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, com.anythink.expressad.reward.a.c.InterfaceC0216c interfaceC0216c, com.anythink.expressad.reward.a.c.i iVar) {
        java.lang.String str4 = str2 + "_" + str3;
        d.put(str4, new com.anythink.expressad.reward.a.c.a(z, z2, i2, copyOnWriteArrayList.size(), str2, str3, i3, copyOnWriteArrayList));
        this.b.a(str2, str3, interfaceC0216c);
        this.b.a(context);
        this.b.a(str4, copyOnWriteArrayList);
        this.b.post(new com.anythink.expressad.reward.a.c.AnonymousClass1(copyOnWriteArrayList, context, str2, i3, str, str3, iVar));
    }

    public final synchronized void a(boolean z, android.os.Handler handler, boolean z2, boolean z3, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView, java.lang.String str, int i2, com.anythink.expressad.foundation.d.c cVar, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.anythink.expressad.videocommon.e.d dVar, com.anythink.expressad.reward.a.c.j jVar) {
        com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            if (com.anythink.expressad.foundation.h.t.e(str)) {
                jVar.a();
                return;
            }
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView d2 = com.anythink.expressad.reward.a.c.m.a.d();
            if (d2 == null) {
                try {
                    windVaneWebView2 = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
                } catch (java.lang.Exception unused) {
                    c0231a.a(true);
                    com.anythink.expressad.videocommon.b.l.a().c(str4 + "_" + str5 + "_" + str, true);
                    jVar.a();
                    return;
                } catch (java.lang.Throwable unused2) {
                    c0231a.a(true);
                    com.anythink.expressad.videocommon.b.l.a().c(str4 + "_" + str5 + "_" + str, true);
                    jVar.a();
                    return;
                }
            } else {
                windVaneWebView2 = d2;
            }
            c0231a.a(windVaneWebView2);
            com.anythink.expressad.video.signal.a.j jVar2 = (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) ? new com.anythink.expressad.video.signal.a.j(null, cVar) : new com.anythink.expressad.video.signal.a.j(null, cVar, copyOnWriteArrayList);
            jVar2.a(i2);
            jVar2.a(str4);
            jVar2.a(dVar);
            jVar2.b(z);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView3 = windVaneWebView2;
            windVaneWebView3.setWebViewListener(new com.anythink.expressad.reward.a.c.k(handler, null, z2, z3, str5, jVar, windVaneWebView, str, str3, str4, c0231a, cVar, copyOnWriteArrayList, currentTimeMillis));
            windVaneWebView3.setObject(jVar2);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView3, str2);
            windVaneWebView3.loadUrl(str2);
            windVaneWebView3.setRid(str5);
        } catch (java.lang.Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.getLocalizedMessage();
            }
            jVar.a(e2.getLocalizedMessage());
        }
    }

    public final synchronized void a(boolean z, android.os.Handler handler, boolean z2, boolean z3, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, com.anythink.expressad.foundation.d.c cVar, java.util.concurrent.CopyOnWriteArrayList<com.anythink.expressad.foundation.d.c> copyOnWriteArrayList, java.lang.String str5, java.lang.String str6, com.anythink.expressad.videocommon.e.d dVar, com.anythink.expressad.reward.a.c.j jVar) {
        com.anythink.expressad.video.signal.a.j jVar2;
        this.e = false;
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        this.e = false;
        if (com.anythink.expressad.foundation.h.t.e(str4)) {
            jVar.a();
            return;
        }
        try {
            com.anythink.expressad.videocommon.a.C0231a c0231a = new com.anythink.expressad.videocommon.a.C0231a();
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView d2 = com.anythink.expressad.reward.a.c.m.a.d();
            if (d2 == null) {
                d2 = new com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView(com.anythink.core.common.b.o.a().f());
            }
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = d2;
            c0231a.a(windVaneWebView);
            com.anythink.expressad.video.bt.a.c.a();
            java.lang.String b2 = com.anythink.expressad.video.bt.a.c.b();
            com.anythink.expressad.video.bt.a.c.a();
            java.lang.String b3 = com.anythink.expressad.video.bt.a.c.b();
            c0231a.a(b3);
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar);
            } else {
                java.util.List<com.anythink.expressad.foundation.d.c> a2 = com.anythink.expressad.videocommon.b.e.a().a(str3);
                if (a2 != null && a2.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        com.anythink.expressad.foundation.d.c cVar2 = copyOnWriteArrayList.get(i3);
                        for (com.anythink.expressad.foundation.d.c cVar3 : a2) {
                            java.util.List<com.anythink.expressad.foundation.d.c> list = a2;
                            if (cVar3.aZ().equals(cVar2.aZ()) && cVar3.Z().equals(cVar2.Z())) {
                                cVar2.au();
                                copyOnWriteArrayList.set(i3, cVar2);
                            }
                            a2 = list;
                        }
                    }
                }
                jVar2 = new com.anythink.expressad.video.signal.a.j(null, cVar, copyOnWriteArrayList);
            }
            com.anythink.expressad.video.signal.a.j jVar3 = jVar2;
            jVar3.a(i2);
            jVar3.a(str6);
            jVar3.c(b3);
            jVar3.d(b2);
            jVar3.p();
            jVar3.a(dVar);
            jVar3.b(z);
            windVaneWebView.setWebViewListener(new com.anythink.expressad.reward.a.c.b(z, handler, null, z2, z3, i2, str4, str2, str3, str, c0231a, cVar, copyOnWriteArrayList, dVar, jVar, currentTimeMillis));
            windVaneWebView.setObject(jVar3);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, str5);
            windVaneWebView.loadUrl(str5);
            windVaneWebView.setRid(str);
            com.anythink.expressad.video.bt.module.AnythinkBTRootLayout anythinkBTRootLayout = new com.anythink.expressad.video.bt.module.AnythinkBTRootLayout(com.anythink.core.common.b.o.a().f());
            anythinkBTRootLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            anythinkBTRootLayout.setInstanceId(b2);
            anythinkBTRootLayout.setUnitId(str3);
            com.anythink.expressad.video.bt.module.AnythinkBTLayout anythinkBTLayout = new com.anythink.expressad.video.bt.module.AnythinkBTLayout(com.anythink.core.common.b.o.a().f());
            anythinkBTLayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            anythinkBTLayout.setInstanceId(b3);
            anythinkBTLayout.setUnitId(str3);
            anythinkBTLayout.setWebView(windVaneWebView);
            java.util.AbstractMap b4 = com.anythink.expressad.video.bt.a.c.a().b(str3, str);
            b4.put(b3, anythinkBTLayout);
            b4.put(b2, anythinkBTRootLayout);
            anythinkBTRootLayout.addView(anythinkBTLayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
        } catch (java.lang.Exception e2) {
            jVar.a(e2.getMessage());
            if (com.anythink.expressad.a.a) {
                e2.getLocalizedMessage();
            }
        }
    }
}
