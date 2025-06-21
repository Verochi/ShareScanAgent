package okhttp3.internal.http1;

/* loaded from: classes24.dex */
public final class Http1ExchangeCodec implements okhttp3.internal.http.ExchangeCodec {
    public final okhttp3.OkHttpClient a;
    public final okhttp3.internal.connection.RealConnection b;
    public final okio.BufferedSource c;
    public final okio.BufferedSink d;
    public int e = 0;
    public long f = android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    public okhttp3.Headers g;

    public abstract class AbstractSource implements okio.Source {
        public final okio.ForwardingTimeout n;
        public boolean t;

        public AbstractSource() {
            this.n = new okio.ForwardingTimeout(okhttp3.internal.http1.Http1ExchangeCodec.this.c.timeout());
        }

        public /* synthetic */ AbstractSource(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, okhttp3.internal.http1.Http1ExchangeCodec.AnonymousClass1 anonymousClass1) {
            this();
        }

        public final void a() {
            if (okhttp3.internal.http1.Http1ExchangeCodec.this.e == 6) {
                return;
            }
            if (okhttp3.internal.http1.Http1ExchangeCodec.this.e == 5) {
                okhttp3.internal.http1.Http1ExchangeCodec.this.k(this.n);
                okhttp3.internal.http1.Http1ExchangeCodec.this.e = 6;
            } else {
                throw new java.lang.IllegalStateException("state: " + okhttp3.internal.http1.Http1ExchangeCodec.this.e);
            }
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            try {
                return okhttp3.internal.http1.Http1ExchangeCodec.this.c.read(buffer, j);
            } catch (java.io.IOException e) {
                okhttp3.internal.http1.Http1ExchangeCodec.this.b.noNewExchanges();
                a();
                throw e;
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.n;
        }
    }

    public final class ChunkedSink implements okio.Sink {
        public final okio.ForwardingTimeout n;
        public boolean t;

