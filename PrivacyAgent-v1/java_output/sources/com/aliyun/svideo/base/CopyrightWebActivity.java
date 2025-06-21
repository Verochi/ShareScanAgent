package com.aliyun.svideo.base;

/* loaded from: classes29.dex */
public class CopyrightWebActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.ImageButton ibBack;
    private android.webkit.WebView webView;

    /* renamed from: com.aliyun.svideo.base.CopyrightWebActivity$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.aliyun.svideo.base.CopyrightWebActivity.this.onBackPressed();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: com.aliyun.svideo.base.CopyrightWebActivity$2, reason: invalid class name */
    public class AnonymousClass2 extends android.webkit.WebViewClient {
        public AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
            webView.loadUrl(str);
            return true;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.aliyun.svideo.base.R.layout.activity_copyright_web);
        android.widget.ImageButton imageButton = (android.widget.ImageButton) findViewById(com.aliyun.svideo.base.R.id.ib_back);
        this.ibBack = imageButton;
        imageButton.setOnClickListener(new com.aliyun.svideo.base.CopyrightWebActivity.AnonymousClass1());
        android.webkit.WebView webView = (android.webkit.WebView) findViewById(com.aliyun.svideo.base.R.id.alivc_copyright_webview);
        this.webView = webView;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, "https://alivc-demo.aliyuncs.com/td.html");
        webView.loadUrl("https://alivc-demo.aliyuncs.com/td.html");
        this.webView.setWebViewClient(new com.aliyun.svideo.base.CopyrightWebActivity.AnonymousClass2());
        this.webView.setWebChromeClient(new android.webkit.WebChromeClient());
        this.webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        android.webkit.WebView webView = this.webView;
        if (webView != null) {
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(webView, null, "", "text/html", "utf-8", null);
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.webView.clearHistory();
            ((android.view.ViewGroup) this.webView.getParent()).removeView(this.webView);
            this.webView.destroy();
            this.webView = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.webView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.webView.onResume();
    }
}
