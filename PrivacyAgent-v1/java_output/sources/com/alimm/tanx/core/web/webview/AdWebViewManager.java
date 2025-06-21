package com.alimm.tanx.core.web.webview;

/* loaded from: classes.dex */
public class AdWebViewManager {
    private static java.lang.String TAG = "AdWebViewManager";
    private com.alimm.tanx.core.web.webview.TanxAdWebView nowWebView;

    private void preload() {
        com.alimm.tanx.core.web.webview.PreloadWebView.getInstance().preload(false);
    }

    public void destroy() {
        com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView = this.nowWebView;
        if (tanxAdWebView != null) {
            tanxAdWebView.destroy();
            com.alimm.tanx.core.web.webview.TanxAdWebView tanxAdWebView2 = this.nowWebView;
            if (tanxAdWebView2 != null) {
                android.view.ViewParent parent = tanxAdWebView2.getParent();
                if (parent != null) {
                    ((android.view.ViewGroup) parent).removeView(this.nowWebView);
                }
                this.nowWebView.removeAllViews();
                this.nowWebView.destroy();
                this.nowWebView = null;
            }
        }
    }

    public com.alimm.tanx.core.web.webview.TanxAdWebView getWebView(android.content.Context context) {
        this.nowWebView = com.alimm.tanx.core.web.webview.PreloadWebView.getInstance().getWebView(context);
        preload();
        return this.nowWebView;
    }
}
