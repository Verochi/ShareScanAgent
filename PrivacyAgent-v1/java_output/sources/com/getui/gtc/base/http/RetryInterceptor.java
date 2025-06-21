package com.getui.gtc.base.http;

/* loaded from: classes22.dex */
public class RetryInterceptor implements com.getui.gtc.base.http.Interceptor {
    private static final int MAX_RETRY_COUNT = 3;
    private volatile boolean canceled;
    private final com.getui.gtc.base.http.GtHttpClient client;
    private volatile java.net.HttpURLConnection connection;

    public RetryInterceptor(com.getui.gtc.base.http.GtHttpClient gtHttpClient) {
        this.client = gtHttpClient;
    }

    private boolean isRecoverable(java.io.IOException iOException) {
        if (iOException instanceof java.net.ProtocolException) {
            return false;
        }
        return iOException instanceof java.io.InterruptedIOException ? iOException instanceof java.net.SocketTimeoutException : (((iOException instanceof javax.net.ssl.SSLHandshakeException) && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(java.io.IOException iOException, java.net.HttpURLConnection httpURLConnection, com.getui.gtc.base.http.Request request) {
        return this.client.isRetryOnConnectionFailure() && isRecoverable(iOException);
    }

    public void cancel() {
        this.canceled = true;
        if (this.connection != null) {
            this.connection.disconnect();
        }
    }

    @Override // com.getui.gtc.base.http.Interceptor
    public com.getui.gtc.base.http.Response intercept(com.getui.gtc.base.http.Interceptor.Chain chain) throws java.io.IOException {
        com.getui.gtc.base.http.Request request = chain.request();
        com.getui.gtc.base.http.RealInterceptorChain realInterceptorChain = (com.getui.gtc.base.http.RealInterceptorChain) chain;
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) request.url().openConnection();
        this.connection = httpURLConnection;
        int i = 0;
        while (!this.canceled) {
            try {
                com.getui.gtc.base.http.Response proceed = realInterceptorChain.proceed(request, httpURLConnection);
                httpURLConnection.disconnect();
                return proceed;
            } catch (java.io.IOException e) {
                if (i >= 3 || !recover(e, httpURLConnection, request)) {
                    throw e;
                }
                httpURLConnection.disconnect();
                httpURLConnection = (java.net.HttpURLConnection) request.url().openConnection();
                this.connection = httpURLConnection;
                i++;
            }
        }
        httpURLConnection.disconnect();
        throw new java.io.IOException("Canceled");
    }
}
