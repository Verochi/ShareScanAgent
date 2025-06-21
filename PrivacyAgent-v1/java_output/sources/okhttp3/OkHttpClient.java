package okhttp3;

/* loaded from: classes23.dex */
public class OkHttpClient implements java.lang.Cloneable, okhttp3.Call.Factory, okhttp3.WebSocket.Factory {
    public static final java.util.List<okhttp3.Protocol> U = okhttp3.internal.Util.immutableList(okhttp3.Protocol.HTTP_2, okhttp3.Protocol.HTTP_1_1);
    public static final java.util.List<okhttp3.ConnectionSpec> V = okhttp3.internal.Util.immutableList(okhttp3.ConnectionSpec.MODERN_TLS, okhttp3.ConnectionSpec.CLEARTEXT);
    public final okhttp3.CookieJar A;

    @javax.annotation.Nullable
    public final okhttp3.Cache B;

    @javax.annotation.Nullable
    public final okhttp3.internal.cache.InternalCache C;
    public final javax.net.SocketFactory D;
    public final javax.net.ssl.SSLSocketFactory E;
    public final okhttp3.internal.tls.CertificateChainCleaner F;
    public final javax.net.ssl.HostnameVerifier G;
    public final okhttp3.CertificatePinner H;
    public final okhttp3.Authenticator I;
    public final okhttp3.Authenticator J;
    public final okhttp3.ConnectionPool K;
    public final okhttp3.Dns L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final int P;
    public final int Q;
    public final int R;
    public final int S;
    public final int T;
    public final okhttp3.Dispatcher n;

    @javax.annotation.Nullable
    public final java.net.Proxy t;
    public final java.util.List<okhttp3.Protocol> u;
    public final java.util.List<okhttp3.ConnectionSpec> v;
    public final java.util.List<okhttp3.Interceptor> w;
    public final java.util.List<okhttp3.Interceptor> x;
    public final okhttp3.EventListener.Factory y;
    public final java.net.ProxySelector z;

    /* renamed from: okhttp3.OkHttpClient$1, reason: invalid class name */
    public class AnonymousClass1 extends okhttp3.internal.Internal {
        @Override // okhttp3.internal.Internal
        public void addLenient(okhttp3.Headers.Builder builder, java.lang.String str) {
            builder.a(str);
        }

        @Override // okhttp3.internal.Internal
        public void addLenient(okhttp3.Headers.Builder builder, java.lang.String str, java.lang.String str2) {
            builder.b(str, str2);
        }

        @Override // okhttp3.internal.Internal
        public void apply(okhttp3.ConnectionSpec connectionSpec, javax.net.ssl.SSLSocket sSLSocket, boolean z) {
            connectionSpec.a(sSLSocket, z);
        }

        @Override // okhttp3.internal.Internal
        public int code(okhttp3.Response.Builder builder) {
            return builder.c;
        }

        @Override // okhttp3.internal.Internal
        public boolean equalsNonHost(okhttp3.Address address, okhttp3.Address address2) {
            return address.a(address2);
        }

        @Override // okhttp3.internal.Internal
        @javax.annotation.Nullable
        public okhttp3.internal.connection.Exchange exchange(okhttp3.Response response) {
            return response.E;
        }

        @Override // okhttp3.internal.Internal
        public void initExchange(okhttp3.Response.Builder builder, okhttp3.internal.connection.Exchange exchange) {
            builder.c(exchange);
        }

        @Override // okhttp3.internal.Internal
        public okhttp3.Call newWebSocketCall(okhttp3.OkHttpClient okHttpClient, okhttp3.Request request) {
            return okhttp3.RealCall.d(okHttpClient, request, true);
        }

        @Override // okhttp3.internal.Internal
        public okhttp3.internal.connection.RealConnectionPool realConnectionPool(okhttp3.ConnectionPool connectionPool) {
            return connectionPool.a;
        }
    }

    public static final class Builder {
        public int A;
        public int B;
        public okhttp3.Dispatcher a;

