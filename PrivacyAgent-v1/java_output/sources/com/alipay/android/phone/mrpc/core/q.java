package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class q implements java.util.concurrent.Callable<com.alipay.android.phone.mrpc.core.u> {
    public static final org.apache.http.client.HttpRequestRetryHandler e = new com.alipay.android.phone.mrpc.core.ad();
    public com.alipay.android.phone.mrpc.core.l a;
    public android.content.Context b;
    public com.alipay.android.phone.mrpc.core.o c;
    public java.lang.String d;
    public org.apache.http.client.methods.HttpUriRequest f;
    public android.webkit.CookieManager i;
    public org.apache.http.entity.AbstractHttpEntity j;
    public org.apache.http.HttpHost k;
    public java.net.URL l;
    public java.lang.String q;
    public org.apache.http.protocol.HttpContext g = new org.apache.http.protocol.BasicHttpContext();
    public org.apache.http.client.CookieStore h = new org.apache.http.impl.client.BasicCookieStore();
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public java.lang.String p = null;

    public q(com.alipay.android.phone.mrpc.core.l lVar, com.alipay.android.phone.mrpc.core.o oVar) {
        this.a = lVar;
        this.b = lVar.a;
        this.c = oVar;
    }

    public static long a(java.lang.String[] strArr) {
        java.lang.String str;
        for (int i = 0; i < strArr.length; i++) {
            if ("max-age".equalsIgnoreCase(strArr[i]) && (str = strArr[i + 1]) != null) {
                try {
                    return java.lang.Long.parseLong(str);
                } catch (java.lang.Exception unused) {
                    continue;
                }
            }
        }
        return 0L;
    }

    public static com.alipay.android.phone.mrpc.core.HttpUrlHeader a(org.apache.http.HttpResponse httpResponse) {
        com.alipay.android.phone.mrpc.core.HttpUrlHeader httpUrlHeader = new com.alipay.android.phone.mrpc.core.HttpUrlHeader();
        for (org.apache.http.Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private com.alipay.android.phone.mrpc.core.u a(org.apache.http.HttpResponse httpResponse, int i, java.lang.String str) {
        java.lang.String str2;
        java.lang.Thread.currentThread().getId();
        org.apache.http.HttpEntity entity = httpResponse.getEntity();
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        java.lang.String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity != null) {
                return null;
            }
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
        java.lang.Thread.currentThread().getId();
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                a(entity, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                this.o = false;
                this.a.c(java.lang.System.currentTimeMillis() - currentTimeMillis);
                this.a.a(byteArray.length);
                com.alipay.android.phone.mrpc.core.p pVar = new com.alipay.android.phone.mrpc.core.p(a(httpResponse), i, str, byteArray);
                long b = b(httpResponse);
                org.apache.http.Header contentType = httpResponse.getEntity().getContentType();
                if (contentType != null) {
                    java.util.HashMap<java.lang.String, java.lang.String> a = a(contentType.getValue());
                    str3 = a.get("charset");
                    str2 = a.get("Content-Type");
                } else {
                    str2 = null;
                }
                pVar.b(str2);
                pVar.a(str3);
                pVar.a(java.lang.System.currentTimeMillis());
                pVar.b(b);
                try {
                    byteArrayOutputStream2.close();
                    return pVar;
                } catch (java.io.IOException e2) {
                    throw new java.lang.RuntimeException("ArrayOutputStream close error!", e2.getCause());
                }
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException e3) {
                        throw new java.lang.RuntimeException("ArrayOutputStream close error!", e3.getCause());
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.String> a(java.lang.String str) {
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        for (java.lang.String str2 : str.split(com.alipay.sdk.m.u.i.b)) {
            java.lang.String[] split = str2.indexOf(61) == -1 ? new java.lang.String[]{"Content-Type", str2} : str2.split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private void a(org.apache.http.HttpEntity httpEntity, java.io.OutputStream outputStream) {
        java.io.InputStream a = com.alipay.android.phone.mrpc.core.b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a.read(bArr);
                    if (read == -1 || this.c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    this.c.f();
                }
                outputStream.flush();
            } catch (java.lang.Exception e2) {
                e2.getCause();
                throw new java.io.IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
            }
        } finally {
            com.alipay.android.phone.mrpc.core.r.a(a);
        }
    }

    public static long b(org.apache.http.HttpResponse httpResponse) {
        org.apache.http.Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            java.lang.String[] split = firstHeader.getValue().split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (java.lang.NumberFormatException unused) {
                }
            }
        }
        org.apache.http.Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return com.alipay.android.phone.mrpc.core.b.b(firstHeader2.getValue()) - java.lang.System.currentTimeMillis();
        }
        return 0L;
    }

    private java.net.URI b() {
        java.lang.String a = this.c.a();
        java.lang.String str = this.d;
        if (str != null) {
            a = str;
        }
        if (a != null) {
            return new java.net.URI(a);
        }
        throw new java.lang.RuntimeException("url should not be null");
    }

    private org.apache.http.client.methods.HttpUriRequest c() {
        org.apache.http.client.methods.HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b = this.c.b();
            java.lang.String b2 = this.c.b("gzip");
            if (b != null) {
                if (android.text.TextUtils.equals(b2, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE)) {
                    this.j = com.alipay.android.phone.mrpc.core.b.a(b);
                } else {
                    this.j = new org.apache.http.entity.ByteArrayEntity(b);
                }
                this.j.setContentType(this.c.c());
            }
        }
        org.apache.http.entity.AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            org.apache.http.client.methods.HttpPost httpPost = new org.apache.http.client.methods.HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f = httpPost;
        } else {
            this.f = new org.apache.http.client.methods.HttpGet(b());
        }
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0113 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, URISyntaxException -> 0x03ba, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, ConnectionPoolTimeoutException -> 0x033a, ConnectTimeoutException -> 0x031a, HttpHostConnectException -> 0x02b9, IOException -> 0x0277, Exception -> 0x023b, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:12:0x0040, B:13:0x0044, B:15:0x004a, B:17:0x0058, B:19:0x006c, B:21:0x0081, B:23:0x00ad, B:25:0x00bc, B:27:0x00c2, B:29:0x00cc, B:31:0x00d5, B:33:0x00e1, B:36:0x00eb, B:39:0x010b, B:41:0x0113, B:42:0x0120, B:44:0x0146, B:45:0x014d, B:47:0x0153, B:48:0x0157, B:50:0x015d, B:53:0x0169, B:56:0x0198, B:62:0x01b4, B:69:0x01d1, B:70:0x01ea, B:73:0x01eb, B:75:0x01f3, B:77:0x01f9, B:80:0x0205, B:82:0x0209, B:87:0x0219, B:89:0x0221, B:91:0x022b, B:94:0x00f3, B:97:0x022f, B:98:0x023a, B:99:0x0017, B:101:0x001b, B:103:0x001f, B:105:0x0025, B:110:0x002d), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0146 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, URISyntaxException -> 0x03ba, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, ConnectionPoolTimeoutException -> 0x033a, ConnectTimeoutException -> 0x031a, HttpHostConnectException -> 0x02b9, IOException -> 0x0277, Exception -> 0x023b, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:12:0x0040, B:13:0x0044, B:15:0x004a, B:17:0x0058, B:19:0x006c, B:21:0x0081, B:23:0x00ad, B:25:0x00bc, B:27:0x00c2, B:29:0x00cc, B:31:0x00d5, B:33:0x00e1, B:36:0x00eb, B:39:0x010b, B:41:0x0113, B:42:0x0120, B:44:0x0146, B:45:0x014d, B:47:0x0153, B:48:0x0157, B:50:0x015d, B:53:0x0169, B:56:0x0198, B:62:0x01b4, B:69:0x01d1, B:70:0x01ea, B:73:0x01eb, B:75:0x01f3, B:77:0x01f9, B:80:0x0205, B:82:0x0209, B:87:0x0219, B:89:0x0221, B:91:0x022b, B:94:0x00f3, B:97:0x022f, B:98:0x023a, B:99:0x0017, B:101:0x001b, B:103:0x001f, B:105:0x0025, B:110:0x002d), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0153 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, URISyntaxException -> 0x03ba, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, ConnectionPoolTimeoutException -> 0x033a, ConnectTimeoutException -> 0x031a, HttpHostConnectException -> 0x02b9, IOException -> 0x0277, Exception -> 0x023b, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:12:0x0040, B:13:0x0044, B:15:0x004a, B:17:0x0058, B:19:0x006c, B:21:0x0081, B:23:0x00ad, B:25:0x00bc, B:27:0x00c2, B:29:0x00cc, B:31:0x00d5, B:33:0x00e1, B:36:0x00eb, B:39:0x010b, B:41:0x0113, B:42:0x0120, B:44:0x0146, B:45:0x014d, B:47:0x0153, B:48:0x0157, B:50:0x015d, B:53:0x0169, B:56:0x0198, B:62:0x01b4, B:69:0x01d1, B:70:0x01ea, B:73:0x01eb, B:75:0x01f3, B:77:0x01f9, B:80:0x0205, B:82:0x0209, B:87:0x0219, B:89:0x0221, B:91:0x022b, B:94:0x00f3, B:97:0x022f, B:98:0x023a, B:99:0x0017, B:101:0x001b, B:103:0x001f, B:105:0x0025, B:110:0x002d), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f3 A[Catch: Exception -> 0x023b, NullPointerException -> 0x0258, IOException -> 0x0277, UnknownHostException -> 0x0297, HttpHostConnectException -> 0x02b9, NoHttpResponseException -> 0x02d8, SocketTimeoutException -> 0x02f9, ConnectTimeoutException -> 0x031a, ConnectionPoolTimeoutException -> 0x033a, SSLException -> 0x035a, SSLPeerUnverifiedException -> 0x037a, SSLHandshakeException -> 0x039a, URISyntaxException -> 0x03ba, HttpException -> 0x03c7, TryCatch #3 {HttpException -> 0x03c7, NullPointerException -> 0x0258, SocketTimeoutException -> 0x02f9, URISyntaxException -> 0x03ba, UnknownHostException -> 0x0297, SSLHandshakeException -> 0x039a, SSLPeerUnverifiedException -> 0x037a, SSLException -> 0x035a, NoHttpResponseException -> 0x02d8, ConnectionPoolTimeoutException -> 0x033a, ConnectTimeoutException -> 0x031a, HttpHostConnectException -> 0x02b9, IOException -> 0x0277, Exception -> 0x023b, blocks: (B:4:0x0006, B:8:0x0032, B:10:0x003a, B:12:0x0040, B:13:0x0044, B:15:0x004a, B:17:0x0058, B:19:0x006c, B:21:0x0081, B:23:0x00ad, B:25:0x00bc, B:27:0x00c2, B:29:0x00cc, B:31:0x00d5, B:33:0x00e1, B:36:0x00eb, B:39:0x010b, B:41:0x0113, B:42:0x0120, B:44:0x0146, B:45:0x014d, B:47:0x0153, B:48:0x0157, B:50:0x015d, B:53:0x0169, B:56:0x0198, B:62:0x01b4, B:69:0x01d1, B:70:0x01ea, B:73:0x01eb, B:75:0x01f3, B:77:0x01f9, B:80:0x0205, B:82:0x0209, B:87:0x0219, B:89:0x0221, B:91:0x022b, B:94:0x00f3, B:97:0x022f, B:98:0x023a, B:99:0x0017, B:101:0x001b, B:103:0x001f, B:105:0x0025, B:110:0x002d), top: B:3:0x0006 }] */
    @Override // java.util.concurrent.Callable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.alipay.android.phone.mrpc.core.u call() {
        boolean z;
        org.apache.http.HttpHost httpHost;
        org.apache.http.HttpHost httpHost2;
        java.util.List<org.apache.http.cookie.Cookie> cookies;
        int statusCode;
        com.alipay.android.phone.mrpc.core.u a;
        while (true) {
            try {
                android.net.NetworkInfo[] allNetworkInfo = ((android.net.ConnectivityManager) this.b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z2 = true;
                if (allNetworkInfo != null) {
                    for (android.net.NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    throw new com.alipay.android.phone.mrpc.core.HttpException(1, "The network is not available");
                }
                java.util.ArrayList<org.apache.http.Header> d = this.c.d();
                if (d != null && !d.isEmpty()) {
                    java.util.Iterator<org.apache.http.Header> it = d.iterator();
                    while (it.hasNext()) {
                        c().addHeader(it.next());
                    }
                }
                com.alipay.android.phone.mrpc.core.b.a((org.apache.http.HttpRequest) c());
                com.alipay.android.phone.mrpc.core.b.b((org.apache.http.HttpRequest) c());
                c().addHeader("cookie", i().getCookie(this.c.a()));
                this.g.setAttribute("http.cookie-store", this.h);
                this.a.a().a(e);
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                f();
                this.f.getURI().toString();
                org.apache.http.params.HttpParams params = this.a.a().getParams();
                android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
                org.apache.http.HttpHost httpHost3 = null;
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    java.lang.String defaultHost = android.net.Proxy.getDefaultHost();
                    int defaultPort = android.net.Proxy.getDefaultPort();
                    if (defaultHost != null) {
                        httpHost = new org.apache.http.HttpHost(defaultHost, defaultPort);
                        if (httpHost != null || !android.text.TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                            httpHost3 = httpHost;
                        }
                        params.setParameter("http.route.default-proxy", httpHost3);
                        httpHost2 = this.k;
                        if (httpHost2 != null) {
                            java.net.URL h = h();
                            org.apache.http.HttpHost httpHost4 = new org.apache.http.HttpHost(h.getHost(), g(), h.getProtocol());
                            this.k = httpHost4;
                            httpHost2 = httpHost4;
                        }
                        if (g() == 80) {
                            httpHost2 = new org.apache.http.HttpHost(h().getHost());
                        }
                        org.apache.http.HttpResponse execute = this.a.a().execute(httpHost2, this.f, this.g);
                        this.a.b(java.lang.System.currentTimeMillis() - currentTimeMillis);
                        cookies = this.h.getCookies();
                        if (this.c.e()) {
                            i().removeAllCookie();
                        }
                        if (!cookies.isEmpty()) {
                            for (org.apache.http.cookie.Cookie cookie : cookies) {
                                if (cookie.getDomain() != null) {
                                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                    sb.append(cookie.getName());
                                    sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                                    sb.append(cookie.getValue());
                                    sb.append("; domain=");
                                    sb.append(cookie.getDomain());
                                    sb.append(cookie.isSecure() ? "; Secure" : "");
                                    i().setCookie(this.c.a(), sb.toString());
                                    android.webkit.CookieSyncManager.getInstance().sync();
                                }
                            }
                        }
                        statusCode = execute.getStatusLine().getStatusCode();
                        java.lang.String reasonPhrase = execute.getStatusLine().getReasonPhrase();
                        if (statusCode != 200) {
                            if (statusCode != 304) {
                                z2 = false;
                            }
                            if (!z2) {
                                throw new com.alipay.android.phone.mrpc.core.HttpException(java.lang.Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                            }
                        }
                        a = a(execute, statusCode, reasonPhrase);
                        if (((a != null || a.b() == null) ? -1L : a.b().length) == -1 && (a instanceof com.alipay.android.phone.mrpc.core.p)) {
                            try {
                                java.lang.Long.parseLong(((com.alipay.android.phone.mrpc.core.p) a).a().getHead("Content-Length"));
                            } catch (java.lang.Exception unused) {
                            }
                        }
                        if (this.c.a() != null && !android.text.TextUtils.isEmpty(f())) {
                            f();
                        }
                        return a;
                    }
                }
                httpHost = null;
                if (httpHost != null) {
                }
                httpHost3 = httpHost;
                params.setParameter("http.route.default-proxy", httpHost3);
                httpHost2 = this.k;
                if (httpHost2 != null) {
                }
                if (g() == 80) {
                }
                org.apache.http.HttpResponse execute2 = this.a.a().execute(httpHost2, this.f, this.g);
                this.a.b(java.lang.System.currentTimeMillis() - currentTimeMillis);
                cookies = this.h.getCookies();
                if (this.c.e()) {
                }
                if (!cookies.isEmpty()) {
                }
                statusCode = execute2.getStatusLine().getStatusCode();
                java.lang.String reasonPhrase2 = execute2.getStatusLine().getReasonPhrase();
                if (statusCode != 200) {
                }
                a = a(execute2, statusCode, reasonPhrase2);
                if (((a != null || a.b() == null) ? -1L : a.b().length) == -1) {
                    java.lang.Long.parseLong(((com.alipay.android.phone.mrpc.core.p) a).a().getHead("Content-Length"));
                }
                if (this.c.a() != null) {
                    f();
                }
                return a;
            } catch (com.alipay.android.phone.mrpc.core.HttpException e2) {
                e();
                if (this.c.f() != null) {
                    e2.getCode();
                    e2.getMsg();
                }
                e2.toString();
                throw e2;
            } catch (java.lang.NullPointerException e3) {
                e();
                int i = this.m;
                if (i > 0) {
                    e3.toString();
                    throw new com.alipay.android.phone.mrpc.core.HttpException(0, java.lang.String.valueOf(e3));
                }
                this.m = i + 1;
            } catch (java.net.SocketTimeoutException e4) {
                e();
                if (this.c.f() != null) {
                    e4.toString();
                }
                e4.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(4, java.lang.String.valueOf(e4));
            } catch (java.net.URISyntaxException e5) {
                throw new java.lang.RuntimeException("Url parser error!", e5.getCause());
            } catch (java.net.UnknownHostException e6) {
                e();
                if (this.c.f() != null) {
                    e6.toString();
                }
                e6.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(9, java.lang.String.valueOf(e6));
            } catch (javax.net.ssl.SSLHandshakeException e7) {
                e();
                if (this.c.f() != null) {
                    e7.toString();
                }
                e7.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(2, java.lang.String.valueOf(e7));
            } catch (javax.net.ssl.SSLPeerUnverifiedException e8) {
                e();
                if (this.c.f() != null) {
                    e8.toString();
                }
                e8.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(2, java.lang.String.valueOf(e8));
            } catch (javax.net.ssl.SSLException e9) {
                e();
                if (this.c.f() != null) {
                    e9.toString();
                }
                e9.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(6, java.lang.String.valueOf(e9));
            } catch (org.apache.http.NoHttpResponseException e10) {
                e();
                if (this.c.f() != null) {
                    e10.toString();
                }
                e10.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(5, java.lang.String.valueOf(e10));
            } catch (org.apache.http.conn.ConnectionPoolTimeoutException e11) {
                e();
                if (this.c.f() != null) {
                    e11.toString();
                }
                e11.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(3, java.lang.String.valueOf(e11));
            } catch (org.apache.http.conn.ConnectTimeoutException e12) {
                e();
                if (this.c.f() != null) {
                    e12.toString();
                }
                e12.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(3, java.lang.String.valueOf(e12));
            } catch (org.apache.http.conn.HttpHostConnectException e13) {
                e();
                if (this.c.f() != null) {
                    e13.toString();
                }
                throw new com.alipay.android.phone.mrpc.core.HttpException(8, java.lang.String.valueOf(e13));
            } catch (java.io.IOException e14) {
                e();
                if (this.c.f() != null) {
                    e14.toString();
                }
                e14.toString();
                throw new com.alipay.android.phone.mrpc.core.HttpException(6, java.lang.String.valueOf(e14));
            } catch (java.lang.Exception e15) {
                e();
                if (this.c.f() != null) {
                    e15.toString();
                }
                throw new com.alipay.android.phone.mrpc.core.HttpException(0, java.lang.String.valueOf(e15));
            }
        }
    }

    private void e() {
        org.apache.http.client.methods.HttpUriRequest httpUriRequest = this.f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private java.lang.String f() {
        if (!android.text.TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        java.lang.String b = this.c.b("operationType");
        this.q = b;
        return b;
    }

    private int g() {
        java.net.URL h = h();
        return h.getPort() == -1 ? h.getDefaultPort() : h.getPort();
    }

    private java.net.URL h() {
        java.net.URL url = this.l;
        if (url != null) {
            return url;
        }
        java.net.URL url2 = new java.net.URL(this.c.a());
        this.l = url2;
        return url2;
    }

    private android.webkit.CookieManager i() {
        android.webkit.CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        android.webkit.CookieManager cookieManager2 = android.webkit.CookieManager.getInstance();
        this.i = cookieManager2;
        return cookieManager2;
    }

    public final com.alipay.android.phone.mrpc.core.o a() {
        return this.c;
    }
}
