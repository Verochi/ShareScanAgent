package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class b implements org.apache.http.client.HttpClient {
    public static long a = 160;
    public static java.lang.String[] b = {"text/", "application/xml", com.baidu.mobads.sdk.internal.am.d};
    public static final org.apache.http.HttpRequestInterceptor c = new com.alipay.android.phone.mrpc.core.c();
    public final org.apache.http.client.HttpClient d;
    public java.lang.RuntimeException e = new java.lang.IllegalStateException("AndroidHttpClient created and never closed");
    public volatile com.alipay.android.phone.mrpc.core.b.C0027b f;

    public class a implements org.apache.http.HttpRequestInterceptor {
        public a() {
        }

        public /* synthetic */ a(com.alipay.android.phone.mrpc.core.b bVar, byte b) {
            this();
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public final void process(org.apache.http.HttpRequest httpRequest, org.apache.http.protocol.HttpContext httpContext) {
            com.alipay.android.phone.mrpc.core.b.C0027b c0027b = com.alipay.android.phone.mrpc.core.b.this.f;
            if (c0027b != null && com.alipay.android.phone.mrpc.core.b.C0027b.a(c0027b) && (httpRequest instanceof org.apache.http.client.methods.HttpUriRequest)) {
                com.alipay.android.phone.mrpc.core.b.C0027b.a(c0027b, com.alipay.android.phone.mrpc.core.b.a((org.apache.http.client.methods.HttpUriRequest) httpRequest));
            }
        }
    }

    /* renamed from: com.alipay.android.phone.mrpc.core.b$b, reason: collision with other inner class name */
    public static class C0027b {
        public final java.lang.String a;
        public final int b;

        public static /* synthetic */ void a(com.alipay.android.phone.mrpc.core.b.C0027b c0027b, java.lang.String str) {
            android.util.Log.println(c0027b.b, c0027b.a, str);
        }

        public static /* synthetic */ boolean a(com.alipay.android.phone.mrpc.core.b.C0027b c0027b) {
            return android.util.Log.isLoggable(c0027b.a, c0027b.b);
        }
    }

    public b(org.apache.http.conn.ClientConnectionManager clientConnectionManager, org.apache.http.params.HttpParams httpParams) {
        this.d = new com.alipay.android.phone.mrpc.core.d(this, clientConnectionManager, httpParams);
    }

    public static com.alipay.android.phone.mrpc.core.b a(java.lang.String str) {
        org.apache.http.params.BasicHttpParams basicHttpParams = new org.apache.http.params.BasicHttpParams();
        org.apache.http.params.HttpProtocolParams.setVersion(basicHttpParams, org.apache.http.HttpVersion.HTTP_1_1);
        org.apache.http.params.HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        org.apache.http.params.HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        org.apache.http.params.HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        org.apache.http.params.HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        org.apache.http.client.params.HttpClientParams.setRedirecting(basicHttpParams, true);
        org.apache.http.client.params.HttpClientParams.setAuthenticating(basicHttpParams, false);
        org.apache.http.params.HttpProtocolParams.setUserAgent(basicHttpParams, str);
        org.apache.http.conn.scheme.SchemeRegistry schemeRegistry = new org.apache.http.conn.scheme.SchemeRegistry();
        schemeRegistry.register(new org.apache.http.conn.scheme.Scheme(com.alipay.sdk.m.l.a.q, org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new org.apache.http.conn.scheme.Scheme("https", android.net.SSLCertificateSocketFactory.getHttpSocketFactory(30000, null), 443));
        org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager threadSafeClientConnManager = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        org.apache.http.conn.params.ConnManagerParams.setTimeout(basicHttpParams, 60000L);
        org.apache.http.conn.params.ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new org.apache.http.conn.params.ConnPerRouteBean(10));
        org.apache.http.conn.params.ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
        java.security.Security.setProperty("networkaddress.cache.ttl", "-1");
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return new com.alipay.android.phone.mrpc.core.b(threadSafeClientConnManager, basicHttpParams);
    }

    public static java.io.InputStream a(org.apache.http.HttpEntity httpEntity) {
        org.apache.http.Header contentEncoding;
        java.lang.String value;
        java.io.InputStream content = httpEntity.getContent();
        return (content == null || (contentEncoding = httpEntity.getContentEncoding()) == null || (value = contentEncoding.getValue()) == null || !value.contains("gzip")) ? content : new java.util.zip.GZIPInputStream(content);
    }

    public static /* synthetic */ java.lang.String a(org.apache.http.client.methods.HttpUriRequest httpUriRequest) {
        org.apache.http.HttpEntity entity;
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("curl ");
        for (org.apache.http.Header header : httpUriRequest.getAllHeaders()) {
            if (!header.getName().equals("Authorization") && !header.getName().equals(com.google.common.net.HttpHeaders.COOKIE)) {
                sb.append("--header \"");
                sb.append(header.toString().trim());
                sb.append("\" ");
            }
        }
        java.net.URI uri = httpUriRequest.getURI();
        if (httpUriRequest instanceof org.apache.http.impl.client.RequestWrapper) {
            org.apache.http.HttpRequest original = ((org.apache.http.impl.client.RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof org.apache.http.client.methods.HttpUriRequest) {
                uri = ((org.apache.http.client.methods.HttpUriRequest) original).getURI();
            }
        }
        sb.append("\"");
        sb.append(uri);
        sb.append("\"");
        if ((httpUriRequest instanceof org.apache.http.HttpEntityEnclosingRequest) && (entity = ((org.apache.http.HttpEntityEnclosingRequest) httpUriRequest).getEntity()) != null && entity.isRepeatable()) {
            if (entity.getContentLength() < 1024) {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                entity.writeTo(byteArrayOutputStream);
                if (b(httpUriRequest)) {
                    sb.insert(0, "echo '" + android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2) + "' | base64 -d > /tmp/$$.bin; ");
                    str = " --data-binary @/tmp/$$.bin";
                } else {
                    java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    sb.append(" --data-ascii \"");
                    sb.append(byteArrayOutputStream2);
                    sb.append("\"");
                }
            } else {
                str = " [TOO MUCH DATA TO INCLUDE]";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static org.apache.http.entity.AbstractHttpEntity a(byte[] bArr) {
        if (bArr.length < a) {
            return new org.apache.http.entity.ByteArrayEntity(bArr);
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        org.apache.http.entity.ByteArrayEntity byteArrayEntity = new org.apache.http.entity.ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        byteArrayEntity.getContentLength();
        return byteArrayEntity;
    }

    public static void a(org.apache.http.HttpRequest httpRequest) {
        httpRequest.addHeader(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
    }

    public static long b(java.lang.String str) {
        return com.alipay.android.phone.mrpc.core.k.a(str);
    }

    public static void b(org.apache.http.HttpRequest httpRequest) {
        httpRequest.addHeader(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
    }

    public static boolean b(org.apache.http.client.methods.HttpUriRequest httpUriRequest) {
        org.apache.http.Header[] headers = httpUriRequest.getHeaders("content-encoding");
        if (headers != null) {
            for (org.apache.http.Header header : headers) {
                if ("gzip".equalsIgnoreCase(header.getValue())) {
                    return true;
                }
            }
        }
        org.apache.http.Header[] headers2 = httpUriRequest.getHeaders(com.alipay.sdk.m.p.e.f);
        if (headers2 != null) {
            for (org.apache.http.Header header2 : headers2) {
                for (java.lang.String str : b) {
                    if (header2.getValue().startsWith(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final void a(org.apache.http.client.HttpRequestRetryHandler httpRequestRetryHandler) {
        ((org.apache.http.impl.client.DefaultHttpClient) this.d).setHttpRequestRetryHandler(httpRequestRetryHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(org.apache.http.HttpHost httpHost, org.apache.http.HttpRequest httpRequest, org.apache.http.client.ResponseHandler<? extends T> responseHandler) {
        return (T) this.d.execute(httpHost, httpRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(org.apache.http.HttpHost httpHost, org.apache.http.HttpRequest httpRequest, org.apache.http.client.ResponseHandler<? extends T> responseHandler, org.apache.http.protocol.HttpContext httpContext) {
        return (T) this.d.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(org.apache.http.client.methods.HttpUriRequest httpUriRequest, org.apache.http.client.ResponseHandler<? extends T> responseHandler) {
        return (T) this.d.execute(httpUriRequest, responseHandler);
    }

    @Override // org.apache.http.client.HttpClient
    public final <T> T execute(org.apache.http.client.methods.HttpUriRequest httpUriRequest, org.apache.http.client.ResponseHandler<? extends T> responseHandler, org.apache.http.protocol.HttpContext httpContext) {
        return (T) this.d.execute(httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final org.apache.http.HttpResponse execute(org.apache.http.HttpHost httpHost, org.apache.http.HttpRequest httpRequest) {
        return this.d.execute(httpHost, httpRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final org.apache.http.HttpResponse execute(org.apache.http.HttpHost httpHost, org.apache.http.HttpRequest httpRequest, org.apache.http.protocol.HttpContext httpContext) {
        return this.d.execute(httpHost, httpRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final org.apache.http.HttpResponse execute(org.apache.http.client.methods.HttpUriRequest httpUriRequest) {
        return this.d.execute(httpUriRequest);
    }

    @Override // org.apache.http.client.HttpClient
    public final org.apache.http.HttpResponse execute(org.apache.http.client.methods.HttpUriRequest httpUriRequest, org.apache.http.protocol.HttpContext httpContext) {
        return this.d.execute(httpUriRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public final org.apache.http.conn.ClientConnectionManager getConnectionManager() {
        return this.d.getConnectionManager();
    }

    @Override // org.apache.http.client.HttpClient
    public final org.apache.http.params.HttpParams getParams() {
        return this.d.getParams();
    }
}
