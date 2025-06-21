package okhttp3.internal.huc;

/* loaded from: classes24.dex */
public final class OkHttpURLConnection extends java.net.HttpURLConnection implements okhttp3.Callback {
    public final java.lang.Object A;
    public okhttp3.Response B;
    public java.lang.Throwable C;
    public okhttp3.Response D;
    public boolean E;
    public java.net.Proxy F;
    public okhttp3.Handshake G;
    public okhttp3.OkHttpClient n;
    public final okhttp3.internal.huc.OkHttpURLConnection.NetworkInterceptor t;
    public okhttp3.Headers.Builder u;
    public boolean v;
    public okhttp3.Call w;
    public okhttp3.internal.URLFilter x;
    public okhttp3.Headers y;
    public long z;
    public static final java.lang.String SELECTED_PROTOCOL = okhttp3.internal.platform.Platform.get().getPrefix() + "-Selected-Protocol";
    public static final java.lang.String RESPONSE_SOURCE = okhttp3.internal.platform.Platform.get().getPrefix() + "-Response-Source";
    public static final java.util.Set<java.lang.String> H = new java.util.LinkedHashSet(java.util.Arrays.asList("OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"));

    public final class NetworkInterceptor implements okhttp3.Interceptor {
        public boolean a;

        public NetworkInterceptor() {
        }

        public void a() {
            synchronized (okhttp3.internal.huc.OkHttpURLConnection.this.A) {
                this.a = true;
                okhttp3.internal.huc.OkHttpURLConnection.this.A.notifyAll();
            }
        }

