package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface IXHybridAdRenderer extends com.baidu.mobads.sdk.api.IAdInterListener {
    java.lang.String getJavaScriptBridge();

    void onPageFinished(android.webkit.WebView webView, java.lang.String str);

    void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap);

    void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2);

    void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError);

    void setCustomerWebView(android.webkit.WebView webView);

    boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str);
}
