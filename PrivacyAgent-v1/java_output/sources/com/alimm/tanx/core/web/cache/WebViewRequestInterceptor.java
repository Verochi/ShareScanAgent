package com.alimm.tanx.core.web.cache;

/* loaded from: classes.dex */
public interface WebViewRequestInterceptor {
    void clearCache();

    void enableForce(boolean z);

    java.io.InputStream getCacheFile(java.lang.String str);

    java.io.File getCachePath();

    void initAssetsData();

    android.webkit.WebResourceResponse interceptRequest(android.webkit.WebResourceRequest webResourceRequest);

    android.webkit.WebResourceResponse interceptRequest(java.lang.String str);

    void loadUrl(android.webkit.WebView webView, java.lang.String str);

    void loadUrl(android.webkit.WebView webView, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map);

    void loadUrl(java.lang.String str, java.lang.String str2);

    void loadUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2);
}