        @javax.annotation.Nullable
        public java.net.Proxy b;
        public java.util.List<okhttp3.Protocol> c;
        public java.util.List<okhttp3.ConnectionSpec> d;
        public final java.util.List<okhttp3.Interceptor> e;
        public final java.util.List<okhttp3.Interceptor> f;
        public okhttp3.EventListener.Factory g;
        public java.net.ProxySelector h;
        public okhttp3.CookieJar i;

        @javax.annotation.Nullable
        public okhttp3.Cache j;

        @javax.annotation.Nullable
        public okhttp3.internal.cache.InternalCache k;
        public javax.net.SocketFactory l;

        @javax.annotation.Nullable
        public javax.net.ssl.SSLSocketFactory m;

        @javax.annotation.Nullable
        public okhttp3.internal.tls.CertificateChainCleaner n;
        public javax.net.ssl.HostnameVerifier o;
        public okhttp3.CertificatePinner p;
        public okhttp3.Authenticator q;
        public okhttp3.Authenticator r;

        /* renamed from: s, reason: collision with root package name */
        public okhttp3.ConnectionPool f501s;
        public okhttp3.Dns t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        public Builder() {
            this.e = new java.util.ArrayList();
            this.f = new java.util.ArrayList();
            this.a = new okhttp3.Dispatcher();
            this.c = okhttp3.OkHttpClient.U;
            this.d = okhttp3.OkHttpClient.V;
            this.g = okhttp3.EventListener.factory(okhttp3.EventListener.NONE);
            java.net.ProxySelector proxySelector = java.net.ProxySelector.getDefault();
            this.h = proxySelector;
            if (proxySelector == null) {
                this.h = new okhttp3.internal.proxy.NullProxySelector();
            }
            this.i = okhttp3.CookieJar.NO_COOKIES;
            this.l = javax.net.SocketFactory.getDefault();
            this.o = okhttp3.internal.tls.OkHostnameVerifier.INSTANCE;
            this.p = okhttp3.CertificatePinner.DEFAULT;
            okhttp3.Authenticator authenticator = okhttp3.Authenticator.NONE;
            this.q = authenticator;
            this.r = authenticator;
            this.f501s = new okhttp3.ConnectionPool();
            this.t = okhttp3.Dns.SYSTEM;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        public Builder(okhttp3.OkHttpClient okHttpClient) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            this.e = arrayList;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            this.f = arrayList2;
            this.a = okHttpClient.n;
            this.b = okHttpClient.t;
            this.c = okHttpClient.u;
            this.d = okHttpClient.v;
            arrayList.addAll(okHttpClient.w);
            arrayList2.addAll(okHttpClient.x);
            this.g = okHttpClient.y;
            this.h = okHttpClient.z;
            this.i = okHttpClient.A;
            this.k = okHttpClient.C;
            this.j = okHttpClient.B;
            this.l = okHttpClient.D;
            this.m = okHttpClient.E;
            this.n = okHttpClient.F;
            this.o = okHttpClient.G;
            this.p = okHttpClient.H;
            this.q = okHttpClient.I;
            this.r = okHttpClient.J;
            this.f501s = okHttpClient.K;
            this.t = okHttpClient.L;
            this.u = okHttpClient.M;
            this.v = okHttpClient.N;
            this.w = okHttpClient.O;
            this.x = okHttpClient.P;
            this.y = okHttpClient.Q;
            this.z = okHttpClient.R;
            this.A = okHttpClient.S;
            this.B = okHttpClient.T;
        }

        public okhttp3.OkHttpClient.Builder addInterceptor(okhttp3.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.e.add(interceptor);
            return this;
        }

        public okhttp3.OkHttpClient.Builder addNetworkInterceptor(okhttp3.Interceptor interceptor) {
            if (interceptor == null) {
                throw new java.lang.IllegalArgumentException("interceptor == null");
            }
            this.f.add(interceptor);
            return this;
        }

