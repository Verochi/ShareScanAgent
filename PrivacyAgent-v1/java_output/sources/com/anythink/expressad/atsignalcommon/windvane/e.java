package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public interface e {
    void loadingResourceStatus(android.webkit.WebView webView, int i);

    void onPageFinished(android.webkit.WebView webView, java.lang.String str);

    void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap);

    void onProgressChanged(android.webkit.WebView webView, int i);

    void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2);

    void onReceivedSslError(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError);

    void readyState(android.webkit.WebView webView, int i);

    boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str);
}
