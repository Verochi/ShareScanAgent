package com.huawei.secure.android.common.webview;

/* loaded from: classes22.dex */
public class SafeWebView extends android.webkit.WebView {
    public java.lang.String n;
    public java.lang.String[] t;
    public java.lang.String[] u;
    public java.lang.String[] v;
    public com.huawei.secure.android.common.webview.WebViewLoadCallBack w;

    public static class b implements android.content.DialogInterface.OnClickListener {
        public final android.webkit.SslErrorHandler n;

        public b(android.webkit.SslErrorHandler sslErrorHandler) {
            this.n = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            this.n.cancel();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public static class c implements android.content.DialogInterface.OnClickListener {
        public final android.webkit.SslErrorHandler n;

        public c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.n = sslErrorHandler;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            this.n.proceed();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public final class d extends android.webkit.WebViewClient {
        public android.webkit.WebViewClient a;
        public boolean b;

        public d(android.webkit.WebViewClient webViewClient, boolean z) {
            this.a = webViewClient;
            this.b = z;
        }

        public /* synthetic */ d(com.huawei.secure.android.common.webview.SafeWebView safeWebView, android.webkit.WebViewClient webViewClient, boolean z, com.huawei.secure.android.common.webview.SafeWebView.a aVar) {
            this(webViewClient, z);
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(android.webkit.WebView webView, java.lang.String str, boolean z) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(android.webkit.WebView webView, android.os.Message message, android.os.Message message2) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(android.webkit.WebView webView, java.lang.String str) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(23)
        public void onPageCommitVisible(android.webkit.WebView webView, java.lang.String str) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null && !this.b) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (com.huawei.secure.android.common.webview.SafeWebView.this.isWhiteListUrl(str)) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                com.huawei.secure.android.common.webview.SafeWebView.this.onCheckError(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(21)
        public void onReceivedClientCertRequest(android.webkit.WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(23)
        public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(android.webkit.WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, java.lang.String str, java.lang.String str2) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(23)
        public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(12)
        public void onReceivedLoginRequest(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, java.lang.String str3) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(8)
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(android.webkit.WebView webView, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean onRenderProcessGone;
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient == null) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            onRenderProcessGone = webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            return onRenderProcessGone;
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, int i, android.webkit.SafeBrowsingResponse safeBrowsingResponse) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i, safeBrowsingResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(android.webkit.WebView webView, android.os.Message message, android.os.Message message2) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(21)
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            android.webkit.WebViewClient webViewClient = this.a;
            return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(11)
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
            android.webkit.WebViewClient webViewClient = this.a;
            return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, str) : super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(android.webkit.WebView webView, android.view.KeyEvent keyEvent) {
            android.webkit.WebViewClient webViewClient = this.a;
            return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(24)
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            boolean shouldOverrideUrlLoading;
            android.webkit.WebViewClient webViewClient = this.a;
            if (webViewClient == null) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            shouldOverrideUrlLoading = webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            return shouldOverrideUrlLoading;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            android.webkit.WebViewClient webViewClient = this.a;
            return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
        }
    }

    public SafeWebView(android.content.Context context) {
        super(context);
        a();
    }

    public SafeWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SafeWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @android.annotation.TargetApi(21)
    public SafeWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a();
    }

    public final void a() {
        com.huawei.secure.android.common.webview.SafeWebSettings.initWebviewAndSettings(this);
        setWebViewClient(null);
    }

    public final boolean b(java.lang.String str) {
        return android.webkit.URLUtil.isHttpUrl(str);
    }

    public java.lang.String getDefaultErrorPage() {
        return this.n;
    }

    public com.huawei.secure.android.common.webview.WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.w;
    }

