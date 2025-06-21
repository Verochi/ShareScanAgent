package okhttp3;

/* loaded from: classes23.dex */
public final class Response implements java.io.Closeable {

    @javax.annotation.Nullable
    public final okhttp3.Response A;

    @javax.annotation.Nullable
    public final okhttp3.Response B;
    public final long C;
    public final long D;

    @javax.annotation.Nullable
    public final okhttp3.internal.connection.Exchange E;

    @javax.annotation.Nullable
    public volatile okhttp3.CacheControl F;
    public final okhttp3.Request n;
    public final okhttp3.Protocol t;
    public final int u;
    public final java.lang.String v;

    @javax.annotation.Nullable
    public final okhttp3.Handshake w;
    public final okhttp3.Headers x;

    @javax.annotation.Nullable
    public final okhttp3.ResponseBody y;

    @javax.annotation.Nullable
    public final okhttp3.Response z;

    public static class Builder {

        @javax.annotation.Nullable
        public okhttp3.Request a;

        @javax.annotation.Nullable
        public okhttp3.Protocol b;
        public int c;
        public java.lang.String d;

        @javax.annotation.Nullable
        public okhttp3.Handshake e;
        public okhttp3.Headers.Builder f;

        @javax.annotation.Nullable
        public okhttp3.ResponseBody g;

        @javax.annotation.Nullable
        public okhttp3.Response h;

        @javax.annotation.Nullable
        public okhttp3.Response i;

        @javax.annotation.Nullable
        public okhttp3.Response j;
        public long k;
        public long l;

        @javax.annotation.Nullable
        public okhttp3.internal.connection.Exchange m;

        public Builder() {
            this.c = -1;
            this.f = new okhttp3.Headers.Builder();
        }

        public Builder(okhttp3.Response response) {
            this.c = -1;
            this.a = response.n;
            this.b = response.t;
            this.c = response.u;
            this.d = response.v;
            this.e = response.w;
            this.f = response.x.newBuilder();
            this.g = response.y;
            this.h = response.z;
            this.i = response.A;
            this.j = response.B;
            this.k = response.C;
            this.l = response.D;
            this.m = response.E;
        }

        public final void a(okhttp3.Response response) {
            if (response.y != null) {
                throw new java.lang.IllegalArgumentException("priorResponse.body != null");
            }
        }

        public okhttp3.Response.Builder addHeader(java.lang.String str, java.lang.String str2) {
            this.f.add(str, str2);
            return this;
        }

        public final void b(java.lang.String str, okhttp3.Response response) {
            if (response.y != null) {
                throw new java.lang.IllegalArgumentException(str + ".body != null");
            }
            if (response.z != null) {
                throw new java.lang.IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.A != null) {
                throw new java.lang.IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.B == null) {
                return;
            }
            throw new java.lang.IllegalArgumentException(str + ".priorResponse != null");
        }

        public okhttp3.Response.Builder body(@javax.annotation.Nullable okhttp3.ResponseBody responseBody) {
            this.g = responseBody;
            return this;
        }

        public okhttp3.Response build() {
            if (this.a == null) {
                throw new java.lang.IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new java.lang.IllegalStateException("protocol == null");
            }
            if (this.c >= 0) {
                if (this.d != null) {
                    return new okhttp3.Response(this);
                }
                throw new java.lang.IllegalStateException("message == null");
            }
            throw new java.lang.IllegalStateException("code < 0: " + this.c);
        }

        public void c(okhttp3.internal.connection.Exchange exchange) {
            this.m = exchange;
        }

        public okhttp3.Response.Builder cacheResponse(@javax.annotation.Nullable okhttp3.Response response) {
            if (response != null) {
                b("cacheResponse", response);
            }
            this.i = response;
            return this;
        }

        public okhttp3.Response.Builder code(int i) {
            this.c = i;
            return this;
        }

        public okhttp3.Response.Builder handshake(@javax.annotation.Nullable okhttp3.Handshake handshake) {
            this.e = handshake;
            return this;
        }

        public okhttp3.Response.Builder header(java.lang.String str, java.lang.String str2) {
            this.f.set(str, str2);
            return this;
        }

        public okhttp3.Response.Builder headers(okhttp3.Headers headers) {
            this.f = headers.newBuilder();
            return this;
        }

        public okhttp3.Response.Builder message(java.lang.String str) {
            this.d = str;
            return this;
        }

