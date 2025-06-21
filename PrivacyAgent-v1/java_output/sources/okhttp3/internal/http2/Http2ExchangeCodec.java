package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public final class Http2ExchangeCodec implements okhttp3.internal.http.ExchangeCodec {
    public static final java.util.List<java.lang.String> g = okhttp3.internal.Util.immutableList("connection", com.alipay.sdk.m.l.c.f, "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", okhttp3.internal.http2.Header.TARGET_METHOD_UTF8, okhttp3.internal.http2.Header.TARGET_PATH_UTF8, okhttp3.internal.http2.Header.TARGET_SCHEME_UTF8, okhttp3.internal.http2.Header.TARGET_AUTHORITY_UTF8);
    public static final java.util.List<java.lang.String> h = okhttp3.internal.Util.immutableList("connection", com.alipay.sdk.m.l.c.f, "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public final okhttp3.Interceptor.Chain a;
    public final okhttp3.internal.connection.RealConnection b;
    public final okhttp3.internal.http2.Http2Connection c;
    public volatile okhttp3.internal.http2.Http2Stream d;
    public final okhttp3.Protocol e;
    public volatile boolean f;

    public Http2ExchangeCodec(okhttp3.OkHttpClient okHttpClient, okhttp3.internal.connection.RealConnection realConnection, okhttp3.Interceptor.Chain chain, okhttp3.internal.http2.Http2Connection http2Connection) {
        this.b = realConnection;
        this.a = chain;
        this.c = http2Connection;
        java.util.List<okhttp3.Protocol> protocols = okHttpClient.protocols();
        okhttp3.Protocol protocol = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE;
        this.e = protocols.contains(protocol) ? protocol : okhttp3.Protocol.HTTP_2;
    }

    public static java.util.List<okhttp3.internal.http2.Header> http2HeadersList(okhttp3.Request request) {
        okhttp3.Headers headers = request.headers();
        java.util.ArrayList arrayList = new java.util.ArrayList(headers.size() + 4);
        arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_METHOD, request.method()));
        arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_PATH, okhttp3.internal.http.RequestLine.requestPath(request.url())));
        java.lang.String header = request.header("Host");
        if (header != null) {
            arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_AUTHORITY, header));
        }
        arrayList.add(new okhttp3.internal.http2.Header(okhttp3.internal.http2.Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            java.lang.String lowerCase = headers.name(i).toLowerCase(java.util.Locale.US);
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && headers.value(i).equals("trailers"))) {
                arrayList.add(new okhttp3.internal.http2.Header(lowerCase, headers.value(i)));
            }
        }
        return arrayList;
    }

    public static okhttp3.Response.Builder readHttp2HeadersList(okhttp3.Headers headers, okhttp3.Protocol protocol) throws java.io.IOException {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        int size = headers.size();
        okhttp3.internal.http.StatusLine statusLine = null;
        for (int i = 0; i < size; i++) {
            java.lang.String name = headers.name(i);
            java.lang.String value = headers.value(i);
            if (name.equals(okhttp3.internal.http2.Header.RESPONSE_STATUS_UTF8)) {
                statusLine = okhttp3.internal.http.StatusLine.parse("HTTP/1.1 " + value);
            } else if (!h.contains(name)) {
                okhttp3.internal.Internal.instance.addLenient(builder, name, value);
            }
        }
        if (statusLine != null) {
            return new okhttp3.Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
        }
        throw new java.net.ProtocolException("Expected ':status' header not present");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        this.f = true;
        if (this.d != null) {
            this.d.closeLater(okhttp3.internal.http2.ErrorCode.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.internal.connection.RealConnection connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okio.Sink createRequestBody(okhttp3.Request request, long j) {
        return this.d.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws java.io.IOException {
        this.d.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws java.io.IOException {
        this.c.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okio.Source openResponseBodySource(okhttp3.Response response) {
        return this.d.getSource();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.Response.Builder readResponseHeaders(boolean z) throws java.io.IOException {
        okhttp3.Response.Builder readHttp2HeadersList = readHttp2HeadersList(this.d.takeHeaders(), this.e);
        if (z && okhttp3.internal.Internal.instance.code(readHttp2HeadersList) == 100) {
            return null;
        }
        return readHttp2HeadersList;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(okhttp3.Response response) {
        return okhttp3.internal.http.HttpHeaders.contentLength(response);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.Headers trailers() throws java.io.IOException {
        return this.d.trailers();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException {
        if (this.d != null) {
            return;
        }
        this.d = this.c.newStream(http2HeadersList(request), request.body() != null);
        if (this.f) {
            this.d.closeLater(okhttp3.internal.http2.ErrorCode.CANCEL);
            throw new java.io.IOException("Canceled");
        }
        okio.Timeout readTimeout = this.d.readTimeout();
        long readTimeoutMillis = this.a.readTimeoutMillis();
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MILLISECONDS;
        readTimeout.timeout(readTimeoutMillis, timeUnit);
        this.d.writeTimeout().timeout(this.a.writeTimeoutMillis(), timeUnit);
    }
}
