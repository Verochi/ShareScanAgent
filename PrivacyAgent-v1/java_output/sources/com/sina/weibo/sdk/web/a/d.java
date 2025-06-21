package com.sina.weibo.sdk.web.a;

/* loaded from: classes19.dex */
public final class d extends com.sina.weibo.sdk.web.a.b {
    public d(android.app.Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        super.onPageFinished(webView, str);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void p(java.lang.String str) {
        n(str);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    @android.annotation.TargetApi(21)
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        java.lang.String uri = webResourceRequest.getUrl().toString();
        if (android.text.TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        android.os.Bundle h = com.sina.weibo.sdk.c.e.h(uri);
        if (h != null) {
            java.lang.String string = h.getString("code");
            java.lang.String string2 = h.getString("msg");
            if (android.text.TextUtils.isEmpty(string)) {
                o("code is null!!!");
            } else if ("0".equals(string)) {
                m(string2);
            } else {
                n(string2);
            }
        } else {
            n("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar == null) {
            return true;
        }
        aVar.t();
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        android.os.Bundle h = com.sina.weibo.sdk.c.e.h(str);
        if (h != null) {
            java.lang.String string = h.getString("code");
            java.lang.String string2 = h.getString("msg");
            if ("0".equals(string)) {
                m(string2);
            } else {
                n(string2);
            }
        } else {
            n("bundle is null!!!");
        }
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar == null) {
            return true;
        }
        aVar.t();
        return true;
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void t() {
        o("cancel share!!!");
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final boolean v() {
        t();
        return true;
    }
}
