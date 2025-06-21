package okhttp3.internal.connection;

/* loaded from: classes23.dex */
public final class Exchange {
    public final okhttp3.internal.connection.Transmitter a;
    public final okhttp3.Call b;
    public final okhttp3.EventListener c;
    public final okhttp3.internal.connection.ExchangeFinder d;
    public final okhttp3.internal.http.ExchangeCodec e;
    public boolean f;

    public final class RequestBodySink extends okio.ForwardingSink {
        public boolean n;
        public long t;
        public long u;
        public boolean v;

        public RequestBodySink(okio.Sink sink, long j) {
            super(sink);
            this.t = j;
        }

        @javax.annotation.Nullable
        public final java.io.IOException a(@javax.annotation.Nullable java.io.IOException iOException) {
            if (this.n) {
                return iOException;
            }
            this.n = true;
            return okhttp3.internal.connection.Exchange.this.a(this.u, false, true, iOException);
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.v) {
                return;
            }
            this.v = true;
            long j = this.t;
            if (j != -1 && this.u != j) {
                throw new java.net.ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (java.io.IOException e) {
                throw a(e);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            try {
                super.flush();
            } catch (java.io.IOException e) {
                throw a(e);
            }
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            if (this.v) {
                throw new java.lang.IllegalStateException("closed");
            }
            long j2 = this.t;
            if (j2 == -1 || this.u + j <= j2) {
                try {
                    super.write(buffer, j);
                    this.u += j;
                    return;
                } catch (java.io.IOException e) {
                    throw a(e);
                }
            }
            throw new java.net.ProtocolException("expected " + this.t + " bytes but received " + (this.u + j));
        }
    }

    public final class ResponseBodySource extends okio.ForwardingSource {
        public final long n;
        public long t;
        public boolean u;
        public boolean v;

        public ResponseBodySource(okio.Source source, long j) {
            super(source);
            this.n = j;
            if (j == 0) {
                a(null);
            }
        }

        @javax.annotation.Nullable
        public java.io.IOException a(@javax.annotation.Nullable java.io.IOException iOException) {
            if (this.u) {
                return iOException;
            }
            this.u = true;
            return okhttp3.internal.connection.Exchange.this.a(this.t, true, false, iOException);
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.v) {
                return;
            }
            this.v = true;
            try {
                super.close();
                a(null);
            } catch (java.io.IOException e) {
                throw a(e);
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            if (this.v) {
                throw new java.lang.IllegalStateException("closed");
            }
            try {
                long read = delegate().read(buffer, j);
                if (read == -1) {
                    a(null);
                    return -1L;
                }
                long j2 = this.t + read;
                long j3 = this.n;
                if (j3 != -1 && j2 > j3) {
                    throw new java.net.ProtocolException("expected " + this.n + " bytes but received " + j2);
                }
                this.t = j2;
                if (j2 == j3) {
                    a(null);
                }
                return read;
            } catch (java.io.IOException e) {
                throw a(e);
            }
        }
    }

    public Exchange(okhttp3.internal.connection.Transmitter transmitter, okhttp3.Call call, okhttp3.EventListener eventListener, okhttp3.internal.connection.ExchangeFinder exchangeFinder, okhttp3.internal.http.ExchangeCodec exchangeCodec) {
        this.a = transmitter;
        this.b = call;
        this.c = eventListener;
        this.d = exchangeFinder;
        this.e = exchangeCodec;
    }

    @javax.annotation.Nullable
    public java.io.IOException a(long j, boolean z, boolean z2, @javax.annotation.Nullable java.io.IOException iOException) {
        if (iOException != null) {
            b(iOException);
        }
        if (z2) {
            if (iOException != null) {
                this.c.requestFailed(this.b, iOException);
            } else {
                this.c.requestBodyEnd(this.b, j);
            }
        }
        if (z) {
            if (iOException != null) {
                this.c.responseFailed(this.b, iOException);
            } else {
                this.c.responseBodyEnd(this.b, j);
            }
        }
        return this.a.c(this, z2, z, iOException);
    }

    public void b(java.io.IOException iOException) {
        this.d.h();
        this.e.connection().l(iOException);
    }

    public void cancel() {
        this.e.cancel();
    }

    public okhttp3.internal.connection.RealConnection connection() {
        return this.e.connection();
    }

    public okio.Sink createRequestBody(okhttp3.Request request, boolean z) throws java.io.IOException {
        this.f = z;
        long contentLength = request.body().contentLength();
        this.c.requestBodyStart(this.b);
        return new okhttp3.internal.connection.Exchange.RequestBodySink(this.e.createRequestBody(request, contentLength), contentLength);
    }

    public void detachWithViolence() {
        this.e.cancel();
        this.a.c(this, true, true, null);
    }

    public void finishRequest() throws java.io.IOException {
        try {
            this.e.finishRequest();
        } catch (java.io.IOException e) {
            this.c.requestFailed(this.b, e);
            b(e);
            throw e;
        }
    }

    public void flushRequest() throws java.io.IOException {
        try {
            this.e.flushRequest();
        } catch (java.io.IOException e) {
            this.c.requestFailed(this.b, e);
            b(e);
            throw e;
        }
    }

    public boolean isDuplex() {
        return this.f;
    }

    public okhttp3.internal.ws.RealWebSocket.Streams newWebSocketStreams() throws java.net.SocketException {
        this.a.timeoutEarlyExit();
        return this.e.connection().i(this);
    }

    public void noNewExchangesOnConnection() {
        this.e.connection().noNewExchanges();
    }

    public void noRequestBody() {
        this.a.c(this, true, false, null);
    }

    public okhttp3.ResponseBody openResponseBody(okhttp3.Response response) throws java.io.IOException {
        try {
            this.c.responseBodyStart(this.b);
            java.lang.String header = response.header("Content-Type");
            long reportedContentLength = this.e.reportedContentLength(response);
            return new okhttp3.internal.http.RealResponseBody(header, reportedContentLength, okio.Okio.buffer(new okhttp3.internal.connection.Exchange.ResponseBodySource(this.e.openResponseBodySource(response), reportedContentLength)));
        } catch (java.io.IOException e) {
            this.c.responseFailed(this.b, e);
            b(e);
            throw e;
        }
    }

    @javax.annotation.Nullable
    public okhttp3.Response.Builder readResponseHeaders(boolean z) throws java.io.IOException {
        try {
            okhttp3.Response.Builder readResponseHeaders = this.e.readResponseHeaders(z);
            if (readResponseHeaders != null) {
                okhttp3.internal.Internal.instance.initExchange(readResponseHeaders, this);
            }
            return readResponseHeaders;
        } catch (java.io.IOException e) {
            this.c.responseFailed(this.b, e);
            b(e);
            throw e;
        }
    }

    public void responseHeadersEnd(okhttp3.Response response) {
        this.c.responseHeadersEnd(this.b, response);
    }

    public void responseHeadersStart() {
        this.c.responseHeadersStart(this.b);
    }

    public void timeoutEarlyExit() {
        this.a.timeoutEarlyExit();
    }

    public okhttp3.Headers trailers() throws java.io.IOException {
        return this.e.trailers();
    }

    public void webSocketUpgradeFailed() {
        a(-1L, true, true, null);
    }

    public void writeRequestHeaders(okhttp3.Request request) throws java.io.IOException {
        try {
            this.c.requestHeadersStart(this.b);
            this.e.writeRequestHeaders(request);
            this.c.requestHeadersEnd(this.b, request);
        } catch (java.io.IOException e) {
            this.c.requestFailed(this.b, e);
            b(e);
            throw e;
        }
    }
}
