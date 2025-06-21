package com.sina.weibo.sdk.web.a;

/* loaded from: classes19.dex */
public abstract class b extends android.webkit.WebViewClient {
    protected com.sina.weibo.sdk.auth.b aC = com.sina.weibo.sdk.auth.b.f();
    protected android.app.Activity aD;
    protected com.sina.weibo.sdk.web.a aE;
    protected com.sina.weibo.sdk.web.b.b aF;
    protected com.sina.weibo.sdk.auth.WbAuthListener aG;

    public b(android.app.Activity activity, com.sina.weibo.sdk.web.a aVar, com.sina.weibo.sdk.web.b.b bVar) {
        this.aD = activity;
        this.aE = aVar;
        this.aF = bVar;
    }

    private void b(int i, java.lang.String str) {
        android.os.Bundle extras = this.aD.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent(this.aD, (java.lang.Class<?>) com.sina.weibo.sdk.share.ShareResultActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i);
        intent.putExtra("_weibo_resp_errstr", str);
        this.aD.startActivity(intent);
    }

    public final void m(java.lang.String str) {
        b(0, str);
    }

    public final void n(java.lang.String str) {
        b(2, str);
    }

    public final void o(java.lang.String str) {
        b(1, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(android.webkit.WebView webView, java.lang.String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @android.annotation.TargetApi(23)
    public void onReceivedError(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceError webResourceError) {
        java.lang.CharSequence description;
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        com.sina.weibo.sdk.web.a aVar = this.aE;
        if (aVar != null) {
            webResourceError.getErrorCode();
            description = webResourceError.getDescription();
            description.toString();
            webResourceRequest.getUrl().toString();
            aVar.s();
        }
    }

    public void p(java.lang.String str) {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public void t() {
    }

    public boolean v() {
        return false;
    }
}
