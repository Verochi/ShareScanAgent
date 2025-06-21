package com.alimm.tanx.core.web.cache;

/* loaded from: classes.dex */
public class WebViewCacheInterceptor implements com.alimm.tanx.core.web.cache.WebViewRequestInterceptor {
    public static final java.lang.String KEY_CACHE = "WebResourceInterceptor-Key-Cache";
    private java.lang.String mAssetsDir;
    private final com.alimm.tanx.core.web.cache.config.CacheExtensionConfig mCacheExtensionConfig;
    private final java.io.File mCacheFile;
    private final long mCacheSize;
    private com.alimm.tanx.core.web.cache.CacheType mCacheType;
    private final long mConnectTimeout;
    private final android.content.Context mContext;
    private final boolean mDebug;
    private okhttp3.Dns mDns;
    private final java.io.File mDynamicCacheFile;
    private boolean mIsSuffixMod;
    private final long mReadTimeout;
    private final com.alimm.tanx.core.web.cache.ResourceInterceptor mResourceInterceptor;
    private javax.net.ssl.SSLSocketFactory mSSLSocketFactory;
    private boolean mTrustAllHostname;
    private javax.net.ssl.X509TrustManager mX509TrustManager;
    private final java.lang.String TAG = "WebViewCacheInterceptor";
    private okhttp3.OkHttpClient mHttpClient = null;
    private java.lang.String mOrigin = "";
    private java.lang.String mReferer = "";
    private java.lang.String mUserAgent = "";

