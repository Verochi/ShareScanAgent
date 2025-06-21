package okio;

/* loaded from: classes24.dex */
public final class Okio {
    static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(okio.Okio.class.getName());

    /* renamed from: okio.Okio$1, reason: invalid class name */
    public class AnonymousClass1 implements okio.Sink {
        final /* synthetic */ java.io.OutputStream val$out;
        final /* synthetic */ okio.Timeout val$timeout;

        public AnonymousClass1(okio.Timeout timeout, java.io.OutputStream outputStream) {
            this.val$timeout = timeout;
            this.val$out = outputStream;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.val$out.close();
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
            this.val$out.flush();
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return this.val$timeout;
        }

        public java.lang.String toString() {
            return "sink(" + this.val$out + ")";
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            okio.Util.checkOffsetAndCount(buffer.size, 0L, j);
            while (j > 0) {
                this.val$timeout.throwIfReached();
                okio.Segment segment = buffer.head;
                int min = (int) java.lang.Math.min(j, segment.limit - segment.pos);
                this.val$out.write(segment.data, segment.pos, min);
                int i = segment.pos + min;
                segment.pos = i;
                long j2 = min;
                j -= j2;
                buffer.size -= j2;
                if (i == segment.limit) {
                    buffer.head = segment.pop();
                    okio.SegmentPool.recycle(segment);
                }
            }
        }
    }

    /* renamed from: okio.Okio$2, reason: invalid class name */
    public class AnonymousClass2 implements okio.Source {
        final /* synthetic */ java.io.InputStream val$in;
        final /* synthetic */ okio.Timeout val$timeout;

        public AnonymousClass2(okio.Timeout timeout, java.io.InputStream inputStream) {
            this.val$timeout = timeout;
            this.val$in = inputStream;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.val$in.close();
        }

        @Override // okio.Source
        public long read(okio.Buffer buffer, long j) throws java.io.IOException {
            if (j < 0) {
                throw new java.lang.IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.val$timeout.throwIfReached();
                okio.Segment writableSegment = buffer.writableSegment(1);
                int read = this.val$in.read(writableSegment.data, writableSegment.limit, (int) java.lang.Math.min(j, 8192 - writableSegment.limit));
                if (read == -1) {
                    return -1L;
                }
                writableSegment.limit += read;
                long j2 = read;
                buffer.size += j2;
                return j2;
            } catch (java.lang.AssertionError e) {
                if (okio.Okio.isAndroidGetsocknameError(e)) {
                    throw new java.io.IOException(e);
                }
                throw e;
            }
        }

        @Override // okio.Source
        public okio.Timeout timeout() {
            return this.val$timeout;
        }

        public java.lang.String toString() {
            return "source(" + this.val$in + ")";
        }
    }

    /* renamed from: okio.Okio$3, reason: invalid class name */
    public class AnonymousClass3 implements okio.Sink {
        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws java.io.IOException {
        }

        @Override // okio.Sink
        public okio.Timeout timeout() {
            return okio.Timeout.NONE;
        }

        @Override // okio.Sink
        public void write(okio.Buffer buffer, long j) throws java.io.IOException {
            buffer.skip(j);
        }
    }

    /* renamed from: okio.Okio$4, reason: invalid class name */
    public class AnonymousClass4 extends okio.AsyncTimeout {
        final /* synthetic */ java.net.Socket val$socket;

        public AnonymousClass4(java.net.Socket socket) {
            this.val$socket = socket;
        }

        @Override // okio.AsyncTimeout
        public java.io.IOException newTimeoutException(@javax.annotation.Nullable java.io.IOException iOException) {
            java.net.SocketTimeoutException socketTimeoutException = new java.net.SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        public void timedOut() {
            try {
                this.val$socket.close();
            } catch (java.lang.AssertionError e) {
                if (!okio.Okio.isAndroidGetsocknameError(e)) {
                    throw e;
                }
                okio.Okio.logger.log(java.util.logging.Level.WARNING, "Failed to close timed out socket " + this.val$socket, (java.lang.Throwable) e);
            } catch (java.lang.Exception e2) {
                okio.Okio.logger.log(java.util.logging.Level.WARNING, "Failed to close timed out socket " + this.val$socket, (java.lang.Throwable) e2);
            }
        }
    }

    private Okio() {
    }

    public static okio.Sink appendingSink(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return sink(new java.io.FileOutputStream(file, true));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static okio.Sink blackhole() {
        return new okio.Okio.AnonymousClass3();
    }

    public static okio.BufferedSink buffer(okio.Sink sink) {
        return new okio.RealBufferedSink(sink);
    }

    public static okio.BufferedSource buffer(okio.Source source) {
        return new okio.RealBufferedSource(source);
    }

    public static boolean isAndroidGetsocknameError(java.lang.AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static okio.Sink sink(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return sink(new java.io.FileOutputStream(file));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static okio.Sink sink(java.io.OutputStream outputStream) {
        return sink(outputStream, new okio.Timeout());
    }

    private static okio.Sink sink(java.io.OutputStream outputStream, okio.Timeout timeout) {
        if (outputStream == null) {
            throw new java.lang.IllegalArgumentException("out == null");
        }
        if (timeout != null) {
            return new okio.Okio.AnonymousClass1(timeout, outputStream);
        }
        throw new java.lang.IllegalArgumentException("timeout == null");
    }

    public static okio.Sink sink(java.net.Socket socket) throws java.io.IOException {
        if (socket == null) {
            throw new java.lang.IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new java.io.IOException("socket's output stream == null");
        }
        okio.AsyncTimeout timeout = timeout(socket);
        return timeout.sink(sink(socket.getOutputStream(), timeout));
    }

    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public static okio.Sink sink(java.nio.file.Path path, java.nio.file.OpenOption... openOptionArr) throws java.io.IOException {
        java.io.OutputStream newOutputStream;
        if (path == null) {
            throw new java.lang.IllegalArgumentException("path == null");
        }
        newOutputStream = java.nio.file.Files.newOutputStream(path, openOptionArr);
        return sink(newOutputStream);
    }

    public static okio.Source source(java.io.File file) throws java.io.FileNotFoundException {
        if (file != null) {
            return source(new java.io.FileInputStream(file));
        }
        throw new java.lang.IllegalArgumentException("file == null");
    }

    public static okio.Source source(java.io.InputStream inputStream) {
        return source(inputStream, new okio.Timeout());
    }

    private static okio.Source source(java.io.InputStream inputStream, okio.Timeout timeout) {
        if (inputStream == null) {
            throw new java.lang.IllegalArgumentException("in == null");
        }
        if (timeout != null) {
            return new okio.Okio.AnonymousClass2(timeout, inputStream);
        }
        throw new java.lang.IllegalArgumentException("timeout == null");
    }

    public static okio.Source source(java.net.Socket socket) throws java.io.IOException {
        if (socket == null) {
            throw new java.lang.IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new java.io.IOException("socket's input stream == null");
        }
        okio.AsyncTimeout timeout = timeout(socket);
        return timeout.source(source(socket.getInputStream(), timeout));
    }

    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public static okio.Source source(java.nio.file.Path path, java.nio.file.OpenOption... openOptionArr) throws java.io.IOException {
        java.io.InputStream newInputStream;
        if (path == null) {
            throw new java.lang.IllegalArgumentException("path == null");
        }
        newInputStream = java.nio.file.Files.newInputStream(path, openOptionArr);
        return source(newInputStream);
    }

    private static okio.AsyncTimeout timeout(java.net.Socket socket) {
        return new okio.Okio.AnonymousClass4(socket);
    }
}
