package com.anythink.expressad.atsignalcommon.base;

/* loaded from: classes12.dex */
public class BaseWebView extends android.webkit.WebView {
    private android.view.View.OnTouchListener a;
    private android.view.View.OnTouchListener b;
    protected android.content.Context e;
    public long lastTouchTime;
    public com.anythink.expressad.atsignalcommon.base.b mWebViewClient;

    /* renamed from: com.anythink.expressad.atsignalcommon.base.BaseWebView$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnTouchListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                com.anythink.expressad.atsignalcommon.base.BaseWebView.this.lastTouchTime = java.lang.System.currentTimeMillis();
            }
            if (com.anythink.expressad.atsignalcommon.base.BaseWebView.this.b != null) {
                return com.anythink.expressad.atsignalcommon.base.BaseWebView.this.b.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    public BaseWebView(android.content.Context context) {
        super(context);
        this.lastTouchTime = 0L;
        this.a = new com.anythink.expressad.atsignalcommon.base.BaseWebView.AnonymousClass1();
        this.e = context;
        a();
    }

    public BaseWebView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastTouchTime = 0L;
        this.a = new com.anythink.expressad.atsignalcommon.base.BaseWebView.AnonymousClass1();
        this.e = context;
        a();
    }

    public BaseWebView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastTouchTime = 0L;
        this.a = new com.anythink.expressad.atsignalcommon.base.BaseWebView.AnonymousClass1();
        this.e = context;
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (r0.contains(com.anythink.expressad.foundation.h.r.a()) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String a(java.lang.String str) {
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(str)) {
            if (!str.contains("../")) {
                if (str.startsWith("file")) {
                    java.lang.String path = android.net.Uri.parse(str).getPath();
                    if (!android.text.TextUtils.isEmpty(path)) {
                    }
                }
            }
            z = true;
        }
        if (!z) {
            return str;
        }
        "illegal URL: ".concat(java.lang.String.valueOf(str));
        return com.anythink.core.common.res.d.a;
    }

    public void a() {
        if (this.mWebViewClient == null) {
            com.anythink.expressad.atsignalcommon.base.b bVar = new com.anythink.expressad.atsignalcommon.base.b();
            this.mWebViewClient = bVar;
            setWebViewClient(bVar);
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        android.webkit.WebSettings settings = getSettings();
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
                th.printStackTrace();
            }
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setAllowUniversalAccessFromFileURLs(false);
        } catch (java.lang.Throwable th2) {
            th2.printStackTrace();
        }
        try {
            settings.setMixedContentMode(1);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        try {
            java.lang.reflect.Method declaredMethod = android.webkit.WebSettings.class.getDeclaredMethod(com.anythink.core.common.o.d.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), java.lang.Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (java.lang.Throwable unused) {
        }
        settings.setDatabaseEnabled(true);
        java.lang.String path = this.e.getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        try {
            java.lang.reflect.Method declaredMethod2 = android.webkit.WebSettings.class.getDeclaredMethod("setDisplayZoomControls", java.lang.Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(settings, java.lang.Boolean.FALSE);
        } catch (java.lang.Exception unused2) {
        }
        try {
            java.lang.reflect.Method declaredMethod3 = android.webkit.WebSettings.class.getDeclaredMethod(com.anythink.core.common.o.d.b("c2V0QWxsb3dVbml2ZXJzYWxBY2Nlc3NGcm9tRmlsZVVSTHM="), java.lang.Boolean.TYPE);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(settings, java.lang.Boolean.TRUE);
        } catch (java.lang.Throwable unused3) {
        }
        super.setOnTouchListener(this.a);
    }

    public com.anythink.expressad.atsignalcommon.base.b getBaseWebViewClient() {
        return this.mWebViewClient;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(@androidx.annotation.Nullable java.lang.String str, java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4, @androidx.annotation.Nullable java.lang.String str5) {
        super.loadDataWithBaseURL(a(str), str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(java.lang.String str) {
        super.loadUrl(a(str));
    }

    @Override // android.webkit.WebView
    public void loadUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        super.loadUrl(a(str), map);
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    public void setFilter(com.anythink.expressad.atsignalcommon.base.a aVar) {
        com.anythink.expressad.atsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // android.view.View
    public void setOnTouchListener(android.view.View.OnTouchListener onTouchListener) {
        this.b = onTouchListener;
    }

    public void setTransparent() {
        setLayerType(1, null);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(android.webkit.WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof com.anythink.expressad.atsignalcommon.base.b) {
            this.mWebViewClient = (com.anythink.expressad.atsignalcommon.base.b) webViewClient;
        }
    }
}