    /* renamed from: com.alimm.tanx.core.web.cache.WebViewCacheInterceptor$1, reason: invalid class name */
    public class AnonymousClass1 implements javax.net.ssl.HostnameVerifier {
        public AnonymousClass1() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            return true;
        }
    }

    public static class Builder {
        private java.io.File mCacheFile;
        private final android.content.Context mContext;
        private java.io.File mDynamicCacheFile;
        private com.alimm.tanx.core.web.cache.ResourceInterceptor mResourceInterceptor;
        private long mCacheSize = 104857600;
        private long mConnectTimeout = 20;
        private long mReadTimeout = 20;
        private boolean mDebug = true;
        private com.alimm.tanx.core.web.cache.CacheType mCacheType = com.alimm.tanx.core.web.cache.CacheType.FORCE;
        private boolean mTrustAllHostname = false;
        private javax.net.ssl.SSLSocketFactory mSSLSocketFactory = null;
        private javax.net.ssl.X509TrustManager mX509TrustManager = null;
        private java.lang.String mAssetsDir = null;
        private boolean mIsSuffixMod = false;
        private okhttp3.Dns mDns = null;
        private com.alimm.tanx.core.web.cache.config.CacheExtensionConfig mCacheExtensionConfig = new com.alimm.tanx.core.web.cache.config.CacheExtensionConfig();

        public Builder(android.content.Context context) {
            this.mContext = context;
            this.mCacheFile = new java.io.File(context.getCacheDir().toString(), "CacheWebViewCache");
        }

        public com.alimm.tanx.core.web.cache.WebViewRequestInterceptor build() {
            return new com.alimm.tanx.core.web.cache.WebViewCacheInterceptor(this);
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder isAssetsSuffixMod(boolean z) {
            this.mIsSuffixMod = z;
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setAssetsDir(java.lang.String str) {
            if (str != null) {
                this.mAssetsDir = str;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setCacheExtensionConfig(com.alimm.tanx.core.web.cache.config.CacheExtensionConfig cacheExtensionConfig) {
            if (cacheExtensionConfig != null) {
                this.mCacheExtensionConfig = cacheExtensionConfig;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setCachePath(java.io.File file) {
            if (file != null) {
                this.mCacheFile = file;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setCacheSize(long j) {
            if (j > 1024) {
                this.mCacheSize = j;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setCacheType(com.alimm.tanx.core.web.cache.CacheType cacheType) {
            this.mCacheType = cacheType;
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setConnectTimeoutSecond(long j) {
            if (j >= 0) {
                this.mConnectTimeout = j;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public void setDns(okhttp3.Dns dns) {
            this.mDns = dns;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setDynamicCachePath(java.io.File file) {
            if (file != null) {
                this.mDynamicCacheFile = file;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setReadTimeoutSecond(long j) {
            if (j >= 0) {
                this.mReadTimeout = j;
            }
            return this;
        }

        public void setResourceInterceptor(com.alimm.tanx.core.web.cache.ResourceInterceptor resourceInterceptor) {
            this.mResourceInterceptor = resourceInterceptor;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, javax.net.ssl.X509TrustManager x509TrustManager) {
            if (sSLSocketFactory != null && x509TrustManager != null) {
                this.mSSLSocketFactory = sSLSocketFactory;
                this.mX509TrustManager = x509TrustManager;
            }
            return this;
        }

        public com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder setTrustAllHostname() {
            this.mTrustAllHostname = true;
            return this;
        }
    }

    public WebViewCacheInterceptor(com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.Builder builder) {
        this.mAssetsDir = null;
        this.mTrustAllHostname = false;
        this.mSSLSocketFactory = null;
        this.mX509TrustManager = null;
        this.mDns = null;
        this.mIsSuffixMod = false;
        this.mCacheExtensionConfig = builder.mCacheExtensionConfig;
        this.mCacheFile = builder.mCacheFile;
        this.mDynamicCacheFile = builder.mDynamicCacheFile;
        this.mCacheSize = builder.mCacheSize;
        this.mCacheType = builder.mCacheType;
        this.mConnectTimeout = builder.mConnectTimeout;
        this.mReadTimeout = builder.mReadTimeout;
        this.mContext = builder.mContext;
        this.mDebug = builder.mDebug;
        this.mAssetsDir = builder.mAssetsDir;
        this.mX509TrustManager = builder.mX509TrustManager;
        this.mSSLSocketFactory = builder.mSSLSocketFactory;
        this.mTrustAllHostname = builder.mTrustAllHostname;
        this.mResourceInterceptor = builder.mResourceInterceptor;
        this.mIsSuffixMod = builder.mIsSuffixMod;
        this.mDns = builder.mDns;
        initHttpClient();
        if (isEnableAssets()) {
            initAssetsLoader();
        }
    }

    private java.util.Map<java.lang.String, java.lang.String> buildHeaders() {
        java.util.HashMap hashMap = new java.util.HashMap();
        if (!android.text.TextUtils.isEmpty(this.mOrigin)) {
            hashMap.put(com.google.common.net.HttpHeaders.ORIGIN, this.mOrigin);
        }
        if (!android.text.TextUtils.isEmpty(this.mReferer)) {
            hashMap.put(com.google.common.net.HttpHeaders.REFERER, this.mReferer);
        }
        if (!android.text.TextUtils.isEmpty(this.mUserAgent)) {
            hashMap.put("User-Agent", this.mUserAgent);
        }
        return hashMap;
    }

    private boolean checkUrl(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || !str.startsWith(com.alipay.sdk.m.l.a.q)) {
            return false;
        }
        com.alimm.tanx.core.web.cache.ResourceInterceptor resourceInterceptor = this.mResourceInterceptor;
        if (resourceInterceptor != null && !resourceInterceptor.interceptor(str)) {
            return false;
        }
        java.lang.String fileExtensionFromUrl = com.alimm.tanx.core.web.cache.utils.MimeTypeMapUtils.getFileExtensionFromUrl(str);
        if (android.text.TextUtils.isEmpty(fileExtensionFromUrl) || this.mCacheExtensionConfig.isMedia(fileExtensionFromUrl)) {
            return false;
        }
        return this.mCacheExtensionConfig.canCache(fileExtensionFromUrl);
    }

    private void initAssetsLoader() {
        com.alimm.tanx.core.web.cache.AssetsLoader.getInstance().init(this.mContext).setDir(this.mAssetsDir).isAssetsSuffixMod(this.mIsSuffixMod);
    }

    private void initHttpClient() {
        javax.net.ssl.X509TrustManager x509TrustManager;
        okhttp3.OkHttpClient.Builder cache = new okhttp3.OkHttpClient.Builder().cache(new okhttp3.Cache(this.mCacheFile, this.mCacheSize));
        long j = this.mConnectTimeout;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        okhttp3.OkHttpClient.Builder addNetworkInterceptor = cache.connectTimeout(j, timeUnit).readTimeout(this.mReadTimeout, timeUnit).addNetworkInterceptor(new com.alimm.tanx.core.web.cache.HttpCacheInterceptor());
        if (this.mTrustAllHostname) {
            addNetworkInterceptor.hostnameVerifier(new com.alimm.tanx.core.web.cache.WebViewCacheInterceptor.AnonymousClass1());
        }
        javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.mSSLSocketFactory;
        if (sSLSocketFactory != null && (x509TrustManager = this.mX509TrustManager) != null) {
            addNetworkInterceptor.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        }
        okhttp3.Dns dns = this.mDns;
        if (dns != null) {
            addNetworkInterceptor.dns(dns);
        }
        this.mHttpClient = addNetworkInterceptor.build();
    }

    private android.webkit.WebResourceResponse interceptRequest(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.io.InputStream resByUrl;
        java.io.File resByUrl2;
        java.io.FileInputStream fileInputStream = null;
        if (this.mCacheType == com.alimm.tanx.core.web.cache.CacheType.NORMAL || !checkUrl(str)) {
            return null;
        }
        if (isEnableDynamicCache() && (resByUrl2 = com.alimm.tanx.core.web.cache.DynamicCacheLoader.getInstance().getResByUrl(this.mDynamicCacheFile, str)) != null) {
            com.alimm.tanx.core.utils.LogUtils.d("WebViewCacheInterceptor", java.lang.String.format("from dynamic file: %s", str));
            java.lang.String mimeTypeFromUrl = com.alimm.tanx.core.web.cache.utils.MimeTypeMapUtils.getMimeTypeFromUrl(str);
            try {
                fileInputStream = new java.io.FileInputStream(resByUrl2);
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
            return new android.webkit.WebResourceResponse(mimeTypeFromUrl, "", fileInputStream);
        }
        if (isEnableAssets() && (resByUrl = com.alimm.tanx.core.web.cache.AssetsLoader.getInstance().getResByUrl(str)) != null) {
            com.alimm.tanx.core.utils.LogUtils.d("WebViewCacheInterceptor", java.lang.String.format("from assets: %s", str));
            return new android.webkit.WebResourceResponse(com.alimm.tanx.core.web.cache.utils.MimeTypeMapUtils.getMimeTypeFromUrl(str), "", resByUrl);
        }
        try {
            okhttp3.Request.Builder url = new okhttp3.Request.Builder().url(str);
            if (this.mCacheExtensionConfig.isHtml(com.alimm.tanx.core.web.cache.utils.MimeTypeMapUtils.getFileExtensionFromUrl(str))) {
                map.put(KEY_CACHE, this.mCacheType.ordinal() + "");
            }
            addHeader(url, map);
            if (!com.alimm.tanx.core.web.cache.utils.NetUtils.isConnected(this.mContext)) {
                url.cacheControl(okhttp3.CacheControl.FORCE_CACHE);
            }
            okhttp3.Response execute = this.mHttpClient.newCall(url.build()).execute();
            if (execute.cacheResponse() != null) {
                com.alimm.tanx.core.utils.LogUtils.d("WebViewCacheInterceptor", java.lang.String.format("from cache: %s", str));
            } else {
                com.alimm.tanx.core.utils.LogUtils.d("WebViewCacheInterceptor", java.lang.String.format("from server: %s", str));
            }
            android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(com.alimm.tanx.core.web.cache.utils.MimeTypeMapUtils.getMimeTypeFromUrl(str), "", execute.body().byteStream());
            if (execute.code() == 504 && !com.alimm.tanx.core.web.cache.utils.NetUtils.isConnected(this.mContext)) {
                return null;
            }
            java.lang.String message = execute.message();
            if (android.text.TextUtils.isEmpty(message)) {
                message = com.baidu.mobads.sdk.internal.bz.k;
            }
            try {
                webResourceResponse.setStatusCodeAndReasonPhrase(execute.code(), message);
                webResourceResponse.setResponseHeaders(com.alimm.tanx.core.web.cache.utils.NetUtils.multimapToSingle(execute.headers().toMultimap()));
                return webResourceResponse;
            } catch (java.lang.Exception unused) {
                return null;
            }
        } catch (java.lang.Exception e2) {
            com.alimm.tanx.core.utils.LogUtils.e("WebViewCacheInterceptor", e2);
            return null;
        }
    }

    private boolean isEnableAssets() {
        return this.mAssetsDir != null;
    }

    private boolean isEnableDynamicCache() {
        return this.mDynamicCacheFile != null;
    }

    public void addHeader(okhttp3.Request.Builder builder, java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void clearCache() {
        com.alimm.tanx.core.web.cache.utils.FileUtil.deleteDirs(this.mCacheFile.getAbsolutePath(), false);
        com.alimm.tanx.core.web.cache.AssetsLoader.getInstance().clear();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void enableForce(boolean z) {
        if (z) {
            this.mCacheType = com.alimm.tanx.core.web.cache.CacheType.FORCE;
        } else {
            this.mCacheType = com.alimm.tanx.core.web.cache.CacheType.NORMAL;
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public java.io.InputStream getCacheFile(java.lang.String str) {
        return com.alimm.tanx.core.web.cache.utils.OKHttpFile.getCacheFile(this.mCacheFile, str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public java.io.File getCachePath() {
        return this.mCacheFile;
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void initAssetsData() {
        com.alimm.tanx.core.web.cache.AssetsLoader.getInstance().initData();
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    @android.annotation.TargetApi(21)
    public android.webkit.WebResourceResponse interceptRequest(android.webkit.WebResourceRequest webResourceRequest) {
        return interceptRequest(webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public android.webkit.WebResourceResponse interceptRequest(java.lang.String str) {
        return interceptRequest(str, buildHeaders());
    }

    public boolean isValidUrl(java.lang.String str) {
        return android.webkit.URLUtil.isValidUrl(str);
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(android.webkit.WebView webView, java.lang.String str) {
        if (isValidUrl(str)) {
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str);
            webView.loadUrl(str);
            java.lang.String url = webView.getUrl();
            this.mReferer = url;
            this.mOrigin = com.alimm.tanx.core.web.cache.utils.NetUtils.getOriginUrl(url);
            this.mUserAgent = webView.getSettings().getUserAgentString();
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(android.webkit.WebView webView, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (isValidUrl(str)) {
            com.sensorsdata.analytics.android.sdk.jsbridge.JSHookAop.loadUrl(webView, str, map);
            webView.loadUrl(str, map);
            java.lang.String url = webView.getUrl();
            this.mReferer = url;
            this.mOrigin = com.alimm.tanx.core.web.cache.utils.NetUtils.getOriginUrl(url);
            this.mUserAgent = webView.getSettings().getUserAgentString();
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(java.lang.String str, java.lang.String str2) {
        if (isValidUrl(str)) {
            this.mReferer = str;
            this.mOrigin = com.alimm.tanx.core.web.cache.utils.NetUtils.getOriginUrl(str);
            this.mUserAgent = str2;
        }
    }

    @Override // com.alimm.tanx.core.web.cache.WebViewRequestInterceptor
    public void loadUrl(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2) {
        if (isValidUrl(str)) {
            this.mReferer = str;
            this.mOrigin = com.alimm.tanx.core.web.cache.utils.NetUtils.getOriginUrl(str);
            this.mUserAgent = str2;
        }
    }
}
