package com.anythink.expressad.atsignalcommon.base;

/* loaded from: classes12.dex */
public class b extends android.webkit.WebViewClient {
    private com.anythink.expressad.atsignalcommon.base.a a;
    private com.anythink.expressad.atsignalcommon.windvane.e b;

    public final void a(com.anythink.expressad.atsignalcommon.base.a aVar) {
        this.a = aVar;
    }

    public final void a(com.anythink.expressad.atsignalcommon.windvane.e eVar) {
        this.b = eVar;
    }

    public final com.anythink.expressad.atsignalcommon.base.a b() {
        return this.a;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        super.onPageFinished(webView, str);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.onReceivedError(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        com.anythink.expressad.atsignalcommon.base.a aVar = this.a;
        if (aVar != null && aVar.a(str)) {
            return true;
        }
        com.anythink.expressad.atsignalcommon.windvane.e eVar = this.b;
        if (eVar != null) {
            eVar.shouldOverrideUrlLoading(webView, str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
