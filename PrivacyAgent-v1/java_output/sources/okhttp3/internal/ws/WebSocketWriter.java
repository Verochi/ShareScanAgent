package okhttp3.internal.ws;

/* loaded from: classes24.dex */
final class WebSocketWriter {
    public final boolean a;
    public final java.util.Random b;
    public final okio.BufferedSink c;
    public final okio.Buffer d;
    public boolean e;
    public final okio.Buffer f = new okio.Buffer();
    public final okhttp3.internal.ws.WebSocketWriter.FrameSink g = new okhttp3.internal.ws.WebSocketWriter.FrameSink();
    public boolean h;
    public final byte[] i;
    public final okio.Buffer.UnsafeCursor j;

    public final class FrameSink implements okio.Sink {
        public int n;
        public long t;
        public boolean u;
        public boolean v;

        public FrameSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            if (this.v) {
                throw new java.io.IOException("closed");
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = okhttp3.internal.ws.WebSocketWriter.this;
            webSocketWriter.d(this.n, webSocketWriter.f.size(), this.u, true);
            this.v = true;
            okhttp3.internal.ws.WebSocketWriter.this.h = false;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            if (this.v) {
                throw new java.io.IOException("closed");
            }
            okhttp3.internal.ws.WebSocketWriter webSocketWriter = okhttp3.internal.ws.WebSocketWriter.this;
            webSocketWriter.d(this.n, webSocketWriter.f.size(), this.u, false);
            this.u = false;
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return okhttp3.internal.ws.WebSocketWriter.this.c.timeout();
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            if (this.v) {
                throw new java.io.IOException("closed");
            }
            okhttp3.internal.ws.WebSocketWriter.this.f.write(buffer, j);
            boolean z = this.u && this.t != -1 && okhttp3.internal.ws.WebSocketWriter.this.f.size() > this.t - 8192;
            long completeSegmentByteCount = okhttp3.internal.ws.WebSocketWriter.this.f.completeSegmentByteCount();
            if (completeSegmentByteCount <= 0 || z) {
                return;
            }
            okhttp3.internal.ws.WebSocketWriter.this.d(this.n, completeSegmentByteCount, this.u, false);
            this.u = false;
        }
    }

    public WebSocketWriter(boolean z, okio.BufferedSink bufferedSink, java.util.Random random) {
        if (bufferedSink == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        if (random == null) {
            throw new java.lang.NullPointerException("random == null");
        }
        this.a = z;
        this.c = bufferedSink;
        this.d = bufferedSink.buffer();
        this.b = random;
        this.i = z ? new byte[4] : null;
        this.j = z ? new okio.Buffer.UnsafeCursor() : null;
    }

    public okio.Sink a(int i, long j) {
        if (this.h) {
            throw new java.lang.IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.h = true;
        okhttp3.internal.ws.WebSocketWriter.FrameSink frameSink = this.g;
        frameSink.n = i;
        frameSink.t = j;
        frameSink.u = true;
        frameSink.v = false;
        return frameSink;
    }

    public void b(int i, okio.ByteString byteString) throws java.io.IOException {
        okio.ByteString byteString2 = okio.ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                okhttp3.internal.ws.WebSocketProtocol.c(i);
            }
            okio.Buffer buffer = new okio.Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            c(8, byteString2);
        } finally {
            this.e = true;
        }
    }

    public final void c(int i, okio.ByteString byteString) throws java.io.IOException {
        if (this.e) {
            throw new java.io.IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new java.lang.IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.d.writeByte(i | 128);
        if (this.a) {
            this.d.writeByte(size | 128);
            this.b.nextBytes(this.i);
            this.d.write(this.i);
            if (size > 0) {
                long size2 = this.d.size();
                this.d.write(byteString);
                this.d.readAndWriteUnsafe(this.j);
                this.j.seek(size2);
                okhttp3.internal.ws.WebSocketProtocol.b(this.j, this.i);
                this.j.close();
            }
        } else {
            this.d.writeByte(size);
            this.d.write(byteString);
        }
        this.c.flush();
    }

    public void d(int i, long j, boolean z, boolean z2) throws java.io.IOException {
        if (this.e) {
            throw new java.io.IOException("closed");
        }
        if (!z) {
            i = 0;
        }
        if (z2) {
            i |= 128;
        }
        this.d.writeByte(i);
        int i2 = this.a ? 128 : 0;
        if (j <= 125) {
            this.d.writeByte(((int) j) | i2);
        } else if (j <= 65535) {
            this.d.writeByte(i2 | 126);
            this.d.writeShort((int) j);
        } else {
            this.d.writeByte(i2 | 127);
            this.d.writeLong(j);
        }
        if (this.a) {
            this.b.nextBytes(this.i);
            this.d.write(this.i);
            if (j > 0) {
                long size = this.d.size();
                this.d.write(this.f, j);
                this.d.readAndWriteUnsafe(this.j);
                this.j.seek(size);
                okhttp3.internal.ws.WebSocketProtocol.b(this.j, this.i);
                this.j.close();
            }
        } else {
            this.d.write(this.f, j);
        }
        this.c.emit();
    }

    public void e(okio.ByteString byteString) throws java.io.IOException {
        c(9, byteString);
    }

    public void f(okio.ByteString byteString) throws java.io.IOException {
        c(10, byteString);
    }
}
