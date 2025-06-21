package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class dg extends com.baidu.mobads.sdk.internal.bi {
    private android.webkit.WebView a;
    private com.baidu.mobads.sdk.api.BaiduHybridAdViewListener t;
    private com.baidu.mobads.sdk.api.IXHybridAdRenderer u;

    public dg(android.webkit.WebView webView) {
        super(webView.getContext());
        this.a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
        this.a.getSettings().setAllowContentAccess(false);
        this.a.getSettings().setSavePassword(false);
        this.a.getSettings().setAllowFileAccess(false);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a() {
        if (this.u == null) {
            this.n = false;
            return;
        }
        this.n = true;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        try {
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.u.createProdHandler(jSONObject3);
            m();
            if (!android.text.TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            jSONObject.put(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.PROD, com.baidu.mobads.sdk.api.IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        this.u.loadAd(jSONObject, jSONObject2);
    }

    public void a(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
        com.baidu.mobads.sdk.api.IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i, str, str2);
        }
    }

    public void a(android.webkit.WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        com.baidu.mobads.sdk.api.IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    public void a(android.webkit.WebView webView, java.lang.String str) {
        com.baidu.mobads.sdk.api.IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        com.baidu.mobads.sdk.api.IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    public void a(com.baidu.mobads.sdk.api.BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.t = baiduHybridAdViewListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        this.u.setCustomerWebView(this.a);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void a(java.lang.String str, int i, java.lang.String str2) {
        super.a(str, i, str2);
        com.baidu.mobads.sdk.api.BaiduHybridAdViewListener baiduHybridAdViewListener = this.t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    public boolean b(android.webkit.WebView webView, java.lang.String str) {
        com.baidu.mobads.sdk.api.IXHybridAdRenderer iXHybridAdRenderer = this.u;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h() {
        com.baidu.mobads.sdk.api.IXHybridAdRenderer iXHybridAdRenderer = (com.baidu.mobads.sdk.api.IXHybridAdRenderer) com.baidu.mobads.sdk.internal.au.a(com.baidu.mobads.sdk.internal.z.j, com.baidu.mobads.sdk.internal.bs.a(this.i), (java.lang.Class<?>[]) new java.lang.Class[]{android.content.Context.class}, this.i);
        this.u = iXHybridAdRenderer;
        this.m = iXHybridAdRenderer;
        if (this.n) {
            return;
        }
        a();
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void h(com.baidu.mobads.sdk.api.IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        com.baidu.mobads.sdk.api.BaiduHybridAdViewListener baiduHybridAdViewListener = this.t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bi
    public void q() {
        super.q();
        com.baidu.mobads.sdk.api.BaiduHybridAdViewListener baiduHybridAdViewListener = this.t;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }
}
