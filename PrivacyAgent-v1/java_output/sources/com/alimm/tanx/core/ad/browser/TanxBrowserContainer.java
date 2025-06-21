package com.alimm.tanx.core.ad.browser;

/* loaded from: classes.dex */
public class TanxBrowserContainer extends android.widget.FrameLayout implements android.webkit.DownloadListener {
    protected com.alimm.tanx.core.bridge.TanxJsBridge tanxc_byte;
    private android.widget.ProgressBar tanxc_case;
    private boolean tanxc_char;
    protected android.content.Context tanxc_do;
    private com.alimm.tanx.core.ad.browser.IAdWebViewCallback tanxc_else;
    protected java.lang.String tanxc_for;
    protected android.webkit.WebView tanxc_if;
    protected android.view.ViewGroup tanxc_int;
    protected long tanxc_new;
    protected boolean tanxc_try;

    /* renamed from: com.alimm.tanx.core.ad.browser.TanxBrowserContainer$1, reason: invalid class name */
    public class AnonymousClass1 extends android.webkit.WebViewClient {
        public AnonymousClass1() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onPageFinished: time = " + (java.lang.System.currentTimeMillis() - com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_new) + "; url = " + str);
            if (com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case != null) {
                com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case.setVisibility(8);
            }
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_byte.injectJavascript();
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_byte.ready();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onPageStarted: url = " + str);
            if (com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case != null) {
                com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onReceivedError: errorCode = " + i + ", url = " + str2 + ", description = " + str);
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_char();
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(21)
        public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onReceivedHttpError: code = " + webResourceResponse.getStatusCode());
                com.alimm.tanx.core.ad.browser.TanxBrowserContainer tanxBrowserContainer = com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this;
                webResourceResponse.getStatusCode();
                tanxBrowserContainer.tanxc_char();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onReceivedSslError: handler = " + sslErrorHandler + ", error = " + sslError);
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            if (webView.getHitTestResult() != null) {
                com.alimm.tanx.core.ad.interaction.tanxc_if.tanxc_do(webView.getHitTestResult().getType(), com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_new);
            }
            return com.alimm.tanx.core.ad.interaction.tanxc_if.tanxc_do(webView.getContext(), str) || super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.browser.TanxBrowserContainer$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebChromeClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_else();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            super.onProgressChanged(webView, i);
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onProgressChanged: newProgress = " + i);
            if (com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case != null) {
                com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case.setProgress(i);
                if (i == 100) {
                    com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_case.setVisibility(8);
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_else.onTitleLoaded(str);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
            com.alimm.tanx.core.ad.browser.TanxBrowserContainer.this.tanxc_do(view, customViewCallback);
        }
    }

    public TanxBrowserContainer(android.content.Context context) {
        this(context, null);
    }

    public TanxBrowserContainer(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TanxBrowserContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tanxc_try = false;
        this.tanxc_char = false;
        try {
            this.tanxc_do = context;
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "AdClickWebViewContainer: mContext = " + this.tanxc_do);
            tanxc_do(this.tanxc_do);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("AdSystemWebViewContainer", e);
        }
    }

    @android.annotation.TargetApi(21)
    public TanxBrowserContainer(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.tanxc_try = false;
        this.tanxc_char = false;
        try {
            this.tanxc_do = context;
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "AdClickWebViewContainer: mContext = " + this.tanxc_do);
            tanxc_do(this.tanxc_do);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("AdSystemWebViewContainer", e);
        }
    }

    private void tanxc_case() {
        android.webkit.WebSettings settings = this.tanxc_if.getSettings();
        try {
            settings.setJavaScriptEnabled(true);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("AdSystemWebViewContainer", "initWebView: failed with exception.", e);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "AdSystemWebViewContainer", "initWebView: failed with exception." + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
        }
        settings.setUserAgentString(settings.getUserAgentString() + com.alimm.tanx.core.utils.AndroidUtils.getUserAgentSuffix() + com.alimm.tanx.core.utils.AndroidUtils.mediaNameStr());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("initWebSettings: userAgent = ");
        sb.append(settings.getUserAgentString());
        com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", sb.toString());
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(false);
        settings.setNeedInitialFocus(true);
        settings.setMixedContentMode(0);
        this.tanxc_if.setWebViewClient(new com.alimm.tanx.core.ad.browser.TanxBrowserContainer.AnonymousClass1());
        this.tanxc_if.setWebChromeClient(new com.alimm.tanx.core.ad.browser.TanxBrowserContainer.AnonymousClass2());
        this.tanxc_if.setDownloadListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_char() {
        android.widget.ProgressBar progressBar = this.tanxc_case;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.tanxc_char) {
            return;
        }
        this.tanxc_char = true;
    }

