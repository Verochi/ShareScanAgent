package okhttp3;

/* loaded from: classes23.dex */
public final class Route {
    public final okhttp3.Address a;
    public final java.net.Proxy b;
    public final java.net.InetSocketAddress c;

    public Route(okhttp3.Address address, java.net.Proxy proxy, java.net.InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new java.lang.NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new java.lang.NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new java.lang.NullPointerException("inetSocketAddress == null");
        }
        this.a = address;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public okhttp3.Address address() {
        return this.a;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj instanceof okhttp3.Route) {
            okhttp3.Route route = (okhttp3.Route) obj;
            if (route.a.equals(this.a) && route.b.equals(this.b) && route.c.equals(this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public java.net.Proxy proxy() {
        return this.b;
    }

    public boolean requiresTunnel() {
        return this.a.i != null && this.b.type() == java.net.Proxy.Type.HTTP;
    }

    public java.net.InetSocketAddress socketAddress() {
        return this.c;
    }

    public java.lang.String toString() {
        return "Route{" + this.c + com.alipay.sdk.m.u.i.d;
    }
}
