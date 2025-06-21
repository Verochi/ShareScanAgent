package okhttp3.internal.connection;

/* loaded from: classes23.dex */
public final class Transmitter {
    public final okhttp3.OkHttpClient a;
    public final okhttp3.internal.connection.RealConnectionPool b;
    public final okhttp3.Call c;
    public okhttp3.internal.connection.RealConnection connection;
    public final okhttp3.EventListener d;
    public final okio.AsyncTimeout e;

    @javax.annotation.Nullable
    public java.lang.Object f;
    public okhttp3.Request g;
    public okhttp3.internal.connection.ExchangeFinder h;

    @javax.annotation.Nullable
    public okhttp3.internal.connection.Exchange i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    /* renamed from: okhttp3.internal.connection.Transmitter$1, reason: invalid class name */
    public class AnonymousClass1 extends okio.AsyncTimeout {
        public AnonymousClass1() {
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            okhttp3.internal.connection.Transmitter.this.cancel();
        }
    }

    public static final class TransmitterReference extends java.lang.ref.WeakReference<okhttp3.internal.connection.Transmitter> {
        public final java.lang.Object a;

        public TransmitterReference(okhttp3.internal.connection.Transmitter transmitter, java.lang.Object obj) {
            super(transmitter);
            this.a = obj;
        }
    }

