package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public final class b extends com.anythink.expressad.atsignalcommon.base.b {
    java.lang.String a;
    com.anythink.expressad.splash.d.a b;
    private final java.lang.String c = "SplashWebViewClient";

    /* renamed from: com.anythink.expressad.splash.view.b$1, reason: invalid class name */
    public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
        public AnonymousClass1() {
        }

        private static void a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(java.lang.String str) {
        }
    }

    public b(java.lang.String str, com.anythink.expressad.splash.d.a aVar) {
        this.a = str;
        this.b = aVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            webView.evaluateJavascript(sb.toString(), new com.anythink.expressad.splash.view.b.AnonymousClass1());
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = (com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) webView;
            if (java.lang.System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.anythink.expressad.a.b.a.c) {
                com.anythink.expressad.foundation.d.c cVar = ((com.anythink.expressad.splash.js.SplashJSBridgeImpl) windVaneWebView.getObject()).getmCampaignList().get(0);
                windVaneWebView.getUrl();
                if (com.anythink.expressad.a.b.a.a(cVar)) {
                    return false;
                }
            }
            com.anythink.expressad.splash.d.a aVar = this.b;
            if (aVar == null) {
                return true;
            }
            aVar.b(str);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
