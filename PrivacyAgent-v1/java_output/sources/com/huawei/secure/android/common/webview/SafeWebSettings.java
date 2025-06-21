package com.huawei.secure.android.common.webview;

/* loaded from: classes22.dex */
public class SafeWebSettings {
    public static void disableContentAccess(android.webkit.WebSettings webSettings) {
        webSettings.setAllowContentAccess(false);
    }

    public static void disableFileCrossAccess(android.webkit.WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    public static void disableGeolocation(android.webkit.WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void disableMixedContentMode(android.webkit.WebSettings webSettings) {
        webSettings.setMixedContentMode(1);
    }

    public static void disablePasswordStorage(android.webkit.WebSettings webSettings) {
    }

    public static void initWebviewAndSettings(android.webkit.WebView webView) {
        android.webkit.WebSettings settings = webView.getSettings();
        disableFileCrossAccess(settings);
        removeUnSafeJavascriptImpl(webView);
        disablePasswordStorage(settings);
        disableGeolocation(settings);
        disableMixedContentMode(settings);
        disableContentAccess(settings);
    }

    public static void removeUnSafeJavascriptImpl(android.webkit.WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }
}
