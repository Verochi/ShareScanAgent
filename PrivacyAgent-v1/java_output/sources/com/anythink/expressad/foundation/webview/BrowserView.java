package com.anythink.expressad.foundation.webview;

/* loaded from: classes12.dex */
public class BrowserView extends android.widget.LinearLayout {
    private static final java.lang.String a = "BrowserView";
    private java.lang.String b;
    private com.anythink.expressad.foundation.webview.ProgressBar c;
    private android.webkit.WebView d;
    private com.anythink.expressad.foundation.webview.ToolBar e;
    private com.anythink.expressad.foundation.webview.BrowserView.a f;
    private com.anythink.expressad.foundation.d.c g;

    /* renamed from: com.anythink.expressad.foundation.webview.BrowserView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null) {
                com.anythink.expressad.foundation.webview.BrowserView.this.d.stopLoading();
            }
            java.lang.String str = (java.lang.String) view.getTag();
            boolean z = false;
            if (android.text.TextUtils.equals(str, "backward")) {
                com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("forward").setEnabled(true);
                if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null && com.anythink.expressad.foundation.webview.BrowserView.this.d.canGoBack()) {
                    com.anythink.expressad.foundation.webview.BrowserView.this.d.goBack();
                }
                android.view.View item = com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("backward");
                if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null && com.anythink.expressad.foundation.webview.BrowserView.this.d.canGoBack()) {
                    z = true;
                }
                item.setEnabled(z);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (android.text.TextUtils.equals(str, "forward")) {
                com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("backward").setEnabled(true);
                if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null && com.anythink.expressad.foundation.webview.BrowserView.this.d.canGoForward()) {
                    com.anythink.expressad.foundation.webview.BrowserView.this.d.goForward();
                }
                android.view.View item2 = com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("forward");
                if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null && com.anythink.expressad.foundation.webview.BrowserView.this.d.canGoForward()) {
                    z = true;
                }
                item2.setEnabled(z);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (android.text.TextUtils.equals(str, com.alipay.sdk.m.x.d.w)) {
                com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("backward").setEnabled(com.anythink.expressad.foundation.webview.BrowserView.this.d != null && com.anythink.expressad.foundation.webview.BrowserView.this.d.canGoBack());
                android.view.View item3 = com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("forward");
                if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null && com.anythink.expressad.foundation.webview.BrowserView.this.d.canGoForward()) {
                    z = true;
                }
                item3.setEnabled(z);
                if (com.anythink.expressad.foundation.webview.BrowserView.this.d != null) {
                    android.webkit.WebView webView = com.anythink.expressad.foundation.webview.BrowserView.this.d;
                    java.lang.String str2 = com.anythink.expressad.foundation.webview.BrowserView.this.b;
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str2);
                    webView.loadUrl(str2);
                    com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
            } else if (android.text.TextUtils.equals(str, "exits") && com.anythink.expressad.foundation.webview.BrowserView.this.f != null) {
                com.anythink.expressad.foundation.webview.BrowserView.this.f.a();
            }
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.anythink.expressad.foundation.webview.BrowserView$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebViewClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            com.anythink.expressad.foundation.webview.BrowserView.this.b = str;
            if (com.anythink.expressad.foundation.webview.BrowserView.this.f != null) {
                com.anythink.expressad.foundation.webview.BrowserView.a unused = com.anythink.expressad.foundation.webview.BrowserView.this.f;
            }
            com.anythink.expressad.foundation.webview.BrowserView.this.c.setVisible(true);
            com.anythink.expressad.foundation.webview.BrowserView.this.c.setProgressState(5);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("backward").setEnabled(true);
            com.anythink.expressad.foundation.webview.BrowserView.this.e.getItem("forward").setEnabled(false);
            if (com.anythink.expressad.foundation.webview.BrowserView.this.f != null) {
                com.anythink.expressad.foundation.webview.BrowserView.this.f.a(webView, str);
            }
            return false;
        }
    }

    /* renamed from: com.anythink.expressad.foundation.webview.BrowserView$3, reason: invalid class name */
    public class AnonymousClass3 extends android.webkit.WebChromeClient {

        /* renamed from: com.anythink.expressad.foundation.webview.BrowserView$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.foundation.webview.BrowserView.this.c.setVisible(false);
            }
        }

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
                com.anythink.expressad.foundation.webview.BrowserView.this.c.setProgressState(7);
                new android.os.Handler().postDelayed(new com.anythink.expressad.foundation.webview.BrowserView.AnonymousClass3.AnonymousClass1(), 200L);
            }
        }
    }

    /* renamed from: com.anythink.expressad.foundation.webview.BrowserView$4, reason: invalid class name */
    public class AnonymousClass4 extends android.webkit.WebChromeClient {

