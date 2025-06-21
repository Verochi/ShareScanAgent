package com.aliyun.vod.qupaiokhttp;

/* loaded from: classes12.dex */
public class OkHttpFinal {
    private static com.aliyun.vod.qupaiokhttp.OkHttpFinal okHttpFinal;
    private com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration configuration;
    private okhttp3.OkHttpClient okHttpClient;

    private OkHttpFinal() {
    }

    public static com.aliyun.vod.qupaiokhttp.OkHttpFinal getInstance() {
        if (okHttpFinal == null) {
            okHttpFinal = new com.aliyun.vod.qupaiokhttp.OkHttpFinal();
        }
        return okHttpFinal;
    }

    public java.util.List<java.io.InputStream> getCertificateList() {
        return this.configuration.getCertificateList();
    }

    public okhttp3.Headers getCommonHeaders() {
        return this.configuration.getCommonHeaders();
    }

    public java.util.List<com.aliyun.vod.qupaiokhttp.Part> getCommonParams() {
        return this.configuration.getCommonParams();
    }

    public javax.net.ssl.HostnameVerifier getHostnameVerifier() {
        return this.configuration.getHostnameVerifier();
    }

    @java.lang.Deprecated
    public okhttp3.OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    public okhttp3.OkHttpClient.Builder getOkHttpClientBuilder() {
        return this.okHttpClient.newBuilder();
    }

    public long getTimeout() {
        return this.configuration.getTimeout();
    }

    public synchronized void init(com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration okHttpFinalConfiguration) {
        this.configuration = okHttpFinalConfiguration;
        long timeout = okHttpFinalConfiguration.getTimeout();
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okhttp3.OkHttpClient.Builder readTimeout = builder.connectTimeout(timeout, timeUnit).writeTimeout(timeout, timeUnit).readTimeout(timeout, timeUnit);
        if (okHttpFinalConfiguration.getHostnameVerifier() != null) {
            readTimeout.hostnameVerifier(okHttpFinalConfiguration.getHostnameVerifier());
        }
        java.util.List<java.io.InputStream> certificateList = okHttpFinalConfiguration.getCertificateList();
        if (certificateList != null && certificateList.size() > 0) {
            new com.aliyun.vod.qupaiokhttp.https.HttpsCerManager(readTimeout).setCertificates(certificateList);
        }
        okhttp3.CookieJar cookieJar = okHttpFinalConfiguration.getCookieJar();
        if (cookieJar != null) {
            readTimeout.cookieJar(cookieJar);
        }
        if (okHttpFinalConfiguration.getCache() != null) {
            readTimeout.cache(okHttpFinalConfiguration.getCache());
        }
        if (okHttpFinalConfiguration.getAuthenticator() != null) {
            readTimeout.authenticator(okHttpFinalConfiguration.getAuthenticator());
        }
        if (okHttpFinalConfiguration.getCertificatePinner() != null) {
            readTimeout.certificatePinner(okHttpFinalConfiguration.getCertificatePinner());
        }
        readTimeout.followRedirects(okHttpFinalConfiguration.isFollowRedirects());
        readTimeout.followSslRedirects(okHttpFinalConfiguration.isFollowSslRedirects());
        if (okHttpFinalConfiguration.getSslSocketFactory() != null && okHttpFinalConfiguration.getX509TrustManager() != null) {
            readTimeout.sslSocketFactory(okHttpFinalConfiguration.getSslSocketFactory(), okHttpFinalConfiguration.getX509TrustManager());
        }
        if (okHttpFinalConfiguration.getDispatcher() != null) {
            readTimeout.dispatcher(okHttpFinalConfiguration.getDispatcher());
        }
        readTimeout.retryOnConnectionFailure(okHttpFinalConfiguration.isRetryOnConnectionFailure());
        if (okHttpFinalConfiguration.getNetworkInterceptorList() != null) {
            readTimeout.networkInterceptors().addAll(okHttpFinalConfiguration.getNetworkInterceptorList());
        }
        if (okHttpFinalConfiguration.getInterceptorList() != null) {
            readTimeout.interceptors().addAll(okHttpFinalConfiguration.getInterceptorList());
        }
        if (okHttpFinalConfiguration.getProxy() != null) {
            readTimeout.proxy(okHttpFinalConfiguration.getProxy());
        }
        com.aliyun.vod.qupaiokhttp.ILogger.DEBUG = okHttpFinalConfiguration.isDebug();
        com.aliyun.vod.qupaiokhttp.ILogger.d("OkHttpFinal init...", new java.lang.Object[0]);
        com.aliyun.vod.qupaiokhttp.Constants.DEBUG = okHttpFinalConfiguration.isDebug();
        this.okHttpClient = readTimeout.build();
    }

    public void updateCommonHeader(java.lang.String str, java.lang.String str2) {
        okhttp3.Headers commonHeaders = this.configuration.getCommonHeaders();
        if (commonHeaders == null) {
            commonHeaders = new okhttp3.Headers.Builder().build();
        }
        this.configuration.commonHeaders = commonHeaders.newBuilder().set(str, str2).build();
    }

    public void updateCommonParams(java.lang.String str, java.lang.String str2) {
        boolean z;
        java.util.List<com.aliyun.vod.qupaiokhttp.Part> commonParams = this.configuration.getCommonParams();
        if (commonParams != null) {
            for (com.aliyun.vod.qupaiokhttp.Part part : commonParams) {
                if (part != null && android.text.TextUtils.equals(part.getKey(), str)) {
                    part.setValue(str2);
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return;
        }
        commonParams.add(new com.aliyun.vod.qupaiokhttp.Part(str, str2));
    }
}
