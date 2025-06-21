package okio;

/* loaded from: classes24.dex */
public final class InflaterSource implements okio.Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final java.util.zip.Inflater inflater;
    private final okio.BufferedSource source;

    public InflaterSource(okio.BufferedSource bufferedSource, java.util.zip.Inflater inflater) {
        if (bufferedSource == null) {
            throw new java.lang.IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new java.lang.IllegalArgumentException("inflater == null");
        }
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    public InflaterSource(okio.Source source, java.util.zip.Inflater inflater) {
        this(okio.Okio.buffer(source), inflater);
    }

    private void releaseInflatedBytes() throws java.io.IOException {
        int i = this.bufferBytesHeldByInflater;
        if (i == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j) throws java.io.IOException {
        boolean refill;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            refill = refill();
            try {
                okio.Segment writableSegment = buffer.writableSegment(1);
                int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, (int) java.lang.Math.min(j, 8192 - writableSegment.limit));
                if (inflate > 0) {
                    writableSegment.limit += inflate;
                    long j2 = inflate;
                    buffer.size += j2;
                    return j2;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (writableSegment.pos != writableSegment.limit) {
                    return -1L;
                }
                buffer.head = writableSegment.pop();
                okio.SegmentPool.recycle(writableSegment);
                return -1L;
            } catch (java.util.zip.DataFormatException e) {
                throw new java.io.IOException(e);
            }
        } while (!refill);
        throw new java.io.EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws java.io.IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (this.inflater.getRemaining() != 0) {
            throw new java.lang.IllegalStateException("?");
        }
        if (this.source.exhausted()) {
            return true;
        }
        okio.Segment segment = this.source.buffer().head;
        int i = segment.limit;
        int i2 = segment.pos;
        int i3 = i - i2;
        this.bufferBytesHeldByInflater = i3;
        this.inflater.setInput(segment.data, i2, i3);
        return false;
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.source.timeout();
    }
}
