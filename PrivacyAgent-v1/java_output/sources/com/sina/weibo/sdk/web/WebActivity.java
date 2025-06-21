package com.sina.weibo.sdk.web;

/* loaded from: classes19.dex */
public class WebActivity extends android.app.Activity implements com.sina.weibo.sdk.web.a {
    private android.widget.LinearLayout ar;
    private android.widget.TextView as;
    private android.widget.TextView at;
    private android.webkit.WebView au;
    private android.widget.ProgressBar av;
    private com.sina.weibo.sdk.web.b.b aw;
    private com.sina.weibo.sdk.web.a.b ax;
    private java.lang.String ay;

    /* renamed from: com.sina.weibo.sdk.web.WebActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sina.weibo.sdk.web.b.b.a {
        public AnonymousClass1() {
        }

        @Override // com.sina.weibo.sdk.web.b.b.a
        public final void onComplete() {
            java.lang.String url = com.sina.weibo.sdk.web.WebActivity.this.aw.getUrl();
            if (android.text.TextUtils.isEmpty(url) || !com.sina.weibo.sdk.web.WebActivity.j(url)) {
                return;
            }
            android.webkit.WebView webView = com.sina.weibo.sdk.web.WebActivity.this.au;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, url);
            webView.loadUrl(url);
        }

        @Override // com.sina.weibo.sdk.web.b.b.a
        public final void onError(java.lang.String str) {
            com.sina.weibo.sdk.web.WebActivity.this.ax.p(str);
        }
    }

    /* renamed from: com.sina.weibo.sdk.web.WebActivity$2, reason: invalid class name */
    public class AnonymousClass2 implements android.view.View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sina.weibo.sdk.web.WebActivity.this.ax.t();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sina.weibo.sdk.web.WebActivity$3, reason: invalid class name */
    public class AnonymousClass3 implements android.view.View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.sina.weibo.sdk.web.WebActivity.d(com.sina.weibo.sdk.web.WebActivity.this);
            com.sina.weibo.sdk.web.WebActivity.this.au.reload();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.sina.weibo.sdk.web.WebActivity$4, reason: invalid class name */
    public class AnonymousClass4 extends android.webkit.WebChromeClient {
        public AnonymousClass4() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(android.webkit.WebView webView, int i) {
            super.onProgressChanged(webView, i);
            com.sina.weibo.sdk.web.WebActivity.this.av.setProgress(i);
            if (i == 100) {
                com.sina.weibo.sdk.web.WebActivity.this.av.setVisibility(4);
            } else {
                com.sina.weibo.sdk.web.WebActivity.this.av.setVisibility(0);
            }
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    private static void a(android.webkit.WebView webView, java.lang.String str) {
        try {
            android.webkit.WebView.class.getDeclaredMethod("removeJavascriptInterface", java.lang.String.class).invoke(webView, str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void d(com.sina.weibo.sdk.web.WebActivity webActivity) {
        webActivity.ar.setVisibility(8);
        webActivity.au.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("https://service.weibo.com/share/mobilesdk.php") || str.startsWith("https://open.weibo.cn/oauth2/authorize?");
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(8192);
        }
        android.widget.RelativeLayout relativeLayout = new android.widget.RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        android.widget.RelativeLayout relativeLayout2 = new android.widget.RelativeLayout(this);
        android.widget.TextView textView = new android.widget.TextView(this);
        this.as = textView;
        textView.setText("关闭");
        this.as.setTextSize(17.0f);
        this.as.setTextColor(-32256);
        this.as.setOnClickListener(new com.sina.weibo.sdk.web.WebActivity.AnonymousClass2());
        android.widget.TextView textView2 = new android.widget.TextView(this);
        this.at = textView2;
        textView2.setTextSize(18.0f);
        this.at.setTextColor(-11382190);
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        this.as.setPadding(com.sina.weibo.sdk.c.e.a(10, this), 0, com.sina.weibo.sdk.c.e.a(10, this), 0);
        layoutParams2.addRule(13);
        relativeLayout2.addView(this.as, layoutParams);
        relativeLayout2.addView(this.at, layoutParams2);
        relativeLayout.addView(relativeLayout2, new android.widget.RelativeLayout.LayoutParams(-1, com.sina.weibo.sdk.c.e.a(55, this)));
        this.au = new android.webkit.WebView(getApplicationContext());
        android.widget.RelativeLayout.LayoutParams layoutParams3 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.topMargin = com.sina.weibo.sdk.c.e.a(55, this);
        relativeLayout.addView(this.au, layoutParams3);
        this.av = new android.widget.ProgressBar(this);
        android.widget.RelativeLayout.LayoutParams layoutParams4 = new android.widget.RelativeLayout.LayoutParams(-1, com.sina.weibo.sdk.c.e.a(3, this));
        layoutParams4.topMargin = com.sina.weibo.sdk.c.e.a(55, this);
        relativeLayout.addView(this.av, layoutParams4);
        android.view.View view = new android.view.View(this);
        view.setBackgroundResource(getResources().getIdentifier("weibosdk_common_shadow_top", com.anythink.expressad.foundation.h.i.c, getPackageName()));
        android.widget.RelativeLayout.LayoutParams layoutParams5 = new android.widget.RelativeLayout.LayoutParams(-1, com.sina.weibo.sdk.c.e.a(3, this));
        layoutParams5.topMargin = com.sina.weibo.sdk.c.e.a(55, this);
        relativeLayout.addView(view, layoutParams5);
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(this);
        this.ar = linearLayout;
        linearLayout.setOrientation(1);
        android.widget.ImageView imageView = new android.widget.ImageView(this);
        imageView.setImageResource(getResources().getIdentifier("weibosdk_empty_failed", com.anythink.expressad.foundation.h.i.c, getPackageName()));
        this.ar.addView(imageView);
        android.widget.TextView textView3 = new android.widget.TextView(this);
        textView3.setTextSize(14.0f);
        textView3.setTextColor(-4342339);
        android.widget.LinearLayout.LayoutParams layoutParams6 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = com.sina.weibo.sdk.c.e.a(18, this);
        layoutParams6.bottomMargin = com.sina.weibo.sdk.c.e.a(20, this);
        this.ar.addView(textView3, layoutParams6);
        textView3.setText("网络出错啦，请点击按钮重新加载");
        android.widget.Button button = new android.widget.Button(this);
        button.setTextSize(16.0f);
        button.setTextColor(-8882056);
        android.widget.LinearLayout.LayoutParams layoutParams7 = new android.widget.LinearLayout.LayoutParams(com.sina.weibo.sdk.c.e.a(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, this), com.sina.weibo.sdk.c.e.a(46, this));
        layoutParams7.gravity = 17;
        this.ar.addView(button, layoutParams7);
        button.setBackgroundResource(getResources().getIdentifier("retry_btn_selector", com.anythink.expressad.foundation.h.i.c, getPackageName()));
        button.setText("重新加载");
        button.setOnClickListener(new com.sina.weibo.sdk.web.WebActivity.AnonymousClass3());
        android.widget.RelativeLayout.LayoutParams layoutParams8 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13);
        relativeLayout.addView(this.ar, layoutParams8);
        this.ar.setVisibility(8);
        this.au.setWebChromeClient(new com.sina.weibo.sdk.web.WebActivity.AnonymousClass4());
        setContentView(relativeLayout);
        android.content.Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        android.os.Bundle extras = intent.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        int intExtra = intent.getIntExtra("web_type", -1);
        if (intExtra == -1) {
            finish();
            return;
        }
        if (intExtra == 1) {
            this.ay = "微博分享";
            this.aw = new com.sina.weibo.sdk.web.b.d(this);
            this.ax = new com.sina.weibo.sdk.web.a.d(this, this, this.aw);
        } else if (intExtra == 2) {
            this.ay = "微博登录";
            this.aw = new com.sina.weibo.sdk.web.b.a();
            this.ax = new com.sina.weibo.sdk.web.a.a(this, this, this.aw);
        } else if (intExtra == 3) {
            this.aw = new com.sina.weibo.sdk.web.b.c();
            this.ax = new com.sina.weibo.sdk.web.a.c(this, this.aw);
        }
        this.au.setWebViewClient(this.ax);
        this.aw.readFromBundle(extras);
        android.webkit.WebSettings settings = this.au.getSettings();
        settings.setSavePassword(false);
        settings.setAllowContentAccess(false);
        settings.setUserAgentString(com.sina.weibo.sdk.c.e.r());
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setGeolocationEnabled(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        this.au.requestFocus();
        this.au.setScrollBarStyle(0);
        a(this.au, "searchBoxJavaBridge_");
        a(this.au, "accessibility");
        a(this.au, "accessibilityTraversal");
        settings.setMixedContentMode(2);
        if (this.aw.w()) {
            this.aw.a(new com.sina.weibo.sdk.web.WebActivity.AnonymousClass1());
        } else {
            java.lang.String url = this.aw.getUrl();
            if (!android.text.TextUtils.isEmpty(url) && j(url)) {
                android.webkit.WebView webView = this.au;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, url);
                webView.loadUrl(url);
            }
        }
        android.widget.TextView textView4 = this.at;
        if (textView4 != null) {
            textView4.setText(this.ay);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ax.v()) {
                return true;
            }
            if (this.au.canGoBack()) {
                this.au.goBack();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNewIntent(this, intent);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void s() {
        this.ar.setVisibility(0);
        this.au.setVisibility(8);
    }

    @Override // com.sina.weibo.sdk.web.a
    public final void t() {
        finish();
    }
}
