package com.anythink.core.activity.component;

/* loaded from: classes12.dex */
public class PrivacyPolicyView extends android.widget.RelativeLayout implements android.view.View.OnClickListener {
    private static java.lang.String n = "PrivacyPolicyView";
    android.view.ViewGroup a;
    android.widget.LinearLayout b;
    com.anythink.core.activity.component.LoadingView c;
    android.widget.TextView d;
    android.widget.FrameLayout e;
    android.webkit.WebView f;
    android.widget.CheckBox g;
    android.view.View h;
    android.widget.TextView i;
    boolean j;
    boolean k;
    java.lang.String l;
    com.anythink.core.activity.component.PrivacyPolicyView.a m;

    /* renamed from: com.anythink.core.activity.component.PrivacyPolicyView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            try {
                com.anythink.core.activity.component.PrivacyPolicyView privacyPolicyView = com.anythink.core.activity.component.PrivacyPolicyView.this;
                if (privacyPolicyView.f != null && !privacyPolicyView.k) {
                    privacyPolicyView.j = true;
                    java.lang.String unused = com.anythink.core.activity.component.PrivacyPolicyView.n;
                    com.anythink.core.activity.component.PrivacyPolicyView privacyPolicyView2 = com.anythink.core.activity.component.PrivacyPolicyView.this;
                    privacyPolicyView2.loadPolicyUrl(privacyPolicyView2.l);
                }
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            } catch (java.lang.Throwable unused2) {
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        }
    }

    /* renamed from: com.anythink.core.activity.component.PrivacyPolicyView$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebViewClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            try {
                java.lang.String unused = com.anythink.core.activity.component.PrivacyPolicyView.n;
                java.lang.StringBuilder sb = new java.lang.StringBuilder("onPageFinished:");
                sb.append(str);
                sb.append("   mIsWebViewloadSuccess:");
                sb.append(com.anythink.core.activity.component.PrivacyPolicyView.this.j);
                if (com.anythink.core.activity.component.PrivacyPolicyView.this.l.equals(str)) {
                    com.anythink.core.activity.component.PrivacyPolicyView privacyPolicyView = com.anythink.core.activity.component.PrivacyPolicyView.this;
                    if (privacyPolicyView.j) {
                        privacyPolicyView.b.setVisibility(4);
                        com.anythink.core.activity.component.PrivacyPolicyView.this.a.setVisibility(0);
                        com.anythink.core.activity.component.PrivacyPolicyView.this.b.setVisibility(8);
                        com.anythink.core.activity.component.PrivacyPolicyView.this.c.clearAnimation();
                        com.anythink.core.activity.component.PrivacyPolicyView.a aVar = com.anythink.core.activity.component.PrivacyPolicyView.this.m;
                        if (aVar != null) {
                            aVar.onPageLoadSuccess();
                        }
                    } else {
                        privacyPolicyView.b.setVisibility(0);
                        com.anythink.core.activity.component.PrivacyPolicyView.this.c.clearAnimation();
                        com.anythink.core.activity.component.PrivacyPolicyView.this.d.setVisibility(0);
                        com.anythink.core.activity.component.PrivacyPolicyView.this.a.setVisibility(8);
                        com.anythink.core.activity.component.PrivacyPolicyView.a aVar2 = com.anythink.core.activity.component.PrivacyPolicyView.this.m;
                        if (aVar2 != null) {
                            aVar2.onPageLoadFail();
                        }
                    }
                    com.anythink.core.activity.component.PrivacyPolicyView.this.k = false;
                    super.onPageFinished(webView, str);
                }
            } catch (java.lang.Throwable unused2) {
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
            java.lang.String unused = com.anythink.core.activity.component.PrivacyPolicyView.n;
            "onPageStarted:".concat(java.lang.String.valueOf(str));
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        @android.annotation.TargetApi(23)
        public final void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
            int errorCode;
            com.anythink.core.activity.component.PrivacyPolicyView.this.j = false;
            java.lang.String unused = com.anythink.core.activity.component.PrivacyPolicyView.n;
            java.lang.StringBuilder sb = new java.lang.StringBuilder("onPageFinished:");
            errorCode = webResourceError.getErrorCode();
            sb.append(errorCode);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            java.lang.String unused = com.anythink.core.activity.component.PrivacyPolicyView.n;
            "shouldOverrideUrlLoading:".concat(java.lang.String.valueOf(str));
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            com.anythink.core.activity.component.PrivacyPolicyView.a(com.anythink.core.activity.component.PrivacyPolicyView.this.getContext(), str);
            return true;
        }
    }

    /* renamed from: com.anythink.core.activity.component.PrivacyPolicyView$3, reason: invalid class name */
    public class AnonymousClass3 extends android.webkit.WebChromeClient {
        public AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(android.webkit.WebView webView, java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str) && str.toLowerCase().contains("error")) {
                com.anythink.core.activity.component.PrivacyPolicyView.this.j = false;
            }
            super.onReceivedTitle(webView, str);
        }
    }

    public interface a {
        void onLevelSelect(int i);

        void onPageLoadFail();

        void onPageLoadSuccess();
    }

    public PrivacyPolicyView(android.content.Context context) {
        super(context);
        this.j = true;
        this.k = false;
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "privace_policy_layout", "layout"), this);
        this.a = (android.view.ViewGroup) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_content_view", "id"));
        this.b = (android.widget.LinearLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_loading_view", "id"));
        this.c = new com.anythink.core.activity.component.LoadingView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 30.0f), com.anythink.core.common.o.i.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.c.setLayoutParams(layoutParams);
        this.d = new android.widget.TextView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = com.anythink.core.common.o.i.a(getContext(), 5.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setText("Page failed to load, please try again later.");
        this.d.setTextColor(-8947849);
        this.d.setTextSize(1, 12.0f);
        this.b.addView(this.c);
        this.b.addView(this.d);
        this.b.setOnClickListener(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass1());
        this.e = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_webview_area", "id"));
        android.webkit.WebView webView = new android.webkit.WebView(getContext());
        this.f = webView;
        com.anythink.core.common.o.h.a(webView);
        this.e.addView(this.f, new android.widget.FrameLayout.LayoutParams(-1, -1));
        android.webkit.WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setCacheMode(-1);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
            settings.setPluginState(android.webkit.WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass2());
        this.f.setWebChromeClient(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass3());
        this.g = (android.widget.CheckBox) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_check_box", "id"));
        this.h = findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_agree_view", "id"));
        this.i = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_reject_view", "id"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        int a2 = com.anythink.core.common.o.i.a(getContext(), 20.0f);
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(a2);
        this.h.setBackgroundDrawable(gradientDrawable);
        this.i.setText(android.text.Html.fromHtml("<u>No,Thanks</u>"));
    }

    public static /* synthetic */ void a(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void b() {
        android.view.LayoutInflater.from(getContext()).inflate(com.anythink.core.common.o.i.a(getContext(), "privace_policy_layout", "layout"), this);
        this.a = (android.view.ViewGroup) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_content_view", "id"));
        this.b = (android.widget.LinearLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_loading_view", "id"));
        this.c = new com.anythink.core.activity.component.LoadingView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(com.anythink.core.common.o.i.a(getContext(), 30.0f), com.anythink.core.common.o.i.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.c.setLayoutParams(layoutParams);
        this.d = new android.widget.TextView(getContext());
        android.widget.LinearLayout.LayoutParams layoutParams2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = com.anythink.core.common.o.i.a(getContext(), 5.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setText("Page failed to load, please try again later.");
        this.d.setTextColor(-8947849);
        this.d.setTextSize(1, 12.0f);
        this.b.addView(this.c);
        this.b.addView(this.d);
        this.b.setOnClickListener(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass1());
        this.e = (android.widget.FrameLayout) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_webview_area", "id"));
        android.webkit.WebView webView = new android.webkit.WebView(getContext());
        this.f = webView;
        com.anythink.core.common.o.h.a(webView);
        this.e.addView(this.f, new android.widget.FrameLayout.LayoutParams(-1, -1));
        android.webkit.WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setCacheMode(-1);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
            settings.setPluginState(android.webkit.WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass2());
        this.f.setWebChromeClient(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass3());
        this.g = (android.widget.CheckBox) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_check_box", "id"));
        this.h = findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_agree_view", "id"));
        this.i = (android.widget.TextView) findViewById(com.anythink.core.common.o.i.a(getContext(), "policy_reject_view", "id"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        int a2 = com.anythink.core.common.o.i.a(getContext(), 20.0f);
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(a2);
        this.h.setBackgroundDrawable(gradientDrawable);
        this.i.setText(android.text.Html.fromHtml("<u>No,Thanks</u>"));
    }

    private static void b(android.content.Context context, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void c() {
        android.webkit.WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setCacheMode(-1);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
            settings.setPluginState(android.webkit.WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass2());
        this.f.setWebChromeClient(new com.anythink.core.activity.component.PrivacyPolicyView.AnonymousClass3());
    }

    public void destory() {
        try {
            removeAllViews();
            android.view.ViewGroup viewGroup = this.a;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            android.widget.FrameLayout frameLayout = this.e;
            if (frameLayout != null) {
                frameLayout.removeView(this.f);
                this.f.removeAllViews();
            }
            android.webkit.WebView webView = this.f;
            if (webView != null) {
                webView.clearHistory();
                this.f.clearCache(true);
                this.f.destroy();
                this.f = null;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public void loadPolicyUrl(java.lang.String str) {
        if (this.k) {
            return;
        }
        this.l = str;
        if (!com.anythink.core.common.o.i.a(getContext())) {
            this.j = false;
            this.b.setVisibility(0);
            this.c.clearAnimation();
            this.d.setVisibility(0);
            this.a.setVisibility(8);
            com.anythink.core.activity.component.PrivacyPolicyView.a aVar = this.m;
            if (aVar != null) {
                aVar.onPageLoadFail();
                return;
            }
            return;
        }
        this.j = true;
        this.b.setVisibility(0);
        this.c.clearAnimation();
        this.c.startAnimation();
        this.d.setVisibility(8);
        this.k = true;
        if (this.l.equals(this.f.getUrl())) {
            this.f.reload();
            return;
        }
        android.webkit.WebView webView = this.f;
        java.lang.String str2 = this.l;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str2);
        webView.loadUrl(str2);
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        if (view == this.h) {
            com.anythink.core.api.ATSDK.setGDPRUploadDataLevel(getContext(), 0);
            view.setTag(0);
            com.anythink.core.activity.component.PrivacyPolicyView.a aVar = this.m;
            if (aVar != null) {
                aVar.onLevelSelect(0);
                com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
        } else if (view == this.i) {
            com.anythink.core.api.ATSDK.setGDPRUploadDataLevel(getContext(), 1);
            view.setTag(1);
            com.anythink.core.activity.component.PrivacyPolicyView.a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.onLevelSelect(1);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setResultCallbackListener(com.anythink.core.activity.component.PrivacyPolicyView.a aVar) {
        this.m = aVar;
    }
}
