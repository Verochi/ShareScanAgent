package com.aliyun.common.qupaiokhttp;

/* loaded from: classes.dex */
public class OkHttpFinalConfiguration {
    private okhttp3.Authenticator authenticator;
    private okhttp3.Cache cache;
    private java.util.List<java.io.InputStream> certificateList;
    private okhttp3.CertificatePinner certificatePinner;
    protected okhttp3.Headers commonHeaders;
    private java.util.List<com.aliyun.common.qupaiokhttp.Part> commonParams;
    private okhttp3.CookieJar cookieJar;
    private boolean debug;
    private okhttp3.Dispatcher dispatcher;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private javax.net.ssl.HostnameVerifier hostnameVerifier;
    private java.util.List<okhttp3.Interceptor> interceptorList;
    private java.util.List<okhttp3.Interceptor> networkInterceptorList;
    private java.net.Proxy proxy;
    private boolean retryOnConnectionFailure;
    private javax.net.ssl.SSLSocketFactory sslSocketFactory;
    private long timeout;

    public static class Builder {
        private okhttp3.Authenticator authenticator;
        private okhttp3.Cache cache;
        private okhttp3.CertificatePinner certificatePinner;
        private okhttp3.Headers commonHeaders;
        private java.util.List<com.aliyun.common.qupaiokhttp.Part> commonParams;
        private boolean debug;
        private okhttp3.Dispatcher dispatcher;
        private javax.net.ssl.HostnameVerifier hostnameVerifier;
        private java.util.List<okhttp3.Interceptor> interceptorList;
        private java.net.Proxy proxy;
        private javax.net.ssl.SSLSocketFactory sslSocketFactory;
        private long timeout;
        private okhttp3.CookieJar cookieJar = okhttp3.CookieJar.NO_COOKIES;
        private java.util.List<java.io.InputStream> certificateList = new java.util.ArrayList();
        private boolean followSslRedirects = true;
        private boolean followRedirects = true;
        private boolean retryOnConnectionFailure = true;
        private java.util.List<okhttp3.Interceptor> networkInterceptorList = new java.util.ArrayList();

        /* renamed from: com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration$Builder$1, reason: invalid class name */
        public class AnonymousClass1 implements okhttp3.Interceptor {
            final /* synthetic */ java.lang.String val$cacheControlValue;

            public AnonymousClass1(java.lang.String str) {
                this.val$cacheControlValue = str;
            }

            @Override // okhttp3.Interceptor
            public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
                return chain.proceed(chain.request()).newBuilder().removeHeader(com.google.common.net.HttpHeaders.PRAGMA).header("Cache-Control", this.val$cacheControlValue).build();
            }
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration build() {
            return new com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration(this, null);
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setAuthenticator(okhttp3.Authenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCache(okhttp3.Cache cache) {
            this.cache = cache;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCache(okhttp3.Cache cache, java.lang.String str) {
            this.networkInterceptorList.add(new com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder.AnonymousClass1(str));
            this.cache = cache;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCacheAge(okhttp3.Cache cache, int i) {
            setCache(cache, java.lang.String.format("max-age=%d", java.lang.Integer.valueOf(i)));
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCacheStale(okhttp3.Cache cache, int i) {
            setCache(cache, java.lang.String.format("max-stale=%d", java.lang.Integer.valueOf(i)));
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCertificatePinner(okhttp3.CertificatePinner certificatePinner) {
            this.certificatePinner = certificatePinner;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCertificates(java.io.InputStream... inputStreamArr) {
            for (java.io.InputStream inputStream : inputStreamArr) {
                if (inputStream != null) {
                    this.certificateList.add(inputStream);
                }
            }
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCertificates(java.lang.String... strArr) {
            for (java.lang.String str : strArr) {
                if (!com.aliyun.common.utils.StringUtils.isEmpty(str)) {
                    this.certificateList.add(new okio.Buffer().writeUtf8(str).inputStream());
                }
            }
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCommenHeaders(okhttp3.Headers headers) {
            this.commonHeaders = headers;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCommenParams(java.util.List<com.aliyun.common.qupaiokhttp.Part> list) {
            this.commonParams = list;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setCookieJar(okhttp3.CookieJar cookieJar) {
            this.cookieJar = cookieJar;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setDispatcher(okhttp3.Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setFollowRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setFollowSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setHostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setInterceptors(java.util.List<okhttp3.Interceptor> list) {
            this.interceptorList = list;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setNetworkInterceptors(java.util.List<okhttp3.Interceptor> list) {
            if (list != null) {
                this.networkInterceptorList.addAll(list);
            }
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setProxy(java.net.Proxy proxy) {
            this.proxy = proxy;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setRetryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder setTimeout(long j) {
            this.timeout = j;
            return this;
        }
    }

    private OkHttpFinalConfiguration(com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder builder) {
        this.timeout = 30000L;
        this.commonParams = builder.commonParams;
        this.commonHeaders = builder.commonHeaders;
        this.certificateList = builder.certificateList;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.timeout = builder.timeout;
        this.debug = builder.debug;
        this.cookieJar = builder.cookieJar;
        this.cache = builder.cache;
        this.authenticator = builder.authenticator;
        this.certificatePinner = builder.certificatePinner;
        this.followSslRedirects = builder.followSslRedirects;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.proxy = builder.proxy;
        this.networkInterceptorList = builder.networkInterceptorList;
        this.interceptorList = builder.interceptorList;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.dispatcher = builder.dispatcher;
    }

    public /* synthetic */ OkHttpFinalConfiguration(com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.Builder builder, com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration.AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public okhttp3.Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public okhttp3.Cache getCache() {
        return this.cache;
    }

    public java.util.List<java.io.InputStream> getCertificateList() {
        return this.certificateList;
    }

    public okhttp3.CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public okhttp3.Headers getCommonHeaders() {
        return this.commonHeaders;
    }

    public java.util.List<com.aliyun.common.qupaiokhttp.Part> getCommonParams() {
        return this.commonParams;
    }

    public okhttp3.CookieJar getCookieJar() {
        return this.cookieJar;
    }

    public okhttp3.Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public javax.net.ssl.HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public java.util.List<okhttp3.Interceptor> getInterceptorList() {
        return this.interceptorList;
    }

    public java.util.List<okhttp3.Interceptor> getNetworkInterceptorList() {
        return this.networkInterceptorList;
    }

    public java.net.Proxy getProxy() {
        return this.proxy;
    }

    public javax.net.ssl.SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public boolean isRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }
}
