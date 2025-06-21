package okio;

/* loaded from: classes24.dex */
final class PeekSource implements okio.Source {
    private final okio.Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private okio.Segment expectedSegment;
    private long pos;
    private final okio.BufferedSource upstream;

    public PeekSource(okio.BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        okio.Buffer buffer = bufferedSource.buffer();
        this.buffer = buffer;
        okio.Segment segment = buffer.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.closed = true;
    }

    @Override // okio.Source
    public long read(okio.Buffer buffer, long j) throws java.io.IOException {
        okio.Segment segment;
        okio.Segment segment2;
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.closed) {
            throw new java.lang.IllegalStateException("closed");
        }
        okio.Segment segment3 = this.expectedSegment;
        if (segment3 != null && (segment3 != (segment2 = this.buffer.head) || this.expectedPos != segment2.pos)) {
            throw new java.lang.IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j == 0) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1)) {
            return -1L;
        }
        if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
            this.expectedSegment = segment;
            this.expectedPos = segment.pos;
        }
        long min = java.lang.Math.min(j, this.buffer.size - this.pos);
        this.buffer.copyTo(buffer, this.pos, min);
        this.pos += min;
        return min;
    }

    @Override // okio.Source
    public okio.Timeout timeout() {
        return this.upstream.timeout();
    }
}