        public ChunkedSink() {
            this.n = new okio.ForwardingTimeout(okhttp3.internal.http1.Http1ExchangeCodec.this.d.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws java.io.IOException {
            if (this.t) {
                return;
            }
            this.t = true;
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.writeUtf8("0\r\n\r\n");
            okhttp3.internal.http1.Http1ExchangeCodec.this.k(this.n);
            okhttp3.internal.http1.Http1ExchangeCodec.this.e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws java.io.IOException {
            if (this.t) {
                return;
            }
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.flush();
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.n;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            if (this.t) {
                throw new java.lang.IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.writeHexadecimalUnsignedLong(j);
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.writeUtf8("\r\n");
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.write(buffer, j);
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.writeUtf8("\r\n");
        }
    }

    public class ChunkedSource extends okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource {
        public final okhttp3.HttpUrl v;
        public long w;
        public boolean x;

        public ChunkedSource(okhttp3.HttpUrl httpUrl) {
            super(okhttp3.internal.http1.Http1ExchangeCodec.this, null);
            this.w = -1L;
            this.x = true;
            this.v = httpUrl;
        }

        public final void c() throws java.io.IOException {
            if (this.w != -1) {
                okhttp3.internal.http1.Http1ExchangeCodec.this.c.readUtf8LineStrict();
            }
            try {
                this.w = okhttp3.internal.http1.Http1ExchangeCodec.this.c.readHexadecimalUnsignedLong();
                java.lang.String trim = okhttp3.internal.http1.Http1ExchangeCodec.this.c.readUtf8LineStrict().trim();
                if (this.w < 0 || !(trim.isEmpty() || trim.startsWith(com.alipay.sdk.m.u.i.b))) {
                    throw new java.net.ProtocolException("expected chunk size and optional extensions but was \"" + this.w + trim + "\"");
                }
                if (this.w == 0) {
                    this.x = false;
                    okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec = okhttp3.internal.http1.Http1ExchangeCodec.this;
                    http1ExchangeCodec.g = http1ExchangeCodec.r();
                    okhttp3.internal.http.HttpHeaders.receiveHeaders(okhttp3.internal.http1.Http1ExchangeCodec.this.a.cookieJar(), this.v, okhttp3.internal.http1.Http1ExchangeCodec.this.g);
                    a();
                }
            } catch (java.lang.NumberFormatException e) {
                throw new java.net.ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.t) {
                return;
            }
            if (this.x && !okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                okhttp3.internal.http1.Http1ExchangeCodec.this.b.noNewExchanges();
                a();
            }
            this.t = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.t) {
                throw new java.lang.IllegalStateException("closed");
            }
            if (!this.x) {
                return -1L;
            }
            long j2 = this.w;
            if (j2 == 0 || j2 == -1) {
                c();
                if (!this.x) {
                    return -1L;
                }
            }
            long read = super.read(buffer, java.lang.Math.min(j, this.w));
            if (read != -1) {
                this.w -= read;
                return read;
            }
            okhttp3.internal.http1.Http1ExchangeCodec.this.b.noNewExchanges();
            java.net.ProtocolException protocolException = new java.net.ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
    }

    public class FixedLengthSource extends okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource {
        public long v;

        public FixedLengthSource(long j) {
            super(okhttp3.internal.http1.Http1ExchangeCodec.this, null);
            this.v = j;
            if (j == 0) {
                a();
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.t) {
                return;
            }
            if (this.v != 0 && !okhttp3.internal.Util.discard(this, 100, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                okhttp3.internal.http1.Http1ExchangeCodec.this.b.noNewExchanges();
                a();
            }
            this.t = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.t) {
                throw new java.lang.IllegalStateException("closed");
            }
            long j2 = this.v;
            if (j2 == 0) {
                return -1L;
            }
            long read = super.read(buffer, java.lang.Math.min(j2, j));
            if (read == -1) {
                okhttp3.internal.http1.Http1ExchangeCodec.this.b.noNewExchanges();
                java.net.ProtocolException protocolException = new java.net.ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
            long j3 = this.v - read;
            this.v = j3;
            if (j3 == 0) {
                a();
            }
            return read;
        }
    }

    public final class KnownLengthSink implements okio.Sink {
        public final okio.ForwardingTimeout n;
        public boolean t;

        public KnownLengthSink() {
            this.n = new okio.ForwardingTimeout(okhttp3.internal.http1.Http1ExchangeCodec.this.d.timeout());
        }

        public /* synthetic */ KnownLengthSink(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, okhttp3.internal.http1.Http1ExchangeCodec.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.t) {
                return;
            }
            this.t = true;
            okhttp3.internal.http1.Http1ExchangeCodec.this.k(this.n);
            okhttp3.internal.http1.Http1ExchangeCodec.this.e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            if (this.t) {
                return;
            }
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.flush();
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.n;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            if (this.t) {
                throw new java.lang.IllegalStateException("closed");
            }
            okhttp3.internal.Util.checkOffsetAndCount(buffer.size(), 0L, j);
            okhttp3.internal.http1.Http1ExchangeCodec.this.d.write(buffer, j);
        }
    }

    public class UnknownLengthSource extends okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource {
        public boolean v;

        public UnknownLengthSource() {
            super(okhttp3.internal.http1.Http1ExchangeCodec.this, null);
        }

        public /* synthetic */ UnknownLengthSource(okhttp3.internal.http1.Http1ExchangeCodec http1ExchangeCodec, okhttp3.internal.http1.Http1ExchangeCodec.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.t) {
                return;
            }
            if (!this.v) {
                a();
            }
            this.t = true;
        }

        @Override // okhttp3.internal.http1.Http1ExchangeCodec.AbstractSource, okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.t) {
                throw new java.lang.IllegalStateException("closed");
            }
            if (this.v) {
                return -1L;
            }
            long read = super.read(buffer, j);
            if (read != -1) {
                return read;
            }
            this.v = true;
            a();
            return -1L;
        }
    }

