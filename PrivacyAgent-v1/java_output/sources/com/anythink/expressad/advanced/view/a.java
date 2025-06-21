package com.anythink.expressad.advanced.view;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.atsignalcommon.base.b {
    java.lang.String a;
    com.anythink.expressad.advanced.d.a b;
    private final java.lang.String c = "NativeAdvancedWebViewClient";
    private com.anythink.expressad.advanced.d.c d;

    /* renamed from: com.anythink.expressad.advanced.view.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
        public AnonymousClass1() {
        }

        private static void a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(java.lang.String str) {
        }
    }

    public a(java.lang.String str, com.anythink.expressad.advanced.d.a aVar, com.anythink.expressad.advanced.d.c cVar) {
        this.a = str;
        this.b = aVar;
        this.d = cVar;
    }

    private android.webkit.WebResourceResponse a(java.lang.String str) {
        android.net.Uri parse;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z = false;
        if (!android.text.TextUtils.isEmpty(str) && (parse = android.net.Uri.parse(str)) != null && "mb-h5".equals(parse.getScheme())) {
            z = true;
        }
        if (!z || this.d == null) {
            return null;
        }
        java.lang.String a = this.d.a(java.net.URLDecoder.decode(android.net.Uri.parse(str).getQueryParameter("uri")));
        try {
            if (android.text.TextUtils.isEmpty(a) || a.contains("127.0.0.1") || a.startsWith(com.alipay.sdk.m.l.a.q)) {
                return null;
            }
            return new android.webkit.WebResourceResponse("video/mp4", "utf-8", new java.io.FileInputStream(a));
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean b(java.lang.String str) {
        android.net.Uri parse;
        return (android.text.TextUtils.isEmpty(str) || (parse = android.net.Uri.parse(str)) == null || !"mb-h5".equals(parse.getScheme())) ? false : true;
    }

    public final void a() {
        if (this.d != null) {
            this.d = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            webView.evaluateJavascript(sb.toString(), new com.anythink.expressad.advanced.view.a.AnonymousClass1());
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    public final android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        return a(webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final android.webkit.WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, java.lang.String str) {
        return a(str);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        try {
            try {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = (com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) webView;
                if (java.lang.System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.c) {
                    com.anythink.expressad.foundation.d.c cVar = ((com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl) windVaneWebView.getObject()).getmCampaignList().get(0);
                    windVaneWebView.getUrl();
                    if (com.anythink.expressad.a.b.a.a(cVar)) {
                        return false;
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.anythink.expressad.advanced.d.a aVar = this.b;
            if (aVar == null) {
                return true;
            }
            aVar.a(str);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