        public okhttp3.OkHttpClient.Builder authenticator(okhttp3.Authenticator authenticator) {
            if (authenticator == null) {
                throw new java.lang.NullPointerException("authenticator == null");
            }
            this.r = authenticator;
            return this;
        }

        public okhttp3.OkHttpClient build() {
            return new okhttp3.OkHttpClient(this);
        }

        public okhttp3.OkHttpClient.Builder cache(@javax.annotation.Nullable okhttp3.Cache cache) {
            this.j = cache;
            this.k = null;
            return this;
        }

        public okhttp3.OkHttpClient.Builder callTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.x = okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder callTimeout(java.time.Duration duration) {
            long millis;
            millis = duration.toMillis();
            this.x = okhttp3.internal.Util.checkDuration("timeout", millis, java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder certificatePinner(okhttp3.CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new java.lang.NullPointerException("certificatePinner == null");
            }
            this.p = certificatePinner;
            return this;
        }

        public okhttp3.OkHttpClient.Builder connectTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.y = okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder connectTimeout(java.time.Duration duration) {
            long millis;
            millis = duration.toMillis();
            this.y = okhttp3.internal.Util.checkDuration("timeout", millis, java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder connectionPool(okhttp3.ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new java.lang.NullPointerException("connectionPool == null");
            }
            this.f501s = connectionPool;
            return this;
        }

        public okhttp3.OkHttpClient.Builder connectionSpecs(java.util.List<okhttp3.ConnectionSpec> list) {
            this.d = okhttp3.internal.Util.immutableList(list);
            return this;
        }

        public okhttp3.OkHttpClient.Builder cookieJar(okhttp3.CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new java.lang.NullPointerException("cookieJar == null");
            }
            this.i = cookieJar;
            return this;
        }

        public okhttp3.OkHttpClient.Builder dispatcher(okhttp3.Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new java.lang.IllegalArgumentException("dispatcher == null");
            }
            this.a = dispatcher;
            return this;
        }

        public okhttp3.OkHttpClient.Builder dns(okhttp3.Dns dns) {
            if (dns == null) {
                throw new java.lang.NullPointerException("dns == null");
            }
            this.t = dns;
            return this;
        }

        public okhttp3.OkHttpClient.Builder eventListener(okhttp3.EventListener eventListener) {
            if (eventListener == null) {
                throw new java.lang.NullPointerException("eventListener == null");
            }
            this.g = okhttp3.EventListener.factory(eventListener);
            return this;
        }

        public okhttp3.OkHttpClient.Builder eventListenerFactory(okhttp3.EventListener.Factory factory) {
            if (factory == null) {
                throw new java.lang.NullPointerException("eventListenerFactory == null");
            }
            this.g = factory;
            return this;
        }

        public okhttp3.OkHttpClient.Builder followRedirects(boolean z) {
            this.v = z;
            return this;
        }

        public okhttp3.OkHttpClient.Builder followSslRedirects(boolean z) {
            this.u = z;
            return this;
        }

