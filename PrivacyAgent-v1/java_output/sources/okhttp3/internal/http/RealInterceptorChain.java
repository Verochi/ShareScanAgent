package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class RealInterceptorChain implements okhttp3.Interceptor.Chain {
    public final java.util.List<okhttp3.Interceptor> a;
    public final okhttp3.internal.connection.Transmitter b;

    @javax.annotation.Nullable
    public final okhttp3.internal.connection.Exchange c;
    public final int d;
    public final okhttp3.Request e;
    public final okhttp3.Call f;
    public final int g;
    public final int h;
    public final int i;
    public int j;

    public RealInterceptorChain(java.util.List<okhttp3.Interceptor> list, okhttp3.internal.connection.Transmitter transmitter, @javax.annotation.Nullable okhttp3.internal.connection.Exchange exchange, int i, okhttp3.Request request, okhttp3.Call call, int i2, int i3, int i4) {
        this.a = list;
        this.b = transmitter;
        this.c = exchange;
        this.d = i;
        this.e = request;
        this.f = call;
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Call call() {
        return this.f;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.g;
    }

    @Override // okhttp3.Interceptor.Chain
    @javax.annotation.Nullable
    public okhttp3.Connection connection() {
        okhttp3.internal.connection.Exchange exchange = this.c;
        if (exchange != null) {
            return exchange.connection();
        }
        return null;
    }

    public okhttp3.internal.connection.Exchange exchange() {
        okhttp3.internal.connection.Exchange exchange = this.c;
        if (exchange != null) {
            return exchange;
        }
        throw new java.lang.IllegalStateException();
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Response proceed(okhttp3.Request request) throws java.io.IOException {
        return proceed(request, this.b, this.c);
    }

    public okhttp3.Response proceed(okhttp3.Request request, okhttp3.internal.connection.Transmitter transmitter, @javax.annotation.Nullable okhttp3.internal.connection.Exchange exchange) throws java.io.IOException {
        if (this.d >= this.a.size()) {
            throw new java.lang.AssertionError();
        }
        this.j++;
        okhttp3.internal.connection.Exchange exchange2 = this.c;
        if (exchange2 != null && !exchange2.connection().supportsUrl(request.url())) {
            throw new java.lang.IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must retain the same host and port");
        }
        if (this.c != null && this.j > 1) {
            throw new java.lang.IllegalStateException("network interceptor " + this.a.get(this.d - 1) + " must call proceed() exactly once");
        }
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = new okhttp3.internal.http.RealInterceptorChain(this.a, transmitter, exchange, this.d + 1, request, this.f, this.g, this.h, this.i);
        okhttp3.Interceptor interceptor = this.a.get(this.d);
        okhttp3.Response intercept = interceptor.intercept(realInterceptorChain);
        if (exchange != null && this.d + 1 < this.a.size() && realInterceptorChain.j != 1) {
            throw new java.lang.IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
        }
        if (intercept == null) {
            throw new java.lang.NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (intercept.body() != null) {
            return intercept;
        }
        throw new java.lang.IllegalStateException("interceptor " + interceptor + " returned a response with no body");
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.h;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Request request() {
        return this.e;
    }

    public okhttp3.internal.connection.Transmitter transmitter() {
        return this.b;
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Interceptor.Chain withConnectTimeout(int i, java.util.concurrent.TimeUnit timeUnit) {
        return new okhttp3.internal.http.RealInterceptorChain(this.a, this.b, this.c, this.d, this.e, this.f, okhttp3.internal.Util.checkDuration("timeout", i, timeUnit), this.h, this.i);
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Interceptor.Chain withReadTimeout(int i, java.util.concurrent.TimeUnit timeUnit) {
        return new okhttp3.internal.http.RealInterceptorChain(this.a, this.b, this.c, this.d, this.e, this.f, this.g, okhttp3.internal.Util.checkDuration("timeout", i, timeUnit), this.i);
    }

    @Override // okhttp3.Interceptor.Chain
    public okhttp3.Interceptor.Chain withWriteTimeout(int i, java.util.concurrent.TimeUnit timeUnit) {
        return new okhttp3.internal.http.RealInterceptorChain(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, okhttp3.internal.Util.checkDuration("timeout", i, timeUnit));
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.i;
    }
}