        /* renamed from: com.anythink.expressad.foundation.webview.BrowserView$4$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.expressad.foundation.webview.BrowserView.this.c.setVisible(false);
            }
        }

        public AnonymousClass4() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(android.webkit.WebView webView, int i) {
            if (i == 100) {
                com.anythink.expressad.foundation.webview.BrowserView.this.c.setProgressState(7);
                new android.os.Handler().postDelayed(new com.anythink.expressad.foundation.webview.BrowserView.AnonymousClass4.AnonymousClass1(), 200L);
            }
        }
    }

    public static final class DownloadListener implements android.webkit.DownloadListener {
        private com.anythink.expressad.foundation.d.c campaignEx;
        private java.lang.String title;

        public DownloadListener() {
        }

        public DownloadListener(com.anythink.expressad.foundation.d.c cVar) {
            this.campaignEx = cVar;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        }

        public final void setTitle(java.lang.String str) {
            this.title = str;
        }
    }

    public interface a {
        void a();

        boolean a(android.webkit.WebView webView, java.lang.String str);

        void b();
    }

    public BrowserView(android.content.Context context) {
        super(context);
        init();
    }

    public BrowserView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BrowserView(android.content.Context context, com.anythink.expressad.foundation.d.c cVar) {
        super(context);
        this.g = cVar;
        init();
    }

    private void a() {
        com.anythink.expressad.foundation.webview.ProgressBar progressBar = new com.anythink.expressad.foundation.webview.ProgressBar(getContext());
        this.c = progressBar;
        progressBar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.d == null) {
                this.d = b();
            }
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.d.setLayoutParams(layoutParams);
        } catch (java.lang.Throwable unused) {
        }
        this.e = new com.anythink.expressad.foundation.webview.ToolBar(getContext());
        this.e.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, com.anythink.expressad.foundation.h.t.b(getContext(), 40.0f)));
        this.e.setBackgroundColor(-1);
        addView(this.c);
        android.webkit.WebView webView = this.d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.e);
    }

    private android.webkit.WebView b() {
        android.webkit.WebView webView = new android.webkit.WebView(getContext());
        try {
            android.webkit.WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setCacheMode(-1);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (java.lang.Throwable th) {
                    th.getMessage();
                }
            }
            settings.setMediaPlaybackRequiresUserGesture(false);
            try {
                settings.setAllowUniversalAccessFromFileURLs(false);
            } catch (java.lang.Throwable th2) {
                th2.getMessage();
            }
            try {
                settings.setMixedContentMode(1);
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
            try {
                java.lang.reflect.Method declaredMethod = android.webkit.WebSettings.class.getDeclaredMethod(com.anythink.core.common.o.d.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), java.lang.Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, 0);
            } catch (java.lang.Throwable unused) {
            }
            settings.setDatabaseEnabled(true);
            java.lang.String path = getContext().getDir("database", 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                java.lang.reflect.Method declaredMethod2 = android.webkit.WebSettings.class.getDeclaredMethod("setDisplayZoomControls", java.lang.Boolean.TYPE);
                declaredMethod2.setAccessible(true);
                declaredMethod2.invoke(settings, java.lang.Boolean.FALSE);
            } catch (java.lang.Exception e2) {
                e2.getMessage();
            }
            try {
                java.lang.reflect.Method declaredMethod3 = android.webkit.WebSettings.class.getDeclaredMethod(com.anythink.core.common.o.d.b("c2V0QWxsb3dVbml2ZXJzYWxBY2Nlc3NGcm9tRmlsZVVSTHM="), java.lang.Boolean.TYPE);
                declaredMethod3.setAccessible(true);
                declaredMethod3.invoke(settings, java.lang.Boolean.TRUE);
            } catch (java.lang.Throwable unused2) {
            }
        } catch (java.lang.Throwable th3) {
            th3.getMessage();
        }
        webView.setDownloadListener(new com.anythink.expressad.foundation.webview.BrowserView.DownloadListener(this.g));
        webView.setWebViewClient(new com.anythink.expressad.foundation.webview.BrowserView.AnonymousClass2());
        webView.setWebChromeClient(com.anythink.expressad.foundation.h.k.d() <= 10 ? new com.anythink.expressad.foundation.webview.BrowserView.AnonymousClass3() : new com.anythink.expressad.foundation.webview.BrowserView.AnonymousClass4());
        return webView;
    }

    public void destroy() {
        android.webkit.WebView webView = this.d;
        if (webView != null) {
            webView.stopLoading();
            this.d.setWebViewClient(null);
            this.d.destroy();
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        com.anythink.expressad.foundation.webview.ProgressBar progressBar = new com.anythink.expressad.foundation.webview.ProgressBar(getContext());
        this.c = progressBar;
        progressBar.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.d == null) {
                this.d = b();
            }
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.d.setLayoutParams(layoutParams);
        } catch (java.lang.Throwable unused) {
        }
        this.e = new com.anythink.expressad.foundation.webview.ToolBar(getContext());
        this.e.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, com.anythink.expressad.foundation.h.t.b(getContext(), 40.0f)));
        this.e.setBackgroundColor(-1);
        addView(this.c);
        android.webkit.WebView webView = this.d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.e);
        this.c.initResource(true);
        this.e.getItem("backward").setEnabled(false);
        this.e.getItem("forward").setEnabled(false);
        this.e.setOnItemClickListener(new com.anythink.expressad.foundation.webview.BrowserView.AnonymousClass1());
    }

    public void loadUrl(java.lang.String str) {
        android.webkit.WebView webView = this.d;
        if (webView != null) {
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
            webView.loadUrl(str);
        }
    }

    public void setListener(com.anythink.expressad.foundation.webview.BrowserView.a aVar) {
        this.f = aVar;
    }

    public void setWebView(android.webkit.WebView webView) {
        this.d = webView;
    }
}