    private void tanxc_do(android.content.Context context) {
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            this.tanxc_if = webView;
            this.tanxc_byte = new com.alimm.tanx.core.bridge.TanxJsBridge(webView.getContext(), this.tanxc_if);
            this.tanxc_if.setBackgroundColor(0);
            this.tanxc_try = true;
            addView(this.tanxc_if, new android.widget.FrameLayout.LayoutParams(-1, -1));
            android.widget.FrameLayout frameLayout = new android.widget.FrameLayout(context);
            this.tanxc_int = frameLayout;
            frameLayout.setVisibility(8);
            addView(this.tanxc_int, -1, -1);
            tanxc_case();
        } catch (java.lang.Throwable th) {
            com.alimm.tanx.core.utils.LogUtils.e("AdSystemWebViewContainer", "Create new Webview exception.", th);
            com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), "AdSystemWebViewContainer", "Create new Webview exception." + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(th), "");
            this.tanxc_if = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(android.view.View view, android.webkit.WebChromeClient.CustomViewCallback customViewCallback) {
        com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "showCustomView: view = " + view + ", callback = " + customViewCallback + ", mPlayerContainer = " + this.tanxc_int);
        android.webkit.WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(8);
        }
        if (this.tanxc_int != null) {
            if (view != null && view.getParent() != null) {
                ((android.view.ViewGroup) view.getParent()).removeView(view);
            }
            this.tanxc_int.setVisibility(0);
            this.tanxc_int.addView(view);
        }
        com.alimm.tanx.core.ad.browser.IAdWebViewCallback iAdWebViewCallback = this.tanxc_else;
        if (iAdWebViewCallback != null) {
            iAdWebViewCallback.onShowCustomView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_else() {
        com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "showCustomView: mDefaultWebView = " + this.tanxc_if + ", mPlayerContainer = " + this.tanxc_int);
        android.webkit.WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.setVisibility(0);
        }
        android.view.ViewGroup viewGroup = this.tanxc_int;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.tanxc_int.setVisibility(8);
        }
        com.alimm.tanx.core.ad.browser.IAdWebViewCallback iAdWebViewCallback = this.tanxc_else;
        if (iAdWebViewCallback != null) {
            iAdWebViewCallback.onHideCustomView();
        }
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "onDownloadStart: url = " + str + ", mimeType = " + str4 + ", contentLength = " + j);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(android.net.Uri.parse(str));
        this.tanxc_do.startActivity(intent);
    }

    public boolean tanxc_byte() {
        android.view.ViewGroup viewGroup = this.tanxc_int;
        if (viewGroup != null && viewGroup.getChildCount() > 0) {
            tanxc_else();
            return true;
        }
        android.webkit.WebView webView = this.tanxc_if;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.tanxc_if.goBack();
        return true;
    }

    public void tanxc_do(android.widget.ProgressBar progressBar) {
        this.tanxc_case = progressBar;
    }

    public void tanxc_do(com.alimm.tanx.core.ad.browser.IAdWebViewCallback iAdWebViewCallback) {
        this.tanxc_else = iAdWebViewCallback;
    }

    public void tanxc_do(com.alimm.tanx.core.bridge.JsBridgeBean jsBridgeBean, com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface, com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface adInterface) {
        com.alimm.tanx.core.bridge.JsBridgeUtil jsBridgeUtil = new com.alimm.tanx.core.bridge.JsBridgeUtil();
        jsBridgeUtil.initJsBridge(this.tanxc_byte, jsBridgeBean, baseWebInterface, adInterface);
        jsBridgeUtil.setShowWebBar(this.tanxc_byte, false);
    }

    public boolean tanxc_do() {
        return this.tanxc_try;
    }

    public boolean tanxc_do(java.lang.String str, com.alimm.tanx.core.bridge.JsBridgeBean jsBridgeBean, com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface, com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface adInterface) {
        if (android.text.TextUtils.isEmpty(str) || this.tanxc_if == null) {
            com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "loadUrl: skip because url is empty.");
            return false;
        }
        tanxc_do(jsBridgeBean, baseWebInterface, adInterface);
        this.tanxc_new = java.lang.System.currentTimeMillis();
        this.tanxc_for = str;
        com.alimm.tanx.core.utils.LogUtils.d("AdSystemWebViewContainer", "loadUrl  mUrl == " + this.tanxc_for);
        android.webkit.WebView webView = this.tanxc_if;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
        webView.loadUrl(str);
        return true;
    }

    public void tanxc_for() {
        android.webkit.WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.reload();
        }
    }

    public java.lang.String tanxc_if() {
        android.webkit.WebView webView = this.tanxc_if;
        return webView != null ? webView.getUrl() : "";
    }

    public void tanxc_int() {
        android.webkit.WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.onPause();
        }
    }

    public void tanxc_new() {
        android.webkit.WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void tanxc_try() {
        android.webkit.WebView webView = this.tanxc_if;
        if (webView != null) {
            webView.removeAllViews();
            this.tanxc_if = null;
        }
    }
}
