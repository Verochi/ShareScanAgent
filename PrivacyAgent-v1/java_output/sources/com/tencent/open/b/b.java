package com.tencent.open.b;

/* loaded from: classes19.dex */
public class b extends android.webkit.WebView {
    public b(android.content.Context context) {
        super(context);
        a();
    }

    public void a() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        com.tencent.open.log.SLog.i("openSDK_LOG.OpenWebView", "removeJSInterface");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setBuiltInZoomControls(true);
            getSettings().setDisplayZoomControls(false);
            setVisibility(8);
            com.tencent.open.log.SLog.i("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls");
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.OpenWebView", "-->OpenWebView.destroy setBuiltInZoomControls", e);
        }
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.webkit.WebSettings settings = getSettings();
        if (settings == null) {
            return;
        }
        settings.setSavePassword(false);
        try {
            java.lang.reflect.Method method = settings.getClass().getMethod("removeJavascriptInterface", java.lang.String.class);
            if (method != null) {
                method.invoke(this, "searchBoxJavaBridge_");
                method.invoke(this, "accessibility");
                method.invoke(this, "accessibilityTraversal");
                com.tencent.open.log.SLog.i("openSDK_LOG.OpenWebView", "remove js interface");
            }
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.OpenWebView", "remove js interface.e:" + e.toString());
        }
    }
}
