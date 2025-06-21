package com.anythink.core.basead.ui.web;

/* loaded from: classes12.dex */
public final class c {
    com.anythink.core.common.f.l a;
    org.json.JSONObject b;
    java.util.HashMap<java.lang.String, java.lang.Boolean> c = new java.util.HashMap<>(3);

    public c(com.anythink.core.common.f.l lVar) {
        org.json.JSONObject jSONObject;
        this.a = lVar;
        if (lVar != null) {
            try {
                jSONObject = new org.json.JSONObject(lVar.P());
            } catch (java.lang.Throwable unused) {
                return;
            }
        } else {
            jSONObject = null;
        }
        this.b = jSONObject;
    }

    public final void a(android.webkit.WebView webView, java.lang.String str) {
        org.json.JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            return;
        }
        try {
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                java.lang.String next = keys.next();
                if (next != null && str != null && str.contains(next) && this.c.get(next) == null) {
                    this.c.put(next, java.lang.Boolean.TRUE);
                    java.lang.String optString = this.b.optString(next);
                    com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, optString);
                    webView.loadUrl(optString);
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }
}
