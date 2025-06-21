package com.ss.android.downloadlib.addownload.compliance;

/* loaded from: classes19.dex */
public class AppPrivacyPolicyActivity extends android.app.Activity {
    private long t;
    private long v;
    private android.widget.ImageView vw;
    private android.webkit.WebView wg;
    private java.lang.String yl;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_privacy_click_close", com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.this.v);
            com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.this.finish();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebViewClient {
        public AnonymousClass2() {
        }

        private boolean vw(android.net.Uri uri) {
            java.lang.String scheme = uri.getScheme();
            return (com.alipay.sdk.m.l.a.q.equals(scheme) || "https".equals(scheme)) ? false : true;
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(android.webkit.WebView webView, android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
            boolean didCrash;
            if (android.os.Build.VERSION.SDK_INT < 26) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            didCrash = renderProcessGoneDetail.didCrash();
            if (didCrash) {
                com.ss.android.downloadlib.bt.z.vw("The WebView rendering process crashed!");
                if (webView != null) {
                    ((android.view.ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }
            com.ss.android.downloadlib.bt.z.vw("System killed the WebView rendering process to reclaim memory. Recreating...");
            if (webView != null) {
                ((android.view.ViewGroup) webView.getParent()).removeView(webView);
                webView.destroy();
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(21)
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
            return vw(webResourceRequest.getUrl());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            return vw(android.net.Uri.parse(str));
        }
    }

    public static void vw(android.app.Activity activity, long j) {
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private void vw(android.webkit.WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean vw() {
        this.t = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.wg.wg vw = com.ss.android.downloadlib.addownload.compliance.t.vw().vw(this.t);
        if (vw == null) {
            return false;
        }
        this.v = vw.wg;
        java.lang.String str = vw.x;
        this.yl = str;
        if (!android.text.TextUtils.isEmpty(str)) {
            return true;
        }
        this.yl = com.ss.android.downloadlib.addownload.z.x().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void wg() {
        this.vw = (android.widget.ImageView) findViewById(com.bytedance.sdk.openadsdk.R.id.iv_privacy_back);
        this.wg = (android.webkit.WebView) findViewById(com.bytedance.sdk.openadsdk.R.id.privacy_webview);
        this.vw.setOnClickListener(new com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.AnonymousClass1());
        android.webkit.WebSettings settings = this.wg.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.wg.setWebViewClient(new com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.AnonymousClass2());
        vw(this.wg);
        this.wg.setScrollBarStyle(0);
        android.webkit.WebView webView = this.wg;
        java.lang.String str = this.yl;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
        webView.loadUrl(str);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.ss.android.downloadlib.addownload.compliance.bt.vw("lp_app_privacy_click_close", this.v);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.R.layout.ttdownloader_activity_app_privacy_policy);
        if (vw()) {
            wg();
        } else {
            com.ss.android.socialbase.appdownloader.t.vw((android.app.Activity) this);
        }
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }
}
