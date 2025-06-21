package com.alipay.sdk.m.x;

/* loaded from: classes.dex */
public class e extends android.widget.LinearLayout {
    public static android.os.Handler m = new android.os.Handler(android.os.Looper.getMainLooper());
    public android.widget.ImageView a;
    public android.widget.TextView b;
    public android.widget.ImageView c;
    public android.widget.ProgressBar d;
    public android.webkit.WebView e;
    public final com.alipay.sdk.m.x.e.C0050e f;
    public com.alipay.sdk.m.x.e.f g;
    public com.alipay.sdk.m.x.e.g h;
    public com.alipay.sdk.m.x.e.h i;
    public final com.alipay.sdk.m.s.a j;
    public android.view.View.OnClickListener k;
    public final float l;

    public class a implements android.view.View.OnClickListener {

        /* renamed from: com.alipay.sdk.m.x.e$a$a, reason: collision with other inner class name */
        public class RunnableC0049a implements java.lang.Runnable {
            public final /* synthetic */ android.view.View a;

            public RunnableC0049a(android.view.View view) {
                this.a = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.setEnabled(true);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.alipay.sdk.m.x.e.h hVar = com.alipay.sdk.m.x.e.this.i;
            if (hVar != null) {
                view.setEnabled(false);
                com.alipay.sdk.m.x.e.m.postDelayed(new com.alipay.sdk.m.x.e.a.RunnableC0049a(view), 256L);
                if (view == com.alipay.sdk.m.x.e.this.a) {
                    hVar.b(com.alipay.sdk.m.x.e.this);
                } else if (view == com.alipay.sdk.m.x.e.this.c) {
                    hVar.a(com.alipay.sdk.m.x.e.this);
                }
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements android.webkit.DownloadListener {
        public final /* synthetic */ android.content.Context a;

        public b(android.content.Context context) {
            this.a = context;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            try {
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                intent.setFlags(268435456);
                this.a.startActivity(intent);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public class c extends android.webkit.WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult) {
            return com.alipay.sdk.m.x.e.this.g.a(com.alipay.sdk.m.x.e.this, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            if (!com.alipay.sdk.m.x.e.this.f.b) {
                com.alipay.sdk.m.x.e.this.d.setVisibility(8);
            } else {
                if (i > 90) {
                    com.alipay.sdk.m.x.e.this.d.setVisibility(4);
                    return;
                }
                if (com.alipay.sdk.m.x.e.this.d.getVisibility() == 4) {
                    com.alipay.sdk.m.x.e.this.d.setVisibility(0);
                }
                com.alipay.sdk.m.x.e.this.d.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            com.alipay.sdk.m.x.e.this.g.c(com.alipay.sdk.m.x.e.this, str);
        }
    }

    public class d extends android.webkit.WebViewClient {
        public d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            if (com.alipay.sdk.m.x.e.this.h.b(com.alipay.sdk.m.x.e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            if (com.alipay.sdk.m.x.e.this.h.d(com.alipay.sdk.m.x.e.this, str)) {
                return;
            }
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            if (com.alipay.sdk.m.x.e.this.h.a(com.alipay.sdk.m.x.e.this, i, str, str2)) {
                return;
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            if (com.alipay.sdk.m.x.e.this.h.a(com.alipay.sdk.m.x.e.this, sslErrorHandler, sslError)) {
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            if (com.alipay.sdk.m.x.e.this.h.a(com.alipay.sdk.m.x.e.this, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* renamed from: com.alipay.sdk.m.x.e$e, reason: collision with other inner class name */
    public static final class C0050e {
        public boolean a;
        public boolean b;

        public C0050e(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }
    }

    public interface f {
        boolean a(com.alipay.sdk.m.x.e eVar, java.lang.String str, java.lang.String str2, java.lang.String str3, android.webkit.JsPromptResult jsPromptResult);

        void c(com.alipay.sdk.m.x.e eVar, java.lang.String str);
    }

    public interface g {
        boolean a(com.alipay.sdk.m.x.e eVar, int i, java.lang.String str, java.lang.String str2);

        boolean a(com.alipay.sdk.m.x.e eVar, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError);

        boolean a(com.alipay.sdk.m.x.e eVar, java.lang.String str);

        boolean b(com.alipay.sdk.m.x.e eVar, java.lang.String str);

        boolean d(com.alipay.sdk.m.x.e eVar, java.lang.String str);
    }

    public interface h {
        void a(com.alipay.sdk.m.x.e eVar);

        void b(com.alipay.sdk.m.x.e eVar);
    }

    public e(android.content.Context context, android.util.AttributeSet attributeSet, com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.x.e.C0050e c0050e) {
        super(context, attributeSet);
        this.k = new com.alipay.sdk.m.x.e.a();
        this.f = c0050e == null ? new com.alipay.sdk.m.x.e.C0050e(false, false) : c0050e;
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    public e(android.content.Context context, com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.x.e.C0050e c0050e) {
        this(context, null, aVar, c0050e);
    }

    private int a(int i) {
        return (int) (i * this.l);
    }

    private void a(android.content.Context context) {
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(this.f.a ? 0 : 8);
        android.widget.ImageView imageView = new android.widget.ImageView(context);
        this.a = imageView;
        imageView.setOnClickListener(this.k);
        this.a.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        this.a.setImageDrawable(com.alipay.sdk.m.u.k.a(com.alipay.sdk.m.u.k.a, context));
        this.a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.a, new android.widget.LinearLayout.LayoutParams(-2, -2));
        android.view.View view = new android.view.View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new android.widget.LinearLayout.LayoutParams(a(1), a(25)));
        android.widget.TextView textView = new android.widget.TextView(context);
        this.b = textView;
        textView.setTextColor(-15658735);
        this.b.setTextSize(17.0f);
        this.b.setMaxLines(1);
        this.b.setEllipsize(android.text.TextUtils.TruncateAt.END);
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams);
        android.widget.ImageView imageView2 = new android.widget.ImageView(context);
        this.c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.c.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        this.c.setImageDrawable(com.alipay.sdk.m.u.k.a(com.alipay.sdk.m.u.k.b, context));
        this.c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.c, new android.widget.LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new android.widget.LinearLayout.LayoutParams(-1, a(48)));
    }

    private void b(android.content.Context context) {
        android.widget.ProgressBar progressBar = new android.widget.ProgressBar(context, null, android.R.style.Widget.ProgressBar.Horizontal);
        this.d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(android.R.drawable.progress_horizontal));
        this.d.setMax(100);
        this.d.setBackgroundColor(-218103809);
        addView(this.d, new android.widget.LinearLayout.LayoutParams(-1, a(2)));
    }

    private void c(android.content.Context context) {
        android.webkit.WebView webView = new android.webkit.WebView(context);
        this.e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.e, context);
        android.webkit.WebSettings settings = this.e.getSettings();
        settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        settings.setSupportMultipleWindows(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(com.google.android.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_FRAGMENT_SIZE);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(false);
        settings.setTextSize(android.webkit.WebSettings.TextSize.NORMAL);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setCacheMode(1);
        settings.setDomStorageEnabled(true);
        settings.setAllowContentAccess(false);
        this.e.setVerticalScrollbarOverlay(true);
        this.e.setDownloadListener(new com.alipay.sdk.m.x.e.b(context));
        try {
            try {
                this.e.removeJavascriptInterface("searchBoxJavaBridge_");
                this.e.removeJavascriptInterface("accessibility");
                this.e.removeJavascriptInterface("accessibilityTraversal");
            } catch (java.lang.Exception unused) {
                java.lang.reflect.Method method = this.e.getClass().getMethod("removeJavascriptInterface", new java.lang.Class[0]);
                if (method != null) {
                    method.invoke(this.e, "searchBoxJavaBridge_");
                    method.invoke(this.e, "accessibility");
                    method.invoke(this.e, "accessibilityTraversal");
                }
            }
        } catch (java.lang.Throwable unused2) {
        }
        com.alipay.sdk.m.x.c.a(this.e);
        addView(this.e, new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    public void a() {
        removeAllViews();
        this.e.removeAllViews();
        this.e.setWebViewClient(null);
        this.e.setWebChromeClient(null);
        this.e.destroy();
    }

    public void a(android.webkit.WebView webView, android.content.Context context) {
        java.lang.String userAgentString = webView.getSettings().getUserAgentString();
        webView.getSettings().setUserAgentString(userAgentString + com.alipay.sdk.m.u.n.g(context));
    }

    public void a(java.lang.String str) {
        android.webkit.WebView webView = this.e;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
        webView.loadUrl(str);
        com.alipay.sdk.m.x.c.a(this.e);
    }

    public void a(java.lang.String str, byte[] bArr) {
        android.webkit.WebView webView = this.e;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.postUrl(webView, str, bArr);
        webView.postUrl(str, bArr);
    }

    public android.widget.ImageView getBackButton() {
        return this.a;
    }

    public android.widget.ProgressBar getProgressbar() {
        return this.d;
    }

    public android.widget.ImageView getRefreshButton() {
        return this.c;
    }

    public android.widget.TextView getTitle() {
        return this.b;
    }

    public java.lang.String getUrl() {
        return this.e.getUrl();
    }

    public android.webkit.WebView getWebView() {
        return this.e;
    }

    public void setChromeProxy(com.alipay.sdk.m.x.e.f fVar) {
        this.g = fVar;
        if (fVar == null) {
            this.e.setWebChromeClient(null);
        } else {
            this.e.setWebChromeClient(new com.alipay.sdk.m.x.e.c());
        }
    }

    public void setWebClientProxy(com.alipay.sdk.m.x.e.g gVar) {
        this.h = gVar;
        if (gVar == null) {
            this.e.setWebViewClient(null);
        } else {
            this.e.setWebViewClient(new com.alipay.sdk.m.x.e.d());
        }
    }

    public void setWebEventProxy(com.alipay.sdk.m.x.e.h hVar) {
        this.i = hVar;
    }
}