        public okhttp3.OkHttpClient.Builder hostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new java.lang.NullPointerException("hostnameVerifier == null");
            }
            this.o = hostnameVerifier;
            return this;
        }

        public java.util.List<okhttp3.Interceptor> interceptors() {
            return this.e;
        }

        public java.util.List<okhttp3.Interceptor> networkInterceptors() {
            return this.f;
        }

        public okhttp3.OkHttpClient.Builder pingInterval(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.B = okhttp3.internal.Util.checkDuration(com.umeng.analytics.pro.bo.ba, j, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder pingInterval(java.time.Duration duration) {
            long millis;
            millis = duration.toMillis();
            this.B = okhttp3.internal.Util.checkDuration("timeout", millis, java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder protocols(java.util.List<okhttp3.Protocol> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList(list);
            okhttp3.Protocol protocol = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
            if (!arrayList.contains(protocol) && !arrayList.contains(okhttp3.Protocol.HTTP_1_1)) {
                throw new java.lang.IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(protocol) && arrayList.size() > 1) {
                throw new java.lang.IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(okhttp3.Protocol.HTTP_1_0)) {
                throw new java.lang.IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new java.lang.IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(okhttp3.Protocol.SPDY_3);
            this.c = java.util.Collections.unmodifiableList(arrayList);
            return this;
        }

        public okhttp3.OkHttpClient.Builder proxy(@javax.annotation.Nullable java.net.Proxy proxy) {
            this.b = proxy;
            return this;
        }

        public okhttp3.OkHttpClient.Builder proxyAuthenticator(okhttp3.Authenticator authenticator) {
            if (authenticator == null) {
                throw new java.lang.NullPointerException("proxyAuthenticator == null");
            }
            this.q = authenticator;
            return this;
        }

        public okhttp3.OkHttpClient.Builder proxySelector(java.net.ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new java.lang.NullPointerException("proxySelector == null");
            }
            this.h = proxySelector;
            return this;
        }

        public okhttp3.OkHttpClient.Builder readTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.z = okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder readTimeout(java.time.Duration duration) {
            long millis;
            millis = duration.toMillis();
            this.z = okhttp3.internal.Util.checkDuration("timeout", millis, java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }

        public okhttp3.OkHttpClient.Builder retryOnConnectionFailure(boolean z) {
            this.w = z;
            return this;
        }

        public okhttp3.OkHttpClient.Builder socketFactory(javax.net.SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new java.lang.NullPointerException("socketFactory == null");
            }
            if (socketFactory instanceof javax.net.ssl.SSLSocketFactory) {
                throw new java.lang.IllegalArgumentException("socketFactory instanceof SSLSocketFactory");
            }
            this.l = socketFactory;
            return this;
        }

        public okhttp3.OkHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            this.m = sSLSocketFactory;
            this.n = okhttp3.internal.platform.Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public okhttp3.OkHttpClient.Builder sslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory, javax.net.ssl.X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new java.lang.NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new java.lang.NullPointerException("trustManager == null");
            }
            this.m = sSLSocketFactory;
            this.n = okhttp3.internal.tls.CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public okhttp3.OkHttpClient.Builder writeTimeout(long j, java.util.concurrent.TimeUnit timeUnit) {
            this.A = okhttp3.internal.Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
        public okhttp3.OkHttpClient.Builder writeTimeout(java.time.Duration duration) {
            long millis;
            millis = duration.toMillis();
            this.A = okhttp3.internal.Util.checkDuration("timeout", millis, java.util.concurrent.TimeUnit.MILLISECONDS);
            return this;
        }
    }

    static {
        okhttp3.internal.Internal.instance = new okhttp3.OkHttpClient.AnonymousClass1();
    }

    public OkHttpClient() {
        this(new okhttp3.OkHttpClient.Builder());
    }

    public OkHttpClient(okhttp3.OkHttpClient.Builder builder) {
        boolean z;
        this.n = builder.a;
        this.t = builder.b;
        this.u = builder.c;
        java.util.List<okhttp3.ConnectionSpec> list = builder.d;
        this.v = list;
        this.w = okhttp3.internal.Util.immutableList(builder.e);
        this.x = okhttp3.internal.Util.immutableList(builder.f);
        this.y = builder.g;
        this.z = builder.h;
        this.A = builder.i;
        this.B = builder.j;
        this.C = builder.k;
        this.D = builder.l;
        java.util.Iterator<okhttp3.ConnectionSpec> it = list.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().isTls();
            }
        }
        javax.net.ssl.SSLSocketFactory sSLSocketFactory = builder.m;
        if (sSLSocketFactory == null && z) {
            javax.net.ssl.X509TrustManager platformTrustManager = okhttp3.internal.Util.platformTrustManager();
            this.E = b(platformTrustManager);
            this.F = okhttp3.internal.tls.CertificateChainCleaner.get(platformTrustManager);
        } else {
            this.E = sSLSocketFactory;
            this.F = builder.n;
        }
        if (this.E != null) {
            okhttp3.internal.platform.Platform.get().configureSslSocketFactory(this.E);
        }
        this.G = builder.o;
        this.H = builder.p.d(this.F);
        this.I = builder.q;
        this.J = builder.r;
        this.K = builder.f501s;
        this.L = builder.t;
        this.M = builder.u;
        this.N = builder.v;
        this.O = builder.w;
        this.P = builder.x;
        this.Q = builder.y;
        this.R = builder.z;
        this.S = builder.A;
        this.T = builder.B;
        if (this.w.contains(null)) {
            throw new java.lang.IllegalStateException("Null interceptor: " + this.w);
        }
        if (this.x.contains(null)) {
            throw new java.lang.IllegalStateException("Null network interceptor: " + this.x);
        }
    }

    public static javax.net.ssl.SSLSocketFactory b(javax.net.ssl.X509TrustManager x509TrustManager) {
        try {
            javax.net.ssl.SSLContext sSLContext = okhttp3.internal.platform.Platform.get().getSSLContext();
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (java.security.GeneralSecurityException e) {
            throw new java.lang.AssertionError("No System TLS", e);
        }
    }

    @javax.annotation.Nullable
    public okhttp3.internal.cache.InternalCache a() {
        okhttp3.Cache cache = this.B;
        return cache != null ? cache.n : this.C;
    }

    public okhttp3.Authenticator authenticator() {
        return this.J;
    }

    @javax.annotation.Nullable
    public okhttp3.Cache cache() {
        return this.B;
    }

    public int callTimeoutMillis() {
        return this.P;
    }

    public okhttp3.CertificatePinner certificatePinner() {
        return this.H;
    }

    public int connectTimeoutMillis() {
        return this.Q;
    }

    public okhttp3.ConnectionPool connectionPool() {
        return this.K;
    }

    public java.util.List<okhttp3.ConnectionSpec> connectionSpecs() {
        return this.v;
    }

    public okhttp3.CookieJar cookieJar() {
        return this.A;
    }

    public okhttp3.Dispatcher dispatcher() {
        return this.n;
    }

    public okhttp3.Dns dns() {
        return this.L;
    }

    public okhttp3.EventListener.Factory eventListenerFactory() {
        return this.y;
    }

    public boolean followRedirects() {
        return this.N;
    }

    public boolean followSslRedirects() {
        return this.M;
    }

    public javax.net.ssl.HostnameVerifier hostnameVerifier() {
        return this.G;
    }

    public java.util.List<okhttp3.Interceptor> interceptors() {
        return this.w;
    }

    public java.util.List<okhttp3.Interceptor> networkInterceptors() {
        return this.x;
    }

    public okhttp3.OkHttpClient.Builder newBuilder() {
        return new okhttp3.OkHttpClient.Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public okhttp3.Call newCall(okhttp3.Request request) {
        return okhttp3.RealCall.d(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public okhttp3.WebSocket newWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener) {
        okhttp3.internal.ws.RealWebSocket realWebSocket = new okhttp3.internal.ws.RealWebSocket(request, webSocketListener, new java.util.Random(), this.T);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.T;
    }

    public java.util.List<okhttp3.Protocol> protocols() {
        return this.u;
    }

    @javax.annotation.Nullable
    public java.net.Proxy proxy() {
        return this.t;
    }

    public okhttp3.Authenticator proxyAuthenticator() {
        return this.I;
    }

    public java.net.ProxySelector proxySelector() {
        return this.z;
    }

    public int readTimeoutMillis() {
        return this.R;
    }

    public boolean retryOnConnectionFailure() {
        return this.O;
    }

    public javax.net.SocketFactory socketFactory() {
        return this.D;
    }

    public javax.net.ssl.SSLSocketFactory sslSocketFactory() {
        return this.E;
    }

    public int writeTimeoutMillis() {
        return this.S;
    }
}
