package com.commonsware.cwac.netsecurity;

/* loaded from: classes22.dex */
public class OkHttp3Integrator {

    public static class CleartextAttemptException extends java.lang.RuntimeException {
        public CleartextAttemptException(java.lang.String str) {
            super(str);
        }
    }

    public static class X509Interceptor implements okhttp3.Interceptor {
        private final com.commonsware.cwac.netsecurity.TrustManagerBuilder builder;
        private final com.commonsware.cwac.netsecurity.CompositeTrustManager trustManager;

        private X509Interceptor(com.commonsware.cwac.netsecurity.CompositeTrustManager compositeTrustManager, com.commonsware.cwac.netsecurity.TrustManagerBuilder trustManagerBuilder) {
            this.trustManager = compositeTrustManager;
            this.builder = trustManagerBuilder;
        }

        public /* synthetic */ X509Interceptor(com.commonsware.cwac.netsecurity.CompositeTrustManager compositeTrustManager, com.commonsware.cwac.netsecurity.TrustManagerBuilder trustManagerBuilder, com.commonsware.cwac.netsecurity.OkHttp3Integrator.AnonymousClass1 anonymousClass1) {
            this(compositeTrustManager, trustManagerBuilder);
        }

        @Override // okhttp3.Interceptor
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
            okhttp3.Response proceed;
            okhttp3.Request request = chain.request();
            java.lang.String host = request.url().host();
            if (!request.url().scheme().equals(com.alipay.sdk.m.l.a.q) || this.builder.isCleartextTrafficPermitted(host)) {
                synchronized (this) {
                    this.trustManager.setHost(host);
                    proceed = chain.proceed(request);
                }
                return proceed;
            }
            throw new com.commonsware.cwac.netsecurity.OkHttp3Integrator.CleartextAttemptException("Cleartext blocked for " + request.url());
        }
    }

    public static okhttp3.OkHttpClient.Builder applyTo(com.commonsware.cwac.netsecurity.TrustManagerBuilder trustManagerBuilder, okhttp3.OkHttpClient.Builder builder) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        com.commonsware.cwac.netsecurity.CompositeTrustManager build = trustManagerBuilder.build();
        if (build.size() > 0) {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            com.commonsware.cwac.netsecurity.OkHttp3Integrator.X509Interceptor x509Interceptor = new com.commonsware.cwac.netsecurity.OkHttp3Integrator.X509Interceptor(build, trustManagerBuilder, null);
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{build}, null);
            builder.sslSocketFactory(sSLContext.getSocketFactory(), build);
            builder.addInterceptor(x509Interceptor);
            builder.addNetworkInterceptor(x509Interceptor);
        }
        return builder;
    }
}
