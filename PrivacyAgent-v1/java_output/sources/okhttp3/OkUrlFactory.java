package okhttp3;

@okhttp3.internal.annotations.EverythingIsNonNull
/* loaded from: classes23.dex */
public final class OkUrlFactory implements java.net.URLStreamHandlerFactory, java.lang.Cloneable {
    public okhttp3.OkHttpClient n;
    public okhttp3.internal.URLFilter t;

    /* renamed from: okhttp3.OkUrlFactory$1, reason: invalid class name */
    public class AnonymousClass1 extends java.net.URLStreamHandler {
        public final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // java.net.URLStreamHandler
        public int getDefaultPort() {
            if (this.a.equals(com.alipay.sdk.m.l.a.q)) {
                return 80;
            }
            if (this.a.equals("https")) {
                return 443;
            }
            throw new java.lang.AssertionError();
        }

        @Override // java.net.URLStreamHandler
        public java.net.URLConnection openConnection(java.net.URL url) {
            return okhttp3.OkUrlFactory.this.open(url);
        }

        @Override // java.net.URLStreamHandler
        public java.net.URLConnection openConnection(java.net.URL url, java.net.Proxy proxy) {
            return okhttp3.OkUrlFactory.this.a(url, proxy);
        }
    }

    public OkUrlFactory(okhttp3.OkHttpClient okHttpClient) {
        this.n = okHttpClient;
    }

    public java.net.HttpURLConnection a(java.net.URL url, java.net.Proxy proxy) {
        java.lang.String protocol = url.getProtocol();
        okhttp3.OkHttpClient build = this.n.newBuilder().proxy(proxy).build();
        if (protocol.equals(com.alipay.sdk.m.l.a.q)) {
            return new okhttp3.internal.huc.OkHttpURLConnection(url, build, this.t);
        }
        if (protocol.equals("https")) {
            return new okhttp3.internal.huc.OkHttpsURLConnection(url, build, this.t);
        }
        throw new java.lang.IllegalArgumentException("Unexpected protocol: " + protocol);
    }

    public okhttp3.OkHttpClient client() {
        return this.n;
    }

    public okhttp3.OkUrlFactory clone() {
        return new okhttp3.OkUrlFactory(this.n);
    }

    @Override // java.net.URLStreamHandlerFactory
    public java.net.URLStreamHandler createURLStreamHandler(java.lang.String str) {
        if (str.equals(com.alipay.sdk.m.l.a.q) || str.equals("https")) {
            return new okhttp3.OkUrlFactory.AnonymousClass1(str);
        }
        return null;
    }

    public java.net.HttpURLConnection open(java.net.URL url) {
        return a(url, this.n.proxy());
    }

    public okhttp3.OkUrlFactory setClient(okhttp3.OkHttpClient okHttpClient) {
        this.n = okHttpClient;
        return this;
    }
}
