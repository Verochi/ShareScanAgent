package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class ConnectInterceptor implements com.getui.gtc.base.http.Interceptor {
    public final com.getui.gtc.base.http.GtHttpClient client;

    public ConnectInterceptor(com.getui.gtc.base.http.GtHttpClient gtHttpClient) {
        this.client = gtHttpClient;
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        com.getui.gtc.base.http.RealInterceptorChain realInterceptorChain = (com.getui.gtc.base.http.RealInterceptorChain) chain;
        com.getui.gtc.base.http.Request request = chain.request();
        java.net.HttpURLConnection connection = chain.connection();
        connection.setDoInput(true);
        connection.setDoOutput(request.body() != null);
        connection.setConnectTimeout(this.client.getConnectTimeout());
        connection.setReadTimeout(this.client.getReadTimeout());
        connection.setInstanceFollowRedirects(this.client.isFollowRedirects());
        connection.setUseCaches(this.client.isUseCache());
        if ("https".equalsIgnoreCase(request.url().getProtocol())) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) connection;
            if (this.client.getSslSocketFactory() != null) {
                httpsURLConnection.setSSLSocketFactory(this.client.getSslSocketFactory());
            }
            if (this.client.getHostnameVerifier() != null) {
                httpsURLConnection.setHostnameVerifier(this.client.getHostnameVerifier());
            }
        }
        java.util.Map<java.lang.String, java.lang.String> headers = request.headers();
        if (headers != null && headers.size() > 0) {
            for (java.lang.String str : headers.keySet()) {
                connection.setRequestProperty(str, headers.get(str));
            }
        }
        connection.connect();
        return realInterceptorChain.proceed(request, connection);
    }
}
