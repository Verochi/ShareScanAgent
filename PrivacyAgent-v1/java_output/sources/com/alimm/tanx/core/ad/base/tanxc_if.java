package com.alimm.tanx.core.ad.base;

/* loaded from: classes.dex */
public abstract class tanxc_if {
    private com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface tanxc_byte;
    private com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface tanxc_case;
    private com.alimm.tanx.core.utils.TanxCountDownTimer tanxc_char;
    private com.alimm.tanx.core.web.webview.AdWebViewManager tanxc_do;
    private android.widget.LinearLayout tanxc_for;
    private com.alimm.tanx.core.web.webview.TanxAdWebView tanxc_if;
    private com.alimm.tanx.core.ad.bean.BidInfo tanxc_int;
    protected com.alimm.tanx.core.bridge.TanxJsBridge tanxc_new;
    private com.alimm.tanx.core.bridge.JsBridgeUtil tanxc_this;
    private com.alimm.tanx.core.request.TanxAdSlot tanxc_try;
    private int tanxc_else = 0;
    private volatile boolean tanxc_goto = false;
    private boolean tanxc_long = false;
    private volatile boolean tanxc_void = false;

    /* renamed from: com.alimm.tanx.core.ad.base.tanxc_if$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.web.webview.OnScrollChangedCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.web.webview.OnScrollChangedCallback
        public void onScroll(int i, int i2) {
            try {
                if (com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_byte == null || !(com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_byte instanceof com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface)) {
                    return;
                }
                ((com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface) com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_byte).onScroll(i, i2);
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e(e);
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.base.tanxc_if$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebChromeClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebChromeClient
        @androidx.annotation.Nullable
        public android.graphics.Bitmap getDefaultVideoPoster() {
            return android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_8888);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(android.webkit.WebView webView, int i) {
            super.onProgressChanged(webView, i);
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "onProgressChanged:" + i);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.base.tanxc_if$3, reason: invalid class name */
    public class AnonymousClass3 extends android.webkit.WebViewClient {
        final /* synthetic */ android.webkit.WebView tanxc_do;

