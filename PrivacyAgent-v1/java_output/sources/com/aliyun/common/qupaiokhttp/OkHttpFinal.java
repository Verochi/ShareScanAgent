package com.aliyun.common.qupaiokhttp;

/* loaded from: classes.dex */
public class OkHttpFinal {
    private static com.aliyun.common.qupaiokhttp.OkHttpFinal sOkHttpFinal;
    private com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration mConfiguration;
    private okhttp3.OkHttpClient mOkHttpClient;

    static {
        com.aliyun.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
    }

    private OkHttpFinal() {
    }

    public static com.aliyun.common.qupaiokhttp.OkHttpFinal getInstance() {
        if (sOkHttpFinal == null) {
            synchronized (com.aliyun.common.qupaiokhttp.OkHttpFinal.class) {
                if (sOkHttpFinal == null) {
                    sOkHttpFinal = new com.aliyun.common.qupaiokhttp.OkHttpFinal();
                }
            }
        }
        return sOkHttpFinal;
    }

    public synchronized java.util.List<java.io.InputStream> getCertificateList() {
        return this.mConfiguration.getCertificateList();
    }

    public synchronized okhttp3.Headers getCommonHeaders() {
        return this.mConfiguration.getCommonHeaders();
    }

    public synchronized java.util.List<com.aliyun.common.qupaiokhttp.Part> getCommonParams() {
        return this.mConfiguration.getCommonParams();
    }

    public synchronized javax.net.ssl.HostnameVerifier getHostnameVerifier() {
        return this.mConfiguration.getHostnameVerifier();
    }

    @java.lang.Deprecated
    public synchronized okhttp3.OkHttpClient getOkHttpClient() {
        return this.mOkHttpClient;
    }

    public synchronized okhttp3.OkHttpClient.Builder getOkHttpClientBuilder() {
        if (this.mOkHttpClient == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("mOkhttpClient is null, okhttpFinal = ");
            sb.append(this);
        }
        return this.mOkHttpClient.newBuilder();
    }

    public synchronized long getTimeout() {
        return this.mConfiguration.getTimeout();
    }

    public synchronized void init(com.aliyun.common.qupaiokhttp.OkHttpFinalConfiguration okHttpFinalConfiguration) {
        this.mConfiguration = okHttpFinalConfiguration;
        long timeout = okHttpFinalConfiguration.getTimeout();
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        okhttp3.OkHttpClient.Builder readTimeout = builder.connectTimeout(timeout, timeUnit).writeTimeout(timeout, timeUnit).readTimeout(timeout, timeUnit);
        if (okHttpFinalConfiguration.getHostnameVerifier() != null) {
            readTimeout.hostnameVerifier(okHttpFinalConfiguration.getHostnameVerifier());
        }
        java.util.List<java.io.InputStream> certificateList = okHttpFinalConfiguration.getCertificateList();
        if (certificateList != null && certificateList.size() > 0) {
            new com.aliyun.common.qupaiokhttp.https.HttpsCerManager(readTimeout).setCertificates(certificateList);
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
        if (okHttpFinalConfiguration.getSslSocketFactory() != null) {
            readTimeout.sslSocketFactory(okHttpFinalConfiguration.getSslSocketFactory());
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
        com.aliyun.common.qupaiokhttp.ILogger.DEBUG = okHttpFinalConfiguration.isDebug();
        com.aliyun.common.qupaiokhttp.ILogger.d("OkHttpFinal init...", new java.lang.Object[0]);
        com.aliyun.common.qupaiokhttp.Constants.DEBUG = okHttpFinalConfiguration.isDebug();
        this.mOkHttpClient = readTimeout.build();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("OkhttpFinal init successful, mOkhttpClient = ");
        sb.append(this.mOkHttpClient);
        sb.append(", okhttpFinal = ");
        sb.append(this);
    }

    public synchronized void updateCommonHeader(java.lang.String str, java.lang.String str2) {
        okhttp3.Headers commonHeaders = this.mConfiguration.getCommonHeaders();
        if (commonHeaders == null) {
            commonHeaders = new okhttp3.Headers.Builder().build();
        }
        this.mConfiguration.commonHeaders = commonHeaders.newBuilder().set(str, str2).build();
    }

    public synchronized void updateCommonParams(java.lang.String str, java.lang.String str2) {
        boolean z;
        java.util.List<com.aliyun.common.qupaiokhttp.Part> commonParams = this.mConfiguration.getCommonParams();
        if (commonParams != null) {
            for (com.aliyun.common.qupaiokhttp.Part part : commonParams) {
                if (part != null && android.text.TextUtils.equals(part.getKey(), str)) {
                    part.setValue(str2);
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            commonParams.add(new com.aliyun.common.qupaiokhttp.Part(str, str2));
        }
    }
}
