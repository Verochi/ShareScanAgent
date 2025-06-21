package com.anythink.expressad.mbbanner.view;

/* loaded from: classes12.dex */
public final class a extends com.anythink.expressad.atsignalcommon.base.b {
    java.lang.String a;
    java.util.List<com.anythink.expressad.foundation.d.c> b;
    com.anythink.expressad.mbbanner.a.c.a c;
    private final java.lang.String d = "BannerWebViewClient";

    /* renamed from: com.anythink.expressad.mbbanner.view.a$1, reason: invalid class name */
    public class AnonymousClass1 implements android.webkit.ValueCallback<java.lang.String> {
        public AnonymousClass1() {
        }

        private static void a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(java.lang.String str) {
        }
    }

    public a(java.lang.String str, java.util.List<com.anythink.expressad.foundation.d.c> list, com.anythink.expressad.mbbanner.a.c.a aVar) {
        this.a = str;
        this.b = list;
        this.c = aVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("javascript:");
            com.anythink.expressad.d.b.a.a();
            sb.append(com.anythink.expressad.d.b.a.b());
            webView.evaluateJavascript(sb.toString(), new com.anythink.expressad.mbbanner.view.a.AnonymousClass1());
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // com.anythink.expressad.atsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        try {
            com.anythink.expressad.atsignalcommon.base.BaseWebView baseWebView = (com.anythink.expressad.atsignalcommon.base.BaseWebView) webView;
            if (java.lang.System.currentTimeMillis() - baseWebView.lastTouchTime > com.anythink.expressad.a.b.a.c) {
                com.anythink.expressad.foundation.d.c cVar = this.b.get(0);
                baseWebView.getUrl();
                if (com.anythink.expressad.a.b.a.a(cVar)) {
                    return false;
                }
            }
            if (this.b.size() > 1) {
                com.anythink.core.common.b.o.a().f().startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str)));
                str = null;
            }
            com.anythink.expressad.mbbanner.a.c.a aVar = this.c;
            if (aVar != null) {
                aVar.a(false, str);
            }
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
