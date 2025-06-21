package okio;

/* loaded from: classes24.dex */
public abstract class ForwardingSink implements okio.Sink {
    private final okio.Sink delegate;

    public ForwardingSink(okio.Sink sink) {
        if (sink == null) {
            throw new java.lang.IllegalArgumentException("delegate == null");
        }
        this.delegate = sink;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.delegate.close();
    }

    public final okio.Sink delegate() {
        return this.delegate;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.delegate.flush();
    }

    @Override // okio.Sink
    public okio.Timeout timeout() {
        return this.delegate.timeout();
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    @Override // okio.Sink
    public void write(okio.Buffer buffer, long j) throws java.io.IOException {
        this.delegate.write(buffer, j);
    }
}
