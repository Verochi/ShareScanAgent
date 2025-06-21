package okhttp3.internal.http2;

/* loaded from: classes24.dex */
public final class Http2Stream {
    public long a = 0;
    public long b;
    public final int c;
    public final okhttp3.internal.http2.Http2Connection d;
    public final java.util.Deque<okhttp3.Headers> e;
    public boolean f;
    public final okhttp3.internal.http2.Http2Stream.FramingSource g;
    public final okhttp3.internal.http2.Http2Stream.FramingSink h;
    public final okhttp3.internal.http2.Http2Stream.StreamTimeout i;
    public final okhttp3.internal.http2.Http2Stream.StreamTimeout j;

    @javax.annotation.Nullable
    public okhttp3.internal.http2.ErrorCode k;

    @javax.annotation.Nullable
    public java.io.IOException l;

    public final class FramingSink implements okio.Sink {
        public final okio.Buffer n = new okio.Buffer();
        public okhttp3.Headers t;
        public boolean u;
        public boolean v;

        public FramingSink() {
        }

        public final void b(boolean z) throws java.io.IOException {
            okhttp3.internal.http2.Http2Stream http2Stream;
            long min;
            okhttp3.internal.http2.Http2Stream http2Stream2;
            boolean z2;
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                okhttp3.internal.http2.Http2Stream.this.j.enter();
                while (true) {
                    try {
                        http2Stream = okhttp3.internal.http2.Http2Stream.this;
                        if (http2Stream.b > 0 || this.v || this.u || http2Stream.k != null) {
                            break;
                        } else {
                            http2Stream.h();
                        }
                    } finally {
                        okhttp3.internal.http2.Http2Stream.this.j.a();
                    }
                }
                http2Stream.j.a();
                okhttp3.internal.http2.Http2Stream.this.c();
                min = java.lang.Math.min(okhttp3.internal.http2.Http2Stream.this.b, this.n.size());
                http2Stream2 = okhttp3.internal.http2.Http2Stream.this;
                http2Stream2.b -= min;
            }
            http2Stream2.j.enter();
            if (z) {
                try {
                    if (min == this.n.size()) {
                        z2 = true;
                        okhttp3.internal.http2.Http2Stream http2Stream3 = okhttp3.internal.http2.Http2Stream.this;
                        http2Stream3.d.writeData(http2Stream3.c, z2, this.n, min);
                    }
                } catch (java.lang.Throwable th) {
                    throw th;
                }
            }
            z2 = false;
            okhttp3.internal.http2.Http2Stream http2Stream32 = okhttp3.internal.http2.Http2Stream.this;
            http2Stream32.d.writeData(http2Stream32.c, z2, this.n, min);
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                if (this.u) {
                    return;
                }
                if (!okhttp3.internal.http2.Http2Stream.this.h.v) {
                    boolean z = this.n.size() > 0;
                    if (this.t != null) {
                        while (this.n.size() > 0) {
                            b(false);
                        }
                        okhttp3.internal.http2.Http2Stream http2Stream = okhttp3.internal.http2.Http2Stream.this;
                        http2Stream.d.B(http2Stream.c, true, okhttp3.internal.Util.toHeaderBlock(this.t));
                    } else if (z) {
                        while (this.n.size() > 0) {
                            b(true);
                        }
                    } else {
                        okhttp3.internal.http2.Http2Stream http2Stream2 = okhttp3.internal.http2.Http2Stream.this;
                        http2Stream2.d.writeData(http2Stream2.c, true, null, 0L);
                    }
                }
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    this.u = true;
                }
                okhttp3.internal.http2.Http2Stream.this.d.flush();
                okhttp3.internal.http2.Http2Stream.this.b();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                okhttp3.internal.http2.Http2Stream.this.c();
            }
            while (this.n.size() > 0) {
                b(false);
                okhttp3.internal.http2.Http2Stream.this.d.flush();
            }
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return okhttp3.internal.http2.Http2Stream.this.j;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            this.n.write(buffer, j);
            while (this.n.size() >= 16384) {
                b(false);
            }
        }
    }

    public final class FramingSource implements okio.Source {
        public final okio.Buffer n = new okio.Buffer();
        public final okio.Buffer t = new okio.Buffer();
        public final long u;
        public okhttp3.Headers v;
        public boolean w;
        public boolean x;

        public FramingSource(long j) {
            this.u = j;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            long size;
            synchronized (okhttp3.internal.http2.Http2Stream.this) {
                this.w = true;
                size = this.t.size();
                this.t.clear();
                okhttp3.internal.http2.Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                f(size);
            }
            okhttp3.internal.http2.Http2Stream.this.b();
        }

        public void e(okio.BufferedSource bufferedSource, long j) throws java.io.IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long j2;
            while (j > 0) {
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    z = this.x;
                    z2 = true;
                    z3 = this.t.size() + j > this.u;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    okhttp3.internal.http2.Http2Stream.this.closeLater(okhttp3.internal.http2.ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long read = bufferedSource.read(this.n, j);
                if (read == -1) {
                    throw new java.io.EOFException();
                }
                j -= read;
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    if (this.w) {
                        j2 = this.n.size();
                        this.n.clear();
                    } else {
                        if (this.t.size() != 0) {
                            z2 = false;
                        }
                        this.t.writeAll(this.n);
                        if (z2) {
                            okhttp3.internal.http2.Http2Stream.this.notifyAll();
                        }
                        j2 = 0;
                    }
                }
                if (j2 > 0) {
                    f(j2);
                }
            }
        }

        public final void f(long j) {
            okhttp3.internal.http2.Http2Stream.this.d.A(j);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
        
            r11 = -1;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            java.lang.Throwable th;
            long read;
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                synchronized (okhttp3.internal.http2.Http2Stream.this) {
                    okhttp3.internal.http2.Http2Stream.this.i.enter();
                    try {
                        okhttp3.internal.http2.Http2Stream http2Stream = okhttp3.internal.http2.Http2Stream.this;
                        if (http2Stream.k != null) {
                            th = http2Stream.l;
                            if (th == null) {
                                th = new okhttp3.internal.http2.StreamResetException(okhttp3.internal.http2.Http2Stream.this.k);
                            }
                        } else {
                            th = null;
                        }
                        if (this.w) {
                            throw new java.io.IOException("stream closed");
                        }
                        if (this.t.size() > 0) {
                            okio.Buffer buffer2 = this.t;
                            read = buffer2.read(buffer, java.lang.Math.min(j, buffer2.size()));
                            okhttp3.internal.http2.Http2Stream http2Stream2 = okhttp3.internal.http2.Http2Stream.this;
                            long j2 = http2Stream2.a + read;
                            http2Stream2.a = j2;
                            if (th == null && j2 >= http2Stream2.d.L.d() / 2) {
                                okhttp3.internal.http2.Http2Stream http2Stream3 = okhttp3.internal.http2.Http2Stream.this;
                                http2Stream3.d.F(http2Stream3.c, http2Stream3.a);
                                okhttp3.internal.http2.Http2Stream.this.a = 0L;
                            }
                        } else {
                            if (this.x || th != null) {
                                break;
                            }
                            okhttp3.internal.http2.Http2Stream.this.h();
                        }
                    } finally {
                        okhttp3.internal.http2.Http2Stream.this.i.a();
                    }
                }
                if (read == -1) {
                    f(read);
                    return read;
                }
                if (th == null) {
                    return -1L;
                }
                throw th;
            }
            if (read == -1) {
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return okhttp3.internal.http2.Http2Stream.this.i;
        }
    }

    public class StreamTimeout extends okio.AsyncTimeout {
        public StreamTimeout() {
        }

        public void a() throws java.io.IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        public java.io.IOException newTimeoutException(java.io.IOException iOException) {
            java.net.SocketTimeoutException socketTimeoutException = new java.net.SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            okhttp3.internal.http2.Http2Stream.this.closeLater(okhttp3.internal.http2.ErrorCode.CANCEL);
            okhttp3.internal.http2.Http2Stream.this.d.y();
        }
    }

    public Http2Stream(int i, okhttp3.internal.http2.Http2Connection http2Connection, boolean z, boolean z2, @javax.annotation.Nullable okhttp3.Headers headers) {
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        this.e = arrayDeque;
        this.i = new okhttp3.internal.http2.Http2Stream.StreamTimeout();
        this.j = new okhttp3.internal.http2.Http2Stream.StreamTimeout();
        if (http2Connection == null) {
            throw new java.lang.NullPointerException("connection == null");
        }
        this.c = i;
        this.d = http2Connection;
        this.b = http2Connection.M.d();
        okhttp3.internal.http2.Http2Stream.FramingSource framingSource = new okhttp3.internal.http2.Http2Stream.FramingSource(http2Connection.L.d());
        this.g = framingSource;
        okhttp3.internal.http2.Http2Stream.FramingSink framingSink = new okhttp3.internal.http2.Http2Stream.FramingSink();
        this.h = framingSink;
        framingSource.x = z2;
        framingSink.v = z;
        if (headers != null) {
            arrayDeque.add(headers);
        }
        if (isLocallyInitiated() && headers != null) {
            throw new java.lang.IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!isLocallyInitiated() && headers == null) {
            throw new java.lang.IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    public void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void b() throws java.io.IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            okhttp3.internal.http2.Http2Stream.FramingSource framingSource = this.g;
            if (!framingSource.x && framingSource.w) {
                okhttp3.internal.http2.Http2Stream.FramingSink framingSink = this.h;
                if (framingSink.v || framingSink.u) {
                    z = true;
                    isOpen = isOpen();
                }
            }
            z = false;
            isOpen = isOpen();
        }
        if (z) {
            close(okhttp3.internal.http2.ErrorCode.CANCEL, null);
        } else {
            if (isOpen) {
                return;
            }
            this.d.x(this.c);
        }
    }

    public void c() throws java.io.IOException {
        okhttp3.internal.http2.Http2Stream.FramingSink framingSink = this.h;
        if (framingSink.u) {
            throw new java.io.IOException("stream closed");
        }
        if (framingSink.v) {
            throw new java.io.IOException("stream finished");
        }
        if (this.k != null) {
            java.io.IOException iOException = this.l;
            if (iOException == null) {
                throw new okhttp3.internal.http2.StreamResetException(this.k);
            }
        }
    }

    public void close(okhttp3.internal.http2.ErrorCode errorCode, @javax.annotation.Nullable java.io.IOException iOException) throws java.io.IOException {
        if (d(errorCode, iOException)) {
            this.d.D(this.c, errorCode);
        }
    }

    public void closeLater(okhttp3.internal.http2.ErrorCode errorCode) {
        if (d(errorCode, null)) {
            this.d.E(this.c, errorCode);
        }
    }

    public final boolean d(okhttp3.internal.http2.ErrorCode errorCode, @javax.annotation.Nullable java.io.IOException iOException) {
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.x && this.h.v) {
                return false;
            }
            this.k = errorCode;
            this.l = iOException;
            notifyAll();
            this.d.x(this.c);
            return true;
        }
    }

    public void e(okio.BufferedSource bufferedSource, int i) throws java.io.IOException {
        this.g.e(bufferedSource, i);
    }

    public void enqueueTrailers(okhttp3.Headers headers) {
        synchronized (this) {
            if (this.h.v) {
                throw new java.lang.IllegalStateException("already finished");
            }
            if (headers.size() == 0) {
                throw new java.lang.IllegalArgumentException("trailers.size() == 0");
            }
            this.h.t = headers;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0009, B:9:0x0018, B:10:0x001c, B:11:0x0023, B:18:0x000f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(okhttp3.Headers headers, boolean z) {
        boolean isOpen;
        synchronized (this) {
            if (this.f && z) {
                this.g.v = headers;
                if (z) {
                    this.g.x = true;
                }
                isOpen = isOpen();
                notifyAll();
            }
            this.f = true;
            this.e.add(headers);
            if (z) {
            }
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.d.x(this.c);
    }

    public synchronized void g(okhttp3.internal.http2.ErrorCode errorCode) {
        if (this.k == null) {
            this.k = errorCode;
            notifyAll();
        }
    }

    public okhttp3.internal.http2.Http2Connection getConnection() {
        return this.d;
    }

    public synchronized okhttp3.internal.http2.ErrorCode getErrorCode() {
        return this.k;
    }

    public int getId() {
        return this.c;
    }

    public okio.Sink getSink() {
        synchronized (this) {
            if (!this.f && !isLocallyInitiated()) {
                throw new java.lang.IllegalStateException("reply before requesting the sink");
            }
        }
        return this.h;
    }

    public okio.Source getSource() {
        return this.g;
    }

    public void h() throws java.io.InterruptedIOException {
        try {
            wait();
        } catch (java.lang.InterruptedException unused) {
            java.lang.Thread.currentThread().interrupt();
            throw new java.io.InterruptedIOException();
        }
    }

    public boolean isLocallyInitiated() {
        return this.d.n == ((this.c & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.k != null) {
            return false;
        }
        okhttp3.internal.http2.Http2Stream.FramingSource framingSource = this.g;
        if (framingSource.x || framingSource.w) {
            okhttp3.internal.http2.Http2Stream.FramingSink framingSink = this.h;
            if (framingSink.v || framingSink.u) {
                if (this.f) {
                    return false;
                }
            }
        }
        return true;
    }

    public okio.Timeout readTimeout() {
        return this.i;
    }

    public synchronized okhttp3.Headers takeHeaders() throws java.io.IOException {
        this.i.enter();
        while (this.e.isEmpty() && this.k == null) {
            try {
                h();
            } catch (java.lang.Throwable th) {
                this.i.a();
                throw th;
            }
        }
        this.i.a();
        if (this.e.isEmpty()) {
            java.io.IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new okhttp3.internal.http2.StreamResetException(this.k);
        }
        return this.e.removeFirst();
    }

    public synchronized okhttp3.Headers trailers() throws java.io.IOException {
        if (this.k != null) {
            java.io.IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            throw new okhttp3.internal.http2.StreamResetException(this.k);
        }
        okhttp3.internal.http2.Http2Stream.FramingSource framingSource = this.g;
        if (!framingSource.x || !framingSource.n.exhausted() || !this.g.t.exhausted()) {
            throw new java.lang.IllegalStateException("too early; can't read the trailers yet");
        }
        return this.g.v != null ? this.g.v : okhttp3.internal.Util.EMPTY_HEADERS;
    }

    public void writeHeaders(java.util.List<okhttp3.internal.http2.Header> list, boolean z, boolean z2) throws java.io.IOException {
        if (list == null) {
            throw new java.lang.NullPointerException("headers == null");
        }
        synchronized (this) {
            this.f = true;
            if (z) {
                this.h.v = true;
            }
        }
        if (!z2) {
            synchronized (this.d) {
                z2 = this.d.K == 0;
            }
        }
        this.d.B(this.c, z, list);
        if (z2) {
            this.d.flush();
        }
    }

    public okio.Timeout writeTimeout() {
        return this.j;
    }
}
