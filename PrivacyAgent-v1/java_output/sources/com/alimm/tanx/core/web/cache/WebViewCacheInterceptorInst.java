package com.alimm.tanx.core.web.cache;

/* loaded from: classes.dex */
public class WebViewCacheInterceptorInst implements com.alimm.tanx.core.web.cache.WebViewRequestInterceptor {
    private static volatile com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst webViewCacheInterceptorInst;
    private com.alimm.tanx.core.web.cache.WebViewRequestInterceptor mInterceptor;

    public static com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst getInstance() {
        if (webViewCacheInterceptorInst == null) {
            synchronized (com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst.class) {
                if (webViewCacheInterceptorInst == null) {
                    webViewCacheInterceptorInst = new com.alimm.tanx.core.web.cache.WebViewCacheInterceptorInst();
                }
            }
        }
        return webViewCacheInterceptorInst;
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void clearCache() {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.clearCache();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void enableForce(boolean z) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.enableForce(z);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public java.io.InputStream getCacheFile(java.lang.String str) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.getCacheFile(str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public java.io.File getCachePath() {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.getCachePath();
    }

    public void init(com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder builder) {
        if (builder != null) {
            this.mInterceptor = builder.build();
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void initAssetsData() {
        com.alimm.tanx.core.web.cache.AssetsLoader.getInstance().initData();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    @android.annotation.TargetApi(21)
    public android.webkit.WebResourceResponse interceptRequest(android.webkit.WebResourceRequest webResourceRequest) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.interceptRequest(webResourceRequest);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public android.webkit.WebResourceResponse interceptRequest(java.lang.String str) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return null;
        }
        return webViewRequestInterceptor.interceptRequest(str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(android.webkit.WebView webView, java.lang.String str) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(webView, str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(android.webkit.WebView webView, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(webView, str, map);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(java.lang.String str, java.lang.String str2) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(str, str2);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        com.alimm.tanx.core.web.cache.WebViewRequestInterceptor webViewRequestInterceptor = this.mInterceptor;
        if (webViewRequestInterceptor == null) {
            return;
        }
        webViewRequestInterceptor.loadUrl(str, map, str2);
    }
}
