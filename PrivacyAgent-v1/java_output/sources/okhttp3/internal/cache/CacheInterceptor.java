package okhttp3.internal.cache;

/* loaded from: classes23.dex */
public final class CacheInterceptor implements okhttp3.Interceptor {

    @javax.annotation.Nullable
    public final okhttp3.internal.cache.InternalCache a;

    /* renamed from: okhttp3.internal.cache.CacheInterceptor$1, reason: invalid class name */
    public class AnonymousClass1 implements okio.Source {
        public boolean n;
        public final /* synthetic */ okio.BufferedSource t;
        public final /* synthetic */ okhttp3.internal.cache.CacheRequest u;
        public final /* synthetic */ okio.BufferedSink v;

        public AnonymousClass1(okio.BufferedSource bufferedSource, okhttp3.internal.cache.CacheRequest cacheRequest, okio.BufferedSink bufferedSink) {
            this.t = bufferedSource;
            this.u = cacheRequest;
            this.v = bufferedSink;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (!this.n && !okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                this.n = true;
                this.u.abort();
            }
            this.t.close();
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            try {
                long read = this.t.read(buffer, j);
                if (read != -1) {
                    buffer.copyTo(this.v.buffer(), buffer.size() - read, read);
                    this.v.emitCompleteSegments();
                    return read;
                }
                if (!this.n) {
                    this.n = true;
                    this.v.close();
                }
                return -1L;
            } catch (java.io.IOException e) {
                if (!this.n) {
                    this.n = true;
                    this.u.abort();
                }
                throw e;
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.t.timeout();
        }
    }

    public CacheInterceptor(@javax.annotation.Nullable okhttp3.internal.cache.InternalCache internalCache) {
        this.a = internalCache;
    }

    public static okhttp3.Headers b(okhttp3.Headers headers, okhttp3.Headers headers2) {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String name = headers.name(i);
            java.lang.String value = headers.value(i);
            if ((!com.google.common.net.HttpHeaders.WARNING.equalsIgnoreCase(name) || !value.startsWith("1")) && (c(name) || !d(name) || headers2.get(name) == null)) {
                okhttp3.internal.Internal.instance.addLenient(builder, name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            java.lang.String name2 = headers2.name(i2);
            if (!c(name2) && d(name2)) {
                okhttp3.internal.Internal.instance.addLenient(builder, name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    public static boolean c(java.lang.String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public static boolean d(java.lang.String str) {
        return (com.google.common.net.HttpHeaders.CONNECTION.equalsIgnoreCase(str) || com.anythink.expressad.foundation.g.f.g.b.c.equalsIgnoreCase(str) || com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || com.google.common.net.HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || com.google.common.net.HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || com.google.common.net.HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    public static okhttp3.Response e(okhttp3.Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    public final okhttp3.Response a(okhttp3.internal.cache.CacheRequest cacheRequest, okhttp3.Response response) throws java.io.IOException {
        okio.Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        return response.newBuilder().body(new okhttp3.internal.http.RealResponseBody(response.header("Content-Type"), response.body().contentLength(), okio.Okio.buffer(new okhttp3.internal.cache.CacheInterceptor.AnonymousClass1(response.body().source(), cacheRequest, okio.Okio.buffer(body))))).build();
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        okhttp3.internal.cache.InternalCache internalCache = this.a;
        okhttp3.Response response = internalCache != null ? internalCache.get(chain.request()) : null;
        okhttp3.internal.cache.CacheStrategy cacheStrategy = new okhttp3.internal.cache.CacheStrategy.Factory(java.lang.System.currentTimeMillis(), chain.request(), response).get();
        okhttp3.Request request = cacheStrategy.networkRequest;
        okhttp3.Response response2 = cacheStrategy.cacheResponse;
        okhttp3.internal.cache.InternalCache internalCache2 = this.a;
        if (internalCache2 != null) {
            internalCache2.trackResponse(cacheStrategy);
        }
        if (response != null && response2 == null) {
            okhttp3.internal.Util.closeQuietly(response.body());
        }
        if (request == null && response2 == null) {
            return new okhttp3.Response.Builder().request(chain.request()).protocol(okhttp3.Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(okhttp3.internal.Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
        }
        if (request == null) {
            return response2.newBuilder().cacheResponse(e(response2)).build();
        }
        try {
            okhttp3.Response proceed = chain.proceed(request);
            if (proceed == null && response != null) {
            }
            if (response2 != null) {
                if (proceed.code() == 304) {
                    okhttp3.Response build = response2.newBuilder().headers(b(response2.headers(), proceed.headers())).sentRequestAtMillis(proceed.sentRequestAtMillis()).receivedResponseAtMillis(proceed.receivedResponseAtMillis()).cacheResponse(e(response2)).networkResponse(e(proceed)).build();
                    proceed.body().close();
                    this.a.trackConditionalCacheHit();
                    this.a.update(response2, build);
                    return build;
                }
                okhttp3.internal.Util.closeQuietly(response2.body());
            }
            okhttp3.Response build2 = proceed.newBuilder().cacheResponse(e(response2)).networkResponse(e(proceed)).build();
            if (this.a != null) {
                if (okhttp3.internal.http.HttpHeaders.hasBody(build2) && okhttp3.internal.cache.CacheStrategy.isCacheable(build2, request)) {
                    return a(this.a.put(build2), build2);
                }
                if (okhttp3.internal.http.HttpMethod.invalidatesCache(request.method())) {
                    try {
                        this.a.remove(request);
                    } catch (java.io.IOException unused) {
                    }
                }
            }
            return build2;
        } finally {
            if (response != null) {
                okhttp3.internal.Util.closeQuietly(response.body());
            }
        }
    }
}
