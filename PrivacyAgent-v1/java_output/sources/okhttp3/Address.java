package okhttp3;

/* loaded from: classes23.dex */
public final class Address {
    public final okhttp3.HttpUrl a;
    public final okhttp3.Dns b;
    public final javax.net.SocketFactory c;
    public final okhttp3.Authenticator d;
    public final java.util.List<okhttp3.Protocol> e;
    public final java.util.List<okhttp3.ConnectionSpec> f;
    public final java.net.ProxySelector g;

    @javax.annotation.Nullable
    public final java.net.Proxy h;

    @javax.annotation.Nullable
    public final javax.net.ssl.SSLSocketFactory i;

    @javax.annotation.Nullable
    public final javax.net.ssl.HostnameVerifier j;

    @javax.annotation.Nullable
    public final okhttp3.CertificatePinner k;

    public Address(java.lang.String str, int i, okhttp3.Dns dns, javax.net.SocketFactory socketFactory, @javax.annotation.Nullable javax.net.ssl.SSLSocketFactory sSLSocketFactory, @javax.annotation.Nullable javax.net.ssl.HostnameVerifier hostnameVerifier, @javax.annotation.Nullable okhttp3.CertificatePinner certificatePinner, okhttp3.Authenticator authenticator, @javax.annotation.Nullable java.net.Proxy proxy, java.util.List<okhttp3.Protocol> list, java.util.List<okhttp3.ConnectionSpec> list2, java.net.ProxySelector proxySelector) {
        this.a = new okhttp3.HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : com.alipay.sdk.m.l.a.q).host(str).port(i).build();
        if (dns == null) {
            throw new java.lang.NullPointerException("dns == null");
        }
        this.b = dns;
        if (socketFactory == null) {
            throw new java.lang.NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (authenticator == null) {
            throw new java.lang.NullPointerException("proxyAuthenticator == null");
        }
        this.d = authenticator;
        if (list == null) {
            throw new java.lang.NullPointerException("protocols == null");
        }
        this.e = okhttp3.internal.Util.immutableList(list);
        if (list2 == null) {
            throw new java.lang.NullPointerException("connectionSpecs == null");
        }
        this.f = okhttp3.internal.Util.immutableList(list2);
        if (proxySelector == null) {
            throw new java.lang.NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = certificatePinner;
    }

    public boolean a(okhttp3.Address address) {
        return this.b.equals(address.b) && this.d.equals(address.d) && this.e.equals(address.e) && this.f.equals(address.f) && this.g.equals(address.g) && java.util.Objects.equals(this.h, address.h) && java.util.Objects.equals(this.i, address.i) && java.util.Objects.equals(this.j, address.j) && java.util.Objects.equals(this.k, address.k) && url().port() == address.url().port();
    }

    @javax.annotation.Nullable
    public okhttp3.CertificatePinner certificatePinner() {
        return this.k;
    }

    public java.util.List<okhttp3.ConnectionSpec> connectionSpecs() {
        return this.f;
    }

    public okhttp3.Dns dns() {
        return this.b;
    }

    public boolean equals(@javax.annotation.Nullable java.lang.Object obj) {
        if (obj instanceof okhttp3.Address) {
            okhttp3.Address address = (okhttp3.Address) obj;
            if (this.a.equals(address.a) && a(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + java.util.Objects.hashCode(this.h)) * 31) + java.util.Objects.hashCode(this.i)) * 31) + java.util.Objects.hashCode(this.j)) * 31) + java.util.Objects.hashCode(this.k);
    }

    @javax.annotation.Nullable
    public javax.net.ssl.HostnameVerifier hostnameVerifier() {
        return this.j;
    }

    public java.util.List<okhttp3.Protocol> protocols() {
        return this.e;
    }

    @javax.annotation.Nullable
    public java.net.Proxy proxy() {
        return this.h;
    }

    public okhttp3.Authenticator proxyAuthenticator() {
        return this.d;
    }

    public java.net.ProxySelector proxySelector() {
        return this.g;
    }

    public javax.net.SocketFactory socketFactory() {
        return this.c;
    }

    @javax.annotation.Nullable
    public javax.net.ssl.SSLSocketFactory sslSocketFactory() {
        return this.i;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Address{");
        sb.append(this.a.host());
        sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        sb.append(this.a.port());
        if (this.h != null) {
            sb.append(", proxy=");
            sb.append(this.h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.g);
        }
        sb.append(com.alipay.sdk.m.u.i.d);
        return sb.toString();
    }

    public okhttp3.HttpUrl url() {
        return this.a;
    }
}
