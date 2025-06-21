package okio;

/* loaded from: classes24.dex */
public final class GzipSink implements okio.Sink {
    private boolean closed;
    private final java.util.zip.CRC32 crc = new java.util.zip.CRC32();
    private final java.util.zip.Deflater deflater;
    private final okio.DeflaterSink deflaterSink;
    private final okio.BufferedSink sink;

    public GzipSink(okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("sink == null");
        }
        java.util.zip.Deflater deflater = new java.util.zip.Deflater(-1, true);
        this.deflater = deflater;
        okio.BufferedSink buffer = okio.Okio.buffer(sink);
        this.sink = buffer;
        this.deflaterSink = new okio.DeflaterSink(buffer, deflater);
        writeHeader();
    }

    private void updateCrc(okio.Buffer buffer, long j) {
        okio.Segment segment = buffer.head;
        while (j > 0) {
            int min = (int) java.lang.Math.min(j, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, min);
            j -= min;
            segment = segment.next;
        }
    }

    private void writeFooter() throws java.io.IOException {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    private void writeHeader() {
        okio.Buffer buffer = this.sink.buffer();
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.closed) {
            return;
        }
        try {
            this.deflaterSink.finishDeflate();
            writeFooter();
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

    public final java.util.zip.Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j) throws java.io.IOException {
        if (j < 0) {
            throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
        }
        if (j == 0) {
            return;
        }
        updateCrc(buffer, j);
        this.deflaterSink.write(buffer, j);
    }
}
