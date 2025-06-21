package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public final class g implements com.anythink.expressad.atsignalcommon.windvane.b {
    private static com.anythink.expressad.atsignalcommon.windvane.g a = new com.anythink.expressad.atsignalcommon.windvane.g();

    private g() {
    }

    private static com.anythink.expressad.atsignalcommon.windvane.g a() {
        return a;
    }

    private static void a(android.webkit.WebView webView, java.lang.String str, java.lang.String str2) {
        java.lang.String format = android.text.TextUtils.isEmpty(str2) ? java.lang.String.format("javascript:window.MvBridge.fireEvent('%s', '');", str) : java.lang.String.format("javascript:window.MvBridge.fireEvent('%s','%s');", str, com.anythink.expressad.atsignalcommon.windvane.n.c(str2));
        if (webView != null) {
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

    @Override // com.anythink.expressad.atsignalcommon.windvane.b
    public final void a(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            java.lang.String format = android.text.TextUtils.isEmpty(str) ? java.lang.String.format("javascript:window.OW.onSuccess(%s,'');", aVar.g) : java.lang.String.format("javascript:window.OW.onSuccess(%s,'%s');", aVar.g, com.anythink.expressad.atsignalcommon.windvane.n.c(str));
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            if (windVaneWebView != null) {
                try {
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, format);
                    windVaneWebView.loadUrl(format);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.b
    public final void a(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            java.lang.String format = android.text.TextUtils.isEmpty(str2) ? java.lang.String.format("javascript:window.MvBridge.fireEvent('%s', '');", str) : java.lang.String.format("javascript:window.MvBridge.fireEvent('%s','%s');", str, com.anythink.expressad.atsignalcommon.windvane.n.c(str2));
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            if (windVaneWebView != null) {
                try {
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, format);
                    windVaneWebView.loadUrl(format);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    @Override // com.anythink.expressad.atsignalcommon.windvane.b
    public final void b(java.lang.Object obj, java.lang.String str) {
        if (obj instanceof com.anythink.expressad.atsignalcommon.windvane.a) {
            com.anythink.expressad.atsignalcommon.windvane.a aVar = (com.anythink.expressad.atsignalcommon.windvane.a) obj;
            if (android.text.TextUtils.isEmpty(str)) {
                java.lang.String.format("javascript:window.MvBridge.onFailure(%s,'');", aVar.g);
            } else {
                str = com.anythink.expressad.atsignalcommon.windvane.n.c(str);
            }
            java.lang.String format = java.lang.String.format("javascript:window.MvBridge.onFailure(%s,'%s');", aVar.g, str);
            com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView = aVar.a;
            if (windVaneWebView != null) {
                try {
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(windVaneWebView, format);
                    windVaneWebView.loadUrl(format);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
