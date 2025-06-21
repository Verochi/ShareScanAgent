package com.anythink.core.basead.ui.web;

/* loaded from: classes12.dex */
public final class a extends android.webkit.WebViewClient {
    private com.anythink.core.basead.ui.web.b a;

    public a(com.anythink.core.basead.ui.web.b bVar) {
        this.a = bVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        super.onPageFinished(webView, str);
        com.anythink.core.basead.ui.web.b bVar = this.a;
        if (bVar != null) {
            bVar.onWebPageFinish(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.anythink.core.basead.ui.web.b bVar = this.a;
        if (bVar != null) {
            bVar.onWebPageStart(webView, str);
            com.anythink.core.basead.ui.web.WebProgressBarView webProgressBarView = this.a.getWebProgressBarView();
            if (webProgressBarView != null) {
                webProgressBarView.setVisibility(0);
                webProgressBarView.setProgress(0);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
        com.anythink.core.basead.ui.web.b bVar = this.a;
        if (bVar != null) {
            bVar.onWebPageLoadError(webView, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @androidx.annotation.RequiresApi(26)
    public final boolean onRenderProcessGone(@androidx.annotation.Nullable android.webkit.WebView webView, @androidx.annotation.Nullable android.webkit.RenderProcessGoneDetail renderProcessGoneDetail) {
        com.anythink.core.basead.ui.web.b bVar = this.a;
        if (bVar == null) {
            return true;
        }
        bVar.onWebFinish();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && !com.anythink.core.common.res.d.a.equals(str)) {
            com.anythink.core.basead.ui.web.b bVar = this.a;
            if (bVar != null) {
                bVar.recordRedirectUrl(str);
            }
            com.anythink.core.common.f.ba a = com.anythink.core.basead.a.a.a(webView.getContext(), str);
            if (a.m) {
                com.anythink.core.basead.ui.web.b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.callbackClickResult(a);
                }
                return true;
            }
            com.anythink.core.basead.ui.web.b bVar3 = this.a;
            if (bVar3 != null) {
                bVar3.callbackClickResult(a);
            }
            com.anythink.core.common.f.ba a2 = com.anythink.core.basead.a.a.a(str);
            com.anythink.core.basead.ui.web.b bVar4 = this.a;
            if (bVar4 != null) {
                bVar4.callbackClickResult(a2);
            }
            if (!android.text.TextUtils.equals(a2.o, str)) {
                java.lang.String str2 = a2.o;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str2);
                webView.loadUrl(str2);
                return true;
            }
            if (!com.anythink.core.common.o.i.d(str)) {
                return true;
            }
        }
        return false;
    }
}
