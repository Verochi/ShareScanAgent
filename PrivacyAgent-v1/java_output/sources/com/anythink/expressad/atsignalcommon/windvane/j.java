package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public final class j implements com.anythink.expressad.atsignalcommon.windvane.b {
    private static com.anythink.expressad.atsignalcommon.windvane.j a = new com.anythink.expressad.atsignalcommon.windvane.j();

    private j() {
    }

    public static com.anythink.expressad.atsignalcommon.windvane.j a() {
        return a;
    }

    public static void a(android.webkit.WebView webView) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.alipay.sdk.m.p.e.l, "1.0.0");
            a(webView, com.anythink.expressad.atsignalcommon.base.e.j, android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception unused) {
            a(webView, com.anythink.expressad.atsignalcommon.base.e.j, "");
        } catch (java.lang.Throwable unused2) {
            a(webView, com.anythink.expressad.atsignalcommon.base.e.j, "");
        }
    }

    public static void a(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        java.lang.String format = android.text.TextUtils.isEmpty(str2) ? java.lang.String.format("javascript:window.WindVane.fireEvent('%s', '');", str) : java.lang.String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, com.anythink.expressad.atsignalcommon.windvane.n.c(str2));
        if (webView != null) {
            if ((webView instanceof com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) && ((com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView) webView).isDestroyed()) {
                return;
            }
            try {
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, format);
                webView.loadUrl(format);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void b(android.webkit.WebView webView) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put(com.alipay.sdk.m.p.e.l, "1.0.0");
            a(webView, "onJSBridgeConnected", android.util.Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (java.lang.Exception unused) {
            a(webView, "onJSBridgeConnected", "");
        } catch (java.lang.Throwable unused2) {
            a(webView, "onJSBridgeConnected", "");
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.b
    public final void a(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            java.lang.String format = android.text.TextUtils.isEmpty(str) ? java.lang.String.format("javascript:window.WindVane.onSuccess(%s,'');", aVar.g) : java.lang.String.format("javascript:window.WindVane.onSuccess(%s,'%s');", aVar.g, com.anythink.expressad.atsignalcommon.windvane.n.c(str));
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            if (windVaneWebView == null || windVaneWebView.isDestroyed()) {
                return;
            }
            try {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = aVar.a;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, format);
                windVaneWebView2.loadUrl(format);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.b
    public final void a(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            java.lang.String format = android.text.TextUtils.isEmpty(str2) ? java.lang.String.format("javascript:window.WindVane.fireEvent('%s', '');", str) : java.lang.String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, com.anythink.expressad.atsignalcommon.windvane.n.c(str2));
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            if (windVaneWebView == null || windVaneWebView.isDestroyed()) {
                return;
            }
            try {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = aVar.a;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, format);
                windVaneWebView2.loadUrl(format);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.b
    public final void b(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            if (android.text.TextUtils.isEmpty(str)) {
                java.lang.String.format("javascript:window.WindVane.onFailure(%s,'');", aVar.g);
            } else {
                str = com.anythink.expressad.atsignalcommon.windvane.n.c(str);
            }
            java.lang.String format = java.lang.String.format("javascript:window.WindVane.onFailure(%s,'%s');", aVar.g, str);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            if (windVaneWebView == null || windVaneWebView.isDestroyed()) {
                return;
            }
            try {
                com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView2 = aVar.a;
                com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView2, format);
                windVaneWebView2.loadUrl(format);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
