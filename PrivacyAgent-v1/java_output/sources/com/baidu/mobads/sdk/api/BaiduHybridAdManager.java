package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class BaiduHybridAdManager {
    private com.baidu.mobads.sdk.internal.dg mAdProd;
    private java.lang.String mAppSid;
    private android.webkit.WebView mWebView;
    private com.baidu.mobads.sdk.api.BaiduHybridAdViewListener mBaiduHybridAdViewListener = new com.baidu.mobads.sdk.api.BaiduHybridAdManager.AnonymousClass1();
    private boolean mAppPageReceivedError = false;

    /* renamed from: com.baidu.mobads.sdk.api.BaiduHybridAdManager$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.api.BaiduHybridAdViewListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdClick(int i, java.lang.String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdFailed(int i, java.lang.String str, java.lang.String str2) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdShow(int i, java.lang.String str) {
        }
    }

    public void injectJavaScriptBridge(android.webkit.WebView webView) {
        if (this.mAppPageReceivedError) {
            return;
        }
        this.mWebView = webView;
        com.baidu.mobads.sdk.internal.dg dgVar = new com.baidu.mobads.sdk.internal.dg(this.mWebView);
        this.mAdProd = dgVar;
        dgVar.h(this.mAppSid);
        this.mAdProd.a(this.mBaiduHybridAdViewListener);
        this.mAdProd.a();
    }

    public void onPageStarted(android.webkit.WebView webView, java.lang.String str, android.graphics.Bitmap bitmap) {
        this.mAppPageReceivedError = false;
    }

    public void onReceivedError(android.webkit.WebView webView, int i, java.lang.String str, java.lang.String str2) {
        this.mAppPageReceivedError = true;
    }

    public void setAppSid(java.lang.String str) {
        this.mAppSid = str;
    }

    public void setBaiduHybridAdViewListener(com.baidu.mobads.sdk.api.BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(android.webkit.WebView webView, java.lang.String str) {
        com.baidu.mobads.sdk.internal.dg dgVar;
        if (!this.mAppPageReceivedError && (dgVar = this.mAdProd) != null) {
            dgVar.b(webView, str);
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if ("mobadssdk".equals(parse.getScheme())) {
                return true;
            }
            return "mobads".equals(parse.getScheme());
        } catch (java.lang.Exception e) {
            java.lang.System.err.println(e);
            return false;
        }
    }
}
