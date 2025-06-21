package okio;

/* loaded from: classes24.dex */
public final class DeflaterSink implements okio.Sink {
    private boolean closed;
    private final java.util.zip.Deflater deflater;
    private final okio.BufferedSink sink;

    public DeflaterSink(okio.BufferedSink bufferedSink, java.util.zip.Deflater deflater) {
        if (bufferedSink == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new java.lang.IllegalArgumentException("inflater == null");
        }
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    public DeflaterSink(okio.Sink sink, java.util.zip.Deflater deflater) {
        this(okio.Okio.buffer(sink), deflater);
    }

    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    private void deflate(boolean z) throws java.io.IOException {
        okio.Segment writableSegment;
        int deflate;
        okio.Buffer buffer = this.sink.buffer();
        while (true) {
            writableSegment = buffer.writableSegment(1);
            if (z) {
                java.util.zip.Deflater deflater = this.deflater;
                byte[] bArr = writableSegment.data;
                int i = writableSegment.limit;
                deflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                java.util.zip.Deflater deflater2 = this.deflater;
                byte[] bArr2 = writableSegment.data;
                int i2 = writableSegment.limit;
                deflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (deflate > 0) {
                writableSegment.limit += deflate;
                buffer.size += deflate;
                this.sink.emitCompleteSegments();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (writableSegment.pos == writableSegment.limit) {
            buffer.head = writableSegment.pop();
            okio.SegmentPool.recycle(writableSegment);
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        try {
            finishDeflate();
            th = null;
        } catch (java.lang.Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (java.lang.Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (java.lang.Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            okio.Util.sneakyRethrow(th);
        }
    }

    public void finishDeflate() throws java.io.IOException {
        this.deflater.finish();
        deflate(false);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        deflate(true);
        this.sink.flush();
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.sink.timeout();
    }

    public java.lang.String toString() {
        return "DeflaterSink(" + this.sink + ")";
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j) throws java.io.IOException {
        okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
        while (j > 0) {
            okio.Segment segment = buffer.head;
            int min = (int) java.lang.Math.min(j, segment.limit - segment.pos);
            this.deflater.setInput(segment.data, segment.pos, min);
            deflate(false);
            long j2 = min;
            buffer.size -= j2;
            int i = segment.pos + min;
            segment.pos = i;
            if (i == segment.limit) {
                buffer.head = segment.pop();
                okio.SegmentPool.recycle(segment);
            }
            j -= j2;
        }
    }
}