        public AnonymousClass3(android.webkit.WebView webView) {
            this.tanxc_do = webView;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(android.webkit.WebView webView, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "onLoadResource");
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "onPageFinished");
            if (com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_byte != null) {
                com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_byte.webDrawStatus(!com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_long);
            }
            if (!com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_long) {
                com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_byte();
                com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_if.setVisibility(0);
            }
            com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_new.injectJavascript();
            com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_new.ready();
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "onPageStarted");
        }

        @Override // android.webkit.WebViewClient
        @androidx.annotation.RequiresApi(api = 23)
        public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            int errorCode;
            int errorCode2;
            java.lang.CharSequence description;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onReceivedError:");
            errorCode = webResourceError.getErrorCode();
            sb.append(errorCode);
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", sb.toString());
            errorCode2 = webResourceError.getErrorCode();
            description = webResourceError.getDescription();
            com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_do(webView, webResourceRequest, errorCode2, description.toString());
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
            com.alimm.tanx.core.ad.base.tanxc_if.this.tanxc_do(webView, webResourceRequest, webResourceResponse.getStatusCode(), "");
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "onReceivedHttpError:" + webResourceResponse.getStatusCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
            if (com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance().getHttpsBoolean()) {
                sslErrorHandler.proceed();
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        @androidx.annotation.Nullable
        @android.annotation.TargetApi(21)
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest");
            return com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().interceptRequest(webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        @androidx.annotation.Nullable
        public android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "shouldInterceptRequest2");
            return com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().interceptRequest(str);
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(21)
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading");
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_do, webResourceRequest.getUrl().toString());
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "shouldOverrideUrlLoading2");
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_do, str);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_byte() {
        try {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "cancelTimerDog  loadingError :" + this.tanxc_long + " startTimerSwitch:" + this.tanxc_goto);
            com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.tanxc_char;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.tanxc_char = null;
            }
            this.tanxc_goto = false;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("timerCancel", e);
        }
    }

    private boolean tanxc_case() {
        com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.tanxc_int;
        if (bidInfo == null || bidInfo.getTemplateConf() == null || this.tanxc_int.getTemplateConf().getWebStartTime2Long() == null || this.tanxc_int.getTemplateConf().getWebEndTime2Long() == null) {
            return true;
        }
        return this.tanxc_int.getTemplateConf().getWebStartTime2Long().longValue() <= java.lang.System.currentTimeMillis() && this.tanxc_int.getTemplateConf().getWebEndTime2Long().longValue() >= java.lang.System.currentTimeMillis();
    }

    private int tanxc_do(android.content.Context context) {
        if (!tanxc_do() || context == null) {
            return 0;
        }
        return com.alimm.tanx.core.utils.SysUtils.getStatusBarHeight2WebView(context);
    }

    private java.lang.String tanxc_do(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains("?")) {
            return (str + "&sdkVersion=" + com.alimm.tanx.core.SdkConstant.getSdkVersion()).trim();
        }
        return (str + "?sdkVersion=" + com.alimm.tanx.core.SdkConstant.getSdkVersion()).trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_do(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, int i, java.lang.String str) {
        try {
            java.lang.String uri = webResourceRequest.getUrl().toString();
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "loadError URL:" + uri);
            if (com.alimm.tanx.core.utils.SysUtils.checkUrlSuffixAndValid(uri)) {
                this.tanxc_long = true;
                webView.setVisibility(8);
            }
            com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", "loadError errorCode:" + i + " errorMsg:" + str + " url:" + uri);
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", "loadError:", e);
        }
    }

    private void tanxc_do(com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView, boolean z) {
        tanxAdWebView.setWebClickable(z);
        tanxAdWebView.setBackgroundColor(0);
        tanxAdWebView.setOnScrollChangedCallback(new com.alimm.tanx.core.ad.base.tanxc_if.AnonymousClass1());
        tanxc_do(tanxAdWebView);
        tanxc_for(tanxAdWebView);
        tanxc_new();
    }

    private void tanxc_for(android.webkit.WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setUserAgentString(webView.getSettings().getUserAgentString() + com.alimm.tanx.core.utils.AndroidUtils.getUserAgentSuffix());
        webView.setOverScrollMode(2);
        webView.setWebChromeClient(new com.alimm.tanx.core.ad.base.tanxc_if.AnonymousClass2());
        webView.setWebViewClient(new com.alimm.tanx.core.ad.base.tanxc_if.AnonymousClass3(webView));
    }

    public static boolean tanxc_if(android.webkit.WebView webView) {
        if (webView != null) {
            try {
                if (webView.getContext() instanceof android.content.MutableContextWrapper) {
                    android.content.MutableContextWrapper mutableContextWrapper = (android.content.MutableContextWrapper) webView.getContext();
                    if ((mutableContextWrapper.getBaseContext() instanceof android.app.Activity) && !((android.app.Activity) mutableContextWrapper.getBaseContext()).isDestroyed()) {
                        return false;
                    }
                } else if ((webView.getContext() instanceof android.app.Activity) && !((android.app.Activity) webView.getContext()).isDestroyed()) {
                    return false;
                }
            } catch (java.lang.Exception e) {
                com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", e);
            }
        }
        return true;
    }

    public static /* synthetic */ int tanxc_new(com.alimm.tanx.core.ad.base.tanxc_if tanxc_ifVar) {
        int i = tanxc_ifVar.tanxc_else;
        tanxc_ifVar.tanxc_else = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_new() {
        char c;
        try {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "load");
            this.tanxc_long = false;
            if (tanxc_if(this.tanxc_if)) {
                com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", "webView已经回收，无法load，终止！！！！");
                return;
            }
            java.lang.String string = com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance().getString(com.alimm.tanx.core.utils.SharedPreferencesHelper.REWARD_URL);
            if (!android.text.TextUtils.isEmpty(string) && com.alimm.tanx.core.TanxCoreSdk.getConfig().isDebugMode()) {
                if (!com.alimm.tanx.core.utils.SysUtils.isValidUrl(string)) {
                    com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface = this.tanxc_byte;
                    if (baseWebInterface != null) {
                        baseWebInterface.webDrawStatus(false);
                        return;
                    }
                    return;
                }
                com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "load testUrl:" + string);
                tanxc_try();
                com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().enableForce(true);
                com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_if, tanxc_do(string));
                if (this.tanxc_if.getParent() == null) {
                    android.view.View view = new android.view.View(this.tanxc_for.getContext());
                    view.setLayoutParams(new android.view.ViewGroup.LayoutParams(1, tanxc_do(this.tanxc_for.getContext())));
                    this.tanxc_for.addView(view);
                    this.tanxc_for.addView(this.tanxc_if, new android.view.ViewGroup.LayoutParams(-1, -1));
                    return;
                }
                return;
            }
            com.alimm.tanx.core.ad.bean.BidInfo bidInfo = this.tanxc_int;
            if (bidInfo == null || bidInfo.getTemplateConf() == null) {
                return;
            }
            java.lang.String renderUrl = this.tanxc_int.getTemplateConf().getRenderUrl();
            if (!android.text.TextUtils.isEmpty(this.tanxc_int.getTemplateConf().getPidStyleId())) {
                java.lang.String pidStyleId = this.tanxc_int.getTemplateConf().getPidStyleId();
                switch (pidStyleId.hashCode()) {
                    case 1448635041:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_REWARD_VIDEO_ID)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635042:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_REWARD_ID)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635075:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_TABLE_SCREEN_ID)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635076:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_ORDER_REWARD_ID)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635077:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_NEW_REWARD_ID)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635101:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_SPLASH_WEB_ID)) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448635103:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_OPEN_TAO_BAO_REWARD_ID)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1448636000:
                        if (pidStyleId.equals(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_FEED_NATIVE_WEB_ID)) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        renderUrl = renderUrl + "?pidStyleId=" + this.tanxc_int.getTemplateConf().getPidStyleId();
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        renderUrl = this.tanxc_int.getClickThroughUrl();
                        break;
                    case 5:
                        renderUrl = this.tanxc_int.getTemplateConf().getRenderUrl();
                        break;
                    case 6:
                    case 7:
                        renderUrl = this.tanxc_int.getTemplateConf().getWebUrl();
                        break;
                }
            } else {
                com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", "load()  getPidStyleId == null ");
            }
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "load h5:" + renderUrl);
            if (!com.alimm.tanx.core.utils.SysUtils.isValidUrl(renderUrl)) {
                this.tanxc_for.setVisibility(8);
                com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface2 = this.tanxc_byte;
                if (baseWebInterface2 != null) {
                    baseWebInterface2.webDrawStatus(false);
                    return;
                }
                return;
            }
            java.lang.String replaceAll = renderUrl.replaceAll("\\\\", "");
            if (android.text.TextUtils.isEmpty(replaceAll)) {
                this.tanxc_for.setVisibility(8);
                return;
            }
            tanxc_try();
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().enableForce(true);
            com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.getInstance().loadUrl(this.tanxc_if, tanxc_do(replaceAll));
            if (this.tanxc_if.getParent() == null) {
                android.view.View view2 = new android.view.View(this.tanxc_for.getContext());
                view2.setLayoutParams(new android.view.ViewGroup.LayoutParams(1, tanxc_do(this.tanxc_for.getContext())));
                this.tanxc_for.addView(view2);
                this.tanxc_for.addView(this.tanxc_if, new android.view.ViewGroup.LayoutParams(-1, -1));
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", "load()   " + com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e));
        }
    }

    private void tanxc_try() {
        com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "startTimerDog - startSwitch:" + this.tanxc_goto);
        try {
            if (this.tanxc_goto) {
                return;
            }
            com.alimm.tanx.core.ad.base.BaseWebViewUtil$4 baseWebViewUtil$4 = new com.alimm.tanx.core.ad.base.BaseWebViewUtil$4(this, 5000L, 1000L);
            this.tanxc_char = baseWebViewUtil$4;
            if (this.tanxc_else <= 5) {
                baseWebViewUtil$4.start();
                this.tanxc_goto = true;
            } else {
                com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "startTimer不在启动：nowTryLoadCount:" + this.tanxc_else);
            }
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e("BaseWebViewUtil", "startTimer", e);
        }
    }

    public void tanxc_do(android.webkit.WebView webView) {
        this.tanxc_new = new com.alimm.tanx.core.bridge.TanxJsBridge(this.tanxc_if.getContext(), this.tanxc_if);
        if (this.tanxc_this == null) {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "initJsBridge，jsBridgeUtil为空终止注册");
        } else {
            this.tanxc_this.initJsBridge(this.tanxc_new, new com.alimm.tanx.core.bridge.JsBridgeBean(this.tanxc_int, this.tanxc_try), this.tanxc_byte, this.tanxc_case);
        }
    }

    public void tanxc_do(android.widget.LinearLayout linearLayout, boolean z, com.alimm.tanx.core.ad.bean.BidInfo bidInfo, com.alimm.tanx.core.request.TanxAdSlot tanxAdSlot, com.alimm.tanx.core.bridge.JsBridgeUtil.BaseWebInterface baseWebInterface, com.alimm.tanx.core.bridge.JsBridgeUtil.AdInterface adInterface) {
        com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "init");
        this.tanxc_for = linearLayout;
        this.tanxc_int = bidInfo;
        this.tanxc_byte = baseWebInterface;
        this.tanxc_case = adInterface;
        this.tanxc_try = tanxAdSlot;
        this.tanxc_this = new com.alimm.tanx.core.bridge.JsBridgeUtil();
        if (tanxc_case()) {
            com.alimm.tanx.core.web.webview.AdWebViewManager adWebView = com.alimm.tanx.core.web.WebCacheManager.getInstance().getAdWebView();
            this.tanxc_do = adWebView;
            com.alimm.tanx.core.web.webview.TanxAdWebView webView = adWebView.getWebView(linearLayout.getContext());
            this.tanxc_if = webView;
            tanxc_do(webView, z);
        }
    }

    public void tanxc_do(boolean z) {
        com.alimm.tanx.core.bridge.JsBridgeUtil jsBridgeUtil = this.tanxc_this;
        if (jsBridgeUtil != null) {
            jsBridgeUtil.setShowWebBar(this.tanxc_new, z);
        } else {
            com.alimm.tanx.core.utils.LogUtils.d("BaseWebViewUtil", "setJsBridgeShowWebBar，jsBridgeUtil为空终止注册");
        }
    }

    public abstract boolean tanxc_do();

    public void tanxc_for() {
        com.alimm.tanx.core.utils.TanxCountDownTimer tanxCountDownTimer = this.tanxc_char;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.cancel();
            this.tanxc_char = null;
        }
    }

    public void tanxc_if() {
        tanxc_byte();
        com.alimm.tanx.core.web.webview.AdWebViewManager adWebViewManager = this.tanxc_do;
        if (adWebViewManager != null) {
            adWebViewManager.destroy();
        }
    }

    public void tanxc_int() {
        if (this.tanxc_long) {
            tanxc_new();
        }
    }
}
