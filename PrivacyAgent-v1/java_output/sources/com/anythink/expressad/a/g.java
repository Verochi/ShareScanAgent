package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public class g {
    public static long a = 0;
    private static final java.lang.String d = "g";
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 0;
    boolean b;
    boolean c;
    private int e;
    private int f;
    private com.anythink.expressad.d.a h;
    private com.anythink.expressad.a.g.a i;
    private java.lang.String j;
    private java.lang.String k;
    private android.webkit.WebView l;
    private boolean m;
    private java.lang.String n;
    private int o;
    private boolean t;

    /* renamed from: s, reason: collision with root package name */
    private boolean f194s = false;
    private final java.lang.Runnable u = new com.anythink.expressad.a.g.AnonymousClass4();
    private final java.lang.Runnable v = new com.anythink.expressad.a.g.AnonymousClass5();
    private android.os.Handler g = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.anythink.expressad.a.g$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ android.content.Context d;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.Context context) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.a.g gVar = com.anythink.expressad.a.g.this;
            gVar.a(this.b, this.c, this.d, gVar.j);
        }
    }

    /* renamed from: com.anythink.expressad.a.g$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebViewClient {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass2(java.lang.String str, java.lang.String str2) {
            this.a = str;
            this.b = str2;
        }

        private boolean a() {
            com.anythink.expressad.a.g gVar = com.anythink.expressad.a.g.this;
            return gVar.b || gVar.c;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            try {
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, "javascript:window.navigator.vibrate([]);");
                webView.loadUrl("javascript:window.navigator.vibrate([]);");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            try {
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, "javascript:window.navigator.vibrate([]);");
                webView.loadUrl("javascript:window.navigator.vibrate([]);");
                if (com.anythink.expressad.a.g.this.t) {
                    com.anythink.expressad.a.g.this.o = 0;
                    com.anythink.expressad.a.g.c(com.anythink.expressad.a.g.this);
                    return;
                }
                com.anythink.expressad.a.g.this.c = false;
                if (webView.getTag() == null) {
                    webView.setTag("has_first_started");
                } else {
                    com.anythink.expressad.a.g.this.b = true;
                }
                synchronized (com.anythink.expressad.a.g.d) {
                    com.anythink.expressad.a.g gVar = com.anythink.expressad.a.g.this;
                    if (gVar.b || gVar.c) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("load page-start:");
                        sb.append("(redirect)");
                    }
                    if (android.webkit.URLUtil.isHttpsUrl(str)) {
                        java.lang.String unused = com.anythink.expressad.a.g.d;
                    } else {
                        java.lang.String unused2 = com.anythink.expressad.a.g.d;
                    }
                    com.anythink.expressad.a.g.this.j = str;
                    if (com.anythink.expressad.a.g.this.i == null || !com.anythink.expressad.a.g.this.i.a(str)) {
                        com.anythink.expressad.a.g.f(com.anythink.expressad.a.g.this);
                    } else {
                        com.anythink.expressad.a.g.e(com.anythink.expressad.a.g.this);
                        com.anythink.expressad.a.g.c(com.anythink.expressad.a.g.this);
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            java.lang.String unused = com.anythink.expressad.a.g.d;
            webView.getUrl();
            synchronized (com.anythink.expressad.a.g.d) {
                com.anythink.expressad.a.g.e(com.anythink.expressad.a.g.this);
                com.anythink.expressad.a.g.this.f();
                com.anythink.expressad.a.g.c(com.anythink.expressad.a.g.this);
            }
            if (com.anythink.expressad.a.g.this.i != null) {
                com.anythink.expressad.a.g.this.i.a(webView.getUrl(), str, com.anythink.expressad.a.g.this.n);
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            try {
                java.lang.String unused = com.anythink.expressad.a.g.d;
                if (com.anythink.expressad.a.q && sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
                if (android.text.TextUtils.isEmpty(this.a)) {
                    return;
                }
                android.text.TextUtils.isEmpty(this.b);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            synchronized (com.anythink.expressad.a.g.d) {
                java.lang.String unused = com.anythink.expressad.a.g.d;
                com.anythink.expressad.a.g gVar = com.anythink.expressad.a.g.this;
                gVar.c = true;
                gVar.j();
                if (com.anythink.expressad.a.g.this.t) {
                    com.anythink.expressad.a.g.this.h();
                    com.anythink.expressad.a.g.c(com.anythink.expressad.a.g.this);
                    return true;
                }
                com.anythink.expressad.a.g.this.j = str;
                if (com.anythink.expressad.a.g.this.i != null && com.anythink.expressad.a.g.this.i.b(str)) {
                    com.anythink.expressad.a.g.e(com.anythink.expressad.a.g.this);
                    com.anythink.expressad.a.g.this.h();
                    com.anythink.expressad.a.g.c(com.anythink.expressad.a.g.this);
                    return true;
                }
                if (com.anythink.expressad.a.g.this.m) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    if (com.anythink.expressad.a.g.this.l.getUrl() != null) {
                        hashMap.put(com.google.common.net.HttpHeaders.REFERER, com.anythink.expressad.a.g.this.l.getUrl());
                    }
                    android.webkit.WebView webView2 = com.anythink.expressad.a.g.this.l;
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView2, str, hashMap);
                    webView2.loadUrl(str, hashMap);
                } else {
                    android.webkit.WebView webView3 = com.anythink.expressad.a.g.this.l;
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView3, str);
                    webView3.loadUrl(str);
                }
                return true;
            }
        }
    }

    /* renamed from: com.anythink.expressad.a.g$3, reason: invalid class name */
    public class AnonymousClass3 extends android.webkit.WebChromeClient {
        public AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsConfirm(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(android.webkit.WebView webView, int i) {
            if (i == 100) {
                try {
                    java.lang.String unused = com.anythink.expressad.a.g.d;
                    webView.getUrl();
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, "javascript:window.navigator.vibrate([]);");
                    webView.loadUrl("javascript:window.navigator.vibrate([]);");
                    if (!com.anythink.expressad.a.g.this.t) {
                        com.anythink.expressad.a.g gVar = com.anythink.expressad.a.g.this;
                        if (!gVar.c) {
                            com.anythink.expressad.a.g.m(gVar);
                        }
                    }
                    if (com.anythink.expressad.a.g.this.i != null) {
                        com.anythink.expressad.a.g.a aVar = com.anythink.expressad.a.g.this.i;
                        webView.getUrl();
                        aVar.a();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.anythink.expressad.a.g$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.a.g.n(com.anythink.expressad.a.g.this);
            com.anythink.expressad.a.g.this.o = 1;
            java.lang.String unused = com.anythink.expressad.a.g.d;
            int unused2 = com.anythink.expressad.a.g.this.f;
            com.anythink.expressad.a.g.p(com.anythink.expressad.a.g.this);
        }
    }

    /* renamed from: com.anythink.expressad.a.g$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.expressad.a.g.n(com.anythink.expressad.a.g.this);
            com.anythink.expressad.a.g.this.o = 2;
            java.lang.String unused = com.anythink.expressad.a.g.d;
            int unused2 = com.anythink.expressad.a.g.this.e;
            com.anythink.expressad.a.g.p(com.anythink.expressad.a.g.this);
        }
    }

    public interface a {
        void a(java.lang.String str, java.lang.String str2);

        void a(java.lang.String str, java.lang.String str2, java.lang.String str3);

        boolean a();

        boolean a(java.lang.String str);

        boolean b(java.lang.String str);
    }

    public g(boolean z) {
        this.e = 15000;
        this.f = 3000;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        this.h = b;
        if (b == null) {
            com.anythink.expressad.d.b.a();
            this.h = com.anythink.expressad.d.b.c();
        }
        this.m = this.h.v();
        if (z) {
            this.e = (int) this.h.q();
            this.f = (int) this.h.q();
        } else {
            this.e = (int) this.h.r();
            this.f = (int) this.h.r();
        }
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    private void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.webkit.WebView webView = new android.webkit.WebView(context);
        this.l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.l.getSettings().setCacheMode(2);
        this.l.getSettings().setLoadsImagesAutomatically(false);
        this.l.setWebViewClient(new com.anythink.expressad.a.g.AnonymousClass2(str2, str));
        this.l.setWebChromeClient(new com.anythink.expressad.a.g.AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, java.lang.String str2, android.content.Context context, java.lang.String str3) {
        try {
            a(context, str, str2);
            if (!android.text.TextUtils.isEmpty(this.k)) {
                this.l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f = 2000;
                this.e = 2000;
                android.webkit.WebView webView = this.l;
                java.lang.String str4 = this.k;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(webView, str3, str4, "*/*", "utf-8", str3);
                webView.loadDataWithBaseURL(str3, str4, "*/*", "utf-8", str3);
                return;
            }
            if (!this.m) {
                android.webkit.WebView webView2 = this.l;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView2, str3);
                webView2.loadUrl(str3);
            } else {
                java.util.HashMap hashMap = new java.util.HashMap();
                if (this.l.getUrl() != null) {
                    hashMap.put(com.google.common.net.HttpHeaders.REFERER, this.l.getUrl());
                }
                android.webkit.WebView webView3 = this.l;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView3, str3, hashMap);
                webView3.loadUrl(str3, hashMap);
            }
        } catch (java.lang.Throwable th) {
            try {
                com.anythink.expressad.a.g.a aVar = this.i;
                if (aVar != null) {
                    aVar.a(this.j, th.getMessage(), this.n);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.Context context) {
        if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
            a(str2, str3, context, this.j);
        } else {
            this.g.post(new com.anythink.expressad.a.g.AnonymousClass1(str, str2, str3, context));
        }
    }

    private void b() {
        synchronized (d) {
            try {
                f();
                com.anythink.expressad.a.g.a aVar = this.i;
                if (aVar != null) {
                    aVar.a(this.j, this.n);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void c() {
        synchronized (d) {
            try {
                f();
                this.l.destroy();
                com.anythink.expressad.a.g.a aVar = this.i;
                if (aVar != null) {
                    aVar.a(this.j, this.n);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static /* synthetic */ void c(com.anythink.expressad.a.g gVar) {
        synchronized (d) {
            try {
                gVar.f();
                com.anythink.expressad.a.g.a aVar = gVar.i;
                if (aVar != null) {
                    aVar.a(gVar.j, gVar.n);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private void d() {
        h();
        this.g.postDelayed(this.v, this.e);
    }

    private void e() {
        j();
        this.g.postDelayed(this.u, this.f);
    }

    public static /* synthetic */ boolean e(com.anythink.expressad.a.g gVar) {
        gVar.t = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        j();
        h();
    }

    public static /* synthetic */ void f(com.anythink.expressad.a.g gVar) {
        gVar.h();
        gVar.g.postDelayed(gVar.v, gVar.e);
    }

    private void g() {
        this.g.postDelayed(this.v, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.g.removeCallbacks(this.v);
    }

    private void i() {
        this.g.postDelayed(this.u, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.g.removeCallbacks(this.u);
    }

    public static /* synthetic */ void m(com.anythink.expressad.a.g gVar) {
        gVar.j();
        gVar.g.postDelayed(gVar.u, gVar.f);
    }

    public static /* synthetic */ boolean n(com.anythink.expressad.a.g gVar) {
        gVar.f194s = true;
        return true;
    }

    public static /* synthetic */ void p(com.anythink.expressad.a.g gVar) {
        synchronized (d) {
            try {
                gVar.f();
                gVar.l.destroy();
                com.anythink.expressad.a.g.a aVar = gVar.i;
                if (aVar != null) {
                    aVar.a(gVar.j, gVar.n);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.Context context, java.lang.String str4, com.anythink.expressad.a.g.a aVar) {
        if (aVar == null) {
            throw new java.lang.NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.j = str4;
        this.i = aVar;
        a(str, str2, str3, context);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.Context context, java.lang.String str4, java.lang.String str5, com.anythink.expressad.a.g.a aVar) {
        if (aVar == null) {
            throw new java.lang.NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.k = str5;
        this.j = str4;
        this.i = aVar;
        a(str, str2, str3, context);
    }
}
