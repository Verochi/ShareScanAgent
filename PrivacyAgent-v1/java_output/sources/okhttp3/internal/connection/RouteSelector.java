package okhttp3.internal.connection;

/* loaded from: classes23.dex */
final class RouteSelector {
    public final okhttp3.Address a;
    public final okhttp3.internal.connection.RouteDatabase b;
    public final okhttp3.Call c;
    public final okhttp3.EventListener d;
    public int f;
    public java.util.List<java.net.Proxy> e = java.util.Collections.emptyList();
    public java.util.List<java.net.InetSocketAddress> g = java.util.Collections.emptyList();
    public final java.util.List<okhttp3.Route> h = new java.util.ArrayList();

    public static final class Selection {
        public final java.util.List<okhttp3.Route> a;
        public int b = 0;

        public Selection(java.util.List<okhttp3.Route> list) {
            this.a = list;
        }

        public java.util.List<okhttp3.Route> getAll() {
            return new java.util.ArrayList(this.a);
        }

        public boolean hasNext() {
            return this.b < this.a.size();
        }

        public okhttp3.Route next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            java.util.List<okhttp3.Route> list = this.a;
            int i = this.b;
            this.b = i + 1;
            return list.get(i);
        }
    }

    public RouteSelector(okhttp3.Address address, okhttp3.internal.connection.RouteDatabase routeDatabase, okhttp3.Call call, okhttp3.EventListener eventListener) {
        this.a = address;
        this.b = routeDatabase;
        this.c = call;
        this.d = eventListener;
        g(address.url(), address.proxy());
    }

    public static java.lang.String a(java.net.InetSocketAddress inetSocketAddress) {
        java.net.InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    public boolean b() {
        return c() || !this.h.isEmpty();
    }

    public final boolean c() {
        return this.f < this.e.size();
    }

    public okhttp3.internal.connection.RouteSelector.Selection d() throws java.io.IOException {
        if (!b()) {
            throw new java.util.NoSuchElementException();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (c()) {
            java.net.Proxy e = e();
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                okhttp3.Route route = new okhttp3.Route(this.a, e, this.g.get(i));
                if (this.b.c(route)) {
                    this.h.add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.h);
            this.h.clear();
        }
        return new okhttp3.internal.connection.RouteSelector.Selection(arrayList);
    }

    public final java.net.Proxy e() throws java.io.IOException {
        if (c()) {
            java.util.List<java.net.Proxy> list = this.e;
            int i = this.f;
            this.f = i + 1;
            java.net.Proxy proxy = list.get(i);
            f(proxy);
            return proxy;
        }
        throw new java.net.SocketException("No route to " + this.a.url().host() + "; exhausted proxy configurations: " + this.e);
    }

    public final void f(java.net.Proxy proxy) throws java.io.IOException {
        java.lang.String host;
        int port;
        this.g = new java.util.ArrayList();
        if (proxy.type() == java.net.Proxy.Type.DIRECT || proxy.type() == java.net.Proxy.Type.SOCKS) {
            host = this.a.url().host();
            port = this.a.url().port();
        } else {
            java.net.SocketAddress address = proxy.address();
            if (!(address instanceof java.net.InetSocketAddress)) {
                throw new java.lang.IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            java.net.InetSocketAddress inetSocketAddress = (java.net.InetSocketAddress) address;
            host = a(inetSocketAddress);
            port = inetSocketAddress.getPort();
        }
        if (port < 1 || port > 65535) {
            throw new java.net.SocketException("No route to " + host + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + port + "; port is out of range");
        }
        if (proxy.type() == java.net.Proxy.Type.SOCKS) {
            this.g.add(java.net.InetSocketAddress.createUnresolved(host, port));
            return;
        }
        this.d.dnsStart(this.c, host);
        java.util.List<java.net.InetAddress> lookup = this.a.dns().lookup(host);
        if (lookup.isEmpty()) {
            throw new java.net.UnknownHostException(this.a.dns() + " returned no addresses for " + host);
        }
        this.d.dnsEnd(this.c, host, lookup);
        int size = lookup.size();
        for (int i = 0; i < size; i++) {
            this.g.add(new java.net.InetSocketAddress(lookup.get(i), port));
        }
    }

    public final void g(okhttp3.HttpUrl httpUrl, java.net.Proxy proxy) {
        if (proxy != null) {
            this.e = java.util.Collections.singletonList(proxy);
        } else {
            java.util.List<java.net.Proxy> select = this.a.proxySelector().select(httpUrl.uri());
            this.e = (select == null || select.isEmpty()) ? okhttp3.internal.Util.immutableList(java.net.Proxy.NO_PROXY) : okhttp3.internal.Util.immutableList(select);
        }
        this.f = 0;
    }
}
