package okhttp3.internal.http;

/* loaded from: classes24.dex */
public final class CallServerInterceptor implements okhttp3.Interceptor {
    public final boolean a;

    public CallServerInterceptor(boolean z) {
        this.a = z;
    }

    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws java.io.IOException {
        boolean z;
        okhttp3.internal.http.RealInterceptorChain realInterceptorChain = (okhttp3.internal.http.RealInterceptorChain) chain;
        okhttp3.internal.connection.Exchange exchange = realInterceptorChain.exchange();
        okhttp3.Request request = realInterceptorChain.request();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        exchange.writeRequestHeaders(request);
        okhttp3.Response.Builder builder = null;
        if (!okhttp3.internal.http.HttpMethod.permitsRequestBody(request.method()) || request.body() == null) {
            exchange.noRequestBody();
            z = false;
        } else {
            if ("100-continue".equalsIgnoreCase(request.header(com.google.common.net.HttpHeaders.EXPECT))) {
                exchange.flushRequest();
                exchange.responseHeadersStart();
                builder = exchange.readResponseHeaders(true);
                z = true;
            } else {
                z = false;
            }
            if (builder != null) {
                exchange.noRequestBody();
                if (!exchange.connection().isMultiplexed()) {
                    exchange.noNewExchangesOnConnection();
                }
            } else if (request.body().isDuplex()) {
                exchange.flushRequest();
                request.body().writeTo(okio.Okio.buffer(exchange.createRequestBody(request, true)));
            } else {
                okio.BufferedSink buffer = okio.Okio.buffer(exchange.createRequestBody(request, false));
                request.body().writeTo(buffer);
                buffer.close();
            }
        }
        if (request.body() == null || !request.body().isDuplex()) {
            exchange.finishRequest();
        }
        if (!z) {
            exchange.responseHeadersStart();
        }
        if (builder == null) {
            builder = exchange.readResponseHeaders(false);
        }
        okhttp3.Response build = builder.request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
        int code = build.code();
        if (code == 100) {
            build = exchange.readResponseHeaders(false).request(request).handshake(exchange.connection().handshake()).sentRequestAtMillis(currentTimeMillis).receivedResponseAtMillis(java.lang.System.currentTimeMillis()).build();
            code = build.code();
        }
        exchange.responseHeadersEnd(build);
        okhttp3.Response build2 = (this.a && code == 101) ? build.newBuilder().body(okhttp3.internal.Util.EMPTY_RESPONSE).build() : build.newBuilder().body(exchange.openResponseBody(build)).build();
        if ("close".equalsIgnoreCase(build2.request().header(com.google.common.net.HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(build2.header(com.google.common.net.HttpHeaders.CONNECTION))) {
            exchange.noNewExchangesOnConnection();
        }
        if ((code != 204 && code != 205) || build2.body().contentLength() <= 0) {
            return build2;
        }
        throw new java.net.ProtocolException("HTTP " + code + " had non-zero Content-Length: " + build2.body().contentLength());
    }
}
