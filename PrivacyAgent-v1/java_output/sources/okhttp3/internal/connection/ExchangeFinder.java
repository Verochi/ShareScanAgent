package okhttp3.internal.connection;

/* loaded from: classes23.dex */
final class ExchangeFinder {
    public final okhttp3.internal.connection.Transmitter a;
    public final okhttp3.Address b;
    public final okhttp3.internal.connection.RealConnectionPool c;
    public final okhttp3.Call d;
    public final okhttp3.EventListener e;
    public okhttp3.internal.connection.RouteSelector.Selection f;
    public final okhttp3.internal.connection.RouteSelector g;
    public okhttp3.internal.connection.RealConnection h;
    public boolean i;
    public okhttp3.Route j;

    public ExchangeFinder(okhttp3.internal.connection.Transmitter transmitter, okhttp3.internal.connection.RealConnectionPool realConnectionPool, okhttp3.Address address, okhttp3.Call call, okhttp3.EventListener eventListener) {
        this.a = transmitter;
        this.c = realConnectionPool;
        this.b = address;
        this.d = call;
        this.e = eventListener;
        this.g = new okhttp3.internal.connection.RouteSelector(address, realConnectionPool.e, call, eventListener);
    }

    public okhttp3.internal.connection.RealConnection a() {
        return this.h;
    }

    public okhttp3.internal.http.ExchangeCodec b(okhttp3.OkHttpClient okHttpClient, okhttp3.Interceptor.Chain chain, boolean z) {
        try {
            return d(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).h(okHttpClient, chain);
        } catch (java.io.IOException e) {
            h();
            throw new okhttp3.internal.connection.RouteException(e);
        } catch (okhttp3.internal.connection.RouteException e2) {
            h();
            throw e2;
        }
    }

    public final okhttp3.internal.connection.RealConnection c(int i, int i2, int i3, int i4, boolean z) throws java.io.IOException {
        okhttp3.internal.connection.RealConnection realConnection;
        java.net.Socket socket;
        java.net.Socket f;
        okhttp3.internal.connection.RealConnection realConnection2;
        okhttp3.Route route;
        boolean z2;
        boolean z3;
        java.util.List<okhttp3.Route> list;
        okhttp3.internal.connection.RouteSelector.Selection selection;
        synchronized (this.c) {
            if (this.a.isCanceled()) {
                throw new java.io.IOException("Canceled");
            }
            this.i = false;
            okhttp3.internal.connection.Transmitter transmitter = this.a;
            realConnection = transmitter.connection;
            socket = null;
            f = (realConnection == null || !realConnection.i) ? null : transmitter.f();
            okhttp3.internal.connection.Transmitter transmitter2 = this.a;
            realConnection2 = transmitter2.connection;
            if (realConnection2 != null) {
                realConnection = null;
            } else {
                realConnection2 = null;
            }
            if (realConnection2 == null) {
                if (this.c.g(this.b, transmitter2, null, false)) {
                    realConnection2 = this.a.connection;
                    route = null;
                    z2 = true;
                } else {
                    route = this.j;
                    if (route != null) {
                        this.j = null;
                    } else if (g()) {
                        route = this.a.connection.route();
                    }
                    z2 = false;
                }
            }
            route = null;
            z2 = false;
        }
        okhttp3.internal.Util.closeQuietly(f);
        if (realConnection != null) {
            this.e.connectionReleased(this.d, realConnection);
        }
        if (z2) {
            this.e.connectionAcquired(this.d, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route != null || ((selection = this.f) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.f = this.g.d();
            z3 = true;
        }
        synchronized (this.c) {
            if (this.a.isCanceled()) {
                throw new java.io.IOException("Canceled");
            }
            if (z3) {
                list = this.f.getAll();
                if (this.c.g(this.b, this.a, list, false)) {
                    realConnection2 = this.a.connection;
                    z2 = true;
                }
            } else {
                list = null;
            }
            if (!z2) {
                if (route == null) {
                    route = this.f.next();
                }
                realConnection2 = new okhttp3.internal.connection.RealConnection(this.c, route);
                this.h = realConnection2;
            }
        }
        if (z2) {
            this.e.connectionAcquired(this.d, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.d, this.e);
        this.c.e.a(realConnection2.route());
        synchronized (this.c) {
            this.h = null;
            if (this.c.g(this.b, this.a, list, true)) {
                realConnection2.i = true;
                socket = realConnection2.socket();
                realConnection2 = this.a.connection;
                this.j = route;
            } else {
                this.c.f(realConnection2);
                this.a.a(realConnection2);
            }
        }
        okhttp3.internal.Util.closeQuietly(socket);
        this.e.connectionAcquired(this.d, realConnection2);
        return realConnection2;
    }

    public final okhttp3.internal.connection.RealConnection d(int i, int i2, int i3, int i4, boolean z, boolean z2) throws java.io.IOException {
        while (true) {
            okhttp3.internal.connection.RealConnection c = c(i, i2, i3, i4, z);
            synchronized (this.c) {
                if (c.k == 0 && !c.isMultiplexed()) {
                    return c;
                }
                if (c.isHealthy(z2)) {
                    return c;
                }
                c.noNewExchanges();
            }
        }
    }

    public boolean e() {
        synchronized (this.c) {
            boolean z = true;
            if (this.j != null) {
                return true;
            }
            if (g()) {
                this.j = this.a.connection.route();
                return true;
            }
            okhttp3.internal.connection.RouteSelector.Selection selection = this.f;
            if ((selection == null || !selection.hasNext()) && !this.g.b()) {
                z = false;
            }
            return z;
        }
    }

    public boolean f() {
        boolean z;
        synchronized (this.c) {
            z = this.i;
        }
        return z;
    }

    public final boolean g() {
        okhttp3.internal.connection.RealConnection realConnection = this.a.connection;
        return realConnection != null && realConnection.j == 0 && okhttp3.internal.Util.sameConnection(realConnection.route().address().url(), this.b.url());
    }

    public void h() {
        synchronized (this.c) {
            this.i = true;
        }
    }
}
