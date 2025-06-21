package com.jd.ad.sdk.bl.adinteraction.deeplink;

/* loaded from: classes30.dex */
public class JADWebViewActivity extends android.app.Activity {
    public static final java.lang.String mUrlIntent = "urlIntent";
    private android.webkit.WebView mWebView;

    public class jad_an implements android.webkit.DownloadListener {
        public jad_an() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
            if (str.endsWith(com.anythink.china.common.a.a.g)) {
                try {
                    com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.this.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class jad_bo extends android.webkit.WebChromeClient {
        public final /* synthetic */ android.widget.TextView jad_an;

        public jad_bo(com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity jADWebViewActivity, android.widget.TextView textView) {
            this.jad_an = textView;
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            this.jad_an.setText(str);
        }
    }

    public class jad_cp implements android.view.View.OnClickListener {
        public jad_cp() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class jad_dq implements android.view.View.OnClickListener {
        public jad_dq() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.this.onBackClick();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static class jad_er extends android.webkit.WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(android.webkit.WebView webView, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            android.net.Uri uri = android.net.Uri.EMPTY;
            android.net.Uri url = webResourceRequest.getUrl();
            java.lang.String uri2 = url.toString();
            if (!android.text.TextUtils.isEmpty(uri2) && !uri2.startsWith(com.alipay.sdk.m.l.a.q)) {
                try {
                    android.content.Context context = webView.getContext();
                    android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", url);
                    if (!(context instanceof android.app.Activity)) {
                        intent.addFlags(268435456);
                    }
                    context.startActivity(intent);
                    return true;
                } catch (java.lang.Throwable unused) {
                }
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            if (str.startsWith(com.alipay.sdk.m.l.a.q)) {
                return false;
            }
            try {
                android.content.Context context = webView.getContext();
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                if (!(context instanceof android.app.Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return true;
            } catch (java.lang.Throwable unused) {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBackClick() {
        android.webkit.WebView webView = this.mWebView;
        if (webView == null || !webView.canGoBack()) {
            finish();
        } else {
            this.mWebView.goBack();
        }
    }

    public static boolean startActivity(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.class);
        intent.putExtra(mUrlIntent, new java.lang.String[]{str});
        if (!(context instanceof android.app.Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            setContentView(com.jd.ad.sdk.R.layout.jad_activity_webview);
            android.widget.TextView textView = (android.widget.TextView) findViewById(com.jd.ad.sdk.R.id.jad_toolbar_title);
            getWindow().addFlags(134217728);
            textView.setSelected(true);
            java.lang.String[] stringArrayExtra = getIntent().getStringArrayExtra(mUrlIntent);
            android.webkit.WebView webView = (android.webkit.WebView) findViewById(com.jd.ad.sdk.R.id.jad_webView);
            this.mWebView = webView;
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            this.mWebView.removeJavascriptInterface("accessibility");
            this.mWebView.removeJavascriptInterface("accessibilityTraversal");
            this.mWebView.setScrollBarStyle(0);
            android.webkit.WebSettings settings = this.mWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setSavePassword(false);
            settings.setDomStorageEnabled(true);
            settings.setAppCachePath(getCacheDir().getAbsolutePath());
            settings.setAppCacheEnabled(true);
            settings.setAllowContentAccess(false);
            this.mWebView.setDownloadListener(new com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.jad_an());
            this.mWebView.setWebViewClient(new com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.jad_er());
            this.mWebView.setWebChromeClient(new com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.jad_bo(this, textView));
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                android.webkit.WebView webView2 = this.mWebView;
                java.lang.String str = stringArrayExtra[0];
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView2, str);
                webView2.loadUrl(str);
            }
            android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.jd.ad.sdk.R.id.jad_toolbar_back);
            int i = com.jd.ad.sdk.R.color.jad_common_half_alpha;
            imageView.setColorFilter(i);
            imageView.setOnClickListener(new com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.jad_cp());
            android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.jd.ad.sdk.R.id.jad_toolbar_back_1);
            imageView2.setColorFilter(i);
            imageView2.setOnClickListener(new com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.jad_dq());
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.w(e.getMessage(), new java.lang.Object[0]);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            android.webkit.WebView webView = this.mWebView;
            if (webView != null) {
                webView.destroy();
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onDestroy:");
            jad_an2.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an2.toString(), new java.lang.Object[0]);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        android.webkit.WebView webView = this.mWebView;
        if (webView == null || i != 4 || !webView.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mWebView.goBack();
        return true;
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
            android.webkit.WebView webView = this.mWebView;
            if (webView != null) {
                webView.onPause();
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onPause:");
            jad_an2.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an2.toString(), new java.lang.Object[0]);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            android.webkit.WebView webView = this.mWebView;
            if (webView != null) {
                webView.onResume();
            }
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while webview activity onResume:");
            jad_an2.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an2.toString(), new java.lang.Object[0]);
        }
    }

    public void setZoomControlGone(android.view.View view) {
        try {
            java.lang.reflect.Field declaredField = android.webkit.WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            android.widget.ZoomButtonsController zoomButtonsController = new android.widget.ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            declaredField.set(view, zoomButtonsController);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while load webview activity:");
            jad_an2.append(e.getMessage());
            com.jd.ad.sdk.logger.Logger.w(jad_an2.toString(), new java.lang.Object[0]);
        }
    }
}
