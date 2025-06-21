package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ai implements java.lang.Runnable {
    final /* synthetic */ org.json.JSONObject a;
    final /* synthetic */ android.webkit.WebView b;
    final /* synthetic */ com.baidu.mobads.sdk.internal.ae c;

    public ai(com.baidu.mobads.sdk.internal.ae aeVar, org.json.JSONObject jSONObject, android.webkit.WebView webView) {
        this.c = aeVar;
        this.a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a == null || this.b == null) {
            return;
        }
        java.lang.String str = "javascript:window.sdkCallback.userInteractCb(\"" + this.a.toString().replace("\"", "\\\"") + "\")";
        android.webkit.WebView webView = this.b;
        com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
        webView.loadUrl(str);
    }
}
