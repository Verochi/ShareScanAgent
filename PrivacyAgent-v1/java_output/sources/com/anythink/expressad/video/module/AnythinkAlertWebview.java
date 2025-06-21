package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkAlertWebview extends com.anythink.expressad.video.module.AnythinkH5EndCardView {
    private java.lang.String A;

    /* renamed from: com.anythink.expressad.video.module.AnythinkAlertWebview$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.expressad.atsignalcommon.a.b {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
            super.onPageFinished(webView, str);
            com.anythink.expressad.atsignalcommon.windvane.j.a();
            com.anythink.expressad.atsignalcommon.windvane.j.a(webView, "onJSBridgeConnected", "");
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
            super.onReceivedError(webView, i, str, str2);
            com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = com.anythink.expressad.video.module.AnythinkAlertWebview.this;
            if (anythinkAlertWebview.w) {
                return;
            }
            anythinkAlertWebview.w = true;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(android.webkit.WebView webView, int i) {
            super.readyState(webView, i);
            com.anythink.expressad.video.module.AnythinkAlertWebview anythinkAlertWebview = com.anythink.expressad.video.module.AnythinkAlertWebview.this;
            if (anythinkAlertWebview.w) {
                return;
            }
            anythinkAlertWebview.v = i == 1;
        }
    }

    public AnythinkAlertWebview(android.content.Context context) {
        super(context);
    }

    public AnythinkAlertWebview(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final java.lang.String a() {
        if (android.text.TextUtils.isEmpty(this.x)) {
            return "";
        }
        com.anythink.expressad.videocommon.e.c.a().a(com.anythink.expressad.foundation.b.a.b().e(), this.x, false);
        java.lang.String J = com.anythink.expressad.videocommon.e.d.J();
        this.A = J;
        return !android.text.TextUtils.isEmpty(J) ? com.anythink.expressad.videocommon.b.i.a().c(this.A) : "";
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final android.widget.RelativeLayout.LayoutParams b() {
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        java.lang.String a = a();
        if (!this.f || this.b == null || android.text.TextUtils.isEmpty(a)) {
            this.e.a(101, "");
            return;
        }
        com.anythink.expressad.foundation.webview.BrowserView.DownloadListener downloadListener = new com.anythink.expressad.foundation.webview.BrowserView.DownloadListener(this.b);
        downloadListener.setTitle(this.b.bb());
        this.f274s.setDownloadListener(downloadListener);
        this.f274s.setCampaignId(this.b.aZ());
        setCloseVisible(8);
        this.f274s.setApiManagerJSFactory(bVar);
        this.f274s.setWebViewListener(new com.anythink.expressad.video.module.AnythinkAlertWebview.AnonymousClass1());
        setHtmlSource(com.anythink.expressad.videocommon.b.j.a().b(a));
        this.v = false;
        if (android.text.TextUtils.isEmpty(this.u)) {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = this.f274s;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, a);
            windVaneWebView.loadUrl(a);
        } else {
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = this.f274s;
            java.lang.String str = this.u;
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadDataWithBaseURL(windVaneWebView2, a, str, "text/html", "UTF-8", null);
            windVaneWebView2.loadDataWithBaseURL(a, str, "text/html", "UTF-8", null);
        }
        this.f274s.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        android.widget.RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(0);
        }
        super.webviewshow();
    }
}
