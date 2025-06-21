package com.tencent.open.web.security;

/* loaded from: classes19.dex */
public class c extends com.tencent.open.a.C0500a {
    private java.lang.String d;

    public c(android.webkit.WebView webView, long j, java.lang.String str, java.lang.String str2) {
        super(webView, j, str);
        this.d = str2;
    }

    private void b(java.lang.String str) {
        android.webkit.WebView webView = this.a.get();
        if (webView != null) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.d);
            stringBuffer.append("){");
            stringBuffer.append(this.d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            java.lang.String stringBuffer2 = stringBuffer.toString();
            com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.a.C0500a
    public void a() {
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.a.C0500a
    public void a(java.lang.Object obj) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.a.C0500a
    public void a(java.lang.String str) {
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("result", !com.tencent.open.b.c.a ? -4 : 0);
            jSONObject.put("sn", this.b);
            jSONObject.put("data", str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