    @android.annotation.TargetApi(9)
    @java.lang.Deprecated
    public java.lang.String[] getWhitelist() {
        java.lang.String[] strArr = this.t;
        if (strArr == null) {
            return null;
        }
        return (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    public java.lang.String[] getWhitelistNotMatchSubDomain() {
        java.lang.String[] strArr = this.u;
        if (strArr == null) {
            return null;
        }
        return (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    @java.lang.Deprecated
    public java.lang.String[] getWhitelistNotMathcSubDomain() {
        java.lang.String[] strArr = this.u;
        if (strArr == null) {
            return null;
        }
        return (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    @android.annotation.TargetApi(9)
    public java.lang.String[] getWhitelistWithPath() {
        java.lang.String[] strArr = this.v;
        if (strArr == null) {
            return null;
        }
        return (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    @android.annotation.TargetApi(9)
    public boolean isWhiteListUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.huawei.secure.android.common.util.LogsUtil.e("SafeWebView", "url is null");
            return false;
        }
        if (!android.webkit.URLUtil.isNetworkUrl(str)) {
            return true;
        }
        java.lang.String[] whitelistWithPath = getWhitelistWithPath();
        java.lang.String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
        return (whitelistWithPath == null || whitelistWithPath.length == 0) ? (whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0) ? com.huawei.secure.android.common.webview.UriUtil.isUrlHostInWhitelist(str, getWhitelist()) : com.huawei.secure.android.common.webview.UriUtil.isUrlHostSameWhitelist(str, whitelistNotMatchSubDomain) : com.huawei.secure.android.common.webview.UriUtil.isUrlHostAndPathInWhitelist(str, whitelistWithPath);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        if (!b(str)) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else if (!android.text.TextUtils.isEmpty(this.n)) {
            super.loadDataWithBaseURL(this.n, str2, str3, str4, str5);
        } else if (getWebViewLoadCallBack() != null) {
            getWebViewLoadCallBack().onCheckError(str, com.huawei.secure.android.common.webview.WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(java.lang.String str) {
        if (!b(str)) {
            super.loadUrl(str);
        } else if (!android.text.TextUtils.isEmpty(this.n)) {
            super.loadUrl(this.n);
        } else if (getWebViewLoadCallBack() != null) {
            getWebViewLoadCallBack().onCheckError(str, com.huawei.secure.android.common.webview.WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (!b(str)) {
            super.loadUrl(str, map);
        } else if (!android.text.TextUtils.isEmpty(this.n)) {
            super.loadUrl(this.n, map);
        } else if (getWebViewLoadCallBack() != null) {
            getWebViewLoadCallBack().onCheckError(str, com.huawei.secure.android.common.webview.WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    public final void onCheckError(android.webkit.WebView webView, java.lang.String str) {
        com.huawei.secure.android.common.util.LogsUtil.e("SafeWebView", "onCheckError url is not in white list ", str);
        webView.stopLoading();
        java.lang.String defaultErrorPage = getDefaultErrorPage();
        if (!android.text.TextUtils.isEmpty(defaultErrorPage)) {
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, defaultErrorPage);
            webView.loadUrl(defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            getWebViewLoadCallBack().onCheckError(str, com.huawei.secure.android.common.webview.WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(java.lang.String str, byte[] bArr) {
        if (!b(str)) {
            super.postUrl(str, bArr);
        } else if (!android.text.TextUtils.isEmpty(this.n)) {
            super.postUrl(this.n, bArr);
        } else if (getWebViewLoadCallBack() != null) {
            getWebViewLoadCallBack().onCheckError(str, com.huawei.secure.android.common.webview.WebViewLoadCallBack.ErrorCode.HTTP_URL);
        }
    }

    public void setDefaultErrorPage(java.lang.String str) {
        this.n = str;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(android.webkit.WebViewClient webViewClient) {
        super.setWebViewClient(new com.huawei.secure.android.common.webview.SafeWebView.d(this, webViewClient, true, null));
    }

    public void setWebViewClient(android.webkit.WebViewClient webViewClient, boolean z) {
        super.setWebViewClient(new com.huawei.secure.android.common.webview.SafeWebView.d(this, webViewClient, z, null));
    }

    public void setWebViewLoadCallBack(com.huawei.secure.android.common.webview.WebViewLoadCallBack webViewLoadCallBack) {
        this.w = webViewLoadCallBack;
    }

    @android.annotation.TargetApi(9)
    @java.lang.Deprecated
    public void setWhitelist(java.lang.String[] strArr) {
        this.t = strArr == null ? null : (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistNotMatchSubDomain(java.lang.String[] strArr) {
        this.u = strArr == null ? null : (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    @java.lang.Deprecated
    public void setWhitelistNotMathcSubDomain(java.lang.String[] strArr) {
        this.u = strArr == null ? null : (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    @android.annotation.TargetApi(9)
    public void setWhitelistWithPath(java.lang.String[] strArr) {
        this.v = strArr == null ? null : (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
    }

    @java.lang.Deprecated
    public final void showNoticeWhenSSLErrorOccurred(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, android.webkit.SslErrorHandler sslErrorHandler) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        if (!android.text.TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        com.huawei.secure.android.common.webview.SafeWebView.c cVar = new com.huawei.secure.android.common.webview.SafeWebView.c(sslErrorHandler);
        com.huawei.secure.android.common.webview.SafeWebView.b bVar = new com.huawei.secure.android.common.webview.SafeWebView.b(sslErrorHandler);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, cVar);
        builder.setNegativeButton(str4, bVar);
        builder.create().show();
    }
}
