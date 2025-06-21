package com.huawei.secure.android.common.ssl;

/* loaded from: classes22.dex */
public class WebViewSSLCheckThread extends java.lang.Thread {
    public static final java.lang.String A = "WebViewSSLCheckThread";
    public javax.net.ssl.SSLSocketFactory n;
    public javax.net.ssl.HostnameVerifier t;
    public org.apache.http.conn.ssl.SSLSocketFactory u;
    public org.apache.http.conn.ssl.X509HostnameVerifier v;
    public android.webkit.SslErrorHandler w;
    public java.lang.String x;
    public com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback y;
    public android.content.Context z;

    public interface Callback {
        void onCancel(android.content.Context context, java.lang.String str);

        void onProceed(android.content.Context context, java.lang.String str);
    }

    public static class a implements okhttp3.Callback {
        public final /* synthetic */ com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback n;
        public final /* synthetic */ android.content.Context t;
        public final /* synthetic */ java.lang.String u;
        public final /* synthetic */ android.webkit.SslErrorHandler v;

        public a(com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback, android.content.Context context, java.lang.String str, android.webkit.SslErrorHandler sslErrorHandler) {
            this.n = callback;
            this.t = context;
            this.u = str;
            this.v = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
            com.huawei.secure.android.common.ssl.util.g.b(com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.A, "onFailure , IO Exception : " + iOException.getMessage());
            com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback = this.n;
            if (callback != null) {
                callback.onCancel(this.t, this.u);
            } else {
                this.v.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(okhttp3.Call call, okhttp3.Response response) throws java.io.IOException {
            com.huawei.secure.android.common.ssl.util.g.b(com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.A, "onResponse . proceed");
            com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback = this.n;
            if (callback != null) {
                callback.onProceed(this.t, this.u);
            } else {
                this.v.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    public WebViewSSLCheckThread(android.webkit.SslErrorHandler sslErrorHandler, java.lang.String str, android.content.Context context) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.io.IOException, java.security.KeyManagementException, java.security.KeyStoreException, java.lang.IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew(new com.huawei.secure.android.common.ssl.c(context)));
        setHostnameVerifier(new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory((java.security.KeyStore) null, new com.huawei.secure.android.common.ssl.c(context)));
        } catch (java.security.UnrecoverableKeyException e) {
            com.huawei.secure.android.common.ssl.util.g.b(A, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        }
        setApacheHostnameVerifier(com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    @java.lang.Deprecated
    public WebViewSSLCheckThread(android.webkit.SslErrorHandler sslErrorHandler, java.lang.String str, javax.net.ssl.SSLSocketFactory sSLSocketFactory, javax.net.ssl.HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @java.lang.Deprecated
    public WebViewSSLCheckThread(android.webkit.SslErrorHandler sslErrorHandler, java.lang.String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, org.apache.http.conn.ssl.X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @java.lang.Deprecated
    public WebViewSSLCheckThread(android.webkit.SslErrorHandler sslErrorHandler, java.lang.String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, org.apache.http.conn.ssl.X509HostnameVerifier x509HostnameVerifier, com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback, android.content.Context context) {
        this.w = sslErrorHandler;
        this.x = str;
        this.u = sSLSocketFactory;
        this.v = x509HostnameVerifier;
        this.y = callback;
        this.z = context;
    }

    public static void checkServerCertificateWithOK(android.webkit.SslErrorHandler sslErrorHandler, java.lang.String str, android.content.Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public static void checkServerCertificateWithOK(android.webkit.SslErrorHandler sslErrorHandler, java.lang.String str, android.content.Context context, com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback) {
        if (sslErrorHandler == null || android.text.TextUtils.isEmpty(str) || context == null) {
            com.huawei.secure.android.common.ssl.util.g.b(A, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        okhttp3.OkHttpClient.Builder builder = new okhttp3.OkHttpClient.Builder();
        try {
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new com.huawei.secure.android.common.ssl.SecureSSLSocketFactoryNew(new com.huawei.secure.android.common.ssl.c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new com.huawei.secure.android.common.ssl.c(context));
            builder.hostnameVerifier(new com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier());
            builder.build().newCall(new okhttp3.Request.Builder().url(str).build()).enqueue(new com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.a(callback, context, str, sslErrorHandler));
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.ssl.util.g.b(A, "checkServerCertificateWithOK: exception : " + e.getMessage());
            sslErrorHandler.cancel();
        }
    }

    public final void b() {
        java.lang.String str = A;
        com.huawei.secure.android.common.ssl.util.g.c(str, "callbackCancel: ");
        com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback = this.y;
        if (callback != null) {
            callback.onCancel(this.z, this.x);
        } else if (this.w != null) {
            com.huawei.secure.android.common.ssl.util.g.c(str, "callbackCancel 2: ");
            this.w.cancel();
        }
    }

    public final void c() {
        com.huawei.secure.android.common.ssl.util.g.c(A, "callbackProceed: ");
        com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback = this.y;
        if (callback != null) {
            callback.onProceed(this.z, this.x);
            return;
        }
        android.webkit.SslErrorHandler sslErrorHandler = this.w;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public org.apache.http.conn.ssl.X509HostnameVerifier getApacheHostnameVerifier() {
        return this.v;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.u;
    }

    public com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback getCallback() {
        return this.y;
    }

    public android.content.Context getContext() {
        return this.z;
    }

    public javax.net.ssl.HostnameVerifier getHostnameVerifier() {
        return this.t;
    }

    public android.webkit.SslErrorHandler getSslErrorHandler() {
        return this.w;
    }

    public javax.net.ssl.SSLSocketFactory getSslSocketFactory() {
        return this.n;
    }

    public java.lang.String getUrl() {
        return this.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        java.lang.Exception e;
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        super.run();
        javax.net.ssl.HttpsURLConnection httpsURLConnection2 = null;
        if (this.u != null && this.v != null) {
            if (this.w != null) {
                try {
                    if (!android.text.TextUtils.isEmpty(this.x)) {
                        try {
                            this.u.setHostnameVerifier(this.v);
                            org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.u;
                            if (sSLSocketFactory instanceof com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory) {
                                ((com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory) sSLSocketFactory).setContext(this.z);
                            }
                            org.apache.http.params.BasicHttpParams basicHttpParams = new org.apache.http.params.BasicHttpParams();
                            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                            org.apache.http.params.HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                            org.apache.http.conn.scheme.SchemeRegistry schemeRegistry = new org.apache.http.conn.scheme.SchemeRegistry();
                            schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", this.u, 443));
                            schemeRegistry.register(new org.apache.http.conn.scheme.Scheme(com.alipay.sdk.m.l.a.q, org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory(), 80));
                            org.apache.http.impl.client.DefaultHttpClient defaultHttpClient = new org.apache.http.impl.client.DefaultHttpClient(new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            org.apache.http.client.methods.HttpGet httpGet = new org.apache.http.client.methods.HttpGet();
                            httpGet.setURI(new java.net.URI(this.x));
                            org.apache.http.HttpResponse execute = defaultHttpClient.execute(httpGet);
                            com.huawei.secure.android.common.ssl.util.g.c(A, "status code is : " + execute.getStatusLine().getStatusCode());
                            com.huawei.secure.android.common.ssl.util.f.a((java.io.Reader) null);
                            c();
                            return;
                        } catch (java.lang.Exception e2) {
                            com.huawei.secure.android.common.ssl.util.g.b(A, "run: exception : " + e2.getMessage());
                            b();
                            com.huawei.secure.android.common.ssl.util.f.a((java.io.Reader) null);
                            return;
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.huawei.secure.android.common.ssl.util.f.a((java.io.Reader) null);
                    throw th;
                }
            }
            com.huawei.secure.android.common.ssl.util.g.b(A, "sslErrorHandler or url is null");
            b();
            return;
        }
        if (this.n != null) {
            ?? r0 = this.t;
            try {
                if (r0 != 0) {
                    try {
                        java.net.URLConnection openConnection = new java.net.URL(this.x).openConnection();
                        if (openConnection instanceof javax.net.ssl.HttpsURLConnection) {
                            httpsURLConnection = (javax.net.ssl.HttpsURLConnection) openConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.n);
                                httpsURLConnection.setHostnameVerifier(this.t);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(20000);
                                httpsURLConnection.connect();
                                httpsURLConnection2 = httpsURLConnection;
                            } catch (java.lang.Exception e3) {
                                e = e3;
                                com.huawei.secure.android.common.ssl.util.g.b(A, "exception : " + e.getMessage());
                                b();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        c();
                        return;
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        httpsURLConnection = null;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        r0 = 0;
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        }
        b();
    }

    public void setApacheHostnameVerifier(org.apache.http.conn.ssl.X509HostnameVerifier x509HostnameVerifier) {
        this.v = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.u = sSLSocketFactory;
    }

    public void setCallback(com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.Callback callback) {
        this.y = callback;
    }

    public void setContext(android.content.Context context) {
        this.z = context;
    }

    public void setHostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
        this.t = hostnameVerifier;
    }

    public void setSslErrorHandler(android.webkit.SslErrorHandler sslErrorHandler) {
        this.w = sslErrorHandler;
    }

    public void setSslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        this.n = sSLSocketFactory;
    }

    public void setUrl(java.lang.String str) {
        this.x = str;
    }
}
