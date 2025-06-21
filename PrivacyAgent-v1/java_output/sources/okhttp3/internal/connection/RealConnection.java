package okhttp3.internal.connection;

/* loaded from: classes23.dex */
public final class RealConnection extends okhttp3.internal.http2.Http2Connection.Listener implements okhttp3.Connection {
    public final okhttp3.Route a;
    public java.net.Socket b;
    public java.net.Socket c;
    public final okhttp3.internal.connection.RealConnectionPool connectionPool;
    public okhttp3.Handshake d;
    public okhttp3.Protocol e;
    public okhttp3.internal.http2.Http2Connection f;
    public okio.BufferedSource g;
    public okio.BufferedSink h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public int m = 1;
    public final java.util.List<java.lang.ref.Reference<okhttp3.internal.connection.Transmitter>> n = new java.util.ArrayList();
    public long o = Long.MAX_VALUE;

    /* renamed from: okhttp3.internal.connection.RealConnection$1, reason: invalid class name */
    public class AnonymousClass1 extends okhttp3.internal.ws.RealWebSocket.Streams {
        public final /* synthetic */ okhttp3.internal.connection.Exchange n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink, okhttp3.internal.connection.Exchange exchange) {
            super(z, bufferedSource, bufferedSink);
            this.n = exchange;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.n.a(-1L, true, true, null);
        }
    }

    public RealConnection(okhttp3.internal.connection.RealConnectionPool realConnectionPool, okhttp3.Route route) {
        this.connectionPool = realConnectionPool;
        this.a = route;
    }

    public final void a(int i, int i2, okhttp3.Call call, okhttp3.EventListener eventListener) throws java.io.IOException {
        java.net.Proxy proxy = this.a.proxy();
        this.b = (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.HTTP) ? this.a.address().socketFactory().createSocket() : new java.net.Socket(proxy);
        eventListener.connectStart(call, this.a.socketAddress(), proxy);
        this.b.setSoTimeout(i2);
        try {
            okhttp3.internal.platform.Platform.get().connectSocket(this.b, this.a.socketAddress(), i);
            try {
                this.g = okio.Okio.buffer(okio.Okio.source(this.b));
                this.h = okio.Okio.buffer(okio.Okio.sink(this.b));
            } catch (java.lang.NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new java.io.IOException(e);
                }
            }
        } catch (java.net.ConnectException e2) {
            java.net.ConnectException connectException = new java.net.ConnectException("Failed to connect to " + this.a.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void b(okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector) throws java.io.IOException {
        javax.net.ssl.SSLSocket sSLSocket;
        okhttp3.Address address = this.a.address();
        javax.net.ssl.SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (javax.net.ssl.SSLSocket) address.sslSocketFactory().createSocket(this.b, address.url().host(), address.url().port(), true);
            } catch (java.lang.AssertionError e) {
                e = e;
            }
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            okhttp3.ConnectionSpec a = connectionSpecSelector.a(sSLSocket);
            if (a.supportsTlsExtensions()) {
                okhttp3.internal.platform.Platform.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            javax.net.ssl.SSLSession session = sSLSocket.getSession();
            okhttp3.Handshake handshake = okhttp3.Handshake.get(session);
            if (address.hostnameVerifier().verify(address.url().host(), session)) {
                address.certificatePinner().check(address.url().host(), handshake.peerCertificates());
                java.lang.String selectedProtocol = a.supportsTlsExtensions() ? okhttp3.internal.platform.Platform.get().getSelectedProtocol(sSLSocket) : null;
                this.c = sSLSocket;
                this.g = okio.Okio.buffer(okio.Okio.source(sSLSocket));
                this.h = okio.Okio.buffer(okio.Okio.sink(this.c));
                this.d = handshake;
                this.e = selectedProtocol != null ? okhttp3.Protocol.get(selectedProtocol) : okhttp3.Protocol.HTTP_1_1;
                okhttp3.internal.platform.Platform.get().afterHandshake(sSLSocket);
                return;
            }
            java.util.List<java.security.cert.Certificate> peerCertificates = handshake.peerCertificates();
            if (peerCertificates.isEmpty()) {
                throw new javax.net.ssl.SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) peerCertificates.get(0);
            throw new javax.net.ssl.SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified:\n    certificate: " + okhttp3.CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(x509Certificate));
        } catch (java.lang.AssertionError e2) {
            e = e2;
            if (!okhttp3.internal.Util.isAndroidGetsocknameError(e)) {
                throw e;
            }
            throw new java.io.IOException(e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                okhttp3.internal.platform.Platform.get().afterHandshake(sSLSocket2);
            }
            okhttp3.internal.Util.closeQuietly((java.net.Socket) sSLSocket2);
            throw th;
        }
    }

    public final void c(int i, int i2, int i3, okhttp3.Call call, okhttp3.EventListener eventListener) throws java.io.IOException {
        okhttp3.Request e = e();
        okhttp3.HttpUrl url = e.url();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, call, eventListener);
            e = d(i2, i3, e, url);
            if (e == null) {
                return;
            }
            okhttp3.internal.Util.closeQuietly(this.b);
            this.b = null;
            this.h = null;
            this.g = null;
            eventListener.connectEnd(call, this.a.socketAddress(), this.a.proxy(), null);
        }
    }

    public void cancel() {
        okhttp3.internal.Util.closeQuietly(this.b);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void connect(int i, int i2, int i3, int i4, boolean z, okhttp3.Call call, okhttp3.EventListener eventListener) {
        if (this.e != null) {
            throw new java.lang.IllegalStateException("already connected");
        }
        java.util.List<okhttp3.ConnectionSpec> connectionSpecs = this.a.address().connectionSpecs();
        okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector = new okhttp3.internal.connection.ConnectionSpecSelector(connectionSpecs);
        if (this.a.address().sslSocketFactory() == null) {
            if (!connectionSpecs.contains(okhttp3.ConnectionSpec.CLEARTEXT)) {
                throw new okhttp3.internal.connection.RouteException(new java.net.UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            java.lang.String host = this.a.address().url().host();
            if (!okhttp3.internal.platform.Platform.get().isCleartextTrafficPermitted(host)) {
                throw new okhttp3.internal.connection.RouteException(new java.net.UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy"));
            }
        } else if (this.a.address().protocols().contains(okhttp3.Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new okhttp3.internal.connection.RouteException(new java.net.UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        okhttp3.internal.connection.RouteException routeException = null;
        do {
            try {
            } catch (java.io.IOException e) {
                e = e;
            }
            try {
                if (this.a.requiresTunnel()) {
                    c(i, i2, i3, call, eventListener);
                    if (this.b == null) {
                        if (!this.a.requiresTunnel() && this.b == null) {
                            throw new okhttp3.internal.connection.RouteException(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        if (this.f == null) {
                            synchronized (this.connectionPool) {
                                this.m = this.f.maxConcurrentStreams();
                            }
                            return;
                        }
                        return;
                    }
                } else {
                    try {
                        a(i, i2, call, eventListener);
                    } catch (java.io.IOException e2) {
                        e = e2;
                        okhttp3.internal.Util.closeQuietly(this.c);
                        okhttp3.internal.Util.closeQuietly(this.b);
                        this.c = null;
                        this.b = null;
                        this.g = null;
                        this.h = null;
                        this.d = null;
                        this.e = null;
                        this.f = null;
                        eventListener.connectFailed(call, this.a.socketAddress(), this.a.proxy(), null, e);
                        if (routeException != null) {
                            routeException = new okhttp3.internal.connection.RouteException(e);
                        } else {
                            routeException.addConnectException(e);
                        }
                        if (z) {
                            throw routeException;
                        }
                    }
                }
                f(connectionSpecSelector, i4, call, eventListener);
                eventListener.connectEnd(call, this.a.socketAddress(), this.a.proxy(), this.e);
                if (!this.a.requiresTunnel()) {
                }
                if (this.f == null) {
                }
            } catch (java.io.IOException e3) {
                e = e3;
                okhttp3.internal.Util.closeQuietly(this.c);
                okhttp3.internal.Util.closeQuietly(this.b);
                this.c = null;
                this.b = null;
                this.g = null;
                this.h = null;
                this.d = null;
                this.e = null;
                this.f = null;
                eventListener.connectFailed(call, this.a.socketAddress(), this.a.proxy(), null, e);
                if (routeException != null) {
                }
                if (z) {
                }
            }
        } while (connectionSpecSelector.b(e));
        throw routeException;
    }

    public final okhttp3.Request d(int i, int i2, okhttp3.Request request, okhttp3.HttpUrl httpUrl) throws java.io.IOException {
        java.lang.String str = "CONNECT " + okhttp3.internal.Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec = new okhttp3.internal.http1.Http1ExchangeCodec(null, null, this.g, this.h);
            java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
            this.g.timeout().timeout(i, timeUnit);
            this.h.timeout().timeout(i2, timeUnit);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            okhttp3.Response build = http1ExchangeCodec.readResponseHeaders(false).request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code == 200) {
                if (this.g.getBuffer().exhausted() && this.h.buffer().exhausted()) {
                    return null;
                }
                throw new java.io.IOException("TLS tunnel buffered too many bytes!");
            }
            if (code != 407) {
                throw new java.io.IOException("Unexpected response code for CONNECT: " + build.code());
            }
            okhttp3.Request authenticate = this.a.address().proxyAuthenticator().authenticate(this.a, build);
            if (authenticate == null) {
                throw new java.io.IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(build.header(com.google.common.net.HttpHeaders.CONNECTION))) {
                return authenticate;
            }
            request = authenticate;
        }
    }

    public final okhttp3.Request e() throws java.io.IOException {
        okhttp3.Request build = new okhttp3.Request.Builder().url(this.a.address().url()).method("CONNECT", null).header("Host", okhttp3.internal.Util.hostHeader(this.a.address().url(), true)).header("Proxy-Connection", com.anythink.expressad.foundation.g.f.g.b.c).header("User-Agent", okhttp3.internal.Version.userAgent()).build();
        okhttp3.Request authenticate = this.a.address().proxyAuthenticator().authenticate(this.a, new okhttp3.Response.Builder().request(build).protocol(okhttp3.Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(okhttp3.internal.Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header(com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    public final void f(okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector, int i, okhttp3.Call call, okhttp3.EventListener eventListener) throws java.io.IOException {
        if (this.a.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            b(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.d);
            if (this.e == okhttp3.Protocol.HTTP_2) {
                k(i);
                return;
            }
            return;
        }
        java.util.List<okhttp3.Protocol> protocols = this.a.address().protocols();
        okhttp3.Protocol protocol = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
        if (!protocols.contains(protocol)) {
            this.c = this.b;
            this.e = okhttp3.Protocol.HTTP_1_1;
        } else {
            this.c = this.b;
            this.e = protocol;
            k(i);
        }
    }

    public boolean g(okhttp3.Address address, @javax.annotation.Nullable java.util.List<okhttp3.Route> list) {
        if (this.n.size() >= this.m || this.i || !okhttp3.internal.Internal.instance.equalsNonHost(this.a.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.f == null || list == null || !j(list) || address.hostnameVerifier() != okhttp3.internal.tls.OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public okhttp3.internal.http.ExchangeCodec h(okhttp3.OkHttpClient okHttpClient, okhttp3.Interceptor.Chain chain) throws java.net.SocketException {
        if (this.f != null) {
            return new okhttp3.internal.http2.Http2ExchangeCodec(okHttpClient, this, chain, this.f);
        }
        this.c.setSoTimeout(chain.readTimeoutMillis());
        okio.Timeout timeout = this.g.timeout();
        long readTimeoutMillis = chain.readTimeoutMillis();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        timeout.timeout(readTimeoutMillis, timeUnit);
        this.h.timeout().timeout(chain.writeTimeoutMillis(), timeUnit);
        return new okhttp3.internal.http1.Http1ExchangeCodec(okHttpClient, this, this.g, this.h);
    }

    @Override // okhttp3.Connection
    public okhttp3.Handshake handshake() {
        return this.d;
    }

    public okhttp3.internal.ws.RealWebSocket.Streams i(okhttp3.internal.connection.Exchange exchange) throws java.net.SocketException {
        this.c.setSoTimeout(0);
        noNewExchanges();
        return new okhttp3.internal.connection.RealConnection.AnonymousClass1(true, this.g, this.h, exchange);
    }

    public boolean isHealthy(boolean z) {
        if (this.c.isClosed() || this.c.isInputShutdown() || this.c.isOutputShutdown()) {
            return false;
        }
        okhttp3.internal.http2.Http2Connection http2Connection = this.f;
        if (http2Connection != null) {
            return http2Connection.isHealthy(java.lang.System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.c.getSoTimeout();
                try {
                    this.c.setSoTimeout(1);
                    return !this.g.exhausted();
                } finally {
                    this.c.setSoTimeout(soTimeout);
                }
            } catch (java.net.SocketTimeoutException unused) {
            } catch (java.io.IOException unused2) {
                return false;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        return this.f != null;
    }

    public final boolean j(java.util.List<okhttp3.Route> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            okhttp3.Route route = list.get(i);
            if (route.proxy().type() == java.net.Proxy.Type.DIRECT && this.a.proxy().type() == java.net.Proxy.Type.DIRECT && this.a.socketAddress().equals(route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    public final void k(int i) throws java.io.IOException {
        this.c.setSoTimeout(0);
        okhttp3.internal.http2.Http2Connection build = new okhttp3.internal.http2.Http2Connection.Builder(true).socket(this.c, this.a.address().url().host(), this.g, this.h).listener(this).pingIntervalMillis(i).build();
        this.f = build;
        build.start();
    }

    public void l(@javax.annotation.Nullable java.io.IOException iOException) {
        synchronized (this.connectionPool) {
            if (iOException instanceof okhttp3.internal.http2.StreamResetException) {
                okhttp3.internal.http2.ErrorCode errorCode = ((okhttp3.internal.http2.StreamResetException) iOException).errorCode;
                if (errorCode == okhttp3.internal.http2.ErrorCode.REFUSED_STREAM) {
                    int i = this.l + 1;
                    this.l = i;
                    if (i > 1) {
                        this.i = true;
                        this.j++;
                    }
                } else if (errorCode != okhttp3.internal.http2.ErrorCode.CANCEL) {
                    this.i = true;
                    this.j++;
                }
            } else if (!isMultiplexed() || (iOException instanceof okhttp3.internal.http2.ConnectionShutdownException)) {
                this.i = true;
                if (this.k == 0) {
                    if (iOException != null) {
                        this.connectionPool.connectFailed(this.a, iOException);
                    }
                    this.j++;
                }
            }
        }
    }

    public void noNewExchanges() {
        synchronized (this.connectionPool) {
            this.i = true;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(okhttp3.internal.http2.Http2Connection http2Connection) {
        synchronized (this.connectionPool) {
            this.m = http2Connection.maxConcurrentStreams();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(okhttp3.internal.http2.Http2Stream http2Stream) throws java.io.IOException {
        http2Stream.close(okhttp3.internal.http2.ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    public okhttp3.Protocol protocol() {
        return this.e;
    }

    @Override // okhttp3.Connection
    public okhttp3.Route route() {
        return this.a;
    }

    @Override // okhttp3.Connection
    public java.net.Socket socket() {
        return this.c;
    }

    public boolean supportsUrl(okhttp3.HttpUrl httpUrl) {
        if (httpUrl.port() != this.a.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.a.address().url().host())) {
            return true;
        }
        return this.d != null && okhttp3.internal.tls.OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (java.security.cert.X509Certificate) this.d.peerCertificates().get(0));
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Connection{");
        sb.append(this.a.address().url().host());
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(this.a.address().url().port());
        sb.append(", proxy=");
        sb.append(this.a.proxy());
        sb.append(" hostAddress=");
        sb.append(this.a.socketAddress());
        sb.append(" cipherSuite=");
        okhttp3.Handshake handshake = this.d;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.e);
        sb.append('}');
        return sb.toString();
    }
}