    public Transmitter(okhttp3.OkHttpClient okHttpClient, okhttp3.Call call) {
        okhttp3.internal.connection.Transmitter.AnonymousClass1 anonymousClass1 = new okhttp3.internal.connection.Transmitter.AnonymousClass1();
        this.e = anonymousClass1;
        this.a = okHttpClient;
        this.b = okhttp3.internal.Internal.instance.realConnectionPool(okHttpClient.connectionPool());
        this.c = call;
        this.d = okHttpClient.eventListenerFactory().create(call);
        anonymousClass1.timeout(okHttpClient.callTimeoutMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    public void a(okhttp3.internal.connection.RealConnection realConnection) {
        if (this.connection != null) {
            throw new java.lang.IllegalStateException();
        }
        this.connection = realConnection;
        realConnection.n.add(new okhttp3.internal.connection.Transmitter.TransmitterReference(this, this.f));
    }

    public final okhttp3.Address b(okhttp3.HttpUrl httpUrl) {
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        okhttp3.CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.a.sslSocketFactory();
            hostnameVerifier = this.a.hostnameVerifier();
            certificatePinner = this.a.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new okhttp3.Address(httpUrl.host(), httpUrl.port(), this.a.dns(), this.a.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.a.proxyAuthenticator(), this.a.proxy(), this.a.protocols(), this.a.connectionSpecs(), this.a.proxySelector());
    }

    @javax.annotation.Nullable
    public java.io.IOException c(okhttp3.internal.connection.Exchange exchange, boolean z, boolean z2, @javax.annotation.Nullable java.io.IOException iOException) {
        boolean z3;
        synchronized (this.b) {
            okhttp3.internal.connection.Exchange exchange2 = this.i;
            if (exchange != exchange2) {
                return iOException;
            }
            boolean z4 = true;
            if (z) {
                z3 = !this.j;
                this.j = true;
            } else {
                z3 = false;
            }
            if (z2) {
                if (!this.k) {
                    z3 = true;
                }
                this.k = true;
            }
            if (this.j && this.k && z3) {
                exchange2.connection().k++;
                this.i = null;
            } else {
                z4 = false;
            }
            return z4 ? d(iOException, false) : iOException;
        }
    }

    public void callStart() {
        this.f = okhttp3.internal.platform.Platform.get().getStackTraceForCloseable("response.body().close()");
        this.d.callStart(this.c);
    }

    public boolean canRetry() {
        return this.h.f() && this.h.e();
    }

    public void cancel() {
        okhttp3.internal.connection.Exchange exchange;
        okhttp3.internal.connection.RealConnection a;
        synchronized (this.b) {
            this.l = true;
            exchange = this.i;
            okhttp3.internal.connection.ExchangeFinder exchangeFinder = this.h;
            a = (exchangeFinder == null || exchangeFinder.a() == null) ? this.connection : this.h.a();
        }
        if (exchange != null) {
            exchange.cancel();
        } else if (a != null) {
            a.cancel();
        }
    }

    @javax.annotation.Nullable
    public final java.io.IOException d(@javax.annotation.Nullable java.io.IOException iOException, boolean z) {
        okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket f;
        boolean z2;
        synchronized (this.b) {
            if (z) {
                if (this.i != null) {
                    throw new java.lang.IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            f = (realConnection != null && this.i == null && (z || this.n)) ? f() : null;
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = this.n && this.i == null;
        }
        okhttp3.internal.Util.closeQuietly(f);
        if (realConnection != null) {
            this.d.connectionReleased(this.c, realConnection);
        }
        if (z2) {
            boolean z3 = iOException != null;
            iOException = g(iOException);
            if (z3) {
                this.d.callFailed(this.c, iOException);
            } else {
                this.d.callEnd(this.c);
            }
        }
        return iOException;
    }

    public okhttp3.internal.connection.Exchange e(okhttp3.Interceptor.Chain chain, boolean z) {
        synchronized (this.b) {
            if (this.n) {
                throw new java.lang.IllegalStateException("released");
            }
            if (this.i != null) {
                throw new java.lang.IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        okhttp3.internal.connection.Exchange exchange = new okhttp3.internal.connection.Exchange(this, this.c, this.d, this.h, this.h.b(this.a, chain, z));
        synchronized (this.b) {
            this.i = exchange;
            this.j = false;
            this.k = false;
        }
        return exchange;
    }

    public void exchangeDoneDueToException() {
        synchronized (this.b) {
            if (this.n) {
                throw new java.lang.IllegalStateException();
            }
            this.i = null;
        }
    }

    @javax.annotation.Nullable
    public java.net.Socket f() {
        int size = this.connection.n.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (this.connection.n.get(i).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new java.lang.IllegalStateException();
        }
        okhttp3.internal.connection.RealConnection realConnection = this.connection;
        realConnection.n.remove(i);
        this.connection = null;
        if (realConnection.n.isEmpty()) {
            realConnection.o = java.lang.System.nanoTime();
            if (this.b.c(realConnection)) {
                return realConnection.socket();
            }
        }
        return null;
    }

    @javax.annotation.Nullable
    public final java.io.IOException g(@javax.annotation.Nullable java.io.IOException iOException) {
        if (this.m || !this.e.exit()) {
            return iOException;
        }
        java.io.InterruptedIOException interruptedIOException = new java.io.InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.b) {
            z = this.i != null;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.b) {
            z = this.l;
        }
        return z;
    }

    @javax.annotation.Nullable
    public java.io.IOException noMoreExchanges(@javax.annotation.Nullable java.io.IOException iOException) {
        synchronized (this.b) {
            this.n = true;
        }
        return d(iOException, false);
    }

    public void prepareToConnect(okhttp3.Request request) {
        okhttp3.Request request2 = this.g;
        if (request2 != null) {
            if (okhttp3.internal.Util.sameConnection(request2.url(), request.url()) && this.h.e()) {
                return;
            }
            if (this.i != null) {
                throw new java.lang.IllegalStateException();
            }
            if (this.h != null) {
                d(null, true);
                this.h = null;
            }
        }
        this.g = request;
        this.h = new okhttp3.internal.connection.ExchangeFinder(this, this.b, b(request.url()), this.c, this.d);
    }

    public okio.Timeout timeout() {
        return this.e;
    }

    public void timeoutEarlyExit() {
        if (this.m) {
            throw new java.lang.IllegalStateException();
        }
        this.m = true;
        this.e.exit();
    }

    public void timeoutEnter() {
        this.e.enter();
    }
}