        public okhttp3.Response.Builder networkResponse(@javax.annotation.Nullable okhttp3.Response response) {
            if (response != null) {
                b("networkResponse", response);
            }
            this.h = response;
            return this;
        }

        public okhttp3.Response.Builder priorResponse(@javax.annotation.Nullable okhttp3.Response response) {
            if (response != null) {
                a(response);
            }
            this.j = response;
            return this;
        }

        public okhttp3.Response.Builder protocol(okhttp3.Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public okhttp3.Response.Builder receivedResponseAtMillis(long j) {
            this.l = j;
            return this;
        }

        public okhttp3.Response.Builder removeHeader(java.lang.String str) {
            this.f.removeAll(str);
            return this;
        }

        public okhttp3.Response.Builder request(okhttp3.Request request) {
            this.a = request;
            return this;
        }

        public okhttp3.Response.Builder sentRequestAtMillis(long j) {
            this.k = j;
            return this;
        }
    }

    public Response(okhttp3.Response.Builder builder) {
        this.n = builder.a;
        this.t = builder.b;
        this.u = builder.c;
        this.v = builder.d;
        this.w = builder.e;
        this.x = builder.f.build();
        this.y = builder.g;
        this.z = builder.h;
        this.A = builder.i;
        this.B = builder.j;
        this.C = builder.k;
        this.D = builder.l;
        this.E = builder.m;
    }

    @javax.annotation.Nullable
    public okhttp3.ResponseBody body() {
        return this.y;
    }

    public okhttp3.CacheControl cacheControl() {
        okhttp3.CacheControl cacheControl = this.F;
        if (cacheControl != null) {
            return cacheControl;
        }
        okhttp3.CacheControl parse = okhttp3.CacheControl.parse(this.x);
        this.F = parse;
        return parse;
    }

    @javax.annotation.Nullable
    public okhttp3.Response cacheResponse() {
        return this.A;
    }

    public java.util.List<okhttp3.Challenge> challenges() {
        java.lang.String str;
        int i = this.u;
        if (i == 401) {
            str = com.google.common.net.HttpHeaders.WWW_AUTHENTICATE;
        } else {
            if (i != 407) {
                return java.util.Collections.emptyList();
            }
            str = com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.ResponseBody responseBody = this.y;
        if (responseBody == null) {
            throw new java.lang.IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.u;
    }

    @javax.annotation.Nullable
    public okhttp3.Handshake handshake() {
        return this.w;
    }

    @javax.annotation.Nullable
    public java.lang.String header(java.lang.String str) {
        return header(str, null);
    }

    @javax.annotation.Nullable
    public java.lang.String header(java.lang.String str, @javax.annotation.Nullable java.lang.String str2) {
        java.lang.String str3 = this.x.get(str);
        return str3 != null ? str3 : str2;
    }

    public java.util.List<java.lang.String> headers(java.lang.String str) {
        return this.x.values(str);
    }

    public okhttp3.Headers headers() {
        return this.x;
    }

    public boolean isRedirect() {
        int i = this.u;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.u;
        return i >= 200 && i < 300;
    }

    public java.lang.String message() {
        return this.v;
    }

    @javax.annotation.Nullable
    public okhttp3.Response networkResponse() {
        return this.z;
    }

    public okhttp3.Response.Builder newBuilder() {
        return new okhttp3.Response.Builder(this);
    }

    public okhttp3.ResponseBody peekBody(long j) throws java.io.IOException {
        okio.BufferedSource peek = this.y.source().peek();
        okio.Buffer buffer = new okio.Buffer();
        peek.request(j);
        buffer.write(peek, java.lang.Math.min(j, peek.getBuffer().size()));
        return okhttp3.ResponseBody.create(this.y.contentType(), buffer.size(), buffer);
    }

    @javax.annotation.Nullable
    public okhttp3.Response priorResponse() {
        return this.B;
    }

    public okhttp3.Protocol protocol() {
        return this.t;
    }

    public long receivedResponseAtMillis() {
        return this.D;
    }

    public okhttp3.Request request() {
        return this.n;
    }

    public long sentRequestAtMillis() {
        return this.C;
    }

    public java.lang.String toString() {
        return "Response{protocol=" + this.t + ", code=" + this.u + ", message=" + this.v + ", url=" + this.n.url() + '}';
    }

    public okhttp3.Headers trailers() throws java.io.IOException {
        okhttp3.internal.connection.Exchange exchange = this.E;
        if (exchange != null) {
            return exchange.trailers();
        }
        throw new java.lang.IllegalStateException("trailers not available");
    }
}
