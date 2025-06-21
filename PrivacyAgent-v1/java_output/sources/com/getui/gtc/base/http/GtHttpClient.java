package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class GtHttpClient {
    private final int connectTimeout;
    private final com.getui.gtc.base.http.Dispatcher dispatcher;
    private final boolean followRedirects;
    private final javax.net.ssl.HostnameVerifier hostnameVerifier;
    final java.util.List<com.getui.gtc.base.http.Interceptor> interceptors;
    private final int readTimeout;
    private final boolean retryOnConnectionFailure;
    private final javax.net.ssl.SSLSocketFactory sslSocketFactory;
    private final boolean useCache;

    public static final class Builder {
        int connectTimeout;
        com.getui.gtc.base.http.Dispatcher dispatcher;
        boolean followRedirects;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        final java.util.List<com.getui.gtc.base.http.Interceptor> interceptors;
        int readTimeout;
        boolean retryOnConnectionFailure;
        javax.net.ssl.SSLSocketFactory sslSocketFactory;
        boolean useCache;

        public Builder() {
            this.interceptors = new java.util.ArrayList();
            this.dispatcher = new com.getui.gtc.base.http.Dispatcher();
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.useCache = false;
            this.connectTimeout = com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
            this.readTimeout = com.google.android.exoplayer2.audio.AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
        }

        public Builder(com.getui.gtc.base.http.GtHttpClient gtHttpClient) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.interceptors = arrayList;
            this.dispatcher = gtHttpClient.dispatcher;
            arrayList.addAll(gtHttpClient.interceptors);
            this.sslSocketFactory = gtHttpClient.sslSocketFactory;
            this.hostnameVerifier = gtHttpClient.hostnameVerifier;
            this.followRedirects = gtHttpClient.followRedirects;
            this.retryOnConnectionFailure = gtHttpClient.retryOnConnectionFailure;
            this.useCache = gtHttpClient.useCache;
            this.connectTimeout = gtHttpClient.connectTimeout;
            this.readTimeout = gtHttpClient.readTimeout;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder addInterceptor(com.getui.gtc.base.http.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.interceptors.add(interceptor);
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient build() {
            return new com.getui.gtc.base.http.GtHttpClient(this);
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder connectTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.connectTimeout = com.getui.gtc.base.http.Util.checkDuration("connectTimeout", j, timeUnit);
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder dispatcher(com.getui.gtc.base.http.Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new java.lang.IllegalArgumentException("dispatcher == null");
            }
            this.dispatcher = dispatcher;
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder hostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new java.lang.NullPointerException("hostnameVerifier == null");
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder readTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.readTimeout = com.getui.gtc.base.http.Util.checkDuration("readTimeout", j, timeUnit);
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public final com.getui.gtc.base.http.GtHttpClient.Builder useCache(boolean z) {
            this.useCache = z;
            return this;
        }
    }

    public GtHttpClient() {
        this(new com.getui.gtc.base.http.GtHttpClient.Builder());
    }

    public GtHttpClient(com.getui.gtc.base.http.GtHttpClient.Builder builder) {
        this.dispatcher = builder.dispatcher;
        java.util.List<com.getui.gtc.base.http.Interceptor> immutableList = com.getui.gtc.base.http.Util.immutableList(builder.interceptors);
        this.interceptors = immutableList;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.followRedirects = builder.followRedirects;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.useCache = builder.useCache;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        if (immutableList.contains(null)) {
            throw new java.lang.IllegalStateException("Null interceptor: " + immutableList);
        }
    }

    @java.lang.Deprecated
    public static com.getui.gtc.base.http.GtHttpClient getDefaultInstance() {
        return new com.getui.gtc.base.http.GtHttpClient.Builder().build();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public com.getui.gtc.base.http.Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public javax.net.ssl.HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public java.util.List<com.getui.gtc.base.http.Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public javax.net.ssl.SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public boolean isFollowRedirects() {
        return this.followRedirects;
    }

    public boolean isRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public boolean isUseCache() {
        return this.useCache;
    }

    public com.getui.gtc.base.http.Call newCall(com.getui.gtc.base.http.Request request) {
        return com.getui.gtc.base.http.RealCall.newCall(this, request);
    }
}
