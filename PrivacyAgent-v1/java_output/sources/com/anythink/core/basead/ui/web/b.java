package com.anythink.core.basead.ui.web;

/* loaded from: classes12.dex */
public interface b {
    void callbackClickResult(com.anythink.core.common.f.ba baVar);

    com.anythink.core.basead.ui.web.WebProgressBarView getWebProgressBarView();

    void onWebFinish();

    void onWebPageFinish(android.webkit.WebView webView, java.lang.String str);

    void onWebPageLoadError(android.webkit.WebView webView, java.lang.String str);

    void onWebPageStart(android.webkit.WebView webView, java.lang.String str);

    void recordRedirectUrl(java.lang.String str);
}
