package okhttp3.internal.cache;

/* loaded from: classes23.dex */
class FaultHidingSink extends okio.ForwardingSink {
    public boolean n;

    public FaultHidingSink(okio.Sink sink) {
        super(sink);
    }

    public void a(java.io.IOException iOException) {
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        if (this.n) {
            return;
        }
        try {
            super.close();
        } catch (java.io.IOException e) {
            this.n = true;
            a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        if (this.n) {
            return;
        }
        try {
            super.flush();
        } catch (java.io.IOException e) {
            this.n = true;
            a(e);
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(okio.Buffer buffer, long j) throws java.io.IOException {
        if (this.n) {
            buffer.skip(j);
            return;
        }
        try {
            super.write(buffer, j);
        } catch (java.io.IOException e) {
            this.n = true;
            a(e);
        }
    }
}
