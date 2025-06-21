package okio;

/* loaded from: classes24.dex */
final class RealBufferedSink implements okio.BufferedSink {
    public final okio.Buffer buffer = new okio.Buffer();
    boolean closed;
    public final okio.Sink sink;

    /* renamed from: okio.RealBufferedSink$1, reason: invalid class name */
    public class AnonymousClass1 extends java.io.OutputStream {
        public AnonymousClass1() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            okio.RealBufferedSink.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws java.io.IOException {
            okio.RealBufferedSink realBufferedSink = okio.RealBufferedSink.this;
            if (realBufferedSink.closed) {
                return;
            }
            realBufferedSink.flush();
        }

        public java.lang.String toString() {
            return okio.RealBufferedSink.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i) throws java.io.IOException {
            okio.RealBufferedSink realBufferedSink = okio.RealBufferedSink.this;
            if (realBufferedSink.closed) {
                throw new java.io.IOException("closed");
            }
            realBufferedSink.buffer.writeByte((int) ((byte) i));
            okio.RealBufferedSink.this.emitCompleteSegments();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
            okio.RealBufferedSink realBufferedSink = okio.RealBufferedSink.this;
            if (realBufferedSink.closed) {
                throw new java.io.IOException("closed");
            }
            realBufferedSink.buffer.write(bArr, i, i2);
            okio.RealBufferedSink.this.emitCompleteSegments();
        }
    }

    public RealBufferedSink(okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.NullPointerException("sink == null");
        }
        this.sink = sink;
    }

    @Override // okio.BufferedSink
    public okio.Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        try {
            okio.Buffer buffer = this.buffer;
            long j = buffer.size;
            if (j > 0) {
                this.sink.write(buffer, j);
            }
            th = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            this.sink.close();
        } catch (java.lang.Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.closed = true;
        if (th != null) {
            okio.Util.sneakyRethrow(th);
        }
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink emit() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        long size = this.buffer.size();
        if (size > 0) {
            this.sink.write(this.buffer, size);
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink emitCompleteSegments() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            this.sink.write(this.buffer, completeSegmentByteCount);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        okio.Buffer buffer = this.buffer;
        long j = buffer.size;
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        this.sink.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSink
    public java.io.OutputStream outputStream() {
        return new okio.RealBufferedSink.AnonymousClass1();
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.sink.timeout();
    }

    public java.lang.String toString() {
        return "buffer(" + this.sink + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        int write = this.buffer.write(byteBuffer);
        emitCompleteSegments();
        return write;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(okio.ByteString byteString) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(byteString);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(okio.Source source, long j) throws java.io.IOException {
        while (j > 0) {
            long read = source.read(this.buffer, j);
            if (read == -1) {
                throw new java.io.EOFException();
            }
            j -= read;
            emitCompleteSegments();
        }
        return this;
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(byte[] bArr) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(bArr);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink write(byte[] bArr, int i, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(bArr, i, i2);
        return emitCompleteSegments();
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.write(buffer, j);
        emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public long writeAll(okio.Source source) throws java.io.IOException {
        if (source == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long read = source.read(this.buffer, 8192L);
            if (read == -1) {
                return j;
            }
            j += read;
            emitCompleteSegments();
        }
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeByte(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeByte(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeDecimalLong(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeDecimalLong(j);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeHexadecimalUnsignedLong(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeHexadecimalUnsignedLong(j);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeInt(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeInt(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeIntLe(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeIntLe(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeLong(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeLong(j);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeLongLe(long j) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeLongLe(j);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeShort(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeShort(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeShortLe(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeShortLe(i);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeString(java.lang.String str, int i, int i2, java.nio.charset.Charset charset) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeString(str, i, i2, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeString(java.lang.String str, java.nio.charset.Charset charset) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeString(str, charset);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeUtf8(java.lang.String str) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeUtf8(java.lang.String str, int i, int i2) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8(str, i, i2);
        return emitCompleteSegments();
    }

    @Override // okio.BufferedSink
    public okio.BufferedSink writeUtf8CodePoint(int i) throws java.io.IOException {
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        this.buffer.writeUtf8CodePoint(i);
        return emitCompleteSegments();
    }
}
