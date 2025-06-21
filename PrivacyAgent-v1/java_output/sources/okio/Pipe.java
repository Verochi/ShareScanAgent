package okio;

/* loaded from: classes24.dex */
public final class Pipe {

    @javax.annotation.Nullable
    private okio.Sink foldedSink;
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final okio.Buffer buffer = new okio.Buffer();
    private final okio.Sink sink = new okio.Pipe.PipeSink();
    private final okio.Source source = new okio.Pipe.PipeSource();

    public final class PipeSink implements okio.Sink {
        final okio.PushableTimeout timeout = new okio.PushableTimeout();

        public PipeSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            okio.Sink sink;
            synchronized (okio.Pipe.this.buffer) {
                okio.Pipe pipe = okio.Pipe.this;
                if (pipe.sinkClosed) {
                    return;
                }
                if (pipe.foldedSink != null) {
                    sink = okio.Pipe.this.foldedSink;
                } else {
                    okio.Pipe pipe2 = okio.Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new java.io.IOException("source is closed");
                    }
                    okio.Pipe pipe3 = okio.Pipe.this;
                    pipe3.sinkClosed = true;
                    pipe3.buffer.notifyAll();
                    sink = null;
                }
                if (sink != null) {
                    this.timeout.push(sink.timeout());
                    try {
                        sink.close();
                    } finally {
                        this.timeout.pop();
                    }
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            okio.Sink sink;
            synchronized (okio.Pipe.this.buffer) {
                okio.Pipe pipe = okio.Pipe.this;
                if (pipe.sinkClosed) {
                    throw new java.lang.IllegalStateException("closed");
                }
                if (pipe.foldedSink != null) {
                    sink = okio.Pipe.this.foldedSink;
                } else {
                    okio.Pipe pipe2 = okio.Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new java.io.IOException("source is closed");
                    }
                    sink = null;
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            okio.Sink sink;
            synchronized (okio.Pipe.this.buffer) {
                if (!okio.Pipe.this.sinkClosed) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        }
                        if (okio.Pipe.this.foldedSink != null) {
                            sink = okio.Pipe.this.foldedSink;
                            break;
                        }
                        okio.Pipe pipe = okio.Pipe.this;
                        if (pipe.sourceClosed) {
                            throw new java.io.IOException("source is closed");
                        }
                        long size = pipe.maxBufferSize - pipe.buffer.size();
                        if (size == 0) {
                            this.timeout.waitUntilNotified(okio.Pipe.this.buffer);
                        } else {
                            long min = java.lang.Math.min(size, j);
                            okio.Pipe.this.buffer.write(buffer, min);
                            j -= min;
                            okio.Pipe.this.buffer.notifyAll();
                        }
                    }
                } else {
                    throw new java.lang.IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.timeout.pop();
                }
            }
        }
    }

    public final class PipeSource implements okio.Source {
        final okio.Timeout timeout = new okio.Timeout();

        public PipeSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            synchronized (okio.Pipe.this.buffer) {
                okio.Pipe pipe = okio.Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            synchronized (okio.Pipe.this.buffer) {
                if (okio.Pipe.this.sourceClosed) {
                    throw new java.lang.IllegalStateException("closed");
                }
                while (okio.Pipe.this.buffer.size() == 0) {
                    okio.Pipe pipe = okio.Pipe.this;
                    if (pipe.sinkClosed) {
                        return -1L;
                    }
                    this.timeout.waitUntilNotified(pipe.buffer);
                }
                long read = okio.Pipe.this.buffer.read(buffer, j);
                okio.Pipe.this.buffer.notifyAll();
                return read;
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new java.lang.IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public void fold(okio.Sink sink) throws java.io.IOException {
        boolean z;
        okio.Buffer buffer;
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink != null) {
                    throw new java.lang.IllegalStateException("sink already folded");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                } else {
                    z = this.sinkClosed;
                    buffer = new okio.Buffer();
                    okio.Buffer buffer2 = this.buffer;
                    buffer.write(buffer2, buffer2.size);
                    this.buffer.notifyAll();
                }
            }
            try {
                sink.write(buffer, buffer.size);
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (java.lang.Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final okio.Sink sink() {
        return this.sink;
    }

    public final okio.Source source() {
        return this.source;
    }
}