    public Http1ExchangeCodec(okhttp3.OkHttpClient okHttpClient, okhttp3.internal.connection.RealConnection realConnection, okio.BufferedSource bufferedSource, okio.BufferedSink bufferedSink) {
        this.a = okHttpClient;
        this.b = realConnection;
        this.c = bufferedSource;
        this.d = bufferedSink;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        okhttp3.internal.connection.RealConnection realConnection = this.b;
        if (realConnection != null) {
            realConnection.cancel();
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.internal.connection.RealConnection connection() {
        return this.b;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okio.Sink createRequestBody(okhttp3.Request request, long j) throws java.io.IOException {
        if (request.body() != null && request.body().isDuplex()) {
            throw new java.net.ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return l();
        }
        if (j != -1) {
            return o();
        }
        throw new java.lang.IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() throws java.io.IOException {
        this.d.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() throws java.io.IOException {
        this.d.flush();
    }

    public boolean isClosed() {
        return this.e == 6;
    }

    public final void k(okio.ForwardingTimeout forwardingTimeout) {
        okio.Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(okio.Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    public final okio.Sink l() {
        if (this.e == 1) {
            this.e = 2;
            return new okhttp3.internal.http1.Http1ExchangeCodec.ChunkedSink();
        }
        throw new java.lang.IllegalStateException("state: " + this.e);
    }

    public final okio.Source m(okhttp3.HttpUrl httpUrl) {
        if (this.e == 4) {
            this.e = 5;
            return new okhttp3.internal.http1.Http1ExchangeCodec.ChunkedSource(httpUrl);
        }
        throw new java.lang.IllegalStateException("state: " + this.e);
    }

    public final okio.Source n(long j) {
        if (this.e == 4) {
            this.e = 5;
            return new okhttp3.internal.http1.Http1ExchangeCodec.FixedLengthSource(j);
        }
        throw new java.lang.IllegalStateException("state: " + this.e);
    }

    public final okio.Sink o() {
        if (this.e == 1) {
            this.e = 2;
            return new okhttp3.internal.http1.Http1ExchangeCodec.KnownLengthSink(this, null);
        }
        throw new java.lang.IllegalStateException("state: " + this.e);
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okio.Source openResponseBodySource(okhttp3.Response response) {
        if (!okhttp3.internal.http.HttpHeaders.hasBody(response)) {
            return n(0L);
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return m(response.request().url());
        }
        long contentLength = okhttp3.internal.http.HttpHeaders.contentLength(response);
        return contentLength != -1 ? n(contentLength) : p();
    }

    public final okio.Source p() {
        if (this.e == 4) {
            this.e = 5;
            this.b.noNewExchanges();
            return new okhttp3.internal.http1.Http1ExchangeCodec.UnknownLengthSource(this, null);
        }
        throw new java.lang.IllegalStateException("state: " + this.e);
    }

    public final java.lang.String q() throws java.io.IOException {
        java.lang.String readUtf8LineStrict = this.c.readUtf8LineStrict(this.f);
        this.f -= readUtf8LineStrict.length();
        return readUtf8LineStrict;
    }

    public final okhttp3.Headers r() throws java.io.IOException {
        okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
        while (true) {
            java.lang.String q = q();
            if (q.length() == 0) {
                return builder.build();
            }
            okhttp3.internal.Internal.instance.addLenient(builder, q);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.Response.Builder readResponseHeaders(boolean z) throws java.io.IOException {
        int i = this.e;
        if (i != 1 && i != 3) {
            throw new java.lang.IllegalStateException("state: " + this.e);
        }
        try {
            okhttp3.internal.http.StatusLine parse = okhttp3.internal.http.StatusLine.parse(q());
            okhttp3.Response.Builder headers = new okhttp3.Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(r());
            if (z && parse.code == 100) {
                return null;
            }
            if (parse.code == 100) {
                this.e = 3;
                return headers;
            }
            this.e = 4;
            return headers;
        } catch (java.io.EOFException e) {
            okhttp3.internal.connection.RealConnection realConnection = this.b;
            throw new java.io.IOException("unexpected end of stream on " + (realConnection != null ? realConnection.route().address().url().redact() : "unknown"), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(okhttp3.Response response) {
        if (!okhttp3.internal.http.HttpHeaders.hasBody(response)) {
            return 0L;
        }
        if (com.ss.android.socialbase.downloader.utils.DownloadUtils.VALUE_CHUNKED.equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return -1L;
        }
        return okhttp3.internal.http.HttpHeaders.contentLength(response);
    }

    public void skipConnectBody(okhttp3.Response response) throws java.io.IOException {
        long contentLength = okhttp3.internal.http.HttpHeaders.contentLength(response);
        if (contentLength == -1) {
            return;
        }
        okio.Source n = n(contentLength);
        okhttp3.internal.Util.skipAll(n, Integer.MAX_VALUE, java.util.concurrent.TimeUnit.MILLISECONDS);
        n.close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public okhttp3.Headers trailers() {
        if (this.e != 6) {
            throw new java.lang.IllegalStateException("too early; can't read the trailers yet");
        }
        okhttp3.Headers headers = this.g;
        return headers != null ? headers : okhttp3.internal.Util.EMPTY_HEADERS;
    }

    public void writeRequest(okhttp3.Headers headers, java.lang.String str) throws java.io.IOException {
        if (this.e != 0) {
            throw new java.lang.IllegalStateException("state: " + this.e);
        }
        this.d.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.d.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.d.writeUtf8("\r\n");
        this.e = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException {
        writeRequest(request.headers(), okhttp3.internal.http.RequestLine.get(request, this.b.route().proxy().type()));
    }
}