        @Override // okhttp3.Interceptor
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
            okhttp3.Request request = chain.request();
            okhttp3.internal.URLFilter uRLFilter = okhttp3.internal.huc.OkHttpURLConnection.this.x;
            if (uRLFilter != null) {
                uRLFilter.checkURLPermitted(request.url().url());
            }
            synchronized (okhttp3.internal.huc.OkHttpURLConnection.this.A) {
                okhttp3.internal.huc.OkHttpURLConnection okHttpURLConnection = okhttp3.internal.huc.OkHttpURLConnection.this;
                okHttpURLConnection.E = false;
                okHttpURLConnection.F = chain.connection().route().proxy();
                okhttp3.internal.huc.OkHttpURLConnection.this.G = chain.connection().handshake();
                okhttp3.internal.huc.OkHttpURLConnection.this.A.notifyAll();
                while (!this.a) {
                    try {
                        okhttp3.internal.huc.OkHttpURLConnection.this.A.wait();
                    } catch (java.lang.InterruptedException unused) {
                        java.lang.Thread.currentThread().interrupt();
                        throw new java.io.InterruptedIOException();
                    }
                }
            }
            if (request.body() instanceof okhttp3.internal.huc.OutputStreamRequestBody) {
                request = ((okhttp3.internal.huc.OutputStreamRequestBody) request.body()).d(request);
            }
            okhttp3.Response proceed = chain.proceed(request);
            synchronized (okhttp3.internal.huc.OkHttpURLConnection.this.A) {
                okhttp3.internal.huc.OkHttpURLConnection okHttpURLConnection2 = okhttp3.internal.huc.OkHttpURLConnection.this;
                okHttpURLConnection2.D = proceed;
                ((java.net.HttpURLConnection) okHttpURLConnection2).url = proceed.request().url().url();
            }
            return proceed;
        }
    }

    public static final class UnexpectedException extends java.io.IOException {
        static final okhttp3.Interceptor INTERCEPTOR = new okhttp3.internal.huc.OkHttpURLConnection.UnexpectedException.AnonymousClass1();

        /* renamed from: okhttp3.internal.huc.OkHttpURLConnection$UnexpectedException$1, reason: invalid class name */
        public class AnonymousClass1 implements okhttp3.Interceptor {
            @Override // okhttp3.Interceptor
            public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
                try {
                    return chain.proceed(chain.request());
                } catch (java.lang.Error | java.lang.RuntimeException e) {
                    throw new okhttp3.internal.huc.OkHttpURLConnection.UnexpectedException(e);
                }
            }
        }

        public UnexpectedException(java.lang.Throwable th) {
            super(th);
        }
    }

    public OkHttpURLConnection(java.net.URL url, okhttp3.OkHttpClient okHttpClient) {
        super(url);
        this.t = new okhttp3.internal.huc.OkHttpURLConnection.NetworkInterceptor();
        this.u = new okhttp3.Headers.Builder();
        this.z = -1L;
        this.A = new java.lang.Object();
        this.E = true;
        this.n = okHttpClient;
    }

    public OkHttpURLConnection(java.net.URL url, okhttp3.OkHttpClient okHttpClient, okhttp3.internal.URLFilter uRLFilter) {
        this(url, okHttpClient);
        this.x = uRLFilter;
    }

    public static java.io.IOException g(java.lang.Throwable th) throws java.io.IOException {
        if (th instanceof java.io.IOException) {
            throw ((java.io.IOException) th);
        }
        if (th instanceof java.lang.Error) {
            throw ((java.lang.Error) th);
        }
        if (th instanceof java.lang.RuntimeException) {
            throw ((java.lang.RuntimeException) th);
        }
        throw new java.lang.AssertionError();
    }

    public static java.lang.String h(okhttp3.Response response) {
        if (response.networkResponse() == null) {
            if (response.cacheResponse() == null) {
                return "NONE";
            }
            return "CACHE " + response.code();
        }
        if (response.cacheResponse() == null) {
            return "NETWORK " + response.code();
        }
        return "CONDITIONAL_CACHE " + response.networkResponse().code();
    }

    public static java.lang.String i(java.lang.String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt <= 31 || codePointAt >= 127) {
                okio.Buffer buffer = new okio.Buffer();
                buffer.writeUtf8(str, 0, i);
                buffer.writeUtf8CodePoint(63);
                while (true) {
                    i += java.lang.Character.charCount(codePointAt);
                    if (i >= length) {
                        return buffer.readUtf8();
                    }
                    codePointAt = str.codePointAt(i);
                    buffer.writeUtf8CodePoint((codePointAt <= 31 || codePointAt >= 127) ? 63 : codePointAt);
                }
            } else {
                i += java.lang.Character.charCount(codePointAt);
            }
        }
        return str;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(java.lang.String str, java.lang.String str2) {
        if (((java.net.HttpURLConnection) this).connected) {
            throw new java.lang.IllegalStateException("Cannot add request property after connection is made");
        }
        if (str == null) {
            throw new java.lang.NullPointerException("field == null");
        }
        if (str2 != null) {
            this.u.add(str, str2);
            return;
        }
        okhttp3.internal.platform.Platform.get().log(5, "Ignoring header " + str + " because its value was null.", null);
    }

    public final okhttp3.Call c() throws java.io.IOException {
        okhttp3.internal.huc.OutputStreamRequestBody outputStreamRequestBody;
        okhttp3.Call call = this.w;
        if (call != null) {
            return call;
        }
        boolean z = true;
        ((java.net.HttpURLConnection) this).connected = true;
        if (((java.net.HttpURLConnection) this).doOutput) {
            if (((java.net.HttpURLConnection) this).method.equals("GET")) {
                ((java.net.HttpURLConnection) this).method = "POST";
            } else if (!okhttp3.internal.http.HttpMethod.permitsRequestBody(((java.net.HttpURLConnection) this).method)) {
                throw new java.net.ProtocolException(((java.net.HttpURLConnection) this).method + " does not support writing");
            }
        }
        if (this.u.get("User-Agent") == null) {
            this.u.add("User-Agent", d());
        }
        if (okhttp3.internal.http.HttpMethod.permitsRequestBody(((java.net.HttpURLConnection) this).method)) {
            if (this.u.get("Content-Type") == null) {
                this.u.add("Content-Type", com.anythink.expressad.foundation.g.f.g.b.e);
            }
            long j = -1;
            if (this.z == -1 && ((java.net.HttpURLConnection) this).chunkLength <= 0) {
                z = false;
            }
            java.lang.String str = this.u.get("Content-Length");
            long j2 = this.z;
            if (j2 != -1) {
                j = j2;
            } else if (str != null) {
                j = java.lang.Long.parseLong(str);
            }
            outputStreamRequestBody = z ? new okhttp3.internal.huc.StreamedRequestBody(j) : new okhttp3.internal.huc.BufferedRequestBody(j);
            outputStreamRequestBody.e().timeout(this.n.writeTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
        } else {
            outputStreamRequestBody = null;
        }
        try {
            okhttp3.Request build = new okhttp3.Request.Builder().url(okhttp3.HttpUrl.get(getURL().toString())).headers(this.u.build()).method(((java.net.HttpURLConnection) this).method, outputStreamRequestBody).build();
            okhttp3.internal.URLFilter uRLFilter = this.x;
            if (uRLFilter != null) {
                uRLFilter.checkURLPermitted(build.url().url());
            }
            okhttp3.OkHttpClient.Builder newBuilder = this.n.newBuilder();
            newBuilder.interceptors().clear();
            newBuilder.interceptors().add(okhttp3.internal.huc.OkHttpURLConnection.UnexpectedException.INTERCEPTOR);
            newBuilder.networkInterceptors().clear();
            newBuilder.networkInterceptors().add(this.t);
            newBuilder.dispatcher(new okhttp3.Dispatcher(this.n.dispatcher().executorService()));
            if (!getUseCaches()) {
                newBuilder.cache(null);
            }
            okhttp3.Call newCall = newBuilder.build().newCall(build);
            this.w = newCall;
            return newCall;
        } catch (java.lang.IllegalArgumentException e) {
            if (okhttp3.internal.Internal.instance.isInvalidHttpUrlHost(e)) {
                java.net.UnknownHostException unknownHostException = new java.net.UnknownHostException();
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
            java.net.MalformedURLException malformedURLException = new java.net.MalformedURLException();
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    @Override // java.net.URLConnection
    public void connect() throws java.io.IOException {
        if (this.v) {
            return;
        }
        okhttp3.Call c = c();
        this.v = true;
        c.enqueue(this);
        synchronized (this.A) {
            while (this.E && this.B == null && this.C == null) {
                try {
                    this.A.wait();
                } catch (java.lang.InterruptedException unused) {
                    java.lang.Thread.currentThread().interrupt();
                    throw new java.io.InterruptedIOException();
                }
            }
            java.lang.Throwable th = this.C;
            if (th != null) {
                throw g(th);
            }
        }
    }

    public final java.lang.String d() {
        java.lang.String property = java.lang.System.getProperty("http.agent");
        return property != null ? i(property) : okhttp3.internal.Version.userAgent();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.w == null) {
            return;
        }
        this.t.a();
        this.w.cancel();
    }

    public final okhttp3.Headers e() throws java.io.IOException {
        if (this.y == null) {
            okhttp3.Response f = f(true);
            this.y = f.headers().newBuilder().add(SELECTED_PROTOCOL, f.protocol().toString()).add(RESPONSE_SOURCE, h(f)).build();
        }
        return this.y;
    }

    public final okhttp3.Response f(boolean z) throws java.io.IOException {
        okhttp3.Response response;
        synchronized (this.A) {
            okhttp3.Response response2 = this.B;
            if (response2 != null) {
                return response2;
            }
            java.lang.Throwable th = this.C;
            if (th != null) {
                if (!z || (response = this.D) == null) {
                    throw g(th);
                }
                return response;
            }
            okhttp3.Call c = c();
            this.t.a();
            okhttp3.internal.huc.OutputStreamRequestBody outputStreamRequestBody = (okhttp3.internal.huc.OutputStreamRequestBody) c.request().body();
            if (outputStreamRequestBody != null) {
                outputStreamRequestBody.c().close();
            }
            if (this.v) {
                synchronized (this.A) {
                    while (this.B == null && this.C == null) {
                        try {
                            try {
                                this.A.wait();
                            } catch (java.lang.InterruptedException unused) {
                                java.lang.Thread.currentThread().interrupt();
                                throw new java.io.InterruptedIOException();
                            }
                        } finally {
                        }
                    }
                }
            } else {
                this.v = true;
                try {
                    onResponse(c, c.execute());
                } catch (java.io.IOException e) {
                    onFailure(c, e);
                }
            }
            synchronized (this.A) {
                java.lang.Throwable th2 = this.C;
                if (th2 != null) {
                    throw g(th2);
                }
                okhttp3.Response response3 = this.B;
                if (response3 != null) {
                    return response3;
                }
                throw new java.lang.AssertionError();
            }
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.n.connectTimeoutMillis();
    }

    @Override // java.net.HttpURLConnection
    public java.io.InputStream getErrorStream() {
        try {
            okhttp3.Response f = f(true);
            if (okhttp3.internal.http.HttpHeaders.hasBody(f) && f.code() >= 400) {
                return f.body().byteStream();
            }
        } catch (java.io.IOException unused) {
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public java.lang.String getHeaderField(int i) {
        try {
            okhttp3.Headers e = e();
            if (i >= 0 && i < e.size()) {
                return e.value(i);
            }
        } catch (java.io.IOException unused) {
        }
        return null;
    }

    @Override // java.net.URLConnection
    public java.lang.String getHeaderField(java.lang.String str) {
        try {
            return str == null ? okhttp3.internal.http.StatusLine.get(f(true)).toString() : e().get(str);
        } catch (java.io.IOException unused) {
            return null;
        }
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public java.lang.String getHeaderFieldKey(int i) {
        try {
            okhttp3.Headers e = e();
            if (i >= 0 && i < e.size()) {
                return e.name(i);
            }
        } catch (java.io.IOException unused) {
        }
        return null;
    }

    @Override // java.net.URLConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getHeaderFields() {
        try {
            return okhttp3.internal.JavaNetHeaders.toMultimap(e(), okhttp3.internal.http.StatusLine.get(f(true)).toString());
        } catch (java.io.IOException unused) {
            return java.util.Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public java.io.InputStream getInputStream() throws java.io.IOException {
        if (!((java.net.HttpURLConnection) this).doInput) {
            throw new java.net.ProtocolException("This protocol does not support input");
        }
        okhttp3.Response f = f(false);
        if (f.code() < 400) {
            return f.body().byteStream();
        }
        throw new java.io.FileNotFoundException(((java.net.HttpURLConnection) this).url.toString());
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.n.followRedirects();
    }

    @Override // java.net.URLConnection
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        okhttp3.internal.huc.OutputStreamRequestBody outputStreamRequestBody = (okhttp3.internal.huc.OutputStreamRequestBody) c().request().body();
        if (outputStreamRequestBody == null) {
            throw new java.net.ProtocolException("method does not support a request body: " + ((java.net.HttpURLConnection) this).method);
        }
        if (outputStreamRequestBody instanceof okhttp3.internal.huc.StreamedRequestBody) {
            connect();
            this.t.a();
        }
        if (outputStreamRequestBody.b()) {
            throw new java.net.ProtocolException("cannot write request body after response has been read");
        }
        return outputStreamRequestBody.c();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public java.security.Permission getPermission() throws java.io.IOException {
        java.net.URL url = getURL();
        java.lang.String host = url.getHost();
        int port = url.getPort() != -1 ? url.getPort() : okhttp3.HttpUrl.defaultPort(url.getProtocol());
        if (usingProxy()) {
            java.net.InetSocketAddress inetSocketAddress = (java.net.InetSocketAddress) this.n.proxy().address();
            host = inetSocketAddress.getHostName();
            port = inetSocketAddress.getPort();
        }
        return new java.net.SocketPermission(host + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port, "connect, resolve");
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.n.readTimeoutMillis();
    }

    @Override // java.net.URLConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestProperties() {
        if (((java.net.HttpURLConnection) this).connected) {
            throw new java.lang.IllegalStateException("Cannot access request header fields after connection is set");
        }
        return okhttp3.internal.JavaNetHeaders.toMultimap(this.u.build(), null);
    }

    @Override // java.net.URLConnection
    public java.lang.String getRequestProperty(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return this.u.get(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws java.io.IOException {
        return f(true).code();
    }

    @Override // java.net.HttpURLConnection
    public java.lang.String getResponseMessage() throws java.io.IOException {
        return f(true).message();
    }

    @Override // okhttp3.Callback
    public void onFailure(okhttp3.Call call, java.io.IOException iOException) {
        synchronized (this.A) {
            boolean z = iOException instanceof okhttp3.internal.huc.OkHttpURLConnection.UnexpectedException;
            java.lang.Throwable th = iOException;
            if (z) {
                th = iOException.getCause();
            }
            this.C = th;
            this.A.notifyAll();
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
        synchronized (this.A) {
            this.B = response;
            this.G = response.handshake();
            ((java.net.HttpURLConnection) this).url = response.request().url().url();
            this.A.notifyAll();
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.n = this.n.newBuilder().connectTimeout(i, java.util.concurrent.TimeUnit.MILLISECONDS).build();
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        if (((java.net.HttpURLConnection) this).connected) {
            throw new java.lang.IllegalStateException("Already connected");
        }
        if (((java.net.HttpURLConnection) this).chunkLength > 0) {
            throw new java.lang.IllegalStateException("Already in chunked mode");
        }
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("contentLength < 0");
        }
        this.z = j;
        ((java.net.HttpURLConnection) this).fixedContentLength = (int) java.lang.Math.min(j, 2147483647L);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (((java.net.HttpURLConnection) this).ifModifiedSince != 0) {
            this.u.set("If-Modified-Since", okhttp3.internal.http.HttpDate.format(new java.util.Date(((java.net.HttpURLConnection) this).ifModifiedSince)));
        } else {
            this.u.removeAll("If-Modified-Since");
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.n = this.n.newBuilder().followRedirects(z).build();
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.n = this.n.newBuilder().readTimeout(i, java.util.concurrent.TimeUnit.MILLISECONDS).build();
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(java.lang.String str) throws java.net.ProtocolException {
        java.util.Set<java.lang.String> set = H;
        if (set.contains(str)) {
            ((java.net.HttpURLConnection) this).method = str;
            return;
        }
        throw new java.net.ProtocolException("Expected one of " + set + " but was " + str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(java.lang.String str, java.lang.String str2) {
        if (((java.net.HttpURLConnection) this).connected) {
            throw new java.lang.IllegalStateException("Cannot set request property after connection is made");
        }
        if (str == null) {
            throw new java.lang.NullPointerException("field == null");
        }
        if (str2 != null) {
            this.u.set(str, str2);
            return;
        }
        okhttp3.internal.platform.Platform.get().log(5, "Ignoring header " + str + " because its value was null.", null);
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (this.F != null) {
            return true;
        }
        java.net.Proxy proxy = this.n.proxy();
        return (proxy == null || proxy.type() == java.net.Proxy.Type.DIRECT) ? false : true;
    }
}
