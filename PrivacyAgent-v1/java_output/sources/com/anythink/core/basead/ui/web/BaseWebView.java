package com.anythink.core.basead.ui.web;

/* loaded from: classes12.dex */
public class BaseWebView extends android.webkit.WebView {
    private static boolean b;
    protected boolean a;

    public BaseWebView(android.content.Context context) {
        super(context.getApplicationContext());
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        com.anythink.core.basead.ui.a.a.a(this);
        com.anythink.core.common.o.h.a(this);
        if (b) {
            return;
        }
        getContext();
        b = true;
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    private void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setDomStorageEnabled(true);
        getSettings().setCacheMode(-1);
    }

    private static void a(android.content.Context context) {
    }

    private void b() {
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(false);
        getSettings().setAllowFileAccessFromFileURLs(false);
        getSettings().setAllowUniversalAccessFromFileURLs(false);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.a) {
            return;
        }
        this.a = true;
        com.anythink.core.common.o.w.a(this);
        removeAllViews();
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        android.webkit.CookieManager.getInstance().setAcceptThirdPartyCookies(this, com.anythink.core.common.b.r.a(getContext()).b());
    }
}
