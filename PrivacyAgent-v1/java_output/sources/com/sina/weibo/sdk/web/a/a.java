package com.sina.weibo.sdk.web.a;

/* loaded from: classes19.dex */
public final class a extends com.sina.weibo.sdk.web.a.b {
    public a(android.app.Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        super(activity, aVar, bVar);
    }

    private boolean l(java.lang.String str) {
        android.os.Bundle g;
        com.sina.weibo.sdk.auth.AuthInfo a = this.aF.x().a();
        return (a == null || !str.startsWith(a.getRedirectUrl()) || (g = com.sina.weibo.sdk.c.e.g(str)) == null || android.text.TextUtils.isEmpty(g.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN))) ? false : true;
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        super.onPageFinished(webView, str);
        com.sina.weibo.sdk.auth.AuthInfo a = this.aF.x().a();
        if (a == null || !str.startsWith(a.getRedirectUrl())) {
            return;
        }
        java.lang.String u = this.aF.x().u();
        if (!android.text.TextUtils.isEmpty(u)) {
            com.sina.weibo.sdk.auth.WbAuthListener a2 = this.aC.a(u);
            this.aG = a2;
            if (a2 != null) {
                android.os.Bundle g = com.sina.weibo.sdk.c.e.g(str);
                if (g != null) {
                    java.lang.String string = g.getString("error");
                    java.lang.String string2 = g.getString("error_code");
                    java.lang.String string3 = g.getString("error_description");
                    if (android.text.TextUtils.isEmpty(string) && android.text.TextUtils.isEmpty(string2)) {
                        com.sina.weibo.sdk.auth.Oauth2AccessToken parseAccessToken = com.sina.weibo.sdk.auth.Oauth2AccessToken.parseAccessToken(g);
                        com.sina.weibo.sdk.auth.AccessTokenHelper.writeAccessToken(this.aD, parseAccessToken);
                        this.aG.onComplete(parseAccessToken);
                    } else {
                        this.aG.onError(new com.sina.weibo.sdk.common.UiError(-1, string2, string3));
                    }
                } else {
                    this.aG.onError(new com.sina.weibo.sdk.common.UiError(-1, "bundle is null", "parse url error"));
                }
                this.aC.b(u);
            }
        }
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.sina.weibo.sdk.web.a.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        return l(webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        return l(str);
    }

    @Override // com.sina.weibo.sdk.web.a.b
    public final void t() {
        super.t();
        java.lang.String u = this.aF.x().u();
        if (!android.text.TextUtils.isEmpty(u)) {
            com.sina.weibo.sdk.auth.WbAuthListener a = this.aC.a(u);
            this.aG = a;
            if (a != null) {
                a.onCancel();
            }
            this.aC.b(u);
        }
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
